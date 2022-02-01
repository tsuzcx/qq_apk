package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.data.r;
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
  SnsInfo DqO;
  List<com.tencent.mm.plugin.sns.ad.a.e> DzA;
  public com.tencent.mm.plugin.sns.ad.widget.recyclerview.b DzB;
  Context mContext;
  RecyclerView mRecyclerView;
  
  public d(RecyclerView paramRecyclerView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202284);
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
          AppMethodBeat.o(202284);
          return;
          this.mContext = MMApplicationContext.getContext();
        }
        else
        {
          paramRecyclerView = paramSnsInfo.getAdXml();
          if ((paramRecyclerView.adFinderTopicInfo == null) || (c.isEmpty(paramRecyclerView.adFinderTopicInfo.DrS)))
          {
            Log.w("SnsAd.RecyclerViewAdapter", "the adFinderTopicInfo or resource info list is null, initialize adapter failed!!!");
            AppMethodBeat.o(202284);
            return;
          }
          this.DqO = paramSnsInfo;
          this.DzA = paramRecyclerView.adFinderTopicInfo.DrS;
          AppMethodBeat.o(202284);
          return;
        }
      }
      catch (Throwable paramRecyclerView)
      {
        AppMethodBeat.o(202284);
      }
    }
  }
  
  private e D(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(202286);
    try
    {
      Log.d("SnsAd.RecyclerViewAdapter", "mRecyclerView width is " + paramViewGroup.getWidth());
      View localView = m.e(this.mContext, paramViewGroup);
      int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 8);
      if ((localView instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)localView).s(i, i, 0.0F, 0.0F);
      }
      if (localView != null)
      {
        localView.setOnClickListener(this);
        paramViewGroup = new e(localView);
        AppMethodBeat.o(202286);
        return paramViewGroup;
      }
      Log.e("SnsAd.RecyclerViewAdapter", "the inflated view is null????");
      paramViewGroup = new e(new View(paramViewGroup.getContext()));
      AppMethodBeat.o(202286);
      return paramViewGroup;
    }
    catch (Throwable paramViewGroup)
    {
      Log.e("SnsAd.RecyclerViewAdapter", "onCreateViewHolder failed????");
      paramViewGroup = new e(new View(MMApplicationContext.getContext()));
      AppMethodBeat.o(202286);
    }
    return paramViewGroup;
  }
  
  public final com.tencent.mm.plugin.sns.ad.a.e XQ(int paramInt)
  {
    AppMethodBeat.i(202287);
    try
    {
      if ((this.DzA != null) && (paramInt >= 0) && (paramInt < this.DzA.size()))
      {
        com.tencent.mm.plugin.sns.ad.a.e locale = (com.tencent.mm.plugin.sns.ad.a.e)this.DzA.get(paramInt);
        AppMethodBeat.o(202287);
        return locale;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.w("SnsAd.RecyclerViewAdapter", "the getResInfo has something wrong " + localThrowable.getMessage());
      AppMethodBeat.o(202287);
    }
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(202288);
    if (this.DzA != null)
    {
      int i = this.DzA.size();
      AppMethodBeat.o(202288);
      return i;
    }
    AppMethodBeat.o(202288);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(202285);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    try
    {
      localObject1 = this.DzB;
      Object localObject2 = this.mRecyclerView;
      if ((paramView == null) || (localObject2 == null) || (localObject1 == null))
      {
        Log.w("SnsAd.RecyclerViewAdapter", "the recycler view or click listener is null!!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202285);
        return;
      }
      if (paramView.getParent() != localObject2)
      {
        Log.e("SnsAd.RecyclerViewAdapter", "are you cray?!! the parent of the clicked view is not same as the input recycler view!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202285);
        return;
      }
      localObject2 = ((RecyclerView)localObject2).bi(paramView);
      if (localObject2 == null)
      {
        Log.e("SnsAd.RecyclerViewAdapter", "I think the statement can't be reached, why?");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202285);
        return;
      }
      ((com.tencent.mm.plugin.sns.ad.widget.recyclerview.b)localObject1).au(paramView, ((RecyclerView.v)localObject2).lR());
    }
    catch (Throwable paramView)
    {
      label183:
      break label183;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(202285);
  }
  
  public final boolean p(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202289);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(202289);
      return false;
    }
    try
    {
      boolean bool = Objects.equals(r.v(this.DqO), r.v(paramSnsInfo));
      AppMethodBeat.o(202289);
      return bool;
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(202289);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.d
 * JD-Core Version:    0.7.0.1
 */