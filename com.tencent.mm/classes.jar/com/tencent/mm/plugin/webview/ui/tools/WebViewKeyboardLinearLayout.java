package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout
  extends KeyboardLinearLayout
{
  boolean Cxl;
  private int Cxm;
  private int Cxn;
  private int Cxo;
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
  
  public final void FG(int paramInt)
  {
    AppMethodBeat.i(210025);
    super.FG(paramInt);
    AppMethodBeat.o(210025);
  }
  
  public final void VE(int paramInt)
  {
    AppMethodBeat.i(188370);
    ac.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + paramInt + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.Cxl);
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    int i = getRootView().getHeight();
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      ac.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      super.FG(-1);
      this.Cxo = (i - localRect.bottom);
    }
    ac.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", new Object[] { localRect.toString() });
    i = localRect.height();
    this.mHeight = i;
    ac.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Cxm) });
    if (this.Cxm != i)
    {
      int j = getRootView().getHeight() - this.Cxo - localRect.top;
      int k = j - i;
      if (k <= j / 4) {
        break label298;
      }
      this.Cxl = true;
      this.Cxn = k;
      super.FG(-3);
      ac.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt + " mKBHeight: " + this.Cxn);
    }
    for (;;)
    {
      this.Cxm = i;
      AppMethodBeat.o(188370);
      return;
      label298:
      this.Cxl = false;
      super.FG(-2);
      ac.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
    }
  }
  
  public final boolean eDg()
  {
    return this.Cxl;
  }
  
  public final int getKeyBoardHeight()
  {
    return this.Cxn;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout
 * JD-Core Version:    0.7.0.1
 */