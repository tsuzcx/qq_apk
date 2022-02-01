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
import com.tencent.mm.ui.ar;

public class b
  extends Dialog
{
  private BubbleLayout Luh;
  private View Lui;
  private View Luj;
  private int Luk;
  private boolean Lul;
  private a Lum;
  private a[] Lun;
  private a Luo;
  private boolean Lup;
  private int[] Luq;
  private ViewTreeObserver.OnGlobalLayoutListener ajt;
  private Activity mActivity;
  private boolean mCancelable;
  private int mHeight;
  private int mKJ;
  private int mMargin;
  private int mOffsetX;
  private int mOffsetY;
  private int mWidth;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(143532);
    this.Lum = a.Lux;
    this.Lun = new a[4];
    this.Lup = false;
    this.Luq = new int[2];
    setCancelable(true);
    this.mActivity = ((Activity)paramContext);
    paramContext = getWindow();
    if (paramContext == null)
    {
      AppMethodBeat.o(143532);
      return;
    }
    paramContext = paramContext.getAttributes();
    int i = c.eF(getContext())[0];
    this.mKJ = ar.jN(getContext());
    getWindow().getDecorView().setOnTouchListener(new b.1(this, paramContext, i));
    AppMethodBeat.o(143532);
  }
  
  private boolean fQH()
  {
    a[] arrayOfa = this.Lun;
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
  
  private void fQI()
  {
    AppMethodBeat.i(143535);
    if ((this.Luj == null) || ((this.Luo == null) && (!fQH())))
    {
      AppMethodBeat.o(143535);
      return;
    }
    Object localObject = new int[4];
    localObject[0] = this.Luq[0];
    localObject[1] = this.Luq[1];
    localObject[2] = (c.eF(getContext())[0] - this.Luq[0] - this.Luj.getWidth());
    localObject[3] = (c.eF(getContext())[1] - this.Luq[1] - this.Luj.getHeight() - this.Luh.getLookLength() - com.tencent.mm.cb.a.fromDPToPix(this.Luj.getContext(), 30));
    int j;
    int i;
    if (fQH())
    {
      this.Lui.measure(0, 0);
      a[] arrayOfa = this.Lun;
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
        switch (4.Luu[locala.ordinal()])
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
              } while (localObject[0] <= this.Lui.getMeasuredWidth());
              this.Lum = a.Luw;
              AppMethodBeat.o(143535);
              return;
            } while (localObject[1] <= this.Lui.getMeasuredHeight());
            this.Lum = a.Lux;
            AppMethodBeat.o(143535);
            return;
          } while (localObject[2] <= this.Lui.getMeasuredWidth());
          this.Lum = a.Luy;
          AppMethodBeat.o(143535);
          return;
        } while (localObject[3] <= this.Lui.getMeasuredHeight());
        this.Lum = a.Luz;
        AppMethodBeat.o(143535);
        return;
      }
      this.Lum = this.Lun[0];
      AppMethodBeat.o(143535);
      return;
    }
    if (this.Luo != null) {}
    switch (4.Luv[this.Luo.ordinal()])
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
      for (localObject = a.Lux;; localObject = a.Luz)
      {
        this.Lum = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (localObject[0] > localObject[2]) {}
      for (localObject = a.Luw;; localObject = a.Luy)
      {
        this.Lum = ((a)localObject);
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[0])
      {
        this.Lum = a.Luw;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[1])
      {
        this.Lum = a.Lux;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[2])
      {
        this.Lum = a.Luy;
        AppMethodBeat.o(143535);
        return;
      }
      if (i == localObject[3]) {
        this.Lum = a.Luz;
      }
      AppMethodBeat.o(143535);
      return;
    }
  }
  
  private void fQJ()
  {
    AppMethodBeat.i(143536);
    switch (4.Luu[this.Lum.ordinal()])
    {
    }
    for (;;)
    {
      this.Luh.fQM();
      AppMethodBeat.o(143536);
      return;
      this.Luh.setLook(BubbleLayout.a.LuR);
      continue;
      this.Luh.setLook(BubbleLayout.a.LuS);
      continue;
      this.Luh.setLook(BubbleLayout.a.LuP);
      continue;
      this.Luh.setLook(BubbleLayout.a.LuQ);
    }
  }
  
  private void fQK()
  {
    AppMethodBeat.i(143538);
    if (this.Luj == null)
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
      localLayoutParams1 = (FrameLayout.LayoutParams)this.Luh.getLayoutParams();
      if ((this.Lum == a.Lux) || (this.Lum == a.Luz))
      {
        localLayoutParams1.leftMargin = this.mMargin;
        localLayoutParams1.rightMargin = this.mMargin;
        this.Luh.setLayoutParams(localLayoutParams1);
      }
    }
    else
    {
      switch (4.Luu[this.Lum.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.Luh.invalidate();
      localWindow.setAttributes(localLayoutParams);
      AppMethodBeat.o(143538);
      return;
      localLayoutParams1.topMargin = this.mMargin;
      localLayoutParams1.bottomMargin = this.mMargin;
      break;
      localLayoutParams.x = (this.Luq[0] + this.Luj.getWidth() / 2 - this.Luh.getWidth() / 2 + this.mOffsetX);
      if ((this.mMargin != 0) && (this.mWidth == -1)) {
        this.Luh.setLookPosition(this.Luq[0] - this.mMargin + this.Luj.getWidth() / 2 - this.Luh.getLookWidth() / 2);
      }
      for (;;)
      {
        if (this.Lum != a.Luz) {
          break label519;
        }
        if (this.Luk != 0) {
          this.mOffsetY = this.Luk;
        }
        localLayoutParams.y = (this.Luq[1] + this.Luj.getHeight() + this.mOffsetY - this.mKJ);
        break;
        if (localLayoutParams.x <= 0) {
          this.Luh.setLookPosition(this.Luq[0] + this.Luj.getWidth() / 2 - this.Luh.getLookWidth() / 2);
        } else if (localLayoutParams.x + this.Luh.getWidth() > c.eF(getContext())[0]) {
          this.Luh.setLookPosition(this.Luq[0] - (c.eF(getContext())[0] - this.Luh.getWidth()) + this.Luj.getWidth() / 2 - this.Luh.getLookWidth() / 2);
        } else {
          this.Luh.setLookPosition(this.Luq[0] - localLayoutParams.x + this.Luj.getWidth() / 2 - this.Luh.getLookWidth() / 2);
        }
      }
      label519:
      if (this.Luk != 0) {
        this.mOffsetY = (-this.Luk);
      }
      localLayoutParams.y = (this.Luq[1] - this.Luh.getHeight() + this.mOffsetY - this.mKJ);
      continue;
      localLayoutParams.y = (this.Luq[1] + this.mOffsetY + this.Luj.getHeight() / 2 - this.Luh.getHeight() / 2 - this.mKJ);
      if ((this.mMargin != 0) && (this.mHeight == -1)) {
        this.Luh.setLookPosition(this.Luq[1] - this.mMargin + this.Luj.getHeight() / 2 - this.Luh.getLookWidth() / 2 - this.mKJ);
      }
      for (;;)
      {
        if (this.Lum != a.Luy) {
          break label887;
        }
        if (this.Luk != 0) {
          this.mOffsetX = this.Luk;
        }
        localLayoutParams.x = (this.Luq[0] + this.Luj.getWidth() + this.mOffsetX);
        break;
        if (localLayoutParams.y <= 0) {
          this.Luh.setLookPosition(this.Luq[1] + this.Luj.getHeight() / 2 - this.Luh.getLookWidth() / 2 - this.mKJ);
        } else if (localLayoutParams.y + this.Luh.getHeight() > c.eF(getContext())[1]) {
          this.Luh.setLookPosition(this.Luq[1] - (c.eF(getContext())[1] - this.Luh.getHeight()) + this.Luj.getHeight() / 2 - this.Luh.getLookWidth() / 2);
        } else {
          this.Luh.setLookPosition(this.Luq[1] - localLayoutParams.y + this.Luj.getHeight() / 2 - this.Luh.getLookWidth() / 2 - this.mKJ);
        }
      }
      label887:
      if (this.Luk != 0) {
        this.mOffsetX = (-this.Luk);
      }
      localLayoutParams.x = (this.Luq[0] - this.Luh.getWidth() + this.mOffsetX);
    }
  }
  
  public final <T extends b> T a(BubbleLayout paramBubbleLayout)
  {
    this.Luh = paramBubbleLayout;
    return this;
  }
  
  public final <T extends b> T a(a... paramVarArgs)
  {
    this.Lun = paramVarArgs;
    return this;
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(143537);
    if (this.Lul)
    {
      View localView = getCurrentFocus();
      if ((localView instanceof TextView)) {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
      }
    }
    if ((this.Luh != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.Luh.getViewTreeObserver().removeOnGlobalLayoutListener(this.ajt);
    }
    super.dismiss();
    AppMethodBeat.o(143537);
  }
  
  public final <T extends b> T hh(View paramView)
  {
    AppMethodBeat.i(193801);
    this.Luj = paramView;
    this.Luj.getLocationOnScreen(this.Luq);
    if (this.ajt != null)
    {
      fQI();
      fQJ();
      fQK();
    }
    AppMethodBeat.o(193801);
    return this;
  }
  
  public final <T extends b> T hi(View paramView)
  {
    this.Lui = paramView;
    return this;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(143534);
    super.onCreate(paramBundle);
    if (this.Luh == null) {
      this.Luh = new BubbleLayout(getContext());
    }
    if (this.Lui != null) {
      this.Luh.addView(this.Lui);
    }
    setContentView(this.Luh);
    paramBundle = getWindow();
    if (paramBundle == null)
    {
      AppMethodBeat.o(143534);
      return;
    }
    if (this.Lul) {
      paramBundle.setSoftInputMode(18);
    }
    paramBundle.setLayout(-2, -2);
    fQI();
    fQJ();
    this.ajt = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      int nmb;
      int nmc;
      
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(143526);
        if ((this.nmb == b.c(b.this).getWidth()) && (this.nmc == b.c(b.this).getHeight()))
        {
          AppMethodBeat.o(143526);
          return;
        }
        b.d(b.this);
        this.nmb = b.c(b.this).getWidth();
        this.nmc = b.c(b.this).getHeight();
        AppMethodBeat.o(143526);
      }
    };
    this.Luh.getViewTreeObserver().addOnGlobalLayoutListener(this.ajt);
    this.Luh.setOnClickEdgeListener(new BubbleLayout.b()
    {
      public final void fQL()
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
    if ((this.Lup) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
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
      Luw = new a("LEFT", 0);
      Lux = new a("TOP", 1);
      Luy = new a("RIGHT", 2);
      Luz = new a("BOTTOM", 3);
      LuA = new a[] { Luw, Lux, Luy, Luz };
      AppMethodBeat.o(143531);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.happybubble.b
 * JD-Core Version:    0.7.0.1
 */