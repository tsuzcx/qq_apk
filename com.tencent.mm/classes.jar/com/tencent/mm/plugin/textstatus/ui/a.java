package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.b.c;
import com.tencent.mm.plugin.textstatus.g.n.e;
import com.tencent.mm.plugin.textstatus.j.e;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.j;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/BackPreview;", "Lcom/tencent/mm/plugin/textstatus/api/IBackPreview;", "context", "Landroid/content/Context;", "closeRunnable", "Ljava/lang/Runnable;", "isPreviewVideo", "", "(Landroid/content/Context;Ljava/lang/Runnable;Z)V", "back", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBack", "()Landroid/view/View;", "setBack", "(Landroid/view/View;)V", "backInitOffset", "", "getBackInitOffset", "()F", "setBackInitOffset", "(F)V", "checkValidListener", "Lcom/tencent/mm/ui/widget/IPullDownView$CheckValidListener;", "getCloseRunnable", "()Ljava/lang/Runnable;", "setCloseRunnable", "(Ljava/lang/Runnable;)V", "containerMaxHeight", "", "getContainerMaxHeight", "()I", "setContainerMaxHeight", "(I)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "isInOpen", "()Z", "setInOpen", "(Z)V", "isMusicPlaying", "setMusicPlaying", "isPlaying", "setPlaying", "setPreviewVideo", "isShowLayoutThirdContainer", "setShowLayoutThirdContainer", "ivMask", "Landroid/widget/ImageView;", "getIvMask", "()Landroid/widget/ImageView;", "setIvMask", "(Landroid/widget/ImageView;)V", "ivPreview", "getIvPreview", "setIvPreview", "lastGetCustomPartsTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getLastGetCustomPartsTopicInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "setLastGetCustomPartsTopicInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)V", "lastId", "", "getLastId", "()J", "setLastId", "(J)V", "lastIsLocal", "getLastIsLocal", "setLastIsLocal", "lastSetThirdTopicInfo", "getLastSetThirdTopicInfo", "setLastSetThirdTopicInfo", "lastVideoHeight", "getLastVideoHeight", "setLastVideoHeight", "lastVideoWidth", "getLastVideoWidth", "setLastVideoWidth", "layoutAuthor", "getLayoutAuthor", "setLayoutAuthor", "layoutAuthorCustomView", "Landroid/widget/FrameLayout;", "getLayoutAuthorCustomView", "()Landroid/widget/FrameLayout;", "setLayoutAuthorCustomView", "(Landroid/widget/FrameLayout;)V", "layoutDetail", "getLayoutDetail", "setLayoutDetail", "layoutPreviewHeader", "Landroid/widget/LinearLayout;", "getLayoutPreviewHeader", "()Landroid/widget/LinearLayout;", "setLayoutPreviewHeader", "(Landroid/widget/LinearLayout;)V", "layoutThirdContainer", "getLayoutThirdContainer", "setLayoutThirdContainer", "layoutThirdThumb", "getLayoutThirdThumb", "setLayoutThirdThumb", "layoutVideo", "getLayoutVideo", "setLayoutVideo", "mCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "getMCustomParts", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "setMCustomParts", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;)V", "startOpenTime", "getStartOpenTime", "setStartOpenTime", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "statusUIListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;", "getStatusUIListener", "()Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;", "setStatusUIListener", "(Lcom/tencent/mm/plugin/textstatus/api/IStatusBrowseUIListener;)V", "thirdBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "getThirdBack", "()Lcom/tencent/mm/ui/widget/IPullDownView;", "setThirdBack", "(Lcom/tencent/mm/ui/widget/IPullDownView;)V", "tvAuthorName", "Landroid/widget/TextView;", "getTvAuthorName", "()Landroid/widget/TextView;", "setTvAuthorName", "(Landroid/widget/TextView;)V", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;)V", "checkCurCustomPartsValid", "topicInfo", "checkCurThirdBackValid", "checkIsThirdBackValid", "", "destroyCustomPartsManual", "destroyThirdBackManual", "destroyVideo", "getCustomParts", "sourceId", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getView", "handlePreviewHeader", "handleThirdBack", "handleThirdBackVisibility", "handleThirdThumb", "handleVideo", "init", "initPos", "isCanPullDown", "isContextValid", "isNeedPauseMusic", "isPureColor", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onPullDownProgress", "persent", "curTranslation", "unfoldTranslation", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTabSwitchIn", "onTabSwitchOut", "playVideo", "setCardView", "cardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "setStatusBrowseUIListener", "listener", "stopVideo", "update", "updateLayoutParams", "updateMask", "updateVideoMute", "Companion", "plugin-textstatus_release"})
public final class a
  implements com.tencent.mm.plugin.textstatus.a.b
{
  public static final a.a MJt;
  private MMTPEffectVideoLayout Bba;
  private long Bkz;
  Runnable FSj;
  private TextView MBA;
  private long MBJ;
  private FrameLayout MBy;
  private View MBz;
  private com.tencent.mm.plugin.textstatus.g.e.a MCs;
  private TextStatusTopicInfo MCw;
  private boolean MEP;
  private ImageView MJa;
  private FrameLayout MJb;
  private ImageView MJc;
  private FrameLayout MJd;
  private LinearLayout MJe;
  private View MJf;
  private FrameLayout MJg;
  private g MJh;
  private boolean MJi;
  private boolean MJj;
  private boolean MJk;
  private int MJl;
  private int MJm;
  com.tencent.mm.ui.widget.b MJn;
  private TextStatusTopicInfo MJo;
  private boolean MJp;
  private i MJq;
  private float MJr;
  private int MJs;
  Context context;
  private boolean fGh;
  private long lzJ;
  private String username;
  private View xYC;
  
  static
  {
    AppMethodBeat.i(235533);
    MJt = new a.a((byte)0);
    AppMethodBeat.o(235533);
  }
  
  public a(Context paramContext, Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(235531);
    this.context = paramContext;
    this.FSj = paramRunnable;
    this.MEP = paramBoolean;
    this.xYC = LayoutInflater.from(this.context).inflate(b.f.MxE, null, false);
    this.username = "";
    paramContext = this.xYC.findViewById(b.e.Mvx);
    p.j(paramContext, "back.findViewById(R.id.iv_preview)");
    this.MJa = ((ImageView)paramContext);
    paramContext = this.xYC.findViewById(b.e.Mwm);
    p.j(paramContext, "back.findViewById(R.id.layout_video)");
    this.MJb = ((FrameLayout)paramContext);
    paramContext = this.xYC.findViewById(b.e.Mvu);
    p.j(paramContext, "back.findViewById(R.id.iv_mask)");
    this.MJc = ((ImageView)paramContext);
    paramContext = this.xYC.findViewById(b.e.Mwh);
    p.j(paramContext, "back.findViewById(R.id.layout_third_container)");
    this.MJd = ((FrameLayout)paramContext);
    paramContext = this.xYC.findViewById(b.e.MvZ);
    p.j(paramContext, "back.findViewById(R.id.layout_preview_header)");
    this.MJe = ((LinearLayout)paramContext);
    this.MBy = ((FrameLayout)this.xYC.findViewById(b.e.MvG));
    this.MBz = this.xYC.findViewById(b.e.MvF);
    this.MBA = ((TextView)this.xYC.findViewById(b.e.MwO));
    paramContext = this.xYC.findViewById(b.e.MvQ);
    p.j(paramContext, "back.findViewById(R.id.layout_detail)");
    this.MJf = paramContext;
    paramContext = this.xYC.findViewById(b.e.Mwi);
    p.j(paramContext, "back.findViewById(R.id.layout_third_thumb)");
    this.MJg = ((FrameLayout)paramContext);
    paramContext = this.MJd.getLayoutParams();
    if ((paramContext instanceof ViewGroup.LayoutParams))
    {
      paramContext.width = -1;
      paramContext.height = com.tencent.mm.plugin.textstatus.a.a.it(this.context)[1];
    }
    paramContext = com.tencent.mm.plugin.textstatus.k.n.MOY;
    com.tencent.mm.plugin.textstatus.k.n.B((View)this.MBy, com.tencent.mm.ci.a.fromDPToPix(this.context, 10.0F));
    this.Bkz = -1L;
    AppMethodBeat.o(235531);
  }
  
  private com.tencent.mm.ui.widget.b F(String paramString, List<? extends TextStatusJumpInfo> paramList)
  {
    localObject2 = null;
    AppMethodBeat.i(235501);
    p.k(paramString, "sourceId");
    com.tencent.mm.plugin.textstatus.proto.d locald = new com.tencent.mm.plugin.textstatus.proto.d();
    locald.kYn = 0;
    locald.MEO = 1;
    locald.MEP = this.MEP;
    localObject1 = this.MCs;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_CreateTime;
      locald.MEQ = i;
      if (paramList == null) {
        break label204;
      }
      paramList = e.in(paramList);
    }
    try
    {
      label78:
      localObject1 = com.tencent.mm.plugin.textstatus.j.d.MIW;
      if (paramList == null) {
        break label209;
      }
      localObject1 = paramList.jumpType;
      label93:
      m localm = com.tencent.mm.plugin.textstatus.j.d.beD((String)localObject1);
      localObject1 = localObject2;
      if (localm != null) {
        localObject1 = localm.a(paramString, this.MJd, paramList, locald);
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
    paramString = this.context;
    if (((paramString instanceof MMFragmentActivity)) && (localObject1 != null)) {
      ((com.tencent.mm.ui.widget.b)localObject1).a((MMFragmentActivity)paramString);
    }
    paramString = new StringBuilder("getThirdBack ");
    if (localObject1 != null) {}
    for (int i = localObject1.hashCode();; i = 0)
    {
      Log.i("MicroMsg.TextStatus.BackPreview", i);
      AppMethodBeat.o(235501);
      return localObject1;
      i = cm.bfF();
      break;
      label204:
      paramList = null;
      break label78;
      label209:
      localObject1 = null;
      break label93;
    }
  }
  
  private void Tf()
  {
    AppMethodBeat.i(235489);
    Object localObject1 = (CharSequence)this.username;
    if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(235489);
      return;
    }
    if (this.fGh)
    {
      AppMethodBeat.o(235489);
      return;
    }
    this.fGh = true;
    localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    com.tencent.mm.plugin.textstatus.g.e.a locala = com.tencent.mm.plugin.textstatus.b.f.bep(this.username);
    if (locala == null)
    {
      AppMethodBeat.o(235489);
      return;
    }
    Log.i("MicroMsg.TextStatus.BackPreview", "[play] mediaType:%s, field_MediaUrl:%s, username:%s", new Object[] { Integer.valueOf(locala.field_MediaType), locala.field_MediaUrl, this.username });
    MMTPEffectVideoLayout localMMTPEffectVideoLayout;
    Object localObject2;
    Object localObject3;
    int k;
    long l;
    if (locala.field_MediaType == 2)
    {
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      if (this.Bba == null) {
        this.Bba = new MMTPEffectVideoLayout(this.context, (byte)0);
      }
      localMMTPEffectVideoLayout = this.Bba;
      if (localMMTPEffectVideoLayout == null)
      {
        AppMethodBeat.o(235489);
        return;
      }
      this.MJb.removeAllViews();
      this.MJb.addView((View)localMMTPEffectVideoLayout, (ViewGroup.LayoutParams)localObject1);
      if (locala.field_MediaUrl != null)
      {
        localObject1 = locala.field_MediaUrl;
        p.j(localObject1, "info.field_MediaUrl");
        localObject2 = kotlin.n.d.UTF_8;
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(235489);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
        p.j(localObject1, "(this as java.lang.String).getBytes(charset)");
        localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      if (locala.field_MediaUrl != null)
      {
        localObject3 = locala.field_MediaUrl;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      int j = locala.field_mediaWidth;
      k = locala.field_mediaHeight;
      if (j > 0)
      {
        i = k;
        if (k > 0) {}
      }
      else
      {
        j = ak.kU(this.context).width;
        i = ak.kU(this.context).height;
      }
      localObject3 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject3 = com.tencent.mm.plugin.textstatus.k.f.beK(this.username);
      boolean bool = u.agG((String)localObject3);
      if (bool)
      {
        localObject1 = new com.tencent.mm.plugin.thumbplayer.e.d((String)localObject1, (String)localObject3, (String)localObject2, j, i);
        ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fEF = bool;
        if (bool)
        {
          localObject2 = MultiMediaVideoChecker.NmA.cO((String)localObject3, true);
          if (localObject2 == null) {
            break label705;
          }
          l = ((MultiMediaVideoChecker.a)localObject2).duration;
          label465:
          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).sTg = l;
          if (localObject2 == null) {
            break label711;
          }
          k = ((MultiMediaVideoChecker.a)localObject2).fSM;
          label483:
          ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).fSM = k;
        }
        Log.i("MicroMsg.TextStatus.BackPreview", "[play] isLocal:%s, videoWidth:%s, videoHeight:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i) });
        localMMTPEffectVideoLayout.goU();
        localMMTPEffectVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.e.d)localObject1);
        localObject2 = localMMTPEffectVideoLayout.getPlayer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).ALj = true;
        }
        localObject2 = localMMTPEffectVideoLayout.getPlayer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).setLoop(true);
        }
        ejp();
        localMMTPEffectVideoLayout.getEffectManager().ike();
        localMMTPEffectVideoLayout.getEffectManager().ikd();
        if (!locala.gma()) {
          break label716;
        }
        localObject2 = localMMTPEffectVideoLayout.getEffectManager().ikc();
        ((com.tencent.mm.xeffect.effect.b)localObject2).setRadius(5.0F);
        ((com.tencent.mm.xeffect.effect.b)localObject2).ikb();
        label624:
        this.Bkz = locala.systemRowid;
        this.MJk = bool;
        this.MJl = j;
        this.MJm = i;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = localMMTPEffectVideoLayout.getPlayer();
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).gos();
        }
        this.MJb.setVisibility(0);
        gmt();
        AppMethodBeat.o(235489);
        return;
      }
      catch (Exception localException)
      {
        label705:
        label711:
        label716:
        Log.e("MicroMsg.TextStatus.BackPreview", "unable to play video! mediaInfo:" + localObject1 + " error:" + localException.getLocalizedMessage());
      }
      localObject3 = com.tencent.mm.plugin.textstatus.k.f.MOw;
      localObject3 = com.tencent.mm.plugin.textstatus.k.f.lD("video", this.username);
      break;
      l = 0L;
      break label465;
      k = 0;
      break label483;
      localMMTPEffectVideoLayout.getEffectManager().b(j.YZP);
      break label624;
      this.MJb.setVisibility(8);
      this.MJa.setVisibility(0);
    }
  }
  
  private final void c(final com.tencent.mm.plugin.textstatus.g.e.a parama)
  {
    AppMethodBeat.i(235503);
    Object localObject1 = parama.glY().sourceId;
    Object localObject2 = glR();
    boolean bool;
    int i;
    if (localObject2 != null)
    {
      bool = ((i)localObject2).dOW();
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (!kotlin.n.n.ba((CharSequence)localObject1))) {
        break label243;
      }
      i = 1;
      label54:
      if ((i != 0) || (!bool)) {
        break label289;
      }
      localObject1 = glR();
      if ((localObject1 == null) || (((i)localObject1).dDH() != true)) {
        break label289;
      }
      this.MJe.setVisibility(0);
      localObject1 = glR();
      localObject2 = this.MBy;
      if (localObject2 != null)
      {
        ((FrameLayout)localObject2).removeAllViews();
        if (localObject1 != null) {
          ((i)localObject1).f((FrameLayout)localObject2);
        }
      }
      localObject2 = this.MBA;
      if (localObject2 != null)
      {
        localObject1 = glR();
        if (localObject1 == null) {
          break label248;
        }
      }
    }
    label243:
    label248:
    for (localObject1 = ((i)localObject1).dDJ();; localObject1 = null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject1 = this.MBz;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new b(this));
      }
      this.MJf.setOnClickListener((View.OnClickListener)new c(this, parama));
      parama = this.MJe.getLayoutParams();
      if (parama != null) {
        break label254;
      }
      parama = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(235503);
      throw parama;
      bool = true;
      break;
      i = 0;
      break label54;
    }
    label254:
    ((RelativeLayout.LayoutParams)parama).topMargin = (com.tencent.mm.ui.statusbar.d.getStatusBarHeight(this.context) + this.context.getResources().getDimensionPixelSize(b.c.Edge_3A));
    AppMethodBeat.o(235503);
    return;
    label289:
    this.MJe.setVisibility(8);
    AppMethodBeat.o(235503);
  }
  
  private boolean c(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(235507);
    if (this.MJq == null)
    {
      AppMethodBeat.o(235507);
      return false;
    }
    TextStatusTopicInfo localTextStatusTopicInfo = this.MCw;
    if ((localTextStatusTopicInfo == null) || (b.a(localTextStatusTopicInfo, paramTextStatusTopicInfo) != true))
    {
      AppMethodBeat.o(235507);
      return false;
    }
    AppMethodBeat.o(235507);
    return true;
  }
  
  private final void ejp()
  {
    boolean bool = false;
    AppMethodBeat.i(235480);
    if ((com.tencent.mm.q.a.aAo()) || (com.tencent.mm.q.a.r(this.context, false)) || (!this.MJi)) {
      bool = true;
    }
    Object localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).setMute(bool);
        AppMethodBeat.o(235480);
        return;
      }
    }
    AppMethodBeat.o(235480);
  }
  
  private void glS()
  {
    AppMethodBeat.i(235506);
    i locali = this.MJq;
    if (locali != null) {
      locali.onDetach();
    }
    this.MJq = null;
    this.MCw = null;
    AppMethodBeat.o(235506);
  }
  
  private final boolean gmp()
  {
    AppMethodBeat.i(235452);
    Object localObject = this.MJn;
    if ((localObject == null) || (((com.tencent.mm.ui.widget.b)localObject).dDD() != true))
    {
      localObject = this.MCs;
      if ((localObject == null) || (((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_MediaType != 2)) {}
    }
    else
    {
      AppMethodBeat.o(235452);
      return true;
    }
    AppMethodBeat.o(235452);
    return false;
  }
  
  private void gmq()
  {
    AppMethodBeat.i(235494);
    Log.i("MicroMsg.TextStatus.BackPreview", "[destroyVideo]");
    Object localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).stopAsync();
      }
    }
    localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).recycle();
      }
    }
    localObject = this.Bba;
    if (localObject != null) {
      ((MMTPEffectVideoLayout)localObject).MUh.YIy.release();
    }
    this.Bba = null;
    this.MJb.removeAllViews();
    AppMethodBeat.o(235494);
  }
  
  private final void gmr()
  {
    AppMethodBeat.i(235502);
    Object localObject = this.context;
    if ((localObject instanceof MMFragmentActivity))
    {
      localb = this.MJn;
      if (localb != null) {
        localb.b((MMFragmentActivity)localObject);
      }
    }
    localObject = new StringBuilder("destroyThirdBackManual ");
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null) {}
    for (int i = localb.hashCode();; i = 0)
    {
      Log.i("MicroMsg.TextStatus.BackPreview", i);
      localObject = this.MJn;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.b)localObject).onDestroy();
      }
      this.MJn = null;
      this.MJo = null;
      AppMethodBeat.o(235502);
      return;
    }
  }
  
  private boolean gms()
  {
    AppMethodBeat.i(235517);
    Object localObject = this.MCs;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_backgroundId;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
        break label72;
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label77;
      }
      localObject = glR();
      if ((localObject != null) && (((i)localObject).dDH() == true)) {
        break label77;
      }
      AppMethodBeat.o(235517);
      return true;
      localObject = null;
      break;
    }
    label77:
    AppMethodBeat.o(235517);
    return false;
  }
  
  private void gmt()
  {
    AppMethodBeat.i(235519);
    if (!gms())
    {
      com.tencent.mm.plugin.textstatus.g.e.a locala = this.MCs;
      if ((locala == null) || (locala.gma() != true)) {}
    }
    else
    {
      this.MJc.setVisibility(8);
      AppMethodBeat.o(235519);
      return;
    }
    this.MJc.setVisibility(0);
    AppMethodBeat.o(235519);
  }
  
  private void stopVideo()
  {
    AppMethodBeat.i(235497);
    Object localObject = (CharSequence)this.username;
    if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(235497);
      return;
    }
    this.fGh = false;
    localObject = this.Bba;
    if (localObject != null)
    {
      localObject = ((MMTPEffectVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).pause();
      }
    }
    this.MJb.setVisibility(8);
    this.MJa.setVisibility(0);
    gmq();
    gmt();
    AppMethodBeat.o(235497);
  }
  
  public final void KN(String paramString)
  {
    AppMethodBeat.i(235500);
    p.k(paramString, "username");
    this.username = paramString;
    Object localObject1 = this.context;
    if ((localObject1 instanceof Activity)) {
      if (!((Activity)localObject1).isFinishing()) {
        i = 1;
      }
    }
    while (i == 0)
    {
      AppMethodBeat.o(235500);
      return;
      i = 0;
      continue;
      i = 0;
    }
    new n.e(paramString, (com.tencent.mm.plugin.textstatus.a.n)this);
    localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    this.MCs = com.tencent.mm.plugin.textstatus.b.f.bep(paramString);
    Log.i("MicroMsg.TextStatus.BackPreview", "[update TextStatusinfo]:" + this.MCs);
    localObject1 = this.MCs;
    if (localObject1 == null)
    {
      paramString = this.MJh;
      if (paramString != null)
      {
        paramString.fpY();
        AppMethodBeat.o(235500);
        return;
      }
      AppMethodBeat.o(235500);
      return;
    }
    label221:
    Object localObject2;
    if (((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_MediaType == 2)
    {
      com.tencent.mm.plugin.textstatus.f.a.a(com.tencent.mm.plugin.textstatus.f.a.MCH, this.context, paramString, this.MJa);
      paramString = this.MJh;
      if (paramString != null) {
        paramString.fpZ();
      }
      gmt();
      paramString = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).glY();
      if (TextUtils.isEmpty((CharSequence)paramString.sourceId)) {
        break label475;
      }
      if (this.MJn != null) {
        break label444;
      }
      i = 0;
      if (i == 0)
      {
        gmr();
        this.MJd.removeAllViews();
        localObject2 = paramString.sourceId;
        p.j(localObject2, "topicInfo.sourceId");
        this.MJn = F((String)localObject2, (List)paramString.jumpInfos);
        this.MJo = paramString;
        paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
        paramString = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
        if (paramString != null) {
          paramString.MFd = 0L;
        }
      }
      this.MJp = true;
      label306:
      c((com.tencent.mm.plugin.textstatus.g.e.a)localObject1);
      paramString = glR();
      if ((paramString == null) || (paramString.d(this.MJg) != true)) {
        this.MJg.removeAllViews();
      }
      paramString = glR();
      localObject1 = this.MJd;
      if ((paramString == null) || (paramString.dOX()) || (!this.MJp)) {
        break label528;
      }
    }
    label528:
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject1).setVisibility(i);
      paramString = this.MCs;
      if ((paramString == null) || (paramString.field_MediaType != 2)) {
        stopVideo();
      }
      if (this.MEP)
      {
        this.fGh = false;
        Tf();
        this.lzJ = cm.bfE();
      }
      AppMethodBeat.o(235500);
      return;
      com.tencent.mm.plugin.textstatus.f.a.MCH.a(this.context, paramString, this.MJa, false);
      break;
      label444:
      localObject2 = this.MJo;
      if ((localObject2 == null) || (b.a((TextStatusTopicInfo)localObject2, paramString) != true))
      {
        i = 0;
        break label221;
      }
      i = 1;
      break label221;
      label475:
      gmr();
      this.MJd.removeAllViews();
      this.MJp = false;
      paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramString = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
      if (paramString == null) {
        break label306;
      }
      paramString.MFd = 0L;
      paramString.MFe = 0L;
      break label306;
    }
  }
  
  public final void a(g paramg)
  {
    this.MJh = paramg;
  }
  
  public final void abo(int paramInt) {}
  
  public final void abp(int paramInt) {}
  
  public final void abq(int paramInt) {}
  
  public final void dDB()
  {
    AppMethodBeat.i(235462);
    this.MJi = true;
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null) {
      localb.dDB();
    }
    if (this.MJp) {
      this.MJd.setVisibility(0);
    }
    ejp();
    AppMethodBeat.o(235462);
  }
  
  public final void dDC()
  {
    AppMethodBeat.i(235465);
    this.MJi = false;
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null) {
      localb.dDC();
    }
    ejp();
    AppMethodBeat.o(235465);
  }
  
  public final void fqe() {}
  
  public final void fqf() {}
  
  public final View getView()
  {
    AppMethodBeat.i(235476);
    View localView = this.xYC;
    p.j(localView, "back");
    AppMethodBeat.o(235476);
    return localView;
  }
  
  public final void gkD()
  {
    AppMethodBeat.i(235522);
    Object localObject = getView().getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = -1;
    ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.plugin.textstatus.a.a.it(this.context)[1];
    int i = com.tencent.mm.plugin.textstatus.a.a.it(this.context)[1];
    int j = com.tencent.mm.plugin.textstatus.a.a.iu(this.context)[1];
    if (i > j)
    {
      float f = (i - j) / 2.0F;
      localObject = this.xYC;
      p.j(localObject, "back");
      ((View)localObject).setTranslationY(-f);
      this.MJr = (-f);
      this.MJs = i;
    }
    AppMethodBeat.o(235522);
  }
  
  public final void gkE()
  {
    AppMethodBeat.i(235524);
    Log.i("MicroMsg.TextStatus.BackPreview", "[onTabSwitchOut]");
    AppMethodBeat.o(235524);
  }
  
  public final void gkF()
  {
    AppMethodBeat.i(235526);
    Log.i("MicroMsg.TextStatus.BackPreview", "[onTabSwitchIn]");
    AppMethodBeat.o(235526);
  }
  
  public final boolean gkG()
  {
    AppMethodBeat.i(235528);
    boolean bool = b.a(this.username, glR(), this.MCs);
    AppMethodBeat.o(235528);
    return bool;
  }
  
  public final void gkI()
  {
    AppMethodBeat.i(235509);
    Log.i("MicroMsg.TextStatus.BackPreview", "onStatusShowDestroy:%s", new Object[] { Boolean.valueOf(this.MJi) });
    gmq();
    this.MJh = null;
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null)
    {
      localb.onDestroy();
      AppMethodBeat.o(235509);
      return;
    }
    AppMethodBeat.o(235509);
  }
  
  public final void gkJ()
  {
    AppMethodBeat.i(235511);
    Log.i("MicroMsg.TextStatus.BackPreview", "onStatusShowResume:%s", new Object[] { Boolean.valueOf(this.MEP) });
    if (this.MEP) {
      Tf();
    }
    AppMethodBeat.o(235511);
  }
  
  public final void gkK()
  {
    AppMethodBeat.i(235513);
    Log.i("MicroMsg.TextStatus.BackPreview", "onStatusShowPause:%s", new Object[] { Boolean.valueOf(this.MJi) });
    stopVideo();
    AppMethodBeat.o(235513);
  }
  
  public final i glR()
  {
    AppMethodBeat.i(235504);
    Object localObject1 = this.MCs;
    Object localObject2;
    label45:
    i locali;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).glY();
      if (!c((TextStatusTopicInfo)localObject1))
      {
        glS();
        localObject2 = com.tencent.mm.plugin.textstatus.j.d.MIW;
        if (localObject1 == null) {
          break label120;
        }
        localObject2 = c.a((TextStatusTopicInfo)localObject1);
        this.MJq = com.tencent.mm.plugin.textstatus.j.d.beE((String)localObject2);
        locali = this.MJq;
        if (locali != null)
        {
          localObject2 = this.MCs;
          if (localObject2 == null) {
            break label125;
          }
          localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_StatusID;
          label78:
          if (localObject1 == null) {
            break label130;
          }
        }
      }
    }
    label130:
    for (LinkedList localLinkedList = ((TextStatusTopicInfo)localObject1).jumpInfos;; localLinkedList = null)
    {
      locali.s((String)localObject2, (List)localLinkedList);
      this.MCw = ((TextStatusTopicInfo)localObject1);
      localObject1 = this.MJq;
      AppMethodBeat.o(235504);
      return localObject1;
      localObject1 = null;
      break;
      label120:
      localObject2 = null;
      break label45;
      label125:
      localObject2 = null;
      break label78;
    }
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(235460);
    Log.i("MicroMsg.TextStatus.BackPreview", "[onPostClose]");
    long l1 = cm.bfE();
    long l2 = this.MBJ;
    if (!this.MEP) {
      stopVideo();
    }
    Object localObject1 = this.MJn;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
      if (localObject2 != null) {
        if (!this.MEP) {
          break label189;
        }
      }
    }
    label189:
    for (((com.tencent.mm.plugin.textstatus.proto.f)localObject2).MFd = (cm.bfE() - this.lzJ);; ((com.tencent.mm.plugin.textstatus.proto.f)localObject2).MFd = (l1 - l2 + ((com.tencent.mm.plugin.textstatus.proto.f)localObject2).MFd))
    {
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject2).MFe = ((com.tencent.mm.ui.widget.b)localObject1).ejq();
      localObject1 = this.MJn;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.b)localObject1).onPostClose();
      }
      if ((gmp()) && (this.MJj)) {
        com.tencent.mm.bb.a.bnu();
      }
      localObject1 = glR();
      if ((localObject1 != null) && (((i)localObject1).dOX() == true)) {
        this.MJd.setVisibility(8);
      }
      localObject1 = this.MCs;
      if (localObject1 == null) {
        break;
      }
      c((com.tencent.mm.plugin.textstatus.g.e.a)localObject1);
      AppMethodBeat.o(235460);
      return;
    }
    AppMethodBeat.o(235460);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(235455);
    Log.i("MicroMsg.TextStatus.BackPreview", "[onPostOpen]");
    this.MBJ = cm.bfE();
    if (gmp())
    {
      this.MJj = com.tencent.mm.bb.a.bnx();
      if (this.MJj) {
        com.tencent.mm.bb.a.bnt();
      }
    }
    Tf();
    com.tencent.mm.ui.widget.b localb = this.MJn;
    if (localb != null) {
      localb.dDE();
    }
    if (this.MJp) {
      this.MJd.setVisibility(0);
    }
    if (this.MEP)
    {
      localb = this.MJn;
      if (localb != null)
      {
        Object localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFd = (cm.bfE() - this.lzJ);
          ((com.tencent.mm.plugin.textstatus.proto.f)localObject).MFe = localb.ejq();
          AppMethodBeat.o(235455);
          return;
        }
        AppMethodBeat.o(235455);
        return;
      }
    }
    AppMethodBeat.o(235455);
  }
  
  public final void r(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(235515);
    this.MJc.setAlpha(0.3F * (1.0F - paramFloat1));
    View localView;
    if (paramFloat3 >= paramFloat2)
    {
      localView = this.xYC;
      p.j(localView, "back");
      localView.setTranslationY((1.0F - paramFloat1) * this.MJr);
    }
    for (;;)
    {
      this.MJe.setAlpha(paramFloat1);
      this.MJe.setScaleY(paramFloat1);
      AppMethodBeat.o(235515);
      return;
      localView = this.xYC;
      p.j(localView, "back");
      localView.setTranslationY(paramFloat2 - paramFloat3);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237335);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/BackPreview$handlePreviewHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.MJu.glR();
      if (paramView != null) {
        paramView.fA(this.MJu.context);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/BackPreview$handlePreviewHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237335);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama, com.tencent.mm.plugin.textstatus.g.e.a parama1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237231);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/BackPreview$handlePreviewHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = this.MJu.FSj;
      if (paramView != null) {
        paramView.run();
      }
      Object localObject2 = parama.glY();
      paramView = com.tencent.mm.plugin.textstatus.d.a.MBv;
      paramView = this.MJu.context;
      localObject1 = this.MJu.glR();
      localObject2 = ((TextStatusTopicInfo)localObject2).jumpInfos;
      p.j(localObject2, "topicInfo.jumpInfos");
      localObject2 = (List)localObject2;
      p.k(paramView, "context");
      p.k(localObject2, "jumpInfos");
      boolean bool = false;
      if (localObject1 != null) {
        bool = ((i)localObject1).iv(paramView);
      }
      com.tencent.mm.plugin.textstatus.d.a.a(paramView, bool, (List)localObject2);
      paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      com.tencent.mm.plugin.textstatus.h.a.a(this.MJu.context, 62L, null, null, 12);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/BackPreview$handlePreviewHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237231);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.a
 * JD-Core Version:    0.7.0.1
 */