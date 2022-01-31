package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class hz
  extends Thread
  implements ia
{
  private long a;
  private ik b;
  private jd c;
  private boolean d;
  private boolean e;
  private boolean f;
  private List<Integer> g;
  
  public hz(ik paramik, jd paramjd)
  {
    this.b = paramik;
    this.c = paramjd;
    this.a = 0L;
    this.f = false;
    this.d = false;
    this.e = false;
  }
  
  private long a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
  }
  
  private File a(String paramString)
  {
    AppMethodBeat.i(148145);
    Object localObject = g();
    if (localObject == null)
    {
      AppMethodBeat.o(148145);
      return null;
    }
    try
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject == null) || (localObject.length == 0))
      {
        AppMethodBeat.o(148145);
        return null;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(148145);
      return null;
    }
    int i = 0;
    while (i < localObject.length)
    {
      String[] arrayOfString = localObject[i].getName().split("_|\\.");
      if ((arrayOfString.length > 1) && (paramString.equals(arrayOfString[0])))
      {
        paramString = localObject[i];
        AppMethodBeat.o(148145);
        return paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(148145);
    return null;
  }
  
  private String a(String paramString, File paramFile)
  {
    AppMethodBeat.i(148144);
    if (paramFile == null)
    {
      AppMethodBeat.o(148144);
      return "0";
    }
    paramFile = paramFile.getName().split("_|\\.");
    if ((paramFile.length > 1) && (paramString.equals(paramFile[0])))
    {
      paramString = paramFile[1];
      AppMethodBeat.o(148144);
      return paramString;
    }
    AppMethodBeat.o(148144);
    return "0";
  }
  
  private String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148143);
    if ((this.b == null) || (this.b.z() == null))
    {
      AppMethodBeat.o(148143);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.z());
    localStringBuilder.append("&citycode=".concat(String.valueOf(paramString1)));
    localStringBuilder.append("&version=".concat(String.valueOf(paramString2)));
    paramString1 = localStringBuilder.toString();
    AppMethodBeat.o(148143);
    return paramString1;
  }
  
  private void a(List<Integer> paramList)
  {
    AppMethodBeat.i(148141);
    if (this.c == null)
    {
      AppMethodBeat.o(148141);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool = b(paramList);
    if ((!bool) && (System.currentTimeMillis() - this.a < 300000L))
    {
      AppMethodBeat.o(148141);
      return;
    }
    int i = 0;
    this.g = paramList;
    int j = paramList.size() - 1;
    int n;
    String str1;
    Object localObject;
    String str2;
    int k;
    if (j >= 0)
    {
      n = ((Integer)paramList.get(j)).intValue();
      str1 = Integer.toString(n);
      localObject = a(str1);
      str2 = a(str1, (File)localObject);
      if ((localObject != null) && (System.currentTimeMillis() - ((File)localObject).lastModified() < 300000L)) {
        k = 0;
      }
    }
    try
    {
      m = Integer.parseInt(str2);
      k = m;
    }
    catch (Exception localException1)
    {
      int m;
      label155:
      break label155;
    }
    localArrayList.add(new BlockRouteCityData(n, k));
    for (;;)
    {
      j -= 1;
      break;
      byte[] arrayOfByte = this.c.a(a(str1, str2));
      if ((arrayOfByte != null) && (arrayOfByte.length >= 10)) {
        if (arrayOfByte[4] == 0) {
          k = 0;
        }
      }
      try
      {
        m = Integer.parseInt(str2);
        k = m;
      }
      catch (Exception localException2)
      {
        label232:
        break label232;
      }
      localArrayList.add(new BlockRouteCityData(n, k));
      ((File)localObject).setLastModified(System.currentTimeMillis());
      continue;
      localObject = new byte[4];
      System.arraycopy(arrayOfByte, 0, localObject, 0, 4);
      k = (int)a((byte[])localObject);
      System.arraycopy(arrayOfByte, 5, localObject, 0, 4);
      m = (int)a((byte[])localObject);
      if (a(k, m, arrayOfByte))
      {
        b(str1, str2);
        localArrayList.add(new BlockRouteCityData(k, m));
        i = 1;
      }
      else
      {
        k = 0;
      }
      try
      {
        m = Integer.parseInt(str2);
        k = m;
      }
      catch (Exception localException3)
      {
        label365:
        break label365;
      }
      localArrayList.add(new BlockRouteCityData(n, k));
    }
    if ((bool) || (i != 0))
    {
      this.b.a(localArrayList);
      this.b.w();
    }
    this.a = System.currentTimeMillis();
    AppMethodBeat.o(148141);
  }
  
  /* Error */
  private boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 202
    //   2: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: ifnull +10 -> 16
    //   9: aload_3
    //   10: arraylength
    //   11: bipush 10
    //   13: if_icmpge +10 -> 23
    //   16: ldc 202
    //   18: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_0
    //   24: invokespecial 54	com/tencent/tencentmap/mapsdk/maps/a/hz:g	()Ljava/io/File;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnonnull +10 -> 41
    //   34: ldc 202
    //   36: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: iconst_0
    //   40: ireturn
    //   41: new 59	java/io/File
    //   44: dup
    //   45: new 92	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   52: aload 4
    //   54: invokevirtual 205	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 209	java/io/File:separator	Ljava/lang/String;
    //   63: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: iload_1
    //   68: invokestatic 148	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   71: iload_2
    //   72: invokestatic 148	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   75: invokespecial 211	com/tencent/tencentmap/mapsdk/maps/a/hz:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   78: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokespecial 214	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: astore 7
    //   89: aload 7
    //   91: invokevirtual 218	java/io/File:exists	()Z
    //   94: ifeq +16 -> 110
    //   97: aload 7
    //   99: invokevirtual 221	java/io/File:delete	()Z
    //   102: ifne +8 -> 110
    //   105: aload 7
    //   107: invokevirtual 224	java/io/File:deleteOnExit	()V
    //   110: aload 7
    //   112: invokevirtual 227	java/io/File:createNewFile	()Z
    //   115: pop
    //   116: aconst_null
    //   117: astore 5
    //   119: aconst_null
    //   120: astore 6
    //   122: aconst_null
    //   123: astore 4
    //   125: aload_3
    //   126: bipush 10
    //   128: aload_3
    //   129: arraylength
    //   130: bipush 10
    //   132: isub
    //   133: invokestatic 233	com/tencent/map/lib/util/ZipUtil:inflate	([BII)[B
    //   136: astore 8
    //   138: aload 8
    //   140: ifnonnull +18 -> 158
    //   143: ldc 202
    //   145: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_3
    //   151: ldc 202
    //   153: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_0
    //   157: ireturn
    //   158: new 235	java/io/FileOutputStream
    //   161: dup
    //   162: aload 7
    //   164: invokespecial 238	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: astore_3
    //   168: aload_3
    //   169: aload 8
    //   171: invokevirtual 242	java/io/FileOutputStream:write	([B)V
    //   174: aload_3
    //   175: invokevirtual 245	java/io/FileOutputStream:flush	()V
    //   178: aload_3
    //   179: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   182: ldc 202
    //   184: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_3
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: aload_3
    //   197: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   200: ldc 202
    //   202: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_3
    //   208: aload 4
    //   210: astore_3
    //   211: aload_3
    //   212: ifnull +7 -> 219
    //   215: aload_3
    //   216: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   219: ldc 202
    //   221: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_3
    //   227: aload 5
    //   229: astore_3
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   238: ldc 202
    //   240: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_3
    //   246: aload 6
    //   248: astore 4
    //   250: aload 4
    //   252: ifnull +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 248	java/io/FileOutputStream:close	()V
    //   260: ldc 202
    //   262: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload_3
    //   266: athrow
    //   267: astore_3
    //   268: goto -86 -> 182
    //   271: astore_3
    //   272: goto -72 -> 200
    //   275: astore_3
    //   276: goto -57 -> 219
    //   279: astore_3
    //   280: goto -42 -> 238
    //   283: astore 4
    //   285: goto -25 -> 260
    //   288: astore 5
    //   290: aload_3
    //   291: astore 4
    //   293: aload 5
    //   295: astore_3
    //   296: goto -46 -> 250
    //   299: astore 4
    //   301: goto -71 -> 230
    //   304: astore 4
    //   306: goto -95 -> 211
    //   309: astore 4
    //   311: goto -119 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	this	hz
    //   0	314	1	paramInt1	int
    //   0	314	2	paramInt2	int
    //   0	314	3	paramArrayOfByte	byte[]
    //   27	229	4	localObject1	Object
    //   283	1	4	localIOException1	java.io.IOException
    //   291	1	4	arrayOfByte1	byte[]
    //   299	1	4	localException	Exception
    //   304	1	4	localIOException2	java.io.IOException
    //   309	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   117	111	5	localObject2	Object
    //   288	6	5	localObject3	Object
    //   120	127	6	localObject4	Object
    //   87	76	7	localFile	File
    //   136	34	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   110	116	150	java/io/IOException
    //   125	138	189	java/io/FileNotFoundException
    //   158	168	189	java/io/FileNotFoundException
    //   125	138	207	java/io/IOException
    //   158	168	207	java/io/IOException
    //   125	138	226	java/lang/Exception
    //   158	168	226	java/lang/Exception
    //   125	138	245	finally
    //   158	168	245	finally
    //   178	182	267	java/io/IOException
    //   196	200	271	java/io/IOException
    //   215	219	275	java/io/IOException
    //   234	238	279	java/io/IOException
    //   255	260	283	java/io/IOException
    //   168	178	288	finally
    //   168	178	299	java/lang/Exception
    //   168	178	304	java/io/IOException
    //   168	178	309	java/io/FileNotFoundException
  }
  
  private void b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148148);
    File localFile = g();
    if (localFile == null)
    {
      AppMethodBeat.o(148148);
      return;
    }
    paramString1 = new File(localFile.getAbsolutePath() + File.separator + c(paramString1, paramString2));
    if ((paramString1.exists()) && (!paramString1.delete())) {
      paramString1.deleteOnExit();
    }
    AppMethodBeat.o(148148);
  }
  
  private boolean b(List<Integer> paramList)
  {
    AppMethodBeat.i(148142);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(148142);
      return false;
    }
    if (this.g == null)
    {
      AppMethodBeat.o(148142);
      return true;
    }
    int i = 0;
    while (i < paramList.size())
    {
      if (!this.g.contains(paramList.get(i)))
      {
        AppMethodBeat.o(148142);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(148142);
    return false;
  }
  
  private String c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148149);
    paramString1 = paramString1 + "_" + paramString2 + ".kml";
    AppMethodBeat.o(148149);
    return paramString1;
  }
  
  private void f()
  {
    AppMethodBeat.i(148140);
    if ((this.b == null) || (this.b.a() == null) || (this.b.a().y() == null) || (this.b.a().m() < 11))
    {
      AppMethodBeat.o(148140);
      return;
    }
    Object localObject = this.b.a();
    localObject = this.b.a(((ii)localObject).y(), ((ii)localObject).m());
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      AppMethodBeat.o(148140);
      return;
    }
    a((List)localObject);
    AppMethodBeat.o(148140);
  }
  
  private File g()
  {
    AppMethodBeat.i(148146);
    if ((this.b == null) || (this.b.C() == null))
    {
      AppMethodBeat.o(148146);
      return null;
    }
    Object localObject = this.b.C().e();
    if (localObject == null)
    {
      AppMethodBeat.o(148146);
      return null;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).mkdirs();
      AppMethodBeat.o(148146);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(148146);
    }
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(148134);
    if (this.b == null)
    {
      AppMethodBeat.o(148134);
      return;
    }
    this.b.b(paramBoolean);
    this.d = paramBoolean;
    if (paramBoolean) {}
    try
    {
      start();
      label41:
      this.b.w();
      AppMethodBeat.o(148134);
      return;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    AppMethodBeat.i(148135);
    try
    {
      notify();
      return;
    }
    finally
    {
      AppMethodBeat.o(148135);
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(148136);
    this.e = false;
    try
    {
      notify();
      return;
    }
    finally
    {
      AppMethodBeat.o(148136);
    }
  }
  
  public void d()
  {
    AppMethodBeat.i(148137);
    this.e = true;
    try
    {
      notify();
      return;
    }
    finally
    {
      AppMethodBeat.o(148137);
    }
  }
  
  public void e()
  {
    AppMethodBeat.i(148138);
    this.f = true;
    this.e = true;
    this.d = false;
    try
    {
      notify();
      interrupt();
      AppMethodBeat.o(148138);
      return;
    }
    finally
    {
      AppMethodBeat.o(148138);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 311
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 313	java/lang/Thread:run	()V
    //   10: aload_0
    //   11: getfield 32	com/tencent/tencentmap/mapsdk/maps/a/hz:f	Z
    //   14: ifne +56 -> 70
    //   17: aload_0
    //   18: getfield 36	com/tencent/tencentmap/mapsdk/maps/a/hz:e	Z
    //   21: ifne +14 -> 35
    //   24: aload_0
    //   25: getfield 34	com/tencent/tencentmap/mapsdk/maps/a/hz:d	Z
    //   28: ifeq +7 -> 35
    //   31: aload_0
    //   32: invokespecial 315	com/tencent/tencentmap/mapsdk/maps/a/hz:f	()V
    //   35: aload_0
    //   36: monitorenter
    //   37: aload_0
    //   38: ldc2_w 127
    //   41: invokevirtual 319	java/lang/Object:wait	(J)V
    //   44: aload_0
    //   45: monitorexit
    //   46: goto -36 -> 10
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: ldc_w 311
    //   55: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_1
    //   59: athrow
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: ldc_w 311
    //   66: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: ldc_w 311
    //   73: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	hz
    //   49	10	1	localObject	Object
    //   60	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   37	44	49	finally
    //   44	46	49	finally
    //   50	52	49	finally
    //   61	63	49	finally
    //   37	44	60	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hz
 * JD-Core Version:    0.7.0.1
 */