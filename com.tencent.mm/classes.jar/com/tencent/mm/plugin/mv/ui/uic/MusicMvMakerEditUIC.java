package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.mv.a.d.g;
import com.tencent.mm.plugin.mv.a.d.h;
import com.tencent.mm.plugin.thumbplayer.d.c;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;", "setActionCallback", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "initMusicDataList", "isEdit", "", "()Z", "setEdit", "(Z)V", "isEditNewItem", "setEditNewItem", "itemDecoration", "Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "getItemDecoration", "()Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "itemDecoration$delegate", "lastPos", "", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "musicProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "mvCardRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getMvCardRV", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mvCardRV$delegate", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVItemSizeResolver;", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "checkCanDoNext", "createMvData", "originTrackData", "disableCurrentSyncMusic", "", "getCurrentCardView", "Landroid/view/View;", "getCurrentEditData", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "itemData", "initEditUI", "makeMediaThumbTransition", "pos", "newItem", "onAnimationEnd", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "nextAnimationInfo", "moveToNextItem", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onDestroy", "onNextBtnClicked", "onPause", "onResume", "pauseVideo", "refreshVideo", "refreshView", "resumeVideo", "rollbackItemImpl", "item", "rollbackLastEditItem", "rollbackToInitItem", "takePhoto", "minDuration", "takePhotoFinished", "result", "updateAlbumItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "updateFinderItem", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "updateLyric", "currentPos", "totalDuration", "updateMusicItemList", "itemList", "", "Companion", "IMVEditItemAction", "IMVItemSizeResolver", "ItemEditActionCallback", "MVEditActionCallback", "MVItemSizeResolver", "MusicMVVideoItemConverterFactory", "plugin-mv_release"})
public final class MusicMvMakerEditUIC
  extends UIComponent
{
  public static final a AuH;
  public com.tencent.mm.plugin.music.model.e.a AkC;
  public csp AqY;
  private final kotlin.f AtV;
  public final com.tencent.mm.emoji.panel.layout.a AtW;
  public final ArrayList<com.tencent.mm.plugin.mv.a.d> AuA;
  private final kotlin.f AuB;
  public final f AuC;
  private final d.a AuD;
  public e AuE;
  public boolean AuF;
  public MMTPRecyclerVideoLayout AuG;
  private final kotlin.f Auz;
  public final ArrayList<com.tencent.mm.plugin.mv.a.d> kgc;
  public int tex;
  public boolean thl;
  private final kotlin.f vat;
  
  static
  {
    AppMethodBeat.i(257249);
    AuH = new a((byte)0);
    AppMethodBeat.o(257249);
  }
  
  public MusicMvMakerEditUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257248);
    this.Auz = kotlin.g.ah((kotlin.g.a.a)new p(paramAppCompatActivity));
    this.kgc = new ArrayList();
    this.AuA = new ArrayList();
    this.AtV = kotlin.g.ah((kotlin.g.a.a)new h(this));
    this.vat = kotlin.g.ah((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.AuB = kotlin.g.ah((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.AtW = new com.tencent.mm.emoji.panel.layout.a();
    this.AuC = new f();
    this.tex = -1;
    this.AuD = ((d.a)new o(this));
    AppMethodBeat.o(257248);
  }
  
  public final void Tq(int paramInt)
  {
    AppMethodBeat.i(257246);
    if (paramInt != this.tex)
    {
      com.tencent.mm.plugin.mv.a.d locald = (com.tencent.mm.plugin.mv.a.d)kotlin.a.j.L((List)this.kgc, this.tex);
      RecyclerView.v localv;
      com.tencent.mm.plugin.mv.ui.a.a.c localc;
      if ((locald != null) && (locald.uOQ))
      {
        locald.uOQ = false;
        locald.Apn = false;
        localv = evW().ch(this.tex);
        if ((localv instanceof com.tencent.mm.view.recyclerview.h))
        {
          localc = com.tencent.mm.plugin.mv.ui.a.a.JRL;
          com.tencent.mm.plugin.mv.ui.a.a.c.a((com.tencent.mm.view.recyclerview.h)localv, locald);
        }
      }
      locald = (com.tencent.mm.plugin.mv.a.d)kotlin.a.j.L((List)this.kgc, paramInt);
      if (locald != null)
      {
        if (!locald.uOQ)
        {
          locald.uOQ = true;
          locald.Apn = true;
          localv = evW().ch(paramInt);
          if ((localv instanceof com.tencent.mm.view.recyclerview.h))
          {
            localc = com.tencent.mm.plugin.mv.ui.a.a.JRL;
            com.tencent.mm.plugin.mv.ui.a.a.c.a((com.tencent.mm.view.recyclerview.h)localv, locald);
          }
        }
        AppMethodBeat.o(257246);
        return;
      }
    }
    AppMethodBeat.o(257246);
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.mv.a.d paramd, final kotlin.g.a.b<? super com.tencent.mm.plugin.mv.a.f, x> paramb)
  {
    AppMethodBeat.i(257237);
    Object localObject = getLayoutManager().findViewByPosition(paramInt);
    if (localObject != null)
    {
      localObject = (ImageView)((View)localObject).findViewById(2131305142);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        ((ImageView)localObject).setAlpha(0.0F);
        d.g localg = paramd.Apo;
        if (localg != null)
        {
          localg.a((ImageView)localObject, (h.a)new n((ImageView)localObject, paramd, paramb));
          AppMethodBeat.o(257237);
          return;
        }
        AppMethodBeat.o(257237);
        return;
      }
      AppMethodBeat.o(257237);
      return;
    }
    AppMethodBeat.o(257237);
  }
  
  public final void cWX()
  {
    AppMethodBeat.i(257242);
    Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "pauseVideo");
    Object localObject1 = evW().ch(this.tex);
    if (localObject1 == null)
    {
      AppMethodBeat.o(257242);
      return;
    }
    p.g(localObject1, "mvCardRV.findViewHolderF…sition(lastPos) ?: return");
    localObject1 = (MMTPRecyclerVideoLayout)((RecyclerView.v)localObject1).aus.findViewById(2131305117);
    if (localObject1 != null)
    {
      localObject2 = ((MMTPRecyclerVideoLayout)localObject1).getPlayer();
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).dFp();
      }
      localObject1 = ((MMTPRecyclerVideoLayout)localObject1).getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).stop();
      }
    }
    com.tencent.mm.plugin.mv.a.d locald;
    if (this.tex >= 0)
    {
      localObject1 = this.kgc.get(this.tex);
      p.g(localObject1, "dataList[lastPos]");
      locald = (com.tencent.mm.plugin.mv.a.d)localObject1;
      localObject1 = this.AuG;
      if (localObject1 == null) {
        break label199;
      }
      localObject1 = ((MMTPRecyclerVideoLayout)localObject1).getPlayer();
      if (localObject1 == null) {
        break label199;
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).Utr;
      localObject2 = this.AuG;
      if (localObject2 == null) {
        break label204;
      }
      localObject2 = ((MMTPRecyclerVideoLayout)localObject2).getEffector();
      if (localObject2 == null) {
        break label204;
      }
    }
    label199:
    label204:
    for (Object localObject2 = ((com.tencent.mm.plugin.thumbplayer.c.a)localObject2).UsW;; localObject2 = null)
    {
      com.tencent.mm.plugin.mv.a.k localk = com.tencent.mm.plugin.mv.a.k.Aql;
      com.tencent.mm.plugin.mv.a.k.a((Context)getActivity(), this.AqY, this.tex, locald, (com.tencent.mm.plugin.thumbplayer.d.b)localObject1, (c)localObject2);
      AppMethodBeat.o(257242);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void cWY()
  {
    AppMethodBeat.i(257243);
    Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "resumeVideo");
    getAdapter().ci(this.AtW.hbQ);
    AppMethodBeat.o(257243);
  }
  
  public final csp d(csp paramcsp)
  {
    AppMethodBeat.i(257240);
    csp localcsp;
    Object localObject2;
    Object localObject1;
    HashSet localHashSet;
    Object localObject5;
    int i;
    label160:
    int j;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    long l;
    label294:
    label443:
    Object localObject3;
    if (paramcsp != null)
    {
      localcsp = new csp();
      localcsp.localId = paramcsp.localId;
      localcsp.MxE = new FinderObject();
      localObject2 = localcsp.MxE;
      if (localObject2 != null)
      {
        localObject1 = paramcsp.MxE;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).objectDesc;
          ((FinderObject)localObject2).objectDesc = ((FinderObjectDesc)localObject1);
        }
      }
      else
      {
        localcsp.MxG = paramcsp.MxG;
        localObject1 = null;
        localHashSet = new HashSet();
        localObject2 = localcsp.MxE;
        if (localObject2 == null) {
          break label957;
        }
        localObject2 = ((FinderObject)localObject2).objectDesc;
        if (localObject2 == null) {
          break label957;
        }
        localObject2 = ((FinderObjectDesc)localObject2).mvInfo;
        if (localObject2 == null) {
          break label957;
        }
        localObject2 = ((axw)localObject2).LId;
        if (localObject2 == null) {
          break label957;
        }
        localObject5 = ((Iterable)localObject2).iterator();
        i = 0;
        if (!((Iterator)localObject5).hasNext()) {
          break label749;
        }
        localObject2 = ((Iterator)localObject5).next();
        j = i + 1;
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject6 = (axz)localObject2;
        localObject7 = (com.tencent.mm.plugin.mv.a.d)kotlin.a.j.L((List)this.kgc, i);
        if (localObject7 == null) {
          break label744;
        }
        localObject2 = ((com.tencent.mm.plugin.mv.a.d)localObject7).App;
        if (localObject2 == null) {
          break label739;
        }
        localObject4 = ((d.h)localObject2).evB();
        if (localObject4 == null) {
          break label739;
        }
        ((axz)localObject6).refObjectId = ((FinderObject)localObject4).id;
        ((axz)localObject6).LIm = ((FinderObject)localObject4).objectNonceId;
        localObject2 = ((com.tencent.mm.plugin.mv.a.d)this.kgc.get(i)).App;
        if (localObject2 == null) {
          break label703;
        }
        l = ((d.h)localObject2).evz();
        ((axz)localObject6).Ghw = l;
        Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "set finderMVTrack, timeOffsetInClipMs:" + ((axz)localObject6).Ghw);
        if (localHashSet.add(((FinderObject)localObject4).objectNonceId))
        {
          localObject2 = ((FinderObject)localObject4).objectDesc;
          if (localObject2 != null) {
            ((FinderObjectDesc)localObject2).mvInfo = new axw();
          }
          localObject2 = ((FinderObject)localObject4).objectDesc;
          if (localObject2 != null)
          {
            localObject2 = ((FinderObjectDesc)localObject2).mvInfo;
            if (localObject2 != null)
            {
              localObject2 = ((axw)localObject2).LId;
              if (localObject2 != null) {
                ((LinkedList)localObject2).add(localObject6);
              }
            }
          }
          localObject2 = ((FinderObject)localObject4).objectDesc;
          if (localObject2 == null) {
            break label709;
          }
          localObject2 = ((FinderObjectDesc)localObject2).media;
          if (localObject2 == null) {
            break label709;
          }
          localObject2 = (FinderMedia)((LinkedList)localObject2).getFirst();
          StringBuilder localStringBuilder = new StringBuilder("ref object media size:");
          localObject3 = ((FinderObject)localObject4).objectDesc;
          if (localObject3 == null) {
            break label715;
          }
          localObject3 = ((FinderObjectDesc)localObject3).media;
          if (localObject3 == null) {
            break label715;
          }
          localObject3 = Integer.valueOf(((LinkedList)localObject3).size());
          label489:
          localStringBuilder = localStringBuilder.append(localObject3).append(", ");
          if (localObject2 == null) {
            break label721;
          }
          localObject3 = ((FinderMedia)localObject2).url;
          label516:
          localStringBuilder = localStringBuilder.append((String)localObject3).append(", [");
          if (localObject2 == null) {
            break label727;
          }
          localObject3 = Float.valueOf(((FinderMedia)localObject2).width);
          label546:
          localObject3 = localStringBuilder.append(localObject3).append(' ');
          if (localObject2 == null) {
            break label733;
          }
          localObject2 = Float.valueOf(((FinderMedia)localObject2).height);
          label575:
          Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", localObject2 + ']');
          localcsp.LDi.add(localObject4);
        }
        if (((FinderObject)localObject4).id == 0L)
        {
          localObject2 = ((FinderObject)localObject4).objectNonceId;
          if ((localObject2 != null) && (n.J((String)localObject2, "local_", false) == true))
          {
            ((axz)localObject6).UtY = 1;
            Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "createMvData isFirstUpload " + ((FinderObject)localObject4).objectNonceId);
          }
        }
        if ((((com.tencent.mm.plugin.mv.a.d)localObject7).Apq == null) || (localObject1 != null)) {
          break label1162;
        }
        localObject1 = localObject4;
      }
    }
    label1162:
    for (;;)
    {
      i = j;
      break label160;
      localObject1 = null;
      break;
      label703:
      l = 0L;
      break label294;
      label709:
      localObject2 = null;
      break label443;
      label715:
      localObject3 = null;
      break label489;
      label721:
      localObject3 = null;
      break label516;
      label727:
      localObject3 = null;
      break label546;
      label733:
      localObject2 = null;
      break label575;
      label739:
      i = j;
      break label160;
      label744:
      i = j;
      break label160;
      label749:
      localObject2 = localcsp.LDi;
      localObject3 = paramcsp.LDi;
      p.g(localObject3, "it.refObjectList");
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList();
      localObject4 = ((Iterable)localObject4).iterator();
      label798:
      label957:
      label968:
      label971:
      for (;;)
      {
        if (!((Iterator)localObject4).hasNext()) {
          break label973;
        }
        localObject5 = ((Iterator)localObject4).next();
        localObject6 = (FinderObject)localObject5;
        localObject7 = paramcsp.MxG;
        if (localObject7 != null)
        {
          localObject7 = ((axw)localObject7).LId;
          if (localObject7 != null)
          {
            localObject7 = (Iterable)localObject7;
            if ((!(localObject7 instanceof Collection)) || (!((Collection)localObject7).isEmpty()))
            {
              localObject7 = ((Iterable)localObject7).iterator();
              while (((Iterator)localObject7).hasNext()) {
                if (p.j(((axz)((Iterator)localObject7).next()).LIm, ((FinderObject)localObject6).objectNonceId))
                {
                  i = 1;
                  if ((i != 1) || (!localHashSet.add(((FinderObject)localObject6).objectNonceId))) {
                    break label968;
                  }
                }
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label971;
          }
          ((Collection)localObject3).add(localObject5);
          break label798;
          localObject1 = null;
          break;
          i = 0;
          break label920;
        }
      }
      label920:
      label973:
      ((LinkedList)localObject2).addAll((Collection)localObject3);
      localcsp.MxF = paramcsp.MxF;
      if (localObject1 != null)
      {
        paramcsp = ((FinderObject)localObject1).objectDesc;
        if (paramcsp != null)
        {
          paramcsp = paramcsp.media;
          if (paramcsp != null)
          {
            localObject2 = (FinderMedia)kotlin.a.j.kt((List)paramcsp);
            if (localObject2 != null)
            {
              paramcsp = com.tencent.mm.plugin.music.model.g.Aku;
              paramcsp = com.tencent.mm.plugin.music.model.g.aHP("thumb_" + ((FinderObject)localObject1).id);
              if (((FinderObject)localObject1).id == 0L)
              {
                localObject1 = ((FinderMedia)localObject2).url;
                if (localObject1 != null)
                {
                  localObject2 = com.tencent.mm.plugin.finder.upload.i.vSX;
                  localObject2 = com.tencent.mm.plugin.finder.upload.i.dK((String)localObject1, 4);
                  localObject3 = com.tencent.mm.plugin.finder.upload.f.vSz;
                  p.g(localObject1, "localPath");
                  com.tencent.mm.plugin.finder.upload.f.a((String)localObject1, paramcsp, ((Point)localObject2).x, ((Point)localObject2).y, null);
                }
              }
              if (s.YS(paramcsp)) {
                localcsp.MxF = paramcsp;
              }
            }
          }
        }
      }
      AppMethodBeat.o(257240);
      return localcsp;
      AppMethodBeat.o(257240);
      return null;
    }
  }
  
  public final WxRecyclerView evW()
  {
    AppMethodBeat.i(257232);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.Auz.getValue();
    AppMethodBeat.o(257232);
    return localWxRecyclerView;
  }
  
  public final com.tencent.mm.plugin.music.ui.view.b evX()
  {
    AppMethodBeat.i(257235);
    com.tencent.mm.plugin.music.ui.view.b localb = (com.tencent.mm.plugin.music.ui.view.b)this.AuB.getValue();
    AppMethodBeat.o(257235);
    return localb;
  }
  
  public final View evY()
  {
    AppMethodBeat.i(257238);
    View localView = getLayoutManager().findViewByPosition(this.AtW.hbQ);
    AppMethodBeat.o(257238);
    return localView;
  }
  
  public final boolean evZ()
  {
    AppMethodBeat.i(257239);
    Object localObject = (Iterable)this.kgc;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (((com.tencent.mm.plugin.mv.a.d)((Iterator)localObject).next()).Apq != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(257239);
          return true;
        }
      }
    }
    AppMethodBeat.o(257239);
    return false;
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.plugin.mv.a.d> getAdapter()
  {
    AppMethodBeat.i(257233);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.AtV.getValue();
    AppMethodBeat.o(257233);
    return localWxRecyclerAdapter;
  }
  
  public final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(257234);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.vat.getValue();
    AppMethodBeat.o(257234);
    return localLinearLayoutManager;
  }
  
  public final void k(m<? super Integer, ? super com.tencent.mm.plugin.mv.a.d, x> paramm)
  {
    AppMethodBeat.i(258920);
    p.h(paramm, "callback");
    int i = this.AtW.hbQ;
    com.tencent.mm.plugin.mv.a.d locald = (com.tencent.mm.plugin.mv.a.d)kotlin.a.j.L((List)this.kgc, i);
    if (locald != null)
    {
      paramm.invoke(Integer.valueOf(i), locald);
      AppMethodBeat.o(258920);
      return;
    }
    AppMethodBeat.o(258920);
  }
  
  public final void onActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(257247);
    Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onActivityResult, requestCodec:" + paramInt1 + ", resultCodec:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(257247);
      return;
      com.tencent.mm.plugin.music.e.k localk = com.tencent.mm.plugin.music.e.k.euj();
      p.g(localk, "MusicPlayerManager.Instance()");
      localk.etW().resume();
      kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (m)new q(this, paramIntent, paramInt2, null), 2);
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(257241);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    ((MusicMvSaveDraftUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvSaveDraftUIC.class)).a(d(this.AqY), this.thl, 2);
    AppMethodBeat.o(257241);
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(257236);
    super.onDestroy();
    Object localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
    }
    localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getEffector();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.c.a)localObject).release();
        AppMethodBeat.o(257236);
        return;
      }
    }
    AppMethodBeat.o(257236);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(257244);
    super.onPause();
    cWX();
    com.tencent.mm.plugin.music.e.k localk = com.tencent.mm.plugin.music.e.k.euj();
    p.g(localk, "MusicPlayerManager.Instance()");
    localk.etW().c(this.AuD);
    AppMethodBeat.o(257244);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(257245);
    super.onResume();
    cWY();
    com.tencent.mm.plugin.music.e.k localk = com.tencent.mm.plugin.music.e.k.euj();
    p.g(localk, "MusicPlayerManager.Instance()");
    localk.etW().b(this.AuD);
    AppMethodBeat.o(257245);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$Companion;", "", "()V", "TAG", "", "TAKE_PHOTO_REQUESTCODE", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;", "", "onEdit", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "itemView", "Landroid/view/View;", "onRollback", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.mv.a.d paramd, View paramView);
    
    public abstract void b(int paramInt, com.tencent.mm.plugin.mv.a.d paramd, View paramView);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "", "getItemWidth", "", "getPadding", "plugin-mv_release"})
  public static abstract interface c
  {
    public abstract int getItemWidth();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$ItemEditActionCallback;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC;)V", "onEdit", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "itemView", "Landroid/view/View;", "onRollback", "plugin-mv_release"})
  public final class d
    implements MusicMvMakerEditUIC.b
  {
    public final void a(int paramInt, com.tencent.mm.plugin.mv.a.d paramd, View paramView)
    {
      AppMethodBeat.i(257202);
      p.h(paramd, "item");
      p.h(paramView, "itemView");
      Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onRollback: ".concat(String.valueOf(paramInt)));
      MusicMvMakerEditUIC.a(this.AuI, paramd, paramInt);
      paramView = this.AuI.AuE;
      if (paramView != null)
      {
        paramView.c(paramd);
        AppMethodBeat.o(257202);
        return;
      }
      AppMethodBeat.o(257202);
    }
    
    public final void b(int paramInt, com.tencent.mm.plugin.mv.a.d paramd, View paramView)
    {
      AppMethodBeat.i(257203);
      p.h(paramd, "item");
      p.h(paramView, "itemView");
      Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onEdit: ".concat(String.valueOf(paramInt)));
      paramView = (ImageView)paramView.findViewById(2131305147);
      if (paramView != null)
      {
        paramView = com.tencent.mm.plugin.mv.a.g.eC((View)paramView);
        MusicMvMakerEditUIC.e locale = this.AuI.AuE;
        if (locale != null)
        {
          locale.a(paramd, false, paramView);
          AppMethodBeat.o(257203);
          return;
        }
        AppMethodBeat.o(257203);
        return;
      }
      AppMethodBeat.o(257203);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVEditActionCallback;", "", "onEditItem", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "fromSelectNewItem", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onItemSelected", "onRollback", "onTakePhotoFinished", "plugin-mv_release"})
  public static abstract interface e
  {
    public abstract void a(com.tencent.mm.plugin.mv.a.d paramd, boolean paramBoolean, com.tencent.mm.plugin.mv.a.f paramf);
    
    public abstract void b(com.tencent.mm.plugin.mv.a.d paramd);
    
    public abstract void c(com.tencent.mm.plugin.mv.a.d paramd);
    
    public abstract void evF();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MVItemSizeResolver;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC;)V", "viewWidth", "", "getViewWidth", "()I", "setViewWidth", "(I)V", "getItemWidth", "getPadding", "plugin-mv_release"})
  public final class f
    implements MusicMvMakerEditUIC.c
  {
    public int gRD;
    
    public static int getPadding()
    {
      AppMethodBeat.i(257205);
      int i = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 70);
      AppMethodBeat.o(257205);
      return i;
    }
    
    public final int getItemWidth()
    {
      AppMethodBeat.i(257204);
      if (this.gRD == 0)
      {
        i = com.tencent.mm.cb.a.jn((Context)this.AuI.getActivity());
        j = getPadding();
        AppMethodBeat.o(257204);
        return i - j * 2;
      }
      int i = this.gRD;
      int j = getPadding();
      AppMethodBeat.o(257204);
      return i - j * 2;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$MusicMVVideoItemConverterFactory;", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC;Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;)V", "getSizeResolver", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public final class g
    implements com.tencent.mm.view.recyclerview.f
  {
    private final MusicMvMakerEditUIC.c ArU;
    
    public g()
    {
      AppMethodBeat.i(257207);
      this.ArU = localObject;
      AppMethodBeat.o(257207);
    }
    
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(257206);
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.mv.ui.a.a(this.ArU, (MusicMvMakerEditUIC.b)new MusicMvMakerEditUIC.d(MusicMvMakerEditUIC.this));
      AppMethodBeat.o(257206);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<WxRecyclerAdapter<com.tencent.mm.plugin.mv.a.d>>
  {
    h(MusicMvMakerEditUIC paramMusicMvMakerEditUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  public static final class i
    implements View.OnLayoutChangeListener
  {
    public i(MusicMvMakerEditUIC paramMusicMvMakerEditUIC) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(257209);
      Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "initEditUI: " + paramInt2 + ", " + paramInt4 + "; " + paramInt6 + ", " + paramInt8);
      MusicMvMakerEditUIC.a(this.AuI).gRD = (paramInt3 - paramInt1);
      AppMethodBeat.o(257209);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$initEditUI$2", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-mv_release"})
  public static final class j
    implements com.tencent.mm.emoji.panel.layout.a.c
  {
    public final void pq(int paramInt)
    {
      AppMethodBeat.i(257210);
      Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onPageSettle: " + paramInt + ", last " + MusicMvMakerEditUIC.b(this.AuI));
      if (MusicMvMakerEditUIC.b(this.AuI) == paramInt)
      {
        AppMethodBeat.o(257210);
        return;
      }
      MusicMvMakerEditUIC.a(this.AuI, paramInt);
      MusicMvMakerEditUIC.b(this.AuI, paramInt);
      MusicMvMakerEditUIC.e locale = this.AuI.AuE;
      if (locale != null)
      {
        Object localObject = MusicMvMakerEditUIC.c(this.AuI).get(paramInt);
        p.g(localObject, "dataList[position]");
        locale.b((com.tencent.mm.plugin.mv.a.d)localObject);
        AppMethodBeat.o(257210);
        return;
      }
      AppMethodBeat.o(257210);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$initEditUI$3", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "plugin-mv_release"})
  public static final class k
    extends RecyclerView.c
  {
    public final void onChanged()
    {
      AppMethodBeat.i(257213);
      super.onChanged();
      Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onChanged: " + MusicMvMakerEditUIC.d(this.AuI).getItemCount());
      if (MusicMvMakerEditUIC.e(this.AuI).hbQ == -1) {
        MusicMvMakerEditUIC.f(this.AuI).post((Runnable)new a(this));
      }
      AppMethodBeat.o(257213);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257215);
      super.onItemRangeChanged(paramInt1, paramInt2);
      Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onItemRangeChanged, start:" + paramInt1 + ", itemCount:" + paramInt2 + ", lastPos:" + MusicMvMakerEditUIC.b(this.AuI));
      int i = MusicMvMakerEditUIC.b(this.AuI);
      if (paramInt1 > i)
      {
        AppMethodBeat.o(257215);
        return;
      }
      if (paramInt1 + paramInt2 > i) {
        MusicMvMakerEditUIC.f(this.AuI).post((Runnable)new b(this));
      }
      AppMethodBeat.o(257215);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(257214);
      if (paramObject == null)
      {
        Log.i("MicroMsg.Mv.MusicMvMakerEditUIC", "onItemRangeChanged, start:" + paramInt1 + ", itemCount:" + paramInt2 + ", lastPos:" + MusicMvMakerEditUIC.b(this.AuI) + ", payload:" + paramObject);
        onItemRangeChanged(paramInt1, paramInt2);
      }
      AppMethodBeat.o(257214);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MusicMvMakerEditUIC.k paramk) {}
      
      public final void run()
      {
        AppMethodBeat.i(257211);
        MusicMvMakerEditUIC.e(this.AuJ.AuI).f((RecyclerView)MusicMvMakerEditUIC.f(this.AuJ.AuI));
        AppMethodBeat.o(257211);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(MusicMvMakerEditUIC.k paramk) {}
      
      public final void run()
      {
        AppMethodBeat.i(257212);
        MusicMvMakerEditUIC.b(this.AuJ.AuI, MusicMvMakerEditUIC.b(this.AuJ.AuI));
        AppMethodBeat.o(257212);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.music.ui.view.b>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "attached", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$makeMediaThumbTransition$1$1$1", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$$special$$inlined$let$lambda$1"})
  static final class n
    implements h.a
  {
    n(ImageView paramImageView, com.tencent.mm.plugin.mv.a.d paramd, kotlin.g.a.b paramb) {}
    
    public final void dSs()
    {
      AppMethodBeat.i(257220);
      com.tencent.f.h.RTc.aV((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(257219);
          this.AuN.AuK.animate().alpha(1.0F).setDuration(200L).withEndAction((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(257218);
              this.AuO.AuN.AuK.setVisibility(4);
              com.tencent.mm.plugin.mv.a.f localf = com.tencent.mm.plugin.mv.a.g.eC((View)this.AuO.AuN.AuK);
              kotlin.g.a.b localb = this.AuO.AuN.AuM;
              if (localb != null)
              {
                localb.invoke(localf);
                AppMethodBeat.o(257218);
                return;
              }
              AppMethodBeat.o(257218);
            }
          }).start();
          AppMethodBeat.o(257219);
        }
      });
      AppMethodBeat.o(257220);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "currentPos", "", "totalDuration", "onProgress"})
  static final class o
    implements d.a
  {
    o(MusicMvMakerEditUIC paramMusicMvMakerEditUIC) {}
    
    public final void fn(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257221);
      com.tencent.f.h.RTc.aV((Runnable)new MusicMvMakerEditUIC.o.1(this, paramInt1, paramInt2));
      AppMethodBeat.o(257221);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<WxRecyclerView>
  {
    p(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC$onActivityResult$1", f="MusicMvMakerEditUIC.kt", hxM={}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class q
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ai p$;
    
    q(MusicMvMakerEditUIC paramMusicMvMakerEditUIC, Intent paramIntent, int paramInt, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(257224);
      p.h(paramd, "completion");
      paramd = new q(this.AuI, paramIntent, paramInt2, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(257224);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(257225);
      paramObject1 = ((q)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(257225);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(257223);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(257223);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      MusicMvMakerEditUIC.a(this.AuI, paramIntent, paramInt2);
      paramObject = x.SXb;
      AppMethodBeat.o(257223);
      return paramObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$refreshVideo$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "lastPlayPos", "", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "timeMs", "plugin-mv_release", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$$special$$inlined$let$lambda$2"})
  public static final class r
    implements com.tencent.mm.plugin.thumbplayer.view.e
  {
    long AuQ;
    
    r(com.tencent.mm.plugin.thumbplayer.d.a parama, MusicMvMakerEditUIC paramMusicMvMakerEditUIC, RecyclerView.v paramv, long paramLong, com.tencent.mm.plugin.mv.a.d paramd) {}
    
    public final void Hv(final long paramLong)
    {
      AppMethodBeat.i(257227);
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(paramLong) {});
      AppMethodBeat.o(257227);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(MusicMvMakerEditUIC paramMusicMvMakerEditUIC, int paramInt, com.tencent.mm.plugin.mv.a.d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(257228);
      MusicMvMakerEditUIC.e locale = this.AuI.AuE;
      if (locale != null) {
        locale.evF();
      }
      locale = this.AuI.AuE;
      if (locale != null)
      {
        locale.a(this.AuW, true, null);
        AppMethodBeat.o(257228);
        return;
      }
      AppMethodBeat.o(257228);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "invoke"})
  public static final class t
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.mv.a.f, x>
  {
    public t(MusicMvMakerEditUIC paramMusicMvMakerEditUIC, int paramInt, com.tencent.mm.plugin.mv.a.d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "invoke"})
  public static final class u
    extends q
    implements kotlin.g.a.b<com.tencent.mm.plugin.mv.a.f, x>
  {
    public u(MusicMvMakerEditUIC paramMusicMvMakerEditUIC, int paramInt, com.tencent.mm.plugin.mv.a.d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class v
    implements Runnable
  {
    public v(MusicMvMakerEditUIC paramMusicMvMakerEditUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(257231);
      MusicMvMakerEditUIC.e(this.AuI).f((RecyclerView)MusicMvMakerEditUIC.f(this.AuI));
      AppMethodBeat.o(257231);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC
 * JD-Core Version:    0.7.0.1
 */