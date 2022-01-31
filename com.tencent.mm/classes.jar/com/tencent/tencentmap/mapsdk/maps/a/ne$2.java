package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ne$2
  extends Thread
{
  ne$2(ne paramne, String paramString1, String paramString2) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 31
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 39	java/lang/Thread:run	()V
    //   9: new 41	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: getfield 21	com/tencent/tencentmap/mapsdk/maps/a/ne$2:a	Ljava/lang/String;
    //   17: invokespecial 44	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 48	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 50	java/net/HttpURLConnection
    //   26: astore_1
    //   27: aload_1
    //   28: sipush 3000
    //   31: invokevirtual 53	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   34: aload_1
    //   35: invokevirtual 57	java/net/HttpURLConnection:getResponseCode	()I
    //   38: sipush 200
    //   41: if_icmpne +70 -> 111
    //   44: aload_1
    //   45: invokevirtual 61	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   48: invokestatic 67	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +15 -> 68
    //   56: invokestatic 71	com/tencent/tencentmap/mapsdk/maps/a/ne:m	()Ljava/util/concurrent/ConcurrentHashMap;
    //   59: aload_0
    //   60: getfield 23	com/tencent/tencentmap/mapsdk/maps/a/ne$2:b	Ljava/lang/String;
    //   63: aload_2
    //   64: invokevirtual 77	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: aload_0
    //   69: getfield 19	com/tencent/tencentmap/mapsdk/maps/a/ne$2:c	Lcom/tencent/tencentmap/mapsdk/maps/a/ne;
    //   72: invokestatic 80	com/tencent/tencentmap/mapsdk/maps/a/ne:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/ne;)Landroid/widget/ImageView;
    //   75: ifnull +23 -> 98
    //   78: aload_0
    //   79: getfield 19	com/tencent/tencentmap/mapsdk/maps/a/ne$2:c	Lcom/tencent/tencentmap/mapsdk/maps/a/ne;
    //   82: invokestatic 80	com/tencent/tencentmap/mapsdk/maps/a/ne:b	(Lcom/tencent/tencentmap/mapsdk/maps/a/ne;)Landroid/widget/ImageView;
    //   85: new 11	com/tencent/tencentmap/mapsdk/maps/a/ne$2$1
    //   88: dup
    //   89: aload_0
    //   90: aload_2
    //   91: invokespecial 83	com/tencent/tencentmap/mapsdk/maps/a/ne$2$1:<init>	(Lcom/tencent/tencentmap/mapsdk/maps/a/ne$2;Landroid/graphics/Bitmap;)V
    //   94: invokevirtual 89	android/widget/ImageView:post	(Ljava/lang/Runnable;)Z
    //   97: pop
    //   98: aload_0
    //   99: getfield 19	com/tencent/tencentmap/mapsdk/maps/a/ne$2:c	Lcom/tencent/tencentmap/mapsdk/maps/a/ne;
    //   102: aload_0
    //   103: getfield 23	com/tencent/tencentmap/mapsdk/maps/a/ne$2:b	Ljava/lang/String;
    //   106: aload_2
    //   107: invokestatic 92	com/tencent/tencentmap/mapsdk/maps/a/ne:a	(Lcom/tencent/tencentmap/mapsdk/maps/a/ne;Ljava/lang/String;Landroid/graphics/Bitmap;)Z
    //   110: pop
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   119: invokestatic 99	com/tencent/tencentmap/mapsdk/maps/a/ne:n	()Ljava/util/List;
    //   122: aload_0
    //   123: getfield 23	com/tencent/tencentmap/mapsdk/maps/a/ne$2:b	Ljava/lang/String;
    //   126: invokeinterface 105 2 0
    //   131: pop
    //   132: ldc 31
    //   134: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: return
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_1
    //   141: aload_1
    //   142: ifnull +7 -> 149
    //   145: aload_1
    //   146: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   149: invokestatic 99	com/tencent/tencentmap/mapsdk/maps/a/ne:n	()Ljava/util/List;
    //   152: aload_0
    //   153: getfield 23	com/tencent/tencentmap/mapsdk/maps/a/ne$2:b	Ljava/lang/String;
    //   156: invokeinterface 105 2 0
    //   161: pop
    //   162: ldc 31
    //   164: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: return
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_2
    //   172: ifnull +7 -> 179
    //   175: aload_2
    //   176: invokevirtual 95	java/net/HttpURLConnection:disconnect	()V
    //   179: invokestatic 99	com/tencent/tencentmap/mapsdk/maps/a/ne:n	()Ljava/util/List;
    //   182: aload_0
    //   183: getfield 23	com/tencent/tencentmap/mapsdk/maps/a/ne$2:b	Ljava/lang/String;
    //   186: invokeinterface 105 2 0
    //   191: pop
    //   192: ldc 31
    //   194: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload_1
    //   198: athrow
    //   199: astore_2
    //   200: aload_1
    //   201: astore_3
    //   202: aload_2
    //   203: astore_1
    //   204: aload_3
    //   205: astore_2
    //   206: goto -35 -> 171
    //   209: astore_2
    //   210: goto -69 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	2
    //   26	90	1	localHttpURLConnection	java.net.HttpURLConnection
    //   138	1	1	localThrowable1	java.lang.Throwable
    //   140	6	1	localObject1	Object
    //   168	33	1	localObject2	Object
    //   203	1	1	localObject3	Object
    //   51	125	2	localBitmap	Bitmap
    //   199	4	2	localObject4	Object
    //   205	1	2	localObject5	Object
    //   209	1	2	localThrowable2	java.lang.Throwable
    //   201	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   9	27	138	java/lang/Throwable
    //   9	27	168	finally
    //   27	52	199	finally
    //   56	68	199	finally
    //   68	98	199	finally
    //   98	111	199	finally
    //   27	52	209	java/lang/Throwable
    //   56	68	209	java/lang/Throwable
    //   68	98	209	java/lang/Throwable
    //   98	111	209	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ne.2
 * JD-Core Version:    0.7.0.1
 */