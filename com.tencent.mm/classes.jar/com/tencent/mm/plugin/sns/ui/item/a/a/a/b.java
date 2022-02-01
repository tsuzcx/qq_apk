package com.tencent.mm.plugin.sns.ui.item.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.helper.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.helper.a.c;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdBreakFrameVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.b.ah.c;
import kotlin.g.b.ah.e;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.v.a;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController;", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameWrapperDelegate;", "()V", "adClickActionHandler", "Lkotlin/Function0;", "Lcom/tencent/mm/plugin/sns/ad/timeline/clicker/actionbutton/AdClickActionHandler;", "getAdClickActionHandler", "()Lkotlin/jvm/functions/Function0;", "setAdClickActionHandler", "(Lkotlin/jvm/functions/Function0;)V", "bizScope", "Lkotlinx/coroutines/CoroutineScope;", "getBizScope", "()Lkotlinx/coroutines/CoroutineScope;", "setBizScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "breakVideoControl", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/IVideoControllerForBreakFrame;", "getBreakVideoControl", "()Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/IVideoControllerForBreakFrame;", "currentSnsId", "", "getCurrentSnsId", "()Ljava/lang/String;", "setCurrentSnsId", "(Ljava/lang/String;)V", "fullCardVideoControl", "getFullCardVideoControl", "setFullCardVideoControl", "(Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/IVideoControllerForBreakFrame;)V", "getClickAreaLayoutParams", "Lkotlin/Function4;", "", "", "Lcom/tencent/mm/plugin/sns/storage/AdBreakFrameClickInfo;", "Landroid/widget/FrameLayout$LayoutParams;", "getGetClickAreaLayoutParams", "()Lkotlin/jvm/functions/Function4;", "setGetClickAreaLayoutParams", "(Lkotlin/jvm/functions/Function4;)V", "hasBreakVideoStarted", "", "getHasBreakVideoStarted", "()Z", "setHasBreakVideoStarted", "(Z)V", "hasPrepared", "getHasPrepared", "setHasPrepared", "isFirstPlayed", "setFirstPlayed", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mSnsAdstatistic", "Lcom/tencent/mm/plugin/sns/ad/model/SnsAdStatistic;", "getMSnsAdstatistic", "()Lcom/tencent/mm/plugin/sns/ad/model/SnsAdStatistic;", "setMSnsAdstatistic", "(Lcom/tencent/mm/plugin/sns/ad/model/SnsAdStatistic;)V", "mSnsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "getMSnsInfo", "()Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "setMSnsInfo", "(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "mViewHolder", "Lcom/tencent/mm/plugin/sns/ad/timeline/item/fullcard/FullCardAdWrapper$ViewHolder;", "getMViewHolder", "()Lcom/tencent/mm/plugin/sns/ad/timeline/item/fullcard/FullCardAdWrapper$ViewHolder;", "setMViewHolder", "(Lcom/tencent/mm/plugin/sns/ad/timeline/item/fullcard/FullCardAdWrapper$ViewHolder;)V", "playStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayStates;", "getPlayStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "restartPlayFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getRestartPlayFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "seekLeadTime", "", "getSeekLeadTime", "()J", "showCommentHeight", "getShowCommentHeight", "setShowCommentHeight", "uiReadyFlow", "getUiReadyFlow", "videoPlayCount", "getVideoPlayCount", "()I", "setVideoPlayCount", "(I)V", "videoPlayTotalTimeMs", "getVideoPlayTotalTimeMs", "setVideoPlayTotalTimeMs", "wrapHolder", "getWrapHolder", "addCurrentVideoTotalTimes", "", "videoInfo", "Lcom/tencent/mm/plugin/sns/storage/AlphaVideoInfo;", "delayForAdjust", "currentTime", "targetTime", "leadTime", "firstDelayTime", "maxDelayTime", "maxGap", "(Lkotlin/jvm/functions/Function0;JJIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initData", "viewHolder", "snsInfo", "context", "isnsAdstatistic", "isTimeLine", "onAdRemoved", "onClear", "pausePlay", "useOnlineVideo", "isSeekedToFirst", "readySnsSightOffline", "imageLoader2", "Lcom/tencent/mm/plugin/sns/model/LazyerImageLoader2;", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "newVideoView", "Lcom/tencent/mm/plugin/sns/ui/widget/SnsAdTimelineVideoView;", "fromscene", "Lcom/tencent/mm/storage/FROM_SCENE;", "reportBreakFrameInfo", "restartPlay", "setClickArea", "breakClickInfo", "clickActionInfo", "Lcom/tencent/mm/plugin/sns/ad/adxml/AdClickActionInfo;", "shouldClearSns", "startPlay", "startProcessCommandFlow", "playCommandFlow", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayInfo;", "trySetThumb", "Companion", "PlayCommand", "PlayInfo", "PlayStates", "UIModel", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c
{
  public static final b.a ROn;
  boolean Fey;
  SnsInfo PJQ;
  boolean QSr;
  com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b QbM;
  l QbO;
  boolean ROA;
  final long ROo;
  private aq ROp;
  final x<FrameLayout.LayoutParams> ROq;
  final x<b.d> ROr;
  final w<Boolean> ROs;
  kotlin.g.a.a<? extends com.tencent.mm.plugin.sns.ad.timeline.a.a.c> ROt;
  kotlin.g.a.a<Integer> ROu;
  kotlin.g.a.r<? super Double, ? super Integer, ? super com.tencent.mm.plugin.sns.storage.a, ? super Integer, ? extends FrameLayout.LayoutParams> ROv;
  private d ROw;
  private String ROx;
  int ROy;
  int ROz;
  Context mContext;
  
  static
  {
    AppMethodBeat.i(309196);
    ROn = new b.a((byte)0);
    AppMethodBeat.o(309196);
  }
  
  public b()
  {
    AppMethodBeat.i(309156);
    this.ROo = 50L;
    this.ROq = kotlinx.coroutines.b.ah.ji(null);
    this.ROr = kotlinx.coroutines.b.ah.ji(b.d.ROK);
    this.ROs = ad.a(1, 0, kotlinx.coroutines.a.g.ajxy);
    this.ROx = "";
    AppMethodBeat.o(309156);
  }
  
  private static final void a(b paramb, AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo, View paramView)
  {
    AppMethodBeat.i(309176);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramAdClickActionInfo);
    localb.cH(paramSnsInfo);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    Log.i("BreakFrameCardAdController", "click area");
    paramb = paramb.ROt;
    if (paramb == null) {}
    for (paramb = null; paramb == null; paramb = (com.tencent.mm.plugin.sns.ad.timeline.a.a.c)paramb.invoke())
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(309176);
      return;
    }
    if (paramAdClickActionInfo != null) {
      paramAdClickActionInfo.scene = 9;
    }
    paramb.a(paramAdClickActionInfo, paramSnsInfo, 0);
    paramb.jg(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(309176);
  }
  
  private static final void a(b paramb, Boolean paramBoolean)
  {
    AppMethodBeat.i(309170);
    s.u(paramb, "this$0");
    paramb.ROs.jc(Boolean.TRUE);
    AppMethodBeat.o(309170);
  }
  
  private boolean hrg()
  {
    boolean bool = false;
    l locall = this.QbO;
    if (locall == null) {}
    for (int i = 0;; i = locall.source)
    {
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final void Dh(boolean paramBoolean)
  {
    AppMethodBeat.i(309262);
    Log.d("BreakFrameCardAdController", s.X("startPlay() called with: useOnlineVideo = ", Boolean.valueOf(paramBoolean)));
    this.ROr.setValue(b.d.ROI);
    AppMethodBeat.o(309262);
  }
  
  public final void Du(boolean paramBoolean)
  {
    AppMethodBeat.i(309269);
    Log.d("BreakFrameCardAdController", s.X("pausePlay() called with: useOnlineVideo = ", Boolean.valueOf(paramBoolean)));
    if (this.ROr.getValue() != b.d.ROK) {
      this.ROr.setValue(b.d.ROJ);
    }
    AppMethodBeat.o(309269);
  }
  
  public final void Dv(boolean paramBoolean)
  {
    AppMethodBeat.i(309274);
    Log.d("BreakFrameCardAdController", s.X("restartPlay() called with: useOnlineVideo = ", Boolean.valueOf(paramBoolean)));
    Object localObject = this.QbM;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Qcj;
      if (localObject != null)
      {
        localObject = ((aw)localObject).RjN;
        if (localObject != null) {
          ((SnsAdTimelineVideoView)localObject).bEH();
        }
      }
    }
    AppMethodBeat.o(309274);
  }
  
  public final Object a(kotlin.g.a.a<Long> parama, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, kotlin.d.d<? super kotlin.ah> paramd)
  {
    AppMethodBeat.i(309254);
    if ((paramd instanceof f))
    {
      localObject1 = (f)paramd;
      if ((((f)localObject1).label & 0x80000000) != 0) {
        ((f)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;; paramd = new f(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309254);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Log.i("BreakFrameCardAdController", "delayForAdjust() called with: targetTime = " + paramLong1 + ", leadTime = " + paramLong2 + ", firstDelayTime = " + paramInt1 + ", maxDelayTime = " + paramInt2 + ", maxGap = " + paramInt3);
    long l1 = paramInt1;
    paramd.L$0 = parama;
    paramd.Yx = paramLong1;
    paramd.aKQ = paramLong2;
    paramd.aai = paramInt2;
    paramd.asI = paramInt3;
    paramd.label = 1;
    if (bb.e(l1, paramd) == locala)
    {
      AppMethodBeat.o(309254);
      return locala;
      paramInt3 = paramd.asI;
      paramInt2 = paramd.aai;
      paramLong2 = paramd.aKQ;
      paramLong1 = paramd.Yx;
      parama = (kotlin.g.a.a)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    Object localObject1 = new ah.e();
    paramInt1 = 0;
    int i = paramInt2;
    l1 = paramLong1;
    for (;;)
    {
      localObject2 = parama.invoke();
      ((ah.e)localObject1).aixc = ((Number)localObject2).longValue();
      kotlin.ah localah = kotlin.ah.aiuX;
      if ((l1 - ((Number)localObject2).longValue() <= paramInt3 + paramLong2) || (paramInt1 >= i)) {
        break;
      }
      Log.d("BreakFrameCardAdController", "delayForAdjust() called with: targetTime = " + l1 + ", cTime = " + ((ah.e)localObject1).aixc + ", tryTimes = " + paramInt1);
      long l3 = ((ah.e)localObject1).aixc;
      paramd.L$0 = parama;
      paramd.Uf = localObject1;
      paramd.Yx = l1;
      paramd.aKQ = paramLong2;
      paramd.aai = i;
      paramd.asI = paramInt3;
      paramd.nuz = paramInt1;
      paramd.label = 2;
      localObject2 = paramd;
      long l2 = l1;
      paramLong1 = paramLong2;
      paramInt2 = paramInt3;
      if (bb.e(l1 - l3 - paramLong2, paramd) == locala)
      {
        AppMethodBeat.o(309254);
        return locala;
        paramInt1 = paramd.nuz;
        paramInt2 = paramd.asI;
        i = paramd.aai;
        paramLong1 = paramd.aKQ;
        l2 = paramd.Yx;
        localObject1 = (ah.e)paramd.Uf;
        parama = (kotlin.g.a.a)paramd.L$0;
        ResultKt.throwOnFailure(localObject2);
        localObject2 = paramd;
      }
      paramInt1 += 1;
      paramd = (kotlin.d.d<? super kotlin.ah>)localObject2;
      l1 = l2;
      paramLong2 = paramLong1;
      paramInt3 = paramInt2;
    }
    parama = kotlin.ah.aiuX;
    AppMethodBeat.o(309254);
    return parama;
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b paramb, SnsInfo paramSnsInfo, Context paramContext, l paraml)
  {
    if (paramb != null) {
      this.QbM = paramb;
    }
    if (paramSnsInfo != null) {
      this.PJQ = paramSnsInfo;
    }
    if (paramContext != null) {
      this.mContext = paramContext;
    }
    if (paraml != null) {
      this.QbO = paraml;
    }
  }
  
  public final void a(final SnsInfo paramSnsInfo, final com.tencent.mm.plugin.sns.model.g paramg, final dmz paramdmz, final SnsAdTimelineVideoView paramSnsAdTimelineVideoView, final br parambr)
  {
    AppMethodBeat.i(309242);
    Log.d("BreakFrameCardAdController", "readySnsSightOffline() called with: snsInfo = " + paramSnsInfo + ", imageLoader2 = " + paramg + ", media = " + paramdmz + ", newVideoView = " + paramSnsAdTimelineVideoView + ", fromscene = " + parambr);
    paramSnsAdTimelineVideoView = this.QbM;
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.Qcj;
      if (paramSnsAdTimelineVideoView != null)
      {
        paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.RjP;
        if (paramSnsAdTimelineVideoView != null) {
          paramSnsAdTimelineVideoView.setVisibility(8);
        }
      }
    }
    paramSnsAdTimelineVideoView = this.QbM;
    if (paramSnsAdTimelineVideoView != null)
    {
      paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.Qcj;
      if (paramSnsAdTimelineVideoView != null)
      {
        paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.PQu;
        if (paramSnsAdTimelineVideoView != null) {
          paramSnsAdTimelineVideoView.setVisibility(8);
        }
      }
    }
    Object localObject2;
    int i;
    label182:
    Object localObject1;
    label196:
    label245:
    Object localObject3;
    if (paramSnsInfo == null)
    {
      paramSnsAdTimelineVideoView = null;
      localObject2 = this.ROx;
      if (!s.p(localObject2, "")) {
        break label524;
      }
      i = 0;
      if (i != 0)
      {
        if (paramSnsInfo != null) {
          break label562;
        }
        localObject1 = "null";
        Log.d("BreakFrameCardAdController", s.X("shouldClearSns called with: snsInfo = ", localObject1));
        nP();
      }
      if (this.ROp != null) {
        break label729;
      }
      this.ROp = ar.b(ar.kBZ(), (f)cx.g(null));
      if (paramdmz != null) {
        break label585;
      }
      localObject1 = null;
      localObject1 = com.tencent.mm.plugin.sns.data.t.db(1, (String)localObject1);
      if (paramg != null) {
        break label594;
      }
      localObject1 = null;
      label260:
      boolean bool = com.tencent.mm.plugin.sns.data.t.b((com.tencent.mm.memory.m)localObject1);
      localObject3 = al.getAccSnsPath();
      if (paramdmz != null) {
        break label605;
      }
      localObject2 = null;
      label279:
      localObject2 = as.mg((String)localObject3, (String)localObject2);
      localObject3 = com.tencent.mm.plugin.sns.data.t.d(paramdmz);
      if (!bool) {
        break label624;
      }
      localObject2 = this.QbM;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject2).Qcj;
        if (localObject2 != null)
        {
          localObject2 = ((aw)localObject2).RjN;
          if (localObject2 != null)
          {
            if (localObject1 != null) {
              break label614;
            }
            localObject1 = null;
            label342:
            ((SnsAdTimelineVideoView)localObject2).setThumbBmp((Bitmap)localObject1);
          }
        }
      }
      label349:
      localObject1 = this.QbM;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject1).Qcj;
        if (localObject1 != null)
        {
          localObject1 = ((aw)localObject1).RjN;
          if (localObject1 != null) {
            ((SnsAdTimelineVideoView)localObject1).hsQ();
          }
        }
      }
      if (paramg != null) {
        break label681;
      }
      localObject2 = null;
      label396:
      localObject1 = (CharSequence)localObject2;
      if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
        break label695;
      }
      i = 1;
      label419:
      if (i == 0)
      {
        localObject1 = this.QbM;
        if (localObject1 != null) {
          break label701;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((SnsAdTimelineVideoView)localObject1).setVideoPath((String)localObject2);
      }
      if (paramdmz != null) {
        break label778;
      }
      AppMethodBeat.o(309242);
      return;
      paramSnsAdTimelineVideoView = paramSnsInfo.getAdXml();
      if (paramSnsAdTimelineVideoView == null)
      {
        paramSnsAdTimelineVideoView = null;
        break;
      }
      paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.adBreakFrameInfo;
      if (paramSnsAdTimelineVideoView == null)
      {
        paramSnsAdTimelineVideoView = null;
        break;
      }
      paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.QIv;
      if (paramSnsAdTimelineVideoView == null)
      {
        paramSnsAdTimelineVideoView = null;
        break;
      }
      paramSnsAdTimelineVideoView = paramSnsAdTimelineVideoView.ibT;
      break;
      label524:
      if (paramSnsInfo == null) {}
      for (localObject1 = null;; localObject1 = paramSnsInfo.getSnsId())
      {
        if (!s.p(localObject2, localObject1)) {
          break label556;
        }
        i = 0;
        break;
      }
      label556:
      i = 1;
      break label182;
      label562:
      localObject2 = paramSnsInfo.getSnsId();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label196;
      }
      localObject1 = "null";
      break label196;
      label585:
      localObject1 = paramdmz.Id;
      break label245;
      label594:
      localObject1 = paramg.aYd((String)localObject1);
      break label260;
      label605:
      localObject2 = paramdmz.Id;
      break label279;
      label614:
      localObject1 = ((com.tencent.mm.memory.m)localObject1).bvR();
      break label342;
      label624:
      localObject1 = BitmapUtil.decodeFile(s.X((String)localObject2, localObject3));
      localObject2 = this.QbM;
      if (localObject2 == null) {
        break label349;
      }
      localObject2 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject2).Qcj;
      if (localObject2 == null) {
        break label349;
      }
      localObject2 = ((aw)localObject2).RjN;
      if (localObject2 == null) {
        break label349;
      }
      ((SnsAdTimelineVideoView)localObject2).setThumbBmp((Bitmap)localObject1);
      break label349;
      label681:
      localObject2 = paramg.a(paramSnsInfo, paramdmz, parambr, true);
      break label396;
      label695:
      i = 0;
      break label419;
      label701:
      localObject1 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject1).Qcj;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((aw)localObject1).RjN;
      }
    }
    label729:
    Log.d("BreakFrameCardAdController", "readySnsSightOffline has inited!");
    paramg = com.tencent.mm.plugin.sns.ad.timeline.helper.a.PZY;
    com.tencent.mm.plugin.sns.ad.timeline.helper.a.a(paramSnsInfo, paramdmz, parambr);
    paramg = com.tencent.mm.plugin.sns.ad.timeline.helper.a.PZY;
    com.tencent.mm.plugin.sns.ad.timeline.helper.a.a(paramSnsInfo, paramSnsAdTimelineVideoView, parambr);
    paramSnsInfo = com.tencent.mm.plugin.sns.ad.timeline.helper.a.PZY;
    com.tencent.mm.plugin.sns.ad.timeline.helper.a.a(paramdmz, parambr);
    AppMethodBeat.o(309242);
    return;
    label778:
    label807:
    label821:
    Object localObject4;
    label973:
    label980:
    label986:
    final float f1;
    if (paramSnsInfo == null)
    {
      localObject1 = "0";
      this.ROx = ((String)localObject1);
      localObject1 = this.QbM;
      if (localObject1 != null) {
        break label1181;
      }
      localObject1 = null;
      localObject2 = this.QbM;
      if (localObject2 != null) {
        break label1215;
      }
      localObject2 = null;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, com.tencent.mm.plugin.sns.b.i.shortvideo_play_btn));
      }
      if (localObject1 != null) {
        ((MMPinProgressBtn)localObject1).setVisibility(8);
      }
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(0);
      }
      localObject3 = ad.a(0, 0, kotlinx.coroutines.a.g.ajxx);
      localObject4 = this.QbM;
      if (localObject4 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject4).Qcj;
        if (localObject4 != null)
        {
          localObject4 = ((aw)localObject4).RjN;
          if (localObject4 != null) {
            ((SnsAdTimelineVideoView)localObject4).setOnReplay(new b..ExternalSyntheticLambda1(this));
          }
        }
      }
      localObject4 = this.ROp;
      if (localObject4 != null) {
        j.a((aq)localObject4, null, null, (kotlin.g.a.m)new g(paramg, paramdmz, parambr, paramSnsInfo, paramSnsAdTimelineVideoView, this, (w)localObject3, (ImageView)localObject2, (MMPinProgressBtn)localObject1, null), 3);
      }
      if (paramSnsInfo != null) {
        break label1249;
      }
      paramg = null;
      if (paramSnsInfo != null) {
        break label1299;
      }
      paramSnsAdTimelineVideoView = null;
      if (paramSnsInfo != null) {
        break label1338;
      }
      paramdmz = null;
      if (paramg != null) {
        break label1388;
      }
      f1 = 0.0F;
      label993:
      parambr = new ah.c();
      if (paramg != null) {
        break label1397;
      }
    }
    label1181:
    label1215:
    label1249:
    label1388:
    label1397:
    for (final float f2 = 0.0F;; f2 = paramg.QYB)
    {
      localObject1 = ad.a(0, 0, null, 7);
      localObject2 = new ah.f();
      localObject4 = this.ROp;
      if (localObject4 != null) {
        j.a((aq)localObject4, null, null, (kotlin.g.a.m)new k(this, f1, null), 3);
      }
      localObject4 = this.ROp;
      if (localObject4 != null) {
        j.a((aq)localObject4, null, null, (kotlin.g.a.m)new l(this, (w)localObject1, f1, (ah.f)localObject2, parambr, null), 3);
      }
      localObject4 = this.ROp;
      if (localObject4 != null) {
        j.a((aq)localObject4, null, null, (kotlin.g.a.m)new i((w)localObject3, this, paramSnsAdTimelineVideoView, paramdmz, paramSnsInfo, (ah.f)localObject2, paramg, parambr, f2, f1, (w)localObject1, null), 3);
      }
      AppMethodBeat.o(309242);
      return;
      localObject2 = paramSnsInfo.getSnsId();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "0";
      break;
      localObject1 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject1).Qcl;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label807;
      }
      localObject1 = (MMPinProgressBtn)((SnsAdBreakFrameVideoView)localObject1).findViewById(com.tencent.mm.plugin.sns.b.f.progress);
      break label807;
      localObject2 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject2).Qcl;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label821;
      }
      localObject2 = (ImageView)((SnsAdBreakFrameVideoView)localObject2).findViewById(com.tencent.mm.plugin.sns.b.f.status_btn);
      break label821;
      paramg = paramSnsInfo.getAdXml();
      if (paramg == null)
      {
        paramg = null;
        break label973;
      }
      paramg = paramg.adBreakFrameInfo;
      if (paramg == null)
      {
        paramg = null;
        break label973;
      }
      paramg = paramg.QIv;
      if (paramg == null)
      {
        paramg = null;
        break label973;
      }
      paramg = paramg.QYu;
      break label973;
      paramdmz = paramSnsInfo.getAdXml();
      if (paramdmz == null)
      {
        paramSnsAdTimelineVideoView = null;
        break label980;
      }
      paramdmz = paramdmz.adBreakFrameInfo;
      if (paramdmz == null)
      {
        paramSnsAdTimelineVideoView = null;
        break label980;
      }
      paramSnsAdTimelineVideoView = paramdmz.QIw;
      break label980;
      paramdmz = paramSnsInfo.getAdXml();
      if (paramdmz == null)
      {
        paramdmz = null;
        break label986;
      }
      paramdmz = paramdmz.adBreakFrameInfo;
      if (paramdmz == null)
      {
        paramdmz = null;
        break label986;
      }
      paramdmz = paramdmz.QIw;
      if (paramdmz == null)
      {
        paramdmz = null;
        break label986;
      }
      paramdmz = paramdmz.clickActionInfo;
      break label986;
      f1 = paramg.QYC;
      break label993;
    }
  }
  
  final void a(com.tencent.mm.plugin.sns.storage.h paramh)
  {
    long l = 0L;
    AppMethodBeat.i(309281);
    int i;
    if (this.ROA)
    {
      if (this.QSr)
      {
        float f = paramh.QYu.QYC;
        i = this.ROz;
        paramh = hre();
        if (paramh == null) {}
        for (;;)
        {
          this.ROz = ((int)l - (int)f + i);
          AppMethodBeat.o(309281);
          return;
          l = paramh.getCurrentPosInMills();
        }
      }
      i = this.ROz;
      paramh = hre();
      if (paramh != null) {
        break label105;
      }
    }
    for (;;)
    {
      this.ROz = ((int)l + i);
      AppMethodBeat.o(309281);
      return;
      label105:
      l = paramh.getCurrentPosInMills();
    }
  }
  
  public final d hre()
  {
    Object localObject = this.QbM;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Qcl) {
      return (d)localObject;
    }
  }
  
  public final d hrf()
  {
    AppMethodBeat.i(309222);
    if (this.ROw == null)
    {
      localObject = this.QbM;
      if (localObject == null) {
        localObject = null;
      }
      while (localObject == null)
      {
        AppMethodBeat.o(309222);
        return null;
        localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Qcj;
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((aw)localObject).RjN;
        }
      }
      this.ROw = ((d)new com.tencent.mm.plugin.sns.ui.widget.c((SnsAdTimelineVideoView)localObject));
    }
    Object localObject = this.ROw;
    AppMethodBeat.o(309222);
    return localObject;
  }
  
  public final void nP()
  {
    AppMethodBeat.i(309257);
    Log.d("BreakFrameCardAdController", "scope.cancel called");
    if (hrg())
    {
      this.ROz = 0;
      this.ROy = 0;
    }
    for (;;)
    {
      this.QSr = false;
      this.Fey = false;
      this.ROA = false;
      this.ROx = "";
      Object localObject = this.ROp;
      if (localObject != null) {
        ar.a((aq)localObject, null);
      }
      this.ROp = null;
      localObject = this.QbM;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Qcl;
        if (localObject != null) {
          ((SnsAdBreakFrameVideoView)localObject).stop();
        }
      }
      localObject = this.QbM;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Qcj;
        if (localObject != null)
        {
          localObject = ((aw)localObject).RjN;
          if (localObject != null) {
            ((SnsAdTimelineVideoView)localObject).clear();
          }
        }
      }
      localObject = this.QbM;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Qcj;
        if (localObject != null)
        {
          localObject = ((aw)localObject).RjN;
          if (localObject != null) {
            ((SnsAdTimelineVideoView)localObject).hsQ();
          }
        }
      }
      localObject = this.QbM;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject).Qcj;
        if (localObject != null)
        {
          localObject = ((aw)localObject).RjN;
          if (localObject != null) {
            ((SnsAdTimelineVideoView)localObject).setOnReplay(null);
          }
        }
      }
      this.ROr.setValue(b.d.ROK);
      AppMethodBeat.o(309257);
      return;
      localObject = this.PJQ;
      if (localObject == null) {
        localObject = null;
      }
      while (localObject == null)
      {
        AppMethodBeat.o(309257);
        return;
        localObject = ((SnsInfo)localObject).getAdXml();
        if (localObject == null)
        {
          localObject = null;
        }
        else
        {
          localObject = ((ADXml)localObject).adBreakFrameInfo;
          if (localObject == null) {
            localObject = null;
          } else {
            localObject = ((com.tencent.mm.plugin.sns.storage.b)localObject).QIv;
          }
        }
      }
      a((com.tencent.mm.plugin.sns.storage.h)localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayInfo;", "", "command", "Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayCommand;", "sight", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;", "breakSight", "breakFrameLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "(Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayCommand;Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;Landroid/widget/FrameLayout$LayoutParams;)V", "getBreakFrameLayoutParams", "()Landroid/widget/FrameLayout$LayoutParams;", "getBreakSight", "()Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;", "getCommand", "()Lcom/tencent/mm/plugin/sns/ui/item/fullcard/business/breakFrameCard/BreakFrameCardAdController$PlayCommand;", "getSight", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    final b.b ROE;
    final a.c ROF;
    final a.c ROG;
    final FrameLayout.LayoutParams ROH;
    
    public c(b.b paramb, a.c paramc1, a.c paramc2, FrameLayout.LayoutParams paramLayoutParams)
    {
      AppMethodBeat.i(309126);
      this.ROE = paramb;
      this.ROF = paramc1;
      this.ROG = paramc2;
      this.ROH = paramLayoutParams;
      AppMethodBeat.o(309126);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    long Yx;
    long aKQ;
    int aai;
    int asI;
    int label;
    int nuz;
    
    f(b paramb, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309088);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ROP.a(null, 0L, 0L, 0, 0, 0, (kotlin.d.d)this);
      AppMethodBeat.o(309088);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    g(com.tencent.mm.plugin.sns.model.g paramg, dmz paramdmz1, br parambr, SnsInfo paramSnsInfo, dmz paramdmz2, b paramb, w<b.c> paramw, ImageView paramImageView, MMPinProgressBtn paramMMPinProgressBtn, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(309111);
      paramObject = (kotlin.d.d)new g(this.ROQ, paramdmz, parambr, paramSnsInfo, paramSnsAdTimelineVideoView, jdField_this, this.ROT, this.ROU, this.ROV, paramd);
      AppMethodBeat.o(309111);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309104);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309104);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.plugin.sns.ad.timeline.helper.a.PZY;
        paramObject = com.tencent.mm.plugin.sns.ad.timeline.helper.a.a(this.ROQ, paramdmz, parambr);
        Object localObject1 = com.tencent.mm.plugin.sns.ad.timeline.helper.a.PZY;
        localObject1 = com.tencent.mm.plugin.sns.ad.timeline.helper.a.a(paramSnsInfo, this.ROQ, paramdmz, parambr);
        Object localObject2 = com.tencent.mm.plugin.sns.ad.timeline.helper.a.PZY;
        localObject2 = com.tencent.mm.plugin.sns.ad.timeline.helper.a.a(paramSnsInfo, this.ROQ, paramSnsAdTimelineVideoView, parambr);
        kotlinx.coroutines.b.g localg1 = (kotlinx.coroutines.b.g)jdField_this.ROq;
        kotlinx.coroutines.b.g localg2 = (kotlinx.coroutines.b.g)jdField_this.ROr;
        kotlin.g.a.t localt = (kotlin.g.a.t)new b.g.1(null);
        paramObject = kotlinx.coroutines.b.n.a((kotlinx.coroutines.b.g)new v.a(new kotlinx.coroutines.b.g[] { paramObject, localObject1, localObject2, localg1, localg2 }, localt));
        localObject1 = (kotlinx.coroutines.b.h)new a(jdField_this, this.ROT, this.ROU, this.ROV, this.ROQ, paramdmz);
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a((kotlinx.coroutines.b.h)localObject1, (kotlin.d.d)localObject2) == locala)
        {
          AppMethodBeat.o(309104);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(309104);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<b.e>
    {
      public a(b paramb, w paramw, ImageView paramImageView, MMPinProgressBtn paramMMPinProgressBtn, com.tencent.mm.plugin.sns.model.g paramg, dmz paramdmz) {}
      
      public final Object a(b.e parame, kotlin.d.d<? super kotlin.ah> paramd)
      {
        AppMethodBeat.i(309144);
        Object localObject1;
        if ((paramd instanceof 1))
        {
          localObject1 = (1)paramd;
          if ((((1)localObject1).label & 0x80000000) != 0) {
            ((1)localObject1).label += -2147483648;
          }
        }
        for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
            {
              Object L$0;
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(309161);
                this.result = paramAnonymousObject;
                this.label |= 0x80000000;
                paramAnonymousObject = this.RPb.a(null, (kotlin.d.d)this);
                AppMethodBeat.o(309161);
                return paramAnonymousObject;
              }
            })
        {
          localObject2 = paramd.result;
          localObject1 = kotlin.d.a.a.aiwj;
          switch (paramd.label)
          {
          default: 
            parame = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(309144);
            throw parame;
          }
        }
        ResultKt.throwOnFailure(localObject2);
        Object localObject3 = (b.e)parame;
        parame = ((b.e)localObject3).ROM;
        Object localObject2 = ((b.e)localObject3).ROF;
        a.c localc = ((b.e)localObject3).ROG;
        ViewGroup.LayoutParams localLayoutParams = ((b.e)localObject3).RON;
        localObject3 = ((b.e)localObject3).ROO;
        Log.i("BreakFrameCardAdController", "readySnsSightOffline.combine  thumb = " + parame + ", sight = " + localObject2 + ", breakSight = " + localc + ", uiLayoutParams = " + localLayoutParams + " , playState=" + localObject3);
        Object localObject4 = this.ROP.QbM;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject4).Qcj;
          if (localObject4 != null)
          {
            localObject4 = ((aw)localObject4).RjP;
            if (localObject4 != null) {
              ((MMPinProgressBtn)localObject4).setVisibility(8);
            }
          }
        }
        localObject4 = this.ROP.QbM;
        if (localObject4 != null)
        {
          localObject4 = ((com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b)localObject4).Qcj;
          if (localObject4 != null)
          {
            localObject4 = ((aw)localObject4).PQu;
            if (localObject4 != null) {
              ((ImageView)localObject4).setVisibility(8);
            }
          }
        }
        if ((localLayoutParams != null) && (localObject3 != b.d.ROK))
        {
          if ((((a.c)localObject2).Qah != a.a.Qaf) || (localc.Qah != a.a.Qaf)) {
            break label647;
          }
          if (localObject3 != b.d.ROI) {
            break label489;
          }
          localObject3 = this.ROX;
          localObject4 = b.b.ROB;
          if ((localLayoutParams instanceof FrameLayout.LayoutParams)) {}
          for (parame = (FrameLayout.LayoutParams)localLayoutParams;; parame = null)
          {
            localObject2 = new b.c((b.b)localObject4, (a.c)localObject2, localc, parame);
            paramd.L$0 = this;
            paramd.label = 1;
            parame = this;
            if (((w)localObject3).a(localObject2, paramd) != localObject1) {
              break;
            }
            AppMethodBeat.o(309144);
            return localObject1;
          }
          parame = (a)paramd.L$0;
          ResultKt.throwOnFailure(localObject2);
          paramd = parame.ROY;
          if (paramd != null) {
            paramd.setVisibility(8);
          }
          parame = parame.ROZ;
          if (parame != null) {
            parame.setVisibility(8);
          }
        }
        label647:
        label827:
        label987:
        for (;;)
        {
          Log.d("BreakFrameCardAdController", "readySnsSightOffline.combine  end！");
          parame = kotlin.ah.aiuX;
          AppMethodBeat.o(309144);
          return parame;
          label489:
          if (localObject3 == b.d.ROJ)
          {
            localObject3 = this.ROX;
            localObject4 = b.b.ROC;
            if ((localLayoutParams instanceof FrameLayout.LayoutParams)) {}
            for (parame = (FrameLayout.LayoutParams)localLayoutParams;; parame = null)
            {
              localObject2 = new b.c((b.b)localObject4, (a.c)localObject2, localc, parame);
              paramd.L$0 = this;
              paramd.label = 2;
              parame = this;
              if (((w)localObject3).a(localObject2, paramd) != localObject1) {
                break;
              }
              AppMethodBeat.o(309144);
              return localObject1;
            }
            parame = (a)paramd.L$0;
            ResultKt.throwOnFailure(localObject2);
            paramd = parame.ROY;
            if (paramd != null) {
              paramd.setImageDrawable(com.tencent.mm.cd.a.m(parame.ROP.mContext, com.tencent.mm.plugin.sns.b.i.shortvideo_play_btn));
            }
            paramd = parame.ROY;
            if (paramd != null) {
              paramd.setVisibility(0);
            }
            parame = parame.ROZ;
            if (parame != null)
            {
              parame.setVisibility(8);
              continue;
              if ((((a.c)localObject2).Qah == a.a.Qae) || (localc.Qah == a.a.Qae))
              {
                paramd = this.ROP.QbM;
                if (paramd != null)
                {
                  paramd = paramd.Qcj;
                  if (paramd != null)
                  {
                    paramd = paramd.RjN;
                    if (paramd != null)
                    {
                      parame = parame.clY;
                      if (parame != null) {
                        break label827;
                      }
                      parame = null;
                    }
                  }
                }
                for (;;)
                {
                  paramd.setThumbBmp(parame);
                  parame = this.ROP.QbM;
                  if (parame != null)
                  {
                    parame = parame.Qcj;
                    if (parame != null)
                    {
                      parame = parame.RjN;
                      if (parame != null) {
                        parame.hsQ();
                      }
                    }
                  }
                  parame = this.RPa;
                  if (parame != null) {
                    parame.setError(this.Qai.Id);
                  }
                  parame = this.ROY;
                  if (parame != null) {
                    parame.setImageDrawable(com.tencent.mm.cd.a.m(this.ROP.mContext, com.tencent.mm.plugin.sns.b.e.sight_chat_error));
                  }
                  parame = this.ROZ;
                  if (parame != null) {
                    parame.setVisibility(8);
                  }
                  parame = this.ROY;
                  if (parame == null) {
                    break;
                  }
                  parame.setVisibility(0);
                  break;
                  parame = (com.tencent.mm.memory.m)parame.get();
                  if (parame == null) {
                    parame = null;
                  } else {
                    parame = parame.bvR();
                  }
                }
              }
              if (parame.Qah == a.a.Qaf)
              {
                paramd = this.ROP.QbM;
                if (paramd != null)
                {
                  paramd = paramd.Qcj;
                  if (paramd != null)
                  {
                    paramd = paramd.RjN;
                    if (paramd != null)
                    {
                      parame = parame.clY;
                      if (parame != null) {
                        break label987;
                      }
                      parame = null;
                    }
                  }
                }
                for (;;)
                {
                  paramd.setThumbBmp(parame);
                  parame = this.ROP.QbM;
                  if (parame != null)
                  {
                    parame = parame.Qcj;
                    if (parame != null)
                    {
                      parame = parame.RjN;
                      if (parame != null) {
                        parame.hsQ();
                      }
                    }
                  }
                  parame = this.ROZ;
                  if (parame != null) {
                    parame.setVisibility(0);
                  }
                  parame = this.ROZ;
                  if (parame != null) {
                    parame.jEN();
                  }
                  parame = this.ROY;
                  if (parame == null) {
                    break;
                  }
                  parame.setVisibility(8);
                  break;
                  parame = (com.tencent.mm.memory.m)parame.get();
                  if (parame == null) {
                    parame = null;
                  } else {
                    parame = parame.bvR();
                  }
                }
              }
              parame = this.ROZ;
              if (parame != null) {
                parame.setVisibility(0);
              }
              parame = this.ROZ;
              if (parame != null) {
                parame.jEN();
              }
              parame = this.ROY;
              if (parame != null) {
                parame.setVisibility(8);
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    h(b paramb, com.tencent.mm.plugin.sns.storage.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    i(w<b.c> paramw, b paramb, com.tencent.mm.plugin.sns.storage.a parama, AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo, ah.f<cb> paramf, com.tencent.mm.plugin.sns.storage.m paramm, ah.c paramc, float paramFloat1, float paramFloat2, w<Boolean> paramw1, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(309109);
      paramd = new i(this.ROT, jdField_this, paramSnsAdTimelineVideoView, paramdmz, paramSnsInfo, this.RPe, paramg, parambr, f2, f1, this.RPj, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(309109);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309103);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309103);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject = (aq)this.L$0;
        paramObject = kotlinx.coroutines.b.n.a((kotlinx.coroutines.b.g)this.ROT);
        localObject = (kotlinx.coroutines.b.h)new b(jdField_this, paramSnsAdTimelineVideoView, paramdmz, paramSnsInfo, this.RPe, (aq)localObject, paramg, parambr, f2, f1, this.RPj);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a((kotlinx.coroutines.b.h)localObject, locald) == locala)
        {
          AppMethodBeat.o(309103);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(309103);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      a(b paramb, float paramFloat, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(309142);
        paramObject = (kotlin.d.d)new a(this.ROP, this.RPh, paramd);
        AppMethodBeat.o(309142);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(309140);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(309140);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.ROP;
          kotlin.g.a.a locala1 = (kotlin.g.a.a)new kotlin.g.b.u(this.ROP) {};
          long l = this.RPh;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (b.a(paramObject, locala1, l, 0L, 0, locald) == locala)
          {
            AppMethodBeat.o(309140);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = this.ROP.hre();
        if (paramObject != null) {
          paramObject.start();
        }
        paramObject = this.ROP;
        paramObject.ROy += 1;
        this.ROP.ROA = true;
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(309140);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements kotlinx.coroutines.b.h<b.c>
    {
      public b(b paramb, com.tencent.mm.plugin.sns.storage.a parama, AdClickActionInfo paramAdClickActionInfo, SnsInfo paramSnsInfo, ah.f paramf, aq paramaq, com.tencent.mm.plugin.sns.storage.m paramm, ah.c paramc, float paramFloat1, float paramFloat2, w paramw) {}
      
      public final Object a(b.c paramc, kotlin.d.d<? super kotlin.ah> paramd)
      {
        AppMethodBeat.i(309165);
        Object localObject1;
        if ((paramd instanceof 1))
        {
          localObject1 = (1)paramd;
          if ((((1)localObject1).label & 0x80000000) != 0) {
            ((1)localObject1).label += -2147483648;
          }
        }
        Object localObject3;
        kotlin.d.a.a locala;
        for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
            {
              Object L$0;
              Object Uf;
              long Yx;
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(309118);
                this.result = paramAnonymousObject;
                this.label |= 0x80000000;
                paramAnonymousObject = this.RPt.a(null, (kotlin.d.d)this);
                AppMethodBeat.o(309118);
                return paramAnonymousObject;
              }
            })
        {
          localObject3 = paramd.result;
          locala = kotlin.d.a.a.aiwj;
          switch (paramd.label)
          {
          default: 
            paramc = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(309165);
            throw paramc;
          }
        }
        ResultKt.throwOnFailure(localObject3);
        Object localObject2 = (b.c)paramc;
        long l1;
        if (((b.c)localObject2).ROE == b.b.ROB) {
          if (!this.ROP.Fey)
          {
            Log.i("BreakFrameCardAdController", "playCommand is not hasStarted, should prepare!");
            l1 = System.currentTimeMillis();
            paramc = this.ROP.hre();
            if (paramc == null) {
              break label814;
            }
            localObject1 = ((b.c)localObject2).ROG.filePath;
            localObject3 = ((b.c)localObject2).ROH;
            paramd.L$0 = this;
            paramd.Uf = localObject2;
            paramd.Yx = l1;
            paramd.label = 1;
            if (paramc.a((String)localObject1, (FrameLayout.LayoutParams)localObject3, paramd) != locala) {
              break label814;
            }
            AppMethodBeat.o(309165);
            return locala;
            l1 = paramd.Yx;
            localObject2 = (b.c)paramd.Uf;
            paramc = (b)paramd.L$0;
            ResultKt.throwOnFailure(localObject3);
          }
        }
        for (;;)
        {
          localObject3 = paramc.ROP.hrf();
          long l2 = l1;
          localObject1 = paramc;
          if (localObject3 != null)
          {
            localObject2 = ((b.c)localObject2).ROF.filePath;
            paramd.L$0 = paramc;
            paramd.Uf = null;
            paramd.Yx = l1;
            paramd.label = 2;
            l2 = l1;
            localObject1 = paramc;
            if (((d)localObject3).a((String)localObject2, null, paramd) == locala)
            {
              AppMethodBeat.o(309165);
              return locala;
              l2 = paramd.Yx;
              localObject1 = (b)paramd.L$0;
              ResultKt.throwOnFailure(localObject3);
            }
          }
          Log.i("BreakFrameCardAdController", "playCommand prepared!");
          l1 = System.currentTimeMillis() - l2;
          if (l1 > 3000L) {
            Log.e("BreakFrameCardAdController", s.X("prepare cost too much time!  ", kotlin.d.b.a.b.BF(l1)));
          }
          b.a(((b)localObject1).ROP, ((b)localObject1).RPk, ((b)localObject1).RPl, ((b)localObject1).RPm);
          b.i.a(((b)localObject1).RPo, ((b)localObject1).ROP, ((b)localObject1).RPm, ((b)localObject1).RPp);
          paramc = ((b)localObject1).ROP.hrf();
          if (paramc != null) {
            paramc.start();
          }
          ((b)localObject1).ROP.Fey = true;
          paramc = (cb)((b)localObject1).RPn.aqH;
          if (paramc != null) {
            paramc.a(null);
          }
          ((b)localObject1).RPn.aqH = b.i.a(((b)localObject1).cmM, ((b)localObject1).ROP, ((b)localObject1).RPq);
          for (;;)
          {
            paramc = kotlin.ah.aiuX;
            AppMethodBeat.o(309165);
            return paramc;
            if (this.ROP.ROA) {
              if (this.ROP.QSr)
              {
                paramc = (cb)this.RPn.aqH;
                if (paramc != null) {
                  paramc.a(null);
                }
                paramc = this.ROP.hre();
                if (paramc != null) {
                  paramc.resume();
                }
                this.RPn.aqH = b.a(this.cmM, this.ROP, this.RPp, this.RPr, this.RPs);
              }
            }
            for (;;)
            {
              paramc = this.ROP.hrf();
              if (paramc == null) {
                break;
              }
              paramc.resume();
              break;
              paramc = this.ROP.hre();
              if (paramc != null)
              {
                paramc.resume();
                continue;
                paramc = (cb)this.RPn.aqH;
                if (paramc != null) {
                  paramc.a(null);
                }
                this.RPn.aqH = b.i.a(this.cmM, this.ROP, this.RPq);
              }
            }
            if (((b.c)localObject2).ROE == b.b.ROC)
            {
              paramc = (cb)this.RPn.aqH;
              if (paramc != null) {
                paramc.a(null);
              }
              if (!this.ROP.Fey)
              {
                Log.e("BreakFrameCardAdController", "playCommand call pause but not started!!");
              }
              else
              {
                if (this.ROP.ROA)
                {
                  paramc = this.ROP.hre();
                  if (paramc != null) {
                    paramc.pause();
                  }
                }
                paramc = this.ROP.hrf();
                if (paramc != null) {
                  paramc.pause();
                }
              }
            }
          }
          label814:
          paramc = this;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    j(b paramb, ah.c paramc, float paramFloat, w<Boolean> paramw, kotlin.d.d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(309091);
      paramObject = (kotlin.d.d)new j(this.ROP, this.RPg, this.RPi, this.RPj, paramd);
      AppMethodBeat.o(309091);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309084);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309084);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.ROP;
        localObject = (kotlin.g.a.a)new kotlin.g.b.u(this.ROP) {};
        long l1 = this.RPg.aixa;
        long l2 = this.ROP.ROo;
        int i = Math.min((int)(this.RPg.aixa - this.RPi), 2000);
        locald = (kotlin.d.d)this;
        this.label = 1;
        if (b.a(paramObject, (kotlin.g.a.a)localObject, l1, l2, i, locald) == locala)
        {
          AppMethodBeat.o(309084);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.RPj;
        localObject = Boolean.TRUE;
        locald = (kotlin.d.d)this;
        this.label = 2;
        if (paramObject.a(localObject, locald) != locala) {
          break label208;
        }
        AppMethodBeat.o(309084);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label208:
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(309084);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    k(b paramb, float paramFloat, kotlin.d.d<? super k> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(309106);
      paramObject = (kotlin.d.d)new k(this.ROP, f1, paramd);
      AppMethodBeat.o(309106);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309100);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309100);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.g)this.ROP.ROs;
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.ROP, f1);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(309100);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(309100);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Boolean>
    {
      public a(b paramb, float paramFloat) {}
      
      public final Object a(Boolean paramBoolean, kotlin.d.d<? super kotlin.ah> paramd)
      {
        long l = 0L;
        AppMethodBeat.i(309138);
        ((Boolean)paramBoolean).booleanValue();
        int i;
        if (this.ROP.QSr)
        {
          paramBoolean = this.ROP;
          i = paramBoolean.ROz;
          paramd = this.ROP.hre();
          if (paramd == null)
          {
            paramBoolean.ROz = ((int)l - (int)this.RPr + i);
            this.ROP.QSr = false;
            this.ROP.ROA = false;
            this.ROP.Fey = false;
            paramBoolean = this.ROP.hre();
            if (paramBoolean != null) {
              paramBoolean.pause();
            }
            paramBoolean = this.ROP.hre();
            if (paramBoolean != null) {
              break label189;
            }
          }
        }
        for (paramBoolean = null;; paramBoolean = kotlin.ah.aiuX)
        {
          if (paramBoolean != kotlin.d.a.a.aiwj) {
            break label202;
          }
          AppMethodBeat.o(309138);
          return paramBoolean;
          l = paramd.getCurrentPosInMills();
          break;
          paramBoolean = this.ROP;
          i = paramBoolean.ROz;
          paramd = this.ROP.hre();
          if (paramd == null) {}
          for (;;)
          {
            paramBoolean.ROz = ((int)l + i);
            break;
            l = paramd.getCurrentPosInMills();
          }
          label189:
          paramBoolean.stop();
        }
        label202:
        paramBoolean = kotlin.ah.aiuX;
        AppMethodBeat.o(309138);
        return paramBoolean;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    l(b paramb, w<Boolean> paramw, float paramFloat, ah.f<cb> paramf, ah.c paramc, kotlin.d.d<? super l> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(309114);
      paramd = new l(this.ROP, this.RPj, f1, this.RPe, parambr, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(309114);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309108);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309108);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject = (aq)this.L$0;
        paramObject = this.ROP.hre();
        if (paramObject == null) {}
        for (paramObject = null; paramObject == null; paramObject = paramObject.getCompletionFlow())
        {
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(309108);
          return paramObject;
        }
        paramObject = kotlinx.coroutines.b.r.a(new kotlinx.coroutines.b.g[] { (kotlinx.coroutines.b.g)new b(kotlinx.coroutines.b.u.b((kotlinx.coroutines.b.g)paramObject)), (kotlinx.coroutines.b.g)new c((kotlinx.coroutines.b.g)this.RPj) });
        localObject = (kotlinx.coroutines.b.h)new a(this.ROP, f1, this.RPe, (aq)localObject, parambr, this.RPj);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a((kotlinx.coroutines.b.h)localObject, locald) == locala)
        {
          AppMethodBeat.o(309108);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(309108);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Integer>
    {
      public a(b paramb, float paramFloat, ah.f paramf, aq paramaq, ah.c paramc, w paramw) {}
      
      public final Object a(Integer paramInteger, kotlin.d.d<? super kotlin.ah> paramd)
      {
        AppMethodBeat.i(309171);
        Object localObject1;
        if ((paramd instanceof 1))
        {
          localObject1 = (1)paramd;
          if ((((1)localObject1).label & 0x80000000) != 0) {
            ((1)localObject1).label += -2147483648;
          }
        }
        Object localObject2;
        for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
            {
              Object L$0;
              long Yx;
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(309107);
                this.result = paramAnonymousObject;
                this.label |= 0x80000000;
                paramAnonymousObject = this.RPu.a(null, (kotlin.d.d)this);
                AppMethodBeat.o(309107);
                return paramAnonymousObject;
              }
            })
        {
          localObject2 = paramd.result;
          localObject1 = kotlin.d.a.a.aiwj;
          switch (paramd.label)
          {
          default: 
            paramInteger = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(309171);
            throw paramInteger;
          }
        }
        ResultKt.throwOnFailure(localObject2);
        int i = ((Number)paramInteger).intValue();
        Log.i("BreakFrameCardAdController", s.X("seekJobFlow called it = ", Integer.valueOf(i)));
        if ((this.ROP.QSr) && (i == 0)) {
          Log.i("BreakFrameCardAdController", "seekJobFlow called but returned");
        }
        for (;;)
        {
          paramInteger = kotlin.ah.aiuX;
          AppMethodBeat.o(309171);
          return paramInteger;
          Log.d("BreakFrameCardAdController", "endBreakVideoJob called restart to begin");
          paramInteger = this.ROP.hre();
          if (paramInteger == null)
          {
            l1 = 0L;
            if (this.ROP.QSr) {
              break label320;
            }
            paramInteger = this.ROP;
            i = paramInteger.ROz;
          }
          for (paramInteger.ROz = ((int)l1 + i);; paramInteger.ROz = ((int)l1 - (int)this.RPr + i))
          {
            this.ROP.QSr = true;
            long l2 = System.currentTimeMillis();
            localObject2 = this.ROP.hre();
            l1 = l2;
            paramInteger = this;
            if (localObject2 == null) {
              break label367;
            }
            long l3 = this.RPr;
            paramd.L$0 = this;
            paramd.Yx = l2;
            paramd.label = 1;
            l1 = l2;
            paramInteger = this;
            if (((d)localObject2).d(l3, paramd) != localObject1) {
              break label367;
            }
            AppMethodBeat.o(309171);
            return localObject1;
            l1 = paramInteger.getCurrentPosInMills();
            break;
            label320:
            paramInteger = this.ROP;
            i = paramInteger.ROz;
          }
          long l1 = paramd.Yx;
          paramInteger = (a)paramd.L$0;
          ResultKt.throwOnFailure(localObject2);
          label367:
          Log.d("BreakFrameCardAdController", s.X("seek cost ", kotlin.d.b.a.b.BF(System.currentTimeMillis() - l1)));
          paramd = (cb)paramInteger.RPn.aqH;
          if (paramd != null) {
            paramd.a(null);
          }
          paramd = paramInteger.ROP;
          paramd.ROy += 1;
          paramInteger.RPn.aqH = b.a(paramInteger.cmM, paramInteger.ROP, paramInteger.RPp, paramInteger.RPr, paramInteger.RPs);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements kotlinx.coroutines.b.g<Integer>
    {
      public b(kotlinx.coroutines.b.g paramg) {}
      
      public final Object a(kotlinx.coroutines.b.h paramh, kotlin.d.d paramd)
      {
        AppMethodBeat.i(309168);
        paramh = this.bLp.a((kotlinx.coroutines.b.h)new kotlinx.coroutines.b.h()
        {
          public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
          {
            AppMethodBeat.i(309143);
            Object localObject1;
            if ((paramAnonymousd instanceof 1))
            {
              localObject1 = (1)paramAnonymousd;
              if ((((1)localObject1).label & 0x80000000) != 0) {
                ((1)localObject1).label += -2147483648;
              }
            }
            for (paramAnonymousd = (kotlin.d.d)localObject1;; paramAnonymousd = new kotlin.d.b.a.d(paramAnonymousd)
                {
                  int label;
                  
                  public final Object invokeSuspend(Object paramAnonymous2Object)
                  {
                    AppMethodBeat.i(309139);
                    this.result = paramAnonymous2Object;
                    this.label |= 0x80000000;
                    paramAnonymous2Object = this.RPv.a(null, (kotlin.d.d)this);
                    AppMethodBeat.o(309139);
                    return paramAnonymous2Object;
                  }
                })
            {
              localObject2 = paramAnonymousd.result;
              localObject1 = kotlin.d.a.a.aiwj;
              switch (paramAnonymousd.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(309143);
                throw paramAnonymousObject;
              }
            }
            ResultKt.throwOnFailure(localObject2);
            Object localObject2 = this.bLr;
            ((Boolean)paramAnonymousObject).booleanValue();
            paramAnonymousd.label = 1;
            if (((kotlinx.coroutines.b.h)localObject2).a(Integer.valueOf(0), paramAnonymousd) == localObject1)
            {
              AppMethodBeat.o(309143);
              return localObject1;
              ResultKt.throwOnFailure(localObject2);
            }
            paramAnonymousObject = kotlin.ah.aiuX;
            AppMethodBeat.o(309143);
            return paramAnonymousObject;
          }
        }, paramd);
        if (paramh == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(309168);
          return paramh;
        }
        paramh = kotlin.ah.aiuX;
        AppMethodBeat.o(309168);
        return paramh;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements kotlinx.coroutines.b.g<Integer>
    {
      public c(kotlinx.coroutines.b.g paramg) {}
      
      public final Object a(kotlinx.coroutines.b.h paramh, kotlin.d.d paramd)
      {
        AppMethodBeat.i(309167);
        paramh = this.bLp.a((kotlinx.coroutines.b.h)new kotlinx.coroutines.b.h()
        {
          public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
          {
            AppMethodBeat.i(309182);
            Object localObject1;
            if ((paramAnonymousd instanceof 1))
            {
              localObject1 = (1)paramAnonymousd;
              if ((((1)localObject1).label & 0x80000000) != 0) {
                ((1)localObject1).label += -2147483648;
              }
            }
            for (paramAnonymousd = (kotlin.d.d)localObject1;; paramAnonymousd = new kotlin.d.b.a.d(paramAnonymousd)
                {
                  int label;
                  
                  public final Object invokeSuspend(Object paramAnonymous2Object)
                  {
                    AppMethodBeat.i(309163);
                    this.result = paramAnonymous2Object;
                    this.label |= 0x80000000;
                    paramAnonymous2Object = this.RPw.a(null, (kotlin.d.d)this);
                    AppMethodBeat.o(309163);
                    return paramAnonymous2Object;
                  }
                })
            {
              localObject2 = paramAnonymousd.result;
              localObject1 = kotlin.d.a.a.aiwj;
              switch (paramAnonymousd.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(309182);
                throw paramAnonymousObject;
              }
            }
            ResultKt.throwOnFailure(localObject2);
            Object localObject2 = this.bLr;
            ((Boolean)paramAnonymousObject).booleanValue();
            paramAnonymousd.label = 1;
            if (((kotlinx.coroutines.b.h)localObject2).a(Integer.valueOf(1), paramAnonymousd) == localObject1)
            {
              AppMethodBeat.o(309182);
              return localObject1;
              ResultKt.throwOnFailure(localObject2);
            }
            paramAnonymousObject = kotlin.ah.aiuX;
            AppMethodBeat.o(309182);
            return paramAnonymousObject;
          }
        }, paramd);
        if (paramh == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(309167);
          return paramh;
        }
        paramh = kotlin.ah.aiuX;
        AppMethodBeat.o(309167);
        return paramh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */