package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout
  extends KeyboardLinearLayout
{
  boolean Jgc;
  private int Jgd;
  private int Jge;
  private int Jgf;
  private boolean mHasInit = false;
  private int mHeight;
  
  public WebViewKeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WebViewKeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void Ns(int paramInt)
  {
    AppMethodBeat.i(258617);
    super.Ns(paramInt);
    AppMethodBeat.o(258617);
  }
  
  public final void agG(int paramInt)
  {
    AppMethodBeat.i(258103);
    Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + paramInt + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.Jgc);
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    int i = getRootView().getHeight();
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      Log.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      super.Ns(-1);
      this.Jgf = (i - localRect.bottom);
    }
    Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", new Object[] { localRect.toString() });
    i = localRect.height();
    this.mHeight = i;
    Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Jgd) });
    if (this.Jgd != i)
    {
      int j = getRootView().getHeight() - this.Jgf - localRect.top;
      int k = j - i;
      if (k <= j / 4) {
        break label298;
      }
      this.Jgc = true;
      this.Jge = k;
      super.Ns(-3);
      Log.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt + " mKBHeight: " + this.Jge);
    }
    for (;;)
    {
      this.Jgd = i;
      AppMethodBeat.o(258103);
      return;
      label298:
      this.Jgc = false;
      super.Ns(-2);
      Log.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
    }
  }
  
  public final boolean geD()
  {
    return this.Jgc;
  }
  
  public final int getKeyBoardHeight()
  {
    return this.Jge;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(79834);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(79834);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79835);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(79835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout
 * JD-Core Version:    0.7.0.1
 */