package com.tencent.mm.plugin.transvoice.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;

public class TransVoicePanelLayout
  extends InputPanelFrameLayout
{
  TransVoicePanelLayout.a tqM;
  
  public TransVoicePanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TransVoicePanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(155205);
    super.p(paramBoolean, paramInt);
    ab.d("TransVoicePanelLayout", "isKeyboardShow: %s, keyboardHeight: %d.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.tqM != null) {
      this.tqM.p(paramBoolean, paramInt);
    }
    AppMethodBeat.o(155205);
  }
  
  void setOnInputPanelChange(TransVoicePanelLayout.a parama)
  {
    this.tqM = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.TransVoicePanelLayout
 * JD-Core Version:    0.7.0.1
 */