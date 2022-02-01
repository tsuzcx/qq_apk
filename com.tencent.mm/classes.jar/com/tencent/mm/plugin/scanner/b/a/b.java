package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
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
  public static float vNg;
  private static b vNm;
  public volatile boolean fFP;
  public Rect gtE;
  public Map vNh;
  public Object vNi;
  public Object vNj;
  public Rect vNl;
  public ExecutorService vNn;
  public long vNo;
  public a vNp;
  public boolean vNq;
  public int vNr;
  
  static
  {
    AppMethodBeat.i(118326);
    vNm = new b();
    vNg = 1.15F;
    AppMethodBeat.o(118326);
  }
  
  public b()
  {
    AppMethodBeat.i(118323);
    this.vNh = new HashMap();
    this.vNi = new Object();
    this.vNj = new Object();
    this.vNn = Executors.newSingleThreadExecutor();
    this.vNl = new Rect();
    this.gtE = new Rect();
    AppMethodBeat.o(118323);
  }
  
  public static b dll()
  {
    return vNm;
  }
  
  public final void release()
  {
    AppMethodBeat.i(118324);
    ad.i("MicroMsg.BankCardDetectQueue", "release");
    long l = this.vNo;
    synchronized (this.vNi)
    {
      if (this.vNo == l)
      {
        this.vNo = 0L;
        this.vNr = 0;
        this.vNp = null;
        this.vNh.clear();
      }
    }
    synchronized (this.vNj)
    {
      if (this.fFP) {
        WxQbarNative.focusedEngineRelease();
      }
      this.fFP = false;
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
    
    public abstract void ag(long paramLong1, long paramLong2);
  }
  
  public final class b
    implements Runnable
  {
    private long dcQ;
    private int pPJ;
    private byte[] vNs;
    private Point vNt;
    
    public b(long paramLong)
    {
      this.dcQ = paramLong;
    }
    
    public final void run()
    {
      AppMethodBeat.i(118322);
      Object localObject2;
      synchronized (b.a(b.this))
      {
        b.a(b.this, true);
        if (this.dcQ == b.b(b.this)) {
          if (!b.c(b.this).isEmpty())
          {
            localObject2 = (byte[])b.c(b.this).get("param_preview_data");
            this.vNs = Arrays.copyOf((byte[])localObject2, localObject2.length);
            this.vNt = new Point((Point)b.c(b.this).get("param_camera_resolution"));
            this.pPJ = ((Integer)b.c(b.this).get("param_camera_rotation")).intValue();
            b.c(b.this).clear();
            if (b.d(b.this) != null) {
              b.d(b.this).ag(b.b(b.this), 10L);
            }
          }
        }
      }
      synchronized (b.e(b.this))
      {
        localObject2 = new byte[b.f(b.this).width() * b.f(b.this).height() * 3 / 2];
        int i = WxQbarNative.QIPUtilYUVCrop((byte[])localObject2, this.vNs, this.vNt.x, this.vNt.y, b.f(b.this).left, b.f(b.this).top, b.f(b.this).width(), b.f(b.this).height());
        b.g(b.this);
        ad.i("MicroMsg.BankCardDetectQueue", "yuv crop ret %d", new Object[] { Integer.valueOf(i) });
        if (i == 0)
        {
          boolean bool;
          Object localObject5;
          if (WxQbarNative.focusedEngineProcess((byte[])localObject2) == 1)
          {
            bool = true;
            ad.d("MicroMsg.BankCardDetectQueue", "isBest %s", new Object[] { Boolean.valueOf(bool) });
            if (!bool) {
              break label630;
            }
            localObject2 = new YuvImage(this.vNs, 17, this.vNt.x, this.vNt.y, null);
            localObject5 = new ByteArrayOutputStream();
            ((YuvImage)localObject2).compressToJpeg(b.f(b.this), 80, (OutputStream)localObject5);
            if (this.pPJ % 180 == 0) {
              break label612;
            }
          }
          label612:
          for (float f = 448.0F / b.f(b.this).height();; f = 448.0F / b.f(b.this).width())
          {
            localObject2 = f.b(f.cl(((ByteArrayOutputStream)localObject5).toByteArray()), this.pPJ, f, f);
            if (localObject2 == null) {
              break label630;
            }
            localObject5 = new Bundle();
            ((Bundle)localObject5).putParcelable("param_card_bitmap", (Parcelable)localObject2);
            if (b.d(b.this) != null) {
              b.d(b.this).a(this.dcQ, (Bundle)localObject5);
            }
            b.a(b.this, false);
            AppMethodBeat.o(118322);
            return;
            if (b.d(b.this) != null) {
              b.d(b.this).ag(b.b(b.this), 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.b
 * JD-Core Version:    0.7.0.1
 */