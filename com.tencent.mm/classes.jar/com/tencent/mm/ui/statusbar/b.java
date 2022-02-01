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
  protected static final boolean Hln = c.HlA;
  private c Hlo;
  private int Hlp;
  private int Hlq;
  private boolean Hlr;
  private boolean Hls;
  private boolean Hlt;
  private final int[] Hlu;
  private boolean apo;
  private volatile int lDk;
  private Activity mActivity;
  private Paint mPaint;
  
  public b(Context paramContext)
  {
    super(a.kc(paramContext));
    AppMethodBeat.i(133806);
    this.Hlp = 0;
    this.Hlq = 0;
    this.Hlr = false;
    this.apo = false;
    this.Hls = false;
    this.Hlt = false;
    this.Hlu = new int[2];
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramContext = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(133806);
      throw paramContext;
    }
    fdo();
    if ((getContext() instanceof a)) {
      ((a)getContext()).Hlz = new b.a.a()
      {
        public final void fds()
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
  
  private void aZ(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192570);
    getLocationInWindow(this.Hlu);
    ad.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.apo), Integer.valueOf(this.Hlu[0]), Integer.valueOf(this.Hlu[1]) });
    if (this.Hlu[1] < 0)
    {
      ad.w("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight: [%d,%d,%d]", new Object[] { Integer.valueOf(this.Hlu[0]), Integer.valueOf(this.Hlu[1]), Integer.valueOf(paramInt) });
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
    this.lDk = Math.max(0, paramInt - this.Hlu[1]);
    if (this.apo)
    {
      this.Hls = true;
      AppMethodBeat.o(192570);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.Hlr) {
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
        fdq();
      }
      AppMethodBeat.o(192570);
      return;
      paramInt = this.lDk;
    }
  }
  
  private void fdo()
  {
    AppMethodBeat.i(133807);
    if (!Hln)
    {
      this.mActivity = null;
      this.mPaint = null;
      AppMethodBeat.o(133807);
      return;
    }
    setPadding(0, 0, 0, 0);
    this.lDk = 0;
    if (this.Hlo != null) {
      this.Hlo.b(this);
    }
    this.mActivity = a.iV(getContext());
    if (this.mActivity == null)
    {
      this.mPaint = null;
      super.setWillNotDraw(true);
      AppMethodBeat.o(133807);
      return;
    }
    c localc = c.bj(this.mActivity);
    this.Hlo = localc;
    localc.a(this);
    this.mPaint = new Paint(0);
    this.mPaint.setStyle(Paint.Style.FILL);
    super.setWillNotDraw(false);
    AppMethodBeat.o(133807);
  }
  
  private void fdp()
  {
    AppMethodBeat.i(175985);
    if (this.Hlo == null)
    {
      AppMethodBeat.o(175985);
      return;
    }
    sG(this.Hlo.HlD);
    AppMethodBeat.o(175985);
  }
  
  private void fdq()
  {
    AppMethodBeat.i(133809);
    if (fdr())
    {
      invalidate();
      AppMethodBeat.o(133809);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(133809);
  }
  
  private static boolean fdr()
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
    if ((this.lDk <= 0) || (!Hln) || (this.Hlr) || (willNotDraw())) {}
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      if ((this.lDk > 0) && (Hln) && (this.Hlr) && (!willNotDraw())) {
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
        this.mPaint.setColor(this.Hlp);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.lDk, this.mPaint);
      }
    }
    if (this.mPaint == null)
    {
      ad.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
      AppMethodBeat.o(133814);
      return;
    }
    this.mPaint.setColor(this.Hlq);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.lDk, this.mPaint);
    AppMethodBeat.o(133814);
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(175986);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    fdp();
    AppMethodBeat.o(175986);
  }
  
  public int getDrawnStatusBarHeight()
  {
    AppMethodBeat.i(175983);
    int i = Math.max(0, this.lDk);
    AppMethodBeat.o(175983);
    return i;
  }
  
  public final void h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133813);
    int j = this.Hlp;
    int k = this.Hlq;
    this.Hlp = paramInt;
    if ((!Hln) || (this.mActivity == null))
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
      this.Hlp = paramInt;
    }
    label168:
    label202:
    for (;;)
    {
      paramInt = 0;
      for (localObject = this;; localObject = this)
      {
        ((b)localObject).Hlq = paramInt;
        label122:
        do
        {
          if ((this.Hlp != 0) || (this.Hlq != 0)) {
            break label168;
          }
          super.setWillNotDraw(true);
          fdq();
          AppMethodBeat.o(133813);
          return;
          if (d.eQT()) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 21);
        int i = paramInt;
        if (paramBoolean1) {
          i = d.Ts(paramInt);
        }
        this.Hlp = i;
        if (!paramBoolean1) {
          break label202;
        }
        paramInt = Color.argb(51, 0, 0, 0);
      }
      if ((j != this.Hlp) || (k != this.Hlq))
      {
        super.setWillNotDraw(false);
        fdq();
      }
      AppMethodBeat.o(133813);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(175987);
    super.onAttachedToWindow();
    fdp();
    AppMethodBeat.o(175987);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(133810);
    if (this.apo)
    {
      this.Hlt = true;
      AppMethodBeat.o(133810);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(133810);
  }
  
  public void sG(int paramInt)
  {
    AppMethodBeat.i(133804);
    aZ(paramInt, true);
    AppMethodBeat.o(133804);
  }
  
  public void setLayoutFrozen(final boolean paramBoolean)
  {
    AppMethodBeat.i(133815);
    if (!fdr())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192569);
          b.this.setLayoutFrozen(paramBoolean);
          AppMethodBeat.o(192569);
        }
      });
      AppMethodBeat.o(133815);
      return;
    }
    ad.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.apo), Boolean.valueOf(this.Hlt), Boolean.valueOf(this.Hls) });
    if (paramBoolean != this.apo) {}
    for (int i = 1;; i = 0)
    {
      this.apo = paramBoolean;
      if ((i != 0) && (!paramBoolean) && ((this.Hlt) || (this.Hls)))
      {
        aZ(this.lDk, true);
        this.Hlt = false;
        this.Hls = false;
      }
      AppMethodBeat.o(133815);
      return;
    }
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(133811);
    if (!Hln)
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
  
  public final void wD(boolean paramBoolean)
  {
    AppMethodBeat.i(133805);
    this.Hlr = paramBoolean;
    aZ(this.lDk, true);
    AppMethodBeat.o(133805);
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
    private boolean Hly = true;
    a Hlz;
    
    private a(MutableContextWrapper paramMutableContextWrapper)
    {
      super();
    }
    
    public static Context kc(Context paramContext)
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
      if (this.Hly)
      {
        if (paramContext == getBaseContext())
        {
          AppMethodBeat.o(133802);
          return;
        }
        ((MutableContextWrapper)getBaseContext()).setBaseContext(paramContext);
        if (this.Hlz != null)
        {
          this.Hlz.fds();
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
      public abstract void fds();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.b
 * JD-Core Version:    0.7.0.1
 */