package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;

final class SnsUploadUI$8
  implements a.e
{
  SnsUploadUI$8(SnsUploadUI paramSnsUploadUI) {}
  
  public final void A(List<a.c> paramList, int paramInt)
  {
    AppMethodBeat.i(203765);
    long l = cl.aWB();
    if ((((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramInt != 8) && (paramInt != 1))
    {
      paramList.add(new a.c(SnsUploadUI.a(this.EPZ).gYK().getString(2131766606), 2));
      SnsUploadUI.a(1, "", "", l, SnsUploadUI.N(this.EPZ));
    }
    AppMethodBeat.o(203765);
  }
  
  public final void a(View paramView, a.c paramc, String paramString)
  {
    AppMethodBeat.i(203766);
    long l = cl.aWB();
    if (paramc.id == 2)
    {
      SnsUploadUI.a(this.EPZ).getText().insert(SnsUploadUI.a(this.EPZ).getSelectionStart(), SnsUploadUI.a(this.EPZ).gYK().getString(2131766606));
      SnsUploadUI.a(2, "", "", l, SnsUploadUI.N(this.EPZ));
    }
    AppMethodBeat.o(203766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.8
 * JD-Core Version:    0.7.0.1
 */