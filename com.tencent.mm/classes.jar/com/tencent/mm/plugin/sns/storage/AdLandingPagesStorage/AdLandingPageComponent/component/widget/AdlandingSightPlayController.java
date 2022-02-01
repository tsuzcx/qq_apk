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
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.abi;
import com.tencent.mm.autogen.a.abi.a;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AdlandingSightPlayController
{
  private static HashMap<String, WeakReference<Bitmap>> PFX = new HashMap();
  private static Map<String, Integer> PGb = new ConcurrentHashMap();
  protected int PFA = 41;
  private Bitmap PFB;
  private Bitmap PFC;
  private Bitmap PFD;
  WeakReference<View> PFE;
  WeakReference<TextView> PFF;
  private long PFG;
  private WeakReference<View> PFH;
  private Animation PFI;
  private Animation PFJ;
  boolean PFT = true;
  public boolean PFU = false;
  public boolean PFY = false;
  double PFZ = -1.0D;
  private int PFv = 0;
  private int PFw = 0;
  String PFx = "";
  int PFy = -1;
  boolean PGa = false;
  double PGc = -1.0D;
  private boolean PGd = false;
  boolean PGe = false;
  volatile g QTj;
  private volatile a QTk;
  volatile h QTl;
  private volatile b QTm;
  private j QTn;
  private i QTo;
  private c QTp;
  private ChattingUIStatusListener QTq;
  d QTr;
  e QTs;
  f QTt;
  String eDC = "";
  private MMHandler eqE = new MMHandler(Looper.getMainLooper());
  private Surface mSurface;
  private boolean oRS = false;
  boolean oYG = true;
  int position;
  
  public AdlandingSightPlayController(View paramView)
  {
    this.PFH = new WeakReference(paramView);
    Log.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(0) });
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
        AppMethodBeat.i(96872);
        long l = System.currentTimeMillis();
        SightVideoJNI.freeObj(paramInt);
        Log.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(96872);
      }
    }, 0L);
  }
  
  public final void Df(boolean paramBoolean)
  {
    if (this.QTj != null)
    {
      v.N(this.QTj);
      this.QTj.stop = true;
    }
    if (this.QTm != null)
    {
      this.eqE.removeCallbacks(this.QTm);
      this.QTm.stop = true;
    }
    if (this.QTk != null)
    {
      v.N(this.QTk);
      this.QTk.stop = true;
    }
    h localh;
    if (this.QTl != null)
    {
      localh = this.QTl;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      localh.type = i;
      v.h(this.QTl, 0L);
      return;
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
    this.QTj = new g((byte)0);
    v.h(this.QTj, 0L);
    return;
    if (1 == this.PFw)
    {
      this.QTk = new a((byte)0);
      this.QTm = null;
      v.h(this.QTk, 0L);
      return;
    }
    this.QTk = new a((byte)0);
    this.QTm = new b();
    this.QTk.QTv = this.QTm;
    this.QTm.QTx = this.QTk;
    v.h(this.QTk, 0L);
  }
  
  public final void clear()
  {
    Log.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.PFy), Boolean.valueOf(gYu()) });
    Df(true);
    this.PFG = 0L;
    ajn(this.PFy);
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
      if ((this.QTk == null) || (this.QTk.stop)) {}
    }
    while ((this.QTm != null) && (!this.QTm.stop) && (this.QTk != null) && (!this.QTk.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  final boolean gYv()
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
    if (this.QTq == null) {
      this.QTq = new ChattingUIStatusListener(this);
    }
    return this.QTq;
  }
  
  public final void hjO()
  {
    Log.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.TRUE });
    v.N(this.QTn);
    if (this.QTn == null) {
      this.QTn = new j((byte)0);
    }
    this.QTn.PGt = new WeakReference(null);
    v.h(this.QTn, 0L);
  }
  
  static class ChattingUIStatusListener
    extends IListener<abi>
  {
    int Ahg;
    int PGl;
    WeakReference<AdlandingSightPlayController> PGm;
    int xZt;
    
    public ChattingUIStatusListener(AdlandingSightPlayController paramAdlandingSightPlayController)
    {
      super();
      AppMethodBeat.i(96874);
      this.xZt = 0;
      this.PGl = 0;
      this.Ahg = 0;
      this.PGm = new WeakReference(paramAdlandingSightPlayController);
      this.__eventId = abi.class.getName().hashCode();
      AppMethodBeat.o(96874);
    }
    
    private void a(abi paramabi)
    {
      this.xZt = paramabi.ieT.ieW;
      this.PGl = paramabi.ieT.ieU;
      this.Ahg = paramabi.ieT.ieV;
    }
    
    private boolean gYA()
    {
      AppMethodBeat.i(96875);
      if (this.PGm.get() == null)
      {
        AppMethodBeat.o(96875);
        return false;
      }
      int i = AdlandingSightPlayController.D((AdlandingSightPlayController)this.PGm.get()) + this.xZt;
      if ((i < this.PGl) || (i > this.Ahg))
      {
        AppMethodBeat.o(96875);
        return false;
      }
      AppMethodBeat.o(96875);
      return true;
    }
  }
  
  final class a
    implements Runnable
  {
    AdlandingSightPlayController.b QTv;
    volatile boolean stop = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(96882);
      if ((AdlandingSightPlayController.q(AdlandingSightPlayController.this) != null) && (AdlandingSightPlayController.q(AdlandingSightPlayController.this).gYC() != null) && (AdlandingSightPlayController.q(AdlandingSightPlayController.this).gYC().getVisibility() == 0)) {
        AdlandingSightPlayController.g(AdlandingSightPlayController.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96877);
            AdlandingSightPlayController.q(AdlandingSightPlayController.this).gYC().setVisibility(8);
            AppMethodBeat.o(96877);
          }
        });
      }
      if (AdlandingSightPlayController.e(AdlandingSightPlayController.this) < 0)
      {
        Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()), AdlandingSightPlayController.a(AdlandingSightPlayController.this) });
        AppMethodBeat.o(96882);
        return;
      }
      if (this.stop)
      {
        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(96882);
        return;
      }
      if (AdlandingSightPlayController.r(AdlandingSightPlayController.this) == 0L)
      {
        if (AdlandingSightPlayController.s(AdlandingSightPlayController.this) != null)
        {
          AdlandingSightPlayController.s(AdlandingSightPlayController.this).type = 1;
          AdlandingSightPlayController.s(AdlandingSightPlayController.this).run();
        }
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, System.currentTimeMillis());
      }
      int j = 0;
      int i = j;
      if (AdlandingSightPlayController.t(AdlandingSightPlayController.this) != -1.0D)
      {
        if (AdlandingSightPlayController.this.PFU) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(AdlandingSightPlayController.t(AdlandingSightPlayController.this), AdlandingSightPlayController.e(AdlandingSightPlayController.this)) > 0)
        {
          if (AdlandingSightPlayController.s(AdlandingSightPlayController.this) == null) {
            AdlandingSightPlayController.a(AdlandingSightPlayController.this, new AdlandingSightPlayController.h(AdlandingSightPlayController.this, (byte)0));
          }
          AdlandingSightPlayController.s(AdlandingSightPlayController.this).type = 4;
          AdlandingSightPlayController.s(AdlandingSightPlayController.this).PGc = AdlandingSightPlayController.t(AdlandingSightPlayController.this);
          AdlandingSightPlayController.s(AdlandingSightPlayController.this).run();
          i = 1;
        }
      }
      float f3 = (float)(System.currentTimeMillis() - AdlandingSightPlayController.r(AdlandingSightPlayController.this));
      float f1;
      label375:
      float f2;
      double d;
      if (i != 0)
      {
        f1 = 0.0F;
        f2 = f1;
        if (AdlandingSightPlayController.this.PFU)
        {
          f2 = f1;
          if (AdlandingSightPlayController.u(AdlandingSightPlayController.this))
          {
            AdlandingSightPlayController.a(AdlandingSightPlayController.this, false);
            f2 = f1;
            if (AdlandingSightPlayController.s(AdlandingSightPlayController.this) != null)
            {
              d = AdlandingSightPlayController.s(AdlandingSightPlayController.this).gYE() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, AdlandingSightPlayController.e(AdlandingSightPlayController.this)) > 0)
              {
                f2 = 0.0F;
                Log.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (AdlandingSightPlayController.v(AdlandingSightPlayController.this)) {
          Log.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(AdlandingSightPlayController.e(AdlandingSightPlayController.this)), Float.valueOf(f3), Float.valueOf(f2) });
        }
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, System.currentTimeMillis());
        if (f2 < 2.0F) {
          break label813;
        }
        AdlandingSightPlayController.w(AdlandingSightPlayController.this);
      }
      for (;;)
      {
        if (!AdlandingSightPlayController.c(AdlandingSightPlayController.this)) {
          break label837;
        }
        Log.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(AdlandingSightPlayController.x(AdlandingSightPlayController.this)) });
        AdlandingSightPlayController.this.clear();
        AppMethodBeat.o(96882);
        return;
        label620:
        if (AdlandingSightPlayController.s(AdlandingSightPlayController.this) != null)
        {
          AdlandingSightPlayController.s(AdlandingSightPlayController.this).type = 4;
          AdlandingSightPlayController.s(AdlandingSightPlayController.this).PGc = AdlandingSightPlayController.t(AdlandingSightPlayController.this);
          AdlandingSightPlayController.s(AdlandingSightPlayController.this).run();
          AdlandingSightPlayController.g(AdlandingSightPlayController.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96878);
              AdlandingSightPlayController.a(AdlandingSightPlayController.this, true);
              AppMethodBeat.o(96878);
            }
          }, 100L);
          i = j;
          break;
        }
        i = j;
        if (SightVideoJNI.seekStream(AdlandingSightPlayController.t(AdlandingSightPlayController.this), AdlandingSightPlayController.e(AdlandingSightPlayController.this)) <= 0) {
          break;
        }
        if (AdlandingSightPlayController.s(AdlandingSightPlayController.this) == null) {
          AdlandingSightPlayController.a(AdlandingSightPlayController.this, new AdlandingSightPlayController.h(AdlandingSightPlayController.this, (byte)0));
        }
        AdlandingSightPlayController.s(AdlandingSightPlayController.this).type = 4;
        AdlandingSightPlayController.s(AdlandingSightPlayController.this).PGc = AdlandingSightPlayController.t(AdlandingSightPlayController.this);
        AdlandingSightPlayController.s(AdlandingSightPlayController.this).run();
        i = 1;
        break;
        f1 = f3 / AdlandingSightPlayController.this.PFA + 0.5F;
        break label375;
        label813:
        AdlandingSightPlayController.c(AdlandingSightPlayController.this, Math.max(0, AdlandingSightPlayController.x(AdlandingSightPlayController.this) - 1));
      }
      label837:
      int k = 0;
      j = 0;
      int m = 0;
      if (1 == AdlandingSightPlayController.d(AdlandingSightPlayController.this)) {
        if ((AdlandingSightPlayController.m(AdlandingSightPlayController.this) != null) && (!AdlandingSightPlayController.m(AdlandingSightPlayController.this).isValid()))
        {
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()) });
          this.stop = true;
          if (this.QTv == null) {
            break label1394;
          }
          this.QTv.stop = true;
          i = 0;
          j = m;
          if (AdlandingSightPlayController.s(AdlandingSightPlayController.this) == null) {
            break label2139;
          }
          Log.d("MicroMsg.SightPlayController", "voice time is" + AdlandingSightPlayController.s(AdlandingSightPlayController.this).gYE() / 1000.0D);
        }
      }
      label1719:
      label2139:
      for (;;)
      {
        if (1 == j) {
          AdlandingSightPlayController.g(AdlandingSightPlayController.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96880);
              if (AdlandingSightPlayController.b(AdlandingSightPlayController.this) != null) {
                AdlandingSightPlayController.b(AdlandingSightPlayController.this).alj(0);
              }
              AppMethodBeat.o(96880);
            }
          });
        }
        if (this.stop)
        {
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()) });
          if (AdlandingSightPlayController.s(AdlandingSightPlayController.this) != null)
          {
            AdlandingSightPlayController.s(AdlandingSightPlayController.this).type = 0;
            AdlandingSightPlayController.s(AdlandingSightPlayController.this).run();
          }
          AppMethodBeat.o(96882);
          return;
          i = SightVideoJNI.drawSurfaceFrame(AdlandingSightPlayController.e(AdlandingSightPlayController.this), AdlandingSightPlayController.m(AdlandingSightPlayController.this), (int)f2, AdlandingSightPlayController.o(AdlandingSightPlayController.this), AdlandingSightPlayController.y(AdlandingSightPlayController.this));
          if (AdlandingSightPlayController.z(AdlandingSightPlayController.this) != null)
          {
            d = SightVideoJNI.getVideoPlayTime(AdlandingSightPlayController.e(AdlandingSightPlayController.this));
            j = (int)d;
            if (j != (int)AdlandingSightPlayController.this.PFZ) {
              AdlandingSightPlayController.z(AdlandingSightPlayController.this).va(j);
            }
            AdlandingSightPlayController.this.PFZ = d;
          }
          if (i == 0)
          {
            AdlandingSightPlayController.a(AdlandingSightPlayController.this, -1.0D);
            k = 0;
            j = i;
            i = k;
            break;
          }
          if (1 == i)
          {
            AdlandingSightPlayController.a(AdlandingSightPlayController.this, -1.0D);
            k = 1;
            AdlandingSightPlayController.a(AdlandingSightPlayController.this, 0L);
            AdlandingSightPlayController.A(AdlandingSightPlayController.this);
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
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i) });
          this.stop = true;
          if (this.QTv != null) {
            this.QTv.stop = true;
          }
          AdlandingSightPlayController.this.hjO();
          j = i;
          if (AdlandingSightPlayController.b(AdlandingSightPlayController.this) != null)
          {
            AdlandingSightPlayController.b(AdlandingSightPlayController.this).alj(-1);
            j = i;
          }
          label1394:
          i = 0;
          break;
          m = SightVideoJNI.drawFrame(AdlandingSightPlayController.e(AdlandingSightPlayController.this), AdlandingSightPlayController.B(AdlandingSightPlayController.this), (int)f2, null, false, AdlandingSightPlayController.y(AdlandingSightPlayController.this));
          if (AdlandingSightPlayController.z(AdlandingSightPlayController.this) != null)
          {
            d = SightVideoJNI.getVideoPlayTime(AdlandingSightPlayController.e(AdlandingSightPlayController.this));
            i = (int)d;
            if (i != (int)AdlandingSightPlayController.this.PFZ) {
              AdlandingSightPlayController.z(AdlandingSightPlayController.this).va(i);
            }
            AdlandingSightPlayController.this.PFZ = d;
            if (AdlandingSightPlayController.v(AdlandingSightPlayController.this)) {
              Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
            }
          }
          for (;;)
          {
            if (m != 0) {
              break label1719;
            }
            AdlandingSightPlayController.a(AdlandingSightPlayController.this, -1.0D);
            j = m;
            i = k;
            break;
            if (AdlandingSightPlayController.v(AdlandingSightPlayController.this))
            {
              d = SightVideoJNI.getVideoPlayTime(AdlandingSightPlayController.e(AdlandingSightPlayController.this));
              if (AdlandingSightPlayController.v(AdlandingSightPlayController.this)) {
                Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (AdlandingSightPlayController.v(AdlandingSightPlayController.this))
            {
              Log.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            }
          }
          if (1 == m)
          {
            AdlandingSightPlayController.a(AdlandingSightPlayController.this, -1.0D);
            i = 1;
            AdlandingSightPlayController.a(AdlandingSightPlayController.this, 0L);
            AdlandingSightPlayController.A(AdlandingSightPlayController.this);
            j = m;
            continue;
          }
          AdlandingSightPlayController.a(AdlandingSightPlayController.this, -1.0D);
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
          this.stop = true;
          if (this.QTv != null) {
            this.QTv.stop = true;
          }
          AdlandingSightPlayController.g(AdlandingSightPlayController.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96879);
              AdlandingSightPlayController.this.aF(null);
              AppMethodBeat.o(96879);
            }
          });
          j = m;
          i = k;
          if (AdlandingSightPlayController.b(AdlandingSightPlayController.this) == null) {
            continue;
          }
          AdlandingSightPlayController.b(AdlandingSightPlayController.this).alj(-1);
          j = m;
          i = k;
          continue;
        }
        long l;
        if (1 == AdlandingSightPlayController.d(AdlandingSightPlayController.this))
        {
          l = AdlandingSightPlayController.this.PFA - (System.currentTimeMillis() - AdlandingSightPlayController.r(AdlandingSightPlayController.this));
          if (AdlandingSightPlayController.r(AdlandingSightPlayController.this) == 0L) {
            v.h(this, AdlandingSightPlayController.this.PFA * 5);
          }
        }
        for (;;)
        {
          if (AdlandingSightPlayController.s(AdlandingSightPlayController.this) != null) {
            Log.d("MicroMsg.SightPlayController", "voice time is" + AdlandingSightPlayController.s(AdlandingSightPlayController.this).gYE() / 1000.0D);
          }
          AppMethodBeat.o(96882);
          return;
          if (l > 0L)
          {
            v.h(this, l);
          }
          else
          {
            v.h(this, 0L);
            continue;
            if ((i != 0) && (AdlandingSightPlayController.q(AdlandingSightPlayController.this) != null))
            {
              i = AdlandingSightPlayController.q(AdlandingSightPlayController.this).gYB();
              AdlandingSightPlayController.g(AdlandingSightPlayController.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(96881);
                  if (AdlandingSightPlayController.q(AdlandingSightPlayController.this) != null)
                  {
                    View localView = AdlandingSightPlayController.q(AdlandingSightPlayController.this).gYC();
                    if (localView != null)
                    {
                      if ((AdlandingSightPlayController.C(AdlandingSightPlayController.this) == null) && (AdlandingSightPlayController.q(AdlandingSightPlayController.this).gYD() != -1) && (AdlandingSightPlayController.k(AdlandingSightPlayController.this).get() != null)) {
                        AdlandingSightPlayController.a(AdlandingSightPlayController.this, AnimationUtils.loadAnimation(((View)AdlandingSightPlayController.k(AdlandingSightPlayController.this).get()).getContext(), AdlandingSightPlayController.q(AdlandingSightPlayController.this).gYD()));
                      }
                      if (AdlandingSightPlayController.C(AdlandingSightPlayController.this) != null) {
                        localView.startAnimation(AdlandingSightPlayController.C(AdlandingSightPlayController.this));
                      }
                      localView.setVisibility(0);
                    }
                  }
                  AppMethodBeat.o(96881);
                }
              });
              this.QTv.PGp = j;
              AdlandingSightPlayController.g(AdlandingSightPlayController.this).postDelayed(this.QTv, i);
            }
            else
            {
              this.QTv.PGp = j;
              AdlandingSightPlayController.g(AdlandingSightPlayController.this).post(this.QTv);
            }
          }
        }
      }
    }
  }
  
  final class b
    implements Runnable
  {
    int PGp;
    AdlandingSightPlayController.a QTx;
    volatile boolean stop;
    
    public b()
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
        Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(96884);
        return;
      }
      AdlandingSightPlayController.this.aF(AdlandingSightPlayController.B(AdlandingSightPlayController.this));
      if (AdlandingSightPlayController.r(AdlandingSightPlayController.this) == 0L)
      {
        v.h(this.QTx, 0L);
        AppMethodBeat.o(96884);
        return;
      }
      long l = AdlandingSightPlayController.this.PFA - (System.currentTimeMillis() - AdlandingSightPlayController.r(AdlandingSightPlayController.this));
      if (l > 0L)
      {
        v.h(this.QTx, l);
        AppMethodBeat.o(96884);
        return;
      }
      v.h(this.QTx, 0L);
      AppMethodBeat.o(96884);
    }
  }
  
  final class c
    implements Runnable
  {
    private c() {}
    
    public final void run()
    {
      AppMethodBeat.i(96885);
      if (AdlandingSightPlayController.k(AdlandingSightPlayController.this).get() == null)
      {
        AppMethodBeat.o(96885);
        return;
      }
      ((View)AdlandingSightPlayController.k(AdlandingSightPlayController.this).get()).startAnimation(AdlandingSightPlayController.l(AdlandingSightPlayController.this));
      AppMethodBeat.o(96885);
    }
  }
  
  public static abstract interface d
  {
    public abstract void alj(int paramInt);
  }
  
  public static abstract interface e
  {
    public abstract void va(long paramLong);
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
      AppMethodBeat.i(96886);
      if (AdlandingSightPlayController.c(AdlandingSightPlayController.this))
      {
        Log.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
        AppMethodBeat.o(96886);
        return;
      }
      AdlandingSightPlayController localAdlandingSightPlayController = AdlandingSightPlayController.this;
      String str = AdlandingSightPlayController.a(AdlandingSightPlayController.this);
      if (1 == AdlandingSightPlayController.d(AdlandingSightPlayController.this)) {}
      for (int i = 0;; i = 1)
      {
        AdlandingSightPlayController.a(localAdlandingSightPlayController, SightVideoJNI.openFileVFS(str, i, 1, false));
        if (AdlandingSightPlayController.e(AdlandingSightPlayController.this) >= 0) {
          break;
        }
        Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(AdlandingSightPlayController.e(AdlandingSightPlayController.this)), AdlandingSightPlayController.a(AdlandingSightPlayController.this) });
        AdlandingSightPlayController.this.hjO();
        if (AdlandingSightPlayController.b(AdlandingSightPlayController.this) != null) {
          AdlandingSightPlayController.b(AdlandingSightPlayController.this).alj(-1);
        }
        AppMethodBeat.o(96886);
        return;
      }
      if (((Boolean)AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.FALSE)).booleanValue())
      {
        if (AdlandingSightPlayController.f(AdlandingSightPlayController.this) == null) {
          AdlandingSightPlayController.a(AdlandingSightPlayController.this, new AdlandingSightPlayController.i(AdlandingSightPlayController.this, (byte)0));
        }
        AdlandingSightPlayController.g(AdlandingSightPlayController.this).removeCallbacks(AdlandingSightPlayController.f(AdlandingSightPlayController.this));
        AdlandingSightPlayController.g(AdlandingSightPlayController.this).post(AdlandingSightPlayController.f(AdlandingSightPlayController.this));
      }
      i = Math.max(1, SightVideoJNI.getVideoWidth(AdlandingSightPlayController.e(AdlandingSightPlayController.this)));
      int j = Math.max(1, SightVideoJNI.getVideoHeight(AdlandingSightPlayController.e(AdlandingSightPlayController.this)));
      if (AdlandingSightPlayController.d(AdlandingSightPlayController.this) == 0)
      {
        if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
        {
          Log.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(96886);
          return;
        }
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, i, j);
      }
      AdlandingSightPlayController.this.gYw();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        Log.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!Util.isNullOrNil(AdlandingSightPlayController.a(AdlandingSightPlayController.this))) {
          AdlandingSightPlayController.hjP().put(AdlandingSightPlayController.a(AdlandingSightPlayController.this), Integer.valueOf(2));
        }
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, 0L);
        AdlandingSightPlayController.b(AdlandingSightPlayController.this, AdlandingSightPlayController.e(AdlandingSightPlayController.this));
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, -1);
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, "");
        AdlandingSightPlayController.b(AdlandingSightPlayController.this, "ERROR#PATH");
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, null);
        this.stop = true;
        if (AdlandingSightPlayController.b(AdlandingSightPlayController.this) != null) {
          AdlandingSightPlayController.b(AdlandingSightPlayController.this).alj(-1);
        }
        AppMethodBeat.o(96886);
        return;
      }
      AdlandingSightPlayController.this.fG(i, j);
      if (1 == AdlandingSightPlayController.d(AdlandingSightPlayController.this))
      {
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, new AdlandingSightPlayController.a(AdlandingSightPlayController.this, (byte)0));
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, null);
        if (!this.stop) {
          v.h(AdlandingSightPlayController.h(AdlandingSightPlayController.this), 0L);
        }
      }
      for (;;)
      {
        if (this.stop) {
          Log.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(AdlandingSightPlayController.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
        }
        AppMethodBeat.o(96886);
        return;
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, new AdlandingSightPlayController.a(AdlandingSightPlayController.this, (byte)0));
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, new AdlandingSightPlayController.b(AdlandingSightPlayController.this));
        AdlandingSightPlayController.h(AdlandingSightPlayController.this).QTv = AdlandingSightPlayController.i(AdlandingSightPlayController.this);
        AdlandingSightPlayController.i(AdlandingSightPlayController.this).QTx = AdlandingSightPlayController.h(AdlandingSightPlayController.this);
        if (!this.stop) {
          v.h(AdlandingSightPlayController.h(AdlandingSightPlayController.this), 0L);
        }
      }
    }
  }
  
  final class h
    implements Runnable
  {
    double PGc = -1.0D;
    MediaPlayer PGr;
    int type;
    
    private h() {}
    
    private void gnu()
    {
      AppMethodBeat.i(96888);
      Log.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.PGr != null)
        {
          this.PGr.stop();
          this.PGr.release();
          this.PGr = null;
        }
        AppMethodBeat.o(96888);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.PGr = null;
        AppMethodBeat.o(96888);
      }
    }
    
    public final double gYE()
    {
      AppMethodBeat.i(96889);
      if (this.PGr == null)
      {
        AppMethodBeat.o(96889);
        return 0.0D;
      }
      double d = this.PGr.getCurrentPosition();
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
        gnu();
        if (!Util.isNullOrNil(AdlandingSightPlayController.a(AdlandingSightPlayController.this)))
        {
          try
          {
            this.PGr = new k();
            this.PGr.setDisplay(null);
            this.PGr.reset();
            this.PGr.setDataSource(AdlandingSightPlayController.a(AdlandingSightPlayController.this));
            this.PGr.setAudioStreamType(3);
            this.PGr.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(96887);
                Log.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { AdlandingSightPlayController.a(AdlandingSightPlayController.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                AdlandingSightPlayController.this.clear();
                if (AdlandingSightPlayController.b(AdlandingSightPlayController.this) != null) {
                  AdlandingSightPlayController.b(AdlandingSightPlayController.this).alj(-1);
                }
                AppMethodBeat.o(96887);
                return true;
              }
            });
            this.PGr.prepare();
            this.PGr.start();
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException1)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            Log.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { AdlandingSightPlayController.a(AdlandingSightPlayController.this) });
            AdlandingSightPlayController.this.clear();
            if (AdlandingSightPlayController.b(AdlandingSightPlayController.this) != null) {
              AdlandingSightPlayController.b(AdlandingSightPlayController.this).alj(-1);
            }
            AppMethodBeat.o(96890);
            return;
          }
          gnu();
          AppMethodBeat.o(96890);
          return;
          try
          {
            if ((this.PGr != null) && (this.PGr.isPlaying())) {
              this.PGr.pause();
            }
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException2)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            gnu();
            AppMethodBeat.o(96890);
            return;
          }
          try
          {
            if (this.PGr != null) {
              this.PGr.start();
            }
            AppMethodBeat.o(96890);
            return;
          }
          catch (Exception localException3)
          {
            Log.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            gnu();
            AppMethodBeat.o(96890);
            return;
          }
          try
          {
            Log.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.PGc) });
            this.PGr.seekTo((int)(this.PGc * 1000.0D));
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
  
  final class i
    implements Runnable
  {
    private i() {}
    
    public final void run()
    {
      AppMethodBeat.i(96891);
      if ((AdlandingSightPlayController.e(AdlandingSightPlayController.this) < 0) || (AdlandingSightPlayController.j(AdlandingSightPlayController.this) == null) || (AdlandingSightPlayController.j(AdlandingSightPlayController.this).get() == null))
      {
        AppMethodBeat.o(96891);
        return;
      }
      String str = SightVideoJNI.getVideoInfo(AdlandingSightPlayController.e(AdlandingSightPlayController.this));
      ((TextView)AdlandingSightPlayController.j(AdlandingSightPlayController.this).get()).setText(str);
      AppMethodBeat.o(96891);
    }
  }
  
  final class j
    implements Runnable
  {
    WeakReference<Bitmap> PGt;
    
    private j()
    {
      AppMethodBeat.i(96895);
      this.PGt = new WeakReference(null);
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
        if ((AdlandingSightPlayController.m(AdlandingSightPlayController.this) != null) && (AdlandingSightPlayController.m(AdlandingSightPlayController.this).isValid())) {
          break label713;
        }
        i = AdlandingSightPlayController.this.hashCode();
        j = hashCode();
        boolean bool3;
        boolean bool4;
        if (AdlandingSightPlayController.m(AdlandingSightPlayController.this) == null)
        {
          bool1 = true;
          if (AdlandingSightPlayController.n(AdlandingSightPlayController.this) != null) {
            break label276;
          }
          bool2 = true;
          if (this.PGt.get() != null) {
            break label282;
          }
          bool3 = true;
          if (AdlandingSightPlayController.o(AdlandingSightPlayController.this) != null) {
            break label288;
          }
          bool4 = true;
          Log.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (AdlandingSightPlayController.o(AdlandingSightPlayController.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.PGt.get();
          if (AdlandingSightPlayController.n(AdlandingSightPlayController.this) != null) {
            localView1 = (View)AdlandingSightPlayController.n(AdlandingSightPlayController.this).get();
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
      if ((AdlandingSightPlayController.p(AdlandingSightPlayController.this) != null) && (AdlandingSightPlayController.p(AdlandingSightPlayController.this).getWidth() == AdlandingSightPlayController.o(AdlandingSightPlayController.this).getWidth()))
      {
        i = AdlandingSightPlayController.p(AdlandingSightPlayController.this).getHeight();
        j = AdlandingSightPlayController.o(AdlandingSightPlayController.this).getHeight();
        if (i == j) {
          break label444;
        }
      }
      label444:
      label506:
      final View localView2;
      try
      {
        AdlandingSightPlayController.a(AdlandingSightPlayController.this, Bitmap.createBitmap(AdlandingSightPlayController.o(AdlandingSightPlayController.this).getWidth(), AdlandingSightPlayController.o(AdlandingSightPlayController.this).getHeight(), Bitmap.Config.ARGB_8888));
        if ((AdlandingSightPlayController.p(AdlandingSightPlayController.this) == null) || (this.PGt.get() == null) || (((Bitmap)this.PGt.get()).isRecycled()))
        {
          if (AdlandingSightPlayController.p(AdlandingSightPlayController.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.PGt.get() != null) {
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
          AdlandingSightPlayController.a(AdlandingSightPlayController.this, null);
        }
        long l = System.nanoTime();
        SightVideoJNI.handleThumb((Bitmap)this.PGt.get(), AdlandingSightPlayController.p(AdlandingSightPlayController.this), AdlandingSightPlayController.o(AdlandingSightPlayController.this));
        Log.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
        localBitmap = AdlandingSightPlayController.p(AdlandingSightPlayController.this);
        if (AdlandingSightPlayController.n(AdlandingSightPlayController.this) != null) {}
        for (localView2 = (View)AdlandingSightPlayController.n(AdlandingSightPlayController.this).get(); (localView2 == null) || (localBitmap == null); localView2 = null)
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
      int i = AdlandingSightPlayController.this.hashCode();
      int j = hashCode();
      if (this.PGt.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (AdlandingSightPlayController.n(AdlandingSightPlayController.this) != null)
        {
          localView2 = (View)AdlandingSightPlayController.n(AdlandingSightPlayController.this).get();
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
        if (this.PGt.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(AdlandingSightPlayController.m(AdlandingSightPlayController.this), 0);
          AppMethodBeat.o(96896);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(AdlandingSightPlayController.m(AdlandingSightPlayController.this), (Bitmap)this.PGt.get(), AdlandingSightPlayController.o(AdlandingSightPlayController.this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdlandingSightPlayController
 * JD-Core Version:    0.7.0.1
 */