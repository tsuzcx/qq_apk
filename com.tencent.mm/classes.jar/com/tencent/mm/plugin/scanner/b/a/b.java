package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
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
  public static float yBl;
  private static b yBr;
  public volatile boolean gff;
  public Rect hpa;
  public Map yBm;
  public Object yBn;
  public Object yBo;
  public Rect yBq;
  public ExecutorService yBs;
  public long yBt;
  public a yBu;
  public boolean yBv;
  public int yBw;
  
  static
  {
    AppMethodBeat.i(118326);
    yBr = new b();
    yBl = 1.15F;
    AppMethodBeat.o(118326);
  }
  
  public b()
  {
    AppMethodBeat.i(118323);
    this.yBm = new HashMap();
    this.yBn = new Object();
    this.yBo = new Object();
    this.yBs = Executors.newSingleThreadExecutor();
    this.yBq = new Rect();
    this.hpa = new Rect();
    AppMethodBeat.o(118323);
  }
  
  public static b dOd()
  {
    return yBr;
  }
  
  public final void release()
  {
    AppMethodBeat.i(118324);
    ae.i("MicroMsg.BankCardDetectQueue", "release");
    long l = this.yBt;
    synchronized (this.yBn)
    {
      if (this.yBt == l)
      {
        this.yBt = 0L;
        this.yBw = 0;
        this.yBu = null;
        this.yBm.clear();
      }
    }
    synchronized (this.yBo)
    {
      if (this.gff) {
        WxQbarNative.focusedEngineRelease();
      }
      this.gff = false;
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
    
    public abstract void af(long paramLong1, long paramLong2);
  }
  
  public final class b
    implements Runnable
  {
    private long dmK;
    private int rql;
    private byte[] yBx;
    private Point yBy;
    
    public b(long paramLong)
    {
      this.dmK = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(118322);
      Object localObject2;
      synchronized (b.a(b.this))
      {
        b.a(b.this, true);
        if (this.dmK == b.b(b.this)) {
          if (!b.c(b.this).isEmpty())
          {
            localObject2 = (byte[])b.c(b.this).get("param_preview_data");
            this.yBx = Arrays.copyOf((byte[])localObject2, localObject2.length);
            this.yBy = new Point((Point)b.c(b.this).get("param_camera_resolution"));
            this.rql = ((Integer)b.c(b.this).get("param_camera_rotation")).intValue();
            b.c(b.this).clear();
            if (b.d(b.this) != null) {
              b.d(b.this).af(b.b(b.this), 10L);
            }
          }
        }
      }
      synchronized (b.e(b.this))
      {
        localObject2 = new byte[b.f(b.this).width() * b.f(b.this).height() * 3 / 2];
        int i = WxQbarNative.QIPUtilYUVCrop((byte[])localObject2, this.yBx, this.yBy.x, this.yBy.y, b.f(b.this).left, b.f(b.this).top, b.f(b.this).width(), b.f(b.this).height());
        b.g(b.this);
        ae.i("MicroMsg.BankCardDetectQueue", "yuv crop ret %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          boolean bool;
          Object localObject5;
          if (WxQbarNative.focusedEngineProcess((byte[])localObject2) == 1)
          {
            bool = true;
            ae.d("MicroMsg.BankCardDetectQueue", "isBest %s", new Object[] { Boolean.valueOf(bool) });
            if (!bool) {
              break label630;
            }
            localObject2 = new YuvImage(this.yBx, 17, this.yBy.x, this.yBy.y, null);
            localObject5 = new ByteArrayOutputStream();
            ((YuvImage)localObject2).compressToJpeg(b.f(b.this), 80, (OutputStream)localObject5);
            if (this.rql % 180 == 0) {
              break label612;
            }
          }
          label612:
          for (float f = 448.0F / b.f(b.this).height();; f = 448.0F / b.f(b.this).width())
          {
            localObject2 = h.b(h.cu(((ByteArrayOutputStream)localObject5).toByteArray()), this.rql, f, f);
            if (localObject2 == null) {
              break label630;
            }
            localObject5 = new Bundle();
            ((Bundle)localObject5).putParcelable("param_card_bitmap", (Parcelable)localObject2);
            if (b.d(b.this) != null) {
              b.d(b.this).a(this.dmK, (Bundle)localObject5);
            }
            b.a(b.this, false);
            AppMethodBeat.o(118322);
            return;
            if (b.d(b.this) != null) {
              b.d(b.this).af(b.b(b.this), 0L);
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