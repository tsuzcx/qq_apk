package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> qTb = new HashMap();
  private static Map<String, Integer> qTf = new ConcurrentHashMap();
  String bHM = "";
  private boolean fOd = false;
  boolean fVw = true;
  private ak loX = new ak(Looper.getMainLooper());
  private Surface mSurface;
  int position;
  private int qSC = 0;
  private int qSD = 0;
  String qSE = "";
  int qSF = -1;
  protected int qSH = 41;
  private Bitmap qSI;
  private Bitmap qSJ;
  private Bitmap qSK;
  WeakReference<View> qSL;
  WeakReference<TextView> qSM;
  private long qSN;
  private WeakReference<View> qSO;
  private Animation qSP;
  private Animation qSQ;
  boolean qSZ = true;
  public boolean qTa = false;
  public boolean qTc = false;
  double qTd = -1.0D;
  boolean qTe = false;
  double qTg = -1.0D;
  private boolean qTh = false;
  boolean qTi = false;
  volatile b.h ryn;
  private volatile b ryo;
  volatile b.i ryp;
  private volatile c ryq;
  private b.k ryr;
  private b.j rys;
  private d ryt;
  private b.a ryu;
  b.e ryv;
  b.f ryw;
  b.g ryx;
  
  public b(View paramView)
  {
    this.qSO = new WeakReference(paramView);
    ab.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(0) });
  }
  
  private void Dt(int paramInt)
  {
    com.tencent.mm.modelvideo.o.j(new b.1(this, paramInt), 0L);
  }
  
  public static boolean Zp(String paramString)
  {
    if (bo.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)qTf.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  public abstract void S(Bitmap paramBitmap);
  
  public final void clear()
  {
    ab.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.qSF), Boolean.valueOf(cmA()) });
    kR(true);
    this.qSN = 0L;
    Dt(this.qSF);
    this.qSF = -1;
    this.bHM = "";
    this.qSE = "ERROR#PATH";
    this.qSK = null;
    this.qTd = 0.0D;
    this.qTe = false;
    com.tencent.mm.memory.o.fdX.t(this.qSI);
    this.qSI = null;
  }
  
  public final boolean cmA()
  {
    if (1 == this.qSD) {
      if ((this.ryo == null) || (this.ryo.oIr)) {}
    }
    while ((this.ryq != null) && (!this.ryq.oIr) && (this.ryo != null) && (!this.ryo.oIr))
    {
      return true;
      return false;
    }
    return false;
  }
  
  final boolean cmB()
  {
    if (this.qTc) {}
    do
    {
      do
      {
        return false;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
      } while (this.qSC < 3);
      ab.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
      this.qSC = 0;
      return false;
    } while (this.qSC < 3);
    return true;
  }
  
  protected final void cmC()
  {
    int i = Math.max(1, (int)SightVideoJNI.getVideoRate(this.qSF));
    this.qSH = (1000 / i);
    ab.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.qSH) });
  }
  
  public final c cmD()
  {
    if (this.ryu == null) {
      this.ryu = new b.a(this);
    }
    return this.ryu;
  }
  
  protected int cmz()
  {
    return -1;
  }
  
  public final void crB()
  {
    ab.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.TRUE });
    com.tencent.mm.modelvideo.o.x(this.ryr);
    if (this.ryr == null) {
      this.ryr = new b.k(this, (byte)0);
    }
    this.ryr.qTy = new WeakReference(null);
    com.tencent.mm.modelvideo.o.j(this.ryr, 0L);
  }
  
  public abstract void dQ(int paramInt1, int paramInt2);
  
  public final void kR(boolean paramBoolean)
  {
    if (this.ryn != null)
    {
      com.tencent.mm.modelvideo.o.x(this.ryn);
      this.ryn.oIr = true;
    }
    if (this.ryq != null)
    {
      this.loX.removeCallbacks(this.ryq);
      this.ryq.oIr = true;
    }
    if (this.ryo != null)
    {
      com.tencent.mm.modelvideo.o.x(this.ryo);
      this.ryo.oIr = true;
    }
    b.i locali;
    if (this.ryp != null)
    {
      locali = this.ryp;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.j(this.ryp, 0L);
      return;
    }
  }
  
  public final void restart()
  {
    ab.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.qSZ), this.bHM, Integer.valueOf(this.qSF) });
    if (!this.qSZ) {
      clear();
    }
    do
    {
      return;
      if (cmA())
      {
        ab.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.bHM });
        return;
      }
      if (this.qSF < 0) {}
      for (boolean bool = true;; bool = false)
      {
        kR(bool);
        this.qSN = 0L;
        if (!cmB()) {
          break;
        }
        ab.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[] { Integer.valueOf(hashCode()) });
        return;
      }
      if (this.qSF >= 0) {
        break;
      }
      ab.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.bHM });
    } while (bo.isNullOrNil(this.bHM));
    if (!Zp(this.bHM))
    {
      ab.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.ryn = new b.h(this, (byte)0);
    com.tencent.mm.modelvideo.o.j(this.ryn, 0L);
    return;
    if (1 == this.qSD)
    {
      this.ryo = new b((byte)0);
      this.ryq = null;
      com.tencent.mm.modelvideo.o.j(this.ryo, 0L);
      return;
    }
    this.ryo = new b((byte)0);
    this.ryq = new c();
    this.ryo.ryz = this.ryq;
    this.ryq.ryB = this.ryo;
    com.tencent.mm.modelvideo.o.j(this.ryo, 0L);
  }
  
  final class b
    implements Runnable
  {
    volatile boolean oIr = false;
    b.c ryz;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(37420);
      if ((b.q(b.this) != null) && (b.q(b.this).cmI() != null) && (b.q(b.this).cmI().getVisibility() == 0)) {
        b.g(b.this).post(new b.b.1(this));
      }
      if (b.e(b.this) < 0)
      {
        ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.a(b.this) });
        AppMethodBeat.o(37420);
        return;
      }
      if (this.oIr)
      {
        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(37420);
        return;
      }
      if (b.r(b.this) == 0L)
      {
        if (b.s(b.this) != null)
        {
          b.s(b.this).type = 1;
          b.s(b.this).run();
        }
        b.a(b.this, System.currentTimeMillis());
      }
      int j = 0;
      int i = j;
      if (b.t(b.this) != -1.0D)
      {
        if (b.this.qTa) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.t(b.this), b.e(b.this)) > 0)
        {
          if (b.s(b.this) == null) {
            b.a(b.this, new b.i(b.this, (byte)0));
          }
          b.s(b.this).type = 4;
          b.s(b.this).qTg = b.t(b.this);
          b.s(b.this).run();
          i = 1;
        }
      }
      float f3 = (float)(System.currentTimeMillis() - b.r(b.this));
      float f1;
      label375:
      float f2;
      double d;
      if (i != 0)
      {
        f1 = 0.0F;
        f2 = f1;
        if (b.this.qTa)
        {
          f2 = f1;
          if (b.u(b.this))
          {
            b.a(b.this, false);
            f2 = f1;
            if (b.s(b.this) != null)
            {
              d = b.s(b.this).cmK() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, b.e(b.this)) > 0)
              {
                f2 = 0.0F;
                ab.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (b.v(b.this)) {
          ab.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), Float.valueOf(f3), Float.valueOf(f2) });
        }
        b.a(b.this, System.currentTimeMillis());
        if (f2 < 2.0F) {
          break label813;
        }
        b.w(b.this);
      }
      for (;;)
      {
        if (!b.c(b.this)) {
          break label837;
        }
        ab.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.x(b.this)) });
        b.this.clear();
        AppMethodBeat.o(37420);
        return;
        label620:
        if (b.s(b.this) != null)
        {
          b.s(b.this).type = 4;
          b.s(b.this).qTg = b.t(b.this);
          b.s(b.this).run();
          b.g(b.this).postDelayed(new b.b.2(this), 100L);
          i = j;
          break;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.t(b.this), b.e(b.this)) <= 0) {
          break;
        }
        if (b.s(b.this) == null) {
          b.a(b.this, new b.i(b.this, (byte)0));
        }
        b.s(b.this).type = 4;
        b.s(b.this).qTg = b.t(b.this);
        b.s(b.this).run();
        i = 1;
        break;
        f1 = f3 / b.this.qSH + 0.5F;
        break label375;
        label813:
        b.c(b.this, Math.max(0, b.x(b.this) - 1));
      }
      label837:
      int k = 0;
      j = 0;
      int m = 0;
      if (1 == b.d(b.this)) {
        if ((b.m(b.this) != null) && (!b.m(b.this).isValid()))
        {
          ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          this.oIr = true;
          if (this.ryz == null) {
            break label1393;
          }
          this.ryz.oIr = true;
          i = 0;
          j = m;
          if (b.s(b.this) == null) {
            break label2137;
          }
          ab.d("MicroMsg.SightPlayController", "voice time is" + b.s(b.this).cmK() / 1000.0D);
        }
      }
      label1718:
      label2137:
      for (;;)
      {
        if (1 == j) {
          b.g(b.this).post(new b.b.4(this));
        }
        if (this.oIr)
        {
          ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          if (b.s(b.this) != null)
          {
            b.s(b.this).type = 0;
            b.s(b.this).run();
          }
          AppMethodBeat.o(37420);
          return;
          i = SightVideoJNI.drawSurfaceFrame(b.e(b.this), b.m(b.this), (int)f2, b.o(b.this), b.y(b.this));
          if (b.z(b.this) != null)
          {
            d = SightVideoJNI.getVideoPlayTime(b.e(b.this));
            j = (int)d;
            if (j != (int)b.this.qTd) {
              b.z(b.this).lO(j);
            }
            b.this.qTd = d;
          }
          if (i == 0)
          {
            b.a(b.this, -1.0D);
            k = 0;
            j = i;
            i = k;
            break;
          }
          if (1 == i)
          {
            b.a(b.this, -1.0D);
            k = 1;
            b.a(b.this, 0L);
            b.A(b.this);
            j = i;
            i = k;
            break;
          }
          if (-7 == i)
          {
            ab.w("MicroMsg.SightPlayController", "surface is null, continue");
            k = 0;
            j = i;
            i = k;
            break;
          }
          ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i) });
          this.oIr = true;
          if (this.ryz != null) {
            this.ryz.oIr = true;
          }
          b.this.crB();
          j = i;
          if (b.b(b.this) != null)
          {
            b.b(b.this).Eh(-1);
            j = i;
          }
          label1393:
          i = 0;
          break;
          m = SightVideoJNI.drawFrame(b.e(b.this), b.B(b.this), (int)f2, null, false, b.y(b.this));
          if (b.z(b.this) != null)
          {
            d = SightVideoJNI.getVideoPlayTime(b.e(b.this));
            i = (int)d;
            if (i != (int)b.this.qTd) {
              b.z(b.this).lO(i);
            }
            b.this.qTd = d;
            if (b.v(b.this)) {
              ab.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
            }
          }
          for (;;)
          {
            if (m != 0) {
              break label1718;
            }
            b.a(b.this, -1.0D);
            j = m;
            i = k;
            break;
            if (b.v(b.this))
            {
              d = SightVideoJNI.getVideoPlayTime(b.e(b.this));
              if (b.v(b.this)) {
                ab.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (b.v(b.this))
            {
              ab.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            }
          }
          if (1 == m)
          {
            b.a(b.this, -1.0D);
            i = 1;
            b.a(b.this, 0L);
            b.A(b.this);
            j = m;
            continue;
          }
          b.a(b.this, -1.0D);
          ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
          this.oIr = true;
          if (this.ryz != null) {
            this.ryz.oIr = true;
          }
          b.g(b.this).post(new b.b.3(this));
          j = m;
          i = k;
          if (b.b(b.this) == null) {
            continue;
          }
          b.b(b.this).Eh(-1);
          j = m;
          i = k;
          continue;
        }
        long l;
        if (1 == b.d(b.this))
        {
          l = b.this.qSH - (System.currentTimeMillis() - b.r(b.this));
          if (b.r(b.this) == 0L) {
            com.tencent.mm.modelvideo.o.j(this, b.this.qSH * 5);
          }
        }
        for (;;)
        {
          if (b.s(b.this) != null) {
            ab.d("MicroMsg.SightPlayController", "voice time is" + b.s(b.this).cmK() / 1000.0D);
          }
          AppMethodBeat.o(37420);
          return;
          if (l > 0L)
          {
            com.tencent.mm.modelvideo.o.j(this, l);
          }
          else
          {
            com.tencent.mm.modelvideo.o.j(this, 0L);
            continue;
            if ((i != 0) && (b.q(b.this) != null))
            {
              i = b.q(b.this).cmH();
              b.g(b.this).post(new b.b.5(this));
              this.ryz.qTu = j;
              b.g(b.this).postDelayed(this.ryz, i);
            }
            else
            {
              this.ryz.qTu = j;
              b.g(b.this).post(this.ryz);
            }
          }
        }
      }
    }
  }
  
  final class c
    implements Runnable
  {
    volatile boolean oIr;
    int qTu;
    b.b ryB;
    
    public c()
    {
      AppMethodBeat.i(37421);
      this.oIr = false;
      ab.i("MicroMsg.SightPlayController", "make sure drawJob alive");
      AppMethodBeat.o(37421);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37422);
      if (this.oIr)
      {
        ab.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(37422);
        return;
      }
      b.this.S(b.B(b.this));
      if (b.r(b.this) == 0L)
      {
        com.tencent.mm.modelvideo.o.j(this.ryB, 0L);
        AppMethodBeat.o(37422);
        return;
      }
      long l = b.this.qSH - (System.currentTimeMillis() - b.r(b.this));
      if (l > 0L)
      {
        com.tencent.mm.modelvideo.o.j(this.ryB, l);
        AppMethodBeat.o(37422);
        return;
      }
      com.tencent.mm.modelvideo.o.j(this.ryB, 0L);
      AppMethodBeat.o(37422);
    }
  }
  
  final class d
    implements Runnable
  {
    private d() {}
    
    public final void run()
    {
      AppMethodBeat.i(37423);
      if (b.k(b.this).get() == null)
      {
        AppMethodBeat.o(37423);
        return;
      }
      ((View)b.k(b.this).get()).startAnimation(b.l(b.this));
      AppMethodBeat.o(37423);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b
 * JD-Core Version:    0.7.0.1
 */