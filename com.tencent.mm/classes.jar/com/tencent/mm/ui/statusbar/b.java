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
import com.tencent.mm.sdk.platformtools.ae;

public class b
  extends FrameLayout
  implements c.a
{
  protected static final boolean KZj = c.KZw;
  private c KZk;
  private int KZl;
  private int KZm;
  private boolean KZn;
  private boolean KZo;
  private boolean KZp;
  private final int[] KZq;
  private boolean asc;
  private Activity mActivity;
  private volatile int mKJ;
  private Paint mPaint;
  
  public b(Context paramContext)
  {
    super(a.kG(paramContext));
    AppMethodBeat.i(133806);
    this.KZl = 0;
    this.KZm = 0;
    this.KZn = false;
    this.asc = false;
    this.KZo = false;
    this.KZp = false;
    this.KZq = new int[2];
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramContext = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(133806);
      throw paramContext;
    }
    fOo();
    if ((getContext() instanceof a)) {
      ((a)getContext()).KZv = new b.a.a()
      {
        public final void fOs()
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
  
  private void bt(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(212317);
    getLocationInWindow(this.KZq);
    ae.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.asc), Integer.valueOf(this.KZq[0]), Integer.valueOf(this.KZq[1]) });
    if (this.KZq[1] < 0)
    {
      ae.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight: [%d,%d,%d]", new Object[] { Integer.valueOf(this.KZq[0]), Integer.valueOf(this.KZq[1]), Integer.valueOf(paramInt) });
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
    this.mKJ = Math.max(0, paramInt - this.KZq[1]);
    if (this.asc)
    {
      this.KZo = true;
      AppMethodBeat.o(212317);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.KZn) {
          continue;
        }
        paramInt = 0;
        setPadding(0, paramInt, 0, 0);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        ae.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", new Object[] { localIllegalStateException.getMessage() });
        continue;
      }
      if (isLayoutRequested()) {
        fOq();
      }
      AppMethodBeat.o(212317);
      return;
      paramInt = this.mKJ;
    }
  }
  
  private void fOo()
  {
    AppMethodBeat.i(133807);
    if (!KZj)
    {
      this.mActivity = null;
      this.mPaint = null;
      AppMethodBeat.o(133807);
      return;
    }
    setPadding(0, 0, 0, 0);
    this.mKJ = 0;
    if (this.KZk != null) {
      this.KZk.b(this);
    }
    this.mActivity = a.jw(getContext());
    if (this.mActivity == null)
    {
      this.mPaint = null;
      super.setWillNotDraw(true);
      AppMethodBeat.o(133807);
      return;
    }
    c localc = c.bn(this.mActivity);
    this.KZk = localc;
    localc.a(this);
    this.mPaint = new Paint(0);
    this.mPaint.setStyle(Paint.Style.FILL);
    super.setWillNotDraw(false);
    AppMethodBeat.o(133807);
  }
  
  private void fOp()
  {
    AppMethodBeat.i(175985);
    if (this.KZk == null)
    {
      AppMethodBeat.o(175985);
      return;
    }
    ug(this.KZk.KZz);
    AppMethodBeat.o(175985);
  }
  
  private void fOq()
  {
    AppMethodBeat.i(133809);
    if (fOr())
    {
      invalidate();
      AppMethodBeat.o(133809);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(133809);
  }
  
  private static boolean fOr()
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
  
  public void M(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133812);
    j(paramInt, paramBoolean, true);
    AppMethodBeat.o(133812);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(133814);
    if ((this.mKJ <= 0) || (!KZj) || (this.KZn) || (willNotDraw())) {}
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      if ((this.mKJ > 0) && (KZj) && (this.KZn) && (!willNotDraw())) {
        break;
      }
      AppMethodBeat.o(133814);
      return;
      if (this.mPaint == null)
      {
        ae.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarBackground NULL paint");
      }
      else
      {
        this.mPaint.setColor(this.KZl);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mKJ, this.mPaint);
      }
    }
    if (this.mPaint == null)
    {
      ae.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
      AppMethodBeat.o(133814);
      return;
    }
    this.mPaint.setColor(this.KZm);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mKJ, this.mPaint);
    AppMethodBeat.o(133814);
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(175986);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    fOp();
    AppMethodBeat.o(175986);
  }
  
  public int getDrawnStatusBarHeight()
  {
    AppMethodBeat.i(175983);
    int i = Math.max(0, this.mKJ);
    AppMethodBeat.o(175983);
    return i;
  }
  
  public final void j(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133813);
    int j = this.KZl;
    int k = this.KZm;
    this.KZl = paramInt;
    if ((!KZj) || (this.mActivity == null))
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
      this.KZl = paramInt;
    }
    label168:
    label202:
    for (;;)
    {
      paramInt = 0;
      for (localObject = this;; localObject = this)
      {
        ((b)localObject).KZm = paramInt;
        label122:
        do
        {
          if ((this.KZl != 0) || (this.KZm != 0)) {
            break label168;
          }
          super.setWillNotDraw(true);
          fOq();
          AppMethodBeat.o(133813);
          return;
          if (d.fAQ()) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 21);
        int i = paramInt;
        if (paramBoolean1) {
          i = d.XV(paramInt);
        }
        this.KZl = i;
        if (!paramBoolean1) {
          break label202;
        }
        paramInt = Color.argb(51, 0, 0, 0);
      }
      if ((j != this.KZl) || (k != this.KZm))
      {
        super.setWillNotDraw(false);
        fOq();
      }
      AppMethodBeat.o(133813);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(175987);
    super.onAttachedToWindow();
    fOp();
    AppMethodBeat.o(175987);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(133810);
    if (this.asc)
    {
      this.KZp = true;
      AppMethodBeat.o(133810);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(133810);
  }
  
  public void setLayoutFrozen(final boolean paramBoolean)
  {
    AppMethodBeat.i(133815);
    if (!fOr())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(212316);
          b.this.setLayoutFrozen(paramBoolean);
          AppMethodBeat.o(212316);
        }
      });
      AppMethodBeat.o(133815);
      return;
    }
    ae.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.asc), Boolean.valueOf(this.KZp), Boolean.valueOf(this.KZo) });
    if (paramBoolean != this.asc) {}
    for (int i = 1;; i = 0)
    {
      this.asc = paramBoolean;
      if ((i != 0) && (!paramBoolean) && ((this.KZp) || (this.KZo)))
      {
        bt(this.mKJ, true);
        this.KZp = false;
        this.KZo = false;
      }
      AppMethodBeat.o(133815);
      return;
    }
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(133811);
    if (!KZj)
    {
      AppMethodBeat.o(133811);
      return;
    }
    Activity localActivity = this.mActivity;
    if (localActivity == null) {}
    for (boolean bool = false;; bool = d.e(localActivity.getWindow()))
    {
      M(paramInt, bool);
      AppMethodBeat.o(133811);
      return;
    }
  }
  
  public final void setWillNotDraw(boolean paramBoolean) {}
  
  public void ug(int paramInt)
  {
    AppMethodBeat.i(133804);
    bt(paramInt, true);
    AppMethodBeat.o(133804);
  }
  
  public final boolean willNotDraw()
  {
    AppMethodBeat.i(175984);
    boolean bool = super.willNotDraw();
    AppMethodBeat.o(175984);
    return bool;
  }
  
  public final void yL(boolean paramBoolean)
  {
    AppMethodBeat.i(133805);
    this.KZn = paramBoolean;
    bt(this.mKJ, true);
    AppMethodBeat.o(133805);
  }
  
  static final class a
    extends MutableContextWrapper
  {
    private boolean KZu = true;
    a KZv;
    
    private a(MutableContextWrapper paramMutableContextWrapper)
    {
      super();
    }
    
    public static Context kG(Context paramContext)
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
      if (this.KZu)
      {
        if (paramContext == getBaseContext())
        {
          AppMethodBeat.o(133802);
          return;
        }
        ((MutableContextWrapper)getBaseContext()).setBaseContext(paramContext);
        if (this.KZv != null)
        {
          this.KZv.fOs();
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
      public abstract void fOs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.b
 * JD-Core Version:    0.7.0.1
 */