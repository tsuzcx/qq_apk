package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;

final class SnsCommentUI$5
  implements a.e
{
  SnsCommentUI$5(SnsCommentUI paramSnsCommentUI) {}
  
  public final void B(List<a.c> paramList, int paramInt)
  {
    AppMethodBeat.i(270249);
    long l = cm.bfF();
    if ((((com.tencent.mm.plugin.websearch.api.c)h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramInt != 8) && (paramInt != 1))
    {
      paramList.add(new a.c(this.KRc.getContext().getString(i.j.tag_search_word), 2));
      if (this.KRc.Jws == null) {
        this.KRc.Jws = aj.fOI().agI(SnsCommentUI.d(this.KRc));
      }
      SnsCommentFooter.a(this.KRc.getContext(), this.KRc.Jws, false, "", 1, "", l);
    }
    AppMethodBeat.o(270249);
  }
  
  public final void a(View paramView, a.c paramc, String paramString)
  {
    AppMethodBeat.i(270250);
    long l = cm.bfF();
    if (paramc.id == 2)
    {
      SnsCommentUI.b(this.KRc).getText().insert(SnsCommentUI.b(this.KRc).getSelectionStart(), this.KRc.getContext().getString(i.j.tag_search_word));
      SnsCommentFooter.a(this.KRc.getContext(), this.KRc.Jws, false, "", 2, "", l);
    }
    AppMethodBeat.o(270250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentUI.5
 * JD-Core Version:    0.7.0.1
 */