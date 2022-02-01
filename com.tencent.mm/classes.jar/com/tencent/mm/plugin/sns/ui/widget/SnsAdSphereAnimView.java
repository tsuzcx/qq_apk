package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.widget.a.a.b;
import com.tencent.mm.plugin.sns.ad.widget.a.b.a;
import com.tencent.mm.plugin.sns.ad.widget.a.f;
import com.tencent.mm.plugin.sns.ad.widget.gllib.GLViewContainer;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdSphereAnimView
  extends FrameLayout
{
  public static int RWn = 1;
  public static int RWo = 2;
  public static int RWp = 3;
  public static int RWq = 4;
  public static int RWr = 0;
  public static int RWs = 1;
  public static int RWt = 2;
  public static int RWu = 80;
  public static int RWv = 40;
  private int JAb;
  private Handler PRJ;
  private Handler Qjm;
  private HandlerThread Qjn;
  private boolean RWA;
  public int RWB;
  public int RWC;
  public boolean RWD;
  public Bitmap RWE;
  private FrameLayout RWw;
  private GLViewContainer RWx;
  private com.tencent.mm.plugin.sns.ad.widget.a.a RWy;
  private com.tencent.mm.plugin.sns.ad.widget.a.a.a RWz;
  public int hbT;
  private Context mContext;
  private int mMaxSize;
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179378);
    this.Qjm = null;
    this.Qjn = null;
    this.RWA = false;
    init(paramContext);
    AppMethodBeat.o(179378);
  }
  
  public SnsAdSphereAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179379);
    this.Qjm = null;
    this.Qjn = null;
    this.RWA = false;
    init(paramContext);
    AppMethodBeat.o(179379);
  }
  
  private static int a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 12;
    AppMethodBeat.i(309191);
    float f1 = com.tencent.mm.cd.a.K(paramContext, paramInt1);
    float f2 = com.tencent.mm.cd.a.K(paramContext, paramInt2);
    float f3 = f1 * f2 / 304500.0F;
    if (paramInt3 == RWr) {
      paramInt1 = i;
    }
    for (;;)
    {
      paramInt2 = Math.round(paramInt1 * f3);
      Log.i("SnsAdSphereAnimView", "getSpriteNum, raw=" + paramInt1 + ", ret=" + paramInt2 + ", dpW=" + f1 + ", dpH=" + f2 + ", rate=" + f3);
      AppMethodBeat.o(309191);
      return paramInt2;
      if (paramInt3 == RWs)
      {
        paramInt1 = 10;
      }
      else
      {
        paramInt1 = i;
        if (paramInt3 == RWt) {
          paramInt1 = 16;
        }
      }
    }
  }
  
  private static boolean hsL()
  {
    AppMethodBeat.i(309187);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIw, 0);
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("SnsAdSphereAnimView", "isUseGLAnimView, exptValue=".concat(String.valueOf(i)));
        AppMethodBeat.o(309187);
        return bool;
      }
      return false;
    }
    finally
    {
      Log.e("SnsAdSphereAnimView", "isUseGLAnimView, exp=" + localObject.toString());
      AppMethodBeat.o(309187);
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(309181);
    this.mContext = paramContext;
    this.PRJ = new Handler(Looper.getMainLooper());
    this.RWA = hsL();
    if (this.RWA)
    {
      this.RWx = new GLViewContainer(paramContext);
      addView(this.RWx, new FrameLayout.LayoutParams(-1, -1));
      if (this.Qjn == null)
      {
        this.Qjn = new HandlerThread("ad_press_anim");
        this.Qjn.start();
        this.Qjm = new Handler(this.Qjn.getLooper());
        Log.i("SnsAdSphereAnimView", "new Thread, hash=" + this.Qjn.hashCode());
      }
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 16);
      AppMethodBeat.o(309181);
      return;
    }
    this.RWw = this;
    AppMethodBeat.o(309181);
  }
  
  public final void lT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(309215);
    this.RWD = false;
    if (this.RWy != null) {
      this.RWy.clear();
    }
    if (this.RWz != null) {
      this.RWz.clear();
    }
    final b.a locala = new b.a();
    locala.Qhk = this.RWE;
    locala.duration = this.hbT;
    locala.Qhl = paramInt1;
    locala.Qhm = paramInt2;
    locala.Qhn = a(this.mContext, paramInt1, paramInt2, this.RWC);
    paramInt1 = com.tencent.mm.cd.a.fromDPToPix(this.mContext, RWv);
    paramInt2 = com.tencent.mm.cd.a.fromDPToPix(this.mContext, RWu);
    if (this.RWC != RWr) {
      if (this.RWC == RWs)
      {
        this.JAb = paramInt2;
        this.mMaxSize = paramInt2;
      }
    }
    for (;;)
    {
      locala.maxSize = this.mMaxSize;
      locala.oQY = this.JAb;
      Log.i("SnsAdSphereAnimView", "doStartAnim, params=".concat(String.valueOf(locala)));
      if (!this.RWA) {
        break;
      }
      if (this.Qjm == null) {
        break label267;
      }
      this.Qjm.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179376);
          if (SnsAdSphereAnimView.a(SnsAdSphereAnimView.this) == SnsAdSphereAnimView.RWn)
          {
            SnsAdSphereAnimView.a(SnsAdSphereAnimView.this, new b(SnsAdSphereAnimView.b(SnsAdSphereAnimView.this), SnsAdSphereAnimView.c(SnsAdSphereAnimView.this), locala));
            AppMethodBeat.o(179376);
            return;
          }
          if (SnsAdSphereAnimView.a(SnsAdSphereAnimView.this) == SnsAdSphereAnimView.RWo)
          {
            SnsAdSphereAnimView.a(SnsAdSphereAnimView.this, new com.tencent.mm.plugin.sns.ad.widget.a.a.c(SnsAdSphereAnimView.b(SnsAdSphereAnimView.this), SnsAdSphereAnimView.c(SnsAdSphereAnimView.this), locala));
            AppMethodBeat.o(179376);
            return;
          }
          if (SnsAdSphereAnimView.a(SnsAdSphereAnimView.this) == SnsAdSphereAnimView.RWp)
          {
            SnsAdSphereAnimView.a(SnsAdSphereAnimView.this, new com.tencent.mm.plugin.sns.ad.widget.a.a.e(SnsAdSphereAnimView.b(SnsAdSphereAnimView.this), SnsAdSphereAnimView.c(SnsAdSphereAnimView.this), locala));
            AppMethodBeat.o(179376);
            return;
          }
          if (SnsAdSphereAnimView.a(SnsAdSphereAnimView.this) == SnsAdSphereAnimView.RWq) {
            SnsAdSphereAnimView.a(SnsAdSphereAnimView.this, new com.tencent.mm.plugin.sns.ad.widget.a.a.d(SnsAdSphereAnimView.b(SnsAdSphereAnimView.this), SnsAdSphereAnimView.c(SnsAdSphereAnimView.this), locala));
          }
          AppMethodBeat.o(179376);
        }
      });
      AppMethodBeat.o(309215);
      return;
      if (this.RWC == RWt)
      {
        this.JAb = paramInt1;
        this.mMaxSize = paramInt1;
      }
      else
      {
        this.JAb = paramInt1;
        this.mMaxSize = paramInt2;
      }
    }
    this.PRJ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179377);
        if (SnsAdSphereAnimView.a(SnsAdSphereAnimView.this) == SnsAdSphereAnimView.RWn)
        {
          SnsAdSphereAnimView.a(SnsAdSphereAnimView.this, new com.tencent.mm.plugin.sns.ad.widget.a.c(SnsAdSphereAnimView.b(SnsAdSphereAnimView.this), SnsAdSphereAnimView.d(SnsAdSphereAnimView.this), locala));
          AppMethodBeat.o(179377);
          return;
        }
        if (SnsAdSphereAnimView.a(SnsAdSphereAnimView.this) == SnsAdSphereAnimView.RWo)
        {
          SnsAdSphereAnimView.a(SnsAdSphereAnimView.this, new com.tencent.mm.plugin.sns.ad.widget.a.d(SnsAdSphereAnimView.b(SnsAdSphereAnimView.this), SnsAdSphereAnimView.d(SnsAdSphereAnimView.this), locala));
          AppMethodBeat.o(179377);
          return;
        }
        if (SnsAdSphereAnimView.a(SnsAdSphereAnimView.this) == SnsAdSphereAnimView.RWp)
        {
          SnsAdSphereAnimView.a(SnsAdSphereAnimView.this, new f(SnsAdSphereAnimView.b(SnsAdSphereAnimView.this), SnsAdSphereAnimView.d(SnsAdSphereAnimView.this), locala));
          AppMethodBeat.o(179377);
          return;
        }
        if (SnsAdSphereAnimView.a(SnsAdSphereAnimView.this) == SnsAdSphereAnimView.RWq) {
          SnsAdSphereAnimView.a(SnsAdSphereAnimView.this, new com.tencent.mm.plugin.sns.ad.widget.a.e(SnsAdSphereAnimView.b(SnsAdSphereAnimView.this), SnsAdSphereAnimView.d(SnsAdSphereAnimView.this), locala));
        }
        AppMethodBeat.o(179377);
      }
    }, 100L);
    label267:
    AppMethodBeat.o(309215);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179381);
    super.onDetachedFromWindow();
    Log.i("SnsAdSphereAnimView", "clear");
    this.RWD = false;
    if (this.RWy != null)
    {
      this.RWy.clear();
      this.RWy = null;
    }
    if (this.RWz != null)
    {
      this.RWz.clear();
      this.RWz = null;
    }
    if (this.Qjn != null)
    {
      this.Qjn.quitSafely();
      Log.i("SnsAdSphereAnimView", "exit Thread, hash=" + this.Qjn.hashCode());
    }
    if (this.Qjm != null) {
      this.Qjm.removeCallbacksAndMessages(null);
    }
    this.PRJ.removeCallbacksAndMessages(null);
    AppMethodBeat.o(179381);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(309227);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("SnsAdSphereAnimView", "onLayout, changed=" + paramBoolean + ", w=" + getWidth() + ", h=" + getHeight());
    AppMethodBeat.o(309227);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(309223);
    super.onMeasure(paramInt1, paramInt2);
    Log.d("SnsAdSphereAnimView", "onMeasure, w=" + getMeasuredWidth() + ", h=" + getMeasuredHeight());
    AppMethodBeat.o(309223);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(309219);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("SnsAdSphereAnimView", "onSizeChanged, w=" + paramInt1 + ", h=" + paramInt2 + ", isAppendAnim=" + this.RWD);
    if ((paramInt1 != 0) && (paramInt2 != 0) && (this.RWD)) {
      lT(paramInt1, paramInt2);
    }
    AppMethodBeat.o(309219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView
 * JD-Core Version:    0.7.0.1
 */