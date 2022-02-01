package com.tencent.mm.plugin.ringtone.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.uic.BaseRingtoneUI;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/ui/RingtoneOccupyUI2;", "Lcom/tencent/mm/plugin/ringtone/uic/BaseRingtoneUI;", "()V", "getLayoutId", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RingtoneOccupyUI2
  extends BaseRingtoneUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return 0;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.ui.RingtoneOccupyUI2
 * JD-Core Version:    0.7.0.1
 */