package com.tencent.tencentmap.mapsdk.a;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class n
{
  private WeakReference<m> a;
  private String b;
  
  private List<lf> a(ld paramld)
  {
    try
    {
      Object localObject = lq.a(this.b);
      localObject = "https://vectorsdk.map.qq.com" + (String)localObject;
      paramld = qs.a().a((String)localObject, "androidsdk", paramld.toByteArray("UTF-8"));
      if ((paramld == null) || (paramld.a == null))
      {
        a(1, null);
        return null;
      }
      paramld = new nk(paramld.a);
      paramld.a("UTF-8");
      localObject = new lg();
      ((lg)localObject).readFrom(paramld);
      if (((lg)localObject).a == 0) {
        return ((lg)localObject).b;
      }
      a(2, null);
      return null;
    }
    catch (Exception paramld) {}
    return null;
  }
  
  private void a(int paramInt, lf paramlf)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((m)this.a.get()).a(paramInt, paramlf);
    }
  }
  
  /* Error */
  private void a(lf paramlf, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 106	com/tencent/tencentmap/mapsdk/a/lf:b	I
    //   4: ifne +163 -> 167
    //   7: aload_1
    //   8: getfield 109	com/tencent/tencentmap/mapsdk/a/lf:d	I
    //   11: iconst_1
    //   12: if_icmpne +148 -> 160
    //   15: new 111	java/net/URL
    //   18: dup
    //   19: aload_1
    //   20: getfield 114	com/tencent/tencentmap/mapsdk/a/lf:e	Ljava/lang/String;
    //   23: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   26: invokevirtual 119	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   29: checkcast 121	java/net/HttpURLConnection
    //   32: astore 4
    //   34: aload 4
    //   36: invokevirtual 125	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   39: astore_3
    //   40: new 127	java/io/File
    //   43: dup
    //   44: new 26	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 131	java/io/File:separator	Ljava/lang/String;
    //   58: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: getfield 133	com/tencent/tencentmap/mapsdk/a/lf:a	Ljava/lang/String;
    //   65: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 138	java/io/File:exists	()Z
    //   79: ifne +16 -> 95
    //   82: aload_2
    //   83: invokevirtual 142	java/io/File:getParentFile	()Ljava/io/File;
    //   86: invokevirtual 145	java/io/File:mkdirs	()Z
    //   89: pop
    //   90: aload_2
    //   91: invokevirtual 148	java/io/File:createNewFile	()Z
    //   94: pop
    //   95: new 150	java/io/FileOutputStream
    //   98: dup
    //   99: aload_2
    //   100: iconst_0
    //   101: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   104: astore_2
    //   105: aload_3
    //   106: aload_2
    //   107: invokestatic 158	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   110: pop2
    //   111: aload 4
    //   113: invokevirtual 161	java/net/HttpURLConnection:disconnect	()V
    //   116: aload_0
    //   117: iconst_0
    //   118: aload_1
    //   119: invokespecial 65	com/tencent/tencentmap/mapsdk/a/n:a	(ILcom/tencent/tencentmap/mapsdk/a/lf;)V
    //   122: aload_3
    //   123: invokestatic 164	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   126: aload_2
    //   127: invokestatic 164	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   130: return
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_3
    //   137: invokestatic 164	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   140: aload_1
    //   141: invokestatic 164	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   144: return
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_3
    //   150: aload_3
    //   151: invokestatic 164	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   154: aload_2
    //   155: invokestatic 164	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   158: aload_1
    //   159: athrow
    //   160: aload_0
    //   161: iconst_0
    //   162: aload_1
    //   163: invokespecial 65	com/tencent/tencentmap/mapsdk/a/n:a	(ILcom/tencent/tencentmap/mapsdk/a/lf;)V
    //   166: return
    //   167: aload_0
    //   168: iconst_2
    //   169: aconst_null
    //   170: invokespecial 65	com/tencent/tencentmap/mapsdk/a/n:a	(ILcom/tencent/tencentmap/mapsdk/a/lf;)V
    //   173: return
    //   174: astore_1
    //   175: aconst_null
    //   176: astore_2
    //   177: goto -27 -> 150
    //   180: astore_1
    //   181: goto -31 -> 150
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_1
    //   187: goto -51 -> 136
    //   190: astore_1
    //   191: aload_2
    //   192: astore_1
    //   193: goto -57 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	n
    //   0	196	1	paramlf	lf
    //   0	196	2	paramString	String
    //   39	112	3	localInputStream	java.io.InputStream
    //   32	80	4	localHttpURLConnection	java.net.HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   15	40	131	java/lang/Exception
    //   15	40	145	finally
    //   40	95	174	finally
    //   95	105	174	finally
    //   105	122	180	finally
    //   40	95	184	java/lang/Exception
    //   95	105	184	java/lang/Exception
    //   105	122	190	java/lang/Exception
  }
  
  public void a(String paramString1, ld paramld, m paramm, String paramString2)
  {
    if ((paramld == null) || (paramm == null)) {}
    for (;;)
    {
      return;
      this.a = new WeakReference(paramm);
      this.b = paramString2;
      paramld = a(paramld);
      if ((paramld != null) && (paramld.size() != 0))
      {
        paramld = paramld.iterator();
        while (paramld.hasNext()) {
          a((lf)paramld.next(), paramString1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.n
 * JD-Core Version:    0.7.0.1
 */