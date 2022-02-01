package com.tencent.mm.ui.widget.happybubble;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.tencent.mm.ui.ap;

public class b
  extends Dialog
{
  private BubbleLayout HFY;
  private View HFZ;
  private View HGa;
  private int HGb;
  private boolean HGc;
  private a HGd;
  private a[] HGe;
  private a HGf;
  private boolean HGg;
  private int[] HGh;
  private ViewTreeObserver.OnGlobalLayoutListener agI;
  private int lDk;
  private Activity mActivity;
  private boolean mCancelable;
  private int mHeight;
  private int mMargin;
  private int mOffsetX;
  private int mOffsetY;
  private int mWidth;
  
  public b(final Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(143532);
    this.HGd = a.HGo;
    this.HGe = new a[4];
    this.HGg = false;
    this.HGh = new int[2];
    setCancelable(true);
    this.mActivity = ((Activity)paramContext);
    paramContext = getWindow();
    if (paramContext == null)
    {
      AppMethodBeat.o(143532);
      return;
    }
    paramContext = paramContext.getAttributes();
    final int i = c.et(getContext())[0];
    this.lDk = ap.iX(getContext());
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
  
  private boolean ffA()
  {
    a[] arrayOfa = this.HGe;
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
  
  private void ffB()
  {
    AppMethodBeat.i(143535);
    if ((this.HGa == null) || ((this.HGf == null) && (!ffA())))
    {
      AppMethodBeat.o(143535);
      return;
    }
    Object localObject = new int[4];
    localObject[0] = this.HGh[0];
    localObject[1] = this.HGh[1];
    localObject[2] = (c.et(getContext())[0] - this.HGh[0] - this.HGa.getWidth());
    localObject[3] = (c.et(getContext())[1] - this.HGh[1] - this.HGa.getHeight() - this.HFY.getLookLength() - com.tencent.mm.cd.a.fromDPToPix(this.HGa.getContext(), 30));
    int j;
    int i;
    if (ffA())
    {
      this.HFZ.measure(0, 0);
      a[] arrayOfa = this.HGe;
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
        switch (4.HGl[locala.ordinal()])
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
              } while (localObject[0] <= this.HFZ.getMeasuredWidth());
              this.HGd = a.HGn;
              AppMethodBeat.o(143535);
              return;
            } while (localObject[1] <= this.HFZ.getMeasuredHeight());
            this.HGd = a.HGo;
            AppMethodBeat.o(143535);
            return;
          } while (localObject[2] <= this.HFZ.getMeasuredWidth());
          this.HGd = a.HGp;
          AppMethodBeat.o(143535);
          return;
        } while (localObject[3] <= this.HFZ.getMeasuredHeight());
        this.HGd = a.HGq;
        AppMethodBeat.o(143535);
        return;
      }
      this.HGd = this.HGe[0];
      AppMethodBeat.o(143535);
      return;
    }
    if (this.HGf != null) {}
    switch (4.HGm[this.HGf.ordinal()])
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
      for (localObject = a.HGo;; localObject = a.HGq)
      {
        this.HGd = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (localObject[0] > localObject[2]) {}
      for (localObject = a.HGn;; localObject = a.HGp)
      {
        this.HGd = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[0])
      {
        this.HGd = a.HGn;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[1])
      {
        this.HGd = a.HGo;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[2])
      {
        this.HGd = a.HGp;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[3]) {
        this.HGd = a.HGq;
      }
      AppMethodBeat.o(143535);
      return;
    }
  }
  
  private void ffC()
  {
    AppMethodBeat.i(143536);
    switch (4.HGl[this.HGd.ordinal()])
    {
    }
    for (;;)
    {
      this.HFY.ffF();
      AppMethodBeat.o(143536);
      return;
      this.HFY.setLook(BubbleLayout.a.HGI);
      continue;
      this.HFY.setLook(BubbleLayout.a.HGJ);
      continue;
      this.HFY.setLook(BubbleLayout.a.HGG);
      continue;
      this.HFY.setLook(BubbleLayout.a.HGH);
    }
  }
  
  private void ffD()
  {
    AppMethodBeat.i(143538);
    if (this.HGa == null)
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
      localLayoutParams1 = (FrameLayout.LayoutParams)this.HFY.getLayoutParams();
      if ((this.HGd == a.HGo) || (this.HGd == a.HGq))
      {
        localLayoutParams1.leftMargin = this.mMargin;
        localLayoutParams1.rightMargin = this.mMargin;
        this.HFY.setLayoutParams(localLayoutParams1);
      }
    }
    else
    {
      switch (4.HGl[this.HGd.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.HFY.invalidate();
      localWindow.setAttributes(localLayoutParams);
      AppMethodBeat.o(143538);
      return;
      localLayoutParams1.topMargin = this.mMargin;
      localLayoutParams1.bottomMargin = this.mMargin;
      break;
      localLayoutParams.x = (this.HGh[0] + this.HGa.getWidth() / 2 - this.HFY.getWidth() / 2 + this.mOffsetX);
      if ((this.mMargin != 0) && (this.mWidth == -1)) {
        this.HFY.setLookPosition(this.HGh[0] - this.mMargin + this.HGa.getWidth() / 2 - this.HFY.getLookWidth() / 2);
      }
      for (;;)
      {
        if (this.HGd != a.HGq) {
          break label519;
        }
        if (this.HGb != 0) {
          this.mOffsetY = this.HGb;
        }
        localLayoutParams.y = (this.HGh[1] + this.HGa.getHeight() + this.mOffsetY - this.lDk);
        break;
        if (localLayoutParams.x <= 0) {
          this.HFY.setLookPosition(this.HGh[0] + this.HGa.getWidth() / 2 - this.HFY.getLookWidth() / 2);
        } else if (localLayoutParams.x + this.HFY.getWidth() > c.et(getContext())[0]) {
          this.HFY.setLookPosition(this.HGh[0] - (c.et(getContext())[0] - this.HFY.getWidth()) + this.HGa.getWidth() / 2 - this.HFY.getLookWidth() / 2);
        } else {
          this.HFY.setLookPosition(this.HGh[0] - localLayoutParams.x + this.HGa.getWidth() / 2 - this.HFY.getLookWidth() / 2);
        }
      }
      label519:
      if (this.HGb != 0) {
        this.mOffsetY = (-this.HGb);
      }
      localLayoutParams.y = (this.HGh[1] - this.HFY.getHeight() + this.mOffsetY - this.lDk);
      continue;
      localLayoutParams.y = (this.HGh[1] + this.mOffsetY + this.HGa.getHeight() / 2 - this.HFY.getHeight() / 2 - this.lDk);
      if ((this.mMargin != 0) && (this.mHeight == -1)) {
        this.HFY.setLookPosition(this.HGh[1] - this.mMargin + this.HGa.getHeight() / 2 - this.HFY.getLookWidth() / 2 - this.lDk);
      }
      for (;;)
      {
        if (this.HGd != a.HGp) {
          break label887;
        }
        if (this.HGb != 0) {
          this.mOffsetX = this.HGb;
        }
        localLayoutParams.x = (this.HGh[0] + this.HGa.getWidth() + this.mOffsetX);
        break;
        if (localLayoutParams.y <= 0) {
          this.HFY.setLookPosition(this.HGh[1] + this.HGa.getHeight() / 2 - this.HFY.getLookWidth() / 2 - this.lDk);
        } else if (localLayoutParams.y + this.HFY.getHeight() > c.et(getContext())[1]) {
          this.HFY.setLookPosition(this.HGh[1] - (c.et(getContext())[1] - this.HFY.getHeight()) + this.HGa.getHeight() / 2 - this.HFY.getLookWidth() / 2);
        } else {
          this.HFY.setLookPosition(this.HGh[1] - localLayoutParams.y + this.HGa.getHeight() / 2 - this.HFY.getLookWidth() / 2 - this.lDk);
        }
      }
      label887:
      if (this.HGb != 0) {
        this.mOffsetX = (-this.HGb);
      }
      localLayoutParams.x = (this.HGh[0] - this.HFY.getWidth() + this.mOffsetX);
    }
  }
  
  public final <T extends b> T a(BubbleLayout paramBubbleLayout)
  {
    this.HFY = paramBubbleLayout;
    return this;
  }
  
  public final <T extends b> T a(a... paramVarArgs)
  {
    this.HGe = paramVarArgs;
    return this;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(143537);
    if (this.HGc)
    {
      View localView = getCurrentFocus();
      if ((localView instanceof TextView)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
    if ((this.HFY != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.HFY.getViewTreeObserver().removeOnGlobalLayoutListener(this.agI);
    }
    super.dismiss();
    AppMethodBeat.o(143537);
  }
  
  public final <T extends b> T gv(View paramView)
  {
    AppMethodBeat.i(191022);
    this.HGa = paramView;
    this.HGa.getLocationOnScreen(this.HGh);
    if (this.agI != null)
    {
      ffB();
      ffC();
      ffD();
    }
    AppMethodBeat.o(191022);
    return this;
  }
  
  public final <T extends b> T gw(View paramView)
  {
    this.HFZ = paramView;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143534);
    super.onCreate(paramBundle);
    if (this.HFY == null) {
      this.HFY = new BubbleLayout(getContext());
    }
    if (this.HFZ != null) {
      this.HFY.addView(this.HFZ);
    }
    setContentView(this.HFY);
    paramBundle = getWindow();
    if (paramBundle == null)
    {
      AppMethodBeat.o(143534);
      return;
    }
    if (this.HGc) {
      paramBundle.setSoftInputMode(18);
    }
    paramBundle.setLayout(-2, -2);
    ffB();
    ffC();
    this.agI = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      int mew;
      int mex;
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143526);
        if ((this.mew == b.c(b.this).getWidth()) && (this.mex == b.c(b.this).getHeight()))
        {
          AppMethodBeat.o(143526);
          return;
        }
        b.d(b.this);
        this.mew = b.c(b.this).getWidth();
        this.mex = b.c(b.this).getHeight();
        AppMethodBeat.o(143526);
      }
    };
    this.HFY.getViewTreeObserver().addOnGlobalLayoutListener(this.agI);
    this.HFY.setOnClickEdgeListener(new BubbleLayout.b()
    {
      public final void ffE()
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
    if ((this.HGg) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
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
      HGn = new a("LEFT", 0);
      HGo = new a("TOP", 1);
      HGp = new a("RIGHT", 2);
      HGq = new a("BOTTOM", 3);
      HGr = new a[] { HGn, HGo, HGp, HGq };
      AppMethodBeat.o(143531);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.b
 * JD-Core Version:    0.7.0.1
 */