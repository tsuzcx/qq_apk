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
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

public class WebViewBag
  extends FrameLayout
{
  private static final int Bjr;
  private a Bjo;
  private WebViewBagBgView Bjp;
  private boolean Bjq;
  private Runnable Zq;
  private View iIW;
  private ImageView jFL;
  private PointF lPG;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  private WindowManager oEl;
  protected ap oFl;
  private Point zAO;
  private Point zAP;
  private Point zAQ;
  private Point zAR;
  
  static
  {
    AppMethodBeat.i(80426);
    Bjr = com.tencent.mm.cd.a.hW(aj.getContext()) - b.mFJ - b.Bjg - b.Bjh;
    AppMethodBeat.o(80426);
  }
  
  public WebViewBag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80418);
    this.lPG = new PointF();
    this.zAO = new Point();
    this.zAP = new Point();
    this.zAQ = new Point();
    this.Zq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80416);
        float f = (float)(System.currentTimeMillis() - WebViewBag.a(WebViewBag.this)) * 1.0F / 200.0F;
        if (f <= 1.0F)
        {
          WebViewBag.this.oFl.postDelayed(WebViewBag.b(WebViewBag.this), 5L);
          WebViewBag localWebViewBag = WebViewBag.this;
          int i = WebViewBag.c(WebViewBag.this).x;
          int j = (int)((WebViewBag.d(WebViewBag.this).x * 1.0F - WebViewBag.c(WebViewBag.this).x) * f);
          int k = WebViewBag.c(WebViewBag.this).y;
          WebViewBag.a(localWebViewBag, i + j, (int)(f * (WebViewBag.d(WebViewBag.this).y * 1.0F - WebViewBag.c(WebViewBag.this).y)) + k);
          AppMethodBeat.o(80416);
          return;
        }
        WebViewBag.a(WebViewBag.this, WebViewBag.d(WebViewBag.this).x, WebViewBag.d(WebViewBag.this).y);
        WebViewBag.e(WebViewBag.this);
        AppMethodBeat.o(80416);
      }
    };
    this.oEl = ((WindowManager)paramContext.getSystemService("window"));
    this.oFl = new ap();
    this.zAR = new Point(com.tencent.mm.cd.a.hV(aj.getContext()), com.tencent.mm.cd.a.hW(aj.getContext()));
    LayoutInflater.from(paramContext).inflate(2131496080, this);
    this.jFL = ((ImageView)findViewById(2131300874));
    this.Bjp = ((WebViewBagBgView)findViewById(2131297203));
    this.iIW = findViewById(2131304239);
    this.Bjp.setStartColor(paramContext.getResources().getColor(2131101163));
    this.Bjp.setAngryColor(paramContext.getResources().getColor(2131101162));
    AppMethodBeat.o(80418);
  }
  
  private void iC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80423);
    if (this.oEl != null)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      try
      {
        this.oEl.updateViewLayout(this, localLayoutParams);
        AppMethodBeat.o(80423);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.WebViewBag", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(80423);
  }
  
  protected Point getLastTouchDownViewPos()
  {
    return this.zAO;
  }
  
  public final void o(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(80420);
    WebViewBagBgView localWebViewBagBgView = this.Bjp;
    localWebViewBagBgView.BjA = false;
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    localWebViewBagBgView.ark = paramInt1;
    localWebViewBagBgView.yGI = paramInt2;
    localWebViewBagBgView.mStartTime = paramLong;
    localWebViewBagBgView.vb(l);
    if (paramLong > l) {
      localWebViewBagBgView.postDelayed(new WebViewBagBgView.1(localWebViewBagBgView), paramLong - l);
    }
    for (;;)
    {
      localWebViewBagBgView.invalidate();
      AppMethodBeat.o(80420);
      return;
      localWebViewBagBgView.BjA = true;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80417);
    ad.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.zAR.x = com.tencent.mm.cd.a.hV(aj.getContext());
    this.zAR.y = com.tencent.mm.cd.a.hW(aj.getContext());
    AppMethodBeat.o(80417);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(80422);
    if (!this.Bjq)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(80422);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (this.Bjo != null) {
        this.Bjo.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(80422);
      return true;
      this.lPG.x = paramMotionEvent.getRawX();
      this.lPG.y = paramMotionEvent.getRawY();
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      this.zAO.x = localLayoutParams.x;
      this.zAO.y = localLayoutParams.y;
      continue;
      iC((int)Math.max(Math.min(this.zAO.x + paramMotionEvent.getRawX() - this.lPG.x, this.zAR.x), 0.0F), (int)Math.max(Math.min(this.zAO.y + paramMotionEvent.getRawY() - this.lPG.y, this.zAR.y), 0.0F));
      continue;
      if ((Math.abs(paramMotionEvent.getRawX() - this.lPG.x) >= BackwardSupportUtil.b.g(getContext(), 3.0F)) || (Math.abs(paramMotionEvent.getRawY() - this.lPG.y) >= BackwardSupportUtil.b.g(getContext(), 3.0F))) {
        break;
      }
      if (this.mOnClickListener != null) {
        this.mOnClickListener.onClick(this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.zAP.x = ((int)Math.max(Math.min(f1 + this.zAO.x - this.lPG.x, this.zAR.x), 0.0F));
    this.zAP.y = ((int)Math.max(Math.min(f2 + this.zAO.y - this.lPG.y, this.zAR.y), 0.0F));
    if (this.zAP.x + getWidth() / 2 <= this.zAR.x / 2)
    {
      this.zAQ.x = b.Bjh;
      label432:
      this.zAQ.y = this.zAP.y;
      if (this.zAQ.y != 0) {
        break label547;
      }
      this.zAQ.y = b.Bjh;
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      this.oFl.postDelayed(this.Zq, 5L);
      if (this.Bjo == null) {
        break;
      }
      this.Bjo.iD(this.zAQ.x, this.zAQ.y);
      break;
      this.zAQ.x = (this.zAR.x - getWidth() - b.Bjh);
      break label432;
      label547:
      if (this.zAQ.y > Bjr) {
        this.zAQ.y = Bjr;
      }
    }
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(80419);
    Object localObject = new c.a();
    ((c.a)localObject).gkG = true;
    ((c.a)localObject).hjU = true;
    ((c.a)localObject).prefixPath = d.apW();
    ((c.a)localObject).hkf = 2131691433;
    localObject = ((c.a)localObject).azc();
    o.ayJ().a(paramString, this.jFL, (c)localObject);
    AppMethodBeat.o(80419);
  }
  
  public void setListener(a parama)
  {
    this.Bjo = parama;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(80421);
    ad.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Bjq = paramBoolean;
    AppMethodBeat.o(80421);
  }
  
  public static abstract interface a
  {
    public abstract void iD(int paramInt1, int paramInt2);
    
    public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag
 * JD-Core Version:    0.7.0.1
 */