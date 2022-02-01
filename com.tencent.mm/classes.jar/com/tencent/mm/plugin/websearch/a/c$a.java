package com.tencent.mm.plugin.websearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lj;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.egj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/websearch/tagsearch/TagSearchUILogic$startTagSearchDialog$listenerWrapper$1", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "appendSearchTag", "", "tag", "", "enterType", "", "onDismiss", "onSearchShare", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "ui-websearch_release"})
public final class c$a
  implements com.tencent.mm.plugin.websearch.a.a.a
{
  public c$a(com.tencent.mm.plugin.websearch.a.a.a parama, z.f paramf, String paramString1, String paramString2) {}
  
  public final void a(buv parambuv)
  {
    AppMethodBeat.i(197947);
    p.h(parambuv, "shareContent");
    this.IFZ.a(parambuv);
    ((egj)this.IGa.SYG).Ngq = 1;
    AppMethodBeat.o(197947);
  }
  
  public final void gf(String paramString, int paramInt)
  {
    AppMethodBeat.i(197946);
    p.h(paramString, "tag");
    this.IFZ.gf(paramString, paramInt);
    AppMethodBeat.o(197946);
  }
  
  public final void onDismiss()
  {
    long l = 2L;
    AppMethodBeat.i(197945);
    this.IFZ.onDismiss();
    Object localObject = new lj();
    ((lj)localObject).aiB();
    if (((egj)this.IGa.SYG).Ngq == 1)
    {
      ((lj)localObject).uR(1L);
      ((lj)localObject).uS(this.IGb);
      ((lj)localObject).uT(cl.aWB());
      if (!ab.Eq(this.vdJ)) {
        break label192;
      }
    }
    for (;;)
    {
      ((lj)localObject).uU(l);
      ((lj)localObject).yD(this.vdJ);
      ((lj)localObject).yE(this.rha);
      ((lj)localObject).yF(((egj)this.IGa.SYG).dDv);
      ((lj)localObject).bfK();
      ar.a((com.tencent.mm.plugin.report.a)localObject);
      localObject = c.IFY;
      Log.i(c.fYD(), "stopTagSearchDialog url:" + ((egj)this.IGa.SYG).url);
      AppMethodBeat.o(197945);
      return;
      ((lj)localObject).uR(2L);
      break;
      label192:
      l = 1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.c.a
 * JD-Core Version:    0.7.0.1
 */