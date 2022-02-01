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
import com.tencent.mm.ui.ar;

public class b
  extends Dialog
{
  private BubbleLayout KXJ;
  private View KXK;
  private View KXL;
  private int KXM;
  private boolean KXN;
  private a KXO;
  private a[] KXP;
  private a KXQ;
  private boolean KXR;
  private int[] KXS;
  private ViewTreeObserver.OnGlobalLayoutListener ajt;
  private Activity mActivity;
  private boolean mCancelable;
  private int mFF;
  private int mHeight;
  private int mMargin;
  private int mOffsetX;
  private int mOffsetY;
  private int mWidth;
  
  public b(final Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(143532);
    this.KXO = a.KXZ;
    this.KXP = new a[4];
    this.KXR = false;
    this.KXS = new int[2];
    setCancelable(true);
    this.mActivity = ((Activity)paramContext);
    paramContext = getWindow();
    if (paramContext == null)
    {
      AppMethodBeat.o(143532);
      return;
    }
    paramContext = paramContext.getAttributes();
    final int i = c.eB(getContext())[0];
    this.mFF = ar.jG(getContext());
    getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143525);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/happybubble/BubbleDialog$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/happybubble/BubbleDialog$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(143525);
            return true;
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/happybubble/BubbleDialog$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143525);
        return false;
      }
    });
    AppMethodBeat.o(143532);
  }
  
  private boolean fMn()
  {
    a[] arrayOfa = this.KXP;
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
  
  private void fMo()
  {
    AppMethodBeat.i(143535);
    if ((this.KXL == null) || ((this.KXQ == null) && (!fMn())))
    {
      AppMethodBeat.o(143535);
      return;
    }
    Object localObject = new int[4];
    localObject[0] = this.KXS[0];
    localObject[1] = this.KXS[1];
    localObject[2] = (c.eB(getContext())[0] - this.KXS[0] - this.KXL.getWidth());
    localObject[3] = (c.eB(getContext())[1] - this.KXS[1] - this.KXL.getHeight() - this.KXJ.getLookLength() - com.tencent.mm.cc.a.fromDPToPix(this.KXL.getContext(), 30));
    int j;
    int i;
    if (fMn())
    {
      this.KXK.measure(0, 0);
      a[] arrayOfa = this.KXP;
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
        switch (4.KXW[locala.ordinal()])
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
              } while (localObject[0] <= this.KXK.getMeasuredWidth());
              this.KXO = a.KXY;
              AppMethodBeat.o(143535);
              return;
            } while (localObject[1] <= this.KXK.getMeasuredHeight());
            this.KXO = a.KXZ;
            AppMethodBeat.o(143535);
            return;
          } while (localObject[2] <= this.KXK.getMeasuredWidth());
          this.KXO = a.KYa;
          AppMethodBeat.o(143535);
          return;
        } while (localObject[3] <= this.KXK.getMeasuredHeight());
        this.KXO = a.KYb;
        AppMethodBeat.o(143535);
        return;
      }
      this.KXO = this.KXP[0];
      AppMethodBeat.o(143535);
      return;
    }
    if (this.KXQ != null) {}
    switch (4.KXX[this.KXQ.ordinal()])
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
      for (localObject = a.KXZ;; localObject = a.KYb)
      {
        this.KXO = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (localObject[0] > localObject[2]) {}
      for (localObject = a.KXY;; localObject = a.KYa)
      {
        this.KXO = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[0])
      {
        this.KXO = a.KXY;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[1])
      {
        this.KXO = a.KXZ;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[2])
      {
        this.KXO = a.KYa;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[3]) {
        this.KXO = a.KYb;
      }
      AppMethodBeat.o(143535);
      return;
    }
  }
  
  private void fMp()
  {
    AppMethodBeat.i(143536);
    switch (4.KXW[this.KXO.ordinal()])
    {
    }
    for (;;)
    {
      this.KXJ.fMs();
      AppMethodBeat.o(143536);
      return;
      this.KXJ.setLook(BubbleLayout.a.KYt);
      continue;
      this.KXJ.setLook(BubbleLayout.a.KYu);
      continue;
      this.KXJ.setLook(BubbleLayout.a.KYr);
      continue;
      this.KXJ.setLook(BubbleLayout.a.KYs);
    }
  }
  
  private void fMq()
  {
    AppMethodBeat.i(143538);
    if (this.KXL == null)
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
      localLayoutParams1 = (FrameLayout.LayoutParams)this.KXJ.getLayoutParams();
      if ((this.KXO == a.KXZ) || (this.KXO == a.KYb))
      {
        localLayoutParams1.leftMargin = this.mMargin;
        localLayoutParams1.rightMargin = this.mMargin;
        this.KXJ.setLayoutParams(localLayoutParams1);
      }
    }
    else
    {
      switch (4.KXW[this.KXO.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.KXJ.invalidate();
      localWindow.setAttributes(localLayoutParams);
      AppMethodBeat.o(143538);
      return;
      localLayoutParams1.topMargin = this.mMargin;
      localLayoutParams1.bottomMargin = this.mMargin;
      break;
      localLayoutParams.x = (this.KXS[0] + this.KXL.getWidth() / 2 - this.KXJ.getWidth() / 2 + this.mOffsetX);
      if ((this.mMargin != 0) && (this.mWidth == -1)) {
        this.KXJ.setLookPosition(this.KXS[0] - this.mMargin + this.KXL.getWidth() / 2 - this.KXJ.getLookWidth() / 2);
      }
      for (;;)
      {
        if (this.KXO != a.KYb) {
          break label519;
        }
        if (this.KXM != 0) {
          this.mOffsetY = this.KXM;
        }
        localLayoutParams.y = (this.KXS[1] + this.KXL.getHeight() + this.mOffsetY - this.mFF);
        break;
        if (localLayoutParams.x <= 0) {
          this.KXJ.setLookPosition(this.KXS[0] + this.KXL.getWidth() / 2 - this.KXJ.getLookWidth() / 2);
        } else if (localLayoutParams.x + this.KXJ.getWidth() > c.eB(getContext())[0]) {
          this.KXJ.setLookPosition(this.KXS[0] - (c.eB(getContext())[0] - this.KXJ.getWidth()) + this.KXL.getWidth() / 2 - this.KXJ.getLookWidth() / 2);
        } else {
          this.KXJ.setLookPosition(this.KXS[0] - localLayoutParams.x + this.KXL.getWidth() / 2 - this.KXJ.getLookWidth() / 2);
        }
      }
      label519:
      if (this.KXM != 0) {
        this.mOffsetY = (-this.KXM);
      }
      localLayoutParams.y = (this.KXS[1] - this.KXJ.getHeight() + this.mOffsetY - this.mFF);
      continue;
      localLayoutParams.y = (this.KXS[1] + this.mOffsetY + this.KXL.getHeight() / 2 - this.KXJ.getHeight() / 2 - this.mFF);
      if ((this.mMargin != 0) && (this.mHeight == -1)) {
        this.KXJ.setLookPosition(this.KXS[1] - this.mMargin + this.KXL.getHeight() / 2 - this.KXJ.getLookWidth() / 2 - this.mFF);
      }
      for (;;)
      {
        if (this.KXO != a.KYa) {
          break label887;
        }
        if (this.KXM != 0) {
          this.mOffsetX = this.KXM;
        }
        localLayoutParams.x = (this.KXS[0] + this.KXL.getWidth() + this.mOffsetX);
        break;
        if (localLayoutParams.y <= 0) {
          this.KXJ.setLookPosition(this.KXS[1] + this.KXL.getHeight() / 2 - this.KXJ.getLookWidth() / 2 - this.mFF);
        } else if (localLayoutParams.y + this.KXJ.getHeight() > c.eB(getContext())[1]) {
          this.KXJ.setLookPosition(this.KXS[1] - (c.eB(getContext())[1] - this.KXJ.getHeight()) + this.KXL.getHeight() / 2 - this.KXJ.getLookWidth() / 2);
        } else {
          this.KXJ.setLookPosition(this.KXS[1] - localLayoutParams.y + this.KXL.getHeight() / 2 - this.KXJ.getLookWidth() / 2 - this.mFF);
        }
      }
      label887:
      if (this.KXM != 0) {
        this.mOffsetX = (-this.KXM);
      }
      localLayoutParams.x = (this.KXS[0] - this.KXJ.getWidth() + this.mOffsetX);
    }
  }
  
  public final <T extends b> T a(BubbleLayout paramBubbleLayout)
  {
    this.KXJ = paramBubbleLayout;
    return this;
  }
  
  public final <T extends b> T a(a... paramVarArgs)
  {
    this.KXP = paramVarArgs;
    return this;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(143537);
    if (this.KXN)
    {
      View localView = getCurrentFocus();
      if ((localView instanceof TextView)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
    if ((this.KXJ != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.KXJ.getViewTreeObserver().removeOnGlobalLayoutListener(this.ajt);
    }
    super.dismiss();
    AppMethodBeat.o(143537);
  }
  
  public final <T extends b> T hc(View paramView)
  {
    AppMethodBeat.i(186543);
    this.KXL = paramView;
    this.KXL.getLocationOnScreen(this.KXS);
    if (this.ajt != null)
    {
      fMo();
      fMp();
      fMq();
    }
    AppMethodBeat.o(186543);
    return this;
  }
  
  public final <T extends b> T hd(View paramView)
  {
    this.KXK = paramView;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143534);
    super.onCreate(paramBundle);
    if (this.KXJ == null) {
      this.KXJ = new BubbleLayout(getContext());
    }
    if (this.KXK != null) {
      this.KXJ.addView(this.KXK);
    }
    setContentView(this.KXJ);
    paramBundle = getWindow();
    if (paramBundle == null)
    {
      AppMethodBeat.o(143534);
      return;
    }
    if (this.KXN) {
      paramBundle.setSoftInputMode(18);
    }
    paramBundle.setLayout(-2, -2);
    fMo();
    fMp();
    this.ajt = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      int ngT;
      int ngU;
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143526);
        if ((this.ngT == b.c(b.this).getWidth()) && (this.ngU == b.c(b.this).getHeight()))
        {
          AppMethodBeat.o(143526);
          return;
        }
        b.d(b.this);
        this.ngT = b.c(b.this).getWidth();
        this.ngU = b.c(b.this).getHeight();
        AppMethodBeat.o(143526);
      }
    };
    this.KXJ.getViewTreeObserver().addOnGlobalLayoutListener(this.ajt);
    this.KXJ.setOnClickEdgeListener(new BubbleLayout.b()
    {
      public final void fMr()
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
    if ((this.KXR) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
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
      KXY = new a("LEFT", 0);
      KXZ = new a("TOP", 1);
      KYa = new a("RIGHT", 2);
      KYb = new a("BOTTOM", 3);
      KYc = new a[] { KXY, KXZ, KYa, KYb };
      AppMethodBeat.o(143531);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.b
 * JD-Core Version:    0.7.0.1
 */