package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VoiceInputLayoutImpl$1
  implements View.OnLongClickListener
{
  VoiceInputLayoutImpl$1(VoiceInputLayoutImpl paramVoiceInputLayoutImpl) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(27586);
    ab.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(this.vSA.currentState) });
    VoiceInputLayoutImpl.a(this.vSA, true);
    VoiceInputLayoutImpl.a(this.vSA).dnm();
    AppMethodBeat.o(27586);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.1
 * JD-Core Version:    0.7.0.1
 */