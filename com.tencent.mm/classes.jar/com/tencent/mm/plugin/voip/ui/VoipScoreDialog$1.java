package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class VoipScoreDialog$1
  implements View.OnClickListener
{
  VoipScoreDialog$1(VoipScoreDialog paramVoipScoreDialog, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(115379);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voip/ui/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    VoipScoreDialog.a(this.CBv, this.val$index);
    a.a(this, "com/tencent/mm/plugin/voip/ui/VoipScoreDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(115379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipScoreDialog.1
 * JD-Core Version:    0.7.0.1
 */