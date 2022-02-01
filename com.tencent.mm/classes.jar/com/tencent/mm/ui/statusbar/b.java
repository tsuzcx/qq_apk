package com.tencent.mm.ui.statusbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public class b
  extends FrameLayout
  implements c.a
{
  protected static final boolean XMo = c.XMC;
  private final Runnable XMn;
  private c XMp;
  private int XMq;
  private int XMr;
  private boolean XMs;
  private boolean XMt;
  private boolean XMu;
  private boolean XMv;
  private final int[] XMw;
  private int XMx;
  private boolean aki;
  private Activity mActivity;
  private Paint mPaint;
  private volatile int mStatusBarHeight;
  
  public b(Context paramContext)
  {
    super(a.ly(paramContext));
    AppMethodBeat.i(133806);
    this.XMn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(237513);
        if (b.a(b.this))
        {
          if (b.b(b.this) != null)
          {
            b.b(b.this).b(b.this);
            b.c(b.this);
          }
          b.d(b.this);
          b.e(b.this);
          AppMethodBeat.o(237513);
          return;
        }
        b.this.cfw();
        AppMethodBeat.o(237513);
      }
    };
    this.XMq = 0;
    this.XMr = 0;
    this.XMs = false;
    this.aki = false;
    this.XMt = false;
    this.XMu = false;
    this.XMv = false;
    this.XMw = new int[2];
    this.XMx = 0;
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramContext = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(133806);
      throw paramContext;
    }
    cfw();
    if ((getContext() instanceof a)) {
      ((a)getContext()).XMB = new b.a.a()
      {
        public final void hXW()
        {
          AppMethodBeat.i(237610);
          if (Looper.getMainLooper() != Looper.myLooper())
          {
            b.this.post(b.f(b.this));
            AppMethodBeat.o(237610);
            return;
          }
          b.f(b.this).run();
          AppMethodBeat.o(237610);
        }
      };
    }
    AppMethodBeat.o(133806);
  }
  
  private void axs(int paramInt)
  {
    AppMethodBeat.i(133808);
    getLocationInWindow(this.XMw);
    this.XMx = this.XMw[1];
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.aki), Integer.valueOf(this.XMw[0]), Integer.valueOf(this.XMw[1]) });
    }
    this.mStatusBarHeight = Math.max(0, paramInt - this.XMw[1]);
    if (this.aki)
    {
      this.XMu = true;
      AppMethodBeat.o(133808);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.XMs) {
          continue;
        }
        paramInt = 0;
        setPadding(0, paramInt, 0, 0);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Log.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", new Object[] { localIllegalStateException.getMessage() });
        continue;
      }
      if (isLayoutRequested()) {
        hXT();
      }
      AppMethodBeat.o(133808);
      return;
      paramInt = this.mStatusBarHeight;
    }
  }
  
  private void hXS()
  {
    AppMethodBeat.i(175985);
    if (this.XMp == null)
    {
      AppMethodBeat.o(175985);
      return;
    }
    BF(this.XMp.XMF);
    AppMethodBeat.o(175985);
  }
  
  private void hXT()
  {
    AppMethodBeat.i(133809);
    if (hXV())
    {
      invalidate();
      AppMethodBeat.o(133809);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(133809);
  }
  
  private static boolean hXV()
  {
    AppMethodBeat.i(175988);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      AppMethodBeat.o(175988);
      return true;
    }
    AppMethodBeat.o(175988);
    return false;
  }
  
  public void BF(int paramInt)
  {
    AppMethodBeat.i(133804);
    axs(paramInt);
    AppMethodBeat.o(133804);
  }
  
  public final void GZ(boolean paramBoolean)
  {
    AppMethodBeat.i(133805);
    this.XMs = paramBoolean;
    axs(this.mStatusBarHeight);
    AppMethodBeat.o(133805);
  }
  
  public void T(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133812);
    o(paramInt, paramBoolean, true);
    AppMethodBeat.o(133812);
  }
  
  protected void cfw()
  {
    AppMethodBeat.i(133807);
    if (!XMo)
    {
      this.mActivity = null;
      this.mPaint = null;
      AppMethodBeat.o(133807);
      return;
    }
    setPadding(0, 0, 0, 0);
    this.mStatusBarHeight = 0;
    if (this.XMp != null) {
      this.XMp.b(this);
    }
    this.mActivity = AndroidContextUtil.castActivityOrNull(getContext());
    if (this.mActivity == null)
    {
      this.mPaint = null;
      super.setWillNotDraw(true);
      AppMethodBeat.o(133807);
      return;
    }
    c localc = c.bA(this.mActivity);
    this.XMp = localc;
    localc.a(this);
    this.mPaint = new Paint(0);
    this.mPaint.setStyle(Paint.Style.FILL);
    super.setWillNotDraw(false);
    AppMethodBeat.o(133807);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(133814);
    if ((this.mStatusBarHeight <= 0) || (!XMo) || (this.XMs) || (willNotDraw())) {}
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      if ((this.mStatusBarHeight > 0) && (XMo) && (this.XMs) && (!willNotDraw())) {
        break;
      }
      AppMethodBeat.o(133814);
      return;
      if (this.mPaint == null)
      {
        Log.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarBackground NULL paint");
      }
      else
      {
        this.mPaint.setColor(this.XMq);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mStatusBarHeight, this.mPaint);
      }
    }
    if (this.mPaint == null)
    {
      Log.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
      AppMethodBeat.o(133814);
      return;
    }
    this.mPaint.setColor(this.XMr);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mStatusBarHeight, this.mPaint);
    AppMethodBeat.o(133814);
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(175986);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    hXS();
    AppMethodBeat.o(175986);
  }
  
  public int getDrawnStatusBarHeight()
  {
    AppMethodBeat.i(175983);
    int i = Math.max(0, this.mStatusBarHeight);
    AppMethodBeat.o(175983);
    return i;
  }
  
  public final boolean hXU()
  {
    return this.aki;
  }
  
  public final void o(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133813);
    int j = this.XMq;
    int k = this.XMr;
    this.XMq = paramInt;
    if ((!XMo) || (this.mActivity == null))
    {
      AppMethodBeat.o(133813);
      return;
    }
    Object localObject = this.mActivity.getWindow();
    d.e((Window)localObject);
    if (paramBoolean2)
    {
      if (!d.d((Window)localObject, paramBoolean1)) {
        break label122;
      }
      this.XMq = paramInt;
    }
    label168:
    label202:
    for (;;)
    {
      paramInt = 0;
      for (localObject = this;; localObject = this)
      {
        ((b)localObject).XMr = paramInt;
        label122:
        do
        {
          if ((this.XMq != 0) || (this.XMr != 0)) {
            break label168;
          }
          super.setWillNotDraw(true);
          hXT();
          AppMethodBeat.o(133813);
          return;
          if (d.hHz()) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 21);
        int i = paramInt;
        if (paramBoolean1) {
          i = d.aor(paramInt);
        }
        this.XMq = i;
        if (!paramBoolean1) {
          break label202;
        }
        paramInt = Color.argb(51, 0, 0, 0);
      }
      if ((j != this.XMq) || (k != this.XMr))
      {
        super.setWillNotDraw(false);
        hXT();
      }
      AppMethodBeat.o(133813);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(175987);
    super.onAttachedToWindow();
    hXS();
    AppMethodBeat.o(175987);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237756);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.XMp != null) && (!this.aki))
    {
      getLocationInWindow(this.XMw);
      if (this.XMx != this.XMw[1]) {
        this.XMp.hXX();
      }
      this.XMx = this.XMw[1];
    }
    AppMethodBeat.o(237756);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(133810);
    if (this.aki)
    {
      this.XMv = true;
      AppMethodBeat.o(133810);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(133810);
  }
  
  @SuppressLint({"WrongThread"})
  public final void setLayoutFrozen(final boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(133815);
    if (!hXV())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(237739);
          b.this.setLayoutFrozen(paramBoolean);
          AppMethodBeat.o(237739);
        }
      });
      AppMethodBeat.o(133815);
      return;
    }
    Log.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b], mReInitializeDeferred[%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aki), Boolean.valueOf(this.XMv), Boolean.valueOf(this.XMu), Boolean.valueOf(this.XMt) });
    if (paramBoolean != this.aki) {}
    for (;;)
    {
      this.aki = paramBoolean;
      if ((i != 0) && (!paramBoolean))
      {
        if (this.XMt)
        {
          cfw();
          this.XMt = false;
        }
        if ((this.XMv) || (this.XMu))
        {
          axs(this.mStatusBarHeight);
          this.XMv = false;
          this.XMu = false;
        }
      }
      AppMethodBeat.o(133815);
      return;
      i = 0;
    }
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(133811);
    if (!XMo)
    {
      AppMethodBeat.o(133811);
      return;
    }
    Activity localActivity = this.mActivity;
    if (localActivity == null) {}
    for (boolean bool = false;; bool = d.f(localActivity.getWindow()))
    {
      T(paramInt, bool);
      AppMethodBeat.o(133811);
      return;
    }
  }
  
  public final void setWillNotDraw(boolean paramBoolean) {}
  
  public final boolean willNotDraw()
  {
    AppMethodBeat.i(175984);
    boolean bool = super.willNotDraw();
    AppMethodBeat.o(175984);
    return bool;
  }
  
  static final class a
    extends MutableContextWrapper
  {
    private boolean XMA = true;
    a XMB;
    
    private a(MutableContextWrapper paramMutableContextWrapper)
    {
      super();
    }
    
    public static Context ly(Context paramContext)
    {
      AppMethodBeat.i(133803);
      if ((paramContext instanceof MutableContextWrapper))
      {
        paramContext = new a((MutableContextWrapper)paramContext);
        AppMethodBeat.o(133803);
        return paramContext;
      }
      AppMethodBeat.o(133803);
      return paramContext;
    }
    
    public final void setBaseContext(Context paramContext)
    {
      AppMethodBeat.i(133802);
      if (this.XMA)
      {
        if (paramContext == getBaseContext())
        {
          AppMethodBeat.o(133802);
          return;
        }
        ((MutableContextWrapper)getBaseContext()).setBaseContext(paramContext);
        if (this.XMB != null)
        {
          this.XMB.hXW();
          AppMethodBeat.o(133802);
        }
      }
      else
      {
        super.setBaseContext(paramContext);
      }
      AppMethodBeat.o(133802);
    }
    
    static abstract interface a
    {
      public abstract void hXW();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.b
 * JD-Core Version:    0.7.0.1
 */