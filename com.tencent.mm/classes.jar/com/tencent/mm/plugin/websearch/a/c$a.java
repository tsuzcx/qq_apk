package com.tencent.mm.plugin.websearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.og;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.eql;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/websearch/tagsearch/TagSearchUILogic$startTagSearchDialog$listenerWrapper$1", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "appendSearchTag", "", "tag", "", "enterType", "", "onDismiss", "onSearchShare", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "ui-websearch_release"})
public final class c$a
  implements com.tencent.mm.plugin.websearch.a.a.a
{
  public c$a(com.tencent.mm.plugin.websearch.a.a.a parama, aa.f paramf, String paramString1, String paramString2) {}
  
  public final void a(ccn paramccn)
  {
    AppMethodBeat.i(198580);
    p.k(paramccn, "shareContent");
    this.PAq.a(paramccn);
    ((eql)this.PAr.aaBC).UsU = 1;
    AppMethodBeat.o(198580);
  }
  
  public final void gO(String paramString, int paramInt)
  {
    AppMethodBeat.i(198579);
    p.k(paramString, "tag");
    this.PAq.gO(paramString, paramInt);
    AppMethodBeat.o(198579);
  }
  
  public final void onDismiss()
  {
    long l = 2L;
    AppMethodBeat.i(198577);
    this.PAq.onDismiss();
    Object localObject = new og();
    ((og)localObject).aof();
    if (((eql)this.PAr.aaBC).UsU == 1)
    {
      ((og)localObject).AG(1L);
      ((og)localObject).AH(this.PAs);
      ((og)localObject).AI(cm.bfF());
      if (!ab.Lj(this.sJQ)) {
        break label192;
      }
    }
    for (;;)
    {
      ((og)localObject).AJ(l);
      ((og)localObject).Fe(this.sJQ);
      ((og)localObject).Ff(this.uKj);
      ((og)localObject).Fg(((eql)this.PAr.aaBC).fwe);
      ((og)localObject).bpa();
      ar.a((com.tencent.mm.plugin.report.a)localObject);
      localObject = c.PAp;
      Log.i(c.gRo(), "stopTagSearchDialog url:" + ((eql)this.PAr.aaBC).url);
      AppMethodBeat.o(198577);
      return;
      ((og)localObject).AG(2L);
      break;
      label192:
      l = 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.c.a
 * JD-Core Version:    0.7.0.1
 */