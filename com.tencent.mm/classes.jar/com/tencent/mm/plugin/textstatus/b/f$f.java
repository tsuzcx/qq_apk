package com.tencent.mm.plugin.textstatus.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.y.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$badgeListener$1", "Lcom/tencent/mm/hub/NewBadge$ISourceListener;", "onChanged", "", "dataSourceKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "type", "", "value", "", "dataSourceId", "plugin-textstatus_release"})
public final class f$f
  implements a.a
{
  public final void D(int paramInt, String paramString)
  {
    AppMethodBeat.i(258408);
    paramString = g.aAh();
    p.g(paramString, "MMKernel.storage()");
    paramString.azQ().set(ar.a.Uui, Long.valueOf(System.currentTimeMillis()));
    Log.i("MicroMsg.TxtStatus.TextStatusInfoManager", "bradge mark read");
    AppMethodBeat.o(258408);
  }
  
  public final void b(ar.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.f.f
 * JD-Core Version:    0.7.0.1
 */