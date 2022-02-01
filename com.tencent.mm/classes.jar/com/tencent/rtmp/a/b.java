package com.tencent.rtmp.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b
  implements a
{
  private final BitmapFactory.Options a;
  private HandlerThread b;
  private Handler c;
  private List<c> d;
  private Map<String, BitmapRegionDecoder> e;
  
  public b()
  {
    AppMethodBeat.i(13624);
    this.a = new BitmapFactory.Options();
    this.d = new ArrayList();
    this.d = Collections.synchronizedList(this.d);
    this.e = new HashMap();
    this.e = Collections.synchronizedMap(this.e);
    AppMethodBeat.o(13624);
  }
  
  private c a(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(13628);
    for (;;)
    {
      int i = (paramInt2 - paramInt1) / 2 + paramInt1;
      c localc;
      if ((((c)this.d.get(i)).a <= paramFloat) && (((c)this.d.get(i)).b > paramFloat))
      {
        localc = (c)this.d.get(i);
        AppMethodBeat.o(13628);
        return localc;
      }
      if (paramInt1 >= paramInt2)
      {
        localc = (c)this.d.get(paramInt1);
        AppMethodBeat.o(13628);
        return localc;
      }
      if (paramFloat >= ((c)this.d.get(i)).b)
      {
        paramInt1 = i + 1;
      }
      else
      {
        if (paramFloat >= ((c)this.d.get(i)).a) {
          break;
        }
        paramInt2 = i - 1;
      }
    }
    AppMethodBeat.o(13628);
    return null;
  }
  
  private InputStream a(String paramString)
  {
    AppMethodBeat.i(13631);
    paramString = new URL(paramString).openConnection();
    paramString.connect();
    paramString.getInputStream();
    paramString.setConnectTimeout(15000);
    paramString.setReadTimeout(15000);
    paramString = paramString.getInputStream();
    AppMethodBeat.o(13631);
    return paramString;
  }
  
  private void a()
  {
    AppMethodBeat.i(13629);
    if (this.b == null)
    {
      this.b = new HandlerThread("SuperVodThumbnailsWorkThread");
      this.b.start();
      this.c = new Handler(this.b.getLooper());
    }
    AppMethodBeat.o(13629);
  }
  
  private void b()
  {
    AppMethodBeat.i(13630);
    if (this.c != null)
    {
      TXCLog.i("TXImageSprite", " remove all tasks!");
      this.c.removeCallbacksAndMessages(null);
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(13623);
          if (b.a(b.this) != null) {
            b.a(b.this).clear();
          }
          if (b.b(b.this) != null)
          {
            Iterator localIterator = b.b(b.this).values().iterator();
            while (localIterator.hasNext())
            {
              BitmapRegionDecoder localBitmapRegionDecoder = (BitmapRegionDecoder)localIterator.next();
              if (localBitmapRegionDecoder != null) {
                localBitmapRegionDecoder.recycle();
              }
            }
            b.b(b.this).clear();
          }
          AppMethodBeat.o(13623);
        }
      });
    }
    AppMethodBeat.o(13630);
  }
  
  public Bitmap getThumbnail(float paramFloat)
  {
    AppMethodBeat.i(13626);
    if (this.d.size() == 0)
    {
      AppMethodBeat.o(13626);
      return null;
    }
    Object localObject1 = a(0, this.d.size() - 1, paramFloat);
    if (localObject1 == null)
    {
      AppMethodBeat.o(13626);
      return null;
    }
    Object localObject2 = ((c)localObject1).d;
    localObject2 = (BitmapRegionDecoder)this.e.get(localObject2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(13626);
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = ((c)localObject1).e;
    localRect.top = ((c)localObject1).f;
    localRect.right = (((c)localObject1).e + ((c)localObject1).g);
    int i = ((c)localObject1).f;
    localRect.bottom = (((c)localObject1).h + i);
    localObject1 = ((BitmapRegionDecoder)localObject2).decodeRegion(localRect, this.a);
    AppMethodBeat.o(13626);
    return localObject1;
  }
  
  public void release()
  {
    AppMethodBeat.i(13627);
    b();
    if ((this.b != null) && (this.c != null))
    {
      if (TXCBuild.VersionInt() < 18) {
        break label57;
      }
      this.b.quitSafely();
    }
    for (;;)
    {
      this.c = null;
      this.b = null;
      AppMethodBeat.o(13627);
      return;
      label57:
      this.b.quit();
    }
  }
  
  public void setVTTUrlAndImageUrls(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(13625);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
      AppMethodBeat.o(13625);
      return;
    }
    b();
    a();
    this.c.post(new a(this, paramString));
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        this.c.post(new b(this, paramString, str));
      }
    }
    AppMethodBeat.o(13625);
  }
  
  static class a
    implements Runnable
  {
    private WeakReference<b> a;
    private String b;
    
    public a(b paramb, String paramString)
    {
      AppMethodBeat.i(13618);
      this.a = new WeakReference(paramb);
      this.b = paramString;
      AppMethodBeat.o(13618);
    }
    
    private float a(String paramString)
    {
      float f1 = 0.0F;
      AppMethodBeat.i(13619);
      paramString = paramString.split(":");
      Object localObject;
      String str;
      if (paramString.length == 3)
      {
        localObject = paramString[0];
        str = paramString[1];
        paramString = paramString[2];
      }
      for (;;)
      {
        if ((localObject == null) || (str != null)) {
          f1 = 0.0F + Float.valueOf(str).floatValue() * 60.0F;
        }
        float f2 = f1;
        if (paramString != null) {
          f2 = f1 + Float.valueOf(paramString).floatValue();
        }
        AppMethodBeat.o(13619);
        return f2;
        if (paramString.length == 2)
        {
          str = paramString[0];
          paramString = paramString[1];
          localObject = null;
        }
        else if (paramString.length == 1)
        {
          paramString = paramString[0];
          str = null;
          localObject = null;
        }
        else
        {
          paramString = null;
          str = null;
          localObject = null;
        }
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: sipush 13620
      //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 31	com/tencent/rtmp/a/b$a:a	Ljava/lang/ref/WeakReference;
      //   10: invokevirtual 64	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   13: checkcast 8	com/tencent/rtmp/a/b
      //   16: astore 4
      //   18: aload 4
      //   20: aload_0
      //   21: getfield 33	com/tencent/rtmp/a/b$a:b	Ljava/lang/String;
      //   24: invokestatic 67	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;Ljava/lang/String;)Ljava/io/InputStream;
      //   27: astore_2
      //   28: aload_2
      //   29: ifnonnull +10 -> 39
      //   32: sipush 13620
      //   35: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   38: return
      //   39: new 69	java/io/BufferedReader
      //   42: dup
      //   43: new 71	java/io/InputStreamReader
      //   46: dup
      //   47: aload_2
      //   48: invokespecial 74	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   51: invokespecial 77	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   54: astore_3
      //   55: aload_3
      //   56: astore_2
      //   57: aload_3
      //   58: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   61: astore 5
      //   63: aload 5
      //   65: ifnull +25 -> 90
      //   68: aload_3
      //   69: astore_2
      //   70: aload 5
      //   72: invokevirtual 85	java/lang/String:length	()I
      //   75: ifeq +15 -> 90
      //   78: aload_3
      //   79: astore_2
      //   80: aload 5
      //   82: ldc 87
      //   84: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   87: ifne +43 -> 130
      //   90: aload_3
      //   91: astore_2
      //   92: ldc 93
      //   94: ldc 95
      //   96: invokestatic 101	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   99: aload 4
      //   101: ifnull +10 -> 111
      //   104: aload_3
      //   105: astore_2
      //   106: aload 4
      //   108: invokestatic 105	com/tencent/rtmp/a/b:c	(Lcom/tencent/rtmp/a/b;)V
      //   111: aload_3
      //   112: invokevirtual 108	java/io/BufferedReader:close	()V
      //   115: sipush 13620
      //   118: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   121: return
      //   122: astore_2
      //   123: sipush 13620
      //   126: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   129: return
      //   130: aload_3
      //   131: astore_2
      //   132: aload_3
      //   133: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   136: astore 5
      //   138: aload 5
      //   140: ifnull +279 -> 419
      //   143: aload_3
      //   144: astore_2
      //   145: aload 5
      //   147: ldc 110
      //   149: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   152: ifeq +267 -> 419
      //   155: aload_3
      //   156: astore_2
      //   157: aload 5
      //   159: ldc 112
      //   161: invokevirtual 46	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   164: astore 7
      //   166: aload_3
      //   167: astore_2
      //   168: aload 7
      //   170: arraylength
      //   171: iconst_2
      //   172: if_icmpne +247 -> 419
      //   175: aload_3
      //   176: astore_2
      //   177: aload_3
      //   178: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   181: astore 8
      //   183: aload_3
      //   184: astore_2
      //   185: new 114	com/tencent/rtmp/a/c
      //   188: dup
      //   189: invokespecial 115	com/tencent/rtmp/a/c:<init>	()V
      //   192: astore 6
      //   194: aload_3
      //   195: astore_2
      //   196: aload 6
      //   198: aload_0
      //   199: aload 7
      //   201: iconst_0
      //   202: aaload
      //   203: invokespecial 117	com/tencent/rtmp/a/b$a:a	(Ljava/lang/String;)F
      //   206: putfield 120	com/tencent/rtmp/a/c:a	F
      //   209: aload_3
      //   210: astore_2
      //   211: aload 6
      //   213: aload_0
      //   214: aload 7
      //   216: iconst_1
      //   217: aaload
      //   218: invokespecial 117	com/tencent/rtmp/a/b$a:a	(Ljava/lang/String;)F
      //   221: putfield 122	com/tencent/rtmp/a/c:b	F
      //   224: aload_3
      //   225: astore_2
      //   226: aload 6
      //   228: aload 8
      //   230: putfield 124	com/tencent/rtmp/a/c:c	Ljava/lang/String;
      //   233: aload_3
      //   234: astore_2
      //   235: aload 8
      //   237: ldc 126
      //   239: invokevirtual 130	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   242: istore_1
      //   243: iload_1
      //   244: iconst_m1
      //   245: if_icmpeq +17 -> 262
      //   248: aload_3
      //   249: astore_2
      //   250: aload 6
      //   252: aload 8
      //   254: iconst_0
      //   255: iload_1
      //   256: invokevirtual 134	java/lang/String:substring	(II)Ljava/lang/String;
      //   259: putfield 137	com/tencent/rtmp/a/c:d	Ljava/lang/String;
      //   262: aload_3
      //   263: astore_2
      //   264: aload 8
      //   266: ldc 139
      //   268: invokevirtual 130	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   271: istore_1
      //   272: iload_1
      //   273: iconst_m1
      //   274: if_icmpeq +115 -> 389
      //   277: aload_3
      //   278: astore_2
      //   279: iload_1
      //   280: iconst_1
      //   281: iadd
      //   282: aload 8
      //   284: invokevirtual 85	java/lang/String:length	()I
      //   287: if_icmpge +102 -> 389
      //   290: aload_3
      //   291: astore_2
      //   292: aload 8
      //   294: iload_1
      //   295: iconst_1
      //   296: iadd
      //   297: aload 8
      //   299: invokevirtual 85	java/lang/String:length	()I
      //   302: invokevirtual 134	java/lang/String:substring	(II)Ljava/lang/String;
      //   305: ldc 141
      //   307: invokevirtual 46	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   310: astore 7
      //   312: aload_3
      //   313: astore_2
      //   314: aload 7
      //   316: arraylength
      //   317: iconst_4
      //   318: if_icmpne +71 -> 389
      //   321: aload_3
      //   322: astore_2
      //   323: aload 6
      //   325: aload 7
      //   327: iconst_0
      //   328: aaload
      //   329: invokestatic 146	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   332: invokevirtual 149	java/lang/Integer:intValue	()I
      //   335: putfield 152	com/tencent/rtmp/a/c:e	I
      //   338: aload_3
      //   339: astore_2
      //   340: aload 6
      //   342: aload 7
      //   344: iconst_1
      //   345: aaload
      //   346: invokestatic 146	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   349: invokevirtual 149	java/lang/Integer:intValue	()I
      //   352: putfield 155	com/tencent/rtmp/a/c:f	I
      //   355: aload_3
      //   356: astore_2
      //   357: aload 6
      //   359: aload 7
      //   361: iconst_2
      //   362: aaload
      //   363: invokestatic 146	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   366: invokevirtual 149	java/lang/Integer:intValue	()I
      //   369: putfield 158	com/tencent/rtmp/a/c:g	I
      //   372: aload_3
      //   373: astore_2
      //   374: aload 6
      //   376: aload 7
      //   378: iconst_3
      //   379: aaload
      //   380: invokestatic 146	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   383: invokevirtual 149	java/lang/Integer:intValue	()I
      //   386: putfield 161	com/tencent/rtmp/a/c:h	I
      //   389: aload 4
      //   391: ifnull +28 -> 419
      //   394: aload_3
      //   395: astore_2
      //   396: aload 4
      //   398: invokestatic 164	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;)Ljava/util/List;
      //   401: ifnull +18 -> 419
      //   404: aload_3
      //   405: astore_2
      //   406: aload 4
      //   408: invokestatic 164	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;)Ljava/util/List;
      //   411: aload 6
      //   413: invokeinterface 170 2 0
      //   418: pop
      //   419: aload 5
      //   421: ifnonnull -291 -> 130
      //   424: aload_3
      //   425: invokevirtual 108	java/io/BufferedReader:close	()V
      //   428: sipush 13620
      //   431: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   434: return
      //   435: astore_2
      //   436: sipush 13620
      //   439: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   442: return
      //   443: astore 4
      //   445: aconst_null
      //   446: astore_3
      //   447: aload_3
      //   448: astore_2
      //   449: ldc 93
      //   451: ldc 172
      //   453: aload 4
      //   455: invokestatic 175	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   458: aload_3
      //   459: ifnull +41 -> 500
      //   462: aload_3
      //   463: invokevirtual 108	java/io/BufferedReader:close	()V
      //   466: sipush 13620
      //   469: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   472: return
      //   473: astore_2
      //   474: sipush 13620
      //   477: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   480: return
      //   481: astore_3
      //   482: aconst_null
      //   483: astore_2
      //   484: aload_2
      //   485: ifnull +7 -> 492
      //   488: aload_2
      //   489: invokevirtual 108	java/io/BufferedReader:close	()V
      //   492: sipush 13620
      //   495: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   498: aload_3
      //   499: athrow
      //   500: sipush 13620
      //   503: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   506: return
      //   507: astore_2
      //   508: goto -16 -> 492
      //   511: astore_3
      //   512: goto -28 -> 484
      //   515: astore 4
      //   517: goto -70 -> 447
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	520	0	this	a
      //   242	55	1	i	int
      //   27	79	2	localObject1	Object
      //   122	1	2	localIOException1	IOException
      //   131	275	2	localObject2	Object
      //   435	1	2	localIOException2	IOException
      //   448	1	2	localObject3	Object
      //   473	1	2	localIOException3	IOException
      //   483	6	2	localObject4	Object
      //   507	1	2	localIOException4	IOException
      //   54	409	3	localBufferedReader	java.io.BufferedReader
      //   481	18	3	localObject5	Object
      //   511	1	3	localObject6	Object
      //   16	391	4	localb	b
      //   443	11	4	localIOException5	IOException
      //   515	1	4	localIOException6	IOException
      //   61	359	5	str1	String
      //   192	220	6	localc	c
      //   164	213	7	arrayOfString	String[]
      //   181	117	8	str2	String
      // Exception table:
      //   from	to	target	type
      //   111	115	122	java/io/IOException
      //   424	428	435	java/io/IOException
      //   18	28	443	java/io/IOException
      //   39	55	443	java/io/IOException
      //   462	466	473	java/io/IOException
      //   18	28	481	finally
      //   39	55	481	finally
      //   488	492	507	java/io/IOException
      //   57	63	511	finally
      //   70	78	511	finally
      //   80	90	511	finally
      //   92	99	511	finally
      //   106	111	511	finally
      //   132	138	511	finally
      //   145	155	511	finally
      //   157	166	511	finally
      //   168	175	511	finally
      //   177	183	511	finally
      //   185	194	511	finally
      //   196	209	511	finally
      //   211	224	511	finally
      //   226	233	511	finally
      //   235	243	511	finally
      //   250	262	511	finally
      //   264	272	511	finally
      //   279	290	511	finally
      //   292	312	511	finally
      //   314	321	511	finally
      //   323	338	511	finally
      //   340	355	511	finally
      //   357	372	511	finally
      //   374	389	511	finally
      //   396	404	511	finally
      //   406	419	511	finally
      //   449	458	511	finally
      //   57	63	515	java/io/IOException
      //   70	78	515	java/io/IOException
      //   80	90	515	java/io/IOException
      //   92	99	515	java/io/IOException
      //   106	111	515	java/io/IOException
      //   132	138	515	java/io/IOException
      //   145	155	515	java/io/IOException
      //   157	166	515	java/io/IOException
      //   168	175	515	java/io/IOException
      //   177	183	515	java/io/IOException
      //   185	194	515	java/io/IOException
      //   196	209	515	java/io/IOException
      //   211	224	515	java/io/IOException
      //   226	233	515	java/io/IOException
      //   235	243	515	java/io/IOException
      //   250	262	515	java/io/IOException
      //   264	272	515	java/io/IOException
      //   279	290	515	java/io/IOException
      //   292	312	515	java/io/IOException
      //   314	321	515	java/io/IOException
      //   323	338	515	java/io/IOException
      //   340	355	515	java/io/IOException
      //   357	372	515	java/io/IOException
      //   374	389	515	java/io/IOException
      //   396	404	515	java/io/IOException
      //   406	419	515	java/io/IOException
    }
  }
  
  static class b
    implements Runnable
  {
    private WeakReference<b> a;
    private String b;
    private String c;
    
    public b(b paramb, String paramString1, String paramString2)
    {
      AppMethodBeat.i(13621);
      this.a = new WeakReference(paramb);
      this.b = paramString1;
      this.c = paramString2;
      AppMethodBeat.o(13621);
    }
    
    public void run()
    {
      AppMethodBeat.i(13622);
      b localb = (b)this.a.get();
      if ((this.a != null) && (localb != null))
      {
        localObject3 = null;
        Object localObject1 = null;
        try
        {
          InputStream localInputStream = b.a(localb, this.c);
          localObject1 = localInputStream;
          localObject3 = localInputStream;
          int i = this.c.lastIndexOf("/");
          if (i != -1)
          {
            localObject1 = localInputStream;
            localObject3 = localInputStream;
            if (i + 1 < this.c.length())
            {
              localObject1 = localInputStream;
              localObject3 = localInputStream;
              String str = this.c.substring(i + 1, this.c.length());
              localObject1 = localInputStream;
              localObject3 = localInputStream;
              if (b.b(localb) != null)
              {
                localObject1 = localInputStream;
                localObject3 = localInputStream;
                b.b(localb).put(str, BitmapRegionDecoder.newInstance(localInputStream, true));
              }
            }
          }
          if (localInputStream != null) {
            try
            {
              localInputStream.close();
              AppMethodBeat.o(13622);
              return;
            }
            catch (IOException localIOException1)
            {
              AppMethodBeat.o(13622);
              return;
            }
          }
          try
          {
            localObject3.close();
            AppMethodBeat.o(13622);
            throw localObject2;
            AppMethodBeat.o(13622);
            return;
          }
          catch (IOException localIOException3)
          {
            break label219;
          }
        }
        catch (IOException localIOException4)
        {
          localObject3 = localIOException1;
          TXCLog.e("TXImageSprite", "load bitmap from network failed.", localIOException4);
          if (localIOException1 != null) {
            try
            {
              localIOException1.close();
              AppMethodBeat.o(13622);
              return;
            }
            catch (IOException localIOException2)
            {
              AppMethodBeat.o(13622);
              return;
            }
          }
        }
        finally
        {
          if (localObject3 == null) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.a.b
 * JD-Core Version:    0.7.0.1
 */