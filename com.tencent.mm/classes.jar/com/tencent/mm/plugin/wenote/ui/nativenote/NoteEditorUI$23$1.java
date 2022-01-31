package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.wenote.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.s;
import java.util.Map;

final class NoteEditorUI$23$1
  implements n.c
{
  NoteEditorUI$23$1(NoteEditorUI.23 param23) {}
  
  public final void a(l paraml)
  {
    if (NoteEditorUI.d(this.rMa.rLT) == 1)
    {
      paraml.e(4, this.rMa.rLT.getString(R.l.favorite_share_with_friend));
      NoteEditorUI.a(this.rMa.rLT, paraml);
      paraml.e(3, this.rMa.rLT.getString(R.l.plugin_favorite_opt));
      return;
    }
    String str;
    if (NoteEditorUI.d(this.rMa.rLT) == 2)
    {
      paraml.e(0, this.rMa.rLT.getString(R.l.favorite_share_with_friend));
      if (a.cjj()) {
        paraml.e(7, this.rMa.rLT.mController.uMN.getString(R.l.favorite_post_to_sns));
      }
      if (!NoteEditorUI.e(this.rMa.rLT)) {
        paraml.e(14, this.rMa.rLT.getString(R.l.favorite_save_as_note));
      }
      str = (String)com.tencent.mm.model.c.c.IX().fJ("100353").ctr().get("Close");
      if (bk.bl(str)) {
        break label381;
      }
    }
    label381:
    for (int i = bk.getInt(str, 0);; i = 0)
    {
      if (i == 0) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          paraml.e(8, this.rMa.rLT.mController.uMN.getString(R.l.note_share_with_longpic));
        }
        NoteEditorUI.a(this.rMa.rLT, paraml);
        paraml.e(1, this.rMa.rLT.getString(R.l.favorite_edit_tag_tips));
        paraml.e(2, this.rMa.rLT.mController.uMN.getString(R.l.app_delete));
        return;
      }
      if (NoteEditorUI.d(this.rMa.rLT) != 4) {
        break;
      }
      paraml.e(9, this.rMa.rLT.getString(R.l.favorite_share_with_friend));
      if (a.cjj()) {
        paraml.e(12, this.rMa.rLT.mController.uMN.getString(R.l.favorite_post_to_sns));
      }
      paraml.e(10, this.rMa.rLT.getString(R.l.plugin_favorite_opt));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.1
 * JD-Core Version:    0.7.0.1
 */