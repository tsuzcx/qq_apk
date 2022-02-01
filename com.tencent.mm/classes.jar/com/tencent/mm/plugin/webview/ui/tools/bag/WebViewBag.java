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
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;

public class WebViewBag
  extends FrameLayout
{
  private static final int CBE;
  private a CBB;
  private WebViewBagBgView CBC;
  private boolean CBD;
  private Runnable aal;
  private PointF gqN;
  private Point gqO;
  private Point gqP;
  private Point gqQ;
  private Point gqR;
  private WindowManager gqS;
  protected ao gqT;
  private View jja;
  private ImageView kgj;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  
  static
  {
    AppMethodBeat.i(80426);
    CBE = com.tencent.mm.cc.a.ih(ai.getContext()) - b.nhO - b.CBt - b.CBu;
    AppMethodBeat.o(80426);
  }
  
  public WebViewBag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80418);
    this.gqN = new PointF();
    this.gqO = new Point();
    this.gqP = new Point();
    this.gqQ = new Point();
    this.aal = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80416);
        float f = (float)(System.currentTimeMillis() - WebViewBag.a(WebViewBag.this)) * 1.0F / 200.0F;
        if (f <= 1.0F)
        {
          WebViewBag.this.gqT.postDelayed(WebViewBag.b(WebViewBag.this), 5L);
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
    this.gqS = ((WindowManager)paramContext.getSystemService("window"));
    this.gqT = new ao();
    this.gqR = new Point(com.tencent.mm.cc.a.ig(ai.getContext()), com.tencent.mm.cc.a.ih(ai.getContext()));
    LayoutInflater.from(paramContext).inflate(2131496080, this);
    this.kgj = ((ImageView)findViewById(2131300874));
    this.CBC = ((WebViewBagBgView)findViewById(2131297203));
    this.jja = findViewById(2131304239);
    this.CBC.setStartColor(paramContext.getResources().getColor(2131101163));
    this.CBC.setAngryColor(paramContext.getResources().getColor(2131101162));
    AppMethodBeat.o(80418);
  }
  
  private void cP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80423);
    if (this.gqS != null)
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      try
      {
        this.gqS.updateViewLayout(this, localLayoutParams);
        AppMethodBeat.o(80423);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.printErrStackTrace("MicroMsg.WebViewBag", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(80423);
  }
  
  protected Point getLastTouchDownViewPos()
  {
    return this.gqO;
  }
  
  public final void o(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(80420);
    WebViewBagBgView localWebViewBagBgView = this.CBC;
    localWebViewBagBgView.CBN = false;
    long l = System.currentTimeMillis();
    ac.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    localWebViewBagBgView.asf = paramInt1;
    localWebViewBagBgView.zTW = paramInt2;
    localWebViewBagBgView.mStartTime = paramLong;
    localWebViewBagBgView.zE(l);
    if (paramLong > l) {
      localWebViewBagBgView.postDelayed(new WebViewBagBgView.1(localWebViewBagBgView), paramLong - l);
    }
    for (;;)
    {
      localWebViewBagBgView.invalidate();
      AppMethodBeat.o(80420);
      return;
      localWebViewBagBgView.CBN = true;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80417);
    ac.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.gqR.x = com.tencent.mm.cc.a.ig(ai.getContext());
    this.gqR.y = com.tencent.mm.cc.a.ih(ai.getContext());
    AppMethodBeat.o(80417);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(80422);
    if (!this.CBD)
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
      if (this.CBB != null) {
        this.CBB.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(80422);
      return true;
      this.gqN.x = paramMotionEvent.getRawX();
      this.gqN.y = paramMotionEvent.getRawY();
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      this.gqO.x = localLayoutParams.x;
      this.gqO.y = localLayoutParams.y;
      continue;
      cP((int)Math.max(Math.min(this.gqO.x + paramMotionEvent.getRawX() - this.gqN.x, this.gqR.x), 0.0F), (int)Math.max(Math.min(this.gqO.y + paramMotionEvent.getRawY() - this.gqN.y, this.gqR.y), 0.0F));
      continue;
      if ((Math.abs(paramMotionEvent.getRawX() - this.gqN.x) >= BackwardSupportUtil.b.g(getContext(), 3.0F)) || (Math.abs(paramMotionEvent.getRawY() - this.gqN.y) >= BackwardSupportUtil.b.g(getContext(), 3.0F))) {
        break;
      }
      if (this.mOnClickListener != null) {
        this.mOnClickListener.onClick(this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.gqP.x = ((int)Math.max(Math.min(f1 + this.gqO.x - this.gqN.x, this.gqR.x), 0.0F));
    this.gqP.y = ((int)Math.max(Math.min(f2 + this.gqO.y - this.gqN.y, this.gqR.y), 0.0F));
    if (this.gqP.x + getWidth() / 2 <= this.gqR.x / 2)
    {
      this.gqQ.x = b.CBu;
      label432:
      this.gqQ.y = this.gqP.y;
      if (this.gqQ.y != 0) {
        break label547;
      }
      this.gqQ.y = b.CBu;
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      this.gqT.postDelayed(this.aal, 5L);
      if (this.CBB == null) {
        break;
      }
      this.CBB.iQ(this.gqQ.x, this.gqQ.y);
      break;
      this.gqQ.x = (this.gqR.x - getWidth() - b.CBu);
      break label432;
      label547:
      if (this.gqQ.y > CBE) {
        this.gqQ.y = CBE;
      }
    }
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(80419);
    Object localObject = new c.a();
    ((c.a)localObject).gLt = true;
    ((c.a)localObject).hKx = true;
    ((c.a)localObject).prefixPath = d.awL();
    ((c.a)localObject).hKI = 2131691433;
    localObject = ((c.a)localObject).aFT();
    o.aFB().a(paramString, this.kgj, (c)localObject);
    AppMethodBeat.o(80419);
  }
  
  public void setListener(a parama)
  {
    this.CBB = parama;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(80421);
    ac.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.CBD = paramBoolean;
    AppMethodBeat.o(80421);
  }
  
  public static abstract interface a
  {
    public abstract void iQ(int paramInt1, int paramInt2);
    
    public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag
 * JD-Core Version:    0.7.0.1
 */