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
import com.tencent.mm.sdk.platformtools.ad;

public class b
  extends FrameLayout
  implements c.a
{
  protected static final boolean KCP = c.KDc;
  private c KCQ;
  private int KCR;
  private int KCS;
  private boolean KCT;
  private boolean KCU;
  private boolean KCV;
  private final int[] KCW;
  private boolean asc;
  private Activity mActivity;
  private volatile int mFF;
  private Paint mPaint;
  
  public b(Context paramContext)
  {
    super(a.kz(paramContext));
    AppMethodBeat.i(133806);
    this.KCR = 0;
    this.KCS = 0;
    this.KCT = false;
    this.asc = false;
    this.KCU = false;
    this.KCV = false;
    this.KCW = new int[2];
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramContext = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(133806);
      throw paramContext;
    }
    fJX();
    if ((getContext() instanceof a)) {
      ((a)getContext()).KDb = new b.a.a()
      {
        public final void fKb()
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
  
  private void bk(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(211006);
    getLocationInWindow(this.KCW);
    ad.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.asc), Integer.valueOf(this.KCW[0]), Integer.valueOf(this.KCW[1]) });
    if (this.KCW[1] < 0)
    {
      ad.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight: [%d,%d,%d]", new Object[] { Integer.valueOf(this.KCW[0]), Integer.valueOf(this.KCW[1]), Integer.valueOf(paramInt) });
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
    this.mFF = Math.max(0, paramInt - this.KCW[1]);
    if (this.asc)
    {
      this.KCU = true;
      AppMethodBeat.o(211006);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.KCT) {
          continue;
        }
        paramInt = 0;
        setPadding(0, paramInt, 0, 0);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        ad.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight setPadding e=%s", new Object[] { localIllegalStateException.getMessage() });
        continue;
      }
      if (isLayoutRequested()) {
        fJZ();
      }
      AppMethodBeat.o(211006);
      return;
      paramInt = this.mFF;
    }
  }
  
  private void fJX()
  {
    AppMethodBeat.i(133807);
    if (!KCP)
    {
      this.mActivity = null;
      this.mPaint = null;
      AppMethodBeat.o(133807);
      return;
    }
    setPadding(0, 0, 0, 0);
    this.mFF = 0;
    if (this.KCQ != null) {
      this.KCQ.b(this);
    }
    this.mActivity = a.jq(getContext());
    if (this.mActivity == null)
    {
      this.mPaint = null;
      super.setWillNotDraw(true);
      AppMethodBeat.o(133807);
      return;
    }
    c localc = c.bm(this.mActivity);
    this.KCQ = localc;
    localc.a(this);
    this.mPaint = new Paint(0);
    this.mPaint.setStyle(Paint.Style.FILL);
    super.setWillNotDraw(false);
    AppMethodBeat.o(133807);
  }
  
  private void fJY()
  {
    AppMethodBeat.i(175985);
    if (this.KCQ == null)
    {
      AppMethodBeat.o(175985);
      return;
    }
    ua(this.KCQ.KDf);
    AppMethodBeat.o(175985);
  }
  
  private void fJZ()
  {
    AppMethodBeat.i(133809);
    if (fKa())
    {
      invalidate();
      AppMethodBeat.o(133809);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(133809);
  }
  
  private static boolean fKa()
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
    j(paramInt, paramBoolean, true);
    AppMethodBeat.o(133812);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(133814);
    if ((this.mFF <= 0) || (!KCP) || (this.KCT) || (willNotDraw())) {}
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      if ((this.mFF > 0) && (KCP) && (this.KCT) && (!willNotDraw())) {
        break;
      }
      AppMethodBeat.o(133814);
      return;
      if (this.mPaint == null)
      {
        ad.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarBackground NULL paint");
      }
      else
      {
        this.mPaint.setColor(this.KCR);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mFF, this.mPaint);
      }
    }
    if (this.mPaint == null)
    {
      ad.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
      AppMethodBeat.o(133814);
      return;
    }
    this.mPaint.setColor(this.KCS);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mFF, this.mPaint);
    AppMethodBeat.o(133814);
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(175986);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    fJY();
    AppMethodBeat.o(175986);
  }
  
  public int getDrawnStatusBarHeight()
  {
    AppMethodBeat.i(175983);
    int i = Math.max(0, this.mFF);
    AppMethodBeat.o(175983);
    return i;
  }
  
  public final void j(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133813);
    int j = this.KCR;
    int k = this.KCS;
    this.KCR = paramInt;
    if ((!KCP) || (this.mActivity == null))
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
      this.KCR = paramInt;
    }
    label168:
    label202:
    for (;;)
    {
      paramInt = 0;
      for (localObject = this;; localObject = this)
      {
        ((b)localObject).KCS = paramInt;
        label122:
        do
        {
          if ((this.KCR != 0) || (this.KCS != 0)) {
            break label168;
          }
          super.setWillNotDraw(true);
          fJZ();
          AppMethodBeat.o(133813);
          return;
          if (d.fwO()) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 21);
        int i = paramInt;
        if (paramBoolean1) {
          i = d.Xp(paramInt);
        }
        this.KCR = i;
        if (!paramBoolean1) {
          break label202;
        }
        paramInt = Color.argb(51, 0, 0, 0);
      }
      if ((j != this.KCR) || (k != this.KCS))
      {
        super.setWillNotDraw(false);
        fJZ();
      }
      AppMethodBeat.o(133813);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(175987);
    super.onAttachedToWindow();
    fJY();
    AppMethodBeat.o(175987);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(133810);
    if (this.asc)
    {
      this.KCV = true;
      AppMethodBeat.o(133810);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(133810);
  }
  
  public void setLayoutFrozen(final boolean paramBoolean)
  {
    AppMethodBeat.i(133815);
    if (!fKa())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211005);
          b.this.setLayoutFrozen(paramBoolean);
          AppMethodBeat.o(211005);
        }
      });
      AppMethodBeat.o(133815);
      return;
    }
    ad.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.asc), Boolean.valueOf(this.KCV), Boolean.valueOf(this.KCU) });
    if (paramBoolean != this.asc) {}
    for (int i = 1;; i = 0)
    {
      this.asc = paramBoolean;
      if ((i != 0) && (!paramBoolean) && ((this.KCV) || (this.KCU)))
      {
        bk(this.mFF, true);
        this.KCV = false;
        this.KCU = false;
      }
      AppMethodBeat.o(133815);
      return;
    }
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(133811);
    if (!KCP)
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
  
  public void ua(int paramInt)
  {
    AppMethodBeat.i(133804);
    bk(paramInt, true);
    AppMethodBeat.o(133804);
  }
  
  public final boolean willNotDraw()
  {
    AppMethodBeat.i(175984);
    boolean bool = super.willNotDraw();
    AppMethodBeat.o(175984);
    return bool;
  }
  
  public final void yy(boolean paramBoolean)
  {
    AppMethodBeat.i(133805);
    this.KCT = paramBoolean;
    bk(this.mFF, true);
    AppMethodBeat.o(133805);
  }
  
  static final class a
    extends MutableContextWrapper
  {
    private boolean KDa = true;
    a KDb;
    
    private a(MutableContextWrapper paramMutableContextWrapper)
    {
      super();
    }
    
    public static Context kz(Context paramContext)
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
      if (this.KDa)
      {
        if (paramContext == getBaseContext())
        {
          AppMethodBeat.o(133802);
          return;
        }
        ((MutableContextWrapper)getBaseContext()).setBaseContext(paramContext);
        if (this.KDb != null)
        {
          this.KDb.fKb();
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
      public abstract void fKb();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.b
 * JD-Core Version:    0.7.0.1
 */