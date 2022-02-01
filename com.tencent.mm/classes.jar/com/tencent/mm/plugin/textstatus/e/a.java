package com.tencent.mm.plugin.textstatus.e;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.proto.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/logic/BaseDetailLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "update", "", "username", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "extraParam", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "plugin-textstatus_release"})
public final class a
  extends c
{
  public a(r paramr)
  {
    super(paramr);
    AppMethodBeat.i(235296);
    AppMethodBeat.o(235296);
  }
  
  public final boolean b(String paramString, com.tencent.mm.plugin.textstatus.g.e.a parama, i parami)
  {
    AppMethodBeat.i(235294);
    p.k(paramString, "username");
    boolean bool = super.b(paramString, parama, parami);
    paramString = this.MCs;
    if ((bool) && (paramString != null))
    {
      parama = glJ();
      if (parama != null) {
        parama.setText((CharSequence)com.tencent.mm.plugin.textstatus.k.c.gnz().d(paramString.glY()));
      }
      paramString = glJ();
      if (paramString != null) {
        paramString.setVisibility(0);
      }
    }
    AppMethodBeat.o(235294);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.a
 * JD-Core Version:    0.7.0.1
 */