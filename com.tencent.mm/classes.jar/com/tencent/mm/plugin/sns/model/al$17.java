package com.tencent.mm.plugin.sns.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.plugin.secdata.i;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.pluginsdk.ui.span.o.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class al$17
  implements bf.a
{
  al$17(al paramal) {}
  
  public final void a(q paramq) {}
  
  public final void bF(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(309531);
    if ((paramBoolean) && (((c)h.az(c.class)).isOpenInlineSnsTag()) && (paramInt > 0)) {
      ((g)h.az(g.class)).getWithClear(2, "SnsPostEnd_".concat(String.valueOf(paramInt)), j.class, new i() {});
    }
    AppMethodBeat.o(309531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.al.17
 * JD-Core Version:    0.7.0.1
 */