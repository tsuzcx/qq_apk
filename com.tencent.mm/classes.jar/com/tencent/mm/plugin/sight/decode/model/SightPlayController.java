package com.tencent.mm.plugin.sight.decode.model;

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
import com.tencent.mm.autogen.a.abi;
import com.tencent.mm.autogen.a.abi.a;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class SightPlayController
{
  private static HashMap<String, WeakReference<Bitmap>> PFX = new HashMap();
  private static Map<String, Integer> PGb = new ConcurrentHashMap();
  protected int PFA = 41;
  private Bitmap PFB;
  public Bitmap PFC;
  private Bitmap PFD;
  private WeakReference<View> PFE;
  private WeakReference<TextView> PFF;
  private long PFG;
  public WeakReference<View> PFH;
  private Animation PFI;
  private Animation PFJ;
  private volatile g PFK;
  private volatile a PFL;
  public volatile h PFM;
  private volatile b PFN;
  private j PFO;
  private i PFP;
  private c PFQ;
  private e PFR = new e()
  {
    public final void b(SightPlayController paramAnonymousSightPlayController, long paramAnonymousLong) {}
  };
  public boolean PFS = true;
  public boolean PFT = true;
  public boolean PFU = false;
  public boolean PFV = false;
  public boolean PFW = false;
  public boolean PFY = false;
  public double PFZ = -1.0D;
  private int PFv = 0;
  private int PFw = 0;
  private String PFx = "";
  private int PFy = -1;
  private Queue<Integer> PFz = new ConcurrentLinkedQueue();
  boolean PGa = false;
  public double PGc = -1.0D;
  private boolean PGd = false;
  public boolean PGe = false;
  private ChattingUIStatusListener PGf;
  public volatile d PGg;
  private volatile e PGh;
  public volatile f PGi;
  public String eDC = "";
  private MMHandler eqE;
  private Surface mSurface;
  private boolean oRS = false;
  public boolean oYG = true;
  public int position;
  
  public SightPlayController(int paramInt, View paramView)
  {
    this.PFw = paramInt;
    this.eqE = new MMHandler(Looper.getMainLooper());
    this.PFH = new WeakReference(paramView);
    Log.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static boolean aWa(String paramString)
  {
    if (Util.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)PGb.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  private void ajn(final int paramInt)
  {
    v.h(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116074);
        long l = System.currentTimeMillis();
        SightVideoJNI.freeObj(paramInt);
        Log.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(116074);
      }
    }, 0L);
  }
  
  public static void bvG()
  {
    v.h(new SightPlayController.2(), 0L);
  }
  
  public static Bitmap c(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = String.format("%s-%s-%s-%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = (WeakReference)PFX.get(str);
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
    PFX.put(str, new WeakReference(localObject));
    Log.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    return localObject;
  }
  
  private void f(Queue<Integer> paramQueue)
  {
    for (;;)
    {
      Integer localInteger = (Integer)paramQueue.poll();
      if (localInteger == null) {
        break;
      }
      ajn(localInteger.intValue());
    }
  }
  
  public final void Df(boolean paramBoolean)
  {
    if (this.PFK != null)
    {
      v.N(this.PFK);
      this.PFK.stop = true;
    }
    if (this.PFN != null)
    {
      this.eqE.removeCallbacks(this.PFN);
      this.PFN.stop = true;
    }
    if (this.PFL != null)
    {
      v.N(this.PFL);
      this.PFL.stop = true;
    }
    h localh;
    if (this.PFM != null)
    {
      localh = this.PFM;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      localh.type = i;
      v.h(this.PFM, 0L);
      return;
    }
  }
  
  public final void aE(Bitmap paramBitmap)
  {
    boolean bool = true;
    if (paramBitmap == null) {}
    for (;;)
    {
      Log.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.valueOf(bool) });
      v.N(this.PFO);
      if (this.PFO == null) {
        this.PFO = new j((byte)0);
      }
      this.PFO.PGt = new WeakReference(paramBitmap);
      v.h(this.PFO, 0L);
      return;
      bool = false;
    }
  }
  
  public abstract void aF(Bitmap paramBitmap);
  
  public final void bEH()
  {
    Log.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.PFT), this.eDC, Integer.valueOf(this.PFy) });
    if (!this.PFT) {
      clear();
    }
    do
    {
      return;
      if (gYu())
      {
        Log.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.eDC });
        return;
      }
      if (this.PFy < 0) {}
      for (boolean bool = true;; bool = false)
      {
        Df(bool);
        this.PFG = 0L;
        if (!gYv()) {
          break;
        }
        Log.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[] { Integer.valueOf(hashCode()) });
        return;
      }
      if (this.PFy >= 0) {
        break;
      }
      Log.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.eDC });
    } while (Util.isNullOrNil(this.eDC));
    if (!aWa(this.eDC))
    {
      Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.PFK = new g((byte)0);
    v.h(this.PFK, 0L);
    return;
    if (1 == this.PFw)
    {
      this.PFL = new a((byte)0);
      this.PFN = null;
      v.h(this.PFL, 0L);
      return;
    }
    this.PFL = new a((byte)0);
    this.PFN = new b();
    this.PFL.PGn = this.PFN;
    this.PFN.PGq = this.PFL;
    v.h(this.PFL, 0L);
  }
  
  public final void cM(String paramString, boolean paramBoolean)
  {
    Log.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(hashCode()), paramString, this.eDC, Boolean.valueOf(paramBoolean), Integer.valueOf(this.PFy), Boolean.valueOf(this.PGe), Boolean.valueOf(this.PFT) });
    if (this.PGe)
    {
      Df(false);
      return;
    }
    if (gYv())
    {
      Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      clear();
      return;
    }
    if (!this.PFT)
    {
      clear();
      return;
    }
    if (paramBoolean)
    {
      this.PFx = paramString;
      Df(false);
      return;
    }
    if (this.eDC.equals(paramString))
    {
      this.PFx = "ERROR#PATH";
      Df(false);
      bEH();
      return;
    }
    clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.eDC = str;
    if (Util.isNullOrNil(this.eDC))
    {
      Log.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      aE(null);
      return;
    }
    if (!aWa(this.eDC))
    {
      Log.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.PFK = new g((byte)0);
    v.h(this.PFK, 0L);
  }
  
  public final void clear()
  {
    Log.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.PFy), Boolean.valueOf(gYu()) });
    Df(true);
    this.PFG = 0L;
    f(this.PFz);
    this.PFy = -1;
    this.eDC = "";
    this.PFx = "ERROR#PATH";
    this.PFD = null;
    this.PFZ = 0.0D;
    this.PGa = false;
    n.nNG.M(this.PFB);
    this.PFB = null;
  }
  
  public abstract void fG(int paramInt1, int paramInt2);
  
  protected int gYt()
  {
    return -1;
  }
  
  public final boolean gYu()
  {
    if (1 == this.PFw) {
      if ((this.PFL == null) || (this.PFL.stop)) {}
    }
    while ((this.PFN != null) && (!this.PFN.stop) && (this.PFL != null) && (!this.PFL.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean gYv()
  {
    if (this.PFY) {}
    do
    {
      do
      {
        return false;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
      } while (this.PFv < 3);
      Log.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
      this.PFv = 0;
      return false;
    } while (this.PFv < 3);
    return true;
  }
  
  protected final void gYw()
  {
    int i = Math.max(1, (int)SightVideoJNI.getVideoRate(this.PFy));
    this.PFA = (1000 / i);
    Log.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.PFA) });
  }
  
  public final IListener gYx()
  {
    if (this.PGf == null) {
      this.PGf = new ChattingUIStatusListener(this);
    }
    return this.PGf;
  }
  
  public final double gYy()
  {
    if (this.PFy == -1) {
      return 0.0D;
    }
    return SightVideoJNI.getVideoDuration(this.PFy);
  }
  
  public final void s(Surface paramSurface)
  {
    Log.v("MicroMsg.SightPlayController", "set play surface %s", new Object[] { paramSurface });
    this.mSurface = paramSurface;
    v.h(this.PFO, 0L);
  }
  
  public final void setOnDecodeDurationListener(e parame)
  {
    if (parame == null) {
      this.PGh = this.PFR;
    }
    this.PGh = parame;
  }
  
  public final void setSightInfoView(TextView paramTextView)
  {
    this.PFF = new WeakReference(paramTextView);
  }
  
  public final void setThumbBgView(View paramView)
  {
    this.PFE = new WeakReference(paramView);
  }
  
  static class ChattingUIStatusListener
    extends IListener<abi>
  {
    int Ahg;
    int PGl;
    WeakReference<SightPlayController> PGm;
    int xZt;
    
    public ChattingUIStatusListener(SightPlayController paramSightPlayController)
    {
      super();
      AppMethodBeat.i(116075);
      this.xZt = 0;
      this.PGl = 0;
      this.Ahg = 0;
      this.PGm = new WeakReference(paramSightPlayController);
      this.__eventId = abi.class.getName().hashCode();
      AppMethodBeat.o(116075);
    }
    
    private void a(abi paramabi)
    {
      this.xZt = paramabi.ieT.ieW;
      this.PGl = paramabi.ieT.ieU;
      this.Ahg = paramabi.ieT.ieV;
    }
    
    private boolean gYA()
    {
      AppMethodBeat.i(116076);
      if (this.PGm.get() == null)
      {
        AppMethodBeat.o(116076);
        return false;
      }
      int i = SightPlayController.G((SightPlayController)this.PGm.get()) + this.xZt;
      if ((i < this.PGl) || (i > this.Ahg))
      {
        AppMethodBeat.o(116076);
        return false;
      }
      AppMethodBeat.o(116076);
      return true;
    }
  }
  
  final class a
    implements Runnable
  {
    SightPlayController.b PGn;
    volatile boolean stop = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(116083);
      if ((SightPlayController.s(SightPlayController.this) != null) && (SightPlayController.s(SightPlayController.this).gYC() != null) && (SightPlayController.s(SightPlayController.this).gYC().getVisibility() == 0)) {
        SightPlayController.h(SightPlayController.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116078);
            SightPlayController.s(SightPlayController.this).gYC().setVisibility(8);
            AppMethodBeat.o(116078);
          }
        });
      }
      if (SightPlayController.e(SightPlayController.this) < 0)
      {
        Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()), SightPlayController.a(SightPlayController.this) });
        AppMethodBeat.o(116083);
        return;
      }
      if (this.stop)
      {
        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(116083);
        return;
      }
      if (SightPlayController.t(SightPlayController.this) == 0L)
      {
        if (SightPlayController.u(SightPlayController.this) != null)
        {
          SightPlayController.u(SightPlayController.this).type = 1;
          SightPlayController.u(SightPlayController.this).run();
        }
        SightPlayController.a(SightPlayController.this, System.currentTimeMillis());
      }
      int j = 0;
      int i = j;
      if (SightPlayController.v(SightPlayController.this) != -1.0D)
      {
        if (SightPlayController.this.PFU) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(SightPlayController.v(SightPlayController.this), SightPlayController.e(SightPlayController.this)) > 0)
        {
          if (SightPlayController.u(SightPlayController.this) == null) {
            SightPlayController.a(SightPlayController.this, new SightPlayController.h(SightPlayController.this, (byte)0));
          }
          SightPlayController.u(SightPlayController.this).type = 4;
          SightPlayController.u(SightPlayController.this).PGc = SightPlayController.v(SightPlayController.this);
          SightPlayController.u(SightPlayController.this).run();
          i = 1;
        }
      }
      float f3 = (float)(System.currentTimeMillis() - SightPlayController.t(SightPlayController.this));
      float f1;
      label375:
      float f2;
      double d;
      if (i != 0)
      {
        f1 = 0.0F;
        f2 = f1;
        if (SightPlayController.this.PFU)
        {
          f2 = f1;
          if (SightPlayController.w(SightPlayController.this))
          {
            SightPlayController.a(SightPlayController.this, false);
            f2 = f1;
            if (SightPlayController.u(SightPlayController.this) != null)
            {
              d = SightPlayController.u(SightPlayController.this).gYE() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, SightPlayController.e(SightPlayController.this)) > 0)
              {
                f2 = 0.0F;
                Log.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (SightPlayController.x(SightPlayController.this)) {
          Log.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(SightPlayController.e(SightPlayController.this)), Float.valueOf(f3), Float.valueOf(f2) });
        }
        SightPlayController.a(SightPlayController.this, System.currentTimeMillis());
        if (f2 < 2.0F) {
          break label813;
        }
        SightPlayController.y(SightPlayController.this);
      }
      for (;;)
      {
        if (!SightPlayController.c(SightPlayController.this)) {
          break label837;
        }
        Log.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(SightPlayController.z(SightPlayController.this)) });
        SightPlayController.this.clear();
        AppMethodBeat.o(116083);
        return;
        label620:
        if (SightPlayController.u(SightPlayController.this) != null)
        {
          SightPlayController.u(SightPlayController.this).type = 4;
          SightPlayController.u(SightPlayController.this).PGc = SightPlayController.v(SightPlayController.this);
          SightPlayController.u(SightPlayController.this).run();
          SightPlayController.h(SightPlayController.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(116079);
              SightPlayController.a(SightPlayController.this, true);
              AppMethodBeat.o(116079);
            }
          }, 100L);
          i = j;
          break;
        }
        i = j;
        if (SightVideoJNI.seekStream(SightPlayController.v(SightPlayController.this), SightPlayController.e(SightPlayController.this)) <= 0) {
          break;
        }
        if (SightPlayController.u(SightPlayController.this) == null) {
          SightPlayController.a(SightPlayController.this, new SightPlayController.h(SightPlayController.this, (byte)0));
        }
        SightPlayController.u(SightPlayController.this).type = 4;
        SightPlayController.u(SightPlayController.this).PGc = SightPlayController.v(SightPlayController.this);
        SightPlayController.u(SightPlayController.this).run();
        i = 1;
        break;
        f1 = f3 / SightPlayController.this.PFA + 0.5F;
        break label375;
        label813:
        SightPlayController.b(SightPlayController.this, Math.max(0, SightPlayController.z(SightPlayController.this) - 1));
      }
      label837:
      int k = 0;
      i = 0;
      j = 0;
      if (1 == SightPlayController.d(SightPlayController.this)) {
        if ((SightPlayController.o(SightPlayController.this) != null) && (!SightPlayController.o(SightPlayController.this).isValid()))
        {
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()) });
          this.stop = true;
          if (this.PGn == null) {
            break label2266;
          }
          this.PGn.stop = true;
          i = 0;
        }
      }
      for (;;)
      {
        if (SightPlayController.u(SightPlayController.this) != null) {
          Log.d("MicroMsg.SightPlayController", "voice time is" + SightPlayController.u(SightPlayController.this).gYE() / 1000.0D);
        }
        for (;;)
        {
          for (;;)
          {
            if (1 == j) {
              SightPlayController.h(SightPlayController.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(116081);
                  if (SightPlayController.b(SightPlayController.this) != null) {
                    SightPlayController.b(SightPlayController.this).c(SightPlayController.this, 0);
                  }
                  AppMethodBeat.o(116081);
                }
              });
            }
            if (!this.stop) {
              break label2005;
            }
            Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()) });
            if (SightPlayController.u(SightPlayController.this) != null)
            {
              SightPlayController.u(SightPlayController.this).type = 0;
              SightPlayController.u(SightPlayController.this).run();
            }
            AppMethodBeat.o(116083);
            return;
            try
            {
              for (;;)
              {
                j = SightVideoJNI.drawSurfaceFrame(SightPlayController.e(SightPlayController.this), SightPlayController.o(SightPlayController.this), (int)f2, SightPlayController.q(SightPlayController.this), SightPlayController.A(SightPlayController.this));
                i = j;
                if (SightPlayController.B(SightPlayController.this) != null)
                {
                  i = j;
                  if (SightPlayController.B(SightPlayController.this) != SightPlayController.C(SightPlayController.this))
                  {
                    i = j;
                    d = SightVideoJNI.getVideoPlayTime(SightPlayController.e(SightPlayController.this));
                    k = (int)d;
                    i = j;
                    if (k != (int)SightPlayController.this.PFZ)
                    {
                      i = j;
                      if (SightPlayController.B(SightPlayController.this) != null)
                      {
                        i = j;
                        SightPlayController.B(SightPlayController.this).b(SightPlayController.this, k);
                      }
                    }
                    i = j;
                    SightPlayController.this.PFZ = d;
                  }
                }
                if (j == 0)
                {
                  i = j;
                  SightPlayController.a(SightPlayController.this, -1.0D);
                  i = 0;
                  break;
                }
                if (1 != j) {
                  break label1343;
                }
                i = j;
                SightPlayController.a(SightPlayController.this, -1.0D);
                k = 1;
                i = 1;
                try
                {
                  SightPlayController.a(SightPlayController.this, 0L);
                  SightPlayController.D(SightPlayController.this);
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
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
          i = j;
          this.stop = true;
          i = j;
          if (this.PGn != null)
          {
            i = j;
            this.PGn.stop = true;
          }
          i = j;
          SightPlayController.this.aE(null);
          i = j;
          if (SightPlayController.b(SightPlayController.this) != null)
          {
            i = j;
            SightPlayController.b(SightPlayController.this).c(SightPlayController.this, -1);
          }
          i = 0;
          break;
          m = SightVideoJNI.drawFrame(SightPlayController.e(SightPlayController.this), SightPlayController.E(SightPlayController.this), (int)f2, null, false, SightPlayController.A(SightPlayController.this));
          if (SightPlayController.B(SightPlayController.this) != null)
          {
            d = SightVideoJNI.getVideoPlayTime(SightPlayController.e(SightPlayController.this));
            i = (int)d;
            if (i != (int)SightPlayController.this.PFZ) {
              SightPlayController.B(SightPlayController.this).b(SightPlayController.this, i);
            }
            SightPlayController.this.PFZ = d;
            if (SightPlayController.x(SightPlayController.this)) {
              Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
            }
          }
          for (;;)
          {
            if (m != 0) {
              break label1823;
            }
            SightPlayController.a(SightPlayController.this, -1.0D);
            j = m;
            i = k;
            break;
            if (SightPlayController.x(SightPlayController.this))
            {
              d = SightVideoJNI.getVideoPlayTime(SightPlayController.e(SightPlayController.this));
              if (SightPlayController.x(SightPlayController.this)) {
                Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (SightPlayController.x(SightPlayController.this))
            {
              Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            }
          }
          if (1 == m)
          {
            SightPlayController.a(SightPlayController.this, -1.0D);
            i = 1;
            SightPlayController.a(SightPlayController.this, 0L);
            SightPlayController.D(SightPlayController.this);
            j = m;
          }
          else
          {
            SightPlayController.a(SightPlayController.this, -1.0D);
            Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            this.stop = true;
            if (this.PGn != null) {
              this.PGn.stop = true;
            }
            SightPlayController.h(SightPlayController.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116080);
                SightPlayController.this.aF(null);
                AppMethodBeat.o(116080);
              }
            });
            j = m;
            i = k;
            if (SightPlayController.b(SightPlayController.this) != null)
            {
              SightPlayController.b(SightPlayController.this).c(SightPlayController.this, -1);
              j = m;
              i = k;
              continue;
              if (1 == SightPlayController.d(SightPlayController.this))
              {
                l = SightPlayController.this.PFA - (System.currentTimeMillis() - SightPlayController.t(SightPlayController.this));
                if (SightPlayController.t(SightPlayController.this) == 0L) {
                  v.h(this, SightPlayController.this.PFA * 5);
                }
              }
              for (;;)
              {
                if (SightPlayController.u(SightPlayController.this) != null) {
                  Log.d("MicroMsg.SightPlayController", "voice time is" + SightPlayController.u(SightPlayController.this).gYE() / 1000.0D);
                }
                AppMethodBeat.o(116083);
                return;
                if (l > 0L)
                {
                  v.h(this, l);
                }
                else
                {
                  v.h(this, 0L);
                  continue;
                  if ((i != 0) && (SightPlayController.s(SightPlayController.this) != null))
                  {
                    i = SightPlayController.s(SightPlayController.this).gYB();
                    SightPlayController.h(SightPlayController.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(116082);
                        if (SightPlayController.s(SightPlayController.this) != null)
                        {
                          View localView = SightPlayController.s(SightPlayController.this).gYC();
                          if (localView != null)
                          {
                            if ((SightPlayController.F(SightPlayController.this) == null) && (SightPlayController.s(SightPlayController.this).gYD() != -1) && (SightPlayController.m(SightPlayController.this).get() != null)) {
                              SightPlayController.a(SightPlayController.this, AnimationUtils.loadAnimation(((View)SightPlayController.m(SightPlayController.this).get()).getContext(), SightPlayController.s(SightPlayController.this).gYD()));
                            }
                            if (SightPlayController.F(SightPlayController.this) != null) {
                              localView.startAnimation(SightPlayController.F(SightPlayController.this));
                            }
                            localView.setVisibility(0);
                          }
                        }
                        AppMethodBeat.o(116082);
                      }
                    });
                    this.PGn.PGp = j;
                    SightPlayController.h(SightPlayController.this).postDelayed(this.PGn, i);
                  }
                  else
                  {
                    this.PGn.PGp = j;
                    SightPlayController.h(SightPlayController.this).post(this.PGn);
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
  
  final class b
    implements Runnable
  {
    int PGp;
    SightPlayController.a PGq;
    volatile boolean stop;
    
    public b()
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
        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(116085);
        return;
      }
      SightPlayController.this.aF(SightPlayController.E(SightPlayController.this));
      if (SightPlayController.t(SightPlayController.this) == 0L)
      {
        v.h(this.PGq, 0L);
        AppMethodBeat.o(116085);
        return;
      }
      long l = SightPlayController.this.PFA - (System.currentTimeMillis() - SightPlayController.t(SightPlayController.this));
      if (l > 0L)
      {
        v.h(this.PGq, l);
        AppMethodBeat.o(116085);
        return;
      }
      v.h(this.PGq, 0L);
      AppMethodBeat.o(116085);
    }
  }
  
  final class c
    implements Runnable
  {
    private c() {}
    
    public final void run()
    {
      AppMethodBeat.i(116086);
      if (SightPlayController.m(SightPlayController.this).get() == null)
      {
        AppMethodBeat.o(116086);
        return;
      }
      ((View)SightPlayController.m(SightPlayController.this).get()).startAnimation(SightPlayController.n(SightPlayController.this));
      AppMethodBeat.o(116086);
    }
  }
  
  public static abstract interface d
  {
    public abstract void c(SightPlayController paramSightPlayController, int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void b(SightPlayController paramSightPlayController, long paramLong);
  }
  
  public static abstract interface f
  {
    public abstract int gYB();
    
    public abstract View gYC();
    
    public abstract int gYD();
  }
  
  final class g
    implements Runnable
  {
    volatile boolean stop = false;
    
    private g() {}
    
    public final void run()
    {
      AppMethodBeat.i(116087);
      if (SightPlayController.c(SightPlayController.this))
      {
        Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
        AppMethodBeat.o(116087);
        return;
      }
      SightPlayController localSightPlayController = SightPlayController.this;
      String str = SightPlayController.a(SightPlayController.this);
      if (1 == SightPlayController.d(SightPlayController.this)) {}
      for (int i = 0;; i = 1)
      {
        SightPlayController.a(localSightPlayController, SightVideoJNI.openFileVFS(str, i, 1, false));
        Log.i("MicroMsg.SightPlayController", "SightVideoJNI.openFile mVideoPath:%s mVideoId:%s", new Object[] { SightPlayController.a(SightPlayController.this), Integer.valueOf(SightPlayController.e(SightPlayController.this)) });
        SightPlayController.f(SightPlayController.this).offer(Integer.valueOf(SightPlayController.e(SightPlayController.this)));
        if (SightPlayController.e(SightPlayController.this) >= 0) {
          break;
        }
        Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(SightPlayController.e(SightPlayController.this)), SightPlayController.a(SightPlayController.this) });
        SightPlayController.this.aE(null);
        if (SightPlayController.b(SightPlayController.this) != null) {
          SightPlayController.b(SightPlayController.this).c(SightPlayController.this, -1);
        }
        AppMethodBeat.o(116087);
        return;
      }
      if (((Boolean)h.baE().ban().d(344065, Boolean.FALSE)).booleanValue())
      {
        if (SightPlayController.g(SightPlayController.this) == null) {
          SightPlayController.a(SightPlayController.this, new SightPlayController.i(SightPlayController.this, (byte)0));
        }
        SightPlayController.h(SightPlayController.this).removeCallbacks(SightPlayController.g(SightPlayController.this));
        SightPlayController.h(SightPlayController.this).post(SightPlayController.g(SightPlayController.this));
      }
      i = Math.max(1, SightVideoJNI.getVideoWidth(SightPlayController.e(SightPlayController.this)));
      int j = Math.max(1, SightVideoJNI.getVideoHeight(SightPlayController.e(SightPlayController.this)));
      if (SightPlayController.d(SightPlayController.this) == 0)
      {
        if (SightPlayController.i(SightPlayController.this))
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
        SightPlayController.a(SightPlayController.this, i, j);
      }
      SightPlayController.this.gYw();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        Log.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!Util.isNullOrNil(SightPlayController.a(SightPlayController.this))) {
          SightPlayController.gYz().put(SightPlayController.a(SightPlayController.this), Integer.valueOf(2));
        }
        SightPlayController.a(SightPlayController.this, 0L);
        SightPlayController.a(SightPlayController.this, SightPlayController.f(SightPlayController.this));
        SightPlayController.a(SightPlayController.this, -1);
        SightPlayController.a(SightPlayController.this, "");
        SightPlayController.b(SightPlayController.this, "ERROR#PATH");
        SightPlayController.a(SightPlayController.this, null);
        this.stop = true;
        if (SightPlayController.b(SightPlayController.this) != null) {
          SightPlayController.b(SightPlayController.this).c(SightPlayController.this, -1);
        }
        AppMethodBeat.o(116087);
        return;
      }
      SightPlayController.this.fG(i, j);
      if (1 == SightPlayController.d(SightPlayController.this))
      {
        SightPlayController.a(SightPlayController.this, new SightPlayController.a(SightPlayController.this, (byte)0));
        SightPlayController.a(SightPlayController.this, null);
        if (!this.stop) {
          v.h(SightPlayController.j(SightPlayController.this), 0L);
        }
      }
      for (;;)
      {
        if (this.stop) {
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(SightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
        }
        AppMethodBeat.o(116087);
        return;
        SightPlayController.a(SightPlayController.this, new SightPlayController.a(SightPlayController.this, (byte)0));
        SightPlayController.a(SightPlayController.this, new SightPlayController.b(SightPlayController.this));
        SightPlayController.j(SightPlayController.this).PGn = SightPlayController.k(SightPlayController.this);
        SightPlayController.k(SightPlayController.this).PGq = SightPlayController.j(SightPlayController.this);
        if (!this.stop) {
          v.h(SightPlayController.j(SightPlayController.this), 0L);
        }
      }
    }
  }
  
  public final class h
    implements Runnable
  {
    double PGc = -1.0D;
    MediaPlayer PGr;
    public int type;
    
    private h() {}
    
    private void gnu()
    {
      AppMethodBeat.i(116089);
      Log.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.PGr != null)
        {
          this.PGr.stop();
          this.PGr.release();
          this.PGr = null;
        }
        AppMethodBeat.o(116089);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.PGr = null;
        AppMethodBeat.o(116089);
      }
    }
    
    public final double gYE()
    {
      AppMethodBeat.i(116090);
      if (this.PGr == null)
      {
        AppMethodBeat.o(116090);
        return 0.0D;
      }
      double d = this.PGr.getCurrentPosition();
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
        gnu();
        if (!Util.isNullOrNil(SightPlayController.a(SightPlayController.this)))
        {
          try
          {
            this.PGr = new k();
            this.PGr.setDisplay(null);
            this.PGr.reset();
            this.PGr.setDataSource(y.n(SightPlayController.a(SightPlayController.this), false));
            this.PGr.setAudioStreamType(3);
            this.PGr.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(116088);
                Log.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { SightPlayController.a(SightPlayController.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                SightPlayController.this.clear();
                if (SightPlayController.b(SightPlayController.this) != null) {
                  SightPlayController.b(SightPlayController.this).c(SightPlayController.this, -1);
                }
                AppMethodBeat.o(116088);
                return true;
              }
            });
            this.PGr.prepare();
            this.PGr.start();
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            Log.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { SightPlayController.a(SightPlayController.this) });
            SightPlayController.this.clear();
            if (SightPlayController.b(SightPlayController.this) != null) {
              SightPlayController.b(SightPlayController.this).c(SightPlayController.this, -1);
            }
            AppMethodBeat.o(116091);
            return;
          }
          gnu();
          AppMethodBeat.o(116091);
          return;
          try
          {
            if ((this.PGr != null) && (this.PGr.isPlaying())) {
              this.PGr.pause();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            gnu();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            if (this.PGr != null) {
              this.PGr.start();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException3)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            gnu();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            Log.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.PGc) });
            this.PGr.seekTo((int)(this.PGc * 1000.0D));
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
  
  final class i
    implements Runnable
  {
    private i() {}
    
    public final void run()
    {
      AppMethodBeat.i(116092);
      if ((SightPlayController.e(SightPlayController.this) < 0) || (SightPlayController.l(SightPlayController.this) == null) || (SightPlayController.l(SightPlayController.this).get() == null))
      {
        AppMethodBeat.o(116092);
        return;
      }
      String str = SightVideoJNI.getVideoInfo(SightPlayController.e(SightPlayController.this));
      ((TextView)SightPlayController.l(SightPlayController.this).get()).setText(str);
      AppMethodBeat.o(116092);
    }
  }
  
  final class j
    implements Runnable
  {
    WeakReference<Bitmap> PGt;
    
    private j()
    {
      AppMethodBeat.i(116096);
      this.PGt = new WeakReference(null);
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
        if ((SightPlayController.o(SightPlayController.this) != null) && (SightPlayController.o(SightPlayController.this).isValid())) {
          break label713;
        }
        i = SightPlayController.this.hashCode();
        j = hashCode();
        boolean bool3;
        boolean bool4;
        if (SightPlayController.o(SightPlayController.this) == null)
        {
          bool1 = true;
          if (SightPlayController.p(SightPlayController.this) != null) {
            break label276;
          }
          bool2 = true;
          if (this.PGt.get() != null) {
            break label282;
          }
          bool3 = true;
          if (SightPlayController.q(SightPlayController.this) != null) {
            break label288;
          }
          bool4 = true;
          Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (SightPlayController.q(SightPlayController.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.PGt.get();
          if (SightPlayController.p(SightPlayController.this) != null) {
            localView1 = (View)SightPlayController.p(SightPlayController.this).get();
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
      if ((SightPlayController.r(SightPlayController.this) != null) && (SightPlayController.r(SightPlayController.this).getWidth() == SightPlayController.q(SightPlayController.this).getWidth()))
      {
        i = SightPlayController.r(SightPlayController.this).getHeight();
        j = SightPlayController.q(SightPlayController.this).getHeight();
        if (i == j) {
          break label444;
        }
      }
      label444:
      label506:
      final View localView2;
      try
      {
        SightPlayController.a(SightPlayController.this, Bitmap.createBitmap(SightPlayController.q(SightPlayController.this).getWidth(), SightPlayController.q(SightPlayController.this).getHeight(), Bitmap.Config.ARGB_8888));
        if ((SightPlayController.r(SightPlayController.this) == null) || (this.PGt.get() == null) || (((Bitmap)this.PGt.get()).isRecycled()))
        {
          if (SightPlayController.r(SightPlayController.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.PGt.get() != null) {
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
          SightPlayController.a(SightPlayController.this, null);
        }
        long l = System.nanoTime();
        SightVideoJNI.handleThumb((Bitmap)this.PGt.get(), SightPlayController.r(SightPlayController.this), SightPlayController.q(SightPlayController.this));
        Log.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
        localBitmap = SightPlayController.r(SightPlayController.this);
        if (SightPlayController.p(SightPlayController.this) != null) {}
        for (localView2 = (View)SightPlayController.p(SightPlayController.this).get(); (localView2 == null) || (localBitmap == null); localView2 = null)
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
      int i = SightPlayController.this.hashCode();
      int j = hashCode();
      if (this.PGt.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (SightPlayController.p(SightPlayController.this) != null)
        {
          localView2 = (View)SightPlayController.p(SightPlayController.this).get();
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
        if (this.PGt.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(SightPlayController.o(SightPlayController.this), 0);
          AppMethodBeat.o(116097);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(SightPlayController.o(SightPlayController.this), (Bitmap)this.PGt.get(), SightPlayController.q(SightPlayController.this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.model.SightPlayController
 * JD-Core Version:    0.7.0.1
 */