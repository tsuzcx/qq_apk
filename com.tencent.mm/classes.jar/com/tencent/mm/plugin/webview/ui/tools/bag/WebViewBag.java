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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class WebViewBag
  extends FrameLayout
{
  private static final int rsg = com.tencent.mm.cb.a.fk(ae.getContext()) - b.rrj - b.rrl - b.rrm;
  private ImageView hok;
  View iUL;
  private WindowManager jfe;
  protected ah jge;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  private PointF qck = new PointF();
  private Point qcl = new Point();
  private Point qcm = new Point();
  private Point qcn = new Point();
  private Point qco;
  private Runnable qcp = new WebViewBag.1(this);
  private a rsd;
  private WebViewBagBgView rse;
  private boolean rsf;
  
  public WebViewBag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jfe = ((WindowManager)paramContext.getSystemService("window"));
    this.jge = new ah();
    this.qco = new Point(com.tencent.mm.cb.a.fj(ae.getContext()), com.tencent.mm.cb.a.fk(ae.getContext()));
    LayoutInflater.from(paramContext).inflate(R.i.webview_bag, this);
    this.hok = ((ImageView)findViewById(R.h.icon));
    this.rse = ((WebViewBagBgView)findViewById(R.h.bg));
    this.iUL = findViewById(R.h.root);
    this.rse.setStartColor(paramContext.getResources().getColor(R.e.webview_bag_bg_color));
    this.rse.setAngryColor(paramContext.getResources().getColor(R.e.webview_bag_bg_angry_color));
  }
  
  private void es(int paramInt1, int paramInt2)
  {
    WindowManager.LayoutParams localLayoutParams;
    if (this.jfe != null)
    {
      localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
    }
    try
    {
      this.jfe.updateViewLayout(this, localLayoutParams);
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.WebViewBag", localThrowable, "", new Object[0]);
    }
  }
  
  public final void cfa()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setDuration(100L);
    localAnimationSet.restrictDuration(150L);
    localAnimationSet.setFillAfter(true);
    this.iUL.startAnimation(localAnimationSet);
  }
  
  protected Point getLastTouchDownViewPos()
  {
    return this.qcl;
  }
  
  public final void j(int paramInt1, int paramInt2, long paramLong)
  {
    WebViewBagBgView localWebViewBagBgView = this.rse;
    localWebViewBagBgView.rsp = false;
    long l = System.currentTimeMillis();
    y.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    localWebViewBagBgView.mDuration = paramInt1;
    localWebViewBagBgView.pyx = paramInt2;
    localWebViewBagBgView.mStartTime = paramLong;
    localWebViewBagBgView.gT(l);
    if (paramLong > l) {
      localWebViewBagBgView.postDelayed(new WebViewBagBgView.1(localWebViewBagBgView), paramLong - l);
    }
    for (;;)
    {
      localWebViewBagBgView.invalidate();
      return;
      localWebViewBagBgView.rsp = true;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    y.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.qco.x = com.tencent.mm.cb.a.fj(ae.getContext());
    this.qco.y = com.tencent.mm.cb.a.fk(ae.getContext());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.rsf) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (this.rsd != null) {
        this.rsd.onTouchEvent(paramMotionEvent);
      }
      return true;
      this.qck.x = paramMotionEvent.getRawX();
      this.qck.y = paramMotionEvent.getRawY();
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      this.qcl.x = localLayoutParams.x;
      this.qcl.y = localLayoutParams.y;
      continue;
      es((int)Math.max(Math.min(this.qcl.x + paramMotionEvent.getRawX() - this.qck.x, this.qco.x), 0.0F), (int)Math.max(Math.min(this.qcl.y + paramMotionEvent.getRawY() - this.qck.y, this.qco.y), 0.0F));
      continue;
      if ((Math.abs(paramMotionEvent.getRawX() - this.qck.x) >= BackwardSupportUtil.b.b(getContext(), 3.0F)) || (Math.abs(paramMotionEvent.getRawY() - this.qck.y) >= BackwardSupportUtil.b.b(getContext(), 3.0F))) {
        break;
      }
      if (this.mOnClickListener != null) {
        this.mOnClickListener.onClick(this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.qcm.x = ((int)Math.max(Math.min(f1 + this.qcl.x - this.qck.x, this.qco.x), 0.0F));
    this.qcm.y = ((int)Math.max(Math.min(f2 + this.qcl.y - this.qck.y, this.qco.y), 0.0F));
    if (this.qcm.x + getWidth() / 2 <= this.qco.x / 2)
    {
      this.qcn.x = b.rrm;
      label410:
      this.qcn.y = this.qcm.y;
      if (this.qcn.y != 0) {
        break label525;
      }
      this.qcn.y = b.rrm;
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      this.jge.postDelayed(this.qcp, 5L);
      if (this.rsd == null) {
        break;
      }
      this.rsd.eK(this.qcn.x, this.qcn.y);
      break;
      this.qcn.x = (this.qco.x - getWidth() - b.rrm);
      break label410;
      label525:
      if (this.qcn.y > rsg) {
        this.qcn.y = rsg;
      }
    }
  }
  
  public void setIcon(String paramString)
  {
    Object localObject = new c.a();
    ((c.a)localObject).erD = true;
    ((c.a)localObject).erf = true;
    ((c.a)localObject).eri = com.tencent.mm.plugin.n.c.FG();
    ((c.a)localObject).eru = R.k.webview_bag_default_icon;
    localObject = ((c.a)localObject).OV();
    o.ON().a(paramString, this.hok, (com.tencent.mm.as.a.a.c)localObject);
  }
  
  public void setListener(a parama)
  {
    this.rsd = parama;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    y.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rsf = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void eK(int paramInt1, int paramInt2);
    
    public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag
 * JD-Core Version:    0.7.0.1
 */