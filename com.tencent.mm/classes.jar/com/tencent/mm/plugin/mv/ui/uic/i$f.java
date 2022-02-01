package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.plugin.mv.ui.a.b;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$2", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$f
  implements a.c
{
  i$f(i parami) {}
  
  public final void rL(int paramInt)
  {
    AppMethodBeat.i(287601);
    Log.i(this.Mfb.TAG, "onPageSettle:" + paramInt + ", lastPos:" + this.Mfb.Ahg);
    if (this.Mfb.Ahg == paramInt)
    {
      AppMethodBeat.o(287601);
      return;
    }
    this.Mfb.bVs = paramInt;
    if (i.d(this.Mfb))
    {
      localObject1 = a.PlI;
      localObject1 = (dtk)a.a.a((Context)this.Mfb.getContext(), 7, dtk.class);
      if (localObject1 != null) {
        ((dtk)localObject1).scene = 13;
      }
    }
    i.a(this.Mfb, false);
    Object localObject1 = this.Mfb.AZd;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = k.aeZF;
      ((h)k.d(this.Mfb.getActivity()).q(h.class)).it((View)localObject1);
      localObject2 = k.aeZF;
      localObject2 = (d)k.d(this.Mfb.getActivity()).q(d.class);
      Object localObject3 = this.Mfb.pUj.get(paramInt);
      s.s(localObject3, "dataList[position]");
      ((d)localObject2).a((View)localObject1, (b)localObject3);
      i.c(this.Mfb, paramInt);
      this.Mfb.Ahg = paramInt;
      this.Mfb.aef(paramInt);
      AppMethodBeat.o(287601);
      return;
      localObject1 = ((WxRecyclerView)localObject1).fU(paramInt);
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((RecyclerView.v)localObject1).caK;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.i.f
 * JD-Core Version:    0.7.0.1
 */