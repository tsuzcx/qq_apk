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
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xg.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> zhZ = new HashMap();
  private static Map<String, Integer> zid = new ConcurrentHashMap();
  public String cvr = "";
  private aq gNm;
  private boolean inI = false;
  public boolean iuX = true;
  private Surface mSurface;
  public int position;
  private int zhA = -1;
  private Queue<Integer> zhB = new ConcurrentLinkedQueue();
  protected int zhC = 41;
  private Bitmap zhD;
  public Bitmap zhE;
  private Bitmap zhF;
  private WeakReference<View> zhG;
  private WeakReference<TextView> zhH;
  private long zhI;
  public WeakReference<View> zhJ;
  private Animation zhK;
  private Animation zhL;
  private volatile h zhM;
  private volatile b zhN;
  public volatile i zhO;
  private volatile c zhP;
  private k zhQ;
  private j zhR;
  private d zhS;
  private f zhT = new f()
  {
    public final void b(b paramAnonymousb, long paramAnonymousLong) {}
  };
  public boolean zhU = true;
  public boolean zhV = true;
  public boolean zhW = false;
  public boolean zhX = false;
  public boolean zhY = false;
  private int zhx = 0;
  private int zhy = 0;
  private String zhz = "";
  public boolean zia = false;
  public double zib = -1.0D;
  boolean zic = false;
  public double zie = -1.0D;
  private boolean zif = false;
  public boolean zig = false;
  private a zih;
  public volatile e zii;
  private volatile f zij;
  public volatile g zik;
  
  public b(int paramInt, View paramView)
  {
    this.zhy = paramInt;
    this.gNm = new aq(Looper.getMainLooper());
    this.zhJ = new WeakReference(paramView);
    ae.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void Qb(final int paramInt)
  {
    com.tencent.mm.modelvideo.o.i(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116074);
        long l = System.currentTimeMillis();
        SightVideoJNI.freeObj(paramInt);
        ae.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(116074);
      }
    }, 0L);
  }
  
  public static void ayL()
  {
    com.tencent.mm.modelvideo.o.i(new b.2(), 0L);
  }
  
  public static boolean ayO(String paramString)
  {
    if (bu.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)zid.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  public static Bitmap b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = String.format("%s-%s-%s-%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = (WeakReference)zhZ.get(str);
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      return (Bitmap)((WeakReference)localObject).get();
    }
    if (paramContext == null)
    {
      ae.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
      return null;
    }
    if (paramInt1 <= 0)
    {
      ae.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
      return null;
    }
    if ((paramInt2 <= 0) || (paramInt4 <= 0) || (paramInt3 <= 0))
    {
      ae.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
      return null;
    }
    long l = bu.HQ();
    paramInt3 = paramInt2 * paramInt4 / paramInt3;
    paramContext = (NinePatchDrawable)paramContext.getResources().getDrawable(paramInt1);
    paramContext.setBounds(0, 0, paramInt2, paramInt3);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    paramContext.draw(new Canvas((Bitmap)localObject));
    zhZ.put(str, new WeakReference(localObject));
    ae.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[] { Long.valueOf(bu.aO(l)) });
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
      Qb(localInteger.intValue());
    }
  }
  
  public final void ah(Bitmap paramBitmap)
  {
    boolean bool = true;
    if (paramBitmap == null) {}
    for (;;)
    {
      ae.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.modelvideo.o.E(this.zhQ);
      if (this.zhQ == null) {
        this.zhQ = new k((byte)0);
      }
      this.zhQ.ziv = new WeakReference(paramBitmap);
      com.tencent.mm.modelvideo.o.i(this.zhQ, 0L);
      return;
      bool = false;
    }
  }
  
  public abstract void ai(Bitmap paramBitmap);
  
  public final void bL(String paramString, boolean paramBoolean)
  {
    ae.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(hashCode()), paramString, this.cvr, Boolean.valueOf(paramBoolean), Integer.valueOf(this.zhA), Boolean.valueOf(this.zig), Boolean.valueOf(this.zhV) });
    if (this.zig)
    {
      rh(false);
      return;
    }
    if (dTA())
    {
      ae.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      clear();
      return;
    }
    if (!this.zhV)
    {
      clear();
      return;
    }
    if (paramBoolean)
    {
      this.zhz = paramString;
      rh(false);
      return;
    }
    if (this.cvr.equals(paramString))
    {
      this.zhz = "ERROR#PATH";
      rh(false);
      restart();
      return;
    }
    clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.cvr = str;
    if (bu.isNullOrNil(this.cvr))
    {
      ae.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      ah(null);
      return;
    }
    if (!ayO(this.cvr))
    {
      ae.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.zhM = new h((byte)0);
    com.tencent.mm.modelvideo.o.i(this.zhM, 0L);
  }
  
  public final void clear()
  {
    ae.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.zhA), Boolean.valueOf(dTz()) });
    rh(true);
    this.zhI = 0L;
    d(this.zhB);
    this.zhA = -1;
    this.cvr = "";
    this.zhz = "ERROR#PATH";
    this.zhF = null;
    this.zib = 0.0D;
    this.zic = false;
    com.tencent.mm.memory.o.hzF.f(this.zhD);
    this.zhD = null;
  }
  
  public final boolean dTA()
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
    if (this.zih == null) {
      this.zih = new a(this);
    }
    return this.zih;
  }
  
  public final double dTD()
  {
    if (this.zhA == -1) {
      return 0.0D;
    }
    return SightVideoJNI.getVideoDuration(this.zhA);
  }
  
  protected int dTy()
  {
    return -1;
  }
  
  public final boolean dTz()
  {
    if (1 == this.zhy) {
      if ((this.zhN == null) || (this.zhN.stop)) {}
    }
    while ((this.zhP != null) && (!this.zhP.stop) && (this.zhN != null) && (!this.zhN.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public abstract void eb(int paramInt1, int paramInt2);
  
  public final void j(Surface paramSurface)
  {
    ae.v("MicroMsg.SightPlayController", "set play surface %s", new Object[] { paramSurface });
    this.mSurface = paramSurface;
    com.tencent.mm.modelvideo.o.i(this.zhQ, 0L);
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
    this.zhM = new h((byte)0);
    com.tencent.mm.modelvideo.o.i(this.zhM, 0L);
    return;
    if (1 == this.zhy)
    {
      this.zhN = new b((byte)0);
      this.zhP = null;
      com.tencent.mm.modelvideo.o.i(this.zhN, 0L);
      return;
    }
    this.zhN = new b((byte)0);
    this.zhP = new c();
    this.zhN.zip = this.zhP;
    this.zhP.zis = this.zhN;
    com.tencent.mm.modelvideo.o.i(this.zhN, 0L);
  }
  
  public final void rh(boolean paramBoolean)
  {
    if (this.zhM != null)
    {
      com.tencent.mm.modelvideo.o.E(this.zhM);
      this.zhM.stop = true;
    }
    if (this.zhP != null)
    {
      this.gNm.removeCallbacks(this.zhP);
      this.zhP.stop = true;
    }
    if (this.zhN != null)
    {
      com.tencent.mm.modelvideo.o.E(this.zhN);
      this.zhN.stop = true;
    }
    i locali;
    if (this.zhO != null)
    {
      locali = this.zhO;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.i(this.zhO, 0L);
      return;
    }
  }
  
  public final void setOnDecodeDurationListener(f paramf)
  {
    if (paramf == null) {
      this.zij = this.zhT;
    }
    this.zij = paramf;
  }
  
  public final void setSightInfoView(TextView paramTextView)
  {
    this.zhH = new WeakReference(paramTextView);
  }
  
  public final void setThumbBgView(View paramView)
  {
    this.zhG = new WeakReference(paramView);
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
      AppMethodBeat.i(116075);
      this.tii = 0;
      this.zin = 0;
      this.rES = 0;
      this.zio = new WeakReference(paramb);
      this.__eventId = xg.class.getName().hashCode();
      AppMethodBeat.o(116075);
    }
    
    private void a(xg paramxg)
    {
      this.tii = paramxg.dMK.dMN;
      this.zin = paramxg.dMK.dML;
      this.rES = paramxg.dMK.dMM;
    }
    
    private boolean dTF()
    {
      AppMethodBeat.i(116076);
      if (this.zio.get() == null)
      {
        AppMethodBeat.o(116076);
        return false;
      }
      int i = b.G((b)this.zio.get()) + this.tii;
      if ((i < this.zin) || (i > this.rES))
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
    b.c zip;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(116083);
      if ((b.s(b.this) != null) && (b.s(b.this).dTH() != null) && (b.s(b.this).dTH().getVisibility() == 0)) {
        b.h(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116078);
            b.s(b.this).dTH().setVisibility(8);
            AppMethodBeat.o(116078);
          }
        });
      }
      if (b.e(b.this) < 0)
      {
        ae.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.a(b.this) });
        AppMethodBeat.o(116083);
        return;
      }
      if (this.stop)
      {
        ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
        if (b.this.zhW) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.v(b.this), b.e(b.this)) > 0)
        {
          if (b.u(b.this) == null) {
            b.a(b.this, new b.i(b.this, (byte)0));
          }
          b.u(b.this).type = 4;
          b.u(b.this).zie = b.v(b.this);
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
        if (b.this.zhW)
        {
          f2 = f1;
          if (b.w(b.this))
          {
            b.a(b.this, false);
            f2 = f1;
            if (b.u(b.this) != null)
            {
              d = b.u(b.this).dTJ() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, b.e(b.this)) > 0)
              {
                f2 = 0.0F;
                ae.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (b.x(b.this)) {
          ae.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), Float.valueOf(f3), Float.valueOf(f2) });
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
        ae.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.z(b.this)) });
        b.this.clear();
        AppMethodBeat.o(116083);
        return;
        label620:
        if (b.u(b.this) != null)
        {
          b.u(b.this).type = 4;
          b.u(b.this).zie = b.v(b.this);
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
        b.u(b.this).zie = b.v(b.this);
        b.u(b.this).run();
        i = 1;
        break;
        f1 = f3 / b.this.zhC + 0.5F;
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
          ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          this.stop = true;
          if (this.zip == null) {
            break label2266;
          }
          this.zip.stop = true;
          i = 0;
        }
      }
      for (;;)
      {
        if (b.u(b.this) != null) {
          ae.d("MicroMsg.SightPlayController", "voice time is" + b.u(b.this).dTJ() / 1000.0D);
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
            ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
                    if (k != (int)b.this.zib)
                    {
                      i = j;
                      if (b.B(b.this) != null)
                      {
                        i = j;
                        b.B(b.this).b(b.this, k);
                      }
                    }
                    i = j;
                    b.this.zib = d;
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
          ae.e("MicroMsg.SightPlayController", "decode job:%s", new Object[] { localException1.getMessage() });
          break;
          if (-7 == j)
          {
            i = j;
            ae.w("MicroMsg.SightPlayController", "surface is null, continue");
            i = 0;
            break;
          }
          i = j;
          ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
          i = j;
          this.stop = true;
          i = j;
          if (this.zip != null)
          {
            i = j;
            this.zip.stop = true;
          }
          i = j;
          b.this.ah(null);
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
            if (i != (int)b.this.zib) {
              b.B(b.this).b(b.this, i);
            }
            b.this.zib = d;
            if (b.x(b.this)) {
              ae.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
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
                ae.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (b.x(b.this))
            {
              ae.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
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
            ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            this.stop = true;
            if (this.zip != null) {
              this.zip.stop = true;
            }
            b.h(b.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116080);
                b.this.ai(null);
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
                l = b.this.zhC - (System.currentTimeMillis() - b.t(b.this));
                if (b.t(b.this) == 0L) {
                  com.tencent.mm.modelvideo.o.i(this, b.this.zhC * 5);
                }
              }
              for (;;)
              {
                if (b.u(b.this) != null) {
                  ae.d("MicroMsg.SightPlayController", "voice time is" + b.u(b.this).dTJ() / 1000.0D);
                }
                AppMethodBeat.o(116083);
                return;
                if (l > 0L)
                {
                  com.tencent.mm.modelvideo.o.i(this, l);
                }
                else
                {
                  com.tencent.mm.modelvideo.o.i(this, 0L);
                  continue;
                  if ((i != 0) && (b.s(b.this) != null))
                  {
                    i = b.s(b.this).dTG();
                    b.h(b.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(116082);
                        if (b.s(b.this) != null)
                        {
                          View localView = b.s(b.this).dTH();
                          if (localView != null)
                          {
                            if ((b.F(b.this) == null) && (b.s(b.this).dTI() != -1) && (b.m(b.this).get() != null)) {
                              b.a(b.this, AnimationUtils.loadAnimation(((View)b.m(b.this).get()).getContext(), b.s(b.this).dTI()));
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
                    this.zip.zir = j;
                    b.h(b.this).postDelayed(this.zip, i);
                  }
                  else
                  {
                    this.zip.zir = j;
                    b.h(b.this).post(this.zip);
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
    int zir;
    b.b zis;
    
    public c()
    {
      AppMethodBeat.i(116084);
      this.stop = false;
      ae.i("MicroMsg.SightPlayController", "make sure drawJob alive");
      AppMethodBeat.o(116084);
    }
    
    public final void run()
    {
      AppMethodBeat.i(116085);
      if (this.stop)
      {
        ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(116085);
        return;
      }
      b.this.ai(b.E(b.this));
      if (b.t(b.this) == 0L)
      {
        com.tencent.mm.modelvideo.o.i(this.zis, 0L);
        AppMethodBeat.o(116085);
        return;
      }
      long l = b.this.zhC - (System.currentTimeMillis() - b.t(b.this));
      if (l > 0L)
      {
        com.tencent.mm.modelvideo.o.i(this.zis, l);
        AppMethodBeat.o(116085);
        return;
      }
      com.tencent.mm.modelvideo.o.i(this.zis, 0L);
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
      AppMethodBeat.i(116087);
      if (b.c(b.this))
      {
        ae.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
        AppMethodBeat.o(116087);
        return;
      }
      b localb = b.this;
      String str = b.a(b.this);
      if (1 == b.d(b.this)) {}
      for (int i = 0;; i = 1)
      {
        b.a(localb, SightVideoJNI.openFileVFS(str, i, 1, false));
        ae.i("MicroMsg.SightPlayController", "SightVideoJNI.openFile mVideoPath:%s mVideoId:%s", new Object[] { b.a(b.this), Integer.valueOf(b.e(b.this)) });
        b.f(b.this).offer(Integer.valueOf(b.e(b.this)));
        if (b.e(b.this) >= 0) {
          break;
        }
        ae.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), b.a(b.this) });
        b.this.ah(null);
        if (b.b(b.this) != null) {
          b.b(b.this).c(b.this, -1);
        }
        AppMethodBeat.o(116087);
        return;
      }
      if (((Boolean)g.ajR().ajA().get(344065, Boolean.FALSE)).booleanValue())
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
            ae.e("MicroMsg.SightPlayController", "get error info for ad,  videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(116087);
          }
        }
        else if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
        {
          ae.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(116087);
          return;
        }
        b.a(b.this, i, j);
      }
      b.this.dTB();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        ae.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!bu.isNullOrNil(b.a(b.this))) {
          b.dTE().put(b.a(b.this), Integer.valueOf(2));
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
      b.this.eb(i, j);
      if (1 == b.d(b.this))
      {
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, null);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.i(b.j(b.this), 0L);
        }
      }
      for (;;)
      {
        if (this.stop) {
          ae.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
        }
        AppMethodBeat.o(116087);
        return;
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, new b.c(b.this));
        b.j(b.this).zip = b.k(b.this);
        b.k(b.this).zis = b.j(b.this);
        if (!this.stop) {
          com.tencent.mm.modelvideo.o.i(b.j(b.this), 0L);
        }
      }
    }
  }
  
  public final class i
    implements Runnable
  {
    public int type;
    double zie = -1.0D;
    MediaPlayer zit;
    
    private i() {}
    
    private void dwn()
    {
      AppMethodBeat.i(116089);
      ae.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.zit != null)
        {
          this.zit.stop();
          this.zit.release();
          this.zit = null;
        }
        AppMethodBeat.o(116089);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.zit = null;
        AppMethodBeat.o(116089);
      }
    }
    
    public final double dTJ()
    {
      AppMethodBeat.i(116090);
      if (this.zit == null)
      {
        AppMethodBeat.o(116090);
        return 0.0D;
      }
      double d = this.zit.getCurrentPosition();
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
        ae.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
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
        dwn();
        if (!bu.isNullOrNil(b.a(b.this)))
        {
          try
          {
            this.zit = new k();
            this.zit.setDisplay(null);
            this.zit.reset();
            this.zit.setDataSource(com.tencent.mm.vfs.o.k(b.a(b.this), false));
            this.zit.setAudioStreamType(3);
            this.zit.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(116088);
                ae.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(b.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                b.this.clear();
                if (b.b(b.this) != null) {
                  b.b(b.this).c(b.this, -1);
                }
                AppMethodBeat.o(116088);
                return true;
              }
            });
            this.zit.prepare();
            this.zit.start();
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException1)
          {
            ae.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            ae.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.a(b.this) });
            b.this.clear();
            if (b.b(b.this) != null) {
              b.b(b.this).c(b.this, -1);
            }
            AppMethodBeat.o(116091);
            return;
          }
          dwn();
          AppMethodBeat.o(116091);
          return;
          try
          {
            if ((this.zit != null) && (this.zit.isPlaying())) {
              this.zit.pause();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException2)
          {
            ae.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            dwn();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            if (this.zit != null) {
              this.zit.start();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException3)
          {
            ae.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            dwn();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            ae.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.zie) });
            this.zit.seekTo((int)(this.zie * 1000.0D));
            AppMethodBeat.o(116091);
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
    WeakReference<Bitmap> ziv;
    
    private k()
    {
      AppMethodBeat.i(116096);
      this.ziv = new WeakReference(null);
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
          if (this.ziv.get() != null) {
            break label282;
          }
          bool3 = true;
          if (b.q(b.this) != null) {
            break label288;
          }
          bool4 = true;
          ae.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (b.q(b.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.ziv.get();
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
          ae.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
        ae.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
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
        if ((b.r(b.this) == null) || (this.ziv.get() == null) || (((Bitmap)this.ziv.get()).isRecycled()))
        {
          if (b.r(b.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.ziv.get() != null) {
            break label883;
          }
          bool2 = bool6;
          ae.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(116097);
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
        SightVideoJNI.handleThumb((Bitmap)this.ziv.get(), b.r(b.this), b.q(b.this));
        ae.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
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
      if (this.ziv.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ae.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (b.p(b.this) != null)
        {
          localView2 = (View)b.p(b.this).get();
          if (localView2 != null) {
            localView2.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116095);
                ae.v("MicroMsg.SightPlayController", "set background drawable null");
                localView2.setBackgroundDrawable(null);
                AppMethodBeat.o(116095);
              }
            });
          }
        }
        if (this.ziv.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(b.o(b.this), 0);
          AppMethodBeat.o(116097);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(b.o(b.this), (Bitmap)this.ziv.get(), b.q(b.this));
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