package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;

final class SnsCommentFooter$2
  implements a.e
{
  SnsCommentFooter$2(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void B(List<a.c> paramList, int paramInt)
  {
    AppMethodBeat.i(194039);
    long l = cm.bfF();
    if ((((com.tencent.mm.plugin.websearch.api.c)h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramInt != 8) && (paramInt != 1))
    {
      paramList.add(new a.c(SnsCommentFooter.h(this.KQR).getString(i.j.tag_search_word), 2));
      SnsCommentFooter.a(this.KQR.getContext(), this.KQR.getTag(), SnsCommentFooter.r(this.KQR), "", 1, "", l);
    }
    AppMethodBeat.o(194039);
  }
  
  public final void a(View paramView, a.c paramc, String paramString)
  {
    AppMethodBeat.i(194042);
    long l = cm.bfF();
    if (paramc.id == 2)
    {
      SnsCommentFooter.b(this.KQR).getText().insert(SnsCommentFooter.b(this.KQR).getSelectionStart(), SnsCommentFooter.h(this.KQR).getString(i.j.tag_search_word));
      SnsCommentFooter.a(this.KQR.getContext(), this.KQR.getTag(), SnsCommentFooter.r(this.KQR), "", 2, "", l);
    }
    AppMethodBeat.o(194042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.2
 * JD-Core Version:    0.7.0.1
 */