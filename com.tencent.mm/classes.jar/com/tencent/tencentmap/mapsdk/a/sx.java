package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class sx
{
  private String a;
  private sx.b b;
  
  public sx(Context paramContext, a parama)
  {
    String str = ub.a(paramContext);
    paramContext.getPackageName();
    paramContext = new StringBuilder(256);
    paramContext.append("https://confinfo.map.qq.com/confinfo?apikey=");
    paramContext.append(str);
    paramContext.append("&type=2");
    paramContext.append("&pf=Android_2D");
    paramContext.append("&uk=");
    paramContext.append(ub.a());
    this.a = paramContext.toString();
    this.b = new sx.b(parama);
  }
  
  public static double a(ry paramry1, ry paramry2)
  {
    double d4 = paramry1.c();
    double d3 = paramry1.b();
    double d2 = paramry2.c();
    double d1 = paramry2.b();
    double d5 = d4 * 0.01745329251994329D;
    double d6 = d3 * 0.01745329251994329D;
    d3 = d2 * 0.01745329251994329D;
    d4 = d1 * 0.01745329251994329D;
    d1 = Math.sin(d5);
    d2 = Math.sin(d6);
    d5 = Math.cos(d5);
    d6 = Math.cos(d6);
    double d7 = Math.sin(d3);
    double d8 = Math.sin(d4);
    d3 = Math.cos(d3);
    d4 = Math.cos(d4);
    paramry1 = new double[3];
    paramry2 = new double[3];
    paramry1[0] = (d5 * d6);
    paramry1[1] = (d6 * d1);
    paramry1[2] = d2;
    paramry2[0] = (d4 * d3);
    paramry2[1] = (d4 * d7);
    paramry2[2] = d8;
    return Math.asin(Math.sqrt((paramry1[0] - paramry2[0]) * (paramry1[0] - paramry2[0]) + (paramry1[1] - paramry2[1]) * (paramry1[1] - paramry2[1]) + (paramry1[2] - paramry2[2]) * (paramry1[2] - paramry2[2])) / 2.0D) * 12742001.579854401D;
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt + 4 > paramArrayOfByte.length)) {
      throw new IllegalArgumentException("Four bytes are required for an integer.");
    }
    return paramArrayOfByte[(paramInt + 0)] & 0xFF | paramArrayOfByte[(paramInt + 1)] << 8 & 0xFF00 | paramArrayOfByte[(paramInt + 2)] << 16 & 0xFF0000 | paramArrayOfByte[(paramInt + 3)] << 24 & 0xFF000000;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static ry a(sw paramsw)
  {
    float f = (float)(paramsw.b() * 180.0D / 20037508.34D);
    return new ry((float)(57.295779513082323D * (2.0D * Math.atan(Math.exp((float)(paramsw.a() * 180.0D / 20037508.34D) * 3.141592653589793D / 180.0D)) - 1.570796326794897D)), f);
  }
  
  public static sw a(PointF paramPointF1, sw paramsw, PointF paramPointF2, su paramsu)
  {
    float f1 = paramPointF1.x;
    float f2 = paramPointF2.x;
    float f3 = paramPointF1.y;
    float f4 = paramPointF2.y;
    return new sw(paramsw.b() + (f1 - f2) * paramsu.d(), paramsw.a() - (f3 - f4) * paramsu.d());
  }
  
  public static sw a(ry paramry)
  {
    if (paramry == null) {
      return null;
    }
    double d = paramry.b();
    return new sw(paramry.c() * 20037508.34D / 180.0D, Math.log(Math.tan((d + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
  }
  
  public static sy a(float paramFloat, Point paramPoint)
  {
    tc localtc = new tc();
    localtc.a(paramFloat);
    localtc.a(paramPoint);
    return localtc;
  }
  
  public static sy a(ru paramru)
  {
    ta localta = new ta();
    localta.a(paramru);
    return localta;
  }
  
  public static sy a(rz paramrz, int paramInt1, int paramInt2, int paramInt3)
  {
    sz localsz = new sz();
    localsz.a(paramrz);
    localsz.c(paramInt3);
    localsz.a(paramInt1);
    localsz.b(paramInt2);
    return localsz;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Stack localStack = new Stack();
    localStack.push(paramString);
    while (!localStack.isEmpty())
    {
      File localFile = new File((String)localStack.peek());
      if (localFile.exists())
      {
        if (localFile.isDirectory())
        {
          paramString = localFile.listFiles();
          if ((paramString == null) || (paramString.length == 0))
          {
            localFile.delete();
            localStack.pop();
          }
          else
          {
            int j = paramString.length;
            int i = 0;
            label96:
            if (i < j)
            {
              localFile = paramString[i];
              if (!localFile.isDirectory()) {
                break label131;
              }
              localStack.push(localFile.getAbsolutePath());
            }
            for (;;)
            {
              i += 1;
              break label96;
              break;
              label131:
              localFile.delete();
            }
          }
        }
        else
        {
          localFile.delete();
          localStack.pop();
        }
      }
      else {
        localStack.pop();
      }
    }
    return true;
  }
  
  /* Error */
  public static byte[] a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 254	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 255	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: astore_2
    //   10: sipush 4096
    //   13: newarray byte
    //   15: astore 4
    //   17: aload_3
    //   18: astore_2
    //   19: aload_0
    //   20: aload 4
    //   22: iconst_0
    //   23: sipush 4096
    //   26: invokevirtual 261	java/io/InputStream:read	([BII)I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_m1
    //   32: if_icmpeq +47 -> 79
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: aload 4
    //   40: iconst_0
    //   41: iload_1
    //   42: invokevirtual 265	java/io/ByteArrayOutputStream:write	([BII)V
    //   45: goto -28 -> 17
    //   48: astore_2
    //   49: aload_3
    //   50: astore_0
    //   51: aload_2
    //   52: astore_3
    //   53: aload_0
    //   54: astore_2
    //   55: new 30	java/lang/StringBuilder
    //   58: dup
    //   59: ldc_w 267
    //   62: invokespecial 268	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_3
    //   66: invokevirtual 269	java/io/IOException:toString	()Ljava/lang/String;
    //   69: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_0
    //   74: invokestatic 271	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   77: aconst_null
    //   78: areturn
    //   79: aload_3
    //   80: astore_2
    //   81: aload_3
    //   82: invokevirtual 274	java/io/ByteArrayOutputStream:flush	()V
    //   85: aload_3
    //   86: astore_2
    //   87: aload_3
    //   88: invokevirtual 278	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   91: astore_0
    //   92: aload_3
    //   93: invokestatic 271	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   96: aload_0
    //   97: areturn
    //   98: astore_0
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_2
    //   102: invokestatic 271	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   105: aload_0
    //   106: athrow
    //   107: astore_0
    //   108: goto -7 -> 101
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_0
    //   114: goto -61 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramInputStream	java.io.InputStream
    //   29	13	1	i	int
    //   9	28	2	localObject1	Object
    //   48	4	2	localIOException1	IOException
    //   54	48	2	localObject2	Object
    //   7	86	3	localObject3	Object
    //   111	1	3	localIOException2	IOException
    //   15	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   10	17	48	java/io/IOException
    //   19	30	48	java/io/IOException
    //   37	45	48	java/io/IOException
    //   81	85	48	java/io/IOException
    //   87	92	48	java/io/IOException
    //   0	8	98	finally
    //   10	17	107	finally
    //   19	30	107	finally
    //   37	45	107	finally
    //   55	73	107	finally
    //   81	85	107	finally
    //   87	92	107	finally
    //   0	8	111	java/io/IOException
  }
  
  public static String b(Context paramContext)
  {
    int j = 6;
    paramContext = a(paramContext);
    int i;
    if ((paramContext == null) || (!paramContext.isAvailable())) {
      i = 0;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "";
        int k = paramContext.getType();
        if (k == 1)
        {
          i = 5;
        }
        else
        {
          i = j;
          if (k == 0)
          {
            paramContext = paramContext.getExtraInfo();
            i = j;
            if (paramContext != null)
            {
              i = j;
              if (paramContext.length() != 0) {
                if (paramContext.equalsIgnoreCase("cmwap"))
                {
                  i = 1;
                }
                else
                {
                  if (!paramContext.equalsIgnoreCase("3gwap"))
                  {
                    if (paramContext.equalsIgnoreCase("uniwap"))
                    {
                      i = 2;
                      continue;
                    }
                    if (paramContext.equalsIgnoreCase("ctwap"))
                    {
                      i = 4;
                      continue;
                    }
                  }
                  i = 3;
                }
              }
            }
          }
        }
        break;
      }
    }
    return "wifi";
    return "3gwap";
    return "uniwap";
    return "cmwap";
    return "ctwap";
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isDirectory())) {
        return true;
      }
      if ((paramString.exists()) && (paramString.isFile())) {
        paramString.delete();
      }
      boolean bool = paramString.mkdirs();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public final void a()
  {
    this.b.execute(new String[] { this.a });
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sx
 * JD-Core Version:    0.7.0.1
 */