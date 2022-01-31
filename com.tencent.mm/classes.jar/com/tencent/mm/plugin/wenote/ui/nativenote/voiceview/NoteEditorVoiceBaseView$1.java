package com.tencent.mm.plugin.wenote.ui.nativenote.voiceview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.wenote.model.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class NoteEditorVoiceBaseView$1
  implements View.OnClickListener
{
  NoteEditorVoiceBaseView$1(NoteEditorVoiceBaseView paramNoteEditorVoiceBaseView) {}
  
  public final void onClick(View paramView)
  {
    String str2 = NoteEditorVoiceBaseView.a(this.rNF);
    String str1;
    if (a.cjx().aQk())
    {
      str1 = "true";
      y.i("MicroMsg.NoteEditorVoiceBaseView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str2, str1, a.cjx().path });
      if ((!com.tencent.mm.r.a.bk(NoteEditorVoiceBaseView.b(this.rNF))) && (!com.tencent.mm.r.a.bi(NoteEditorVoiceBaseView.b(this.rNF)))) {
        break label81;
      }
    }
    label81:
    do
    {
      return;
      str1 = "false";
      break;
      if ((!f.zF()) && (!bk.bl(NoteEditorVoiceBaseView.a(this.rNF))))
      {
        s.gM(paramView.getContext());
        return;
      }
    } while (k.chy().ibC);
    if ((bk.aM(NoteEditorVoiceBaseView.a(this.rNF), "").equals(a.cjx().path)) && (a.cjx().aQk()))
    {
      paramView = this.rNF;
      y.d("MicroMsg.NoteEditorVoiceBaseView", "stop play");
      paramView.bvP();
      a.cjx().stopPlay();
      return;
    }
    NoteEditorVoiceBaseView.c(this.rNF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.NoteEditorVoiceBaseView.1
 * JD-Core Version:    0.7.0.1
 */