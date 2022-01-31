package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class VoiceTransTextUI$2
  implements View.OnLongClickListener
{
  VoiceTransTextUI$2(VoiceTransTextUI paramVoiceTransTextUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    y.d("MicroMsg.VoiceTransTextUI", "onLongClick");
    paramView = this.pyO;
    String str = this.pyO.getString(R.l.app_copy);
    VoiceTransTextUI.2.1 local1 = new VoiceTransTextUI.2.1(this);
    h.a(paramView, "", new String[] { str }, "", local1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.2
 * JD-Core Version:    0.7.0.1
 */