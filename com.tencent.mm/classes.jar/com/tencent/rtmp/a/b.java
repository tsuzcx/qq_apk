package com.tencent.rtmp.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
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
      if (Build.VERSION.SDK_INT < 18) {
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
      //   16: astore_3
      //   17: aload_3
      //   18: aload_0
      //   19: getfield 33	com/tencent/rtmp/a/b$a:b	Ljava/lang/String;
      //   22: invokestatic 67	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;Ljava/lang/String;)Ljava/io/InputStream;
      //   25: astore_2
      //   26: aload_2
      //   27: ifnonnull +10 -> 37
      //   30: sipush 13620
      //   33: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: return
      //   37: new 69	java/io/BufferedReader
      //   40: dup
      //   41: new 71	java/io/InputStreamReader
      //   44: dup
      //   45: aload_2
      //   46: invokespecial 74	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   49: invokespecial 77	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   52: astore_2
      //   53: aload_2
      //   54: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   57: astore 4
      //   59: aload 4
      //   61: ifnull +21 -> 82
      //   64: aload 4
      //   66: invokevirtual 85	java/lang/String:length	()I
      //   69: ifeq +13 -> 82
      //   72: aload 4
      //   74: ldc 87
      //   76: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   79: ifne +37 -> 116
      //   82: ldc 93
      //   84: ldc 95
      //   86: invokestatic 101	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   89: aload_3
      //   90: ifnull +7 -> 97
      //   93: aload_3
      //   94: invokestatic 105	com/tencent/rtmp/a/b:c	(Lcom/tencent/rtmp/a/b;)V
      //   97: aload_2
      //   98: invokevirtual 108	java/io/BufferedReader:close	()V
      //   101: sipush 13620
      //   104: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   107: return
      //   108: astore_2
      //   109: sipush 13620
      //   112: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   115: return
      //   116: aload_2
      //   117: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   120: astore 4
      //   122: aload 4
      //   124: ifnull +236 -> 360
      //   127: aload 4
      //   129: ldc 110
      //   131: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   134: ifeq +226 -> 360
      //   137: aload 4
      //   139: ldc 112
      //   141: invokevirtual 46	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   144: astore 6
      //   146: aload 6
      //   148: arraylength
      //   149: iconst_2
      //   150: if_icmpne +210 -> 360
      //   153: aload_2
      //   154: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   157: astore 7
      //   159: new 114	com/tencent/rtmp/a/c
      //   162: dup
      //   163: invokespecial 115	com/tencent/rtmp/a/c:<init>	()V
      //   166: astore 5
      //   168: aload 5
      //   170: aload_0
      //   171: aload 6
      //   173: iconst_0
      //   174: aaload
      //   175: invokespecial 117	com/tencent/rtmp/a/b$a:a	(Ljava/lang/String;)F
      //   178: putfield 120	com/tencent/rtmp/a/c:a	F
      //   181: aload 5
      //   183: aload_0
      //   184: aload 6
      //   186: iconst_1
      //   187: aaload
      //   188: invokespecial 117	com/tencent/rtmp/a/b$a:a	(Ljava/lang/String;)F
      //   191: putfield 122	com/tencent/rtmp/a/c:b	F
      //   194: aload 5
      //   196: aload 7
      //   198: putfield 124	com/tencent/rtmp/a/c:c	Ljava/lang/String;
      //   201: aload 7
      //   203: ldc 126
      //   205: invokevirtual 130	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   208: istore_1
      //   209: iload_1
      //   210: iconst_m1
      //   211: if_icmpeq +15 -> 226
      //   214: aload 5
      //   216: aload 7
      //   218: iconst_0
      //   219: iload_1
      //   220: invokevirtual 134	java/lang/String:substring	(II)Ljava/lang/String;
      //   223: putfield 137	com/tencent/rtmp/a/c:d	Ljava/lang/String;
      //   226: aload 7
      //   228: ldc 139
      //   230: invokevirtual 130	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   233: istore_1
      //   234: iload_1
      //   235: iconst_m1
      //   236: if_icmpeq +101 -> 337
      //   239: iload_1
      //   240: iconst_1
      //   241: iadd
      //   242: aload 7
      //   244: invokevirtual 85	java/lang/String:length	()I
      //   247: if_icmpge +90 -> 337
      //   250: aload 7
      //   252: iload_1
      //   253: iconst_1
      //   254: iadd
      //   255: aload 7
      //   257: invokevirtual 85	java/lang/String:length	()I
      //   260: invokevirtual 134	java/lang/String:substring	(II)Ljava/lang/String;
      //   263: ldc 141
      //   265: invokevirtual 46	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   268: astore 6
      //   270: aload 6
      //   272: arraylength
      //   273: iconst_4
      //   274: if_icmpne +63 -> 337
      //   277: aload 5
      //   279: aload 6
      //   281: iconst_0
      //   282: aaload
      //   283: invokestatic 146	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   286: invokevirtual 149	java/lang/Integer:intValue	()I
      //   289: putfield 152	com/tencent/rtmp/a/c:e	I
      //   292: aload 5
      //   294: aload 6
      //   296: iconst_1
      //   297: aaload
      //   298: invokestatic 146	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   301: invokevirtual 149	java/lang/Integer:intValue	()I
      //   304: putfield 155	com/tencent/rtmp/a/c:f	I
      //   307: aload 5
      //   309: aload 6
      //   311: iconst_2
      //   312: aaload
      //   313: invokestatic 146	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   316: invokevirtual 149	java/lang/Integer:intValue	()I
      //   319: putfield 158	com/tencent/rtmp/a/c:g	I
      //   322: aload 5
      //   324: aload 6
      //   326: iconst_3
      //   327: aaload
      //   328: invokestatic 146	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   331: invokevirtual 149	java/lang/Integer:intValue	()I
      //   334: putfield 161	com/tencent/rtmp/a/c:h	I
      //   337: aload_3
      //   338: ifnull +22 -> 360
      //   341: aload_3
      //   342: invokestatic 164	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;)Ljava/util/List;
      //   345: ifnull +15 -> 360
      //   348: aload_3
      //   349: invokestatic 164	com/tencent/rtmp/a/b:a	(Lcom/tencent/rtmp/a/b;)Ljava/util/List;
      //   352: aload 5
      //   354: invokeinterface 170 2 0
      //   359: pop
      //   360: aload 4
      //   362: ifnonnull -246 -> 116
      //   365: aload_2
      //   366: invokevirtual 108	java/io/BufferedReader:close	()V
      //   369: sipush 13620
      //   372: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   375: return
      //   376: astore_2
      //   377: sipush 13620
      //   380: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   383: return
      //   384: astore_2
      //   385: aconst_null
      //   386: astore_2
      //   387: aload_2
      //   388: ifnull +41 -> 429
      //   391: aload_2
      //   392: invokevirtual 108	java/io/BufferedReader:close	()V
      //   395: sipush 13620
      //   398: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   401: return
      //   402: astore_2
      //   403: sipush 13620
      //   406: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   409: return
      //   410: astore_3
      //   411: aconst_null
      //   412: astore_2
      //   413: aload_2
      //   414: ifnull +7 -> 421
      //   417: aload_2
      //   418: invokevirtual 108	java/io/BufferedReader:close	()V
      //   421: sipush 13620
      //   424: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   427: aload_3
      //   428: athrow
      //   429: sipush 13620
      //   432: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   435: return
      //   436: astore_2
      //   437: goto -16 -> 421
      //   440: astore_3
      //   441: goto -28 -> 413
      //   444: astore_3
      //   445: goto -58 -> 387
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	448	0	this	a
      //   208	47	1	i	int
      //   25	73	2	localObject1	Object
      //   108	258	2	localIOException1	IOException
      //   376	1	2	localIOException2	IOException
      //   384	1	2	localIOException3	IOException
      //   386	6	2	localObject2	Object
      //   402	1	2	localIOException4	IOException
      //   412	6	2	localObject3	Object
      //   436	1	2	localIOException5	IOException
      //   16	333	3	localb	b
      //   410	18	3	localObject4	Object
      //   440	1	3	localObject5	Object
      //   444	1	3	localIOException6	IOException
      //   57	304	4	str1	String
      //   166	187	5	localc	c
      //   144	181	6	arrayOfString	String[]
      //   157	99	7	str2	String
      // Exception table:
      //   from	to	target	type
      //   97	101	108	java/io/IOException
      //   365	369	376	java/io/IOException
      //   17	26	384	java/io/IOException
      //   37	53	384	java/io/IOException
      //   391	395	402	java/io/IOException
      //   17	26	410	finally
      //   37	53	410	finally
      //   417	421	436	java/io/IOException
      //   53	59	440	finally
      //   64	82	440	finally
      //   82	89	440	finally
      //   93	97	440	finally
      //   116	122	440	finally
      //   127	209	440	finally
      //   214	226	440	finally
      //   226	234	440	finally
      //   239	337	440	finally
      //   341	360	440	finally
      //   53	59	444	java/io/IOException
      //   64	82	444	java/io/IOException
      //   82	89	444	java/io/IOException
      //   93	97	444	java/io/IOException
      //   116	122	444	java/io/IOException
      //   127	209	444	java/io/IOException
      //   214	226	444	java/io/IOException
      //   226	234	444	java/io/IOException
      //   239	337	444	java/io/IOException
      //   341	360	444	java/io/IOException
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
        try
        {
          InputStream localInputStream = b.a(localb, this.c);
          localObject3 = localInputStream;
          try
          {
            int i;
            String str;
            Object localObject1;
            localObject3.close();
            AppMethodBeat.o(13622);
            throw localObject2;
            AppMethodBeat.o(13622);
            return;
          }
          catch (IOException localIOException4)
          {
            break label183;
          }
        }
        catch (IOException localIOException2)
        {
          if (localObject1 != null) {
            try
            {
              localObject1.close();
              AppMethodBeat.o(13622);
              return;
            }
            catch (IOException localIOException3)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.a.b
 * JD-Core Version:    0.7.0.1
 */