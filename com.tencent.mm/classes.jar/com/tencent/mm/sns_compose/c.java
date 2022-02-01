package com.tencent.mm.sns_compose;

import android.content.Context;
import androidx.compose.b.n;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"WithTaScreenTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "sns-compose_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final void c(kotlin.g.a.m<? super h, ? super Integer, ah> paramm, h paramh, final int paramInt)
  {
    AppMethodBeat.i(235464);
    s.u(paramm, "content");
    paramh = paramh.by(1426916319);
    int i;
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramm))
      {
        i = 4;
        i |= paramInt;
      }
    }
    for (;;)
    {
      if (((i & 0xB ^ 0x2) != 0) || (!paramh.nZ()))
      {
        Object localObject = androidx.compose.b.m.aiH;
        localObject = androidx.compose.b.m.j(paramh);
        int j = b.a.BG_2;
        Context localContext = MMApplicationContext.getContext();
        s.s(localContext, "getContext()");
        n.a(androidx.compose.b.a.a((androidx.compose.b.a)localObject, 0L, 0L, 0L, 0L, 0L, com.tencent.mm.aj.a.c(j, localContext), 0L, 0L, 0L, 0L, 0L, 0L, false, 8159), null, null, paramm, paramh, i << 9 & 0x1C00, 6);
      }
      for (;;)
      {
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new a(paramm, paramInt));
        }
        AppMethodBeat.o(235464);
        return;
        i = 2;
        break;
        paramh.oi();
      }
      i = paramInt;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    a(kotlin.g.a.m<? super h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.c
 * JD-Core Version:    0.7.0.1
 */