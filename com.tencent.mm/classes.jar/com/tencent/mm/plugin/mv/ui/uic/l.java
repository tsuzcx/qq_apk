package com.tencent.mm.plugin.mv.ui.uic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Parcelable.Creator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.mv.b.d;
import com.tencent.mm.plugin.mv.model.flex.MusicMvFlexLiveList;
import com.tencent.mm.plugin.mv.model.flex.a.a;
import com.tencent.mm.plugin.mv.model.flex.a.c;
import com.tencent.mm.plugin.mv.model.flex.b.a;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.e;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.bqo;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.protocal.protobuf.dse;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.protocal.protobuf.eww;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "_albumPreviewActionLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "_takePhotoActionLiveData", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "getAdapter", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "albumPreviewActionLiveData", "Landroidx/lifecycle/LiveData;", "getAlbumPreviewActionLiveData", "()Landroidx/lifecycle/LiveData;", "arrangementReqJob", "Lkotlinx/coroutines/Job;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "delListener", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "getDelListener", "()Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "setDelListener", "(Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;)V", "flexMvCardRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getFlexMvCardRV", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "flexMvCardRV$delegate", "Lkotlin/Lazy;", "fromScene", "isEdit", "", "()Z", "setEdit", "(Z)V", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "listener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$listener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$listener$1;", "liveList", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexLiveList;", "getLiveList", "()Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexLiveList;", "takePhotoActionLiveData", "getTakePhotoActionLiveData", "tipDialog", "Landroid/app/ProgressDialog;", "arrangementTrack", "", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createMvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "originTrackData", "resultList", "", "Lcom/tencent/mm/protocal/protobuf/FinderMvMediaInfoResult;", "clientItemMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "handleArrangementResp", "postData", "initDraftSelectItem", "trackData", "initEditUI", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onNextBtnClicked", "onSwitchIn", "onSwitchOut", "reportWhenChecked", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "takePhoto", "isFixMode", "minRecordDurationMs", "maxRecordDurationMs", "takePhotoFinished", "result", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends UIComponent
{
  public static final l.a Mfz;
  public boolean Ake;
  private final kotlin.j EKZ;
  private final com.tencent.mm.plugin.mvvmlist.g<com.tencent.mm.plugin.mv.model.flex.a> Mdx;
  private final x<Integer> MfA;
  public final LiveData<Integer> MfB;
  private final x<Integer> MfC;
  public final LiveData<Integer> MfD;
  private final com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.plugin.mv.model.flex.a> MfE;
  public final MusicMvFlexLiveList MfF;
  private final kotlin.j MfG;
  b.a MfH;
  private final g MfI;
  private cb MfJ;
  private int fromScene;
  public ProgressDialog lzP;
  
  static
  {
    AppMethodBeat.i(287926);
    Mfz = new l.a((byte)0);
    AppMethodBeat.o(287926);
  }
  
  public l(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287811);
    this.MfA = new x();
    this.MfB = ((LiveData)this.MfA);
    this.MfC = new x();
    this.MfD = ((LiveData)this.MfC);
    this.MfE = ((com.tencent.mm.plugin.mvvmlist.a.a)new d());
    com.tencent.mm.plugin.mvvmlist.a.f localf = (com.tencent.mm.plugin.mvvmlist.a.f)this.MfE;
    e locale = new e();
    locale.wDG = true;
    ah localah = ah.aiuX;
    this.MfF = new MusicMvFlexLiveList(localf, locale, (androidx.lifecycle.q)paramAppCompatActivity);
    this.Mdx = new com.tencent.mm.plugin.mvvmlist.g((MvvmList)this.MfF, (com.tencent.mm.view.recyclerview.g)new c(this), (byte)0);
    this.MfG = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.EKZ = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.MfI = new g(this);
    AppMethodBeat.o(287811);
  }
  
  private static dtf a(dtf paramdtf, List<? extends bqo> paramList, HashMap<String, com.tencent.mm.plugin.mv.model.flex.a> paramHashMap)
  {
    AppMethodBeat.i(287857);
    dtf localdtf = new dtf();
    paramdtf = paramdtf.toByteArray();
    if (paramdtf != null) {}
    label267:
    label399:
    label783:
    label1424:
    try
    {
      localdtf.parseFrom(paramdtf);
      paramdtf = localdtf.aaYK;
      if (paramdtf == null)
      {
        paramdtf = null;
        if (paramdtf != null) {
          paramdtf.ZWM = 1;
        }
        paramdtf = localdtf.aaYK;
        if (paramdtf == null) {
          break label187;
        }
        paramdtf = paramdtf.objectDesc;
        if (paramdtf == null) {
          break label187;
        }
        paramdtf = paramdtf.mvInfo;
        if (paramdtf == null) {
          break label187;
        }
        paramdtf = paramdtf.ZWI;
        if (paramdtf == null) {
          break label187;
        }
        paramdtf = ((Iterable)paramdtf).iterator();
        while (paramdtf.hasNext())
        {
          localObject1 = (boq)paramdtf.next();
          ((boq)localObject1).ZWZ = "";
          ((boq)localObject1).refObjectId = 0L;
        }
      }
    }
    catch (Exception paramdtf)
    {
      Object localObject1;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Mv.MusicMvMakerFlexEditUIC", (Throwable)paramdtf, "mvFeedObj", new Object[0]);
        paramdtf = ah.aiuX;
        continue;
        paramdtf = paramdtf.objectDesc;
        if (paramdtf == null) {
          paramdtf = null;
        } else {
          paramdtf = paramdtf.mvInfo;
        }
      }
      paramdtf = ah.aiuX;
      label187:
      localdtf.ZJp.clear();
      paramdtf = localdtf.aaYK;
      if (paramdtf != null)
      {
        paramdtf = paramdtf.objectDesc;
        if (paramdtf != null)
        {
          paramdtf = paramdtf.mvInfo;
          if (paramdtf != null)
          {
            paramdtf = paramdtf.ZWL;
            if (paramdtf != null)
            {
              paramdtf.clear();
              paramdtf = ah.aiuX;
            }
          }
        }
      }
      HashSet localHashSet = new HashSet();
      paramdtf = (Iterable)paramList;
      int i = 0;
      Iterator localIterator = paramdtf.iterator();
      long l1 = 0L;
      label926:
      label1054:
      label1311:
      label1316:
      if (localIterator.hasNext())
      {
        paramdtf = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        paramList = (bqo)paramdtf;
        Object localObject3 = (com.tencent.mm.plugin.mv.model.flex.a)((Map)paramHashMap).get(paramList.oUw);
        long l2 = l1;
        boq localboq;
        label434:
        label568:
        label580:
        Object localObject2;
        if (localObject3 != null)
        {
          localboq = new boq();
          localboq.TBO = paramList.ZYx;
          localboq.ZWY = paramList.ZYy;
          localboq.TBM = l1;
          if (((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYr != null)
          {
            localboq.mdP = 1;
            localObject1 = new bor();
            paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYr;
            if (paramdtf == null)
            {
              paramdtf = null;
              ((bor)localObject1).ZXi = paramdtf;
              ((bor)localObject1).ZXj = paramList.ZYx;
              localboq.ZXh = ((bor)localObject1);
              paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYr;
              if (paramdtf != null) {
                break label526;
              }
              paramdtf = null;
              Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", s.X("local_material_id:", paramdtf));
              Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", s.X("local_material_time_offset_in_clip_ms:", Long.valueOf(paramList.ZYx)));
            }
          }
          for (;;)
          {
            l2 = l1 + paramList.ZYy;
            switch (((com.tencent.mm.plugin.mv.model.flex.a)localObject3).type)
            {
            default: 
              i = j;
              l1 = l2;
              break label267;
              paramdtf = paramdtf.thumbPath;
              break label399;
              paramdtf = paramdtf.thumbPath;
              break label434;
              localboq.mdP = 0;
            }
          }
          paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYs;
          if (paramdtf != null) {
            break label926;
          }
          paramList = null;
          label555:
          paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYs;
          if (paramdtf != null) {
            break label934;
          }
          l1 = 0L;
          paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYs;
          if (paramdtf != null) {
            break label958;
          }
          paramdtf = null;
          localboq.ZXf = new LinkedList();
          localObject1 = localboq.ZXf;
          if (localObject1 != null) {
            ((LinkedList)localObject1).add(Integer.valueOf(0));
          }
          localObject1 = ah.aiuX;
          localObject2 = paramList;
          localObject1 = paramdtf;
          localboq.refObjectId = l1;
          localboq.ZWZ = ((String)localObject1);
          if ((localHashSet.add(localObject1)) && (localObject2 != null))
          {
            paramdtf = ((FinderObject)localObject2).objectDesc;
            if (paramdtf != null)
            {
              paramdtf = paramdtf.mvInfo;
              if (paramdtf != null)
              {
                paramdtf = paramdtf.ZWL;
                if (paramdtf != null) {
                  paramdtf.add(localboq);
                }
              }
            }
            paramdtf = ((FinderObject)localObject2).objectDesc;
            if (paramdtf != null) {
              break label1371;
            }
            paramdtf = null;
            label701:
            localObject3 = new StringBuilder("ref object media size:");
            paramList = ((FinderObject)localObject2).objectDesc;
            if (paramList != null) {
              break label1399;
            }
            paramList = null;
            label725:
            localObject3 = ((StringBuilder)localObject3).append(paramList).append(", ");
            if (paramdtf != null) {
              break label1424;
            }
            paramList = null;
            label745:
            localObject3 = ((StringBuilder)localObject3).append(paramList).append(", [");
            if (paramdtf != null) {
              break label1432;
            }
            paramList = null;
            label765:
            paramList = ((StringBuilder)localObject3).append(paramList).append(' ');
            if (paramdtf != null) {
              break label1443;
            }
            paramdtf = null;
            Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", paramdtf + ']');
            localdtf.ZJp.add(localObject2);
          }
          if (l1 == 0L) {
            if ((localObject1 == null) || (n.U((String)localObject1, "local_", false) != true)) {
              break label1454;
            }
          }
        }
        label934:
        label1192:
        label1454:
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            localboq.ZXa = 1;
            Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", s.X("createMvData isFirstUpload ", localObject1));
          }
          paramdtf = localdtf.aaYK;
          if (paramdtf != null)
          {
            paramdtf = paramdtf.objectDesc;
            if (paramdtf != null)
            {
              paramdtf = paramdtf.mvInfo;
              if (paramdtf != null)
              {
                paramdtf = paramdtf.ZWL;
                if (paramdtf != null) {
                  paramdtf.add(localboq);
                }
              }
            }
          }
          paramdtf = ah.aiuX;
          paramdtf = ah.aiuX;
          l1 = l2;
          i = j;
          break;
          paramList = paramdtf.EDa;
          break label555;
          paramdtf = paramdtf.EDa;
          if (paramdtf == null)
          {
            l1 = 0L;
            break label568;
          }
          l1 = paramdtf.id;
          break label568;
          label958:
          paramdtf = paramdtf.EDa;
          if (paramdtf == null)
          {
            paramdtf = null;
            break label580;
          }
          paramdtf = paramdtf.objectNonceId;
          break label580;
          localObject2 = new FinderObject();
          l1 = 0L;
          localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).id;
          paramList = new FinderMedia();
          paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYr;
          label1019:
          int k;
          if (paramdtf == null)
          {
            paramdtf = null;
            paramList.url = paramdtf;
            paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYr;
            if (paramdtf != null) {
              break label1273;
            }
            i = 0;
            paramList.width = i;
            paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYr;
            if (paramdtf != null) {
              break label1281;
            }
            i = 0;
            paramList.height = i;
            paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYr;
            if (paramdtf != null) {
              break label1289;
            }
            paramdtf = null;
            label1072:
            paramList.decodeKey = paramdtf;
            paramList.videoDuration = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).videoDuration;
            ((FinderObject)localObject2).objectNonceId = ((String)localObject1);
            paramdtf = new FinderObjectDesc();
            paramdtf.media.add(paramList);
            ah localah = ah.aiuX;
            ((FinderObject)localObject2).objectDesc = paramdtf;
            localboq.ZXf = new LinkedList();
            paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYr;
            if (paramdtf != null) {
              break label1303;
            }
            paramdtf = null;
            label1145:
            if ((paramdtf instanceof GalleryItem.VideoMediaItem)) {
              paramList.bitrate = ((GalleryItem.VideoMediaItem)paramdtf).nCg;
            }
            paramdtf = ((com.tencent.mm.plugin.mv.model.flex.a)localObject3).LYr;
            if (paramdtf == null) {
              break label1311;
            }
            paramdtf = paramdtf.HHB;
            if ((paramdtf == null) || (paramdtf.getType() != 2)) {
              break label1311;
            }
            i = 1;
            if (i == 0) {
              break label1316;
            }
            k = 4;
            i = 0;
            label1201:
            paramdtf = ((FinderObject)localObject2).objectDesc;
            if (paramdtf != null) {
              paramdtf.mediaType = k;
            }
            paramdtf = ((FinderObject)localObject2).objectDesc;
            if (paramdtf != null) {
              break label1346;
            }
            paramdtf = null;
          }
          for (;;)
          {
            if (paramdtf != null) {
              paramdtf.mediaType = k;
            }
            paramdtf = localboq.ZXf;
            if (paramdtf != null) {
              paramdtf.add(Integer.valueOf(i));
            }
            paramdtf = ah.aiuX;
            break;
            paramdtf = paramdtf.thumbPath;
            break label1019;
            label1273:
            i = paramdtf.width;
            break label1036;
            i = paramdtf.height;
            break label1054;
            paramdtf = Long.valueOf(paramdtf.LYu).toString();
            break label1072;
            paramdtf = paramdtf.HHB;
            break label1145;
            i = 0;
            break label1192;
            k = 2;
            paramdtf = com.tencent.mm.plugin.thumbplayer.c.a.TCz;
            localboq.ZXg = com.tencent.mm.plugin.thumbplayer.c.a.mg((int)paramList.width, (int)paramList.height);
            i = 1;
            break label1201;
            label1346:
            paramdtf = paramdtf.media;
            if (paramdtf == null) {
              paramdtf = null;
            } else {
              paramdtf = (FinderMedia)paramdtf.getFirst();
            }
          }
          label1371:
          paramdtf = paramdtf.media;
          if (paramdtf == null)
          {
            paramdtf = null;
            break label701;
          }
          paramdtf = (FinderMedia)p.oL((List)paramdtf);
          break label701;
          label1399:
          paramList = paramList.media;
          if (paramList == null)
          {
            paramList = null;
            break label725;
          }
          paramList = Integer.valueOf(paramList.size());
          break label725;
          paramList = paramdtf.url;
          break label745;
          paramList = Float.valueOf(paramdtf.width);
          break label765;
          paramdtf = Float.valueOf(paramdtf.height);
          break label783;
        }
      }
      label1303:
      label1432:
      label1443:
      AppMethodBeat.o(287857);
    }
    label526:
    return localdtf;
  }
  
  private static final void a(l paraml, List paramList)
  {
    AppMethodBeat.i(287866);
    s.u(paraml, "this$0");
    paraml.fcq().bo(paramList.size() - 1, 0);
    AppMethodBeat.o(287866);
  }
  
  private WxLinearLayoutManager fcq()
  {
    AppMethodBeat.i(287821);
    WxLinearLayoutManager localWxLinearLayoutManager = (WxLinearLayoutManager)this.EKZ.getValue();
    AppMethodBeat.o(287821);
    return localWxLinearLayoutManager;
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(287945);
    this.MfH = parama;
    this.fromScene = getIntent().getIntExtra("key_mv_from_scene", 0);
    gqW().setLayoutManager((RecyclerView.LayoutManager)fcq());
    gqW().setAdapter((RecyclerView.a)this.Mdx);
    this.MfF.MmR.a((androidx.lifecycle.q)getActivity(), new l..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(287945);
  }
  
  public final WxRecyclerView gqW()
  {
    AppMethodBeat.i(287936);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.MfG.getValue();
    AppMethodBeat.o(287936);
    return localWxRecyclerView;
  }
  
  public final void onActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(287962);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(287962);
      return;
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().resume();
      kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (m)new h(this, paramIntent, paramInt2, null), 2);
      AppMethodBeat.o(287962);
      return;
      Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", "album preview callback");
      Object localObject1;
      ArrayList localArrayList;
      long l2;
      label200:
      int i;
      Object localObject2;
      int j;
      label257:
      label276:
      long l1;
      if (paramIntent == null)
      {
        paramInt2 = 0;
        localObject1 = new egz();
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getByteArrayExtra("PreviewItemObjCallback");
          if (paramIntent != null) {
            ((egz)localObject1).parseFrom(paramIntent);
          }
        }
        localArrayList = new ArrayList();
        l2 = System.currentTimeMillis();
        localArrayList.add(new com.tencent.mm.plugin.mv.model.flex.a("", 0, 2L * l2, -1));
        paramIntent = ((egz)localObject1).abmm;
        s.s(paramIntent, "previewItemObj.selectItemList");
        Iterator localIterator = ((Iterable)paramIntent).iterator();
        paramInt1 = 0;
        if (!localIterator.hasNext()) {
          break label1137;
        }
        paramIntent = localIterator.next();
        i = paramInt1 + 1;
        if (paramInt1 < 0) {
          p.kkW();
        }
        localObject2 = (eww)paramIntent;
        paramIntent = ((eww)localObject2).abyX;
        if ((paramIntent == null) || (paramIntent.type != 3)) {
          break label493;
        }
        j = 1;
        if (j == 0) {
          break label587;
        }
        paramIntent = ((eww)localObject2).abyX;
        if (paramIntent != null) {
          break label499;
        }
        paramIntent = "";
        l1 = paramInt1;
        localObject1 = ((eww)localObject2).LZD;
        if (localObject1 != null) {
          break label520;
        }
        paramInt1 = 0;
        label294:
        localObject1 = new com.tencent.mm.plugin.mv.model.flex.a(paramIntent, 2, l1 + l2, paramInt1);
        paramIntent = ((eww)localObject2).abyX;
        if (paramIntent != null)
        {
          localObject2 = paramIntent.EDa;
          if (localObject2 != null)
          {
            ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYs = new a.c((byte)0);
            paramIntent = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYs;
            if (paramIntent != null) {
              paramIntent.EDa = ((FinderObject)localObject2);
            }
            paramIntent = ((FinderObject)localObject2).objectDesc;
            if (paramIntent != null) {
              break label529;
            }
            paramIntent = null;
            label373:
            if (paramIntent != null) {
              break label579;
            }
          }
        }
      }
      label520:
      label529:
      label579:
      for (paramInt1 = 0;; paramInt1 = paramIntent.intValue())
      {
        ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).videoDuration = paramInt1;
        paramIntent = ((FinderObject)localObject2).objectDesc;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.media;
          if (paramIntent != null)
          {
            paramIntent = (FinderMedia)p.oL((List)paramIntent);
            if (paramIntent != null)
            {
              localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYs;
              if (localObject2 != null) {
                ((a.c)localObject2).thumbUrl = s.X(paramIntent.thumbUrl, paramIntent.thumb_url_token);
              }
              paramIntent = ah.aiuX;
              paramIntent = ah.aiuX;
            }
          }
        }
        paramIntent = ah.aiuX;
        paramIntent = ah.aiuX;
        paramIntent = ah.aiuX;
        localArrayList.add(localObject1);
        paramInt1 = i;
        break label200;
        paramInt2 = paramIntent.getIntExtra("PreviewItemObjCallbackAction", 0);
        break;
        label493:
        j = 0;
        break label257;
        label499:
        localObject1 = paramIntent.id;
        paramIntent = (Intent)localObject1;
        if (localObject1 != null) {
          break label276;
        }
        paramIntent = "";
        break label276;
        paramInt1 = Integer.parseInt((String)localObject1);
        break label294;
        paramIntent = paramIntent.media;
        if (paramIntent == null)
        {
          paramIntent = null;
          break label373;
        }
        paramIntent = (FinderMedia)p.ae((List)paramIntent, 0);
        if (paramIntent == null)
        {
          paramIntent = null;
          break label373;
        }
        paramIntent = Integer.valueOf(paramIntent.videoDuration * 1000);
        break label373;
      }
      label587:
      paramIntent = ((eww)localObject2).abyX;
      label601:
      label619:
      Object localObject3;
      if (paramIntent == null)
      {
        paramIntent = "";
        l1 = paramInt1;
        localObject1 = ((eww)localObject2).LZD;
        if (localObject1 != null) {
          break label947;
        }
        paramInt1 = 0;
        localObject1 = new com.tencent.mm.plugin.mv.model.flex.a(paramIntent, 1, l1 + l2, paramInt1);
        paramIntent = ((eww)localObject2).abyX;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.abml;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.toByteArray();
            if (paramIntent != null)
            {
              ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr = new a.a((byte)0);
              localObject3 = ((eww)localObject2).abyX;
              if ((localObject3 == null) || (((egx)localObject3).type != 1)) {
                break label956;
              }
              paramInt1 = 1;
              label700:
              if (paramInt1 == 0) {
                break label985;
              }
              localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
              if (localObject2 != null)
              {
                localObject3 = GalleryItem.ImageMediaItem.CREATOR;
                s.s(localObject3, "CREATOR");
                ((a.a)localObject2).HHB = ((GalleryItem.MediaItem)com.tencent.mm.ae.d.a(paramIntent, (Parcelable.Creator)localObject3));
              }
              paramIntent = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
              if (paramIntent != null) {
                break label961;
              }
              paramIntent = null;
              label755:
              paramIntent = BitmapUtil.getPictureSize(paramIntent);
              localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
              if (localObject2 != null)
              {
                if (paramIntent != null) {
                  break label969;
                }
                paramInt1 = 0;
                label778:
                ((a.a)localObject2).width = paramInt1;
              }
              localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
              if (localObject2 != null)
              {
                if (paramIntent != null) {
                  break label977;
                }
                paramInt1 = 0;
                label802:
                ((a.a)localObject2).height = paramInt1;
              }
              label808:
              paramIntent = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
              if (paramIntent != null)
              {
                localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
                if (localObject2 != null) {
                  break label1059;
                }
                l1 = 0L;
                label833:
                paramIntent.HHJ = l1;
              }
              localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
              if (localObject2 != null)
              {
                paramIntent = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
                if (paramIntent != null) {
                  break label1087;
                }
                paramIntent = null;
                label863:
                ((a.a)localObject2).thumbPath = paramIntent;
              }
              paramIntent = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
              if (paramIntent != null)
              {
                localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
                if (localObject2 != null) {
                  break label1109;
                }
                l1 = 0L;
              }
            }
          }
        }
      }
      for (;;)
      {
        paramIntent.LYu = l1;
        paramIntent = ah.aiuX;
        paramIntent = ah.aiuX;
        paramIntent = ah.aiuX;
        localArrayList.add(localObject1);
        paramInt1 = i;
        break;
        localObject1 = paramIntent.id;
        paramIntent = (Intent)localObject1;
        if (localObject1 != null) {
          break label601;
        }
        paramIntent = "";
        break label601;
        label947:
        paramInt1 = Integer.parseInt((String)localObject1);
        break label619;
        label956:
        paramInt1 = 0;
        break label700;
        label961:
        paramIntent = paramIntent.thumbPath;
        break label755;
        label969:
        paramInt1 = paramIntent.x;
        break label778;
        label977:
        paramInt1 = paramIntent.y;
        break label802;
        label985:
        localObject2 = ((eww)localObject2).abyX;
        if ((localObject2 != null) && (((egx)localObject2).type == 2)) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label1057;
          }
          localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).LYr;
          if (localObject2 == null) {
            break;
          }
          localObject3 = GalleryItem.VideoMediaItem.CREATOR;
          s.s(localObject3, "CREATOR");
          ((a.a)localObject2).HHB = ((GalleryItem.MediaItem)com.tencent.mm.ae.d.a(paramIntent, (Parcelable.Creator)localObject3));
          break;
        }
        label1057:
        break label808;
        label1059:
        localObject2 = ((a.a)localObject2).HHB;
        if (localObject2 == null)
        {
          l1 = 0L;
          break label833;
        }
        l1 = ((GalleryItem.MediaItem)localObject2).HHJ;
        break label833;
        label1087:
        paramIntent = paramIntent.HHB;
        if (paramIntent == null)
        {
          paramIntent = null;
          break label863;
        }
        paramIntent = paramIntent.bud();
        break label863;
        label1109:
        localObject2 = ((a.a)localObject2).HHB;
        if (localObject2 == null) {
          l1 = 0L;
        } else {
          l1 = ((GalleryItem.MediaItem)localObject2).HHK;
        }
      }
      label1137:
      this.Ake = true;
      this.MfF.jg((List)localArrayList);
      this.MfF.gpN();
      if ((localArrayList.size() > 0) && (paramInt2 == 1)) {
        this.MfA.t(Integer.valueOf(1));
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(287967);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(j.class);
    s.s(localObject, "UICProvider.of(activity)…MakerDataUIC::class.java)");
    localObject = (j)localObject;
    Integer localInteger = (Integer)((j)localObject).gqP().getValue();
    if (localInteger == null) {}
    while (localInteger.intValue() != 1)
    {
      AppMethodBeat.o(287967);
      return false;
    }
    this.MfF.aB((kotlin.g.a.b)new i((j)localObject, this));
    AppMethodBeat.o(287967);
    return true;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.b<List<? extends com.tencent.mm.plugin.mv.model.flex.a>, ah>
  {
    public b(dsd paramdsd, l paraml, com.tencent.mm.plugin.mvvmbase.a.a parama, j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.view.recyclerview.g
  {
    c(l paraml) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(288016);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.mv.model.flex.b((b.a)l.a(this.MfL));
      AppMethodBeat.o(288016);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$dataSource$1", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.plugin.mv.model.flex.a>
  {
    public final kotlinx.coroutines.b.g<com.tencent.mm.plugin.mvvmlist.a.d<com.tencent.mm.plugin.mv.model.flex.a>> a(LifecycleScope paramLifecycleScope, c<com.tencent.mm.plugin.mv.model.flex.a> paramc)
    {
      AppMethodBeat.i(288014);
      s.u(paramLifecycleScope, "scope");
      s.u(paramc, "request");
      paramLifecycleScope = new kotlinx.coroutines.a.q();
      paramc = new com.tencent.mm.plugin.mvvmlist.a.d(paramc);
      ArrayList localArrayList = paramc.pUj;
      com.tencent.mm.plugin.mv.model.flex.a locala = new com.tencent.mm.plugin.mv.model.flex.a("", 0, System.currentTimeMillis() * 2L, -1);
      locala.LYt = b.d.LRH;
      ah localah = ah.aiuX;
      localArrayList.add(locala);
      paramLifecycleScope.offer(paramc);
      paramLifecycleScope = kotlinx.coroutines.b.k.a((kotlinx.coroutines.a.f)paramLifecycleScope);
      AppMethodBeat.o(288014);
      return paramLifecycleScope;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    e(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<WxLinearLayoutManager>
  {
    f(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$listener$1", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "onClicked", "", "pos", "", "item", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements b.a
  {
    g(l paraml) {}
    
    public final void a(int paramInt, com.tencent.mm.plugin.mv.model.flex.a parama)
    {
      AppMethodBeat.i(288027);
      s.u(parama, "item");
      Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", "OnDelBtnClicked, pos:" + paramInt + ", type:" + parama.type);
      b.a locala = this.MfL.MfH;
      if (locala != null) {
        locala.a(paramInt, parama);
      }
      this.MfL.MfF.a((com.tencent.mm.plugin.mvvmlist.b)parama);
      this.MfL.MfF.gpN();
      AppMethodBeat.o(288027);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    h(l paraml, Intent paramIntent, int paramInt, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(288043);
      paramObject = (kotlin.d.d)new h(this.MfL, paramIntent, paramInt2, paramd);
      AppMethodBeat.o(288043);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(288038);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(288038);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      l.a(this.MfL, paramIntent, paramInt2);
      paramObject = ah.aiuX;
      AppMethodBeat.o(288038);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "liveList", "", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<List<? extends com.tencent.mm.plugin.mv.model.flex.a>, ah>
  {
    i(j paramj, l paraml)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(l paraml, dtf paramdtf)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.l
 * JD-Core Version:    0.7.0.1
 */