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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class WebViewBag
  extends FrameLayout
{
  private static final int JkI;
  private Point HpF;
  private Point HpG;
  private Point HpH;
  private Point HpI;
  private a JkF;
  private WebViewBagBgView JkG;
  private boolean JkH;
  private Runnable aco;
  protected MMHandler czp;
  private View kHq;
  private ImageView lIM;
  private View.OnClickListener mOnClickListener;
  private long mStartTime;
  private WindowManager mWindowManager;
  private PointF okA;
  
  static
  {
    AppMethodBeat.i(80426);
    JkI = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()) - b.oYI - b.Jkx - b.Jky;
    AppMethodBeat.o(80426);
  }
  
  public WebViewBag(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(80418);
    this.okA = new PointF();
    this.HpF = new Point();
    this.HpG = new Point();
    this.HpH = new Point();
    this.aco = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80416);
        float f = (float)(System.currentTimeMillis() - WebViewBag.a(WebViewBag.this)) * 1.0F / 200.0F;
        if (f <= 1.0F)
        {
          WebViewBag.this.czp.postDelayed(WebViewBag.b(WebViewBag.this), 5L);
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
    this.czp = new MMHandler();
    this.HpI = new Point(com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()), com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
    LayoutInflater.from(paramContext).inflate(2131497065, this);
    this.lIM = ((ImageView)findViewById(2131302468));
    this.JkG = ((WebViewBagBgView)findViewById(2131297352));
    this.kHq = findViewById(2131307157);
    this.JkG.setStartColor(paramContext.getResources().getColor(2131101406));
    this.JkG.setAngryColor(paramContext.getResources().getColor(2131101405));
    AppMethodBeat.o(80418);
  }
  
  private void ko(int paramInt1, int paramInt2)
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
    return this.HpF;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80417);
    Log.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.HpI.x = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext());
    this.HpI.y = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext());
    AppMethodBeat.o(80417);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(80422);
    if (!this.JkH)
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
      if (this.JkF != null) {
        this.JkF.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(80422);
      return true;
      this.okA.x = paramMotionEvent.getRawX();
      this.okA.y = paramMotionEvent.getRawY();
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)getLayoutParams();
      this.HpF.x = localLayoutParams.x;
      this.HpF.y = localLayoutParams.y;
      continue;
      ko((int)Math.max(Math.min(this.HpF.x + paramMotionEvent.getRawX() - this.okA.x, this.HpI.x), 0.0F), (int)Math.max(Math.min(this.HpF.y + paramMotionEvent.getRawY() - this.okA.y, this.HpI.y), 0.0F));
      continue;
      if ((Math.abs(paramMotionEvent.getRawX() - this.okA.x) >= BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 3.0F)) || (Math.abs(paramMotionEvent.getRawY() - this.okA.y) >= BackwardSupportUtil.BitmapFactory.fromDPToPix(getContext(), 3.0F))) {
        break;
      }
      if (this.mOnClickListener != null) {
        this.mOnClickListener.onClick(this);
      }
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    this.HpG.x = ((int)Math.max(Math.min(f1 + this.HpF.x - this.okA.x, this.HpI.x), 0.0F));
    this.HpG.y = ((int)Math.max(Math.min(f2 + this.HpF.y - this.okA.y, this.HpI.y), 0.0F));
    if (this.HpG.x + getWidth() / 2 <= this.HpI.x / 2)
    {
      this.HpH.x = b.Jky;
      label427:
      this.HpH.y = this.HpG.y;
      if (this.HpH.y != 0) {
        break label542;
      }
      this.HpH.y = b.Jky;
    }
    for (;;)
    {
      this.mStartTime = System.currentTimeMillis();
      this.czp.postDelayed(this.aco, 5L);
      if (this.JkF == null) {
        break;
      }
      this.JkF.kp(this.HpH.x, this.HpH.y);
      break;
      this.HpH.x = (this.HpI.x - getWidth() - b.Jky);
      break label427;
      label542:
      if (this.HpH.y > JkI) {
        this.HpH.y = JkI;
      }
    }
  }
  
  public final void p(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(80420);
    WebViewBagBgView localWebViewBagBgView = this.JkG;
    localWebViewBagBgView.JkR = false;
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l) });
    localWebViewBagBgView.atU = paramInt1;
    localWebViewBagBgView.FNL = paramInt2;
    localWebViewBagBgView.mStartTime = paramLong;
    localWebViewBagBgView.Mg(l);
    if (paramLong > l) {
      localWebViewBagBgView.postDelayed(new WebViewBagBgView.1(localWebViewBagBgView), paramLong - l);
    }
    for (;;)
    {
      localWebViewBagBgView.invalidate();
      AppMethodBeat.o(80420);
      return;
      localWebViewBagBgView.JkR = true;
    }
  }
  
  public void setIcon(String paramString)
  {
    AppMethodBeat.i(80419);
    Object localObject = new c.a();
    ((c.a)localObject).iaT = true;
    ((c.a)localObject).jbf = true;
    ((c.a)localObject).prefixPath = d.aSY();
    ((c.a)localObject).jbq = 2131691771;
    localObject = ((c.a)localObject).bdv();
    q.bcV().a(paramString, this.lIM, (c)localObject);
    AppMethodBeat.o(80419);
  }
  
  public void setListener(a parama)
  {
    this.JkF = parama;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setTouchEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(80421);
    Log.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.JkH = paramBoolean;
    AppMethodBeat.o(80421);
  }
  
  public static abstract interface a
  {
    public abstract void kp(int paramInt1, int paramInt2);
    
    public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag
 * JD-Core Version:    0.7.0.1
 */