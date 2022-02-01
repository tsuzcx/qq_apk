package com.tencent.mm.ui.widget.happybubble;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;

public class b
  extends Dialog
{
  private a JgA;
  private a[] JgB;
  private a JgC;
  private boolean JgD;
  private int[] JgE;
  private BubbleLayout Jgv;
  private View Jgw;
  private View Jgx;
  private int Jgy;
  private boolean Jgz;
  private ViewTreeObserver.OnGlobalLayoutListener ahC;
  private Activity mActivity;
  private boolean mCancelable;
  private int mHeight;
  private int mMargin;
  private int mOffsetX;
  private int mOffsetY;
  private int mWidth;
  private int mfe;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(143532);
    this.JgA = a.JgL;
    this.JgB = new a[4];
    this.JgD = false;
    this.JgE = new int[2];
    setCancelable(true);
    this.mActivity = ((Activity)paramContext);
    paramContext = getWindow();
    if (paramContext == null)
    {
      AppMethodBeat.o(143532);
      return;
    }
    paramContext = paramContext.getAttributes();
    int i = c.eB(getContext())[0];
    this.mfe = ap.ji(getContext());
    getWindow().getDecorView().setOnTouchListener(new b.1(this, paramContext, i));
    AppMethodBeat.o(143532);
  }
  
  private void fvA()
  {
    AppMethodBeat.i(143535);
    if ((this.Jgx == null) || ((this.JgC == null) && (!fvz())))
    {
      AppMethodBeat.o(143535);
      return;
    }
    Object localObject = new int[4];
    localObject[0] = this.JgE[0];
    localObject[1] = this.JgE[1];
    localObject[2] = (c.eB(getContext())[0] - this.JgE[0] - this.Jgx.getWidth());
    localObject[3] = (c.eB(getContext())[1] - this.JgE[1] - this.Jgx.getHeight() - this.Jgv.getLookLength() - com.tencent.mm.cc.a.fromDPToPix(this.Jgx.getContext(), 30));
    int j;
    int i;
    if (fvz())
    {
      this.Jgw.measure(0, 0);
      a[] arrayOfa = this.JgB;
      j = arrayOfa.length;
      i = 0;
      if (i < j)
      {
        a locala = arrayOfa[i];
        if (locala == null)
        {
          AppMethodBeat.o(143535);
          return;
        }
        switch (4.JgI[locala.ordinal()])
        {
        }
        do
        {
          do
          {
            do
            {
              do
              {
                i += 1;
                break;
              } while (localObject[0] <= this.Jgw.getMeasuredWidth());
              this.JgA = a.JgK;
              AppMethodBeat.o(143535);
              return;
            } while (localObject[1] <= this.Jgw.getMeasuredHeight());
            this.JgA = a.JgL;
            AppMethodBeat.o(143535);
            return;
          } while (localObject[2] <= this.Jgw.getMeasuredWidth());
          this.JgA = a.JgM;
          AppMethodBeat.o(143535);
          return;
        } while (localObject[3] <= this.Jgw.getMeasuredHeight());
        this.JgA = a.JgN;
        AppMethodBeat.o(143535);
        return;
      }
      this.JgA = this.JgB[0];
      AppMethodBeat.o(143535);
      return;
    }
    if (this.JgC != null) {}
    switch (4.JgJ[this.JgC.ordinal()])
    {
    case 1: 
    default: 
      j = 0;
      i = 0;
      if (j < 4)
      {
        int k = localObject[j];
        if (k <= i) {
          break label584;
        }
        i = k;
      }
      break;
    }
    label584:
    for (;;)
    {
      j += 1;
      break;
      if (localObject[1] > localObject[3]) {}
      for (localObject = a.JgL;; localObject = a.JgN)
      {
        this.JgA = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (localObject[0] > localObject[2]) {}
      for (localObject = a.JgK;; localObject = a.JgM)
      {
        this.JgA = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[0])
      {
        this.JgA = a.JgK;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[1])
      {
        this.JgA = a.JgL;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[2])
      {
        this.JgA = a.JgM;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[3]) {
        this.JgA = a.JgN;
      }
      AppMethodBeat.o(143535);
      return;
    }
  }
  
  private void fvB()
  {
    AppMethodBeat.i(143536);
    switch (4.JgI[this.JgA.ordinal()])
    {
    }
    for (;;)
    {
      this.Jgv.fvE();
      AppMethodBeat.o(143536);
      return;
      this.Jgv.setLook(BubbleLayout.a.Jhf);
      continue;
      this.Jgv.setLook(BubbleLayout.a.Jhg);
      continue;
      this.Jgv.setLook(BubbleLayout.a.Jhd);
      continue;
      this.Jgv.setLook(BubbleLayout.a.Jhe);
    }
  }
  
  private void fvC()
  {
    AppMethodBeat.i(143538);
    if (this.Jgx == null)
    {
      AppMethodBeat.o(143538);
      return;
    }
    Window localWindow = getWindow();
    if (localWindow == null)
    {
      AppMethodBeat.o(143538);
      return;
    }
    localWindow.setGravity(51);
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (this.mWidth != 0) {
      localLayoutParams.width = this.mWidth;
    }
    if (this.mHeight != 0) {
      localLayoutParams.height = this.mHeight;
    }
    FrameLayout.LayoutParams localLayoutParams1;
    if (this.mMargin != 0)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.Jgv.getLayoutParams();
      if ((this.JgA == a.JgL) || (this.JgA == a.JgN))
      {
        localLayoutParams1.leftMargin = this.mMargin;
        localLayoutParams1.rightMargin = this.mMargin;
        this.Jgv.setLayoutParams(localLayoutParams1);
      }
    }
    else
    {
      switch (4.JgI[this.JgA.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.Jgv.invalidate();
      localWindow.setAttributes(localLayoutParams);
      AppMethodBeat.o(143538);
      return;
      localLayoutParams1.topMargin = this.mMargin;
      localLayoutParams1.bottomMargin = this.mMargin;
      break;
      localLayoutParams.x = (this.JgE[0] + this.Jgx.getWidth() / 2 - this.Jgv.getWidth() / 2 + this.mOffsetX);
      if ((this.mMargin != 0) && (this.mWidth == -1)) {
        this.Jgv.setLookPosition(this.JgE[0] - this.mMargin + this.Jgx.getWidth() / 2 - this.Jgv.getLookWidth() / 2);
      }
      for (;;)
      {
        if (this.JgA != a.JgN) {
          break label519;
        }
        if (this.Jgy != 0) {
          this.mOffsetY = this.Jgy;
        }
        localLayoutParams.y = (this.JgE[1] + this.Jgx.getHeight() + this.mOffsetY - this.mfe);
        break;
        if (localLayoutParams.x <= 0) {
          this.Jgv.setLookPosition(this.JgE[0] + this.Jgx.getWidth() / 2 - this.Jgv.getLookWidth() / 2);
        } else if (localLayoutParams.x + this.Jgv.getWidth() > c.eB(getContext())[0]) {
          this.Jgv.setLookPosition(this.JgE[0] - (c.eB(getContext())[0] - this.Jgv.getWidth()) + this.Jgx.getWidth() / 2 - this.Jgv.getLookWidth() / 2);
        } else {
          this.Jgv.setLookPosition(this.JgE[0] - localLayoutParams.x + this.Jgx.getWidth() / 2 - this.Jgv.getLookWidth() / 2);
        }
      }
      label519:
      if (this.Jgy != 0) {
        this.mOffsetY = (-this.Jgy);
      }
      localLayoutParams.y = (this.JgE[1] - this.Jgv.getHeight() + this.mOffsetY - this.mfe);
      continue;
      localLayoutParams.y = (this.JgE[1] + this.mOffsetY + this.Jgx.getHeight() / 2 - this.Jgv.getHeight() / 2 - this.mfe);
      if ((this.mMargin != 0) && (this.mHeight == -1)) {
        this.Jgv.setLookPosition(this.JgE[1] - this.mMargin + this.Jgx.getHeight() / 2 - this.Jgv.getLookWidth() / 2 - this.mfe);
      }
      for (;;)
      {
        if (this.JgA != a.JgM) {
          break label887;
        }
        if (this.Jgy != 0) {
          this.mOffsetX = this.Jgy;
        }
        localLayoutParams.x = (this.JgE[0] + this.Jgx.getWidth() + this.mOffsetX);
        break;
        if (localLayoutParams.y <= 0) {
          this.Jgv.setLookPosition(this.JgE[1] + this.Jgx.getHeight() / 2 - this.Jgv.getLookWidth() / 2 - this.mfe);
        } else if (localLayoutParams.y + this.Jgv.getHeight() > c.eB(getContext())[1]) {
          this.Jgv.setLookPosition(this.JgE[1] - (c.eB(getContext())[1] - this.Jgv.getHeight()) + this.Jgx.getHeight() / 2 - this.Jgv.getLookWidth() / 2);
        } else {
          this.Jgv.setLookPosition(this.JgE[1] - localLayoutParams.y + this.Jgx.getHeight() / 2 - this.Jgv.getLookWidth() / 2 - this.mfe);
        }
      }
      label887:
      if (this.Jgy != 0) {
        this.mOffsetX = (-this.Jgy);
      }
      localLayoutParams.x = (this.JgE[0] - this.Jgv.getWidth() + this.mOffsetX);
    }
  }
  
  private boolean fvz()
  {
    a[] arrayOfa = this.JgB;
    int m = arrayOfa.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfa[i] != null) {
        k = j + 1;
      }
      i += 1;
    }
    return j > 0;
  }
  
  public final <T extends b> T a(BubbleLayout paramBubbleLayout)
  {
    this.Jgv = paramBubbleLayout;
    return this;
  }
  
  public final <T extends b> T a(a... paramVarArgs)
  {
    this.JgB = paramVarArgs;
    return this;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(143537);
    if (this.Jgz)
    {
      View localView = getCurrentFocus();
      if ((localView instanceof TextView)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
    if ((this.Jgv != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.Jgv.getViewTreeObserver().removeOnGlobalLayoutListener(this.ahC);
    }
    super.dismiss();
    AppMethodBeat.o(143537);
  }
  
  public final <T extends b> T gL(View paramView)
  {
    AppMethodBeat.i(197235);
    this.Jgx = paramView;
    this.Jgx.getLocationOnScreen(this.JgE);
    if (this.ahC != null)
    {
      fvA();
      fvB();
      fvC();
    }
    AppMethodBeat.o(197235);
    return this;
  }
  
  public final <T extends b> T gM(View paramView)
  {
    this.Jgw = paramView;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143534);
    super.onCreate(paramBundle);
    if (this.Jgv == null) {
      this.Jgv = new BubbleLayout(getContext());
    }
    if (this.Jgw != null) {
      this.Jgv.addView(this.Jgw);
    }
    setContentView(this.Jgv);
    paramBundle = getWindow();
    if (paramBundle == null)
    {
      AppMethodBeat.o(143534);
      return;
    }
    if (this.Jgz) {
      paramBundle.setSoftInputMode(18);
    }
    paramBundle.setLayout(-2, -2);
    fvA();
    fvB();
    this.ahC = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      int mGv;
      int mGw;
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143526);
        if ((this.mGv == b.c(b.this).getWidth()) && (this.mGw == b.c(b.this).getHeight()))
        {
          AppMethodBeat.o(143526);
          return;
        }
        b.d(b.this);
        this.mGv = b.c(b.this).getWidth();
        this.mGw = b.c(b.this).getHeight();
        AppMethodBeat.o(143526);
      }
    };
    this.Jgv.getViewTreeObserver().addOnGlobalLayoutListener(this.ahC);
    this.Jgv.setOnClickEdgeListener(new BubbleLayout.b()
    {
      public final void fvD()
      {
        AppMethodBeat.i(143527);
        if (b.e(b.this)) {
          b.this.dismiss();
        }
        AppMethodBeat.o(143527);
      }
    });
    AppMethodBeat.o(143534);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(143533);
    if ((this.JgD) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      dismiss();
      this.mActivity.onBackPressed();
      this.mActivity = null;
      AppMethodBeat.o(143533);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(143533);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143539);
    Object localObject = getWindow();
    if (localObject == null)
    {
      AppMethodBeat.o(143539);
      return false;
    }
    localObject = ((Window)localObject).getDecorView();
    if ((this.mCancelable) && (isShowing()))
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((i <= 0) || (j <= 0) || (i > ((View)localObject).getWidth()) || (j > ((View)localObject).getHeight())) {}
      for (i = 1; i != 0; i = 0)
      {
        cancel();
        AppMethodBeat.o(143539);
        return true;
      }
    }
    AppMethodBeat.o(143539);
    return false;
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(143540);
    super.setCancelable(paramBoolean);
    this.mCancelable = paramBoolean;
    AppMethodBeat.o(143540);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(143531);
      JgK = new a("LEFT", 0);
      JgL = new a("TOP", 1);
      JgM = new a("RIGHT", 2);
      JgN = new a("BOTTOM", 3);
      JgO = new a[] { JgK, JgL, JgM, JgN };
      AppMethodBeat.o(143531);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.b
 * JD-Core Version:    0.7.0.1
 */