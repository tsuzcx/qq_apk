package org.extra.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class a
  implements c.a
{
  private static a b(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(220053);
    paramContext = paramContext.getApplicationInfo();
    String[] arrayOfString;
    int i;
    label78:
    String str;
    int j;
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.splitSourceDirs != null) && (paramContext.splitSourceDirs.length != 0))
    {
      arrayOfString = new String[paramContext.splitSourceDirs.length + 1];
      arrayOfString[0] = paramContext.sourceDir;
      System.arraycopy(paramContext.splitSourceDirs, 0, arrayOfString, 1, paramContext.splitSourceDirs.length);
      int m = arrayOfString.length;
      i = 0;
      paramContext = null;
      if (i >= m) {
        break label296;
      }
      str = arrayOfString[i];
      j = 0;
      label93:
      if (j >= 5) {
        break label308;
      }
    }
    label267:
    label276:
    label285:
    label289:
    label296:
    label308:
    for (;;)
    {
      for (;;)
      {
        int k;
        try
        {
          Object localObject = new ZipFile(new File(str), 1);
          paramContext = (Context)localObject;
          if (paramContext == null) {
            break label289;
          }
          j = 0;
          if (j >= 5) {
            break label285;
          }
          int n = paramArrayOfString.length;
          k = 0;
          if (k >= n) {
            break label276;
          }
          localObject = paramArrayOfString[k];
          localObject = "lib" + File.separatorChar + (String)localObject + File.separatorChar + paramString;
          d.B("Looking for %s in APK %s...", new Object[] { localObject, str });
          localObject = paramContext.getEntry((String)localObject);
          if (localObject == null) {
            break label267;
          }
          paramContext = new a(paramContext, (ZipEntry)localObject);
          AppMethodBeat.o(220053);
          return paramContext;
        }
        catch (IOException localIOException1)
        {
          j += 1;
        }
        arrayOfString = new String[1];
        arrayOfString[0] = paramContext.sourceDir;
        break;
        break label93;
        k += 1;
        continue;
        j += 1;
        continue;
        try
        {
          paramContext.close();
          i += 1;
          break label78;
          AppMethodBeat.o(220053);
          return null;
        }
        catch (IOException localIOException2)
        {
          break label289;
        }
      }
    }
  }
  
  private static void e(Closeable paramCloseable)
  {
    AppMethodBeat.i(220056);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(220056);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(220056);
    }
  }
  
  private static long h(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(220055);
    long l = 0L;
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
    paramOutputStream.flush();
    AppMethodBeat.o(220055);
    return l;
  }
  
  /* Error */
  public final void a(Context paramContext, String[] paramArrayOfString, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 134
    //   8: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: aload_2
    //   13: aload_3
    //   14: invokestatic 136	org/extra/a/a:b	(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Lorg/extra/a/a$a;
    //   17: astore 12
    //   19: aload 12
    //   21: ifnonnull +48 -> 69
    //   24: new 138	org/extra/a/b
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 139	org/extra/a/b:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: ldc 134
    //   35: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload 12
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +17 -> 62
    //   48: aload_2
    //   49: getfield 143	org/extra/a/a$a:NVw	Ljava/util/zip/ZipFile;
    //   52: ifnull +10 -> 62
    //   55: aload_2
    //   56: getfield 143	org/extra/a/a$a:NVw	Ljava/util/zip/ZipFile;
    //   59: invokevirtual 106	java/util/zip/ZipFile:close	()V
    //   62: ldc 134
    //   64: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_1
    //   68: athrow
    //   69: iload 5
    //   71: iconst_1
    //   72: iadd
    //   73: istore 6
    //   75: iload 5
    //   77: iconst_5
    //   78: if_icmpge +234 -> 312
    //   81: ldc 145
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_3
    //   90: aastore
    //   91: invokestatic 93	org/extra/a/d:B	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload 4
    //   96: invokevirtual 149	java/io/File:exists	()Z
    //   99: ifne +30 -> 129
    //   102: aload 4
    //   104: invokevirtual 152	java/io/File:createNewFile	()Z
    //   107: istore 7
    //   109: iload 7
    //   111: ifne +18 -> 129
    //   114: iload 6
    //   116: istore 5
    //   118: goto -49 -> 69
    //   121: astore_1
    //   122: iload 6
    //   124: istore 5
    //   126: goto -57 -> 69
    //   129: aload 12
    //   131: getfield 143	org/extra/a/a$a:NVw	Ljava/util/zip/ZipFile;
    //   134: aload 12
    //   136: getfield 156	org/extra/a/a$a:NVx	Ljava/util/zip/ZipEntry;
    //   139: invokevirtual 160	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   142: astore_1
    //   143: new 162	java/io/FileOutputStream
    //   146: dup
    //   147: aload 4
    //   149: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   152: astore_2
    //   153: aload_1
    //   154: aload_2
    //   155: invokestatic 167	org/extra/a/a:h	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   158: lstore 8
    //   160: aload_2
    //   161: invokevirtual 171	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   164: invokevirtual 176	java/io/FileDescriptor:sync	()V
    //   167: aload 4
    //   169: invokevirtual 180	java/io/File:length	()J
    //   172: lstore 10
    //   174: lload 8
    //   176: lload 10
    //   178: lcmp
    //   179: ifeq +18 -> 197
    //   182: aload_1
    //   183: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   186: aload_2
    //   187: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   190: iload 6
    //   192: istore 5
    //   194: goto -125 -> 69
    //   197: aload_1
    //   198: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   201: aload_2
    //   202: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   205: aload 4
    //   207: iconst_1
    //   208: iconst_0
    //   209: invokevirtual 186	java/io/File:setReadable	(ZZ)Z
    //   212: pop
    //   213: aload 4
    //   215: iconst_1
    //   216: iconst_0
    //   217: invokevirtual 189	java/io/File:setExecutable	(ZZ)Z
    //   220: pop
    //   221: aload 4
    //   223: iconst_1
    //   224: invokevirtual 193	java/io/File:setWritable	(Z)Z
    //   227: pop
    //   228: aload 12
    //   230: ifnull +19 -> 249
    //   233: aload 12
    //   235: getfield 143	org/extra/a/a$a:NVw	Ljava/util/zip/ZipFile;
    //   238: ifnull +11 -> 249
    //   241: aload 12
    //   243: getfield 143	org/extra/a/a$a:NVw	Ljava/util/zip/ZipFile;
    //   246: invokevirtual 106	java/util/zip/ZipFile:close	()V
    //   249: ldc 134
    //   251: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_2
    //   258: aconst_null
    //   259: astore_1
    //   260: aload_1
    //   261: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   264: aload_2
    //   265: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   268: iload 6
    //   270: istore 5
    //   272: goto -203 -> 69
    //   275: aload_1
    //   276: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   279: aload_2
    //   280: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   283: iload 6
    //   285: istore 5
    //   287: goto -218 -> 69
    //   290: aload_3
    //   291: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   294: aload_2
    //   295: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   298: ldc 134
    //   300: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: aload_1
    //   304: athrow
    //   305: astore_1
    //   306: ldc 134
    //   308: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: return
    //   312: aload 12
    //   314: ifnull +19 -> 333
    //   317: aload 12
    //   319: getfield 143	org/extra/a/a$a:NVw	Ljava/util/zip/ZipFile;
    //   322: ifnull +11 -> 333
    //   325: aload 12
    //   327: getfield 143	org/extra/a/a$a:NVw	Ljava/util/zip/ZipFile;
    //   330: invokevirtual 106	java/util/zip/ZipFile:close	()V
    //   333: ldc 134
    //   335: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: return
    //   339: astore_1
    //   340: ldc 134
    //   342: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: return
    //   346: astore_2
    //   347: goto -285 -> 62
    //   350: astore_1
    //   351: aload 13
    //   353: astore_2
    //   354: goto -310 -> 44
    //   357: astore_2
    //   358: aconst_null
    //   359: astore 4
    //   361: aload_1
    //   362: astore_3
    //   363: aload_2
    //   364: astore_1
    //   365: aload 4
    //   367: astore_2
    //   368: goto -78 -> 290
    //   371: astore 4
    //   373: aload_1
    //   374: astore_3
    //   375: aload 4
    //   377: astore_1
    //   378: goto -88 -> 290
    //   381: astore_2
    //   382: aconst_null
    //   383: astore_2
    //   384: goto -109 -> 275
    //   387: astore 13
    //   389: goto -114 -> 275
    //   392: astore_2
    //   393: aconst_null
    //   394: astore_2
    //   395: goto -135 -> 260
    //   398: astore 13
    //   400: goto -140 -> 260
    //   403: astore_1
    //   404: aconst_null
    //   405: astore_2
    //   406: aconst_null
    //   407: astore_1
    //   408: goto -133 -> 275
    //   411: astore_1
    //   412: aconst_null
    //   413: astore_2
    //   414: aconst_null
    //   415: astore_3
    //   416: goto -126 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	a
    //   0	419	1	paramContext	Context
    //   0	419	2	paramArrayOfString	String[]
    //   0	419	3	paramString	String
    //   0	419	4	paramFile	File
    //   4	282	5	i	int
    //   73	211	6	j	int
    //   107	3	7	bool	boolean
    //   158	17	8	l1	long
    //   172	5	10	l2	long
    //   17	309	12	locala	a
    //   1	351	13	localObject	Object
    //   387	1	13	localIOException	IOException
    //   398	1	13	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   24	40	40	finally
    //   81	94	40	finally
    //   94	109	40	finally
    //   182	190	40	finally
    //   197	228	40	finally
    //   260	268	40	finally
    //   275	283	40	finally
    //   290	305	40	finally
    //   94	109	121	java/io/IOException
    //   129	143	255	java/io/FileNotFoundException
    //   233	249	305	java/io/IOException
    //   317	333	339	java/io/IOException
    //   48	62	346	java/io/IOException
    //   11	19	350	finally
    //   143	153	357	finally
    //   153	174	371	finally
    //   143	153	381	java/io/IOException
    //   153	174	387	java/io/IOException
    //   143	153	392	java/io/FileNotFoundException
    //   153	174	398	java/io/FileNotFoundException
    //   129	143	403	java/io/IOException
    //   129	143	411	finally
  }
  
  static final class a
  {
    public ZipFile NVw;
    public ZipEntry NVx;
    
    public a(ZipFile paramZipFile, ZipEntry paramZipEntry)
    {
      this.NVw = paramZipFile;
      this.NVx = paramZipEntry;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.a
 * JD-Core Version:    0.7.0.1
 */