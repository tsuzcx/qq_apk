package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.List;

public final class f
  extends b
  implements com.tencent.mm.plugin.sns.ad.f.d, com.tencent.mm.plugin.sns.ad.widget.recyclerview.b, com.tencent.mm.plugin.sns.ad.widget.recyclerview.c
{
  com.tencent.mm.plugin.sns.ad.timeline.c.a.b JJE;
  private com.tencent.mm.plugin.sns.ad.timeline.a.a.c JJh;
  RoundedCornerFrameLayout JJs;
  public RecyclerView JJt;
  l KPn;
  CardLayoutManager LjS;
  com.tencent.mm.plugin.sns.ad.timeline.video.online.e LjT;
  com.tencent.mm.plugin.sns.ad.timeline.c.a.e LjU;
  Context context;
  
  public f(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, com.tencent.mm.plugin.sns.ui.d.c paramc, l paraml)
  {
    AppMethodBeat.i(270038);
    this.LjT = new com.tencent.mm.plugin.sns.ad.timeline.video.online.e();
    this.timeLineObject = paramTimeLineObject;
    this.Jzk = paramSnsInfo;
    this.JIp = paramc;
    this.KPn = paraml;
    this.JJE = new com.tencent.mm.plugin.sns.ad.timeline.c.a.b(2);
    AppMethodBeat.o(270038);
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
    AppMethodBeat.i(270045);
    try
    {
      if (this.Jzk != null)
      {
        String str = t.w(this.Jzk);
        if ((!TextUtils.isEmpty(str)) && (str.equals(paramString))) {
          com.tencent.mm.plugin.sns.ad.i.j.a(this.JJE);
        }
      }
      AppMethodBeat.o(270045);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(270045);
    }
  }
  
  public final void aeU(int paramInt)
  {
    AppMethodBeat.i(270044);
    try
    {
      if (this.JJE != null) {
        this.JJE.aeW(paramInt);
      }
      AppMethodBeat.o(270044);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(270044);
    }
  }
  
  public final void ay(View paramView, int paramInt)
  {
    AppMethodBeat.i(270042);
    try
    {
      SnsInfo localSnsInfo = this.Jzk;
      if ((localSnsInfo == null) || (localSnsInfo.getAdXml() == null) || (localSnsInfo.getAdXml().adSliderFullCardInfo == null)) {}
      for (;;)
      {
        if (this.JJE != null) {
          this.JJE.aeV(paramInt);
        }
        AppMethodBeat.o(270042);
        return;
        com.tencent.mm.plugin.sns.ad.adxml.j localj = localSnsInfo.getAdXml().adSliderFullCardInfo;
        if ((localj.Jym != null) && (localj.Jym.size() > 0))
        {
          i locali = (i)localj.Jym.get(paramInt);
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
      AppMethodBeat.o(270042);
    }
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(270039);
    if (paramView1 != null) {}
    try
    {
      if ((this.Jzk == null) || (this.Jzk.getAdXml() == null))
      {
        Log.w("SnsAd.SlideFullCardDetailItem", "the content view is null??? the init view can't complete!!!!");
        AppMethodBeat.o(270039);
        return;
      }
      paramView2 = this.Jzk.getAdXml().adSliderFullCardInfo;
      if (paramView2 == null)
      {
        Log.w("SnsAd.SlideFullCardDetailItem", "the adSliderFullCardInfo is null");
        AppMethodBeat.o(270039);
        return;
      }
    }
    catch (Throwable paramView1)
    {
      Log.e("SnsAd.SlideFullCardDetailItem", "the init view failed");
      AppMethodBeat.o(270039);
      return;
    }
    if (this.JJE != null) {
      this.JJE.a(this.Jzk, getSource(), paramView2);
    }
    this.context = paramView1.getContext();
    this.JJs = ((RoundedCornerFrameLayout)paramView1.findViewById(i.f.sns_ad_slide_full_card_recycler_view_layout));
    this.JJt = ((RecyclerView)paramView1.findViewById(i.f.sns_ad_slide_full_card_recycler_view));
    if (this.JJt != null)
    {
      this.JJt.setHasFixedSize(true);
      this.LjS = new CardLayoutManager(this.JJt);
      this.LjU = new com.tencent.mm.plugin.sns.ad.timeline.c.a.e(this.LjT, this.JJE);
      this.LjU.Jws = this.Jzk;
      this.LjS.a(new com.tencent.mm.plugin.sns.ad.widget.recyclerview.d(a.fromDPToPix(this.context, 12), a.fromDPToPix(this.context, 8)));
      this.LjS.JNd = this.LjU;
      this.LjS.source = getSource();
      this.JJt.setLayoutManager(this.LjS);
      this.JJh = new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.context, getSource(), this.KPn, null, new a());
      paramView1 = new com.tencent.mm.plugin.sns.ad.timeline.c.a.c(this.JJt, this.Jzk, new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.context, getSource(), this.KPn, null, new a()));
      paramView1.aw(true);
      paramView1.JJR = this;
      paramView1.JJS = this;
      this.JJt.setAdapter(paramView1);
    }
    paramView1 = this.KPn;
    if (paramView1 != null)
    {
      paramView2 = t.w(this.Jzk);
      if ((!TextUtils.isEmpty(paramView2)) && (!"0".equals(paramView2))) {
        paramView1.a(paramView2, this);
      }
    }
    AppMethodBeat.o(270039);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(270041);
    Log.d("SnsAd.SlideFullCardDetailItem", "the onPause is called");
    try
    {
      super.onPause();
      if (this.LjU != null) {
        this.LjU.fLB();
      }
      if (this.LjS != null) {
        this.LjS.fMn();
      }
      AppMethodBeat.o(270041);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(270041);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(270040);
    try
    {
      Log.d("SnsAd.SlideFullCardDetailItem", "the refresh view is called");
      if (this.LjU != null) {
        this.LjU.b(this.LjS);
      }
      AppMethodBeat.o(270040);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(270040);
    }
  }
  
  final class a
    implements c.b
  {
    a() {}
    
    public final void fLc()
    {
      AppMethodBeat.i(258023);
      if (f.this.JIp != null) {
        f.this.JIp.a(f.this, null);
      }
      AppMethodBeat.o(258023);
    }
    
    public final ViewGroup fLd()
    {
      return f.this.JJt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.f
 * JD-Core Version:    0.7.0.1
 */