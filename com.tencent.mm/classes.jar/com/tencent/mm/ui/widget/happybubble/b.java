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
import com.tencent.mm.ah.a.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;

public class b
  extends Dialog
{
  private int Bw;
  private int CL;
  private int CM;
  private BubbleLayout YoA;
  private View YoB;
  private Rect YoC;
  private int YoD;
  private boolean YoE;
  private b.a YoF;
  private b.a[] YoG;
  private a YoH;
  private boolean YoI;
  private int[] YoJ;
  private Activity mActivity;
  private boolean mCancelable;
  private int mHeight;
  private int mStatusBarHeight;
  private int mWidth;
  private ViewTreeObserver.OnGlobalLayoutListener qc;
  
  public b(final Context paramContext)
  {
    super(paramContext, a.l.mmalertdialog);
    AppMethodBeat.i(143532);
    this.YoF = b.a.YoQ;
    this.YoG = new b.a[4];
    this.YoI = false;
    this.YoJ = new int[2];
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
    this.mStatusBarHeight = ax.getStatusBarHeight(getContext());
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
  
  private boolean icM()
  {
    b.a[] arrayOfa = this.YoG;
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
  
  private void icN()
  {
    AppMethodBeat.i(143535);
    if ((this.YoC == null) || ((this.YoH == null) && (!icM())))
    {
      AppMethodBeat.o(143535);
      return;
    }
    Object localObject = new int[4];
    localObject[0] = this.YoJ[0];
    localObject[1] = this.YoJ[1];
    localObject[2] = (c.getScreenWH(getContext())[0] - this.YoJ[0] - this.YoC.width());
    localObject[3] = (c.getScreenWH(getContext())[1] - this.YoJ[1] - this.YoC.height());
    int j;
    int i;
    if (icM())
    {
      this.YoB.measure(0, 0);
      b.a[] arrayOfa = this.YoG;
      j = arrayOfa.length;
      i = 0;
      if (i < j)
      {
        b.a locala = arrayOfa[i];
        if (locala == null)
        {
          AppMethodBeat.o(143535);
          return;
        }
        switch (b.4.YoN[locala.ordinal()])
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
              } while (localObject[0] <= this.YoB.getMeasuredWidth());
              this.YoF = b.a.YoP;
              AppMethodBeat.o(143535);
              return;
            } while (localObject[1] <= this.YoB.getMeasuredHeight());
            this.YoF = b.a.YoQ;
            AppMethodBeat.o(143535);
            return;
          } while (localObject[2] <= this.YoB.getMeasuredWidth());
          this.YoF = b.a.YoR;
          AppMethodBeat.o(143535);
          return;
        } while (localObject[3] <= this.YoB.getMeasuredHeight());
        this.YoF = b.a.YoS;
        AppMethodBeat.o(143535);
        return;
      }
      this.YoF = this.YoG[0];
      AppMethodBeat.o(143535);
      return;
    }
    if (this.YoH != null) {}
    switch (b.4.YoO[this.YoH.ordinal()])
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
      for (localObject = b.a.YoQ;; localObject = b.a.YoS)
      {
        this.YoF = ((b.a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (localObject[0] > localObject[2]) {}
      for (localObject = b.a.YoP;; localObject = b.a.YoR)
      {
        this.YoF = ((b.a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[0])
      {
        this.YoF = b.a.YoP;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[1])
      {
        this.YoF = b.a.YoQ;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[2])
      {
        this.YoF = b.a.YoR;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[3]) {
        this.YoF = b.a.YoS;
      }
      AppMethodBeat.o(143535);
      return;
    }
  }
  
  private void icO()
  {
    AppMethodBeat.i(143536);
    switch (b.4.YoN[this.YoF.ordinal()])
    {
    }
    for (;;)
    {
      this.YoA.icS();
      AppMethodBeat.o(143536);
      return;
      this.YoA.setLook(BubbleLayout.a.Ypk);
      continue;
      this.YoA.setLook(BubbleLayout.a.Ypl);
      continue;
      this.YoA.setLook(BubbleLayout.a.Ypi);
      continue;
      this.YoA.setLook(BubbleLayout.a.Ypj);
    }
  }
  
  private void icP()
  {
    AppMethodBeat.i(143538);
    if (this.YoC == null)
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
    if (this.Bw != 0)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.YoA.getLayoutParams();
      if ((this.YoF == b.a.YoQ) || (this.YoF == b.a.YoS))
      {
        localLayoutParams1.leftMargin = this.Bw;
        localLayoutParams1.rightMargin = this.Bw;
        this.YoA.setLayoutParams(localLayoutParams1);
      }
    }
    else
    {
      switch (b.4.YoN[this.YoF.ordinal()])
      {
      default: 
        label180:
        if (k.avQ()) {
          if ((this.mActivity == null) || (!d.qV(24)) || (!this.mActivity.isInMultiWindowMode())) {
            break label991;
          }
        }
        break;
      }
    }
    label581:
    label991:
    for (int i = 1;; i = 0)
    {
      if ((ar.hIH()) || (i != 0)) {
        localLayoutParams.y += this.mStatusBarHeight;
      }
      this.YoA.invalidate();
      localWindow.setAttributes(localLayoutParams);
      AppMethodBeat.o(143538);
      return;
      localLayoutParams1.topMargin = this.Bw;
      localLayoutParams1.bottomMargin = this.Bw;
      break;
      localLayoutParams.x = (this.YoJ[0] + this.YoC.width() / 2 - this.YoA.getMeasuredWidth() / 2 + this.CL);
      if ((this.Bw != 0) && (this.mWidth == -1)) {
        this.YoA.setLookPosition(this.YoJ[0] - this.Bw + this.YoC.width() / 2 - this.YoA.getLookWidth() / 2);
      }
      for (;;)
      {
        if (this.YoF != b.a.YoS) {
          break label581;
        }
        if (this.YoD != 0) {
          this.CM = this.YoD;
        }
        localLayoutParams.y = (this.YoJ[1] + this.YoC.height() + this.CM - this.mStatusBarHeight);
        break;
        if (localLayoutParams.x <= 0) {
          this.YoA.setLookPosition(this.YoJ[0] + this.YoC.width() / 2 - this.YoA.getLookWidth() / 2);
        } else if (localLayoutParams.x + this.YoA.getMeasuredWidth() > c.getScreenWH(getContext())[0]) {
          this.YoA.setLookPosition(this.YoJ[0] - (c.getScreenWH(getContext())[0] - this.YoA.getMeasuredWidth()) + this.YoC.width() / 2 - this.YoA.getLookWidth() / 2);
        } else {
          this.YoA.setLookPosition(this.YoJ[0] - localLayoutParams.x + this.YoC.width() / 2 - this.YoA.getLookWidth() / 2);
        }
      }
      if (this.YoD != 0) {
        this.CM = (-this.YoD);
      }
      localLayoutParams.y = (this.YoJ[1] - this.YoA.getMeasuredHeight() + this.CM - this.mStatusBarHeight);
      break label180;
      localLayoutParams.y = (this.YoJ[1] + this.CM + this.YoC.height() / 2 - this.YoA.getMeasuredHeight() / 2 - this.mStatusBarHeight);
      if ((this.Bw != 0) && (this.mHeight == -1)) {
        this.YoA.setLookPosition(this.YoJ[1] - this.Bw + this.YoC.height() / 2 - this.YoA.getLookWidth() / 2 - this.mStatusBarHeight);
      }
      for (;;)
      {
        if (this.YoF != b.a.YoR) {
          break label949;
        }
        if (this.YoD != 0) {
          this.CL = this.YoD;
        }
        localLayoutParams.x = (this.YoJ[0] + this.YoC.width() + this.CL);
        break;
        if (localLayoutParams.y <= 0) {
          this.YoA.setLookPosition(this.YoJ[1] + this.YoC.height() / 2 - this.YoA.getLookWidth() / 2 - this.mStatusBarHeight);
        } else if (localLayoutParams.y + this.YoA.getMeasuredHeight() > c.getScreenWH(getContext())[1]) {
          this.YoA.setLookPosition(this.YoJ[1] - (c.getScreenWH(getContext())[1] - this.YoA.getMeasuredHeight()) + this.YoC.height() / 2 - this.YoA.getLookWidth() / 2);
        } else {
          this.YoA.setLookPosition(this.YoJ[1] - localLayoutParams.y + this.YoC.height() / 2 - this.YoA.getLookWidth() / 2 - this.mStatusBarHeight);
        }
      }
      if (this.YoD != 0) {
        this.CL = (-this.YoD);
      }
      localLayoutParams.x = (this.YoJ[0] - this.YoA.getMeasuredWidth() + this.CL);
      break label180;
    }
  }
  
  private void icQ()
  {
    AppMethodBeat.i(216004);
    icN();
    if (this.qc != null)
    {
      icO();
      icP();
    }
    AppMethodBeat.o(216004);
  }
  
  public final <T extends b> T a(BubbleLayout paramBubbleLayout)
  {
    this.YoA = paramBubbleLayout;
    return this;
  }
  
  public final <T extends b> T a(b.a... paramVarArgs)
  {
    this.YoG = paramVarArgs;
    return this;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(143537);
    if (this.YoE)
    {
      View localView = getCurrentFocus();
      if ((localView instanceof TextView)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
    if ((this.YoA != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.YoA.getViewTreeObserver().removeOnGlobalLayoutListener(this.qc);
    }
    super.dismiss();
    AppMethodBeat.o(143537);
  }
  
  public final <T extends b> T iM(View paramView)
  {
    AppMethodBeat.i(216003);
    this.YoC = new Rect(0, 0, paramView.getWidth(), paramView.getHeight());
    paramView.getLocationInWindow(this.YoJ);
    icQ();
    AppMethodBeat.o(216003);
    return this;
  }
  
  @Deprecated
  public final <T extends b> T iN(View paramView)
  {
    this.YoB = paramView;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143534);
    super.onCreate(paramBundle);
    if (this.YoA == null) {
      this.YoA = new BubbleLayout(getContext());
    }
    if (this.YoB != null) {
      this.YoA.addView(this.YoB);
    }
    setContentView(this.YoA);
    paramBundle = getWindow();
    if (paramBundle == null)
    {
      AppMethodBeat.o(143534);
      return;
    }
    if (this.YoE) {
      paramBundle.setSoftInputMode(18);
    }
    paramBundle.setLayout(-2, -2);
    icN();
    icO();
    this.YoA.measure(0, 0);
    icP();
    this.qc = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      int ryu;
      int ryv;
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143526);
        if ((this.ryu == b.c(b.this).getMeasuredWidth()) && (this.ryv == b.c(b.this).getMeasuredHeight()))
        {
          AppMethodBeat.o(143526);
          return;
        }
        b.d(b.this);
        this.ryu = b.c(b.this).getMeasuredWidth();
        this.ryv = b.c(b.this).getMeasuredHeight();
        AppMethodBeat.o(143526);
      }
    };
    this.YoA.getViewTreeObserver().addOnGlobalLayoutListener(this.qc);
    this.YoA.setOnClickEdgeListener(new BubbleLayout.b()
    {
      public final void icR()
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
    if ((this.YoI) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.b
 * JD-Core Version:    0.7.0.1
 */