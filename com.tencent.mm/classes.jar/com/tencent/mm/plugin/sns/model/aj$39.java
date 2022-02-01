package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class aj$39
  implements be.a
{
  aj$39(aj paramaj) {}
  
  public final void aP(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(202763);
    if ((paramBoolean) && (((c)com.tencent.mm.kernel.g.ah(c.class)).isOpenInlineSnsTag()) && (paramInt > 0)) {
      ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.secdata.g.class)).getWithClear(2, "SnsPostEnd_".concat(String.valueOf(paramInt)), j.class, new i() {});
    }
    AppMethodBeat.o(202763);
  }
  
  public final void fbl() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj.39
 * JD-Core Version:    0.7.0.1
 */