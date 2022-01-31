package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class VoipVideoFragment$17
  implements View.OnClickListener
{
  VoipVideoFragment$17(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(4894);
    ab.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
    if ((this.tEo.tCc != null) && (this.tEo.tCc.get() != null) && (((c)this.tEo.tCc.get()).cMP()))
    {
      VoipVideoFragment.a(this.tEo).setEnabled(false);
      VoipVideoFragment.f(this.tEo).setEnabled(false);
      VoipVideoFragment.g(this.tEo).setVisibility(0);
      VoipVideoFragment.g(this.tEo).setText(2131304637);
    }
    AppMethodBeat.o(4894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.17
 * JD-Core Version:    0.7.0.1
 */