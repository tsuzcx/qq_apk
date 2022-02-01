package com.tencent.tinker.lib.c;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.ShareArkHotDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public final class b
  extends c
{
  private static ArrayList<ShareArkHotDiffPatchInfo> MgC = new ArrayList();
  
  protected static boolean a(ShareSecurityCheck paramShareSecurityCheck, Context paramContext, String paramString, File paramFile)
  {
    paramShareSecurityCheck = (String)paramShareSecurityCheck.getMetaContentMap().get("assets/arkHot_meta.txt");
    if (paramShareSecurityCheck == null) {
      return true;
    }
    paramString = paramString + "/arkHot/";
    MgC.clear();
    ShareArkHotDiffPatchInfo.parseDiffPatchInfo(paramShareSecurityCheck, MgC);
    b(paramContext, paramString, paramFile);
    return true;
  }
  
  /* Error */
  private static boolean b(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 69	com/tencent/tinker/lib/e/a:lk	(Landroid/content/Context;)Lcom/tencent/tinker/lib/e/a;
    //   4: astore 4
    //   6: new 71	java/util/zip/ZipFile
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 74	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   14: astore_3
    //   15: getstatic 16	com/tencent/tinker/lib/c/b:MgC	Ljava/util/ArrayList;
    //   18: invokevirtual 78	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   21: astore 5
    //   23: aload 5
    //   25: invokeinterface 84 1 0
    //   30: ifeq +277 -> 307
    //   33: aload 5
    //   35: invokeinterface 88 1 0
    //   40: checkcast 53	com/tencent/tinker/loader/shareutil/ShareArkHotDiffPatchInfo
    //   43: astore 6
    //   45: aload 6
    //   47: getfield 92	com/tencent/tinker/loader/shareutil/ShareArkHotDiffPatchInfo:path	Ljava/lang/String;
    //   50: astore_0
    //   51: aload_0
    //   52: ldc 94
    //   54: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +46 -> 103
    //   60: aload 6
    //   62: getfield 101	com/tencent/tinker/loader/shareutil/ShareArkHotDiffPatchInfo:name	Ljava/lang/String;
    //   65: astore_0
    //   66: aload 6
    //   68: getfield 104	com/tencent/tinker/loader/shareutil/ShareArkHotDiffPatchInfo:patchMd5	Ljava/lang/String;
    //   71: astore 7
    //   73: aload 7
    //   75: invokestatic 110	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:checkIfMd5Valid	(Ljava/lang/String;)Z
    //   78: ifne +56 -> 134
    //   81: aload 4
    //   83: getfield 114	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   86: aload_2
    //   87: bipush 8
    //   89: invokestatic 118	com/tencent/tinker/lib/c/c:ail	(I)I
    //   92: invokeinterface 124 3 0
    //   97: aload_3
    //   98: invokestatic 128	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   101: iconst_0
    //   102: ireturn
    //   103: new 37	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   110: aload_0
    //   111: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 130
    //   116: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 6
    //   121: getfield 101	com/tencent/tinker/loader/shareutil/ShareArkHotDiffPatchInfo:name	Ljava/lang/String;
    //   124: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: astore_0
    //   131: goto -65 -> 66
    //   134: new 132	java/io/File
    //   137: dup
    //   138: new 37	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   145: aload_1
    //   146: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 6
    //   151: getfield 101	com/tencent/tinker/loader/shareutil/ShareArkHotDiffPatchInfo:name	Ljava/lang/String;
    //   154: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore 8
    //   165: aload 8
    //   167: invokevirtual 138	java/io/File:exists	()Z
    //   170: ifeq +65 -> 235
    //   173: aload 7
    //   175: aload 8
    //   177: invokestatic 142	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:getMD5	(Ljava/io/File;)Ljava/lang/String;
    //   180: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifne -160 -> 23
    //   186: aload 8
    //   188: invokevirtual 145	java/io/File:delete	()Z
    //   191: pop
    //   192: aload_3
    //   193: aload_3
    //   194: aload_0
    //   195: invokevirtual 149	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   198: aload 8
    //   200: aload 7
    //   202: iconst_0
    //   203: invokestatic 152	com/tencent/tinker/lib/c/b:a	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/lang/String;Z)Z
    //   206: ifne -183 -> 23
    //   209: aload 4
    //   211: getfield 114	com/tencent/tinker/lib/e/a:MgW	Lcom/tencent/tinker/lib/d/d;
    //   214: aload_2
    //   215: aload 8
    //   217: aload 6
    //   219: getfield 101	com/tencent/tinker/loader/shareutil/ShareArkHotDiffPatchInfo:name	Ljava/lang/String;
    //   222: bipush 8
    //   224: invokeinterface 155 5 0
    //   229: aload_3
    //   230: invokestatic 128	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   233: iconst_0
    //   234: ireturn
    //   235: aload 8
    //   237: invokevirtual 159	java/io/File:getParentFile	()Ljava/io/File;
    //   240: invokevirtual 162	java/io/File:mkdirs	()Z
    //   243: pop
    //   244: goto -52 -> 192
    //   247: astore_1
    //   248: aload_3
    //   249: astore_0
    //   250: new 164	com/tencent/tinker/loader/TinkerRuntimeException
    //   253: dup
    //   254: new 37	java/lang/StringBuilder
    //   257: dup
    //   258: ldc 166
    //   260: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   263: bipush 8
    //   265: invokestatic 173	com/tencent/tinker/loader/shareutil/ShareTinkerInternals:getTypeString	(I)Ljava/lang/String;
    //   268: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc 175
    //   273: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 178	java/io/IOException:getMessage	()Ljava/lang/String;
    //   280: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc 180
    //   285: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: aload_1
    //   292: invokespecial 183	com/tencent/tinker/loader/TinkerRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   295: athrow
    //   296: astore_2
    //   297: aload_0
    //   298: astore_1
    //   299: aload_2
    //   300: astore_0
    //   301: aload_1
    //   302: invokestatic 128	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   305: aload_0
    //   306: athrow
    //   307: aload_3
    //   308: invokestatic 128	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   311: iconst_1
    //   312: ireturn
    //   313: astore_0
    //   314: aconst_null
    //   315: astore_1
    //   316: goto -15 -> 301
    //   319: astore_0
    //   320: aload_3
    //   321: astore_1
    //   322: goto -21 -> 301
    //   325: astore_1
    //   326: aconst_null
    //   327: astore_0
    //   328: goto -78 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramContext	Context
    //   0	331	1	paramString	String
    //   0	331	2	paramFile	File
    //   14	307	3	localZipFile	java.util.zip.ZipFile
    //   4	206	4	locala	com.tencent.tinker.lib.e.a
    //   21	13	5	localIterator	java.util.Iterator
    //   43	175	6	localShareArkHotDiffPatchInfo	ShareArkHotDiffPatchInfo
    //   71	130	7	str	String
    //   163	73	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   15	23	247	java/io/IOException
    //   23	66	247	java/io/IOException
    //   66	97	247	java/io/IOException
    //   103	131	247	java/io/IOException
    //   134	192	247	java/io/IOException
    //   192	229	247	java/io/IOException
    //   235	244	247	java/io/IOException
    //   250	296	296	finally
    //   6	15	313	finally
    //   15	23	319	finally
    //   23	66	319	finally
    //   66	97	319	finally
    //   103	131	319	finally
    //   134	192	319	finally
    //   192	229	319	finally
    //   235	244	319	finally
    //   6	15	325	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.c.b
 * JD-Core Version:    0.7.0.1
 */