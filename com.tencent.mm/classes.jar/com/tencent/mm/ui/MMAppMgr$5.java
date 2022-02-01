package com.tencent.mm.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ab;

final class MMAppMgr$5
  implements CompoundButton.OnCheckedChangeListener
{
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(33407);
    if (paramBoolean)
    {
      az.arV();
      c.afk().set(4105, Boolean.TRUE);
      AppMethodBeat.o(33407);
      return;
    }
    az.arV();
    c.afk().set(4105, Boolean.FALSE);
    AppMethodBeat.o(33407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.5
 * JD-Core Version:    0.7.0.1
 */