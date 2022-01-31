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
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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
    AppMethodBeat.i(65979);
    this.a = new BitmapFactory.Options();
    this.d = new ArrayList();
    this.d = Collections.synchronizedList(this.d);
    this.e = new HashMap();
    this.e = Collections.synchronizedMap(this.e);
    AppMethodBeat.o(65979);
  }
  
  private c a(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(65983);
    for (;;)
    {
      int i = (paramInt2 - paramInt1) / 2 + paramInt1;
      c localc;
      if ((((c)this.d.get(i)).a <= paramFloat) && (((c)this.d.get(i)).b > paramFloat))
      {
        localc = (c)this.d.get(i);
        AppMethodBeat.o(65983);
        return localc;
      }
      if (paramInt1 >= paramInt2)
      {
        localc = (c)this.d.get(paramInt1);
        AppMethodBeat.o(65983);
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
    AppMethodBeat.o(65983);
    return null;
  }
  
  private InputStream a(String paramString)
  {
    AppMethodBeat.i(65986);
    paramString = new URL(paramString).openConnection();
    paramString.connect();
    paramString.getInputStream();
    paramString.setConnectTimeout(15000);
    paramString.setReadTimeout(15000);
    paramString = paramString.getInputStream();
    AppMethodBeat.o(65986);
    return paramString;
  }
  
  private void a()
  {
    AppMethodBeat.i(65984);
    if (this.b == null)
    {
      this.b = new HandlerThread("SuperVodThumbnailsWorkThread");
      this.b.start();
      this.c = new Handler(this.b.getLooper());
    }
    AppMethodBeat.o(65984);
  }
  
  private void b()
  {
    AppMethodBeat.i(65985);
    if (this.c != null)
    {
      TXCLog.i("TXImageSprite", " remove all tasks!");
      this.c.removeCallbacksAndMessages(null);
      this.c.post(new b.1(this));
    }
    AppMethodBeat.o(65985);
  }
  
  public Bitmap getThumbnail(float paramFloat)
  {
    AppMethodBeat.i(65981);
    if (this.d.size() == 0)
    {
      AppMethodBeat.o(65981);
      return null;
    }
    Object localObject1 = a(0, this.d.size() - 1, paramFloat);
    if (localObject1 == null)
    {
      AppMethodBeat.o(65981);
      return null;
    }
    Object localObject2 = ((c)localObject1).d;
    localObject2 = (BitmapRegionDecoder)this.e.get(localObject2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(65981);
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = ((c)localObject1).e;
    localRect.top = ((c)localObject1).f;
    localRect.right = (((c)localObject1).e + ((c)localObject1).g);
    int i = ((c)localObject1).f;
    localRect.bottom = (((c)localObject1).h + i);
    localObject1 = ((BitmapRegionDecoder)localObject2).decodeRegion(localRect, this.a);
    AppMethodBeat.o(65981);
    return localObject1;
  }
  
  public void release()
  {
    AppMethodBeat.i(65982);
    b();
    if ((this.b != null) && (this.c != null))
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label55;
      }
      this.b.quitSafely();
    }
    for (;;)
    {
      this.c = null;
      this.b = null;
      AppMethodBeat.o(65982);
      return;
      label55:
      this.b.quit();
    }
  }
  
  public void setVTTUrlAndImageUrls(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(65980);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("TXImageSprite", "setVTTUrlAndImageUrls: vttUrl can't be null!");
      AppMethodBeat.o(65980);
      return;
    }
    b();
    a();
    this.c.post(new b.a(this, paramString));
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        this.c.post(new b.b(this, paramString, str));
      }
    }
    AppMethodBeat.o(65980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.a.b
 * JD-Core Version:    0.7.0.1
 */