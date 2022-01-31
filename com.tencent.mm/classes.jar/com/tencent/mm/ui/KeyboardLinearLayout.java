package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout
  extends OnLayoutChangedLinearLayout
{
  public String TAG;
  private boolean mHasInit;
  private int mHeight;
  private boolean yYM;
  private KeyboardLinearLayout.a yYN;
  
  public KeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105972);
    this.TAG = "MicroMsg.KeyboardLinearLayout";
    this.mHasInit = false;
    this.mHasInit = false;
    this.mHeight = 0;
    this.yYM = false;
    this.TAG += getId();
    AppMethodBeat.o(105972);
  }
  
  public KeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.TAG = "MicroMsg.KeyboardLinearLayout";
    this.mHasInit = false;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105973);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    rM(paramInt4);
    AppMethodBeat.o(105973);
  }
  
  protected void rM(int paramInt)
  {
    AppMethodBeat.i(105974);
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      ab.i(this.TAG, "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      if (this.yYN != null) {
        this.yYN.sJ(-1);
      }
      if ((this.mHasInit) && (!this.yYM) && (this.mHeight - paramInt > 100))
      {
        this.yYM = true;
        sJ(-3);
        ab.w(this.TAG, "show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
      }
      if ((this.mHasInit) && (this.yYM) && (this.mHeight - paramInt <= 100))
      {
        this.yYM = false;
        sJ(-2);
        ab.w(this.TAG, "hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
      }
      AppMethodBeat.o(105974);
      return;
    }
    if (this.mHeight < paramInt) {}
    for (int i = paramInt;; i = this.mHeight)
    {
      this.mHeight = i;
      break;
    }
  }
  
  protected void sJ(int paramInt)
  {
    AppMethodBeat.i(105975);
    if (this.yYN != null) {
      this.yYN.sJ(paramInt);
    }
    AppMethodBeat.o(105975);
  }
  
  public void setOnkbdStateListener(KeyboardLinearLayout.a parama)
  {
    this.yYN = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.KeyboardLinearLayout
 * JD-Core Version:    0.7.0.1
 */