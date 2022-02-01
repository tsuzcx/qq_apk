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
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.c.c.f;
import com.tencent.mm.plugin.sns.ad.timeline.video.online.e;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.stackup.StackUpLayout;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class h
  extends b
  implements com.tencent.mm.plugin.sns.ad.f.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.c
{
  RoundedCornerFrameLayout JJs;
  RecyclerView JJt;
  ViewGroup JJu;
  ImageView JJv;
  TextView JJw;
  TextView JJy;
  com.tencent.mm.plugin.sns.ad.f.l KPn;
  CardLayoutManager LjS;
  e LjT;
  StackUpLayout Lkk;
  f Lkl;
  com.tencent.mm.plugin.sns.ad.timeline.c.c.c Lkm;
  com.tencent.mm.plugin.sns.ad.timeline.c.c.b Lkn;
  com.tencent.mm.plugin.sns.ad.timeline.c.c.a Lko;
  Context context;
  
  public h(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ad.f.l paraml)
  {
    AppMethodBeat.i(212096);
    this.LjT = new e();
    this.Lkm = new com.tencent.mm.plugin.sns.ad.timeline.c.c.c();
    this.timeLineObject = paramTimeLineObject;
    this.Jzk = paramSnsInfo;
    this.JIp = paramc;
    this.KPn = paraml;
    this.Lko = new com.tencent.mm.plugin.sns.ad.timeline.c.c.a(2);
    AppMethodBeat.o(212096);
  }
  
  private int getSource()
  {
    if (this.KPn != null) {
      return this.KPn.source;
    }
    return 1;
  }
  
  public final void aYz(String paramString)
  {
    AppMethodBeat.i(212114);
    try
    {
      if (this.Jzk != null)
      {
        String str = t.w(this.Jzk);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          j.a(this.Lko);
        }
      }
      AppMethodBeat.o(212114);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(212114);
    }
  }
  
  public final void ay(View paramView, int paramInt)
  {
    AppMethodBeat.i(212111);
    try
    {
      Log.d("SnsAd.TopicCardDetail", "the item is click");
      b(paramView, this.Jzk);
      if (this.Lko != null) {
        this.Lko.aeV(paramInt);
      }
      AppMethodBeat.o(212111);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(212111);
    }
  }
  
  protected final void b(View paramView, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(212117);
    com.tencent.mm.plugin.sns.ad.timeline.a.c localc = com.tencent.mm.plugin.sns.ad.timeline.a.a.e(5, this.context);
    if (localc != null)
    {
      com.tencent.mm.plugin.sns.ad.timeline.a.d locald = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
      if (this.KPn != null) {
        locald.y("sns_ad_statistic", this.KPn);
      }
      localc.a(paramView, getSource(), paramSnsInfo, locald);
    }
    if (this.Lkn != null) {
      this.Lkn.c(paramSnsInfo, false);
    }
    AppMethodBeat.o(212117);
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(212101);
    if (paramView1 != null) {}
    try
    {
      if ((this.Jzk == null) || (this.Jzk.getAdXml() == null))
      {
        Log.w("SnsAd.TopicCardDetail", "the content view is null??? the init view can't complete!!!!");
        AppMethodBeat.o(212101);
        return;
      }
      paramView2 = this.Jzk.getAdXml().adFinderTopicInfo;
      if (paramView2 == null)
      {
        Log.w("SnsAd.TopicCardDetail", "the adFinderTopicInfo is null");
        AppMethodBeat.o(212101);
        return;
      }
    }
    catch (Throwable paramView1)
    {
      Log.e("SnsAd.TopicCardDetail", "the init view failed");
      AppMethodBeat.o(212101);
      return;
    }
    if (this.Lko != null) {
      this.Lko.a(this.Jzk, getSource(), paramView2);
    }
    this.context = paramView1.getContext();
    this.JJs = ((RoundedCornerFrameLayout)paramView1.findViewById(i.f.sns_ad_finder_topic_recycler_view_layout));
    this.JJt = ((RecyclerView)paramView1.findViewById(i.f.sns_ad_finder_topic_recycler_view));
    this.JJv = ((ImageView)paramView1.findViewById(i.f.sns_ad_finder_topic_rear_desc_flag_image));
    this.JJw = ((TextView)paramView1.findViewById(i.f.sns_ad_finder_topic_rear_desc_text));
    this.Lkk = ((StackUpLayout)paramView1.findViewById(i.f.sns_ad_finder_topic_participants_layout));
    this.JJy = ((TextView)paramView1.findViewById(i.f.sns_ad_finder_topic_participants_desc_text));
    this.JJu = ((ViewGroup)paramView1.findViewById(i.f.sns_ad_finder_topic_rear_desc_layout));
    if (this.JJv != null) {
      this.JJv.setImageResource(i.i.sns_ad_finder_topic_item_rear_flag);
    }
    if (this.JJu != null) {
      this.JJu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194251);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/TopicCardDetailItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (h.this.Lko != null) {
            h.this.Lko.fLG();
          }
          h.this.b(paramAnonymousView, h.this.Jzk);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TopicCardDetailItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194251);
        }
      });
    }
    com.tencent.mm.plugin.sns.ad.i.l.f(this.JJw, paramView2.Jyj);
    com.tencent.mm.plugin.sns.ad.i.l.f(this.JJy, paramView2.Jyk);
    int i;
    if (this.Lkk != null)
    {
      this.Lkk.setStackUpWidthSize(com.tencent.mm.ci.a.fromDPToPix(this.context, 6));
      i = com.tencent.mm.ci.a.fromDPToPix(this.context, 20);
      this.Lkk.jA(i, i);
      this.Lkm.a(this.Lkk, this.Jzk);
    }
    if (this.JJs != null)
    {
      i = com.tencent.mm.ci.a.fromDPToPix(this.context, 8);
      this.JJs.v(i, i, 0.0F, 0.0F);
    }
    if (this.JJt != null)
    {
      if (this.JJt != null)
      {
        paramView1 = this.JJt.getLayoutParams();
        if (paramView1 != null) {
          paramView1.height = com.tencent.mm.ci.a.fromDPToPix(this.context, 222);
        }
      }
      this.LjS = new CardLayoutManager(this.JJt);
      this.Lkl = new f(this.LjT, this.Lko);
      this.Lkl.Jws = this.Jzk;
      this.LjS.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.a(com.tencent.mm.ci.a.fromDPToPix(this.context, 12), com.tencent.mm.ci.a.fromDPToPix(this.context, 8)));
      this.LjS.JNd = this.Lkl;
      this.JJt.setLayoutManager(this.LjS);
      paramView1 = new com.tencent.mm.plugin.sns.ad.timeline.c.c.d(this.JJt, this.Jzk);
      paramView1.aw(true);
      paramView1.JJR = this;
      this.JJt.setAdapter(paramView1);
    }
    if ((this.context instanceof Activity))
    {
      this.Lkn = new com.tencent.mm.plugin.sns.ad.timeline.c.c.b((Activity)this.context, this.JJy, this.JJt);
      this.Lkn.c(this.Jzk, true);
    }
    paramView1 = this.KPn;
    if (paramView1 != null)
    {
      paramView2 = t.w(this.Jzk);
      if ((!TextUtils.isEmpty(paramView2)) && (!"0".equals(paramView2))) {
        paramView1.a(paramView2, this);
      }
    }
    AppMethodBeat.o(212101);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(212108);
    Log.d("SnsAd.TopicCardDetail", "the onPause is called");
    try
    {
      super.onPause();
      if (this.Lkl != null) {
        this.Lkl.fLB();
      }
      if (this.LjS != null) {
        this.LjS.fMn();
      }
      AppMethodBeat.o(212108);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(212108);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(212106);
    try
    {
      Log.d("SnsAd.TopicCardDetail", "the refresh view is called");
      if (this.Lkl != null) {
        this.Lkl.b(this.LjS);
      }
      AppMethodBeat.o(212106);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(212106);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.h
 * JD-Core Version:    0.7.0.1
 */