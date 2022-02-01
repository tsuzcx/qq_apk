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
import com.tencent.mm.f.a.zo;
import com.tencent.mm.f.a.zo.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> Jsv = new HashMap();
  private static Map<String, Integer> Jsz = new ConcurrentHashMap();
  private int JrT = 0;
  private int JrU = 0;
  private String JrV = "";
  private int JrW = -1;
  private Queue<Integer> JrX = new ConcurrentLinkedQueue();
  protected int JrY = 41;
  private Bitmap JrZ;
  public double JsA = -1.0D;
  private boolean JsB = false;
  public boolean JsC = false;
  private a JsD;
  public volatile e JsE;
  private volatile f JsF;
  public volatile g JsG;
  public Bitmap Jsa;
  private Bitmap Jsb;
  private WeakReference<View> Jsc;
  private WeakReference<TextView> Jsd;
  private long Jse;
  public WeakReference<View> Jsf;
  private Animation Jsg;
  private Animation Jsh;
  private volatile h Jsi;
  private volatile b Jsj;
  public volatile i Jsk;
  private volatile c Jsl;
  private k Jsm;
  private j Jsn;
  private d Jso;
  private f Jsp = new f()
  {
    public final void b(b paramAnonymousb, long paramAnonymousLong) {}
  };
  public boolean Jsq = true;
  public boolean Jsr = true;
  public boolean Jss = false;
  public boolean Jst = false;
  public boolean Jsu = false;
  public boolean Jsw = false;
  public double Jsx = -1.0D;
  boolean Jsy = false;
  public String cJT = "";
  private MMHandler cyl;
  private boolean lYN = false;
  private Surface mSurface;
  public boolean mfK = true;
  public int position;
  
  public b(int paramInt, View paramView)
  {
    this.JrU = paramInt;
    this.cyl = new MMHandler(Looper.getMainLooper());
    this.Jsf = new WeakReference(paramView);
    Log.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static Bitmap a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = String.format("%s-%s-%s-%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = (WeakReference)Jsv.get(str);
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      return (Bitmap)((WeakReference)localObject).get();
    }
    if (paramContext == null)
    {
      Log.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
      return null;
    }
    if (paramInt1 <= 0)
    {
      Log.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
      return null;
    }
    if ((paramInt2 <= 0) || (paramInt4 <= 0) || (paramInt3 <= 0))
    {
      Log.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
      return null;
    }
    long l = Util.currentTicks();
    paramInt3 = paramInt2 * paramInt4 / paramInt3;
    paramContext = (NinePatchDrawable)paramContext.getResources().getDrawable(paramInt1);
    paramContext.setBounds(0, 0, paramInt2, paramInt3);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    paramContext.draw(new Canvas((Bitmap)localObject));
    Jsv.put(str, new WeakReference(localObject));
    Log.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    return localObject;
  }
  
  public static boolean aYi(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)Jsz.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  private void aeE(final int paramInt)
  {
    s.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116074);
        long l = System.currentTimeMillis();
        SightVideoJNI.freeObj(paramInt);
        Log.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(116074);
      }
    }, 0L);
  }
  
  public static void baL()
  {
    s.g(new b.2(), 0L);
  }
  
  private void d(Queue<Integer> paramQueue)
  {
    for (;;)
    {
      Integer localInteger = (Integer)paramQueue.poll();
      if (localInteger == null) {
        break;
      }
      aeE(localInteger.intValue());
    }
  }
  
  public final void ap(Bitmap paramBitmap)
  {
    boolean bool = true;
    if (paramBitmap == null) {}
    for (;;)
    {
      Log.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.valueOf(bool) });
      s.I(this.Jsm);
      if (this.Jsm == null) {
        this.Jsm = new k((byte)0);
      }
      this.Jsm.JsR = new WeakReference(paramBitmap);
      s.g(this.Jsm, 0L);
      return;
      bool = false;
    }
  }
  
  public abstract void aq(Bitmap paramBitmap);
  
  public final void bgP()
  {
    Log.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.Jsr), this.cJT, Integer.valueOf(this.JrW) });
    if (!this.Jsr) {
      clear();
    }
    do
    {
      return;
      if (fIB())
      {
        Log.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cJT });
        return;
      }
      if (this.JrW < 0) {}
      for (boolean bool = true;; bool = false)
      {
        yb(bool);
        this.Jse = 0L;
        if (!fIC()) {
          break;
        }
        Log.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[] { Integer.valueOf(hashCode()) });
        return;
      }
      if (this.JrW >= 0) {
        break;
      }
      Log.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.cJT });
    } while (Util.isNullOrNil(this.cJT));
    if (!aYi(this.cJT))
    {
      Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.Jsi = new h((byte)0);
    s.g(this.Jsi, 0L);
    return;
    if (1 == this.JrU)
    {
      this.Jsj = new b((byte)0);
      this.Jsl = null;
      s.g(this.Jsj, 0L);
      return;
    }
    this.Jsj = new b((byte)0);
    this.Jsl = new c();
    this.Jsj.JsL = this.Jsl;
    this.Jsl.JsO = this.Jsj;
    s.g(this.Jsj, 0L);
  }
  
  public final void clear()
  {
    Log.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.JrW), Boolean.valueOf(fIB()) });
    yb(true);
    this.Jse = 0L;
    d(this.JrX);
    this.JrW = -1;
    this.cJT = "";
    this.JrV = "ERROR#PATH";
    this.Jsb = null;
    this.Jsx = 0.0D;
    this.Jsy = false;
    o.liV.E(this.JrZ);
    this.JrZ = null;
  }
  
  public final void cm(String paramString, boolean paramBoolean)
  {
    Log.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(hashCode()), paramString, this.cJT, Boolean.valueOf(paramBoolean), Integer.valueOf(this.JrW), Boolean.valueOf(this.JsC), Boolean.valueOf(this.Jsr) });
    if (this.JsC)
    {
      yb(false);
      return;
    }
    if (fIC())
    {
      Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      clear();
      return;
    }
    if (!this.Jsr)
    {
      clear();
      return;
    }
    if (paramBoolean)
    {
      this.JrV = paramString;
      yb(false);
      return;
    }
    if (this.cJT.equals(paramString))
    {
      this.JrV = "ERROR#PATH";
      yb(false);
      bgP();
      return;
    }
    clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.cJT = str;
    if (Util.isNullOrNil(this.cJT))
    {
      Log.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      ap(null);
      return;
    }
    if (!aYi(this.cJT))
    {
      Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.Jsi = new h((byte)0);
    s.g(this.Jsi, 0L);
  }
  
  public abstract void eM(int paramInt1, int paramInt2);
  
  protected int fIA()
  {
    return -1;
  }
  
  public final boolean fIB()
  {
    if (1 == this.JrU) {
      if ((this.Jsj == null) || (this.Jsj.stop)) {}
    }
    while ((this.Jsl != null) && (!this.Jsl.stop) && (this.Jsj != null) && (!this.Jsj.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean fIC()
  {
    if (this.Jsw) {}
    do
    {
      do
      {
        return false;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
      } while (this.JrT < 3);
      Log.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
      this.JrT = 0;
      return false;
    } while (this.JrT < 3);
    return true;
  }
  
  protected final void fID()
  {
    int i = Math.max(1, (int)SightVideoJNI.getVideoRate(this.JrW));
    this.JrY = (1000 / i);
    Log.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.JrY) });
  }
  
  public final IListener fIE()
  {
    if (this.JsD == null) {
      this.JsD = new a(this);
    }
    return this.JsD;
  }
  
  public final double fIF()
  {
    if (this.JrW == -1) {
      return 0.0D;
    }
    return SightVideoJNI.getVideoDuration(this.JrW);
  }
  
  public final void n(Surface paramSurface)
  {
    Log.v("MicroMsg.SightPlayController", "set play surface %s", new Object[] { paramSurface });
    this.mSurface = paramSurface;
    s.g(this.Jsm, 0L);
  }
  
  public final void setOnDecodeDurationListener(f paramf)
  {
    if (paramf == null) {
      this.JsF = this.Jsp;
    }
    this.JsF = paramf;
  }
  
  public final void setSightInfoView(TextView paramTextView)
  {
    this.Jsd = new WeakReference(paramTextView);
  }
  
  public final void setThumbBgView(View paramView)
  {
    this.Jsc = new WeakReference(paramView);
  }
  
  public final void yb(boolean paramBoolean)
  {
    if (this.Jsi != null)
    {
      s.I(this.Jsi);
      this.Jsi.stop = true;
    }
    if (this.Jsl != null)
    {
      this.cyl.removeCallbacks(this.Jsl);
      this.Jsl.stop = true;
    }
    if (this.Jsj != null)
    {
      s.I(this.Jsj);
      this.Jsj.stop = true;
    }
    i locali;
    if (this.Jsk != null)
    {
      locali = this.Jsk;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      s.g(this.Jsk, 0L);
      return;
    }
  }
  
  static final class a
    extends IListener<zo>
  {
    int BcO;
    int JsJ;
    WeakReference<b> JsK;
    int wKJ;
    
    public a(b paramb)
    {
      super();
      AppMethodBeat.i(116075);
      this.BcO = 0;
      this.JsJ = 0;
      this.wKJ = 0;
      this.JsK = new WeakReference(paramb);
      this.__eventId = zo.class.getName().hashCode();
      AppMethodBeat.o(116075);
    }
    
    private void a(zo paramzo)
    {
      this.BcO = paramzo.fYR.fYU;
      this.JsJ = paramzo.fYR.fYS;
      this.wKJ = paramzo.fYR.fYT;
    }
    
    private boolean fIH()
    {
      AppMethodBeat.i(116076);
      if (this.JsK.get() == null)
      {
        AppMethodBeat.o(116076);
        return false;
      }
      int i = b.G((b)this.JsK.get()) + this.BcO;
      if ((i < this.JsJ) || (i > this.wKJ))
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
    b.c JsL;
    volatile boolean stop = false;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(116083);
      if ((b.s(b.this) != null) && (b.s(b.this).fIJ() != null) && (b.s(b.this).fIJ().getVisibility() == 0)) {
        b.h(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116078);
            b.s(b.this).fIJ().setVisibility(8);
            AppMethodBeat.o(116078);
          }
        });
      }
      if (b.e(b.this) < 0)
      {
        Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.a(b.this) });
        AppMethodBeat.o(116083);
        return;
      }
      if (this.stop)
      {
        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
        if (b.this.Jss) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.v(b.this), b.e(b.this)) > 0)
        {
          if (b.u(b.this) == null) {
            b.a(b.this, new b.i(b.this, (byte)0));
          }
          b.u(b.this).type = 4;
          b.u(b.this).JsA = b.v(b.this);
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
        if (b.this.Jss)
        {
          f2 = f1;
          if (b.w(b.this))
          {
            b.a(b.this, false);
            f2 = f1;
            if (b.u(b.this) != null)
            {
              d = b.u(b.this).fIL() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, b.e(b.this)) > 0)
              {
                f2 = 0.0F;
                Log.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (b.x(b.this)) {
          Log.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), Float.valueOf(f3), Float.valueOf(f2) });
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
        Log.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.z(b.this)) });
        b.this.clear();
        AppMethodBeat.o(116083);
        return;
        label620:
        if (b.u(b.this) != null)
        {
          b.u(b.this).type = 4;
          b.u(b.this).JsA = b.v(b.this);
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
        b.u(b.this).JsA = b.v(b.this);
        b.u(b.this).run();
        i = 1;
        break;
        f1 = f3 / b.this.JrY + 0.5F;
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
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          this.stop = true;
          if (this.JsL == null) {
            break label2266;
          }
          this.JsL.stop = true;
          i = 0;
        }
      }
      for (;;)
      {
        if (b.u(b.this) != null) {
          Log.d("MicroMsg.SightPlayController", "voice time is" + b.u(b.this).fIL() / 1000.0D);
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
            Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
                    if (k != (int)b.this.Jsx)
                    {
                      i = j;
                      if (b.B(b.this) != null)
                      {
                        i = j;
                        b.B(b.this).b(b.this, k);
                      }
                    }
                    i = j;
                    b.this.Jsx = d;
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
          Log.e("MicroMsg.SightPlayController", "decode job:%s", new Object[] { localException1.getMessage() });
          break;
          if (-7 == j)
          {
            i = j;
            Log.w("MicroMsg.SightPlayController", "surface is null, continue");
            i = 0;
            break;
          }
          i = j;
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
          i = j;
          this.stop = true;
          i = j;
          if (this.JsL != null)
          {
            i = j;
            this.JsL.stop = true;
          }
          i = j;
          b.this.ap(null);
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
            if (i != (int)b.this.Jsx) {
              b.B(b.this).b(b.this, i);
            }
            b.this.Jsx = d;
            if (b.x(b.this)) {
              Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
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
                Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (b.x(b.this))
            {
              Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
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
            Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            this.stop = true;
            if (this.JsL != null) {
              this.JsL.stop = true;
            }
            b.h(b.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116080);
                b.this.aq(null);
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
                l = b.this.JrY - (System.currentTimeMillis() - b.t(b.this));
                if (b.t(b.this) == 0L) {
                  s.g(this, b.this.JrY * 5);
                }
              }
              for (;;)
              {
                if (b.u(b.this) != null) {
                  Log.d("MicroMsg.SightPlayController", "voice time is" + b.u(b.this).fIL() / 1000.0D);
                }
                AppMethodBeat.o(116083);
                return;
                if (l > 0L)
                {
                  s.g(this, l);
                }
                else
                {
                  s.g(this, 0L);
                  continue;
                  if ((i != 0) && (b.s(b.this) != null))
                  {
                    i = b.s(b.this).fII();
                    b.h(b.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(116082);
                        if (b.s(b.this) != null)
                        {
                          View localView = b.s(b.this).fIJ();
                          if (localView != null)
                          {
                            if ((b.F(b.this) == null) && (b.s(b.this).fIK() != -1) && (b.m(b.this).get() != null)) {
                              b.a(b.this, AnimationUtils.loadAnimation(((View)b.m(b.this).get()).getContext(), b.s(b.this).fIK()));
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
                    this.JsL.JsN = j;
                    b.h(b.this).postDelayed(this.JsL, i);
                  }
                  else
                  {
                    this.JsL.JsN = j;
                    b.h(b.this).post(this.JsL);
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
    int JsN;
    b.b JsO;
    volatile boolean stop;
    
    public c()
    {
      AppMethodBeat.i(116084);
      this.stop = false;
      Log.i("MicroMsg.SightPlayController", "make sure drawJob alive");
      AppMethodBeat.o(116084);
    }
    
    public final void run()
    {
      AppMethodBeat.i(116085);
      if (this.stop)
      {
        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(116085);
        return;
      }
      b.this.aq(b.E(b.this));
      if (b.t(b.this) == 0L)
      {
        s.g(this.JsO, 0L);
        AppMethodBeat.o(116085);
        return;
      }
      long l = b.this.JrY - (System.currentTimeMillis() - b.t(b.this));
      if (l > 0L)
      {
        s.g(this.JsO, l);
        AppMethodBeat.o(116085);
        return;
      }
      s.g(this.JsO, 0L);
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
    public abstract int fII();
    
    public abstract View fIJ();
    
    public abstract int fIK();
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
        Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
        AppMethodBeat.o(116087);
        return;
      }
      b localb = b.this;
      String str = b.a(b.this);
      if (1 == b.d(b.this)) {}
      for (int i = 0;; i = 1)
      {
        b.a(localb, SightVideoJNI.openFileVFS(str, i, 1, false));
        Log.i("MicroMsg.SightPlayController", "SightVideoJNI.openFile mVideoPath:%s mVideoId:%s", new Object[] { b.a(b.this), Integer.valueOf(b.e(b.this)) });
        b.f(b.this).offer(Integer.valueOf(b.e(b.this)));
        if (b.e(b.this) >= 0) {
          break;
        }
        Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), b.a(b.this) });
        b.this.ap(null);
        if (b.b(b.this) != null) {
          b.b(b.this).c(b.this, -1);
        }
        AppMethodBeat.o(116087);
        return;
      }
      if (((Boolean)h.aHG().aHp().b(344065, Boolean.FALSE)).booleanValue())
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
          if ((i * j > 2073600) || (i <= 0) || (j <= 0))
          {
            Log.e("MicroMsg.SightPlayController", "get error info for ad,  videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(116087);
          }
        }
        else if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
        {
          Log.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(116087);
          return;
        }
        b.a(b.this, i, j);
      }
      b.this.fID();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        Log.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!Util.isNullOrNil(b.a(b.this))) {
          b.fIG().put(b.a(b.this), Integer.valueOf(2));
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
      b.this.eM(i, j);
      if (1 == b.d(b.this))
      {
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, null);
        if (!this.stop) {
          s.g(b.j(b.this), 0L);
        }
      }
      for (;;)
      {
        if (this.stop) {
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
        }
        AppMethodBeat.o(116087);
        return;
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, new b.c(b.this));
        b.j(b.this).JsL = b.k(b.this);
        b.k(b.this).JsO = b.j(b.this);
        if (!this.stop) {
          s.g(b.j(b.this), 0L);
        }
      }
    }
  }
  
  public final class i
    implements Runnable
  {
    double JsA = -1.0D;
    MediaPlayer JsP;
    public int type;
    
    private i() {}
    
    private void fer()
    {
      AppMethodBeat.i(116089);
      Log.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.JsP != null)
        {
          this.JsP.stop();
          this.JsP.release();
          this.JsP = null;
        }
        AppMethodBeat.o(116089);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.JsP = null;
        AppMethodBeat.o(116089);
      }
    }
    
    public final double fIL()
    {
      AppMethodBeat.i(116090);
      if (this.JsP == null)
      {
        AppMethodBeat.o(116090);
        return 0.0D;
      }
      double d = this.JsP.getCurrentPosition();
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
        Log.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
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
        fer();
        if (!Util.isNullOrNil(b.a(b.this)))
        {
          try
          {
            this.JsP = new k();
            this.JsP.setDisplay(null);
            this.JsP.reset();
            this.JsP.setDataSource(u.n(b.a(b.this), false));
            this.JsP.setAudioStreamType(3);
            this.JsP.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(116088);
                Log.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(b.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                b.this.clear();
                if (b.b(b.this) != null) {
                  b.b(b.this).c(b.this, -1);
                }
                AppMethodBeat.o(116088);
                return true;
              }
            });
            this.JsP.prepare();
            this.JsP.start();
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            Log.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.a(b.this) });
            b.this.clear();
            if (b.b(b.this) != null) {
              b.b(b.this).c(b.this, -1);
            }
            AppMethodBeat.o(116091);
            return;
          }
          fer();
          AppMethodBeat.o(116091);
          return;
          try
          {
            if ((this.JsP != null) && (this.JsP.isPlaying())) {
              this.JsP.pause();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            fer();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            if (this.JsP != null) {
              this.JsP.start();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException3)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            fer();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            Log.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.JsA) });
            this.JsP.seekTo((int)(this.JsA * 1000.0D));
            AppMethodBeat.o(116091);
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
    WeakReference<Bitmap> JsR;
    
    private k()
    {
      AppMethodBeat.i(116096);
      this.JsR = new WeakReference(null);
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
          if (this.JsR.get() != null) {
            break label282;
          }
          bool3 = true;
          if (b.q(b.this) != null) {
            break label288;
          }
          bool4 = true;
          Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (b.q(b.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.JsR.get();
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
          Log.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
        Log.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
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
        if ((b.r(b.this) == null) || (this.JsR.get() == null) || (((Bitmap)this.JsR.get()).isRecycled()))
        {
          if (b.r(b.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.JsR.get() != null) {
            break label883;
          }
          bool2 = bool6;
          Log.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(116097);
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
        SightVideoJNI.handleThumb((Bitmap)this.JsR.get(), b.r(b.this), b.q(b.this));
        Log.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
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
      if (this.JsR.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (b.p(b.this) != null)
        {
          localView2 = (View)b.p(b.this).get();
          if (localView2 != null) {
            localView2.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116095);
                Log.v("MicroMsg.SightPlayController", "set background drawable null");
                localView2.setBackgroundDrawable(null);
                AppMethodBeat.o(116095);
              }
            });
          }
        }
        if (this.JsR.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(b.o(b.this), 0);
          AppMethodBeat.o(116097);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(b.o(b.this), (Bitmap)this.JsR.get(), b.q(b.this));
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