package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SdcardUtil
{
  public static final String ID_EMULATED_INTERNAL = "emulated";
  private static final String TAG = "MicroMsg.SdcardUtil";
  static String[] excludeSpecialFileSystems = { "sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs" };
  static String[] excludeStorageMountDirs = { "/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/" };
  static String[] includeDeviceNames = { "/dev/block/vold" };
  static String[] includeStorageFileSystems = { "vfat", "exfat", "fuse", "sdcardfs" };
  
  private static void filterSpecialFileSystems(ArrayList<StatMountParse> paramArrayList)
  {
    AppMethodBeat.i(243538);
    int i = paramArrayList.size();
    List localList = Arrays.asList(excludeSpecialFileSystems);
    i -= 1;
    while (i >= 0)
    {
      if (localList.contains(((StatMountParse)paramArrayList.get(i)).fileSystem)) {
        paramArrayList.remove(i);
      }
      i -= 1;
    }
    AppMethodBeat.o(243538);
  }
  
  private static void filterStatMountParseForStorage(ArrayList<StatMountParse> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(243576);
    int i = paramArrayList.size();
    Object localObject1 = Arrays.asList(includeStorageFileSystems);
    Object localObject2 = Arrays.asList(excludeStorageMountDirs);
    Object localObject3 = Arrays.asList(includeDeviceNames);
    i -= 1;
    if (i >= 0)
    {
      StatMountParse localStatMountParse = (StatMountParse)paramArrayList.get(i);
      if (!((List)localObject1).contains(localStatMountParse.fileSystem))
      {
        paramArrayList.remove(i);
        Log.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + localStatMountParse.fileSystem);
      }
      for (;;)
      {
        i -= 1;
        break;
        Iterator localIterator = ((List)localObject2).iterator();
        String str;
        for (boolean bool = false; localIterator.hasNext(); bool = localStatMountParse.mountDir.startsWith(str) | bool) {
          str = (String)localIterator.next();
        }
        if (bool)
        {
          paramArrayList.remove(i);
          Log.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + localStatMountParse.mountDir);
        }
        else if ((localStatMountParse.fileSystem.equals("fuse")) || (localStatMountParse.fileSystem.equals("sdcardfs")))
        {
          if (localStatMountParse.devName.startsWith("/data/"))
          {
            paramArrayList.remove(i);
            Log.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + localStatMountParse.devName);
          }
        }
        else if ((!localStatMountParse.fileSystem.equals("fuse")) && (!localStatMountParse.fileSystem.equals("sdcardfs")))
        {
          localIterator = ((List)localObject3).iterator();
          for (bool = false; localIterator.hasNext(); bool = localStatMountParse.devName.startsWith(str) | bool) {
            str = (String)localIterator.next();
          }
          if (!bool)
          {
            paramArrayList.remove(i);
            Log.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + localStatMountParse.devName);
          }
        }
      }
    }
    localObject1 = Environment.getExternalStorageDirectory().getPath();
    i = paramArrayList.size() - 1;
    if (i >= 0)
    {
      localObject2 = (StatMountParse)paramArrayList.get(i);
      if (((StatMountParse)localObject2).mountDir.equals(localObject1))
      {
        paramArrayList.remove(i);
        paramArrayList.add(0, localObject2);
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = new StatMountParse();
        ((StatMountParse)localObject2).mountDir = ((String)localObject1);
        ((StatMountParse)localObject2).fileSystem = "unknown";
        ((StatMountParse)localObject2).devName = "unknown";
        paramArrayList.add(0, localObject2);
      }
      i = paramArrayList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localObject1 = (StatMountParse)paramArrayList.get(i);
          localObject2 = new u(((StatMountParse)localObject1).mountDir);
          if ((!((u)localObject2).jKS()) || (!((u)localObject2).isDirectory()))
          {
            Log.d("MicroMsg.SdcardUtil", "Directory verify failed: ".concat(String.valueOf(localObject1)));
            paramArrayList.remove(i);
          }
          i -= 1;
          continue;
          i -= 1;
          break;
        }
      }
      if (paramBoolean)
      {
        i = paramArrayList.size() - 1;
        while (i >= 0)
        {
          localObject1 = (StatMountParse)paramArrayList.get(i);
          if (!testPermissionForStatMountParse((StatMountParse)localObject1))
          {
            Log.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: ".concat(String.valueOf(localObject1)));
            paramArrayList.remove(i);
          }
          i -= 1;
        }
      }
      localObject3 = new ArrayList();
      if (!paramArrayList.isEmpty())
      {
        localObject1 = (StatMountParse)paramArrayList.remove(0);
        i = paramArrayList.size() - 1;
        label656:
        if (i >= 0)
        {
          localObject2 = (StatMountParse)paramArrayList.get(i);
          if (!((StatMountParse)localObject1).devName.equals(((StatMountParse)localObject2).devName)) {
            break label918;
          }
          paramArrayList.remove(i);
          Log.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + ((StatMountParse)localObject1).devName);
          if ((((StatMountParse)localObject1).canWrite) || (!((StatMountParse)localObject2).canWrite)) {
            break label918;
          }
          Log.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
          localObject1 = localObject2;
        }
      }
      label918:
      for (;;)
      {
        i -= 1;
        break label656;
        ((ArrayList)localObject3).add(localObject1);
        break;
        localObject1 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext()) {
          statFsForStatMountParse((StatMountParse)((Iterator)localObject1).next());
        }
        paramArrayList.clear();
        while (!((ArrayList)localObject3).isEmpty())
        {
          localObject1 = (StatMountParse)((ArrayList)localObject3).remove(0);
          paramArrayList.add(localObject1);
          i = ((ArrayList)localObject3).size() - 1;
          while (i >= 0)
          {
            localObject2 = (StatMountParse)((ArrayList)localObject3).get(i);
            if (((StatMountParse)localObject1).equals(localObject2))
            {
              Log.d("MicroMsg.SdcardUtil", "Duplicate:" + ((StatMountParse)localObject1).toString() + "---" + ((StatMountParse)localObject2).toString());
              ((ArrayList)localObject3).remove(i);
            }
            i -= 1;
          }
        }
        AppMethodBeat.o(243576);
        return;
      }
    }
  }
  
  public static long getAvailableExternalMemorySize()
  {
    AppMethodBeat.i(243624);
    Iterator localIterator = getStoragesStatMountParse().iterator();
    StatMountParse localStatMountParse;
    long l2;
    for (long l1 = 0L; localIterator.hasNext(); l1 = localStatMountParse.blockSize * l2 + l1)
    {
      localStatMountParse = (StatMountParse)localIterator.next();
      l2 = localStatMountParse.availableBlocks;
    }
    AppMethodBeat.o(243624);
    return l1;
  }
  
  public static long getAvailableExternalMemorySize2()
  {
    AppMethodBeat.i(157820);
    StatMountParse localStatMountParse = getSdcardDirectoryStatMountParse();
    long l1 = localStatMountParse.availableBlocks;
    long l2 = localStatMountParse.blockSize;
    AppMethodBeat.o(157820);
    return l2 * l1;
  }
  
  public static long getAvailableInternalMemorySize()
  {
    AppMethodBeat.i(157819);
    StatMountParse localStatMountParse = getDataDirectoryStatMountParse();
    long l1 = localStatMountParse.availableBlocks;
    long l2 = localStatMountParse.blockSize;
    AppMethodBeat.o(157819);
    return l2 * l1;
  }
  
  public static StatMountParse getDataDirectoryStatMountParse()
  {
    AppMethodBeat.i(157816);
    Object localObject1 = parseProcMounts();
    String str = Environment.getDataDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (StatMountParse)((Iterator)localObject2).next();
    } while (!((StatMountParse)localObject1).mountDir.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new StatMountParse();
        ((StatMountParse)localObject2).mountDir = str;
        ((StatMountParse)localObject2).devName = "Unknown";
        ((StatMountParse)localObject2).fileSystem = "Unknown";
      }
      statFsForStatMountParse((StatMountParse)localObject2);
      AppMethodBeat.o(157816);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public static StatMountParse getDataStatMountParse()
  {
    AppMethodBeat.i(243592);
    StatMountParse localStatMountParse = getDataDirectoryStatMountParse();
    postProcess(localStatMountParse, getWritableStatMountParseForStorage());
    AppMethodBeat.o(243592);
    return localStatMountParse;
  }
  
  public static String getFileSystem(String paramString)
  {
    AppMethodBeat.i(157822);
    Object localObject2 = "";
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157822);
      return "";
    }
    Object localObject3 = parseProcMounts();
    Object localObject1 = localObject2;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject4 = ((ArrayList)localObject3).iterator();
      do
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject1 = (StatMountParse)((Iterator)localObject4).next();
      } while (!paramString.equals(((StatMountParse)localObject1).mountDir));
      localObject1 = ((StatMountParse)localObject1).fileSystem;
    }
    Log.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", new Object[] { paramString, localObject1 });
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (paramString.contains("emulated"))
      {
        localObject4 = paramString.substring(paramString.lastIndexOf('/') + 1);
        int i = Util.getInt((String)localObject4, -1);
        Log.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", new Object[] { localObject4, Integer.valueOf(i) });
        localObject2 = localObject1;
        if (i != -1)
        {
          localObject4 = paramString.substring(0, paramString.length() - ((String)localObject4).length() - 1);
          localObject2 = localObject1;
          if (!Util.isNullOrNil((String)localObject4))
          {
            localObject3 = ((ArrayList)localObject3).iterator();
            do
            {
              localObject2 = localObject1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject2 = (StatMountParse)((Iterator)localObject3).next();
            } while (!((String)localObject4).equals(((StatMountParse)localObject2).mountDir));
            localObject2 = ((StatMountParse)localObject2).fileSystem;
            Log.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", new Object[] { paramString, localObject4, localObject2 });
          }
        }
      }
    }
    AppMethodBeat.o(157822);
    return localObject2;
  }
  
  private static StatMountParse getSdcardDirectoryStatMountParse()
  {
    AppMethodBeat.i(157817);
    Object localObject1 = parseProcMounts();
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (StatMountParse)((Iterator)localObject2).next();
    } while (!((StatMountParse)localObject1).mountDir.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new StatMountParse();
        ((StatMountParse)localObject2).mountDir = str;
        ((StatMountParse)localObject2).devName = "Unknown";
        ((StatMountParse)localObject2).fileSystem = "Unknown";
      }
      statFsForStatMountParse((StatMountParse)localObject2);
      AppMethodBeat.o(157817);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public static ArrayList<StatMountParse> getStatMountParseExcludeSpecialFileSystems()
  {
    AppMethodBeat.i(243544);
    ArrayList localArrayList = parseProcMounts();
    filterSpecialFileSystems(localArrayList);
    AppMethodBeat.o(243544);
    return localArrayList;
  }
  
  public static ArrayList<String> getStorageDirectories()
  {
    AppMethodBeat.i(243601);
    Object localObject = parseProcMounts();
    filterStatMountParseForStorage((ArrayList)localObject, false);
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((StatMountParse)((Iterator)localObject).next()).mountDir);
    }
    AppMethodBeat.o(243601);
    return localArrayList;
  }
  
  public static ArrayList<StatMountParse> getStoragesStatMountParse()
  {
    AppMethodBeat.i(243596);
    StatMountParse localStatMountParse = getDataDirectoryStatMountParse();
    ArrayList localArrayList = getWritableStatMountParseForStorage();
    postProcess(localStatMountParse, localArrayList);
    AppMethodBeat.o(243596);
    return localArrayList;
  }
  
  public static long getTotalExternalMemorySize()
  {
    AppMethodBeat.i(243618);
    Iterator localIterator = getStoragesStatMountParse().iterator();
    StatMountParse localStatMountParse;
    long l2;
    for (long l1 = 0L; localIterator.hasNext(); l1 = localStatMountParse.blockSize * l2 + l1)
    {
      localStatMountParse = (StatMountParse)localIterator.next();
      l2 = localStatMountParse.totalBlocks;
    }
    AppMethodBeat.o(243618);
    return l1;
  }
  
  public static long getTotalInternalMemorySize()
  {
    AppMethodBeat.i(243610);
    StatMountParse localStatMountParse = getDataDirectoryStatMountParse();
    long l1 = localStatMountParse.totalBlocks;
    long l2 = localStatMountParse.blockSize;
    AppMethodBeat.o(243610);
    return l2 * l1;
  }
  
  public static ArrayList<StatMountParse> getWritableStatMountParseForStorage()
  {
    AppMethodBeat.i(157818);
    ArrayList localArrayList = parseProcMounts();
    filterStatMountParseForStorage(localArrayList, true);
    AppMethodBeat.o(157818);
    return localArrayList;
  }
  
  public static ArrayList<String> getWritableStorageDirectories()
  {
    AppMethodBeat.i(243608);
    Object localObject = getWritableStatMountParseForStorage();
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((StatMountParse)((Iterator)localObject).next()).mountDir);
    }
    AppMethodBeat.o(243608);
    return localArrayList;
  }
  
  public static boolean hasUnRemovableStorage()
  {
    AppMethodBeat.i(157821);
    long l = System.currentTimeMillis();
    Object localObject5 = parseProcMounts();
    String str2 = Environment.getDataDirectory().getAbsolutePath();
    String str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    Object localObject1 = null;
    Iterator localIterator = ((ArrayList)localObject5).iterator();
    Object localObject3 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      localObject4 = localObject3;
      if (!localIterator.hasNext()) {
        break label138;
      }
      localObject2 = (StatMountParse)localIterator.next();
      if ((localObject3 == null) && (((StatMountParse)localObject2).mountDir.equals(str2)))
      {
        if (localObject1 != null) {
          break label492;
        }
        localObject3 = localObject2;
      }
      else
      {
        if ((localObject1 != null) || (!((StatMountParse)localObject2).mountDir.equals(str1))) {
          break label485;
        }
        if (localObject3 != null) {
          break;
        }
        localObject1 = localObject2;
      }
    }
    Object localObject4 = localObject3;
    for (;;)
    {
      label138:
      if ((localObject4 != null) && (localObject2 == null) && (!Util.isNullOrNil(str1)) && (str1.contains("emulated")))
      {
        localObject1 = str1.substring(str1.lastIndexOf('/') + 1);
        int i = Util.getInt((String)localObject1, -1);
        Log.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", new Object[] { localObject1, Integer.valueOf(i) });
        if (i != -1)
        {
          localObject3 = str1.substring(0, str1.length() - ((String)localObject1).length() - 1);
          if (!Util.isNullOrNil((String)localObject3))
          {
            localObject5 = ((ArrayList)localObject5).iterator();
            do
            {
              if (!((Iterator)localObject5).hasNext()) {
                break;
              }
              localObject1 = (StatMountParse)((Iterator)localObject5).next();
            } while (!((StatMountParse)localObject1).mountDir.equals(localObject3));
          }
        }
      }
      for (;;)
      {
        if ((localObject4 != null) && (localObject1 != null))
        {
          statFsForStatMountParse(localObject4);
          statFsForStatMountParse((StatMountParse)localObject1);
          Log.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", new Object[] { localObject4, localObject1 });
          if (((!((StatMountParse)localObject1).fileSystem.equals("fuse")) && (!((StatMountParse)localObject1).fileSystem.equals("sdcardfs")) && (!((StatMountParse)localObject1).fileSystem.equals("esdfs"))) || (localObject4.totalBlocks < ((StatMountParse)localObject1).totalBlocks) || (((StatMountParse)localObject1).totalBlocks <= 0L) || (localObject4.blockSize < ((StatMountParse)localObject1).blockSize) || (((StatMountParse)localObject1).blockSize <= 0L) || (localObject4.availableBlocks < ((StatMountParse)localObject1).availableBlocks)) {}
        }
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(157821);
          return bool;
        }
        localObject1 = localObject2;
      }
      label485:
      localObject2 = localObject1;
      break;
      label492:
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
  }
  
  /* Error */
  private static ArrayList<StatMountParse> parseProcMounts()
  {
    // Byte code:
    //   0: ldc_w 404
    //   3: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 100	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 232	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: new 406	java/io/BufferedReader
    //   17: dup
    //   18: new 408	com/tencent/mm/vfs/ab
    //   21: dup
    //   22: ldc_w 410
    //   25: invokespecial 411	com/tencent/mm/vfs/ab:<init>	(Ljava/lang/String;)V
    //   28: invokespecial 414	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 417	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +156 -> 198
    //   45: aload_1
    //   46: astore_0
    //   47: aload 4
    //   49: ldc_w 419
    //   52: invokevirtual 423	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   55: astore_2
    //   56: aload_2
    //   57: ifnull +11 -> 68
    //   60: aload_1
    //   61: astore_0
    //   62: aload_2
    //   63: arraylength
    //   64: iconst_3
    //   65: if_icmpge +59 -> 124
    //   68: aload_1
    //   69: astore_0
    //   70: ldc 14
    //   72: ldc_w 425
    //   75: aload 4
    //   77: invokestatic 221	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokevirtual 225	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokestatic 428	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: goto -54 -> 32
    //   89: astore_2
    //   90: aload_1
    //   91: astore_0
    //   92: ldc 14
    //   94: ldc_w 429
    //   97: iconst_1
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_2
    //   104: aastore
    //   105: invokestatic 431	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 434	java/io/BufferedReader:close	()V
    //   116: ldc_w 404
    //   119: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_3
    //   123: areturn
    //   124: aload_1
    //   125: astore_0
    //   126: new 6	com/tencent/mm/sdk/platformtools/SdcardUtil$StatMountParse
    //   129: dup
    //   130: invokespecial 204	com/tencent/mm/sdk/platformtools/SdcardUtil$StatMountParse:<init>	()V
    //   133: astore 4
    //   135: aload_1
    //   136: astore_0
    //   137: aload 4
    //   139: aload_2
    //   140: iconst_0
    //   141: aaload
    //   142: putfield 184	com/tencent/mm/sdk/platformtools/SdcardUtil$StatMountParse:devName	Ljava/lang/String;
    //   145: aload_1
    //   146: astore_0
    //   147: aload 4
    //   149: aload_2
    //   150: iconst_1
    //   151: aaload
    //   152: putfield 172	com/tencent/mm/sdk/platformtools/SdcardUtil$StatMountParse:mountDir	Ljava/lang/String;
    //   155: aload_1
    //   156: astore_0
    //   157: aload 4
    //   159: aload_2
    //   160: iconst_2
    //   161: aaload
    //   162: putfield 117	com/tencent/mm/sdk/platformtools/SdcardUtil$StatMountParse:fileSystem	Ljava/lang/String;
    //   165: aload_1
    //   166: astore_0
    //   167: aload_3
    //   168: aload 4
    //   170: invokevirtual 245	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   173: pop
    //   174: goto -142 -> 32
    //   177: astore_2
    //   178: aload_0
    //   179: astore_1
    //   180: aload_2
    //   181: astore_0
    //   182: aload_1
    //   183: ifnull +7 -> 190
    //   186: aload_1
    //   187: invokevirtual 434	java/io/BufferedReader:close	()V
    //   190: ldc_w 404
    //   193: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_0
    //   197: athrow
    //   198: aload_1
    //   199: invokevirtual 434	java/io/BufferedReader:close	()V
    //   202: goto -86 -> 116
    //   205: astore_0
    //   206: ldc 14
    //   208: aload_0
    //   209: ldc_w 310
    //   212: iconst_0
    //   213: anewarray 4	java/lang/Object
    //   216: invokestatic 438	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: goto -103 -> 116
    //   222: astore_0
    //   223: ldc 14
    //   225: aload_0
    //   226: ldc_w 310
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 438	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: goto -120 -> 116
    //   239: astore_1
    //   240: ldc 14
    //   242: aload_1
    //   243: ldc_w 310
    //   246: iconst_0
    //   247: anewarray 4	java/lang/Object
    //   250: invokestatic 438	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: goto -63 -> 190
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_1
    //   259: goto -77 -> 182
    //   262: astore_2
    //   263: aconst_null
    //   264: astore_1
    //   265: goto -175 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	164	0	localObject1	Object
    //   205	4	0	localIOException1	IOException
    //   222	4	0	localIOException2	IOException
    //   256	1	0	localObject2	Object
    //   31	168	1	localObject3	Object
    //   239	4	1	localIOException3	IOException
    //   258	7	1	localObject4	Object
    //   55	8	2	arrayOfString	String[]
    //   89	71	2	localException1	java.lang.Exception
    //   177	4	2	localObject5	Object
    //   262	1	2	localException2	java.lang.Exception
    //   13	155	3	localArrayList	ArrayList
    //   38	131	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   34	40	89	java/lang/Exception
    //   47	56	89	java/lang/Exception
    //   62	68	89	java/lang/Exception
    //   70	86	89	java/lang/Exception
    //   126	135	89	java/lang/Exception
    //   137	145	89	java/lang/Exception
    //   147	155	89	java/lang/Exception
    //   157	165	89	java/lang/Exception
    //   167	174	89	java/lang/Exception
    //   34	40	177	finally
    //   47	56	177	finally
    //   62	68	177	finally
    //   70	86	177	finally
    //   92	108	177	finally
    //   126	135	177	finally
    //   137	145	177	finally
    //   147	155	177	finally
    //   157	165	177	finally
    //   167	174	177	finally
    //   198	202	205	java/io/IOException
    //   112	116	222	java/io/IOException
    //   186	190	239	java/io/IOException
    //   14	32	256	finally
    //   14	32	262	java/lang/Exception
  }
  
  private static void postProcess(StatMountParse paramStatMountParse, ArrayList<StatMountParse> paramArrayList)
  {
    AppMethodBeat.i(243583);
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      StatMountParse localStatMountParse = (StatMountParse)paramArrayList.get(i);
      if (localStatMountParse.equals(paramStatMountParse))
      {
        paramStatMountParse.sharedStatMountParse = localStatMountParse;
        paramArrayList.remove(i);
      }
      i -= 1;
    }
    AppMethodBeat.o(243583);
  }
  
  public static void statFsForStatMountParse(StatMountParse paramStatMountParse)
  {
    AppMethodBeat.i(157814);
    try
    {
      StatFs localStatFs = new StatFs(paramStatMountParse.mountDir);
      paramStatMountParse.blockSize = localStatFs.getBlockSize();
      paramStatMountParse.availableBlocks = localStatFs.getAvailableBlocks();
      paramStatMountParse.totalBlocks = localStatFs.getBlockCount();
      paramStatMountParse.freeBlocks = localStatFs.getFreeBlocks();
      AppMethodBeat.o(157814);
      return;
    }
    catch (IllegalArgumentException paramStatMountParse)
    {
      Log.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", new Object[] { paramStatMountParse });
      AppMethodBeat.o(157814);
    }
  }
  
  private static boolean testPermissionForStatMountParse(StatMountParse paramStatMountParse)
  {
    AppMethodBeat.i(157815);
    u localu = new u(paramStatMountParse.mountDir, "test_writable");
    Object localObject2 = null;
    OutputStream localOutputStream3 = null;
    localOutputStream2 = localOutputStream3;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        localu.jKZ();
        localOutputStream2 = localOutputStream3;
        localObject1 = localObject2;
        localOutputStream3 = y.ap(localu);
        localOutputStream2 = localOutputStream3;
        localObject1 = localOutputStream3;
        localOutputStream3.write("test".getBytes());
        localOutputStream2 = localOutputStream3;
        localObject1 = localOutputStream3;
        localOutputStream3.flush();
        localOutputStream2 = localOutputStream3;
        localObject1 = localOutputStream3;
        localOutputStream3.close();
        localOutputStream2 = localOutputStream3;
        localObject1 = localOutputStream3;
        bool2 = localu.diJ();
        bool1 = bool2;
        if (localOutputStream3 == null) {}
      }
      catch (IOException localIOException4)
      {
        boolean bool2;
        OutputStream localOutputStream1 = localOutputStream2;
        Log.e("MicroMsg.SdcardUtil", "createNewFile: " + localIOException4.getMessage() + " dir: " + paramStatMountParse.mountDir);
        if (localOutputStream2 == null) {
          continue;
        }
        try
        {
          localOutputStream2.close();
          bool1 = false;
        }
        catch (IOException localIOException2)
        {
          Log.printErrStackTrace("MicroMsg.SdcardUtil", localIOException2, "", new Object[0]);
          bool1 = false;
        }
        continue;
      }
      finally
      {
        if (localIOException2 == null) {
          continue;
        }
        try
        {
          localIOException2.close();
          AppMethodBeat.o(157815);
          throw paramStatMountParse;
        }
        catch (IOException localIOException3)
        {
          Log.printErrStackTrace("MicroMsg.SdcardUtil", localIOException3, "", new Object[0]);
          continue;
        }
        boolean bool1 = false;
        continue;
      }
      try
      {
        localOutputStream3.close();
        bool1 = bool2;
      }
      catch (IOException localIOException1)
      {
        Log.printErrStackTrace("MicroMsg.SdcardUtil", localIOException1, "", new Object[0]);
        bool1 = bool2;
      }
    }
    paramStatMountParse.canWrite = bool1;
    AppMethodBeat.o(157815);
    return bool1;
  }
  
  public static class StatMountParse
  {
    private static final int DIFF_THRESHOLD = 4;
    public long availableBlocks;
    public long blockSize;
    public boolean canWrite;
    public String devName;
    public String fileSystem;
    public long freeBlocks;
    public String mountDir;
    StatMountParse sharedStatMountParse;
    public long totalBlocks;
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(157812);
      paramObject = (StatMountParse)paramObject;
      if (this.blockSize != paramObject.blockSize)
      {
        AppMethodBeat.o(157812);
        return false;
      }
      long l1 = this.totalBlocks - paramObject.totalBlocks;
      long l2 = this.freeBlocks - paramObject.freeBlocks;
      long l3 = this.availableBlocks - paramObject.availableBlocks;
      if ((Math.abs(l1 - l2) <= 4L) && (Math.abs(l1 - l3) <= 4L) && (Math.abs(l2 - l3) <= 4L))
      {
        AppMethodBeat.o(157812);
        return true;
      }
      AppMethodBeat.o(157812);
      return false;
    }
    
    public String toString()
    {
      AppMethodBeat.i(157811);
      Object localObject = new StringBuilder("{DevName=").append(this.devName).append(", MountDir=").append(this.mountDir).append(", FileSystem=").append(this.fileSystem).append(", TotalBlocks=").append(this.totalBlocks).append(", FreeBlocks=").append(this.freeBlocks).append(", AvailableBlocks=").append(this.availableBlocks).append(", BlockSize=").append(this.blockSize).append(", Shared=");
      if (this.sharedStatMountParse != null) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = bool + "}";
        AppMethodBeat.o(157811);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SdcardUtil
 * JD-Core Version:    0.7.0.1
 */