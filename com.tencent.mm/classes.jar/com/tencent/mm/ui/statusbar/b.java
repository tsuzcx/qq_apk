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
  protected static final boolean Qoi = c.Qow;
  private c Qoj;
  private int Qok;
  private int Qol;
  private boolean Qom;
  private boolean Qon;
  private boolean Qoo;
  private final int[] Qop;
  private int Qoq;
  private boolean asn;
  private Activity mActivity;
  private Paint mPaint;
  private volatile int mStatusBarHeight;
  
  public b(Context paramContext)
  {
    super(a.kC(paramContext));
    AppMethodBeat.i(133806);
    this.Qok = 0;
    this.Qol = 0;
    this.Qom = false;
    this.asn = false;
    this.Qon = false;
    this.Qoo = false;
    this.Qop = new int[2];
    this.Qoq = 0;
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      paramContext = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(133806);
      throw paramContext;
    }
    bSw();
    if ((getContext() instanceof a)) {
      ((a)getContext()).Qov = new b.a.a()
      {
        public final void gXl()
        {
          AppMethodBeat.i(133800);
          if (Looper.getMainLooper() != Looper.myLooper())
          {
            b.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(175982);
                b.this.bSw();
                AppMethodBeat.o(175982);
              }
            });
            AppMethodBeat.o(133800);
            return;
          }
          b.this.bSw();
          AppMethodBeat.o(133800);
        }
      };
    }
    AppMethodBeat.o(133806);
  }
  
  private void aom(int paramInt)
  {
    AppMethodBeat.i(133808);
    getLocationInWindow(this.Qop);
    this.Qoq = this.Qop[1];
    if (Log.getLogLevel() <= 1) {
      Log.d("MicroMsg.DrawStatusBarFrameLayout", "applyStatusBarHeight height[%d] mFrozen[%b] mLocationInWindow[%d.%d]", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.asn), Integer.valueOf(this.Qop[0]), Integer.valueOf(this.Qop[1]) });
    }
    this.mStatusBarHeight = Math.max(0, paramInt - this.Qop[1]);
    if (this.asn)
    {
      this.Qon = true;
      AppMethodBeat.o(133808);
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.Qom) {
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
        gXj();
      }
      AppMethodBeat.o(133808);
      return;
      paramInt = this.mStatusBarHeight;
    }
  }
  
  private void gXi()
  {
    AppMethodBeat.i(175985);
    if (this.Qoj == null)
    {
      AppMethodBeat.o(175985);
      return;
    }
    yf(this.Qoj.Qoz);
    AppMethodBeat.o(175985);
  }
  
  private void gXj()
  {
    AppMethodBeat.i(133809);
    if (gXk())
    {
      invalidate();
      AppMethodBeat.o(133809);
      return;
    }
    postInvalidate();
    AppMethodBeat.o(133809);
  }
  
  private static boolean gXk()
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
  
  public final void CF(boolean paramBoolean)
  {
    AppMethodBeat.i(133805);
    this.Qom = paramBoolean;
    aom(this.mStatusBarHeight);
    AppMethodBeat.o(133805);
  }
  
  public void S(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133812);
    l(paramInt, paramBoolean, true);
    AppMethodBeat.o(133812);
  }
  
  protected void bSw()
  {
    AppMethodBeat.i(133807);
    if (!Qoi)
    {
      this.mActivity = null;
      this.mPaint = null;
      AppMethodBeat.o(133807);
      return;
    }
    setPadding(0, 0, 0, 0);
    this.mStatusBarHeight = 0;
    if (this.Qoj != null) {
      this.Qoj.b(this);
    }
    this.mActivity = AndroidContextUtil.castActivityOrNull(getContext());
    if (this.mActivity == null)
    {
      this.mPaint = null;
      super.setWillNotDraw(true);
      AppMethodBeat.o(133807);
      return;
    }
    c localc = c.bt(this.mActivity);
    this.Qoj = localc;
    localc.a(this);
    this.mPaint = new Paint(0);
    this.mPaint.setStyle(Paint.Style.FILL);
    super.setWillNotDraw(false);
    AppMethodBeat.o(133807);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(133814);
    if ((this.mStatusBarHeight <= 0) || (!Qoi) || (this.Qom) || (willNotDraw())) {}
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      if ((this.mStatusBarHeight > 0) && (Qoi) && (this.Qom) && (!willNotDraw())) {
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
        this.mPaint.setColor(this.Qok);
        paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mStatusBarHeight, this.mPaint);
      }
    }
    if (this.mPaint == null)
    {
      Log.e("MicroMsg.DrawStatusBarFrameLayout", "drawStatusBarForeground NULL paint");
      AppMethodBeat.o(133814);
      return;
    }
    this.mPaint.setColor(this.Qol);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.mStatusBarHeight, this.mPaint);
    AppMethodBeat.o(133814);
  }
  
  public void dispatchSystemUiVisibilityChanged(int paramInt)
  {
    AppMethodBeat.i(175986);
    super.dispatchSystemUiVisibilityChanged(paramInt);
    gXi();
    AppMethodBeat.o(175986);
  }
  
  public int getDrawnStatusBarHeight()
  {
    AppMethodBeat.i(175983);
    int i = Math.max(0, this.mStatusBarHeight);
    AppMethodBeat.o(175983);
    return i;
  }
  
  public final void l(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133813);
    int j = this.Qok;
    int k = this.Qol;
    this.Qok = paramInt;
    if ((!Qoi) || (this.mActivity == null))
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
      this.Qok = paramInt;
    }
    label168:
    label202:
    for (;;)
    {
      paramInt = 0;
      for (localObject = this;; localObject = this)
      {
        ((b)localObject).Qol = paramInt;
        label122:
        do
        {
          if ((this.Qok != 0) || (this.Qol != 0)) {
            break label168;
          }
          super.setWillNotDraw(true);
          gXj();
          AppMethodBeat.o(133813);
          return;
          if (d.gIJ()) {
            break;
          }
        } while (Build.VERSION.SDK_INT < 21);
        int i = paramInt;
        if (paramBoolean1) {
          i = d.agC(paramInt);
        }
        this.Qok = i;
        if (!paramBoolean1) {
          break label202;
        }
        paramInt = Color.argb(51, 0, 0, 0);
      }
      if ((j != this.Qok) || (k != this.Qol))
      {
        super.setWillNotDraw(false);
        gXj();
      }
      AppMethodBeat.o(133813);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(175987);
    super.onAttachedToWindow();
    gXi();
    AppMethodBeat.o(175987);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196230);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.Qoj != null) && (!this.asn))
    {
      getLocationInWindow(this.Qop);
      if (this.Qoq != this.Qop[1]) {
        this.Qoj.requestApplyInsets();
      }
      this.Qoq = this.Qop[1];
    }
    AppMethodBeat.o(196230);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(133810);
    if (this.asn)
    {
      this.Qoo = true;
      AppMethodBeat.o(133810);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(133810);
  }
  
  public void setLayoutFrozen(final boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(133815);
    if (!gXk())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133801);
          b.this.setLayoutFrozen(paramBoolean);
          AppMethodBeat.o(133801);
        }
      });
      AppMethodBeat.o(133815);
      return;
    }
    Log.d("MicroMsg.DrawStatusBarFrameLayout", "setLayoutFrozen frozen[%b], mFrozen[%b], mDeferLayout[%b], mDeferInvalidate[%b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.asn), Boolean.valueOf(this.Qoo), Boolean.valueOf(this.Qon) });
    if (paramBoolean != this.asn) {}
    for (;;)
    {
      this.asn = paramBoolean;
      if ((i != 0) && (!paramBoolean) && ((this.Qoo) || (this.Qon)))
      {
        aom(this.mStatusBarHeight);
        this.Qoo = false;
        this.Qon = false;
      }
      AppMethodBeat.o(133815);
      return;
      i = 0;
    }
  }
  
  public void setStatusBarColor(int paramInt)
  {
    AppMethodBeat.i(133811);
    if (!Qoi)
    {
      AppMethodBeat.o(133811);
      return;
    }
    Activity localActivity = this.mActivity;
    if (localActivity == null) {}
    for (boolean bool = false;; bool = d.f(localActivity.getWindow()))
    {
      S(paramInt, bool);
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
  
  public void yf(int paramInt)
  {
    AppMethodBeat.i(133804);
    aom(paramInt);
    AppMethodBeat.o(133804);
  }
  
  static final class a
    extends MutableContextWrapper
  {
    private boolean Qou = true;
    a Qov;
    
    private a(MutableContextWrapper paramMutableContextWrapper)
    {
      super();
    }
    
    public static Context kC(Context paramContext)
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
      if (this.Qou)
      {
        if (paramContext == getBaseContext())
        {
          AppMethodBeat.o(133802);
          return;
        }
        ((MutableContextWrapper)getBaseContext()).setBaseContext(paramContext);
        if (this.Qov != null)
        {
          this.Qov.gXl();
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
      public abstract void gXl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.b
 * JD-Core Version:    0.7.0.1
 */