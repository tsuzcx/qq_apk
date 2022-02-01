package com.tencent.mm.plugin.recordvideo.res;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cd.a;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic$checkResUpdateCacheFileEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BaseVideoResLogic$checkResUpdateCacheFileEventListener$1
  extends IListener<cd>
{
  BaseVideoResLogic$checkResUpdateCacheFileEventListener$1(a parama, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(279684);
    AppMethodBeat.o(279684);
  }
  
  private static final void a(a parama, cd paramcd)
  {
    AppMethodBeat.i(279688);
    s.u(parama, "this$0");
    s.u(paramcd, "$event");
    String str = paramcd.hCg.filePath;
    s.s(str, "event.data.filePath");
    a.a(parama, str, paramcd.hCg.hCh, paramcd.hCg.subType, paramcd.hCg.hCi);
    AppMethodBeat.o(279688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.BaseVideoResLogic.checkResUpdateCacheFileEventListener.1
 * JD-Core Version:    0.7.0.1
 */