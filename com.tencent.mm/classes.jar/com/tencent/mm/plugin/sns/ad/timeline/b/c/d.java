package com.tencent.mm.plugin.sns.ad.timeline.b.c;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.c;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;
import java.util.Objects;

public final class d
  extends RecyclerView.a<e>
  implements View.OnClickListener
{
  SnsInfo PJQ;
  public c Qbv;
  List<g> QcG;
  Context mContext;
  RecyclerView mRecyclerView;
  
  public d(RecyclerView paramRecyclerView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311223);
    if (paramRecyclerView != null)
    {
      this.mRecyclerView = paramRecyclerView;
      this.mContext = paramRecyclerView.getContext();
    }
    for (;;)
    {
      if (paramSnsInfo != null) {}
      try
      {
        if (paramSnsInfo.getAdXml() == null)
        {
          Log.w("SnsAd.RecyclerViewAdapter", "the sns info is null, initialize adapter failed!");
          return;
          this.mContext = MMApplicationContext.getContext();
        }
        else
        {
          paramRecyclerView = paramSnsInfo.getAdXml();
          if ((paramRecyclerView.adFinderTopicInfo == null) || (com.tencent.mm.plugin.sns.ad.j.d.isEmpty(paramRecyclerView.adFinderTopicInfo.PMG)))
          {
            Log.w("SnsAd.RecyclerViewAdapter", "the adFinderTopicInfo or resource info list is null, initialize adapter failed!!!");
            return;
          }
          this.PJQ = paramSnsInfo;
          this.QcG = paramRecyclerView.adFinderTopicInfo.PMG;
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(311223);
      }
    }
  }
  
  private e V(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(311232);
    try
    {
      Log.d("SnsAd.RecyclerViewAdapter", "mRecyclerView width is " + paramViewGroup.getWidth());
      View localView = l.a(this.mContext, b.g.sns_ad_finder_topic_sub_item_layout, paramViewGroup);
      int i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 8);
      if ((localView instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)localView).A(i, i, 0.0F, 0.0F);
      }
      if (localView != null)
      {
        localView.setOnClickListener(this);
        paramViewGroup = new e(localView);
        AppMethodBeat.o(311232);
        return paramViewGroup;
      }
      Log.e("SnsAd.RecyclerViewAdapter", "the inflated view is null????");
      paramViewGroup = new e(new View(paramViewGroup.getContext()));
      AppMethodBeat.o(311232);
      return paramViewGroup;
    }
    finally
    {
      Log.e("SnsAd.RecyclerViewAdapter", "onCreateViewHolder failed????");
      paramViewGroup = new e(new View(MMApplicationContext.getContext()));
      AppMethodBeat.o(311232);
    }
    return paramViewGroup;
  }
  
  public final g ajN(int paramInt)
  {
    AppMethodBeat.i(311252);
    try
    {
      if ((this.QcG != null) && (paramInt >= 0) && (paramInt < this.QcG.size()))
      {
        g localg = (g)this.QcG.get(paramInt);
        AppMethodBeat.o(311252);
        return localg;
      }
    }
    finally
    {
      Log.w("SnsAd.RecyclerViewAdapter", "the getResInfo has something wrong " + localObject.getMessage());
      AppMethodBeat.o(311252);
    }
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(311260);
    if (this.QcG != null)
    {
      int i = this.QcG.size();
      AppMethodBeat.o(311260);
      return i;
    }
    AppMethodBeat.o(311260);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(311245);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    try
    {
      localObject1 = this.Qbv;
      Object localObject2 = this.mRecyclerView;
      if ((paramView == null) || (localObject2 == null) || (localObject1 == null))
      {
        Log.w("SnsAd.RecyclerViewAdapter", "the recycler view or click listener is null!!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(311245);
        return;
      }
      if (paramView.getParent() != localObject2)
      {
        Log.e("SnsAd.RecyclerViewAdapter", "are you cray?!! the parent of the clicked view is not same as the input recycler view!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(311245);
        return;
      }
      localObject2 = ((RecyclerView)localObject2).bj(paramView);
      if (localObject2 == null)
      {
        Log.e("SnsAd.RecyclerViewAdapter", "I think the statement can't be reached, why?");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(311245);
        return;
      }
      ((c)localObject1).aU(paramView, ((RecyclerView.v)localObject2).KJ());
    }
    finally
    {
      label183:
      break label183;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(311245);
  }
  
  public final boolean q(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311278);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(311278);
      return false;
    }
    try
    {
      boolean bool = Objects.equals(t.x(this.PJQ), t.x(paramSnsInfo));
      return bool;
    }
    finally
    {
      AppMethodBeat.o(311278);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.c.d
 * JD-Core Version:    0.7.0.1
 */