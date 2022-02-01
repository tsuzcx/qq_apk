package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.timeline.c.a.f;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class e
  extends a
  implements com.tencent.mm.plugin.sns.ad.g.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.b
{
  RoundedCornerFrameLayout Dzc;
  RecyclerView Dzd;
  ViewGroup Dze;
  ImageView Dzf;
  TextView Dzg;
  TextView Dzi;
  k EBv;
  StackUpLayout EVX;
  CardLayoutManager EVY;
  com.tencent.mm.plugin.sns.ad.timeline.video.online.e EVZ;
  f EWa;
  com.tencent.mm.plugin.sns.ad.timeline.c.a.c EWb;
  com.tencent.mm.plugin.sns.ad.timeline.c.a.b EWc;
  com.tencent.mm.plugin.sns.ad.timeline.c.a.a EWd;
  Context context;
  
  public e(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.d.c paramc, k paramk)
  {
    AppMethodBeat.i(203896);
    this.EVZ = new com.tencent.mm.plugin.sns.ad.timeline.video.online.e();
    this.EWb = new com.tencent.mm.plugin.sns.ad.timeline.c.a.c();
    this.timeLineObject = paramTimeLineObject;
    this.DsC = paramSnsInfo;
    this.Dyw = paramc;
    this.EBv = paramk;
    this.EWd = new com.tencent.mm.plugin.sns.ad.timeline.c.a.a(2);
    AppMethodBeat.o(203896);
  }
  
  private int getSource()
  {
    if (this.EBv != null) {
      return this.EBv.source;
    }
    return 1;
  }
  
  public final void aNK(String paramString)
  {
    AppMethodBeat.i(203901);
    try
    {
      if (this.DsC != null)
      {
        String str = r.v(this.DsC);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          i.a(this.EWd);
        }
      }
      AppMethodBeat.o(203901);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(203901);
    }
  }
  
  public final void au(View paramView, int paramInt)
  {
    AppMethodBeat.i(203900);
    try
    {
      Log.d("SnsAd.TopicCardDetail", "the item is click");
      b(paramView, this.DsC);
      if (this.EWd != null) {
        this.EWd.XN(paramInt);
      }
      AppMethodBeat.o(203900);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(203900);
    }
  }
  
  protected final void b(View paramView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(203902);
    com.tencent.mm.plugin.sns.ad.timeline.a.c localc = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(5, this.context);
    if (localc != null)
    {
      com.tencent.mm.plugin.sns.ad.timeline.a.d locald = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
      if (this.EBv != null) {
        locald.z("sns_ad_statistic", this.EBv);
      }
      localc.a(paramView, getSource(), paramSnsInfo, locald);
    }
    if (this.EWc != null) {
      this.EWc.c(paramSnsInfo, false);
    }
    AppMethodBeat.o(203902);
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(203897);
    if (paramView1 != null) {}
    try
    {
      if ((this.DsC == null) || (this.DsC.getAdXml() == null))
      {
        Log.w("SnsAd.TopicCardDetail", "the content view is null??? the init view can't complete!!!!");
        AppMethodBeat.o(203897);
        return;
      }
      paramView2 = this.DsC.getAdXml().adFinderTopicInfo;
      if (paramView2 == null)
      {
        Log.w("SnsAd.TopicCardDetail", "the adFinderTopicInfo is null");
        AppMethodBeat.o(203897);
        return;
      }
    }
    catch (Throwable paramView1)
    {
      Log.e("SnsAd.TopicCardDetail", "the init view failed");
      AppMethodBeat.o(203897);
      return;
    }
    if (this.EWd != null) {
      this.EWd.a(this.DsC, getSource(), paramView2);
    }
    this.context = paramView1.getContext();
    this.Dzc = ((RoundedCornerFrameLayout)paramView1.findViewById(2131308018));
    this.Dzd = ((RecyclerView)paramView1.findViewById(2131308017));
    this.Dzf = ((ImageView)paramView1.findViewById(2131308014));
    this.Dzg = ((TextView)paramView1.findViewById(2131308016));
    this.EVX = ((StackUpLayout)paramView1.findViewById(2131308013));
    this.Dzi = ((TextView)paramView1.findViewById(2131308012));
    this.Dze = ((ViewGroup)paramView1.findViewById(2131308015));
    if (this.Dzf != null) {
      this.Dzf.setImageResource(2131691508);
    }
    if (this.Dze != null) {
      this.Dze.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203895);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TopicCardDetailItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (e.this.EWd != null) {
            e.this.EWd.eXZ();
          }
          e.this.b(paramAnonymousView, e.this.DsC);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TopicCardDetailItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203895);
        }
      });
    }
    m.f(this.Dzg, paramView2.DrP);
    m.f(this.Dzi, paramView2.DrQ);
    int i;
    if (this.EVX != null)
    {
      this.EVX.setStackUpWidthSize(com.tencent.mm.cb.a.fromDPToPix(this.context, 6));
      i = com.tencent.mm.cb.a.fromDPToPix(this.context, 20);
      this.EVX.ir(i, i);
      this.EWb.a(this.EVX, this.DsC);
    }
    if (this.Dzc != null)
    {
      i = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
      this.Dzc.s(i, i, 0.0F, 0.0F);
    }
    if (this.Dzd != null)
    {
      if (this.Dzd != null)
      {
        paramView1 = this.Dzd.getLayoutParams();
        if (paramView1 != null) {
          paramView1.height = com.tencent.mm.cb.a.fromDPToPix(this.context, 222);
        }
      }
      this.EVY = new CardLayoutManager(this.Dzd);
      this.EWa = new f(this.EVZ, this.EWd);
      this.EWa.DqO = this.DsC;
      this.EVY.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.a(com.tencent.mm.cb.a.fromDPToPix(this.context, 12), com.tencent.mm.cb.a.fromDPToPix(this.context, 8)));
      this.EVY.DBs = this.EWa;
      this.Dzd.setLayoutManager(this.EVY);
      paramView1 = new com.tencent.mm.plugin.sns.ad.timeline.c.a.d(this.Dzd, this.DsC);
      paramView1.au(true);
      paramView1.DzB = this;
      this.Dzd.setAdapter(paramView1);
    }
    if ((this.context instanceof Activity))
    {
      this.EWc = new com.tencent.mm.plugin.sns.ad.timeline.c.a.b((Activity)this.context, this.Dzi, this.Dzd);
      this.EWc.c(this.DsC, true);
    }
    paramView1 = this.EBv;
    if (paramView1 != null)
    {
      paramView2 = r.v(this.DsC);
      if ((!TextUtils.isEmpty(paramView2)) && (!"0".equals(paramView2))) {
        paramView1.a(paramView2, this);
      }
    }
    AppMethodBeat.o(203897);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203899);
    Log.d("SnsAd.TopicCardDetail", "the onPause is called");
    try
    {
      super.onPause();
      if (this.EWa != null) {
        this.EWa.eYb();
      }
      if (this.EVY != null) {
        this.EVY.eYC();
      }
      AppMethodBeat.o(203899);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(203899);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(203898);
    try
    {
      Log.d("SnsAd.TopicCardDetail", "the refresh view is called");
      if (this.EWa != null) {
        this.EWa.b(this.EVY);
      }
      AppMethodBeat.o(203898);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(203898);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.e
 * JD-Core Version:    0.7.0.1
 */