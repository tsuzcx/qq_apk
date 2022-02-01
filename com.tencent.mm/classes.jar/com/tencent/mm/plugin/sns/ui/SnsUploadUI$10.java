package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;

final class SnsUploadUI$10
  implements a.e
{
  SnsUploadUI$10(SnsUploadUI paramSnsUploadUI)
  {
    AppMethodBeat.i(307875);
    AppMethodBeat.o(307875);
  }
  
  public final void I(List<a.c> paramList, int paramInt)
  {
    AppMethodBeat.i(369915);
    long l = cn.getSyncServerTimeSecond();
    if ((((com.tencent.mm.plugin.websearch.api.c)h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramInt != 8) && (paramInt != 1) && (!aj.aBu()))
    {
      paramList.add(new a.c(SnsUploadUI.a(this.REd).jEK().getString(b.j.tag_search_word), 2));
      SnsUploadUI.a(1, "", "", l, SnsUploadUI.O(this.REd));
    }
    AppMethodBeat.o(369915);
  }
  
  public final void a(View paramView, a.c paramc, String paramString)
  {
    AppMethodBeat.i(369916);
    long l = cn.getSyncServerTimeSecond();
    if (paramc.id == 2)
    {
      SnsUploadUI.a(this.REd).getText().insert(SnsUploadUI.a(this.REd).getSelectionStart(), SnsUploadUI.a(this.REd).jEK().getString(b.j.tag_search_word));
      SnsUploadUI.a(2, "", "", l, SnsUploadUI.O(this.REd));
    }
    AppMethodBeat.o(369916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.10
 * JD-Core Version:    0.7.0.1
 */