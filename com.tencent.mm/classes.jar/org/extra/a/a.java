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
    AppMethodBeat.i(187302);
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
          d.x("Looking for %s in APK %s...", new Object[] { localObject, str });
          localObject = paramContext.getEntry((String)localObject);
          if (localObject == null) {
            break label267;
          }
          paramContext = new a(paramContext, (ZipEntry)localObject);
          AppMethodBeat.o(187302);
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
          AppMethodBeat.o(187302);
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
    AppMethodBeat.i(187318);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(187318);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(187318);
    }
  }
  
  private static long k(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(187310);
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
    AppMethodBeat.o(187310);
    return l;
  }
  
  /* Error */
  public final void a(Context paramContext, String[] paramArrayOfString, String paramString, File paramFile, d paramd)
  {
    // Byte code:
    //   0: ldc 134
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 5
    //   8: aload_1
    //   9: aload_2
    //   10: aload_3
    //   11: invokestatic 136	org/extra/a/a:b	(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Lorg/extra/a/a$a;
    //   14: astore 15
    //   16: aload 15
    //   18: ifnonnull +48 -> 66
    //   21: new 138	org/extra/a/b
    //   24: dup
    //   25: aload_3
    //   26: invokespecial 139	org/extra/a/b:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: ldc 134
    //   32: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_1
    //   36: athrow
    //   37: astore_1
    //   38: aload 15
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +17 -> 59
    //   45: aload_2
    //   46: getfield 143	org/extra/a/a$a:ajXP	Ljava/util/zip/ZipFile;
    //   49: ifnull +10 -> 59
    //   52: aload_2
    //   53: getfield 143	org/extra/a/a$a:ajXP	Ljava/util/zip/ZipFile;
    //   56: invokevirtual 106	java/util/zip/ZipFile:close	()V
    //   59: ldc 134
    //   61: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_1
    //   65: athrow
    //   66: iconst_0
    //   67: istore 6
    //   69: iload 6
    //   71: iconst_1
    //   72: iadd
    //   73: istore 7
    //   75: iload 6
    //   77: iconst_5
    //   78: if_icmpge +257 -> 335
    //   81: ldc 145
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload_3
    //   90: aastore
    //   91: invokestatic 93	org/extra/a/d:x	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload 4
    //   96: invokevirtual 149	java/io/File:exists	()Z
    //   99: ifne +30 -> 129
    //   102: aload 4
    //   104: invokevirtual 152	java/io/File:createNewFile	()Z
    //   107: istore 8
    //   109: iload 8
    //   111: ifne +18 -> 129
    //   114: iload 7
    //   116: istore 6
    //   118: goto -49 -> 69
    //   121: astore_1
    //   122: iload 7
    //   124: istore 6
    //   126: goto -57 -> 69
    //   129: aconst_null
    //   130: astore 13
    //   132: aconst_null
    //   133: astore 14
    //   135: aconst_null
    //   136: astore 5
    //   138: aconst_null
    //   139: astore 16
    //   141: aload 15
    //   143: getfield 143	org/extra/a/a$a:ajXP	Ljava/util/zip/ZipFile;
    //   146: aload 15
    //   148: getfield 156	org/extra/a/a$a:ajXQ	Ljava/util/zip/ZipEntry;
    //   151: invokevirtual 160	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   154: astore_1
    //   155: aload_1
    //   156: astore 5
    //   158: aload_1
    //   159: astore 13
    //   161: aload_1
    //   162: astore 14
    //   164: new 162	java/io/FileOutputStream
    //   167: dup
    //   168: aload 4
    //   170: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   173: astore_2
    //   174: aload_1
    //   175: aload_2
    //   176: invokestatic 167	org/extra/a/a:k	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   179: lstore 9
    //   181: aload_2
    //   182: invokevirtual 171	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   185: invokevirtual 176	java/io/FileDescriptor:sync	()V
    //   188: aload 4
    //   190: invokevirtual 180	java/io/File:length	()J
    //   193: lstore 11
    //   195: lload 9
    //   197: lload 11
    //   199: lcmp
    //   200: ifeq +18 -> 218
    //   203: aload_1
    //   204: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   207: aload_2
    //   208: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   211: iload 7
    //   213: istore 6
    //   215: goto -146 -> 69
    //   218: aload_1
    //   219: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   222: aload_2
    //   223: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   226: aload 4
    //   228: iconst_1
    //   229: iconst_0
    //   230: invokevirtual 186	java/io/File:setReadable	(ZZ)Z
    //   233: pop
    //   234: aload 4
    //   236: iconst_1
    //   237: iconst_0
    //   238: invokevirtual 189	java/io/File:setExecutable	(ZZ)Z
    //   241: pop
    //   242: aload 4
    //   244: iconst_1
    //   245: invokevirtual 193	java/io/File:setWritable	(Z)Z
    //   248: pop
    //   249: aload 15
    //   251: ifnull +19 -> 270
    //   254: aload 15
    //   256: getfield 143	org/extra/a/a$a:ajXP	Ljava/util/zip/ZipFile;
    //   259: ifnull +11 -> 270
    //   262: aload 15
    //   264: getfield 143	org/extra/a/a$a:ajXP	Ljava/util/zip/ZipFile;
    //   267: invokevirtual 106	java/util/zip/ZipFile:close	()V
    //   270: ldc 134
    //   272: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: return
    //   276: astore_1
    //   277: aconst_null
    //   278: astore_2
    //   279: aload 5
    //   281: astore_1
    //   282: aload_1
    //   283: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   286: aload_2
    //   287: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   290: iload 7
    //   292: istore 6
    //   294: goto -225 -> 69
    //   297: aload_1
    //   298: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   301: aload_2
    //   302: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   305: iload 7
    //   307: istore 6
    //   309: goto -240 -> 69
    //   312: aload_1
    //   313: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   316: aload 4
    //   318: invokestatic 182	org/extra/a/a:e	(Ljava/io/Closeable;)V
    //   321: ldc 134
    //   323: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_2
    //   327: athrow
    //   328: astore_1
    //   329: ldc 134
    //   331: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: return
    //   335: aload 15
    //   337: ifnull +19 -> 356
    //   340: aload 15
    //   342: getfield 143	org/extra/a/a$a:ajXP	Ljava/util/zip/ZipFile;
    //   345: ifnull +11 -> 356
    //   348: aload 15
    //   350: getfield 143	org/extra/a/a$a:ajXP	Ljava/util/zip/ZipFile;
    //   353: invokevirtual 106	java/util/zip/ZipFile:close	()V
    //   356: ldc 134
    //   358: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: return
    //   362: astore_1
    //   363: ldc 134
    //   365: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: return
    //   369: astore_2
    //   370: goto -311 -> 59
    //   373: astore_1
    //   374: aload 5
    //   376: astore_2
    //   377: goto -336 -> 41
    //   380: astore_3
    //   381: aload_2
    //   382: astore 4
    //   384: aload_3
    //   385: astore_2
    //   386: goto -74 -> 312
    //   389: astore 5
    //   391: goto -94 -> 297
    //   394: astore 5
    //   396: goto -114 -> 282
    //   399: astore_1
    //   400: aload 16
    //   402: astore_2
    //   403: aload 13
    //   405: astore_1
    //   406: goto -109 -> 297
    //   409: astore_2
    //   410: aconst_null
    //   411: astore 4
    //   413: aload 14
    //   415: astore_1
    //   416: goto -104 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	a
    //   0	419	1	paramContext	Context
    //   0	419	2	paramArrayOfString	String[]
    //   0	419	3	paramString	String
    //   0	419	4	paramFile	File
    //   0	419	5	paramd	d
    //   67	241	6	i	int
    //   73	233	7	j	int
    //   107	3	8	bool	boolean
    //   179	17	9	l1	long
    //   193	5	11	l2	long
    //   130	274	13	localContext1	Context
    //   133	281	14	localContext2	Context
    //   14	335	15	locala	a
    //   139	262	16	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	37	37	finally
    //   81	94	37	finally
    //   94	109	37	finally
    //   203	211	37	finally
    //   218	249	37	finally
    //   282	290	37	finally
    //   297	305	37	finally
    //   312	328	37	finally
    //   94	109	121	java/io/IOException
    //   141	155	276	java/io/FileNotFoundException
    //   164	174	276	java/io/FileNotFoundException
    //   254	270	328	java/io/IOException
    //   340	356	362	java/io/IOException
    //   45	59	369	java/io/IOException
    //   8	16	373	finally
    //   174	195	380	finally
    //   174	195	389	java/io/IOException
    //   174	195	394	java/io/FileNotFoundException
    //   141	155	399	java/io/IOException
    //   164	174	399	java/io/IOException
    //   141	155	409	finally
    //   164	174	409	finally
  }
  
  static final class a
  {
    public ZipFile ajXP;
    public ZipEntry ajXQ;
    
    public a(ZipFile paramZipFile, ZipEntry paramZipEntry)
    {
      this.ajXP = paramZipFile;
      this.ajXQ = paramZipEntry;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.extra.a.a
 * JD-Core Version:    0.7.0.1
 */