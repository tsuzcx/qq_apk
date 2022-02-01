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
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ac;

public class b
  extends FrameLayout
  implements c.a
{
  protected static final boolean ILI = c.ILV;
  private c ILJ;
  private int ILK;
  private int ILL;
  private boolean ILM;
  private boolean ILN;
  private boolean ILO;
  private final int[] ILP;
  private boolean aqk;
  private Activity mActivity;
  private Paint mPaint;
  private volatile int mfe;
  
  public b(Context paramContext)
  {
    super(a.kn(paramContext));
    AppMethodBeat.i(133806);
    this.ILK = 0;
    this.ILL = 0;
    this.ILM = false;
    this.aqk = false;
    this.ILN = false;
    this.ILO = false;
    this.ILP = new int[2];
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramContext = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(133806);
      throw paramContext;
    }
    ftj();
    if ((getContext() instanceof a)) {
      ((a)getContext()).ILU = new b.a.a()
      {
        public final void ftn()
        {
          AppMethodBeat.i(133800);
          if (Looper.getMainLooper() != Looper.myLooper())
          {
            b.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(175982);
                b.a(b.this);
                AppMethodBeat.o(175982);
              }
            });
            AppMethodBeat.o(133800);
            return;
          }
          b.a(b.this);
          AppMethodBeat.o(133800);
        }
      };
    }
    AppMethodBeat.o(133806);
  }
  
  private void bd(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(205121);
    getLocationInWindow(this.ILP);
    ac.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.aqk), Integer.valueOf(this.ILP[0]), Integer.valueOf(this.ILP[1]) });
    if (this.ILP[1] < 0)
    {
      ac.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight: [%d,%d,%d]", new Object[] { Integer.valueOf(this.ILP[0]), Integer.valueOf(this.ILP[1]), Integer.valueOf(paramInt) });
      if (paramBoolean) {
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(133801);
            b.a(b.this, paramInt);
            AppMethodBeat.o(133801);
          }
        });
      }
    }
    this.mfe = Math.max(0, paramInt - this.ILP[1]);
    if (this.aqk)
    {
      this.ILN = true;
      AppMethodBeat.o(205121);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.ILM) {
          continue;
        }
        paramInt = 0;
        setPadding(0, paramInt, 0, 0);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        ac.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", new Object[] { localIllegalStateException.getMessage() });
        continue;
      }
      if (isLayoutRequested()) {
        ftl();
      }
      AppMethodBeat.o(205121);
      return;
      paramInt = this.mfe;
    }
  }
  
  private void ftj()
  {
    AppMethodBeat.i(133807);
    if (!ILI)
    {
      this.mActivity = null;
      this.mPaint = null;
      AppMethodBeat.o(133807);
      return;
    }
    setPadding(0, 0, 0, 0);
    this.mfe = 0;
    if (this.ILJ != null) {
      this.ILJ.b(this);
    }
    this.mActivity = a.jg(getContext());
    if (this.mActivity == null)
    {
      this.mPaint = null;
      super.setWillNotDraw(true);
      AppMethodBeat.o(133807);
      return;
    }
    c localc = c.bm(this.mActivity);
    this.ILJ = localc;
    localc.a(this);
    this.mPaint = new Paint(0);
    this.mPaint.setStyle(Paint.Style.FILL);
    super.setWillNotDraw(false);
    AppMethodBeat.o(133807);
  }
  
  private void ftk()
  {
    AppMethodBeat.i(175985);
    if (this.ILJ == null)
    {
      AppMethodBeat.o(175985);
      return;
    }
    tx(this.ILJ.ILY);
    AppMethodBeat.o(175985);
  }
  
  private void ftl()
  {
    AppMethodBeat.i(133809);
    if (ftm())
    {
      invalidate();
      AppMethodBeat.o(133809);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(133809);
  }
  
  private static boolean ftm()
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
  
  public void L(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133812);
    h(paramInt, paramBoolean, true);
    AppMethodBeat.o(133812);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(133814);
    if ((this.mfe <= 0) || (!ILI) || (this.ILM) || (willNotDraw())) {}
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      if ((this.mfe > 0) && (ILI) && (this.ILM) && (!willNotDraw())) {
        break;
      }
      AppMethodBeat.o(133814);
      return;
      if (this.mPaint == null)
      {
        ac.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarBackground NULL paint");
      }
      else
      {
        this.mPaint.setColor(this.ILK);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mfe, this.mPaint);
      }
    }
    if (this.mPaint == null)
    {
      ac.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
      AppMethodBeat.o(133814);
      return;
    }
    this.mPaint.setColor(this.ILL);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mfe, this.mPaint);
    AppMethodBeat.o(133814);
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(175986);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    ftk();
    AppMethodBeat.o(175986);
  }
  
  public int getDrawnStatusBarHeight()
  {
    AppMethodBeat.i(175983);
    int i = Math.max(0, this.mfe);
    AppMethodBeat.o(175983);
    return i;
  }
  
  public final void h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133813);
    int j = this.ILK;
    int k = this.ILL;
    this.ILK = paramInt;
    if ((!ILI) || (this.mActivity == null))
    {
      AppMethodBeat.o(133813);
      return;
    }
    Object localObject = this.mActivity.getWindow();
    d.b((Window)localObject);
    if (paramBoolean2)
    {
      if (!d.c((Window)localObject, paramBoolean1)) {
        break label122;
      }
      this.ILK = paramInt;
    }
    label168:
    label202:
    for (;;)
    {
      paramInt = 0;
      for (localObject = this;; localObject = this)
      {
        ((b)localObject).ILL = paramInt;
        label122:
        do
        {
          if ((this.ILK != 0) || (this.ILL != 0)) {
            break label168;
          }
          super.setWillNotDraw(true);
          ftl();
          AppMethodBeat.o(133813);
          return;
          if (d.fgC()) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 21);
        int i = paramInt;
        if (paramBoolean1) {
          i = d.VA(paramInt);
        }
        this.ILK = i;
        if (!paramBoolean1) {
          break label202;
        }
        paramInt = Color.argb(51, 0, 0, 0);
      }
      if ((j != this.ILK) || (k != this.ILL))
      {
        super.setWillNotDraw(false);
        ftl();
      }
      AppMethodBeat.o(133813);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(175987);
    super.onAttachedToWindow();
    ftk();
    AppMethodBeat.o(175987);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(133810);
    if (this.aqk)
    {
      this.ILO = true;
      AppMethodBeat.o(133810);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(133810);
  }
  
  public void setLayoutFrozen(final boolean paramBoolean)
  {
    AppMethodBeat.i(133815);
    if (!ftm())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(205120);
          b.this.setLayoutFrozen(paramBoolean);
          AppMethodBeat.o(205120);
        }
      });
      AppMethodBeat.o(133815);
      return;
    }
    ac.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aqk), Boolean.valueOf(this.ILO), Boolean.valueOf(this.ILN) });
    if (paramBoolean != this.aqk) {}
    for (int i = 1;; i = 0)
    {
      this.aqk = paramBoolean;
      if ((i != 0) && (!paramBoolean) && ((this.ILO) || (this.ILN)))
      {
        bd(this.mfe, true);
        this.ILO = false;
        this.ILN = false;
      }
      AppMethodBeat.o(133815);
      return;
    }
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(133811);
    if (!ILI)
    {
      AppMethodBeat.o(133811);
      return;
    }
    Activity localActivity = this.mActivity;
    if (localActivity == null) {}
    for (boolean bool = false;; bool = d.e(localActivity.getWindow()))
    {
      L(paramInt, bool);
      AppMethodBeat.o(133811);
      return;
    }
  }
  
  public final void setWillNotDraw(boolean paramBoolean) {}
  
  public void tx(int paramInt)
  {
    AppMethodBeat.i(133804);
    bd(paramInt, true);
    AppMethodBeat.o(133804);
  }
  
  public final boolean willNotDraw()
  {
    AppMethodBeat.i(175984);
    boolean bool = super.willNotDraw();
    AppMethodBeat.o(175984);
    return bool;
  }
  
  public final void xK(boolean paramBoolean)
  {
    AppMethodBeat.i(133805);
    this.ILM = paramBoolean;
    bd(this.mfe, true);
    AppMethodBeat.o(133805);
  }
  
  static final class a
    extends MutableContextWrapper
  {
    private boolean ILT = true;
    a ILU;
    
    private a(MutableContextWrapper paramMutableContextWrapper)
    {
      super();
    }
    
    public static Context kn(Context paramContext)
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
      if (this.ILT)
      {
        if (paramContext == getBaseContext())
        {
          AppMethodBeat.o(133802);
          return;
        }
        ((MutableContextWrapper)getBaseContext()).setBaseContext(paramContext);
        if (this.ILU != null)
        {
          this.ILU.ftn();
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
      public abstract void ftn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.b
 * JD-Core Version:    0.7.0.1
 */