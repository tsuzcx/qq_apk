package com.tencent.mm.plugin.wear.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WearYoNoLockUI
  extends WearYoUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.ui.WearYoNoLockUI
 * JD-Core Version:    0.7.0.1
 */