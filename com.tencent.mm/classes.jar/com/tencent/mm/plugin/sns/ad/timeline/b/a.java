package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
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

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ad.g.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.c, com.tencent.mm.plugin.sns.ui.video.a
{
  SnsInfo PJQ;
  CardLayoutManager QaN;
  com.tencent.mm.plugin.sns.ad.timeline.video.online.e QaO;
  a QaP;
  com.tencent.mm.plugin.sns.ad.timeline.b.c.b QaQ;
  com.tencent.mm.plugin.sns.ad.timeline.b.c.f QaR;
  com.tencent.mm.plugin.sns.ad.timeline.b.c.c QaS;
  com.tencent.mm.plugin.sns.ad.timeline.b.c.a QaT;
  
  public a()
  {
    AppMethodBeat.i(311189);
    this.QaO = new com.tencent.mm.plugin.sns.ad.timeline.video.online.e();
    this.QaS = new com.tencent.mm.plugin.sns.ad.timeline.b.c.c();
    AppMethodBeat.o(311189);
  }
  
  private void a(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(311202);
    if (this.QaR != null) {
      this.QaR.hbY();
    }
    if (paramCardLayoutManager != null) {
      paramCardLayoutManager.hdj();
    }
    AppMethodBeat.o(311202);
  }
  
  private void c(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(311196);
    com.tencent.mm.plugin.sns.ad.timeline.b.c.b localb = this.QaQ;
    if (localb != null) {
      localb.c(paramSnsInfo, paramBoolean);
    }
    AppMethodBeat.o(311196);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(311250);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item video play!!! item hash " + hashCode());
      com.tencent.mm.plugin.sns.ui.video.e.hsu().bck();
      com.tencent.mm.plugin.sns.ui.video.b.hsi().a(this);
      if (this.QaR != null) {
        this.QaR.b(this.QaN);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311250);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(311236);
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.FinderTopicTimeLineItem", "fillItem::the holder is not type of FinderTopicItemViewHolder!!!");
      AppMethodBeat.o(311236);
      return;
    }
    if (parambo == null)
    {
      Log.e("SnsAd.FinderTopicTimeLineItem", "fillItem::the struct is null!!!");
      AppMethodBeat.o(311236);
      return;
    }
    if (paramBaseViewHolder.mtE)
    {
      Log.i("SnsAd.FinderTopicTimeLineItem", "holder is busy");
      AppMethodBeat.o(311236);
      return;
    }
    paramBaseViewHolder.mtE = true;
    final SnsInfo localSnsInfo = parambo.PJQ;
    if ((localSnsInfo == null) || (localSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(311236);
      return;
    }
    this.PJQ = localSnsInfo;
    try
    {
      localObject = (a)paramBaseViewHolder;
      paramTimeLineObject = localSnsInfo.getAdXml().adFinderTopicInfo;
      if (localObject != null)
      {
        com.tencent.mm.plugin.sns.ad.j.l.e(((a)localObject).Qbc, paramTimeLineObject.PME);
        this.QaS.a(((a)localObject).Qbb, localSnsInfo);
      }
      if (localObject != null)
      {
        if (((a)localObject).Qba != null) {
          ((a)localObject).Qba.setText(paramTimeLineObject.PMD);
        }
        if (((a)localObject).QaY != null) {
          ((a)localObject).QaY.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(311188);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/item/AdFinderTopicTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              try
              {
                if (a.this.QaT != null) {
                  a.this.QaT.hcc();
                }
                a.this.b(paramAnonymousView, localSnsInfo);
              }
              finally
              {
                label66:
                break label66;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/AdFinderTopicTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(311188);
            }
          });
        }
      }
      if (this.QaR != null) {
        this.QaR.PJQ = localSnsInfo;
      }
      localRecyclerView = ((a)localObject).QaX;
      if (localRecyclerView == null) {
        break label310;
      }
      RecyclerView.a locala = localRecyclerView.getAdapter();
      if ((!(locala instanceof com.tencent.mm.plugin.sns.ad.timeline.b.c.d)) || (!((com.tencent.mm.plugin.sns.ad.timeline.b.c.d)locala).q(localSnsInfo))) {
        break label458;
      }
      locala.bZE.notifyChanged();
      paramInt1 = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        RecyclerView localRecyclerView;
        continue;
        paramInt1 = 1;
      }
    }
    if (paramInt1 != 0)
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the adapter sns info is not same");
      localObject = new com.tencent.mm.plugin.sns.ad.timeline.b.c.d(((a)localObject).QaX, localSnsInfo);
      ((com.tencent.mm.plugin.sns.ad.timeline.b.c.d)localObject).bf(true);
      ((com.tencent.mm.plugin.sns.ad.timeline.b.c.d)localObject).Qbv = this;
      localRecyclerView.setAdapter((RecyclerView.a)localObject);
    }
    label310:
    c(localSnsInfo, true);
    if (this.QaT != null) {
      this.QaT.a(localSnsInfo, 0, paramTimeLineObject);
    }
    paramTimeLineObject = null;
    if ((parambn != null) && (parambn.Ryp != null) && (parambn.Ryp.Rbv != null)) {
      paramTimeLineObject = parambn.Ryp.Rbv;
    }
    for (;;)
    {
      if (paramTimeLineObject != null)
      {
        parambn = t.x(localSnsInfo);
        if ((!TextUtils.isEmpty(parambn)) && (!"0".equals(parambn))) {
          paramTimeLineObject.a(parambn, this);
        }
      }
      paramBaseViewHolder.mtE = false;
      a(parambo, 3);
      AppMethodBeat.o(311236);
      return;
      if ((this.mActivity instanceof SnsTimeLineUI)) {
        paramTimeLineObject = ((SnsTimeLineUI)this.mActivity).hpK();
      }
    }
  }
  
  public final void aU(View paramView, int paramInt)
  {
    AppMethodBeat.i(311288);
    try
    {
      b(paramView, this.PJQ);
      if (this.QaT != null) {
        this.QaT.ajE(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311288);
    }
  }
  
  public final void aWD(String paramString)
  {
    AppMethodBeat.i(311292);
    try
    {
      if (this.PJQ != null)
      {
        String str = t.x(this.PJQ);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          j.a(this.QaT);
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311292);
    }
  }
  
  protected final void b(View paramView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(311303);
    com.tencent.mm.plugin.sns.ad.timeline.a.c localc = com.tencent.mm.plugin.sns.ad.timeline.a.a.f(5, this.mActivity);
    if (localc != null)
    {
      com.tencent.mm.plugin.sns.ad.timeline.a.d locald = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
      if ((this.mActivity instanceof SnsTimeLineUI))
      {
        com.tencent.mm.plugin.sns.ad.g.l locall = ((SnsTimeLineUI)this.mActivity).hpK();
        if (locall != null) {
          locald.K("sns_ad_statistic", locall);
        }
      }
      localc.a(paramView, 0, paramSnsInfo, locald);
      c(this.PJQ, false);
    }
    AppMethodBeat.o(311303);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(311220);
    Log.d("SnsAd.FinderTopicTimeLineItem", "AdFinderTopicTimeLineItem build content is called");
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.FinderTopicTimeLineItem", "buildContent::the holder is not type of FinderTopicItemViewHolder!!!");
      AppMethodBeat.o(311220);
      return;
    }
    this.QaP = ((a)paramBaseViewHolder);
    Object localObject;
    for (;;)
    {
      try
      {
        if (paramBaseViewHolder.RKG != null)
        {
          paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_ad_finder_topic_item_content);
          if (!paramBaseViewHolder.RKH)
          {
            this.QaP.pzi = ((ViewGroup)paramBaseViewHolder.RKG.inflate());
            paramBaseViewHolder.RKH = true;
          }
          this.QaT = new com.tencent.mm.plugin.sns.ad.timeline.b.c.a(1);
          paramBaseViewHolder = this.QaP;
          if (paramBaseViewHolder == null) {
            break label490;
          }
          localObject = paramBaseViewHolder.pzi;
          if (localObject != null) {
            break;
          }
          Log.e("SnsAd.FinderTopicTimeLineItem", "fillViewHolder::the root null, is it right????");
        }
      }
      finally
      {
        AppMethodBeat.o(311220);
        return;
      }
      if (!paramBaseViewHolder.RKH)
      {
        this.QaP.pzi = ((ViewGroup)paramBaseViewHolder.convertView.findViewById(b.f.ad_card_container));
        paramBaseViewHolder.RKH = true;
      }
    }
    paramBaseViewHolder.QaW = ((RoundedCornerFrameLayout)((ViewGroup)localObject).findViewById(b.f.sns_ad_finder_topic_recycler_view_layout));
    paramBaseViewHolder.QaX = ((RecyclerView)((ViewGroup)localObject).findViewById(b.f.sns_ad_finder_topic_recycler_view));
    paramBaseViewHolder.QaZ = ((ImageView)((ViewGroup)localObject).findViewById(b.f.sns_ad_finder_topic_rear_desc_flag_image));
    paramBaseViewHolder.Qba = ((TextView)((ViewGroup)localObject).findViewById(b.f.sns_ad_finder_topic_rear_desc_text));
    paramBaseViewHolder.Qbb = ((StackUpLayout)((ViewGroup)localObject).findViewById(b.f.sns_ad_finder_topic_participants_layout));
    paramBaseViewHolder.Qbc = ((TextView)((ViewGroup)localObject).findViewById(b.f.sns_ad_finder_topic_participants_desc_text));
    paramBaseViewHolder.QaY = ((ViewGroup)((ViewGroup)localObject).findViewById(b.f.sns_ad_finder_topic_rear_desc_layout));
    if (paramBaseViewHolder.QaZ != null) {
      paramBaseViewHolder.QaZ.setImageResource(b.i.sns_ad_finder_topic_item_rear_flag);
    }
    int i;
    if (paramBaseViewHolder.Qbb != null)
    {
      localObject = paramBaseViewHolder.Qbb;
      ((StackUpLayout)localObject).setStackUpWidthSize(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 6));
      i = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 20);
      ((StackUpLayout)localObject).lk(i, i);
    }
    if (paramBaseViewHolder.QaW != null)
    {
      i = com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8);
      paramBaseViewHolder.QaW.A(i, i, 0.0F, 0.0F);
    }
    if (paramBaseViewHolder.QaX != null)
    {
      paramBaseViewHolder.QaX.setHasFixedSize(true);
      this.QaN = new CardLayoutManager(paramBaseViewHolder.QaX);
      this.QaR = new com.tencent.mm.plugin.sns.ad.timeline.b.c.f(this.QaO, this.QaT);
      this.QaN.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.a(com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 12), com.tencent.mm.cd.a.fromDPToPix(this.mActivity, 8)));
      this.QaN.QhD = this.QaR;
      paramBaseViewHolder.QaX.setLayoutManager(this.QaN);
    }
    this.QaQ = new com.tencent.mm.plugin.sns.ad.timeline.b.c.b(this.mActivity, paramBaseViewHolder.Qbc, paramBaseViewHolder.QaX);
    label490:
    AppMethodBeat.o(311220);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(311279);
    try
    {
      Object localObject1 = this.QaP;
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
      AppMethodBeat.o(311279);
    }
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(311261);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item  video onUIPause!!! item hash " + hashCode());
      a(this.QaN);
      return;
    }
    finally
    {
      AppMethodBeat.o(311261);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(311255);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item  video pause!!! item hash " + hashCode());
      a(this.QaN);
      return;
    }
    finally
    {
      AppMethodBeat.o(311255);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(311269);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item video stop!!! item hash " + hashCode());
      if (this.QaO != null) {
        this.QaO.stopAll();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311269);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    RoundedCornerFrameLayout QaW;
    RecyclerView QaX;
    ViewGroup QaY;
    ImageView QaZ;
    TextView Qba;
    StackUpLayout Qbb;
    TextView Qbc;
    ViewGroup pzi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a
 * JD-Core Version:    0.7.0.1
 */