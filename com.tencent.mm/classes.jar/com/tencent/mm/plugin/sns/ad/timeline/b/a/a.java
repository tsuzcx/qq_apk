package com.tencent.mm.plugin.sns.ad.timeline.b.a;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.m;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ad.g.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.b, com.tencent.mm.plugin.sns.ad.widget.recyclerview.c, com.tencent.mm.plugin.sns.ui.video.a
{
  SnsInfo PJQ;
  private com.tencent.mm.plugin.sns.ad.timeline.a.a.c QaL;
  CardLayoutManager QaN;
  com.tencent.mm.plugin.sns.ad.timeline.video.online.e QaO;
  private a Qbg;
  e Qbh;
  b Qbi;
  
  public a()
  {
    AppMethodBeat.i(311263);
    this.QaO = new com.tencent.mm.plugin.sns.ad.timeline.video.online.e();
    AppMethodBeat.o(311263);
  }
  
  private com.tencent.mm.plugin.sns.ad.g.l a(bn parambn)
  {
    AppMethodBeat.i(311282);
    Object localObject = null;
    if ((parambn != null) && (parambn.Ryp != null) && (parambn.Ryp.Rbv != null)) {
      parambn = parambn.Ryp.Rbv;
    }
    for (;;)
    {
      AppMethodBeat.o(311282);
      return parambn;
      parambn = localObject;
      if ((this.mActivity instanceof SnsTimeLineUI)) {
        parambn = ((SnsTimeLineUI)this.mActivity).hpK();
      }
    }
  }
  
  private void a(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(311272);
    if (this.Qbh != null) {
      this.Qbh.hbY();
    }
    if (paramCardLayoutManager != null) {
      paramCardLayoutManager.hdj();
    }
    AppMethodBeat.o(311272);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(311325);
    try
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the item video play!!! item hash " + hashCode());
      com.tencent.mm.plugin.sns.ui.video.e.hsu().bck();
      com.tencent.mm.plugin.sns.ui.video.b.hsi().a(this);
      if (this.Qbh != null) {
        this.Qbh.b(this.QaN);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311325);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(311317);
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.AdSlideFullCardTimeLineItem", "fillItem::the holder is not type of AdSlideFullCardItemViewHolder!!!");
      AppMethodBeat.o(311317);
      return;
    }
    if (parambo == null)
    {
      Log.e("SnsAd.AdSlideFullCardTimeLineItem", "fillItem::the struct is null!!!");
      AppMethodBeat.o(311317);
      return;
    }
    if (paramBaseViewHolder.mtE)
    {
      Log.i("SnsAd.AdSlideFullCardTimeLineItem", "holder is busy");
      AppMethodBeat.o(311317);
      return;
    }
    paramBaseViewHolder.mtE = true;
    Object localObject1 = parambo.PJQ;
    if ((localObject1 == null) || (((SnsInfo)localObject1).getAdXml() == null))
    {
      AppMethodBeat.o(311317);
      return;
    }
    this.PJQ = ((SnsInfo)localObject1);
    try
    {
      localObject2 = (a)paramBaseViewHolder;
      localm = ((SnsInfo)localObject1).getAdXml().adSliderFullCardInfo;
      if (this.Qbh != null) {
        this.Qbh.PJQ = ((SnsInfo)localObject1);
      }
      localRecyclerView = ((a)localObject2).QaX;
      if (localRecyclerView == null) {
        break label271;
      }
      localObject3 = localRecyclerView.getAdapter();
      if ((!(localObject3 instanceof c)) || (!((c)localObject3).q((SnsInfo)localObject1))) {
        break label425;
      }
      paramInt2 = 0;
      ((RecyclerView.a)localObject3).bZE.notifyChanged();
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        m localm;
        RecyclerView localRecyclerView;
        Object localObject3;
        label271:
        continue;
        paramInt2 = 1;
      }
    }
    if (paramInt2 != 0)
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the adapter sns info is not same");
      localObject3 = this.QBJ;
      localObject2 = new c(((a)localObject2).QaX, (SnsInfo)localObject1, new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.mActivity, 0, a((bn)localObject3), null, new c.b()
      {
        public final void hbt()
        {
          AppMethodBeat.i(311246);
          this.Qbl.QBf.m(this.Qbm);
          AppMethodBeat.o(311246);
        }
        
        public final ViewGroup hbu()
        {
          return this.Qbm.QaX;
        }
      }));
      ((c)localObject2).bf(true);
      ((c)localObject2).Qbv = this;
      ((c)localObject2).Qbw = this;
      localRecyclerView.setAdapter((RecyclerView.a)localObject2);
    }
    if (this.Qbi != null) {
      this.Qbi.a((SnsInfo)localObject1, 0, localm);
    }
    parambn = a(parambn);
    if (parambn != null)
    {
      localObject1 = t.x((SnsInfo)localObject1);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"0".equals(localObject1))) {
        parambn.a((String)localObject1, this);
      }
    }
    paramBaseViewHolder.mtE = false;
    parambn = new StringBuilder("ad fillItem, slidefullCardAd, pos=").append(paramInt1).append(", snsId=");
    if (paramTimeLineObject == null) {}
    for (paramBaseViewHolder = "";; paramBaseViewHolder = paramTimeLineObject.Id)
    {
      Log.i("SnsAd.AdSlideFullCardTimeLineItem", paramBaseViewHolder + ", hash=" + hashCode());
      a(parambo, 3);
      AppMethodBeat.o(311317);
      return;
    }
  }
  
  public final void aU(View paramView, int paramInt)
  {
    AppMethodBeat.i(311374);
    try
    {
      SnsInfo localSnsInfo = this.PJQ;
      if ((localSnsInfo == null) || (localSnsInfo.getAdXml() == null) || (localSnsInfo.getAdXml().adSliderFullCardInfo == null)) {}
      for (;;)
      {
        if (this.Qbi != null) {
          this.Qbi.ajE(paramInt);
        }
        return;
        m localm = localSnsInfo.getAdXml().adSliderFullCardInfo;
        if ((localm.PMG != null) && (localm.PMG.size() > 0))
        {
          com.tencent.mm.plugin.sns.ad.adxml.l locall = (com.tencent.mm.plugin.sns.ad.adxml.l)localm.PMG.get(paramInt);
          if ((locall != null) && (locall.clickActionInfo != null))
          {
            int i = localm.ajr(paramInt);
            this.QaL.a(locall.clickActionInfo, localSnsInfo, i);
            this.QaL.jg(paramView);
          }
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311374);
    }
  }
  
  public final void aWD(String paramString)
  {
    AppMethodBeat.i(311362);
    try
    {
      if (this.Qbi != null) {
        this.Qbi.currentIndex = -1;
      }
      if (this.PJQ != null)
      {
        String str = t.x(this.PJQ);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          j.a(this.Qbi);
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311362);
    }
  }
  
  public final void ajD(int paramInt)
  {
    AppMethodBeat.i(311379);
    try
    {
      if (this.Qbi != null) {
        this.Qbi.ajF(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311379);
    }
  }
  
  public final void d(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(311304);
    Log.d("SnsAd.AdSlideFullCardTimeLineItem", "AdSlideFullCardTimeLineItem build content is called");
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.AdSlideFullCardTimeLineItem", "buildContent::the holder is not type of AdSlideFullCardItemViewHolder!!!");
      AppMethodBeat.o(311304);
      return;
    }
    this.Qbg = ((a)paramBaseViewHolder);
    ViewGroup localViewGroup;
    for (;;)
    {
      try
      {
        if (paramBaseViewHolder.RKG != null)
        {
          paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_ad_slide_full_card);
          if (!paramBaseViewHolder.RKH)
          {
            this.Qbg.pzi = ((ViewGroup)paramBaseViewHolder.RKG.inflate());
            paramBaseViewHolder.RKH = true;
          }
          this.Qbi = new b(1);
          paramBaseViewHolder = this.Qbg;
          if (paramBaseViewHolder == null) {
            break label346;
          }
          localViewGroup = this.Qbg.pzi;
          if (localViewGroup != null) {
            break;
          }
          Log.e("SnsAd.AdSlideFullCardTimeLineItem", "fillViewHolder::the root null, is it right????");
        }
      }
      finally
      {
        AppMethodBeat.o(311304);
        return;
      }
      if (!paramBaseViewHolder.RKH)
      {
        this.Qbg.pzi = ((ViewGroup)paramBaseViewHolder.convertView.findViewById(b.f.ad_card_container));
        paramBaseViewHolder.RKH = true;
      }
    }
    paramBaseViewHolder.QaW = ((RoundedCornerFrameLayout)localViewGroup.findViewById(b.f.sns_ad_slide_full_card_recycler_view_layout));
    paramBaseViewHolder.QaX = ((RecyclerView)localViewGroup.findViewById(b.f.sns_ad_slide_full_card_recycler_view));
    if (paramBaseViewHolder.QaX != null)
    {
      paramBaseViewHolder.QaX.setHasFixedSize(true);
      this.QaN = new CardLayoutManager(paramBaseViewHolder.QaX);
      this.Qbh = new e(this.QaO, this.Qbi);
      this.QaN.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.d(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8)));
      this.QaN.QhD = this.Qbh;
      paramBaseViewHolder.QaX.setLayoutManager(this.QaN);
      this.QaL = new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.mActivity, 0, a(this.QBJ), null, new c.b()
      {
        public final void hbt()
        {
          AppMethodBeat.i(311241);
          a.a(a.this).QBf.m(paramBaseViewHolder);
          AppMethodBeat.o(311241);
        }
        
        public final ViewGroup hbu()
        {
          return paramBaseViewHolder.QaX;
        }
      });
    }
    label346:
    AppMethodBeat.o(311304);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(311356);
    try
    {
      Object localObject1 = this.Qbg;
      if ((localObject1 != null) && (((a)localObject1).QaW != null))
      {
        int[] arrayOfInt = new int[2];
        ((a)localObject1).QaW.getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        localObject1 = new Rect(i, j, ((a)localObject1).QaW.getWidth() + i, ((a)localObject1).QaW.getHeight() + j);
        return localObject1;
      }
    }
    finally
    {
      AppMethodBeat.o(311356);
    }
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(311340);
    try
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the item video onUIPause!!! item hash " + hashCode());
      a(this.QaN);
      return;
    }
    finally
    {
      AppMethodBeat.o(311340);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(311330);
    try
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the item video pause!!! item hash " + hashCode());
      a(this.QaN);
      return;
    }
    finally
    {
      AppMethodBeat.o(311330);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(311348);
    try
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the item video stop!!! item hash " + hashCode());
      if (this.QaO != null) {
        this.QaO.stopAll();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311348);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    RoundedCornerFrameLayout QaW;
    public RecyclerView QaX;
    ViewGroup pzi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a.a
 * JD-Core Version:    0.7.0.1
 */