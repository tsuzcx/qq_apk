package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

public class WebViewBag
  extends FrameLayout
{
  private static final int vil;
  private Runnable Sn;
  private ImageView iCl;
  public View ldP;
  private WindowManager lnU;
  protected ak loX;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  private PointF tJa;
  private Point tJb;
  private Point tJc;
  private Point tJd;
  private Point tJe;
  private a vii;
  private WebViewBagBgView vij;
  private boolean vik;
  
  static
  {
    AppMethodBeat.i(8196);
    vil = com.tencent.mm.cb.a.gx(ah.getContext()) - b.vho - b.vhq - b.vhr;
    AppMethodBeat.o(8196);
  }
  
  public WebViewBag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8186);
    this.tJa = new PointF();
    this.tJb = new Point();
    this.tJc = new Point();
    this.tJd = new Point();
    this.Sn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8184);
        float f = (float)(System.currentTimeMillis() - WebViewBag.a(WebViewBag.this)) * 1.0F / 200.0F;
        if (f <= 1.0F)
        {
          WebViewBag.this.loX.postDelayed(WebViewBag.b(WebViewBag.this), 5L);
          WebViewBag localWebViewBag = WebViewBag.this;
          int i = WebViewBag.c(WebViewBag.this).x;
          int j = (int)((WebViewBag.d(WebViewBag.this).x * 1.0F - WebViewBag.c(WebViewBag.this).x) * f);
          int k = WebViewBag.c(WebViewBag.this).y;
          WebViewBag.a(localWebViewBag, i + j, (int)(f * (WebViewBag.d(WebViewBag.this).y * 1.0F - WebViewBag.c(WebViewBag.this).y)) + k);
          AppMethodBeat.o(8184);
          return;
        }
        WebViewBag.a(WebViewBag.this, WebViewBag.d(WebViewBag.this).x, WebViewBag.d(WebViewBag.this).y);
        WebViewBag.e(WebViewBag.this);
        AppMethodBeat.o(8184);
      }
    };
    this.lnU = ((WindowManager)paramContext.getSystemService("window"));
    this.loX = new ak();
    this.tJe = new Point(com.tencent.mm.cb.a.gw(ah.getContext()), com.tencent.mm.cb.a.gx(ah.getContext()));
    LayoutInflater.from(paramContext).inflate(2130971298, this);
    this.iCl = ((ImageView)findViewById(2131820929));
    this.vij = ((WebViewBagBgView)findViewById(2131829530));
    this.ldP = findViewById(2131821003);
    this.vij.setStartColor(paramContext.getResources().getColor(2131690694));
    this.vij.setAngryColor(paramContext.getResources().getColor(2131690693));
    AppMethodBeat.o(8186);
  }
  
  private void gt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(8193);
    if (this.lnU != null)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      try
      {
        this.lnU.updateViewLayout(this, localLayoutParams);
        AppMethodBeat.o(8193);
        return;
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.WebViewBag", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(8193);
  }
  
  public final void dfh()
  {
    AppMethodBeat.i(8187);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setDuration(100L);
    localAnimationSet.restrictDuration(150L);
    localAnimationSet.setFillAfter(true);
    this.ldP.startAnimation(localAnimationSet);
    AppMethodBeat.o(8187);
  }
  
  protected Point getLastTouchDownViewPos()
  {
    return this.tJb;
  }
  
  public final void l(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(8190);
    WebViewBagBgView localWebViewBagBgView = this.vij;
    localWebViewBagBgView.viu = false;
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    localWebViewBagBgView.mDuration = paramInt1;
    localWebViewBagBgView.tal = paramInt2;
    localWebViewBagBgView.mStartTime = paramLong;
    localWebViewBagBgView.nq(l);
    if (paramLong > l) {
      localWebViewBagBgView.postDelayed(new WebViewBagBgView.1(localWebViewBagBgView), paramLong - l);
    }
    for (;;)
    {
      localWebViewBagBgView.invalidate();
      AppMethodBeat.o(8190);
      return;
      localWebViewBagBgView.viu = true;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(8185);
    ab.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.tJe.x = com.tencent.mm.cb.a.gw(ah.getContext());
    this.tJe.y = com.tencent.mm.cb.a.gx(ah.getContext());
    AppMethodBeat.o(8185);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(8192);
    if (!this.vik)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(8192);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (this.vii != null) {
        this.vii.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(8192);
      return true;
      this.tJa.x = paramMotionEvent.getRawX();
      this.tJa.y = paramMotionEvent.getRawY();
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      this.tJb.x = localLayoutParams.x;
      this.tJb.y = localLayoutParams.y;
      continue;
      gt((int)Math.max(Math.min(this.tJb.x + paramMotionEvent.getRawX() - this.tJa.x, this.tJe.x), 0.0F), (int)Math.max(Math.min(this.tJb.y + paramMotionEvent.getRawY() - this.tJa.y, this.tJe.y), 0.0F));
      continue;
      if ((Math.abs(paramMotionEvent.getRawX() - this.tJa.x) >= BackwardSupportUtil.b.b(getContext(), 3.0F)) || (Math.abs(paramMotionEvent.getRawY() - this.tJa.y) >= BackwardSupportUtil.b.b(getContext(), 3.0F))) {
        break;
      }
      if (this.mOnClickListener != null) {
        this.mOnClickListener.onClick(this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.tJc.x = ((int)Math.max(Math.min(f1 + this.tJb.x - this.tJa.x, this.tJe.x), 0.0F));
    this.tJc.y = ((int)Math.max(Math.min(f2 + this.tJb.y - this.tJa.y, this.tJe.y), 0.0F));
    if (this.tJc.x + getWidth() / 2 <= this.tJe.x / 2)
    {
      this.tJd.x = b.vhr;
      label432:
      this.tJd.y = this.tJc.y;
      if (this.tJd.y != 0) {
        break label547;
      }
      this.tJd.y = b.vhr;
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      this.loX.postDelayed(this.Sn, 5L);
      if (this.vii == null) {
        break;
      }
      this.vii.gP(this.tJd.x, this.tJd.y);
      break;
      this.tJd.x = (this.tJe.x - getWidth() - b.vhr);
      break label432;
      label547:
      if (this.tJd.y > vil) {
        this.tJd.y = vil;
      }
    }
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(8189);
    Object localObject = new c.a();
    ((c.a)localObject).eOk = true;
    ((c.a)localObject).eNM = true;
    ((c.a)localObject).eNP = com.tencent.mm.plugin.i.c.YK();
    ((c.a)localObject).eNY = 2131232226;
    localObject = ((c.a)localObject).ahY();
    o.ahG().a(paramString, this.iCl, (com.tencent.mm.at.a.a.c)localObject);
    AppMethodBeat.o(8189);
  }
  
  public void setListener(a parama)
  {
    this.vii = parama;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(8191);
    ab.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vik = paramBoolean;
    AppMethodBeat.o(8191);
  }
  
  public static abstract interface a
  {
    public abstract void gP(int paramInt1, int paramInt2);
    
    public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag
 * JD-Core Version:    0.7.0.1
 */