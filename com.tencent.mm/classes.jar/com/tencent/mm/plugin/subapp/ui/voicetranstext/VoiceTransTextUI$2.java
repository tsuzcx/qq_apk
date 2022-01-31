package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

final class VoiceTransTextUI$2
  implements View.OnLongClickListener
{
  VoiceTransTextUI$2(VoiceTransTextUI paramVoiceTransTextUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(25593);
    ab.d("MicroMsg.VoiceTransTextUI", "onLongClick");
    paramView = this.taB;
    String str = this.taB.getString(2131296895);
    VoiceTransTextUI.2.1 local1 = new VoiceTransTextUI.2.1(this);
    h.a(paramView, "", new String[] { str }, "", local1);
    AppMethodBeat.o(25593);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.2
 * JD-Core Version:    0.7.0.1
 */