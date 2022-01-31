package com.tencent.tencentmap.mapsdk.a;

final class ti$1
  extends Thread
{
  ti$1(ti paramti, String paramString1, String paramString2) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 30	java/lang/Thread:run	()V
    //   4: new 32	java/net/URL
    //   7: dup
    //   8: aload_0
    //   9: getfield 19	com/tencent/tencentmap/mapsdk/a/ti$1:a	Ljava/lang/String;
    //   12: invokespecial 35	java/net/URL:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 39	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: checkcast 41	java/net/HttpURLConnection
    //   21: astore_1
    //   22: aload_1
    //   23: sipush 3000
    //   26: invokevirtual 45	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   29: aload_1
    //   30: invokevirtual 49	java/net/HttpURLConnection:getResponseCode	()I
    //   33: sipush 200
    //   36: if_icmpne +70 -> 106
    //   39: aload_1
    //   40: invokevirtual 53	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   43: invokestatic 59	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +15 -> 63
    //   51: invokestatic 62	com/tencent/tencentmap/mapsdk/a/ti:c	()Ljava/util/concurrent/ConcurrentHashMap;
    //   54: aload_0
    //   55: getfield 21	com/tencent/tencentmap/mapsdk/a/ti$1:b	Ljava/lang/String;
    //   58: aload_2
    //   59: invokevirtual 68	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload_0
    //   64: getfield 17	com/tencent/tencentmap/mapsdk/a/ti$1:c	Lcom/tencent/tencentmap/mapsdk/a/ti;
    //   67: invokestatic 71	com/tencent/tencentmap/mapsdk/a/ti:a	(Lcom/tencent/tencentmap/mapsdk/a/ti;)Ljava/lang/ref/WeakReference;
    //   70: invokevirtual 77	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   73: ifnull +20 -> 93
    //   76: aload_0
    //   77: getfield 17	com/tencent/tencentmap/mapsdk/a/ti$1:c	Lcom/tencent/tencentmap/mapsdk/a/ti;
    //   80: invokestatic 71	com/tencent/tencentmap/mapsdk/a/ti:a	(Lcom/tencent/tencentmap/mapsdk/a/ti;)Ljava/lang/ref/WeakReference;
    //   83: invokevirtual 77	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   86: checkcast 79	com/tencent/tencentmap/mapsdk/a/tn
    //   89: aload_2
    //   90: invokevirtual 82	com/tencent/tencentmap/mapsdk/a/tn:b	(Landroid/graphics/Bitmap;)V
    //   93: aload_0
    //   94: getfield 17	com/tencent/tencentmap/mapsdk/a/ti$1:c	Lcom/tencent/tencentmap/mapsdk/a/ti;
    //   97: aload_0
    //   98: getfield 21	com/tencent/tencentmap/mapsdk/a/ti$1:b	Ljava/lang/String;
    //   101: aload_2
    //   102: invokestatic 85	com/tencent/tencentmap/mapsdk/a/ti:a	(Lcom/tencent/tencentmap/mapsdk/a/ti;Ljava/lang/String;Landroid/graphics/Bitmap;)Z
    //   105: pop
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   114: return
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull -5 -> 114
    //   122: aload_1
    //   123: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   126: return
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 88	java/net/HttpURLConnection:disconnect	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aload_1
    //   142: astore_3
    //   143: aload_2
    //   144: astore_1
    //   145: aload_3
    //   146: astore_2
    //   147: goto -17 -> 130
    //   150: astore_2
    //   151: goto -33 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	1
    //   21	90	1	localHttpURLConnection	java.net.HttpURLConnection
    //   115	1	1	localThrowable1	java.lang.Throwable
    //   117	6	1	localObject1	java.lang.Object
    //   127	15	1	localObject2	java.lang.Object
    //   144	1	1	localObject3	java.lang.Object
    //   46	89	2	localBitmap	android.graphics.Bitmap
    //   140	4	2	localObject4	java.lang.Object
    //   146	1	2	localObject5	java.lang.Object
    //   150	1	2	localThrowable2	java.lang.Throwable
    //   142	4	3	localObject6	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   4	22	115	java/lang/Throwable
    //   4	22	127	finally
    //   22	47	140	finally
    //   51	63	140	finally
    //   63	93	140	finally
    //   93	106	140	finally
    //   22	47	150	java/lang/Throwable
    //   51	63	150	java/lang/Throwable
    //   63	93	150	java/lang/Throwable
    //   93	106	150	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ti.1
 * JD-Core Version:    0.7.0.1
 */