package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class VoiceInputFooter$3
  implements View.OnClickListener
{
  VoiceInputFooter$3(VoiceInputFooter paramVoiceInputFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31257);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    VoiceInputFooter.c(this.Ree);
    a.a(this, "com/tencent/mm/pluginsdk/ui/VoiceInputFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputFooter.3
 * JD-Core Version:    0.7.0.1
 */