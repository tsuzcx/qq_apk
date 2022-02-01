package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.WxQbarNative;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  public static float IIp;
  private static b IIu;
  public Object Brg;
  public Map IIq;
  public Object IIr;
  public Rect IIt;
  public ExecutorService IIv;
  public long IIw;
  public a IIx;
  public boolean IIy;
  public int IIz;
  public volatile boolean jvb;
  public Rect kXj;
  
  static
  {
    AppMethodBeat.i(118326);
    IIu = new b();
    IIp = 1.15F;
    AppMethodBeat.o(118326);
  }
  
  public b()
  {
    AppMethodBeat.i(118323);
    this.IIq = new HashMap();
    this.Brg = new Object();
    this.IIr = new Object();
    this.IIv = Executors.newSingleThreadExecutor();
    this.IIt = new Rect();
    this.kXj = new Rect();
    AppMethodBeat.o(118323);
  }
  
  public static b fCu()
  {
    return IIu;
  }
  
  public final void release()
  {
    AppMethodBeat.i(118324);
    Log.i("MicroMsg.BankCardDetectQueue", "release");
    long l = this.IIw;
    synchronized (this.Brg)
    {
      if (this.IIw == l)
      {
        this.IIw = 0L;
        this.IIz = 0;
        this.IIx = null;
        this.IIq.clear();
      }
    }
    synchronized (this.IIr)
    {
      if (this.jvb) {
        WxQbarNative.focusedEngineRelease();
      }
      this.jvb = false;
      AppMethodBeat.o(118324);
      return;
      localObject2 = finally;
      AppMethodBeat.o(118324);
      throw localObject2;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, Bundle paramBundle);
    
    public abstract void as(long paramLong1, long paramLong2);
  }
  
  public final class b
    implements Runnable
  {
    private byte[] IIA;
    private Point IIB;
    private long fwK;
    private int wxE;
    
    public b(long paramLong)
    {
      this.fwK = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(118322);
      Object localObject2;
      synchronized (b.a(b.this))
      {
        b.a(b.this, true);
        if (this.fwK == b.b(b.this)) {
          if (!b.c(b.this).isEmpty())
          {
            localObject2 = (byte[])b.c(b.this).get("param_preview_data");
            this.IIA = Arrays.copyOf((byte[])localObject2, localObject2.length);
            this.IIB = new Point((Point)b.c(b.this).get("param_camera_resolution"));
            this.wxE = ((Integer)b.c(b.this).get("param_camera_rotation")).intValue();
            b.c(b.this).clear();
            if (b.d(b.this) != null) {
              b.d(b.this).as(b.b(b.this), 10L);
            }
          }
        }
      }
      synchronized (b.e(b.this))
      {
        localObject2 = new byte[b.f(b.this).width() * b.f(b.this).height() * 3 / 2];
        int i = WxQbarNative.QIPUtilYUVCrop((byte[])localObject2, this.IIA, this.IIB.x, this.IIB.y, b.f(b.this).left, b.f(b.this).top, b.f(b.this).width(), b.f(b.this).height());
        b.g(b.this);
        Log.i("MicroMsg.BankCardDetectQueue", "yuv crop ret %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          boolean bool;
          Object localObject5;
          if (WxQbarNative.focusedEngineProcess((byte[])localObject2) == 1)
          {
            bool = true;
            Log.d("MicroMsg.BankCardDetectQueue", "isBest %s", new Object[] { Boolean.valueOf(bool) });
            if (!bool) {
              break label630;
            }
            localObject2 = new YuvImage(this.IIA, 17, this.IIB.x, this.IIB.y, null);
            localObject5 = new ByteArrayOutputStream();
            ((YuvImage)localObject2).compressToJpeg(b.f(b.this), 80, (OutputStream)localObject5);
            if (this.wxE % 180 == 0) {
              break label612;
            }
          }
          label612:
          for (float f = 448.0F / b.f(b.this).height();; f = 448.0F / b.f(b.this).width())
          {
            localObject2 = BitmapUtil.rotateAndScale(BitmapUtil.decodeByteArray(((ByteArrayOutputStream)localObject5).toByteArray()), this.wxE, f, f);
            if (localObject2 == null) {
              break label630;
            }
            localObject5 = new Bundle();
            ((Bundle)localObject5).putParcelable("param_card_bitmap", (Parcelable)localObject2);
            if (b.d(b.this) != null) {
              b.d(b.this).a(this.fwK, (Bundle)localObject5);
            }
            b.a(b.this, false);
            AppMethodBeat.o(118322);
            return;
            if (b.d(b.this) != null) {
              b.d(b.this).as(b.b(b.this), 0L);
            }
            b.a(b.this, false);
            AppMethodBeat.o(118322);
            return;
            b.a(b.this, false);
            AppMethodBeat.o(118322);
            return;
            localObject3 = finally;
            AppMethodBeat.o(118322);
            throw localObject3;
            bool = false;
            break;
          }
        }
        label630:
        b.a(b.this, false);
        b.h(b.this);
        AppMethodBeat.o(118322);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.b
 * JD-Core Version:    0.7.0.1
 */