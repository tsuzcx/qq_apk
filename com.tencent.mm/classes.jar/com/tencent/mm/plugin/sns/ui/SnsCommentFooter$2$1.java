package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ui.widget.g;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.storage.emotion.EmojiInfo;

final class SnsCommentFooter$2$1
  implements y.a
{
  SnsCommentFooter$2$1(SnsCommentFooter.2 param2, t paramt) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(369899);
    if ((SnsCommentFooter.r(this.akiN.RqJ) != null) && (paramBoolean)) {
      if (!g.lU(SnsCommentFooter.c(this.akiN.RqJ), 8)) {
        break label94;
      }
    }
    label94:
    for (paramString = this.akiN.RqJ.getCommentAtPrefix();; paramString = "")
    {
      SnsCommentFooter.r(this.akiN.RqJ).mU(paramString, ((EmojiInfo)this.akiM).field_md5);
      h.OAn.kJ(150, 81);
      AppMethodBeat.o(369899);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.2.1
 * JD-Core Version:    0.7.0.1
 */