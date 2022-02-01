package com.tencent.mm.plugin.sns.ad.timeline.b.a;

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
import com.tencent.mm.plugin.sns.ad.adxml.m;
import com.tencent.mm.plugin.sns.ad.adxml.o;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
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
  SnsInfo PJQ;
  List<com.tencent.mm.plugin.sns.ad.adxml.l> Qbu;
  public com.tencent.mm.plugin.sns.ad.widget.recyclerview.c Qbv;
  public com.tencent.mm.plugin.sns.ad.widget.recyclerview.b Qbw;
  com.tencent.mm.plugin.sns.ad.timeline.a.a.c Qbx;
  Context mContext;
  RecyclerView mRecyclerView;
  
  public c(RecyclerView paramRecyclerView, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.a.c paramc)
  {
    AppMethodBeat.i(311300);
    if (paramRecyclerView != null)
    {
      this.mRecyclerView = paramRecyclerView;
      this.mContext = paramRecyclerView.getContext();
    }
    for (;;)
    {
      this.Qbx = paramc;
      if (paramSnsInfo != null) {}
      try
      {
        if (paramSnsInfo.getAdXml() == null)
        {
          Log.w("SnsAd.SlideFullCardRecyclerViewAdapter", "the sns info is null, initialize adapter failed!");
          return;
          this.mContext = MMApplicationContext.getContext();
        }
        else
        {
          paramRecyclerView = paramSnsInfo.getAdXml();
          if ((paramRecyclerView.adSliderFullCardInfo == null) || (com.tencent.mm.plugin.sns.ad.j.d.isEmpty(paramRecyclerView.adSliderFullCardInfo.PMG)))
          {
            Log.w("SnsAd.SlideFullCardRecyclerViewAdapter", "the adSliderFullCardInfo or resource info list is null, initialize adapter failed!!!");
            return;
          }
          this.PJQ = paramSnsInfo;
          this.Qbu = paramRecyclerView.adSliderFullCardInfo.PMG;
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(311300);
      }
    }
  }
  
  private d T(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(311315);
    try
    {
      Log.d("SnsAd.SlideFullCardRecyclerViewAdapter", "mRecyclerView width is " + paramViewGroup.getWidth());
      View localView = com.tencent.mm.plugin.sns.ad.j.l.a(this.mContext, b.g.sns_ad_slide_full_card_sub_item_layout, paramViewGroup);
      if (localView != null)
      {
        localView.setOnClickListener(this);
        paramViewGroup = new d(localView, new a());
        AppMethodBeat.o(311315);
        return paramViewGroup;
      }
      Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "the inflated view is null????");
      paramViewGroup = new d(new View(paramViewGroup.getContext()), new a());
      AppMethodBeat.o(311315);
      return paramViewGroup;
    }
    finally
    {
      Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "onCreateViewHolder failed????");
      paramViewGroup = new d(new View(MMApplicationContext.getContext()), new a());
      AppMethodBeat.o(311315);
    }
    return paramViewGroup;
  }
  
  private void z(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(311326);
    paramString = BitmapUtil.decodeFile(paramString, null);
    if (paramString == null)
    {
      Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "onDownloaded, bitmap == null");
      AppMethodBeat.o(311326);
      return;
    }
    paramString = new BitmapDrawable(paramString);
    androidx.core.graphics.drawable.a.a(paramString, this.mContext.getResources().getColor(b.c.BW_100_Alpha_0_9));
    paramImageView.setImageDrawable(paramString);
    com.tencent.mm.plugin.sns.ad.j.l.C(paramImageView, true);
    AppMethodBeat.o(311326);
  }
  
  public final com.tencent.mm.plugin.sns.ad.adxml.l ajI(int paramInt)
  {
    AppMethodBeat.i(311365);
    try
    {
      if ((this.Qbu != null) && (paramInt >= 0) && (paramInt < this.Qbu.size()))
      {
        com.tencent.mm.plugin.sns.ad.adxml.l locall = (com.tencent.mm.plugin.sns.ad.adxml.l)this.Qbu.get(paramInt);
        AppMethodBeat.o(311365);
        return locall;
      }
    }
    finally
    {
      Log.w("SnsAd.SlideFullCardRecyclerViewAdapter", "the getResInfo has something wrong " + localObject.getMessage());
      AppMethodBeat.o(311365);
    }
    return null;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(311378);
    if (this.Qbu != null)
    {
      int i = this.Qbu.size();
      AppMethodBeat.o(311378);
      return i;
    }
    AppMethodBeat.o(311378);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(311355);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    try
    {
      localObject1 = this.Qbv;
      Object localObject2 = this.mRecyclerView;
      if ((paramView == null) || (localObject2 == null) || (localObject1 == null))
      {
        Log.w("SnsAd.SlideFullCardRecyclerViewAdapter", "the recycler view or click listener is null!!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(311355);
        return;
      }
      if (paramView.getParent() != localObject2)
      {
        Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "are you cray?!! the parent of the clicked view is not same as the input recycler view!!");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(311355);
        return;
      }
      localObject2 = ((RecyclerView)localObject2).bj(paramView);
      if (localObject2 == null)
      {
        Log.e("SnsAd.SlideFullCardRecyclerViewAdapter", "I think the statement can't be reached, why?");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(311355);
        return;
      }
      ((com.tencent.mm.plugin.sns.ad.widget.recyclerview.c)localObject1).aU(paramView, ((RecyclerView.v)localObject2).KJ());
    }
    finally
    {
      label183:
      break label183;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(311355);
  }
  
  public final boolean q(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311393);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(311393);
      return false;
    }
    try
    {
      boolean bool = Objects.equals(t.x(this.PJQ), t.x(paramSnsInfo));
      return bool;
    }
    finally
    {
      AppMethodBeat.o(311393);
    }
    return false;
  }
  
  final class a
    implements View.OnClickListener
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(311313);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter$ActionBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
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
              localSnsInfo = c.this.PJQ;
              if ((localSnsInfo != null) && (localSnsInfo.getAdXml() != null))
              {
                localm = localSnsInfo.getAdXml().adSliderFullCardInfo;
                if (localm != null) {
                  continue;
                }
              }
            }
          }
        }
        finally
        {
          int i;
          SnsInfo localSnsInfo;
          m localm;
          Object localObject2;
          continue;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/adSlideFullCard/SlideFullCardRecyclerViewAdapter$ActionBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(311313);
        return;
        localm = localSnsInfo.getAdXml().adSliderFullCardInfo;
        if ((localm.PMG != null) && (localm.PMG.size() > 0))
        {
          localObject2 = (com.tencent.mm.plugin.sns.ad.adxml.l)localm.PMG.get(i);
          if ((localObject2 != null) && (((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY != null) && (((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY.PNj != null))
          {
            localObject2 = ((com.tencent.mm.plugin.sns.ad.adxml.l)localObject2).PMY.PNj;
            if (((c)localObject1).Qbw != null) {
              ((c)localObject1).Qbw.ajD(i);
            }
            i = localm.ajr(i);
            ((c)localObject1).Qbx.a((AdClickActionInfo)localObject2, localSnsInfo, i);
            ((c)localObject1).Qbx.jg(paramView);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a.c
 * JD-Core Version:    0.7.0.1
 */