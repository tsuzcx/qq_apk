package com.tencent.mm.plugin.transvoice.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;

public class TransVoicePanelLayout
  extends InputPanelFrameLayout
{
  a yYI;
  
  public TransVoicePanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TransVoicePanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(102632);
    super.g(paramBoolean, paramInt);
    ad.d("TransVoicePanelLayout", "isKeyboardShow: %s, keyboardHeight: %d.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.yYI != null) {
      this.yYI.g(paramBoolean, paramInt);
    }
    AppMethodBeat.o(102632);
  }
  
  void setOnInputPanelChange(a parama)
  {
    this.yYI = parama;
  }
  
  static abstract interface a
  {
    public abstract void g(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.TransVoicePanelLayout
 * JD-Core Version:    0.7.0.1
 */