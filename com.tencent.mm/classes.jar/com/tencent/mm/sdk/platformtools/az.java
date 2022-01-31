package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class az
{
  static String[] uhR = { "sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs" };
  static String[] uhS = { "vfat", "exfat", "fuse", "sdcardfs" };
  static String[] uhT = { "/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/" };
  static String[] uhU = { "/dev/block/vold" };
  
  public static String Zw(String paramString)
  {
    Object localObject2 = "";
    if (bk.bl(paramString)) {}
    Object localObject4;
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            return localObject2;
            localObject3 = crC();
            localObject4 = ((ArrayList)localObject3).iterator();
            do
            {
              localObject1 = localObject2;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localObject1 = (a)((Iterator)localObject4).next();
            } while (!paramString.equals(((a)localObject1).uhW));
            localObject1 = ((a)localObject1).uhX;
            y.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", new Object[] { paramString, localObject1 });
            localObject2 = localObject1;
          } while (!bk.bl((String)localObject1));
          localObject2 = localObject1;
        } while (!paramString.contains("emulated"));
        localObject4 = paramString.substring(paramString.lastIndexOf('/') + 1);
        i = bk.getInt((String)localObject4, -1);
        y.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", new Object[] { localObject4, Integer.valueOf(i) });
        localObject2 = localObject1;
      } while (i == -1);
      localObject4 = paramString.substring(0, paramString.length() - ((String)localObject4).length() - 1);
      localObject2 = localObject1;
    } while (bk.bl((String)localObject4));
    Object localObject3 = ((ArrayList)localObject3).iterator();
    do
    {
      localObject2 = localObject1;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject2 = (a)((Iterator)localObject3).next();
    } while (!((String)localObject4).equals(((a)localObject2).uhW));
    Object localObject1 = ((a)localObject2).uhX;
    y.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", new Object[] { paramString, localObject4, localObject1 });
    return localObject1;
  }
  
  private static void a(a parama)
  {
    try
    {
      StatFs localStatFs = new StatFs(parama.uhW);
      parama.uib = localStatFs.getBlockSize();
      parama.uia = localStatFs.getAvailableBlocks();
      parama.uhY = localStatFs.getBlockCount();
      parama.uhZ = localStatFs.getFreeBlocks();
      return;
    }
    catch (IllegalArgumentException parama)
    {
      y.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", new Object[] { parama });
    }
  }
  
  /* Error */
  private static boolean b(a parama)
  {
    // Byte code:
    //   0: new 210	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 113	com/tencent/mm/sdk/platformtools/az$a:uhW	Ljava/lang/String;
    //   8: ldc 212
    //   10: invokespecial 215	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore 4
    //   15: aload 4
    //   17: invokevirtual 218	java/io/File:createNewFile	()Z
    //   20: pop
    //   21: new 220	java/io/FileOutputStream
    //   24: dup
    //   25: aload 4
    //   27: invokespecial 223	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: ldc 225
    //   36: invokevirtual 229	java/lang/String:getBytes	()[B
    //   39: invokevirtual 233	java/io/FileOutputStream:write	([B)V
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: invokevirtual 236	java/io/FileOutputStream:flush	()V
    //   48: aload_3
    //   49: astore_2
    //   50: aload_3
    //   51: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   54: aload_3
    //   55: astore_2
    //   56: aload 4
    //   58: invokevirtual 242	java/io/File:delete	()Z
    //   61: istore_1
    //   62: aload_3
    //   63: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   66: aload_0
    //   67: iload_1
    //   68: putfield 246	com/tencent/mm/sdk/platformtools/az$a:btL	Z
    //   71: iload_1
    //   72: ireturn
    //   73: astore_2
    //   74: ldc 122
    //   76: aload_2
    //   77: ldc 83
    //   79: iconst_0
    //   80: anewarray 4	java/lang/Object
    //   83: invokestatic 250	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: goto -20 -> 66
    //   89: astore 4
    //   91: aconst_null
    //   92: astore_3
    //   93: aload_3
    //   94: astore_2
    //   95: ldc 122
    //   97: new 252	java/lang/StringBuilder
    //   100: dup
    //   101: ldc 254
    //   103: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: aload 4
    //   108: invokevirtual 259	java/io/IOException:getMessage	()Ljava/lang/String;
    //   111: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 265
    //   117: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_0
    //   121: getfield 113	com/tencent/mm/sdk/platformtools/az$a:uhW	Ljava/lang/String;
    //   124: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 270	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_3
    //   134: ifnull +68 -> 202
    //   137: aload_3
    //   138: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   141: iconst_0
    //   142: istore_1
    //   143: goto -77 -> 66
    //   146: astore_2
    //   147: ldc 122
    //   149: aload_2
    //   150: ldc 83
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 250	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: iconst_0
    //   160: istore_1
    //   161: goto -95 -> 66
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: ifnull +7 -> 175
    //   171: aload_2
    //   172: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   175: aload_0
    //   176: athrow
    //   177: astore_2
    //   178: ldc 122
    //   180: aload_2
    //   181: ldc 83
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 250	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: goto -15 -> 175
    //   193: astore_0
    //   194: goto -27 -> 167
    //   197: astore 4
    //   199: goto -106 -> 93
    //   202: iconst_0
    //   203: istore_1
    //   204: goto -138 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	parama	a
    //   61	143	1	bool	boolean
    //   32	24	2	localFileOutputStream1	java.io.FileOutputStream
    //   73	4	2	localIOException1	java.io.IOException
    //   94	1	2	localFileOutputStream2	java.io.FileOutputStream
    //   146	4	2	localIOException2	java.io.IOException
    //   166	6	2	localObject	Object
    //   177	4	2	localIOException3	java.io.IOException
    //   30	108	3	localFileOutputStream3	java.io.FileOutputStream
    //   13	44	4	localFile	File
    //   89	18	4	localIOException4	java.io.IOException
    //   197	1	4	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   62	66	73	java/io/IOException
    //   15	31	89	java/io/IOException
    //   137	141	146	java/io/IOException
    //   15	31	164	finally
    //   171	175	177	java/io/IOException
    //   33	42	193	finally
    //   44	48	193	finally
    //   50	54	193	finally
    //   56	62	193	finally
    //   95	133	193	finally
    //   33	42	197	java/io/IOException
    //   44	48	197	java/io/IOException
    //   50	54	197	java/io/IOException
    //   56	62	197	java/io/IOException
  }
  
  /* Error */
  private static ArrayList<a> crC()
  {
    // Byte code:
    //   0: new 95	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 274	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: new 276	java/io/BufferedReader
    //   11: dup
    //   12: new 278	java/io/FileReader
    //   15: dup
    //   16: ldc_w 280
    //   19: invokespecial 281	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 284	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: aload_1
    //   29: invokevirtual 287	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +151 -> 187
    //   39: aload_1
    //   40: astore_0
    //   41: aload 4
    //   43: ldc_w 289
    //   46: invokevirtual 293	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +11 -> 62
    //   54: aload_1
    //   55: astore_0
    //   56: aload_2
    //   57: arraylength
    //   58: iconst_3
    //   59: if_icmpge +60 -> 119
    //   62: aload_1
    //   63: astore_0
    //   64: ldc 122
    //   66: new 252	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 295
    //   73: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload 4
    //   78: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 268	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 270	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -61 -> 26
    //   90: astore_2
    //   91: aload_1
    //   92: astore_0
    //   93: ldc 122
    //   95: ldc_w 297
    //   98: iconst_1
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_2
    //   105: aastore
    //   106: invokestatic 204	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 298	java/io/BufferedReader:close	()V
    //   117: aload_3
    //   118: areturn
    //   119: aload_1
    //   120: astore_0
    //   121: new 6	com/tencent/mm/sdk/platformtools/az$a
    //   124: dup
    //   125: invokespecial 299	com/tencent/mm/sdk/platformtools/az$a:<init>	()V
    //   128: astore 4
    //   130: aload_1
    //   131: astore_0
    //   132: aload 4
    //   134: aload_2
    //   135: iconst_0
    //   136: aaload
    //   137: putfield 302	com/tencent/mm/sdk/platformtools/az$a:uhV	Ljava/lang/String;
    //   140: aload_1
    //   141: astore_0
    //   142: aload 4
    //   144: aload_2
    //   145: iconst_1
    //   146: aaload
    //   147: putfield 113	com/tencent/mm/sdk/platformtools/az$a:uhW	Ljava/lang/String;
    //   150: aload_1
    //   151: astore_0
    //   152: aload 4
    //   154: aload_2
    //   155: iconst_2
    //   156: aaload
    //   157: putfield 120	com/tencent/mm/sdk/platformtools/az$a:uhX	Ljava/lang/String;
    //   160: aload_1
    //   161: astore_0
    //   162: aload_3
    //   163: aload 4
    //   165: invokevirtual 305	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   168: pop
    //   169: goto -143 -> 26
    //   172: astore_2
    //   173: aload_0
    //   174: astore_1
    //   175: aload_2
    //   176: astore_0
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 298	java/io/BufferedReader:close	()V
    //   185: aload_0
    //   186: athrow
    //   187: aload_1
    //   188: invokevirtual 298	java/io/BufferedReader:close	()V
    //   191: aload_3
    //   192: areturn
    //   193: astore_0
    //   194: ldc 122
    //   196: aload_0
    //   197: ldc 83
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 250	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload_3
    //   207: areturn
    //   208: astore_0
    //   209: ldc 122
    //   211: aload_0
    //   212: ldc 83
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 250	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: aload_3
    //   222: areturn
    //   223: astore_1
    //   224: ldc 122
    //   226: aload_1
    //   227: ldc 83
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 250	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: goto -51 -> 185
    //   239: astore_0
    //   240: aconst_null
    //   241: astore_1
    //   242: goto -65 -> 177
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_1
    //   248: goto -157 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	159	0	localObject1	Object
    //   193	4	0	localIOException1	java.io.IOException
    //   208	4	0	localIOException2	java.io.IOException
    //   239	1	0	localObject2	Object
    //   25	163	1	localObject3	Object
    //   223	4	1	localIOException3	java.io.IOException
    //   241	7	1	localObject4	Object
    //   49	8	2	arrayOfString	String[]
    //   90	65	2	localException1	java.lang.Exception
    //   172	4	2	localObject5	Object
    //   245	1	2	localException2	java.lang.Exception
    //   7	215	3	localArrayList	ArrayList
    //   32	132	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   28	34	90	java/lang/Exception
    //   41	50	90	java/lang/Exception
    //   56	62	90	java/lang/Exception
    //   64	87	90	java/lang/Exception
    //   121	130	90	java/lang/Exception
    //   132	140	90	java/lang/Exception
    //   142	150	90	java/lang/Exception
    //   152	160	90	java/lang/Exception
    //   162	169	90	java/lang/Exception
    //   28	34	172	finally
    //   41	50	172	finally
    //   56	62	172	finally
    //   64	87	172	finally
    //   93	109	172	finally
    //   121	130	172	finally
    //   132	140	172	finally
    //   142	150	172	finally
    //   152	160	172	finally
    //   162	169	172	finally
    //   187	191	193	java/io/IOException
    //   113	117	208	java/io/IOException
    //   181	185	223	java/io/IOException
    //   8	26	239	finally
    //   8	26	245	java/lang/Exception
  }
  
  private static a crD()
  {
    Object localObject1 = crC();
    String str = Environment.getDataDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject2).next();
    } while (!((a)localObject1).uhW.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a();
        ((a)localObject2).uhW = str;
        ((a)localObject2).uhV = "Unknown";
        ((a)localObject2).uhX = "Unknown";
      }
      a((a)localObject2);
      return localObject2;
      localObject1 = null;
    }
  }
  
  private static a crE()
  {
    Object localObject1 = crC();
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject2).next();
    } while (!((a)localObject1).uhW.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a();
        ((a)localObject2).uhW = str;
        ((a)localObject2).uhV = "Unknown";
        ((a)localObject2).uhX = "Unknown";
      }
      a((a)localObject2);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public static ArrayList<a> crF()
  {
    ArrayList localArrayList = crC();
    int i = localArrayList.size();
    Object localObject1 = Arrays.asList(uhS);
    Object localObject2 = Arrays.asList(uhT);
    Object localObject3 = Arrays.asList(uhU);
    i -= 1;
    if (i >= 0)
    {
      a locala = (a)localArrayList.get(i);
      if (!((List)localObject1).contains(locala.uhX))
      {
        localArrayList.remove(i);
        y.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + locala.uhX);
      }
      for (;;)
      {
        i -= 1;
        break;
        Iterator localIterator = ((List)localObject2).iterator();
        String str;
        for (boolean bool = false; localIterator.hasNext(); bool = locala.uhW.startsWith(str) | bool) {
          str = (String)localIterator.next();
        }
        if (bool)
        {
          localArrayList.remove(i);
          y.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + locala.uhW);
        }
        else if ((locala.uhX.equals("fuse")) || (locala.uhX.equals("sdcardfs")))
        {
          if (locala.uhV.startsWith("/data/"))
          {
            localArrayList.remove(i);
            y.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + locala.uhV);
          }
        }
        else if ((!locala.uhX.equals("fuse")) && (!locala.uhX.equals("sdcardfs")))
        {
          localIterator = ((List)localObject3).iterator();
          for (bool = false; localIterator.hasNext(); bool = locala.uhV.startsWith(str) | bool) {
            str = (String)localIterator.next();
          }
          if (!bool)
          {
            localArrayList.remove(i);
            y.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + locala.uhV);
          }
        }
      }
    }
    localObject1 = Environment.getExternalStorageDirectory().getPath();
    i = localArrayList.size() - 1;
    if (i >= 0)
    {
      localObject2 = (a)localArrayList.get(i);
      if (((a)localObject2).uhW.equals(localObject1))
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
        ((a)localObject2).uhW = ((String)localObject1);
        ((a)localObject2).uhX = "unknown";
        ((a)localObject2).uhV = "unknown";
        localArrayList.add(0, localObject2);
      }
      i = localArrayList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localObject1 = (a)localArrayList.get(i);
          localObject2 = new File(((a)localObject1).uhW);
          if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory()))
          {
            y.d("MicroMsg.SdcardUtil", "Directory verify failed: " + localObject1);
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
          y.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: " + localObject1);
          localArrayList.remove(i);
        }
        i -= 1;
      }
      localObject3 = new ArrayList();
      if (!localArrayList.isEmpty())
      {
        localObject1 = (a)localArrayList.remove(0);
        i = localArrayList.size() - 1;
        label669:
        if (i >= 0)
        {
          localObject2 = (a)localArrayList.get(i);
          if (!((a)localObject1).uhV.equals(((a)localObject2).uhV)) {
            break label915;
          }
          localArrayList.remove(i);
          y.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + ((a)localObject1).uhV);
          if ((((a)localObject1).btL) || (!((a)localObject2).btL)) {
            break label915;
          }
          y.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
          localObject1 = localObject2;
        }
      }
      label915:
      for (;;)
      {
        i -= 1;
        break label669;
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
              y.d("MicroMsg.SdcardUtil", "Duplicate:" + ((a)localObject1).toString() + "---" + ((a)localObject2).toString());
              ((ArrayList)localObject3).remove(i);
            }
            i -= 1;
          }
        }
        return localArrayList;
      }
    }
  }
  
  public static long crG()
  {
    a locala = crD();
    long l = locala.uia;
    return locala.uib * l;
  }
  
  public static long crH()
  {
    a locala = crE();
    long l = locala.uia;
    return locala.uib * l;
  }
  
  public static boolean crI()
  {
    long l = System.currentTimeMillis();
    Object localObject5 = crC();
    String str2 = Environment.getDataDirectory().getAbsolutePath();
    String str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
    Iterator localIterator = ((ArrayList)localObject5).iterator();
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      localObject4 = localObject3;
      if (!localIterator.hasNext()) {
        break label132;
      }
      localObject2 = (a)localIterator.next();
      if ((localObject3 == null) && (((a)localObject2).uhW.equals(str2)))
      {
        if (localObject1 != null) {
          break label480;
        }
        localObject3 = localObject2;
      }
      else
      {
        if ((localObject1 != null) || (!((a)localObject2).uhW.equals(str1))) {
          break label473;
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
      label132:
      if ((localObject4 != null) && (localObject2 == null) && (!bk.bl(str1)) && (str1.contains("emulated")))
      {
        localObject1 = str1.substring(str1.lastIndexOf('/') + 1);
        int i = bk.getInt((String)localObject1, -1);
        y.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", new Object[] { localObject1, Integer.valueOf(i) });
        if (i != -1)
        {
          localObject3 = str1.substring(0, str1.length() - ((String)localObject1).length() - 1);
          if (!bk.bl((String)localObject3))
          {
            localObject5 = ((ArrayList)localObject5).iterator();
            do
            {
              if (!((Iterator)localObject5).hasNext()) {
                break;
              }
              localObject1 = (a)((Iterator)localObject5).next();
            } while (!((a)localObject1).uhW.equals(localObject3));
          }
        }
      }
      for (;;)
      {
        if ((localObject4 != null) && (localObject1 != null))
        {
          a(localObject4);
          a((a)localObject1);
          y.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", new Object[] { localObject4, localObject1 });
          if (((!((a)localObject1).uhX.equals("fuse")) && (!((a)localObject1).uhX.equals("sdcardfs")) && (!((a)localObject1).uhX.equals("esdfs"))) || (localObject4.uhY < ((a)localObject1).uhY) || (((a)localObject1).uhY <= 0L) || (localObject4.uib < ((a)localObject1).uib) || (((a)localObject1).uib <= 0L) || (localObject4.uia < ((a)localObject1).uia)) {}
        }
        for (boolean bool = true;; bool = false)
        {
          y.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          return bool;
        }
        localObject1 = localObject2;
      }
      label473:
      localObject2 = localObject1;
      break;
      label480:
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
  }
  
  public static final class a
  {
    public boolean btL;
    public String uhV;
    public String uhW;
    public String uhX;
    public long uhY;
    public long uhZ;
    public long uia;
    public long uib;
    a uic;
    
    public final boolean equals(Object paramObject)
    {
      paramObject = (a)paramObject;
      if (this.uib != paramObject.uib) {}
      long l1;
      long l2;
      long l3;
      do
      {
        return false;
        l1 = this.uhY - paramObject.uhY;
        l2 = this.uhZ - paramObject.uhZ;
        l3 = this.uia - paramObject.uia;
      } while ((Math.abs(l1 - l2) > 4L) || (Math.abs(l1 - l3) > 4L) || (Math.abs(l2 - l3) > 4L));
      return true;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("{DevName=").append(this.uhV).append(", MountDir=").append(this.uhW).append(", FileSystem=").append(this.uhX).append(", TotalBlocks=").append(this.uhY).append(", FreeBlocks=").append(this.uhZ).append(", AvailableBlocks=").append(this.uia).append(", BlockSize=").append(this.uib).append(", Shared=");
      if (this.uic != null) {}
      for (boolean bool = true;; bool = false) {
        return bool + "}";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.az
 * JD-Core Version:    0.7.0.1
 */