package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout
  extends KeyboardLinearLayout
{
  boolean Qdk;
  private int Qdl;
  private int Qdm;
  private int Qdn;
  private int Qdo = -1;
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
    AppMethodBeat.i(267722);
    int i;
    if (this.Qdo < 0)
    {
      i = ((b)h.ae(b.class)).a(b.a.vzO, 10);
      if (i <= 0) {
        break label73;
      }
    }
    for (;;)
    {
      this.Qdo = i;
      Log.i("MicroMsg.WebViewKeyboardLinearLayout", "hide rate:%d", new Object[] { Integer.valueOf(this.Qdo) });
      i = this.Qdo;
      AppMethodBeat.o(267722);
      return i;
      label73:
      i = 10;
    }
  }
  
  public final void SG(int paramInt)
  {
    AppMethodBeat.i(293245);
    super.SG(paramInt);
    AppMethodBeat.o(293245);
  }
  
  public final void aow(int paramInt)
  {
    AppMethodBeat.i(292654);
    Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + paramInt + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.Qdk);
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    int i = getRootView().getHeight();
    if (!this.mHasInit)
    {
      this.mHasInit = true;
      this.mHeight = paramInt;
      Log.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", new Object[] { Integer.valueOf(this.mHeight) });
      super.SG(-1);
      this.Qdn = (i - localRect.bottom);
    }
    Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", new Object[] { localRect.toString() });
    i = localRect.height();
    this.mHeight = i;
    Log.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Qdl) });
    if (this.Qdl != i)
    {
      int j = getRootView().getHeight() - this.Qdn - localRect.top;
      int k = j - i;
      if (k <= j / getHideKeyHeightRate()) {
        break label301;
      }
      this.Qdk = true;
      this.Qdm = k;
      super.SG(-3);
      Log.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.mHeight + " b: " + paramInt + " mKBHeight: " + this.Qdm);
    }
    for (;;)
    {
      this.Qdl = i;
      AppMethodBeat.o(292654);
      return;
      label301:
      this.Qdk = false;
      super.SG(-2);
      Log.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.mHeight + " b: " + paramInt);
    }
  }
  
  public final boolean gXJ()
  {
    return this.Qdk;
  }
  
  public final int getKeyBoardHeight()
  {
    return this.Qdm;
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