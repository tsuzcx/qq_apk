package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout
  extends KeyboardLinearLayout
{
  boolean EaT;
  private int EaU;
  private int EaV;
  private int EaW;
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
  
  public final void GV(int paramInt)
  {
    AppMethodBeat.i(221643);
    super.GV(paramInt);
    AppMethodBeat.o(221643);
  }
  
  public final void Xt(int paramInt)
  {
    AppMethodBeat.i(208002);
    ad.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + paramInt + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.EaT);
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    int i = getRootView().getHeight();
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      ad.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      super.GV(-1);
      this.EaW = (i - localRect.bottom);
    }
    ad.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", new Object[] { localRect.toString() });
    i = localRect.height();
    this.mHeight = i;
    ad.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.EaU) });
    if (this.EaU != i)
    {
      int j = getRootView().getHeight() - this.EaW - localRect.top;
      int k = j - i;
      if (k <= j / 4) {
        break label298;
      }
      this.EaT = true;
      this.EaV = k;
      super.GV(-3);
      ad.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt + " mKBHeight: " + this.EaV);
    }
    for (;;)
    {
      this.EaU = i;
      AppMethodBeat.o(208002);
      return;
      label298:
      this.EaT = false;
      super.GV(-2);
      ad.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
    }
  }
  
  public final boolean eRY()
  {
    return this.EaT;
  }
  
  public final int getKeyBoardHeight()
  {
    return this.EaV;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout
 * JD-Core Version:    0.7.0.1
 */