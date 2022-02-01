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
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
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
  private static final int Xae;
  private Point UUM;
  private Point UUN;
  private Point UUO;
  private Point UUP;
  private a Xab;
  private WebViewBagBgView Xac;
  private boolean Xad;
  protected MMHandler eqE;
  private Runnable jR;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  private WindowManager mWindowManager;
  private View qAv;
  private ImageView rIe;
  private PointF uwL;
  
  static
  {
    AppMethodBeat.i(80426);
    Xae = com.tencent.mm.cd.a.mt(MMApplicationContext.getContext()) - b.vmb - b.WZT - b.WZU;
    AppMethodBeat.o(80426);
  }
  
  public WebViewBag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80418);
    this.uwL = new PointF();
    this.UUM = new Point();
    this.UUN = new Point();
    this.UUO = new Point();
    this.jR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80416);
        float f = (float)(System.currentTimeMillis() - WebViewBag.a(WebViewBag.this)) * 1.0F / 200.0F;
        if (f <= 1.0F)
        {
          WebViewBag.this.eqE.postDelayed(WebViewBag.b(WebViewBag.this), 5L);
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
    this.eqE = new MMHandler();
    this.UUP = new Point(com.tencent.mm.cd.a.ms(MMApplicationContext.getContext()), com.tencent.mm.cd.a.mt(MMApplicationContext.getContext()));
    LayoutInflater.from(paramContext).inflate(c.g.webview_bag, this);
    this.rIe = ((ImageView)findViewById(c.f.icon));
    this.Xac = ((WebViewBagBgView)findViewById(c.f.bg));
    this.qAv = findViewById(c.f.root);
    this.Xac.setStartColor(paramContext.getResources().getColor(c.c.webview_bag_bg_color));
    this.Xac.setAngryColor(paramContext.getResources().getColor(c.c.webview_bag_bg_angry_color));
    AppMethodBeat.o(80418);
  }
  
  private void nq(int paramInt1, int paramInt2)
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
      finally
      {
        Log.printErrStackTrace("MicroMsg.WebViewBag", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(80423);
  }
  
  protected Point getLastTouchDownViewPos()
  {
    return this.UUM;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80417);
    Log.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.UUP.x = com.tencent.mm.cd.a.ms(MMApplicationContext.getContext());
    this.UUP.y = com.tencent.mm.cd.a.mt(MMApplicationContext.getContext());
    AppMethodBeat.o(80417);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(80422);
    if (!this.Xad)
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
      if (this.Xab != null) {
        this.Xab.B(paramMotionEvent);
      }
      AppMethodBeat.o(80422);
      return true;
      this.uwL.x = paramMotionEvent.getRawX();
      this.uwL.y = paramMotionEvent.getRawY();
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      this.UUM.x = localLayoutParams.x;
      this.UUM.y = localLayoutParams.y;
      continue;
      nq((int)Math.max(Math.min(this.UUM.x + paramMotionEvent.getRawX() - this.uwL.x, this.UUP.x), 0.0F), (int)Math.max(Math.min(this.UUM.y + paramMotionEvent.getRawY() - this.uwL.y, this.UUP.y), 0.0F));
      continue;
      if ((Math.abs(paramMotionEvent.getRawX() - this.uwL.x) >= BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 3.0F)) || (Math.abs(paramMotionEvent.getRawY() - this.uwL.y) >= BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 3.0F))) {
        break;
      }
      if (this.mOnClickListener != null) {
        this.mOnClickListener.onClick(this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.UUN.x = ((int)Math.max(Math.min(f1 + this.UUM.x - this.uwL.x, this.UUP.x), 0.0F));
    this.UUN.y = ((int)Math.max(Math.min(f2 + this.UUM.y - this.uwL.y, this.UUP.y), 0.0F));
    if (this.UUN.x + getWidth() / 2 <= this.UUP.x / 2)
    {
      this.UUO.x = b.WZU;
      label432:
      this.UUO.y = this.UUN.y;
      if (this.UUO.y != 0) {
        break label547;
      }
      this.UUO.y = b.WZU;
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      this.eqE.postDelayed(this.jR, 5L);
      if (this.Xab == null) {
        break;
      }
      this.Xab.nr(this.UUO.x, this.UUO.y);
      break;
      this.UUO.x = (this.UUP.x - getWidth() - b.WZU);
      break label432;
      label547:
      if (this.UUO.y > Xae) {
        this.UUO.y = Xae;
      }
    }
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(80419);
    Object localObject = new c.a();
    ((c.a)localObject).nrc = true;
    ((c.a)localObject).oKp = true;
    ((c.a)localObject).prefixPath = d.bzL();
    ((c.a)localObject).oKB = c.h.webview_bag_default_icon;
    localObject = ((c.a)localObject).bKx();
    r.bKe().a(paramString, this.rIe, (c)localObject);
    AppMethodBeat.o(80419);
  }
  
  public void setListener(a parama)
  {
    this.Xab = parama;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(80421);
    Log.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Xad = paramBoolean;
    AppMethodBeat.o(80421);
  }
  
  public final void y(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(80420);
    WebViewBagBgView localWebViewBagBgView = this.Xac;
    localWebViewBagBgView.Xan = false;
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    localWebViewBagBgView.cam = paramInt1;
    localWebViewBagBgView.cqG = paramInt2;
    localWebViewBagBgView.mStartTime = paramLong;
    localWebViewBagBgView.xP(l);
    if (paramLong > l) {
      localWebViewBagBgView.postDelayed(new WebViewBagBgView.1(localWebViewBagBgView), paramLong - l);
    }
    for (;;)
    {
      localWebViewBagBgView.invalidate();
      AppMethodBeat.o(80420);
      return;
      localWebViewBagBgView.Xan = true;
    }
  }
  
  public static abstract interface a
  {
    public abstract void B(MotionEvent paramMotionEvent);
    
    public abstract void nr(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag
 * JD-Core Version:    0.7.0.1
 */