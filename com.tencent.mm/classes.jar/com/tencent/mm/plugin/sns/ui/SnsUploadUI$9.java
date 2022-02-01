package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;

final class SnsUploadUI$9
  implements a.e
{
  SnsUploadUI$9(SnsUploadUI paramSnsUploadUI)
  {
    AppMethodBeat.i(219422);
    AppMethodBeat.o(219422);
  }
  
  public final void B(List<a.c> paramList, int paramInt)
  {
    AppMethodBeat.i(292929);
    long l = cm.bfF();
    if ((((com.tencent.mm.plugin.websearch.api.c)h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramInt != 8) && (paramInt != 1))
    {
      paramList.add(new a.c(SnsUploadUI.a(this.LdU).hZC().getString(i.j.tag_search_word), 2));
      SnsUploadUI.a(1, "", "", l, SnsUploadUI.N(this.LdU));
    }
    AppMethodBeat.o(292929);
  }
  
  public final void a(View paramView, a.c paramc, String paramString)
  {
    AppMethodBeat.i(292930);
    long l = cm.bfF();
    if (paramc.id == 2)
    {
      SnsUploadUI.a(this.LdU).getText().insert(SnsUploadUI.a(this.LdU).getSelectionStart(), SnsUploadUI.a(this.LdU).hZC().getString(i.j.tag_search_word));
      SnsUploadUI.a(2, "", "", l, SnsUploadUI.N(this.LdU));
    }
    AppMethodBeat.o(292930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.9
 * JD-Core Version:    0.7.0.1
 */