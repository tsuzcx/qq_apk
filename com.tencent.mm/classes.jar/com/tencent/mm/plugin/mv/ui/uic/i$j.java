package com.tencent.mm.plugin.mv.ui.uic;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.d;
import com.tencent.mm.plugin.thumbplayer.c.b.g;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.effect.h;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageStartChangeListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "onPageStartChange", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$j
  implements a.d
{
  i$j(i parami) {}
  
  public final void rM(final int paramInt)
  {
    AppMethodBeat.i(287611);
    Log.i(this.Mfb.TAG, "onPageStartChange:" + paramInt + ", dataList.size:" + this.Mfb.pUj.size());
    if ((paramInt >= this.Mfb.pUj.size()) || (paramInt < 0))
    {
      AppMethodBeat.o(287611);
      return;
    }
    i.e(this.Mfb);
    i.a(this.Mfb, true);
    Object localObject = this.Mfb.Mci;
    if (localObject != null)
    {
      kotlin.g.a.b localb = (kotlin.g.a.b)new a(this.Mfb, paramInt);
      s.u(localb, "callback");
      localObject = ((MultiMediaEffectVideoLayout)localObject).TGY;
      s.u(localb, "callback");
      ((com.tencent.mm.plugin.thumbplayer.c.b)localObject).TCR.aX((kotlin.g.a.b)new b.g(localb));
    }
    AppMethodBeat.o(287611);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    a(i parami, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.i.j
 * JD-Core Version:    0.7.0.1
 */