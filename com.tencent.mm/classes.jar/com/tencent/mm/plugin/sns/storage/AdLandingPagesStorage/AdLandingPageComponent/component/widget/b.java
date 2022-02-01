package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> zhZ = new HashMap();
  private static Map<String, Integer> zid = new ConcurrentHashMap();
  String cvr = "";
  private aq gNm = new aq(Looper.getMainLooper());
  private boolean inI = false;
  boolean iuX = true;
  private Surface mSurface;
  int position;
  volatile h zZb;
  private volatile b zZc;
  volatile i zZd;
  private volatile c zZe;
  private k zZf;
  private j zZg;
  private d zZh;
  private a zZi;
  e zZj;
  f zZk;
  g zZl;
  int zhA = -1;
  protected int zhC = 41;
  private Bitmap zhD;
  private Bitmap zhE;
  private Bitmap zhF;
  WeakReference<View> zhG;
  WeakReference<TextView> zhH;
  private long zhI;
  private WeakReference<View> zhJ;
  private Animation zhK;
  private Animation zhL;
  boolean zhV = true;
  public boolean zhW = false;
  private int zhx = 0;
  private int zhy = 0;
  String zhz = "";
  public boolean zia = false;
  double zib = -1.0D;
  boolean zic = false;
  double zie = -1.0D;
  private boolean zif = false;
  boolean zig = false;
  
  public b(View paramView)
  {
    this.zhJ = new WeakReference(paramView);
    ae.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(0) });
  }
  
  private void Qb(final int paramInt)
  {
    com.tencent.mm.modelvideo.o.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96872);
        long l = System.currentTimeMillis();
        SightVideoJNI.freeObj(paramInt);
        ae.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(96872);
      }
    }, 0L);
  }
  
  public static boolean ayO(String paramString)
  {
    if (bu.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)zid.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  public abstract void ai(Bitmap paramBitmap);
  
  public final void clear()
  {
    ae.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.zhA), Boolean.valueOf(dTz()) });
    rh(true);
    this.zhI = 0L;
    Qb(this.zhA);
    this.zhA = -1;
    this.cvr = "";
    this.zhz = "ERROR#PATH";
    this.zhF = null;
    this.zib = 0.0D;
    this.zic = false;
    com.tencent.mm.memory.o.hzF.f(this.zhD);
    this.zhD = null;
  }
  
  final boolean dTA()
  {
    if (this.zia) {}
    do
    {
      do
      {
        return false;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
      } while (this.zhx < 3);
      ae.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
      this.zhx = 0;
      return false;
    } while (this.zhx < 3);
    return true;
  }
  
  protected final void dTB()
  {
    int i = Math.max(1, (int)SightVideoJNI.getVideoRate(this.zhA));
    this.zhC = (1000 / i);
    ae.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.zhC) });
  }
  
  public final c dTC()
  {
    if (this.zZi == null) {
      this.zZi = new a(this);
    }
    return this.zZi;
  }
  
  protected int dTy()
  {
    return -1;
  }
  
  public final boolean dTz()
  {
    if (1 == this.zhy) {
      if ((this.zZc == null) || (this.zZc.stop)) {}
    }
    while ((this.zZe != null) && (!this.zZe.stop) && (this.zZc != null) && (!this.zZc.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public abstract void eb(int paramInt1, int paramInt2);
  
  public final void eba()
  {
    ae.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.TRUE });
    com.tencent.mm.modelvideo.o.E(this.zZf);
    if (this.zZf == null) {
      this.zZf = new k((byte)0);
    }
    this.zZf.ziv = new WeakReference(null);
    com.tencent.mm.modelvideo.o.i(this.zZf, 0L);
  }
  
  public final void restart()
  {
    ae.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.zhV), this.cvr, Integer.valueOf(this.zhA) });
    if (!this.zhV) {
      clear();
    }
    do
    {
      return;
      if (dTz())
      {
        ae.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cvr });
        return;
      }
      if (this.zhA < 0) {}
      for (boolean bool = true;; bool = false)
      {
        rh(bool);
        this.zhI = 0L;
        if (!dTA()) {
          break;
        }
        ae.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[] { Integer.valueOf(hashCode()) });
        return;
      }
      if (this.zhA >= 0) {
        break;
      }
      ae.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cvr });
    } while (bu.isNullOrNil(this.cvr));
    if (!ayO(this.cvr))
    {
      ae.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.zZb = new h((byte)0);
    com.tencent.mm.modelvideo.o.i(this.zZb, 0L);
    return;
    if (1 == this.zhy)
    {
      this.zZc = new b((byte)0);
      this.zZe = null;
      com.tencent.mm.modelvideo.o.i(this.zZc, 0L);
      return;
    }
    this.zZc = new b((byte)0);
    this.zZe = new c();
    this.zZc.zZn = this.zZe;
    this.zZe.zZp = this.zZc;
    com.tencent.mm.modelvideo.o.i(this.zZc, 0L);
  }
  
  public final void rh(boolean paramBoolean)
  {
    if (this.zZb != null)
    {
      com.tencent.mm.modelvideo.o.E(this.zZb);
      this.zZb.stop = true;
    }
    if (this.zZe != null)
    {
      this.gNm.removeCallbacks(this.zZe);
      this.zZe.stop = true;
    }
    if (this.zZc != null)
    {
      com.tencent.mm.modelvideo.o.E(this.zZc);
      this.zZc.stop = true;
    }
    i locali;
    if (this.zZd != null)
    {
      locali = this.zZd;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.i(this.zZd, 0L);
      return;
    }
  }
  
  static final class a
    extends c<xg>
  {
    int rES;
    int tii;
    int zin;
    WeakReference<b> zio;
    
    public a(b paramb)
    {
      super();
      AppMethodBeat.i(96874);
      this.tii = 0;
      this.zin = 0;
      this.rES = 0;
      this.zio = new WeakReference(paramb);
      this.__eventId = xg.class.getName().hashCode();
      AppMethodBeat.o(96874);
    }
    
    private void a(xg paramxg)
    {
      this.tii = paramxg.dMK.dMN;
      this.zin = paramxg.dMK.dML;
      this.rES = paramxg.dMK.dMM;
    }
    
    private boolean dTF()
    {
      AppMethodBeat.i(96875);
      if (this.zio.get() == null)
      {
        AppMethodBeat.o(96875);
        return false;
      }
      int i = b.D((b)this.zio.get()) + this.tii;
      if ((i < this.zin) || (i > this.rES))
      {
        AppMethodBeat.o(96875);
        return false;
      }
      AppMethodBeat.o(96875);
      return true;
    }
  }
  
  final class b
    implements Runnable
  {
    volatile boolean stop = false;
    b.c zZn;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(96882);
      if ((b.q(b.this) != null) && (b.q(b.this).dTH() != null) && (b.q(b.this).dTH().getVisibility() == 0)) {
        b.g(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96877);
            b.q(b.this).dTH().setVisibility(8);
            AppMethodBeat.o(96877);
          }
        });
      }
      if (b.e(b.this) < 0)
      {
        ae.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.a(b.this) });
        AppMethodBeat.o(96882);
        return;
      }
      if (this.stop)
      {
        ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(96882);
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
        if (b.this.zhW) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.t(b.this), b.e(b.this)) > 0)
        {
          if (b.s(b.this) == null) {
            b.a(b.this, new b.i(b.this, (byte)0));
          }
          b.s(b.this).type = 4;
          b.s(b.this).zie = b.t(b.this);
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
        if (b.this.zhW)
        {
          f2 = f1;
          if (b.u(b.this))
          {
            b.a(b.this, false);
            f2 = f1;
            if (b.s(b.this) != null)
            {
              d = b.s(b.this).dTJ() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, b.e(b.this)) > 0)
              {
                f2 = 0.0F;
                ae.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (b.v(b.this)) {
          ae.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), Float.valueOf(f3), Float.valueOf(f2) });
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
        ae.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.x(b.this)) });
        b.this.clear();
        AppMethodBeat.o(96882);
        return;
        label620:
        if (b.s(b.this) != null)
        {
          b.s(b.this).type = 4;
          b.s(b.this).zie = b.t(b.this);
          b.s(b.this).run();
          b.g(b.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96878);
              b.a(b.this, true);
              AppMethodBeat.o(96878);
            }
          }, 100L);
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
        b.s(b.this).zie = b.t(b.this);
        b.s(b.this).run();
        i = 1;
        break;
        f1 = f3 / b.this.zhC + 0.5F;
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
          ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          this.stop = true;
          if (this.zZn == null) {
            break label1394;
          }
          this.zZn.stop = true;
          i = 0;
          j = m;
          if (b.s(b.this) == null) {
            break label2139;
          }
          ae.d("MicroMsg.SightPlayController", "voice time is" + b.s(b.this).dTJ() / 1000.0D);
        }
      }
      label1719:
      label2139:
      for (;;)
      {
        if (1 == j) {
          b.g(b.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96880);
              if (b.b(b.this) != null) {
                b.b(b.this).Rd(0);
              }
              AppMethodBeat.o(96880);
            }
          });
        }
        if (this.stop)
        {
          ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          if (b.s(b.this) != null)
          {
            b.s(b.this).type = 0;
            b.s(b.this).run();
          }
          AppMethodBeat.o(96882);
          return;
          i = SightVideoJNI.drawSurfaceFrame(b.e(b.this), b.m(b.this), (int)f2, b.o(b.this), b.y(b.this));
          if (b.z(b.this) != null)
          {
            d = SightVideoJNI.getVideoPlayTime(b.e(b.this));
            j = (int)d;
            if (j != (int)b.this.zib) {
              b.z(b.this).Au(j);
            }
            b.this.zib = d;
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
            ae.w("MicroMsg.SightPlayController", "surface is null, continue");
            k = 0;
            j = i;
            i = k;
            break;
          }
          ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i) });
          this.stop = true;
          if (this.zZn != null) {
            this.zZn.stop = true;
          }
          b.this.eba();
          j = i;
          if (b.b(b.this) != null)
          {
            b.b(b.this).Rd(-1);
            j = i;
          }
          label1394:
          i = 0;
          break;
          m = SightVideoJNI.drawFrame(b.e(b.this), b.B(b.this), (int)f2, null, false, b.y(b.this));
          if (b.z(b.this) != null)
          {
            d = SightVideoJNI.getVideoPlayTime(b.e(b.this));
            i = (int)d;
            if (i != (int)b.this.zib) {
              b.z(b.this).Au(i);
            }
            b.this.zib = d;
            if (b.v(b.this)) {
              ae.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
            }
          }
          for (;;)
          {
            if (m != 0) {
              break label1719;
            }
            b.a(b.this, -1.0D);
            j = m;
            i = k;
            break;
            if (b.v(b.this))
            {
              d = SightVideoJNI.getVideoPlayTime(b.e(b.this));
              if (b.v(b.this)) {
                ae.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (b.v(b.this))
            {
              ae.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
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
          ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
          this.stop = true;
          if (this.zZn != null) {
            this.zZn.stop = true;
          }
          b.g(b.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96879);
              b.this.ai(null);
              AppMethodBeat.o(96879);
            }
          });
          j = m;
          i = k;
          if (b.b(b.this) == null) {
            continue;
          }
          b.b(b.this).Rd(-1);
          j = m;
          i = k;
          continue;
        }
        long l;
        if (1 == b.d(b.this))
        {
          l = b.this.zhC - (System.currentTimeMillis() - b.r(b.this));
          if (b.r(b.this) == 0L) {
            com.tencent.mm.modelvideo.o.i(this, b.this.zhC * 5);
          }
        }
        for (;;)
        {
          if (b.s(b.this) != null) {
            ae.d("MicroMsg.SightPlayController", "voice time is" + b.s(b.this).dTJ() / 1000.0D);
          }
          AppMethodBeat.o(96882);
          return;
          if (l > 0L)
          {
            com.tencent.mm.modelvideo.o.i(this, l);
          }
          else
          {
            com.tencent.mm.modelvideo.o.i(this, 0L);
            continue;
            if ((i != 0) && (b.q(b.this) != null))
            {
              i = b.q(b.this).dTG();
              b.g(b.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(96881);
                  if (b.q(b.this) != null)
                  {
                    View localView = b.q(b.this).dTH();
                    if (localView != null)
                    {
                      if ((b.C(b.this) == null) && (b.q(b.this).dTI() != -1) && (b.k(b.this).get() != null)) {
                        b.a(b.this, AnimationUtils.loadAnimation(((View)b.k(b.this).get()).getContext(), b.q(b.this).dTI()));
                      }
                      if (b.C(b.this) != null) {
                        localView.startAnimation(b.C(b.this));
                      }
                      localView.setVisibility(0);
                    }
                  }
                  AppMethodBeat.o(96881);
                }
              });
              this.zZn.zir = j;
              b.g(b.this).postDelayed(this.zZn, i);
            }
            else
            {
              this.zZn.zir = j;
              b.g(b.this).post(this.zZn);
            }
          }
        }
      }
    }
  }
  
  final class c
    implements Runnable
  {
    volatile boolean stop;
    b.b zZp;
    int zir;
    
    public c()
    {
      AppMethodBeat.i(96883);
      this.stop = false;
      ae.i("MicroMsg.SightPlayController", "make sure drawJob alive");
      AppMethodBeat.o(96883);
    }
    
    public final void run()
    {
      AppMethodBeat.i(96884);
      if (this.stop)
      {
        ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(96884);
        return;
      }
      b.this.ai(b.B(b.this));
      if (b.r(b.this) == 0L)
      {
        com.tencent.mm.modelvideo.o.i(this.zZp, 0L);
        AppMethodBeat.o(96884);
        return;
      }
      long l = b.this.zhC - (System.currentTimeMillis() - b.r(b.this));
      if (l > 0L)
      {
        com.tencent.mm.modelvideo.o.i(this.zZp, l);
        AppMethodBeat.o(96884);
        return;
      }
      com.tencent.mm.modelvideo.o.i(this.zZp, 0L);
      AppMethodBeat.o(96884);
    }
  }
  
  final class d
    implements Runnable
  {
    private d() {}
    
    public final void run()
    {
      AppMethodBeat.i(96885);
      if (b.k(b.this).get() == null)
      {
        AppMethodBeat.o(96885);
        return;
      }
      ((View)b.k(b.this).get()).startAnimation(b.l(b.this));
      AppMethodBeat.o(96885);
    }
  }
  
  public static abstract interface e
  {
    public abstract void Rd(int paramInt);
  }
  
  public static abstract interface f
  {
    public abstract void Au(long paramLong);
  }
  
  public static abstract interface g
  {
    public abstract int dTG();
    
    public abstract View dTH();
    
    public abstract int dTI();
  }
  
  final class h
    implements Runnable
  {
    volatile boolean stop = false;
    
    private h() {}
    
    public final void run()
    {
      AppMethodBeat.i(96886);
      if (b.c(b.this))
      {
        ae.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
        AppMethodBeat.o(96886);
        return;
      }
      b localb = b.this;
      String str = b.a(b.this);
      if (1 == b.d(b.this)) {}
      for (int i = 0;; i = 1)
      {
        b.a(localb, SightVideoJNI.openFileVFS(str, i, 1, false));
        if (b.e(b.this) >= 0) {
          break;
        }
        ae.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), b.a(b.this) });
        b.this.eba();
        if (b.b(b.this) != null) {
          b.b(b.this).Rd(-1);
        }
        AppMethodBeat.o(96886);
        return;
      }
      if (((Boolean)AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.FALSE)).booleanValue())
      {
        if (b.f(b.this) == null) {
          b.a(b.this, new b.j(b.this, (byte)0));
        }
        b.g(b.this).removeCallbacks(b.f(b.this));
        b.g(b.this).post(b.f(b.this));
      }
      i = Math.max(1, SightVideoJNI.getVideoWidth(b.e(b.this)));
      int j = Math.max(1, SightVideoJNI.getVideoHeight(b.e(b.this)));
      if (b.d(b.this) == 0)
      {
        if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
        {
          ae.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(96886);
          return;
        }
        b.a(b.this, i, j);
      }
      b.this.dTB();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        ae.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!bu.isNullOrNil(b.a(b.this))) {
          b.ebb().put(b.a(b.this), Integer.valueOf(2));
        }
        b.a(b.this, 0L);
        b.b(b.this, b.e(b.this));
        b.a(b.this, -1);
        b.a(b.this, "");
        b.b(b.this, "ERROR#PATH");
        b.a(b.this, null);
        this.stop = true;
        if (b.b(b.this) != null) {
          b.b(b.this).Rd(-1);
        }
        AppMethodBeat.o(96886);
        return;
      }
      b.this.eb(i, j);
      if (1 == b.d(b.this))
      {
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, null);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.i(b.h(b.this), 0L);
        }
      }
      for (;;)
      {
        if (this.stop) {
          ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
        }
        AppMethodBeat.o(96886);
        return;
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, new b.c(b.this));
        b.h(b.this).zZn = b.i(b.this);
        b.i(b.this).zZp = b.h(b.this);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.i(b.h(b.this), 0L);
        }
      }
    }
  }
  
  final class i
    implements Runnable
  {
    int type;
    double zie = -1.0D;
    MediaPlayer zit;
    
    private i() {}
    
    private void dwn()
    {
      AppMethodBeat.i(96888);
      ae.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.zit != null)
        {
          this.zit.stop();
          this.zit.release();
          this.zit = null;
        }
        AppMethodBeat.o(96888);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.zit = null;
        AppMethodBeat.o(96888);
      }
    }
    
    public final double dTJ()
    {
      AppMethodBeat.i(96889);
      if (this.zit == null)
      {
        AppMethodBeat.o(96889);
        return 0.0D;
      }
      double d = this.zit.getCurrentPosition();
      AppMethodBeat.o(96889);
      return d;
    }
    
    public final void run()
    {
      AppMethodBeat.i(96890);
      String str;
      switch (this.type)
      {
      default: 
        str = "unknown";
        ae.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
        switch (this.type)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(96890);
        return;
        str = "start";
        break;
        str = "stop";
        break;
        str = "pause";
        break;
        str = "resume";
        break;
        str = "seek";
        break;
        dwn();
        if (!bu.isNullOrNil(b.a(b.this)))
        {
          try
          {
            this.zit = new k();
            this.zit.setDisplay(null);
            this.zit.reset();
            this.zit.setDataSource(b.a(b.this));
            this.zit.setAudioStreamType(3);
            this.zit.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(96887);
                ae.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(b.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                b.this.clear();
                if (b.b(b.this) != null) {
                  b.b(b.this).Rd(-1);
                }
                AppMethodBeat.o(96887);
                return true;
              }
            });
            this.zit.prepare();
            this.zit.start();
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException1)
          {
            ae.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            ae.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.a(b.this) });
            b.this.clear();
            if (b.b(b.this) != null) {
              b.b(b.this).Rd(-1);
            }
            AppMethodBeat.o(96890);
            return;
          }
          dwn();
          AppMethodBeat.o(96890);
          return;
          try
          {
            if ((this.zit != null) && (this.zit.isPlaying())) {
              this.zit.pause();
            }
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException2)
          {
            ae.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            dwn();
            AppMethodBeat.o(96890);
            return;
          }
          try
          {
            if (this.zit != null) {
              this.zit.start();
            }
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException3)
          {
            ae.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            dwn();
            AppMethodBeat.o(96890);
            return;
          }
          try
          {
            ae.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.zie) });
            this.zit.seekTo((int)(this.zie * 1000.0D));
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException4)
          {
            ae.printErrStackTrace("MicroMsg.SightPlayController", localException4, "seek sound error: %s", new Object[] { localException4.getMessage() });
          }
        }
      }
    }
  }
  
  final class j
    implements Runnable
  {
    private j() {}
    
    public final void run()
    {
      AppMethodBeat.i(96891);
      if ((b.e(b.this) < 0) || (b.j(b.this) == null) || (b.j(b.this).get() == null))
      {
        AppMethodBeat.o(96891);
        return;
      }
      String str = SightVideoJNI.getVideoInfo(b.e(b.this));
      ((TextView)b.j(b.this).get()).setText(str);
      AppMethodBeat.o(96891);
    }
  }
  
  final class k
    implements Runnable
  {
    WeakReference<Bitmap> ziv;
    
    private k()
    {
      AppMethodBeat.i(96895);
      this.ziv = new WeakReference(null);
      AppMethodBeat.o(96895);
    }
    
    public final void run()
    {
      final View localView1 = null;
      boolean bool6 = true;
      boolean bool5 = true;
      AppMethodBeat.i(96896);
      boolean bool2;
      label75:
      label88:
      label101:
      final Bitmap localBitmap;
      try
      {
        if ((b.m(b.this) != null) && (b.m(b.this).isValid())) {
          break label713;
        }
        i = b.this.hashCode();
        j = hashCode();
        boolean bool3;
        boolean bool4;
        if (b.m(b.this) == null)
        {
          bool1 = true;
          if (b.n(b.this) != null) {
            break label276;
          }
          bool2 = true;
          if (this.ziv.get() != null) {
            break label282;
          }
          bool3 = true;
          if (b.o(b.this) != null) {
            break label288;
          }
          bool4 = true;
          ae.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (b.o(b.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.ziv.get();
          if (b.n(b.this) != null) {
            localView1 = (View)b.n(b.this).get();
          }
          if ((localView1 != null) && (localBitmap != null) && (!localBitmap.isRecycled())) {
            break label305;
          }
          if (localView1 != null) {
            break label294;
          }
          bool1 = true;
          label230:
          if (localBitmap != null) {
            break label299;
          }
        }
        label276:
        label282:
        label288:
        label294:
        label299:
        for (bool2 = bool5;; bool2 = false)
        {
          ae.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(96896);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label75;
          bool3 = false;
          break label88;
          bool4 = false;
          break label101;
          bool1 = false;
          break label230;
        }
        label305:
        localView1.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96892);
            localView1.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            AppMethodBeat.o(96892);
          }
        });
        AppMethodBeat.o(96896);
        return;
      }
      catch (Exception localException1)
      {
        ae.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
        AppMethodBeat.o(96896);
        return;
      }
      label350:
      if ((b.p(b.this) != null) && (b.p(b.this).getWidth() == b.o(b.this).getWidth()))
      {
        i = b.p(b.this).getHeight();
        j = b.o(b.this).getHeight();
        if (i == j) {
          break label444;
        }
      }
      label444:
      label506:
      final View localView2;
      try
      {
        b.a(b.this, Bitmap.createBitmap(b.o(b.this).getWidth(), b.o(b.this).getHeight(), Bitmap.Config.ARGB_8888));
        if ((b.p(b.this) == null) || (this.ziv.get() == null) || (((Bitmap)this.ziv.get()).isRecycled()))
        {
          if (b.p(b.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.ziv.get() != null) {
            break label883;
          }
          bool2 = bool6;
          ae.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(96896);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.SightPlayController", localException2, "try to create thumb bmp error:%s", new Object[] { localException2.getMessage() });
          b.a(b.this, null);
        }
        long l = System.nanoTime();
        SightVideoJNI.handleThumb((Bitmap)this.ziv.get(), b.p(b.this), b.o(b.this));
        ae.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
        localBitmap = b.p(b.this);
        if (b.n(b.this) != null) {}
        for (localView2 = (View)b.n(b.this).get(); (localView2 == null) || (localBitmap == null); localView2 = null)
        {
          AppMethodBeat.o(96896);
          return;
        }
        localView2.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96893);
            localView2.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            AppMethodBeat.o(96893);
          }
        });
        AppMethodBeat.o(96896);
        return;
      }
      label713:
      int i = b.this.hashCode();
      int j = hashCode();
      if (this.ziv.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ae.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (b.n(b.this) != null)
        {
          localView2 = (View)b.n(b.this).get();
          if (localView2 != null) {
            localView2.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96894);
                ae.v("MicroMsg.SightPlayController", "set background drawable null");
                localView2.setBackgroundDrawable(null);
                AppMethodBeat.o(96894);
              }
            });
          }
        }
        if (this.ziv.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(b.m(b.this), 0);
          AppMethodBeat.o(96896);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(b.m(b.this), (Bitmap)this.ziv.get(), b.o(b.this));
        AppMethodBeat.o(96896);
        return;
        label878:
        bool1 = false;
        break;
        label883:
        bool2 = false;
        break label506;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b
 * JD-Core Version:    0.7.0.1
 */