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
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class WebViewBag
  extends FrameLayout
{
  private static final int Qia;
  private Point OgA;
  private Point OgB;
  private Point Ogy;
  private Point Ogz;
  private a QhX;
  private WebViewBagBgView QhY;
  private boolean QhZ;
  protected MMHandler cyl;
  private Runnable iW;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  private WindowManager mWindowManager;
  private View nBk;
  private ImageView oFa;
  private PointF rmS;
  
  static
  {
    AppMethodBeat.i(80426);
    Qia = com.tencent.mm.ci.a.ks(MMApplicationContext.getContext()) - b.saJ - b.QhP - b.QhQ;
    AppMethodBeat.o(80426);
  }
  
  public WebViewBag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80418);
    this.rmS = new PointF();
    this.Ogy = new Point();
    this.Ogz = new Point();
    this.OgA = new Point();
    this.iW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80416);
        float f = (float)(System.currentTimeMillis() - WebViewBag.a(WebViewBag.this)) * 1.0F / 200.0F;
        if (f <= 1.0F)
        {
          WebViewBag.this.cyl.postDelayed(WebViewBag.b(WebViewBag.this), 5L);
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
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.cyl = new MMHandler();
    this.OgB = new Point(com.tencent.mm.ci.a.kr(MMApplicationContext.getContext()), com.tencent.mm.ci.a.ks(MMApplicationContext.getContext()));
    LayoutInflater.from(paramContext).inflate(c.g.webview_bag, this);
    this.oFa = ((ImageView)findViewById(c.f.icon));
    this.QhY = ((WebViewBagBgView)findViewById(c.f.bg));
    this.nBk = findViewById(c.f.root);
    this.QhY.setStartColor(paramContext.getResources().getColor(c.c.webview_bag_bg_color));
    this.QhY.setAngryColor(paramContext.getResources().getColor(c.c.webview_bag_bg_angry_color));
    AppMethodBeat.o(80418);
  }
  
  private void lG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80423);
    if (this.mWindowManager != null)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      try
      {
        this.mWindowManager.updateViewLayout(this, localLayoutParams);
        AppMethodBeat.o(80423);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("MicroMsg.WebViewBag", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(80423);
  }
  
  protected Point getLastTouchDownViewPos()
  {
    return this.Ogy;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80417);
    Log.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.OgB.x = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext());
    this.OgB.y = com.tencent.mm.ci.a.ks(MMApplicationContext.getContext());
    AppMethodBeat.o(80417);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(80422);
    if (!this.QhZ)
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
      if (this.QhX != null) {
        this.QhX.B(paramMotionEvent);
      }
      AppMethodBeat.o(80422);
      return true;
      this.rmS.x = paramMotionEvent.getRawX();
      this.rmS.y = paramMotionEvent.getRawY();
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      this.Ogy.x = localLayoutParams.x;
      this.Ogy.y = localLayoutParams.y;
      continue;
      lG((int)Math.max(Math.min(this.Ogy.x + paramMotionEvent.getRawX() - this.rmS.x, this.OgB.x), 0.0F), (int)Math.max(Math.min(this.Ogy.y + paramMotionEvent.getRawY() - this.rmS.y, this.OgB.y), 0.0F));
      continue;
      if ((Math.abs(paramMotionEvent.getRawX() - this.rmS.x) >= BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 3.0F)) || (Math.abs(paramMotionEvent.getRawY() - this.rmS.y) >= BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 3.0F))) {
        break;
      }
      if (this.mOnClickListener != null) {
        this.mOnClickListener.onClick(this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.Ogz.x = ((int)Math.max(Math.min(f1 + this.Ogy.x - this.rmS.x, this.OgB.x), 0.0F));
    this.Ogz.y = ((int)Math.max(Math.min(f2 + this.Ogy.y - this.rmS.y, this.OgB.y), 0.0F));
    if (this.Ogz.x + getWidth() / 2 <= this.OgB.x / 2)
    {
      this.OgA.x = b.QhQ;
      label432:
      this.OgA.y = this.Ogz.y;
      if (this.OgA.y != 0) {
        break label547;
      }
      this.OgA.y = b.QhQ;
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      this.cyl.postDelayed(this.iW, 5L);
      if (this.QhX == null) {
        break;
      }
      this.QhX.lH(this.OgA.x, this.OgA.y);
      break;
      this.OgA.x = (this.OgB.x - getWidth() - b.QhQ);
      break label432;
      label547:
      if (this.OgA.y > Qia) {
        this.OgA.y = Qia;
      }
    }
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(80419);
    Object localObject = new c.a();
    ((c.a)localObject).kPz = true;
    ((c.a)localObject).lRD = true;
    ((c.a)localObject).prefixPath = d.bbW();
    ((c.a)localObject).lRP = c.h.webview_bag_default_icon;
    localObject = ((c.a)localObject).bmL();
    q.bml().a(paramString, this.oFa, (c)localObject);
    AppMethodBeat.o(80419);
  }
  
  public void setListener(a parama)
  {
    this.QhX = parama;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(80421);
    Log.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.QhZ = paramBoolean;
    AppMethodBeat.o(80421);
  }
  
  public final void v(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(80420);
    WebViewBagBgView localWebViewBagBgView = this.QhY;
    localWebViewBagBgView.Qij = false;
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    localWebViewBagBgView.alM = paramInt1;
    localWebViewBagBgView.MhM = paramInt2;
    localWebViewBagBgView.mStartTime = paramLong;
    localWebViewBagBgView.TG(l);
    if (paramLong > l) {
      localWebViewBagBgView.postDelayed(new WebViewBagBgView.1(localWebViewBagBgView), paramLong - l);
    }
    for (;;)
    {
      localWebViewBagBgView.invalidate();
      AppMethodBeat.o(80420);
      return;
      localWebViewBagBgView.Qij = true;
    }
  }
  
  public static abstract interface a
  {
    public abstract void B(MotionEvent paramMotionEvent);
    
    public abstract void lH(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag
 * JD-Core Version:    0.7.0.1
 */