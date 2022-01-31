package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.af;

public class b
  extends FrameLayout
  implements c.a
{
  protected static final boolean Apy = c.ApJ;
  private int ApA;
  private int ApB;
  private boolean ApC;
  private boolean ApD;
  private boolean ApE;
  private c Apz;
  private boolean aih;
  private int iPy;
  private Activity mActivity;
  private Paint mPaint;
  
  public b(Context paramContext)
  {
    super(a.iA(paramContext));
    AppMethodBeat.i(67835);
    this.ApA = 0;
    this.ApB = 0;
    this.ApC = false;
    this.aih = false;
    this.ApD = false;
    this.ApE = false;
    dNr();
    if ((getContext() instanceof a)) {
      ((a)getContext()).ApI = new b.a.a()
      {
        public final void dNt()
        {
          AppMethodBeat.i(141896);
          b.a(b.this);
          AppMethodBeat.o(141896);
        }
      };
    }
    AppMethodBeat.o(67835);
  }
  
  private void QN(int paramInt)
  {
    AppMethodBeat.i(67836);
    ab.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.aih) });
    this.iPy = Math.max(0, paramInt);
    if (this.aih)
    {
      this.ApD = true;
      AppMethodBeat.o(67836);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.ApC) {
          continue;
        }
        paramInt = 0;
        setPadding(0, paramInt, 0, 0);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        ab.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", new Object[] { localIllegalStateException.getMessage() });
        continue;
      }
      dNs();
      AppMethodBeat.o(67836);
      return;
      paramInt = this.iPy;
    }
  }
  
  private void dNr()
  {
    AppMethodBeat.i(141900);
    if (!Apy)
    {
      this.mActivity = null;
      this.mPaint = null;
      AppMethodBeat.o(141900);
      return;
    }
    setPadding(0, 0, 0, 0);
    this.iPy = 0;
    if (this.Apz != null) {
      this.Apz.b(this);
    }
    this.mActivity = a.hr(getContext());
    if (this.mActivity == null)
    {
      this.mPaint = null;
      setWillNotDraw(true);
      AppMethodBeat.o(141900);
      return;
    }
    c localc = c.aH(this.mActivity);
    this.Apz = localc;
    localc.a(this);
    this.mPaint = new Paint(0);
    this.mPaint.setStyle(Paint.Style.FILL);
    setWillNotDraw(false);
    AppMethodBeat.o(141900);
  }
  
  private void dNs()
  {
    AppMethodBeat.i(67837);
    if (al.isMainThread())
    {
      invalidate();
      AppMethodBeat.o(67837);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(67837);
  }
  
  public void K(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(67840);
    a(paramInt, paramBoolean, true);
    AppMethodBeat.o(67840);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(67841);
    int j = this.ApA;
    int k = this.ApB;
    this.ApA = paramInt;
    if ((!Apy) || (this.mActivity == null))
    {
      AppMethodBeat.o(67841);
      return;
    }
    Object localObject = this.mActivity.getWindow();
    d.a((Window)localObject);
    if (paramBoolean2)
    {
      if (!d.a((Window)localObject, paramBoolean1)) {
        break label119;
      }
      this.ApA = paramInt;
    }
    label165:
    label198:
    for (;;)
    {
      paramInt = 0;
      for (localObject = this;; localObject = this)
      {
        ((b)localObject).ApB = paramInt;
        label119:
        do
        {
          if ((this.ApA != 0) || (this.ApB != 0)) {
            break label165;
          }
          setWillNotDraw(true);
          dNs();
          AppMethodBeat.o(67841);
          return;
          if (d.dNu()) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 21);
        int i = paramInt;
        if (paramBoolean1) {
          i = af.Kq(paramInt);
        }
        this.ApA = i;
        if (!paramBoolean1) {
          break label198;
        }
        paramInt = Color.argb(51, 0, 0, 0);
      }
      if ((j != this.ApA) || (k != this.ApB))
      {
        setWillNotDraw(false);
        dNs();
      }
      AppMethodBeat.o(67841);
      return;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(67842);
    if ((this.iPy <= 0) || (!Apy) || (this.ApC) || (willNotDraw())) {}
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      if ((this.iPy > 0) && (Apy) && (this.ApC) && (!willNotDraw())) {
        break;
      }
      AppMethodBeat.o(67842);
      return;
      this.mPaint.setColor(this.ApA);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.iPy, this.mPaint);
    }
    this.mPaint.setColor(this.ApB);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.iPy, this.mPaint);
    AppMethodBeat.o(67842);
  }
  
  public void pB(int paramInt)
  {
    AppMethodBeat.i(67833);
    QN(paramInt);
    AppMethodBeat.o(67833);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(67838);
    if (this.aih)
    {
      this.ApE = true;
      AppMethodBeat.o(67838);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(67838);
  }
  
  public final void rq(boolean paramBoolean)
  {
    AppMethodBeat.i(67834);
    this.ApC = paramBoolean;
    QN(this.iPy);
    AppMethodBeat.o(67834);
  }
  
  public void setLayoutFrozen(final boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(67843);
    if (!al.isMainThread())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(141897);
          b.this.setLayoutFrozen(paramBoolean);
          AppMethodBeat.o(141897);
        }
      });
      AppMethodBeat.o(67843);
      return;
    }
    ab.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.aih), Boolean.valueOf(this.ApE), Boolean.valueOf(this.ApD) });
    if (paramBoolean != this.aih) {}
    for (;;)
    {
      this.aih = paramBoolean;
      if ((i != 0) && (!paramBoolean) && ((this.ApE) || (this.ApD)))
      {
        QN(this.iPy);
        this.ApE = false;
        this.ApD = false;
      }
      AppMethodBeat.o(67843);
      return;
      i = 0;
    }
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(67839);
    if (!Apy)
    {
      AppMethodBeat.o(67839);
      return;
    }
    Activity localActivity = this.mActivity;
    if (localActivity == null) {}
    for (boolean bool = false;; bool = d.b(localActivity.getWindow()))
    {
      K(paramInt, bool);
      AppMethodBeat.o(67839);
      return;
    }
  }
  
  static final class a
    extends MutableContextWrapper
  {
    private boolean ApH = true;
    a ApI;
    
    private a(MutableContextWrapper paramMutableContextWrapper)
    {
      super();
    }
    
    public static Context iA(Context paramContext)
    {
      AppMethodBeat.i(141899);
      if ((paramContext instanceof MutableContextWrapper))
      {
        paramContext = new a((MutableContextWrapper)paramContext);
        AppMethodBeat.o(141899);
        return paramContext;
      }
      AppMethodBeat.o(141899);
      return paramContext;
    }
    
    public final void setBaseContext(Context paramContext)
    {
      AppMethodBeat.i(141898);
      if (this.ApH)
      {
        ((MutableContextWrapper)getBaseContext()).setBaseContext(paramContext);
        if (this.ApI != null)
        {
          this.ApI.dNt();
          AppMethodBeat.o(141898);
        }
      }
      else
      {
        super.setBaseContext(paramContext);
      }
      AppMethodBeat.o(141898);
    }
    
    static abstract interface a
    {
      public abstract void dNt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.b
 * JD-Core Version:    0.7.0.1
 */