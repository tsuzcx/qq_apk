package com.tencent.mm.plugin.sns.ad.timeline.c;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.timeline.c.a.f;
import com.tencent.mm.plugin.sns.ad.timeline.video.online.e;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class a
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ad.g.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.b, com.tencent.mm.plugin.sns.ui.video.a
{
  SnsInfo DqO;
  CardLayoutManager DyT;
  e DyU;
  a DyV;
  com.tencent.mm.plugin.sns.ad.timeline.c.a.b DyW;
  f DyX;
  com.tencent.mm.plugin.sns.ad.timeline.c.a.c DyY;
  com.tencent.mm.plugin.sns.ad.timeline.c.a.a DyZ;
  
  public a()
  {
    AppMethodBeat.i(202238);
    this.DyU = new e();
    this.DyY = new com.tencent.mm.plugin.sns.ad.timeline.c.a.c();
    AppMethodBeat.o(202238);
  }
  
  private void a(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(202249);
    if (this.DyX != null) {
      this.DyX.eYb();
    }
    if (paramCardLayoutManager != null) {
      paramCardLayoutManager.eYC();
    }
    AppMethodBeat.o(202249);
  }
  
  private void c(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(202248);
    com.tencent.mm.plugin.sns.ad.timeline.c.a.b localb = this.DyW;
    if (localb != null) {
      localb.c(paramSnsInfo, paramBoolean);
    }
    AppMethodBeat.o(202248);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(202241);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item video play!!! item hash " + hashCode());
      com.tencent.mm.plugin.sns.ui.video.d.fkS().cXa();
      com.tencent.mm.plugin.sns.ui.video.b.fkM().a(this);
      if (this.DyX != null) {
        this.DyX.b(this.DyT);
      }
      AppMethodBeat.o(202241);
      return;
    }
    catch (Throwable paramBaseViewHolder)
    {
      AppMethodBeat.o(202241);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, final TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(202240);
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.FinderTopicTimeLineItem", "fillItem::the holder is not type of FinderTopicItemViewHolder!!!");
      AppMethodBeat.o(202240);
      return;
    }
    if (parambl == null)
    {
      Log.e("SnsAd.FinderTopicTimeLineItem", "fillItem::the struct is null!!!");
      AppMethodBeat.o(202240);
      return;
    }
    if (paramBaseViewHolder.hho)
    {
      Log.i("SnsAd.FinderTopicTimeLineItem", "holder is busy");
      AppMethodBeat.o(202240);
      return;
    }
    paramBaseViewHolder.hho = true;
    paramTimeLineObject = parambl.DqO;
    if ((paramTimeLineObject == null) || (paramTimeLineObject.getAdXml() == null))
    {
      AppMethodBeat.o(202240);
      return;
    }
    this.DqO = paramTimeLineObject;
    try
    {
      localObject = (a)paramBaseViewHolder;
      parambl = paramTimeLineObject.getAdXml().adFinderTopicInfo;
      if (localObject != null)
      {
        m.f(((a)localObject).Dzi, parambl.DrQ);
        this.DyY.a(((a)localObject).Dzh, paramTimeLineObject);
      }
      if (localObject != null)
      {
        if (((a)localObject).Dzg != null) {
          ((a)localObject).Dzg.setText(parambl.DrP);
        }
        if (((a)localObject).Dze != null) {
          ((a)localObject).Dze.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(202237);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/timeline/item/AdFinderTopicTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              try
              {
                if (a.this.DyZ != null) {
                  a.this.DyZ.eXZ();
                }
                a.this.b(paramAnonymousView, paramTimeLineObject);
              }
              catch (Throwable paramAnonymousView)
              {
                label66:
                break label66;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/item/AdFinderTopicTimeLineItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(202237);
            }
          });
        }
      }
      if (this.DyX != null) {
        this.DyX.DqO = paramTimeLineObject;
      }
      localRecyclerView = ((a)localObject).Dzd;
      if (localRecyclerView == null) {
        break label307;
      }
      RecyclerView.a locala = localRecyclerView.getAdapter();
      if ((!(locala instanceof com.tencent.mm.plugin.sns.ad.timeline.c.a.d)) || (!((com.tencent.mm.plugin.sns.ad.timeline.c.a.d)locala).p(paramTimeLineObject))) {
        break label443;
      }
      locala.atj.notifyChanged();
      paramInt1 = 0;
    }
    catch (Throwable parambl)
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
      localObject = new com.tencent.mm.plugin.sns.ad.timeline.c.a.d(((a)localObject).Dzd, paramTimeLineObject);
      ((com.tencent.mm.plugin.sns.ad.timeline.c.a.d)localObject).au(true);
      ((com.tencent.mm.plugin.sns.ad.timeline.c.a.d)localObject).DzB = this;
      localRecyclerView.setAdapter((RecyclerView.a)localObject);
    }
    label307:
    c(paramTimeLineObject, true);
    if (this.DyZ != null) {
      this.DyZ.a(paramTimeLineObject, 0, parambl);
    }
    parambl = null;
    if ((parambk != null) && (parambk.EKl != null) && (parambk.EKl.EoE != null)) {
      parambl = parambk.EKl.EoE;
    }
    for (;;)
    {
      if (parambl != null)
      {
        paramTimeLineObject = r.v(paramTimeLineObject);
        if ((!TextUtils.isEmpty(paramTimeLineObject)) && (!"0".equals(paramTimeLineObject))) {
          parambl.a(paramTimeLineObject, this);
        }
      }
      paramBaseViewHolder.hho = false;
      AppMethodBeat.o(202240);
      return;
      if ((this.mActivity instanceof SnsTimeLineUI)) {
        parambl = ((SnsTimeLineUI)this.mActivity).fjf();
      }
    }
  }
  
  public final void aNK(String paramString)
  {
    AppMethodBeat.i(202247);
    try
    {
      if (this.DqO != null)
      {
        String str = r.v(this.DqO);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          com.tencent.mm.plugin.sns.ad.i.i.a(this.DyZ);
        }
      }
      AppMethodBeat.o(202247);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(202247);
    }
  }
  
  public final void au(View paramView, int paramInt)
  {
    AppMethodBeat.i(202246);
    try
    {
      b(paramView, this.DqO);
      if (this.DyZ != null) {
        this.DyZ.XN(paramInt);
      }
      AppMethodBeat.o(202246);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(202246);
    }
  }
  
  protected final void b(View paramView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(202250);
    com.tencent.mm.plugin.sns.ad.timeline.a.c localc = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(5, this.mActivity);
    if (localc != null)
    {
      com.tencent.mm.plugin.sns.ad.timeline.a.d locald = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
      if ((this.mActivity instanceof SnsTimeLineUI))
      {
        k localk = ((SnsTimeLineUI)this.mActivity).fjf();
        if (localk != null) {
          locald.z("sns_ad_statistic", localk);
        }
      }
      localc.a(paramView, 0, paramSnsInfo, locald);
      c(this.DqO, false);
    }
    AppMethodBeat.o(202250);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(202239);
    Log.d("SnsAd.FinderTopicTimeLineItem", "AdFinderTopicTimeLineItem build content is called");
    if (!(paramBaseViewHolder instanceof a))
    {
      Log.e("SnsAd.FinderTopicTimeLineItem", "buildContent::the holder is not type of FinderTopicItemViewHolder!!!");
      AppMethodBeat.o(202239);
      return;
    }
    this.DyV = ((a)paramBaseViewHolder);
    Object localObject;
    for (;;)
    {
      try
      {
        if (paramBaseViewHolder.EWD != null)
        {
          paramBaseViewHolder.EWD.setLayoutResource(2131496367);
          if (!paramBaseViewHolder.EWE)
          {
            this.DyV.jLx = ((ViewGroup)paramBaseViewHolder.EWD.inflate());
            paramBaseViewHolder.EWE = true;
          }
          this.DyZ = new com.tencent.mm.plugin.sns.ad.timeline.c.a.a(1);
          paramBaseViewHolder = this.DyV;
          if (paramBaseViewHolder == null) {
            break label490;
          }
          localObject = paramBaseViewHolder.jLx;
          if (localObject != null) {
            break;
          }
          Log.e("SnsAd.FinderTopicTimeLineItem", "fillViewHolder::the root null, is it right????");
          AppMethodBeat.o(202239);
          return;
        }
      }
      catch (Throwable paramBaseViewHolder)
      {
        AppMethodBeat.o(202239);
        return;
      }
      if (!paramBaseViewHolder.EWE)
      {
        this.DyV.jLx = ((ViewGroup)paramBaseViewHolder.convertView.findViewById(2131296484));
        paramBaseViewHolder.EWE = true;
      }
    }
    paramBaseViewHolder.Dzc = ((RoundedCornerFrameLayout)((ViewGroup)localObject).findViewById(2131308018));
    paramBaseViewHolder.Dzd = ((RecyclerView)((ViewGroup)localObject).findViewById(2131308017));
    paramBaseViewHolder.Dzf = ((ImageView)((ViewGroup)localObject).findViewById(2131308014));
    paramBaseViewHolder.Dzg = ((TextView)((ViewGroup)localObject).findViewById(2131308016));
    paramBaseViewHolder.Dzh = ((StackUpLayout)((ViewGroup)localObject).findViewById(2131308013));
    paramBaseViewHolder.Dzi = ((TextView)((ViewGroup)localObject).findViewById(2131308012));
    paramBaseViewHolder.Dze = ((ViewGroup)((ViewGroup)localObject).findViewById(2131308015));
    if (paramBaseViewHolder.Dzf != null) {
      paramBaseViewHolder.Dzf.setImageResource(2131691508);
    }
    int i;
    if (paramBaseViewHolder.Dzh != null)
    {
      localObject = paramBaseViewHolder.Dzh;
      ((StackUpLayout)localObject).setStackUpWidthSize(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 6));
      i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 20);
      ((StackUpLayout)localObject).ir(i, i);
    }
    if (paramBaseViewHolder.Dzc != null)
    {
      i = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8);
      paramBaseViewHolder.Dzc.s(i, i, 0.0F, 0.0F);
    }
    if (paramBaseViewHolder.Dzd != null)
    {
      paramBaseViewHolder.Dzd.setHasFixedSize(true);
      this.DyT = new CardLayoutManager(paramBaseViewHolder.Dzd);
      this.DyX = new f(this.DyU, this.DyZ);
      this.DyT.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.a(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 12), com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8)));
      this.DyT.DBs = this.DyX;
      paramBaseViewHolder.Dzd.setLayoutManager(this.DyT);
    }
    this.DyW = new com.tencent.mm.plugin.sns.ad.timeline.c.a.b(this.mActivity, paramBaseViewHolder.Dzi, paramBaseViewHolder.Dzd);
    label490:
    AppMethodBeat.o(202239);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(202245);
    try
    {
      Object localObject = this.DyV;
      if ((localObject != null) && (((a)localObject).Dzc != null))
      {
        int[] arrayOfInt = new int[2];
        ((a)localObject).Dzc.getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        localObject = new Rect(i, j, ((a)localObject).Dzc.getWidth() + i, ((a)localObject).Dzc.getHeight() + j);
        AppMethodBeat.o(202245);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202245);
    }
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(202243);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item  video onUIPause!!! item hash " + hashCode());
      a(this.DyT);
      AppMethodBeat.o(202243);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202243);
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(202242);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item  video pause!!! item hash " + hashCode());
      a(this.DyT);
      AppMethodBeat.o(202242);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202242);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(202244);
    try
    {
      Log.d("SnsAd.FinderTopicTimeLineItem", "the item video stop!!! item hash " + hashCode());
      if (this.DyU != null) {
        this.DyU.stopAll();
      }
      AppMethodBeat.o(202244);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202244);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    RoundedCornerFrameLayout Dzc;
    RecyclerView Dzd;
    ViewGroup Dze;
    ImageView Dzf;
    TextView Dzg;
    StackUpLayout Dzh;
    TextView Dzi;
    ViewGroup jLx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a
 * JD-Core Version:    0.7.0.1
 */