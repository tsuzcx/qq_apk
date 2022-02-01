package com.tencent.mm.plugin.repairer.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerGroupUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerPrefUI;", "()V", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerGroupUI
  extends BaseRepairerPrefUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerGroupUI
 * JD-Core Version:    0.7.0.1
 */