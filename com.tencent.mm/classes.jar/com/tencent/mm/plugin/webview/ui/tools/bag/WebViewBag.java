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
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;

public class WebViewBag
  extends FrameLayout
{
  private static final int Exp;
  private a Exm;
  private WebViewBagBgView Exn;
  private boolean Exo;
  private Runnable acb;
  private PointF gNg;
  private Point gNh;
  private Point gNi;
  private Point gNj;
  private Point gNk;
  private WindowManager gNl;
  protected aq gNm;
  private View jFG;
  private ImageView kEm;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(80426);
    Exp = com.tencent.mm.cb.a.iv(ak.getContext()) - b.nNN - b.Exe - b.Exf;
    AppMethodBeat.o(80426);
  }
  
  public WebViewBag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80418);
    this.gNg = new PointF();
    this.gNh = new Point();
    this.gNi = new Point();
    this.gNj = new Point();
    this.acb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80416);
        float f = (float)(System.currentTimeMillis() - WebViewBag.a(WebViewBag.this)) * 1.0F / 200.0F;
        if (f <= 1.0F)
        {
          WebViewBag.this.gNm.postDelayed(WebViewBag.b(WebViewBag.this), 5L);
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
    this.gNl = ((WindowManager)paramContext.getSystemService("window"));
    this.gNm = new aq();
    this.gNk = new Point(com.tencent.mm.cb.a.iu(ak.getContext()), com.tencent.mm.cb.a.iv(ak.getContext()));
    LayoutInflater.from(paramContext).inflate(2131496080, this);
    this.kEm = ((ImageView)findViewById(2131300874));
    this.Exn = ((WebViewBagBgView)findViewById(2131297203));
    this.jFG = findViewById(2131304239);
    this.Exn.setStartColor(paramContext.getResources().getColor(2131101163));
    this.Exn.setAngryColor(paramContext.getResources().getColor(2131101162));
    AppMethodBeat.o(80418);
  }
  
  private void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80423);
    if (this.gNl != null)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      try
      {
        this.gNl.updateViewLayout(this, localLayoutParams);
        AppMethodBeat.o(80423);
        return;
      }
      catch (Throwable localThrowable)
      {
        ae.printErrStackTrace("MicroMsg.WebViewBag", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(80423);
  }
  
  protected Point getLastTouchDownViewPos()
  {
    return this.gNh;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80417);
    ae.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.gNk.x = com.tencent.mm.cb.a.iu(ak.getContext());
    this.gNk.y = com.tencent.mm.cb.a.iv(ak.getContext());
    AppMethodBeat.o(80417);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(80422);
    if (!this.Exo)
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
      if (this.Exm != null) {
        this.Exm.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(80422);
      return true;
      this.gNg.x = paramMotionEvent.getRawX();
      this.gNg.y = paramMotionEvent.getRawY();
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      this.gNh.x = localLayoutParams.x;
      this.gNh.y = localLayoutParams.y;
      continue;
      cR((int)Math.max(Math.min(this.gNh.x + paramMotionEvent.getRawX() - this.gNg.x, this.gNk.x), 0.0F), (int)Math.max(Math.min(this.gNh.y + paramMotionEvent.getRawY() - this.gNg.y, this.gNk.y), 0.0F));
      continue;
      if ((Math.abs(paramMotionEvent.getRawX() - this.gNg.x) >= BackwardSupportUtil.b.h(getContext(), 3.0F)) || (Math.abs(paramMotionEvent.getRawY() - this.gNg.y) >= BackwardSupportUtil.b.h(getContext(), 3.0F))) {
        break;
      }
      if (this.mOnClickListener != null) {
        this.mOnClickListener.onClick(this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.gNi.x = ((int)Math.max(Math.min(f1 + this.gNh.x - this.gNg.x, this.gNk.x), 0.0F));
    this.gNi.y = ((int)Math.max(Math.min(f2 + this.gNh.y - this.gNg.y, this.gNk.y), 0.0F));
    if (this.gNi.x + getWidth() / 2 <= this.gNk.x / 2)
    {
      this.gNj.x = b.Exf;
      label427:
      this.gNj.y = this.gNi.y;
      if (this.gNj.y != 0) {
        break label542;
      }
      this.gNj.y = b.Exf;
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      this.gNm.postDelayed(this.acb, 5L);
      if (this.Exm == null) {
        break;
      }
      this.Exm.jh(this.gNj.x, this.gNj.y);
      break;
      this.gNj.x = (this.gNk.x - getWidth() - b.Exf);
      break label427;
      label542:
      if (this.gNj.y > Exp) {
        this.gNj.y = Exp;
      }
    }
  }
  
  public final void p(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(80420);
    WebViewBagBgView localWebViewBagBgView = this.Exn;
    localWebViewBagBgView.Exy = false;
    long l = System.currentTimeMillis();
    ae.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    localWebViewBagBgView.atW = paramInt1;
    localWebViewBagBgView.BCZ = paramInt2;
    localWebViewBagBgView.mStartTime = paramLong;
    localWebViewBagBgView.CR(l);
    if (paramLong > l) {
      localWebViewBagBgView.postDelayed(new WebViewBagBgView.1(localWebViewBagBgView), paramLong - l);
    }
    for (;;)
    {
      localWebViewBagBgView.invalidate();
      AppMethodBeat.o(80420);
      return;
      localWebViewBagBgView.Exy = true;
    }
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(80419);
    Object localObject = new c.a();
    ((c.a)localObject).hhW = true;
    ((c.a)localObject).igk = true;
    ((c.a)localObject).prefixPath = d.azQ();
    ((c.a)localObject).igv = 2131691433;
    localObject = ((c.a)localObject).aJu();
    q.aJb().a(paramString, this.kEm, (c)localObject);
    AppMethodBeat.o(80419);
  }
  
  public void setListener(a parama)
  {
    this.Exm = parama;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(80421);
    ae.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Exo = paramBoolean;
    AppMethodBeat.o(80421);
  }
  
  public static abstract interface a
  {
    public abstract void jh(int paramInt1, int paramInt2);
    
    public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag
 * JD-Core Version:    0.7.0.1
 */