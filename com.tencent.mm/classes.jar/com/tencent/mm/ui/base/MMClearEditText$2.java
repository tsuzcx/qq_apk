package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMClearEditText$2
  implements View.OnFocusChangeListener
{
  MMClearEditText$2(MMClearEditText paramMMClearEditText) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(106505);
    if (MMClearEditText.b(this.zja) != null) {
      MMClearEditText.b(this.zja).onFocusChange(paramView, paramBoolean);
    }
    MMClearEditText.a(this.zja);
    AppMethodBeat.o(106505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText.2
 * JD-Core Version:    0.7.0.1
 */