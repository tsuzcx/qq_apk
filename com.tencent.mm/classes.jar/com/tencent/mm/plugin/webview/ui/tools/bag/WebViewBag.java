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
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

public class WebViewBag
  extends FrameLayout
{
  private static final int Efm;
  private a Efj;
  private WebViewBagBgView Efk;
  private boolean Efl;
  private Runnable acb;
  private Point gKA;
  private Point gKB;
  private WindowManager gKC;
  protected ap gKD;
  private PointF gKx;
  private Point gKy;
  private Point gKz;
  private View jCI;
  private ImageView kAX;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(80426);
    Efm = com.tencent.mm.cc.a.iq(aj.getContext()) - b.nIk - b.Efb - b.Efc;
    AppMethodBeat.o(80426);
  }
  
  public WebViewBag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80418);
    this.gKx = new PointF();
    this.gKy = new Point();
    this.gKz = new Point();
    this.gKA = new Point();
    this.acb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80416);
        float f = (float)(System.currentTimeMillis() - WebViewBag.a(WebViewBag.this)) * 1.0F / 200.0F;
        if (f <= 1.0F)
        {
          WebViewBag.this.gKD.postDelayed(WebViewBag.b(WebViewBag.this), 5L);
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
    this.gKC = ((WindowManager)paramContext.getSystemService("window"));
    this.gKD = new ap();
    this.gKB = new Point(com.tencent.mm.cc.a.ip(aj.getContext()), com.tencent.mm.cc.a.iq(aj.getContext()));
    LayoutInflater.from(paramContext).inflate(2131496080, this);
    this.kAX = ((ImageView)findViewById(2131300874));
    this.Efk = ((WebViewBagBgView)findViewById(2131297203));
    this.jCI = findViewById(2131304239);
    this.Efk.setStartColor(paramContext.getResources().getColor(2131101163));
    this.Efk.setAngryColor(paramContext.getResources().getColor(2131101162));
    AppMethodBeat.o(80418);
  }
  
  private void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80423);
    if (this.gKC != null)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      try
      {
        this.gKC.updateViewLayout(this, localLayoutParams);
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
    return this.gKy;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80417);
    ad.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.gKB.x = com.tencent.mm.cc.a.ip(aj.getContext());
    this.gKB.y = com.tencent.mm.cc.a.iq(aj.getContext());
    AppMethodBeat.o(80417);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(80422);
    if (!this.Efl)
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
      if (this.Efj != null) {
        this.Efj.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(80422);
      return true;
      this.gKx.x = paramMotionEvent.getRawX();
      this.gKx.y = paramMotionEvent.getRawY();
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      this.gKy.x = localLayoutParams.x;
      this.gKy.y = localLayoutParams.y;
      continue;
      cR((int)Math.max(Math.min(this.gKy.x + paramMotionEvent.getRawX() - this.gKx.x, this.gKB.x), 0.0F), (int)Math.max(Math.min(this.gKy.y + paramMotionEvent.getRawY() - this.gKx.y, this.gKB.y), 0.0F));
      continue;
      if ((Math.abs(paramMotionEvent.getRawX() - this.gKx.x) >= BackwardSupportUtil.b.g(getContext(), 3.0F)) || (Math.abs(paramMotionEvent.getRawY() - this.gKx.y) >= BackwardSupportUtil.b.g(getContext(), 3.0F))) {
        break;
      }
      if (this.mOnClickListener != null) {
        this.mOnClickListener.onClick(this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.gKz.x = ((int)Math.max(Math.min(f1 + this.gKy.x - this.gKx.x, this.gKB.x), 0.0F));
    this.gKz.y = ((int)Math.max(Math.min(f2 + this.gKy.y - this.gKx.y, this.gKB.y), 0.0F));
    if (this.gKz.x + getWidth() / 2 <= this.gKB.x / 2)
    {
      this.gKA.x = b.Efc;
      label427:
      this.gKA.y = this.gKz.y;
      if (this.gKA.y != 0) {
        break label542;
      }
      this.gKA.y = b.Efc;
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      this.gKD.postDelayed(this.acb, 5L);
      if (this.Efj == null) {
        break;
      }
      this.Efj.jd(this.gKA.x, this.gKA.y);
      break;
      this.gKA.x = (this.gKB.x - getWidth() - b.Efc);
      break label427;
      label542:
      if (this.gKA.y > Efm) {
        this.gKA.y = Efm;
      }
    }
  }
  
  public final void p(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(80420);
    WebViewBagBgView localWebViewBagBgView = this.Efk;
    localWebViewBagBgView.Efv = false;
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    localWebViewBagBgView.atW = paramInt1;
    localWebViewBagBgView.BlA = paramInt2;
    localWebViewBagBgView.mStartTime = paramLong;
    localWebViewBagBgView.Ct(l);
    if (paramLong > l) {
      localWebViewBagBgView.postDelayed(new WebViewBagBgView.1(localWebViewBagBgView), paramLong - l);
    }
    for (;;)
    {
      localWebViewBagBgView.invalidate();
      AppMethodBeat.o(80420);
      return;
      localWebViewBagBgView.Efv = true;
    }
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(80419);
    Object localObject = new c.a();
    ((c.a)localObject).hfi = true;
    ((c.a)localObject).idr = true;
    ((c.a)localObject).prefixPath = d.azA();
    ((c.a)localObject).idD = 2131691433;
    localObject = ((c.a)localObject).aJc();
    q.aIJ().a(paramString, this.kAX, (c)localObject);
    AppMethodBeat.o(80419);
  }
  
  public void setListener(a parama)
  {
    this.Efj = parama;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(80421);
    ad.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Efl = paramBoolean;
    AppMethodBeat.o(80421);
  }
  
  public static abstract interface a
  {
    public abstract void jd(int paramInt1, int paramInt2);
    
    public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag
 * JD-Core Version:    0.7.0.1
 */