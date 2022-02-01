package com.tencent.mm.plugin.textstatus.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$badgeListener$1", "Lcom/tencent/mm/hub/NewBadge$ISourceListener;", "onChanged", "", "dataSourceKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "type", "", "value", "", "dataSourceId", "plugin-textstatus_release"})
public final class f$b
  implements a.a
{
  public final void E(int paramInt, String paramString)
  {
    AppMethodBeat.i(237746);
    paramString = h.aHG();
    p.j(paramString, "MMKernel.storage()");
    paramString.aHp().set(ar.a.VDK, Long.valueOf(System.currentTimeMillis()));
    Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "bradge mark read");
    AppMethodBeat.o(237746);
  }
  
  public final void b(ar.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.f.b
 * JD-Core Version:    0.7.0.1
 */