package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.ad.timeline.video.online.e;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class g
  extends b
  implements com.tencent.mm.plugin.sns.ad.g.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.c
{
  RoundedCornerFrameLayout QaW;
  RecyclerView QaX;
  ViewGroup QaY;
  ImageView QaZ;
  TextView Qba;
  TextView Qbc;
  CardLayoutManager RJG;
  e RJH;
  StackUpLayout RJY;
  com.tencent.mm.plugin.sns.ad.timeline.b.c.f RJZ;
  com.tencent.mm.plugin.sns.ad.timeline.b.c.c RKa;
  com.tencent.mm.plugin.sns.ad.timeline.b.c.b RKb;
  com.tencent.mm.plugin.sns.ad.timeline.b.c.a RKc;
  com.tencent.mm.plugin.sns.ad.g.l RoZ;
  Context context;
  
  public g(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.listener.c paramc, com.tencent.mm.plugin.sns.ad.g.l paraml)
  {
    AppMethodBeat.i(308800);
    this.RJH = new e();
    this.RKa = new com.tencent.mm.plugin.sns.ad.timeline.b.c.c();
    this.timeLineObject = paramTimeLineObject;
    this.PNI = paramSnsInfo;
    this.PZr = paramc;
    this.RoZ = paraml;
    this.RKc = new com.tencent.mm.plugin.sns.ad.timeline.b.c.a(2);
    AppMethodBeat.o(308800);
  }
  
  private int getSource()
  {
    if (this.RoZ != null) {
      return this.RoZ.source;
    }
    return 1;
  }
  
  public final void aU(View paramView, int paramInt)
  {
    AppMethodBeat.i(308832);
    try
    {
      Log.d("SnsAd.TopicCardDetail", "the item is click");
      b(paramView, this.PNI);
      if (this.RKc != null) {
        this.RKc.ajE(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308832);
    }
  }
  
  public final void aWD(String paramString)
  {
    AppMethodBeat.i(308835);
    try
    {
      if (this.PNI != null)
      {
        String str = t.x(this.PNI);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          j.a(this.RKc);
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308835);
    }
  }
  
  protected final void b(View paramView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(308843);
    com.tencent.mm.plugin.sns.ad.timeline.a.c localc = com.tencent.mm.plugin.sns.ad.timeline.a.a.f(5, this.context);
    if (localc != null)
    {
      com.tencent.mm.plugin.sns.ad.timeline.a.d locald = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
      if (this.RoZ != null) {
        locald.K("sns_ad_statistic", this.RoZ);
      }
      localc.a(paramView, getSource(), paramSnsInfo, locald);
    }
    if (this.RKb != null) {
      this.RKb.c(paramSnsInfo, false);
    }
    AppMethodBeat.o(308843);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(308830);
    Log.d("SnsAd.TopicCardDetail", "the onPause is called");
    try
    {
      super.onPause();
      if (this.RJZ != null) {
        this.RJZ.hbY();
      }
      if (this.RJG != null) {
        this.RJG.hdj();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308830);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(308825);
    try
    {
      Log.d("SnsAd.TopicCardDetail", "the refresh view is called");
      if (this.RJZ != null) {
        this.RJZ.b(this.RJG);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308825);
    }
  }
  
  public final void t(View paramView1, View paramView2)
  {
    AppMethodBeat.i(308818);
    if (paramView1 != null) {}
    try
    {
      if ((this.PNI == null) || (this.PNI.getAdXml() == null))
      {
        Log.w("SnsAd.TopicCardDetail", "the content view is null??? the init view can't complete!!!!");
        AppMethodBeat.o(308818);
        return;
      }
      paramView2 = this.PNI.getAdXml().adFinderTopicInfo;
      if (paramView2 != null) {}
    }
    finally
    {
      Log.e("SnsAd.TopicCardDetail", "the init view failed");
      AppMethodBeat.o(308818);
      return;
    }
    if (this.RKc != null) {
      this.RKc.a(this.PNI, getSource(), paramView2);
    }
    this.context = paramView1.getContext();
    this.QaW = ((RoundedCornerFrameLayout)paramView1.findViewById(b.f.sns_ad_finder_topic_recycler_view_layout));
    this.QaX = ((RecyclerView)paramView1.findViewById(b.f.sns_ad_finder_topic_recycler_view));
    this.QaZ = ((ImageView)paramView1.findViewById(b.f.sns_ad_finder_topic_rear_desc_flag_image));
    this.Qba = ((TextView)paramView1.findViewById(b.f.sns_ad_finder_topic_rear_desc_text));
    this.RJY = ((StackUpLayout)paramView1.findViewById(b.f.sns_ad_finder_topic_participants_layout));
    this.Qbc = ((TextView)paramView1.findViewById(b.f.sns_ad_finder_topic_participants_desc_text));
    this.QaY = ((ViewGroup)paramView1.findViewById(b.f.sns_ad_finder_topic_rear_desc_layout));
    if (this.QaZ != null) {
      this.QaZ.setImageResource(b.i.sns_ad_finder_topic_item_rear_flag);
    }
    if (this.QaY != null) {
      this.QaY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(308820);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/TopicCardDetailItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (g.this.RKc != null) {
            g.this.RKc.hcc();
          }
          g.this.b(paramAnonymousView, g.this.PNI);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TopicCardDetailItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308820);
        }
      });
    }
    com.tencent.mm.plugin.sns.ad.j.l.e(this.Qba, paramView2.PMD);
    com.tencent.mm.plugin.sns.ad.j.l.e(this.Qbc, paramView2.PME);
    int i;
    if (this.RJY != null)
    {
      this.RJY.setStackUpWidthSize(com.tencent.mm.cd.a.fromDPToPix(this.context, 6));
      i = com.tencent.mm.cd.a.fromDPToPix(this.context, 20);
      this.RJY.lk(i, i);
      this.RKa.a(this.RJY, this.PNI);
    }
    if (this.QaW != null)
    {
      i = com.tencent.mm.cd.a.fromDPToPix(this.context, 8);
      this.QaW.A(i, i, 0.0F, 0.0F);
    }
    if (this.QaX != null)
    {
      if (this.QaX != null)
      {
        paramView1 = this.QaX.getLayoutParams();
        if (paramView1 != null) {
          paramView1.height = com.tencent.mm.cd.a.fromDPToPix(this.context, 222);
        }
      }
      this.RJG = new CardLayoutManager(this.QaX);
      this.RJZ = new com.tencent.mm.plugin.sns.ad.timeline.b.c.f(this.RJH, this.RKc);
      this.RJZ.PJQ = this.PNI;
      this.RJG.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.a(com.tencent.mm.cd.a.fromDPToPix(this.context, 12), com.tencent.mm.cd.a.fromDPToPix(this.context, 8)));
      this.RJG.QhD = this.RJZ;
      this.QaX.setLayoutManager(this.RJG);
      paramView1 = new com.tencent.mm.plugin.sns.ad.timeline.b.c.d(this.QaX, this.PNI);
      paramView1.bf(true);
      paramView1.Qbv = this;
      this.QaX.setAdapter(paramView1);
    }
    if ((this.context instanceof Activity))
    {
      this.RKb = new com.tencent.mm.plugin.sns.ad.timeline.b.c.b((Activity)this.context, this.Qbc, this.QaX);
      this.RKb.c(this.PNI, true);
    }
    paramView1 = this.RoZ;
    if (paramView1 != null)
    {
      paramView2 = t.x(this.PNI);
      if ((!TextUtils.isEmpty(paramView2)) && (!"0".equals(paramView2))) {
        paramView1.a(paramView2, this);
      }
    }
    AppMethodBeat.o(308818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.g
 * JD-Core Version:    0.7.0.1
 */