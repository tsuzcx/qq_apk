package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout
  extends KeyboardLinearLayout
{
  boolean EsV;
  private int EsW;
  private int EsX;
  private boolean mHasInit = false;
  private int mHeight;
  private int vls;
  
  public WebViewKeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WebViewKeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void Hs(int paramInt)
  {
    AppMethodBeat.i(224326);
    super.Hs(paramInt);
    AppMethodBeat.o(224326);
  }
  
  public final void XZ(int paramInt)
  {
    AppMethodBeat.i(198179);
    ae.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + paramInt + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.EsV);
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    int i = getRootView().getHeight();
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      ae.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      super.Hs(-1);
      this.vls = (i - localRect.bottom);
    }
    ae.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", new Object[] { localRect.toString() });
    i = localRect.height();
    this.mHeight = i;
    ae.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.EsW) });
    if (this.EsW != i)
    {
      int j = getRootView().getHeight() - this.vls - localRect.top;
      int k = j - i;
      if (k <= j / 4) {
        break label298;
      }
      this.EsV = true;
      this.EsX = k;
      super.Hs(-3);
      ae.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt + " mKBHeight: " + this.EsX);
    }
    for (;;)
    {
      this.EsW = i;
      AppMethodBeat.o(198179);
      return;
      label298:
      this.EsV = false;
      super.Hs(-2);
      ae.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
    }
  }
  
  public final boolean eVK()
  {
    return this.EsV;
  }
  
  public final int getKeyBoardHeight()
  {
    return this.EsX;
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