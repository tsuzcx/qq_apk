package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

final class NoteEditorVoiceBaseView$1
  implements View.OnClickListener
{
  NoteEditorVoiceBaseView$1(NoteEditorVoiceBaseView paramNoteEditorVoiceBaseView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27188);
    String str2 = NoteEditorVoiceBaseView.a(this.vEj);
    if (a.djZ().bwz()) {}
    for (String str1 = "true";; str1 = "false")
    {
      ab.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str2, str1, a.djZ().path });
      if ((!com.tencent.mm.r.a.bO(NoteEditorVoiceBaseView.b(this.vEj))) && (!com.tencent.mm.r.a.bM(NoteEditorVoiceBaseView.b(this.vEj)))) {
        break;
      }
      AppMethodBeat.o(27188);
      return;
    }
    if ((!f.Mi()) && (!bo.isNullOrNil(NoteEditorVoiceBaseView.a(this.vEj))))
    {
      t.ii(paramView.getContext());
      AppMethodBeat.o(27188);
      return;
    }
    if (k.dhL().mwK)
    {
      AppMethodBeat.o(27188);
      return;
    }
    if ((bo.bf(NoteEditorVoiceBaseView.a(this.vEj), "").equals(a.djZ().path)) && (a.djZ().bwz()))
    {
      paramView = this.vEj;
      ab.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
      paramView.cgf();
      a.djZ().stopPlay();
      AppMethodBeat.o(27188);
      return;
    }
    NoteEditorVoiceBaseView.c(this.vEj);
    AppMethodBeat.o(27188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView.1
 * JD-Core Version:    0.7.0.1
 */