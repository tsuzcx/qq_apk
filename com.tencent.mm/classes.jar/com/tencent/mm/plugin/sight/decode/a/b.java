package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
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
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> qTb = new HashMap();
  private static Map<String, Integer> qTf = new ConcurrentHashMap();
  public String bHM = "";
  private boolean fOd = false;
  public boolean fVw = true;
  private ak loX;
  private Surface mSurface;
  public int position;
  private int qSC = 0;
  private int qSD = 0;
  private String qSE = "";
  private int qSF = -1;
  private Queue<Integer> qSG = new ConcurrentLinkedQueue();
  protected int qSH = 41;
  private Bitmap qSI;
  public Bitmap qSJ;
  private Bitmap qSK;
  private WeakReference<View> qSL;
  private WeakReference<TextView> qSM;
  private long qSN;
  public WeakReference<View> qSO;
  private Animation qSP;
  private Animation qSQ;
  private volatile b.h qSR;
  private volatile b.b qSS;
  public volatile b.i qST;
  private volatile b.c qSU;
  private k qSV;
  private j qSW;
  private b.d qSX;
  public boolean qSY = true;
  public boolean qSZ = true;
  public boolean qTa = false;
  public boolean qTc = false;
  public double qTd = -1.0D;
  boolean qTe = false;
  public double qTg = -1.0D;
  private boolean qTh = false;
  public boolean qTi = false;
  private b.a qTj;
  public volatile e qTk;
  public volatile b.f qTl;
  public volatile b.g qTm;
  
  public b(int paramInt, View paramView)
  {
    this.qSD = paramInt;
    this.loX = new ak(Looper.getMainLooper());
    this.qSO = new WeakReference(paramView);
    ab.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void Dt(int paramInt)
  {
    com.tencent.mm.modelvideo.o.j(new b.2(this, paramInt), 0L);
  }
  
  public static void XJ()
  {
    com.tencent.mm.modelvideo.o.j(new b.1(), 0L);
  }
  
  public static boolean Zp(String paramString)
  {
    if (bo.isNullOrNil(paramString)) {
      return false;
    }
    paramString = (Integer)qTf.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  public static Bitmap b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = String.format("%s-%s-%s-%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = (WeakReference)qTb.get(str);
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      return (Bitmap)((WeakReference)localObject).get();
    }
    if (paramContext == null)
    {
      ab.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
      return null;
    }
    if (paramInt1 <= 0)
    {
      ab.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
      return null;
    }
    if ((paramInt2 <= 0) || (paramInt4 <= 0) || (paramInt3 <= 0))
    {
      ab.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
      return null;
    }
    long l = bo.yB();
    paramInt3 = paramInt2 * paramInt4 / paramInt3;
    paramContext = (NinePatchDrawable)paramContext.getResources().getDrawable(paramInt1);
    paramContext.setBounds(0, 0, paramInt2, paramInt3);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    paramContext.draw(new Canvas((Bitmap)localObject));
    qTb.put(str, new WeakReference(localObject));
    ab.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[] { Long.valueOf(bo.av(l)) });
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
      Dt(localInteger.intValue());
    }
  }
  
  public final void R(Bitmap paramBitmap)
  {
    boolean bool = true;
    if (paramBitmap == null) {}
    for (;;)
    {
      ab.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.modelvideo.o.x(this.qSV);
      if (this.qSV == null) {
        this.qSV = new k((byte)0);
      }
      this.qSV.qTy = new WeakReference(paramBitmap);
      com.tencent.mm.modelvideo.o.j(this.qSV, 0L);
      return;
      bool = false;
    }
  }
  
  public abstract void S(Bitmap paramBitmap);
  
  public final void bl(String paramString, boolean paramBoolean)
  {
    ab.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(hashCode()), paramString, this.bHM, Boolean.valueOf(paramBoolean), Integer.valueOf(this.qSF), Boolean.valueOf(this.qTi), Boolean.valueOf(this.qSZ) });
    if (this.qTi)
    {
      kR(false);
      return;
    }
    if (cmB())
    {
      ab.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      clear();
      return;
    }
    if (!this.qSZ)
    {
      clear();
      return;
    }
    if (paramBoolean)
    {
      this.qSE = paramString;
      kR(false);
      return;
    }
    if (this.bHM.equals(paramString))
    {
      this.qSE = "ERROR#PATH";
      kR(false);
      restart();
      return;
    }
    clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.bHM = str;
    if (bo.isNullOrNil(this.bHM))
    {
      ab.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      R(null);
      return;
    }
    if (!Zp(this.bHM))
    {
      ab.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.qSR = new b.h(this, (byte)0);
    com.tencent.mm.modelvideo.o.j(this.qSR, 0L);
  }
  
  public final void clear()
  {
    ab.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.qSF), Boolean.valueOf(cmA()) });
    kR(true);
    this.qSN = 0L;
    d(this.qSG);
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
      if ((this.qSS == null) || (this.qSS.oIr)) {}
    }
    while ((this.qSU != null) && (!this.qSU.oIr) && (this.qSS != null) && (!this.qSS.oIr))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean cmB()
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
    if (this.qTj == null) {
      this.qTj = new b.a(this);
    }
    return this.qTj;
  }
  
  public final double cmE()
  {
    if (this.qSF == -1) {
      return 0.0D;
    }
    return SightVideoJNI.getVideoDuration(this.qSF);
  }
  
  protected int cmz()
  {
    return -1;
  }
  
  public abstract void dQ(int paramInt1, int paramInt2);
  
  public final void g(Surface paramSurface)
  {
    ab.v("MicroMsg.SightPlayController", "set play surface %s", new Object[] { paramSurface });
    this.mSurface = paramSurface;
    com.tencent.mm.modelvideo.o.j(this.qSV, 0L);
  }
  
  public final void kR(boolean paramBoolean)
  {
    if (this.qSR != null)
    {
      com.tencent.mm.modelvideo.o.x(this.qSR);
      this.qSR.oIr = true;
    }
    if (this.qSU != null)
    {
      this.loX.removeCallbacks(this.qSU);
      this.qSU.oIr = true;
    }
    if (this.qSS != null)
    {
      com.tencent.mm.modelvideo.o.x(this.qSS);
      this.qSS.oIr = true;
    }
    b.i locali;
    if (this.qST != null)
    {
      locali = this.qST;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.j(this.qST, 0L);
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
    this.qSR = new b.h(this, (byte)0);
    com.tencent.mm.modelvideo.o.j(this.qSR, 0L);
    return;
    if (1 == this.qSD)
    {
      this.qSS = new b.b(this, (byte)0);
      this.qSU = null;
      com.tencent.mm.modelvideo.o.j(this.qSS, 0L);
      return;
    }
    this.qSS = new b.b(this, (byte)0);
    this.qSU = new b.c(this);
    this.qSS.qTs = this.qSU;
    this.qSU.qTv = this.qSS;
    com.tencent.mm.modelvideo.o.j(this.qSS, 0L);
  }
  
  public final void setSightInfoView(TextView paramTextView)
  {
    this.qSM = new WeakReference(paramTextView);
  }
  
  public final void setThumbBgView(View paramView)
  {
    this.qSL = new WeakReference(paramView);
  }
  
  public static abstract interface e
  {
    public abstract void c(b paramb, int paramInt);
  }
  
  final class j
    implements Runnable
  {
    private j() {}
    
    public final void run()
    {
      AppMethodBeat.i(70246);
      if ((b.e(b.this) < 0) || (b.k(b.this) == null) || (b.k(b.this).get() == null))
      {
        AppMethodBeat.o(70246);
        return;
      }
      String str = SightVideoJNI.getVideoInfo(b.e(b.this));
      ((TextView)b.k(b.this).get()).setText(str);
      AppMethodBeat.o(70246);
    }
  }
  
  final class k
    implements Runnable
  {
    WeakReference<Bitmap> qTy;
    
    private k()
    {
      AppMethodBeat.i(70250);
      this.qTy = new WeakReference(null);
      AppMethodBeat.o(70250);
    }
    
    public final void run()
    {
      View localView1 = null;
      boolean bool6 = true;
      boolean bool5 = true;
      AppMethodBeat.i(70251);
      boolean bool2;
      label75:
      label88:
      label101:
      final Bitmap localBitmap;
      try
      {
        if ((b.n(b.this) != null) && (b.n(b.this).isValid())) {
          break label713;
        }
        i = b.this.hashCode();
        j = hashCode();
        boolean bool3;
        boolean bool4;
        if (b.n(b.this) == null)
        {
          bool1 = true;
          if (b.o(b.this) != null) {
            break label276;
          }
          bool2 = true;
          if (this.qTy.get() != null) {
            break label282;
          }
          bool3 = true;
          if (b.p(b.this) != null) {
            break label288;
          }
          bool4 = true;
          ab.w("MicroMsg.SightPlayController", "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if (b.p(b.this) != null) {
            break label350;
          }
          localBitmap = (Bitmap)this.qTy.get();
          if (b.o(b.this) != null) {
            localView1 = (View)b.o(b.this).get();
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
          ab.e("MicroMsg.SightPlayController", "bgView:%B, thumb:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(70251);
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
        localView1.post(new b.k.1(this, localView1, localBitmap));
        AppMethodBeat.o(70251);
        return;
      }
      catch (Exception localException1)
      {
        ab.printErrStackTrace("MicroMsg.SightPlayController", localException1, "", new Object[0]);
        AppMethodBeat.o(70251);
        return;
      }
      label350:
      if ((b.q(b.this) != null) && (b.q(b.this).getWidth() == b.p(b.this).getWidth()))
      {
        i = b.q(b.this).getHeight();
        j = b.p(b.this).getHeight();
        if (i == j) {
          break label444;
        }
      }
      label444:
      label506:
      final View localView2;
      try
      {
        b.a(b.this, Bitmap.createBitmap(b.p(b.this).getWidth(), b.p(b.this).getHeight(), Bitmap.Config.ARGB_8888));
        if ((b.q(b.this) == null) || (this.qTy.get() == null) || (((Bitmap)this.qTy.get()).isRecycled()))
        {
          if (b.q(b.this) != null) {
            break label878;
          }
          bool1 = true;
          if (this.qTy.get() != null) {
            break label883;
          }
          bool2 = bool6;
          ab.e("MicroMsg.SightPlayController", "mThubmBgBmp:%B, thumbRef:%B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(70251);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.SightPlayController", localException2, "try to create thumb bmp error:%s", new Object[] { localException2.getMessage() });
          b.a(b.this, null);
        }
        long l = System.nanoTime();
        SightVideoJNI.handleThumb((Bitmap)this.qTy.get(), b.q(b.this), b.p(b.this));
        ab.i("MicroMsg.SightPlayController", "handle thumb use %d us", new Object[] { Long.valueOf((System.nanoTime() - l) / 1000L) });
        localBitmap = b.q(b.this);
        if (b.o(b.this) != null) {}
        for (localView2 = (View)b.o(b.this).get(); (localView2 == null) || (localBitmap == null); localView2 = null)
        {
          AppMethodBeat.o(70251);
          return;
        }
        localView2.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(70248);
            localView2.setBackgroundDrawable(new BitmapDrawable(localBitmap));
            AppMethodBeat.o(70248);
          }
        });
        AppMethodBeat.o(70251);
        return;
      }
      label713:
      int i = b.this.hashCode();
      int j = hashCode();
      if (this.qTy.get() == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ab.d("MicroMsg.SightPlayController", "#0x%x-#0x%x draw thumb, thumb empty ? %B", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
        if (b.o(b.this) != null)
        {
          localView2 = (View)b.o(b.this).get();
          if (localView2 != null) {
            localView2.post(new b.k.3(this, localView2));
          }
        }
        if (this.qTy.get() == null)
        {
          SightVideoJNI.drawSurfaceColor(b.n(b.this), 0);
          AppMethodBeat.o(70251);
          return;
        }
        SightVideoJNI.drawSurfaceThumb(b.n(b.this), (Bitmap)this.qTy.get(), b.p(b.this));
        AppMethodBeat.o(70251);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b
 * JD-Core Version:    0.7.0.1
 */