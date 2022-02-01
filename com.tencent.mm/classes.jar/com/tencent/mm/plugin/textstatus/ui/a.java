package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.b.b.c;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.h.o.f;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.util.e;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ao.a;
import com.tencent.mm.ui.component.glocom.b.a;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/BackPreview;", "Lcom/tencent/mm/plugin/textstatus/api/IBackPreview;", "context", "Landroid/content/Context;", "closeRunnable", "Ljava/lang/Runnable;", "isPreviewVideo", "", "(Landroid/content/Context;Ljava/lang/Runnable;Z)V", "back", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBack", "()Landroid/view/View;", "setBack", "(Landroid/view/View;)V", "backInitOffset", "", "getBackInitOffset", "()F", "setBackInitOffset", "(F)V", "checkValidListener", "Lcom/tencent/mm/ui/widget/IPullDownView$CheckValidListener;", "getCloseRunnable", "()Ljava/lang/Runnable;", "setCloseRunnable", "(Ljava/lang/Runnable;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "isInOpen", "()Z", "setInOpen", "(Z)V", "isMusicPlaying", "setMusicPlaying", "isPlaying", "setPlaying", "setPreviewVideo", "isShowLayoutThirdContainer", "setShowLayoutThirdContainer", "ivMask", "Landroid/widget/ImageView;", "getIvMask", "()Landroid/widget/ImageView;", "setIvMask", "(Landroid/widget/ImageView;)V", "ivPreview", "getIvPreview", "setIvPreview", "lastGetCustomPartsTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getLastGetCustomPartsTopicInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "setLastGetCustomPartsTopicInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)V", "lastId", "", "getLastId", "()J", "setLastId", "(J)V", "lastIsLocal", "getLastIsLocal", "setLastIsLocal", "lastSetThirdTopicInfo", "getLastSetThirdTopicInfo", "setLastSetThirdTopicInfo", "lastVideoHeight", "", "getLastVideoHeight", "()I", "setLastVideoHeight", "(I)V", "lastVideoWidth", "getLastVideoWidth", "setLastVideoWidth", "layoutAuthor", "getLayoutAuthor", "setLayoutAuthor", "layoutAuthorCustomView", "Landroid/widget/FrameLayout;", "getLayoutAuthorCustomView", "()Landroid/widget/FrameLayout;", "setLayoutAuthorCustomView", "(Landroid/widget/FrameLayout;)V", "layoutDetail", "getLayoutDetail", "setLayoutDetail", "layoutPreviewHeader", "Landroid/widget/LinearLayout;", "getLayoutPreviewHeader", "()Landroid/widget/LinearLayout;", "setLayoutPreviewHeader", "(Landroid/widget/LinearLayout;)V", "layoutThirdContainer", "getLayoutThirdContainer", "setLayoutThirdContainer", "layoutThirdThumb", "getLayoutThirdThumb", "setLayoutThirdThumb", "layoutVideo", "getLayoutVideo", "setLayoutVideo", "mCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "getMCustomParts", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "setMCustomParts", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;)V", "startOpenTime", "getStartOpenTime", "setStartOpenTime", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "statusUIListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;", "getStatusUIListener", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;", "setStatusUIListener", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;)V", "thirdBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "getThirdBack", "()Lcom/tencent/mm/ui/widget/IPullDownView;", "setThirdBack", "(Lcom/tencent/mm/ui/widget/IPullDownView;)V", "tvAuthorName", "Landroid/widget/TextView;", "getTvAuthorName", "()Landroid/widget/TextView;", "setTvAuthorName", "(Landroid/widget/TextView;)V", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;)V", "checkCurCustomPartsValid", "topicInfo", "checkCurThirdBackValid", "checkIsThirdBackValid", "", "destroyCustomPartsManual", "destroyThirdBackManual", "destroyVideo", "getCustomParts", "sourceId", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getView", "handlePreviewHeader", "handleThirdBack", "handleThirdBackVisibility", "handleThirdThumb", "handleVideo", "init", "initPos", "isCanPullDown", "isContextValid", "isNeedPauseMusic", "isPureColor", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onPullDownProgress", "persent", "curTranslation", "unfoldTranslation", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTabSwitchIn", "onTabSwitchOut", "playVideo", "setCardView", "cardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "setStatusBrowseUIListener", "listener", "stopVideo", "update", "updateLayoutParams", "updateMask", "updateVideoMute", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.textstatus.a.b
{
  public static final a.a Tvk;
  private View CwU;
  private long GQt;
  private MMTPEffectVideoLayout Goz;
  private Runnable LNf;
  private FrameLayout Tlf;
  private TextView Tlg;
  private long Tlq;
  private com.tencent.mm.plugin.textstatus.h.f.b Tmb;
  private TextStatusTopicInfo Tmi;
  private boolean ToP;
  private TextStatusTopicInfo TvA;
  private boolean TvB;
  private k TvC;
  private float TvD;
  private ImageView Tvl;
  private FrameLayout Tvm;
  private ImageView Tvn;
  private FrameLayout Tvo;
  private LinearLayout Tvp;
  private View Tvq;
  private View Tvr;
  private FrameLayout Tvs;
  private com.tencent.mm.plugin.textstatus.a.i Tvt;
  private boolean Tvu;
  private boolean Tvv;
  private boolean Tvw;
  private int Tvx;
  private int Tvy;
  private com.tencent.mm.ui.widget.b Tvz;
  private Context context;
  private boolean hLy;
  private long ork;
  private String username;
  
  static
  {
    AppMethodBeat.i(291558);
    Tvk = new a.a((byte)0);
    AppMethodBeat.o(291558);
  }
  
  public a(Context paramContext, Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(291427);
    this.context = paramContext;
    this.LNf = paramRunnable;
    this.ToP = paramBoolean;
    this.CwU = LayoutInflater.from(this.context).inflate(a.f.Tfb, null, false);
    this.username = "";
    paramContext = this.CwU.findViewById(a.e.TcK);
    s.s(paramContext, "back.findViewById(R.id.iv_preview)");
    this.Tvl = ((ImageView)paramContext);
    paramContext = this.CwU.findViewById(a.e.TdB);
    s.s(paramContext, "back.findViewById(R.id.layout_video)");
    this.Tvm = ((FrameLayout)paramContext);
    paramContext = this.CwU.findViewById(a.e.TcH);
    s.s(paramContext, "back.findViewById(R.id.iv_mask)");
    this.Tvn = ((ImageView)paramContext);
    paramContext = this.CwU.findViewById(a.e.Tdw);
    s.s(paramContext, "back.findViewById(R.id.layout_third_container)");
    this.Tvo = ((FrameLayout)paramContext);
    paramContext = this.CwU.findViewById(a.e.Tdp);
    s.s(paramContext, "back.findViewById(R.id.layout_preview_header)");
    this.Tvp = ((LinearLayout)paramContext);
    this.Tlf = ((FrameLayout)this.CwU.findViewById(a.e.TcV));
    this.Tvq = this.CwU.findViewById(a.e.TcU);
    this.Tlg = ((TextView)this.CwU.findViewById(a.e.Teg));
    paramContext = this.CwU.findViewById(a.e.Tde);
    s.s(paramContext, "back.findViewById(R.id.layout_detail)");
    this.Tvr = paramContext;
    this.Tvr.setVisibility(8);
    paramContext = this.CwU.findViewById(a.e.Tdx);
    s.s(paramContext, "back.findViewById(R.id.layout_third_thumb)");
    this.Tvs = ((FrameLayout)paramContext);
    this.CwU.setOnClickListener(new a..ExternalSyntheticLambda0(this));
    paramContext = this.Tvo.getLayoutParams();
    if (paramContext != null)
    {
      paramContext.width = -1;
      paramContext.height = com.tencent.mm.plugin.textstatus.a.a.kk(this.context)[1];
    }
    paramContext = com.tencent.mm.plugin.textstatus.util.l.TBz;
    com.tencent.mm.plugin.textstatus.util.l.C((View)this.Tlf, com.tencent.mm.cd.a.fromDPToPix(this.context, 10.0F));
    this.GQt = -1L;
    AppMethodBeat.o(291427);
  }
  
  private com.tencent.mm.ui.widget.b N(String paramString, List<? extends TextStatusJumpInfo> paramList)
  {
    localObject2 = null;
    AppMethodBeat.i(291492);
    s.u(paramString, "sourceId");
    com.tencent.mm.plugin.textstatus.proto.l locall = new com.tencent.mm.plugin.textstatus.proto.l();
    locall.nDl = 0;
    locall.ToO = 1;
    locall.ToP = this.ToP;
    Object localObject1 = this.Tmb;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label178;
      }
      i = cn.getSyncServerTimeSecond();
      label69:
      locall.ToQ = i;
      if (paramList != null) {
        break label187;
      }
      paramList = null;
    }
    try
    {
      label81:
      localObject1 = com.tencent.mm.plugin.textstatus.third.i.TuX;
      if (paramList != null) {
        break label195;
      }
      localObject1 = null;
      label93:
      localObject1 = com.tencent.mm.plugin.textstatus.third.i.bec((String)localObject1);
      if (localObject1 != null) {
        break label204;
      }
      paramString = localObject2;
    }
    finally
    {
      for (;;)
      {
        label108:
        paramString = localObject2;
      }
    }
    paramList = this.context;
    if (((paramList instanceof MMFragmentActivity)) && (paramString != null)) {
      b.a.a(paramString, (MMFragmentActivity)paramList);
    }
    if (paramString != null) {}
    for (int i = paramString.hashCode();; i = 0)
    {
      Log.i("MicroMsg.TextStatus.BackPreview", s.X("getThirdBack ", Integer.valueOf(i)));
      AppMethodBeat.o(291492);
      return paramString;
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).field_CreateTime);
      break;
      label178:
      i = ((Integer)localObject1).intValue();
      break label69;
      label187:
      paramList = com.tencent.mm.plugin.textstatus.third.j.lu(paramList);
      break label81;
      label195:
      localObject1 = paramList.jumpType;
      break label93;
      label204:
      paramString = ((com.tencent.mm.plugin.textstatus.a.o)localObject1).a(paramString, this.Tvo, paramList, locall);
      break label108;
    }
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(291551);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/BackPreview", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    if (!s.p(parama.username, com.tencent.mm.plugin.auth.a.a.cUx()))
    {
      parama = parama.context;
      if ((parama instanceof Activity))
      {
        parama = ((Activity)parama).findViewById(a.e.TdX);
        if (parama != null) {
          parama.performClick();
        }
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/BackPreview", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(291551);
  }
  
  private void atK()
  {
    AppMethodBeat.i(291464);
    Object localObject1 = (CharSequence)this.username;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291464);
      return;
    }
    if (this.hLy)
    {
      AppMethodBeat.o(291464);
      return;
    }
    this.hLy = true;
    localObject1 = f.TjQ;
    com.tencent.mm.plugin.textstatus.h.f.b localb = f.bdN(this.username);
    if (localb == null)
    {
      AppMethodBeat.o(291464);
      return;
    }
    Log.i("MicroMsg.TextStatus.BackPreview", "[play] mediaType:%s, field_MediaUrl:%s, username:%s", new Object[] { Integer.valueOf(localb.field_MediaType), localb.field_MediaUrl, this.username });
    MMTPEffectVideoLayout localMMTPEffectVideoLayout;
    Object localObject2;
    label248:
    int k;
    Object localObject3;
    label318:
    long l;
    if (localb.field_MediaType == 2)
    {
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      if (this.Goz == null) {
        this.Goz = new MMTPEffectVideoLayout(this.context, (byte)0);
      }
      localMMTPEffectVideoLayout = this.Goz;
      if (localMMTPEffectVideoLayout == null)
      {
        AppMethodBeat.o(291464);
        return;
      }
      this.Tvm.removeAllViews();
      this.Tvm.addView((View)localMMTPEffectVideoLayout, (ViewGroup.LayoutParams)localObject1);
      if (localb.field_MediaUrl == null)
      {
        localObject1 = "";
        if (localb.field_MediaUrl != null) {
          break label640;
        }
        localObject2 = "";
        int j = localb.field_mediaWidth;
        k = localb.field_mediaHeight;
        if (j > 0)
        {
          i = k;
          if (k > 0) {}
        }
        else
        {
          j = ao.mX(this.context).width;
          i = ao.mX(this.context).height;
        }
        localObject3 = e.TAU;
        localObject3 = e.bek(this.username);
        boolean bool = y.ZC((String)localObject3);
        if (!bool) {
          break label664;
        }
        localObject1 = new com.tencent.mm.plugin.thumbplayer.a.b((String)localObject1, (String)localObject3, (String)localObject2, j, i);
        ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hJv = bool;
        if (bool)
        {
          localObject2 = MultiMediaVideoChecker.ObB.cI((String)localObject3, true);
          if (localObject2 != null) {
            break label684;
          }
          l = 0L;
          label366:
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).vYw = l;
          if (localObject2 != null) {
            break label694;
          }
          k = 0;
          label380:
          ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).hYK = k;
        }
        Log.i("MicroMsg.TextStatus.BackPreview", "[play] isLocal:%s, videoWidth:%s, videoHeight:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i) });
        localMMTPEffectVideoLayout.fva();
        localMMTPEffectVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
        localObject2 = localMMTPEffectVideoLayout.getPlayer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).Flr = true;
        }
        localObject2 = localMMTPEffectVideoLayout.getPlayer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).setLoop(true);
        }
        flu();
        localMMTPEffectVideoLayout.getEffectManager().jQl();
        localMMTPEffectVideoLayout.getEffectManager().jQk();
        if (!localb.hHI()) {
          break label703;
        }
        localObject2 = localMMTPEffectVideoLayout.getEffectManager().jQj();
        ((com.tencent.mm.xeffect.effect.b)localObject2).setRadius(5.0F);
        ((com.tencent.mm.xeffect.effect.b)localObject2).eC(1.0F);
        label522:
        this.GQt = localb.systemRowid;
        this.Tvw = bool;
        this.Tvx = j;
        this.Tvy = i;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = localMMTPEffectVideoLayout.getPlayer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).hLh();
        }
        this.Tvm.setVisibility(0);
        hIl();
        AppMethodBeat.o(291464);
        return;
      }
      catch (Exception localException)
      {
        label640:
        label664:
        label684:
        label694:
        label703:
        Log.e("MicroMsg.TextStatus.BackPreview", "unable to play video! mediaInfo:" + localObject1 + " error:" + localException.getLocalizedMessage());
      }
      localObject1 = localb.field_MediaUrl;
      s.s(localObject1, "info.field_MediaUrl");
      localObject1 = ((String)localObject1).getBytes(d.UTF_8);
      s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
      localObject2 = g.getMessageDigest((byte[])localObject1);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject3 = localb.field_MediaUrl;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label248;
      }
      localObject2 = "";
      break label248;
      localObject3 = e.TAU;
      localObject3 = e.nl("video", this.username);
      break label318;
      l = ((MultiMediaVideoChecker.a)localObject2).duration;
      break label366;
      k = ((MultiMediaVideoChecker.a)localObject2).hYK;
      break label380;
      localMMTPEffectVideoLayout.getEffectManager().b(com.tencent.mm.xeffect.effect.j.agYb);
      break label522;
      this.Tvm.setVisibility(8);
      this.Tvl.setVisibility(0);
    }
  }
  
  private boolean e(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(291534);
    if (this.TvC == null)
    {
      AppMethodBeat.o(291534);
      return false;
    }
    TextStatusTopicInfo localTextStatusTopicInfo = this.Tmi;
    if ((localTextStatusTopicInfo != null) && (b.a(localTextStatusTopicInfo, paramTextStatusTopicInfo) == true)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(291534);
      return false;
    }
    AppMethodBeat.o(291534);
    return true;
  }
  
  private final void f(com.tencent.mm.plugin.textstatus.h.f.b paramb)
  {
    int j = 1;
    AppMethodBeat.i(291516);
    paramb = com.tencent.mm.plugin.textstatus.h.f.b.b(paramb).sourceId;
    Object localObject = hHx();
    boolean bool;
    int i;
    if (localObject == null)
    {
      bool = true;
      paramb = (CharSequence)paramb;
      if ((paramb != null) && (!n.bp(paramb))) {
        break label189;
      }
      i = 1;
      label48:
      if ((i != 0) || (!bool)) {
        break label244;
      }
      paramb = hHx();
      if ((paramb == null) || (paramb.etQ() != true)) {
        break label194;
      }
      i = j;
      label76:
      if (i == 0) {
        break label244;
      }
      this.Tvp.setVisibility(0);
      paramb = hHx();
      localObject = this.Tlf;
      if (localObject != null)
      {
        ((FrameLayout)localObject).removeAllViews();
        if (paramb != null) {
          paramb.f((FrameLayout)localObject);
        }
      }
      localObject = this.Tlg;
      if (localObject != null)
      {
        paramb = hHx();
        if (paramb != null) {
          break label199;
        }
      }
    }
    label189:
    label194:
    label199:
    for (paramb = null;; paramb = paramb.etS())
    {
      ((TextView)localObject).setText(paramb);
      paramb = this.Tvp.getLayoutParams();
      if (paramb != null) {
        break label207;
      }
      paramb = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(291516);
      throw paramb;
      bool = ((k)localObject).eKU();
      break;
      i = 0;
      break label48;
      i = 0;
      break label76;
    }
    label207:
    ((RelativeLayout.LayoutParams)paramb).topMargin = (com.tencent.mm.compatible.util.o.I(this.context, 25) + this.context.getResources().getDimensionPixelSize(a.c.Edge_3A));
    AppMethodBeat.o(291516);
    return;
    label244:
    this.Tvp.setVisibility(8);
    AppMethodBeat.o(291516);
  }
  
  private final void flu()
  {
    boolean bool = false;
    AppMethodBeat.i(291444);
    if ((com.tencent.mm.n.a.aTj()) || (com.tencent.mm.n.a.s(this.context, false)) || (!this.Tvu)) {
      bool = true;
    }
    Object localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).setMute(bool);
      }
    }
    AppMethodBeat.o(291444);
  }
  
  private void hHu()
  {
    AppMethodBeat.i(291526);
    k localk = this.TvC;
    if (localk != null) {
      localk.onDetach();
    }
    this.TvC = null;
    this.Tmi = null;
    AppMethodBeat.o(291526);
  }
  
  private k hHx()
  {
    LinkedList localLinkedList = null;
    AppMethodBeat.i(291524);
    Object localObject1 = this.Tmb;
    Object localObject2;
    label41:
    k localk;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!e((TextStatusTopicInfo)localObject1))
      {
        hHu();
        localObject2 = com.tencent.mm.plugin.textstatus.third.i.TuX;
        if (localObject1 != null) {
          break label111;
        }
        localObject2 = null;
        this.TvC = com.tencent.mm.plugin.textstatus.third.i.bed((String)localObject2);
        localk = this.TvC;
        if (localk != null)
        {
          localObject2 = this.Tmb;
          if (localObject2 != null) {
            break label119;
          }
          localObject2 = null;
          label71:
          if (localObject1 != null) {
            break label127;
          }
        }
      }
    }
    for (;;)
    {
      localk.y((String)localObject2, (List)localLinkedList);
      this.Tmi = ((TextStatusTopicInfo)localObject1);
      localObject1 = this.TvC;
      AppMethodBeat.o(291524);
      return localObject1;
      localObject1 = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject1);
      break;
      label111:
      localObject2 = c.b((TextStatusTopicInfo)localObject1);
      break label41;
      label119:
      localObject2 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_StatusID;
      break label71;
      label127:
      localLinkedList = ((TextStatusTopicInfo)localObject1).jumpInfos;
    }
  }
  
  private final boolean hIh()
  {
    AppMethodBeat.i(291438);
    Object localObject = this.Tvz;
    if ((localObject != null) && (((com.tencent.mm.ui.widget.b)localObject).etN() == true))
    {
      i = 1;
      if (i == 0)
      {
        localObject = this.Tmb;
        if ((localObject == null) || (((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_MediaType != 2)) {
          break label65;
        }
      }
    }
    label65:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label70;
      }
      AppMethodBeat.o(291438);
      return true;
      i = 0;
      break;
    }
    label70:
    AppMethodBeat.o(291438);
    return false;
  }
  
  private void hIi()
  {
    AppMethodBeat.i(291470);
    Log.i("MicroMsg.TextStatus.BackPreview", "[destroyVideo]");
    Object localObject = this.Goz;
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
    this.Goz = null;
    this.Tvm.removeAllViews();
    AppMethodBeat.o(291470);
  }
  
  private final void hIj()
  {
    AppMethodBeat.i(291503);
    Object localObject = this.context;
    if ((localObject instanceof MMFragmentActivity))
    {
      com.tencent.mm.ui.widget.b localb = this.Tvz;
      if (localb != null) {
        b.a.b(localb, (MMFragmentActivity)localObject);
      }
    }
    localObject = this.Tvz;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      Log.i("MicroMsg.TextStatus.BackPreview", s.X("destroyThirdBackManual ", Integer.valueOf(i)));
      localObject = this.Tvz;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.b)localObject).onDestroy();
      }
      this.Tvz = null;
      this.TvA = null;
      AppMethodBeat.o(291503);
      return;
    }
  }
  
  private boolean hIk()
  {
    AppMethodBeat.i(291539);
    Object localObject = this.Tmb;
    if (localObject == null)
    {
      localObject = null;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
        break label78;
      }
      i = 1;
      label35:
      if (i != 0) {
        break label88;
      }
      localObject = hHx();
      if ((localObject == null) || (((k)localObject).etQ() != true)) {
        break label83;
      }
    }
    label78:
    label83:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label88;
      }
      AppMethodBeat.o(291539);
      return true;
      localObject = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_backgroundId;
      break;
      i = 0;
      break label35;
    }
    label88:
    AppMethodBeat.o(291539);
    return false;
  }
  
  private void hIl()
  {
    int i = 1;
    AppMethodBeat.i(291543);
    if (!hIk())
    {
      com.tencent.mm.plugin.textstatus.h.f.b localb = this.Tmb;
      if ((localb == null) || (localb.hHI() != true)) {
        break label52;
      }
    }
    while (i != 0)
    {
      this.Tvn.setVisibility(8);
      AppMethodBeat.o(291543);
      return;
      label52:
      i = 0;
    }
    this.Tvn.setVisibility(0);
    AppMethodBeat.o(291543);
  }
  
  private void stopVideo()
  {
    AppMethodBeat.i(291479);
    Object localObject = (CharSequence)this.username;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291479);
      return;
    }
    this.hLy = false;
    localObject = this.Goz;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.b((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
      }
    }
    this.Tvm.setVisibility(8);
    this.Tvl.setVisibility(0);
    hIi();
    hIl();
    AppMethodBeat.o(291479);
  }
  
  public final void Ds(String paramString)
  {
    AppMethodBeat.i(291627);
    s.u(paramString, "username");
    this.username = paramString;
    Object localObject1 = this.context;
    if ((localObject1 instanceof Activity)) {
      if (!((Activity)localObject1).isFinishing()) {
        i = 1;
      }
    }
    while (i == 0)
    {
      AppMethodBeat.o(291627);
      return;
      i = 0;
      continue;
      i = 0;
    }
    new o.f(paramString, (com.tencent.mm.plugin.textstatus.a.p)this);
    localObject1 = f.TjQ;
    this.Tmb = f.bdN(paramString);
    Log.i("MicroMsg.TextStatus.BackPreview", s.X("[update TextStatusinfo]:", this.Tmb));
    localObject1 = this.Tmb;
    if (localObject1 == null)
    {
      paramString = this.Tvt;
      if (paramString != null) {
        paramString.gBn();
      }
      AppMethodBeat.o(291627);
      return;
    }
    label204:
    Object localObject2;
    if (((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).field_MediaType == 2)
    {
      com.tencent.mm.plugin.textstatus.g.a.a(com.tencent.mm.plugin.textstatus.g.a.Tmr, this.context, paramString, this.Tvl);
      paramString = this.Tvt;
      if (paramString != null) {
        paramString.gBo();
      }
      hIl();
      paramString = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject1);
      if (TextUtils.isEmpty((CharSequence)paramString.sourceId)) {
        break label487;
      }
      if (this.Tvz != null) {
        break label445;
      }
      i = 0;
      if (i == 0)
      {
        hIj();
        this.Tvo.removeAllViews();
        localObject2 = paramString.sourceId;
        s.s(localObject2, "topicInfo.sourceId");
        this.Tvz = N((String)localObject2, (List)paramString.jumpInfos);
        this.TvA = paramString;
        paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramString = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
        if (paramString != null) {
          paramString.Tpk = 0L;
        }
      }
      this.TvB = true;
      label289:
      f((com.tencent.mm.plugin.textstatus.h.f.b)localObject1);
      paramString = hHx();
      if ((paramString == null) || (paramString.d(this.Tvs) != true)) {
        break label540;
      }
      i = 1;
      label317:
      if (i == 0) {
        this.Tvs.removeAllViews();
      }
      paramString = hHx();
      localObject1 = this.Tvo;
      if ((paramString == null) || (paramString.eKV())) {
        break label545;
      }
      i = 1;
      label351:
      if ((i == 0) || (!this.TvB)) {
        break label550;
      }
      i = 0;
      label364:
      ((FrameLayout)localObject1).setVisibility(i);
      paramString = this.Tmb;
      if ((paramString == null) || (paramString.field_MediaType != 2)) {
        break label556;
      }
    }
    label540:
    label545:
    label550:
    label556:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        stopVideo();
      }
      if (this.ToP)
      {
        this.hLy = false;
        atK();
        this.ork = cn.bDw();
      }
      AppMethodBeat.o(291627);
      return;
      com.tencent.mm.plugin.textstatus.g.a.Tmr.a(this.context, paramString, this.Tvl, false);
      break;
      label445:
      localObject2 = this.TvA;
      if ((localObject2 != null) && (b.a((TextStatusTopicInfo)localObject2, paramString) == true)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label482;
        }
        i = 0;
        break;
      }
      label482:
      i = 1;
      break label204;
      label487:
      hIj();
      this.Tvo.removeAllViews();
      this.TvB = false;
      paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramString = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
      if (paramString == null) {
        break label289;
      }
      paramString.Tpk = 0L;
      paramString.Tpl = 0L;
      break label289;
      i = 0;
      break label317;
      i = 0;
      break label351;
      i = 8;
      break label364;
    }
  }
  
  public final void a(com.tencent.mm.plugin.textstatus.a.i parami)
  {
    this.Tvt = parami;
  }
  
  public final void afI(int paramInt) {}
  
  public final void afJ(int paramInt) {}
  
  public final void afK(int paramInt) {}
  
  public final void etL()
  {
    AppMethodBeat.i(291582);
    this.Tvu = true;
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.etL();
    }
    if (this.TvB) {
      this.Tvo.setVisibility(0);
    }
    flu();
    AppMethodBeat.o(291582);
  }
  
  public final void etM()
  {
    AppMethodBeat.i(291587);
    this.Tvu = false;
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.etM();
    }
    flu();
    AppMethodBeat.o(291587);
  }
  
  public final void gBu() {}
  
  public final void gBv() {}
  
  public final View getView()
  {
    AppMethodBeat.i(291613);
    View localView = this.CwU;
    s.s(localView, "back");
    AppMethodBeat.o(291613);
    return localView;
  }
  
  public final void hFo()
  {
    AppMethodBeat.i(291659);
    ViewGroup.LayoutParams localLayoutParams = getView().getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = com.tencent.mm.plugin.textstatus.a.a.kk(this.context)[1];
    int i = com.tencent.mm.plugin.textstatus.a.a.kk(this.context)[1];
    int j = com.tencent.mm.plugin.textstatus.a.a.kl(this.context)[1];
    if (i > j)
    {
      float f = (i - j) / 2.0F;
      this.CwU.setTranslationY(-f);
      this.TvD = (-f);
    }
    Log.d("MicroMsg.TextStatus.BackPreview", "initPos backHeight:" + i + " foreHeight:" + j);
    AppMethodBeat.o(291659);
  }
  
  public final void hFp()
  {
    AppMethodBeat.i(291665);
    Log.i("MicroMsg.TextStatus.BackPreview", "[onTabSwitchOut]");
    AppMethodBeat.o(291665);
  }
  
  public final void hFq()
  {
    AppMethodBeat.i(291669);
    Log.i("MicroMsg.TextStatus.BackPreview", "[onTabSwitchIn]");
    AppMethodBeat.o(291669);
  }
  
  public final boolean hFr()
  {
    AppMethodBeat.i(291675);
    boolean bool = b.a(this.username, hHx(), this.Tmb);
    AppMethodBeat.o(291675);
    return bool;
  }
  
  public final void hFv()
  {
    AppMethodBeat.i(291632);
    Log.i("MicroMsg.TextStatus.BackPreview", "onStatusShowDestroy:%s", new Object[] { Boolean.valueOf(this.Tvu) });
    hIi();
    this.Tvt = null;
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.onDestroy();
    }
    AppMethodBeat.o(291632);
  }
  
  public final void hFw()
  {
    AppMethodBeat.i(291638);
    Log.i("MicroMsg.TextStatus.BackPreview", "onStatusShowResume:%s", new Object[] { Boolean.valueOf(this.ToP) });
    if (this.ToP) {
      atK();
    }
    AppMethodBeat.o(291638);
  }
  
  public final void hFx()
  {
    AppMethodBeat.i(291640);
    Log.i("MicroMsg.TextStatus.BackPreview", "onStatusShowPause:%s", new Object[] { Boolean.valueOf(this.Tvu) });
    stopVideo();
    AppMethodBeat.o(291640);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(291578);
    Log.i("MicroMsg.TextStatus.BackPreview", "[onPostClose]");
    long l1 = cn.bDw();
    long l2 = this.Tlq;
    if (!this.ToP) {
      stopVideo();
    }
    Object localObject1 = this.Tvz;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject2 = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
      if (localObject2 != null)
      {
        if (!this.ToP) {
          break label196;
        }
        ((com.tencent.mm.plugin.textstatus.proto.p)localObject2).Tpk = (cn.bDw() - this.ork);
        ((com.tencent.mm.plugin.textstatus.proto.p)localObject2).Tpl = ((com.tencent.mm.ui.widget.b)localObject1).flv();
      }
    }
    localObject1 = this.Tvz;
    if (localObject1 != null) {
      ((com.tencent.mm.ui.widget.b)localObject1).onPostClose();
    }
    if ((hIh()) && (this.Tvv)) {
      com.tencent.mm.aw.a.bLh();
    }
    localObject1 = hHx();
    if ((localObject1 != null) && (((k)localObject1).eKV() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.Tvo.setVisibility(8);
      }
      localObject1 = this.Tmb;
      if (localObject1 != null) {
        f((com.tencent.mm.plugin.textstatus.h.f.b)localObject1);
      }
      AppMethodBeat.o(291578);
      return;
      label196:
      ((com.tencent.mm.plugin.textstatus.proto.p)localObject2).Tpk = (l1 - l2 + ((com.tencent.mm.plugin.textstatus.proto.p)localObject2).Tpk);
      break;
    }
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(291570);
    Log.i("MicroMsg.TextStatus.BackPreview", "[onPostOpen]");
    this.Tlq = cn.bDw();
    if (hIh())
    {
      this.Tvv = com.tencent.mm.aw.a.bLk();
      if (this.Tvv) {
        com.tencent.mm.aw.a.bLg();
      }
    }
    atK();
    com.tencent.mm.ui.widget.b localb = this.Tvz;
    if (localb != null) {
      localb.etO();
    }
    if (this.TvB) {
      this.Tvo.setVisibility(0);
    }
    if (this.ToP)
    {
      localb = this.Tvz;
      if (localb != null)
      {
        Object localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.textstatus.proto.p)localObject).Tpk = (cn.bDw() - this.ork);
          ((com.tencent.mm.plugin.textstatus.proto.p)localObject).Tpl = localb.flv();
        }
      }
    }
    AppMethodBeat.o(291570);
  }
  
  public final void w(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(291649);
    this.Tvn.setAlpha(0.3F * (1.0F - paramFloat1));
    if (paramFloat3 >= paramFloat2) {
      this.CwU.setTranslationY((1.0F - paramFloat1) * this.TvD);
    }
    for (;;)
    {
      this.Tvp.setAlpha(paramFloat1);
      this.Tvp.setScaleY(paramFloat1);
      AppMethodBeat.o(291649);
      return;
      this.CwU.setTranslationY(paramFloat2 - paramFloat3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.a
 * JD-Core Version:    0.7.0.1
 */