package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class bd
{
  static String[] ypX = { "sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs" };
  static String[] ypY = { "vfat", "exfat", "fuse", "sdcardfs" };
  static String[] ypZ = { "/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/" };
  static String[] yqa = { "/dev/block/vold" };
  
  private static void a(a parama)
  {
    AppMethodBeat.i(52254);
    try
    {
      StatFs localStatFs = new StatFs(parama.yqc);
      parama.yqh = localStatFs.getBlockSize();
      parama.yqg = localStatFs.getAvailableBlocks();
      parama.yqe = localStatFs.getBlockCount();
      parama.yqf = localStatFs.getFreeBlocks();
      AppMethodBeat.o(52254);
      return;
    }
    catch (IllegalArgumentException parama)
    {
      ab.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", new Object[] { parama });
      AppMethodBeat.o(52254);
    }
  }
  
  public static String apB(String paramString)
  {
    AppMethodBeat.i(52262);
    Object localObject2 = "";
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(52262);
      return "";
    }
    Object localObject3 = dtC();
    Object localObject4 = ((ArrayList)localObject3).iterator();
    do
    {
      localObject1 = localObject2;
      if (!((Iterator)localObject4).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject4).next();
    } while (!paramString.equals(((a)localObject1).yqc));
    Object localObject1 = ((a)localObject1).yqd;
    ab.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", new Object[] { paramString, localObject1 });
    localObject2 = localObject1;
    if (bo.isNullOrNil((String)localObject1))
    {
      localObject2 = localObject1;
      if (paramString.contains("emulated"))
      {
        localObject4 = paramString.substring(paramString.lastIndexOf('/') + 1);
        int i = bo.getInt((String)localObject4, -1);
        ab.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", new Object[] { localObject4, Integer.valueOf(i) });
        localObject2 = localObject1;
        if (i != -1)
        {
          localObject4 = paramString.substring(0, paramString.length() - ((String)localObject4).length() - 1);
          localObject2 = localObject1;
          if (!bo.isNullOrNil((String)localObject4))
          {
            localObject3 = ((ArrayList)localObject3).iterator();
            do
            {
              localObject2 = localObject1;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              localObject2 = (a)((Iterator)localObject3).next();
            } while (!((String)localObject4).equals(((a)localObject2).yqc));
            localObject2 = ((a)localObject2).yqd;
            ab.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", new Object[] { paramString, localObject4, localObject2 });
          }
        }
      }
    }
    AppMethodBeat.o(52262);
    return localObject2;
  }
  
  /* Error */
  private static boolean b(a parama)
  {
    // Byte code:
    //   0: ldc 219
    //   2: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 221	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 95	com/tencent/mm/sdk/platformtools/bd$a:yqc	Ljava/lang/String;
    //   13: ldc 223
    //   15: invokespecial 226	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: astore 4
    //   20: aload 4
    //   22: invokevirtual 229	java/io/File:createNewFile	()Z
    //   25: pop
    //   26: new 231	java/io/FileOutputStream
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 234	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: ldc 236
    //   41: invokevirtual 240	java/lang/String:getBytes	()[B
    //   44: invokevirtual 244	java/io/FileOutputStream:write	([B)V
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokevirtual 247	java/io/FileOutputStream:flush	()V
    //   53: aload_3
    //   54: astore_2
    //   55: aload_3
    //   56: invokevirtual 250	java/io/FileOutputStream:close	()V
    //   59: aload_3
    //   60: astore_2
    //   61: aload 4
    //   63: invokevirtual 253	java/io/File:delete	()Z
    //   66: istore_1
    //   67: aload_3
    //   68: invokevirtual 250	java/io/FileOutputStream:close	()V
    //   71: aload_0
    //   72: iload_1
    //   73: putfield 257	com/tencent/mm/sdk/platformtools/bd$a:bUV	Z
    //   76: ldc 219
    //   78: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iload_1
    //   82: ireturn
    //   83: astore_2
    //   84: ldc 130
    //   86: aload_2
    //   87: ldc 143
    //   89: iconst_0
    //   90: anewarray 4	java/lang/Object
    //   93: invokestatic 261	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: goto -25 -> 71
    //   99: astore 4
    //   101: aconst_null
    //   102: astore_3
    //   103: aload_3
    //   104: astore_2
    //   105: ldc 130
    //   107: new 263	java/lang/StringBuilder
    //   110: dup
    //   111: ldc_w 265
    //   114: invokespecial 266	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload 4
    //   119: invokevirtual 270	java/io/IOException:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 276
    //   128: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 95	com/tencent/mm/sdk/platformtools/bd$a:yqc	Ljava/lang/String;
    //   135: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_3
    //   145: ifnull +73 -> 218
    //   148: aload_3
    //   149: invokevirtual 250	java/io/FileOutputStream:close	()V
    //   152: iconst_0
    //   153: istore_1
    //   154: goto -83 -> 71
    //   157: astore_2
    //   158: ldc 130
    //   160: aload_2
    //   161: ldc 143
    //   163: iconst_0
    //   164: anewarray 4	java/lang/Object
    //   167: invokestatic 261	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: iconst_0
    //   171: istore_1
    //   172: goto -101 -> 71
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_2
    //   178: aload_2
    //   179: ifnull +7 -> 186
    //   182: aload_2
    //   183: invokevirtual 250	java/io/FileOutputStream:close	()V
    //   186: ldc 219
    //   188: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_0
    //   192: athrow
    //   193: astore_2
    //   194: ldc 130
    //   196: aload_2
    //   197: ldc 143
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 261	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -20 -> 186
    //   209: astore_0
    //   210: goto -32 -> 178
    //   213: astore 4
    //   215: goto -112 -> 103
    //   218: iconst_0
    //   219: istore_1
    //   220: goto -149 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	parama	a
    //   66	154	1	bool	boolean
    //   37	24	2	localFileOutputStream1	java.io.FileOutputStream
    //   83	4	2	localIOException1	java.io.IOException
    //   104	1	2	localFileOutputStream2	java.io.FileOutputStream
    //   157	4	2	localIOException2	java.io.IOException
    //   177	6	2	localObject	Object
    //   193	4	2	localIOException3	java.io.IOException
    //   35	114	3	localFileOutputStream3	java.io.FileOutputStream
    //   18	44	4	localFile	File
    //   99	19	4	localIOException4	java.io.IOException
    //   213	1	4	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   67	71	83	java/io/IOException
    //   20	36	99	java/io/IOException
    //   148	152	157	java/io/IOException
    //   20	36	175	finally
    //   182	186	193	java/io/IOException
    //   38	47	209	finally
    //   49	53	209	finally
    //   55	59	209	finally
    //   61	67	209	finally
    //   105	144	209	finally
    //   38	47	213	java/io/IOException
    //   49	53	213	java/io/IOException
    //   55	59	213	java/io/IOException
    //   61	67	213	java/io/IOException
  }
  
  /* Error */
  private static ArrayList<a> dtC()
  {
    // Byte code:
    //   0: ldc_w 284
    //   3: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 155	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 286	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: new 288	java/io/BufferedReader
    //   17: dup
    //   18: new 290	java/io/FileReader
    //   21: dup
    //   22: ldc_w 292
    //   25: invokespecial 293	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   28: invokespecial 296	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 299	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +156 -> 198
    //   45: aload_1
    //   46: astore_0
    //   47: aload 4
    //   49: ldc_w 301
    //   52: invokevirtual 305	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   72: ldc_w 307
    //   75: aload 4
    //   77: invokestatic 310	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokevirtual 313	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokestatic 281	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: goto -54 -> 32
    //   89: astore_2
    //   90: aload_1
    //   91: astore_0
    //   92: ldc 130
    //   94: ldc_w 315
    //   97: iconst_1
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_2
    //   104: aastore
    //   105: invokestatic 138	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 316	java/io/BufferedReader:close	()V
    //   116: ldc_w 284
    //   119: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_3
    //   123: areturn
    //   124: aload_1
    //   125: astore_0
    //   126: new 6	com/tencent/mm/sdk/platformtools/bd$a
    //   129: dup
    //   130: invokespecial 317	com/tencent/mm/sdk/platformtools/bd$a:<init>	()V
    //   133: astore 4
    //   135: aload_1
    //   136: astore_0
    //   137: aload 4
    //   139: aload_2
    //   140: iconst_0
    //   141: aaload
    //   142: putfield 320	com/tencent/mm/sdk/platformtools/bd$a:yqb	Ljava/lang/String;
    //   145: aload_1
    //   146: astore_0
    //   147: aload 4
    //   149: aload_2
    //   150: iconst_1
    //   151: aaload
    //   152: putfield 95	com/tencent/mm/sdk/platformtools/bd$a:yqc	Ljava/lang/String;
    //   155: aload_1
    //   156: astore_0
    //   157: aload 4
    //   159: aload_2
    //   160: iconst_2
    //   161: aaload
    //   162: putfield 176	com/tencent/mm/sdk/platformtools/bd$a:yqd	Ljava/lang/String;
    //   165: aload_1
    //   166: astore_0
    //   167: aload_3
    //   168: aload 4
    //   170: invokevirtual 323	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   187: invokevirtual 316	java/io/BufferedReader:close	()V
    //   190: ldc_w 284
    //   193: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_0
    //   197: athrow
    //   198: aload_1
    //   199: invokevirtual 316	java/io/BufferedReader:close	()V
    //   202: goto -86 -> 116
    //   205: astore_0
    //   206: ldc 130
    //   208: aload_0
    //   209: ldc 143
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 261	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: goto -102 -> 116
    //   221: astore_0
    //   222: ldc 130
    //   224: aload_0
    //   225: ldc 143
    //   227: iconst_0
    //   228: anewarray 4	java/lang/Object
    //   231: invokestatic 261	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: goto -118 -> 116
    //   237: astore_1
    //   238: ldc 130
    //   240: aload_1
    //   241: ldc 143
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 261	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   205	4	0	localIOException1	java.io.IOException
    //   221	4	0	localIOException2	java.io.IOException
    //   253	1	0	localObject2	Object
    //   31	168	1	localObject3	Object
    //   237	4	1	localIOException3	java.io.IOException
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
  
  private static a dtD()
  {
    AppMethodBeat.i(52256);
    Object localObject1 = dtC();
    String str = Environment.getDataDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject2).next();
    } while (!((a)localObject1).yqc.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a();
        ((a)localObject2).yqc = str;
        ((a)localObject2).yqb = "Unknown";
        ((a)localObject2).yqd = "Unknown";
      }
      a((a)localObject2);
      AppMethodBeat.o(52256);
      return localObject2;
      localObject1 = null;
    }
  }
  
  private static a dtE()
  {
    AppMethodBeat.i(52257);
    Object localObject1 = dtC();
    String str = Environment.getExternalStorageDirectory().getAbsolutePath();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (a)((Iterator)localObject2).next();
    } while (!((a)localObject1).yqc.equals(str));
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new a();
        ((a)localObject2).yqc = str;
        ((a)localObject2).yqb = "Unknown";
        ((a)localObject2).yqd = "Unknown";
      }
      a((a)localObject2);
      AppMethodBeat.o(52257);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public static ArrayList<a> dtF()
  {
    AppMethodBeat.i(52258);
    ArrayList localArrayList = dtC();
    int i = localArrayList.size();
    Object localObject1 = Arrays.asList(ypY);
    Object localObject2 = Arrays.asList(ypZ);
    Object localObject3 = Arrays.asList(yqa);
    i -= 1;
    if (i >= 0)
    {
      a locala = (a)localArrayList.get(i);
      if (!((List)localObject1).contains(locala.yqd))
      {
        localArrayList.remove(i);
        ab.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + locala.yqd);
      }
      for (;;)
      {
        i -= 1;
        break;
        Iterator localIterator = ((List)localObject2).iterator();
        String str;
        for (boolean bool = false; localIterator.hasNext(); bool = locala.yqc.startsWith(str) | bool) {
          str = (String)localIterator.next();
        }
        if (bool)
        {
          localArrayList.remove(i);
          ab.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + locala.yqc);
        }
        else if ((locala.yqd.equals("fuse")) || (locala.yqd.equals("sdcardfs")))
        {
          if (locala.yqb.startsWith("/data/"))
          {
            localArrayList.remove(i);
            ab.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + locala.yqb);
          }
        }
        else if ((!locala.yqd.equals("fuse")) && (!locala.yqd.equals("sdcardfs")))
        {
          localIterator = ((List)localObject3).iterator();
          for (bool = false; localIterator.hasNext(); bool = locala.yqb.startsWith(str) | bool) {
            str = (String)localIterator.next();
          }
          if (!bool)
          {
            localArrayList.remove(i);
            ab.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + locala.yqb);
          }
        }
      }
    }
    localObject1 = Environment.getExternalStorageDirectory().getPath();
    i = localArrayList.size() - 1;
    if (i >= 0)
    {
      localObject2 = (a)localArrayList.get(i);
      if (((a)localObject2).yqc.equals(localObject1))
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
        ((a)localObject2).yqc = ((String)localObject1);
        ((a)localObject2).yqd = "unknown";
        ((a)localObject2).yqb = "unknown";
        localArrayList.add(0, localObject2);
      }
      i = localArrayList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          localObject1 = (a)localArrayList.get(i);
          localObject2 = new File(((a)localObject1).yqc);
          if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory()))
          {
            ab.d("MicroMsg.SdcardUtil", "Directory verify failed: ".concat(String.valueOf(localObject1)));
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
          ab.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: ".concat(String.valueOf(localObject1)));
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
          if (!((a)localObject1).yqb.equals(((a)localObject2).yqb)) {
            break label913;
          }
          localArrayList.remove(i);
          ab.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + ((a)localObject1).yqb);
          if ((((a)localObject1).bUV) || (!((a)localObject2).bUV)) {
            break label913;
          }
          ab.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
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
              ab.d("MicroMsg.SdcardUtil", "Duplicate:" + ((a)localObject1).toString() + "---" + ((a)localObject2).toString());
              ((ArrayList)localObject3).remove(i);
            }
            i -= 1;
          }
        }
        AppMethodBeat.o(52258);
        return localArrayList;
      }
    }
  }
  
  public static long dtG()
  {
    AppMethodBeat.i(52259);
    a locala = dtD();
    long l1 = locala.yqg;
    long l2 = locala.yqh;
    AppMethodBeat.o(52259);
    return l2 * l1;
  }
  
  public static long dtH()
  {
    AppMethodBeat.i(52260);
    a locala = dtE();
    long l1 = locala.yqg;
    long l2 = locala.yqh;
    AppMethodBeat.o(52260);
    return l2 * l1;
  }
  
  public static boolean dtI()
  {
    AppMethodBeat.i(52261);
    long l = System.currentTimeMillis();
    Object localObject5 = dtC();
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
      if ((localObject3 == null) && (((a)localObject2).yqc.equals(str2)))
      {
        if (localObject1 != null) {
          break label492;
        }
        localObject3 = localObject2;
      }
      else
      {
        if ((localObject1 != null) || (!((a)localObject2).yqc.equals(str1))) {
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
      if ((localObject4 != null) && (localObject2 == null) && (!bo.isNullOrNil(str1)) && (str1.contains("emulated")))
      {
        localObject1 = str1.substring(str1.lastIndexOf('/') + 1);
        int i = bo.getInt((String)localObject1, -1);
        ab.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", new Object[] { localObject1, Integer.valueOf(i) });
        if (i != -1)
        {
          localObject3 = str1.substring(0, str1.length() - ((String)localObject1).length() - 1);
          if (!bo.isNullOrNil((String)localObject3))
          {
            localObject5 = ((ArrayList)localObject5).iterator();
            do
            {
              if (!((Iterator)localObject5).hasNext()) {
                break;
              }
              localObject1 = (a)((Iterator)localObject5).next();
            } while (!((a)localObject1).yqc.equals(localObject3));
          }
        }
      }
      for (;;)
      {
        if ((localObject4 != null) && (localObject1 != null))
        {
          a(localObject4);
          a((a)localObject1);
          ab.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", new Object[] { localObject4, localObject1 });
          if (((!((a)localObject1).yqd.equals("fuse")) && (!((a)localObject1).yqd.equals("sdcardfs")) && (!((a)localObject1).yqd.equals("esdfs"))) || (localObject4.yqe < ((a)localObject1).yqe) || (((a)localObject1).yqe <= 0L) || (localObject4.yqh < ((a)localObject1).yqh) || (((a)localObject1).yqh <= 0L) || (localObject4.yqg < ((a)localObject1).yqg)) {}
        }
        for (boolean bool = true;; bool = false)
        {
          ab.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(52261);
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
    public boolean bUV;
    public String yqb;
    public String yqc;
    public String yqd;
    public long yqe;
    public long yqf;
    public long yqg;
    public long yqh;
    a yqi;
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(52252);
      paramObject = (a)paramObject;
      if (this.yqh != paramObject.yqh)
      {
        AppMethodBeat.o(52252);
        return false;
      }
      long l1 = this.yqe - paramObject.yqe;
      long l2 = this.yqf - paramObject.yqf;
      long l3 = this.yqg - paramObject.yqg;
      if ((Math.abs(l1 - l2) <= 4L) && (Math.abs(l1 - l3) <= 4L) && (Math.abs(l2 - l3) <= 4L))
      {
        AppMethodBeat.o(52252);
        return true;
      }
      AppMethodBeat.o(52252);
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(52251);
      Object localObject = new StringBuilder("{DevName=").append(this.yqb).append(", MountDir=").append(this.yqc).append(", FileSystem=").append(this.yqd).append(", TotalBlocks=").append(this.yqe).append(", FreeBlocks=").append(this.yqf).append(", AvailableBlocks=").append(this.yqg).append(", BlockSize=").append(this.yqh).append(", Shared=");
      if (this.yqi != null) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = bool + "}";
        AppMethodBeat.o(52251);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bd
 * JD-Core Version:    0.7.0.1
 */