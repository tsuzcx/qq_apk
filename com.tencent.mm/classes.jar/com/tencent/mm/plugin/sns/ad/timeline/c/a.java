package com.tencent.mm.plugin.sns.ad.timeline.c;

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
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.c.c.f;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ad.f.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.c, com.tencent.mm.plugin.sns.ui.video.a
{
  CardLayoutManager JJj;
  com.tencent.mm.plugin.sns.ad.timeline.video.online.e JJk;
  a JJl;
  com.tencent.mm.plugin.sns.ad.timeline.c.c.b JJm;
  f JJn;
  com.tencent.mm.plugin.sns.ad.timeline.c.c.c JJo;
  com.tencent.mm.plugin.sns.ad.timeline.c.c.a JJp;
  SnsInfo Jws;
  
  public a()
  {
    AppMethodBeat.i(222518);
    this.JJk = new com.tencent.mm.plugin.sns.ad.timeline.video.online.e();
    this.JJo = new com.tencent.mm.plugin.sns.ad.timeline.c.c.c();
    AppMethodBeat.o(222518);
  }
  
  private void a(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(222597);
    if (this.JJn != null) {
      this.JJn.fLB();
    }
    if (paramCardLayoutManager != null) {
      paramCardLayoutManager.fMn();
    }
    AppMethodBeat.o(222597);
  }
  
  private void c(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(222593);
    com.tencent.mm.plugin.sns.ad.timeline.c.c.b localb = this.JJm;
    if (localb != null) {
      localb.c(paramSnsInfo, paramBoolean);
    }
    AppMethodBeat.o(222593);
  }
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(222541);
    Log.d("SnsAd.FinderTopicTimeLineItem", "AdFinderTopicTimeLineItem build content is called");
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.FinderTopicTimeLineItem", "buildContent::the holder is not type of FinderTopicItemViewHolder!!!");
      AppMethodBeat.o(222541);
      return;
    }
    this.JJl = ((a)paramBaseViewHolder);
    for (;;)
    {
      try
      {
        if (paramBaseViewHolder.LkR != null)
        {
          paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_ad_finder_topic_item_content);
          if (!paramBaseViewHolder.LkS)
          {
            this.JJl.mCB = ((ViewGroup)paramBaseViewHolder.LkR.inflate());
            paramBaseViewHolder.LkS = true;
          }
          this.JJp = new com.tencent.mm.plugin.sns.ad.timeline.c.c.a(1);
          paramViewStub = this.JJl;
          if (paramViewStub == null) {
            break label483;
          }
          paramBaseViewHolder = paramViewStub.mCB;
          if (paramBaseViewHolder != null) {
            break;
          }
          Log.e("SnsAd.FinderTopicTimeLineItem", "fillViewHolder::the root null, is it right????");
          AppMethodBeat.o(222541);
          return;
        }
      }
      catch (Throwable paramViewStub)
      {
        AppMethodBeat.o(222541);
        return;
      }
      if (!paramBaseViewHolder.LkS)
      {
        this.JJl.mCB = ((ViewGroup)paramBaseViewHolder.convertView.findViewById(i.f.ad_card_container));
        paramBaseViewHolder.LkS = true;
      }
    }
    paramViewStub.JJs = ((RoundedCornerFrameLayout)paramBaseViewHolder.findViewById(i.f.sns_ad_finder_topic_recycler_view_layout));
    paramViewStub.JJt = ((RecyclerView)paramBaseViewHolder.findViewById(i.f.sns_ad_finder_topic_recycler_view));
    paramViewStub.JJv = ((ImageView)paramBaseViewHolder.findViewById(i.f.sns_ad_finder_topic_rear_desc_flag_image));
    paramViewStub.JJw = ((TextView)paramBaseViewHolder.findViewById(i.f.sns_ad_finder_topic_rear_desc_text));
    paramViewStub.JJx = ((StackUpLayout)paramBaseViewHolder.findViewById(i.f.sns_ad_finder_topic_participants_layout));
    paramViewStub.JJy = ((TextView)paramBaseViewHolder.findViewById(i.f.sns_ad_finder_topic_participants_desc_text));
    paramViewStub.JJu = ((ViewGroup)paramBaseViewHolder.findViewById(i.f.sns_ad_finder_topic_rear_desc_layout));
    if (paramViewStub.JJv != null) {
      paramViewStub.JJv.setImageResource(i.i.sns_ad_finder_topic_item_rear_flag);
    }
    int i;
    if (paramViewStub.JJx != null)
    {
      paramBaseViewHolder = paramViewStub.JJx;
      paramBaseViewHolder.setStackUpWidthSize(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 6));
      i = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 20);
      paramBaseViewHolder.jA(i, i);
    }
    if (paramViewStub.JJs != null)
    {
      i = com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8);
      paramViewStub.JJs.v(i, i, 0.0F, 0.0F);
    }
    if (paramViewStub.JJt != null)
    {
      paramViewStub.JJt.setHasFixedSize(true);
      this.JJj = new CardLayoutManager(paramViewStub.JJt);
      this.JJn = new f(this.JJk, this.JJp);
      this.JJj.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.a(com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12), com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 8)));
      this.JJj.JNd = this.JJn;
      paramViewStub.JJt.setLayoutManager(this.JJj);
    }
    this.JJm = new com.tencent.mm.plugin.sns.ad.timeline.c.c.b(this.mActivity, paramViewStub.JJy, paramViewStub.JJt);
    label483:
    AppMethodBeat.o(222541);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(222562);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item video play!!! item hash " + hashCode());
      com.tencent.mm.plugin.sns.ui.video.e.fZg().dmi();
      com.tencent.mm.plugin.sns.ui.video.b.fYX().a(this);
      if (this.JJn != null) {
        this.JJn.b(this.JJj);
      }
      AppMethodBeat.o(222562);
      return;
    }
    catch (Throwable paramBaseViewHolder)
    {
      AppMethodBeat.o(222562);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, final TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(222557);
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.FinderTopicTimeLineItem", "fillItem::the holder is not type of FinderTopicItemViewHolder!!!");
      AppMethodBeat.o(222557);
      return;
    }
    if (parambn == null)
    {
      Log.e("SnsAd.FinderTopicTimeLineItem", "fillItem::the struct is null!!!");
      AppMethodBeat.o(222557);
      return;
    }
    if (paramBaseViewHolder.jTm)
    {
      Log.i("SnsAd.FinderTopicTimeLineItem", "holder is busy");
      AppMethodBeat.o(222557);
      return;
    }
    paramBaseViewHolder.jTm = true;
    paramTimeLineObject = parambn.Jws;
    if ((paramTimeLineObject == null) || (paramTimeLineObject.getAdXml() == null))
    {
      AppMethodBeat.o(222557);
      return;
    }
    this.Jws = paramTimeLineObject;
    try
    {
      localObject = (a)paramBaseViewHolder;
      parambn = paramTimeLineObject.getAdXml().adFinderTopicInfo;
      if (localObject != null)
      {
        com.tencent.mm.plugin.sns.ad.i.l.f(((a)localObject).JJy, parambn.Jyk);
        this.JJo.a(((a)localObject).JJx, paramTimeLineObject);
      }
      if (localObject != null)
      {
        if (((a)localObject).JJw != null) {
          ((a)localObject).JJw.setText(parambn.Jyj);
        }
        if (((a)localObject).JJu != null) {
          ((a)localObject).JJu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(265455);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/item/AdFinderTopicTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              try
              {
                if (a.this.JJp != null) {
                  a.this.JJp.fLG();
                }
                a.this.b(paramAnonymousView, paramTimeLineObject);
              }
              catch (Throwable paramAnonymousView)
              {
                label66:
                break label66;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/AdFinderTopicTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(265455);
            }
          });
        }
      }
      if (this.JJn != null) {
        this.JJn.Jws = paramTimeLineObject;
      }
      localRecyclerView = ((a)localObject).JJt;
      if (localRecyclerView == null) {
        break label316;
      }
      RecyclerView.a locala = localRecyclerView.getAdapter();
      if ((!(locala instanceof com.tencent.mm.plugin.sns.ad.timeline.c.c.d)) || (!((com.tencent.mm.plugin.sns.ad.timeline.c.c.d)locala).o(paramTimeLineObject))) {
        break label453;
      }
      locala.alc.notifyChanged();
      paramInt1 = 0;
    }
    catch (Throwable parambn)
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
      localObject = new com.tencent.mm.plugin.sns.ad.timeline.c.c.d(((a)localObject).JJt, paramTimeLineObject);
      ((com.tencent.mm.plugin.sns.ad.timeline.c.c.d)localObject).aw(true);
      ((com.tencent.mm.plugin.sns.ad.timeline.c.c.d)localObject).JJR = this;
      localRecyclerView.setAdapter((RecyclerView.a)localObject);
    }
    label316:
    c(paramTimeLineObject, true);
    if (this.JJp != null) {
      this.JJp.a(paramTimeLineObject, 0, parambn);
    }
    parambn = null;
    if ((parambm != null) && (parambm.KYo != null) && (parambm.KYo.KBN != null)) {
      parambn = parambm.KYo.KBN;
    }
    for (;;)
    {
      if (parambn != null)
      {
        paramTimeLineObject = t.w(paramTimeLineObject);
        if ((!TextUtils.isEmpty(paramTimeLineObject)) && (!"0".equals(paramTimeLineObject))) {
          parambn.a(paramTimeLineObject, this);
        }
      }
      paramBaseViewHolder.jTm = false;
      AppMethodBeat.o(222557);
      return;
      if ((this.mActivity instanceof SnsTimeLineUI)) {
        parambn = ((SnsTimeLineUI)this.mActivity).fXs();
      }
    }
  }
  
  public final void aYz(String paramString)
  {
    AppMethodBeat.i(222592);
    try
    {
      if (this.Jws != null)
      {
        String str = t.w(this.Jws);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          j.a(this.JJp);
        }
      }
      AppMethodBeat.o(222592);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(222592);
    }
  }
  
  public final void ay(View paramView, int paramInt)
  {
    AppMethodBeat.i(222585);
    try
    {
      b(paramView, this.Jws);
      if (this.JJp != null) {
        this.JJp.aeV(paramInt);
      }
      AppMethodBeat.o(222585);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(222585);
    }
  }
  
  protected final void b(View paramView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(222601);
    com.tencent.mm.plugin.sns.ad.timeline.a.c localc = com.tencent.mm.plugin.sns.ad.timeline.a.a.e(5, this.mActivity);
    if (localc != null)
    {
      com.tencent.mm.plugin.sns.ad.timeline.a.d locald = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
      if ((this.mActivity instanceof SnsTimeLineUI))
      {
        com.tencent.mm.plugin.sns.ad.f.l locall = ((SnsTimeLineUI)this.mActivity).fXs();
        if (locall != null) {
          locald.y("sns_ad_statistic", locall);
        }
      }
      localc.a(paramView, 0, paramSnsInfo, locald);
      c(this.Jws, false);
    }
    AppMethodBeat.o(222601);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(222578);
    try
    {
      Object localObject = this.JJl;
      if ((localObject != null) && (((a)localObject).JJs != null))
      {
        int[] arrayOfInt = new int[2];
        ((a)localObject).JJs.getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        localObject = new Rect(i, j, ((a)localObject).JJs.getWidth() + i, ((a)localObject).JJs.getHeight() + j);
        AppMethodBeat.o(222578);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(222578);
    }
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(222570);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item  video onUIPause!!! item hash " + hashCode());
      a(this.JJj);
      AppMethodBeat.o(222570);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(222570);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(222565);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item  video pause!!! item hash " + hashCode());
      a(this.JJj);
      AppMethodBeat.o(222565);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(222565);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(222573);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item video stop!!! item hash " + hashCode());
      if (this.JJk != null) {
        this.JJk.stopAll();
      }
      AppMethodBeat.o(222573);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(222573);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    RoundedCornerFrameLayout JJs;
    RecyclerView JJt;
    ViewGroup JJu;
    ImageView JJv;
    TextView JJw;
    StackUpLayout JJx;
    TextView JJy;
    ViewGroup mCB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a
 * JD-Core Version:    0.7.0.1
 */