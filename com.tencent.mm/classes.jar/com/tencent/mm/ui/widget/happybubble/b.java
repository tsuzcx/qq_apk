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
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;

public class b
  extends Dialog
{
  private BubbleLayout aggN;
  private View aggO;
  private Rect aggP;
  private int aggQ;
  private boolean aggR;
  private a aggS;
  private a[] aggT;
  private a aggU;
  private boolean aggV;
  private int[] aggW;
  private int bhE;
  private int biT;
  private int biU;
  private Activity mActivity;
  private boolean mCancelable;
  private int mHeight;
  private int mStatusBarHeight;
  private int mWidth;
  private ViewTreeObserver.OnGlobalLayoutListener qZ;
  
  public b(final Context paramContext)
  {
    super(paramContext, a.l.mmalertdialog);
    AppMethodBeat.i(143532);
    this.aggS = a.aghd;
    this.aggT = new a[4];
    this.aggV = false;
    this.aggW = new int[2];
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
    this.mStatusBarHeight = bf.getStatusBarHeight(getContext());
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
  
  private boolean jHY()
  {
    a[] arrayOfa = this.aggT;
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
  
  private void jHZ()
  {
    AppMethodBeat.i(143535);
    if ((this.aggP == null) || ((this.aggU == null) && (!jHY())))
    {
      AppMethodBeat.o(143535);
      return;
    }
    Object localObject = new int[4];
    localObject[0] = this.aggW[0];
    localObject[1] = this.aggW[1];
    localObject[2] = (c.getScreenWH(getContext())[0] - this.aggW[0] - this.aggP.width());
    localObject[3] = (c.getScreenWH(getContext())[1] - this.aggW[1] - this.aggP.height());
    int j;
    int i;
    if (jHY())
    {
      this.aggO.measure(0, 0);
      a[] arrayOfa = this.aggT;
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
        switch (4.agha[locala.ordinal()])
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
              } while (localObject[0] <= this.aggO.getMeasuredWidth());
              this.aggS = a.aghc;
              AppMethodBeat.o(143535);
              return;
            } while (localObject[1] <= this.aggO.getMeasuredHeight());
            this.aggS = a.aghd;
            AppMethodBeat.o(143535);
            return;
          } while (localObject[2] <= this.aggO.getMeasuredWidth());
          this.aggS = a.aghe;
          AppMethodBeat.o(143535);
          return;
        } while (localObject[3] <= this.aggO.getMeasuredHeight());
        this.aggS = a.aghf;
        AppMethodBeat.o(143535);
        return;
      }
      this.aggS = this.aggT[0];
      AppMethodBeat.o(143535);
      return;
    }
    if (this.aggU != null) {}
    switch (4.aghb[this.aggU.ordinal()])
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
      for (localObject = a.aghd;; localObject = a.aghf)
      {
        this.aggS = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (localObject[0] > localObject[2]) {}
      for (localObject = a.aghc;; localObject = a.aghe)
      {
        this.aggS = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[0])
      {
        this.aggS = a.aghc;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[1])
      {
        this.aggS = a.aghd;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[2])
      {
        this.aggS = a.aghe;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[3]) {
        this.aggS = a.aghf;
      }
      AppMethodBeat.o(143535);
      return;
    }
  }
  
  private void jIa()
  {
    AppMethodBeat.i(143536);
    switch (4.agha[this.aggS.ordinal()])
    {
    }
    for (;;)
    {
      this.aggN.jIe();
      AppMethodBeat.o(143536);
      return;
      this.aggN.setLook(BubbleLayout.a.aghx);
      continue;
      this.aggN.setLook(BubbleLayout.a.aghy);
      continue;
      this.aggN.setLook(BubbleLayout.a.aghv);
      continue;
      this.aggN.setLook(BubbleLayout.a.aghw);
    }
  }
  
  private void jIb()
  {
    AppMethodBeat.i(143538);
    if (this.aggP == null)
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
    if (this.bhE != 0)
    {
      localLayoutParams1 = (FrameLayout.LayoutParams)this.aggN.getLayoutParams();
      if ((this.aggS == a.aghd) || (this.aggS == a.aghf))
      {
        localLayoutParams1.leftMargin = this.bhE;
        localLayoutParams1.rightMargin = this.bhE;
        this.aggN.setLayoutParams(localLayoutParams1);
      }
    }
    else
    {
      switch (4.agha[this.aggS.ordinal()])
      {
      default: 
        label180:
        if (l.aQo()) {
          if ((this.mActivity == null) || (!d.rb(24)) || (!this.mActivity.isInMultiWindowMode())) {
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
      if ((aw.jkS()) || (i != 0)) {
        localLayoutParams.y += this.mStatusBarHeight;
      }
      this.aggN.invalidate();
      localWindow.setAttributes(localLayoutParams);
      AppMethodBeat.o(143538);
      return;
      localLayoutParams1.topMargin = this.bhE;
      localLayoutParams1.bottomMargin = this.bhE;
      break;
      localLayoutParams.x = (this.aggW[0] + this.aggP.width() / 2 - this.aggN.getMeasuredWidth() / 2 + this.biT);
      if ((this.bhE != 0) && (this.mWidth == -1)) {
        this.aggN.setLookPosition(this.aggW[0] - this.bhE + this.aggP.width() / 2 - this.aggN.getLookWidth() / 2);
      }
      for (;;)
      {
        if (this.aggS != a.aghf) {
          break label581;
        }
        if (this.aggQ != 0) {
          this.biU = this.aggQ;
        }
        localLayoutParams.y = (this.aggW[1] + this.aggP.height() + this.biU - this.mStatusBarHeight);
        break;
        if (localLayoutParams.x <= 0) {
          this.aggN.setLookPosition(this.aggW[0] + this.aggP.width() / 2 - this.aggN.getLookWidth() / 2);
        } else if (localLayoutParams.x + this.aggN.getMeasuredWidth() > c.getScreenWH(getContext())[0]) {
          this.aggN.setLookPosition(this.aggW[0] - (c.getScreenWH(getContext())[0] - this.aggN.getMeasuredWidth()) + this.aggP.width() / 2 - this.aggN.getLookWidth() / 2);
        } else {
          this.aggN.setLookPosition(this.aggW[0] - localLayoutParams.x + this.aggP.width() / 2 - this.aggN.getLookWidth() / 2);
        }
      }
      if (this.aggQ != 0) {
        this.biU = (-this.aggQ);
      }
      localLayoutParams.y = (this.aggW[1] - this.aggN.getMeasuredHeight() + this.biU - this.mStatusBarHeight);
      break label180;
      localLayoutParams.y = (this.aggW[1] + this.biU + this.aggP.height() / 2 - this.aggN.getMeasuredHeight() / 2 - this.mStatusBarHeight);
      if ((this.bhE != 0) && (this.mHeight == -1)) {
        this.aggN.setLookPosition(this.aggW[1] - this.bhE + this.aggP.height() / 2 - this.aggN.getLookWidth() / 2 - this.mStatusBarHeight);
      }
      for (;;)
      {
        if (this.aggS != a.aghe) {
          break label949;
        }
        if (this.aggQ != 0) {
          this.biT = this.aggQ;
        }
        localLayoutParams.x = (this.aggW[0] + this.aggP.width() + this.biT);
        break;
        if (localLayoutParams.y <= 0) {
          this.aggN.setLookPosition(this.aggW[1] + this.aggP.height() / 2 - this.aggN.getLookWidth() / 2 - this.mStatusBarHeight);
        } else if (localLayoutParams.y + this.aggN.getMeasuredHeight() > c.getScreenWH(getContext())[1]) {
          this.aggN.setLookPosition(this.aggW[1] - (c.getScreenWH(getContext())[1] - this.aggN.getMeasuredHeight()) + this.aggP.height() / 2 - this.aggN.getLookWidth() / 2);
        } else {
          this.aggN.setLookPosition(this.aggW[1] - localLayoutParams.y + this.aggP.height() / 2 - this.aggN.getLookWidth() / 2 - this.mStatusBarHeight);
        }
      }
      if (this.aggQ != 0) {
        this.biT = (-this.aggQ);
      }
      localLayoutParams.x = (this.aggW[0] - this.aggN.getMeasuredWidth() + this.biT);
      break label180;
    }
  }
  
  private void jIc()
  {
    AppMethodBeat.i(251748);
    jHZ();
    if (this.qZ != null)
    {
      jIa();
      jIb();
    }
    AppMethodBeat.o(251748);
  }
  
  public final <T extends b> T a(BubbleLayout paramBubbleLayout)
  {
    this.aggN = paramBubbleLayout;
    return this;
  }
  
  public final <T extends b> T a(a... paramVarArgs)
  {
    this.aggT = paramVarArgs;
    return this;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(143537);
    if (this.aggR)
    {
      View localView = getCurrentFocus();
      if ((localView instanceof TextView)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
    if ((this.aggN != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.aggN.getViewTreeObserver().removeOnGlobalLayoutListener(this.qZ);
    }
    super.dismiss();
    AppMethodBeat.o(143537);
  }
  
  public final <T extends b> T mj(View paramView)
  {
    AppMethodBeat.i(251767);
    this.aggP = new Rect(0, 0, paramView.getWidth(), paramView.getHeight());
    paramView.getLocationInWindow(this.aggW);
    jIc();
    AppMethodBeat.o(251767);
    return this;
  }
  
  @Deprecated
  public final <T extends b> T mk(View paramView)
  {
    this.aggO = paramView;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143534);
    super.onCreate(paramBundle);
    if (this.aggN == null) {
      this.aggN = new BubbleLayout(getContext());
    }
    if (this.aggO != null) {
      this.aggN.addView(this.aggO);
    }
    setContentView(this.aggN);
    paramBundle = getWindow();
    if (paramBundle == null)
    {
      AppMethodBeat.o(143534);
      return;
    }
    if (this.aggR) {
      paramBundle.setSoftInputMode(18);
    }
    paramBundle.setLayout(-2, -2);
    jHZ();
    jIa();
    this.aggN.measure(0, 0);
    jIb();
    this.qZ = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      int uJy;
      int uJz;
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143526);
        if ((this.uJy == b.c(b.this).getMeasuredWidth()) && (this.uJz == b.c(b.this).getMeasuredHeight()))
        {
          AppMethodBeat.o(143526);
          return;
        }
        b.d(b.this);
        this.uJy = b.c(b.this).getMeasuredWidth();
        this.uJz = b.c(b.this).getMeasuredHeight();
        AppMethodBeat.o(143526);
      }
    };
    this.aggN.getViewTreeObserver().addOnGlobalLayoutListener(this.qZ);
    this.aggN.setOnClickEdgeListener(new BubbleLayout.b()
    {
      public final void jId()
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
    if ((this.aggV) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
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
      aghc = new a("LEFT", 0);
      aghd = new a("TOP", 1);
      aghe = new a("RIGHT", 2);
      aghf = new a("BOTTOM", 3);
      aghg = new a[] { aghc, aghd, aghe, aghf };
      AppMethodBeat.o(143531);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.b
 * JD-Core Version:    0.7.0.1
 */