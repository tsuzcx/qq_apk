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
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.a.wj.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> xDf = new HashMap();
  private static Map<String, Integer> xDj = new ConcurrentHashMap();
  String cko = "";
  private ao gqT = new ao(Looper.getMainLooper());
  private boolean hRB = false;
  boolean hYH = true;
  private Surface mSurface;
  int position;
  private int xCD = 0;
  private int xCE = 0;
  String xCF = "";
  int xCG = -1;
  protected int xCI = 41;
  private Bitmap xCJ;
  private Bitmap xCK;
  private Bitmap xCL;
  WeakReference<View> xCM;
  WeakReference<TextView> xCN;
  private long xCO;
  private WeakReference<View> xCP;
  private Animation xCQ;
  private Animation xCR;
  boolean xDb = true;
  public boolean xDc = false;
  public boolean xDg = false;
  double xDh = -1.0D;
  boolean xDi = false;
  double xDk = -1.0D;
  private boolean xDl = false;
  boolean xDm = false;
  volatile h yqK;
  private volatile b yqL;
  volatile i yqM;
  private volatile c yqN;
  private k yqO;
  private j yqP;
  private d yqQ;
  private a yqR;
  e yqS;
  f yqT;
  g yqU;
  
  public b(View paramView)
  {
    this.xCP = new WeakReference(paramView);
    ac.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(0) });
  }
  
  private void NR(int paramInt)
  {
    com.tencent.mm.modelvideo.o.h(new b.1(this, paramInt), 0L);
  }
  
  public static boolean asy(String paramString)
  {
    if (bs.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)xDj.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  public abstract void af(Bitmap paramBitmap);
  
  public final void clear()
  {
    ac.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.xCG), Boolean.valueOf(dEz()) });
    qy(true);
    this.xCO = 0L;
    NR(this.xCG);
    this.xCG = -1;
    this.cko = "";
    this.xCF = "ERROR#PATH";
    this.xCL = null;
    this.xDh = 0.0D;
    this.xDi = false;
    com.tencent.mm.memory.o.heJ.f(this.xCJ);
    this.xCJ = null;
  }
  
  final boolean dEA()
  {
    if (this.xDg) {}
    do
    {
      do
      {
        return false;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
      } while (this.xCD < 3);
      ac.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
      this.xCD = 0;
      return false;
    } while (this.xCD < 3);
    return true;
  }
  
  protected final void dEB()
  {
    int i = Math.max(1, (int)SightVideoJNI.getVideoRate(this.xCG));
    this.xCI = (1000 / i);
    ac.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.xCI) });
  }
  
  public final c dEC()
  {
    if (this.yqR == null) {
      this.yqR = new a(this);
    }
    return this.yqR;
  }
  
  protected int dEy()
  {
    return -1;
  }
  
  public final boolean dEz()
  {
    if (1 == this.xCE) {
      if ((this.yqL == null) || (this.yqL.stop)) {}
    }
    while ((this.yqN != null) && (!this.yqN.stop) && (this.yqL != null) && (!this.yqL.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final void dLg()
  {
    ac.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.TRUE });
    com.tencent.mm.modelvideo.o.H(this.yqO);
    if (this.yqO == null) {
      this.yqO = new k((byte)0);
    }
    this.yqO.xDB = new WeakReference(null);
    com.tencent.mm.modelvideo.o.h(this.yqO, 0L);
  }
  
  public abstract void dZ(int paramInt1, int paramInt2);
  
  public final void qy(boolean paramBoolean)
  {
    if (this.yqK != null)
    {
      com.tencent.mm.modelvideo.o.H(this.yqK);
      this.yqK.stop = true;
    }
    if (this.yqN != null)
    {
      this.gqT.removeCallbacks(this.yqN);
      this.yqN.stop = true;
    }
    if (this.yqL != null)
    {
      com.tencent.mm.modelvideo.o.H(this.yqL);
      this.yqL.stop = true;
    }
    i locali;
    if (this.yqM != null)
    {
      locali = this.yqM;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.h(this.yqM, 0L);
      return;
    }
  }
  
  public final void restart()
  {
    ac.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.xDb), this.cko, Integer.valueOf(this.xCG) });
    if (!this.xDb) {
      clear();
    }
    do
    {
      return;
      if (dEz())
      {
        ac.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cko });
        return;
      }
      if (this.xCG < 0) {}
      for (boolean bool = true;; bool = false)
      {
        qy(bool);
        this.xCO = 0L;
        if (!dEA()) {
          break;
        }
        ac.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[] { Integer.valueOf(hashCode()) });
        return;
      }
      if (this.xCG >= 0) {
        break;
      }
      ac.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cko });
    } while (bs.isNullOrNil(this.cko));
    if (!asy(this.cko))
    {
      ac.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.yqK = new h((byte)0);
    com.tencent.mm.modelvideo.o.h(this.yqK, 0L);
    return;
    if (1 == this.xCE)
    {
      this.yqL = new b((byte)0);
      this.yqN = null;
      com.tencent.mm.modelvideo.o.h(this.yqL, 0L);
      return;
    }
    this.yqL = new b((byte)0);
    this.yqN = new c();
    this.yqL.yqW = this.yqN;
    this.yqN.yqY = this.yqL;
    com.tencent.mm.modelvideo.o.h(this.yqL, 0L);
  }
  
  static final class a
    extends c<wj>
  {
    int qME;
    int rZI;
    int xDt;
    WeakReference<b> xDu;
    
    public a(b paramb)
    {
      super();
      AppMethodBeat.i(96874);
      this.rZI = 0;
      this.xDt = 0;
      this.qME = 0;
      this.xDu = new WeakReference(paramb);
      this.__eventId = wj.class.getName().hashCode();
      AppMethodBeat.o(96874);
    }
    
    private void a(wj paramwj)
    {
      this.rZI = paramwj.dzj.dzm;
      this.xDt = paramwj.dzj.dzk;
      this.qME = paramwj.dzj.dzl;
    }
    
    private boolean dEF()
    {
      AppMethodBeat.i(96875);
      if (this.xDu.get() == null)
      {
        AppMethodBeat.o(96875);
        return false;
      }
      int i = b.D((b)this.xDu.get()) + this.rZI;
      if ((i < this.xDt) || (i > this.qME))
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
    b.c yqW;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(96882);
      if ((b.q(b.this) != null) && (b.q(b.this).dEH() != null) && (b.q(b.this).dEH().getVisibility() == 0)) {
        b.g(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96877);
            b.q(b.this).dEH().setVisibility(8);
            AppMethodBeat.o(96877);
          }
        });
      }
      if (b.e(b.this) < 0)
      {
        ac.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.a(b.this) });
        AppMethodBeat.o(96882);
        return;
      }
      if (this.stop)
      {
        ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
        if (b.this.xDc) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.t(b.this), b.e(b.this)) > 0)
        {
          if (b.s(b.this) == null) {
            b.a(b.this, new b.i(b.this, (byte)0));
          }
          b.s(b.this).type = 4;
          b.s(b.this).xDk = b.t(b.this);
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
        if (b.this.xDc)
        {
          f2 = f1;
          if (b.u(b.this))
          {
            b.a(b.this, false);
            f2 = f1;
            if (b.s(b.this) != null)
            {
              d = b.s(b.this).dEJ() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, b.e(b.this)) > 0)
              {
                f2 = 0.0F;
                ac.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (b.v(b.this)) {
          ac.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), Float.valueOf(f3), Float.valueOf(f2) });
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
        ac.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.x(b.this)) });
        b.this.clear();
        AppMethodBeat.o(96882);
        return;
        label620:
        if (b.s(b.this) != null)
        {
          b.s(b.this).type = 4;
          b.s(b.this).xDk = b.t(b.this);
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
        b.s(b.this).xDk = b.t(b.this);
        b.s(b.this).run();
        i = 1;
        break;
        f1 = f3 / b.this.xCI + 0.5F;
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
          ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          this.stop = true;
          if (this.yqW == null) {
            break label1394;
          }
          this.yqW.stop = true;
          i = 0;
          j = m;
          if (b.s(b.this) == null) {
            break label2139;
          }
          ac.d("MicroMsg.SightPlayController", "voice time is" + b.s(b.this).dEJ() / 1000.0D);
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
                b.b(b.this).OO(0);
              }
              AppMethodBeat.o(96880);
            }
          });
        }
        if (this.stop)
        {
          ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
            if (j != (int)b.this.xDh) {
              b.z(b.this).xy(j);
            }
            b.this.xDh = d;
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
            ac.w("MicroMsg.SightPlayController", "surface is null, continue");
            k = 0;
            j = i;
            i = k;
            break;
          }
          ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i) });
          this.stop = true;
          if (this.yqW != null) {
            this.yqW.stop = true;
          }
          b.this.dLg();
          j = i;
          if (b.b(b.this) != null)
          {
            b.b(b.this).OO(-1);
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
            if (i != (int)b.this.xDh) {
              b.z(b.this).xy(i);
            }
            b.this.xDh = d;
            if (b.v(b.this)) {
              ac.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
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
                ac.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (b.v(b.this))
            {
              ac.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
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
          ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
          this.stop = true;
          if (this.yqW != null) {
            this.yqW.stop = true;
          }
          b.g(b.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96879);
              b.this.af(null);
              AppMethodBeat.o(96879);
            }
          });
          j = m;
          i = k;
          if (b.b(b.this) == null) {
            continue;
          }
          b.b(b.this).OO(-1);
          j = m;
          i = k;
          continue;
        }
        long l;
        if (1 == b.d(b.this))
        {
          l = b.this.xCI - (System.currentTimeMillis() - b.r(b.this));
          if (b.r(b.this) == 0L) {
            com.tencent.mm.modelvideo.o.h(this, b.this.xCI * 5);
          }
        }
        for (;;)
        {
          if (b.s(b.this) != null) {
            ac.d("MicroMsg.SightPlayController", "voice time is" + b.s(b.this).dEJ() / 1000.0D);
          }
          AppMethodBeat.o(96882);
          return;
          if (l > 0L)
          {
            com.tencent.mm.modelvideo.o.h(this, l);
          }
          else
          {
            com.tencent.mm.modelvideo.o.h(this, 0L);
            continue;
            if ((i != 0) && (b.q(b.this) != null))
            {
              i = b.q(b.this).dEG();
              b.g(b.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(96881);
                  if (b.q(b.this) != null)
                  {
                    View localView = b.q(b.this).dEH();
                    if (localView != null)
                    {
                      if ((b.C(b.this) == null) && (b.q(b.this).dEI() != -1) && (b.k(b.this).get() != null)) {
                        b.a(b.this, AnimationUtils.loadAnimation(((View)b.k(b.this).get()).getContext(), b.q(b.this).dEI()));
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
              this.yqW.xDx = j;
              b.g(b.this).postDelayed(this.yqW, i);
            }
            else
            {
              this.yqW.xDx = j;
              b.g(b.this).post(this.yqW);
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
    int xDx;
    b.b yqY;
    
    public c()
    {
      AppMethodBeat.i(96883);
      this.stop = false;
      ac.i("MicroMsg.SightPlayController", "make sure drawJob alive");
      AppMethodBeat.o(96883);
    }
    
    public final void run()
    {
      AppMethodBeat.i(96884);
      if (this.stop)
      {
        ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(96884);
        return;
      }
      b.this.af(b.B(b.this));
      if (b.r(b.this) == 0L)
      {
        com.tencent.mm.modelvideo.o.h(this.yqY, 0L);
        AppMethodBeat.o(96884);
        return;
      }
      long l = b.this.xCI - (System.currentTimeMillis() - b.r(b.this));
      if (l > 0L)
      {
        com.tencent.mm.modelvideo.o.h(this.yqY, l);
        AppMethodBeat.o(96884);
        return;
      }
      com.tencent.mm.modelvideo.o.h(this.yqY, 0L);
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
    public abstract void OO(int paramInt);
  }
  
  public static abstract interface f
  {
    public abstract void xy(long paramLong);
  }
  
  public static abstract interface g
  {
    public abstract int dEG();
    
    public abstract View dEH();
    
    public abstract int dEI();
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
        ac.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
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
        ac.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), b.a(b.this) });
        b.this.dLg();
        if (b.b(b.this) != null) {
          b.b(b.this).OO(-1);
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
          ac.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(96886);
          return;
        }
        b.a(b.this, i, j);
      }
      b.this.dEB();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        ac.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!bs.isNullOrNil(b.a(b.this))) {
          b.dLh().put(b.a(b.this), Integer.valueOf(2));
        }
        b.a(b.this, 0L);
        b.b(b.this, b.e(b.this));
        b.a(b.this, -1);
        b.a(b.this, "");
        b.b(b.this, "ERROR#PATH");
        b.a(b.this, null);
        this.stop = true;
        if (b.b(b.this) != null) {
          b.b(b.this).OO(-1);
        }
        AppMethodBeat.o(96886);
        return;
      }
      b.this.dZ(i, j);
      if (1 == b.d(b.this))
      {
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, null);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.h(b.h(b.this), 0L);
        }
      }
      for (;;)
      {
        if (this.stop) {
          ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
        }
        AppMethodBeat.o(96886);
        return;
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, new b.c(b.this));
        b.h(b.this).yqW = b.i(b.this);
        b.i(b.this).yqY = b.h(b.this);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.h(b.h(b.this), 0L);
        }
      }
    }
  }
  
  final class i
    implements Runnable
  {
    int type;
    double xDk = -1.0D;
    MediaPlayer xDz;
    
    private i() {}
    
    private void diM()
    {
      AppMethodBeat.i(96888);
      ac.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.xDz != null)
        {
          this.xDz.stop();
          this.xDz.release();
          this.xDz = null;
        }
        AppMethodBeat.o(96888);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.xDz = null;
        AppMethodBeat.o(96888);
      }
    }
    
    public final double dEJ()
    {
      AppMethodBeat.i(96889);
      if (this.xDz == null)
      {
        AppMethodBeat.o(96889);
        return 0.0D;
      }
      double d = this.xDz.getCurrentPosition();
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
        ac.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
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
        diM();
        if (!bs.isNullOrNil(b.a(b.this)))
        {
          try
          {
            this.xDz = new k();
            this.xDz.setDisplay(null);
            this.xDz.reset();
            this.xDz.setDataSource(b.a(b.this));
            this.xDz.setAudioStreamType(3);
            this.xDz.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(96887);
                ac.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(b.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                b.this.clear();
                if (b.b(b.this) != null) {
                  b.b(b.this).OO(-1);
                }
                AppMethodBeat.o(96887);
                return true;
              }
            });
            this.xDz.prepare();
            this.xDz.start();
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException1)
          {
            ac.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            ac.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.a(b.this) });
            b.this.clear();
            if (b.b(b.this) != null) {
              b.b(b.this).OO(-1);
            }
            AppMethodBeat.o(96890);
            return;
          }
          diM();
          AppMethodBeat.o(96890);
          return;
          try
          {
            if ((this.xDz != null) && (this.xDz.isPlaying())) {
              this.xDz.pause();
            }
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException2)
          {
            ac.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            diM();
            AppMethodBeat.o(96890);
            return;
          }
          try
          {
            if (this.xDz != null) {
              this.xDz.start();
            }
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException3)
          {
            ac.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            diM();
            AppMethodBeat.o(96890);
            return;
          }
          try
          {
            ac.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.xDk) });
            this.xDz.seekTo((int)(this.xDk * 1000.0D));
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException4)
          {
            ac.printErrStackTrace("MicroMsg.SightPlayController", localException4, "seek sound error: %s", new Object[] { localException4.getMessage() });
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
    WeakReference<Bitmap> xDB;
    
    private k()
    {
      AppMethodBeat.i(96895);
      this.xDB = new WeakReference(null);
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
          if (this.xDB.get() != null) {
            break label282;
          }
          bool3 = true;
          if (b.o(b.this) != null) {
            break label288;
          }
          bool4 = true;
          ac.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (b.o(b.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.xDB.get();
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
          ac.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
        ac.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
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
        if ((b.p(b.this) == null) || (this.xDB.get() == null) || (((Bitmap)this.xDB.get()).isRecycled()))
        {
          if (b.p(b.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.xDB.get() != null) {
            break label883;
          }
          bool2 = bool6;
          ac.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(96896);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.SightPlayController", localException2, "try to create thumb bmp error:%s", new Object[] { localException2.getMessage() });
          b.a(b.this, null);
        }
        long l = System.nanoTime();
        SightVideoJNI.handleThumb((Bitmap)this.xDB.get(), b.p(b.this), b.o(b.this));
        ac.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
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
      if (this.xDB.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ac.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (b.n(b.this) != null)
        {
          localView2 = (View)b.n(b.this).get();
          if (localView2 != null) {
            localView2.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96894);
                ac.v("MicroMsg.SightPlayController", "set background drawable null");
                localView2.setBackgroundDrawable(null);
                AppMethodBeat.o(96894);
              }
            });
          }
        }
        if (this.xDB.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(b.m(b.this), 0);
          AppMethodBeat.o(96896);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(b.m(b.this), (Bitmap)this.xDB.get(), b.o(b.this));
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