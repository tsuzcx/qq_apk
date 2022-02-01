package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class VoiceTransTextUI$1
  implements View.OnClickListener
{
  VoiceTransTextUI$1(VoiceTransTextUI paramVoiceTransTextUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29281);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.FOa.finish();
    a.a(this, "com/tencent/mm/plugin/subapp/ui/voicetranstext/VoiceTransTextUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(29281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI.1
 * JD-Core Version:    0.7.0.1
 */