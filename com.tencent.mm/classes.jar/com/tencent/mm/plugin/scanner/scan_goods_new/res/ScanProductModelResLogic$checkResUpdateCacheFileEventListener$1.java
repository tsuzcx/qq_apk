package com.tencent.mm.plugin.scanner.scan_goods_new.res;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cd.a;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/scan_goods_new/res/ScanProductModelResLogic$checkResUpdateCacheFileEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanProductModelResLogic$checkResUpdateCacheFileEventListener$1
  extends IListener<cd>
{
  ScanProductModelResLogic$checkResUpdateCacheFileEventListener$1(f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(313958);
    AppMethodBeat.o(313958);
  }
  
  private static final void e(cd paramcd)
  {
    AppMethodBeat.i(313967);
    s.u(paramcd, "$event");
    a locala = a.OWG;
    String str = paramcd.hCg.filePath;
    s.s(str, "event.data.filePath");
    a.a(locala, str, paramcd.hCg.hCh, paramcd.hCg.subType, paramcd.hCg.hCi);
    AppMethodBeat.o(313967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.res.ScanProductModelResLogic.checkResUpdateCacheFileEventListener.1
 * JD-Core Version:    0.7.0.1
 */