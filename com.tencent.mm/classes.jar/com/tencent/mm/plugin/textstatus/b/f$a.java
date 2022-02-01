package com.tencent.mm.plugin.textstatus.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$badgeListener$1", "Lcom/tencent/mm/hub/NewBadge$ISourceListener;", "onChanged", "", "dataSourceKey", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "type", "", "value", "", "dataSourceId", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$a
  implements a.a
{
  public final void D(int paramInt, String paramString)
  {
    AppMethodBeat.i(290207);
    h.baE().ban().set(at.a.adgL, Long.valueOf(System.currentTimeMillis()));
    Log.i("MicroMsg.TextStatus.TextStatusInfoManager", "bradge mark read");
    AppMethodBeat.o(290207);
  }
  
  public final void b(at.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.b.f.a
 * JD-Core Version:    0.7.0.1
 */