package com.tencent.mm.plugin.mv.ui.uic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Parcelable.Creator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.livelist.h;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.mv.model.flex.MusicMvFlexLiveList;
import com.tencent.mm.plugin.mv.model.flex.a.a;
import com.tencent.mm.plugin.mv.model.flex.a.c;
import com.tencent.mm.plugin.mv.model.flex.b.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.b.c;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.by;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "_albumPreviewActionLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "_takePhotoActionLiveData", "adapter", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "getAdapter", "()Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "albumPreviewActionLiveData", "Landroidx/lifecycle/LiveData;", "getAlbumPreviewActionLiveData", "()Landroidx/lifecycle/LiveData;", "arrangementReqJob", "Lkotlinx/coroutines/Job;", "dataSource", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "dataSource$delegate", "delListener", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "getDelListener", "()Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "setDelListener", "(Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;)V", "flexMvCardRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getFlexMvCardRV", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "flexMvCardRV$delegate", "fromScene", "isEdit", "", "()Z", "setEdit", "(Z)V", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "listener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$listener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$listener$1;", "liveList", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexLiveList;", "getLiveList", "()Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexLiveList;", "liveList$delegate", "takePhotoActionLiveData", "getTakePhotoActionLiveData", "tipDialog", "Landroid/app/ProgressDialog;", "arrangementTrack", "", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createMvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "originTrackData", "resultList", "", "Lcom/tencent/mm/protocal/protobuf/FinderMvMediaInfoResult;", "clientItemMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "handleArrangementResp", "postData", "initDraftSelectItem", "trackData", "initEditUI", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onNextBtnClicked", "onSwitchIn", "onSwitchOut", "reportWhenChecked", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "takePhoto", "isFixMode", "minRecordDurationMs", "maxRecordDurationMs", "takePhotoFinished", "result", "Companion", "plugin-mv_release"})
public final class n
  extends UIComponent
{
  public static final n.a Gld;
  public final kotlin.f BiY;
  private final r<Integer> GkT;
  public final LiveData<Integer> GkU;
  private final r<Integer> GkV;
  public final LiveData<Integer> GkW;
  final kotlin.f GkX;
  private final kotlin.f GkY;
  private final kotlin.f GkZ;
  public b.a Gla;
  private final i Glb;
  private by Glc;
  public int fromScene;
  public ProgressDialog iXX;
  public boolean wNB;
  private final kotlin.f zQC;
  
  static
  {
    AppMethodBeat.i(227070);
    Gld = new n.a((byte)0);
    AppMethodBeat.o(227070);
  }
  
  public n(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(227067);
    this.GkT = new r();
    r localr = this.GkT;
    if (localr == null)
    {
      paramAppCompatActivity = new t("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
      AppMethodBeat.o(227067);
      throw paramAppCompatActivity;
    }
    this.GkU = ((LiveData)localr);
    this.GkV = new r();
    localr = this.GkV;
    if (localr == null)
    {
      paramAppCompatActivity = new t("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
      AppMethodBeat.o(227067);
      throw paramAppCompatActivity;
    }
    this.GkW = ((LiveData)localr);
    this.GkX = kotlin.g.ar((kotlin.g.a.a)e.Gll);
    this.GkY = kotlin.g.ar((kotlin.g.a.a)new j(this, paramAppCompatActivity));
    this.BiY = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.GkZ = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.zQC = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.Glb = new i(this);
    AppMethodBeat.o(227067);
  }
  
  private static dbo a(dbo paramdbo, List<? extends bfj> paramList, HashMap<String, com.tencent.mm.plugin.mv.model.flex.a> paramHashMap)
  {
    AppMethodBeat.i(227039);
    dbo localdbo = new dbo();
    paramdbo = paramdbo.toByteArray();
    if (paramdbo != null) {}
    try
    {
      localdbo.parseFrom(paramdbo);
      paramdbo = localdbo.TIV;
      if (paramdbo != null)
      {
        paramdbo = paramdbo.objectDesc;
        if (paramdbo != null)
        {
          paramdbo = paramdbo.mvInfo;
          if (paramdbo != null) {
            paramdbo.SOF = 1;
          }
        }
      }
      paramdbo = localdbo.TIV;
      if (paramdbo != null)
      {
        paramdbo = paramdbo.objectDesc;
        if (paramdbo != null)
        {
          paramdbo = paramdbo.mvInfo;
          if (paramdbo != null)
          {
            paramdbo = paramdbo.SOB;
            if (paramdbo != null)
            {
              paramdbo = ((Iterable)paramdbo).iterator();
              while (paramdbo.hasNext())
              {
                localObject1 = (bdt)paramdbo.next();
                ((bdt)localObject1).SOS = "";
                ((bdt)localObject1).refObjectId = 0L;
              }
            }
          }
        }
      }
    }
    catch (Exception paramdbo)
    {
      Object localObject1;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Mv.MusicMvMakerFlexEditUIC", (Throwable)paramdbo, "mvFeedObj", new Object[0]);
        paramdbo = x.aazN;
      }
      localdbo.SGC.clear();
      paramdbo = localdbo.TIV;
      if (paramdbo != null)
      {
        paramdbo = paramdbo.objectDesc;
        if (paramdbo != null)
        {
          paramdbo = paramdbo.mvInfo;
          if (paramdbo != null)
          {
            paramdbo = paramdbo.SOE;
            if (paramdbo != null) {
              paramdbo.clear();
            }
          }
        }
      }
      HashSet localHashSet = new HashSet();
      paramdbo = (Iterable)paramList;
      int i = 0;
      Iterator localIterator = paramdbo.iterator();
      long l1 = 0L;
      while (localIterator.hasNext())
      {
        paramdbo = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        paramdbo = (bfj)paramdbo;
        Object localObject2 = (com.tencent.mm.plugin.mv.model.flex.a)((Map)paramHashMap).get(paramdbo.mbB);
        if (localObject2 != null)
        {
          bdt localbdt = new bdt();
          localbdt.MSG = paramdbo.SQb;
          localbdt.SOR = paramdbo.SQc;
          localbdt.MSE = l1;
          long l2 = l1 + paramdbo.SQc;
          label409:
          label434:
          label458:
          label492:
          Object localObject3;
          switch (((com.tencent.mm.plugin.mv.model.flex.a)localObject2).type)
          {
          default: 
            i = j;
            l1 = l2;
            break;
          case 2: 
            paramdbo = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcH;
            if (paramdbo != null)
            {
              paramdbo = paramdbo.Gbc;
              paramList = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcH;
              if (paramList == null) {
                break label863;
              }
              paramList = paramList.Gbc;
              if (paramList == null) {
                break label863;
              }
              l1 = paramList.id;
              paramList = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcH;
              if (paramList == null) {
                break label869;
              }
              paramList = paramList.Gbc;
              if (paramList == null) {
                break label869;
              }
              paramList = paramList.objectNonceId;
              localbdt.SOY = new LinkedList();
              localObject1 = localbdt.SOY;
              if (localObject1 == null) {
                break label874;
              }
              ((LinkedList)localObject1).add(Integer.valueOf(0));
              localbdt.refObjectId = l1;
              localbdt.SOS = paramList;
              if ((localHashSet.add(paramList)) && (paramdbo != null))
              {
                localObject1 = paramdbo.objectDesc;
                if (localObject1 != null)
                {
                  localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
                  if (localObject1 != null)
                  {
                    localObject1 = ((bdp)localObject1).SOE;
                    if (localObject1 != null) {
                      ((LinkedList)localObject1).add(localbdt);
                    }
                  }
                }
                localObject1 = paramdbo.objectDesc;
                if (localObject1 == null) {
                  break label1306;
                }
                localObject1 = ((FinderObjectDesc)localObject1).media;
                if (localObject1 == null) {
                  break label1306;
                }
                localObject1 = (FinderMedia)kotlin.a.j.lp((List)localObject1);
                localObject3 = new StringBuilder("ref object media size:");
                localObject2 = paramdbo.objectDesc;
                if (localObject2 == null) {
                  break label1312;
                }
                localObject2 = ((FinderObjectDesc)localObject2).media;
                if (localObject2 == null) {
                  break label1312;
                }
                localObject2 = Integer.valueOf(((LinkedList)localObject2).size());
                localObject3 = ((StringBuilder)localObject3).append(localObject2).append(", ");
                if (localObject1 == null) {
                  break label1318;
                }
                localObject2 = ((FinderMedia)localObject1).url;
                localObject3 = ((StringBuilder)localObject3).append((String)localObject2).append(", [");
                if (localObject1 == null) {
                  break label1324;
                }
                localObject2 = Float.valueOf(((FinderMedia)localObject1).width);
                localObject2 = ((StringBuilder)localObject3).append(localObject2).append(' ');
                if (localObject1 == null) {
                  break label1330;
                }
              }
            }
          case 1: 
          case 3: 
            label597:
            for (localObject1 = Float.valueOf(((FinderMedia)localObject1).height);; localObject1 = null)
            {
              Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", localObject1 + ']');
              localdbo.SGC.add(paramdbo);
              if ((l1 == 0L) && (paramList != null) && (kotlin.n.n.M(paramList, "local_", false) == true))
              {
                localbdt.SOT = 1;
                Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", "createMvData isFirstUpload ".concat(String.valueOf(paramList)));
              }
              paramdbo = localdbo.TIV;
              if (paramdbo == null) {
                break label1336;
              }
              paramdbo = paramdbo.objectDesc;
              if (paramdbo == null) {
                break label1336;
              }
              paramdbo = paramdbo.mvInfo;
              if (paramdbo == null) {
                break label1336;
              }
              paramdbo = paramdbo.SOE;
              if (paramdbo == null) {
                break label1336;
              }
              paramdbo.add(localbdt);
              i = j;
              l1 = l2;
              break;
              paramdbo = null;
              break label409;
              label863:
              l1 = 0L;
              break label434;
              label869:
              paramList = null;
              break label458;
              label874:
              break label492;
              paramList = new FinderObject();
              l1 = 0L;
              paramdbo = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).id;
              localObject3 = new FinderMedia();
              localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
              label1001:
              int k;
              if (localObject1 != null)
              {
                localObject1 = ((a.a)localObject1).thumbPath;
                ((FinderMedia)localObject3).url = ((String)localObject1);
                localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
                if (localObject1 == null) {
                  break label1240;
                }
                i = ((a.a)localObject1).width;
                ((FinderMedia)localObject3).width = i;
                localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
                if (localObject1 == null) {
                  break label1245;
                }
                i = ((a.a)localObject1).height;
                ((FinderMedia)localObject3).height = i;
                localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
                if (localObject1 == null) {
                  break label1250;
                }
                localObject1 = String.valueOf(((a.a)localObject1).GcL);
                ((FinderMedia)localObject3).decodeKey = ((String)localObject1);
                ((FinderMedia)localObject3).videoDuration = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).videoDuration;
                paramList.objectNonceId = paramdbo;
                localObject1 = new FinderObjectDesc();
                ((FinderObjectDesc)localObject1).media.add(localObject3);
                paramList.objectDesc = ((FinderObjectDesc)localObject1);
                localbdt.SOY = new LinkedList();
                localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
                if (localObject1 == null) {
                  break label1256;
                }
                localObject1 = ((a.a)localObject1).BVd;
                if ((localObject1 instanceof GalleryItem.VideoMediaItem)) {
                  ((FinderMedia)localObject3).bitrate = ((GalleryItem.VideoMediaItem)localObject1).kWG;
                }
                localObject1 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject2).GcG;
                if (localObject1 == null) {
                  break label1262;
                }
                localObject1 = ((a.a)localObject1).BVd;
                if ((localObject1 == null) || (((GalleryItem.MediaItem)localObject1).getType() != 2)) {
                  break label1262;
                }
                k = 0;
              }
              for (i = 4;; i = 2)
              {
                localObject1 = paramList.objectDesc;
                if (localObject1 != null) {
                  ((FinderObjectDesc)localObject1).mediaType = i;
                }
                localObject1 = paramList.objectDesc;
                if (localObject1 != null)
                {
                  localObject1 = ((FinderObjectDesc)localObject1).media;
                  if (localObject1 != null)
                  {
                    localObject1 = (FinderMedia)((LinkedList)localObject1).getFirst();
                    if (localObject1 != null) {
                      ((FinderMedia)localObject1).mediaType = i;
                    }
                  }
                }
                localObject1 = localbdt.SOY;
                if (localObject1 == null) {
                  break label1295;
                }
                ((LinkedList)localObject1).add(Integer.valueOf(k));
                localObject1 = paramList;
                paramList = paramdbo;
                paramdbo = (dbo)localObject1;
                break;
                localObject1 = null;
                break label922;
                label1240:
                i = 0;
                break label947;
                label1245:
                i = 0;
                break label972;
                label1250:
                localObject1 = null;
                break label1001;
                label1256:
                localObject1 = null;
                break label1080;
                label1262:
                k = 1;
                localObject1 = com.tencent.mm.plugin.thumbplayer.d.a.MPX;
                localbdt.SOZ = com.tencent.mm.plugin.thumbplayer.d.a.kt((int)((FinderMedia)localObject3).width, (int)((FinderMedia)localObject3).height);
              }
              localObject1 = paramList;
              paramList = paramdbo;
              paramdbo = (dbo)localObject1;
              break label492;
              localObject1 = null;
              break label597;
              localObject2 = null;
              break label642;
              localObject2 = null;
              break label669;
              localObject2 = null;
              break label699;
            }
            label642:
            label669:
            label699:
            label972:
            i = j;
            label922:
            label947:
            label1080:
            l1 = l2;
            label1295:
            label1306:
            label1312:
            label1318:
            label1324:
            label1330:
            label1336:
            break;
          }
        }
        else
        {
          i = j;
        }
      }
      AppMethodBeat.o(227039);
    }
    return localdbo;
  }
  
  public final MusicMvFlexLiveList fhj()
  {
    AppMethodBeat.i(227007);
    MusicMvFlexLiveList localMusicMvFlexLiveList = (MusicMvFlexLiveList)this.GkY.getValue();
    AppMethodBeat.o(227007);
    return localMusicMvFlexLiveList;
  }
  
  public final WxRecyclerView fhk()
  {
    AppMethodBeat.i(227010);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.GkZ.getValue();
    AppMethodBeat.o(227010);
    return localWxRecyclerView;
  }
  
  public final WxLinearLayoutManager fhl()
  {
    AppMethodBeat.i(227011);
    WxLinearLayoutManager localWxLinearLayoutManager = (WxLinearLayoutManager)this.zQC.getValue();
    AppMethodBeat.o(227011);
    return localWxLinearLayoutManager;
  }
  
  public final void onActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(227062);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(227062);
      return;
      Object localObject1 = k.fet();
      p.j(localObject1, "MusicPlayerManager.Instance()");
      ((k)localObject1).feg().resume();
      kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (m)new k(this, paramIntent, paramInt2, null), 2);
      AppMethodBeat.o(227062);
      return;
      Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", "album preview callback");
      ArrayList localArrayList;
      long l2;
      label220:
      int i;
      Object localObject2;
      if (paramIntent != null)
      {
        paramInt2 = paramIntent.getIntExtra("PreviewItemObjCallbackAction", 0);
        localObject1 = new doi();
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getByteArrayExtra("PreviewItemObjCallback");
          if (paramIntent != null) {
            ((doi)localObject1).parseFrom(paramIntent);
          }
        }
        localArrayList = new ArrayList();
        l2 = System.currentTimeMillis();
        localArrayList.add(new com.tencent.mm.plugin.mv.model.flex.a("", 0, 2L * l2, -1));
        paramIntent = ((doi)localObject1).TVz;
        p.j(paramIntent, "previewItemObj.selectItemList");
        paramIntent = (Iterable)paramIntent;
        paramInt1 = 0;
        Iterator localIterator = paramIntent.iterator();
        if (!localIterator.hasNext()) {
          break label1070;
        }
        paramIntent = localIterator.next();
        i = paramInt1 + 1;
        if (paramInt1 < 0) {
          kotlin.a.j.iBO();
        }
        localObject2 = (edf)paramIntent;
        paramIntent = ((edf)localObject2).UhH;
        if ((paramIntent == null) || (paramIntent.type != 3)) {
          break label574;
        }
        paramIntent = ((edf)localObject2).UhH;
        if (paramIntent != null)
        {
          localObject1 = paramIntent.id;
          paramIntent = (Intent)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramIntent = "";
        }
        l1 = paramInt1;
        localObject1 = ((edf)localObject2).GdS;
        if (localObject1 == null) {
          break label564;
        }
        paramInt1 = Integer.parseInt((String)localObject1);
        label324:
        paramIntent = new com.tencent.mm.plugin.mv.model.flex.a(paramIntent, 2, l1 + l2, paramInt1);
        localObject1 = ((edf)localObject2).UhH;
        if (localObject1 != null)
        {
          localObject1 = ((dog)localObject1).Gbc;
          if (localObject1 != null)
          {
            paramIntent.GcH = new a.c((byte)0);
            localObject2 = paramIntent.GcH;
            if (localObject2 != null) {
              ((a.c)localObject2).Gbc = ((FinderObject)localObject1);
            }
            localObject2 = ((FinderObject)localObject1).objectDesc;
            if (localObject2 == null) {
              break label569;
            }
            localObject2 = ((FinderObjectDesc)localObject2).media;
            if (localObject2 == null) {
              break label569;
            }
            localObject2 = (FinderMedia)kotlin.a.j.M((List)localObject2, 0);
            if (localObject2 == null) {
              break label569;
            }
          }
        }
      }
      label564:
      label569:
      for (paramInt1 = ((FinderMedia)localObject2).videoDuration * 1000;; paramInt1 = 0)
      {
        paramIntent.videoDuration = paramInt1;
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).media;
          if (localObject1 != null)
          {
            localObject1 = (FinderMedia)kotlin.a.j.lp((List)localObject1);
            if (localObject1 != null)
            {
              localObject2 = paramIntent.GcH;
              if (localObject2 != null) {
                ((a.c)localObject2).thumbUrl = (((FinderMedia)localObject1).thumbUrl + ((FinderMedia)localObject1).thumb_url_token);
              }
              localObject1 = x.aazN;
            }
          }
        }
        localObject1 = x.aazN;
        localArrayList.add(paramIntent);
        paramInt1 = i;
        break label220;
        paramInt2 = 0;
        break;
        paramInt1 = 0;
        break label324;
      }
      label574:
      paramIntent = ((edf)localObject2).UhH;
      if (paramIntent != null)
      {
        localObject1 = paramIntent.id;
        paramIntent = (Intent)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramIntent = "";
      }
      long l1 = paramInt1;
      localObject1 = ((edf)localObject2).GdS;
      label624:
      Object localObject3;
      if (localObject1 != null)
      {
        paramInt1 = Integer.parseInt((String)localObject1);
        localObject1 = new com.tencent.mm.plugin.mv.model.flex.a(paramIntent, 1, l1 + l2, paramInt1);
        paramIntent = ((edf)localObject2).UhH;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.TVy;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.toByteArray();
            ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG = new a.a((byte)0);
            localObject3 = ((edf)localObject2).UhH;
            if ((localObject3 == null) || (((dog)localObject3).type != 1)) {
              break label990;
            }
            localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
            if (localObject2 != null)
            {
              localObject3 = GalleryItem.ImageMediaItem.CREATOR;
              p.j(localObject3, "GalleryItem.ImageMediaItem.CREATOR");
              ((a.a)localObject2).BVd = ((GalleryItem.MediaItem)com.tencent.mm.ae.d.a(paramIntent, (Parcelable.Creator)localObject3));
            }
            paramIntent = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
            if (paramIntent == null) {
              break label975;
            }
            paramIntent = paramIntent.thumbPath;
            label753:
            paramIntent = BitmapUtil.getPictureSize(paramIntent);
            localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
            if (localObject2 != null)
            {
              if (paramIntent == null) {
                break label980;
              }
              paramInt1 = paramIntent.x;
              label779:
              ((a.a)localObject2).width = paramInt1;
            }
            localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
            if (localObject2 != null)
            {
              if (paramIntent == null) {
                break label985;
              }
              paramInt1 = paramIntent.y;
              label806:
              ((a.a)localObject2).height = paramInt1;
            }
            label812:
            paramIntent = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
            if (paramIntent != null)
            {
              localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
              if (localObject2 == null) {
                break label1053;
              }
              localObject2 = ((a.a)localObject2).BVd;
              if (localObject2 == null) {
                break label1053;
              }
              l1 = ((GalleryItem.MediaItem)localObject2).BVl;
              label853:
              paramIntent.BVl = l1;
            }
            localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
            if (localObject2 != null)
            {
              paramIntent = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
              if (paramIntent == null) {
                break label1059;
              }
              paramIntent = paramIntent.BVd;
              if (paramIntent == null) {
                break label1059;
              }
              paramIntent = paramIntent.aZe();
              label895:
              ((a.a)localObject2).thumbPath = paramIntent;
            }
            paramIntent = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
            if (paramIntent != null)
            {
              localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
              if (localObject2 == null) {
                break label1064;
              }
              localObject2 = ((a.a)localObject2).BVd;
              if (localObject2 == null) {
                break label1064;
              }
            }
          }
        }
      }
      label1053:
      label1059:
      label1064:
      for (l1 = ((GalleryItem.MediaItem)localObject2).BVm;; l1 = 0L)
      {
        paramIntent.GcL = l1;
        paramIntent = x.aazN;
        paramIntent = x.aazN;
        localArrayList.add(localObject1);
        paramInt1 = i;
        break;
        paramInt1 = 0;
        break label624;
        label975:
        paramIntent = null;
        break label753;
        label980:
        paramInt1 = 0;
        break label779;
        label985:
        paramInt1 = 0;
        break label806;
        label990:
        localObject2 = ((edf)localObject2).UhH;
        if ((localObject2 == null) || (((dog)localObject2).type != 2)) {
          break label812;
        }
        localObject2 = ((com.tencent.mm.plugin.mv.model.flex.a)localObject1).GcG;
        if (localObject2 == null) {
          break label812;
        }
        localObject3 = GalleryItem.VideoMediaItem.CREATOR;
        p.j(localObject3, "GalleryItem.VideoMediaItem.CREATOR");
        ((a.a)localObject2).BVd = ((GalleryItem.MediaItem)com.tencent.mm.ae.d.a(paramIntent, (Parcelable.Creator)localObject3));
        break label812;
        l1 = 0L;
        break label853;
        paramIntent = null;
        break label895;
      }
      label1070:
      this.wNB = true;
      fhj().fK((List)localArrayList);
      fhj().fgm();
      if ((localArrayList.size() > 0) && (paramInt2 == 1)) {
        this.GkT.L(Integer.valueOf(1));
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(227064);
    Object localObject = com.tencent.mm.ui.component.g.Xox;
    localObject = com.tencent.mm.ui.component.g.b(getActivity()).i(l.class);
    p.j(localObject, "UICProvider.of(activity)…MakerDataUIC::class.java)");
    localObject = (l)localObject;
    Integer localInteger = (Integer)((l)localObject).fhe().getValue();
    if (localInteger == null) {}
    while (localInteger.intValue() != 1)
    {
      AppMethodBeat.o(227064);
      return false;
    }
    fhj().U((kotlin.g.a.b)new l(this, (l)localObject));
    AppMethodBeat.o(227064);
    return true;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<h<com.tencent.mm.plugin.mv.model.flex.a>>
  {
    b(n paramn)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.b<List<? extends com.tencent.mm.plugin.mv.model.flex.a>, x>
  {
    public c(n paramn, dav paramdav, com.tencent.mm.plugin.livebase.a.a parama, l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(243952);
      e locale = (e)new com.tencent.mm.plugin.mv.model.flex.b((b.a)n.a(this.Gle));
      AppMethodBeat.o(243952);
      return locale;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$dataSource$2$1", "invoke", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$dataSource$2$1;"})
  static final class e
    extends q
    implements kotlin.g.a.a<1>
  {
    public static final e Gll;
    
    static
    {
      AppMethodBeat.i(231282);
      Gll = new e();
      AppMethodBeat.o(231282);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<WxRecyclerView>
  {
    f(n paramn)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "kotlin.jvm.PlatformType", "onChanged"})
  public static final class g<T>
    implements s<List<? extends com.tencent.mm.plugin.mv.model.flex.a>>
  {
    public g(n paramn) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<WxLinearLayoutManager>
  {
    h(n paramn)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$listener$1", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "onClicked", "", "pos", "", "item", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "plugin-mv_release"})
  public static final class i
    implements b.a
  {
    public final void a(int paramInt, com.tencent.mm.plugin.mv.model.flex.a parama)
    {
      AppMethodBeat.i(230063);
      p.k(parama, "item");
      Log.i("MicroMsg.Mv.MusicMvMakerFlexEditUIC", "OnDelBtnClicked, pos:" + paramInt + ", type:" + parama.type);
      b.a locala = this.Gle.Gla;
      if (locala != null) {
        locala.a(paramInt, parama);
      }
      this.Gle.fhj().d((com.tencent.mm.plugin.livelist.b)parama);
      this.Gle.fhj().fgm();
      AppMethodBeat.o(230063);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexLiveList;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<MusicMvFlexLiveList>
  {
    j(n paramn, AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class k
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    k(n paramn, Intent paramIntent, int paramInt, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(236811);
      p.k(paramd, "completion");
      paramd = new k(this.Gle, paramIntent, paramInt2, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(236811);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(236813);
      paramObject1 = ((k)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(236813);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(236809);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(236809);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      n.a(this.Gle, paramIntent, paramInt2);
      paramObject = x.aazN;
      AppMethodBeat.o(236809);
      return paramObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "liveList", "", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.b<List<? extends com.tencent.mm.plugin.mv.model.flex.a>, x>
  {
    l(n paramn, l paraml)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFlexEditUIC$onBackPressed$1$2$2"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(dbo paramdbo, n.l paraml, List paramList, LinkedList paramLinkedList, HashMap paramHashMap)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.n
 * JD-Core Version:    0.7.0.1
 */