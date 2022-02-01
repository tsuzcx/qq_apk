package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.ad.adxml.m;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;

public final class e
  extends b
  implements com.tencent.mm.plugin.sns.ad.g.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.b, com.tencent.mm.plugin.sns.ad.widget.recyclerview.c
{
  private com.tencent.mm.plugin.sns.ad.timeline.a.a.c QaL;
  RoundedCornerFrameLayout QaW;
  public RecyclerView QaX;
  com.tencent.mm.plugin.sns.ad.timeline.b.a.b Qbi;
  CardLayoutManager RJG;
  com.tencent.mm.plugin.sns.ad.timeline.video.online.e RJH;
  com.tencent.mm.plugin.sns.ad.timeline.b.a.e RJI;
  com.tencent.mm.plugin.sns.ad.g.l RoZ;
  Context context;
  
  public e(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.listener.c paramc, com.tencent.mm.plugin.sns.ad.g.l paraml)
  {
    AppMethodBeat.i(308822);
    this.RJH = new com.tencent.mm.plugin.sns.ad.timeline.video.online.e();
    this.timeLineObject = paramTimeLineObject;
    this.PNI = paramSnsInfo;
    this.PZr = paramc;
    this.RoZ = paraml;
    this.Qbi = new com.tencent.mm.plugin.sns.ad.timeline.b.a.b(2);
    AppMethodBeat.o(308822);
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
    AppMethodBeat.i(308874);
    try
    {
      SnsInfo localSnsInfo = this.PNI;
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
      AppMethodBeat.o(308874);
    }
  }
  
  public final void aWD(String paramString)
  {
    AppMethodBeat.i(308882);
    try
    {
      if (this.PNI != null)
      {
        String str = t.x(this.PNI);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          j.a(this.Qbi);
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308882);
    }
  }
  
  public final void ajD(int paramInt)
  {
    AppMethodBeat.i(308878);
    try
    {
      if (this.Qbi != null) {
        this.Qbi.ajF(paramInt);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308878);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(308868);
    Log.d("SnsAd.SlideFullCardDetailItem", "the onPause is called");
    try
    {
      super.onPause();
      if (this.RJI != null) {
        this.RJI.hbY();
      }
      if (this.RJG != null) {
        this.RJG.hdj();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308868);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(308863);
    try
    {
      Log.d("SnsAd.SlideFullCardDetailItem", "the refresh view is called");
      if (this.RJI != null) {
        this.RJI.b(this.RJG);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308863);
    }
  }
  
  public final void t(View paramView1, View paramView2)
  {
    AppMethodBeat.i(308856);
    if (paramView1 != null) {}
    try
    {
      if ((this.PNI == null) || (this.PNI.getAdXml() == null))
      {
        Log.w("SnsAd.SlideFullCardDetailItem", "the content view is null??? the init view can't complete!!!!");
        AppMethodBeat.o(308856);
        return;
      }
      paramView2 = this.PNI.getAdXml().adSliderFullCardInfo;
      if (paramView2 != null) {}
    }
    finally
    {
      Log.e("SnsAd.SlideFullCardDetailItem", "the init view failed");
      AppMethodBeat.o(308856);
      return;
    }
    if (this.Qbi != null) {
      this.Qbi.a(this.PNI, getSource(), paramView2);
    }
    this.context = paramView1.getContext();
    this.QaW = ((RoundedCornerFrameLayout)paramView1.findViewById(b.f.sns_ad_slide_full_card_recycler_view_layout));
    this.QaX = ((RecyclerView)paramView1.findViewById(b.f.sns_ad_slide_full_card_recycler_view));
    if (this.QaX != null)
    {
      this.QaX.setHasFixedSize(true);
      this.RJG = new CardLayoutManager(this.QaX);
      this.RJI = new com.tencent.mm.plugin.sns.ad.timeline.b.a.e(this.RJH, this.Qbi);
      this.RJI.PJQ = this.PNI;
      this.RJG.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.d(a.fromDPToPix(this.context, 12), a.fromDPToPix(this.context, 8)));
      this.RJG.QhD = this.RJI;
      this.RJG.source = getSource();
      this.QaX.setLayoutManager(this.RJG);
      this.QaL = new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.context, getSource(), this.RoZ, null, new a());
      paramView1 = new com.tencent.mm.plugin.sns.ad.timeline.b.a.c(this.QaX, this.PNI, new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.context, getSource(), this.RoZ, null, new a()));
      paramView1.bf(true);
      paramView1.Qbv = this;
      paramView1.Qbw = this;
      this.QaX.setAdapter(paramView1);
    }
    paramView1 = this.RoZ;
    if (paramView1 != null)
    {
      paramView2 = t.x(this.PNI);
      if ((!TextUtils.isEmpty(paramView2)) && (!"0".equals(paramView2))) {
        paramView1.a(paramView2, this);
      }
    }
    AppMethodBeat.o(308856);
  }
  
  final class a
    implements c.b
  {
    a() {}
    
    public final void hbt()
    {
      AppMethodBeat.i(308840);
      if (e.this.PZr != null) {
        e.this.PZr.a(e.this);
      }
      AppMethodBeat.o(308840);
    }
    
    public final ViewGroup hbu()
    {
      return e.this.QaX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.e
 * JD-Core Version:    0.7.0.1
 */