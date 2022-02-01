package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout
  extends OnLayoutChangedLinearLayout
{
  private boolean IYJ;
  private a IYK;
  public String TAG;
  private boolean mHasInit;
  private int mHeight;
  
  public KeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141302);
    this.TAG = "MicroMsg.KeyboardLinearLayout";
    this.mHasInit = false;
    this.mHasInit = false;
    this.mHeight = 0;
    this.IYJ = false;
    this.TAG += getId();
    AppMethodBeat.o(141302);
  }
  
  public KeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.TAG = "MicroMsg.KeyboardLinearLayout";
    this.mHasInit = false;
  }
  
  protected void GV(int paramInt)
  {
    AppMethodBeat.i(141305);
    if (this.IYK != null) {
      this.IYK.GV(paramInt);
    }
    AppMethodBeat.o(141305);
  }
  
  protected void Xt(int paramInt)
  {
    AppMethodBeat.i(141304);
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      ad.i(this.TAG, "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      if (this.IYK != null) {
        this.IYK.GV(-1);
      }
      if ((this.mHasInit) && (!this.IYJ) && (this.mHeight - paramInt > 100))
      {
        this.IYJ = true;
        GV(-3);
        ad.w(this.TAG, "show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
      }
      if ((this.mHasInit) && (this.IYJ) && (this.mHeight - paramInt <= 100))
      {
        this.IYJ = false;
        GV(-2);
        ad.w(this.TAG, "hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
      }
      AppMethodBeat.o(141304);
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
    AppMethodBeat.i(141303);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Xt(paramInt4);
    AppMethodBeat.o(141303);
  }
  
  public void setOnkbdStateListener(a parama)
  {
    this.IYK = parama;
  }
  
  public static abstract interface a
  {
    public abstract void GV(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.KeyboardLinearLayout
 * JD-Core Version:    0.7.0.1
 */