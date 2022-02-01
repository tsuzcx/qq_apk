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
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> DmQ = new HashMap();
  private static Map<String, Integer> DmU = new ConcurrentHashMap();
  private WeakReference<View> DmA;
  private Animation DmB;
  private Animation DmC;
  boolean DmM = true;
  public boolean DmN = false;
  public boolean DmR = false;
  double DmS = -1.0D;
  boolean DmT = false;
  double DmV = -1.0D;
  private boolean DmW = false;
  boolean DmX = false;
  private int Dmo = 0;
  private int Dmp = 0;
  String Dmq = "";
  int Dmr = -1;
  protected int Dmt = 41;
  private Bitmap Dmu;
  private Bitmap Dmv;
  private Bitmap Dmw;
  WeakReference<View> Dmx;
  WeakReference<TextView> Dmy;
  private long Dmz;
  e EhA;
  b.f EhB;
  g EhC;
  volatile h Ehs;
  private volatile b Eht;
  volatile i Ehu;
  private volatile c Ehv;
  private k Ehw;
  private j Ehx;
  private d Ehy;
  private a Ehz;
  String cJp = "";
  private MMHandler czp = new MMHandler(Looper.getMainLooper());
  private boolean jiQ = false;
  boolean jqj = true;
  private Surface mSurface;
  int position;
  
  public b(View paramView)
  {
    this.DmA = new WeakReference(paramView);
    Log.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(0) });
  }
  
  private void XF(int paramInt)
  {
    com.tencent.mm.modelvideo.o.g(new b.1(this, paramInt), 0L);
  }
  
  public static boolean aNy(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)DmU.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  public abstract void at(Bitmap paramBitmap);
  
  public final void clear()
  {
    Log.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.Dmr), Boolean.valueOf(eVy()) });
    uD(true);
    this.Dmz = 0L;
    XF(this.Dmr);
    this.Dmr = -1;
    this.cJp = "";
    this.Dmq = "ERROR#PATH";
    this.Dmw = null;
    this.DmS = 0.0D;
    this.DmT = false;
    com.tencent.mm.memory.o.itM.f(this.Dmu);
    this.Dmu = null;
  }
  
  protected final void eVA()
  {
    int i = Math.max(1, (int)SightVideoJNI.getVideoRate(this.Dmr));
    this.Dmt = (1000 / i);
    Log.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.Dmt) });
  }
  
  public final IListener eVB()
  {
    if (this.Ehz == null) {
      this.Ehz = new a(this);
    }
    return this.Ehz;
  }
  
  protected int eVx()
  {
    return -1;
  }
  
  public final boolean eVy()
  {
    if (1 == this.Dmp) {
      if ((this.Eht == null) || (this.Eht.stop)) {}
    }
    while ((this.Ehv != null) && (!this.Ehv.stop) && (this.Eht != null) && (!this.Eht.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  final boolean eVz()
  {
    if (this.DmR) {}
    do
    {
      do
      {
        return false;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
      } while (this.Dmo < 3);
      Log.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
      this.Dmo = 0;
      return false;
    } while (this.Dmo < 3);
    return true;
  }
  
  public abstract void eo(int paramInt1, int paramInt2);
  
  public final void fdR()
  {
    Log.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.TRUE });
    com.tencent.mm.modelvideo.o.I(this.Ehw);
    if (this.Ehw == null) {
      this.Ehw = new k((byte)0);
    }
    this.Ehw.Dnm = new WeakReference(null);
    com.tencent.mm.modelvideo.o.g(this.Ehw, 0L);
  }
  
  public final void restart()
  {
    Log.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.DmM), this.cJp, Integer.valueOf(this.Dmr) });
    if (!this.DmM) {
      clear();
    }
    do
    {
      return;
      if (eVy())
      {
        Log.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cJp });
        return;
      }
      if (this.Dmr < 0) {}
      for (boolean bool = true;; bool = false)
      {
        uD(bool);
        this.Dmz = 0L;
        if (!eVz()) {
          break;
        }
        Log.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[] { Integer.valueOf(hashCode()) });
        return;
      }
      if (this.Dmr >= 0) {
        break;
      }
      Log.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cJp });
    } while (Util.isNullOrNil(this.cJp));
    if (!aNy(this.cJp))
    {
      Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.Ehs = new h((byte)0);
    com.tencent.mm.modelvideo.o.g(this.Ehs, 0L);
    return;
    if (1 == this.Dmp)
    {
      this.Eht = new b((byte)0);
      this.Ehv = null;
      com.tencent.mm.modelvideo.o.g(this.Eht, 0L);
      return;
    }
    this.Eht = new b((byte)0);
    this.Ehv = new c();
    this.Eht.EhE = this.Ehv;
    this.Ehv.EhG = this.Eht;
    com.tencent.mm.modelvideo.o.g(this.Eht, 0L);
  }
  
  public final void uD(boolean paramBoolean)
  {
    if (this.Ehs != null)
    {
      com.tencent.mm.modelvideo.o.I(this.Ehs);
      this.Ehs.stop = true;
    }
    if (this.Ehv != null)
    {
      this.czp.removeCallbacks(this.Ehv);
      this.Ehv.stop = true;
    }
    if (this.Eht != null)
    {
      com.tencent.mm.modelvideo.o.I(this.Eht);
      this.Eht.stop = true;
    }
    i locali;
    if (this.Ehu != null)
    {
      locali = this.Ehu;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.g(this.Ehu, 0L);
      return;
    }
  }
  
  static final class a
    extends IListener<yh>
  {
    int Dne;
    WeakReference<b> Dnf;
    int tex;
    int wqJ;
    
    public a(b paramb)
    {
      super();
      AppMethodBeat.i(96874);
      this.wqJ = 0;
      this.Dne = 0;
      this.tex = 0;
      this.Dnf = new WeakReference(paramb);
      this.__eventId = yh.class.getName().hashCode();
      AppMethodBeat.o(96874);
    }
    
    private void a(yh paramyh)
    {
      this.wqJ = paramyh.eeC.eeF;
      this.Dne = paramyh.eeC.eeD;
      this.tex = paramyh.eeC.eeE;
    }
    
    private boolean eVE()
    {
      AppMethodBeat.i(96875);
      if (this.Dnf.get() == null)
      {
        AppMethodBeat.o(96875);
        return false;
      }
      int i = b.D((b)this.Dnf.get()) + this.wqJ;
      if ((i < this.Dne) || (i > this.tex))
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
    b.c EhE;
    volatile boolean stop = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(96882);
      if ((b.q(b.this) != null) && (b.q(b.this).eVG() != null) && (b.q(b.this).eVG().getVisibility() == 0)) {
        b.g(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96877);
            b.q(b.this).eVG().setVisibility(8);
            AppMethodBeat.o(96877);
          }
        });
      }
      if (b.e(b.this) < 0)
      {
        Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.a(b.this) });
        AppMethodBeat.o(96882);
        return;
      }
      if (this.stop)
      {
        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
        if (b.this.DmN) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.t(b.this), b.e(b.this)) > 0)
        {
          if (b.s(b.this) == null) {
            b.a(b.this, new b.i(b.this, (byte)0));
          }
          b.s(b.this).type = 4;
          b.s(b.this).DmV = b.t(b.this);
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
        if (b.this.DmN)
        {
          f2 = f1;
          if (b.u(b.this))
          {
            b.a(b.this, false);
            f2 = f1;
            if (b.s(b.this) != null)
            {
              d = b.s(b.this).eVI() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, b.e(b.this)) > 0)
              {
                f2 = 0.0F;
                Log.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (b.v(b.this)) {
          Log.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), Float.valueOf(f3), Float.valueOf(f2) });
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
        Log.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.x(b.this)) });
        b.this.clear();
        AppMethodBeat.o(96882);
        return;
        label620:
        if (b.s(b.this) != null)
        {
          b.s(b.this).type = 4;
          b.s(b.this).DmV = b.t(b.this);
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
        b.s(b.this).DmV = b.t(b.this);
        b.s(b.this).run();
        i = 1;
        break;
        f1 = f3 / b.this.Dmt + 0.5F;
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
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          this.stop = true;
          if (this.EhE == null) {
            break label1394;
          }
          this.EhE.stop = true;
          i = 0;
          j = m;
          if (b.s(b.this) == null) {
            break label2139;
          }
          Log.d("MicroMsg.SightPlayController", "voice time is" + b.s(b.this).eVI() / 1000.0D);
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
                b.b(b.this).Zb(0);
              }
              AppMethodBeat.o(96880);
            }
          });
        }
        if (this.stop)
        {
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
            if (j != (int)b.this.DmS) {
              b.z(b.this).JB(j);
            }
            b.this.DmS = d;
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
            Log.w("MicroMsg.SightPlayController", "surface is null, continue");
            k = 0;
            j = i;
            i = k;
            break;
          }
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i) });
          this.stop = true;
          if (this.EhE != null) {
            this.EhE.stop = true;
          }
          b.this.fdR();
          j = i;
          if (b.b(b.this) != null)
          {
            b.b(b.this).Zb(-1);
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
            if (i != (int)b.this.DmS) {
              b.z(b.this).JB(i);
            }
            b.this.DmS = d;
            if (b.v(b.this)) {
              Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
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
                Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (b.v(b.this))
            {
              Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
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
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
          this.stop = true;
          if (this.EhE != null) {
            this.EhE.stop = true;
          }
          b.g(b.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96879);
              b.this.at(null);
              AppMethodBeat.o(96879);
            }
          });
          j = m;
          i = k;
          if (b.b(b.this) == null) {
            continue;
          }
          b.b(b.this).Zb(-1);
          j = m;
          i = k;
          continue;
        }
        long l;
        if (1 == b.d(b.this))
        {
          l = b.this.Dmt - (System.currentTimeMillis() - b.r(b.this));
          if (b.r(b.this) == 0L) {
            com.tencent.mm.modelvideo.o.g(this, b.this.Dmt * 5);
          }
        }
        for (;;)
        {
          if (b.s(b.this) != null) {
            Log.d("MicroMsg.SightPlayController", "voice time is" + b.s(b.this).eVI() / 1000.0D);
          }
          AppMethodBeat.o(96882);
          return;
          if (l > 0L)
          {
            com.tencent.mm.modelvideo.o.g(this, l);
          }
          else
          {
            com.tencent.mm.modelvideo.o.g(this, 0L);
            continue;
            if ((i != 0) && (b.q(b.this) != null))
            {
              i = b.q(b.this).eVF();
              b.g(b.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(96881);
                  if (b.q(b.this) != null)
                  {
                    View localView = b.q(b.this).eVG();
                    if (localView != null)
                    {
                      if ((b.C(b.this) == null) && (b.q(b.this).eVH() != -1) && (b.k(b.this).get() != null)) {
                        b.a(b.this, AnimationUtils.loadAnimation(((View)b.k(b.this).get()).getContext(), b.q(b.this).eVH()));
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
              this.EhE.Dni = j;
              b.g(b.this).postDelayed(this.EhE, i);
            }
            else
            {
              this.EhE.Dni = j;
              b.g(b.this).post(this.EhE);
            }
          }
        }
      }
    }
  }
  
  final class c
    implements Runnable
  {
    int Dni;
    b.b EhG;
    volatile boolean stop;
    
    public c()
    {
      AppMethodBeat.i(96883);
      this.stop = false;
      Log.i("MicroMsg.SightPlayController", "make sure drawJob alive");
      AppMethodBeat.o(96883);
    }
    
    public final void run()
    {
      AppMethodBeat.i(96884);
      if (this.stop)
      {
        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(96884);
        return;
      }
      b.this.at(b.B(b.this));
      if (b.r(b.this) == 0L)
      {
        com.tencent.mm.modelvideo.o.g(this.EhG, 0L);
        AppMethodBeat.o(96884);
        return;
      }
      long l = b.this.Dmt - (System.currentTimeMillis() - b.r(b.this));
      if (l > 0L)
      {
        com.tencent.mm.modelvideo.o.g(this.EhG, l);
        AppMethodBeat.o(96884);
        return;
      }
      com.tencent.mm.modelvideo.o.g(this.EhG, 0L);
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
    public abstract void Zb(int paramInt);
  }
  
  public static abstract interface g
  {
    public abstract int eVF();
    
    public abstract View eVG();
    
    public abstract int eVH();
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
        Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
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
        Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), b.a(b.this) });
        b.this.fdR();
        if (b.b(b.this) != null) {
          b.b(b.this).Zb(-1);
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
          Log.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(96886);
          return;
        }
        b.a(b.this, i, j);
      }
      b.this.eVA();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        Log.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!Util.isNullOrNil(b.a(b.this))) {
          b.fdS().put(b.a(b.this), Integer.valueOf(2));
        }
        b.a(b.this, 0L);
        b.b(b.this, b.e(b.this));
        b.a(b.this, -1);
        b.a(b.this, "");
        b.b(b.this, "ERROR#PATH");
        b.a(b.this, null);
        this.stop = true;
        if (b.b(b.this) != null) {
          b.b(b.this).Zb(-1);
        }
        AppMethodBeat.o(96886);
        return;
      }
      b.this.eo(i, j);
      if (1 == b.d(b.this))
      {
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, null);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.g(b.h(b.this), 0L);
        }
      }
      for (;;)
      {
        if (this.stop) {
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
        }
        AppMethodBeat.o(96886);
        return;
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, new b.c(b.this));
        b.h(b.this).EhE = b.i(b.this);
        b.i(b.this).EhG = b.h(b.this);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.g(b.h(b.this), 0L);
        }
      }
    }
  }
  
  final class i
    implements Runnable
  {
    double DmV = -1.0D;
    MediaPlayer Dnk;
    int type;
    
    private i() {}
    
    private void euh()
    {
      AppMethodBeat.i(96888);
      Log.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.Dnk != null)
        {
          this.Dnk.stop();
          this.Dnk.release();
          this.Dnk = null;
        }
        AppMethodBeat.o(96888);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.Dnk = null;
        AppMethodBeat.o(96888);
      }
    }
    
    public final double eVI()
    {
      AppMethodBeat.i(96889);
      if (this.Dnk == null)
      {
        AppMethodBeat.o(96889);
        return 0.0D;
      }
      double d = this.Dnk.getCurrentPosition();
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
        Log.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
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
        euh();
        if (!Util.isNullOrNil(b.a(b.this)))
        {
          try
          {
            this.Dnk = new k();
            this.Dnk.setDisplay(null);
            this.Dnk.reset();
            this.Dnk.setDataSource(b.a(b.this));
            this.Dnk.setAudioStreamType(3);
            this.Dnk.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(96887);
                Log.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(b.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                b.this.clear();
                if (b.b(b.this) != null) {
                  b.b(b.this).Zb(-1);
                }
                AppMethodBeat.o(96887);
                return true;
              }
            });
            this.Dnk.prepare();
            this.Dnk.start();
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            Log.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.a(b.this) });
            b.this.clear();
            if (b.b(b.this) != null) {
              b.b(b.this).Zb(-1);
            }
            AppMethodBeat.o(96890);
            return;
          }
          euh();
          AppMethodBeat.o(96890);
          return;
          try
          {
            if ((this.Dnk != null) && (this.Dnk.isPlaying())) {
              this.Dnk.pause();
            }
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            euh();
            AppMethodBeat.o(96890);
            return;
          }
          try
          {
            if (this.Dnk != null) {
              this.Dnk.start();
            }
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException3)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            euh();
            AppMethodBeat.o(96890);
            return;
          }
          try
          {
            Log.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.DmV) });
            this.Dnk.seekTo((int)(this.DmV * 1000.0D));
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException4)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException4, "seek sound error: %s", new Object[] { localException4.getMessage() });
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
    WeakReference<Bitmap> Dnm;
    
    private k()
    {
      AppMethodBeat.i(96895);
      this.Dnm = new WeakReference(null);
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
          if (this.Dnm.get() != null) {
            break label282;
          }
          bool3 = true;
          if (b.o(b.this) != null) {
            break label288;
          }
          bool4 = true;
          Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (b.o(b.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.Dnm.get();
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
          Log.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
        Log.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
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
        if ((b.p(b.this) == null) || (this.Dnm.get() == null) || (((Bitmap)this.Dnm.get()).isRecycled()))
        {
          if (b.p(b.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.Dnm.get() != null) {
            break label883;
          }
          bool2 = bool6;
          Log.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(96896);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SightPlayController", localException2, "try to create thumb bmp error:%s", new Object[] { localException2.getMessage() });
          b.a(b.this, null);
        }
        long l = System.nanoTime();
        SightVideoJNI.handleThumb((Bitmap)this.Dnm.get(), b.p(b.this), b.o(b.this));
        Log.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
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
      if (this.Dnm.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (b.n(b.this) != null)
        {
          localView2 = (View)b.n(b.this).get();
          if (localView2 != null) {
            localView2.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96894);
                Log.v("MicroMsg.SightPlayController", "set background drawable null");
                localView2.setBackgroundDrawable(null);
                AppMethodBeat.o(96894);
              }
            });
          }
        }
        if (this.Dnm.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(b.m(b.this), 0);
          AppMethodBeat.o(96896);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(b.m(b.this), (Bitmap)this.Dnm.get(), b.o(b.this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b
 * JD-Core Version:    0.7.0.1
 */