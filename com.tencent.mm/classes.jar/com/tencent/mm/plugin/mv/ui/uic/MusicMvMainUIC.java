package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.v;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.emoji.panel.layout.a.d;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.report.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.h;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout;
import com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.layoutmanager.Flip3DLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.g.b.p;
import kotlin.x;
import kotlinx.coroutines.ai;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "downY", "", "finderCommentEventListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderCommentEventListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderCommentEventListener$1;", "finderPostListener", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getFinderPostListener", "()Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "getBeatTrackFlag", "", "getGetBeatTrackFlag", "()Z", "setGetBeatTrackFlag", "(Z)V", "getRecMvListFlag", "getGetRecMvListFlag", "setGetRecMvListFlag", "isDoPlayMusic", "isDragChangePaged", "isJumpToApp", "lastAction", "", "lastActionTime", "", "lastPos", "getLastPos", "()I", "setLastPos", "(I)V", "layoutManager", "Lcom/tencent/mm/view/layoutmanager/Flip3DLayoutManager;", "musicListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicListener", "()Lcom/tencent/mm/sdk/event/IListener;", "needResumePosition", "onPageSelectedListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageSelectedListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageSelectedListener$1;", "onPageStartChangeListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageStartChangeListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageStartChangeListener$1;", "onSceneEndListener", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "getSnapHelper", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "topPanelMargin", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMMvVideoLayout;)V", "waitDetailDataList", "getWaitDetailDataList", "setWaitDetailDataList", "checkRecycleViewSafeTouch", "e", "Landroid/view/MotionEvent;", "checkVideoLayout", "", "convertTpMediaInfo", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "data", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "deleteMv", "musicMv", "doJumpToApp", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "enableMvListScroll", "enable", "fillMusicMvData", "getEffectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "getMVList", "getMvDetailInfo", "mvObjectId", "mvNonceId", "getSongDetailInfo", "handleGetCommentDetailResponse", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "musicMvHashCode", "handleGetMvRecommendListResponse", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStop", "refreshVideo", "position", "reportLastMvExit", "scrollMvToPosition", "switchToMv", "objectId", "nonceId", "syncBreakTrack", "syncPostPermission", "Companion", "plugin-mv_release"})
public final class MusicMvMainUIC
  extends UIComponent
{
  private static final Object Auk;
  public static final a Aul;
  private ArrayList<com.tencent.mm.plugin.mv.ui.a.b> AtU;
  private final kotlin.f AtV;
  final com.tencent.mm.emoji.panel.layout.a AtW;
  MMMvVideoLayout AtX;
  private boolean AtY;
  private boolean AtZ;
  private boolean Aua;
  private Flip3DLayoutManager Aub;
  boolean Auc;
  boolean Aud;
  private int Aue;
  private final k Auf;
  private final l Aug;
  private final IListener<mx> Auh;
  private final com.tencent.mm.ak.i Aui;
  private final com.tencent.mm.plugin.finder.upload.q Auj;
  public final String TAG;
  private boolean Urh;
  private final MusicMvMainUIC.q Uri;
  private float dep;
  public ArrayList<com.tencent.mm.plugin.mv.ui.a.b> kgc;
  int tex;
  private int uGY;
  WxRecyclerView ufR;
  private long xHU;
  
  static
  {
    AppMethodBeat.i(257196);
    Aul = new a((byte)0);
    Auk = new Object();
    AppMethodBeat.o(257196);
  }
  
  public MusicMvMainUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257195);
    this.TAG = "MicroMsg.Mv.MusicMvMainUIC";
    this.kgc = new ArrayList();
    this.AtU = new ArrayList();
    this.AtV = kotlin.g.ah((kotlin.g.a.a)new b(this, paramAppCompatActivity));
    this.AtW = new com.tencent.mm.emoji.panel.layout.a();
    this.tex = -1;
    this.Aub = new Flip3DLayoutManager((Context)paramAppCompatActivity);
    this.xHU = -1L;
    this.dep = -1.0F;
    this.Aue = -1;
    this.Auf = new k(this);
    this.Aug = new l(this);
    this.Auh = ((IListener)new e(this, paramAppCompatActivity));
    this.Aui = ((com.tencent.mm.ak.i)new o(this, paramAppCompatActivity));
    this.Auj = ((com.tencent.mm.plugin.finder.upload.q)new d(this, paramAppCompatActivity));
    this.Uri = new MusicMvMainUIC.q(this, paramAppCompatActivity);
    AppMethodBeat.o(257195);
  }
  
  private LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> h(com.tencent.mm.plugin.mv.a.e parame)
  {
    AppMethodBeat.i(257193);
    p.h(parame, "data");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Iterable)parame.ApH).iterator();
    int i = 0;
    Object localObject1;
    int k;
    axz localaxz;
    Object localObject3;
    Object localObject4;
    FinderMedia localFinderMedia;
    Object localObject5;
    String str;
    Object localObject2;
    long l;
    int j;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      k = i + 1;
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localaxz = (axz)localObject1;
      if (localaxz.refObjectId == 0L) {
        break label1297;
      }
      localObject3 = (MusicMvMainUIC)this;
      localObject1 = ((Iterable)parame.ApL).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (FinderObject)((Iterator)localObject1).next();
          if (((FinderObject)localObject4).id == localaxz.refObjectId)
          {
            localObject1 = ((FinderObject)localObject4).objectDesc;
            if (localObject1 != null)
            {
              localObject1 = ((FinderObjectDesc)localObject1).media;
              if (localObject1 != null)
              {
                localFinderMedia = (FinderMedia)kotlin.a.j.kt((List)localObject1);
                if (localFinderMedia != null)
                {
                  localObject5 = "video_" + ((FinderObject)localObject4).id;
                  localObject1 = com.tencent.mm.plugin.mv.ui.a.ArA;
                  str = com.tencent.mm.plugin.mv.ui.a.aIp((String)localObject5);
                  localObject2 = localFinderMedia.url;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  localObject5 = new com.tencent.mm.plugin.thumbplayer.d.a((String)localObject5, str, (String)localObject1, kotlin.h.a.cR(localFinderMedia.width), kotlin.h.a.cR(localFinderMedia.height));
                  ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).Ghr = Integer.valueOf(2);
                  ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).dVY = "xV2";
                  localObject2 = localFinderMedia.url_token;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).aTt((String)localObject1);
                  ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).decodeKey = localFinderMedia.decodeKey;
                  localObject2 = localFinderMedia.thumbUrl;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).GR((String)localObject1);
                  localObject2 = localFinderMedia.thumb_url_token;
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).aTu((String)localObject1);
                  ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).Ghv = localaxz.LIl;
                  ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).Ghu = localaxz.Ghu;
                  ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).Ghw = localaxz.Ghw;
                  localObject1 = ((FinderObject)localObject4).objectDesc;
                  if (localObject1 != null)
                  {
                    localObject1 = ((FinderObjectDesc)localObject1).media;
                    if (localObject1 != null)
                    {
                      localObject1 = (FinderMedia)kotlin.a.j.ks((List)localObject1);
                      if (localObject1 != null)
                      {
                        l = ((FinderMedia)localObject1).videoDuration;
                        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).pLQ = (l * 1000L);
                        localObject1 = MMThumbPlayerTextureView.GiC;
                        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).scaleType = MMThumbPlayerTextureView.fxj();
                        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).dLQ = false;
                        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).Ghx = localObject4;
                        localLinkedList.add(localObject5);
                        Log.i(((MusicMvMainUIC)localObject3).TAG, "add mediaTrack network id:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).Ghw + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).Ghu + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject5).Ghv);
                        j = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label623:
      if (j == 0)
      {
        Log.i(this.TAG, "not find ref obj Id:" + localaxz.refObjectId);
        localObject2 = localaxz.LIm;
        if (localObject2 != null)
        {
          p.g(localObject2, "it");
          if (((CharSequence)localObject2).length() > 0)
          {
            j = 1;
            if (j == 0) {
              break label967;
            }
          }
          for (;;)
          {
            if (localObject2 == null) {
              break label1276;
            }
            localObject4 = ((Iterable)parame.ApL).iterator();
            localObject1 = null;
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (FinderObject)((Iterator)localObject4).next();
              if (p.j(localObject2, ((FinderObject)localObject5).objectNonceId))
              {
                localObject3 = ((FinderObject)localObject5).objectDesc;
                if (localObject3 != null)
                {
                  localObject3 = ((FinderObjectDesc)localObject3).media;
                  if (localObject3 != null)
                  {
                    localFinderMedia = (FinderMedia)kotlin.a.j.kt((List)localObject3);
                    if (localFinderMedia != null)
                    {
                      str = "video_" + ((FinderObject)localObject5).objectNonceId;
                      localObject3 = localFinderMedia.url;
                      localObject1 = localObject3;
                      if (localObject3 == null) {
                        localObject1 = "";
                      }
                      localObject1 = new com.tencent.mm.plugin.thumbplayer.d.a(str, (String)localObject1, "", kotlin.h.a.cR(localFinderMedia.width), kotlin.h.a.cR(localFinderMedia.height));
                      ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).pLQ = (localFinderMedia.videoDuration * 1000L);
                      ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).dLQ = true;
                      ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).Ghx = localObject5;
                    }
                  }
                }
              }
            }
            l = 0L;
            break;
            Log.i(((MusicMvMainUIC)localObject3).TAG, "not find ref object media " + i + ' ' + localaxz.refObjectId + ' ' + localaxz.LIm);
            j = 0;
            break label623;
            j = 0;
            break label690;
            localObject2 = null;
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = com.tencent.mm.plugin.mv.a.a.Apj;
            localObject1 = com.tencent.mm.plugin.mv.a.a.evw();
            localObject2 = com.tencent.mm.plugin.mv.a.a.Apj;
            localObject1 = (com.tencent.mm.plugin.mv.a.a)((List)localObject1).get(i % com.tencent.mm.plugin.mv.a.a.evw().size());
            localObject2 = new com.tencent.mm.plugin.thumbplayer.d.a("video_" + ((com.tencent.mm.plugin.mv.a.a)localObject1).name, ((com.tencent.mm.plugin.mv.a.a)localObject1).getFilePath(), "", ((com.tencent.mm.plugin.mv.a.a)localObject1).width, ((com.tencent.mm.plugin.mv.a.a)localObject1).height);
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).pLQ = ((com.tencent.mm.plugin.mv.a.a)localObject1).durationMs;
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).loop = true;
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ght = true;
            ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).dLQ = true;
          }
          if (localObject2 == null) {
            break label1282;
          }
          ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghv = localaxz.LIl;
          ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghu = localaxz.Ghu;
          ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghw = localaxz.Ghw;
          ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).dLQ = true;
          localObject1 = MMThumbPlayerTextureView.GiC;
          ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).scaleType = MMThumbPlayerTextureView.fxj();
          localLinkedList.add(localObject2);
          Log.i(this.TAG, "add mediaTrack local id:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).mediaId + " path:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).path + " width:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).width + " height:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).height + " timeOffsetInClipMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghw + " timeOffsetInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghu + " timeLengthInMvMs:" + ((com.tencent.mm.plugin.thumbplayer.d.a)localObject2).Ghv);
          i = k;
          break;
          label1276:
          localObject1 = null;
        }
      }
      label690:
      label967:
      i = k;
      label1282:
      break;
      AppMethodBeat.o(257193);
      return localLinkedList;
      label1297:
      j = 0;
    }
  }
  
  public final void To(final int paramInt)
  {
    AppMethodBeat.i(257186);
    if (paramInt == this.AtW.hbQ)
    {
      AppMethodBeat.o(257186);
      return;
    }
    Log.i(this.TAG, "scrollMvToPosition:" + paramInt + ", snapPosition:" + this.AtW.hbQ + ", dataList.size:" + this.kgc.size());
    this.Aub.Rpy = true;
    WxRecyclerView localWxRecyclerView;
    com.tencent.mm.hellhoundlib.b.a locala;
    if (paramInt > this.AtW.hbQ)
    {
      localWxRecyclerView = this.ufR;
      if (localWxRecyclerView != null)
      {
        locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localWxRecyclerView, locala.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        localWxRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    for (;;)
    {
      localWxRecyclerView = this.ufR;
      if (localWxRecyclerView == null) {
        break;
      }
      localWxRecyclerView.post((Runnable)new p(this, paramInt));
      AppMethodBeat.o(257186);
      return;
      localWxRecyclerView = this.ufR;
      if (localWxRecyclerView != null)
      {
        locala = com.tencent.mm.hellhoundlib.b.c.a(paramInt + 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localWxRecyclerView, locala.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
        localWxRecyclerView.scrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
      }
    }
    AppMethodBeat.o(257186);
  }
  
  public final void a(long paramLong, String paramString, com.tencent.mm.plugin.mv.a.e parame)
  {
    AppMethodBeat.i(257192);
    p.h(paramString, "mvNonceId");
    p.h(parame, "musicMv");
    Log.i(this.TAG, "getMvDetailInfo mvObjectId:" + paramLong + " mvNonceId:" + paramString + " localId:" + parame.ApB);
    Object localObject = com.tencent.mm.plugin.mv.a.h.Aqi;
    localObject = com.tencent.mm.plugin.mv.a.h.U(paramLong, paramString);
    if (localObject != null)
    {
      Log.i(this.TAG, "getMvDetailInfo hit cache");
      if (com.tencent.f.h.RTc.aV((Runnable)new MusicMvMainUIC.r((ars)localObject, this, parame)) != null) {}
    }
    else
    {
      localObject = (MusicMvMainUIC)this;
      com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.mv.a.a.f(paramLong, paramString, parame.hashCode(), ((MusicMvMainUIC)localObject).getActivity().hashCode()));
    }
    AppMethodBeat.o(257192);
  }
  
  public final void a(ars paramars, int paramInt)
  {
    AppMethodBeat.i(258917);
    p.h(paramars, "resp");
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
    p.g(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject1 = (MusicMvDataUIC)localObject1;
    Object localObject2 = (Iterable)this.kgc;
    int j = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    int i = 0;
    Object localObject3;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (j < 0) {
        kotlin.a.j.hxH();
      }
      localObject3 = (com.tencent.mm.plugin.mv.ui.a.b)localObject3;
      if (((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY.hashCode() != paramInt) {
        break label840;
      }
      if (((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY.ApB != null)
      {
        localObject4 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY.ApB;
        if (localObject4 == null)
        {
          label143:
          ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY.ApP = paramars.feedObject;
          localObject3 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY;
          localObject4 = paramars.LDi;
          p.g(localObject4, "resp.refObjectList");
          p.h(localObject4, "<set-?>");
          ((com.tencent.mm.plugin.mv.a.e)localObject3).ApQ = ((LinkedList)localObject4);
          label191:
          i = 1;
        }
      }
    }
    label451:
    label455:
    label840:
    for (;;)
    {
      j += 1;
      break;
      if (((Long)localObject4).longValue() != 0L) {
        break label143;
      }
      localObject4 = paramars.feedObject;
      if (localObject4 == null) {
        break label191;
      }
      Object localObject5 = com.tencent.mm.plugin.mv.a.e.ApR;
      p.g(localObject4, "obj");
      com.tencent.mm.plugin.mv.a.e.a.a((FinderObject)localObject4, ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY);
      localObject3 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY;
      localObject4 = paramars.LDi;
      p.g(localObject4, "resp.refObjectList");
      ((com.tencent.mm.plugin.mv.a.e)localObject3).bf((LinkedList)localObject4);
      Log.i(this.TAG, "notifyItemChanged1:".concat(String.valueOf(j)));
      getAdapter().ci(j);
      break label191;
      if (i == 0)
      {
        localObject2 = (MusicMvMainUIC)this;
        localObject4 = ((Iterable)((MusicMvMainUIC)localObject2).AtU).iterator();
        i = 0;
        if (!((Iterator)localObject4).hasNext()) {
          break label835;
        }
        localObject3 = ((Iterator)localObject4).next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject3 = (com.tencent.mm.plugin.mv.ui.a.b)localObject3;
        if (((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY.hashCode() != paramInt) {
          break label828;
        }
        localObject5 = paramars.feedObject;
        if (localObject5 == null) {
          break label828;
        }
        localObject4 = com.tencent.mm.plugin.mv.a.e.ApR;
        p.g(localObject5, "obj");
        com.tencent.mm.plugin.mv.a.e.a.a((FinderObject)localObject5, ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY);
        localObject4 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY;
        paramars = paramars.LDi;
        p.g(paramars, "resp.refObjectList");
        ((com.tencent.mm.plugin.mv.a.e)localObject4).bf(paramars);
        paramars = ((MusicMvMainUIC)localObject2).kgc;
        if (paramars.size() != 1) {
          break label609;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label614;
        }
        if (paramars == null) {
          break label667;
        }
        paramars = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.ks((List)paramars);
        if (paramars == null) {
          break label667;
        }
        paramars = paramars.ArY;
        if (paramars == null) {
          break label667;
        }
        if (p.j(paramars, ((MusicMvDataUIC)localObject1).Atp))
        {
          if (((MusicMvDataUIC)localObject1).Atp.ApE == null) {
            break label629;
          }
          localObject1 = ((MusicMvDataUIC)localObject1).Atp.ApE;
          if (localObject1 != null) {
            break label619;
          }
        }
        paramInt = 0;
        if (paramInt == 0) {
          break label662;
        }
        if (paramars == null) {
          break label667;
        }
        ((MusicMvMainUIC)localObject2).kgc.clear();
        ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY.ApO = paramars.ApO;
        ((MusicMvMainUIC)localObject2).kgc.add(localObject3);
        Log.i(((MusicMvMainUIC)localObject2).TAG, "notifyItemChanged2:".concat(String.valueOf(i)));
        ((MusicMvMainUIC)localObject2).getAdapter().ci(0);
      }
      for (;;)
      {
        if (i >= 0) {
          this.AtU.remove(i);
        }
        AppMethodBeat.o(258917);
        return;
        label609:
        paramInt = 0;
        break label451;
        label614:
        paramars = null;
        break label455;
        label619:
        if (((Long)localObject1).longValue() != 0L) {
          break label521;
        }
        label629:
        if (paramars.ApB != null)
        {
          localObject1 = paramars.ApB;
          if ((localObject1 == null) || (((Long)localObject1).longValue() != 0L)) {
            break label521;
          }
        }
        paramInt = 1;
        break label523;
        paramars = null;
        break label527;
        ((MusicMvMainUIC)localObject2).kgc.add(localObject3);
        paramars = ((MusicMvMainUIC)localObject2).kgc;
        if (paramars.size() <= 2)
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label818;
          }
          if (paramars != null)
          {
            paramars = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.kt((List)paramars);
            if (paramars != null) {
              if (!paramars.ArY.tav) {
                break label823;
              }
            }
          }
        }
        for (;;)
        {
          if (paramars != null)
          {
            Log.i(((MusicMvMainUIC)localObject2).TAG, "notifyItemChanged3:".concat(String.valueOf(i)));
            ((MusicMvMainUIC)localObject2).getAdapter().ci(0);
          }
          Log.i(((MusicMvMainUIC)localObject2).TAG, "notifyItemInserted4:" + (((MusicMvMainUIC)localObject2).kgc.size() - 1));
          ((MusicMvMainUIC)localObject2).getAdapter().cj(((MusicMvMainUIC)localObject2).kgc.size() - 1);
          break;
          paramInt = 0;
          break label694;
          paramars = null;
          break label698;
          paramars = null;
        }
        i += 1;
        break;
        i = -1;
      }
    }
  }
  
  public final void a(csb paramcsb)
  {
    AppMethodBeat.i(258916);
    p.h(paramcsb, "resp");
    Object localObject1 = paramcsb.object;
    int i;
    if (((LinkedList)localObject1).size() > 0)
    {
      i = 1;
      if (i == 0) {
        break label222;
      }
      label33:
      if (localObject1 == null) {
        break label248;
      }
      localObject1 = ((Iterable)localObject1).iterator();
    }
    label50:
    label222:
    label246:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label311;
      }
      Object localObject2 = (FinderObject)((Iterator)localObject1).next();
      Object localObject3 = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.kt((List)this.kgc);
      long l;
      if (localObject3 != null)
      {
        localObject3 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject3).ArY;
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.plugin.mv.a.e)localObject3).ApE;
          l = ((FinderObject)localObject2).id;
          if (localObject3 == null) {
            i = 0;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label246;
        }
        localObject3 = new com.tencent.mm.plugin.mv.a.e();
        Object localObject4 = com.tencent.mm.plugin.mv.a.e.ApR;
        p.g(localObject2, "it");
        com.tencent.mm.plugin.mv.a.e.a.a((FinderObject)localObject2, (com.tencent.mm.plugin.mv.a.e)localObject3);
        this.AtU.add(new com.tencent.mm.plugin.mv.ui.a.b((com.tencent.mm.plugin.mv.a.e)localObject3));
        localObject2 = ((com.tencent.mm.plugin.mv.a.e)localObject3).ApE;
        localObject4 = ((com.tencent.mm.plugin.mv.a.e)localObject3).ApF;
        if ((localObject2 == null) || (localObject4 == null)) {
          break label50;
        }
        a(((Number)localObject2).longValue(), (String)localObject4, (com.tencent.mm.plugin.mv.a.e)localObject3);
        break label50;
        i = 0;
        break;
        localObject1 = null;
        break label33;
        if (((Long)localObject3).longValue() == l) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    label248:
    localObject1 = (MusicMvMainUIC)this;
    if (((MusicMvMainUIC)localObject1).Auc)
    {
      Log.i(((MusicMvMainUIC)localObject1).TAG, "get mv list notify, dataList.size:" + ((MusicMvMainUIC)localObject1).kgc.size());
      ((MusicMvMainUIC)localObject1).getAdapter().aq(0, ((MusicMvMainUIC)localObject1).kgc.size());
    }
    label311:
    Log.i(this.TAG, "get mv recommend list " + paramcsb.object.size());
    AppMethodBeat.o(258916);
  }
  
  public final void c(axy paramaxy)
  {
    AppMethodBeat.i(257185);
    p.h(paramaxy, "songInfo");
    Log.i(this.TAG, "doJumpToApp: ");
    this.Aua = true;
    Object localObject = com.tencent.mm.plugin.music.e.k.euj();
    p.g(localObject, "MusicPlayerManager.Instance()");
    localObject = ((com.tencent.mm.plugin.music.e.k)localObject).etU();
    if (localObject != null)
    {
      com.tencent.mm.plugin.music.model.l locall = com.tencent.mm.plugin.music.model.l.AkI;
      com.tencent.mm.plugin.music.model.l.a((Context)getContext(), (com.tencent.mm.ay.f)localObject, paramaxy);
      AppMethodBeat.o(257185);
      return;
    }
    AppMethodBeat.o(257185);
  }
  
  public final void evT()
  {
    this.Aub.Rpy = true;
  }
  
  public final EffectManager evU()
  {
    AppMethodBeat.i(257190);
    Object localObject = this.AtX;
    if (localObject != null)
    {
      localObject = ((MMMvVideoLayout)localObject).getEffector();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).wet;
        AppMethodBeat.o(257190);
        return localObject;
      }
    }
    AppMethodBeat.o(257190);
    return null;
  }
  
  public final void g(com.tencent.mm.plugin.mv.a.e parame)
  {
    AppMethodBeat.i(257189);
    p.h(parame, "musicMv");
    Object localObject = com.tencent.mm.plugin.music.e.k.euj();
    p.g(localObject, "MusicPlayerManager.Instance()");
    localObject = ((com.tencent.mm.plugin.music.e.k)localObject).etW();
    p.g(localObject, "MusicPlayerManager.Instance().musicPlayer");
    int i = ((com.tencent.mm.plugin.music.f.a.d)localObject).getDuration();
    if (i != 0)
    {
      this.Auh.dead();
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = ((MusicMvDataUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class)).Aqo;
      ((axy)localObject).duration = i;
      Log.i(this.TAG, "syncBreakTrack songId:" + ((axy)localObject).AqO + " songName:" + ((axy)localObject).BPc + " singer:" + ((axy)localObject).lDR + " musicTotalDuration:" + i);
      com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.mv.a.a.c((axy)localObject, i, parame.hashCode(), getActivity().hashCode()));
      AppMethodBeat.o(257189);
      return;
    }
    Log.i(this.TAG, "wait song start");
    this.Auh.alive();
    AppMethodBeat.o(257189);
  }
  
  public final void gIh()
  {
    AppMethodBeat.i(258914);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
    p.g(localObject, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject = (MusicMvDataUIC)localObject;
    com.tencent.mm.plugin.mv.ui.a.b localb = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.L((List)this.kgc, this.tex);
    if (localb != null)
    {
      com.tencent.mm.plugin.mv.a.k localk = com.tencent.mm.plugin.mv.a.k.Aql;
      com.tencent.mm.plugin.mv.a.k.b((Context)getContext(), ((MusicMvDataUIC)localObject).Aqo, localb.ArY);
      AppMethodBeat.o(258914);
      return;
    }
    AppMethodBeat.o(258914);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> getAdapter()
  {
    AppMethodBeat.i(257182);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.AtV.getValue();
    AppMethodBeat.o(257182);
    return localWxRecyclerAdapter;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(257183);
    com.tencent.mm.kernel.g.azz().a(6860, this.Aui);
    com.tencent.mm.kernel.g.azz().a(3763, this.Aui);
    com.tencent.mm.kernel.g.azz().a(5292, this.Aui);
    com.tencent.mm.kernel.g.azz().a(5904, this.Aui);
    com.tencent.mm.kernel.g.azz().a(5286, this.Aui);
    com.tencent.mm.kernel.g.azz().a(3627, this.Aui);
    paramBundle = com.tencent.mm.plugin.finder.upload.g.vSJ;
    com.tencent.mm.plugin.finder.upload.g.dBa().a(this.Auj);
    this.Uri.alive();
    AppMethodBeat.o(257183);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(257184);
    this.ufR = ((WxRecyclerView)getActivity().findViewById(2131306757));
    paramBundle = this.ufR;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)this.Aub);
    }
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    paramBundle = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
    p.g(paramBundle, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    MusicMvDataUIC localMusicMvDataUIC = (MusicMvDataUIC)paramBundle;
    Object localObject1 = new com.tencent.mm.plugin.mv.ui.a.b(localMusicMvDataUIC.Atp);
    Object localObject2 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject1).ArY;
    p.h(localObject2, "musicMv");
    Object localObject3;
    String str;
    if (((com.tencent.mm.plugin.mv.a.e)localObject2).ApB != null)
    {
      Log.i(this.TAG, "init local music mv");
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      paramBundle = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
      p.g(paramBundle, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
      paramBundle = (MusicMvDataUIC)paramBundle;
      Log.i(this.TAG, "asyncCheckPostPermission songId:" + paramBundle.Aqo.AqO);
      com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.mv.a.a.a(paramBundle.Aqo, getActivity().hashCode()));
      this.kgc.add(localObject1);
      paramBundle = this.ufR;
      if (paramBundle != null) {
        paramBundle.setAdapter((RecyclerView.a)getAdapter());
      }
      paramBundle = this.ufR;
      if (paramBundle != null) {
        paramBundle.a((RecyclerView.k)new f(this));
      }
      this.AtW.hbS = ((a.c)new g(this));
      paramBundle = this.ufR;
      if (paramBundle != null) {
        paramBundle.post((Runnable)new h(this));
      }
      this.AtW.hbR = ((a.b)this.Auf);
      this.AtW.hbT = ((a.d)this.Aug);
      getAdapter().a((RecyclerView.c)new i(this));
      paramBundle = localMusicMvDataUIC.Aqo;
      Log.i(this.TAG, "getSongDetailInfo songId:" + paramBundle.AqO + " appId:" + paramBundle.LIf + " webUrl:" + paramBundle.LIg);
      if (com.tencent.mm.plugin.music.model.m.akQ(paramBundle.LIf)) {
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.mv.a.a.i(paramBundle, getActivity().hashCode()));
      }
      localObject2 = localMusicMvDataUIC.Aqo;
      Log.i(this.TAG, "getMVList songId:" + ((axy)localObject2).AqO);
      paramBundle = SecDataUIC.CWq;
      localObject3 = (cst)SecDataUIC.a.a((Context)getContext(), 7, cst.class);
      paramBundle = com.tencent.mm.plugin.mv.ui.a.ArA;
      str = com.tencent.mm.plugin.mv.ui.a.b((axy)localObject2);
      paramBundle = com.tencent.mm.plugin.mv.a.h.Aqi;
      p.h(str, "songInfoBase64");
      if (com.tencent.mm.plugin.mv.a.h.mxg) {
        break label829;
      }
      paramBundle = null;
      if (paramBundle == null) {
        break label955;
      }
      Log.i(this.TAG, "getMVList hit cache");
      a(paramBundle);
      this.Aud = true;
    }
    for (;;)
    {
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvSongInfoUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvSongInfoUIC.class)).AtW = this.AtW;
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvChattingUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvChattingUIC.class)).AsZ = ((com.tencent.mm.plugin.mv.ui.uic.a.a)new j(this));
      paramBundle = com.tencent.mm.ui.component.a.PRN;
      ((MusicMvLyricUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvLyricUIC.class)).a(localMusicMvDataUIC.Aqo, localMusicMvDataUIC.Amv);
      paramBundle = SecDataUIC.CWq;
      paramBundle = (cst)SecDataUIC.a.a((Context)getContext(), 7, cst.class);
      if (paramBundle != null) {
        paramBundle.Uue = Util.currentTicks();
      }
      paramBundle = SecDataUIC.CWq;
      paramBundle = (cst)SecDataUIC.a.a((Context)getContext(), 7, cst.class);
      if (paramBundle == null) {
        break label993;
      }
      paramBundle.Uuf = 0L;
      AppMethodBeat.o(257184);
      return;
      paramBundle = ((com.tencent.mm.plugin.mv.a.e)localObject2).ApE;
      localObject3 = ((com.tencent.mm.plugin.mv.a.e)localObject2).ApF;
      if ((paramBundle != null) && (localObject3 != null))
      {
        l = ((Number)paramBundle).longValue();
        a(l, (String)localObject3, (com.tencent.mm.plugin.mv.a.e)localObject2);
        Log.i(this.TAG, "init finder music mv " + l + ' ' + (String)localObject3);
      }
      for (paramBundle = x.SXb;; paramBundle = null)
      {
        if (paramBundle != null) {
          break label827;
        }
        ((MusicMvMainUIC)this).g((com.tencent.mm.plugin.mv.a.e)localObject2);
        paramBundle = x.SXb;
        break;
      }
      label827:
      break;
      label829:
      Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList, songInfoBase64:" + str.hashCode());
      long l = Util.currentTicks();
      paramBundle = (com.tencent.mm.plugin.mv.a.i)com.tencent.mm.plugin.mv.a.h.Aqg.get(new com.tencent.mm.plugin.mv.a.j(str));
      if (paramBundle != null)
      {
        if (l - paramBundle.timestamp > 180000L) {
          break label933;
        }
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList success from cache");
      }
      for (localObject1 = paramBundle.Aqj;; localObject1 = null)
      {
        paramBundle = (Bundle)localObject1;
        if (localObject1 != null) {
          break;
        }
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList not found");
        paramBundle = null;
        break;
        label933:
        Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "tryGetCacheMvRecommendList failed timeout");
        com.tencent.mm.plugin.mv.a.h.Aqi.Hs(l);
      }
      label955:
      paramBundle = (MusicMvMainUIC)this;
      com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.mv.a.a.h((cst)localObject3, (axy)localObject2, str, paramBundle.getActivity().hashCode()));
    }
    label993:
    AppMethodBeat.o(257184);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257188);
    Log.i(this.TAG, "onDestroy");
    Object localObject1 = com.tencent.mm.plugin.finder.upload.g.vSJ;
    com.tencent.mm.plugin.finder.upload.g.dBa().b(this.Auj);
    com.tencent.mm.kernel.g.azz().b(6860, this.Aui);
    com.tencent.mm.kernel.g.azz().b(3763, this.Aui);
    com.tencent.mm.kernel.g.azz().b(5292, this.Aui);
    com.tencent.mm.kernel.g.azz().b(5904, this.Aui);
    com.tencent.mm.kernel.g.azz().b(5286, this.Aui);
    com.tencent.mm.kernel.g.azz().b(3627, this.Aui);
    localObject1 = this.AtX;
    if (localObject1 != null) {
      ((MMMvVideoLayout)localObject1).recycle();
    }
    this.Auh.dead();
    this.AtY = false;
    this.Uri.dead();
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
    p.g(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    localObject1 = (MusicMvDataUIC)localObject1;
    Object localObject2 = com.tencent.mm.plugin.mv.a.k.Aql;
    com.tencent.mm.plugin.mv.a.k.b((Context)getContext(), ((MusicMvDataUIC)localObject1).Aqo, ((com.tencent.mm.plugin.mv.ui.a.b)this.kgc.get(this.tex)).ArY);
    localObject1 = com.tencent.mm.plugin.mv.a.k.Aql;
    localObject2 = (Context)getActivity();
    com.tencent.mm.plugin.mv.a.e locale = ((com.tencent.mm.plugin.mv.ui.a.b)this.kgc.get(this.tex)).ArY;
    localObject1 = this.AtX;
    if (localObject1 != null) {}
    for (localObject1 = ((MMMvVideoLayout)localObject1).getReportInfo();; localObject1 = null)
    {
      com.tencent.mm.plugin.mv.a.k.a((Context)localObject2, locale, (com.tencent.mm.plugin.thumbplayer.d.d)localObject1);
      AppMethodBeat.o(257188);
      return;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(257194);
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getByteArrayExtra("key_track_data");
      if (paramIntent != null)
      {
        Object localObject = new csp();
        ((csp)localObject).parseFrom(paramIntent);
        paramIntent = com.tencent.mm.plugin.mv.a.e.ApR;
        paramIntent = com.tencent.mm.plugin.mv.a.e.a.b((csp)localObject);
        c.a locala = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        localObject = c.a.FS(((csp)localObject).localId);
        if (localObject != null)
        {
          if (!((FinderItem)localObject).isPostFailed()) {
            break label300;
          }
          paramIntent.ApM = 3;
        }
        for (;;)
        {
          localObject = SecDataUIC.CWq;
          localObject = (cst)SecDataUIC.a.a((Context)getContext(), 7, cst.class);
          if (localObject != null) {
            ((cst)localObject).scene = 14;
          }
          localObject = com.tencent.mm.plugin.music.e.k.euj();
          p.g(localObject, "MusicPlayerManager.Instance()");
          ((com.tencent.mm.plugin.music.e.k)localObject).etW().tG(0);
          Log.i(this.TAG, "onNewIntent mvLocalId:" + paramIntent.ApB + " coverPath:" + paramIntent.ApD + " mvPostStatus:" + paramIntent.ApM);
          this.AtY = false;
          this.kgc.add(0, new com.tencent.mm.plugin.mv.ui.a.b(paramIntent));
          getAdapter().notifyDataSetChanged();
          paramIntent = this.ufR;
          if (paramIntent == null) {
            break;
          }
          localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.a(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "scrollToPosition", "(I)V");
          paramIntent.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramIntent, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "scrollToPosition", "(I)V");
          AppMethodBeat.o(257194);
          return;
          label300:
          if (!((FinderItem)localObject).isPostFinish()) {
            paramIntent.ApM = 2;
          } else {
            paramIntent.ApM = 1;
          }
        }
        AppMethodBeat.o(257194);
        return;
      }
    }
    AppMethodBeat.o(257194);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(257191);
    super.onPause();
    MMMvVideoLayout localMMMvVideoLayout = this.AtX;
    if (localMMMvVideoLayout != null) {
      localMMMvVideoLayout.pause();
    }
    this.AtY = true;
    this.AtZ = false;
    Log.i(this.TAG, "onPause");
    AppMethodBeat.o(257191);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(257187);
    super.onResume();
    Log.i(this.TAG, "onResume, needResumePosition:" + this.AtY + ", isJumpToApp:" + this.Aua);
    Object localObject1 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
    p.g(localObject1, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
    Object localObject3 = (MusicMvDataUIC)localObject1;
    localObject1 = com.tencent.mm.plugin.music.e.k.euj();
    p.g(localObject1, "MusicPlayerManager.Instance()");
    Object localObject2 = ((com.tencent.mm.plugin.music.e.k)localObject1).etU();
    int i;
    if (!((MusicMvDataUIC)localObject3).f((com.tencent.mm.ay.f)localObject2))
    {
      Log.i(this.TAG, "onResume different music firstTimeEnterMusicId:" + ((MusicMvDataUIC)localObject3).Ato + ' ');
      localObject1 = ac.vER;
      axy localaxy = ((MusicMvDataUIC)localObject3).Aqo;
      localObject2 = ((MusicMvDataUIC)localObject3).Ato;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((MusicMvDataUIC)localObject3).Aqo.AqO;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = ((MusicMvDataUIC)localObject3).Ura;
      if (localObject1 != null)
      {
        i = ((Integer)localObject1).intValue();
        localObject3 = ((MusicMvDataUIC)localObject3).Atp.coverUrl;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ac.a(localaxy, (String)localObject2, i, (String)localObject1);
        this.AtZ = true;
        localObject1 = this.ufR;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).post((Runnable)new m(this));
        }
      }
    }
    for (;;)
    {
      this.AtY = false;
      AppMethodBeat.o(257187);
      return;
      i = 0;
      break;
      if ((this.AtY) || (this.Aua))
      {
        localObject1 = this.TAG;
        localObject2 = new StringBuilder("onResume same music ").append(((com.tencent.mm.ay.f)localObject2).jeV).append(' ').append(((com.tencent.mm.ay.f)localObject2).jeT).append(", musicPlayer.isPlaying:");
        localObject3 = com.tencent.mm.plugin.music.e.k.euj();
        p.g(localObject3, "MusicPlayerManager.Instance()");
        localObject3 = ((com.tencent.mm.plugin.music.e.k)localObject3).etW();
        p.g(localObject3, "MusicPlayerManager.Instance().musicPlayer");
        Log.i((String)localObject1, ((com.tencent.mm.plugin.music.f.a.d)localObject3).bec());
        localObject1 = this.ufR;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).post((Runnable)new n(this));
        }
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(258915);
    super.onStop();
    Log.i(this.TAG, "onStop");
    AppMethodBeat.o(258915);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$Companion;", "", "()V", "PAYLOAD_NO_VIDEO", "getPAYLOAD_NO_VIDEO", "()Ljava/lang/Object;", "plugin-mv_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b>>
  {
    b(MusicMvMainUIC paramMusicMvMainUIC, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$checkVideoLayout$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MvMusicProxy;", "getCurrentPosition", "", "getTotalDuration", "seekMusic", "", "position", "", "plugin-mv_release"})
  public static final class c
    implements com.tencent.mm.plugin.thumbplayer.view.c
  {
    public final void Tp(int paramInt)
    {
      AppMethodBeat.i(257152);
      com.tencent.mm.plugin.music.e.k localk = com.tencent.mm.plugin.music.e.k.euj();
      p.g(localk, "MusicPlayerManager.Instance()");
      localk.etW().tG(paramInt);
      AppMethodBeat.o(257152);
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(257151);
      Object localObject = com.tencent.mm.plugin.music.e.k.euj();
      p.g(localObject, "MusicPlayerManager.Instance()");
      localObject = ((com.tencent.mm.plugin.music.e.k)localObject).etW();
      p.g(localObject, "MusicPlayerManager.Instance().musicPlayer");
      long l = ((com.tencent.mm.plugin.music.f.a.d)localObject).etn();
      AppMethodBeat.o(257151);
      return l;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderPostListener$1", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostOk", "svrID", "onPostStart", "plugin-mv_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.upload.q
  {
    d(AppCompatActivity paramAppCompatActivity) {}
    
    public final void onPostEnd(final long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(257157);
      Log.i(this.Aum.TAG, "onPostEnd " + paramLong + ' ' + paramBoolean);
      Object localObject = this.Aum.kgc;
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
            localObject = ((com.tencent.mm.plugin.mv.ui.a.b)localObject).ArY;
            if (localObject != null)
            {
              Long localLong = ((com.tencent.mm.plugin.mv.a.e)localObject).ApB;
              if (localLong == null)
              {
                AppMethodBeat.o(257157);
                return;
                i = 0;
                break;
                label122:
                localObject = null;
                continue;
              }
              if ((localLong.longValue() == paramLong) && (!paramBoolean))
              {
                ((com.tencent.mm.plugin.mv.a.e)localObject).ApM = 3;
                com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this, paramLong, paramBoolean));
              }
              AppMethodBeat.o(257157);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(257157);
    }
    
    public final void onPostNotify(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(257159);
      Log.i(this.Aum.TAG, "onPostNotify " + paramLong + ' ' + paramBoolean);
      AppMethodBeat.o(257159);
    }
    
    public final void onPostOk(final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(257158);
      Object localObject1 = this.Aum.kgc;
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
        localObject1 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject1).ArY;
        if (localObject1 == null) {
          break label250;
        }
        Log.i(this.Aum.TAG, "onPostOk " + paramLong1 + ' ' + paramLong2);
        localObject2 = ((com.tencent.mm.plugin.mv.a.e)localObject1).ApB;
        if (localObject2 != null) {
          break label167;
        }
      }
      label161:
      label167:
      while (((Long)localObject2).longValue() != paramLong1)
      {
        Log.i(this.Aum.TAG, "first item difference local id " + ((com.tencent.mm.plugin.mv.a.e)localObject1).ApB + ' ' + paramLong1);
        AppMethodBeat.o(257158);
        return;
        i = 0;
        break;
        localObject1 = null;
        break label30;
      }
      ((com.tencent.mm.plugin.mv.a.e)localObject1).ApM = 4;
      Object localObject2 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
      localObject2 = com.tencent.mm.plugin.finder.storage.data.e.a.Fy(paramLong2);
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.mv.a.e)localObject1).ApP = ((FinderItem)localObject2).getFeedObject();
        this.Aum.a(((FinderItem)localObject2).getId(), ((FinderItem)localObject2).getObjectNonceId(), (com.tencent.mm.plugin.mv.a.e)localObject1);
      }
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this, paramLong1, paramLong2));
      AppMethodBeat.o(257158);
      return;
      label250:
      Log.i(this.Aum.TAG, "onPostOk not found mv " + paramLong1 + ' ' + paramLong2);
      AppMethodBeat.o(257158);
    }
    
    public final void onPostStart(final long paramLong)
    {
      AppMethodBeat.i(257156);
      Log.i(this.Aum.TAG, "onPostStart ".concat(String.valueOf(paramLong)));
      Object localObject = this.Aum.kgc;
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
            localObject = ((com.tencent.mm.plugin.mv.ui.a.b)localObject).ArY;
            if (localObject != null)
            {
              Long localLong = ((com.tencent.mm.plugin.mv.a.e)localObject).ApB;
              if (localLong == null)
              {
                AppMethodBeat.o(257156);
                return;
                i = 0;
                break;
                label103:
                localObject = null;
                continue;
              }
              if (localLong.longValue() == paramLong)
              {
                ((com.tencent.mm.plugin.mv.a.e)localObject).ApM = 2;
                com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, paramLong));
              }
              AppMethodBeat.o(257156);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(257156);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderPostListener$1$onPostEnd$2$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(MusicMvMainUIC.d paramd, long paramLong, boolean paramBoolean)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderPostListener$1$onPostOk$2$2"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(MusicMvMainUIC.d paramd, long paramLong1, long paramLong2)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$finderPostListener$1$onPostStart$2$1"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      c(MusicMvMainUIC.d paramd, long paramLong)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$musicListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
  public static final class e
    extends IListener<mx>
  {
    e(AppCompatActivity paramAppCompatActivity) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$1", "Landroid/support/v7/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-mv_release"})
  public static final class f
    extends RecyclerView.q
  {
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257161);
      p.h(paramRecyclerView, "rv");
      p.h(paramMotionEvent, "e");
      boolean bool = MusicMvMainUIC.a(this.Aum, paramMotionEvent);
      AppMethodBeat.o(257161);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$2", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-mv_release"})
  public static final class g
    implements a.c
  {
    public final void pq(int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(257162);
      Log.i(this.Aum.TAG, "onPageSettle:" + paramInt + ", lastPos:" + this.Aum.tex);
      if (this.Aum.tex == paramInt)
      {
        AppMethodBeat.o(257162);
        return;
      }
      if (MusicMvMainUIC.c(this.Aum))
      {
        localObject1 = SecDataUIC.CWq;
        localObject1 = (cst)SecDataUIC.a.a((Context)this.Aum.getContext(), 7, cst.class);
        if (localObject1 != null) {
          ((cst)localObject1).scene = 13;
        }
      }
      MusicMvMainUIC.a(this.Aum, false);
      Object localObject1 = this.Aum.ufR;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((WxRecyclerView)localObject1).ch(paramInt);
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView.v)localObject1).aus;
          localObject3 = com.tencent.mm.ui.component.a.PRN;
          localObject3 = (MusicMvLyricUIC)com.tencent.mm.ui.component.a.b(this.Aum.getActivity()).get(MusicMvLyricUIC.class);
          ((MusicMvLyricUIC)localObject3).aus = ((View)localObject1);
          MusicMvLyricView localMusicMvLyricView = ((MusicMvLyricUIC)localObject3).evQ();
          if (localMusicMvLyricView != null) {
            localMusicMvLyricView.setEventListener(null);
          }
          if (localObject1 != null) {
            localObject2 = (RecyclerView)((View)localObject1).findViewById(2131304296);
          }
          ((MusicMvLyricUIC)localObject3).AtK = ((RecyclerView)localObject2);
          localObject2 = ((MusicMvLyricUIC)localObject3).evQ();
          if (localObject2 != null) {
            ((MusicMvLyricView)localObject2).setEventListener((MusicMvLyricView.h)((MusicMvLyricUIC)localObject3).AtQ);
          }
          localObject2 = com.tencent.mm.ui.component.a.PRN;
          localObject2 = (MusicMvCommentUIC)com.tencent.mm.ui.component.a.b(this.Aum.getActivity()).get(MusicMvCommentUIC.class);
          localObject3 = this.Aum.kgc.get(paramInt);
          p.g(localObject3, "dataList[position]");
          ((MusicMvCommentUIC)localObject2).a((View)localObject1, (com.tencent.mm.plugin.mv.ui.a.b)localObject3);
          MusicMvMainUIC.a(this.Aum, paramInt);
          this.Aum.tex = paramInt;
          localObject1 = (com.tencent.mm.plugin.mv.ui.a.b)kotlin.a.j.L((List)this.Aum.kgc, paramInt);
          if (localObject1 == null) {
            break label459;
          }
          localObject1 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject1).ArY;
          if (localObject1 == null) {
            break label459;
          }
          ((com.tencent.mm.plugin.mv.a.e)localObject1).Uqt = 0L;
          localObject2 = new css();
          localObject3 = ((com.tencent.mm.plugin.mv.a.e)localObject1).ApE;
          if (localObject3 == null) {
            break label454;
          }
        }
      }
      label454:
      for (long l = ((Long)localObject3).longValue();; l = 0L)
      {
        ((css)localObject2).Ktn = com.tencent.mm.ac.d.zs(l);
        ((css)localObject2).Kto = ((com.tencent.mm.plugin.mv.a.e)localObject1).ApF;
        ((css)localObject2).Ktp = ((com.tencent.mm.plugin.mv.a.e)localObject1).coverUrl;
        ((css)localObject2).Ktq = ((com.tencent.mm.plugin.mv.a.e)localObject1).ApG;
        com.tencent.mm.plugin.music.model.b.c((css)localObject2);
        AppMethodBeat.o(257162);
        return;
        localObject1 = null;
        break;
      }
      label459:
      AppMethodBeat.o(257162);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(MusicMvMainUIC paramMusicMvMainUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(257163);
      this.Aum.AtW.f((RecyclerView)this.Aum.ufR);
      AppMethodBeat.o(257163);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$4", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "plugin-mv_release"})
  public static final class i
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(257166);
      super.onChanged();
      Log.d(this.Aum.TAG, "onChanged, lastPos:" + this.Aum.tex + ", dataList.size:" + this.Aum.kgc.size());
      if ((this.Aum.kgc.size() > 0) && (this.Aum.tex >= 0))
      {
        WxRecyclerView localWxRecyclerView = this.Aum.ufR;
        if (localWxRecyclerView != null)
        {
          localWxRecyclerView.post((Runnable)new a(this));
          AppMethodBeat.o(257166);
          return;
        }
      }
      AppMethodBeat.o(257166);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257168);
      super.onItemRangeChanged(paramInt1, paramInt2);
      Log.i(this.Aum.TAG, "onItemRangeChanged, lastPos:" + this.Aum.tex + ", positionStart:" + paramInt1 + ", itemCount:" + paramInt2 + ", dataList.size:" + this.Aum.kgc.size());
      if ((this.Aum.kgc.size() > 0) && (this.Aum.tex >= 0))
      {
        int i = this.Aum.tex;
        if (paramInt1 > i)
        {
          AppMethodBeat.o(257168);
          return;
        }
        if ((paramInt1 + paramInt2 > i) && (!this.Aum.AtW.hbN))
        {
          WxRecyclerView localWxRecyclerView = this.Aum.ufR;
          if (localWxRecyclerView != null)
          {
            localWxRecyclerView.post((Runnable)new b(this));
            AppMethodBeat.o(257168);
            return;
          }
        }
      }
      AppMethodBeat.o(257168);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(257167);
      Log.i(this.Aum.TAG, "onItemRangeChanged, lastPos:" + this.Aum.tex + ", positionStart:" + paramInt1 + ", itemCount:" + paramInt2 + ", dataList.size:" + this.Aum.kgc.size() + ", payLoad:" + paramObject);
      MusicMvMainUIC.a locala = MusicMvMainUIC.Aul;
      if ((p.j(paramObject, MusicMvMainUIC.evV()) ^ true)) {
        super.onItemRangeChanged(paramInt1, paramInt2, paramObject);
      }
      AppMethodBeat.o(257167);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MusicMvMainUIC.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(257164);
        MusicMvMainUIC.a(this.Aur.Aum, this.Aur.Aum.tex);
        Object localObject1 = this.Aur.Aum.ufR;
        if (localObject1 != null)
        {
          localObject1 = ((WxRecyclerView)localObject1).ch(this.Aur.Aum.tex);
          if (localObject1 == null) {}
        }
        for (localObject1 = ((RecyclerView.v)localObject1).aus;; localObject1 = null)
        {
          Object localObject2 = com.tencent.mm.ui.component.a.PRN;
          localObject2 = (MusicMvCommentUIC)com.tencent.mm.ui.component.a.b(this.Aur.Aum.getActivity()).get(MusicMvCommentUIC.class);
          Object localObject3 = this.Aur.Aum.kgc.get(this.Aur.Aum.tex);
          p.g(localObject3, "dataList[lastPos]");
          ((MusicMvCommentUIC)localObject2).a((View)localObject1, (com.tencent.mm.plugin.mv.ui.a.b)localObject3);
          AppMethodBeat.o(257164);
          return;
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MusicMvMainUIC.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(257165);
        MusicMvMainUIC.a(this.Aur.Aum, this.Aur.Aum.tex);
        Object localObject1 = this.Aur.Aum.ufR;
        if (localObject1 != null)
        {
          localObject1 = ((WxRecyclerView)localObject1).ch(this.Aur.Aum.tex);
          if (localObject1 == null) {}
        }
        for (localObject1 = ((RecyclerView.v)localObject1).aus;; localObject1 = null)
        {
          Object localObject2 = com.tencent.mm.ui.component.a.PRN;
          localObject2 = (MusicMvCommentUIC)com.tencent.mm.ui.component.a.b(this.Aur.Aum.getActivity()).get(MusicMvCommentUIC.class);
          Object localObject3 = this.Aur.Aum.kgc.get(this.Aur.Aum.tex);
          p.g(localObject3, "dataList[lastPos]");
          ((MusicMvCommentUIC)localObject2).a((View)localObject1, (com.tencent.mm.plugin.mv.ui.a.b)localObject3);
          AppMethodBeat.o(257165);
          return;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onCreateAfter$5", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "onReferLinkClicked", "", "feedId", "", "nonceId", "", "plugin-mv_release"})
  public static final class j
    implements com.tencent.mm.plugin.mv.ui.uic.a.a
  {
    public final void B(long paramLong, String paramString)
    {
      AppMethodBeat.i(257169);
      p.h(paramString, "nonceId");
      MusicMvMainUIC localMusicMvMainUIC = this.Aum;
      p.h(paramString, "nonceId");
      Log.i(localMusicMvMainUIC.TAG, "start to switchToMv from id dataList.size:" + localMusicMvMainUIC.kgc.size());
      Object localObject1 = ((Iterable)localMusicMvMainUIC.kgc).iterator();
      int j = 0;
      int i = 0;
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        int m = j + 1;
        if (j < 0) {
          kotlin.a.j.hxH();
        }
        localObject2 = (com.tencent.mm.plugin.mv.ui.a.b)localObject2;
        com.tencent.mm.plugin.mv.a.e.a locala = com.tencent.mm.plugin.mv.a.e.ApR;
        localObject2 = com.tencent.mm.plugin.mv.a.e.a.a(((com.tencent.mm.plugin.mv.ui.a.b)localObject2).ArY);
        if (localObject2 != null)
        {
          int k = i;
          if (((FinderObject)localObject2).id == paramLong)
          {
            k = i;
            if (p.j(((FinderObject)localObject2).objectNonceId, paramString))
            {
              k = 1;
              Log.i(localMusicMvMainUIC.TAG, "switchToMv exist index:".concat(String.valueOf(j)));
              localMusicMvMainUIC.gIh();
              localObject2 = SecDataUIC.CWq;
              localObject2 = (cst)SecDataUIC.a.a((Context)localMusicMvMainUIC.getContext(), 7, cst.class);
              if (localObject2 != null) {
                ((cst)localObject2).scene = 11;
              }
              localMusicMvMainUIC.To(j);
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
        Log.i(localMusicMvMainUIC.TAG, "switchToMv not exist");
        localObject1 = localMusicMvMainUIC.kgc;
        localObject2 = new com.tencent.mm.plugin.mv.a.e();
        ((com.tencent.mm.plugin.mv.a.e)localObject2).ApE = Long.valueOf(paramLong);
        ((com.tencent.mm.plugin.mv.a.e)localObject2).ApF = paramString;
        localMusicMvMainUIC.a(paramLong, paramString, (com.tencent.mm.plugin.mv.a.e)localObject2);
        ((ArrayList)localObject1).add(new com.tencent.mm.plugin.mv.ui.a.b((com.tencent.mm.plugin.mv.a.e)localObject2));
        localMusicMvMainUIC.gIh();
        i = localMusicMvMainUIC.kgc.size() - 1;
        Log.i(localMusicMvMainUIC.TAG, "switchToMv final index:" + i + ", dataList.size:" + localMusicMvMainUIC.kgc.size());
        localMusicMvMainUIC.getAdapter().cj(i);
        paramString = SecDataUIC.CWq;
        paramString = (cst)SecDataUIC.a.a((Context)localMusicMvMainUIC.getContext(), 7, cst.class);
        if (paramString != null) {
          paramString.scene = 11;
        }
        localMusicMvMainUIC.To(i);
      }
      AppMethodBeat.o(257169);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageSelectedListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-mv_release"})
  public static final class k
    implements a.b
  {
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(257170);
      Log.i(this.Aum.TAG, "onPageSelected:".concat(String.valueOf(paramInt)));
      Object localObject1 = this.Aum.kgc;
      int i;
      if (((ArrayList)localObject1).size() > paramInt)
      {
        i = 1;
        if (i == 0) {
          break label288;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.plugin.mv.ui.a.b)((ArrayList)localObject1).get(paramInt);
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject1).ArY;
            if (localObject1 != null)
            {
              Object localObject2 = com.tencent.mm.plugin.mv.a.e.ApR;
              Object localObject3 = com.tencent.mm.plugin.mv.a.e.a.a((com.tencent.mm.plugin.mv.a.e)localObject1);
              if (localObject3 != null)
              {
                localObject1 = new bbn();
                ((bbn)localObject1).tCE = 91;
                localObject2 = new ecq();
                ((ecq)localObject2).hFK = ((FinderObject)localObject3).id;
                ((ecq)localObject2).objectNonceId = ((FinderObject)localObject3).objectNonceId;
                localObject3 = new epf();
                ((epf)localObject3).iJF = cl.aWA();
                ((epf)localObject3).Nng = (cl.aWA() + 1000L);
                ((epf)localObject3).sGB = 1000L;
                ((epf)localObject3).Nnd = 1000L;
                ((epf)localObject3).Nne = 1000L;
                ((epf)localObject3).Nnc = 1;
                ((epf)localObject3).ElR = 1;
                ((epf)localObject3).Nnf = 1000L;
                ((epf)localObject3).vgi = 1000L;
                ((epf)localObject3).Nnh = 1L;
                ((ecq)localObject2).NcN = ((epf)localObject3);
                localObject3 = new cxr();
                ((cxr)localObject3).MCf = 100;
                ((cxr)localObject3).MCg = 1000;
                ((cxr)localObject3).MCq = 100;
                ((ecq)localObject2).NcO = ((cxr)localObject3);
                localObject3 = s.vhF;
                s.c(kotlin.a.j.listOf(localObject2), (bbn)localObject1);
                AppMethodBeat.o(257170);
                return;
                i = 0;
                break;
                label288:
                localObject1 = null;
                continue;
              }
              AppMethodBeat.o(257170);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(257170);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onPageStartChangeListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageStartChangeListener;", "onPageStartChange", "", "position", "", "plugin-mv_release"})
  public static final class l
    implements a.d
  {
    public final void pr(final int paramInt)
    {
      AppMethodBeat.i(257175);
      Log.i(this.Aum.TAG, "onPageStartChange:" + paramInt + ", dataList.size:" + this.Aum.kgc.size());
      if ((paramInt >= this.Aum.kgc.size()) || (paramInt < 0))
      {
        AppMethodBeat.o(257175);
        return;
      }
      MusicMvMainUIC.d(this.Aum);
      MusicMvMainUIC.a(this.Aum, true);
      Object localObject = this.Aum.AtX;
      if (localObject != null)
      {
        localObject = ((MMMvVideoLayout)localObject).getEffector();
        if (localObject != null)
        {
          kotlin.g.a.b localb = (kotlin.g.a.b)new a(this, paramInt);
          p.h(localb, "callback");
          ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).Ghj = localb;
          ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).Ghi = true;
          Log.i(((com.tencent.mm.plugin.thumbplayer.c.a)localObject).TAG, "request snapshot");
          AppMethodBeat.o(257175);
          return;
        }
      }
      AppMethodBeat.o(257175);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Bitmap, x>
    {
      a(MusicMvMainUIC.l paraml, int paramInt)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(MusicMvMainUIC paramMusicMvMainUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(257176);
      MusicMvMainUIC.a(this.Aum, this.Aum.tex);
      WxRecyclerAdapter localWxRecyclerAdapter = this.Aum.getAdapter();
      int i = this.Aum.tex;
      MusicMvMainUIC.a locala = MusicMvMainUIC.Aul;
      localWxRecyclerAdapter.e(i, 1, MusicMvMainUIC.evV());
      AppMethodBeat.o(257176);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(MusicMvMainUIC paramMusicMvMainUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(257177);
      Object localObject = this.Aum.AtX;
      if (localObject != null) {
        ((MMMvVideoLayout)localObject).resume();
      }
      localObject = this.Aum.getAdapter();
      int i = this.Aum.tex;
      MusicMvMainUIC.a locala = MusicMvMainUIC.Aul;
      ((WxRecyclerAdapter)localObject).e(i, 1, MusicMvMainUIC.evV());
      localObject = com.tencent.mm.plugin.music.e.k.euj();
      p.g(localObject, "MusicPlayerManager.Instance()");
      localObject = ((com.tencent.mm.plugin.music.e.k)localObject).etW();
      p.g(localObject, "MusicPlayerManager.Instance().musicPlayer");
      if (!((com.tencent.mm.plugin.music.f.a.d)localObject).bec())
      {
        if (!MusicMvMainUIC.a(this.Aum)) {
          break label122;
        }
        localObject = com.tencent.mm.plugin.music.e.k.euj();
        p.g(localObject, "MusicPlayerManager.Instance()");
        ((com.tencent.mm.plugin.music.e.k)localObject).etW().resume();
      }
      for (;;)
      {
        MusicMvMainUIC.b(this.Aum);
        AppMethodBeat.o(257177);
        return;
        label122:
        localObject = this.Aum.AtX;
        if (localObject != null) {
          ((MMMvVideoLayout)localObject).setPauseVideoOnPlay(true);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class o
    implements com.tencent.mm.ak.i
  {
    o(MusicMvMainUIC paramMusicMvMainUIC, AppCompatActivity paramAppCompatActivity) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(257179);
      if (((paramq instanceof com.tencent.mm.plugin.mv.a.a.m)) && (((com.tencent.mm.plugin.mv.a.a.m)paramq).NoN != 0) && (((com.tencent.mm.plugin.mv.a.a.m)paramq).NoN != paramAppCompatActivity.hashCode()))
      {
        Log.i(this.Aum.TAG, "not the same page of netscene");
        AppMethodBeat.o(257179);
        return;
      }
      paramString = com.tencent.mm.ui.component.a.PRN;
      paramString = com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(MusicMvDataUIC.class);
      p.g(paramString, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
      paramString = (MusicMvDataUIC)paramString;
      if ((paramq instanceof com.tencent.mm.plugin.mv.a.a.h))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = ((com.tencent.mm.plugin.mv.a.a.h)paramq).Aqj;
          if (paramString != null) {
            this.Aum.a(paramString);
          }
        }
        this.Aum.Aud = true;
        AppMethodBeat.o(257179);
        return;
      }
      Object localObject1;
      Object localObject2;
      int i;
      if ((paramq instanceof com.tencent.mm.plugin.mv.a.a.i))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramq = ((com.tencent.mm.plugin.mv.a.a.i)paramq).AqL;
          if (paramq != null)
          {
            paramString.Aqo.LIh = paramq.LIh;
            paramString.Aqo.albumName = paramq.Mxl;
            paramString.Aqo.Djf = paramq.Mxm;
            paramString.Aqo.LIj = paramq.Mxn;
            paramString.Aqo.LIi = paramq.LIi;
            paramString.evO();
            localObject1 = com.tencent.mm.ui.component.a.PRN;
            ((MusicMvLyricUIC)com.tencent.mm.ui.component.a.b(paramAppCompatActivity).get(MusicMvLyricUIC.class)).a(paramString.Aqo, paramString.Amv);
            com.tencent.f.h.RTc.aX((Runnable)new a(paramq, this, paramString));
          }
          paramq = com.tencent.mm.plugin.mv.a.k.Aql;
          com.tencent.mm.plugin.mv.a.k.a((Context)paramAppCompatActivity, paramString.Aqo, paramString.Atp);
          AppMethodBeat.o(257179);
        }
      }
      else
      {
        if ((paramq instanceof com.tencent.mm.plugin.mv.a.a.f))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramString = ((com.tencent.mm.plugin.mv.a.a.f)paramq).Apk;
            if (paramString != null)
            {
              this.Aum.a(paramString, ((com.tencent.mm.plugin.mv.a.a.f)paramq).AqE);
              AppMethodBeat.o(257179);
              return;
            }
            AppMethodBeat.o(257179);
            return;
          }
          paramString = ((Iterable)this.Aum.kgc).iterator();
          paramInt1 = 0;
          while (paramString.hasNext())
          {
            localObject1 = paramString.next();
            if (paramInt1 < 0) {
              kotlin.a.j.hxH();
            }
            localObject1 = (com.tencent.mm.plugin.mv.ui.a.b)localObject1;
            if (((com.tencent.mm.plugin.mv.ui.a.b)localObject1).ArY.hashCode() == ((com.tencent.mm.plugin.mv.a.a.f)paramq).AqE)
            {
              localObject2 = com.tencent.mm.plugin.mv.a.e.ApR;
              localObject2 = ((com.tencent.mm.plugin.mv.ui.a.b)localObject1).ArY;
              p.h(localObject2, "mv");
              ((com.tencent.mm.plugin.mv.a.e)localObject2).tav = true;
              ((com.tencent.mm.plugin.mv.a.e)localObject2).ApJ = null;
              ((com.tencent.mm.plugin.mv.a.e)localObject2).ApI = null;
              ((com.tencent.mm.plugin.mv.a.e)localObject2).ApH.clear();
              ((com.tencent.mm.plugin.mv.a.e)localObject2).likeCount = 0;
              ((com.tencent.mm.plugin.mv.a.e)localObject2).forwardCount = 0;
              ((com.tencent.mm.plugin.mv.a.e)localObject2).commentCount = 0;
              ((com.tencent.mm.plugin.mv.a.e)localObject2).ApK = false;
              ((com.tencent.mm.plugin.mv.a.e)localObject2).ApN = null;
              ((com.tencent.mm.plugin.mv.a.e)localObject2).ApP = null;
              ((com.tencent.mm.plugin.mv.a.e)localObject2).ApQ.clear();
              ((com.tencent.mm.plugin.mv.a.e)localObject2).onr = false;
              Log.i(this.Aum.TAG, "notifyItemChanged5:".concat(String.valueOf(paramInt1)));
              this.Aum.getAdapter().ci(paramInt1);
              this.Aum.g(((com.tencent.mm.plugin.mv.ui.a.b)localObject1).ArY);
            }
            paramInt1 += 1;
          }
          AppMethodBeat.o(257179);
          return;
        }
        if ((paramq instanceof com.tencent.mm.plugin.mv.a.a.c))
        {
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            break label1367;
          }
          this.Aum.Auc = true;
          localObject1 = this.Aum.TAG;
          localObject2 = new StringBuilder("onSceneEnd MusicLiveGetBeatTrack songId:").append(((com.tencent.mm.plugin.mv.a.a.c)paramq).Aqo.AqO).append(" trackPoint:");
          paramString = ((com.tencent.mm.plugin.mv.a.a.c)paramq).Aqu;
          if (paramString != null)
          {
            paramString = paramString.Mxc;
            Log.i((String)localObject1, paramString);
            i = ((com.tencent.mm.plugin.mv.a.a.c)paramq).Aqv;
            localObject1 = ((com.tencent.mm.plugin.mv.a.a.c)paramq).Aqu;
            if (localObject1 == null) {
              break label1083;
            }
            paramString = ((Iterable)this.Aum.kgc).iterator();
            paramInt1 = 0;
            label733:
            if (!paramString.hasNext()) {
              break label1373;
            }
            localObject2 = paramString.next();
            if (paramInt1 < 0) {
              kotlin.a.j.hxH();
            }
            localObject2 = (com.tencent.mm.plugin.mv.ui.a.b)localObject2;
            if (((com.tencent.mm.plugin.mv.ui.a.b)localObject2).ArY.hashCode() != ((com.tencent.mm.plugin.mv.a.a.c)paramq).Aqw) {
              break label945;
            }
            paramString = ((com.tencent.mm.plugin.mv.ui.a.b)localObject2).ArY;
          }
        }
      }
      for (;;)
      {
        if (paramString != null)
        {
          if (paramInt1 >= 0)
          {
            paramInt2 = 1;
            label799:
            if (paramInt2 == 0) {
              break label957;
            }
          }
          for (;;)
          {
            label803:
            if (paramString != null)
            {
              paramString.ApH.clear();
              paramInt2 = 0;
              paramq = ((crz)localObject1).Mxc;
              p.g(paramq, "beatTrackResponse.break_point_ms");
              paramq = ((Iterable)paramq).iterator();
              for (;;)
              {
                if (paramq.hasNext())
                {
                  localObject1 = (Integer)paramq.next();
                  localObject2 = new axz();
                  ((axz)localObject2).refObjectId = 0L;
                  ((axz)localObject2).LIm = "";
                  ((axz)localObject2).Ghu = paramInt2;
                  ((axz)localObject2).LIl = (((Integer)localObject1).intValue() - paramInt2);
                  ((axz)localObject2).Ghw = 0L;
                  paramString.ApH.add(localObject2);
                  p.g(localObject1, "point");
                  paramInt2 = ((Integer)localObject1).intValue();
                  continue;
                  paramString = null;
                  break;
                  label945:
                  paramInt1 += 1;
                  break label733;
                  paramInt2 = 0;
                  break label799;
                  label957:
                  paramString = null;
                  break label803;
                }
              }
              if (paramInt2 < i)
              {
                paramq = new axz();
                paramq.refObjectId = 0L;
                paramq.LIm = "";
                paramq.Ghu = paramInt2;
                paramq.LIl = (i - paramInt2);
                paramq.Ghw = 0L;
                paramString.ApH.add(paramq);
              }
            }
          }
        }
        if (this.Aum.Aud)
        {
          Log.i(this.Aum.TAG, "get beat track notify");
          Log.i(this.Aum.TAG, "notifyItemChanged6:".concat(String.valueOf(paramInt1)));
          this.Aum.getAdapter().ci(paramInt1);
        }
        AppMethodBeat.o(257179);
        return;
        label1083:
        AppMethodBeat.o(257179);
        return;
        if ((paramq instanceof com.tencent.mm.plugin.mv.a.a.a))
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            paramq = ((com.tencent.mm.plugin.mv.a.a.a)paramq).Aqn;
            if (paramq != null)
            {
              paramString.Atq = paramq.MwZ;
              paramString.Aqo.AqO = paramq.MwX;
              paramString.fuN = paramq.uFc;
              Log.i(this.Aum.TAG, "NetSceneMusicMvCheckPermission songId:" + paramq.MwX + " mvPostPermissionBit:" + paramq.MwZ + " statusVerifyInfo:" + paramq.uFc);
              AppMethodBeat.o(257179);
              return;
            }
            AppMethodBeat.o(257179);
          }
        }
        else if (((paramq instanceof av)) && (paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i(this.Aum.TAG, "ret delete mv finished");
          if (this.Aum.tex < this.Aum.kgc.size())
          {
            paramString = com.tencent.mm.plugin.mv.a.e.ApR;
            com.tencent.mm.plugin.mv.a.e.a.e(((com.tencent.mm.plugin.mv.ui.a.b)this.Aum.kgc.get(this.Aum.tex)).ArY);
            ((com.tencent.mm.plugin.mv.ui.a.b)this.Aum.kgc.get(this.Aum.tex)).ArY.tav = true;
            paramString = com.tencent.mm.plugin.music.e.k.euj();
            p.g(paramString, "MusicPlayerManager.Instance()");
            paramString.etW().tG(0);
            this.Aum.getAdapter().aq(this.Aum.tex, 1);
          }
        }
        label1367:
        AppMethodBeat.o(257179);
        return;
        label1373:
        paramString = null;
        paramInt1 = -1;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$onSceneEndListener$1$2$1"})
    static final class a
      implements Runnable
    {
      a(csd paramcsd, MusicMvMainUIC.o paramo, MusicMvDataUIC paramMusicMvDataUIC) {}
      
      public final void run()
      {
        AppMethodBeat.i(257178);
        Object localObject = com.tencent.mm.plugin.music.model.l.AkI;
        localObject = com.tencent.mm.plugin.music.model.l.au((Activity)jdField_this.uQi);
        if (localObject != null)
        {
          o.euD().b(((com.tencent.mm.plugin.music.model.e.a)localObject).field_musicId, ((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbum, this.Auu.Mxm, this.Auu.LIh, false, false);
          AppMethodBeat.o(257178);
          return;
        }
        AppMethodBeat.o(257178);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class p
    implements Runnable
  {
    p(MusicMvMainUIC paramMusicMvMainUIC, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(257181);
      Log.i(this.Aum.TAG, "post stopScroll");
      WxRecyclerView localWxRecyclerView = this.Aum.ufR;
      if (localWxRecyclerView != null) {
        localWxRecyclerView.kQ();
      }
      localWxRecyclerView = this.Aum.ufR;
      if (localWxRecyclerView != null)
      {
        localWxRecyclerView.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(257180);
            Log.i(this.Aux.Aum.TAG, "post smooth scroll");
            WxRecyclerView localWxRecyclerView = this.Aux.Aum.ufR;
            if (localWxRecyclerView != null)
            {
              com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(this.Aux.gUj, new com.tencent.mm.hellhoundlib.b.a());
              com.tencent.mm.hellhoundlib.a.a.a(localWxRecyclerView, locala.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$scrollMvToPosition$1$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
              localWxRecyclerView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$scrollMvToPosition$1$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
              AppMethodBeat.o(257180);
              return;
            }
            AppMethodBeat.o(257180);
          }
        });
        AppMethodBeat.o(257181);
        return;
      }
      AppMethodBeat.o(257181);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC
 * JD-Core Version:    0.7.0.1
 */