package com.tencent.mm.plugin.sns.ui.item.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.ad.widget.alphavideo.AdAlphaPlayerView;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdBreakFrameVideoView;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.r;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.b.x;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameAdBusiness;", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/BaseFullCardAdBusiness;", "()V", "adClickActionHandler", "Lcom/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler;", "getAdClickActionHandler", "()Lcom/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler;", "setAdClickActionHandler", "(Lcom/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler;)V", "controller", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController;", "getController", "()Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController;", "hasSetOnPreDrawListener", "", "getHasSetOnPreDrawListener", "()Z", "setHasSetOnPreDrawListener", "(Z)V", "showComment", "Landroid/view/View;", "getShowComment", "()Landroid/view/View;", "calControlViewLocation", "", "currentOffLeft", "", "currentOffTop", "calVideoContainerLocation", "Lkotlin/Pair;", "calVideoViewLocation", "Landroid/widget/FrameLayout$LayoutParams;", "calViewLocation", "getClickAreaLayoutParams", "scale", "", "breakFrameViewHeight", "breakClickInfo", "Lcom/tencent/mm/plugin/sns/storage/AdBreakFrameClickInfo;", "safeHeight", "getSource", "onAdRemoved", "onCreate", "activity", "Landroid/app/Activity;", "snsAdStatistic", "Lcom/tencent/mm/plugin/sns/ad/model/SnsAdStatistic;", "listener", "Lcom/tencent/mm/plugin/sns/ui/listener/TimelineClickListener;", "wrapHolder", "Lcom/tencent/mm/plugin/sns/ad/timeline/item/fullcard/FullCardAdWrapper$ViewHolder;", "wrapper", "Lcom/tencent/mm/plugin/sns/ad/timeline/item/fullcard/FullCardAdWrapper;", "onRefresh", "position", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "fullCardInfo", "Lcom/tencent/mm/plugin/sns/storage/ADXml$AdFullCardInfo;", "contentParams", "Landroid/view/ViewGroup$LayoutParams;", "onUIDestroy", "onVideoPlaying", "playTimeMs", "", "duration", "setLeftMarginOff", "currentOff", "setTopMarginOff", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.sns.ui.item.a.a.a
{
  public static final a.a ROj;
  boolean Qex;
  final b ROk;
  com.tencent.mm.plugin.sns.ad.timeline.a.a.c ROl;
  
  static
  {
    AppMethodBeat.i(309154);
    ROj = new a.a((byte)0);
    AppMethodBeat.o(309154);
  }
  
  public a()
  {
    AppMethodBeat.i(309119);
    this.ROk = new b();
    AppMethodBeat.o(309119);
  }
  
  private static final void a(a parama, Void paramVoid)
  {
    AppMethodBeat.i(309128);
    s.u(parama, "this$0");
    parama.ROk.nP();
    AppMethodBeat.o(309128);
  }
  
  private final int getSource()
  {
    if (this.PYh != null)
    {
      l locall = this.PYh;
      if (locall == null) {
        return 0;
      }
      return locall.source;
    }
    return 1;
  }
  
  public final void a(int paramInt, SnsInfo paramSnsInfo, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject = null;
    AppMethodBeat.i(309169);
    super.a(paramInt, paramSnsInfo, paramg, paramLayoutParams);
    if (this.RIM == null)
    {
      AppMethodBeat.o(309169);
      return;
    }
    this.ROk.a(this.RIM, paramSnsInfo, (Context)this.mActivity, this.PYh);
    paramSnsInfo = this.RIM.Qcl;
    if (paramSnsInfo != null) {
      paramSnsInfo.setDetachedListener(new a..ExternalSyntheticLambda0(this));
    }
    if (this.ROk.ROq.getValue() != null) {
      this.ROk.ROq.setValue(null);
    }
    if (!this.Qex)
    {
      paramSnsInfo = this.RIM.Qcl;
      if (paramSnsInfo != null) {
        break label160;
      }
    }
    label160:
    for (paramSnsInfo = localObject;; paramSnsInfo = paramSnsInfo.getViewTreeObserver())
    {
      if (paramSnsInfo != null) {
        paramSnsInfo.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new d(this));
      }
      this.Qex = true;
      AppMethodBeat.o(309169);
      return;
    }
  }
  
  public final void a(Activity paramActivity, l paraml, com.tencent.mm.plugin.sns.ui.listener.c paramc, com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b paramb, com.tencent.mm.plugin.sns.ad.timeline.b.b.a parama)
  {
    AppMethodBeat.i(309166);
    super.a(paramActivity, paraml, paramc, paramb, parama);
    if (paramb == null)
    {
      AppMethodBeat.o(309166);
      return;
    }
    if (this.mActivity == null)
    {
      AppMethodBeat.o(309166);
      return;
    }
    if (parama != null) {
      parama.QbQ = ((c)this.ROk);
    }
    this.ROk.a(this.RIM, this.PJQ, (Context)this.mActivity, this.PYh);
    if (paramb.Qcl == null)
    {
      paramActivity = ((ViewStub)paramb.Qcs.findViewById(b.f.sns_ad_break_video_stub)).inflate();
      if (paramActivity == null)
      {
        paramActivity = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.widget.SnsAdBreakFrameVideoView");
        AppMethodBeat.o(309166);
        throw paramActivity;
      }
      paramb.Qcl = ((SnsAdBreakFrameVideoView)paramActivity);
    }
    for (;;)
    {
      this.ROl = new com.tencent.mm.plugin.sns.ad.timeline.a.a.c((Context)this.mActivity, getSource(), this.PYh, null, (c.b)new b(this));
      this.ROk.ROt = ((kotlin.g.a.a)new c(this));
      AppMethodBeat.o(309166);
      return;
      Log.e("BreakFrameAdBusiness", "buildContent many times");
    }
  }
  
  public final void hqZ()
  {
    long l2 = 0L;
    AppMethodBeat.i(309175);
    super.hqZ();
    b localb = this.ROk;
    Object localObject3 = localb.PJQ;
    if (localObject3 != null) {}
    label522:
    label529:
    for (;;)
    {
      float f1;
      float f2;
      long l1;
      try
      {
        Object localObject1 = ((SnsInfo)localObject3).getAdXml().adBreakFrameInfo;
        if (localObject1 == null)
        {
          localObject1 = null;
          if (localObject1 == null) {
            break label504;
          }
          localObject2 = ((SnsInfo)localObject3).getAdXml().adBreakFrameInfo;
          if (localObject2 == null)
          {
            localObject2 = null;
            if (localObject2 == null) {
              break label504;
            }
            localb.a((h)localObject2);
            float f3 = ((h)localObject2).QYu.QYC;
            if (((h)localObject2).ibT.aaTF <= 0.0F) {
              continue;
            }
            f1 = ((h)localObject2).ibT.aaTF * 1000.0F;
            f2 = ((h)localObject2).QYu.QYD;
            if (f2 <= 0.0F) {
              break label529;
            }
            f2 = Math.min(f2, f1);
            localObject2 = localb.QbO;
            if (localObject2 != null) {
              continue;
            }
            i = 0;
            break label511;
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("snsid", t.uA(((SnsInfo)localObject3).field_snsId));
            ((JSONObject)localObject2).put("uxinfo", ((SnsInfo)localObject3).getUxinfo());
            ((JSONObject)localObject2).put("scene", i);
            localObject3 = new JSONObject();
            ((JSONObject)localObject2).put("extInfo", localObject3);
            ((JSONObject)localObject3).put("videoDuration", Float.valueOf(f1));
            ((JSONObject)localObject3).put("clickAreaStartTime", Float.valueOf(((com.tencent.mm.plugin.sns.storage.a)localObject1).QIs));
            ((JSONObject)localObject3).put("loopStartTime", Float.valueOf(f3));
            ((JSONObject)localObject3).put("loopEndTime", Float.valueOf(f2));
            int j = localb.ROz;
            i = j;
            if (j < 0) {
              i = 0;
            }
            ((JSONObject)localObject3).put("videoPlayTotalTime", i);
            ((JSONObject)localObject3).put("videoPlayCount", localb.ROy);
            localObject1 = ((JSONObject)localObject2).toString();
            s.s(localObject1, "obj.toString()");
            Log.d("BreakFrameCardAdController", s.X("sns_ad_break_frame_report:", localObject1));
            com.tencent.mm.plugin.sns.data.m.lU("sns_ad_break_frame_report", (String)localObject1);
            AppMethodBeat.o(309175);
          }
        }
        else
        {
          localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).QIw;
          continue;
        }
        Object localObject2 = ((com.tencent.mm.plugin.sns.storage.b)localObject2).QIv;
        continue;
        Object localObject4 = localb.QbM;
        if (localObject4 == null)
        {
          l1 = l2;
          break label522;
        }
        localObject4 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject4).Qcl;
        l1 = l2;
        if (localObject4 == null) {
          break label522;
        }
        localObject4 = ((SnsAdBreakFrameVideoView)localObject4).getMPlayerView();
        l1 = l2;
        if (localObject4 == null) {
          break label522;
        }
        localObject4 = ((AdAlphaPlayerView)localObject4).QeH;
        l1 = l2;
        if (localObject4 == null) {
          break label522;
        }
        l1 = ((com.tencent.mm.plugin.thumbplayer.e.a)localObject4).getDurationMs();
        break label522;
        i = ((l)localObject2).source;
      }
      catch (Exception localException)
      {
        Log.e("BreakFrameCardAdController", s.X("sns_ad_break_frame_report, exp=", localException));
      }
      int i = 2;
      continue;
      label504:
      AppMethodBeat.o(309175);
      return;
      label511:
      if (i == 0)
      {
        i = 1;
        continue;
        f1 = (float)l1;
        continue;
        f2 = f1;
      }
    }
  }
  
  public final View hrd()
  {
    AppMethodBeat.i(309160);
    Object localObject = this.RIM;
    if (localObject == null)
    {
      AppMethodBeat.o(309160);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Qcs;
    if (localObject == null)
    {
      AppMethodBeat.o(309160);
      return null;
    }
    localObject = ((View)localObject).findViewById(b.f.album_show_comment_tv);
    AppMethodBeat.o(309160);
    return localObject;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(309178);
    super.onUIDestroy();
    AppMethodBeat.o(309178);
  }
  
  public final void vA(long paramLong) {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameAdBusiness$onCreate$1", "Lcom/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler$CardAnimPrepareListener;", "onGetAnimContentView", "Landroid/view/ViewGroup;", "onPrepareOpenCanvasAnim", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c.b
  {
    b(a parama) {}
    
    public final void hbt()
    {
      AppMethodBeat.i(309153);
      a.a(this.ROm);
      AppMethodBeat.o(309153);
    }
    
    public final ViewGroup hbu()
    {
      AppMethodBeat.i(309158);
      Object localObject = a.b(this.ROm);
      if (localObject == null) {}
      for (localObject = null; (localObject instanceof ViewGroup); localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Cxb)
      {
        localObject = (ViewGroup)localObject;
        AppMethodBeat.o(309158);
        return localObject;
      }
      AppMethodBeat.o(309158);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.sns.ad.timeline.a.a.c>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameAdBusiness$onRefresh$2", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ViewTreeObserver.OnPreDrawListener
  {
    d(a parama) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(309172);
      Object localObject = a.b(this.ROm);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Qcl;
        if (localObject != null)
        {
          localObject = ((SnsAdBreakFrameVideoView)localObject).getViewTreeObserver();
          if (localObject != null) {
            ((ViewTreeObserver)localObject).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
          }
        }
      }
      localObject = a.c(this.ROm);
      this.ROm.ROk.ROu = ((kotlin.g.a.a)new a(this.ROm));
      this.ROm.ROk.ROv = ((r)new b(this.ROm));
      this.ROm.ROk.ROq.setValue(localObject);
      this.ROm.Qex = false;
      Log.i("BreakFrameAdBusiness", "onPreDraw() called");
      AppMethodBeat.o(309172);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<Integer>
    {
      a(a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */