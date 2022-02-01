package com.tencent.mm.sns_compose.d;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.c.ab;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.h;
import androidx.compose.ui.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"PlayerVideo", "", "modifier", "Landroidx/compose/ui/Modifier;", "playerState", "Lcom/tencent/mm/sns_compose/widget/PlayerState;", "(Landroidx/compose/ui/Modifier;Lcom/tencent/mm/sns_compose/widget/PlayerState;Landroidx/compose/runtime/Composer;II)V", "sns-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final void a(f paramf, final c paramc, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(235400);
    s.u(paramc, "playerState");
    paramh = paramh.by(2046612711);
    if ((paramInt2 & 0x1) != 0) {
      paramf = (f)f.aud;
    }
    androidx.compose.ui.p.c.a((b)new a(paramc), ab.e((f)f.aud).a(paramf), (b)d.b.acAg, paramh, 0, 0);
    paramh = paramh.oh();
    if (paramh != null) {
      paramh.b((m)new c(paramf, paramc, paramInt1, paramInt2));
    }
    AppMethodBeat.o(235400);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<h, Integer, ah>
  {
    c(f paramf, c paramc, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.d.d
 * JD-Core Version:    0.7.0.1
 */