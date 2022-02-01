package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout
  extends KeyboardLinearLayout
{
  protected boolean WUW;
  private int WUX;
  private int WUY;
  private int WUZ;
  private int WVa = -1;
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
  
  private int getHideKeyHeightRate()
  {
    AppMethodBeat.i(296357);
    int i;
    if (this.WVa < 0)
    {
      i = ((c)h.ax(c.class)).a(c.a.yNw, 10);
      if (i <= 0) {
        break label73;
      }
    }
    for (;;)
    {
      this.WVa = i;
      Log.i("MicroMsg.WebViewKeyboardLinearLayout", "hide rate:%d", new Object[] { Integer.valueOf(this.WVa) });
      i = this.WVa;
      AppMethodBeat.o(296357);
      return i;
      label73:
      i = 10;
    }
  }
  
  public final void aup(int paramInt)
  {
    AppMethodBeat.i(296375);
    Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + paramInt + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.WUW);
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    int i = getRootView().getHeight();
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      Log.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      super.onKeyBoardStateChange(-1);
      this.WUZ = (i - localRect.bottom);
    }
    Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", new Object[] { localRect.toString() });
    i = localRect.height();
    this.mHeight = i;
    Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.WUX) });
    if (this.WUX != i)
    {
      int j = getRootView().getHeight() - this.WUZ - localRect.top;
      int k = j - i;
      if (k <= j / getHideKeyHeightRate()) {
        break label301;
      }
      this.WUW = true;
      this.WUY = k;
      super.onKeyBoardStateChange(-3);
      Log.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt + " mKBHeight: " + this.WUY);
    }
    for (;;)
    {
      this.WUX = i;
      AppMethodBeat.o(296375);
      return;
      label301:
      this.WUW = false;
      super.onKeyBoardStateChange(-2);
      Log.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
    }
  }
  
  public final int getKeyBoardHeight()
  {
    return this.WUY;
  }
  
  public final void onKeyBoardStateChange(int paramInt)
  {
    AppMethodBeat.i(369833);
    super.onKeyBoardStateChange(paramInt);
    AppMethodBeat.o(369833);
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