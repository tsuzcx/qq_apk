package com.tencent.mm.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ao;

final class MMAppMgr$4
  implements CompoundButton.OnCheckedChangeListener
{
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(33406);
    bg.aVF();
    paramCompoundButton = c.azQ();
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramCompoundButton.set(16385, Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(33406);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.4
 * JD-Core Version:    0.7.0.1
 */