package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class iz
  extends Thread
  implements ja
{
  private long a;
  private jh b;
  private kt c;
  private boolean d;
  private boolean e;
  private boolean f;
  private List<Integer> g;
  
  public iz(jh paramjh, kt paramkt)
  {
    this.b = paramjh;
    this.c = paramkt;
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
    Object localObject = g();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject == null) || (localObject.length == 0)) {
        return null;
      }
    }
    catch (Exception paramString)
    {
      return null;
    }
    int i = 0;
    while (i < localObject.length)
    {
      String[] arrayOfString = localObject[i].getName().split("_|\\.");
      if ((arrayOfString.length > 1) && (paramString.equals(arrayOfString[0]))) {
        return localObject[i];
      }
      i += 1;
    }
    return null;
  }
  
  private String a(String paramString, File paramFile)
  {
    if (paramFile == null) {
      return "0";
    }
    paramFile = paramFile.getName().split("_|\\.");
    if ((paramFile.length > 1) && (paramString.equals(paramFile[0]))) {
      return paramFile[1];
    }
    return "0";
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((this.b == null) || (this.b.C() == null)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b.C());
    localStringBuilder.append("&citycode=" + paramString1);
    localStringBuilder.append("&version=" + paramString2);
    return localStringBuilder.toString();
  }
  
  private void a(List<Integer> paramList)
  {
    if (this.c == null) {}
    ArrayList localArrayList;
    boolean bool;
    do
    {
      return;
      localArrayList = new ArrayList();
      bool = b(paramList);
    } while ((!bool) && (System.currentTimeMillis() - this.a < 300000L));
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
      label139:
      break label139;
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
        label218:
        break label218;
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
        label351:
        break label351;
      }
      localArrayList.add(new BlockRouteCityData(n, k));
    }
    if ((bool) || (i != 0))
    {
      this.b.a(localArrayList);
      this.b.x();
    }
    this.a = System.currentTimeMillis();
  }
  
  /* Error */
  private boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_3
    //   1: ifnull +10 -> 11
    //   4: aload_3
    //   5: arraylength
    //   6: bipush 10
    //   8: if_icmpge +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: invokespecial 47	com/tencent/tencentmap/mapsdk/a/iz:g	()Ljava/io/File;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnull -10 -> 11
    //   24: new 49	java/io/File
    //   27: dup
    //   28: new 80	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   35: aload 4
    //   37: invokevirtual 186	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   40: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: getstatic 190	java/io/File:separator	Ljava/lang/String;
    //   46: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: iload_1
    //   51: invokestatic 130	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   54: iload_2
    //   55: invokestatic 130	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   58: invokespecial 192	com/tencent/tencentmap/mapsdk/a/iz:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore 7
    //   72: aload 7
    //   74: invokevirtual 197	java/io/File:exists	()Z
    //   77: ifeq +16 -> 93
    //   80: aload 7
    //   82: invokevirtual 200	java/io/File:delete	()Z
    //   85: ifne +8 -> 93
    //   88: aload 7
    //   90: invokevirtual 203	java/io/File:deleteOnExit	()V
    //   93: aload 7
    //   95: invokevirtual 206	java/io/File:createNewFile	()Z
    //   98: pop
    //   99: aconst_null
    //   100: astore 5
    //   102: aconst_null
    //   103: astore 6
    //   105: aconst_null
    //   106: astore 4
    //   108: aload_3
    //   109: bipush 10
    //   111: aload_3
    //   112: arraylength
    //   113: bipush 10
    //   115: isub
    //   116: invokestatic 212	com/tencent/map/lib/util/ZipUtil:inflate	([BII)[B
    //   119: astore 8
    //   121: aload 8
    //   123: ifnull -112 -> 11
    //   126: new 214	java/io/FileOutputStream
    //   129: dup
    //   130: aload 7
    //   132: invokespecial 217	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   135: astore_3
    //   136: aload_3
    //   137: aload 8
    //   139: invokevirtual 221	java/io/FileOutputStream:write	([B)V
    //   142: aload_3
    //   143: invokevirtual 224	java/io/FileOutputStream:flush	()V
    //   146: aload_3
    //   147: invokevirtual 227	java/io/FileOutputStream:close	()V
    //   150: iconst_1
    //   151: ireturn
    //   152: astore_3
    //   153: aconst_null
    //   154: astore_3
    //   155: aload_3
    //   156: ifnull -145 -> 11
    //   159: aload_3
    //   160: invokevirtual 227	java/io/FileOutputStream:close	()V
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_3
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_3
    //   169: aload 4
    //   171: astore_3
    //   172: aload_3
    //   173: ifnull -162 -> 11
    //   176: aload_3
    //   177: invokevirtual 227	java/io/FileOutputStream:close	()V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_3
    //   183: iconst_0
    //   184: ireturn
    //   185: astore_3
    //   186: aload 5
    //   188: astore_3
    //   189: aload_3
    //   190: ifnull -179 -> 11
    //   193: aload_3
    //   194: invokevirtual 227	java/io/FileOutputStream:close	()V
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_3
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_3
    //   203: aload 6
    //   205: astore 4
    //   207: aload 4
    //   209: ifnull +8 -> 217
    //   212: aload 4
    //   214: invokevirtual 227	java/io/FileOutputStream:close	()V
    //   217: aload_3
    //   218: athrow
    //   219: astore_3
    //   220: iconst_0
    //   221: ireturn
    //   222: astore_3
    //   223: goto -73 -> 150
    //   226: astore 4
    //   228: goto -11 -> 217
    //   231: astore 5
    //   233: aload_3
    //   234: astore 4
    //   236: aload 5
    //   238: astore_3
    //   239: goto -32 -> 207
    //   242: astore 4
    //   244: goto -55 -> 189
    //   247: astore 4
    //   249: goto -77 -> 172
    //   252: astore 4
    //   254: goto -99 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	iz
    //   0	257	1	paramInt1	int
    //   0	257	2	paramInt2	int
    //   0	257	3	paramArrayOfByte	byte[]
    //   17	196	4	localObject1	Object
    //   226	1	4	localIOException1	java.io.IOException
    //   234	1	4	arrayOfByte1	byte[]
    //   242	1	4	localException	Exception
    //   247	1	4	localIOException2	java.io.IOException
    //   252	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   100	87	5	localObject2	Object
    //   231	6	5	localObject3	Object
    //   103	101	6	localObject4	Object
    //   70	61	7	localFile	File
    //   119	19	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   108	121	152	java/io/FileNotFoundException
    //   126	136	152	java/io/FileNotFoundException
    //   159	163	165	java/io/IOException
    //   108	121	168	java/io/IOException
    //   126	136	168	java/io/IOException
    //   176	180	182	java/io/IOException
    //   108	121	185	java/lang/Exception
    //   126	136	185	java/lang/Exception
    //   193	197	199	java/io/IOException
    //   108	121	202	finally
    //   126	136	202	finally
    //   93	99	219	java/io/IOException
    //   146	150	222	java/io/IOException
    //   212	217	226	java/io/IOException
    //   136	146	231	finally
    //   136	146	242	java/lang/Exception
    //   136	146	247	java/io/IOException
    //   136	146	252	java/io/FileNotFoundException
  }
  
  private void b(String paramString1, String paramString2)
  {
    File localFile = g();
    if (localFile == null) {}
    do
    {
      return;
      paramString1 = new File(localFile.getAbsolutePath() + File.separator + c(paramString1, paramString2));
    } while ((!paramString1.exists()) || (paramString1.delete()));
    paramString1.deleteOnExit();
  }
  
  private boolean b(List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return false;
      if (this.g == null) {
        return true;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (!this.g.contains(paramList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private String c(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2 + ".kml";
  }
  
  private void f()
  {
    if ((this.b == null) || (this.b.a() == null) || (this.b.a().y() == null) || (this.b.a().m() < 11)) {}
    Object localObject;
    do
    {
      return;
      localObject = this.b.a();
      localObject = this.b.a(((jf)localObject).y(), ((jf)localObject).m());
    } while ((localObject == null) || (((List)localObject).size() == 0));
    a((List)localObject);
  }
  
  private File g()
  {
    if ((this.b == null) || (this.b.G() == null)) {}
    do
    {
      return null;
      localObject = this.b.G().e();
    } while (localObject == null);
    Object localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).mkdirs();
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.b.c(paramBoolean);
    this.d = paramBoolean;
    if (paramBoolean) {}
    try
    {
      start();
      label29:
      this.b.x();
      return;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public void c()
  {
    this.e = false;
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public void d()
  {
    this.e = true;
    try
    {
      notify();
      return;
    }
    finally {}
  }
  
  public void e()
  {
    this.f = true;
    this.e = true;
    this.d = false;
    try
    {
      notify();
      interrupt();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 281	java/lang/Thread:run	()V
    //   4: aload_0
    //   5: getfield 32	com/tencent/tencentmap/mapsdk/a/iz:f	Z
    //   8: ifne +43 -> 51
    //   11: aload_0
    //   12: getfield 36	com/tencent/tencentmap/mapsdk/a/iz:e	Z
    //   15: ifne +14 -> 29
    //   18: aload_0
    //   19: getfield 34	com/tencent/tencentmap/mapsdk/a/iz:d	Z
    //   22: ifeq +7 -> 29
    //   25: aload_0
    //   26: invokespecial 283	com/tencent/tencentmap/mapsdk/a/iz:f	()V
    //   29: aload_0
    //   30: monitorenter
    //   31: aload_0
    //   32: ldc2_w 109
    //   35: invokevirtual 287	java/lang/Object:wait	(J)V
    //   38: aload_0
    //   39: monitorexit
    //   40: goto -36 -> 4
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	iz
    //   43	4	1	localObject	Object
    //   48	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   31	38	43	finally
    //   38	40	43	finally
    //   44	46	43	finally
    //   49	51	43	finally
    //   31	38	48	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.iz
 * JD-Core Version:    0.7.0.1
 */