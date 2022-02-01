package com.tencent.mm.plugin.mv.ui.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.model.f;
import com.tencent.mm.plugin.mv.model.l;
import com.tencent.mm.plugin.mv.ui.uic.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$5", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "onDoCopy", "", "feedId", "", "nonceId", "", "commentId", "(Ljava/lang/Long;Ljava/lang/String;J)V", "onDoExpose", "onReferLinkClicked", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$h
  implements a
{
  i$h(i parami) {}
  
  public final void X(long paramLong, String paramString)
  {
    AppMethodBeat.i(287625);
    s.u(paramString, "nonceId");
    this.Mfb.Y(paramLong, paramString);
    AppMethodBeat.o(287625);
  }
  
  public final void a(Long paramLong, String paramString, long paramLong1)
  {
    AppMethodBeat.i(287633);
    Object localObject2 = null;
    i locali = this.Mfb;
    Object localObject1 = localObject2;
    if (paramLong != null)
    {
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = i.a(locali, ((Number)paramLong).longValue(), paramString);
      }
    }
    paramLong = l.LXJ;
    l.a((f)localObject1, paramLong1);
    AppMethodBeat.o(287633);
  }
  
  public final void b(Long paramLong, String paramString, long paramLong1)
  {
    AppMethodBeat.i(287641);
    Object localObject2 = null;
    i locali = this.Mfb;
    Object localObject1 = localObject2;
    if (paramLong != null)
    {
      localObject1 = localObject2;
      if (paramString != null) {
        localObject1 = i.a(locali, ((Number)paramLong).longValue(), paramString);
      }
    }
    paramLong = l.LXJ;
    l.b((f)localObject1, paramLong1);
    AppMethodBeat.o(287641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.i.h
 * JD-Core Version:    0.7.0.1
 */