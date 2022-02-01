package com.tencent.mm.plugin.websearch.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ry;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.flp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/websearch/tagsearch/TagSearchUILogic$startTagSearchDialog$listenerWrapper$1", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "appendSearchTag", "", "tag", "", "enterType", "", "onDismiss", "onSearchShare", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$a
  implements com.tencent.mm.plugin.websearch.b.a.a
{
  public c$a(com.tencent.mm.plugin.websearch.b.a.a parama, ah.f<flp> paramf, String paramString1, String paramString2) {}
  
  public final void a(cry paramcry)
  {
    AppMethodBeat.i(315396);
    s.u(paramcry, "shareContent");
    this.WqQ.a(paramcry);
    ((flp)this.WqR.aqH).abMb = 1;
    AppMethodBeat.o(315396);
  }
  
  public final void hN(String paramString, int paramInt)
  {
    AppMethodBeat.i(315394);
    s.u(paramString, "tag");
    this.WqQ.hN(paramString, paramInt);
    AppMethodBeat.o(315394);
  }
  
  public final void onDismiss()
  {
    long l = 2L;
    AppMethodBeat.i(315391);
    this.WqQ.onDismiss();
    ry localry = new ry();
    localry.ioV = 2L;
    if (((flp)this.WqR.aqH).abMb == 1)
    {
      localry.jwW = 1L;
      localry.jwX = this.WqS;
      localry.iow = cn.getSyncServerTimeSecond();
      if (!au.bwE(this.FyP)) {
        break label175;
      }
    }
    for (;;)
    {
      localry.izg = l;
      localry.yJ(this.FyP);
      localry.yK(this.AGN);
      localry.yL(((flp)this.WqR.aqH).hAB);
      localry.bMH();
      as.a((com.tencent.mm.plugin.report.a)localry);
      Log.i(c.aUw(), s.X("stopTagSearchDialog url:", ((flp)this.WqR.aqH).url));
      AppMethodBeat.o(315391);
      return;
      localry.jwW = 2L;
      break;
      label175:
      l = 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.c.a
 * JD-Core Version:    0.7.0.1
 */