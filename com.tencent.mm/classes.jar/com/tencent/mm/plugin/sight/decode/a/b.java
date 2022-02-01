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
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.a.wj.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> xDf = new HashMap();
  private static Map<String, Integer> xDj = new ConcurrentHashMap();
  public String cko = "";
  private ao gqT;
  private boolean hRB = false;
  public boolean hYH = true;
  private Surface mSurface;
  public int position;
  private int xCD = 0;
  private int xCE = 0;
  private String xCF = "";
  private int xCG = -1;
  private Queue<Integer> xCH = new ConcurrentLinkedQueue();
  protected int xCI = 41;
  private Bitmap xCJ;
  public Bitmap xCK;
  private Bitmap xCL;
  private WeakReference<View> xCM;
  private WeakReference<TextView> xCN;
  private long xCO;
  public WeakReference<View> xCP;
  private Animation xCQ;
  private Animation xCR;
  private volatile h xCS;
  private volatile b xCT;
  public volatile i xCU;
  private volatile c xCV;
  private k xCW;
  private j xCX;
  private d xCY;
  private f xCZ = new f()
  {
    public final void b(b paramAnonymousb, long paramAnonymousLong) {}
  };
  public boolean xDa = true;
  public boolean xDb = true;
  public boolean xDc = false;
  public boolean xDd = false;
  public boolean xDe = false;
  public boolean xDg = false;
  public double xDh = -1.0D;
  boolean xDi = false;
  public double xDk = -1.0D;
  private boolean xDl = false;
  public boolean xDm = false;
  private a xDn;
  public volatile e xDo;
  private volatile f xDp;
  public volatile g xDq;
  
  public b(int paramInt, View paramView)
  {
    this.xCE = paramInt;
    this.gqT = new ao(Looper.getMainLooper());
    this.xCP = new WeakReference(paramView);
    ac.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void NR(int paramInt)
  {
    com.tencent.mm.modelvideo.o.h(new b.3(this, paramInt), 0L);
  }
  
  public static boolean asy(String paramString)
  {
    if (bs.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)xDj.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  public static void avJ()
  {
    com.tencent.mm.modelvideo.o.h(new b.2(), 0L);
  }
  
  public static Bitmap b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = String.format("%s-%s-%s-%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = (WeakReference)xDf.get(str);
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      return (Bitmap)((WeakReference)localObject).get();
    }
    if (paramContext == null)
    {
      ac.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
      return null;
    }
    if (paramInt1 <= 0)
    {
      ac.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
      return null;
    }
    if ((paramInt2 <= 0) || (paramInt4 <= 0) || (paramInt3 <= 0))
    {
      ac.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
      return null;
    }
    long l = bs.Gn();
    paramInt3 = paramInt2 * paramInt4 / paramInt3;
    paramContext = (NinePatchDrawable)paramContext.getResources().getDrawable(paramInt1);
    paramContext.setBounds(0, 0, paramInt2, paramInt3);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    paramContext.draw(new Canvas((Bitmap)localObject));
    xDf.put(str, new WeakReference(localObject));
    ac.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[] { Long.valueOf(bs.aO(l)) });
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
      NR(localInteger.intValue());
    }
  }
  
  public final void ae(Bitmap paramBitmap)
  {
    boolean bool = true;
    if (paramBitmap == null) {}
    for (;;)
    {
      ac.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.modelvideo.o.H(this.xCW);
      if (this.xCW == null) {
        this.xCW = new k((byte)0);
      }
      this.xCW.xDB = new WeakReference(paramBitmap);
      com.tencent.mm.modelvideo.o.h(this.xCW, 0L);
      return;
      bool = false;
    }
  }
  
  public abstract void af(Bitmap paramBitmap);
  
  public final void bA(String paramString, boolean paramBoolean)
  {
    ac.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(hashCode()), paramString, this.cko, Boolean.valueOf(paramBoolean), Integer.valueOf(this.xCG), Boolean.valueOf(this.xDm), Boolean.valueOf(this.xDb) });
    if (this.xDm)
    {
      qy(false);
      return;
    }
    if (dEA())
    {
      ac.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      clear();
      return;
    }
    if (!this.xDb)
    {
      clear();
      return;
    }
    if (paramBoolean)
    {
      this.xCF = paramString;
      qy(false);
      return;
    }
    if (this.cko.equals(paramString))
    {
      this.xCF = "ERROR#PATH";
      qy(false);
      restart();
      return;
    }
    clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.cko = str;
    if (bs.isNullOrNil(this.cko))
    {
      ac.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      ae(null);
      return;
    }
    if (!asy(this.cko))
    {
      ac.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.xCS = new h((byte)0);
    com.tencent.mm.modelvideo.o.h(this.xCS, 0L);
  }
  
  public final void clear()
  {
    ac.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.xCG), Boolean.valueOf(dEz()) });
    qy(true);
    this.xCO = 0L;
    d(this.xCH);
    this.xCG = -1;
    this.cko = "";
    this.xCF = "ERROR#PATH";
    this.xCL = null;
    this.xDh = 0.0D;
    this.xDi = false;
    com.tencent.mm.memory.o.heJ.f(this.xCJ);
    this.xCJ = null;
  }
  
  public final boolean dEA()
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
    if (this.xDn == null) {
      this.xDn = new a(this);
    }
    return this.xDn;
  }
  
  public final double dED()
  {
    if (this.xCG == -1) {
      return 0.0D;
    }
    return SightVideoJNI.getVideoDuration(this.xCG);
  }
  
  protected int dEy()
  {
    return -1;
  }
  
  public final boolean dEz()
  {
    if (1 == this.xCE) {
      if ((this.xCT == null) || (this.xCT.stop)) {}
    }
    while ((this.xCV != null) && (!this.xCV.stop) && (this.xCT != null) && (!this.xCT.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public abstract void dZ(int paramInt1, int paramInt2);
  
  public final void j(Surface paramSurface)
  {
    ac.v("MicroMsg.SightPlayController", "set play surface %s", new Object[] { paramSurface });
    this.mSurface = paramSurface;
    com.tencent.mm.modelvideo.o.h(this.xCW, 0L);
  }
  
  public final void qy(boolean paramBoolean)
  {
    if (this.xCS != null)
    {
      com.tencent.mm.modelvideo.o.H(this.xCS);
      this.xCS.stop = true;
    }
    if (this.xCV != null)
    {
      this.gqT.removeCallbacks(this.xCV);
      this.xCV.stop = true;
    }
    if (this.xCT != null)
    {
      com.tencent.mm.modelvideo.o.H(this.xCT);
      this.xCT.stop = true;
    }
    i locali;
    if (this.xCU != null)
    {
      locali = this.xCU;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.h(this.xCU, 0L);
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
    this.xCS = new h((byte)0);
    com.tencent.mm.modelvideo.o.h(this.xCS, 0L);
    return;
    if (1 == this.xCE)
    {
      this.xCT = new b((byte)0);
      this.xCV = null;
      com.tencent.mm.modelvideo.o.h(this.xCT, 0L);
      return;
    }
    this.xCT = new b((byte)0);
    this.xCV = new c();
    this.xCT.xDv = this.xCV;
    this.xCV.xDy = this.xCT;
    com.tencent.mm.modelvideo.o.h(this.xCT, 0L);
  }
  
  public final void setOnDecodeDurationListener(f paramf)
  {
    if (paramf == null) {
      this.xDp = this.xCZ;
    }
    this.xDp = paramf;
  }
  
  public final void setSightInfoView(TextView paramTextView)
  {
    this.xCN = new WeakReference(paramTextView);
  }
  
  public final void setThumbBgView(View paramView)
  {
    this.xCM = new WeakReference(paramView);
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
      AppMethodBeat.i(116075);
      this.rZI = 0;
      this.xDt = 0;
      this.qME = 0;
      this.xDu = new WeakReference(paramb);
      this.__eventId = wj.class.getName().hashCode();
      AppMethodBeat.o(116075);
    }
    
    private void a(wj paramwj)
    {
      this.rZI = paramwj.dzj.dzm;
      this.xDt = paramwj.dzj.dzk;
      this.qME = paramwj.dzj.dzl;
    }
    
    private boolean dEF()
    {
      AppMethodBeat.i(116076);
      if (this.xDu.get() == null)
      {
        AppMethodBeat.o(116076);
        return false;
      }
      int i = b.G((b)this.xDu.get()) + this.rZI;
      if ((i < this.xDt) || (i > this.qME))
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
    b.c xDv;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(116083);
      if ((b.s(b.this) != null) && (b.s(b.this).dEH() != null) && (b.s(b.this).dEH().getVisibility() == 0)) {
        b.h(b.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116078);
            b.s(b.this).dEH().setVisibility(8);
            AppMethodBeat.o(116078);
          }
        });
      }
      if (b.e(b.this) < 0)
      {
        ac.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), b.a(b.this) });
        AppMethodBeat.o(116083);
        return;
      }
      if (this.stop)
      {
        ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
        if (b.this.xDc) {
          break label620;
        }
        i = j;
        if (SightVideoJNI.seekStream(b.v(b.this), b.e(b.this)) > 0)
        {
          if (b.u(b.this) == null) {
            b.a(b.this, new b.i(b.this, (byte)0));
          }
          b.u(b.this).type = 4;
          b.u(b.this).xDk = b.v(b.this);
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
        if (b.this.xDc)
        {
          f2 = f1;
          if (b.w(b.this))
          {
            b.a(b.this, false);
            f2 = f1;
            if (b.u(b.this) != null)
            {
              d = b.u(b.this).dEJ() / 1000.0D;
              f2 = f1;
              if (SightVideoJNI.seekStream(d, b.e(b.this)) > 0)
              {
                f2 = 0.0F;
                ac.i("MicroMsg.SightPlayController", "seek to " + d + " modify time : 0.0");
              }
            }
          }
        }
        if (b.x(b.this)) {
          ac.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), Float.valueOf(f3), Float.valueOf(f2) });
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
        ac.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[] { Integer.valueOf(b.z(b.this)) });
        b.this.clear();
        AppMethodBeat.o(116083);
        return;
        label620:
        if (b.u(b.this) != null)
        {
          b.u(b.this).type = 4;
          b.u(b.this).xDk = b.v(b.this);
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
        b.u(b.this).xDk = b.v(b.this);
        b.u(b.this).run();
        i = 1;
        break;
        f1 = f3 / b.this.xCI + 0.5F;
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
          ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
          this.stop = true;
          if (this.xDv == null) {
            break label2266;
          }
          this.xDv.stop = true;
          i = 0;
        }
      }
      for (;;)
      {
        if (b.u(b.this) != null) {
          ac.d("MicroMsg.SightPlayController", "voice time is" + b.u(b.this).dEJ() / 1000.0D);
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
            ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
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
                    if (k != (int)b.this.xDh)
                    {
                      i = j;
                      if (b.B(b.this) != null)
                      {
                        i = j;
                        b.B(b.this).b(b.this, k);
                      }
                    }
                    i = j;
                    b.this.xDh = d;
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
          ac.e("MicroMsg.SightPlayController", "decode job:%s", new Object[] { localException1.getMessage() });
          break;
          if (-7 == j)
          {
            i = j;
            ac.w("MicroMsg.SightPlayController", "surface is null, continue");
            i = 0;
            break;
          }
          i = j;
          ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(j) });
          i = j;
          this.stop = true;
          i = j;
          if (this.xDv != null)
          {
            i = j;
            this.xDv.stop = true;
          }
          i = j;
          b.this.ae(null);
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
            if (i != (int)b.this.xDh) {
              b.B(b.this).b(b.this, i);
            }
            b.this.xDh = d;
            if (b.x(b.this)) {
              ac.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
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
                ac.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m), Double.valueOf(d) });
              }
            }
            else if (b.x(b.this))
            {
              ac.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
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
            ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(m) });
            this.stop = true;
            if (this.xDv != null) {
              this.xDv.stop = true;
            }
            b.h(b.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116080);
                b.this.af(null);
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
                l = b.this.xCI - (System.currentTimeMillis() - b.t(b.this));
                if (b.t(b.this) == 0L) {
                  com.tencent.mm.modelvideo.o.h(this, b.this.xCI * 5);
                }
              }
              for (;;)
              {
                if (b.u(b.this) != null) {
                  ac.d("MicroMsg.SightPlayController", "voice time is" + b.u(b.this).dEJ() / 1000.0D);
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
                    i = b.s(b.this).dEG();
                    b.h(b.this).post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(116082);
                        if (b.s(b.this) != null)
                        {
                          View localView = b.s(b.this).dEH();
                          if (localView != null)
                          {
                            if ((b.F(b.this) == null) && (b.s(b.this).dEI() != -1) && (b.m(b.this).get() != null)) {
                              b.a(b.this, AnimationUtils.loadAnimation(((View)b.m(b.this).get()).getContext(), b.s(b.this).dEI()));
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
                    this.xDv.xDx = j;
                    b.h(b.this).postDelayed(this.xDv, i);
                  }
                  else
                  {
                    this.xDv.xDx = j;
                    b.h(b.this).post(this.xDv);
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
    int xDx;
    b.b xDy;
    
    public c()
    {
      AppMethodBeat.i(116084);
      this.stop = false;
      ac.i("MicroMsg.SightPlayController", "make sure drawJob alive");
      AppMethodBeat.o(116084);
    }
    
    public final void run()
    {
      AppMethodBeat.i(116085);
      if (this.stop)
      {
        ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()) });
        AppMethodBeat.o(116085);
        return;
      }
      b.this.af(b.E(b.this));
      if (b.t(b.this) == 0L)
      {
        com.tencent.mm.modelvideo.o.h(this.xDy, 0L);
        AppMethodBeat.o(116085);
        return;
      }
      long l = b.this.xCI - (System.currentTimeMillis() - b.t(b.this));
      if (l > 0L)
      {
        com.tencent.mm.modelvideo.o.h(this.xDy, l);
        AppMethodBeat.o(116085);
        return;
      }
      com.tencent.mm.modelvideo.o.h(this.xDy, 0L);
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
      AppMethodBeat.i(116087);
      if (b.c(b.this))
      {
        ac.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
        AppMethodBeat.o(116087);
        return;
      }
      b localb = b.this;
      String str = b.a(b.this);
      if (1 == b.d(b.this)) {}
      for (int i = 0;; i = 1)
      {
        b.a(localb, SightVideoJNI.openFileVFS(str, i, 1, false));
        ac.i("MicroMsg.SightPlayController", "SightVideoJNI.openFile mVideoPath:%s mVideoId:%s", new Object[] { b.a(b.this), Integer.valueOf(b.e(b.this)) });
        b.f(b.this).offer(Integer.valueOf(b.e(b.this)));
        if (b.e(b.this) >= 0) {
          break;
        }
        ac.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(b.this.hashCode()), Integer.valueOf(b.e(b.this)), b.a(b.this) });
        b.this.ae(null);
        if (b.b(b.this) != null) {
          b.b(b.this).c(b.this, -1);
        }
        AppMethodBeat.o(116087);
        return;
      }
      if (((Boolean)g.agR().agA().get(344065, Boolean.FALSE)).booleanValue())
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
            ac.e("MicroMsg.SightPlayController", "get error info for ad,  videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            AppMethodBeat.o(116087);
          }
        }
        else if ((i * j >= 1048576) || (i <= 0) || (j <= 0))
        {
          ac.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(116087);
          return;
        }
        b.a(b.this, i, j);
      }
      b.this.dEB();
      if ((Float.compare(i / j, 5.0F) > 0) || (Float.compare(j / i, 5.0F) > 0))
      {
        ac.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if (!bs.isNullOrNil(b.a(b.this))) {
          b.dEE().put(b.a(b.this), Integer.valueOf(2));
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
      b.this.dZ(i, j);
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
          ac.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[] { Integer.valueOf(b.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.stop) });
        }
        AppMethodBeat.o(116087);
        return;
        b.a(b.this, new b.b(b.this, (byte)0));
        b.a(b.this, new b.c(b.this));
        b.j(b.this).xDv = b.k(b.this);
        b.k(b.this).xDy = b.j(b.this);
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
    double xDk = -1.0D;
    MediaPlayer xDz;
    
    private i() {}
    
    private void diM()
    {
      AppMethodBeat.i(116089);
      ac.i("MicroMsg.SightPlayController", "stopPlayer");
      try
      {
        if (this.xDz != null)
        {
          this.xDz.stop();
          this.xDz.release();
          this.xDz = null;
        }
        AppMethodBeat.o(116089);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.SightPlayController", localException, "stop play sound error: %s", new Object[] { localException.getMessage() });
        this.xDz = null;
        AppMethodBeat.o(116089);
      }
    }
    
    public final double dEJ()
    {
      AppMethodBeat.i(116090);
      if (this.xDz == null)
      {
        AppMethodBeat.o(116090);
        return 0.0D;
      }
      double d = this.xDz.getCurrentPosition();
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
        ac.i("MicroMsg.SightPlayController", "do play sound, operation %s", new Object[] { str });
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
        diM();
        if (!bs.isNullOrNil(b.a(b.this)))
        {
          try
          {
            this.xDz = new k();
            this.xDz.setDisplay(null);
            this.xDz.reset();
            this.xDz.setDataSource(i.k(b.a(b.this), false));
            this.xDz.setAudioStreamType(3);
            this.xDz.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
              {
                AppMethodBeat.i(116088);
                ac.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(b.this), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
                b.this.clear();
                if (b.b(b.this) != null) {
                  b.b(b.this).c(b.this, -1);
                }
                AppMethodBeat.o(116088);
                return true;
              }
            });
            this.xDz.prepare();
            this.xDz.start();
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException1)
          {
            ac.printErrStackTrace("MicroMsg.SightPlayController", localException1, "play sound error: %s", new Object[] { localException1.getMessage() });
            ac.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[] { b.a(b.this) });
            b.this.clear();
            if (b.b(b.this) != null) {
              b.b(b.this).c(b.this, -1);
            }
            AppMethodBeat.o(116091);
            return;
          }
          diM();
          AppMethodBeat.o(116091);
          return;
          try
          {
            if ((this.xDz != null) && (this.xDz.isPlaying())) {
              this.xDz.pause();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException2)
          {
            ac.printErrStackTrace("MicroMsg.SightPlayController", localException2, "pause sound error: %s", new Object[] { localException2.getMessage() });
            diM();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            if (this.xDz != null) {
              this.xDz.start();
            }
            AppMethodBeat.o(116091);
            return;
          }
          catch (Exception localException3)
          {
            ac.printErrStackTrace("MicroMsg.SightPlayController", localException3, "pause sound error: %s", new Object[] { localException3.getMessage() });
            diM();
            AppMethodBeat.o(116091);
            return;
          }
          try
          {
            ac.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[] { Double.valueOf(this.xDk) });
            this.xDz.seekTo((int)(this.xDk * 1000.0D));
            AppMethodBeat.o(116091);
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
    WeakReference<Bitmap> xDB;
    
    private k()
    {
      AppMethodBeat.i(116096);
      this.xDB = new WeakReference(null);
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
          if (this.xDB.get() != null) {
            break label282;
          }
          bool3 = true;
          if (b.q(b.this) != null) {
            break label288;
          }
          bool4 = true;
          ac.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (b.q(b.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.xDB.get();
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
          ac.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
        ac.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
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
        if ((b.r(b.this) == null) || (this.xDB.get() == null) || (((Bitmap)this.xDB.get()).isRecycled()))
        {
          if (b.r(b.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.xDB.get() != null) {
            break label883;
          }
          bool2 = bool6;
          ac.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(116097);
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
        SightVideoJNI.handleThumb((Bitmap)this.xDB.get(), b.r(b.this), b.q(b.this));
        ac.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
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
      if (this.xDB.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ac.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (b.p(b.this) != null)
        {
          localView2 = (View)b.p(b.this).get();
          if (localView2 != null) {
            localView2.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(116095);
                ac.v("MicroMsg.SightPlayController", "set background drawable null");
                localView2.setBackgroundDrawable(null);
                AppMethodBeat.o(116095);
              }
            });
          }
        }
        if (this.xDB.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(b.o(b.this), 0);
          AppMethodBeat.o(116097);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(b.o(b.this), (Bitmap)this.xDB.get(), b.q(b.this));
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