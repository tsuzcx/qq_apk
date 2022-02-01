package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.j.a;
import com.tencent.mm.plugin.textstatus.a.l.a;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.a.x;
import com.tencent.mm.plugin.textstatus.f.e.a;
import com.tencent.mm.plugin.textstatus.h.o.f;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.an;
import com.tencent.mm.plugin.textstatus.proto.t;
import com.tencent.mm.plugin.textstatus.third.i;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bf;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.n.d;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/StatusCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusInfoUpdate;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "attachStateListener", "Landroid/view/View$OnAttachStateChangeListener;", "getAttachStateListener", "()Landroid/view/View$OnAttachStateChangeListener;", "btnClose", "Landroid/view/View;", "getBtnClose", "()Landroid/view/View;", "setBtnClose", "(Landroid/view/View;)V", "btnJoin", "Landroid/widget/ImageView;", "getBtnJoin", "()Landroid/widget/ImageView;", "setBtnJoin", "(Landroid/widget/ImageView;)V", "btnLike", "getBtnLike", "setBtnLike", "cardView", "checkValidListener", "Lcom/tencent/mm/ui/widget/IPullDownView$CheckValidListener;", "clickListener", "defaultDimensionRatio", "", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "exposeTime", "", "getExposeTime", "()J", "setExposeTime", "(J)V", "hasDetached", "", "getHasDetached", "()Z", "setHasDetached", "(Z)V", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivBigIcon", "getIvBigIcon", "setIvBigIcon", "ivMask", "getIvMask", "setIvMask", "lastExposedSessionId", "lastSetThirdTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getLastSetThirdTopicInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "setLastSetThirdTopicInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)V", "lastStatusId", "layoutBottom", "getLayoutBottom", "setLayoutBottom", "layoutBrandAndPoi", "Landroid/widget/LinearLayout;", "getLayoutBrandAndPoi", "()Landroid/widget/LinearLayout;", "setLayoutBrandAndPoi", "(Landroid/widget/LinearLayout;)V", "layoutCardContent", "getLayoutCardContent", "setLayoutCardContent", "layoutDesContent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutDesContent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setLayoutDesContent", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "layoutFillWindow", "Landroid/view/ViewGroup;", "getLayoutFillWindow", "()Landroid/view/ViewGroup;", "setLayoutFillWindow", "(Landroid/view/ViewGroup;)V", "layoutLuckyMoney", "getLayoutLuckyMoney", "setLayoutLuckyMoney", "layoutThirdContainer", "Landroid/widget/FrameLayout;", "getLayoutThirdContainer", "()Landroid/widget/FrameLayout;", "setLayoutThirdContainer", "(Landroid/widget/FrameLayout;)V", "layoutThirdThumb", "getLayoutThirdThumb", "setLayoutThirdThumb", "layoutVideo", "getLayoutVideo", "setLayoutVideo", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "rootView", "getRootView", "setRootView", "screenHeight", "getScreenHeight", "()F", "screenHeight$delegate", "Lkotlin/Lazy;", "screenWidth", "getScreenWidth", "screenWidth$delegate", "sessionId", "statusBarHeight", "getStatusBarHeight", "statusBarHeight$delegate", "statusCardEventListener", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;", "getStatusCardEventListener", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;", "statusId", "getStatusId", "setStatusId", "(Ljava/lang/String;)V", "thirdBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "getThirdBack", "()Lcom/tencent/mm/ui/widget/IPullDownView;", "setThirdBack", "(Lcom/tencent/mm/ui/widget/IPullDownView;)V", "tvDesc", "Landroid/widget/TextView;", "getTvDesc", "()Landroid/widget/TextView;", "setTvDesc", "(Landroid/widget/TextView;)V", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvPoi", "getTvPoi", "setTvPoi", "tvRef", "getTvRef", "setTvRef", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "username", "getUsername", "setUsername", "vBack", "getVBack", "setVBack", "vScrollTips", "getVScrollTips", "setVScrollTips", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;)V", "cardClick", "", "checkCurThirdBackValid", "topicInfo", "checkIsThirdBackValid", "destroyCustomPartsManual", "destroyThirdBackManual", "destroyVideo", "fixLayout", "getCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "sourceId", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getView", "goProfile", "handleThirdBack", "handleThirdThumb", "handleVideo", "initData", "isMute", "isNeedStopMusic", "onBackPressed", "onClick", "v", "onPullDownProgress", "persent", "curTranslation", "unfoldTranslation", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "pauseThirdPreview", "pauseVideo", "playThirdPreview", "playVideo", "reportExit", "cardLeaveMethod", "reportExpose", "reportFirstOrLastOverScroll", "isLast", "setEventListener", "l", "setItemClickListener", "showScrollTips", "show", "update", "extraParam", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "updateLikeNum", "updateMask", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements View.OnClickListener, com.tencent.mm.am.h, com.tencent.mm.plugin.textstatus.a.j, com.tencent.mm.plugin.textstatus.a.l
{
  private final kotlin.j AJO;
  public final View Aoy;
  private final kotlin.j BqT;
  private MMTPEffectVideoLayout Goz;
  private long HsA;
  final String TAG;
  private ImageView TlA;
  private ImageView TlB;
  private View TlC;
  private TextView TlD;
  private ViewGroup TlJ;
  private ImageView TlL;
  private ImageView TlN;
  private TextView TlP;
  private final x Tlv;
  private TextView Tlw;
  private TextView Tlx;
  private String Tly;
  private TextView Tlz;
  private com.tencent.mm.plugin.textstatus.h.f.b Tmb;
  private ViewGroup Tme;
  private final e.a Tmm;
  private TextStatusTopicInfo TvA;
  private ImageView TvR;
  private FrameLayout Tvm;
  private FrameLayout Tvo;
  private FrameLayout Tvs;
  com.tencent.mm.ui.widget.b Tvz;
  private final kotlin.j TwK;
  private final float TwL;
  private ConstraintLayout TwM;
  private View TwN;
  private View TwO;
  private com.tencent.mm.plugin.textstatus.f.e TwP;
  private View TwQ;
  private View TwR;
  private LinearLayout TwS;
  boolean TwT;
  private final View.OnAttachStateChangeListener TwU;
  private String Two;
  private String Twp;
  private j.a Twr;
  private TextView Twz;
  View.OnClickListener fhU;
  Context mContext;
  private w psR;
  private ViewGroup pzj;
  private String sessionId;
  public String username;
  
  public h(Context paramContext, x paramx)
  {
    AppMethodBeat.i(291298);
    this.Tlv = paramx;
    this.TAG = kotlin.g.b.s.X("MicroMsg.TextStatus.StatusCardView@", Integer.valueOf(hashCode()));
    this.TwK = kotlin.k.cm((kotlin.g.a.a)h.b.TwW);
    this.AJO = kotlin.k.cm((kotlin.g.a.a)h.c.TwX);
    this.BqT = kotlin.k.cm((kotlin.g.a.a)new h.d(this));
    this.TwL = 1.777778F;
    paramx = LayoutInflater.from(paramContext).inflate(a.f.Tff, null, false);
    kotlin.g.b.s.s(paramx, "from(context).inflate(R.…card_new_ui, null, false)");
    this.Aoy = paramx;
    this.mContext = paramContext;
    this.Tly = "";
    this.TwU = ((View.OnAttachStateChangeListener)new h.a(this));
    paramx = com.tencent.mm.plugin.textstatus.f.f.Tmq;
    this.TwP = com.tencent.mm.plugin.textstatus.f.f.a(this.Tlv);
    this.TwP.g(this.Aoy);
    this.TwP.bO((kotlin.g.a.a)new h.1(this));
    this.Tlw = ((TextView)this.Aoy.findViewById(a.e.TeC));
    this.Tlz = ((TextView)this.Aoy.findViewById(a.e.Tey));
    paramx = this.Tlz;
    if (paramx != null) {
      paramx.setTextSize(0, com.tencent.mm.cd.a.bs(paramContext, a.c.DescTextSize));
    }
    this.Tlx = ((TextView)this.Aoy.findViewById(a.e.gaN));
    this.TwM = ((ConstraintLayout)this.Aoy.findViewById(a.e.Tdd));
    this.TlD = ((TextView)this.Aoy.findViewById(a.e.Tew));
    this.TvR = ((ImageView)this.Aoy.findViewById(a.e.Tca));
    paramContext = this.Aoy.findViewById(a.e.Tcb);
    kotlin.g.b.s.s(paramContext, "cardView.findViewById(R.id.btn_like)");
    this.TlL = ((ImageView)paramContext);
    this.TlN = ((ImageView)this.Aoy.findViewById(a.e.Tcu));
    paramContext = this.Aoy.findViewById(a.e.Tep);
    kotlin.g.b.s.s(paramContext, "cardView.findViewById(R.id.tv_like_num)");
    this.TlP = ((TextView)paramContext);
    this.Tme = ((ViewGroup)this.Aoy.findViewById(a.e.Tdk));
    this.Tme = ((ViewGroup)this.Aoy.findViewById(a.e.Tdk));
    this.Twz = ((TextView)this.Aoy.findViewById(a.e.Tex));
    paramContext = this.Twz;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    this.TlJ = ((ViewGroup)this.Aoy.findViewById(a.e.Tdh));
    this.TlB = ((ImageView)this.Aoy.findViewById(a.e.TcA));
    this.TlA = ((ImageView)this.Aoy.findViewById(a.e.TeJ));
    this.TwR = this.Aoy.findViewById(a.e.TcH);
    this.Tvm = ((FrameLayout)this.Aoy.findViewById(a.e.TdB));
    this.TlC = this.Aoy.findViewById(a.e.Tdb);
    this.TwN = this.Aoy.findViewById(a.e.TcY);
    this.Tvs = ((FrameLayout)this.Aoy.findViewById(a.e.Tdx));
    this.Tvo = ((FrameLayout)this.Aoy.findViewById(a.e.Tdw));
    this.TwQ = this.Aoy.findViewById(a.e.btn_close);
    this.TwO = this.Aoy.findViewById(a.e.TeU);
    this.pzj = ((ViewGroup)this.Aoy.findViewById(a.e.TdX));
    if (this.Tlv.aom(128))
    {
      i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12.0F);
      paramContext = com.tencent.mm.plugin.textstatus.util.l.TBz;
      com.tencent.mm.plugin.textstatus.util.l.C(this.Aoy, i);
    }
    paramContext = this.TwQ;
    if (paramContext != null) {
      if (!this.Tlv.aom(512)) {
        break label786;
      }
    }
    label786:
    for (int i = 0;; i = 8)
    {
      paramContext.setVisibility(i);
      paramContext = this.TwQ;
      if (paramContext != null) {
        paramContext.setOnClickListener(new h..ExternalSyntheticLambda1(this));
      }
      this.Aoy.addOnAttachStateChangeListener(this.TwU);
      this.sessionId = "";
      this.Two = "";
      this.Twp = "";
      this.Tmm = ((e.a)new e(this));
      AppMethodBeat.o(291298);
      return;
    }
  }
  
  private com.tencent.mm.ui.widget.b N(String paramString, List<? extends TextStatusJumpInfo> paramList)
  {
    AppMethodBeat.i(291341);
    kotlin.g.b.s.u(paramString, "sourceId");
    com.tencent.mm.plugin.textstatus.proto.l locall = new com.tencent.mm.plugin.textstatus.proto.l();
    locall.nDl = 0;
    locall.ToO = 2;
    Object localObject = this.Tmb;
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label97;
      }
      i = cn.getSyncServerTimeSecond();
      label57:
      locall.ToQ = i;
    }
    for (;;)
    {
      try
      {
        localFrameLayout = this.Tvo;
        if (localFrameLayout != null) {
          continue;
        }
        paramString = null;
      }
      finally
      {
        FrameLayout localFrameLayout;
        label97:
        paramString = null;
        continue;
      }
      AppMethodBeat.o(291341);
      return paramString;
      localObject = Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_CreateTime);
      break;
      i = ((Integer)localObject).intValue();
      break label57;
      if (paramList == null)
      {
        paramList = null;
        localObject = i.TuX;
        if (paramList == null)
        {
          localObject = null;
          localObject = i.bec((String)localObject);
          if (localObject != null) {
            continue;
          }
          paramString = null;
        }
      }
      else
      {
        paramList = com.tencent.mm.plugin.textstatus.third.j.lu(paramList);
        continue;
      }
      localObject = paramList.jumpType;
      continue;
      paramString = ((o)localObject).a(paramString, localFrameLayout, paramList, locall);
    }
  }
  
  private static final void a(com.tencent.mm.plugin.textstatus.h.f.b paramb, h paramh, View paramView)
  {
    AppMethodBeat.i(291411);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    if (paramb == null) {}
    for (paramb = null;; paramb = com.tencent.mm.plugin.textstatus.h.f.b.b(paramb))
    {
      if (paramb != null)
      {
        paramView = com.tencent.mm.plugin.textstatus.e.a.Tlb;
        paramView = paramh.mContext;
        paramh = paramh.hHx();
        paramb = paramb.jumpInfos;
        kotlin.g.b.s.s(paramb, "topicInfo.jumpInfos");
        paramb = (List)paramb;
        kotlin.g.b.s.u(paramView, "context");
        kotlin.g.b.s.u(paramb, "jumpInfos");
        boolean bool = false;
        if (paramh != null) {
          bool = paramh.km(paramView);
        }
        com.tencent.mm.plugin.textstatus.e.a.Q(paramView, bool);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291411);
      return;
    }
  }
  
  private static final void a(h paramh, View paramView)
  {
    AppMethodBeat.i(291402);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramh, "this$0");
    paramh = paramh.Twr;
    if (paramh != null) {
      paramh.aok(1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291402);
  }
  
  private void atK()
  {
    Object localObject1 = null;
    AppMethodBeat.i(291375);
    String str = this.TAG;
    Object localObject2 = this.Goz;
    if (localObject2 == null) {}
    for (;;)
    {
      Log.d(str, kotlin.g.b.s.X("playVideo() called textureView:", localObject1));
      if (this.TwT)
      {
        this.TwT = false;
        localObject1 = this.Goz;
        if (localObject1 != null)
        {
          localObject1 = ((MMTPEffectVideoLayout)localObject1).getPlayer();
          if (localObject1 != null) {
            com.tencent.mm.plugin.thumbplayer.e.b.a((com.tencent.mm.plugin.thumbplayer.e.b)localObject1, 0, false, 6);
          }
        }
      }
      localObject1 = this.Goz;
      if (localObject1 != null)
      {
        localObject1 = ((MMTPEffectVideoLayout)localObject1).getPlayer();
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).hLh();
        }
      }
      AppMethodBeat.o(291375);
      return;
      localObject2 = ((MMTPEffectVideoLayout)localObject2).getPlayer();
      if (localObject2 != null) {
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).hashCode());
      }
    }
  }
  
  private final float getStatusBarHeight()
  {
    AppMethodBeat.i(291331);
    float f = ((Number)this.BqT.getValue()).floatValue();
    AppMethodBeat.o(291331);
    return f;
  }
  
  private com.tencent.mm.plugin.textstatus.a.k hHx()
  {
    AppMethodBeat.i(291353);
    com.tencent.mm.plugin.textstatus.a.k localk = this.TwP.hHx();
    AppMethodBeat.o(291353);
    return localk;
  }
  
  private final float hIA()
  {
    AppMethodBeat.i(291323);
    float f = ((Number)this.AJO.getValue()).floatValue();
    AppMethodBeat.o(291323);
    return f;
  }
  
  private void hIB()
  {
    AppMethodBeat.i(291363);
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.etL();
    }
    localb = this.Tvz;
    if (localb != null) {
      localb.etO();
    }
    AppMethodBeat.o(291363);
  }
  
  private void hIC()
  {
    AppMethodBeat.i(291368);
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.etM();
    }
    localb = this.Tvz;
    if (localb != null) {
      localb.onPostClose();
    }
    AppMethodBeat.o(291368);
  }
  
  private void hIi()
  {
    AppMethodBeat.i(291384);
    Object localObject = this.Tvm;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = this.Tvm;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stopAsync();
      }
    }
    localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
    }
    localObject = this.Goz;
    if (localObject != null) {
      ((MMTPEffectVideoLayout)localObject).TGP.HkF.release();
    }
    AppMethodBeat.o(291384);
  }
  
  private final void hIj()
  {
    AppMethodBeat.i(291344);
    hIC();
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.onDestroy();
    }
    this.Tvz = null;
    this.TvA = null;
    AppMethodBeat.o(291344);
  }
  
  private final void hIv()
  {
    AppMethodBeat.i(291399);
    if (this.Tlv.scene == 6)
    {
      Object localObject1 = this.Aoy.getTag(a.e.TdW);
      if ((localObject1 instanceof an))
      {
        localObject1 = (an)localObject1;
        if (localObject1 != null)
        {
          Object localObject2 = TextStatusDetailActivity.Txi;
          localObject2 = this.mContext;
          kotlin.g.b.s.u(localObject2, "context");
          kotlin.g.b.s.u(localObject1, "history");
          Intent localIntent = new Intent((Context)localObject2, TextStatusDetailActivity.class);
          localIntent.putExtra("history_item", ((an)localObject1).toByteArray());
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusDetailActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/textstatus/ui/TextStatusDetailActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        localObject1 = this.Aoy.getTag(a.e.tag_key_position);
        if (!(localObject1 instanceof Integer)) {
          break label233;
        }
        localObject1 = (Integer)localObject1;
        label190:
        if (localObject1 != null) {
          break label238;
        }
      }
      label233:
      label238:
      for (int i = 0;; i = ((Integer)localObject1).intValue())
      {
        localObject1 = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.a(this.mContext, 27L, null, this.Tmb, 0L, 0L, i, 52);
        AppMethodBeat.o(291399);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label190;
      }
    }
    AppMethodBeat.o(291399);
  }
  
  private final float hIz()
  {
    AppMethodBeat.i(291316);
    float f = ((Number)this.TwK.getValue()).floatValue();
    AppMethodBeat.o(291316);
    return f;
  }
  
  public final void Ds(String paramString)
  {
    AppMethodBeat.i(291527);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291527);
      return;
    }
    new o.f(paramString, (com.tencent.mm.plugin.textstatus.a.p)this);
    localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    localObject = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString);
    l.a.a((com.tencent.mm.plugin.textstatus.a.l)this, paramString, (com.tencent.mm.plugin.textstatus.h.f.b)localObject);
    AppMethodBeat.o(291527);
  }
  
  public final void Ft(boolean paramBoolean)
  {
    AppMethodBeat.i(291510);
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.TwO;
      if (localObject != null)
      {
        localObject = ((View)localObject).getLayoutParams();
        if (localObject != null)
        {
          ((ViewGroup.LayoutParams)localObject).height = -2;
          AppMethodBeat.o(291510);
        }
      }
    }
    else
    {
      localObject = this.TwO;
      if (localObject != null)
      {
        localObject = ((View)localObject).getLayoutParams();
        if (localObject != null)
        {
          ((ViewGroup.LayoutParams)localObject).height = 0;
          View localView = this.TwO;
          if (localView != null) {
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
      }
    }
    AppMethodBeat.o(291510);
  }
  
  public final void Fu(boolean paramBoolean)
  {
    AppMethodBeat.i(291502);
    if (paramBoolean)
    {
      localb = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(this.mContext, 72L, null, this.Tmb, 0L, 0L, 0L, 116);
      AppMethodBeat.o(291502);
      return;
    }
    com.tencent.mm.plugin.textstatus.i.b localb = com.tencent.mm.plugin.textstatus.i.b.Trt;
    com.tencent.mm.plugin.textstatus.i.b.a(this.mContext, 71L, null, this.Tmb, 0L, 0L, 0L, 116);
    AppMethodBeat.o(291502);
  }
  
  public final void a(j.a parama)
  {
    this.Twr = parama;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.textstatus.h.f.b paramb, t paramt)
  {
    AppMethodBeat.i(291476);
    kotlin.g.b.s.u(paramString, "username");
    this.Tmb = paramb;
    this.username = paramString;
    Object localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    Object localObject3 = (com.tencent.mm.plugin.textstatus.proto.p)a.a.a(this.mContext, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.textstatus.proto.p)localObject3).sessionId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.sessionId = ((String)localObject1);
      ((com.tencent.mm.plugin.textstatus.proto.p)localObject3).username = paramString;
      ((com.tencent.mm.plugin.textstatus.proto.p)localObject3).Tpg = this.Tlv.scene;
    }
    if (this.Tlv.scene == 3)
    {
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGH().bdW(paramString);
    }
    if (!this.TwP.b(paramString, paramb, paramt))
    {
      this.Aoy.setVisibility(8);
      AppMethodBeat.o(291476);
      return;
    }
    this.Aoy.setVisibility(0);
    label192:
    label238:
    label250:
    int j;
    if (this.Tlv.aom(32))
    {
      paramString = this.TwN;
      if (paramString == null)
      {
        paramString = null;
        if (!(paramString instanceof RelativeLayout.LayoutParams)) {
          break label1066;
        }
        paramString = (RelativeLayout.LayoutParams)paramString;
        if (paramString != null)
        {
          paramString.removeRule(12);
          paramString.addRule(2, a.e.TeU);
          paramt = this.TwN;
          if (paramt != null) {
            paramt.setLayoutParams((ViewGroup.LayoutParams)paramString);
          }
        }
        paramString = this.TlC;
        if (paramString != null) {
          break label1071;
        }
        paramString = null;
        if (!(paramString instanceof ConstraintLayout.LayoutParams)) {
          break label1079;
        }
        paramString = (ConstraintLayout.LayoutParams)paramString;
        if (paramString != null)
        {
          paramString.height = -1;
          paramt = this.TlC;
          if (paramt != null) {
            paramt.setLayoutParams((ViewGroup.LayoutParams)paramString);
          }
        }
        paramString = this.TlC;
        if (paramString != null)
        {
          i = com.tencent.mm.cd.a.br(this.mContext, a.c.Edge_3A);
          j = bf.getStatusBarHeight(this.mContext);
          paramt = this.TwO;
          if (paramt != null) {
            paramt.setVisibility(0);
          }
          paramString.setPadding(paramString.getPaddingLeft(), i + j, paramString.getPaddingRight(), paramString.getPaddingBottom());
        }
      }
    }
    for (;;)
    {
      try
      {
        str = this.username;
        if (str != null)
        {
          localObject2 = this.Tmb;
          if (localObject2 != null)
          {
            if ((((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaType != 2) || (!this.Tlv.aom(16))) {
              continue;
            }
            Log.i(this.TAG, "playVideo called");
            paramString = this.Tvm;
            if (paramString != null) {
              paramString.removeAllViews();
            }
            if (this.Goz == null) {
              this.Goz = new MMTPEffectVideoLayout(this.mContext, (byte)0);
            }
            localObject3 = this.Goz;
            if (localObject3 != null)
            {
              paramString = new FrameLayout.LayoutParams(-1, -1);
              paramString.gravity = 17;
              paramt = this.Tvm;
              if (paramt != null) {
                paramt.addView((View)localObject3, (ViewGroup.LayoutParams)paramString);
              }
              paramString = this.Tvm;
              if (paramString != null) {
                paramString.setVisibility(0);
              }
              if (((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaUrl != null) {
                continue;
              }
              paramString = "";
              if (((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaUrl != null) {
                continue;
              }
              paramt = "";
              localObject1 = com.tencent.mm.plugin.textstatus.util.e.TAU;
              localObject1 = com.tencent.mm.plugin.textstatus.util.e.bek(str);
              bool = y.ZC((String)localObject1);
              if (!bool) {
                continue;
              }
              j = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_mediaWidth;
              k = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_mediaHeight;
              if (j > 0)
              {
                i = k;
                if (k > 0) {}
              }
              else
              {
                j = ao.mX(this.mContext).width;
                i = ao.mX(this.mContext).height;
              }
              paramString = new com.tencent.mm.plugin.thumbplayer.a.b(paramString, (String)localObject1, paramt, j, i);
              paramString.hJv = bool;
              if (bool)
              {
                paramt = MultiMediaVideoChecker.ObB.cI((String)localObject1, true);
                if (paramt != null) {
                  continue;
                }
                l = 0L;
                paramString.vYw = l;
                if (paramt != null) {
                  continue;
                }
                i = 0;
                paramString.hYK = i;
              }
              ((MMTPEffectVideoLayout)localObject3).fva();
              ((MMTPEffectVideoLayout)localObject3).setMediaInfo(paramString);
              paramString = ((MMTPEffectVideoLayout)localObject3).getPlayer();
              if (paramString != null) {
                paramString.Flr = true;
              }
              paramString = ((MMTPEffectVideoLayout)localObject3).getPlayer();
              if (paramString != null)
              {
                if ((this.Tlv.aom(64)) && (com.tencent.mm.n.a.aTj())) {
                  continue;
                }
                if (!com.tencent.mm.n.a.s(this.mContext, false)) {
                  continue;
                }
                continue;
                paramString.setMute(bool);
              }
              paramString = ((MMTPEffectVideoLayout)localObject3).getPlayer();
              if (paramString != null) {
                paramString.setLoop(true);
              }
              ((MMTPEffectVideoLayout)localObject3).getEffectManager().jQl();
              ((MMTPEffectVideoLayout)localObject3).getEffectManager().jQk();
              if (!((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).hHI()) {
                continue;
              }
              paramString = ((MMTPEffectVideoLayout)localObject3).getEffectManager().jQj();
              paramString.setRadius(5.0F);
              paramString.eC(1.0F);
              this.Goz = ((MMTPEffectVideoLayout)localObject3);
              if (this.Tlv.aom(8192)) {
                atK();
              }
            }
          }
        }
      }
      finally
      {
        String str;
        boolean bool;
        int k;
        long l;
        label1066:
        label1071:
        label1079:
        float f;
        continue;
        i = 1;
        continue;
        i = 0;
        continue;
        if (i != 0) {
          continue;
        }
        i = 0;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
      }
      paramString = this.Tmb;
      if (paramString == null)
      {
        paramString = null;
        paramString = (CharSequence)paramString;
        if ((paramString != null) && (!n.bp(paramString))) {
          continue;
        }
        i = 1;
        if (i == 0)
        {
          paramString = this.Tmb;
          if ((paramString == null) || (paramString.hHI() != true)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
        }
        paramString = this.TwR;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.TlN;
        if ((paramString == null) || (paramString.getVisibility() != 0)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString = this.TwS;
        if (paramString != null) {
          continue;
        }
        paramString = null;
        if ((paramString instanceof LinearLayout.LayoutParams)) {
          ((LinearLayout.LayoutParams)paramString).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12);
        }
        this.Aoy.setOnClickListener((View.OnClickListener)this);
        paramString = this.TlJ;
        if (paramString != null) {
          paramString.setOnClickListener(new h..ExternalSyntheticLambda0(paramb, this));
        }
        paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramt = (com.tencent.mm.plugin.textstatus.proto.p)a.a.a(this.mContext, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
        if (paramt == null) {
          continue;
        }
        if (!TextUtils.equals((CharSequence)paramt.sessionId, (CharSequence)this.Two)) {
          continue;
        }
        localObject1 = (CharSequence)this.Twp;
        if (paramb != null) {
          continue;
        }
        paramString = null;
        if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)paramString)) {
          continue;
        }
        AppMethodBeat.o(291476);
        return;
        paramString = paramString.getLayoutParams();
        break;
        paramString = null;
        break label192;
        paramString = paramString.getLayoutParams();
        break label238;
        paramString = null;
        break label250;
        if (this.Tlv.aom(2048))
        {
          paramString = this.TlC;
          if (paramString == null)
          {
            paramString = null;
            if ((paramString instanceof ConstraintLayout.LayoutParams))
            {
              paramString = (ConstraintLayout.LayoutParams)paramString;
              if (paramString == null) {
                continue;
              }
              paramString.blC = "16:9";
            }
          }
          else
          {
            paramString = paramString.getLayoutParams();
            continue;
          }
          paramString = null;
          continue;
          continue;
        }
        if ((hIz() - getStatusBarHeight() - com.tencent.mm.cd.a.br(this.mContext, a.c.Edge_3A)) / hIA() >= this.TwL) {
          continue;
        }
        f = hIA() / (hIz() - getStatusBarHeight() - com.tencent.mm.cd.a.br(this.mContext, a.c.Edge_9A));
        paramString = this.TlC;
        if (paramString == null)
        {
          paramString = null;
          if ((paramString instanceof ConstraintLayout.LayoutParams))
          {
            paramString = (ConstraintLayout.LayoutParams)paramString;
            if (paramString == null) {
              continue;
            }
            paramString.blC = (f + ":1");
          }
        }
        else
        {
          paramString = paramString.getLayoutParams();
          continue;
        }
        paramString = null;
        continue;
        continue;
        paramString = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaUrl;
        kotlin.g.b.s.s(paramString, "info.field_MediaUrl");
        paramString = paramString.getBytes(d.UTF_8);
        kotlin.g.b.s.s(paramString, "(this as java.lang.String).getBytes(charset)");
        paramt = com.tencent.mm.b.g.getMessageDigest(paramString);
        paramString = paramt;
        if (paramt != null) {
          continue;
        }
        paramString = "";
        continue;
        localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaUrl;
        paramt = (t)localObject1;
        if (localObject1 != null) {
          continue;
        }
        paramt = "";
        continue;
        localObject1 = com.tencent.mm.plugin.textstatus.util.e.TAU;
        localObject1 = com.tencent.mm.plugin.textstatus.util.e.nl("video", str);
        continue;
        l = paramt.duration;
        continue;
        i = paramt.hYK;
        continue;
        ((MMTPEffectVideoLayout)localObject3).getEffectManager().b(com.tencent.mm.xeffect.effect.j.agYb);
        continue;
        hIi();
        continue;
      }
      paramString = paramString.field_MediaThumbUrl;
      continue;
      i = 0;
      continue;
      i = 0;
      continue;
      paramString = this.TwR;
      if (paramString != null)
      {
        paramString.setVisibility(0);
        continue;
        i = 0;
        continue;
        paramString = paramString.getLayoutParams();
        continue;
        paramString = this.TwS;
        if (paramString == null)
        {
          paramString = null;
          if ((paramString instanceof LinearLayout.LayoutParams)) {
            ((LinearLayout.LayoutParams)paramString).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 14);
          }
        }
        else
        {
          paramString = paramString.getLayoutParams();
          continue;
        }
        continue;
        paramString = paramb.field_StatusID;
        continue;
        if (!this.Tlv.aom(16384)) {
          def();
        }
        this.Two = paramt.sessionId;
        if (paramb == null)
        {
          paramString = "";
          this.Twp = paramString;
          paramString = hHx();
          k = 0;
          paramt = this.Tvs;
          j = k;
          if (paramt != null)
          {
            paramt.removeAllViews();
            if ((paramString == null) || (paramString.d(this.Tvs) != true)) {
              continue;
            }
            i = 1;
            j = k;
            if (i != 0) {
              j = 1;
            }
          }
          if (j == 0) {
            continue;
          }
          paramString = this.Tvs;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          if (paramb != null) {
            continue;
          }
          paramString = null;
          if (paramString == null) {
            continue;
          }
        }
        try
        {
          paramb = (CharSequence)paramString.sourceId;
          if (paramb == null) {
            continue;
          }
          if (!n.bp(paramb)) {
            continue;
          }
        }
        finally
        {
          continue;
        }
        if ((i == 0) && (this.Tlv.aom(16)))
        {
          if (this.Tvz == null)
          {
            i = 0;
            if (i == 0)
            {
              hIj();
              paramb = this.Tvo;
              if (paramb != null) {
                paramb.removeAllViews();
              }
              paramb = paramString.sourceId;
              kotlin.g.b.s.s(paramb, "topicInfo.sourceId");
              this.Tvz = N(paramb, (List)paramString.jumpInfos);
              this.TvA = paramString;
            }
            if (this.Tlv.aom(8192)) {
              hIB();
            }
            paramString = this.Tvo;
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            this.TwP.a(this.Tmm);
            AppMethodBeat.o(291476);
            return;
            paramt = paramb.field_StatusID;
            paramString = paramt;
            if (paramt == null)
            {
              paramString = "";
              continue;
              i = 0;
              continue;
              paramString = this.Tvs;
              if (paramString != null)
              {
                paramString.setVisibility(8);
                continue;
                paramString = com.tencent.mm.plugin.textstatus.h.f.b.b(paramb);
              }
            }
          }
          else
          {
            paramb = this.TvA;
            if ((paramb == null) || (b.a(paramb, paramString) != true)) {
              continue;
            }
            i = 1;
          }
        }
        else
        {
          hIj();
          paramString = this.Tvo;
          if (paramString != null) {
            paramString.removeAllViews();
          }
          paramString = this.Tvo;
          if (paramString != null)
          {
            paramString.setVisibility(8);
            continue;
            bool = true;
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public final void def()
  {
    AppMethodBeat.i(291485);
    Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
    com.tencent.mm.plugin.textstatus.proto.p localp = (com.tencent.mm.plugin.textstatus.proto.p)a.a.a(this.mContext, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
    if (localp != null)
    {
      localObject = this.Aoy.getTag(a.e.tag_key_position);
      if (!(localObject instanceof Integer)) {
        break label100;
      }
      localObject = (Integer)localObject;
      if (localObject != null) {
        break label105;
      }
    }
    label100:
    label105:
    for (int i = 0;; i = ((Integer)localObject).intValue())
    {
      localp.Tpi = i;
      localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(this.mContext, 1L, null, this.Tmb, 0L, 0L, 0L, 116);
      this.HsA = cn.bDw();
      AppMethodBeat.o(291485);
      return;
      localObject = null;
      break;
    }
  }
  
  public final View getView()
  {
    return this.Aoy;
  }
  
  public final void hFv()
  {
    AppMethodBeat.i(291533);
    Log.i(this.TAG, "[onStatusShowDestroy]");
    hIi();
    this.TwP.hHu();
    this.TwP.hHt();
    hIj();
    AppMethodBeat.o(291533);
  }
  
  public final void hFw()
  {
    int j = 0;
    AppMethodBeat.i(291538);
    Log.i(this.TAG, "[onStatusShowResume]");
    Object localObject = this.Tvz;
    if (localObject == null) {}
    for (boolean bool = false;; bool = ((com.tencent.mm.ui.widget.b)localObject).gpj())
    {
      int i = j;
      if (this.Tlv.aom(32))
      {
        i = j;
        if (!bool) {
          i = 1;
        }
      }
      if ((i != 0) && (com.tencent.mm.aw.a.bLk())) {
        com.tencent.mm.aw.a.bLi();
      }
      hIB();
      atK();
      this.TwP.hHv();
      localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGH().bdW(this.username);
      AppMethodBeat.o(291538);
      return;
    }
  }
  
  public final void hFx()
  {
    Object localObject2 = null;
    AppMethodBeat.i(291545);
    Log.i(this.TAG, "[onStatusShowPause]");
    hIC();
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("pauseVideo() called textureView:");
    Object localObject1 = this.Goz;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" state:");
      localObject1 = this.Goz;
      if (localObject1 != null) {
        break label156;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      Log.d(str, localObject1 + ' ');
      localObject1 = this.Goz;
      if (localObject1 != null)
      {
        localObject1 = ((MMTPEffectVideoLayout)localObject1).getPlayer();
        if (localObject1 != null) {
          com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)localObject1);
        }
      }
      this.TwP.hHw();
      AppMethodBeat.o(291545);
      return;
      localObject1 = ((MMTPEffectVideoLayout)localObject1).getPlayer();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).hashCode());
      break;
      label156:
      com.tencent.mm.plugin.thumbplayer.e.b localb = ((MMTPEffectVideoLayout)localObject1).getPlayer();
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = Integer.valueOf(localb.currentPlayState);
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(291517);
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.onBackPressed();
    }
    AppMethodBeat.o(291517);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(291563);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    localObject = this.fhU;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.e.TdX;
      if (paramView != null) {
        break label103;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291563);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label103:
      if (paramView.intValue() == i) {
        hIv();
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(291569);
    if ((paramp instanceof com.tencent.mm.plugin.textstatus.h.b))
    {
      com.tencent.mm.kernel.h.aZW().b(((com.tencent.mm.plugin.textstatus.h.b)paramp).getType(), (com.tencent.mm.am.h)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label79;
      }
    }
    for (int i = 1;; i = 0)
    {
      paramString = this.Twr;
      if (paramString != null) {
        paramString.aok(0);
      }
      paramString = this.psR;
      if (paramString != null) {
        paramString.dismiss();
      }
      AppMethodBeat.o(291569);
      return;
      label79:
      com.tencent.mm.ui.base.k.c(this.mContext, this.mContext.getString(a.h.Tgb), "", true);
    }
  }
  
  public final void w(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public final void wk(long paramLong)
  {
    AppMethodBeat.i(291494);
    long l2 = cn.bDw() - this.HsA;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    com.tencent.mm.plugin.textstatus.i.b localb = com.tencent.mm.plugin.textstatus.i.b.Trt;
    com.tencent.mm.plugin.textstatus.i.b.a(this.mContext, 2L, null, null, paramLong, l1, 0L, 76);
    AppMethodBeat.o(291494);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/StatusCardView$statusCardEventListener$1", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;", "beforeJumpDetail", "", "beforeJumpSource", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements e.a
  {
    e(h paramh) {}
    
    public final void gpi()
    {
      AppMethodBeat.i(291374);
      com.tencent.mm.ui.widget.b localb = this.TwV.Tvz;
      if (localb != null) {
        localb.gpi();
      }
      AppMethodBeat.o(291374);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.h
 * JD-Core Version:    0.7.0.1
 */