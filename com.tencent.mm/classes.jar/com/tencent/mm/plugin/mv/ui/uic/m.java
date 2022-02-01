package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.model.e.g;
import com.tencent.mm.plugin.mv.model.e.h;
import com.tencent.mm.plugin.mv.ui.a.a.a;
import com.tencent.mm.plugin.thumbplayer.view.MMTPVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVEditActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVEditActionCallback;", "setActionCallback", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVEditActionCallback;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fixMvCardRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getFixMvCardRV", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "fixMvCardRV$delegate", "fromScene", "", "initMusicDataList", "isEdit", "", "()Z", "setEdit", "(Z)V", "isEditNewItem", "setEditNewItem", "itemDecoration", "Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "getItemDecoration", "()Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "itemDecoration$delegate", "lastPos", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "musicProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVItemSizeResolver;", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPVideoLayout;", "checkCanDoNext", "createMvData", "originTrackData", "disableCurrentSyncMusic", "", "getCurrentCardView", "Landroid/view/View;", "getCurrentEditData", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "itemData", "getSamePrefixItem", "initEditUI", "makeMediaThumbTransition", "pos", "newItem", "onAnimationEnd", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "nextAnimationInfo", "moveToNextItem", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onDestroy", "onNextBtnClicked", "onPause", "onResume", "onSwitchIn", "onSwitchOut", "pauseVideo", "refreshVideo", "refreshView", "resumeVideo", "rollbackItemImpl", "item", "rollbackLastEditItem", "rollbackToInitItem", "takePhoto", "isFixMode", "minRecordDurationMs", "maxRecordDurationMs", "takePhotoFinished", "result", "updateAlbumItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "updateFinderItem", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "updateLyric", "currentPos", "totalDuration", "updateMusicItemList", "itemList", "", "originItemList", "Companion", "IMVEditItemAction", "IMVItemSizeResolver", "ItemEditActionCallback", "MVEditActionCallback", "MVItemSizeResolver", "MusicMVVideoItemConverterFactory", "plugin-mv_release"})
public final class m
  extends UIComponent
{
  public static final m.a GkC;
  private final kotlin.f BiY;
  public com.tencent.mm.plugin.music.model.e.a FRG;
  public dbo Geg;
  private final kotlin.f Get;
  public final com.tencent.mm.emoji.panel.layout.a GjI;
  public boolean GkA;
  public MMTPVideoLayout GkB;
  public final ArrayList<com.tencent.mm.plugin.mv.model.e> Gkv;
  private final kotlin.f Gkw;
  public final f Gkx;
  private final d.a Gky;
  public e Gkz;
  public int fromScene;
  public final ArrayList<com.tencent.mm.plugin.mv.model.e> mXB;
  private final ak oDi;
  public int wKJ;
  public boolean wNB;
  private final kotlin.f zQC;
  
  static
  {
    AppMethodBeat.i(226351);
    GkC = new m.a((byte)0);
    AppMethodBeat.o(226351);
  }
  
  public m(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(226350);
    this.Get = kotlin.g.ar((kotlin.g.a.a)new m.i(paramAppCompatActivity));
    this.mXB = new ArrayList();
    this.Gkv = new ArrayList();
    this.BiY = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.zQC = kotlin.g.ar((kotlin.g.a.a)new m.n(paramAppCompatActivity));
    this.Gkw = kotlin.g.ar((kotlin.g.a.a)new m.m(paramAppCompatActivity));
    this.GjI = new com.tencent.mm.emoji.panel.layout.a();
    this.Gkx = new f();
    this.wKJ = -1;
    this.Gky = ((d.a)new p(this));
    this.oDi = al.iRe();
    AppMethodBeat.o(226350);
  }
  
  public final void ZS(int paramInt)
  {
    AppMethodBeat.i(226343);
    if (paramInt != this.wKJ)
    {
      com.tencent.mm.plugin.mv.model.e locale = (com.tencent.mm.plugin.mv.model.e)kotlin.a.j.M((List)this.mXB, this.wKJ);
      RecyclerView.v localv;
      a.a locala;
      if ((locale != null) && (locale.xUg))
      {
        locale.xUg = false;
        locale.GaV = false;
        localv = fhf().cK(this.wKJ);
        if ((localv instanceof com.tencent.mm.view.recyclerview.i))
        {
          locala = com.tencent.mm.plugin.mv.ui.a.a.GfF;
          a.a.a((com.tencent.mm.view.recyclerview.i)localv, locale);
        }
      }
      locale = (com.tencent.mm.plugin.mv.model.e)kotlin.a.j.M((List)this.mXB, paramInt);
      if (locale != null)
      {
        if (!locale.xUg)
        {
          locale.xUg = true;
          locale.GaV = true;
          localv = fhf().cK(paramInt);
          if ((localv instanceof com.tencent.mm.view.recyclerview.i))
          {
            locala = com.tencent.mm.plugin.mv.ui.a.a.GfF;
            a.a.a((com.tencent.mm.view.recyclerview.i)localv, locale);
          }
        }
        AppMethodBeat.o(226343);
        return;
      }
    }
    AppMethodBeat.o(226343);
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.mv.model.e parame, final kotlin.g.a.b<? super com.tencent.mm.plugin.mv.model.g, x> paramb)
  {
    AppMethodBeat.i(226319);
    Object localObject = getLayoutManager().findViewByPosition(paramInt);
    if (localObject != null)
    {
      localObject = (ImageView)((View)localObject).findViewById(b.e.FXT);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        ((ImageView)localObject).setAlpha(0.0F);
        e.g localg = parame.GaW;
        if (localg != null)
        {
          localg.a((ImageView)localObject, (h.a)new o((ImageView)localObject, parame, paramb));
          AppMethodBeat.o(226319);
          return;
        }
        AppMethodBeat.o(226319);
        return;
      }
      AppMethodBeat.o(226319);
      return;
    }
    AppMethodBeat.o(226319);
  }
  
  public final void dmf()
  {
    AppMethodBeat.i(226336);
    Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "pauseVideo");
    Object localObject1 = fhf().cK(this.wKJ);
    if (localObject1 == null)
    {
      AppMethodBeat.o(226336);
      return;
    }
    kotlin.g.b.p.j(localObject1, "fixMvCardRV.findViewHold…sition(lastPos) ?: return");
    localObject1 = (MMTPVideoLayout)((RecyclerView.v)localObject1).amk.findViewById(b.e.music_video_layout);
    if (localObject1 != null)
    {
      localObject2 = ((MMTPVideoLayout)localObject1).getPlayer();
      if (localObject2 != null) {
        com.tencent.mm.plugin.thumbplayer.f.b.b((com.tencent.mm.plugin.thumbplayer.f.b)localObject2);
      }
      localObject1 = ((MMTPVideoLayout)localObject1).getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).stop();
      }
    }
    com.tencent.mm.plugin.mv.model.e locale;
    if (this.wKJ >= 0)
    {
      localObject1 = this.mXB.get(this.wKJ);
      kotlin.g.b.p.j(localObject1, "dataList[lastPos]");
      locale = (com.tencent.mm.plugin.mv.model.e)localObject1;
      localObject1 = this.GkB;
      if (localObject1 == null) {
        break label199;
      }
      localObject1 = ((MMTPVideoLayout)localObject1).getPlayer();
      if (localObject1 == null) {
        break label199;
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.f.b)localObject1).MTd;
      localObject2 = this.GkB;
      if (localObject2 == null) {
        break label204;
      }
      localObject2 = ((MMTPVideoLayout)localObject2).getEffector();
      if (localObject2 == null) {
        break label204;
      }
    }
    label199:
    label204:
    for (Object localObject2 = ((com.tencent.mm.plugin.thumbplayer.d.g)localObject2).MRa;; localObject2 = null)
    {
      com.tencent.mm.plugin.mv.model.o localo = com.tencent.mm.plugin.mv.model.o.GcB;
      com.tencent.mm.plugin.mv.model.o.a((Context)getActivity(), this.Geg, this.wKJ, locale, (com.tencent.mm.plugin.thumbplayer.e.a)localObject1, (com.tencent.mm.plugin.thumbplayer.e.b)localObject2);
      AppMethodBeat.o(226336);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void dmg()
  {
    AppMethodBeat.i(226338);
    Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "resumeVideo");
    getAdapter().cL(this.GjI.jNa);
    AppMethodBeat.o(226338);
  }
  
  public final dbo e(dbo paramdbo)
  {
    AppMethodBeat.i(226331);
    dbo localdbo;
    Object localObject3;
    int i;
    int j;
    if (paramdbo != null)
    {
      localdbo = new dbo();
      localdbo.localId = paramdbo.localId;
      localdbo.TIV = new FinderObject();
      Object localObject1 = paramdbo.TIV;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).toByteArray();
        if (localObject1 == null) {}
      }
      try
      {
        localObject3 = localdbo.TIV;
        if (localObject3 != null) {
          ((FinderObject)localObject3).parseFrom((byte[])localObject1);
        }
      }
      catch (Exception localException)
      {
        HashSet localHashSet;
        Object localObject6;
        Object localObject7;
        Object localObject8;
        for (;;)
        {
          int k;
          StringBuilder localStringBuilder;
          Log.printErrStackTrace("MicroMsg.Mv.MusicMvMakerFixEditUIC", (Throwable)localException, "createMvData", new Object[0]);
          localObject2 = x.aazN;
          continue;
          long l = 0L;
          continue;
          localObject3 = null;
          continue;
          localObject4 = null;
          continue;
          localObject4 = null;
          continue;
          localObject4 = null;
          continue;
          localObject3 = null;
          continue;
          j = k;
          continue;
          j = k;
        }
        localObject3 = localdbo.SGC;
        Object localObject4 = paramdbo.SGC;
        kotlin.g.b.p.j(localObject4, "it.refObjectList");
        Object localObject5 = (Iterable)localObject4;
        localObject4 = (Collection)new ArrayList();
        localObject5 = ((Iterable)localObject5).iterator();
        for (;;)
        {
          if (!((Iterator)localObject5).hasNext()) {
            break label1216;
          }
          localObject6 = ((Iterator)localObject5).next();
          localObject7 = (FinderObject)localObject6;
          localObject8 = paramdbo.TIX;
          if (localObject8 != null)
          {
            localObject8 = ((bdp)localObject8).SOB;
            if (localObject8 != null)
            {
              localObject8 = (Iterable)localObject8;
              if ((!(localObject8 instanceof Collection)) || (!((Collection)localObject8).isEmpty()))
              {
                localObject8 = ((Iterable)localObject8).iterator();
                while (((Iterator)localObject8).hasNext()) {
                  if (kotlin.g.b.p.h(((bdt)((Iterator)localObject8).next()).SOS, ((FinderObject)localObject7).objectNonceId))
                  {
                    j = 1;
                    if ((j != 1) || (!localHashSet.add(((FinderObject)localObject7).objectNonceId))) {
                      break label1211;
                    }
                  }
                }
              }
            }
          }
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label1214;
            }
            ((Collection)localObject4).add(localObject6);
            break label1038;
            i = 0;
            localObject2 = localObject3;
            break;
            j = 0;
            break label1160;
          }
        }
        ((LinkedList)localObject3).addAll((Collection)localObject4);
        localdbo.TIW = paramdbo.TIW;
        if (this.fromScene == 0) {
          break label1295;
        }
      }
      localdbo.TIX = paramdbo.TIX;
      localObject3 = null;
      localObject1 = null;
      i = 0;
      localHashSet = new HashSet();
      localObject4 = localdbo.TIV;
      if (localObject4 != null)
      {
        localObject4 = ((FinderObject)localObject4).objectDesc;
        if (localObject4 != null)
        {
          localObject4 = ((FinderObjectDesc)localObject4).mvInfo;
          if (localObject4 != null) {
            ((bdp)localObject4).SOF = 0;
          }
        }
      }
      localObject4 = localdbo.TIV;
      if (localObject4 != null)
      {
        localObject4 = ((FinderObject)localObject4).objectDesc;
        if (localObject4 != null)
        {
          localObject4 = ((FinderObjectDesc)localObject4).mvInfo;
          if (localObject4 != null)
          {
            localObject4 = ((bdp)localObject4).SOE;
            if (localObject4 != null) {
              ((LinkedList)localObject4).clear();
            }
          }
        }
      }
      localdbo.SGC.clear();
      localObject4 = localdbo.TIV;
      if (localObject4 != null)
      {
        localObject4 = ((FinderObject)localObject4).objectDesc;
        if (localObject4 != null)
        {
          localObject4 = ((FinderObjectDesc)localObject4).mvInfo;
          if (localObject4 != null)
          {
            localObject4 = ((bdp)localObject4).SOB;
            if (localObject4 != null)
            {
              localObject6 = ((Iterable)localObject4).iterator();
              j = 0;
              if (((Iterator)localObject6).hasNext())
              {
                localObject3 = ((Iterator)localObject6).next();
                k = j + 1;
                if (j < 0) {
                  kotlin.a.j.iBO();
                }
                localObject7 = (bdt)localObject3;
                localObject8 = (com.tencent.mm.plugin.mv.model.e)kotlin.a.j.M((List)this.mXB, j);
                if (localObject8 != null)
                {
                  localObject3 = ((com.tencent.mm.plugin.mv.model.e)localObject8).GaX;
                  if (localObject3 != null)
                  {
                    localObject5 = ((e.h)localObject3).ffY();
                    if (localObject5 != null)
                    {
                      ((bdt)localObject7).refObjectId = ((FinderObject)localObject5).id;
                      ((bdt)localObject7).SOS = ((FinderObject)localObject5).objectNonceId;
                      localObject3 = ((com.tencent.mm.plugin.mv.model.e)this.mXB.get(j)).GaX;
                      if (localObject3 != null)
                      {
                        l = ((e.h)localObject3).ffW();
                        ((bdt)localObject7).MSG = l;
                        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "set finderMVTrack, timeOffsetInClipMs:" + ((bdt)localObject7).MSG);
                        if (localHashSet.add(((FinderObject)localObject5).objectNonceId))
                        {
                          localObject3 = ((FinderObject)localObject5).objectDesc;
                          if (localObject3 != null) {
                            ((FinderObjectDesc)localObject3).mvInfo = new bdp();
                          }
                          localObject3 = ((FinderObject)localObject5).objectDesc;
                          if (localObject3 != null)
                          {
                            localObject3 = ((FinderObjectDesc)localObject3).mvInfo;
                            if (localObject3 != null) {
                              ((bdp)localObject3).SOF = 0;
                            }
                          }
                          localObject3 = ((FinderObject)localObject5).objectDesc;
                          if (localObject3 != null)
                          {
                            localObject3 = ((FinderObjectDesc)localObject3).mvInfo;
                            if (localObject3 != null)
                            {
                              localObject3 = ((bdp)localObject3).SOB;
                              if (localObject3 != null) {
                                ((LinkedList)localObject3).add(localObject7);
                              }
                            }
                          }
                          localObject3 = ((FinderObject)localObject5).objectDesc;
                          if (localObject3 != null) {
                            ((FinderObjectDesc)localObject3).mediaType = 4;
                          }
                          localObject3 = ((FinderObject)localObject5).objectDesc;
                          if (localObject3 != null)
                          {
                            localObject3 = ((FinderObjectDesc)localObject3).media;
                            if (localObject3 != null)
                            {
                              localObject3 = (FinderMedia)((LinkedList)localObject3).getFirst();
                              if (localObject3 != null) {
                                ((FinderMedia)localObject3).mediaType = 4;
                              }
                            }
                          }
                          localObject3 = ((FinderObject)localObject5).objectDesc;
                          if (localObject3 == null) {
                            break label947;
                          }
                          localObject3 = ((FinderObjectDesc)localObject3).media;
                          if (localObject3 == null) {
                            break label947;
                          }
                          localObject3 = (FinderMedia)((LinkedList)localObject3).getFirst();
                          localStringBuilder = new StringBuilder("ref object media size:");
                          localObject4 = ((FinderObject)localObject5).objectDesc;
                          if (localObject4 == null) {
                            break label953;
                          }
                          localObject4 = ((FinderObjectDesc)localObject4).media;
                          if (localObject4 == null) {
                            break label953;
                          }
                          localObject4 = Integer.valueOf(((LinkedList)localObject4).size());
                          localStringBuilder = localStringBuilder.append(localObject4).append(", ");
                          if (localObject3 == null) {
                            break label959;
                          }
                          localObject4 = ((FinderMedia)localObject3).url;
                          localStringBuilder = localStringBuilder.append((String)localObject4).append(", [");
                          if (localObject3 == null) {
                            break label965;
                          }
                          localObject4 = Float.valueOf(((FinderMedia)localObject3).width);
                          localObject4 = localStringBuilder.append(localObject4).append(' ');
                          if (localObject3 == null) {
                            break label971;
                          }
                          localObject3 = Float.valueOf(((FinderMedia)localObject3).height);
                          Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", localObject3 + ']');
                          localdbo.SGC.add(localObject5);
                        }
                        if (((FinderObject)localObject5).id == 0L)
                        {
                          localObject3 = ((FinderObject)localObject5).objectNonceId;
                          if ((localObject3 != null) && (n.M((String)localObject3, "local_", false) == true))
                          {
                            ((bdt)localObject7).SOT = 1;
                            Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "createMvData isFirstUpload " + ((FinderObject)localObject5).objectNonceId);
                          }
                        }
                        if ((((com.tencent.mm.plugin.mv.model.e)localObject8).GaY == null) || (localObject1 != null)) {
                          break label1610;
                        }
                        i = (int)((bdt)localObject7).MSE;
                        localObject1 = localObject5;
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
    label947:
    label953:
    label959:
    label965:
    label1610:
    for (;;)
    {
      j = k;
      break;
      Object localObject2;
      label971:
      paramdbo = localdbo.TIW;
      if ((paramdbo == null) || (n.pu(paramdbo, ".auto") != true))
      {
        paramdbo = (CharSequence)localdbo.TIW;
        if ((paramdbo != null) && (paramdbo.length() != 0)) {
          break label1555;
        }
        j = 1;
        if (j == 0) {}
      }
      else
      {
        paramdbo = com.tencent.mm.ui.component.g.Xox;
        paramdbo = (p)com.tencent.mm.ui.component.g.b(getActivity()).i(p.class);
        paramdbo = new kotlin.o(Integer.valueOf(paramdbo.GlA), paramdbo.GlB);
        j = ((Number)paramdbo.Mx).intValue();
        localObject3 = (Bitmap)paramdbo.My;
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "originCoverPath:" + localdbo.TIW + ", fromScene:" + this.fromScene + ", thumbObj:" + localObject2 + ", thumbMvTime:" + i + " firstRenderTime:" + j + ", firstRenderFrame:" + localObject3);
        if ((j > i) || (localObject3 == null)) {
          break label1560;
        }
        paramdbo = com.tencent.mm.plugin.mv.ui.a.Gfi;
        if (localObject2 != null)
        {
          localObject2 = ((FinderObject)localObject2).objectNonceId;
          paramdbo = (dbo)localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          paramdbo = UUID.randomUUID().toString();
          kotlin.g.b.p.j(paramdbo, "UUID.randomUUID().toString()");
        }
        paramdbo = com.tencent.mm.plugin.mv.ui.a.aSH(paramdbo);
        paramdbo = paramdbo + ".auto";
        BitmapUtil.saveBitmapToImage((Bitmap)localObject3, 70, Bitmap.CompressFormat.PNG, paramdbo, false);
        localdbo.TIW = paramdbo;
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "auto generate thumb succeed: ".concat(String.valueOf(paramdbo)));
      }
      for (;;)
      {
        AppMethodBeat.o(226331);
        return localdbo;
        j = 0;
        break;
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "current firstRenderTime[" + j + "] large than thumbMvTime[" + i + "], do not generate thumb!");
      }
      AppMethodBeat.o(226331);
      return null;
    }
  }
  
  public final WxRecyclerView fhf()
  {
    AppMethodBeat.i(226311);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.Get.getValue();
    AppMethodBeat.o(226311);
    return localWxRecyclerView;
  }
  
  public final com.tencent.mm.plugin.music.ui.view.b fhg()
  {
    AppMethodBeat.i(226315);
    com.tencent.mm.plugin.music.ui.view.b localb = (com.tencent.mm.plugin.music.ui.view.b)this.Gkw.getValue();
    AppMethodBeat.o(226315);
    return localb;
  }
  
  public final View fhh()
  {
    AppMethodBeat.i(226323);
    View localView = getLayoutManager().findViewByPosition(this.GjI.jNa);
    AppMethodBeat.o(226323);
    return localView;
  }
  
  public final boolean fhi()
  {
    AppMethodBeat.i(226324);
    Object localObject = (Iterable)this.mXB;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (((com.tencent.mm.plugin.mv.model.e)((Iterator)localObject).next()).GaY != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(226324);
          return true;
        }
      }
    }
    AppMethodBeat.o(226324);
    return false;
  }
  
  public final void g(kotlin.g.a.m<? super Integer, ? super com.tencent.mm.plugin.mv.model.e, x> paramm)
  {
    AppMethodBeat.i(226322);
    kotlin.g.b.p.k(paramm, "callback");
    int i = this.GjI.jNa;
    com.tencent.mm.plugin.mv.model.e locale = (com.tencent.mm.plugin.mv.model.e)kotlin.a.j.M((List)this.mXB, i);
    if (locale != null)
    {
      paramm.invoke(Integer.valueOf(i), locale);
      AppMethodBeat.o(226322);
      return;
    }
    AppMethodBeat.o(226322);
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.plugin.mv.model.e> getAdapter()
  {
    AppMethodBeat.i(226312);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.BiY.getValue();
    AppMethodBeat.o(226312);
    return localWxRecyclerAdapter;
  }
  
  public final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(226313);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.zQC.getValue();
    AppMethodBeat.o(226313);
    return localLinearLayoutManager;
  }
  
  public final void onActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(226346);
    Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onActivityResult, requestCodec:" + paramInt1 + ", resultCodec:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(226346);
      return;
      k localk = k.fet();
      kotlin.g.b.p.j(localk, "MusicPlayerManager.Instance()");
      localk.feg().resume();
      kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (kotlin.g.a.m)new q(this, paramIntent, paramInt2, null), 2);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(226333);
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = com.tencent.mm.ui.component.g.b(getActivity()).i(l.class);
    kotlin.g.b.p.j(localObject, "UICProvider.of(activity)…MakerDataUIC::class.java)");
    localObject = (Integer)((l)localObject).fhe().getValue();
    if (localObject == null) {}
    while (((Integer)localObject).intValue() != 0)
    {
      AppMethodBeat.o(226333);
      return false;
    }
    localObject = com.tencent.mm.ui.component.g.Xox;
    ((t)com.tencent.mm.ui.component.g.b(getActivity()).i(t.class)).a(e(this.Geg), this.wNB, 2);
    AppMethodBeat.o(226333);
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(226317);
    super.onDestroy();
    Object localObject = this.GkB;
    if (localObject != null)
    {
      localObject = ((MMTPVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.f.b)localObject).recycle();
      }
    }
    localObject = this.GkB;
    if (localObject != null)
    {
      localObject = ((MMTPVideoLayout)localObject).getEffector();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.d.g)localObject).release();
        AppMethodBeat.o(226317);
        return;
      }
    }
    AppMethodBeat.o(226317);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(226340);
    super.onPause();
    dmf();
    k localk = k.fet();
    kotlin.g.b.p.j(localk, "MusicPlayerManager.Instance()");
    localk.feg().b(this.Gky);
    AppMethodBeat.o(226340);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(226341);
    super.onResume();
    dmg();
    k localk = k.fet();
    kotlin.g.b.p.j(localk, "MusicPlayerManager.Instance()");
    localk.feg().a(this.Gky);
    AppMethodBeat.o(226341);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;", "", "onEdit", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "itemView", "Landroid/view/View;", "onRollback", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.mv.model.e parame, View paramView);
    
    public abstract void b(int paramInt, com.tencent.mm.plugin.mv.model.e parame, View paramView);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "", "getItemWidth", "", "getPadding", "plugin-mv_release"})
  public static abstract interface c
  {
    public abstract int getItemWidth();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$ItemEditActionCallback;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC;)V", "onEdit", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "itemView", "Landroid/view/View;", "onRollback", "plugin-mv_release"})
  public final class d
    implements m.b
  {
    public final void a(int paramInt, com.tencent.mm.plugin.mv.model.e parame, View paramView)
    {
      AppMethodBeat.i(228909);
      kotlin.g.b.p.k(parame, "item");
      kotlin.g.b.p.k(paramView, "itemView");
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onRollback: ".concat(String.valueOf(paramInt)));
      m.a(this.GkD, parame, paramInt);
      paramView = this.GkD.Gkz;
      if (paramView != null)
      {
        paramView.c(parame);
        AppMethodBeat.o(228909);
        return;
      }
      AppMethodBeat.o(228909);
    }
    
    public final void b(int paramInt, com.tencent.mm.plugin.mv.model.e parame, View paramView)
    {
      AppMethodBeat.i(228911);
      kotlin.g.b.p.k(parame, "item");
      kotlin.g.b.p.k(paramView, "itemView");
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onEdit: ".concat(String.valueOf(paramInt)));
      paramView = (ImageView)paramView.findViewById(b.e.FXY);
      if (paramView != null)
      {
        paramView = com.tencent.mm.plugin.mv.model.h.fC((View)paramView);
        m.e locale = this.GkD.Gkz;
        if (locale != null)
        {
          locale.a(parame, false, paramView);
          AppMethodBeat.o(228911);
          return;
        }
        AppMethodBeat.o(228911);
        return;
      }
      AppMethodBeat.o(228911);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVEditActionCallback;", "", "onEditItem", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "fromSelectNewItem", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onItemSelected", "onRollback", "onTakePhotoFinished", "plugin-mv_release"})
  public static abstract interface e
  {
    public abstract void a(com.tencent.mm.plugin.mv.model.e parame, boolean paramBoolean, com.tencent.mm.plugin.mv.model.g paramg);
    
    public abstract void b(com.tencent.mm.plugin.mv.model.e parame);
    
    public abstract void c(com.tencent.mm.plugin.mv.model.e parame);
    
    public abstract void fgw();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVItemSizeResolver;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC;)V", "viewWidth", "", "getViewWidth", "()I", "setViewWidth", "(I)V", "getItemWidth", "getPadding", "plugin-mv_release"})
  public final class f
    implements m.c
  {
    public int jBZ;
    
    public static int getPadding()
    {
      AppMethodBeat.i(231711);
      int i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 70);
      AppMethodBeat.o(231711);
      return i;
    }
    
    public final int getItemWidth()
    {
      AppMethodBeat.i(231710);
      if (this.jBZ == 0)
      {
        i = com.tencent.mm.ci.a.kr((Context)this.GkD.getActivity());
        j = getPadding();
        AppMethodBeat.o(231710);
        return i - j * 2;
      }
      int i = this.jBZ;
      int j = getPadding();
      AppMethodBeat.o(231710);
      return i - j * 2;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MusicMVVideoItemConverterFactory;", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC;Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;)V", "getSizeResolver", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public final class g
    implements com.tencent.mm.view.recyclerview.f
  {
    private final m.c GfD;
    
    public g()
    {
      AppMethodBeat.i(226626);
      this.GfD = localObject;
      AppMethodBeat.o(226626);
    }
    
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(226623);
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.mv.ui.a.a(this.GfD, (m.b)new m.d(m.this));
      AppMethodBeat.o(226623);
      return locale;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<WxRecyclerAdapter<com.tencent.mm.plugin.mv.model.e>>
  {
    h(m paramm)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  public static final class j
    implements View.OnLayoutChangeListener
  {
    public j(m paramm) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(226420);
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "initEditUI: " + paramInt2 + ", " + paramInt4 + "; " + paramInt6 + ", " + paramInt8);
      m.a(this.GkD).jBZ = (paramInt3 - paramInt1);
      AppMethodBeat.o(226420);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$initEditUI$2", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-mv_release"})
  public static final class k
    implements a.c
  {
    public final void rJ(int paramInt)
    {
      AppMethodBeat.i(225276);
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onPageSettle: " + paramInt + ", last " + m.b(this.GkD));
      if (m.b(this.GkD) == paramInt)
      {
        AppMethodBeat.o(225276);
        return;
      }
      m.b(this.GkD, paramInt);
      m.c(this.GkD, paramInt);
      m.e locale = this.GkD.Gkz;
      if (locale != null)
      {
        Object localObject = m.c(this.GkD).get(paramInt);
        kotlin.g.b.p.j(localObject, "dataList[position]");
        locale.b((com.tencent.mm.plugin.mv.model.e)localObject);
        AppMethodBeat.o(225276);
        return;
      }
      AppMethodBeat.o(225276);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$initEditUI$3", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "plugin-mv_release"})
  public static final class l
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(233193);
      super.onChanged();
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onChanged: " + m.d(this.GkD).getItemCount());
      if (m.e(this.GkD).jNa == -1) {
        m.f(this.GkD).post((Runnable)new a(this));
      }
      AppMethodBeat.o(233193);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(233200);
      super.onItemRangeChanged(paramInt1, paramInt2);
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onItemRangeChanged, start:" + paramInt1 + ", itemCount:" + paramInt2 + ", lastPos:" + m.b(this.GkD));
      int i = m.b(this.GkD);
      if (paramInt1 > i)
      {
        AppMethodBeat.o(233200);
        return;
      }
      if (paramInt1 + paramInt2 > i) {
        m.f(this.GkD).post((Runnable)new b(this));
      }
      AppMethodBeat.o(233200);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(233197);
      if (paramObject == null)
      {
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onItemRangeChanged, start:" + paramInt1 + ", itemCount:" + paramInt2 + ", lastPos:" + m.b(this.GkD) + ", payload:" + paramObject);
        onItemRangeChanged(paramInt1, paramInt2);
      }
      AppMethodBeat.o(233197);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(m.l paraml) {}
      
      public final void run()
      {
        AppMethodBeat.i(231744);
        m.e(this.GkE.GkD).a((RecyclerView)m.f(this.GkE.GkD));
        AppMethodBeat.o(231744);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(m.l paraml) {}
      
      public final void run()
      {
        AppMethodBeat.i(226375);
        m.c(this.GkE.GkD, m.b(this.GkE.GkD));
        AppMethodBeat.o(226375);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "attached", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$makeMediaThumbTransition$1$1$1", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$$special$$inlined$let$lambda$1"})
  static final class o
    implements h.a
  {
    o(ImageView paramImageView, com.tencent.mm.plugin.mv.model.e parame, kotlin.g.a.b paramb) {}
    
    public final void euT()
    {
      AppMethodBeat.i(229487);
      com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231453);
          this.GkH.zTz.animate().alpha(1.0F).setDuration(200L).withEndAction((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(228578);
              this.GkI.GkH.zTz.setVisibility(4);
              com.tencent.mm.plugin.mv.model.g localg = com.tencent.mm.plugin.mv.model.h.fC((View)this.GkI.GkH.zTz);
              kotlin.g.a.b localb = this.GkI.GkH.GkG;
              if (localb != null)
              {
                localb.invoke(localg);
                AppMethodBeat.o(228578);
                return;
              }
              AppMethodBeat.o(228578);
            }
          }).start();
          AppMethodBeat.o(231453);
        }
      });
      AppMethodBeat.o(229487);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
  static final class p
    implements d.a
  {
    p(m paramm) {}
    
    public final void fK(final int paramInt1, final int paramInt2)
    {
      AppMethodBeat.i(234616);
      com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(228386);
          m.d(this.GkJ.GkD, paramInt1);
          AppMethodBeat.o(228386);
        }
      });
      AppMethodBeat.o(234616);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class q
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    q(m paramm, Intent paramIntent, int paramInt, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(227404);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new q(this.GkD, paramIntent, paramInt2, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(227404);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(227406);
      paramObject1 = ((q)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(227406);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(227402);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(227402);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      m.a(this.GkD, paramIntent, paramInt2);
      paramObject = x.aazN;
      AppMethodBeat.o(227402);
      return paramObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class r
    implements Runnable
  {
    public r(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(226193);
      m.e(this.GkD).aCV();
      AppMethodBeat.o(226193);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class s
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    long uyU;
    
    s(m paramm, int paramInt, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(242543);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new s(this.GkD, this.jEN, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(242543);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(242546);
      paramObject1 = ((s)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(242546);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(242538);
      Object localObject3 = kotlin.d.a.a.aaAA;
      Object localObject4;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(242538);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject2 = this.p$;
        Log.printInfoStack("MicroMsg.Mv.MusicMvMakerFixEditUIC", "refreshVideo: " + this.jEN + ' ' + m.b(this.GkD), new Object[0]);
        if (m.b(this.GkD) >= 0)
        {
          paramObject = m.g(this.GkD);
          if (paramObject != null)
          {
            paramObject = paramObject.getPlayer();
            if ((paramObject != null) && (paramObject.isPlaying() == true))
            {
              paramObject = m.c(this.GkD).get(m.b(this.GkD));
              kotlin.g.b.p.j(paramObject, "dataList[lastPos]");
              localObject4 = (com.tencent.mm.plugin.mv.model.e)paramObject;
              paramObject = m.g(this.GkD);
              if (paramObject == null) {
                break label303;
              }
              paramObject = paramObject.getPlayer();
              if (paramObject == null) {
                break label303;
              }
              paramObject = paramObject.MTd;
              localObject1 = m.g(this.GkD);
              if (localObject1 == null) {
                break label308;
              }
              localObject1 = ((MMTPVideoLayout)localObject1).getEffector();
              if (localObject1 == null) {
                break label308;
              }
            }
          }
        }
        Object localObject5;
        label303:
        label308:
        for (localObject1 = ((com.tencent.mm.plugin.thumbplayer.d.g)localObject1).MRa;; localObject1 = null)
        {
          localObject5 = com.tencent.mm.plugin.mv.model.o.GcB;
          com.tencent.mm.plugin.mv.model.o.a((Context)this.GkD.getActivity(), this.GkD.Geg, m.b(this.GkD), (com.tencent.mm.plugin.mv.model.e)localObject4, paramObject, (com.tencent.mm.plugin.thumbplayer.e.b)localObject1);
          localObject1 = m.f(this.GkD).cK(this.jEN);
          if (localObject1 != null) {
            break label314;
          }
          paramObject = x.aazN;
          AppMethodBeat.o(242538);
          return paramObject;
          paramObject = null;
          break;
        }
        label314:
        kotlin.g.b.p.j(localObject1, "fixMvCardRV.findViewHold…osition) ?: return@launch");
        paramObject = m.c(this.GkD).get(this.jEN);
        kotlin.g.b.p.j(paramObject, "dataList[position]");
        paramObject = (com.tencent.mm.plugin.mv.model.e)paramObject;
        m.a(this.GkD, this.jEN);
        if (paramObject.GaV)
        {
          localObject4 = k.fet();
          kotlin.g.b.p.j(localObject4, "MusicPlayerManager.Instance()");
          ((k)localObject4).feg().wG(paramObject.GaT);
        }
        localObject4 = paramObject.GaX;
        if (localObject4 != null) {}
        for (l = kotlin.d.b.a.b.Xu(((e.h)localObject4).ffW()).longValue();; l = 0L)
        {
          localObject4 = (kotlin.d.f)bc.iRs();
          localObject5 = (kotlin.g.a.m)new b(paramObject, null);
          this.L$0 = localObject2;
          this.oDA = localObject1;
          this.pGq = paramObject;
          this.uyU = l;
          this.label = 1;
          localObject2 = kotlinx.coroutines.i.a((kotlin.d.f)localObject4, (kotlin.g.a.m)localObject5, this);
          if (localObject2 != localObject3) {
            break;
          }
          AppMethodBeat.o(242538);
          return localObject3;
        }
      }
      final long l = this.uyU;
      Object localObject2 = (com.tencent.mm.plugin.mv.model.e)this.pGq;
      localObject3 = (RecyclerView.v)this.oDA;
      ResultKt.throwOnFailure(paramObject);
      Object localObject1 = paramObject;
      paramObject = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      for (;;)
      {
        localObject3 = (com.tencent.mm.plugin.thumbplayer.e.d)localObject2;
        if (localObject3 == null)
        {
          paramObject = x.aazN;
          AppMethodBeat.o(242538);
          return paramObject;
        }
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "refreshVideo mediaInfo:".concat(String.valueOf(localObject3)));
        localObject4 = (FrameLayout)((RecyclerView.v)localObject1).amk.findViewById(b.e.video_container);
        localObject2 = m.g(this.GkD);
        if (localObject2 != null)
        {
          localObject2 = ((MMTPVideoLayout)localObject2).getParent();
          if (localObject2 == null) {
            break label692;
          }
          localObject2 = m.g(this.GkD);
          if (localObject2 == null) {
            break label668;
          }
        }
        label668:
        for (localObject2 = ((MMTPVideoLayout)localObject2).getParent();; localObject2 = null)
        {
          if (localObject2 != null) {
            break label674;
          }
          paramObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(242538);
          throw paramObject;
          localObject2 = null;
          break;
        }
        label674:
        ((ViewGroup)localObject2).removeView((View)m.g(this.GkD));
        label692:
        ((FrameLayout)localObject4).removeAllViews();
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        ((FrameLayout)localObject4).addView((View)m.g(this.GkD), (ViewGroup.LayoutParams)localObject2);
        localObject2 = ((RecyclerView.v)localObject1).amk.findViewById(b.e.FYL);
        kotlin.g.b.p.j(localObject2, "holder.itemView.findView…r>(R.id.part_mv_seek_bar)");
        ((ProgressBar)localObject2).setProgress(0);
        localObject2 = m.g(this.GkD);
        if (localObject2 != null)
        {
          ((MMTPVideoLayout)localObject2).goU();
          ((MMTPVideoLayout)localObject2).setKeepScreenOn(true);
          localObject4 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject4 != null) {
            ((com.tencent.mm.plugin.thumbplayer.f.b)localObject4).ehf();
          }
          ((MMTPVideoLayout)localObject2).setMediaInfo((com.tencent.mm.plugin.thumbplayer.e.d)localObject3);
          localObject4 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject4 != null) {
            ((com.tencent.mm.plugin.thumbplayer.f.b)localObject4).ALj = true;
          }
          localObject4 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject4 != null) {
            ((com.tencent.mm.plugin.thumbplayer.f.b)localObject4).setMute(true);
          }
          localObject4 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject4 != null) {
            ((com.tencent.mm.plugin.thumbplayer.f.b)localObject4).setLoop(true);
          }
          com.tencent.mm.plugin.thumbplayer.d.g.a(((MMTPVideoLayout)localObject2).getEffector());
          localObject4 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject4 != null) {
            ((com.tencent.mm.plugin.thumbplayer.f.b)localObject4).aG(l, paramObject.getDurationMs() + l);
          }
          localObject4 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject4 != null) {
            ((com.tencent.mm.plugin.thumbplayer.f.b)localObject4).gos();
          }
          localObject2 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.thumbplayer.f.b)localObject2).a((com.tencent.mm.plugin.thumbplayer.view.e)new a((com.tencent.mm.plugin.thumbplayer.e.d)localObject3, l, paramObject, (RecyclerView.v)localObject1), 30L);
          }
        }
        paramObject = x.aazN;
        AppMethodBeat.o(242538);
        return paramObject;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$refreshVideo$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "lastPlayPos", "", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "timeMs", "plugin-mv_release"})
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.view.e
    {
      long GkL;
      
      a(com.tencent.mm.plugin.thumbplayer.e.d paramd, long paramLong, com.tencent.mm.plugin.mv.model.e parame, RecyclerView.v paramv) {}
      
      public final void a(com.tencent.mm.plugin.thumbplayer.e.d paramd, final long paramLong)
      {
        AppMethodBeat.i(227945);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramLong) {});
        AppMethodBeat.o(227945);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class b
      extends kotlin.d.b.a.j
      implements kotlin.g.a.m<ak, kotlin.d.d<? super com.tencent.mm.plugin.thumbplayer.e.d>, Object>
    {
      int label;
      private ak p$;
      
      b(com.tencent.mm.plugin.mv.model.e parame, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(231303);
        kotlin.g.b.p.k(paramd, "completion");
        paramd = new b(this.GfH, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(231303);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(231304);
        paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(231304);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(231299);
        kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(231299);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.GfH.GaX;
        if (paramObject != null)
        {
          paramObject = paramObject.ffX();
          AppMethodBeat.o(231299);
          return paramObject;
        }
        AppMethodBeat.o(231299);
        return null;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(m paramm, int paramInt, com.tencent.mm.plugin.mv.model.e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(226309);
      m.e locale = this.GkD.Gkz;
      if (locale != null) {
        locale.fgw();
      }
      locale = this.GkD.Gkz;
      if (locale != null)
      {
        locale.a(this.GkR, true, null);
        AppMethodBeat.o(226309);
        return;
      }
      AppMethodBeat.o(226309);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "invoke"})
  public static final class u
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.mv.model.g, x>
  {
    public u(m paramm, int paramInt, com.tencent.mm.plugin.mv.model.e parame)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "invoke"})
  public static final class v
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.mv.model.g, x>
  {
    public v(m paramm, int paramInt, com.tencent.mm.plugin.mv.model.e parame)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class w
    implements Runnable
  {
    public w(m paramm) {}
    
    public final void run()
    {
      AppMethodBeat.i(231905);
      m.e(this.GkD).a((RecyclerView)m.f(this.GkD));
      AppMethodBeat.o(231905);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.m
 * JD-Core Version:    0.7.0.1
 */