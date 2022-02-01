package com.tencent.mm.plugin.transvoice.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;

public class TransVoicePanelLayout
  extends InputPanelFrameLayout
{
  a TWB;
  
  public TransVoicePanelLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TransVoicePanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(102632);
    super.onInputPanelChange(paramBoolean, paramInt);
    Log.d("TransVoicePanelLayout", "isKeyboardShow: %s, keyboardHeight: %d.", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.TWB != null) {
      this.TWB.onInputPanelChange(paramBoolean, paramInt);
    }
    AppMethodBeat.o(102632);
  }
  
  void setOnInputPanelChange(a parama)
  {
    this.TWB = parama;
  }
  
  static abstract interface a
  {
    public abstract void onInputPanelChange(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.TransVoicePanelLayout
 * JD-Core Version:    0.7.0.1
 */