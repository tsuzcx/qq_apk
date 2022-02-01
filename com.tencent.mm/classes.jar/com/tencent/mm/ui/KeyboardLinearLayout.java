package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout
  extends OnLayoutChangedLinearLayout
{
  public String TAG;
  private boolean VXb;
  private a VXc;
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
    this.VXb = false;
    this.TAG += getId();
    AppMethodBeat.o(141302);
  }
  
  public KeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.TAG = "MicroMsg.KeyboardLinearLayout";
    this.mHasInit = false;
  }
  
  protected void SG(int paramInt)
  {
    AppMethodBeat.i(141305);
    if (this.VXc != null) {
      this.VXc.SG(paramInt);
    }
    AppMethodBeat.o(141305);
  }
  
  protected void aow(int paramInt)
  {
    AppMethodBeat.i(141304);
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      Log.i(this.TAG, "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      if (this.VXc != null) {
        this.VXc.SG(-1);
      }
      if ((this.mHasInit) && (!this.VXb) && (this.mHeight - paramInt > 100))
      {
        this.VXb = true;
        SG(-3);
        Log.w(this.TAG, "show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
      }
      if ((this.mHasInit) && (this.VXb) && (this.mHeight - paramInt <= 100))
      {
        this.VXb = false;
        SG(-2);
        Log.w(this.TAG, "hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
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
    aow(paramInt4);
    AppMethodBeat.o(141303);
  }
  
  public void setOnkbdStateListener(a parama)
  {
    this.VXc = parama;
  }
  
  public static abstract interface a
  {
    public abstract void SG(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.KeyboardLinearLayout
 * JD-Core Version:    0.7.0.1
 */