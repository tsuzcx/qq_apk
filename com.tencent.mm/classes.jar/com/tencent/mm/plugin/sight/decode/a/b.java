package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
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
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.a.vy.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> wrP = new HashMap();
  private static Map<String, Integer> wrT = new ConcurrentHashMap();
  public String cnm = "";
  private boolean hqZ = false;
  public boolean hyg = true;
  private Surface mSurface;
  private ap oFl;
  public int position;
  private Animation wrA;
  private Animation wrB;
  private volatile h wrC;
  private volatile b wrD;
  public volatile i wrE;
  private volatile c wrF;
  private k wrG;
  private j wrH;
  private d wrI;
  private f wrJ = new f()
  {
    public final void b(b paramAnonymousb, long paramAnonymousLong) {}
  };
  public boolean wrK = true;
  public boolean wrL = true;
  public boolean wrM = false;
  public boolean wrN = false;
  public boolean wrO = false;
  public boolean wrQ = false;
  public double wrR = -1.0D;
  boolean wrS = false;
  public double wrU = -1.0D;
  private boolean wrV = false;
  public boolean wrW = false;
  private a wrX;
  public volatile e wrY;
  private volatile f wrZ;
  private int wrn = 0;
  private int wro = 0;
  private String wrp = "";
  private int wrq = -1;
  private Queue<Integer> wrr = new ConcurrentLinkedQueue();
  protected int wrs = 41;
  private Bitmap wrt;
  public Bitmap wru;
  private Bitmap wrv;
  private WeakReference<View> wrw;
  private WeakReference<TextView> wrx;
  private long wry;
  public WeakReference<View> wrz;
  public volatile g wsa;
  
  public b(int paramInt, View paramView)
  {
    this.wro = paramInt;
    this.oFl = new ap(Looper.getMainLooper());
    this.wrz = new WeakReference(paramView);
    ad.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void LR(final int paramInt)
  {
    com.tencent.mm.modelvideo.o.h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116074);
        long l = System.currentTimeMillis();
        SightVideoJNI.freeObj(paramInt);
        ad.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(116074);
      }
    }, 0L);
  }
  
  public static boolean anp(String paramString)
  {
    if (bt.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)wrT.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  public static void aoS()
  {
    com.tencent.mm.modelvideo.o.h(new b.2(), 0L);
  }
  
  public static Bitmap b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = String.format("%s-%s-%s-%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = (WeakReference)wrP.get(str);
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      return (Bitmap)((WeakReference)localObject).get();
    }
    if (paramContext == null)
    {
      ad.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
      return null;
    }
    if (paramInt1 <= 0)
    {
      ad.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
      return null;
    }
    if ((paramInt2 <= 0) || (paramInt4 <= 0) || (paramInt3 <= 0))
    {
      ad.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
      return null;
    }
    long l = bt.GC();
    paramInt3 = paramInt2 * paramInt4 / paramInt3;
    paramContext = (NinePatchDrawable)paramContext.getResources().getDrawable(paramInt1);
    paramContext.setBounds(0, 0, paramInt2, paramInt3);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    paramContext.draw(new Canvas((Bitmap)localObject));
    wrP.put(str, new WeakReference(localObject));
    ad.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[] { Long.valueOf(bt.aS(l)) });
    return localObject;
  }
  
  private void d(Queue<Integer> paramQueue)
  {
    for (;;)
    {
      Integer localInteger = (Integer)paramQueue.poll();
      if (localInteger == null) {
        break;
      }
      LR(localInteger.intValue());
    }
  }
  
  public final void ad(Bitmap paramBitmap)
  {
    boolean bool = true;
    if (paramBitmap == null) {}
    for (;;)
    {
      ad.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.modelvideo.o.F(this.wrG);
      if (this.wrG == null) {
        this.wrG = new k((byte)0);
      }
      this.wrG.wsl = new WeakReference(paramBitmap);
      com.tencent.mm.modelvideo.o.h(this.wrG, 0L);
      return;
      bool = false;
    }
  }
  
  public abstract void ae(Bitmap paramBitmap);
  
  public final void bt(String paramString, boolean paramBoolean)
  {
    ad.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(hashCode()), paramString, this.cnm, Boolean.valueOf(paramBoolean), Integer.valueOf(this.wrq), Boolean.valueOf(this.wrW), Boolean.valueOf(this.wrL) });
    if (this.wrW)
    {
      pz(false);
      return;
    }
    if (dqr())
    {
      ad.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      clear();
      return;
    }
    if (!this.wrL)
    {
      clear();
      return;
    }
    if (paramBoolean)
    {
      this.wrp = paramString;
      pz(false);
      return;
    }
    if (this.cnm.equals(paramString))
    {
      this.wrp = "ERROR#PATH";
      pz(false);
      restart();
      return;
    }
    clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.cnm = str;
    if (bt.isNullOrNil(this.cnm))
    {
      ad.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      ad(null);
      return;
    }
    if (!anp(this.cnm))
    {
      ad.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.wrC = new h((byte)0);
    com.tencent.mm.modelvideo.o.h(this.wrC, 0L);
  }
  
  public final void clear()
  {
    ad.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wrq), Boolean.valueOf(dqq()) });
    pz(true);
    this.wry = 0L;
    d(this.wrr);
    this.wrq = -1;
    this.cnm = "";
    this.wrp = "ERROR#PATH";
    this.wrv = null;
    this.wrR = 0.0D;
    this.wrS = false;
    com.tencent.mm.memory.o.gEi.f(this.wrt);
    this.wrt = null;
  }
  
  public abstract void dY(int paramInt1, int paramInt2);
  
  protected int dqp()
  {
    return -1;
  }
  
  public final boolean dqq()
  {
    if (1 == this.wro) {
      if ((this.wrD == null) || (this.wrD.stop)) {}
    }
    while ((this.wrF != null) && (!this.wrF.stop) && (this.wrD != null) && (!this.wrD.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean dqr()
  {
    if (this.wrQ) {}
    do
    {
      do
      {
        return false;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
      } while (this.wrn < 3);
      ad.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
      this.wrn = 0;
      return false;
    } while (this.wrn < 3);
    return true;
  }
  
  protected final void dqs()
  {
    int i = Math.max(1, (int)SightVideoJNI.getVideoRate(this.wrq));
    this.wrs = (1000 / i);
    ad.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.wrs) });
  }
  
  public final c dqt()
  {
    if (this.wrX == null) {
      this.wrX = new a(this);
    }
    return this.wrX;
  }
  
  public final double dqu()
  {
    if (this.wrq == -1) {
      return 0.0D;
    }
    return SightVideoJNI.getVideoDuration(this.wrq);
  }
  
  public final void k(Surface paramSurface)
  {
    ad.v("MicroMsg.SightPlayController", "set play surface %s", new Object[] { paramSurface });
    this.mSurface = paramSurface;
    com.tencent.mm.modelvideo.o.h(this.wrG, 0L);
  }
  
  public final void pz(boolean paramBoolean)
  {
    if (this.wrC != null)
    {
      com.tencent.mm.modelvideo.o.F(this.wrC);
      this.wrC.stop = true;
    }
    if (this.wrF != null)
    {
      this.oFl.removeCallbacks(this.wrF);
      this.wrF.stop = true;
    }
    if (this.wrD != null)
    {
      com.tencent.mm.modelvideo.o.F(this.wrD);
      this.wrD.stop = true;
    }
    i locali;
    if (this.wrE != null)
    {
      locali = this.wrE;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.h(this.wrE, 0L);
      return;
    }
  }
  
  public final void restart()
  {
    ad.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.wrL), this.cnm, Integer.valueOf(this.wrq) });
    if (!this.wrL) {
      clear();
    }
    do
    {
      return;
      if (dqq())
      {
        ad.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cnm });
        return;
      }
      if (this.wrq < 0) {}
      for (boolean bool = true;; bool = false)
      {
        pz(bool);
        this.wry = 0L;
        if (!dqr()) {
          break;
        }
        ad.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[] { Integer.valueOf(hashCode()) });
        return;
      }
      if (this.wrq >= 0) {
        break;
      }
      ad.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cnm });
    } while (bt.isNullOrNil(this.cnm));
    if (!anp(this.cnm))
    {
      ad.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.wrC = new h((byte)0);
    com.tencent.mm.modelvideo.o.h(this.wrC, 0L);
    return;
    if (1 == this.wro)
    {
      this.wrD = new b((byte)0);
      this.wrF = null;
      com.tencent.mm.modelvideo.o.h(this.wrD, 0L);
      return;
    }
    this.wrD = new b((byte)0);
    this.wrF = new c();
    this.wrD.wsf = this.wrF;
    this.wrF.wsi = this.wrD;
    com.tencent.mm.modelvideo.o.h(this.wrD, 0L);
  }
  
  public final void setOnDecodeDurationListener(f paramf)
  {
    if (paramf == null) {
      this.wrZ = this.wrJ;
    }
    this.wrZ = paramf;
  }
  
  public final void setSightInfoView(TextView paramTextView)
  {
    this.wrx = new WeakReference(paramTextView);
  }
  
  public final void setThumbBgView(View paramView)
  {
    this.wrw = new WeakReference(paramView);
  }
  
  static final class a
    extends c<vy>
  {
    int qYg;
    int qeb;
    int wsd;
    WeakReference<b> wse;
    
    public a(b paramb)
    {
      super();
      AppMethodBeat.i(116075);
      this.qYg = 0;
      this.wsd = 0;
      this.qeb = 0;
      this.wse = new WeakReference(paramb);
      this.__eventId = vy.class.getName().hashCode();
      AppMethodBeat.o(116075);
    }
    
    private void a(vy paramvy)
    {
      this.qYg = paramvy.dBv.dBy;
      this.wsd = paramvy.dBv.dBw;
      this.qeb = paramvy.dBv.dBx;
    }
    
    private boolean dqw()
    {
      AppMethodBeat.i(116076);
      if (this.wse.get() == null)
      {
        AppMethodBeat.o(116076);
        return false;
      }
      int i = b.G((b)this.wse.get()) + this.qYg;
      if ((i < this.wsd) || (i > this.qeb))
      {
        AppMethodBeat.o(116076);
        return false;
      }
      AppMethodBeat.o(116076);
      return true;
    }
  }
  
  final class b
    implements Runnable
  {
    volatile boolean stop = false;
    b.c wsf;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(116083);
      if ((b.s(b.this) != null) && (b.s(b.this).dqy() != null) && (b.s(b.this).dqy().getVisibility() == 0)) {
        b.h(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116078);
            b.s(b.this).dqy().setVisibility(8);
            AppMethodBeat.o(116078);
          }
        });
      }
      if (b.e(b.this) < 0)
      {
        ad.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.a(b.this) });
        AppMethodBeat.o(116083);
        return;
      }
      if (this.stop)
      {
        ad.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(116083);
        return;
      }
      if (b.t(b.this) == 0L)
      {
        if (b.u(b.this) != null)
        {
          b.u(b.this).type = 1;
          b.u(b.this).run();
        }
        b.a(b.this, System.currentTimeMillis());
      }
      int j = 0;
      int i = j;
      if (b.v(b.this) != -1.0D)
      {
        if (b.this.wrM) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.v(b.this), b.e(b.this)) > 0)
        {
          if (b.u(b.this) == null) {
            b.a(b.this, new b.i(b.this, (byte)0));
          }
          b.u(b.this).type = 4;
          b.u(b.this).wrU = b.v(b.this);
          b.u(b.this).run();
          i = 1;
        }
      }
      float f3 = (float)(System.currentTimeMillis() - b.t(b.this));
      float f1;
      label375:
      float f2;
      double d;
      if (i != 0)
      {
        f1 = 0.0F;
        f2 = f1;
        if (b.this.wrM)
        {
          f2 = f1;
          if (b.w(b.this))
          {
            b.a(b.this, false);
            f2 = f1;
            if (b.u(b.this) != null)
            {
              d = b.u(b.this).dqA() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, b.e(b.this)) > 0)
              {
                f2 = 0.0F;
                ad.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (b.x(b.this)) {
          ad.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), Float.valueOf(f3), Float.valueOf(f2) });
        }
        b.a(b.this, System.currentTimeMillis());
        if (f2 < 2.0F) {
          break label813;
        }
        b.y(b.this);
      }
      for (;;)
      {
        if (!b.c(b.this)) {
          break label837;
        }
        ad.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.z(b.this)) });
        b.this.clear();
        AppMethodBeat.o(116083);
        return;
        label620:
        if (b.u(b.this) != null)
        {
          b.u(b.this).type = 4;
          b.u(b.this).wrU = b.v(b.this);
          b.u(b.this).run();
          b.h(b.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116079);
              b.a(b.this, true);
              AppMethodBeat.o(116079);
            }
          }, 100L);
          i = j;
          break;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.v(b.this), b.e(b.this)) <= 0) {
          break;
        }
        if (b.u(b.this) == null) {
          b.a(b.this, new b.i(b.this, (byte)0));
        }
        b.u(b.this).type = 4;
        b.u(b.this).wrU = b.v(b.this);
        b.u(b.this).run();
        i = 1;
        break;
        f1 = f3 / b.this.wrs + 0.5F;
        break label375;
        label813:
        b.b(b.this, Math.max(0, b.z(b.this) - 1));
      }
      label837:
      int k = 0;
      i = 0;
      j = 0;
      if (1 == b.d(b.this)) {
        if ((b.o(b.this) != null) && (!b.o(b.this).isValid()))
        {
          ad.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          this.stop = true;
          if (this.wsf == null) {
            break label2266;
          }
          this.wsf.stop = true;
          i = 0;
        }
      }
      for (;;)
      {
        if (b.u(b.this) != null) {
          ad.d("MicroMsg.SightPlayController", "voice time is" + b.u(b.this).dqA() / 1000.0D);
        }
        for (;;)
        {
          for (;;)
          {
            if (1 == j) {
              b.h(b.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(116081);
                  if (b.b(b.this) != null) {
                    b.b(b.this).c(b.this, 0);
                  }
                  AppMethodBeat.o(116081);
                }
              });
            }
            if (!this.stop) {
              break label2005;
            }
            ad.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
            if (b.u(b.this) != null)
            {
              b.u(b.this).type = 0;
              b.u(b.this).run();
            }
            AppMethodBeat.o(116083);
            return;
            try
            {
              for (;;)
              {
                j = SightVideoJNI.drawSurfaceFrame(b.e(b.this), b.o(b.this), (int)f2, b.q(b.this), b.A(b.this));
                i = j;
                if (b.B(b.this) != null)
                {
                  i = j;
                  if (b.B(b.this) != b.C(b.this))
                  {
                    i = j;
                    d = SightVideoJNI.getVideoPlayTime(b.e(b.this));
                    k = (int)d;
                    i = j;
                    if (k != (int)b.this.wrR)
                    {
                      i = j;
                      if (b.B(b.this) != null)
                      {
                        i = j;
                        b.B(b.this).b(b.this, k);
                      }
                    }
                    i = j;
                    b.this.wrR = d;
                  }
                }
                if (j == 0)
                {
                  i = j;
                  b.a(b.this, -1.0D);
                  i = 0;
                  break;
                }
                if (1 != j) {
                  break label1343;
                }
                i = j;
                b.a(b.this, -1.0D);
                k = 1;
                i = 1;
                try
                {
                  b.a(b.this, 0L);
                  b.D(b.this);
                }
                catch (Exception localException1)
                {
                  i = k;
                }
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                label1343:
                int m;
                label1823:
                label2005:
                long l;
                k = 0;
                j = i;
                i = k;
              }
            }
          }
          ad.e("MicroMsg.SightPlayController", "decode job:%s", new Object[] { localException1.getMessage() });
          break;
          if (-7 == j)
          {
            i = j;
            ad.w("MicroMsg.SightPlayController", "surface is null, continue");
            i = 0;
            break;
          }
          i = j;
          ad.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
          i = j;
          this.stop = true;
          i = j;
          if (this.wsf != null)
          {
            i = j;
            this.wsf.stop = true;
          }
          i = j;
          b.this.ad(null);
          i = j;
          if (b.b(b.this) != null)
          {
            i = j;
            b.b(b.this).c(b.this, -1);
          }
          i = 0;
          break;
          m = SightVideoJNI.drawFrame(b.e(b.this), b.E(b.this), (int)f2, null, false, b.A(b.this));
          if (b.B(b.this) != null)
          {
            d = SightVideoJNI.getVideoPlayTime(b.e(b.this));
            i = (int)d;
            if (i != (int)b.this.wrR) {
              b.B(b.this).b(b.this, i);
            }
            b.this.wrR = d;
            if (b.x(b.this)) {
              ad.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
            }
          }
          for (;;)
          {
            if (m != 0) {
              break label1823;
            }
            b.a(b.this, -1.0D);
            j = m;
            i = k;
            break;
            if (b.x(b.this))
            {
              d = SightVideoJNI.getVideoPlayTime(b.e(b.this));
              if (b.x(b.this)) {
                ad.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (b.x(b.this))
            {
              ad.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            }
          }
          if (1 == m)
          {
            b.a(b.this, -1.0D);
            i = 1;
            b.a(b.this, 0L);
            b.D(b.this);
            j = m;
          }
          else
          {
            b.a(b.this, -1.0D);
            ad.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            this.stop = true;
            if (this.wsf != null) {
              this.wsf.stop = true;
            }
            b.h(b.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116080);
                b.this.ae(null);
                AppMethodBeat.o(116080);
              }
            });
            j = m;
            i = k;
            if (b.b(b.this) != null)
            {
              b.b(b.this).c(b.this, -1);
              j = m;
              i = k;
              continue;
              if (1 == b.d(b.this))
              {
                l = b.this.wrs - (System.currentTimeMillis() - b.t(b.this));
                if (b.t(b.this) == 0L) {
                  com.tencent.mm.modelvideo.o.h(this, b.this.wrs * 5);
                }
              }
              for (;;)
              {
                if (b.u(b.this) != null) {
                  ad.d("MicroMsg.SightPlayController", "voice time is" + b.u(b.this).dqA() / 1000.0D);
                }
                AppMethodBeat.o(116083);
                return;
                if (l > 0L)
                {
                  com.tencent.mm.modelvideo.o.h(this, l);
                }
                else
                {
                  com.tencent.mm.modelvideo.o.h(this, 0L);
                  continue;
                  if ((i != 0) && (b.s(b.this) != null))
                  {
                    i = b.s(b.this).dqx();
                    b.h(b.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(116082);
                        if (b.s(b.this) != null)
                        {
                          View localView = b.s(b.this).dqy();
                          if (localView != null)
                          {
                            if ((b.F(b.this) == null) && (b.s(b.this).dqz() != -1) && (b.m(b.this).get() != null)) {
                              b.a(b.this, AnimationUtils.loadAnimation(((View)b.m(b.this).get()).getContext(), b.s(b.this).dqz()));
                            }
                            if (b.F(b.this) != null) {
                              localView.startAnimation(b.F(b.this));
                            }
                            localView.setVisibility(0);
                          }
                        }
                        AppMethodBeat.o(116082);
                      }
                    });
                    this.wsf.wsh = j;
                    b.h(b.this).postDelayed(this.wsf, i);
                  }
                  else
                  {
                    this.wsf.wsh = j;
                    b.h(b.this).post(this.wsf);
                  }
                }
              }
            }
          }
        }
        label2266:
        i = 0;
      }
    }
  }
  
  final class c
    implements Runnable
  {
    volatile boolean stop;
    int wsh;
    b.b wsi;
    
    public c()
    {
      AppMethodBeat.i(116084);
      this.stop = false;
      ad.i("MicroMsg.SightPlayController", "make sure drawJob alive");
      AppMethodBeat.o(116084);
    }
    
    public final void run()
    {
      AppMethodBeat.i(116085);
      if (this.stop)
      {
        ad.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(116085);
        return;
      }
      b.this.ae(b.E(b.this));
      if (b.t(b.this) == 0L)
      {
        com.tencent.mm.modelvideo.o.h(this.wsi, 0L);
        AppMethodBeat.o(116085);
        return;
      }
      long l = b.this.wrs - (System.currentTimeMillis() - b.t(b.this));
      if (l > 0L)
      {
        com.tencent.mm.modelvideo.o.h(this.wsi, l);
        AppMethodBeat.o(116085);
        return;
      }
      com.tencent.mm.modelvideo.o.h(this.wsi, 0L);
      AppMethodBeat.o(116085);
    }
  }
  
  final class d
    implements Runnable
  {
    private d() {}
    
    public final void run()
    {
      AppMethodBeat.i(116086);
      if (b.m(b.this).get() == null)
      {
        AppMethodBeat.o(116086);
        return;
      }
      ((View)b.m(b.this).get()).startAnimation(b.n(b.this));
      AppMethodBeat.o(116086);
    }
  }
  
  public static abstract interface e
  {
    public abstract void c(b paramb, int paramInt);
  }
  
  public static abstract interface f
  {
    public abstract void b(b paramb, long paramLong);
  }
  
  public static abstract interface g
  {
    public abstract int dqx();
    
    public abstract View dqy();
    
    public abstract int dqz();
  }
  
  final class h
    implements Runnable
  {
    volatile boolean stop = false;
    
    private h() {}
    
    public final void run()
    {
      AppMethodBeat.i(116087);
      if (b.c(b.this))
      {
        ad.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
        AppMethodBeat.o(116087);
        return;
      }
      b localb = b.this;
      String str = b.a(b.this);
      if (1 == b.d(b.this)) {}
      for (int i = 0;; i = 1)
      {
        b.a(localb, SightVideoJNI.openFileVFS(str, i, 1, false));
        ad.i("MicroMsg.SightPlayController", "SightVideoJNI.openFile mVideoPath:%s mVideoId:%s", new Object[] { b.a(b.this), Integer.valueOf(b.e(b.this)) });
        b.f(b.this).offer(Integer.valueOf(b.e(b.this)));
        if (b.e(b.this) >= 0) {
          break;
        }
        ad.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), b.a(b.this) });
        b.this.ad(null);
        if (b.b(b.this) != null) {
          b.b(b.this).c(b.this, -1);
        }
        AppMethodBeat.o(116087);
        return;
      }
      if (((Boolean)g.afB().afk().get(344065, Boolean.FALSE)).booleanValue())
      {
        if (b.g(b.this) == null) {
          b.a(b.this, new b.j(b.this, (byte)0));
        }
        b.h(b.this).removeCallbacks(b.g(b.this));
        b.h(b.this).post(b.g(b.this));
      }
      i = Math.max(1, SightVideoJNI.getVideoWidth(b.e(b.this)));
      int j = Math.max(1, SightVideoJNI.getVideoHeight(b.e(b.this)));
      if (b.d(b.this) == 0)
      {
        if (b.i(b.this))
        {
          if ((i * j > 1152000) || (i <= 0) || (j <= 0))
          {
            ad.e("MicroMsg.SightPlayController", "get error info for ad,  videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(116087);
          }
        }
        else if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
        {
          ad.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(116087);
          return;
        }
        b.a(b.this, i, j);
      }
      b.this.dqs();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        ad.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!bt.isNullOrNil(b.a(b.this))) {
          b.dqv().put(b.a(b.this), Integer.valueOf(2));
        }
        b.a(b.this, 0L);
        b.a(b.this, b.f(b.this));
        b.a(b.this, -1);
        b.a(b.this, "");
        b.b(b.this, "ERROR#PATH");
        b.a(b.this, null);
        this.stop = true;
        if (b.b(b.this) != null) {
          b.b(b.this).c(b.this, -1);
        }
        AppMethodBeat.o(116087);
        return;
      }
      b.this.dY(i, j);
      if (1 == b.d(b.this))
      {
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, null);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.h(b.j(b.this), 0L);
        }
      }
      for (;;)
      {
        if (this.stop) {
          ad.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
        }
        AppMethodBeat.o(116087);
        return;
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, new b.c(b.this));
        b.j(b.this).wsf = b.k(b.this);
        b.k(b.this).wsi = b.j(b.this);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.h(b.j(b.this), 0L);
        }
      }
    }
  }
  
  public final class i
    implements Runnable
  {
    public int type;
    double wrU = -1.0D;
    MediaPlayer wsj;
    
    private i() {}
    
    private void cVg()
    {
      AppMethodBeat.i(116089);
      ad.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.wsj != null)
        {
          this.wsj.stop();
          this.wsj.release();
          this.wsj = null;
        }
        AppMethodBeat.o(116089);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.wsj = null;
        AppMethodBeat.o(116089);
      }
    }
    
    public final double dqA()
    {
      AppMethodBeat.i(116090);
      if (this.wsj == null)
      {
        AppMethodBeat.o(116090);
        return 0.0D;
      }
      double d = this.wsj.getCurrentPosition();
      AppMethodBeat.o(116090);
      return d;
    }
    
    public final void run()
    {
      AppMethodBeat.i(116091);
      String str;
      switch (this.type)
      {
      default: 
        str = "unknown";
        ad.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
        switch (this.type)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(116091);
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
        cVg();
        if (!bt.isNullOrNil(b.a(b.this)))
        {
          try
          {
            this.wsj = new k();
            this.wsj.setDisplay(null);
            this.wsj.reset();
            this.wsj.setDataSource(i.k(b.a(b.this), false));
            this.wsj.setAudioStreamType(3);
            this.wsj.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(116088);
                ad.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(b.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                b.this.clear();
                if (b.b(b.this) != null) {
                  b.b(b.this).c(b.this, -1);
                }
                AppMethodBeat.o(116088);
                return true;
              }
            });
            this.wsj.prepare();
            this.wsj.start();
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException1)
          {
            ad.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            ad.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.a(b.this) });
            b.this.clear();
            if (b.b(b.this) != null) {
              b.b(b.this).c(b.this, -1);
            }
            AppMethodBeat.o(116091);
            return;
          }
          cVg();
          AppMethodBeat.o(116091);
          return;
          try
          {
            if ((this.wsj != null) && (this.wsj.isPlaying())) {
              this.wsj.pause();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException2)
          {
            ad.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            cVg();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            if (this.wsj != null) {
              this.wsj.start();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException3)
          {
            ad.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            cVg();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            ad.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.wrU) });
            this.wsj.seekTo((int)(this.wrU * 1000.0D));
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException4)
          {
            ad.printErrStackTrace("MicroMsg.SightPlayController", localException4, "seek sound error: %s", new Object[] { localException4.getMessage() });
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
      AppMethodBeat.i(116092);
      if ((b.e(b.this) < 0) || (b.l(b.this) == null) || (b.l(b.this).get() == null))
      {
        AppMethodBeat.o(116092);
        return;
      }
      String str = SightVideoJNI.getVideoInfo(b.e(b.this));
      ((TextView)b.l(b.this).get()).setText(str);
      AppMethodBeat.o(116092);
    }
  }
  
  final class k
    implements Runnable
  {
    WeakReference<Bitmap> wsl;
    
    private k()
    {
      AppMethodBeat.i(116096);
      this.wsl = new WeakReference(null);
      AppMethodBeat.o(116096);
    }
    
    public final void run()
    {
      final View localView1 = null;
      boolean bool6 = true;
      boolean bool5 = true;
      AppMethodBeat.i(116097);
      boolean bool2;
      label75:
      label88:
      label101:
      final Bitmap localBitmap;
      try
      {
        if ((b.o(b.this) != null) && (b.o(b.this).isValid())) {
          break label713;
        }
        i = b.this.hashCode();
        j = hashCode();
        boolean bool3;
        boolean bool4;
        if (b.o(b.this) == null)
        {
          bool1 = true;
          if (b.p(b.this) != null) {
            break label276;
          }
          bool2 = true;
          if (this.wsl.get() != null) {
            break label282;
          }
          bool3 = true;
          if (b.q(b.this) != null) {
            break label288;
          }
          bool4 = true;
          ad.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (b.q(b.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.wsl.get();
          if (b.p(b.this) != null) {
            localView1 = (View)b.p(b.this).get();
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
          ad.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(116097);
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
            AppMethodBeat.i(116093);
            localView1.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            AppMethodBeat.o(116093);
          }
        });
        AppMethodBeat.o(116097);
        return;
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
        AppMethodBeat.o(116097);
        return;
      }
      label350:
      if ((b.r(b.this) != null) && (b.r(b.this).getWidth() == b.q(b.this).getWidth()))
      {
        i = b.r(b.this).getHeight();
        j = b.q(b.this).getHeight();
        if (i == j) {
          break label444;
        }
      }
      label444:
      label506:
      final View localView2;
      try
      {
        b.a(b.this, Bitmap.createBitmap(b.q(b.this).getWidth(), b.q(b.this).getHeight(), Bitmap.Config.ARGB_8888));
        if ((b.r(b.this) == null) || (this.wsl.get() == null) || (((Bitmap)this.wsl.get()).isRecycled()))
        {
          if (b.r(b.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.wsl.get() != null) {
            break label883;
          }
          bool2 = bool6;
          ad.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(116097);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.SightPlayController", localException2, "try to create thumb bmp error:%s", new Object[] { localException2.getMessage() });
          b.a(b.this, null);
        }
        long l = System.nanoTime();
        SightVideoJNI.handleThumb((Bitmap)this.wsl.get(), b.r(b.this), b.q(b.this));
        ad.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
        localBitmap = b.r(b.this);
        if (b.p(b.this) != null) {}
        for (localView2 = (View)b.p(b.this).get(); (localView2 == null) || (localBitmap == null); localView2 = null)
        {
          AppMethodBeat.o(116097);
          return;
        }
        localView2.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116094);
            localView2.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            AppMethodBeat.o(116094);
          }
        });
        AppMethodBeat.o(116097);
        return;
      }
      label713:
      int i = b.this.hashCode();
      int j = hashCode();
      if (this.wsl.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ad.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (b.p(b.this) != null)
        {
          localView2 = (View)b.p(b.this).get();
          if (localView2 != null) {
            localView2.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116095);
                ad.v("MicroMsg.SightPlayController", "set background drawable null");
                localView2.setBackgroundDrawable(null);
                AppMethodBeat.o(116095);
              }
            });
          }
        }
        if (this.wsl.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(b.o(b.this), 0);
          AppMethodBeat.o(116097);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(b.o(b.this), (Bitmap)this.wsl.get(), b.q(b.this));
        AppMethodBeat.o(116097);
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
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b
 * JD-Core Version:    0.7.0.1
 */