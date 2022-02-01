package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BaseVoicePrintUI$2
  implements View.OnClickListener
{
  BaseVoicePrintUI$2(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29812);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voiceprint/ui/BaseVoicePrintUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.BWj.finish();
    a.a(this, "com/tencent/mm/plugin/voiceprint/ui/BaseVoicePrintUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(29812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.2
 * JD-Core Version:    0.7.0.1
 */