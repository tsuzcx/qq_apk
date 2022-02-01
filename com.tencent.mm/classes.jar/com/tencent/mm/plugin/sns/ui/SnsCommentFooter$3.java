package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;

final class SnsCommentFooter$3
  implements a.e
{
  SnsCommentFooter$3(SnsCommentFooter paramSnsCommentFooter)
  {
    AppMethodBeat.i(308417);
    AppMethodBeat.o(308417);
  }
  
  public final void I(List<a.c> paramList, int paramInt)
  {
    AppMethodBeat.i(369943);
    long l = cn.getSyncServerTimeSecond();
    if ((((com.tencent.mm.plugin.websearch.api.c)h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramInt != 8) && (paramInt != 1) && (!aj.aBu()))
    {
      paramList.add(new a.c(SnsCommentFooter.j(this.RqJ).getString(b.j.tag_search_word), 2));
      SnsCommentFooter.a(this.RqJ.getContext(), this.RqJ.getTag(), SnsCommentFooter.s(this.RqJ), "", 1, "", l);
    }
    AppMethodBeat.o(369943);
  }
  
  public final void a(View paramView, a.c paramc, String paramString)
  {
    AppMethodBeat.i(369944);
    long l = cn.getSyncServerTimeSecond();
    if (paramc.id == 2)
    {
      SnsCommentFooter.b(this.RqJ).getText().insert(SnsCommentFooter.b(this.RqJ).getSelectionStart(), SnsCommentFooter.j(this.RqJ).getString(b.j.tag_search_word));
      SnsCommentFooter.a(this.RqJ.getContext(), this.RqJ.getTag(), SnsCommentFooter.s(this.RqJ), "", 2, "", l);
    }
    AppMethodBeat.o(369944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.3
 * JD-Core Version:    0.7.0.1
 */