package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.q;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.emoji.panel.layout.a.d;
import com.tencent.mm.f.a.hv;
import com.tencent.mm.f.a.hv.a;
import com.tencent.mm.f.a.np;
import com.tencent.mm.model.cm;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.aa;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.model.l.a;
import com.tencent.mm.plugin.music.model.l.b;
import com.tencent.mm.plugin.music.model.l.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.h;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.thumbplayer.d.c.c;
import com.tencent.mm.plugin.thumbplayer.d.c.f;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.view.layoutmanager.Flip3DLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.g.b.p;
import kotlin.x;
import kotlinx.coroutines.ak;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "downY", "", "finderCommentEventListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderCommentEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderCommentEventListener$1;", "finderPostListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getFinderPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getBeatTrackFlag", "", "getGetBeatTrackFlag", "()Z", "setGetBeatTrackFlag", "(Z)V", "getRecMvListFlag", "getGetRecMvListFlag", "setGetRecMvListFlag", "isDoPlayMusic", "isDragChangePaged", "isJumpToApp", "lastAction", "", "lastActionTime", "", "lastPos", "getLastPos", "()I", "setLastPos", "(I)V", "layoutManager", "Lcom/tencent/mm/view/layoutmanager/Flip3DLayoutManager;", "musicListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicListener", "()Lcom/tencent/mm/sdk/event/IListener;", "needResumePosition", "onPageSelectedListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageSelectedListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageSelectedListener$1;", "onPageStartChangeListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageStartChangeListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageStartChangeListener$1;", "onSceneEndListener", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "playProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "getSnapHelper", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "statRecord", "Lcom/tencent/mm/plugin/mv/model/StatRecord;", "getStatRecord", "()Lcom/tencent/mm/plugin/mv/model/StatRecord;", "setStatRecord", "(Lcom/tencent/mm/plugin/mv/model/StatRecord;)V", "topPanelMargin", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MultiMediaEffectVideoLayout;)V", "waitDetailDataList", "getWaitDetailDataList", "setWaitDetailDataList", "checkRecycleViewSafeTouch", "e", "Landroid/view/MotionEvent;", "checkVideoLayout", "", "deleteMv", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "doJumpToApp", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "callback", "Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;", "enableMvListScroll", "enable", "fillMusicMvData", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getMVList", "getMusicMv", "objectId", "nonceId", "getMvDetailInfo", "mvObjectId", "mvNonceId", "getSongDetailInfo", "handleGetCommentDetailResponse", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "musicMvHashCode", "handleGetMvRecommendListResponse", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onMusicPause", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStart", "onStop", "recordStat", "position", "mv", "refreshFrame", "refreshVideo", "reportLastMvExit", "reportStat", "dataUIC", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvDataUIC;", "scrollMvToPosition", "switchToMv", "syncBeatTrack", "syncPostPermission", "updateFloatBallMvInfo", "Companion", "plugin-mv_release"})
public final class k
  extends UIComponent
{
  private static final Object GjW;
  public static final k.a GjX;
  private final kotlin.f BiY;
  private long CLY;
  private final d.a FOE;
  MultiMediaEffectVideoLayout GgY;
  private boolean Ghb;
  private final com.tencent.mm.an.i Ghd;
  private ArrayList<com.tencent.mm.plugin.mv.ui.a.b> GjH;
  final com.tencent.mm.emoji.panel.layout.a GjI;
  private boolean GjJ;
  private boolean GjK;
  public Flip3DLayoutManager GjL;
  boolean GjM;
  boolean GjN;
  volatile com.tencent.mm.plugin.mv.model.q GjO;
  private boolean GjP;
  private int GjQ;
  private final k.m GjR;
  private final n GjS;
  private final IListener<np> GjT;
  private final com.tencent.mm.plugin.finder.upload.q GjU;
  private final k.d GjV;
  public final String TAG;
  private float diu;
  public ArrayList<com.tencent.mm.plugin.mv.ui.a.b> mXB;
  int wKJ;
  WxRecyclerView xUj;
  private int zqm;
  
  static
  {
    AppMethodBeat.i(226887);
    GjX = new k.a((byte)0);
    GjW = new Object();
    AppMethodBeat.o(226887);
  }
  
  public k(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(226884);
    this.TAG = "MicroMsg.Mv.MusicMvMainUIC";
    this.mXB = new ArrayList();
    this.GjH = new ArrayList();
    this.BiY = kotlin.g.ar((kotlin.g.a.a)new b(this, paramAppCompatActivity));
    this.FOE = ((d.a)new r(this));
    this.GjI = new com.tencent.mm.emoji.panel.layout.a();
    this.wKJ = -1;
    this.GjL = new Flip3DLayoutManager((Context)paramAppCompatActivity);
    this.CLY = -1L;
    this.diu = -1.0F;
    this.GjQ = -1;
    this.GjR = new k.m(this);
    this.GjS = new n(this);
    this.GjT = ((IListener)new g(this, paramAppCompatActivity));
    this.Ghd = ((com.tencent.mm.an.i)new q(this, paramAppCompatActivity));
    this.GjU = ((com.tencent.mm.plugin.finder.upload.q)new e(this, paramAppCompatActivity));
    this.GjV = new k.d(this, paramAppCompatActivity);
    AppMethodBeat.o(226884);
  }
  
  private final void a(g paramg)
  {
    AppMethodBeat.i(226766);
    com.tencent.mm.plugin.mv.model.q localq = this.GjO;
    if (localq != null)
    {
      com.tencent.mm.plugin.mv.ui.a.b localb = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.M((List)this.mXB, this.wKJ);
      if (localb != null)
      {
        com.tencent.mm.plugin.mv.model.o localo = com.tencent.mm.plugin.mv.model.o.GcB;
        com.tencent.mm.plugin.mv.model.o.a((Context)getContext(), paramg.GaB, localb.GfI, localq);
        AppMethodBeat.o(226766);
        return;
      }
      AppMethodBeat.o(226766);
      return;
    }
    AppMethodBeat.o(226766);
  }
  
  private final void a(dba paramdba)
  {
    AppMethodBeat.i(226861);
    Object localObject1 = paramdba.object;
    int i;
    if (((LinkedList)localObject1).size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label227;
      }
      label26:
      if (localObject1 == null) {
        break label253;
      }
      localObject1 = ((Iterable)localObject1).iterator();
    }
    label43:
    label227:
    label251:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label316;
      }
      Object localObject2 = (FinderObject)((Iterator)localObject1).next();
      Object localObject3 = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.lp((List)this.mXB);
      long l;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).GfI;
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.mv.model.f)localObject3).Gbl;
          l = ((FinderObject)localObject2).id;
          if (localObject3 == null) {
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label251;
        }
        localObject3 = new com.tencent.mm.plugin.mv.model.f();
        Object localObject4 = com.tencent.mm.plugin.mv.model.f.GbD;
        p.j(localObject2, "it");
        com.tencent.mm.plugin.mv.model.f.a.a((FinderObject)localObject2, (com.tencent.mm.plugin.mv.model.f)localObject3);
        this.GjH.add(new com.tencent.mm.plugin.mv.ui.a.b((com.tencent.mm.plugin.mv.model.f)localObject3));
        localObject2 = ((com.tencent.mm.plugin.mv.model.f)localObject3).Gbl;
        localObject4 = ((com.tencent.mm.plugin.mv.model.f)localObject3).Gbm;
        if ((localObject2 == null) || (localObject4 == null)) {
          break label43;
        }
        l = ((Number)localObject2).longValue();
        Log.i(this.TAG, "handleGetMvRecommendListResponse do getMvDetailInfo");
        a(l, (String)localObject4, (com.tencent.mm.plugin.mv.model.f)localObject3);
        break label43;
        i = 0;
        break;
        localObject1 = null;
        break label26;
        if (((Long)localObject3).longValue() == l) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    label253:
    localObject1 = (k)this;
    if (((k)localObject1).GjM)
    {
      Log.i(((k)localObject1).TAG, "get mv list notify, dataList.size:" + ((k)localObject1).mXB.size());
      ((k)localObject1).getAdapter().aE(0, ((k)localObject1).mXB.size());
    }
    label316:
    Log.i(this.TAG, "get mv recommend list " + paramdba.object.size());
    AppMethodBeat.o(226861);
  }
  
  private final void fgI()
  {
    AppMethodBeat.i(226840);
    if (this.GgY == null)
    {
      this.GgY = new MultiMediaEffectVideoLayout((Context)getActivity());
      localMultiMediaEffectVideoLayout = this.GgY;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.setMvMusicProxy((com.tencent.mm.plugin.thumbplayer.view.b)new c());
      }
      localMultiMediaEffectVideoLayout = this.GgY;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.setId(b.e.music_video_layout);
      }
    }
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null)
    {
      com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
      localMultiMediaEffectVideoLayout.setMediaChangeListener(((i)com.tencent.mm.ui.component.g.b(getActivity()).i(i.class)).Gjl);
      AppMethodBeat.o(226840);
      return;
    }
    AppMethodBeat.o(226840);
  }
  
  public final void ZP(final int paramInt)
  {
    AppMethodBeat.i(226803);
    if (paramInt == this.GjI.jNa)
    {
      AppMethodBeat.o(226803);
      return;
    }
    Log.i(this.TAG, "scrollMvToPosition:" + paramInt + ", snapPosition:" + this.GjI.jNa + ", dataList.size:" + this.mXB.size());
    this.GjL.YQS = true;
    WxRecyclerView localWxRecyclerView;
    com.tencent.mm.hellhoundlib.b.a locala;
    if (paramInt > this.GjI.jNa)
    {
      localWxRecyclerView = this.xUj;
      if (localWxRecyclerView != null)
      {
        locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, locala.aFh(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        localWxRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    for (;;)
    {
      localWxRecyclerView = this.xUj;
      if (localWxRecyclerView == null) {
        break;
      }
      localWxRecyclerView.post((Runnable)new u(this, paramInt));
      AppMethodBeat.o(226803);
      return;
      localWxRecyclerView = this.xUj;
      if (localWxRecyclerView != null)
      {
        locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt + 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, locala.aFh(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        localWxRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    AppMethodBeat.o(226803);
  }
  
  public final void ZQ(int paramInt)
  {
    AppMethodBeat.i(226815);
    Log.v(this.TAG, "alvinluo updateFloatBallMvInfo position: %s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = getActivity().getIntent();
    dbr localdbr;
    Long localLong;
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      com.tencent.mm.plugin.music.model.b.am((Bundle)localObject);
      localObject = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.M((List)this.mXB, paramInt);
      if (localObject == null) {
        break label187;
      }
      localObject = ((com.tencent.mm.plugin.mv.ui.a.b)localObject).GfI;
      if (localObject == null) {
        break label187;
      }
      ((com.tencent.mm.plugin.mv.model.f)localObject).GbA = 0L;
      ((com.tencent.mm.plugin.mv.model.f)localObject).GbB = 0L;
      localdbr = new dbr();
      localLong = ((com.tencent.mm.plugin.mv.model.f)localObject).Gbl;
      if (localLong == null) {
        break label182;
      }
    }
    label182:
    for (long l = localLong.longValue();; l = 0L)
    {
      localdbr.Ruu = com.tencent.mm.ae.d.Fw(l);
      localdbr.Ruv = ((com.tencent.mm.plugin.mv.model.f)localObject).Gbm;
      localdbr.Ruw = ((com.tencent.mm.plugin.mv.model.f)localObject).coverUrl;
      localdbr.Rux = ((com.tencent.mm.plugin.mv.model.f)localObject).Gbn;
      com.tencent.mm.plugin.music.model.b.c(localdbr);
      AppMethodBeat.o(226815);
      return;
      localObject = null;
      break;
    }
    label187:
    AppMethodBeat.o(226815);
  }
  
  public final int a(bds parambds, al paramal)
  {
    int j = 0;
    AppMethodBeat.i(226800);
    p.k(parambds, "songInfo");
    Log.i(this.TAG, "doJumpToApp: ");
    this.GjK = true;
    Object localObject1 = com.tencent.mm.plugin.music.e.k.fet();
    p.j(localObject1, "MusicPlayerManager.Instance()");
    com.tencent.mm.bb.f localf = ((com.tencent.mm.plugin.music.e.k)localObject1).fed();
    Context localContext;
    Object localObject2;
    if (localf != null)
    {
      localObject1 = com.tencent.mm.plugin.music.model.l.FRM;
      localContext = (Context)getContext();
      p.k(localContext, "context");
      if (localf == null)
      {
        Log.e("MusicUIUtil", "doJumpToApp wrapper is null");
        AppMethodBeat.o(226800);
        return -1;
      }
      Log.i("MusicUIUtil", "doJumpToApp MusicType:%d, SongWebUrl:%s, AppId:%s, srcUsername:%s", new Object[] { Integer.valueOf(localf.lVr), localf.lVB, localf.lVG, localf.fUd });
      localObject1 = com.tencent.mm.pluginsdk.model.app.h.aTS(localf.lVG);
      if (localObject1 != null) {
        Log.i("MusicUIUtil", "packageName:%s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName });
      }
      int i;
      while (localf.lVr == 11)
      {
        parambds = new hv();
        EventCenter.instance.publish((IEvent)parambds);
        localObject1 = parambds.fER.appId;
        paramal = parambds.fER.fzM;
        localObject2 = parambds.fER.appUserName;
        i = parambds.fER.fES;
        parambds = paramal;
        if (TextUtils.isEmpty((CharSequence)paramal)) {
          parambds = "";
        }
        Log.i("MusicUIUtil", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { localObject1, parambds, Integer.valueOf(i), localObject2 });
        Log.i("MusicUIUtil", "launch app brand Application");
        com.tencent.mm.plugin.music.model.m.al((String)localObject1, (String)localObject2, i);
        AppMethodBeat.o(226800);
        return 4;
        Log.e("MusicUIUtil", "appInfo is null");
      }
      if ((!TextUtils.isEmpty((CharSequence)localf.lVG)) && (p.h(localf.lVG, "wx485a97c844086dc9")))
      {
        Log.i("MusicUIUtil", "launch qq music Application");
        com.tencent.mm.plugin.music.model.m.b(localf, (Activity)localContext);
        AppMethodBeat.o(226800);
        return 5;
      }
      if ((!TextUtils.isEmpty((CharSequence)localf.lVG)) && (localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName)) && (com.tencent.mm.pluginsdk.model.app.h.u(localContext, localf.lVG))) {
        if (com.tencent.mm.plugin.music.model.m.asG(localf.lVG))
        {
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10910, "4");
          localObject2 = localf.lVB;
          localObject1 = com.tencent.mm.plugin.music.h.e.aSB((String)localObject2);
          parambds = (bds)localObject1;
          if (localObject1 == null) {
            parambds = "";
          }
          localObject2 = com.tencent.mm.plugin.music.h.e.aSA((String)localObject2);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          if (((CharSequence)parambds).length() > 0)
          {
            i = 1;
            if (i == 0)
            {
              if (((CharSequence)localObject1).length() <= 0) {
                break label644;
              }
              i = 1;
              label539:
              if (i == 0) {
                break label649;
              }
            }
            parambds = "qqmusic://qq.com/media/playSonglist?p=%7b%22song%22%3a%5b%7b%22type%22%3a%220%22%2c%22songid%22%3a%22" + parambds + "%22%2c%22songmid%22%3a%22" + (String)localObject1 + "%22%7d%5d%2c%22action%22%3a%22play%22%7d&source=https%3a%2f%2fi.y.qq.com%2fv8%2fplaysong.html%3fADTAG%3dhz_weixin";
            label578:
            Log.i("MusicUIUtil", "launchQQMusic qqMusicActionUrl: %s", new Object[] { parambds });
            localObject1 = Uri.parse(parambds);
            if (localObject1 != null) {
              break label656;
            }
            Log.w("MusicUIUtil", "launchQQMusic parse qq music action url fail, url %s", new Object[] { parambds });
            i = j;
          }
          for (;;)
          {
            if (i != 0)
            {
              AppMethodBeat.o(226800);
              return 7;
              i = 0;
              break;
              label644:
              i = 0;
              break label539;
              label649:
              parambds = "qqmusic://qq.com/ui/jumpTab?p=%7B%22page%22%3A%221%22%7D&source=https%3a%2f%2fi.y.qq.com%2fv8%2fplaysong.html%3fADTAG%3dhz_weixin";
              break label578;
              label656:
              localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
              ((Intent)localObject2).addFlags(268435456);
              i = j;
              if (Util.isIntentAvailable(localContext, (Intent)localObject2))
              {
                localObject1 = com.tencent.mm.pluginsdk.model.app.h.b(localContext, com.tencent.mm.pluginsdk.model.app.h.aTS(localf.lVG));
                parambds = (bds)localObject1;
                if (localObject1 == null) {
                  parambds = "";
                }
                if (((CharSequence)parambds).length() > 0)
                {
                  i = 1;
                  label733:
                  if (i == 0) {
                    break label860;
                  }
                  parambds = localContext.getString(a.h.launch_3rd_detail_app_tips, new Object[] { parambds });
                  label754:
                  p.j(parambds, "if (appName.isNotEmpty()…d_app_tips)\n            }");
                  localObject1 = new com.tencent.mm.ui.widget.a.f.a(localContext);
                  ((com.tencent.mm.ui.widget.a.f.a)localObject1).bBl(parambds).bBp(localContext.getString(a.h.launch_3rd_app_confirm)).bBq(localContext.getString(a.h.app_cancel)).b((f.c)new l.a(localContext, (Intent)localObject2, paramal)).a((f.c)new l.b(paramal));
                  if (!p.h(Looper.myLooper(), Looper.getMainLooper())) {
                    break label872;
                  }
                  ((com.tencent.mm.ui.widget.a.f.a)localObject1).show();
                }
                for (;;)
                {
                  i = 1;
                  break;
                  i = 0;
                  break label733;
                  label860:
                  parambds = localContext.getString(a.h.launch_3rd_app_tips);
                  break label754;
                  label872:
                  com.tencent.e.e.e.ipM().ipR().a((com.tencent.e.e.a)new l.c((com.tencent.mm.ui.widget.a.f.a)localObject1)).ipQ();
                }
              }
            }
          }
          Log.e("MusicUIUtil", "jumpToApp launch QQMusic failed");
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.music.model.l.a(localContext, localf);
      AppMethodBeat.o(226800);
      return 2;
      Log.i("MusicUIUtil", "launch third party app, package name:%s", new Object[] { ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName });
      WXMusicVideoObject localWXMusicVideoObject = new WXMusicVideoObject();
      localWXMusicVideoObject.musicUrl = localf.lVB;
      localWXMusicVideoObject.musicDataUrl = localf.lVz;
      if (parambds != null)
      {
        localObject2 = parambds.identification;
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      localWXMusicVideoObject.identification = URLDecoder.decode((String)localObject1);
      localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localWXMusicVideoObject);
      ((WXMediaMessage)localObject2).sdkVer = 637992960;
      if (parambds != null)
      {
        localObject1 = parambds.extraInfo;
        parambds = (bds)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        parambds = "";
      }
      ((WXMediaMessage)localObject2).messageExt = URLDecoder.decode(parambds);
      com.tencent.mm.pluginsdk.model.app.h.a(localContext, localf.lVG, (WXMediaMessage)localObject2, 0, paramal, null);
      AppMethodBeat.o(226800);
      return 7;
      if (!TextUtils.isEmpty((CharSequence)localf.fUd))
      {
        if (localf.lVB == null) {}
        for (parambds = localf.lVz;; parambds = localf.lVB)
        {
          Log.i("MusicUIUtil", "launch biz H5 url:%s", new Object[] { parambds });
          paramal = new Intent();
          paramal.putExtra("rawUrl", parambds);
          com.tencent.mm.by.c.b(localContext, "webview", ".ui.tools.WebViewUI", paramal);
          AppMethodBeat.o(226800);
          return 6;
        }
      }
      if (parambds != null)
      {
        paramal = parambds.SOQ;
        if (Util.isNullOrNil(paramal)) {
          break label1250;
        }
        Log.i("MusicUIUtil", "use androdiDownloadUrl");
        if (parambds == null) {
          break label1245;
        }
      }
      label1245:
      for (parambds = parambds.SOQ;; parambds = null)
      {
        if (parambds == null) {
          p.iCn();
        }
        p.j(parambds, "songInfo?.androidDownloadUrl!!");
        com.tencent.mm.plugin.music.model.l.bv(localContext, parambds);
        AppMethodBeat.o(226800);
        return 2;
        paramal = null;
        break;
      }
      label1250:
      if (!TextUtils.isEmpty((CharSequence)localf.lVG))
      {
        parambds = com.tencent.mm.plugin.comm.a.ubo;
        if (com.tencent.mm.plugin.comm.a.asG(localf.lVG)) {
          parambds = "https://y.qq.com/m/download/index.html?channelId=2005000732";
        }
      }
      while (!Util.isNullOrNil(parambds))
      {
        com.tencent.mm.plugin.music.model.l.bv(localContext, parambds);
        AppMethodBeat.o(226800);
        return 2;
        parambds = com.tencent.mm.plugin.comm.a.ubo;
        if (com.tencent.mm.plugin.comm.a.asH(localf.lVG))
        {
          parambds = "https://a.app.qq.com/o/simple.jsp?pkgname=com.netease.cloudmusic";
        }
        else
        {
          parambds = com.tencent.mm.plugin.comm.a.ubo;
          if (com.tencent.mm.plugin.comm.a.asJ(localf.lVG))
          {
            parambds = "https://a.app.qq.com/o/simple.jsp?pkgname=com.kugou.android";
          }
          else
          {
            parambds = com.tencent.mm.plugin.comm.a.ubo;
            if (com.tencent.mm.plugin.comm.a.asI(localf.lVG))
            {
              parambds = "https://a.app.qq.com/o/simple.jsp?pkgname=cn.kuwo.player";
            }
            else
            {
              parambds = "";
              continue;
              AppMethodBeat.o(226800);
              return -1;
              parambds = "";
            }
          }
        }
      }
    }
  }
  
  public final void a(long paramLong, String paramString, final com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(226855);
    p.k(paramString, "mvNonceId");
    p.k(paramf, "musicMv");
    Log.i(this.TAG, "getMvDetailInfo mvObjectId:" + paramLong + " mvNonceId:" + paramString + " localId:" + paramf.Gbi);
    Object localObject = com.tencent.mm.plugin.mv.model.i.GbW;
    localObject = com.tencent.mm.plugin.mv.model.i.I(paramLong, paramString);
    if (localObject != null)
    {
      Log.i(this.TAG, "getMvDetailInfo hit cache");
      if (com.tencent.e.h.ZvG.bc((Runnable)new f((att)localObject, this, paramf)) != null) {}
    }
    else
    {
      localObject = (k)this;
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.mv.model.a.h(paramLong, paramString, paramf.hashCode(), ((k)localObject).getActivity().hashCode()));
    }
    AppMethodBeat.o(226855);
  }
  
  public final void fhb()
  {
    AppMethodBeat.i(226764);
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = com.tencent.mm.ui.component.g.b(getActivity()).i(g.class);
    p.j(localObject, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject = (g)localObject;
    com.tencent.mm.plugin.mv.ui.a.b localb = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.M((List)this.mXB, this.wKJ);
    if (localb != null)
    {
      com.tencent.mm.plugin.mv.model.o localo = com.tencent.mm.plugin.mv.model.o.GcB;
      com.tencent.mm.plugin.mv.model.o.b((Context)getContext(), ((g)localObject).GaB, localb.GfI);
    }
    a((g)localObject);
    AppMethodBeat.o(226764);
  }
  
  public final void fhc()
  {
    AppMethodBeat.i(226837);
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null)
    {
      localMultiMediaEffectVideoLayout.MUy.fhc();
      AppMethodBeat.o(226837);
      return;
    }
    AppMethodBeat.o(226837);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> getAdapter()
  {
    AppMethodBeat.i(226735);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.BiY.getValue();
    AppMethodBeat.o(226735);
    return localWxRecyclerAdapter;
  }
  
  public final EffectManager getEffectManager()
  {
    AppMethodBeat.i(226835);
    Object localObject = this.GgY;
    if (localObject != null)
    {
      localObject = ((MultiMediaEffectVideoLayout)localObject).getEffectManager();
      AppMethodBeat.o(226835);
      return localObject;
    }
    AppMethodBeat.o(226835);
    return null;
  }
  
  public final void j(com.tencent.mm.plugin.mv.model.f paramf)
  {
    AppMethodBeat.i(226832);
    p.k(paramf, "musicMv");
    Object localObject = com.tencent.mm.plugin.music.e.k.fet();
    p.j(localObject, "MusicPlayerManager.Instance()");
    localObject = ((com.tencent.mm.plugin.music.e.k)localObject).feg();
    p.j(localObject, "MusicPlayerManager.Instance().musicPlayer");
    int i = ((com.tencent.mm.plugin.music.f.a.d)localObject).getDuration();
    if (i != 0)
    {
      this.GjT.dead();
      localObject = com.tencent.mm.ui.component.g.Xox;
      localObject = ((g)com.tencent.mm.ui.component.g.b(getActivity()).i(g.class)).GaB;
      ((bds)localObject).duration = i;
      Log.i(this.TAG, "syncBeatTrack songId:" + ((bds)localObject).kkU + " songName:" + ((bds)localObject).HLH + " singer:" + ((bds)localObject).ozs + " musicTotalDuration:" + i);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.mv.model.a.e((bds)localObject, i, paramf.hashCode(), getActivity().hashCode()));
      AppMethodBeat.o(226832);
      return;
    }
    Log.i(this.TAG, "wait song start");
    this.GjT.alive();
    AppMethodBeat.o(226832);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226742);
    com.tencent.mm.kernel.h.aGY().a(6860, this.Ghd);
    com.tencent.mm.kernel.h.aGY().a(3763, this.Ghd);
    com.tencent.mm.kernel.h.aGY().a(5292, this.Ghd);
    com.tencent.mm.kernel.h.aGY().a(5904, this.Ghd);
    com.tencent.mm.kernel.h.aGY().a(5286, this.Ghd);
    com.tencent.mm.kernel.h.aGY().a(3627, this.Ghd);
    paramBundle = com.tencent.mm.plugin.finder.upload.g.AAk;
    com.tencent.mm.plugin.finder.upload.g.ecj().a(this.GjU);
    this.GjV.alive();
    AppMethodBeat.o(226742);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(226761);
    this.xUj = ((WxRecyclerView)getActivity().findViewById(b.e.recycler_view));
    paramBundle = this.xUj;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)this.GjL);
    }
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    paramBundle = com.tencent.mm.ui.component.g.b(getActivity()).i(g.class);
    p.j(paramBundle, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    g localg = (g)paramBundle;
    paramBundle = new com.tencent.mm.plugin.mv.ui.a.b(localg.GiV);
    Object localObject1 = paramBundle.GfI;
    p.k(localObject1, "musicMv");
    Object localObject2;
    Object localObject3;
    String str;
    if (((com.tencent.mm.plugin.mv.model.f)localObject1).Gbi != null)
    {
      Log.i(this.TAG, "init local music mv");
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = com.tencent.mm.ui.component.g.b(getActivity()).i(g.class);
      p.j(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
      localObject1 = (g)localObject1;
      Log.i(this.TAG, "asyncCheckPostPermission songId:" + ((g)localObject1).GaB.kkU);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.mv.model.a.c(((g)localObject1).GaB, getActivity().hashCode()));
      this.mXB.add(paramBundle);
      paramBundle = this.xUj;
      if (paramBundle != null) {
        paramBundle.setAdapter((RecyclerView.a)getAdapter());
      }
      paramBundle = this.xUj;
      if (paramBundle != null) {
        paramBundle.a((RecyclerView.k)new h(this));
      }
      this.GjI.jNc = ((a.c)new i(this));
      paramBundle = this.xUj;
      if (paramBundle != null) {
        paramBundle.post((Runnable)new j(this));
      }
      this.GjI.jNb = ((a.b)this.GjR);
      this.GjI.jNd = ((a.d)this.GjS);
      getAdapter().a((RecyclerView.c)new k(this));
      paramBundle = localg.GaB;
      Log.i(this.TAG, "getSongDetailInfo songId:" + paramBundle.kkU + " appId:" + paramBundle.SOJ + " webUrl:" + paramBundle.SOK);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.mv.model.a.k(paramBundle, getActivity().hashCode()));
      localObject2 = localg.GaB;
      Log.i(this.TAG, "getMVList songId:" + ((bds)localObject2).kkU);
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject3 = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      paramBundle = com.tencent.mm.plugin.mv.ui.a.Gfi;
      str = com.tencent.mm.plugin.mv.ui.a.a((bds)localObject2);
      paramBundle = com.tencent.mm.plugin.mv.model.i.GbW;
      p.k(str, "songInfoBase64");
      if (com.tencent.mm.plugin.mv.model.i.pvA) {
        break label810;
      }
      paramBundle = null;
      if (paramBundle == null) {
        break label936;
      }
      Log.i(this.TAG, "getMVList hit cache");
      a(paramBundle);
      this.GjN = true;
    }
    for (;;)
    {
      paramBundle = com.tencent.mm.ui.component.g.Xox;
      ((w)com.tencent.mm.ui.component.g.b(getActivity()).i(w.class)).GjI = this.GjI;
      paramBundle = com.tencent.mm.ui.component.g.Xox;
      ((e)com.tencent.mm.ui.component.g.b(getActivity()).i(e.class)).GiJ = ((com.tencent.mm.plugin.mv.ui.uic.a.a)new l(this));
      paramBundle = com.tencent.mm.ui.component.g.Xox;
      ((j)com.tencent.mm.ui.component.g.b(getActivity()).i(j.class)).a(localg.GaB, localg.FTB);
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramBundle = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      if (paramBundle != null) {
        paramBundle.TJe = Util.currentTicks();
      }
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramBundle = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
      if (paramBundle != null) {
        paramBundle.TJf = 0L;
      }
      fgI();
      AppMethodBeat.o(226761);
      return;
      localObject2 = ((com.tencent.mm.plugin.mv.model.f)localObject1).Gbl;
      localObject3 = ((com.tencent.mm.plugin.mv.model.f)localObject1).Gbm;
      if ((localObject2 != null) && (localObject3 != null))
      {
        l = ((Number)localObject2).longValue();
        a(l, (String)localObject3, (com.tencent.mm.plugin.mv.model.f)localObject1);
        Log.i(this.TAG, "init finder music mv " + l + ' ' + (String)localObject3);
      }
      j((com.tencent.mm.plugin.mv.model.f)localObject1);
      break;
      label810:
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList, songInfoBase64:" + str.hashCode());
      long l = Util.currentTicks();
      paramBundle = (com.tencent.mm.plugin.mv.model.j)com.tencent.mm.plugin.mv.model.i.GbU.get(new com.tencent.mm.plugin.mv.model.k(str));
      if (paramBundle != null)
      {
        if (l - paramBundle.timestamp > 180000L) {
          break label914;
        }
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList success from cache");
      }
      for (localObject1 = paramBundle.GbX;; localObject1 = null)
      {
        paramBundle = (Bundle)localObject1;
        if (localObject1 != null) {
          break;
        }
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList not found");
        paramBundle = null;
        break;
        label914:
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList failed timeout");
        com.tencent.mm.plugin.mv.model.i.GbW.OI(l);
      }
      label936:
      paramBundle = (k)this;
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.mv.model.a.j((dbs)localObject3, (bds)localObject2, str, paramBundle.getActivity().hashCode()));
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(226827);
    Log.i(this.TAG, "onDestroy");
    Object localObject = com.tencent.mm.plugin.finder.upload.g.AAk;
    com.tencent.mm.plugin.finder.upload.g.ecj().b(this.GjU);
    com.tencent.mm.kernel.h.aGY().b(6860, this.Ghd);
    com.tencent.mm.kernel.h.aGY().b(3763, this.Ghd);
    com.tencent.mm.kernel.h.aGY().b(5292, this.Ghd);
    com.tencent.mm.kernel.h.aGY().b(5904, this.Ghd);
    com.tencent.mm.kernel.h.aGY().b(5286, this.Ghd);
    com.tencent.mm.kernel.h.aGY().b(3627, this.Ghd);
    localObject = this.GgY;
    if (localObject != null) {
      ((MultiMediaEffectVideoLayout)localObject).MUy.release();
    }
    this.GjT.dead();
    this.Ghb = false;
    this.GjV.dead();
    localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = com.tencent.mm.ui.component.g.b(getActivity()).i(g.class);
    p.j(localObject, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    g localg = (g)localObject;
    localObject = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.M((List)this.mXB, this.wKJ);
    com.tencent.mm.plugin.mv.model.f localf;
    Context localContext;
    if (localObject != null)
    {
      localf = ((com.tencent.mm.plugin.mv.ui.a.b)localObject).GfI;
      if (localf != null)
      {
        localObject = com.tencent.mm.plugin.mv.model.o.GcB;
        com.tencent.mm.plugin.mv.model.o.b((Context)getContext(), localg.GaB, localf);
        localObject = com.tencent.mm.plugin.mv.model.o.GcB;
        localContext = (Context)getActivity();
        localObject = this.GgY;
        if (localObject == null) {
          break label278;
        }
      }
    }
    label278:
    for (localObject = ((MultiMediaEffectVideoLayout)localObject).getReportInfo();; localObject = null)
    {
      com.tencent.mm.plugin.mv.model.o.a(localContext, localf, (com.tencent.mm.plugin.thumbplayer.e.c)localObject);
      a(localg);
      if (!com.tencent.mm.bb.a.bnx()) {
        com.tencent.mm.bb.a.bnv();
      }
      AppMethodBeat.o(226827);
      return;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(226871);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getByteArrayExtra("key_track_data");
      if (paramIntent != null)
      {
        Object localObject = new dbo();
        ((dbo)localObject).parseFrom(paramIntent);
        paramIntent = com.tencent.mm.plugin.mv.model.f.GbD;
        paramIntent = com.tencent.mm.plugin.mv.model.f.a.b((dbo)localObject);
        c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        localObject = c.a.MS(((dbo)localObject).localId);
        if (localObject != null)
        {
          if (!((FinderItem)localObject).isPostFailed()) {
            break label300;
          }
          paramIntent.Gbu = 3;
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.secdata.ui.a.JbV;
          localObject = (dbs)a.a.a((Context)getContext(), 7, dbs.class);
          if (localObject != null) {
            ((dbs)localObject).scene = 14;
          }
          localObject = com.tencent.mm.plugin.music.e.k.fet();
          p.j(localObject, "MusicPlayerManager.Instance()");
          ((com.tencent.mm.plugin.music.e.k)localObject).feg().wG(0);
          Log.i(this.TAG, "onNewIntent mvLocalId:" + paramIntent.Gbi + " coverPath:" + paramIntent.Gbk + " mvPostStatus:" + paramIntent.Gbu);
          this.Ghb = false;
          this.mXB.add(0, new com.tencent.mm.plugin.mv.ui.a.b(paramIntent));
          getAdapter().notifyDataSetChanged();
          paramIntent = this.xUj;
          if (paramIntent == null) {
            break;
          }
          localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "scrollToPosition", "(I)V");
          paramIntent.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramIntent, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "scrollToPosition", "(I)V");
          AppMethodBeat.o(226871);
          return;
          label300:
          if (!((FinderItem)localObject).isPostFinish()) {
            paramIntent.Gbu = 2;
          } else {
            paramIntent.Gbu = 1;
          }
        }
        AppMethodBeat.o(226871);
        return;
      }
    }
    AppMethodBeat.o(226871);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(226842);
    super.onPause();
    Object localObject = this.GgY;
    if (localObject != null) {
      ((MultiMediaEffectVideoLayout)localObject).pause();
    }
    this.Ghb = true;
    this.GjJ = false;
    Log.i(this.TAG, "onPause");
    localObject = com.tencent.mm.plugin.music.e.k.fet();
    p.j(localObject, "MusicPlayerManager.Instance()");
    ((com.tencent.mm.plugin.music.e.k)localObject).feg().b(this.FOE);
    AppMethodBeat.o(226842);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(226810);
    super.onResume();
    Log.i(this.TAG, "onResume, needResumePosition:" + this.Ghb + ", isJumpToApp:" + this.GjK);
    Object localObject1 = com.tencent.mm.ui.component.g.Xox;
    localObject1 = com.tencent.mm.ui.component.g.b(getActivity()).i(g.class);
    p.j(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    Object localObject3 = (g)localObject1;
    localObject1 = com.tencent.mm.plugin.music.e.k.fet();
    p.j(localObject1, "MusicPlayerManager.Instance()");
    Object localObject2 = ((com.tencent.mm.plugin.music.e.k)localObject1).fed();
    int i;
    if (!((g)localObject3).f((com.tencent.mm.bb.f)localObject2))
    {
      Log.i(this.TAG, "onResume different music firstTimeEnterMusicId:" + ((g)localObject3).GiU + ' ');
      localObject1 = aa.Amg;
      bds localbds = ((g)localObject3).GaB;
      localObject2 = ((g)localObject3).GiU;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((g)localObject3).GaB.kkU;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = ((g)localObject3).GiT;
      if (localObject1 != null)
      {
        i = ((Integer)localObject1).intValue();
        localObject3 = ((g)localObject3).GiV.coverUrl;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        aa.a(localbds, (String)localObject2, i, (String)localObject1);
        this.GjJ = true;
        localObject1 = this.xUj;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).post((Runnable)new o(this));
        }
      }
    }
    for (;;)
    {
      this.Ghb = false;
      localObject1 = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localObject1, "MusicPlayerManager.Instance()");
      ((com.tencent.mm.plugin.music.e.k)localObject1).feg().a(this.FOE);
      AppMethodBeat.o(226810);
      return;
      i = 0;
      break;
      if ((this.Ghb) || (this.GjK))
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("onResume same music ").append(((com.tencent.mm.bb.f)localObject2).lVt).append(' ').append(((com.tencent.mm.bb.f)localObject2).lVr).append(", musicPlayer.isPlaying:");
        localObject3 = com.tencent.mm.plugin.music.e.k.fet();
        p.j(localObject3, "MusicPlayerManager.Instance()");
        localObject3 = ((com.tencent.mm.plugin.music.e.k)localObject3).feg();
        p.j(localObject3, "MusicPlayerManager.Instance().musicPlayer");
        Log.i((String)localObject1, ((com.tencent.mm.plugin.music.f.a.d)localObject3).bnx());
        localObject1 = this.xUj;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).post((Runnable)new p(this));
        }
      }
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(226845);
    super.onStart();
    Log.i(this.TAG, "onStart: ");
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null) {
      localMultiMediaEffectVideoLayout.setMute(true);
    }
    localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null)
    {
      localMultiMediaEffectVideoLayout.start();
      AppMethodBeat.o(226845);
      return;
    }
    AppMethodBeat.o(226845);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(226847);
    super.onStop();
    Log.i(this.TAG, "onStop");
    MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.GgY;
    if (localMultiMediaEffectVideoLayout != null)
    {
      localMultiMediaEffectVideoLayout.MUy.stop();
      AppMethodBeat.o(226847);
      return;
    }
    AppMethodBeat.o(226847);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b>>
  {
    b(k paramk, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$checkVideoLayout$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getCurrentPosition", "", "getTotalDuration", "seekMusic", "", "position", "", "plugin-mv_release"})
  public static final class c
    implements com.tencent.mm.plugin.thumbplayer.view.b
  {
    public final void ZN(int paramInt)
    {
      AppMethodBeat.i(227197);
      com.tencent.mm.plugin.music.e.k localk = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localk, "MusicPlayerManager.Instance()");
      localk.feg().wG(paramInt);
      AppMethodBeat.o(227197);
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(227196);
      Object localObject = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localObject, "MusicPlayerManager.Instance()");
      localObject = ((com.tencent.mm.plugin.music.e.k)localObject).feg();
      p.j(localObject, "MusicPlayerManager.Instance().musicPlayer");
      long l = ((com.tencent.mm.plugin.music.f.a.d)localObject).fdx();
      AppMethodBeat.o(227196);
      return l;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderPostListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-mv_release"})
  public static final class e
    implements com.tencent.mm.plugin.finder.upload.q
  {
    e(AppCompatActivity paramAppCompatActivity) {}
    
    public final void onPostEnd(final long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(233917);
      Log.i(this.GjY.TAG, "onPostEnd " + paramLong + ' ' + paramBoolean);
      Object localObject = this.GjY.mXB;
      int i;
      if (((ArrayList)localObject).size() > 0)
      {
        i = 1;
        if (i == 0) {
          break label122;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          localObject = (com.tencent.mm.plugin.mv.ui.a.b)((ArrayList)localObject).get(0);
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.mv.ui.a.b)localObject).GfI;
            if (localObject != null)
            {
              Long localLong = ((com.tencent.mm.plugin.mv.model.f)localObject).Gbi;
              if (localLong == null)
              {
                AppMethodBeat.o(233917);
                return;
                i = 0;
                break;
                label122:
                localObject = null;
                continue;
              }
              if ((localLong.longValue() == paramLong) && (!paramBoolean))
              {
                ((com.tencent.mm.plugin.mv.model.f)localObject).Gbu = 3;
                com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramLong, paramBoolean));
              }
              AppMethodBeat.o(233917);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(233917);
    }
    
    public final void onPostNotify(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(233921);
      Log.i(this.GjY.TAG, "onPostNotify " + paramLong + ' ' + paramBoolean);
      AppMethodBeat.o(233921);
    }
    
    public final void onPostOk(final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(233919);
      Object localObject1 = this.GjY.mXB;
      int i;
      if (((ArrayList)localObject1).size() > 0)
      {
        i = 1;
        if (i == 0) {
          break label161;
        }
        label30:
        if (localObject1 == null) {
          break label250;
        }
        localObject1 = (com.tencent.mm.plugin.mv.ui.a.b)((ArrayList)localObject1).get(0);
        if (localObject1 == null) {
          break label250;
        }
        localObject1 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject1).GfI;
        if (localObject1 == null) {
          break label250;
        }
        Log.i(this.GjY.TAG, "onPostOk " + paramLong1 + ' ' + paramLong2);
        localObject2 = ((com.tencent.mm.plugin.mv.model.f)localObject1).Gbi;
        if (localObject2 != null) {
          break label167;
        }
      }
      label161:
      label167:
      while (((Long)localObject2).longValue() != paramLong1)
      {
        Log.i(this.GjY.TAG, "first item difference local id " + ((com.tencent.mm.plugin.mv.model.f)localObject1).Gbi + ' ' + paramLong1);
        AppMethodBeat.o(233919);
        return;
        i = 0;
        break;
        localObject1 = null;
        break label30;
      }
      ((com.tencent.mm.plugin.mv.model.f)localObject1).Gbu = 4;
      Object localObject2 = com.tencent.mm.plugin.finder.storage.data.e.AmW;
      localObject2 = e.a.MH(paramLong2);
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.mv.model.f)localObject1).Gbx = ((FinderItem)localObject2).getFeedObject();
        this.GjY.a(((FinderItem)localObject2).getId(), ((FinderItem)localObject2).getObjectNonceId(), (com.tencent.mm.plugin.mv.model.f)localObject1);
      }
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramLong1, paramLong2));
      AppMethodBeat.o(233919);
      return;
      label250:
      Log.i(this.GjY.TAG, "onPostOk not found mv " + paramLong1 + ' ' + paramLong2);
      AppMethodBeat.o(233919);
    }
    
    public final void onPostStart(final long paramLong)
    {
      AppMethodBeat.i(233915);
      Log.i(this.GjY.TAG, "onPostStart ".concat(String.valueOf(paramLong)));
      Object localObject = this.GjY.mXB;
      int i;
      if (((ArrayList)localObject).size() > 0)
      {
        i = 1;
        if (i == 0) {
          break label103;
        }
      }
      for (;;)
      {
        if (localObject != null)
        {
          localObject = (com.tencent.mm.plugin.mv.ui.a.b)((ArrayList)localObject).get(0);
          if (localObject != null)
          {
            localObject = ((com.tencent.mm.plugin.mv.ui.a.b)localObject).GfI;
            if (localObject != null)
            {
              Long localLong = ((com.tencent.mm.plugin.mv.model.f)localObject).Gbi;
              if (localLong == null)
              {
                AppMethodBeat.o(233915);
                return;
                i = 0;
                break;
                label103:
                localObject = null;
                continue;
              }
              if (localLong.longValue() == paramLong)
              {
                ((com.tencent.mm.plugin.mv.model.f)localObject).Gbu = 2;
                com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramLong));
              }
              AppMethodBeat.o(233915);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(233915);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderPostListener$1$onPostEnd$2$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(k.e parame, long paramLong, boolean paramBoolean)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderPostListener$1$onPostOk$2$2"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(k.e parame, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderPostListener$1$onPostStart$2$1"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      c(k.e parame, long paramLong)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$getMvDetailInfo$1$1"})
  static final class f
    implements Runnable
  {
    f(att paramatt, k paramk, com.tencent.mm.plugin.mv.model.f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(233145);
      k.a(jdField_this, this.Ghf, paramf.hashCode());
      AppMethodBeat.o(233145);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$musicListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class g
    extends IListener<np>
  {
    g(AppCompatActivity paramAppCompatActivity) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$1", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-mv_release"})
  public static final class h
    extends RecyclerView.q
  {
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(228838);
      p.k(paramRecyclerView, "rv");
      p.k(paramMotionEvent, "e");
      boolean bool = k.a(this.GjY, paramMotionEvent);
      AppMethodBeat.o(228838);
      return bool;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$2", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-mv_release"})
  public static final class i
    implements a.c
  {
    public final void rJ(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(228203);
      Log.i(this.GjY.TAG, "onPageSettle:" + paramInt + ", lastPos:" + this.GjY.wKJ);
      if (this.GjY.wKJ == paramInt)
      {
        AppMethodBeat.o(228203);
        return;
      }
      if (k.a(this.GjY))
      {
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject1 = (dbs)a.a.a((Context)this.GjY.getContext(), 7, dbs.class);
        if (localObject1 != null) {
          ((dbs)localObject1).scene = 13;
        }
      }
      k.a(this.GjY, false);
      Object localObject1 = this.GjY.xUj;
      if (localObject1 != null)
      {
        localObject1 = ((WxRecyclerView)localObject1).cK(paramInt);
        if (localObject1 == null) {}
      }
      for (localObject1 = ((RecyclerView.v)localObject1).amk;; localObject1 = null)
      {
        Object localObject3 = com.tencent.mm.ui.component.g.Xox;
        localObject3 = (j)com.tencent.mm.ui.component.g.b(this.GjY.getActivity()).i(j.class);
        ((j)localObject3).amk = ((View)localObject1);
        MusicMvLyricView localMusicMvLyricView = ((j)localObject3).fgY();
        if (localMusicMvLyricView != null) {
          localMusicMvLyricView.setEventListener(null);
        }
        if (localObject1 != null) {
          localObject2 = (RecyclerView)((View)localObject1).findViewById(b.e.FXx);
        }
        ((j)localObject3).Gjx = ((RecyclerView)localObject2);
        localObject2 = ((j)localObject3).fgY();
        if (localObject2 != null) {
          ((MusicMvLyricView)localObject2).setEventListener((MusicMvLyricView.h)((j)localObject3).GjD);
        }
        localObject2 = com.tencent.mm.ui.component.g.Xox;
        localObject2 = (f)com.tencent.mm.ui.component.g.b(this.GjY.getActivity()).i(f.class);
        localObject3 = this.GjY.mXB.get(paramInt);
        p.j(localObject3, "dataList[position]");
        ((f)localObject2).a((View)localObject1, (com.tencent.mm.plugin.mv.ui.a.b)localObject3);
        k.a(this.GjY, paramInt);
        this.GjY.wKJ = paramInt;
        this.GjY.ZQ(paramInt);
        AppMethodBeat.o(228203);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(228507);
      this.GjY.GjI.a((RecyclerView)this.GjY.xUj);
      AppMethodBeat.o(228507);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$4", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "plugin-mv_release"})
  public static final class k
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(227234);
      super.onChanged();
      Log.d(this.GjY.TAG, "onChanged, lastPos:" + this.GjY.wKJ + ", dataList.size:" + this.GjY.mXB.size());
      if ((this.GjY.mXB.size() > 0) && (this.GjY.wKJ >= 0))
      {
        WxRecyclerView localWxRecyclerView = this.GjY.xUj;
        if (localWxRecyclerView != null)
        {
          localWxRecyclerView.post((Runnable)new a(this));
          AppMethodBeat.o(227234);
          return;
        }
      }
      AppMethodBeat.o(227234);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(227255);
      super.onItemRangeChanged(paramInt1, paramInt2);
      Log.i(this.GjY.TAG, "onItemRangeChanged, lastPos:" + this.GjY.wKJ + ", positionStart:" + paramInt1 + ", itemCount:" + paramInt2 + ", dataList.size:" + this.GjY.mXB.size());
      if ((this.GjY.mXB.size() > 0) && (this.GjY.wKJ >= 0))
      {
        int i = this.GjY.wKJ;
        if (paramInt1 > i)
        {
          AppMethodBeat.o(227255);
          return;
        }
        if ((paramInt1 + paramInt2 > i) && (!this.GjY.GjI.jMX))
        {
          WxRecyclerView localWxRecyclerView = this.GjY.xUj;
          if (localWxRecyclerView != null)
          {
            localWxRecyclerView.post((Runnable)new b(this));
            AppMethodBeat.o(227255);
            return;
          }
        }
      }
      AppMethodBeat.o(227255);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(227243);
      Log.i(this.GjY.TAG, "onItemRangeChanged, lastPos:" + this.GjY.wKJ + ", positionStart:" + paramInt1 + ", itemCount:" + paramInt2 + ", dataList.size:" + this.GjY.mXB.size() + ", payLoad:" + paramObject);
      k.a locala = k.GjX;
      if ((p.h(paramObject, k.fhd()) ^ true)) {
        super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      }
      AppMethodBeat.o(227243);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(k.k paramk) {}
      
      public final void run()
      {
        AppMethodBeat.i(234124);
        k.a(this.Gkd.GjY, this.Gkd.GjY.wKJ);
        Object localObject1 = this.Gkd.GjY.xUj;
        if (localObject1 != null)
        {
          localObject1 = ((WxRecyclerView)localObject1).cK(this.Gkd.GjY.wKJ);
          if (localObject1 == null) {}
        }
        for (localObject1 = ((RecyclerView.v)localObject1).amk;; localObject1 = null)
        {
          Object localObject2 = com.tencent.mm.ui.component.g.Xox;
          localObject2 = (f)com.tencent.mm.ui.component.g.b(this.Gkd.GjY.getActivity()).i(f.class);
          Object localObject3 = this.Gkd.GjY.mXB.get(this.Gkd.GjY.wKJ);
          p.j(localObject3, "dataList[lastPos]");
          ((f)localObject2).a((View)localObject1, (com.tencent.mm.plugin.mv.ui.a.b)localObject3);
          AppMethodBeat.o(234124);
          return;
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(k.k paramk) {}
      
      public final void run()
      {
        AppMethodBeat.i(233002);
        k.a(this.Gkd.GjY, this.Gkd.GjY.wKJ);
        Object localObject1 = this.Gkd.GjY.xUj;
        if (localObject1 != null)
        {
          localObject1 = ((WxRecyclerView)localObject1).cK(this.Gkd.GjY.wKJ);
          if (localObject1 == null) {}
        }
        for (localObject1 = ((RecyclerView.v)localObject1).amk;; localObject1 = null)
        {
          Object localObject2 = com.tencent.mm.ui.component.g.Xox;
          localObject2 = (f)com.tencent.mm.ui.component.g.b(this.Gkd.GjY.getActivity()).i(f.class);
          Object localObject3 = this.Gkd.GjY.mXB.get(this.Gkd.GjY.wKJ);
          p.j(localObject3, "dataList[lastPos]");
          ((f)localObject2).a((View)localObject1, (com.tencent.mm.plugin.mv.ui.a.b)localObject3);
          AppMethodBeat.o(233002);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$5", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "onDoCopy", "", "feedId", "", "nonceId", "", "commentId", "(Ljava/lang/Long;Ljava/lang/String;J)V", "onDoExpose", "onReferLinkClicked", "plugin-mv_release"})
  public static final class l
    implements com.tencent.mm.plugin.mv.ui.uic.a.a
  {
    public final void J(long paramLong, String paramString)
    {
      AppMethodBeat.i(225152);
      p.k(paramString, "nonceId");
      k localk = this.GjY;
      p.k(paramString, "nonceId");
      Log.i(localk.TAG, "start to switchToMv from id dataList.size:" + localk.mXB.size());
      Object localObject1 = ((Iterable)localk.mXB).iterator();
      int j = 0;
      int i = 0;
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        int m = j + 1;
        if (j < 0) {
          kotlin.a.j.iBO();
        }
        localObject2 = (com.tencent.mm.plugin.mv.ui.a.b)localObject2;
        com.tencent.mm.plugin.mv.model.f.a locala = com.tencent.mm.plugin.mv.model.f.GbD;
        localObject2 = com.tencent.mm.plugin.mv.model.f.a.b(((com.tencent.mm.plugin.mv.ui.a.b)localObject2).GfI);
        if (localObject2 != null)
        {
          int k = i;
          if (((FinderObject)localObject2).id == paramLong)
          {
            k = i;
            if (p.h(((FinderObject)localObject2).objectNonceId, paramString))
            {
              k = 1;
              Log.i(localk.TAG, "switchToMv exist index:".concat(String.valueOf(j)));
              localk.fhb();
              localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
              localObject2 = (dbs)a.a.a((Context)localk.getContext(), 7, dbs.class);
              if (localObject2 != null) {
                ((dbs)localObject2).scene = 11;
              }
              localk.ZP(j);
            }
          }
          j = m;
          i = k;
        }
        else
        {
          j = m;
        }
      }
      if (i == 0)
      {
        Log.i(localk.TAG, "switchToMv not exist");
        localObject1 = localk.mXB;
        localObject2 = new com.tencent.mm.plugin.mv.model.f();
        ((com.tencent.mm.plugin.mv.model.f)localObject2).Gbl = Long.valueOf(paramLong);
        ((com.tencent.mm.plugin.mv.model.f)localObject2).Gbm = paramString;
        localk.a(paramLong, paramString, (com.tencent.mm.plugin.mv.model.f)localObject2);
        ((ArrayList)localObject1).add(new com.tencent.mm.plugin.mv.ui.a.b((com.tencent.mm.plugin.mv.model.f)localObject2));
        i = localk.mXB.size() - 1;
        localk.fhb();
        Log.i(localk.TAG, "switchToMv final index:" + i + ", dataList.size:" + localk.mXB.size());
        localk.getAdapter().cM(i);
        paramString = com.tencent.mm.plugin.secdata.ui.a.JbV;
        paramString = (dbs)a.a.a((Context)localk.getContext(), 7, dbs.class);
        if (paramString != null) {
          paramString.scene = 11;
        }
        localk.ZP(i);
      }
      AppMethodBeat.o(225152);
    }
    
    public final void a(Long paramLong, String paramString, long paramLong1)
    {
      AppMethodBeat.i(225154);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramLong != null)
      {
        localObject1 = localObject2;
        if (paramString != null)
        {
          long l = ((Number)paramLong).longValue();
          localObject1 = k.a(this.GjY, l, paramString);
        }
      }
      paramLong = com.tencent.mm.plugin.mv.model.l.Gcr;
      com.tencent.mm.plugin.mv.model.l.a((com.tencent.mm.plugin.mv.model.f)localObject1, paramLong1);
      AppMethodBeat.o(225154);
    }
    
    public final void b(Long paramLong, String paramString, long paramLong1)
    {
      AppMethodBeat.i(225158);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramLong != null)
      {
        localObject1 = localObject2;
        if (paramString != null)
        {
          long l = ((Number)paramLong).longValue();
          localObject1 = k.a(this.GjY, l, paramString);
        }
      }
      paramLong = com.tencent.mm.plugin.mv.model.l.Gcr;
      com.tencent.mm.plugin.mv.model.l.b((com.tencent.mm.plugin.mv.model.f)localObject1, paramLong1);
      AppMethodBeat.o(225158);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageStartChangeListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "onPageStartChange", "", "position", "", "plugin-mv_release"})
  public static final class n
    implements a.d
  {
    public final void rK(final int paramInt)
    {
      AppMethodBeat.i(230756);
      Log.i(this.GjY.TAG, "onPageStartChange:" + paramInt + ", dataList.size:" + this.GjY.mXB.size());
      if ((paramInt >= this.GjY.mXB.size()) || (paramInt < 0))
      {
        AppMethodBeat.o(230756);
        return;
      }
      k.d(this.GjY);
      k.a(this.GjY, true);
      Object localObject = this.GjY.GgY;
      if (localObject != null)
      {
        kotlin.g.a.b localb = (kotlin.g.a.b)new a(this, paramInt);
        p.k(localb, "callback");
        localObject = ((MultiMediaEffectVideoLayout)localObject).MUy;
        p.k(localb, "callback");
        ((com.tencent.mm.plugin.thumbplayer.d.c)localObject).MQn.ag((kotlin.g.a.b)new c.f(localb));
        AppMethodBeat.o(230756);
        return;
      }
      AppMethodBeat.o(230756);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Bitmap, x>
    {
      a(k.n paramn, int paramInt)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(228255);
      k.a(this.GjY, this.GjY.wKJ);
      WxRecyclerAdapter localWxRecyclerAdapter = this.GjY.getAdapter();
      int i = this.GjY.wKJ;
      k.a locala = k.GjX;
      localWxRecyclerAdapter.e(i, 1, k.fhd());
      AppMethodBeat.o(228255);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(228923);
      Object localObject = this.GjY.GgY;
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).start();
      }
      localObject = this.GjY.getAdapter();
      int i = this.GjY.wKJ;
      k.a locala = k.GjX;
      ((WxRecyclerAdapter)localObject).e(i, 1, k.fhd());
      localObject = com.tencent.mm.plugin.music.e.k.fet();
      p.j(localObject, "MusicPlayerManager.Instance()");
      localObject = ((com.tencent.mm.plugin.music.e.k)localObject).feg();
      p.j(localObject, "MusicPlayerManager.Instance().musicPlayer");
      if (!((com.tencent.mm.plugin.music.f.a.d)localObject).bnx())
      {
        if (!k.b(this.GjY)) {
          break label136;
        }
        this.GjY.ZQ(this.GjY.wKJ);
        localObject = com.tencent.mm.plugin.music.e.k.fet();
        p.j(localObject, "MusicPlayerManager.Instance()");
        ((com.tencent.mm.plugin.music.e.k)localObject).feg().resume();
      }
      for (;;)
      {
        k.c(this.GjY);
        AppMethodBeat.o(228923);
        return;
        label136:
        localObject = this.GjY.GgY;
        if (localObject != null) {
          ((MultiMediaEffectVideoLayout)localObject).setPauseOnVideoPlay(true);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class q
    implements com.tencent.mm.an.i
  {
    q(k paramk, AppCompatActivity paramAppCompatActivity) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(227737);
      if (((paramq instanceof com.tencent.mm.plugin.mv.model.a.a)) && (((com.tencent.mm.plugin.mv.model.a.a)paramq).GcW != 0) && (((com.tencent.mm.plugin.mv.model.a.a)paramq).GcW != paramAppCompatActivity.hashCode()))
      {
        Log.i(this.GjY.TAG, "not the same page of netscene");
        AppMethodBeat.o(227737);
        return;
      }
      paramString = com.tencent.mm.ui.component.g.Xox;
      paramString = com.tencent.mm.ui.component.g.b(paramAppCompatActivity).i(g.class);
      p.j(paramString, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
      Object localObject1 = (g)paramString;
      if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.j))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((com.tencent.mm.plugin.mv.model.a.j)paramq).GbX;
          if (paramString != null)
          {
            k.a(this.GjY, paramString);
            paramString = x.aazN;
          }
        }
        this.GjY.GjN = true;
        AppMethodBeat.o(227737);
        return;
      }
      label209:
      label358:
      label362:
      Object localObject2;
      label256:
      label260:
      label307:
      label311:
      label463:
      label609:
      label614:
      label619:
      label624:
      label629:
      label634:
      label639:
      int i;
      if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.k))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramq = ((com.tencent.mm.plugin.mv.model.a.k)paramq).Gdz;
          if (paramq != null)
          {
            paramString = paramq.SOL;
            if (paramString != null)
            {
              p.j(paramString, "it");
              if (((CharSequence)paramString).length() <= 0) {
                break label609;
              }
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label614;
              }
              if (paramString != null)
              {
                ((g)localObject1).GaB.SOL = paramString;
                paramString = x.aazN;
              }
            }
            paramString = paramq.SMW;
            if (paramString != null)
            {
              p.j(paramString, "it");
              if (((CharSequence)paramString).length() <= 0) {
                break label619;
              }
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label624;
              }
              if (paramString != null)
              {
                ((g)localObject1).GaB.albumName = paramString;
                paramString = x.aazN;
              }
            }
            paramString = paramq.TIC;
            if (paramString != null)
            {
              p.j(paramString, "it");
              if (((CharSequence)paramString).length() <= 0) {
                break label629;
              }
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label634;
              }
              if (paramString != null)
              {
                ((g)localObject1).GaB.SOM = paramString;
                paramString = x.aazN;
              }
            }
            paramString = paramq.SMY;
            if (paramString != null)
            {
              p.j(paramString, "it");
              if (((CharSequence)paramString).length() <= 0) {
                break label639;
              }
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label644;
              }
              if (paramString != null)
              {
                ((g)localObject1).GaB.SMY = paramString;
                paramString = x.aazN;
              }
            }
            paramString = Long.valueOf(paramq.TID);
            if (((Number)paramString).longValue() <= 0L) {
              break label649;
            }
            paramInt1 = 1;
            label402:
            if (paramInt1 == 0) {
              break label654;
            }
            label406:
            if (paramString != null)
            {
              long l = ((Number)paramString).longValue();
              ((g)localObject1).GaB.SOO = l;
              paramString = x.aazN;
            }
            paramString = paramq.SOQ;
            if (paramString != null)
            {
              p.j(paramString, "it");
              if (((CharSequence)paramString).length() <= 0) {
                break label659;
              }
              paramInt1 = 1;
              if (paramInt1 == 0) {
                break label664;
              }
            }
          }
          for (;;)
          {
            if (paramString != null)
            {
              ((g)localObject1).GaB.SOQ = paramString;
              paramString = x.aazN;
            }
            paramString = this.GjY.TAG;
            localObject2 = com.tencent.mm.plugin.mv.ui.a.Gfi;
            Log.v(paramString, "getSongStatus %s", new Object[] { com.tencent.mm.plugin.mv.ui.a.b(((g)localObject1).GaB) });
            ((g)localObject1).fgV();
            paramString = com.tencent.mm.ui.component.g.Xox;
            ((j)com.tencent.mm.ui.component.g.b(paramAppCompatActivity).i(j.class)).a(((g)localObject1).GaB, ((g)localObject1).FTB);
            com.tencent.e.h.ZvG.be((Runnable)new a(paramq, this, (g)localObject1));
            paramString = com.tencent.mm.plugin.mv.model.o.GcB;
            com.tencent.mm.plugin.mv.model.o.a((Context)paramAppCompatActivity, ((g)localObject1).GaB, ((g)localObject1).GiV);
            AppMethodBeat.o(227737);
            return;
            paramInt1 = 0;
            break;
            paramString = null;
            break label209;
            paramInt1 = 0;
            break label256;
            paramString = null;
            break label260;
            paramInt1 = 0;
            break label307;
            paramString = null;
            break label311;
            paramInt1 = 0;
            break label358;
            label644:
            paramString = null;
            break label362;
            label649:
            paramInt1 = 0;
            break label402;
            label654:
            paramString = null;
            break label406;
            label659:
            paramInt1 = 0;
            break label463;
            label664:
            paramString = null;
          }
        }
      }
      else
      {
        if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.h))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = ((com.tencent.mm.plugin.mv.model.a.h)paramq).GaS;
            if (paramString != null)
            {
              k.a(this.GjY, paramString, ((com.tencent.mm.plugin.mv.model.a.h)paramq).Gdt);
              paramString = x.aazN;
              AppMethodBeat.o(227737);
              return;
            }
            AppMethodBeat.o(227737);
            return;
          }
          paramString = ((Iterable)this.GjY.mXB).iterator();
          paramInt1 = 0;
          while (paramString.hasNext())
          {
            localObject1 = paramString.next();
            if (paramInt1 < 0) {
              kotlin.a.j.iBO();
            }
            localObject1 = (com.tencent.mm.plugin.mv.ui.a.b)localObject1;
            if (((com.tencent.mm.plugin.mv.ui.a.b)localObject1).GfI.hashCode() == ((com.tencent.mm.plugin.mv.model.a.h)paramq).Gdt)
            {
              localObject2 = com.tencent.mm.plugin.mv.model.f.GbD;
              localObject2 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject1).GfI;
              p.k(localObject2, "mv");
              ((com.tencent.mm.plugin.mv.model.f)localObject2).wGy = true;
              ((com.tencent.mm.plugin.mv.model.f)localObject2).Gbr = null;
              ((com.tencent.mm.plugin.mv.model.f)localObject2).Gbq = null;
              ((com.tencent.mm.plugin.mv.model.f)localObject2).Gbo.clear();
              ((com.tencent.mm.plugin.mv.model.f)localObject2).likeCount = 0;
              ((com.tencent.mm.plugin.mv.model.f)localObject2).forwardCount = 0;
              ((com.tencent.mm.plugin.mv.model.f)localObject2).commentCount = 0;
              ((com.tencent.mm.plugin.mv.model.f)localObject2).Gbs = false;
              ((com.tencent.mm.plugin.mv.model.f)localObject2).Gbv = null;
              ((com.tencent.mm.plugin.mv.model.f)localObject2).Gbx = null;
              ((com.tencent.mm.plugin.mv.model.f)localObject2).Gby.clear();
              Log.i(this.GjY.TAG, "notifyItemChanged5:".concat(String.valueOf(paramInt1)));
              this.GjY.getAdapter().cL(paramInt1);
              this.GjY.j(((com.tencent.mm.plugin.mv.ui.a.b)localObject1).GfI);
            }
            paramInt1 += 1;
          }
          AppMethodBeat.o(227737);
          return;
        }
        if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.e))
        {
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label1795;
          }
          this.GjY.GjM = true;
          localObject2 = this.GjY.TAG;
          StringBuilder localStringBuilder = new StringBuilder("onSceneEnd MusicLiveGetBeatTrack songId:").append(((com.tencent.mm.plugin.mv.model.a.e)paramq).GaB.kkU).append(" trackPoint:");
          paramString = ((com.tencent.mm.plugin.mv.model.a.e)paramq).Gdj;
          if (paramString != null)
          {
            paramString = paramString.TIt;
            localStringBuilder = localStringBuilder.append(paramString).append(" flexSize:");
            paramString = ((com.tencent.mm.plugin.mv.model.a.e)paramq).Gdj;
            if (paramString == null) {
              break label1361;
            }
            paramString = paramString.TIu;
            if (paramString == null) {
              break label1361;
            }
            paramString = Integer.valueOf(paramString.size());
            label1071:
            Log.i((String)localObject2, paramString);
            i = ((com.tencent.mm.plugin.mv.model.a.e)paramq).Gdk;
            localObject2 = ((com.tencent.mm.plugin.mv.model.a.e)paramq).Gdj;
            if (localObject2 == null) {
              break label1512;
            }
            ((g)localObject1).GiZ = ((day)localObject2).TIu.size();
            paramString = ((Iterable)this.GjY.mXB).iterator();
            paramInt1 = 0;
            label1141:
            if (!paramString.hasNext()) {
              break label1801;
            }
            localObject1 = paramString.next();
            if (paramInt1 < 0) {
              kotlin.a.j.iBO();
            }
            localObject1 = (com.tencent.mm.plugin.mv.ui.a.b)localObject1;
            if (((com.tencent.mm.plugin.mv.ui.a.b)localObject1).GfI.hashCode() != ((com.tencent.mm.plugin.mv.model.a.e)paramq).Gdl) {
              break label1366;
            }
            paramString = ((com.tencent.mm.plugin.mv.ui.a.b)localObject1).GfI;
          }
        }
      }
      for (;;)
      {
        paramq = x.aazN;
        if (paramString != null)
        {
          if ((paramInt1 >= 0) && (paramString.Gbo.isEmpty()))
          {
            paramInt2 = 1;
            label1222:
            if (paramInt2 == 0) {
              break label1378;
            }
          }
          for (;;)
          {
            label1226:
            if (paramString != null)
            {
              paramInt2 = 0;
              paramq = ((day)localObject2).TIt;
              p.j(paramq, "beatTrackResponse.break_point_ms");
              paramq = ((Iterable)paramq).iterator();
              for (;;)
              {
                if (paramq.hasNext())
                {
                  localObject1 = (Integer)paramq.next();
                  localObject2 = new bdt();
                  ((bdt)localObject2).refObjectId = 0L;
                  ((bdt)localObject2).SOS = "";
                  ((bdt)localObject2).MSE = paramInt2;
                  ((bdt)localObject2).SOR = (((Integer)localObject1).intValue() - paramInt2);
                  ((bdt)localObject2).MSG = 0L;
                  paramString.Gbo.add(localObject2);
                  p.j(localObject1, "point");
                  paramInt2 = ((Integer)localObject1).intValue();
                  continue;
                  paramString = null;
                  break;
                  label1361:
                  paramString = null;
                  break label1071;
                  label1366:
                  paramInt1 += 1;
                  break label1141;
                  paramInt2 = 0;
                  break label1222;
                  label1378:
                  paramString = null;
                  break label1226;
                }
              }
              if (paramInt2 < i)
              {
                paramq = new bdt();
                paramq.refObjectId = 0L;
                paramq.SOS = "";
                paramq.MSE = paramInt2;
                paramq.SOR = (i - paramInt2);
                paramq.MSG = 0L;
                paramString.Gbo.add(paramq);
              }
              paramString = x.aazN;
            }
          }
        }
        if (this.GjY.GjN)
        {
          Log.i(this.GjY.TAG, "get beat track notify");
          Log.i(this.GjY.TAG, "notifyItemChanged6:".concat(String.valueOf(paramInt1)));
          this.GjY.getAdapter().cL(paramInt1);
        }
        paramString = x.aazN;
        AppMethodBeat.o(227737);
        return;
        label1512:
        AppMethodBeat.o(227737);
        return;
        if ((paramq instanceof com.tencent.mm.plugin.mv.model.a.c))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = ((com.tencent.mm.plugin.mv.model.a.c)paramq).Gdd;
            if (paramString != null)
            {
              ((g)localObject1).GiW = paramString.TIo;
              ((g)localObject1).GaB.kkU = paramString.TIm;
              ((g)localObject1).verifyInfo = paramString.zfW;
              Log.i(this.GjY.TAG, "NetSceneMusicMvCheckPermission songId:" + paramString.TIm + " mvPostPermissionBit:" + paramString.TIo + " statusVerifyInfo:" + paramString.zfW);
              paramString = x.aazN;
              AppMethodBeat.o(227737);
              return;
            }
            AppMethodBeat.o(227737);
          }
        }
        else if (((paramq instanceof ay)) && (paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i(this.GjY.TAG, "ret delete mv finished");
          if (this.GjY.wKJ < this.GjY.mXB.size())
          {
            paramString = com.tencent.mm.plugin.mv.model.f.GbD;
            com.tencent.mm.plugin.mv.model.f.a.a(((com.tencent.mm.plugin.mv.ui.a.b)this.GjY.mXB.get(this.GjY.wKJ)).GfI);
            ((com.tencent.mm.plugin.mv.ui.a.b)this.GjY.mXB.get(this.GjY.wKJ)).GfI.wGy = true;
            paramString = com.tencent.mm.plugin.music.e.k.fet();
            p.j(paramString, "MusicPlayerManager.Instance()");
            paramString.feg().wG(0);
            this.GjY.getAdapter().aE(this.GjY.wKJ, 1);
          }
        }
        label1795:
        AppMethodBeat.o(227737);
        return;
        label1801:
        paramString = null;
        paramInt1 = -1;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onSceneEndListener$1$2$13"})
    static final class a
      implements Runnable
    {
      a(dbc paramdbc, k.q paramq, g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(228205);
        Object localObject = com.tencent.mm.plugin.music.model.l.FRM;
        localObject = com.tencent.mm.plugin.music.model.l.aA((Activity)jdField_this.wYZ);
        if (localObject != null)
        {
          com.tencent.mm.plugin.music.model.o.feW().b(((com.tencent.mm.plugin.music.model.e.a)localObject).field_musicId, ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbum, this.Gkg.TIC, this.Gkg.SOL, false, false);
          AppMethodBeat.o(228205);
          return;
        }
        AppMethodBeat.o(228205);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
  static final class r
    implements d.a
  {
    r(k paramk) {}
    
    public final void fK(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(231127);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new kotlin.g.b.q(paramInt1) {});
      AppMethodBeat.o(231127);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    s(k paramk)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$refreshVideo$2", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectController$PlayerStatusChangeListener;", "onPause", "", "onResume", "plugin-mv_release"})
  public static final class t
    implements c.c
  {
    t(com.tencent.mm.plugin.mv.model.f paramf) {}
    
    public final void onPause()
    {
      AppMethodBeat.i(230734);
      if (this.Gkl.Gbz > 0L)
      {
        com.tencent.mm.plugin.mv.model.f localf = this.Gkl;
        localf.GbA += cm.bfE() - this.Gkl.Gbz;
        this.Gkl.Gbz = 0L;
      }
      AppMethodBeat.o(230734);
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(230735);
      if (this.Gkl.Gbz > 0L)
      {
        com.tencent.mm.plugin.mv.model.f localf = this.Gkl;
        localf.GbA += cm.bfE() - this.Gkl.Gbz;
      }
      this.Gkl.Gbz = cm.bfE();
      AppMethodBeat.o(230735);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(k paramk, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(230039);
      Log.i(this.GjY.TAG, "post stopScroll");
      WxRecyclerView localWxRecyclerView = this.GjY.xUj;
      if (localWxRecyclerView != null) {
        localWxRecyclerView.ld();
      }
      localWxRecyclerView = this.GjY.xUj;
      if (localWxRecyclerView != null)
      {
        localWxRecyclerView.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243502);
            Log.i(this.Gkm.GjY.TAG, "post smooth scroll");
            WxRecyclerView localWxRecyclerView = this.Gkm.GjY.xUj;
            if (localWxRecyclerView != null)
            {
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.Gkm.jEN, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, locala.aFh(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$scrollMvToPosition$1$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
              localWxRecyclerView.smoothScrollToPosition(((Integer)locala.sf(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$scrollMvToPosition$1$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
              AppMethodBeat.o(243502);
              return;
            }
            AppMethodBeat.o(243502);
          }
        });
        AppMethodBeat.o(230039);
        return;
      }
      AppMethodBeat.o(230039);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.k
 * JD-Core Version:    0.7.0.1
 */