package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.q;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.emoji.panel.layout.a.d;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.upload.r;
import com.tencent.mm.plugin.music.model.l;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.model.a.m;
import com.tencent.mm.plugin.mv.model.a.n;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.plugin.mv.model.q;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.thumbplayer.c.b.c;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dsc;
import com.tencent.mm.protocal.protobuf.dsg;
import com.tencent.mm.protocal.protobuf.dsi;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.layoutmanager.Flip3DLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAGLyric", "getTAGLyric", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "checkPermissionFlag", "", "getCheckPermissionFlag", "()Z", "setCheckPermissionFlag", "(Z)V", "currentPos", "", "getCurrentPos", "()I", "setCurrentPos", "(I)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "downY", "", "finderCommentEventListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderCommentEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderCommentEventListener$1;", "finderPostListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getFinderPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getBeatTrackFlag", "getGetBeatTrackFlag", "setGetBeatTrackFlag", "getRecMvListFlag", "getGetRecMvListFlag", "setGetRecMvListFlag", "getRecommendedListFlag", "getGetRecommendedListFlag", "setGetRecommendedListFlag", "isDoPlayMusic", "isDragChangePaged", "isJumpToApp", "lastAction", "lastActionTime", "", "lastPos", "getLastPos", "setLastPos", "layoutManager", "Lcom/tencent/mm/view/layoutmanager/Flip3DLayoutManager;", "musicListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicListener", "()Lcom/tencent/mm/sdk/event/IListener;", "needResumePosition", "onPageSelectedListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageSelectedListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageSelectedListener$1;", "onPageStartChangeListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageStartChangeListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageStartChangeListener$1;", "onSceneEndListener", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "getSnapHelper", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "statRecord", "Lcom/tencent/mm/plugin/mv/model/StatRecord;", "getStatRecord", "()Lcom/tencent/mm/plugin/mv/model/StatRecord;", "setStatRecord", "(Lcom/tencent/mm/plugin/mv/model/StatRecord;)V", "topPanelMargin", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;)V", "waitDetailDataList", "getWaitDetailDataList", "setWaitDetailDataList", "checkRecycleViewSafeTouch", "e", "Landroid/view/MotionEvent;", "checkVideoLayout", "", "deleteMv", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "doJumpToApp", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "callback", "Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;", "enableMvListScroll", "enable", "fillMusicMvData", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getMVList", "getMusicMv", "objectId", "nonceId", "getMusicNewUrl", "appId", "mid", "getMvDetailInfo", "mvObjectId", "mvNonceId", "getSongDetailInfo", "getTicketToQQMusic", "getUniInfo", "handleGetCommentDetailResponse", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "musicMvHashCode", "handleGetMvRecommendListResponse", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onMusicPause", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onStop", "recordStat", "position", "mv", "refreshFrame", "refreshVideo", "reportLastMvExit", "reportStat", "dataUIC", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDataUIC;", "scrollMvToPosition", "switchToMv", "syncBeatTrack", "syncPostPermission", "updateFloatBallMvInfo", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends UIComponent
{
  public static final i.a MeI;
  private static final Object Mfa;
  WxRecyclerView AZd;
  int Ahg;
  private int EsN;
  private long IGe;
  private final com.tencent.mm.plugin.music.e.a.d.a LJz;
  private final com.tencent.mm.am.h LYH;
  MultiMediaEffectVideoLayout Mci;
  private boolean Mcl;
  private final String MdT;
  private ArrayList<com.tencent.mm.plugin.mv.ui.a.b> MeJ;
  final com.tencent.mm.emoji.panel.layout.a MeK;
  private boolean MeL;
  private boolean MeM;
  Flip3DLayoutManager MeN;
  private boolean MeO;
  private boolean MeP;
  volatile q MeQ;
  private boolean MeR;
  private int MeS;
  private final i.i MeT;
  private final i.j MeU;
  private final IListener<ox> MeV;
  private boolean MeW;
  private boolean MeX;
  private final r MeY;
  private final MusicMvMainUIC.finderCommentEventListener.1 MeZ;
  final String TAG;
  int bVs;
  private float fig;
  ArrayList<com.tencent.mm.plugin.mv.ui.a.b> pUj;
  private final kotlin.j xZP;
  
  static
  {
    AppMethodBeat.i(288063);
    MeI = new i.a((byte)0);
    Mfa = new Object();
    AppMethodBeat.o(288063);
  }
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287723);
    this.TAG = "MicroMsg.Mv.MusicMvMainUIC";
    this.MdT = "MicroMsg.Mv.GetLyric";
    this.pUj = new ArrayList();
    this.MeJ = new ArrayList();
    this.xZP = kotlin.k.cm((kotlin.g.a.a)new i.b(this, paramAppCompatActivity));
    this.LJz = new i..ExternalSyntheticLambda1(this);
    this.MeK = new com.tencent.mm.emoji.panel.layout.a();
    this.Ahg = -1;
    this.MeN = new Flip3DLayoutManager((Context)paramAppCompatActivity);
    this.IGe = -1L;
    this.fig = -1.0F;
    this.MeS = -1;
    this.MeT = new i.i(this);
    this.MeU = new i.j(this);
    this.MeV = ((IListener)new MusicMvMainUIC.musicListener.1(paramAppCompatActivity, this, com.tencent.mm.app.f.hfK));
    this.LYH = new i..ExternalSyntheticLambda0(paramAppCompatActivity, this);
    this.MeY = ((r)new i.d(this, paramAppCompatActivity));
    this.MeZ = new MusicMvMainUIC.finderCommentEventListener.1(paramAppCompatActivity, this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(287723);
  }
  
  private static final void a(AppCompatActivity paramAppCompatActivity, i parami, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(287998);
    kotlin.g.b.s.u(paramAppCompatActivity, "$activity");
    kotlin.g.b.s.u(parami, "this$0");
    if (((paramp instanceof com.tencent.mm.plugin.mv.model.a.a)) && (((com.tencent.mm.plugin.mv.model.a.a)paramp).LYA != 0) && (((com.tencent.mm.plugin.mv.model.a.a)paramp).LYA != paramAppCompatActivity.hashCode()))
    {
      Log.i(parami.TAG, "not the same page of netscene");
      AppMethodBeat.o(287998);
      return;
    }
    paramString = com.tencent.mm.ui.component.k.aeZF;
    paramString = com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(e.class);
    kotlin.g.b.s.s(paramString, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    Object localObject1 = (e)paramString;
    if ((paramp instanceof n))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramAppCompatActivity = ((n)paramp).LXH;
        if (paramAppCompatActivity != null)
        {
          parami.a(paramAppCompatActivity);
          paramAppCompatActivity = ah.aiuX;
          paramAppCompatActivity = ah.aiuX;
        }
      }
      parami.MeP = true;
      AppMethodBeat.o(287998);
      return;
    }
    label238:
    label242:
    Object localObject2;
    label294:
    label298:
    label350:
    label354:
    label997:
    label1003:
    label1008:
    label1013:
    label1021:
    int i;
    if ((paramp instanceof com.tencent.mm.plugin.mv.model.a.o))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = ((com.tencent.mm.plugin.mv.model.a.o)paramp).LZo;
        if (paramp != null)
        {
          paramString = paramp.Mcq;
          if (paramString != null)
          {
            if (((CharSequence)paramString).length() <= 0) {
              break label932;
            }
            paramInt1 = 1;
            if ((paramInt1 == 0) || (!TextUtils.isEmpty((CharSequence)((e)localObject1).LWI.Mcq))) {
              break label937;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label942;
            }
            if (paramString != null)
            {
              ((e)localObject1).LWI.Mcq = paramString;
              paramString = ah.aiuX;
              paramString = ah.aiuX;
            }
          }
          paramString = paramp.ZTy;
          if (paramString != null)
          {
            if (((CharSequence)paramString).length() <= 0) {
              break label948;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label953;
            }
            if (paramString != null)
            {
              ((e)localObject1).LWI.albumName = paramString;
              paramString = ah.aiuX;
              paramString = ah.aiuX;
            }
          }
          paramString = paramp.aaYr;
          if (paramString != null)
          {
            if (((CharSequence)paramString).length() <= 0) {
              break label959;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label964;
            }
            if (paramString != null)
            {
              ((e)localObject1).LWI.ZWS = paramString;
              paramString = ah.aiuX;
              paramString = ah.aiuX;
            }
          }
          paramString = paramp.ZTA;
          if (paramString != null)
          {
            if (((CharSequence)paramString).length() <= 0) {
              break label970;
            }
            paramInt1 = 1;
            label406:
            if (paramInt1 == 0) {
              break label975;
            }
            label410:
            if (paramString != null)
            {
              ((e)localObject1).LWI.ZTA = paramString;
              paramString = ah.aiuX;
              paramString = ah.aiuX;
            }
          }
          paramString = Long.valueOf(paramp.aaYs);
          if (((Number)paramString).longValue() <= 0L) {
            break label981;
          }
          paramInt1 = 1;
          label460:
          if (paramInt1 == 0) {
            break label986;
          }
          label464:
          if (paramString != null)
          {
            long l = ((Number)paramString).longValue();
            ((e)localObject1).LWI.ZWU = l;
            paramString = ah.aiuX;
            paramString = ah.aiuX;
          }
          paramString = paramp.ZWV;
          if (paramString != null)
          {
            if (((CharSequence)paramString).length() <= 0) {
              break label992;
            }
            paramInt1 = 1;
            label526:
            if (paramInt1 == 0) {
              break label997;
            }
            label530:
            if (paramString != null)
            {
              ((e)localObject1).LWI.ZWV = paramString;
              paramString = ah.aiuX;
              paramString = ah.aiuX;
            }
          }
          paramString = paramp.aaYt;
          if ((paramString != null) && (paramString != null))
          {
            ((e)localObject1).Meb = paramString;
            paramString = ah.aiuX;
            paramString = ah.aiuX;
          }
          paramString = parami.TAG;
          localObject2 = com.tencent.mm.plugin.mv.ui.a.Maz;
          Log.v(paramString, "getSongStatus %s", new Object[] { com.tencent.mm.plugin.mv.ui.a.b(((e)localObject1).LWI) });
          Log.i(parami.MdT, kotlin.g.b.s.X("get lyric from SongStatus ", paramp.Mcq));
          ((e)localObject1).gqD();
          parami = com.tencent.mm.ui.component.k.aeZF;
          ((h)com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(h.class)).a(((e)localObject1).LWI, ((e)localObject1).LOA);
          parami = ((e)localObject1).Meb;
          if ((parami == null) || (parami.vhJ != 2)) {
            break label1003;
          }
          paramInt1 = 1;
          label696:
          if (paramInt1 != 0)
          {
            parami = ((e)localObject1).Meb;
            if (parami != null)
            {
              parami = parami.acjs;
              if (parami != null)
              {
                paramString = com.tencent.mm.plugin.ringtone.g.d.ODu;
                paramString = ((e)localObject1).Meb;
                kotlin.g.b.s.checkNotNull(paramString);
                ((e)localObject1).Mec = com.tencent.mm.plugin.ringtone.g.d.a.a(parami, paramString);
                parami = ((e)localObject1).Mec;
                if (parami != null) {
                  parami.ODy = ((e)localObject1).Meb;
                }
              }
            }
            ((e)localObject1).Med = true;
          }
          parami = ((e)localObject1).Meb;
          if ((parami == null) || (parami.vhJ != 1)) {
            break label1008;
          }
          paramInt1 = 1;
          label792:
          if (paramInt1 != 0)
          {
            parami = ((e)localObject1).Meb;
            if (parami != null) {
              break label1013;
            }
            parami = null;
            label808:
            paramString = ((e)localObject1).Meb;
            if ((parami != null) && (paramString != null))
            {
              localObject2 = com.tencent.mm.plugin.ringtone.g.d.ODu;
              ((e)localObject1).Mec = com.tencent.mm.plugin.ringtone.g.d.a.a(0L, parami.acjm, paramString, null);
              parami = ((e)localObject1).Mec;
              if (parami != null) {
                parami.ODy = paramString;
              }
            }
            ((e)localObject1).Med = true;
            parami = ((e)localObject1).Meb;
            if (parami != null) {
              break label1021;
            }
            paramInt1 = 0;
          }
        }
        for (;;)
        {
          ((e)localObject1).Mee = paramInt1;
          com.tencent.threadpool.h.ahAA.bm(new i..ExternalSyntheticLambda2(paramAppCompatActivity, paramp));
          parami = com.tencent.mm.plugin.mv.model.o.LYk;
          com.tencent.mm.plugin.mv.model.o.a((Context)paramAppCompatActivity, ((e)localObject1).LWI, ((e)localObject1).MdW);
          AppMethodBeat.o(287998);
          return;
          label932:
          paramInt1 = 0;
          break;
          label937:
          paramInt1 = 0;
          break label238;
          label942:
          paramString = null;
          break label242;
          label948:
          paramInt1 = 0;
          break label294;
          label953:
          paramString = null;
          break label298;
          label959:
          paramInt1 = 0;
          break label350;
          label964:
          paramString = null;
          break label354;
          label970:
          paramInt1 = 0;
          break label406;
          label975:
          paramString = null;
          break label410;
          label981:
          paramInt1 = 0;
          break label460;
          label986:
          paramString = null;
          break label464;
          label992:
          paramInt1 = 0;
          break label526;
          paramString = null;
          break label530;
          paramInt1 = 0;
          break label696;
          paramInt1 = 0;
          break label792;
          parami = parami.acjr;
          break label808;
          parami = parami.acjr;
          if (parami == null) {
            paramInt1 = 0;
          } else {
            paramInt1 = (int)parami.acjo;
          }
        }
      }
    }
    else
    {
      if ((paramp instanceof com.tencent.mm.plugin.mv.model.a.k))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramAppCompatActivity = ((com.tencent.mm.plugin.mv.model.a.k)paramp).LWS;
          if (paramAppCompatActivity != null)
          {
            parami.a(paramAppCompatActivity, ((com.tencent.mm.plugin.mv.model.a.k)paramp).LZe);
            paramAppCompatActivity = ah.aiuX;
            paramAppCompatActivity = ah.aiuX;
          }
          AppMethodBeat.o(287998);
          return;
        }
        paramAppCompatActivity = ((Iterable)parami.pUj).iterator();
        paramInt1 = 0;
        while (paramAppCompatActivity.hasNext())
        {
          paramString = paramAppCompatActivity.next();
          if (paramInt1 < 0) {
            kotlin.a.p.kkW();
          }
          paramString = (com.tencent.mm.plugin.mv.ui.a.b)paramString;
          if (paramString.MaX.hashCode() == ((com.tencent.mm.plugin.mv.model.a.k)paramp).LZe)
          {
            localObject1 = com.tencent.mm.plugin.mv.model.f.LXf;
            localObject1 = paramString.MaX;
            kotlin.g.b.s.u(localObject1, "mv");
            ((com.tencent.mm.plugin.mv.model.f)localObject1).AcH = true;
            ((com.tencent.mm.plugin.mv.model.f)localObject1).LXp = null;
            ((com.tencent.mm.plugin.mv.model.f)localObject1).LXo = null;
            ((com.tencent.mm.plugin.mv.model.f)localObject1).LXm.clear();
            ((com.tencent.mm.plugin.mv.model.f)localObject1).likeCount = 0;
            ((com.tencent.mm.plugin.mv.model.f)localObject1).forwardCount = 0;
            ((com.tencent.mm.plugin.mv.model.f)localObject1).commentCount = 0;
            ((com.tencent.mm.plugin.mv.model.f)localObject1).LXq = false;
            ((com.tencent.mm.plugin.mv.model.f)localObject1).LXt = null;
            ((com.tencent.mm.plugin.mv.model.f)localObject1).LXv = null;
            ((com.tencent.mm.plugin.mv.model.f)localObject1).LXw.clear();
            Log.i(parami.TAG, kotlin.g.b.s.X("notifyItemChanged5:", Integer.valueOf(paramInt1)));
            parami.getAdapter().t(paramInt1, "NetSceneMusicMvGetFinderFeedDetail_fail");
            parami.l(paramString.MaX);
          }
          paramInt1 += 1;
        }
        AppMethodBeat.o(287998);
        return;
      }
      if ((paramp instanceof com.tencent.mm.plugin.mv.model.a.h))
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label3110;
        }
        parami.MeO = true;
        paramString = parami.TAG;
        localObject2 = new StringBuilder("onSceneEnd MusicLiveGetBeatTrack songId:").append(((com.tencent.mm.plugin.mv.model.a.h)paramp).LWI.mLQ).append(" trackPoint:");
        paramAppCompatActivity = ((com.tencent.mm.plugin.mv.model.a.h)paramp).LYY;
        if (paramAppCompatActivity == null)
        {
          paramAppCompatActivity = null;
          localObject2 = ((StringBuilder)localObject2).append(paramAppCompatActivity).append(" flexSize:");
          paramAppCompatActivity = ((com.tencent.mm.plugin.mv.model.a.h)paramp).LYY;
          if (paramAppCompatActivity != null) {
            break label1700;
          }
          paramAppCompatActivity = null;
          label1410:
          Log.i(paramString, paramAppCompatActivity);
          i = ((com.tencent.mm.plugin.mv.model.a.h)paramp).LYV;
          paramString = ((com.tencent.mm.plugin.mv.model.a.h)paramp).LYY;
          if (paramString == null) {
            break label1864;
          }
          ((e)localObject1).Mea = paramString.aaYd.size();
          paramAppCompatActivity = ((Iterable)parami.pUj).iterator();
          paramInt1 = 0;
          label1477:
          if (!paramAppCompatActivity.hasNext()) {
            break label3117;
          }
          localObject1 = paramAppCompatActivity.next();
          if (paramInt1 < 0) {
            kotlin.a.p.kkW();
          }
          localObject1 = (com.tencent.mm.plugin.mv.ui.a.b)localObject1;
          if (((com.tencent.mm.plugin.mv.ui.a.b)localObject1).MaX.hashCode() != ((com.tencent.mm.plugin.mv.model.a.h)paramp).LYW) {
            break label1725;
          }
          paramAppCompatActivity = ((com.tencent.mm.plugin.mv.ui.a.b)localObject1).MaX;
        }
      }
    }
    for (;;)
    {
      paramp = ah.aiuX;
      if (paramAppCompatActivity != null)
      {
        if ((paramInt1 >= 0) && (paramAppCompatActivity.LXm.isEmpty()))
        {
          paramInt2 = 1;
          label1558:
          if (paramInt2 == 0) {
            break label1737;
          }
        }
        for (;;)
        {
          label1562:
          if (paramAppCompatActivity != null)
          {
            paramInt2 = 0;
            paramString = paramString.aaYc;
            kotlin.g.b.s.s(paramString, "beatTrackResponse.break_point_ms");
            paramString = ((Iterable)paramString).iterator();
            for (;;)
            {
              if (paramString.hasNext())
              {
                paramp = (Integer)paramString.next();
                localObject1 = new boq();
                ((boq)localObject1).refObjectId = 0L;
                ((boq)localObject1).ZWZ = "";
                ((boq)localObject1).TBM = paramInt2;
                ((boq)localObject1).ZWY = (paramp.intValue() - paramInt2);
                ((boq)localObject1).TBO = 0L;
                paramAppCompatActivity.LXm.add(localObject1);
                kotlin.g.b.s.s(paramp, "point");
                paramInt2 = paramp.intValue();
                continue;
                paramAppCompatActivity = paramAppCompatActivity.aaYc;
                break;
                label1700:
                paramAppCompatActivity = paramAppCompatActivity.aaYd;
                if (paramAppCompatActivity == null)
                {
                  paramAppCompatActivity = null;
                  break label1410;
                }
                paramAppCompatActivity = Integer.valueOf(paramAppCompatActivity.size());
                break label1410;
                label1725:
                paramInt1 += 1;
                break label1477;
                paramInt2 = 0;
                break label1558;
                label1737:
                paramAppCompatActivity = null;
                break label1562;
              }
            }
            if (paramInt2 < i)
            {
              paramString = new boq();
              paramString.refObjectId = 0L;
              paramString.ZWZ = "";
              paramString.TBM = paramInt2;
              paramString.ZWY = (i - paramInt2);
              paramString.TBO = 0L;
              paramAppCompatActivity.LXm.add(paramString);
            }
            paramAppCompatActivity = ah.aiuX;
            paramAppCompatActivity = ah.aiuX;
          }
        }
      }
      if (parami.MeP)
      {
        Log.i(parami.TAG, "get beat track notify");
        Log.i(parami.TAG, kotlin.g.b.s.X("notifyItemChanged6:", Integer.valueOf(paramInt1)));
        parami.getAdapter().t(paramInt1, "NetSceneMusicMvGetBeatTrack");
      }
      paramAppCompatActivity = ah.aiuX;
      paramAppCompatActivity = ah.aiuX;
      label1864:
      AppMethodBeat.o(287998);
      return;
      if ((paramp instanceof com.tencent.mm.plugin.mv.model.a.f))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramp = ((com.tencent.mm.plugin.mv.model.a.f)paramp).LYP;
          if (paramp != null)
          {
            ((e)localObject1).MdX = paramp.aaXX;
            ((e)localObject1).LWI.mLQ = paramp.aaXV;
            ((e)localObject1).verifyInfo = paramp.EdM;
            paramString = paramp.Meg;
            paramAppCompatActivity = paramString;
            if (paramString == null) {
              paramAppCompatActivity = "";
            }
            kotlin.g.b.s.u(paramAppCompatActivity, "<set-?>");
            ((e)localObject1).Meg = paramAppCompatActivity;
            paramString = paramp.Meh;
            paramAppCompatActivity = paramString;
            if (paramString == null) {
              paramAppCompatActivity = "";
            }
            kotlin.g.b.s.u(paramAppCompatActivity, "<set-?>");
            ((e)localObject1).Meh = paramAppCompatActivity;
            parami.MeW = true;
            parami.gqN();
            Log.i(parami.TAG, "NetSceneMusicMvCheckPermission songId:" + paramp.aaXV + " mvPostPermissionBit:" + paramp.aaXX + " statusVerifyInfo:" + paramp.EdM);
            paramAppCompatActivity = ah.aiuX;
            paramAppCompatActivity = ah.aiuX;
          }
          AppMethodBeat.o(287998);
        }
      }
      else if ((paramp instanceof bt))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i(parami.TAG, "ret delete mv finished");
          if (parami.Ahg < parami.pUj.size())
          {
            paramAppCompatActivity = com.tencent.mm.plugin.mv.model.f.LXf;
            f.a.a(((com.tencent.mm.plugin.mv.ui.a.b)parami.pUj.get(parami.Ahg)).MaX);
            ((com.tencent.mm.plugin.mv.ui.a.b)parami.pUj.get(parami.Ahg)).MaX.AcH = true;
            com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(0);
            parami.getAdapter().e(parami.Ahg, 1, "NetSceneDeleteFinderObject");
            AppMethodBeat.o(287998);
          }
        }
      }
      else if ((paramp instanceof m))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i(parami.TAG, "get ticket");
          if ((paramp instanceof m))
          {
            paramString = (m)paramp;
            if (paramString != null) {
              break label2411;
            }
            paramString = null;
            label2248:
            paramp = com.tencent.mm.plugin.music.model.c.LLZ;
            com.tencent.mm.plugin.music.model.c.zK(true);
            paramp = l.LMH;
            paramp = (Context)parami.getContext();
            localObject1 = com.tencent.mm.aw.a.bLn();
            kotlin.g.b.s.s(localObject1, "getMusicWrapper()");
            l.a(paramp, paramString, (com.tencent.mm.aw.f)localObject1);
            paramString = com.tencent.mm.ui.component.k.aeZF;
            paramAppCompatActivity = com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(t.class);
            kotlin.g.b.s.s(paramAppCompatActivity, "UICProvider.of(activity)…vSongInfoUIC::class.java)");
            paramString = (t)paramAppCompatActivity;
            paramAppCompatActivity = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.p.ae((List)parami.pUj, parami.Ahg);
            if (paramAppCompatActivity != null) {
              break label2439;
            }
            paramAppCompatActivity = null;
            label2346:
            paramp = paramString.LWI;
            if ((paramp != null) && (paramAppCompatActivity != null)) {
              if (!paramString.MgY) {
                break label2447;
              }
            }
          }
          label2439:
          label2447:
          for (paramInt1 = 1;; paramInt1 = 2)
          {
            paramString = com.tencent.mm.plugin.mv.model.o.LYk;
            com.tencent.mm.plugin.mv.model.o.a((Context)parami.getContext(), paramp, paramAppCompatActivity, 4, 0, 1, paramInt1);
            paramAppCompatActivity = ah.aiuX;
            AppMethodBeat.o(287998);
            return;
            paramString = null;
            break;
            label2411:
            paramString = paramString.LZl;
            if (paramString == null)
            {
              paramString = null;
              break label2248;
            }
            paramString = paramString.token;
            break label2248;
            paramAppCompatActivity = paramAppCompatActivity.MaX;
            break label2346;
          }
        }
      }
      else if ((paramp instanceof com.tencent.mm.plugin.mv.model.a.e))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject2 = com.tencent.mm.aw.a.bLn();
          paramString = ((com.tencent.mm.plugin.mv.model.a.e)paramp).oDw;
          dsp localdsp;
          if (paramString != null)
          {
            paramString = c.c.b(paramString.otC);
            if (paramString != null)
            {
              paramString = ((dso)paramString).ToF;
              paramp = com.tencent.mm.ui.component.k.aeZF;
              paramp = com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(t.class);
              kotlin.g.b.s.s(paramp, "UICProvider.of(activity)…vSongInfoUIC::class.java)");
              paramp = (t)paramp;
              localObject1 = com.tencent.mm.ui.component.k.aeZF;
              localObject1 = com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(e.class);
              kotlin.g.b.s.s(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
              localObject1 = (e)localObject1;
              if (paramString != null)
              {
                localdsp = (dsp)paramString.get(0);
                if (localdsp != null)
                {
                  if (localdsp.ret != 0) {
                    break label2919;
                  }
                  if (localdsp.aaYh != null) {
                    break label2655;
                  }
                  paramAppCompatActivity = null;
                  if (paramAppCompatActivity == null)
                  {
                    Log.e(parami.TAG, "linkInfo.info is null");
                    paramAppCompatActivity = ah.aiuX;
                  }
                }
              }
            }
          }
          for (;;)
          {
            paramAppCompatActivity = ah.aiuX;
            paramAppCompatActivity = ah.aiuX;
            AppMethodBeat.o(287998);
            return;
            paramString = null;
            break;
            label2655:
            if ((localdsp.aaYi == 1) && (paramp.MgY))
            {
              com.tencent.mm.plugin.music.model.a.b localb = com.tencent.mm.plugin.music.model.a.b.LMO;
              com.tencent.mm.plugin.music.model.a.b.bG(paramString);
              ((e)localObject1).LWI.Mcq = localdsp.Mcq;
              ((com.tencent.mm.aw.f)localObject2).playUrl = localdsp.url;
              com.tencent.mm.aw.a.c((com.tencent.mm.aw.f)localObject2);
              paramString = paramp.MgW;
              if (paramString != null) {
                break label2875;
              }
              paramString = null;
              if (paramString != null) {
                paramString.setVisibility(8);
              }
              paramString = paramp.MgW;
              if (paramString != null) {
                break label2885;
              }
              paramString = null;
              if (!(paramString instanceof LinearLayout.LayoutParams)) {
                break label2913;
              }
            }
            label2725:
            label2752:
            label2885:
            label2913:
            for (paramString = (LinearLayout.LayoutParams)paramString;; paramString = null)
            {
              if (paramString != null) {
                paramString.bottomMargin = com.tencent.mm.cd.a.fromDPToPix((Context)parami.getContext(), 36);
              }
              ((e)localObject1).gqD();
              paramString = com.tencent.mm.ui.component.k.aeZF;
              ((h)com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(h.class)).a(((e)localObject1).LWI, ((e)localObject1).LOA);
              paramAppCompatActivity = paramp.uJh;
              if (paramAppCompatActivity != null)
              {
                paramAppCompatActivity.findViewById(b.e.LUK).setVisibility(0);
                paramAppCompatActivity.findViewById(b.e.LUV).setVisibility(8);
              }
              paramp.MgY = false;
              paramAppCompatActivity = ah.aiuX;
              paramAppCompatActivity = ah.aiuX;
              break;
              paramString = paramString.gsc();
              break label2725;
              paramString = paramString.gsb();
              if (paramString == null)
              {
                paramString = null;
                break label2752;
              }
              paramString = paramString.getLayoutParams();
              break label2752;
            }
            label2875:
            label2919:
            Log.e(parami.TAG, "errCode:" + localdsp.ret + ", errMsg:" + localdsp.hNw);
          }
        }
      }
      else if (((paramp instanceof com.tencent.mm.plugin.mv.model.a.d)) && (paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = c.c.b(((com.tencent.mm.plugin.mv.model.a.d)paramp).oDw.otC);
        if (paramString == null)
        {
          paramAppCompatActivity = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.MusicLiveGetInteractionInfoResp");
          AppMethodBeat.o(287998);
          throw paramAppCompatActivity;
        }
        paramString = (dsi)paramString;
        paramp = com.tencent.mm.ui.component.k.aeZF;
        paramAppCompatActivity = com.tencent.mm.ui.component.k.d(paramAppCompatActivity).q(e.class);
        kotlin.g.b.s.s(paramAppCompatActivity, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        paramAppCompatActivity = (e)paramAppCompatActivity;
        paramAppCompatActivity.likeCount = paramString.HWO;
        paramAppCompatActivity.commentCount = paramString.YES;
        paramAppCompatActivity.forwardCount = paramString.aaYe;
        paramAppCompatActivity.Mei = paramString.aaYf;
        paramAppCompatActivity = ah.aiuX;
        paramAppCompatActivity = ah.aiuX;
        parami.getAdapter().t(0, "UniComponent");
      }
      label3110:
      AppMethodBeat.o(287998);
      return;
      label3117:
      paramAppCompatActivity = null;
      paramInt1 = -1;
    }
  }
  
  private static final void a(AppCompatActivity paramAppCompatActivity, dst paramdst)
  {
    AppMethodBeat.i(287922);
    kotlin.g.b.s.u(paramAppCompatActivity, "$activity");
    kotlin.g.b.s.u(paramdst, "$resp");
    l locall = l.LMH;
    paramAppCompatActivity = l.bb((Activity)paramAppCompatActivity);
    if (paramAppCompatActivity != null) {
      com.tencent.mm.plugin.music.model.o.god().b(paramAppCompatActivity.field_musicId, paramAppCompatActivity.field_songAlbum, paramdst.aaYr, paramdst.Mcq, false, false);
    }
    AppMethodBeat.o(287922);
  }
  
  private final void a(e parame)
  {
    AppMethodBeat.i(287746);
    q localq = this.MeQ;
    if (localq != null)
    {
      com.tencent.mm.plugin.mv.ui.a.b localb = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.p.ae((List)this.pUj, this.Ahg);
      if (localb != null)
      {
        com.tencent.mm.plugin.mv.model.o localo = com.tencent.mm.plugin.mv.model.o.LYk;
        com.tencent.mm.plugin.mv.model.o.a((Context)getContext(), parame.LWI, localb.MaX, localq);
      }
    }
    AppMethodBeat.o(287746);
  }
  
  private static final void a(i parami)
  {
    AppMethodBeat.i(287832);
    kotlin.g.b.s.u(parami, "this$0");
    parami.MeK.a((RecyclerView)parami.AZd);
    AppMethodBeat.o(287832);
  }
  
  private static final void a(i parami, int paramInt)
  {
    AppMethodBeat.i(287841);
    kotlin.g.b.s.u(parami, "this$0");
    Log.i(parami.TAG, "post smooth scroll");
    parami = parami.AZd;
    if (parami != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(parami, locala.aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition$lambda-16$lambda-15", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      parami.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(parami, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition$lambda-16$lambda-15", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    AppMethodBeat.o(287841);
  }
  
  private static final void a(i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287825);
    kotlin.g.b.s.u(parami, "this$0");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i.k(paramInt1, paramInt2, parami));
    AppMethodBeat.o(287825);
  }
  
  private static final void a(i parami, ayl paramayl, com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(287908);
    kotlin.g.b.s.u(parami, "this$0");
    kotlin.g.b.s.u(paramayl, "$cache");
    kotlin.g.b.s.u(paramf, "$musicMv");
    parami.a(paramayl, paramf.hashCode());
    AppMethodBeat.o(287908);
  }
  
  private final void a(ayl paramayl, int paramInt)
  {
    AppMethodBeat.i(287820);
    Log.i(this.TAG, "handleGetCommentDetailResponse");
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(e.class);
    kotlin.g.b.s.s(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    Object localObject2 = (e)localObject1;
    localObject1 = ((Iterable)this.pUj).iterator();
    int j = 0;
    int i = 0;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (((Iterator)localObject1).hasNext())
    {
      localObject3 = ((Iterator)localObject1).next();
      if (j < 0) {
        kotlin.a.p.kkW();
      }
      localObject3 = (com.tencent.mm.plugin.mv.ui.a.b)localObject3;
      if (((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX.hashCode() != paramInt) {
        break label923;
      }
      localObject4 = paramayl.ZJp;
      kotlin.g.b.s.s(localObject4, "resp.refObjectList");
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (FinderObject)((Iterator)localObject4).next();
        com.tencent.mm.plugin.mv.ui.a locala = com.tencent.mm.plugin.mv.ui.a.Maz;
        kotlin.g.b.s.s(localObject5, "it");
        com.tencent.mm.plugin.mv.ui.a.R((FinderObject)localObject5);
      }
      if (((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX.LXg != null)
      {
        localObject4 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX.LXg;
        if (localObject4 == null)
        {
          label211:
          ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX.LXv = paramayl.feedObject;
          localObject3 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX;
          localObject4 = paramayl.ZJp;
          kotlin.g.b.s.s(localObject4, "resp.refObjectList");
          kotlin.g.b.s.u(localObject4, "<set-?>");
          ((com.tencent.mm.plugin.mv.model.f)localObject3).LXw = ((LinkedList)localObject4);
          label259:
          i = 1;
        }
      }
    }
    label516:
    label790:
    label923:
    for (;;)
    {
      j += 1;
      break;
      if (((Long)localObject4).longValue() != 0L) {
        break label211;
      }
      localObject4 = paramayl.feedObject;
      if (localObject4 == null) {
        break label259;
      }
      localObject5 = com.tencent.mm.plugin.mv.model.f.LXf;
      f.a.a((FinderObject)localObject4, ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX);
      localObject3 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX;
      localObject4 = paramayl.ZJp;
      kotlin.g.b.s.s(localObject4, "resp.refObjectList");
      ((com.tencent.mm.plugin.mv.model.f)localObject3).bH((LinkedList)localObject4);
      Log.i(this.TAG, kotlin.g.b.s.X("notifyItemChanged1:", Integer.valueOf(j)));
      getAdapter().t(j, "CommentDetailResponse");
      break label259;
      if (i == 0)
      {
        localObject1 = (i)this;
        localObject4 = ((Iterable)((i)localObject1).MeJ).iterator();
        i = 0;
        if (!((Iterator)localObject4).hasNext()) {
          break label918;
        }
        localObject3 = ((Iterator)localObject4).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject3 = (com.tencent.mm.plugin.mv.ui.a.b)localObject3;
        if (((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX.hashCode() != paramInt) {
          break label911;
        }
        localObject5 = paramayl.feedObject;
        if (localObject5 == null) {
          break label911;
        }
        localObject4 = com.tencent.mm.plugin.mv.model.f.LXf;
        f.a.a((FinderObject)localObject5, ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX);
        localObject4 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX;
        paramayl = paramayl.ZJp;
        kotlin.g.b.s.s(paramayl, "resp.refObjectList");
        ((com.tencent.mm.plugin.mv.model.f)localObject4).bH(paramayl);
        paramayl = ((i)localObject1).pUj;
        if (paramayl.size() != 1) {
          break label683;
        }
        paramInt = 1;
        label506:
        if (paramInt == 0) {
          break label688;
        }
        label510:
        if (paramayl != null) {
          break label693;
        }
        paramayl = null;
        paramInt = i;
        if (paramayl == null)
        {
          ((i)localObject1).pUj.add(localObject3);
          paramayl = ((i)localObject1).pUj;
          if (paramayl.size() > 2) {
            break label896;
          }
          paramInt = 1;
          label549:
          if (paramInt == 0) {
            break label901;
          }
          label553:
          if (paramayl != null)
          {
            paramayl = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.p.oL((List)paramayl);
            if (paramayl != null)
            {
              if (!paramayl.MaX.AcH) {
                break label906;
              }
              label582:
              if (paramayl != null)
              {
                Log.i(((i)localObject1).TAG, kotlin.g.b.s.X("notifyItemChanged3:", Integer.valueOf(i)));
                ((i)localObject1).getAdapter().t(0, "notifyItemChanged2");
              }
            }
          }
          Log.i(((i)localObject1).TAG, kotlin.g.b.s.X("notifyItemInserted4:", Integer.valueOf(((i)localObject1).pUj.size() - 1)));
          ((i)localObject1).getAdapter().fW(((i)localObject1).pUj.size() - 1);
        }
      }
      for (paramInt = i;; paramInt = -1)
      {
        if (paramInt >= 0) {
          this.MeJ.remove(paramInt);
        }
        AppMethodBeat.o(287820);
        return;
        label683:
        paramInt = 0;
        break label506;
        label688:
        paramayl = null;
        break label510;
        label693:
        paramayl = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.p.oK((List)paramayl);
        if (paramayl == null)
        {
          paramayl = null;
          break label516;
        }
        paramayl = paramayl.MaX;
        if (paramayl == null)
        {
          paramayl = null;
          break label516;
        }
        if (kotlin.g.b.s.p(paramayl, ((e)localObject2).MdW))
        {
          if (((e)localObject2).MdW.LXj == null) {
            break label790;
          }
          localObject2 = ((e)localObject2).MdW.LXj;
          if (localObject2 != null) {}
        }
        else
        {
          label765:
          paramInt = 0;
          label767:
          if (paramInt == 0) {
            break label823;
          }
        }
        for (;;)
        {
          if (paramayl != null) {
            break label828;
          }
          paramayl = null;
          break;
          if (((Long)localObject2).longValue() != 0L) {
            break label765;
          }
          if (paramayl.LXg != null)
          {
            localObject2 = paramayl.LXg;
            if ((localObject2 == null) || (((Long)localObject2).longValue() != 0L)) {
              break label765;
            }
          }
          paramInt = 1;
          break label767;
          label823:
          paramayl = null;
        }
        label828:
        ((i)localObject1).pUj.clear();
        ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX.LXu = paramayl.LXu;
        ((i)localObject1).pUj.add(localObject3);
        Log.i(((i)localObject1).TAG, kotlin.g.b.s.X("notifyItemChanged2:", Integer.valueOf(i)));
        ((i)localObject1).getAdapter().t(0, "notifyItemChanged2");
        paramayl = ah.aiuX;
        break label516;
        paramInt = 0;
        break label549;
        paramayl = null;
        break label553;
        paramayl = null;
        break label582;
        i += 1;
        break;
      }
    }
  }
  
  private final void a(dsr paramdsr)
  {
    AppMethodBeat.i(287799);
    Object localObject1 = paramdsr.object;
    int i;
    if (((LinkedList)localObject1).size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label144;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label150;
      }
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = (i)this;
        if (((i)localObject1).MeO)
        {
          Log.i(((i)localObject1).TAG, kotlin.g.b.s.X("get mv list notify, dataList.size:", Integer.valueOf(((i)localObject1).pUj.size())));
          ((i)localObject1).getAdapter().e(0, ((i)localObject1).pUj.size(), "handleGetMvRecommendListResponse");
        }
        ((i)localObject1).MeX = true;
        ((i)localObject1).gqN();
      }
      Log.i(this.TAG, kotlin.g.b.s.X("get mv recommend list ", Integer.valueOf(paramdsr.object.size())));
      AppMethodBeat.o(287799);
      return;
      i = 0;
      break;
      label144:
      localObject1 = null;
    }
    label150:
    localObject1 = ((Iterable)localObject1).iterator();
    label162:
    label364:
    label367:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      long l;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FinderObject)((Iterator)localObject1).next();
        localObject3 = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.p.oL((List)this.pUj);
        if (localObject3 == null) {
          break label364;
        }
        localObject3 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).MaX;
        if (localObject3 == null) {
          break label364;
        }
        localObject3 = ((com.tencent.mm.plugin.mv.model.f)localObject3).LXj;
        l = ((FinderObject)localObject2).id;
        if (localObject3 == null) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label367;
        }
        localObject3 = new com.tencent.mm.plugin.mv.model.f();
        Object localObject4 = com.tencent.mm.plugin.mv.model.f.LXf;
        kotlin.g.b.s.s(localObject2, "it");
        f.a.a((FinderObject)localObject2, (com.tencent.mm.plugin.mv.model.f)localObject3);
        this.MeJ.add(new com.tencent.mm.plugin.mv.ui.a.b((com.tencent.mm.plugin.mv.model.f)localObject3));
        localObject2 = ((com.tencent.mm.plugin.mv.model.f)localObject3).LXj;
        localObject4 = ((com.tencent.mm.plugin.mv.model.f)localObject3).LXk;
        if ((localObject2 == null) || (localObject4 == null)) {
          break label162;
        }
        l = ((Number)localObject2).longValue();
        Log.i(this.TAG, "handleGetMvRecommendListResponse do getMvDetailInfo");
        a(l, (String)localObject4, (com.tencent.mm.plugin.mv.model.f)localObject3);
        break label162;
        if (((Long)localObject3).longValue() == l)
        {
          i = 1;
          continue;
          localObject1 = ah.aiuX;
          break;
        }
        i = 0;
      }
    }
  }
  
  private final void aee(int paramInt)
  {
    AppMethodBeat.i(287757);
    if (paramInt == this.MeK.mma)
    {
      AppMethodBeat.o(287757);
      return;
    }
    Log.i(this.TAG, "scrollMvToPosition:" + paramInt + ", snapPosition:" + this.MeK.mma + ", dataList.size:" + this.pUj.size());
    this.MeN.agMz = true;
    WxRecyclerView localWxRecyclerView;
    com.tencent.mm.hellhoundlib.b.a locala;
    if (paramInt > this.MeK.mma)
    {
      localWxRecyclerView = this.AZd;
      if (localWxRecyclerView != null)
      {
        locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, locala.aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        localWxRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    for (;;)
    {
      localWxRecyclerView = this.AZd;
      if (localWxRecyclerView != null) {
        localWxRecyclerView.post(new i..ExternalSyntheticLambda7(this, paramInt));
      }
      AppMethodBeat.o(287757);
      return;
      localWxRecyclerView = this.AZd;
      if (localWxRecyclerView != null)
      {
        locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt + 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, locala.aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        localWxRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
  }
  
  private final void aeg(int paramInt)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = null;
    AppMethodBeat.i(287785);
    if (paramInt < 0)
    {
      Log.e(this.TAG, kotlin.g.b.s.X("refreshVideo position error:", Integer.valueOf(paramInt)));
      AppMethodBeat.o(287785);
      return;
    }
    if (((com.tencent.mm.plugin.mv.ui.a.b)this.pUj.get(paramInt)).MaX.LXm.size() == 0)
    {
      Log.i(this.TAG, "refreshVideo " + paramInt + " trackDataList empty");
      AppMethodBeat.o(287785);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.mv.model.f.LXf;
    Object localObject2;
    label304:
    boolean bool1;
    long l;
    label363:
    Object localObject3;
    if (!f.a.c(((com.tencent.mm.plugin.mv.ui.a.b)this.pUj.get(paramInt)).MaX))
    {
      if (((com.tencent.mm.plugin.mv.ui.a.b)this.pUj.get(paramInt)).MaX.LXg == null) {
        break label914;
      }
      localObject1 = ((com.tencent.mm.plugin.mv.ui.a.b)this.pUj.get(paramInt)).MaX.LXg;
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      if (localObject1 != null) {
        ((dtk)localObject1).aaYS = 2;
      }
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = (dtk)a.a.a((Context)getActivity(), 7, dtk.class);
      if (localObject1 != null) {
        ((dtk)localObject1).aaYT = 2;
      }
      Log.i(this.TAG, "refreshVideo, position:" + paramInt + ", lastPos:" + this.Ahg);
      gqr();
      localObject2 = this.TAG;
      localObject1 = this.Mci;
      if (localObject1 != null) {
        break label931;
      }
      localObject1 = null;
      Log.i((String)localObject2, kotlin.g.b.s.X("refreshVideo, videoLayout.parent:", localObject1));
      bool1 = bool3;
      if (this.Ahg != paramInt)
      {
        bool1 = bool3;
        if (this.Ahg >= 0)
        {
          localObject1 = this.MeQ;
          if (localObject1 != null)
          {
            localObject2 = this.Mci;
            if (localObject2 != null) {
              break label941;
            }
            l = 0L;
            ((q)localObject1).FsW = l;
          }
          if (com.tencent.mm.plugin.music.logic.j.gnw().gnj().bLk()) {
            break label951;
          }
          bool1 = true;
          label386:
          localObject1 = this.MeQ;
          if (localObject1 != null)
          {
            if (!bool1) {
              bool2 = true;
            }
            ((q)localObject1).isAutoPlay = bool2;
          }
          localObject2 = this.TAG;
          localObject3 = new StringBuilder("recycle last video, isVideoPause:").append(bool1).append(", videoLayout.parent:");
          localObject1 = this.Mci;
          if (localObject1 != null) {
            break label956;
          }
          localObject1 = null;
          label451:
          Log.d((String)localObject2, localObject1);
          localObject1 = this.Mci;
          if (localObject1 != null) {
            ((MultiMediaEffectVideoLayout)localObject1).pause();
          }
          localObject1 = this.Mci;
          if (localObject1 != null) {
            break label966;
          }
          localObject1 = null;
          label496:
          localObject1 = (ViewGroup)localObject1;
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)this.Mci);
          }
          Log.d(this.TAG, kotlin.g.b.s.X("recycle last video, isVideoPause:", Boolean.valueOf(bool1)));
        }
      }
      localObject1 = this.AZd;
      if (localObject1 != null) {
        break label976;
      }
      localObject1 = null;
      label551:
      if (localObject1 != null)
      {
        localObject2 = (FrameLayout)((RecyclerView.v)localObject1).caK.findViewById(b.e.video_container);
        localObject1 = this.Mci;
        if (localObject1 != null) {
          break label987;
        }
        localObject1 = null;
        label586:
        if (localObject1 == null)
        {
          localObject1 = this.Mci;
          if (localObject1 != null) {
            ((MultiMediaEffectVideoLayout)localObject1).setId(b.e.music_video_layout);
          }
          Log.i(this.TAG, "refreshVideo add videoLayout to current videoContainer");
          ((FrameLayout)localObject2).addView((View)this.Mci);
          localObject1 = this.Mci;
          if (localObject1 != null) {
            ((MultiMediaEffectVideoLayout)localObject1).setAlpha(0.0F);
          }
        }
        if (this.Ahg >= 0)
        {
          localObject1 = com.tencent.mm.plugin.mv.model.o.LYk;
          localObject2 = (Context)getActivity();
          localObject3 = ((com.tencent.mm.plugin.mv.ui.a.b)this.pUj.get(this.Ahg)).MaX;
          localObject1 = this.Mci;
          if (localObject1 != null) {
            break label997;
          }
        }
      }
    }
    label914:
    label931:
    label941:
    label951:
    label956:
    label966:
    label976:
    label987:
    label997:
    for (localObject1 = localMultiMediaEffectVideoLayout;; localObject1 = ((MultiMediaEffectVideoLayout)localObject1).getReportInfo())
    {
      com.tencent.mm.plugin.mv.model.o.a((Context)localObject2, (com.tencent.mm.plugin.mv.model.f)localObject3, (com.tencent.mm.plugin.thumbplayer.d.c)localObject1);
      Log.i(this.TAG, kotlin.g.b.s.X("refreshVideo current music position:", Integer.valueOf(com.tencent.mm.plugin.music.logic.j.gnw().gnj().gmA())));
      localObject1 = ((com.tencent.mm.plugin.mv.ui.a.b)this.pUj.get(paramInt)).MaX;
      localMultiMediaEffectVideoLayout = this.Mci;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.setMediaList((List)((com.tencent.mm.plugin.mv.model.f)localObject1).gpD());
      }
      localMultiMediaEffectVideoLayout = this.Mci;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.setFirstFrameRenderCallback((kotlin.g.a.a)new i.l(this));
      }
      localMultiMediaEffectVideoLayout = this.Mci;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.setPlayStatusChangeListener((b.c)new m((com.tencent.mm.plugin.mv.model.f)localObject1));
      }
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).start();
      }
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().gmA();
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setPauseOnVideoPlay(bool1);
      }
      localObject1 = this.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).setKeepScreenOn(true);
      }
      AppMethodBeat.o(287785);
      return;
      if (((Long)localObject1).longValue() != 0L) {
        break;
      }
      Log.i(this.TAG, "no mv");
      AppMethodBeat.o(287785);
      return;
      localObject1 = ((MultiMediaEffectVideoLayout)localObject1).getParent();
      break label304;
      l = ((MultiMediaEffectVideoLayout)localObject2).getCurrentPositionMs();
      break label363;
      bool1 = false;
      break label386;
      localObject1 = ((MultiMediaEffectVideoLayout)localObject1).getParent();
      break label451;
      localObject1 = ((MultiMediaEffectVideoLayout)localObject1).getParent();
      break label496;
      localObject1 = ((WxRecyclerView)localObject1).fU(paramInt);
      break label551;
      localObject1 = ((MultiMediaEffectVideoLayout)localObject1).getParent();
      break label586;
    }
  }
  
  private static final void b(i parami)
  {
    AppMethodBeat.i(287883);
    kotlin.g.b.s.u(parami, "this$0");
    parami.aeg(parami.Ahg);
    parami.getAdapter().e(parami.Ahg, 1, Mfa);
    AppMethodBeat.o(287883);
  }
  
  private static final void b(i parami, int paramInt)
  {
    AppMethodBeat.i(287851);
    kotlin.g.b.s.u(parami, "this$0");
    Log.i(parami.TAG, "post stopScroll");
    WxRecyclerView localWxRecyclerView = parami.AZd;
    if (localWxRecyclerView != null) {
      localWxRecyclerView.JO();
    }
    localWxRecyclerView = parami.AZd;
    if (localWxRecyclerView != null) {
      localWxRecyclerView.post(new i..ExternalSyntheticLambda6(parami, paramInt));
    }
    AppMethodBeat.o(287851);
  }
  
  private static final void c(i parami)
  {
    AppMethodBeat.i(287895);
    kotlin.g.b.s.u(parami, "this$0");
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = parami.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.start();
    }
    parami.getAdapter().e(parami.Ahg, 1, Mfa);
    if (!com.tencent.mm.plugin.music.logic.j.gnw().gnj().bLk())
    {
      if (!parami.MeM) {
        break label93;
      }
      parami.aef(parami.Ahg);
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().resume();
    }
    for (;;)
    {
      parami.MeM = false;
      AppMethodBeat.o(287895);
      return;
      label93:
      localMultiMediaEffectVideoLayout = parami.Mci;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.setPauseOnVideoPlay(true);
      }
    }
  }
  
  private final void gqL()
  {
    AppMethodBeat.i(287736);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(e.class);
    kotlin.g.b.s.s(localObject, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject = (e)localObject;
    com.tencent.mm.plugin.mv.ui.a.b localb = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.p.ae((List)this.pUj, this.Ahg);
    if (localb != null)
    {
      com.tencent.mm.plugin.mv.model.o localo = com.tencent.mm.plugin.mv.model.o.LYk;
      com.tencent.mm.plugin.mv.model.o.b((Context)getContext(), ((e)localObject).LWI, localb.MaX);
    }
    a((e)localObject);
    AppMethodBeat.o(287736);
  }
  
  private final void gqN()
  {
    AppMethodBeat.i(287790);
    if ((!this.MeW) || (!this.MeX))
    {
      AppMethodBeat.o(287790);
      return;
    }
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(e.class);
    kotlin.g.b.s.s(localObject, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject = (e)localObject;
    if (((CharSequence)((e)localObject).Meg).length() == 0)
    {
      i = 1;
      if (i == 0) {
        if (((CharSequence)((e)localObject).Meh).length() != 0) {
          break label122;
        }
      }
    }
    label122:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label127;
      }
      getAdapter().t(0, "NotPermittedSong");
      AppMethodBeat.o(287790);
      return;
      i = 0;
      break;
    }
    label127:
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new com.tencent.mm.plugin.mv.model.a.d(((e)localObject).Meg, ((e)localObject).Meh, getActivity().hashCode()), 0);
    AppMethodBeat.o(287790);
  }
  
  private final void gqr()
  {
    AppMethodBeat.i(287765);
    if (this.Mci == null)
    {
      this.Mci = new MultiMediaEffectVideoLayout((Context)getActivity());
      localMultiMediaEffectVideoLayout = this.Mci;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.setMvMusicProxy((com.tencent.mm.plugin.thumbplayer.view.b)new c());
      }
      localMultiMediaEffectVideoLayout = this.Mci;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.setId(b.e.music_video_layout);
      }
    }
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null)
    {
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      localMultiMediaEffectVideoLayout.setMediaChangeListener(((g)com.tencent.mm.ui.component.k.d(getActivity()).q(g.class)).Meq);
    }
    AppMethodBeat.o(287765);
  }
  
  public final void Y(long paramLong, String paramString)
  {
    AppMethodBeat.i(288149);
    kotlin.g.b.s.u(paramString, "nonceId");
    Log.i(this.TAG, kotlin.g.b.s.X("start to switchToMv from id dataList.size:", Integer.valueOf(this.pUj.size())));
    Object localObject1 = ((Iterable)this.pUj).iterator();
    int k = 0;
    Object localObject2;
    int j;
    for (int i = 0; ((Iterator)localObject1).hasNext(); i = j)
    {
      localObject2 = ((Iterator)localObject1).next();
      if (k < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (com.tencent.mm.plugin.mv.ui.a.b)localObject2;
      f.a locala = com.tencent.mm.plugin.mv.model.f.LXf;
      localObject2 = f.a.b(((com.tencent.mm.plugin.mv.ui.a.b)localObject2).MaX);
      j = i;
      if (localObject2 != null)
      {
        j = i;
        if (((FinderObject)localObject2).id == paramLong)
        {
          j = i;
          if (kotlin.g.b.s.p(((FinderObject)localObject2).objectNonceId, paramString))
          {
            j = 1;
            Log.i(this.TAG, kotlin.g.b.s.X("switchToMv exist index:", Integer.valueOf(k)));
            gqL();
            localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
            localObject2 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
            if (localObject2 != null) {
              ((dtk)localObject2).scene = 11;
            }
            aee(k);
          }
        }
      }
      k += 1;
    }
    if (i == 0)
    {
      Log.i(this.TAG, "switchToMv not exist");
      localObject1 = this.pUj;
      localObject2 = new com.tencent.mm.plugin.mv.model.f();
      ((com.tencent.mm.plugin.mv.model.f)localObject2).LXj = Long.valueOf(paramLong);
      ((com.tencent.mm.plugin.mv.model.f)localObject2).LXk = paramString;
      a(paramLong, paramString, (com.tencent.mm.plugin.mv.model.f)localObject2);
      paramString = ah.aiuX;
      ((ArrayList)localObject1).add(new com.tencent.mm.plugin.mv.ui.a.b((com.tencent.mm.plugin.mv.model.f)localObject2));
      i = this.pUj.size() - 1;
      gqL();
      Log.i(this.TAG, "switchToMv final index:" + i + ", dataList.size:" + this.pUj.size());
      getAdapter().fW(i);
      paramString = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramString = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      if (paramString != null) {
        paramString.scene = 11;
      }
      aee(i);
    }
    AppMethodBeat.o(288149);
  }
  
  public final int a(boo paramboo, ap paramap)
  {
    AppMethodBeat.i(288161);
    kotlin.g.b.s.u(paramboo, "songInfo");
    Log.i(this.TAG, "doJumpToApp: ");
    this.MeM = true;
    com.tencent.mm.aw.f localf = com.tencent.mm.plugin.music.logic.j.gnw().gng();
    if (localf != null)
    {
      l locall = l.LMH;
      int i = l.a((Context)getContext(), localf, paramboo, paramap);
      AppMethodBeat.o(288161);
      return i;
    }
    AppMethodBeat.o(288161);
    return -1;
  }
  
  public final void a(long paramLong, String paramString, com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(288243);
    kotlin.g.b.s.u(paramString, "mvNonceId");
    kotlin.g.b.s.u(paramf, "musicMv");
    Log.i(this.TAG, "getMvDetailInfo mvObjectId:" + paramLong + " mvNonceId:" + paramString + " localId:" + paramf.LXg);
    Object localObject = com.tencent.mm.plugin.mv.model.i.LXD;
    localObject = com.tencent.mm.plugin.mv.model.i.W(paramLong, paramString);
    if (localObject == null) {}
    for (localObject = null;; localObject = com.tencent.threadpool.h.ahAA.bk(new i..ExternalSyntheticLambda8(this, (ayl)localObject, paramf)))
    {
      if (localObject == null)
      {
        localObject = (i)this;
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new com.tencent.mm.plugin.mv.model.a.k(paramLong, paramString, paramf.hashCode(), ((i)localObject).getActivity().hashCode()), 0);
      }
      AppMethodBeat.o(288243);
      return;
      Log.i(this.TAG, "getMvDetailInfo hit cache");
    }
  }
  
  public final void aef(int paramInt)
  {
    AppMethodBeat.i(288185);
    Log.v(this.TAG, "alvinluo updateFloatBallMvInfo position: %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = getActivity().getIntent();
    dtj localdtj;
    Long localLong;
    if (localObject == null)
    {
      localObject = null;
      com.tencent.mm.plugin.music.model.b.aK((Bundle)localObject);
      localObject = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.p.ae((List)this.pUj, paramInt);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.mv.ui.a.b)localObject).MaX;
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.mv.model.f)localObject).LXy = 0L;
          ((com.tencent.mm.plugin.mv.model.f)localObject).LXz = 0L;
          localdtj = new dtj();
          localLong = ((com.tencent.mm.plugin.mv.model.f)localObject).LXj;
          if (localLong != null) {
            break label178;
          }
        }
      }
    }
    label178:
    for (long l = 0L;; l = localLong.longValue())
    {
      localdtj.YqN = com.tencent.mm.ae.d.hF(l);
      localdtj.YqO = ((com.tencent.mm.plugin.mv.model.f)localObject).LXk;
      localdtj.YqP = ((com.tencent.mm.plugin.mv.model.f)localObject).coverUrl;
      localdtj.YqQ = ((com.tencent.mm.plugin.mv.model.f)localObject).LXl;
      com.tencent.mm.plugin.music.model.b.c(localdtj);
      AppMethodBeat.o(288185);
      return;
      localObject = ((Intent)localObject).getExtras();
      break;
    }
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> getAdapter()
  {
    AppMethodBeat.i(288118);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.xZP.getValue();
    AppMethodBeat.o(288118);
    return localWxRecyclerAdapter;
  }
  
  public final EffectManager getEffectManager()
  {
    AppMethodBeat.i(288213);
    Object localObject = this.Mci;
    if (localObject == null)
    {
      AppMethodBeat.o(288213);
      return null;
    }
    localObject = ((MultiMediaEffectVideoLayout)localObject).getEffectManager();
    AppMethodBeat.o(288213);
    return localObject;
  }
  
  public final void gqM()
  {
    AppMethodBeat.i(288219);
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.TGY.gqM();
    }
    AppMethodBeat.o(288219);
  }
  
  public final void k(com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(288154);
    kotlin.g.b.s.u(paramf, "musicMv");
    Log.i(this.TAG, kotlin.g.b.s.X("start switchToMv from musicMv, dataList.size:", Integer.valueOf(this.pUj.size())));
    i locali = (i)this;
    Object localObject1 = (Iterable)locali.pUj;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      if (kotlin.g.b.s.p(((com.tencent.mm.plugin.mv.ui.a.b)localObject2).MaX, paramf))
      {
        Log.i(locali.TAG, kotlin.g.b.s.X("switchToMv index:", Integer.valueOf(i)));
        locali.gqL();
        paramf = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramf = (dtk)a.a.a((Context)locali.getContext(), 7, dtk.class);
        if (paramf != null) {
          paramf.scene = 12;
        }
        locali.aee(i);
        AppMethodBeat.o(288154);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(288154);
  }
  
  public final void l(com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(288203);
    kotlin.g.b.s.u(paramf, "musicMv");
    int i = com.tencent.mm.plugin.music.logic.j.gnw().gnj().getDuration();
    if (i != 0)
    {
      this.MeV.dead();
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = ((e)com.tencent.mm.ui.component.k.d(getActivity()).q(e.class)).LWI;
      ((boo)localObject).duration = i;
      Log.i(this.TAG, "syncBeatTrack songId:" + ((boo)localObject).mLQ + " songName:" + ((boo)localObject).songName + " singer:" + ((boo)localObject).rDl + " musicTotalDuration:" + i);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new com.tencent.mm.plugin.mv.model.a.h((boo)localObject, i, paramf.hashCode(), getActivity().hashCode()), 0);
      AppMethodBeat.o(288203);
      return;
    }
    Log.i(this.TAG, "wait song start");
    this.MeV.alive();
    AppMethodBeat.o(288203);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288123);
    com.tencent.mm.kernel.h.aZW().a(6860, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(3763, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(5292, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(5904, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(5286, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(3627, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(6448, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(6473, this.LYH);
    com.tencent.mm.kernel.h.aZW().a(8967, this.LYH);
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().a(this.MeY);
    this.MeZ.alive();
    AppMethodBeat.o(288123);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(288140);
    this.AZd = ((WxRecyclerView)getActivity().findViewById(b.e.recycler_view));
    paramBundle = this.AZd;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)this.MeN);
    }
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = com.tencent.mm.ui.component.k.d(getActivity()).q(e.class);
    kotlin.g.b.s.s(paramBundle, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    e locale = (e)paramBundle;
    paramBundle = new com.tencent.mm.plugin.mv.ui.a.b(locale.MdW);
    Object localObject1 = paramBundle.MaX;
    kotlin.g.b.s.u(localObject1, "musicMv");
    Object localObject2;
    String str;
    if (((com.tencent.mm.plugin.mv.model.f)localObject1).LXg != null)
    {
      Log.i(this.TAG, "init local music mv");
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(e.class);
      kotlin.g.b.s.s(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
      localObject1 = (e)localObject1;
      Log.i(this.TAG, kotlin.g.b.s.X("asyncCheckPostPermission songId:", ((e)localObject1).LWI.mLQ));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new com.tencent.mm.plugin.mv.model.a.f(((e)localObject1).LWI, getActivity().hashCode()), 0);
      this.pUj.add(paramBundle);
      paramBundle = this.AZd;
      if (paramBundle != null) {
        paramBundle.setAdapter((RecyclerView.a)getAdapter());
      }
      paramBundle = this.AZd;
      if (paramBundle != null) {
        paramBundle.a((RecyclerView.k)new e(this));
      }
      this.MeK.mmc = ((a.c)new i.f(this));
      paramBundle = this.AZd;
      if (paramBundle != null) {
        paramBundle.post(new i..ExternalSyntheticLambda4(this));
      }
      this.MeK.mmb = ((a.b)this.MeT);
      this.MeK.mmd = ((a.d)this.MeU);
      getAdapter().a((RecyclerView.c)new i.g(this));
      paramBundle = locale.LWI;
      Log.i(this.TAG, "getSongDetailInfo songId:" + paramBundle.mLQ + " appId:" + paramBundle.ZWQ + " webUrl:" + paramBundle.ZWR);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new com.tencent.mm.plugin.mv.model.a.o(paramBundle, getActivity().hashCode()), 0);
      localObject1 = locale.LWI;
      Log.i(this.TAG, kotlin.g.b.s.X("getMVList songId:", ((boo)localObject1).mLQ));
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject2 = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      paramBundle = com.tencent.mm.plugin.mv.ui.a.Maz;
      str = com.tencent.mm.plugin.mv.ui.a.a((boo)localObject1);
      paramBundle = com.tencent.mm.plugin.mv.model.i.LXD;
      paramBundle = com.tencent.mm.plugin.mv.model.i.aPy(str);
      if (paramBundle != null) {
        break label801;
      }
    }
    for (paramBundle = null;; paramBundle = ah.aiuX)
    {
      if (paramBundle == null)
      {
        paramBundle = (i)this;
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new n((dtk)localObject2, (boo)localObject1, str, paramBundle.getActivity().hashCode()), 0);
      }
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((t)com.tencent.mm.ui.component.k.d(getActivity()).q(t.class)).MeK = this.MeK;
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((c)com.tencent.mm.ui.component.k.d(getActivity()).q(c.class)).MdK = ((com.tencent.mm.plugin.mv.ui.uic.a.a)new i.h(this));
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((h)com.tencent.mm.ui.component.k.d(getActivity()).q(h.class)).a(locale.LWI, locale.LOA);
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramBundle = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      if (paramBundle != null) {
        paramBundle.aaYU = Util.currentTicks();
      }
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramBundle = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      if (paramBundle != null) {
        paramBundle.aaYV = 0L;
      }
      gqr();
      AppMethodBeat.o(288140);
      return;
      localObject2 = ((com.tencent.mm.plugin.mv.model.f)localObject1).LXj;
      str = ((com.tencent.mm.plugin.mv.model.f)localObject1).LXk;
      if ((localObject2 != null) && (str != null))
      {
        long l = ((Number)localObject2).longValue();
        a(l, str, (com.tencent.mm.plugin.mv.model.f)localObject1);
        Log.i(this.TAG, "init finder music mv " + l + ' ' + str);
      }
      l((com.tencent.mm.plugin.mv.model.f)localObject1);
      break;
      label801:
      Log.i(this.TAG, "getMVList hit cache");
      a(paramBundle);
      this.MeP = true;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(288195);
    Log.i(this.TAG, "onDestroy");
    ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().b(this.MeY);
    com.tencent.mm.kernel.h.aZW().b(6860, this.LYH);
    com.tencent.mm.kernel.h.aZW().b(3763, this.LYH);
    com.tencent.mm.kernel.h.aZW().b(5292, this.LYH);
    com.tencent.mm.kernel.h.aZW().b(5904, this.LYH);
    com.tencent.mm.kernel.h.aZW().b(5286, this.LYH);
    com.tencent.mm.kernel.h.aZW().b(3627, this.LYH);
    com.tencent.mm.kernel.h.aZW().b(6448, this.LYH);
    com.tencent.mm.kernel.h.aZW().b(6473, this.LYH);
    com.tencent.mm.kernel.h.aZW().b(8967, this.LYH);
    Object localObject = this.Mci;
    if (localObject != null) {
      ((MultiMediaEffectVideoLayout)localObject).TGY.release();
    }
    this.MeV.dead();
    this.Mcl = false;
    this.MeZ.dead();
    localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(e.class);
    kotlin.g.b.s.s(localObject, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    e locale = (e)localObject;
    localObject = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.p.ae((List)this.pUj, this.Ahg);
    com.tencent.mm.plugin.mv.model.f localf;
    Context localContext;
    if (localObject != null)
    {
      localf = ((com.tencent.mm.plugin.mv.ui.a.b)localObject).MaX;
      if (localf != null)
      {
        localObject = com.tencent.mm.plugin.mv.model.o.LYk;
        com.tencent.mm.plugin.mv.model.o.b((Context)getContext(), locale.LWI, localf);
        localObject = com.tencent.mm.plugin.mv.model.o.LYk;
        localContext = (Context)getActivity();
        localObject = this.Mci;
        if (localObject != null) {
          break label323;
        }
      }
    }
    label323:
    for (localObject = null;; localObject = ((MultiMediaEffectVideoLayout)localObject).getReportInfo())
    {
      com.tencent.mm.plugin.mv.model.o.a(localContext, localf, (com.tencent.mm.plugin.thumbplayer.d.c)localObject);
      a(locale);
      if (!com.tencent.mm.aw.a.bLk()) {
        com.tencent.mm.aw.a.bLi();
      }
      AppMethodBeat.o(288195);
      return;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(288249);
    Object localObject;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getByteArrayExtra("key_track_data");
      if (paramIntent != null)
      {
        localObject = new dtf();
        ((dtf)localObject).parseFrom(paramIntent);
        paramIntent = com.tencent.mm.plugin.mv.model.f.LXf;
        paramIntent = f.a.b((dtf)localObject);
        com.tencent.mm.plugin.finder.storage.logic.d.a locala = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.a.qr(((dtf)localObject).localId);
        if (localObject != null)
        {
          if (!((FinderItem)localObject).isPostFailed()) {
            break label294;
          }
          paramIntent.LXs = 3;
        }
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject = (dtk)a.a.a((Context)getContext(), 7, dtk.class);
      if (localObject != null) {
        ((dtk)localObject).scene = 14;
      }
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(0);
      Log.i(this.TAG, "onNewIntent mvLocalId:" + paramIntent.LXg + " coverPath:" + paramIntent.LXi + " mvPostStatus:" + paramIntent.LXs);
      this.Mcl = false;
      this.pUj.add(0, new com.tencent.mm.plugin.mv.ui.a.b(paramIntent));
      getAdapter().bZE.notifyChanged();
      paramIntent = this.AZd;
      if (paramIntent != null)
      {
        localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "scrollToPosition", "(I)V");
        paramIntent.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramIntent, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "scrollToPosition", "(I)V");
      }
      AppMethodBeat.o(288249);
      return;
      label294:
      if (!((FinderItem)localObject).isPostFinish()) {
        paramIntent.LXs = 2;
      } else {
        paramIntent.LXs = 1;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(288230);
    super.onPause();
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.pause();
    }
    this.Mcl = true;
    this.MeL = false;
    Log.i(this.TAG, "onPause");
    com.tencent.mm.plugin.music.logic.j.gnw().gnj().b(this.LJz);
    AppMethodBeat.o(288230);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(288169);
    super.onResume();
    Log.i(this.TAG, "onResume, needResumePosition:" + this.Mcl + ", isJumpToApp:" + this.MeM);
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(e.class);
    kotlin.g.b.s.s(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    Object localObject3 = (e)localObject1;
    Object localObject4 = com.tencent.mm.plugin.music.logic.j.gnw().gng();
    Object localObject2;
    int i;
    if (!((e)localObject3).f((com.tencent.mm.aw.f)localObject4))
    {
      Log.i(this.TAG, "onResume different music firstTimeEnterMusicId:" + ((e)localObject3).MdV + ' ');
      localObject1 = ac.FLX;
      boo localboo = ((e)localObject3).LWI;
      localObject2 = ((e)localObject3).MdV;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = ((e)localObject3).LWI.mLQ;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localObject2 = ((e)localObject3).MdU;
      if (localObject2 == null)
      {
        i = 0;
        localObject3 = ((e)localObject3).MdW.coverUrl;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        ac.a(localboo, (String)localObject1, i, (String)localObject2);
        this.MeL = true;
        localObject1 = this.AZd;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).post(new i..ExternalSyntheticLambda3(this));
        }
      }
    }
    for (;;)
    {
      this.Mcl = false;
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().a(this.LJz);
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(t.class);
      kotlin.g.b.s.s(localObject1, "UICProvider.of(activity)…vSongInfoUIC::class.java)");
      if (((t)localObject1).MgY)
      {
        localObject1 = ((com.tencent.mm.aw.f)localObject4).oOI;
        kotlin.g.b.s.s(localObject1, "musicWrapper.AppId");
        localObject2 = ((com.tencent.mm.aw.f)localObject4).oOZ;
        kotlin.g.b.s.s(localObject2, "musicWrapper.mid");
        if (!Util.isNullOrNil((String)localObject2))
        {
          localObject3 = new LinkedList();
          localObject4 = new dsn();
          ((dsn)localObject4).appid = ((String)localObject1);
          ((dsn)localObject4).oOZ = ((String)localObject2);
          ((LinkedList)localObject3).add(localObject4);
          localObject1 = new com.tencent.mm.plugin.mv.model.a.e((LinkedList)localObject3);
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
        }
      }
      AppMethodBeat.o(288169);
      return;
      i = ((Integer)localObject2).intValue();
      break;
      if ((this.Mcl) || (this.MeM))
      {
        Log.i(this.TAG, "onResume same music " + ((com.tencent.mm.aw.f)localObject4).oOv + ' ' + ((com.tencent.mm.aw.f)localObject4).oOt + ", musicPlayer.isPlaying:" + com.tencent.mm.plugin.music.logic.j.gnw().gnj().bLk());
        localObject1 = this.AZd;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).post(new i..ExternalSyntheticLambda5(this));
        }
      }
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(288235);
    super.onStart();
    Log.i(this.TAG, "onStart: ");
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.setMute(true);
    }
    localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.start();
    }
    AppMethodBeat.o(288235);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(288239);
    super.onStop();
    Log.i(this.TAG, "onStop");
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.Mci;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.TGY.stop();
    }
    AppMethodBeat.o(288239);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$checkVideoLayout$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getCurrentPosition", "", "getTotalDuration", "seekMusic", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.thumbplayer.view.b
  {
    public final void aea(int paramInt)
    {
      AppMethodBeat.i(287615);
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(paramInt);
      AppMethodBeat.o(287615);
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(287606);
      long l = com.tencent.mm.plugin.music.logic.j.gnw().gnj().gmA();
      AppMethodBeat.o(287606);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$1", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.q
  {
    e(i parami) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(287593);
      kotlin.g.b.s.u(paramRecyclerView, "rv");
      kotlin.g.b.s.u(paramMotionEvent, "e");
      boolean bool = i.a(this.Mfb, paramMotionEvent);
      AppMethodBeat.o(287593);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$refreshVideo$2", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "onPause", "", "onResume", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements b.c
  {
    m(com.tencent.mm.plugin.mv.model.f paramf) {}
    
    public final void onPause()
    {
      AppMethodBeat.i(287620);
      if (this.Mfc.LXx > 0L)
      {
        com.tencent.mm.plugin.mv.model.f localf = this.Mfc;
        localf.LXy += cn.bDw() - this.Mfc.LXx;
        this.Mfc.LXx = 0L;
      }
      AppMethodBeat.o(287620);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(287629);
      if (this.Mfc.LXx > 0L)
      {
        com.tencent.mm.plugin.mv.model.f localf = this.Mfc;
        localf.LXy += cn.bDw() - this.Mfc.LXx;
      }
      this.Mfc.LXx = cn.bDw();
      AppMethodBeat.o(287629);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.i
 * JD-Core Version:    0.7.0.1
 */