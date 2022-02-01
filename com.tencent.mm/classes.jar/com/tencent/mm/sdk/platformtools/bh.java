package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class bh
{
  static String[] GtT = { "sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs" };
  static String[] GtU = { "vfat", "exfat", "fuse", "sdcardfs" };
  static String[] GtV = { "/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/" };
  static String[] GtW = { "/dev/block/vold" };
  
  private static void a(a parama)
  {
    AppMethodBeat.i(157814);
    try
    {
      StatFs localStatFs = new StatFs(parama.GtY);
      parama.Gud = localStatFs.getBlockSize();
      parama.Guc = localStatFs.getAvailableBlocks();
      parama.Gua = localStatFs.getBlockCount();
      parama.Gub = localStatFs.getFreeBlocks();
      AppMethodBeat.o(157814);
      return;
    }
    catch (IllegalArgumentException parama)
    {
      ac.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", new Object[] { parama });
      AppMethodBeat.o(157814);
    }
  }
  
  public static String aLf(String paramString)
  {
    AppMethodBeat.i(157822);
    Object localObject2 = "";
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157822);
      return "";
    }
    Object localObject3 = eVL();
    Object localObject4 = ((ArrayList)localObject3).iterator();
    do
    {
      localObject1 = localObject2;
      if (!((Iterator)localObject4).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject4).next();
    } while (!paramString.equals(((a)localObject1).GtY));
    Object localObject1 = ((a)localObject1).GtZ;
    ac.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", new Object[] { paramString, localObject1 });
    localObject2 = localObject1;
    if (bs.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (paramString.contains("emulated"))
      {
        localObject4 = paramString.substring(paramString.lastIndexOf('/') + 1);
        int i = bs.getInt((String)localObject4, -1);
        ac.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", new Object[] { localObject4, Integer.valueOf(i) });
        localObject2 = localObject1;
        if (i != -1)
        {
          localObject4 = paramString.substring(0, paramString.length() - ((String)localObject4).length() - 1);
          localObject2 = localObject1;
          if (!bs.isNullOrNil((String)localObject4))
          {
            localObject3 = ((ArrayList)localObject3).iterator();
            do
            {
              localObject2 = localObject1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject2 = (a)((Iterator)localObject3).next();
            } while (!((String)localObject4).equals(((a)localObject2).GtY));
            localObject2 = ((a)localObject2).GtZ;
            ac.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", new Object[] { paramString, localObject4, localObject2 });
          }
        }
      }
    }
    AppMethodBeat.o(157822);
    return localObject2;
  }
  
  private static boolean b(a parama)
  {
    AppMethodBeat.i(157815);
    e locale = new e(parama.GtY, "test_writable");
    Object localObject2 = null;
    OutputStream localOutputStream3 = null;
    localOutputStream2 = localOutputStream3;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        locale.createNewFile();
        localOutputStream2 = localOutputStream3;
        localObject1 = localObject2;
        localOutputStream3 = i.ah(locale);
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
        bool2 = locale.delete();
        bool1 = bool2;
        if (localOutputStream3 == null) {}
      }
      catch (IOException localIOException4)
      {
        boolean bool2;
        OutputStream localOutputStream1 = localOutputStream2;
        ac.e("MicroMsg.SdcardUtil", "createNewFile: " + localIOException4.getMessage() + " dir: " + parama.GtY);
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
          ac.printErrStackTrace("MicroMsg.SdcardUtil", localIOException2, "", new Object[0]);
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
          throw parama;
        }
        catch (IOException localIOException3)
        {
          ac.printErrStackTrace("MicroMsg.SdcardUtil", localIOException3, "", new Object[0]);
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
        ac.printErrStackTrace("MicroMsg.SdcardUtil", localIOException1, "", new Object[0]);
        bool1 = bool2;
      }
    }
    parama.cDN = bool1;
    AppMethodBeat.o(157815);
    return bool1;
  }
  
  /* Error */
  private static ArrayList<a> eVL()
  {
    // Byte code:
    //   0: ldc_w 287
    //   3: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 155	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 289	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: new 291	java/io/BufferedReader
    //   17: dup
    //   18: new 293	com/tencent/mm/vfs/k
    //   21: dup
    //   22: ldc_w 295
    //   25: invokespecial 296	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   28: invokespecial 299	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 302	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +156 -> 198
    //   45: aload_1
    //   46: astore_0
    //   47: aload 4
    //   49: ldc_w 304
    //   52: invokevirtual 308	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   70: ldc 130
    //   72: ldc_w 310
    //   75: aload 4
    //   77: invokestatic 313	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokevirtual 316	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokestatic 284	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: goto -54 -> 32
    //   89: astore_2
    //   90: aload_1
    //   91: astore_0
    //   92: ldc 130
    //   94: ldc_w 318
    //   97: iconst_1
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_2
    //   104: aastore
    //   105: invokestatic 138	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 319	java/io/BufferedReader:close	()V
    //   116: ldc_w 287
    //   119: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_3
    //   123: areturn
    //   124: aload_1
    //   125: astore_0
    //   126: new 6	com/tencent/mm/sdk/platformtools/bh$a
    //   129: dup
    //   130: invokespecial 320	com/tencent/mm/sdk/platformtools/bh$a:<init>	()V
    //   133: astore 4
    //   135: aload_1
    //   136: astore_0
    //   137: aload 4
    //   139: aload_2
    //   140: iconst_0
    //   141: aaload
    //   142: putfield 323	com/tencent/mm/sdk/platformtools/bh$a:GtX	Ljava/lang/String;
    //   145: aload_1
    //   146: astore_0
    //   147: aload 4
    //   149: aload_2
    //   150: iconst_1
    //   151: aaload
    //   152: putfield 95	com/tencent/mm/sdk/platformtools/bh$a:GtY	Ljava/lang/String;
    //   155: aload_1
    //   156: astore_0
    //   157: aload 4
    //   159: aload_2
    //   160: iconst_2
    //   161: aaload
    //   162: putfield 176	com/tencent/mm/sdk/platformtools/bh$a:GtZ	Ljava/lang/String;
    //   165: aload_1
    //   166: astore_0
    //   167: aload_3
    //   168: aload 4
    //   170: invokevirtual 326	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   187: invokevirtual 319	java/io/BufferedReader:close	()V
    //   190: ldc_w 287
    //   193: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_0
    //   197: athrow
    //   198: aload_1
    //   199: invokevirtual 319	java/io/BufferedReader:close	()V
    //   202: goto -86 -> 116
    //   205: astore_0
    //   206: ldc 130
    //   208: aload_0
    //   209: ldc 143
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 264	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: goto -102 -> 116
    //   221: astore_0
    //   222: ldc 130
    //   224: aload_0
    //   225: ldc 143
    //   227: iconst_0
    //   228: anewarray 4	java/lang/Object
    //   231: invokestatic 264	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: goto -118 -> 116
    //   237: astore_1
    //   238: ldc 130
    //   240: aload_1
    //   241: ldc 143
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 264	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: goto -60 -> 190
    //   253: astore_0
    //   254: aconst_null
    //   255: astore_1
    //   256: goto -74 -> 182
    //   259: astore_2
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -172 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	164	0	localObject1	Object
    //   205	4	0	localIOException1	IOException
    //   221	4	0	localIOException2	IOException
    //   253	1	0	localObject2	Object
    //   31	168	1	localObject3	Object
    //   237	4	1	localIOException3	IOException
    //   255	7	1	localObject4	Object
    //   55	8	2	arrayOfString	String[]
    //   89	71	2	localException1	java.lang.Exception
    //   177	4	2	localObject5	Object
    //   259	1	2	localException2	java.lang.Exception
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
    //   112	116	221	java/io/IOException
    //   186	190	237	java/io/IOException
    //   14	32	253	finally
    //   14	32	259	java/lang/Exception
  }
  
  private static a eVM()
  {
    AppMethodBeat.i(157816);
    Object localObject1 = eVL();
    String str = Environment.getDataDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject2).next();
    } while (!((a)localObject1).GtY.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a();
        ((a)localObject2).GtY = str;
        ((a)localObject2).GtX = "Unknown";
        ((a)localObject2).GtZ = "Unknown";
      }
      a((a)localObject2);
      AppMethodBeat.o(157816);
      return localObject2;
      localObject1 = null;
    }
  }
  
  private static a eVN()
  {
    AppMethodBeat.i(157817);
    Object localObject1 = eVL();
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject2).next();
    } while (!((a)localObject1).GtY.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a();
        ((a)localObject2).GtY = str;
        ((a)localObject2).GtX = "Unknown";
        ((a)localObject2).GtZ = "Unknown";
      }
      a((a)localObject2);
      AppMethodBeat.o(157817);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public static ArrayList<a> eVO()
  {
    AppMethodBeat.i(157818);
    ArrayList localArrayList = eVL();
    int i = localArrayList.size();
    Object localObject1 = Arrays.asList(GtU);
    Object localObject2 = Arrays.asList(GtV);
    Object localObject3 = Arrays.asList(GtW);
    i -= 1;
    if (i >= 0)
    {
      a locala = (a)localArrayList.get(i);
      if (!((List)localObject1).contains(locala.GtZ))
      {
        localArrayList.remove(i);
        ac.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + locala.GtZ);
      }
      for (;;)
      {
        i -= 1;
        break;
        Iterator localIterator = ((List)localObject2).iterator();
        String str;
        for (boolean bool = false; localIterator.hasNext(); bool = locala.GtY.startsWith(str) | bool) {
          str = (String)localIterator.next();
        }
        if (bool)
        {
          localArrayList.remove(i);
          ac.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + locala.GtY);
        }
        else if ((locala.GtZ.equals("fuse")) || (locala.GtZ.equals("sdcardfs")))
        {
          if (locala.GtX.startsWith("/data/"))
          {
            localArrayList.remove(i);
            ac.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + locala.GtX);
          }
        }
        else if ((!locala.GtZ.equals("fuse")) && (!locala.GtZ.equals("sdcardfs")))
        {
          localIterator = ((List)localObject3).iterator();
          for (bool = false; localIterator.hasNext(); bool = locala.GtX.startsWith(str) | bool) {
            str = (String)localIterator.next();
          }
          if (!bool)
          {
            localArrayList.remove(i);
            ac.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + locala.GtX);
          }
        }
      }
    }
    localObject1 = Environment.getExternalStorageDirectory().getPath();
    i = localArrayList.size() - 1;
    if (i >= 0)
    {
      localObject2 = (a)localArrayList.get(i);
      if (((a)localObject2).GtY.equals(localObject1))
      {
        localArrayList.remove(i);
        localArrayList.add(0, localObject2);
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject2 = new a();
        ((a)localObject2).GtY = ((String)localObject1);
        ((a)localObject2).GtZ = "unknown";
        ((a)localObject2).GtX = "unknown";
        localArrayList.add(0, localObject2);
      }
      i = localArrayList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localObject1 = (a)localArrayList.get(i);
          localObject2 = new e(((a)localObject1).GtY);
          if ((!((e)localObject2).exists()) || (!((e)localObject2).isDirectory()))
          {
            ac.d("MicroMsg.SdcardUtil", "Directory verify failed: ".concat(String.valueOf(localObject1)));
            localArrayList.remove(i);
          }
          i -= 1;
          continue;
          i -= 1;
          break;
        }
      }
      i = localArrayList.size() - 1;
      while (i >= 0)
      {
        localObject1 = (a)localArrayList.get(i);
        if (!b((a)localObject1))
        {
          ac.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: ".concat(String.valueOf(localObject1)));
          localArrayList.remove(i);
        }
        i -= 1;
      }
      localObject3 = new ArrayList();
      if (!localArrayList.isEmpty())
      {
        localObject1 = (a)localArrayList.remove(0);
        i = localArrayList.size() - 1;
        label661:
        if (i >= 0)
        {
          localObject2 = (a)localArrayList.get(i);
          if (!((a)localObject1).GtX.equals(((a)localObject2).GtX)) {
            break label913;
          }
          localArrayList.remove(i);
          ac.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + ((a)localObject1).GtX);
          if ((((a)localObject1).cDN) || (!((a)localObject2).cDN)) {
            break label913;
          }
          ac.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
          localObject1 = localObject2;
        }
      }
      label913:
      for (;;)
      {
        i -= 1;
        break label661;
        ((ArrayList)localObject3).add(localObject1);
        break;
        localObject1 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a((a)((Iterator)localObject1).next());
        }
        localArrayList.clear();
        while (!((ArrayList)localObject3).isEmpty())
        {
          localObject1 = (a)((ArrayList)localObject3).remove(0);
          localArrayList.add(localObject1);
          i = ((ArrayList)localObject3).size() - 1;
          while (i >= 0)
          {
            localObject2 = (a)((ArrayList)localObject3).get(i);
            if (((a)localObject1).equals(localObject2))
            {
              ac.d("MicroMsg.SdcardUtil", "Duplicate:" + ((a)localObject1).toString() + "---" + ((a)localObject2).toString());
              ((ArrayList)localObject3).remove(i);
            }
            i -= 1;
          }
        }
        AppMethodBeat.o(157818);
        return localArrayList;
      }
    }
  }
  
  public static long eVP()
  {
    AppMethodBeat.i(157819);
    a locala = eVM();
    long l1 = locala.Guc;
    long l2 = locala.Gud;
    AppMethodBeat.o(157819);
    return l2 * l1;
  }
  
  public static long eVQ()
  {
    AppMethodBeat.i(157820);
    a locala = eVN();
    long l1 = locala.Guc;
    long l2 = locala.Gud;
    AppMethodBeat.o(157820);
    return l2 * l1;
  }
  
  public static boolean eVR()
  {
    AppMethodBeat.i(157821);
    long l = System.currentTimeMillis();
    Object localObject5 = eVL();
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
      localObject2 = (a)localIterator.next();
      if ((localObject3 == null) && (((a)localObject2).GtY.equals(str2)))
      {
        if (localObject1 != null) {
          break label492;
        }
        localObject3 = localObject2;
      }
      else
      {
        if ((localObject1 != null) || (!((a)localObject2).GtY.equals(str1))) {
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
      if ((localObject4 != null) && (localObject2 == null) && (!bs.isNullOrNil(str1)) && (str1.contains("emulated")))
      {
        localObject1 = str1.substring(str1.lastIndexOf('/') + 1);
        int i = bs.getInt((String)localObject1, -1);
        ac.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", new Object[] { localObject1, Integer.valueOf(i) });
        if (i != -1)
        {
          localObject3 = str1.substring(0, str1.length() - ((String)localObject1).length() - 1);
          if (!bs.isNullOrNil((String)localObject3))
          {
            localObject5 = ((ArrayList)localObject5).iterator();
            do
            {
              if (!((Iterator)localObject5).hasNext()) {
                break;
              }
              localObject1 = (a)((Iterator)localObject5).next();
            } while (!((a)localObject1).GtY.equals(localObject3));
          }
        }
      }
      for (;;)
      {
        if ((localObject4 != null) && (localObject1 != null))
        {
          a(localObject4);
          a((a)localObject1);
          ac.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", new Object[] { localObject4, localObject1 });
          if (((!((a)localObject1).GtZ.equals("fuse")) && (!((a)localObject1).GtZ.equals("sdcardfs")) && (!((a)localObject1).GtZ.equals("esdfs"))) || (localObject4.Gua < ((a)localObject1).Gua) || (((a)localObject1).Gua <= 0L) || (localObject4.Gud < ((a)localObject1).Gud) || (((a)localObject1).Gud <= 0L) || (localObject4.Guc < ((a)localObject1).Guc)) {}
        }
        for (boolean bool = true;; bool = false)
        {
          ac.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
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
  
  public static final class a
  {
    public String GtX;
    public String GtY;
    public String GtZ;
    public long Gua;
    public long Gub;
    public long Guc;
    public long Gud;
    a Gue;
    public boolean cDN;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(157812);
      paramObject = (a)paramObject;
      if (this.Gud != paramObject.Gud)
      {
        AppMethodBeat.o(157812);
        return false;
      }
      long l1 = this.Gua - paramObject.Gua;
      long l2 = this.Gub - paramObject.Gub;
      long l3 = this.Guc - paramObject.Guc;
      if ((Math.abs(l1 - l2) <= 4L) && (Math.abs(l1 - l3) <= 4L) && (Math.abs(l2 - l3) <= 4L))
      {
        AppMethodBeat.o(157812);
        return true;
      }
      AppMethodBeat.o(157812);
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(157811);
      Object localObject = new StringBuilder("{DevName=").append(this.GtX).append(", MountDir=").append(this.GtY).append(", FileSystem=").append(this.GtZ).append(", TotalBlocks=").append(this.Gua).append(", FreeBlocks=").append(this.Gub).append(", AvailableBlocks=").append(this.Guc).append(", BlockSize=").append(this.Gud).append(", Shared=");
      if (this.Gue != null) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = bool + "}";
        AppMethodBeat.o(157811);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bh
 * JD-Core Version:    0.7.0.1
 */