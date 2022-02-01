package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.ad.adxml.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Objects;

public final class c
  extends RecyclerView.a<d>
  implements View.OnClickListener
{
  List<i> JJQ;
  public com.tencent.mm.plugin.sns.ad.widget.recyclerview.c JJR;
  public com.tencent.mm.plugin.sns.ad.widget.recyclerview.b JJS;
  com.tencent.mm.plugin.sns.ad.timeline.a.a.c JJT;
  SnsInfo Jws;
  Context mContext;
  RecyclerView mRecyclerView;
  
  public c(RecyclerView paramRecyclerView, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.a.c paramc)
  {
    AppMethodBeat.i(239158);
    if (paramRecyclerView != null)
    {
      this.mRecyclerView = paramRecyclerView;
      this.mContext = paramRecyclerView.getContext();
    }
    for (;;)
    {
      this.JJT = paramc;
      if (paramSnsInfo != null) {}
      try
      {
        if (paramSnsInfo.getAdXml() == null)
        {
          Log.w("SnsAd.SlideFullCardRecyclerViewAdapter", "the sns info is null, initialize adapter failed!");
          AppMethodBeat.o(239158);
          return;
          this.mContext = MMApplicationContext.getContext();
        }
        else
        {
          paramRecyclerView = paramSnsInfo.getAdXml();
          if ((paramRecyclerView.adSliderFullCardInfo == null) || (com.tencent.mm.plugin.sns.ad.i.d.isEmpty(paramRecyclerView.adSliderFullCardInfo.Jym)))
          {
            Log.w("SnsAd.SlideFullCardRecyclerViewAdapter", "the adSliderFullCardInfo or resource info list is null, initialize adapter failed!!!");
            AppMethodBeat.o(239158);
            return;
          }
          this.Jws = paramSnsInfo;
          this.JJQ = paramRecyclerView.adSliderFullCardInfo.Jym;
          AppMethodBeat.o(239158);
          return;
        }
      }
      catch (Throwable paramRecyclerView)
      {
        AppMethodBeat.o(239158);
      }
    }
  }
  
  private d J(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(239163);
    try
    {
      Log.d("SnsAd.SlideFullCardRecyclerViewAdapter", "mRecyclerView width is " + paramViewGroup.getWidth());
      View localView = com.tencent.mm.plugin.sns.ad.i.l.a(this.mContext, i.g.sns_ad_slide_full_card_sub_item_layout, paramViewGroup);
      if (localView != null)
      {
        localView.setOnClickListener(this);
        paramViewGroup = new d(localView, new a());
        AppMethodBeat.o(239163);
        return paramViewGroup;
      }
      Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "the inflated view is null????");
      paramViewGroup = new d(new View(paramViewGroup.getContext()), new a());
      AppMethodBeat.o(239163);
      return paramViewGroup;
    }
    catch (Throwable paramViewGroup)
    {
      Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "onCreateViewHolder failed????");
      paramViewGroup = new d(new View(MMApplicationContext.getContext()), new a());
      AppMethodBeat.o(239163);
    }
    return paramViewGroup;
  }
  
  private void x(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(239179);
    paramString = BitmapUtil.decodeFile(paramString, null);
    if (paramString == null)
    {
      Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "onDownloaded, bitmap == null");
      AppMethodBeat.o(239179);
      return;
    }
    paramString = new BitmapDrawable(paramString);
    androidx.core.graphics.drawable.a.a(paramString, this.mContext.getResources().getColor(i.c.BW_100_Alpha_0_9));
    paramImageView.setImageDrawable(paramString);
    com.tencent.mm.plugin.sns.ad.i.l.w(paramImageView, true);
    AppMethodBeat.o(239179);
  }
  
  public final i aeZ(int paramInt)
  {
    AppMethodBeat.i(239171);
    try
    {
      if ((this.JJQ != null) && (paramInt >= 0) && (paramInt < this.JJQ.size()))
      {
        i locali = (i)this.JJQ.get(paramInt);
        AppMethodBeat.o(239171);
        return locali;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.w("SnsAd.SlideFullCardRecyclerViewAdapter", "the getResInfo has something wrong " + localThrowable.getMessage());
      AppMethodBeat.o(239171);
    }
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(239174);
    if (this.JJQ != null)
    {
      int i = this.JJQ.size();
      AppMethodBeat.o(239174);
      return i;
    }
    AppMethodBeat.o(239174);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final boolean o(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(239177);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(239177);
      return false;
    }
    try
    {
      boolean bool = Objects.equals(t.w(this.Jws), t.w(paramSnsInfo));
      AppMethodBeat.o(239177);
      return bool;
    }
    catch (Throwable paramSnsInfo)
    {
      AppMethodBeat.o(239177);
    }
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(239167);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    try
    {
      localObject1 = this.JJR;
      Object localObject2 = this.mRecyclerView;
      if ((paramView == null) || (localObject2 == null) || (localObject1 == null))
      {
        Log.w("SnsAd.SlideFullCardRecyclerViewAdapter", "the recycler view or click listener is null!!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(239167);
        return;
      }
      if (paramView.getParent() != localObject2)
      {
        Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "are you cray?!! the parent of the clicked view is not same as the input recycler view!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(239167);
        return;
      }
      localObject2 = ((RecyclerView)localObject2).aQ(paramView);
      if (localObject2 == null)
      {
        Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "I think the statement can't be reached, why?");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(239167);
        return;
      }
      ((com.tencent.mm.plugin.sns.ad.widget.recyclerview.c)localObject1).ay(paramView, ((RecyclerView.v)localObject2).md());
    }
    catch (Throwable paramView)
    {
      label183:
      break label183;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(239167);
  }
  
  final class a
    implements View.OnClickListener
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(267090);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter$ActionBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      for (;;)
      {
        try
        {
          if ((paramView instanceof FrameLayout))
          {
            paramView = (FrameLayout)paramView;
            localObject1 = paramView.getTag();
            if ((localObject1 instanceof Integer))
            {
              i = ((Integer)localObject1).intValue();
              localObject1 = c.this;
              localSnsInfo = c.this.Jws;
              if ((localSnsInfo != null) && (localSnsInfo.getAdXml() != null))
              {
                localj = localSnsInfo.getAdXml().adSliderFullCardInfo;
                if (localj != null) {
                  continue;
                }
              }
            }
          }
        }
        catch (Throwable paramView)
        {
          int i;
          SnsInfo localSnsInfo;
          j localj;
          Object localObject2;
          continue;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter$ActionBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(267090);
        return;
        localj = localSnsInfo.getAdXml().adSliderFullCardInfo;
        if ((localj.Jym != null) && (localj.Jym.size() > 0))
        {
          localObject2 = (i)localj.Jym.get(i);
          if ((localObject2 != null) && (((i)localObject2).JyD != null) && (((i)localObject2).JyD.JyK != null))
          {
            localObject2 = ((i)localObject2).JyD.JyK;
            if (((c)localObject1).JJS != null) {
              ((c)localObject1).JJS.aeU(i);
            }
            i = localj.aeI(i);
            ((c)localObject1).JJT.a((AdClickActionInfo)localObject2, localSnsInfo, i);
            ((c)localObject1).JJT.gd(paramView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.c
 * JD-Core Version:    0.7.0.1
 */