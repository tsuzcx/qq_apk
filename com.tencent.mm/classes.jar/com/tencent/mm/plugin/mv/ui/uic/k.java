package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.plugin.music.e.a.d.a;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.model.e.b;
import com.tencent.mm.plugin.mv.model.e.g;
import com.tencent.mm.plugin.mv.model.e.h;
import com.tencent.mm.plugin.mv.model.e.i;
import com.tencent.mm.plugin.mv.ui.a.a.a;
import com.tencent.mm.plugin.thumbplayer.view.MMTPVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVEditActionCallback;", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVEditActionCallback;", "setActionCallback", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVEditActionCallback;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fixMvCardRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getFixMvCardRV", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "fixMvCardRV$delegate", "fromScene", "", "initMusicDataList", "isEdit", "", "()Z", "setEdit", "(Z)V", "isEditNewItem", "setEditNewItem", "itemDecoration", "Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "getItemDecoration", "()Lcom/tencent/mm/plugin/music/ui/view/MusicMVDurationDecoration;", "itemDecoration$delegate", "lastPos", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "musicProgressListener", "Lcom/tencent/mm/plugin/music/player/base/IMusicPlayer$PlayProgressListener;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVItemSizeResolver;", "snapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPVideoLayout;", "checkCanDoNext", "createMvData", "originTrackData", "disableCurrentSyncMusic", "", "getCurrentCardView", "Landroid/view/View;", "getCurrentEditData", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "itemData", "getSamePrefixItem", "initEditUI", "makeMediaThumbTransition", "pos", "newItem", "onAnimationEnd", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "nextAnimationInfo", "moveToNextItem", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onDestroy", "onNextBtnClicked", "onPause", "onResume", "onSwitchIn", "onSwitchOut", "pauseVideo", "refreshVideo", "refreshView", "resumeVideo", "rollbackItemImpl", "item", "rollbackLastEditItem", "rollbackToInitItem", "takePhoto", "isFixMode", "minRecordDurationMs", "maxRecordDurationMs", "takePhotoFinished", "result", "updateAlbumItem", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$VideoMediaItem;", "updateFinderItem", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "updateLyric", "currentPos", "totalDuration", "updateMusicItemList", "itemList", "", "originItemList", "Companion", "IMVEditItemAction", "IMVItemSizeResolver", "ItemEditActionCallback", "MVEditActionCallback", "MVItemSizeResolver", "MusicMVVideoItemConverterFactory", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends UIComponent
{
  public static final k.a Mfj;
  public int Ahg;
  public boolean Ake;
  private final kotlin.j EKZ;
  public com.tencent.mm.plugin.music.model.e.a LMB;
  public dtf LZM;
  private final kotlin.j LZZ;
  public final com.tencent.mm.emoji.panel.layout.a MeK;
  public final ArrayList<com.tencent.mm.plugin.mv.model.e> Mfk;
  private final kotlin.j Mfl;
  private final f Mfm;
  private final d.a Mfn;
  public e Mfo;
  public boolean Mfp;
  private MMTPVideoLayout Mfq;
  private int fromScene;
  public final ArrayList<com.tencent.mm.plugin.mv.model.e> pUj;
  private final kotlin.j xZP;
  
  static
  {
    AppMethodBeat.i(287959);
    Mfj = new k.a((byte)0);
    AppMethodBeat.o(287959);
  }
  
  public k(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287796);
    this.LZZ = kotlin.k.cm((kotlin.g.a.a)new k.i(paramAppCompatActivity));
    this.pUj = new ArrayList();
    this.Mfk = new ArrayList();
    this.xZP = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.EKZ = kotlin.k.cm((kotlin.g.a.a)new k.m(paramAppCompatActivity));
    this.Mfl = kotlin.k.cm((kotlin.g.a.a)new k.l(paramAppCompatActivity));
    this.MeK = new com.tencent.mm.emoji.panel.layout.a();
    this.Mfm = new f();
    this.Ahg = -1;
    this.Mfn = new k..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(287796);
  }
  
  private static final void a(ImageView paramImageView, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(287859);
    s.u(paramImageView, "$thumbView");
    paramImageView.setVisibility(4);
    paramImageView = com.tencent.mm.plugin.mv.model.h.ip((View)paramImageView);
    if (paramb != null) {
      paramb.invoke(paramImageView);
    }
    AppMethodBeat.o(287859);
  }
  
  private static final void a(k paramk)
  {
    AppMethodBeat.i(287843);
    s.u(paramk, "this$0");
    paramk.MeK.aVV();
    AppMethodBeat.o(287843);
  }
  
  private static final void a(k paramk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287818);
    s.u(paramk, "this$0");
    RecyclerView.v localv = paramk.gqQ().fU(paramk.Ahg);
    if (localv != null) {
      ((TextView)localv.caK.findViewById(b.e.LTv)).setText((CharSequence)((com.tencent.mm.plugin.mv.model.e)paramk.pUj.get(paramk.Ahg)).adQ(paramInt1));
    }
    AppMethodBeat.o(287818);
  }
  
  private static final void a(k paramk, int paramInt, com.tencent.mm.plugin.mv.model.e parame)
  {
    AppMethodBeat.i(287878);
    s.u(paramk, "this$0");
    s.u(parame, "$itemData");
    e locale = paramk.Mfo;
    if (locale != null) {
      locale.gpY();
    }
    paramk = paramk.Mfo;
    if (paramk != null) {
      paramk.a(parame, true, null);
    }
    AppMethodBeat.o(287878);
  }
  
  private static final void a(k paramk, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(287834);
    s.u(paramk, "this$0");
    Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "initEditUI: " + paramInt2 + ", " + paramInt4 + "; " + paramInt6 + ", " + paramInt8);
    paramk.Mfm.mbM = (paramInt3 - paramInt1);
    AppMethodBeat.o(287834);
  }
  
  private static final void b(ImageView paramImageView, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(287867);
    s.u(paramImageView, "$thumbView");
    paramImageView.animate().alpha(1.0F).setDuration(200L).withEndAction(new k..ExternalSyntheticLambda4(paramImageView, paramb)).start();
    AppMethodBeat.o(287867);
  }
  
  private static final void b(k paramk)
  {
    AppMethodBeat.i(287850);
    s.u(paramk, "this$0");
    paramk.MeK.a((RecyclerView)paramk.gqQ());
    AppMethodBeat.o(287850);
  }
  
  private static final void b(k paramk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287826);
    s.u(paramk, "this$0");
    com.tencent.threadpool.h.ahAA.bk(new k..ExternalSyntheticLambda7(paramk, paramInt1, paramInt2));
    AppMethodBeat.o(287826);
  }
  
  private static final void c(ImageView paramImageView, kotlin.g.a.b paramb)
  {
    AppMethodBeat.i(287872);
    s.u(paramImageView, "$thumbView");
    com.tencent.threadpool.h.ahAA.bk(new k..ExternalSyntheticLambda3(paramImageView, paramb));
    AppMethodBeat.o(287872);
  }
  
  private final LinearLayoutManager getLayoutManager()
  {
    AppMethodBeat.i(287804);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)this.EKZ.getValue();
    AppMethodBeat.o(287804);
    return localLinearLayoutManager;
  }
  
  private final com.tencent.mm.plugin.music.ui.view.b gqR()
  {
    AppMethodBeat.i(287808);
    com.tencent.mm.plugin.music.ui.view.b localb = (com.tencent.mm.plugin.music.ui.view.b)this.Mfl.getValue();
    AppMethodBeat.o(287808);
    return localb;
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.mv.model.e parame, kotlin.g.a.b<? super com.tencent.mm.plugin.mv.model.g, ah> paramb)
  {
    AppMethodBeat.i(288040);
    Object localObject = getLayoutManager().findViewByPosition(paramInt);
    if (localObject != null)
    {
      localObject = (ImageView)((View)localObject).findViewById(b.e.LTu);
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        ((ImageView)localObject).setAlpha(0.0F);
        parame = parame.LWX;
        if (parame != null) {
          parame.a((ImageView)localObject, new k..ExternalSyntheticLambda1((ImageView)localObject, paramb));
        }
      }
    }
    AppMethodBeat.o(288040);
  }
  
  public final void aei(int paramInt)
  {
    AppMethodBeat.i(288128);
    if (paramInt != this.Ahg)
    {
      com.tencent.mm.plugin.mv.model.e locale = (com.tencent.mm.plugin.mv.model.e)p.ae((List)this.pUj, this.Ahg);
      RecyclerView.v localv;
      a.a locala;
      if ((locale != null) && (locale.Bvd))
      {
        locale.Bvd = false;
        locale.LWW = false;
        localv = gqQ().fU(this.Ahg);
        if ((localv instanceof com.tencent.mm.view.recyclerview.j))
        {
          locala = com.tencent.mm.plugin.mv.ui.a.a.MaU;
          a.a.a((com.tencent.mm.view.recyclerview.j)localv, locale);
        }
      }
      locale = (com.tencent.mm.plugin.mv.model.e)p.ae((List)this.pUj, paramInt);
      if ((locale != null) && (!locale.Bvd))
      {
        locale.Bvd = true;
        locale.LWW = true;
        localv = gqQ().fU(paramInt);
        if ((localv instanceof com.tencent.mm.view.recyclerview.j))
        {
          locala = com.tencent.mm.plugin.mv.ui.a.a.MaU;
          a.a.a((com.tencent.mm.view.recyclerview.j)localv, locale);
        }
      }
    }
    AppMethodBeat.o(288128);
  }
  
  public final void dSW()
  {
    AppMethodBeat.i(288104);
    Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "pauseVideo");
    Object localObject1 = gqQ().fU(this.Ahg);
    if (localObject1 == null)
    {
      AppMethodBeat.o(288104);
      return;
    }
    localObject1 = (MMTPVideoLayout)((RecyclerView.v)localObject1).caK.findViewById(b.e.music_video_layout);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((MMTPVideoLayout)localObject1).getPlayer();
      if (localObject2 != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.c((com.tencent.mm.plugin.thumbplayer.e.b)localObject2);
      }
      localObject1 = ((MMTPVideoLayout)localObject1).getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).stop();
      }
    }
    com.tencent.mm.plugin.mv.model.e locale;
    if (this.Ahg >= 0)
    {
      localObject1 = this.pUj.get(this.Ahg);
      s.s(localObject1, "dataList[lastPos]");
      locale = (com.tencent.mm.plugin.mv.model.e)localObject1;
      localObject1 = this.Mfq;
      if (localObject1 != null) {
        break label168;
      }
      localObject1 = null;
      localObject2 = this.Mfq;
      if (localObject2 != null) {
        break label190;
      }
      localObject2 = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.mv.model.o localo = com.tencent.mm.plugin.mv.model.o.LYk;
      com.tencent.mm.plugin.mv.model.o.a((Context)getActivity(), this.LZM, this.Ahg, locale, (com.tencent.mm.plugin.thumbplayer.d.a)localObject1, (com.tencent.mm.plugin.thumbplayer.d.b)localObject2);
      AppMethodBeat.o(288104);
      return;
      label168:
      localObject1 = ((MMTPVideoLayout)localObject1).getPlayer();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFu;
      break;
      label190:
      localObject2 = ((MMTPVideoLayout)localObject2).getEffector();
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((com.tencent.mm.plugin.thumbplayer.c.e)localObject2).TDC;
      }
    }
  }
  
  public final void dSX()
  {
    AppMethodBeat.i(288109);
    Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "resumeVideo");
    getAdapter().fV(this.MeK.mma);
    AppMethodBeat.o(288109);
  }
  
  public final dtf f(dtf paramdtf)
  {
    AppMethodBeat.i(288089);
    dtf localdtf;
    Object localObject3;
    Object localObject4;
    int k;
    int j;
    HashSet localHashSet;
    Object localObject5;
    int i;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    Object localObject2;
    if (paramdtf != null)
    {
      localdtf = new dtf();
      localdtf.localId = paramdtf.localId;
      localdtf.aaYK = new FinderObject();
      Object localObject1 = paramdtf.aaYK;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).toByteArray();
        if (localObject1 == null) {}
      }
      try
      {
        localObject3 = localdtf.aaYK;
        if (localObject3 != null) {
          ((FinderObject)localObject3).parseFrom((byte[])localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l;
          Log.printErrStackTrace("MicroMsg.Mv.MusicMvMakerFixEditUIC", (Throwable)localException, "createMvData", new Object[0]);
          localObject2 = ah.aiuX;
          continue;
          localObject2 = ((FinderObject)localObject2).objectDesc;
          if (localObject2 == null)
          {
            localObject2 = null;
          }
          else
          {
            localObject2 = ((FinderObjectDesc)localObject2).mvInfo;
            continue;
            l = ((e.h)localObject3).gpA();
            continue;
            j = 0;
            continue;
            j = 0;
            continue;
            j = 0;
          }
        }
        localObject4 = (e.i)localObject4;
        ((bor)localObject3).ZXi = ((e.i)localObject4).videoPath;
        ((bor)localObject3).ZXj = ((e.i)localObject4).startMs;
        ((boq)localObject7).ZXh = ((bor)localObject3);
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("local_material_id:", ((e.i)localObject4).videoPath));
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("local_material_time_offset_in_clip_ms:", Long.valueOf(((e.i)localObject4).startMs)));
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("set finderMVTrack, timeOffsetInClipMs:", Long.valueOf(((boq)localObject7).TBO)));
        if (!localHashSet.add(((FinderObject)localObject5).objectNonceId)) {
          break label1077;
        }
      }
      localdtf.aaYM = paramdtf.aaYM;
      localObject4 = null;
      localObject3 = null;
      k = 0;
      j = 0;
      localHashSet = new HashSet();
      localObject1 = localdtf.aaYK;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          ((bol)localObject1).ZWM = 0;
        }
        localObject1 = localdtf.aaYK;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObject)localObject1).objectDesc;
          if (localObject1 != null)
          {
            localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
            if (localObject1 != null)
            {
              localObject1 = ((bol)localObject1).ZWL;
              if (localObject1 != null)
              {
                ((LinkedList)localObject1).clear();
                localObject1 = ah.aiuX;
              }
            }
          }
        }
        localdtf.ZJp.clear();
        localObject5 = localdtf.aaYK;
        i = k;
        localObject1 = localObject4;
        if (localObject5 == null) {
          break label1355;
        }
        localObject5 = ((FinderObject)localObject5).objectDesc;
        i = k;
        localObject1 = localObject4;
        if (localObject5 == null) {
          break label1355;
        }
        localObject5 = ((FinderObjectDesc)localObject5).mvInfo;
        i = k;
        localObject1 = localObject4;
        if (localObject5 == null) {
          break label1355;
        }
        localObject5 = ((bol)localObject5).ZWI;
        i = k;
        localObject1 = localObject4;
        if (localObject5 == null) {
          break label1355;
        }
        localObject6 = ((Iterable)localObject5).iterator();
        k = 0;
        localObject1 = localObject3;
        i = j;
        if (!((Iterator)localObject6).hasNext()) {
          break label1350;
        }
        localObject3 = ((Iterator)localObject6).next();
        if (k < 0) {
          p.kkW();
        }
        localObject7 = (boq)localObject3;
        localObject8 = (com.tencent.mm.plugin.mv.model.e)p.ae((List)this.pUj, k);
        j = i;
        localObject3 = localObject1;
        if (localObject8 == null) {
          break label1191;
        }
        localObject4 = ((com.tencent.mm.plugin.mv.model.e)localObject8).LWY;
        j = i;
        localObject3 = localObject1;
        if (localObject4 == null) {
          break label1181;
        }
        localObject5 = ((e.h)localObject4).gpC();
        j = i;
        localObject3 = localObject1;
        if (localObject5 == null) {
          break label1181;
        }
        ((boq)localObject7).refObjectId = ((FinderObject)localObject5).id;
        ((boq)localObject7).ZWZ = ((FinderObject)localObject5).objectNonceId;
        localObject3 = ((com.tencent.mm.plugin.mv.model.e)this.pUj.get(k)).LWY;
        if (localObject3 != null) {
          break label666;
        }
        l = 0L;
        ((boq)localObject7).TBO = l;
        localObject3 = ((com.tencent.mm.plugin.mv.model.e)this.pUj.get(k)).LWY;
        if ((localObject3 == null) || (((e.h)localObject3).eDB() != true)) {
          break label678;
        }
        j = 1;
        if (j == 0) {
          break label683;
        }
        j = 1;
        ((boq)localObject7).mdP = j;
        localObject3 = ((com.tencent.mm.plugin.mv.model.e)this.pUj.get(k)).LWY;
        if ((localObject3 == null) || (((e.h)localObject3).eDB() != true)) {
          break label688;
        }
        j = 1;
        if ((j == 0) || (!(((com.tencent.mm.plugin.mv.model.e)this.pUj.get(k)).LWY instanceof e.i))) {
          break label764;
        }
        localObject3 = new bor();
        localObject4 = ((com.tencent.mm.plugin.mv.model.e)this.pUj.get(k)).LWY;
        if (localObject4 != null) {
          break label693;
        }
        paramdtf = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.mv.model.MusicMVVideoConvertData.LocalVideoData");
        AppMethodBeat.o(288089);
        throw paramdtf;
      }
      label666:
      label678:
      label683:
      label688:
      label693:
      label764:
      localObject3 = ((FinderObject)localObject5).objectDesc;
      if (localObject3 != null) {
        ((FinderObjectDesc)localObject3).mvInfo = new bol();
      }
      localObject3 = ((FinderObject)localObject5).objectDesc;
      if (localObject3 == null)
      {
        localObject3 = null;
        label836:
        if (localObject3 != null) {
          ((bol)localObject3).ZWM = 0;
        }
        localObject3 = ((FinderObject)localObject5).objectDesc;
        if (localObject3 != null)
        {
          localObject3 = ((FinderObjectDesc)localObject3).mvInfo;
          if (localObject3 != null)
          {
            localObject3 = ((bol)localObject3).ZWI;
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
        if (localObject3 != null) {
          break label1216;
        }
        localObject3 = null;
        label924:
        if (localObject3 != null) {
          ((FinderMedia)localObject3).mediaType = 4;
        }
        localObject3 = ((FinderObject)localObject5).objectDesc;
        if (localObject3 != null) {
          break label1247;
        }
        localObject3 = null;
        label950:
        StringBuilder localStringBuilder = new StringBuilder("ref object media size:");
        localObject4 = ((FinderObject)localObject5).objectDesc;
        if (localObject4 != null) {
          break label1278;
        }
        localObject4 = null;
        label977:
        localStringBuilder = localStringBuilder.append(localObject4).append(", ");
        if (localObject3 != null) {
          break label1309;
        }
        localObject4 = null;
        label1000:
        localStringBuilder = localStringBuilder.append(localObject4).append(", [");
        if (localObject3 != null) {
          break label1319;
        }
        localObject4 = null;
        label1023:
        localObject4 = localStringBuilder.append(localObject4).append(' ');
        if (localObject3 != null) {
          break label1332;
        }
        localObject3 = null;
        label1045:
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", localObject3 + ']');
        localdtf.ZJp.add(localObject5);
        label1077:
        if (((FinderObject)localObject5).id == 0L)
        {
          localObject3 = ((FinderObject)localObject5).objectNonceId;
          if ((localObject3 == null) || (n.U((String)localObject3, "local_", false) != true)) {
            break label1345;
          }
          j = 1;
          label1114:
          if (j != 0)
          {
            ((boq)localObject7).ZXa = 1;
            Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("createMvData isFirstUpload ", ((FinderObject)localObject5).objectNonceId));
          }
        }
        if ((((com.tencent.mm.plugin.mv.model.e)localObject8).LWZ == null) || (localObject2 != null)) {
          break label1977;
        }
        i = (int)((boq)localObject7).TBM;
        localObject2 = localObject5;
      }
    }
    label1181:
    label1191:
    label1332:
    label1977:
    for (;;)
    {
      localObject3 = ah.aiuX;
      localObject3 = ah.aiuX;
      localObject3 = localObject2;
      j = i;
      localObject2 = ah.aiuX;
      localObject2 = ah.aiuX;
      k += 1;
      i = j;
      localObject2 = localObject3;
      break;
      localObject3 = ((FinderObjectDesc)localObject3).mvInfo;
      break label836;
      label1216:
      localObject3 = ((FinderObjectDesc)localObject3).media;
      if (localObject3 == null)
      {
        localObject3 = null;
        break label924;
      }
      localObject3 = (FinderMedia)((LinkedList)localObject3).getFirst();
      break label924;
      label1247:
      localObject3 = ((FinderObjectDesc)localObject3).media;
      if (localObject3 == null)
      {
        localObject3 = null;
        break label950;
      }
      localObject3 = (FinderMedia)((LinkedList)localObject3).getFirst();
      break label950;
      label1278:
      localObject4 = ((FinderObjectDesc)localObject4).media;
      if (localObject4 == null)
      {
        localObject4 = null;
        break label977;
      }
      localObject4 = Integer.valueOf(((LinkedList)localObject4).size());
      break label977;
      localObject4 = ((FinderMedia)localObject3).url;
      break label1000;
      localObject4 = Float.valueOf(((FinderMedia)localObject3).width);
      break label1023;
      localObject3 = Float.valueOf(((FinderMedia)localObject3).height);
      break label1045;
      label1345:
      j = 0;
      break label1114;
      label1350:
      localObject3 = ah.aiuX;
      label1355:
      localObject3 = localdtf.ZJp;
      localObject4 = paramdtf.ZJp;
      s.s(localObject4, "it.refObjectList");
      localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList();
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = ((Iterator)localObject5).next();
        localObject7 = (FinderObject)localObject6;
        localObject8 = paramdtf.aaYM;
        if (localObject8 != null)
        {
          localObject8 = ((bol)localObject8).ZWI;
          if (localObject8 != null)
          {
            localObject8 = (Iterable)localObject8;
            if ((!(localObject8 instanceof Collection)) || (!((Collection)localObject8).isEmpty()))
            {
              localObject8 = ((Iterable)localObject8).iterator();
              while (((Iterator)localObject8).hasNext()) {
                if (s.p(((boq)((Iterator)localObject8).next()).ZWZ, ((FinderObject)localObject7).objectNonceId))
                {
                  j = 1;
                  label1526:
                  if (j != 1) {
                    break label1574;
                  }
                  j = 1;
                  label1533:
                  if ((j == 0) || (!localHashSet.add(((FinderObject)localObject7).objectNonceId))) {
                    break label1579;
                  }
                }
              }
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label1582;
          }
          ((Collection)localObject4).add(localObject6);
          break;
          j = 0;
          break label1526;
          j = 0;
          break label1533;
        }
      }
      ((LinkedList)localObject3).addAll((Collection)localObject4);
      localdtf.aaYL = paramdtf.aaYL;
      if (this.fromScene != 0)
      {
        paramdtf = localdtf.aaYL;
        if ((paramdtf == null) || (n.rs(paramdtf, ".auto") != true)) {
          break label1908;
        }
        j = 1;
        if (j == 0)
        {
          paramdtf = (CharSequence)localdtf.aaYL;
          if ((paramdtf != null) && (paramdtf.length() != 0)) {
            break label1913;
          }
          j = 1;
          if (j == 0) {
            break label1899;
          }
        }
      }
      paramdtf = com.tencent.mm.ui.component.k.aeZF;
      paramdtf = (m)com.tencent.mm.ui.component.k.d(getActivity()).q(m.class);
      paramdtf = new r(Integer.valueOf(paramdtf.Mga), paramdtf.Mgb);
      j = ((Number)paramdtf.bsC).intValue();
      localObject3 = (Bitmap)paramdtf.bsD;
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "originCoverPath:" + localdtf.aaYL + ", fromScene:" + this.fromScene + ", thumbObj:" + localObject2 + ", thumbMvTime:" + i + " firstRenderTime:" + j + ", firstRenderFrame:" + localObject3);
      if ((j <= i) && (localObject3 != null))
      {
        paramdtf = com.tencent.mm.plugin.mv.ui.a.Maz;
        if (localObject2 == null)
        {
          paramdtf = null;
          localObject2 = paramdtf;
          if (paramdtf == null) {
            localObject2 = UUID.randomUUID().toString();
          }
          s.s(localObject2, "thumbObj?.objectNonceId …D.randomUUID().toString()");
          paramdtf = s.X(com.tencent.mm.plugin.mv.ui.a.aPB((String)localObject2), ".auto");
          BitmapUtil.saveBitmapToImage((Bitmap)localObject3, 70, Bitmap.CompressFormat.PNG, paramdtf, false);
          localdtf.aaYL = paramdtf;
          Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("auto generate thumb succeed: ", paramdtf));
        }
      }
      for (;;)
      {
        label1899:
        AppMethodBeat.o(288089);
        return localdtf;
        label1908:
        j = 0;
        break;
        label1913:
        j = 0;
        break label1665;
        paramdtf = ((FinderObject)localObject2).objectNonceId;
        break label1832;
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "current firstRenderTime[" + j + "] large than thumbMvTime[" + i + "], do not generate thumb!");
      }
      AppMethodBeat.o(288089);
      return null;
    }
  }
  
  public final WxRecyclerAdapter<com.tencent.mm.plugin.mv.model.e> getAdapter()
  {
    AppMethodBeat.i(288008);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.xZP.getValue();
    AppMethodBeat.o(288008);
    return localWxRecyclerAdapter;
  }
  
  public final WxRecyclerView gqQ()
  {
    AppMethodBeat.i(288004);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.LZZ.getValue();
    AppMethodBeat.o(288004);
    return localWxRecyclerView;
  }
  
  public final void gqS()
  {
    AppMethodBeat.i(288026);
    this.fromScene = getIntent().getIntExtra("key_mv_from_scene", 0);
    gqQ().setItemAnimator(null);
    gqQ().setLayoutManager((RecyclerView.LayoutManager)getLayoutManager());
    gqQ().setAdapter((RecyclerView.a)getAdapter());
    gqQ().setPadding(f.getPadding(), 0, f.getPadding(), 0);
    this.Mfm.mbM = com.tencent.mm.cd.a.ms((Context)getContext());
    gqQ().addOnLayoutChangeListener(new k..ExternalSyntheticLambda0(this));
    gqQ().a((RecyclerView.h)gqR());
    this.MeK.mmc = ((a.c)new j(this));
    getAdapter().a((RecyclerView.c)new k(this));
    dtf localdtf = this.LZM;
    Object localObject1;
    LinkedList localLinkedList1;
    LinkedList localLinkedList2;
    Object localObject2;
    label212:
    int i;
    label262:
    Object localObject3;
    Object localObject4;
    if (localdtf != null)
    {
      localObject1 = com.tencent.mm.plugin.mv.model.e.LWT;
      localObject1 = this.LMB;
      s.u(localdtf, "trackData");
      localLinkedList1 = new LinkedList();
      localLinkedList2 = new LinkedList();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label511;
        }
        localObject2 = null;
        localObject1 = localdtf.aaYK;
        if (localObject1 == null) {
          break label525;
        }
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 == null) {
          break label525;
        }
        localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
        if (localObject1 == null) {
          break label525;
        }
        localObject1 = ((bol)localObject1).ZWI;
        if (localObject1 == null) {
          break label525;
        }
        Iterator localIterator = ((Iterable)localObject1).iterator();
        i = 0;
        if (!localIterator.hasNext()) {
          break label525;
        }
        localObject1 = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        localObject3 = (boq)localObject1;
        localObject1 = com.tencent.mm.plugin.mv.model.e.LWT;
        s.s(localObject3, "mvTrack");
        localObject1 = localdtf.ZJp;
        s.s(localObject1, "trackData.refObjectList");
        localObject4 = e.b.a((boq)localObject3, (com.tencent.mm.plugin.music.model.e)localObject2, (List)localObject1);
        localObject1 = localdtf.aaYM;
        if (localObject1 == null) {
          break label871;
        }
        localObject1 = ((bol)localObject1).ZWI;
        if (localObject1 == null) {
          break label871;
        }
        boq localboq = (boq)p.ae((List)localObject1, i);
        if (localboq == null) {
          break label871;
        }
        localObject1 = com.tencent.mm.plugin.mv.model.e.LWT;
        localObject1 = localdtf.ZJp;
        s.s(localObject1, "trackData.refObjectList");
        localObject1 = e.b.a(localboq, (com.tencent.mm.plugin.music.model.e)localObject2, (List)localObject1);
        if (localObject1 != null) {
          ((com.tencent.mm.plugin.mv.model.e)localObject1).type = 0;
        }
        if (s.p(((boq)localObject3).ZWZ, localboq.ZWZ)) {
          break label516;
        }
        ((com.tencent.mm.plugin.mv.model.e)localObject4).LWZ = ((com.tencent.mm.plugin.mv.model.e)localObject1);
      }
    }
    for (;;)
    {
      localLinkedList1.add(localObject4);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = localObject4;
      }
      localLinkedList2.add(localObject3);
      i += 1;
      break label262;
      localObject2 = com.tencent.mm.plugin.music.model.o.god();
      if (((com.tencent.mm.plugin.music.model.e.b)localObject2).LNK.get(((com.tencent.mm.plugin.music.model.e.a)localObject1).field_musicId) != null)
      {
        localObject1 = (com.tencent.mm.plugin.music.model.e)((com.tencent.mm.plugin.music.model.e.b)localObject2).LNK.get(((com.tencent.mm.plugin.music.model.e.a)localObject1).field_musicId);
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.music.model.e.b)localObject2).b((com.tencent.mm.plugin.music.model.e.a)localObject1, false, false);
      break;
      label511:
      localObject2 = localObject1;
      break label212;
      label516:
      ((com.tencent.mm.plugin.mv.model.e)localObject4).type = 0;
      continue;
      label525:
      localObject2 = new r(localLinkedList1, localLinkedList2);
      localObject1 = (List)((r)localObject2).bsC;
      localObject2 = (List)((r)localObject2).bsD;
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "updateMusicItemList size:" + ((List)localObject1).size() + ", origin size:" + ((List)localObject2).size());
      this.pUj.clear();
      this.pUj.addAll((Collection)localObject1);
      this.Mfk.clear();
      this.Mfk.addAll((Collection)localObject2);
      getAdapter().bZE.notifyChanged();
      gqQ().post(new k..ExternalSyntheticLambda5(this));
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(Long.valueOf(0L));
      localObject2 = localdtf.aaYK;
      if (localObject2 != null)
      {
        localObject2 = ((FinderObject)localObject2).objectDesc;
        if (localObject2 != null)
        {
          localObject2 = ((FinderObjectDesc)localObject2).mvInfo;
          if (localObject2 != null)
          {
            localObject2 = ((bol)localObject2).ZWI;
            if (localObject2 != null)
            {
              localObject3 = (Iterable)localObject2;
              localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (boq)((Iterator)localObject3).next();
                ((Collection)localObject2).add(Long.valueOf(((boq)localObject4).TBM + ((boq)localObject4).ZWY));
              }
              ((ArrayList)localObject1).addAll((Collection)localObject2);
            }
          }
        }
      }
      gqR().je((List)localObject1);
      this.Mfq = new MMTPVideoLayout((Context)getActivity());
      localObject1 = this.Mfq;
      if (localObject1 != null) {
        ((MMTPVideoLayout)localObject1).hLO();
      }
      localObject1 = this.Mfq;
      if (localObject1 != null) {
        ((MMTPVideoLayout)localObject1).setId(b.e.music_video_layout);
      }
      AppMethodBeat.o(288026);
      return;
      label871:
      localObject1 = null;
    }
  }
  
  public final void gqT()
  {
    AppMethodBeat.i(288032);
    gqQ().setVisibility(0);
    if (this.MeK.mma == -1) {
      gqQ().post(new k..ExternalSyntheticLambda6(this));
    }
    AppMethodBeat.o(288032);
  }
  
  public final View gqU()
  {
    AppMethodBeat.i(288054);
    View localView = getLayoutManager().findViewByPosition(this.MeK.mma);
    AppMethodBeat.o(288054);
    return localView;
  }
  
  public final boolean gqV()
  {
    AppMethodBeat.i(288060);
    Object localObject = (Iterable)this.pUj;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        if (((com.tencent.mm.plugin.mv.model.e)((Iterator)localObject).next()).LWZ != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(288060);
          return true;
        }
      }
    }
    AppMethodBeat.o(288060);
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(288134);
    Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onActivityResult, requestCodec:" + paramInt1 + ", resultCodec:" + paramInt2);
    if (paramInt1 == 1024)
    {
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().resume();
      kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (kotlin.g.a.m)new k.n(this, paramIntent, paramInt2, null), 2);
    }
    AppMethodBeat.o(288134);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(288095);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(j.class);
    s.s(localObject, "UICProvider.of(activity)…MakerDataUIC::class.java)");
    localObject = (Integer)((j)localObject).gqP().getValue();
    if (localObject == null) {}
    while (((Integer)localObject).intValue() != 0)
    {
      AppMethodBeat.o(288095);
      return false;
    }
    localObject = com.tencent.mm.ui.component.k.aeZF;
    ((q)com.tencent.mm.ui.component.k.d(getActivity()).q(q.class)).a(f(this.LZM), this.Ake, 2);
    AppMethodBeat.o(288095);
    return true;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(288036);
    super.onDestroy();
    Object localObject = this.Mfq;
    if (localObject != null)
    {
      localObject = ((MMTPVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
    }
    localObject = this.Mfq;
    if (localObject != null)
    {
      localObject = ((MMTPVideoLayout)localObject).getEffector();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.c.e)localObject).release();
      }
    }
    AppMethodBeat.o(288036);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(288117);
    super.onPause();
    dSW();
    com.tencent.mm.plugin.music.logic.j.gnw().gnj().b(this.Mfn);
    AppMethodBeat.o(288117);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(288122);
    super.onResume();
    dSX();
    com.tencent.mm.plugin.music.logic.j.gnw().gnj().a(this.Mfn);
    AppMethodBeat.o(288122);
  }
  
  public final void q(kotlin.g.a.m<? super Integer, ? super com.tencent.mm.plugin.mv.model.e, ah> paramm)
  {
    AppMethodBeat.i(288048);
    s.u(paramm, "callback");
    int i = this.MeK.mma;
    com.tencent.mm.plugin.mv.model.e locale = (com.tencent.mm.plugin.mv.model.e)p.ae((List)this.pUj, i);
    if (locale != null) {
      paramm.invoke(Integer.valueOf(i), locale);
    }
    AppMethodBeat.o(288048);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;", "", "onEdit", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "itemView", "Landroid/view/View;", "onRollback", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(int paramInt, com.tencent.mm.plugin.mv.model.e parame, View paramView);
    
    public abstract void b(int paramInt, com.tencent.mm.plugin.mv.model.e parame, View paramView);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "", "getItemWidth", "", "getPadding", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract int getItemWidth();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$ItemEditActionCallback;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC;)V", "onEdit", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "itemView", "Landroid/view/View;", "onRollback", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    implements k.b
  {
    public d()
    {
      AppMethodBeat.i(287529);
      AppMethodBeat.o(287529);
    }
    
    public final void a(int paramInt, com.tencent.mm.plugin.mv.model.e parame, View paramView)
    {
      AppMethodBeat.i(287540);
      s.u(parame, "item");
      s.u(paramView, "itemView");
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("onRollback: ", Integer.valueOf(paramInt)));
      k.a(this.Mfr, parame, paramInt);
      paramView = this.Mfr.Mfo;
      if (paramView != null) {
        paramView.c(parame);
      }
      AppMethodBeat.o(287540);
    }
    
    public final void b(int paramInt, com.tencent.mm.plugin.mv.model.e parame, View paramView)
    {
      AppMethodBeat.i(287550);
      s.u(parame, "item");
      s.u(paramView, "itemView");
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("onEdit: ", Integer.valueOf(paramInt)));
      Object localObject = (ImageView)paramView.findViewById(b.e.LTz);
      if (localObject != null)
      {
        paramView = this.Mfr;
        localObject = com.tencent.mm.plugin.mv.model.h.ip((View)localObject);
        paramView = paramView.Mfo;
        if (paramView != null) {
          paramView.a(parame, false, (com.tencent.mm.plugin.mv.model.g)localObject);
        }
      }
      AppMethodBeat.o(287550);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVEditActionCallback;", "", "onEditItem", "", "position", "", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "fromSelectNewItem", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;", "onItemSelected", "onRollback", "onTakePhotoFinished", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface e
  {
    public abstract void a(com.tencent.mm.plugin.mv.model.e parame, boolean paramBoolean, com.tencent.mm.plugin.mv.model.g paramg);
    
    public abstract void b(com.tencent.mm.plugin.mv.model.e parame);
    
    public abstract void c(com.tencent.mm.plugin.mv.model.e parame);
    
    public abstract void gpY();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MVItemSizeResolver;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC;)V", "viewWidth", "", "getViewWidth", "()I", "setViewWidth", "(I)V", "getItemWidth", "getPadding", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class f
    implements k.c
  {
    int mbM;
    
    public f()
    {
      AppMethodBeat.i(287511);
      AppMethodBeat.o(287511);
    }
    
    public static int getPadding()
    {
      AppMethodBeat.i(287516);
      int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 70);
      AppMethodBeat.o(287516);
      return i;
    }
    
    public final int getItemWidth()
    {
      AppMethodBeat.i(287519);
      if (this.mbM == 0)
      {
        i = com.tencent.mm.cd.a.ms((Context)this.Mfr.getActivity());
        j = getPadding();
        AppMethodBeat.o(287519);
        return i - j * 2;
      }
      int i = this.mbM;
      int j = getPadding();
      AppMethodBeat.o(287519);
      return i - j * 2;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$MusicMVVideoItemConverterFactory;", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC;Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;)V", "getSizeResolver", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class g
    implements com.tencent.mm.view.recyclerview.g
  {
    private final k.c MaV;
    
    public g()
    {
      AppMethodBeat.i(287512);
      this.MaV = localObject;
      AppMethodBeat.o(287512);
    }
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(287517);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.mv.ui.a.a(this.MaV, (k.b)new k.d(k.this));
      AppMethodBeat.o(287517);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<WxRecyclerAdapter<com.tencent.mm.plugin.mv.model.e>>
  {
    h(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$initEditUI$2", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements a.c
  {
    j(k paramk) {}
    
    public final void rL(int paramInt)
    {
      AppMethodBeat.i(287530);
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onPageSettle: " + paramInt + ", last " + k.c(this.Mfr));
      if (k.c(this.Mfr) == paramInt)
      {
        AppMethodBeat.o(287530);
        return;
      }
      k.a(this.Mfr, paramInt);
      k.b(this.Mfr, paramInt);
      k.e locale = this.Mfr.Mfo;
      if (locale != null)
      {
        Object localObject = k.d(this.Mfr).get(paramInt);
        s.s(localObject, "dataList[position]");
        locale.b((com.tencent.mm.plugin.mv.model.e)localObject);
      }
      AppMethodBeat.o(287530);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$initEditUI$3", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends RecyclerView.c
  {
    k(k paramk) {}
    
    private static final void j(k paramk)
    {
      AppMethodBeat.i(287521);
      s.u(paramk, "this$0");
      k.f(paramk).a((RecyclerView)k.g(paramk));
      AppMethodBeat.o(287521);
    }
    
    private static final void k(k paramk)
    {
      AppMethodBeat.i(287523);
      s.u(paramk, "this$0");
      k.b(paramk, k.c(paramk));
      AppMethodBeat.o(287523);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(287541);
      super.onChanged();
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("onChanged: ", Integer.valueOf(k.e(this.Mfr).getItemCount())));
      if (k.f(this.Mfr).mma == -1) {
        k.g(this.Mfr).post(new k.k..ExternalSyntheticLambda1(this.Mfr));
      }
      AppMethodBeat.o(287541);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      int j = 0;
      AppMethodBeat.i(287554);
      super.onItemRangeChanged(paramInt1, paramInt2);
      Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onItemRangeChanged, start:" + paramInt1 + ", itemCount:" + paramInt2 + ", lastPos:" + k.c(this.Mfr));
      int k = k.c(this.Mfr);
      int i = j;
      if (paramInt1 <= k)
      {
        i = j;
        if (k < paramInt1 + paramInt2) {
          i = 1;
        }
      }
      if (i != 0) {
        k.g(this.Mfr).post(new k.k..ExternalSyntheticLambda0(this.Mfr));
      }
      AppMethodBeat.o(287554);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(287546);
      if (paramObject == null)
      {
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", "onItemRangeChanged, start:" + paramInt1 + ", itemCount:" + paramInt2 + ", lastPos:" + k.c(this.Mfr) + ", payload:" + paramObject);
        onItemRangeChanged(paramInt1, paramInt2);
      }
      AppMethodBeat.o(287546);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    long Yx;
    int label;
    
    o(int paramInt, k paramk, kotlin.d.d<? super o> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(287564);
      paramObject = (kotlin.d.d)new o(this.qkg, this.Mfr, paramd);
      AppMethodBeat.o(287564);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(287558);
      Object localObject3 = kotlin.d.a.a.aiwj;
      label189:
      Object localObject4;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(287558);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.printInfoStack("MicroMsg.Mv.MusicMvMakerFixEditUIC", "refreshVideo: " + this.qkg + ' ' + k.c(this.Mfr), new Object[0]);
        int i;
        if (k.c(this.Mfr) >= 0)
        {
          paramObject = k.h(this.Mfr);
          if (paramObject == null) {
            break label275;
          }
          paramObject = paramObject.getPlayer();
          if ((paramObject == null) || (paramObject.isPlaying() != true)) {
            break label275;
          }
          i = 1;
          if (i != 0)
          {
            paramObject = k.d(this.Mfr).get(k.c(this.Mfr));
            s.s(paramObject, "dataList[lastPos]");
            localObject2 = (com.tencent.mm.plugin.mv.model.e)paramObject;
            paramObject = k.h(this.Mfr);
            if (paramObject != null) {
              break label280;
            }
            paramObject = null;
            localObject1 = k.h(this.Mfr);
            if (localObject1 != null) {
              break label302;
            }
            localObject1 = null;
          }
        }
        for (;;)
        {
          localObject4 = com.tencent.mm.plugin.mv.model.o.LYk;
          com.tencent.mm.plugin.mv.model.o.a((Context)this.Mfr.getActivity(), this.Mfr.LZM, k.c(this.Mfr), (com.tencent.mm.plugin.mv.model.e)localObject2, paramObject, (com.tencent.mm.plugin.thumbplayer.d.b)localObject1);
          localObject1 = k.g(this.Mfr).fU(this.qkg);
          if (localObject1 != null) {
            break label330;
          }
          paramObject = ah.aiuX;
          AppMethodBeat.o(287558);
          return paramObject;
          label275:
          i = 0;
          break;
          label280:
          paramObject = paramObject.getPlayer();
          if (paramObject == null)
          {
            paramObject = null;
            break label189;
          }
          paramObject = paramObject.TFu;
          break label189;
          label302:
          localObject1 = ((MMTPVideoLayout)localObject1).getEffector();
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.e)localObject1).TDC;
          }
        }
        label330:
        paramObject = k.d(this.Mfr).get(this.qkg);
        s.s(paramObject, "dataList[position]");
        paramObject = (com.tencent.mm.plugin.mv.model.e)paramObject;
        k.c(this.Mfr, this.qkg);
        if (paramObject.LWW) {
          com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(paramObject.LWU);
        }
        localObject2 = paramObject.LWY;
        if (localObject2 == null) {}
        for (l = 0L;; l = ((e.h)localObject2).gpA())
        {
          localObject2 = (kotlin.d.f)bg.kCi();
          localObject4 = (kotlin.g.a.m)new b(paramObject, null);
          kotlin.d.d locald = (kotlin.d.d)this;
          this.L$0 = localObject1;
          this.Uf = paramObject;
          this.Yx = l;
          this.label = 1;
          localObject2 = l.a((kotlin.d.f)localObject2, (kotlin.g.a.m)localObject4, locald);
          if (localObject2 != localObject3) {
            break;
          }
          AppMethodBeat.o(287558);
          return localObject3;
        }
      }
      final long l = this.Yx;
      localObject3 = (com.tencent.mm.plugin.mv.model.e)this.Uf;
      Object localObject1 = (RecyclerView.v)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      Object localObject2 = paramObject;
      paramObject = localObject3;
      for (;;)
      {
        localObject3 = (com.tencent.mm.plugin.thumbplayer.a.b)localObject2;
        if (localObject3 == null)
        {
          paramObject = ah.aiuX;
          AppMethodBeat.o(287558);
          return paramObject;
        }
        Log.i("MicroMsg.Mv.MusicMvMakerFixEditUIC", s.X("refreshVideo mediaInfo:", localObject3));
        localObject4 = (FrameLayout)((RecyclerView.v)localObject1).caK.findViewById(b.e.video_container);
        localObject2 = k.h(this.Mfr);
        if (localObject2 == null)
        {
          localObject2 = null;
          if (localObject2 == null) {
            break label674;
          }
          localObject2 = k.h(this.Mfr);
          if (localObject2 != null) {
            break label646;
          }
        }
        label646:
        for (localObject2 = null;; localObject2 = ((MMTPVideoLayout)localObject2).getParent())
        {
          if (localObject2 != null) {
            break label656;
          }
          paramObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(287558);
          throw paramObject;
          localObject2 = ((MMTPVideoLayout)localObject2).getParent();
          break;
        }
        label656:
        ((ViewGroup)localObject2).removeView((View)k.h(this.Mfr));
        label674:
        ((FrameLayout)localObject4).removeAllViews();
        localObject2 = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        ((FrameLayout)localObject4).addView((View)k.h(this.Mfr), (ViewGroup.LayoutParams)localObject2);
        ((ProgressBar)((RecyclerView.v)localObject1).caK.findViewById(b.e.LUr)).setProgress(0);
        localObject2 = k.h(this.Mfr);
        if (localObject2 != null)
        {
          ((MMTPVideoLayout)localObject2).fva();
          ((MMTPVideoLayout)localObject2).setKeepScreenOn(true);
          localObject4 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject4 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject4).eLO();
          }
          ((MMTPVideoLayout)localObject2).setMediaInfo((com.tencent.mm.plugin.thumbplayer.a.b)localObject3);
          localObject3 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject3).Flr = true;
          }
          localObject3 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject3).setMute(true);
          }
          localObject3 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject3).setLoop(true);
          }
          com.tencent.mm.plugin.thumbplayer.c.e.a(((MMTPVideoLayout)localObject2).getEffector());
          localObject3 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject3).bs(l, paramObject.getDurationMs() + l);
          }
          localObject3 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject3).hLh();
          }
          localObject2 = ((MMTPVideoLayout)localObject2).getPlayer();
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.thumbplayer.e.b)localObject2).a((com.tencent.mm.plugin.thumbplayer.view.e)new a(paramObject, l, (RecyclerView.v)localObject1), 30L);
          }
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(287558);
        return paramObject;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$refreshVideo$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "lastPlayPos", "", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "timeMs", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.mm.plugin.thumbplayer.view.e
    {
      long Mfu;
      
      a(com.tencent.mm.plugin.mv.model.e parame, long paramLong, RecyclerView.v paramv) {}
      
      public final void a(com.tencent.mm.plugin.thumbplayer.a.b paramb, final long paramLong)
      {
        AppMethodBeat.i(287877);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.Mfv, this, paramLong, l, this.ucs));
        AppMethodBeat.o(287877);
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(com.tencent.mm.plugin.mv.model.e parame, k.o.a parama, long paramLong1, long paramLong2, RecyclerView.v paramv)
        {
          super();
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super com.tencent.mm.plugin.thumbplayer.a.b>, Object>
    {
      int label;
      
      b(com.tencent.mm.plugin.mv.model.e parame, kotlin.d.d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(287917);
        paramObject = (kotlin.d.d)new b(this.Mfv, paramd);
        AppMethodBeat.o(287917);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(287913);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(287913);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.Mfv.LWY;
        if (paramObject == null)
        {
          AppMethodBeat.o(287913);
          return null;
        }
        paramObject = paramObject.gpB();
        AppMethodBeat.o(287913);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class p
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.mv.model.g, ah>
  {
    public p(k paramk, int paramInt, com.tencent.mm.plugin.mv.model.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "animationInfo", "Lcom/tencent/mm/plugin/mv/model/MusicMvAnimationInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class q
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.mv.model.g, ah>
  {
    public q(k paramk, int paramInt, com.tencent.mm.plugin.mv.model.e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.k
 * JD-Core Version:    0.7.0.1
 */