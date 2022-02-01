package com.tencent.mm.ui.statusbar;

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
  protected static final boolean afCC = c.afCQ;
  private final Runnable afCB;
  private c afCD;
  private int afCE;
  private int afCF;
  private boolean afCG;
  private boolean afCH;
  private boolean afCI;
  private boolean afCJ;
  private final int[] afCK;
  private int afCL;
  private boolean bYK;
  private Activity mActivity;
  private Paint mPaint;
  private volatile int mStatusBarHeight;
  
  public b(Context paramContext)
  {
    super(a.nC(paramContext));
    AppMethodBeat.i(133806);
    this.afCB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249903);
        if (b.a(b.this))
        {
          if (b.b(b.this) != null)
          {
            b.b(b.this).b(b.this);
            b.c(b.this);
          }
          b.d(b.this);
          b.e(b.this);
          AppMethodBeat.o(249903);
          return;
        }
        b.this.cGh();
        AppMethodBeat.o(249903);
      }
    };
    this.afCE = 0;
    this.afCF = 0;
    this.afCG = false;
    this.bYK = false;
    this.afCH = false;
    this.afCI = false;
    this.afCJ = false;
    this.afCK = new int[2];
    this.afCL = 0;
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramContext = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(133806);
      throw paramContext;
    }
    cGh();
    if ((getContext() instanceof a)) {
      ((a)getContext()).afCP = new b.a.a()
      {
        public final void jCG()
        {
          AppMethodBeat.i(249901);
          if (Looper.getMainLooper() != Looper.myLooper())
          {
            b.this.post(b.f(b.this));
            AppMethodBeat.o(249901);
            return;
          }
          b.f(b.this).run();
          AppMethodBeat.o(249901);
        }
      };
    }
    AppMethodBeat.o(133806);
  }
  
  private void aEb(int paramInt)
  {
    AppMethodBeat.i(133808);
    getLocationInWindow(this.afCK);
    this.afCL = this.afCK[1];
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.bYK), Integer.valueOf(this.afCK[0]), Integer.valueOf(this.afCK[1]) });
    }
    this.mStatusBarHeight = Math.max(0, paramInt - this.afCK[1]);
    if (this.bYK)
    {
      this.afCI = true;
      AppMethodBeat.o(133808);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.afCG) {
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
        jCD();
      }
      AppMethodBeat.o(133808);
      return;
      paramInt = this.mStatusBarHeight;
    }
  }
  
  private void jCC()
  {
    AppMethodBeat.i(175985);
    if (this.afCD == null)
    {
      AppMethodBeat.o(175985);
      return;
    }
    onStatusBarHeightChange(this.afCD.afCS);
    AppMethodBeat.o(175985);
  }
  
  private void jCD()
  {
    AppMethodBeat.i(133809);
    if (jCF())
    {
      invalidate();
      AppMethodBeat.o(133809);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(133809);
  }
  
  private static boolean jCF()
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
  
  public final void MU(boolean paramBoolean)
  {
    AppMethodBeat.i(133805);
    this.afCG = paramBoolean;
    aEb(this.mStatusBarHeight);
    AppMethodBeat.o(133805);
  }
  
  public void aj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133812);
    u(paramInt, paramBoolean, true);
    AppMethodBeat.o(133812);
  }
  
  protected void cGh()
  {
    AppMethodBeat.i(133807);
    if (!afCC)
    {
      this.mActivity = null;
      this.mPaint = null;
      AppMethodBeat.o(133807);
      return;
    }
    setPadding(0, 0, 0, 0);
    this.mStatusBarHeight = 0;
    if (this.afCD != null) {
      this.afCD.b(this);
    }
    this.mActivity = AndroidContextUtil.castActivityOrNull(getContext());
    if (this.mActivity == null)
    {
      this.mPaint = null;
      super.setWillNotDraw(true);
      AppMethodBeat.o(133807);
      return;
    }
    c localc = c.ch(this.mActivity);
    this.afCD = localc;
    localc.a(this);
    this.mPaint = new Paint(0);
    this.mPaint.setStyle(Paint.Style.FILL);
    super.setWillNotDraw(false);
    AppMethodBeat.o(133807);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(133814);
    if ((this.mStatusBarHeight <= 0) || (!afCC) || (this.afCG) || (willNotDraw())) {}
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      if ((this.mStatusBarHeight > 0) && (afCC) && (this.afCG) && (!willNotDraw())) {
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
        this.mPaint.setColor(this.afCE);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mStatusBarHeight, this.mPaint);
      }
    }
    if (this.mPaint == null)
    {
      Log.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
      AppMethodBeat.o(133814);
      return;
    }
    this.mPaint.setColor(this.afCF);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mStatusBarHeight, this.mPaint);
    AppMethodBeat.o(133814);
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(175986);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    jCC();
    AppMethodBeat.o(175986);
  }
  
  public int getDrawnStatusBarHeight()
  {
    AppMethodBeat.i(175983);
    int i = Math.max(0, this.mStatusBarHeight);
    AppMethodBeat.o(175983);
    return i;
  }
  
  public final boolean jCE()
  {
    return this.bYK;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(175987);
    super.onAttachedToWindow();
    jCC();
    AppMethodBeat.o(175987);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(250007);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.afCD != null) && (!this.bYK))
    {
      getLocationInWindow(this.afCK);
      if (this.afCL != this.afCK[1]) {
        this.afCD.jCH();
      }
      this.afCL = this.afCK[1];
    }
    AppMethodBeat.o(250007);
  }
  
  public void onStatusBarHeightChange(int paramInt)
  {
    AppMethodBeat.i(133804);
    aEb(paramInt);
    AppMethodBeat.o(133804);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(133810);
    if (this.bYK)
    {
      this.afCJ = true;
      AppMethodBeat.o(133810);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(133810);
  }
  
  public final void setLayoutFrozen(final boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(133815);
    if (!jCF())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249899);
          b.this.setLayoutFrozen(paramBoolean);
          AppMethodBeat.o(249899);
        }
      });
      AppMethodBeat.o(133815);
      return;
    }
    Log.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b], mReInitializeDeferred[%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.bYK), Boolean.valueOf(this.afCJ), Boolean.valueOf(this.afCI), Boolean.valueOf(this.afCH) });
    if (paramBoolean != this.bYK) {}
    for (;;)
    {
      this.bYK = paramBoolean;
      if ((i != 0) && (!paramBoolean))
      {
        if (this.afCH)
        {
          cGh();
          this.afCH = false;
        }
        if ((this.afCJ) || (this.afCI))
        {
          aEb(this.mStatusBarHeight);
          this.afCJ = false;
          this.afCI = false;
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
    if (!afCC)
    {
      AppMethodBeat.o(133811);
      return;
    }
    Activity localActivity = this.mActivity;
    if (localActivity == null) {}
    for (boolean bool = false;; bool = d.h(localActivity.getWindow()))
    {
      aj(paramInt, bool);
      AppMethodBeat.o(133811);
      return;
    }
  }
  
  public final void setWillNotDraw(boolean paramBoolean) {}
  
  public final void u(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133813);
    int j = this.afCE;
    int k = this.afCF;
    this.afCE = paramInt;
    if ((!afCC) || (this.mActivity == null))
    {
      AppMethodBeat.o(133813);
      return;
    }
    Object localObject = this.mActivity.getWindow();
    d.g((Window)localObject);
    if (paramBoolean2)
    {
      if (!d.c((Window)localObject, paramBoolean1)) {
        break label122;
      }
      this.afCE = paramInt;
    }
    label168:
    label202:
    for (;;)
    {
      paramInt = 0;
      for (localObject = this;; localObject = this)
      {
        ((b)localObject).afCF = paramInt;
        label122:
        do
        {
          if ((this.afCE != 0) || (this.afCF != 0)) {
            break label168;
          }
          super.setWillNotDraw(true);
          jCD();
          AppMethodBeat.o(133813);
          return;
          if (d.jjJ()) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 21);
        int i = paramInt;
        if (paramBoolean1) {
          i = d.auk(paramInt);
        }
        this.afCE = i;
        if (!paramBoolean1) {
          break label202;
        }
        paramInt = Color.argb(51, 0, 0, 0);
      }
      if ((j != this.afCE) || (k != this.afCF))
      {
        super.setWillNotDraw(false);
        jCD();
      }
      AppMethodBeat.o(133813);
      return;
    }
  }
  
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
    private boolean afCO = true;
    a afCP;
    
    private a(MutableContextWrapper paramMutableContextWrapper)
    {
      super();
    }
    
    public static Context nC(Context paramContext)
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
      if (this.afCO)
      {
        if (paramContext == getBaseContext())
        {
          AppMethodBeat.o(133802);
          return;
        }
        ((MutableContextWrapper)getBaseContext()).setBaseContext(paramContext);
        if (this.afCP != null)
        {
          this.afCP.jCG();
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
      public abstract void jCG();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.b
 * JD-Core Version:    0.7.0.1
 */