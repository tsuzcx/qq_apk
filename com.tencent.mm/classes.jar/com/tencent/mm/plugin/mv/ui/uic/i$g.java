package com.tencent.mm.plugin.mv.ui.uic;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a;
import com.tencent.mm.plugin.mv.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$4", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$g
  extends RecyclerView.c
{
  i$g(i parami) {}
  
  private static final void f(i parami)
  {
    AppMethodBeat.i(287617);
    s.u(parami, "this$0");
    i.c(parami, parami.Ahg);
    Object localObject1 = parami.AZd;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = k.aeZF;
      localObject2 = (d)k.d(parami.getActivity()).q(d.class);
      parami = parami.pUj.get(parami.Ahg);
      s.s(parami, "dataList[lastPos]");
      ((d)localObject2).a((View)localObject1, (b)parami);
      AppMethodBeat.o(287617);
      return;
      localObject1 = ((WxRecyclerView)localObject1).fU(parami.Ahg);
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((RecyclerView.v)localObject1).caK;
      }
    }
  }
  
  private static final void g(i parami)
  {
    AppMethodBeat.i(287624);
    s.u(parami, "this$0");
    i.c(parami, parami.Ahg);
    Object localObject1 = parami.AZd;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      Object localObject2 = k.aeZF;
      localObject2 = (d)k.d(parami.getActivity()).q(d.class);
      parami = parami.pUj.get(parami.Ahg);
      s.s(parami, "dataList[lastPos]");
      ((d)localObject2).a((View)localObject1, (b)parami);
      AppMethodBeat.o(287624);
      return;
      localObject1 = ((WxRecyclerView)localObject1).fU(parami.Ahg);
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((RecyclerView.v)localObject1).caK;
      }
    }
  }
  
  public final void onChanged()
  {
    AppMethodBeat.i(287639);
    super.onChanged();
    Log.d(this.Mfb.TAG, "onChanged, lastPos:" + this.Mfb.Ahg + ", dataList.size:" + this.Mfb.pUj.size());
    if ((this.Mfb.pUj.size() > 0) && (this.Mfb.Ahg >= 0))
    {
      WxRecyclerView localWxRecyclerView = this.Mfb.AZd;
      if (localWxRecyclerView != null) {
        localWxRecyclerView.post(new i.g..ExternalSyntheticLambda1(this.Mfb));
      }
    }
    AppMethodBeat.o(287639);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(287655);
    super.onItemRangeChanged(paramInt1, paramInt2);
    Log.i(this.Mfb.TAG, "onItemRangeChanged, lastPos:" + this.Mfb.Ahg + ", positionStart:" + paramInt1 + ", itemCount:" + paramInt2 + ", dataList.size:" + this.Mfb.pUj.size());
    if ((this.Mfb.pUj.size() > 0) && (this.Mfb.Ahg >= 0))
    {
      int k = this.Mfb.Ahg;
      int i = j;
      if (paramInt1 <= k)
      {
        i = j;
        if (k < paramInt1 + paramInt2) {
          i = 1;
        }
      }
      if ((i != 0) && (!this.Mfb.MeK.mlX))
      {
        WxRecyclerView localWxRecyclerView = this.Mfb.AZd;
        if (localWxRecyclerView != null) {
          localWxRecyclerView.post(new i.g..ExternalSyntheticLambda0(this.Mfb));
        }
      }
    }
    AppMethodBeat.o(287655);
  }
  
  public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(287646);
    Log.i(this.Mfb.TAG, "onItemRangeChanged, lastPos:" + this.Mfb.Ahg + ", positionStart:" + paramInt1 + ", itemCount:" + paramInt2 + ", dataList.size:" + this.Mfb.pUj.size() + ", payLoad:" + paramObject);
    i.a locala = i.MeI;
    if (!s.p(paramObject, i.gqO())) {
      super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
    }
    AppMethodBeat.o(287646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.i.g
 * JD-Core Version:    0.7.0.1
 */