package com.tencent.mm.ui.widget.happybubble;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.au;

public class b
  extends Dialog
{
  private BubbleLayout QPP;
  private View QPQ;
  private Rect QPR;
  private int QPS;
  private boolean QPT;
  private a QPU;
  private a[] QPV;
  private a QPW;
  private boolean QPX;
  private int[] QPY;
  private ViewTreeObserver.OnGlobalLayoutListener ajG;
  private Activity mActivity;
  private boolean mCancelable;
  private int mHeight;
  private int mMargin;
  private int mOffsetX;
  private int mOffsetY;
  private int mStatusBarHeight;
  private int mWidth;
  
  public b(final Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(143532);
    this.QPU = a.QQf;
    this.QPV = new a[4];
    this.QPX = false;
    this.QPY = new int[2];
    setCancelable(true);
    this.mActivity = ((Activity)paramContext);
    paramContext = getWindow();
    if (paramContext == null)
    {
      AppMethodBeat.o(143532);
      return;
    }
    paramContext = paramContext.getAttributes();
    final int i = c.getScreenWH(getContext())[0];
    this.mStatusBarHeight = au.getStatusBarHeight(getContext());
    getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143525);
        if (b.a(b.this))
        {
          if (paramContext.x < 0) {}
          for (float f1 = 0.0F;; f1 = paramContext.x)
          {
            float f2 = f1;
            if (paramAnonymousView.getWidth() + f1 > i) {
              f2 = i - paramAnonymousView.getWidth();
            }
            paramAnonymousMotionEvent.setLocation(f2 + paramAnonymousMotionEvent.getX(), paramContext.y + paramAnonymousMotionEvent.getY());
            b.b(b.this).getWindow().getDecorView().dispatchTouchEvent(paramAnonymousMotionEvent);
            AppMethodBeat.o(143525);
            return true;
          }
        }
        AppMethodBeat.o(143525);
        return false;
      }
    });
    AppMethodBeat.o(143532);
  }
  
  private boolean hbF()
  {
    a[] arrayOfa = this.QPV;
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
  
  private void hbG()
  {
    AppMethodBeat.i(143535);
    if ((this.QPR == null) || ((this.QPW == null) && (!hbF())))
    {
      AppMethodBeat.o(143535);
      return;
    }
    Object localObject = new int[4];
    localObject[0] = this.QPY[0];
    localObject[1] = this.QPY[1];
    localObject[2] = (c.getScreenWH(getContext())[0] - this.QPY[0] - this.QPR.width());
    localObject[3] = (c.getScreenWH(getContext())[1] - this.QPY[1] - this.QPR.height());
    int j;
    int i;
    if (hbF())
    {
      this.QPQ.measure(0, 0);
      a[] arrayOfa = this.QPV;
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
        switch (4.QQc[locala.ordinal()])
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
              } while (localObject[0] <= this.QPQ.getMeasuredWidth());
              this.QPU = a.QQe;
              AppMethodBeat.o(143535);
              return;
            } while (localObject[1] <= this.QPQ.getMeasuredHeight());
            this.QPU = a.QQf;
            AppMethodBeat.o(143535);
            return;
          } while (localObject[2] <= this.QPQ.getMeasuredWidth());
          this.QPU = a.QQg;
          AppMethodBeat.o(143535);
          return;
        } while (localObject[3] <= this.QPQ.getMeasuredHeight());
        this.QPU = a.QQh;
        AppMethodBeat.o(143535);
        return;
      }
      this.QPU = this.QPV[0];
      AppMethodBeat.o(143535);
      return;
    }
    if (this.QPW != null) {}
    switch (4.QQd[this.QPW.ordinal()])
    {
    case 1: 
    default: 
      j = 0;
      i = 0;
      if (j < 4)
      {
        int k = localObject[j];
        if (k <= i) {
          break label564;
        }
        i = k;
      }
      break;
    }
    label564:
    for (;;)
    {
      j += 1;
      break;
      if (localObject[1] > localObject[3]) {}
      for (localObject = a.QQf;; localObject = a.QQh)
      {
        this.QPU = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (localObject[0] > localObject[2]) {}
      for (localObject = a.QQe;; localObject = a.QQg)
      {
        this.QPU = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[0])
      {
        this.QPU = a.QQe;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[1])
      {
        this.QPU = a.QQf;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[2])
      {
        this.QPU = a.QQg;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[3]) {
        this.QPU = a.QQh;
      }
      AppMethodBeat.o(143535);
      return;
    }
  }
  
  private void hbH()
  {
    AppMethodBeat.i(143536);
    switch (4.QQc[this.QPU.ordinal()])
    {
    }
    for (;;)
    {
      this.QPP.hbL();
      AppMethodBeat.o(143536);
      return;
      this.QPP.setLook(BubbleLayout.a.QQz);
      continue;
      this.QPP.setLook(BubbleLayout.a.QQA);
      continue;
      this.QPP.setLook(BubbleLayout.a.QQx);
      continue;
      this.QPP.setLook(BubbleLayout.a.QQy);
    }
  }
  
  private void hbI()
  {
    AppMethodBeat.i(143538);
    if (this.QPR == null)
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
      localLayoutParams1 = (FrameLayout.LayoutParams)this.QPP.getLayoutParams();
      if ((this.QPU == a.QQf) || (this.QPU == a.QQh))
      {
        localLayoutParams1.leftMargin = this.mMargin;
        localLayoutParams1.rightMargin = this.mMargin;
        this.QPP.setLayoutParams(localLayoutParams1);
      }
    }
    else
    {
      switch (4.QQc[this.QPU.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.QPP.invalidate();
      localWindow.setAttributes(localLayoutParams);
      AppMethodBeat.o(143538);
      return;
      localLayoutParams1.topMargin = this.mMargin;
      localLayoutParams1.bottomMargin = this.mMargin;
      break;
      localLayoutParams.x = (this.QPY[0] + this.QPR.width() / 2 - this.QPP.getMeasuredWidth() / 2 + this.mOffsetX);
      if ((this.mMargin != 0) && (this.mWidth == -1)) {
        this.QPP.setLookPosition(this.QPY[0] - this.mMargin + this.QPR.width() / 2 - this.QPP.getLookWidth() / 2);
      }
      for (;;)
      {
        if (this.QPU != a.QQh) {
          break label519;
        }
        if (this.QPS != 0) {
          this.mOffsetY = this.QPS;
        }
        localLayoutParams.y = (this.QPY[1] + this.QPR.height() + this.mOffsetY - this.mStatusBarHeight);
        break;
        if (localLayoutParams.x <= 0) {
          this.QPP.setLookPosition(this.QPY[0] + this.QPR.width() / 2 - this.QPP.getLookWidth() / 2);
        } else if (localLayoutParams.x + this.QPP.getMeasuredWidth() > c.getScreenWH(getContext())[0]) {
          this.QPP.setLookPosition(this.QPY[0] - (c.getScreenWH(getContext())[0] - this.QPP.getMeasuredWidth()) + this.QPR.width() / 2 - this.QPP.getLookWidth() / 2);
        } else {
          this.QPP.setLookPosition(this.QPY[0] - localLayoutParams.x + this.QPR.width() / 2 - this.QPP.getLookWidth() / 2);
        }
      }
      label519:
      if (this.QPS != 0) {
        this.mOffsetY = (-this.QPS);
      }
      localLayoutParams.y = (this.QPY[1] - this.QPP.getMeasuredHeight() + this.mOffsetY - this.mStatusBarHeight);
      continue;
      localLayoutParams.y = (this.QPY[1] + this.mOffsetY + this.QPR.height() / 2 - this.QPP.getMeasuredHeight() / 2 - this.mStatusBarHeight);
      if ((this.mMargin != 0) && (this.mHeight == -1)) {
        this.QPP.setLookPosition(this.QPY[1] - this.mMargin + this.QPR.height() / 2 - this.QPP.getLookWidth() / 2 - this.mStatusBarHeight);
      }
      for (;;)
      {
        if (this.QPU != a.QQg) {
          break label887;
        }
        if (this.QPS != 0) {
          this.mOffsetX = this.QPS;
        }
        localLayoutParams.x = (this.QPY[0] + this.QPR.width() + this.mOffsetX);
        break;
        if (localLayoutParams.y <= 0) {
          this.QPP.setLookPosition(this.QPY[1] + this.QPR.height() / 2 - this.QPP.getLookWidth() / 2 - this.mStatusBarHeight);
        } else if (localLayoutParams.y + this.QPP.getMeasuredHeight() > c.getScreenWH(getContext())[1]) {
          this.QPP.setLookPosition(this.QPY[1] - (c.getScreenWH(getContext())[1] - this.QPP.getMeasuredHeight()) + this.QPR.height() / 2 - this.QPP.getLookWidth() / 2);
        } else {
          this.QPP.setLookPosition(this.QPY[1] - localLayoutParams.y + this.QPR.height() / 2 - this.QPP.getLookWidth() / 2 - this.mStatusBarHeight);
        }
      }
      label887:
      if (this.QPS != 0) {
        this.mOffsetX = (-this.QPS);
      }
      localLayoutParams.x = (this.QPY[0] - this.QPP.getMeasuredWidth() + this.mOffsetX);
    }
  }
  
  private void hbJ()
  {
    AppMethodBeat.i(206157);
    hbG();
    if (this.ajG != null)
    {
      hbH();
      hbI();
    }
    AppMethodBeat.o(206157);
  }
  
  public final <T extends b> T a(BubbleLayout paramBubbleLayout)
  {
    this.QPP = paramBubbleLayout;
    return this;
  }
  
  public final <T extends b> T a(a... paramVarArgs)
  {
    this.QPV = paramVarArgs;
    return this;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(143537);
    if (this.QPT)
    {
      View localView = getCurrentFocus();
      if ((localView instanceof TextView)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
    if ((this.QPP != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.QPP.getViewTreeObserver().removeOnGlobalLayoutListener(this.ajG);
    }
    super.dismiss();
    AppMethodBeat.o(143537);
  }
  
  public final <T extends b> T hw(View paramView)
  {
    AppMethodBeat.i(206156);
    this.QPR = new Rect(0, 0, paramView.getWidth(), paramView.getHeight());
    paramView.getLocationOnScreen(this.QPY);
    hbJ();
    AppMethodBeat.o(206156);
    return this;
  }
  
  @Deprecated
  public final <T extends b> T hx(View paramView)
  {
    this.QPQ = paramView;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143534);
    super.onCreate(paramBundle);
    if (this.QPP == null) {
      this.QPP = new BubbleLayout(getContext());
    }
    if (this.QPQ != null) {
      this.QPP.addView(this.QPQ);
    }
    setContentView(this.QPP);
    paramBundle = getWindow();
    if (paramBundle == null)
    {
      AppMethodBeat.o(143534);
      return;
    }
    if (this.QPT) {
      paramBundle.setSoftInputMode(18);
    }
    paramBundle.setLayout(-2, -2);
    hbG();
    hbH();
    this.QPP.measure(0, 0);
    hbI();
    this.ajG = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      int ovI;
      int ovJ;
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143526);
        if ((this.ovI == b.c(b.this).getMeasuredWidth()) && (this.ovJ == b.c(b.this).getMeasuredHeight()))
        {
          AppMethodBeat.o(143526);
          return;
        }
        b.d(b.this);
        this.ovI = b.c(b.this).getMeasuredWidth();
        this.ovJ = b.c(b.this).getMeasuredHeight();
        AppMethodBeat.o(143526);
      }
    };
    this.QPP.getViewTreeObserver().addOnGlobalLayoutListener(this.ajG);
    this.QPP.setOnClickEdgeListener(new BubbleLayout.b()
    {
      public final void hbK()
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
    if ((this.QPX) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
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
      QQe = new a("LEFT", 0);
      QQf = new a("TOP", 1);
      QQg = new a("RIGHT", 2);
      QQh = new a("BOTTOM", 3);
      QQi = new a[] { QQe, QQf, QQg, QQh };
      AppMethodBeat.o(143531);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.b
 * JD-Core Version:    0.7.0.1
 */