package com.tencent.mm.plugin.repairer.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/RepairerGroupUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerPrefUI;", "()V", "ui-repairer_release"})
public final class RepairerGroupUI
  extends BaseRepairerPrefUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerGroupUI
 * JD-Core Version:    0.7.0.1
 */