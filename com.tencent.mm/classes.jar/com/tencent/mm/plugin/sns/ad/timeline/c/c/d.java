package com.tencent.mm.plugin.sns.ad.timeline.c.c;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.c;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.g;
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
  public c JJR;
  List<com.tencent.mm.plugin.sns.ad.adxml.e> JKX;
  SnsInfo Jws;
  Context mContext;
  RecyclerView mRecyclerView;
  
  public d(RecyclerView paramRecyclerView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(265235);
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
          AppMethodBeat.o(265235);
          return;
          this.mContext = MMApplicationContext.getContext();
        }
        else
        {
          paramRecyclerView = paramSnsInfo.getAdXml();
          if ((paramRecyclerView.adFinderTopicInfo == null) || (com.tencent.mm.plugin.sns.ad.i.d.isEmpty(paramRecyclerView.adFinderTopicInfo.Jym)))
          {
            Log.w("SnsAd.RecyclerViewAdapter", "the adFinderTopicInfo or resource info list is null, initialize adapter failed!!!");
            AppMethodBeat.o(265235);
            return;
          }
          this.Jws = paramSnsInfo;
          this.JKX = paramRecyclerView.adFinderTopicInfo.Jym;
          AppMethodBeat.o(265235);
          return;
        }
      }
      catch (Throwable paramRecyclerView)
      {
        AppMethodBeat.o(265235);
      }
    }
  }
  
  private e L(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(265239);
    try
    {
      Log.d("SnsAd.RecyclerViewAdapter", "mRecyclerView width is " + paramViewGroup.getWidth());
      View localView = l.a(this.mContext, i.g.sns_ad_finder_topic_sub_item_layout, paramViewGroup);
      int i = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 8);
      if ((localView instanceof RoundedCornerFrameLayout)) {
        ((RoundedCornerFrameLayout)localView).v(i, i, 0.0F, 0.0F);
      }
      if (localView != null)
      {
        localView.setOnClickListener(this);
        paramViewGroup = new e(localView);
        AppMethodBeat.o(265239);
        return paramViewGroup;
      }
      Log.e("SnsAd.RecyclerViewAdapter", "the inflated view is null????");
      paramViewGroup = new e(new View(paramViewGroup.getContext()));
      AppMethodBeat.o(265239);
      return paramViewGroup;
    }
    catch (Throwable paramViewGroup)
    {
      Log.e("SnsAd.RecyclerViewAdapter", "onCreateViewHolder failed????");
      paramViewGroup = new e(new View(MMApplicationContext.getContext()));
      AppMethodBeat.o(265239);
    }
    return paramViewGroup;
  }
  
  public final com.tencent.mm.plugin.sns.ad.adxml.e afe(int paramInt)
  {
    AppMethodBeat.i(265240);
    try
    {
      if ((this.JKX != null) && (paramInt >= 0) && (paramInt < this.JKX.size()))
      {
        com.tencent.mm.plugin.sns.ad.adxml.e locale = (com.tencent.mm.plugin.sns.ad.adxml.e)this.JKX.get(paramInt);
        AppMethodBeat.o(265240);
        return locale;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.w("SnsAd.RecyclerViewAdapter", "the getResInfo has something wrong " + localThrowable.getMessage());
      AppMethodBeat.o(265240);
    }
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(265241);
    if (this.JKX != null)
    {
      int i = this.JKX.size();
      AppMethodBeat.o(265241);
      return i;
    }
    AppMethodBeat.o(265241);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final boolean o(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(265242);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(265242);
      return false;
    }
    try
    {
      boolean bool = Objects.equals(t.w(this.Jws), t.w(paramSnsInfo));
      AppMethodBeat.o(265242);
      return bool;
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(265242);
    }
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(265236);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    try
    {
      localObject1 = this.JJR;
      Object localObject2 = this.mRecyclerView;
      if ((paramView == null) || (localObject2 == null) || (localObject1 == null))
      {
        Log.w("SnsAd.RecyclerViewAdapter", "the recycler view or click listener is null!!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265236);
        return;
      }
      if (paramView.getParent() != localObject2)
      {
        Log.e("SnsAd.RecyclerViewAdapter", "are you cray?!! the parent of the clicked view is not same as the input recycler view!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265236);
        return;
      }
      localObject2 = ((RecyclerView)localObject2).aQ(paramView);
      if (localObject2 == null)
      {
        Log.e("SnsAd.RecyclerViewAdapter", "I think the statement can't be reached, why?");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265236);
        return;
      }
      ((c)localObject1).ay(paramView, ((RecyclerView.v)localObject2).md());
    }
    catch (Throwable paramView)
    {
      label183:
      break label183;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/topic/TopicCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.c.d
 * JD-Core Version:    0.7.0.1
 */