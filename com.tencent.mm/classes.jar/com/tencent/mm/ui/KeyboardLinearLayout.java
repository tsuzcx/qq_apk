package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout
  extends OnLayoutChangedLinearLayout
{
  public String TAG = "MicroMsg.KeyboardLinearLayout";
  private boolean mHasInit = false;
  private int mHeight;
  private boolean uKK;
  private a uKL;
  
  public KeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mHasInit = false;
    this.mHeight = 0;
    this.uKK = false;
    this.TAG += getId();
  }
  
  public KeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void CB(int paramInt)
  {
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      y.i(this.TAG, "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      if (this.uKL != null) {
        this.uKL.rD(-1);
      }
      if ((this.mHasInit) && (!this.uKK) && (this.mHeight - paramInt > 100))
      {
        this.uKK = true;
        rD(-3);
        y.w(this.TAG, "show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
      }
      if ((this.mHasInit) && (this.uKK) && (this.mHeight - paramInt <= 100))
      {
        this.uKK = false;
        rD(-2);
        y.w(this.TAG, "hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
      }
      return;
    }
    if (this.mHeight < paramInt) {}
    for (int i = paramInt;; i = this.mHeight)
    {
      this.mHeight = i;
      break;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    CB(paramInt4);
  }
  
  public void rD(int paramInt)
  {
    if (this.uKL != null) {
      this.uKL.rD(paramInt);
    }
  }
  
  public void setOnkbdStateListener(a parama)
  {
    this.uKL = parama;
  }
  
  public static abstract interface a
  {
    public abstract void rD(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.KeyboardLinearLayout
 * JD-Core Version:    0.7.0.1
 */