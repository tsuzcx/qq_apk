package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ad.f.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.b, com.tencent.mm.plugin.sns.ad.widget.recyclerview.c, com.tencent.mm.plugin.sns.ui.video.a
{
  private a JJC;
  e JJD;
  b JJE;
  private com.tencent.mm.plugin.sns.ad.timeline.a.a.c JJh;
  CardLayoutManager JJj;
  com.tencent.mm.plugin.sns.ad.timeline.video.online.e JJk;
  SnsInfo Jws;
  
  public a()
  {
    AppMethodBeat.i(204991);
    this.JJk = new com.tencent.mm.plugin.sns.ad.timeline.video.online.e();
    AppMethodBeat.o(204991);
  }
  
  private l a(bm parambm)
  {
    AppMethodBeat.i(205016);
    Object localObject = null;
    if ((parambm != null) && (parambm.KYo != null) && (parambm.KYo.KBN != null)) {
      parambm = parambm.KYo.KBN;
    }
    for (;;)
    {
      AppMethodBeat.o(205016);
      return parambm;
      parambm = localObject;
      if ((this.mActivity instanceof SnsTimeLineUI)) {
        parambm = ((SnsTimeLineUI)this.mActivity).fXs();
      }
    }
  }
  
  private void a(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(205004);
    if (this.JJD != null) {
      this.JJD.fLB();
    }
    if (paramCardLayoutManager != null) {
      paramCardLayoutManager.fMn();
    }
    AppMethodBeat.o(205004);
  }
  
  public final void a(final ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(204992);
    Log.d("SnsAd.AdSlideFullCardTimeLineItem", "AdSlideFullCardTimeLineItem build content is called");
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.AdSlideFullCardTimeLineItem", "buildContent::the holder is not type of AdSlideFullCardItemViewHolder!!!");
      AppMethodBeat.o(204992);
      return;
    }
    this.JJC = ((a)paramBaseViewHolder);
    for (;;)
    {
      try
      {
        if (paramBaseViewHolder.LkR != null)
        {
          paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_ad_slide_full_card);
          if (!paramBaseViewHolder.LkS)
          {
            this.JJC.mCB = ((ViewGroup)paramBaseViewHolder.LkR.inflate());
            paramBaseViewHolder.LkS = true;
          }
          this.JJE = new b(1);
          paramViewStub = this.JJC;
          if (paramViewStub == null) {
            break label339;
          }
          paramBaseViewHolder = this.JJC.mCB;
          if (paramBaseViewHolder != null) {
            break;
          }
          Log.e("SnsAd.AdSlideFullCardTimeLineItem", "fillViewHolder::the root null, is it right????");
          AppMethodBeat.o(204992);
          return;
        }
      }
      catch (Throwable paramViewStub)
      {
        AppMethodBeat.o(204992);
        return;
      }
      if (!paramBaseViewHolder.LkS)
      {
        this.JJC.mCB = ((ViewGroup)paramBaseViewHolder.convertView.findViewById(i.f.ad_card_container));
        paramBaseViewHolder.LkS = true;
      }
    }
    paramViewStub.JJs = ((RoundedCornerFrameLayout)paramBaseViewHolder.findViewById(i.f.sns_ad_slide_full_card_recycler_view_layout));
    paramViewStub.JJt = ((RecyclerView)paramBaseViewHolder.findViewById(i.f.sns_ad_slide_full_card_recycler_view));
    if (paramViewStub.JJt != null)
    {
      paramViewStub.JJt.setHasFixedSize(true);
      this.JJj = new CardLayoutManager(paramViewStub.JJt);
      this.JJD = new e(this.JJk, this.JJE);
      this.JJj.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.d(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8)));
      this.JJj.JNd = this.JJD;
      paramViewStub.JJt.setLayoutManager(this.JJj);
      this.JJh = new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.mActivity, 0, a(this.Kee), null, new c.b()
      {
        public final void fLc()
        {
          AppMethodBeat.i(229625);
          a.a(a.this).Kdz.a(paramViewStub, null);
          AppMethodBeat.o(229625);
        }
        
        public final ViewGroup fLd()
        {
          return paramViewStub.JJt;
        }
      });
    }
    label339:
    AppMethodBeat.o(204992);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(204996);
    try
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the item video play!!! item hash " + hashCode());
      com.tencent.mm.plugin.sns.ui.video.e.fZg().dmi();
      com.tencent.mm.plugin.sns.ui.video.b.fYX().a(this);
      if (this.JJD != null) {
        this.JJD.b(this.JJj);
      }
      AppMethodBeat.o(204996);
      return;
    }
    catch (Throwable paramBaseViewHolder)
    {
      AppMethodBeat.o(204996);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(204994);
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.AdSlideFullCardTimeLineItem", "fillItem::the holder is not type of AdSlideFullCardItemViewHolder!!!");
      AppMethodBeat.o(204994);
      return;
    }
    if (parambn == null)
    {
      Log.e("SnsAd.AdSlideFullCardTimeLineItem", "fillItem::the struct is null!!!");
      AppMethodBeat.o(204994);
      return;
    }
    if (paramBaseViewHolder.jTm)
    {
      Log.i("SnsAd.AdSlideFullCardTimeLineItem", "holder is busy");
      AppMethodBeat.o(204994);
      return;
    }
    paramBaseViewHolder.jTm = true;
    parambn = parambn.Jws;
    if ((parambn == null) || (parambn.getAdXml() == null))
    {
      AppMethodBeat.o(204994);
      return;
    }
    this.Jws = parambn;
    try
    {
      localObject1 = (a)paramBaseViewHolder;
      paramTimeLineObject = parambn.getAdXml().adSliderFullCardInfo;
      if (this.JJD != null) {
        this.JJD.Jws = parambn;
      }
      localRecyclerView = ((a)localObject1).JJt;
      if (localRecyclerView == null) {
        break label270;
      }
      localObject2 = localRecyclerView.getAdapter();
      if ((!(localObject2 instanceof c)) || (!((c)localObject2).o(parambn))) {
        break label346;
      }
      paramInt1 = 0;
      ((RecyclerView.a)localObject2).alc.notifyChanged();
    }
    catch (Throwable parambn)
    {
      for (;;)
      {
        Object localObject1;
        RecyclerView localRecyclerView;
        Object localObject2;
        continue;
        paramInt1 = 1;
      }
    }
    if (paramInt1 != 0)
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the adapter sns info is not same");
      localObject2 = this.Kee;
      localObject1 = new c(((a)localObject1).JJt, parambn, new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.mActivity, 0, a((bm)localObject2), null, new c.b()
      {
        public final void fLc()
        {
          AppMethodBeat.i(268971);
          this.JJH.Kdz.a(this.JJI, null);
          AppMethodBeat.o(268971);
        }
        
        public final ViewGroup fLd()
        {
          return this.JJI.JJt;
        }
      }));
      ((c)localObject1).aw(true);
      ((c)localObject1).JJR = this;
      ((c)localObject1).JJS = this;
      localRecyclerView.setAdapter((RecyclerView.a)localObject1);
    }
    label270:
    if (this.JJE != null) {
      this.JJE.a(parambn, 0, paramTimeLineObject);
    }
    paramTimeLineObject = a(parambm);
    if (paramTimeLineObject != null)
    {
      parambn = t.w(parambn);
      if ((!TextUtils.isEmpty(parambn)) && (!"0".equals(parambn))) {
        paramTimeLineObject.a(parambn, this);
      }
    }
    paramBaseViewHolder.jTm = false;
    AppMethodBeat.o(204994);
  }
  
  public final void aYz(String paramString)
  {
    AppMethodBeat.i(205009);
    try
    {
      if (this.JJE != null) {
        this.JJE.currentIndex = -1;
      }
      if (this.Jws != null)
      {
        String str = t.w(this.Jws);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          com.tencent.mm.plugin.sns.ad.i.j.a(this.JJE);
        }
      }
      AppMethodBeat.o(205009);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(205009);
    }
  }
  
  public final void aeU(int paramInt)
  {
    AppMethodBeat.i(205015);
    try
    {
      if (this.JJE != null) {
        this.JJE.aeW(paramInt);
      }
      AppMethodBeat.o(205015);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205015);
    }
  }
  
  public final void ay(View paramView, int paramInt)
  {
    AppMethodBeat.i(205013);
    try
    {
      SnsInfo localSnsInfo = this.Jws;
      if ((localSnsInfo == null) || (localSnsInfo.getAdXml() == null) || (localSnsInfo.getAdXml().adSliderFullCardInfo == null)) {}
      for (;;)
      {
        if (this.JJE != null) {
          this.JJE.aeV(paramInt);
        }
        AppMethodBeat.o(205013);
        return;
        com.tencent.mm.plugin.sns.ad.adxml.j localj = localSnsInfo.getAdXml().adSliderFullCardInfo;
        if ((localj.Jym != null) && (localj.Jym.size() > 0))
        {
          com.tencent.mm.plugin.sns.ad.adxml.i locali = (com.tencent.mm.plugin.sns.ad.adxml.i)localj.Jym.get(paramInt);
          if ((locali != null) && (locali.clickActionInfo != null))
          {
            int i = localj.aeI(paramInt);
            this.JJh.a(locali.clickActionInfo, localSnsInfo, i);
            this.JJh.gd(paramView);
          }
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(205013);
    }
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(205005);
    try
    {
      Object localObject = this.JJC;
      if ((localObject != null) && (((a)localObject).JJs != null))
      {
        int[] arrayOfInt = new int[2];
        ((a)localObject).JJs.getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        localObject = new Rect(i, j, ((a)localObject).JJs.getWidth() + i, ((a)localObject).JJs.getHeight() + j);
        AppMethodBeat.o(205005);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205005);
    }
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(205001);
    try
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the item video onUIPause!!! item hash " + hashCode());
      a(this.JJj);
      AppMethodBeat.o(205001);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205001);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(205000);
    try
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the item video pause!!! item hash " + hashCode());
      a(this.JJj);
      AppMethodBeat.o(205000);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205000);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(205002);
    try
    {
      Log.d("SnsAd.AdSlideFullCardTimeLineItem", "the item video stop!!! item hash " + hashCode());
      if (this.JJk != null) {
        this.JJk.stopAll();
      }
      AppMethodBeat.o(205002);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205002);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    RoundedCornerFrameLayout JJs;
    public RecyclerView JJt;
    ViewGroup mCB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.a
 * JD-Core Version:    0.7.0.1
 */