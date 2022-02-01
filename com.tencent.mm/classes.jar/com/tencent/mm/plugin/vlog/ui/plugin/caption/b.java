package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaExtractor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.d.d;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.n.n;
import kotlin.v;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "parent", "Landroid/view/ViewGroup;", "previewHolder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "editHolder", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "btnRoot", "Landroid/view/View;", "kotlin.jvm.PlatformType", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "captionDatas", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "captionEditClickCount", "captionEditView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "getCaptionEditView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "captionEditView$delegate", "Lkotlin/Lazy;", "captionIconClickCount", "captionView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "getCaptionView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "captionView$delegate", "checkIcon", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "dataMangerMaps", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lkotlin/collections/HashMap;", "editRenderScripts", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/EditRenderScript;", "enableCaption", "", "invalidSets", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "lock", "Ljava/lang/Object;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "scriptTransResults", "view", "addVideoPath", "path", "clearCaption", "getScriptTransResult", "incCaptionEditClickCount", "initCaptionView", "initEditView", "initEditorHolder", "initLogic", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "initPreviewHolder", "kvCaptionInfo", "notifyCaptionViewUpdate", "onApplyRecords", "records", "Lkotlin/Triple;", "", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOriginPosition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "release", "reset", "resetIconColor", "iconColor", "setVisibility", "visibility", "showCaptionEditView", "transResult", "", "showEditorHolder", "result", "updateCaption", "color", "bgColor", "font", "voiceTranslate", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements com.tencent.mm.plugin.vlog.ui.plugin.d.c, d.d
{
  public static final b.a UkB;
  private final kotlin.j NTV;
  private final EditorPanelHolder UkC;
  private final EditorPanelHolder UkD;
  private final View UkE;
  private final ImageView UkF;
  private final kotlin.j UkG;
  private final List<HashMap<String, a>> UkH;
  public final List<ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a>> UkI;
  private final List<ArrayList<uq>> UkJ;
  private final List<HashSet<String>> UkK;
  private final List<com.tencent.mm.plugin.recordvideo.ui.editor.item.c> UkL;
  public boolean UkM;
  private int UkN;
  private int UkO;
  private final Context context;
  private final ImageView cqj;
  private final Object lock;
  private final kotlin.g.a.r<Integer, String, Integer, ArrayList<uq>, ah> mXP;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(283412);
    UkB = new b.a((byte)0);
    AppMethodBeat.o(283412);
  }
  
  public b(ViewGroup paramViewGroup, EditorPanelHolder paramEditorPanelHolder1, EditorPanelHolder paramEditorPanelHolder2, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(283248);
    this.parent = paramViewGroup;
    this.UkC = paramEditorPanelHolder1;
    this.UkD = paramEditorPanelHolder2;
    this.context = this.parent.getContext();
    this.UkE = this.parent.findViewById(a.f.editor_add_caption_group);
    this.cqj = ((ImageView)this.parent.findViewById(a.f.editor_add_caption));
    this.UkF = ((ImageView)this.parent.findViewById(a.f.editor_add_caption_status));
    this.NTV = k.cm((kotlin.g.a.a)new d(this));
    this.UkG = k.cm((kotlin.g.a.a)new c(this));
    this.UkH = p.listOf(new HashMap[] { new HashMap(), new HashMap() });
    this.UkI = p.listOf(new ArrayList[] { new ArrayList(), new ArrayList() });
    this.UkJ = p.listOf(new ArrayList[] { new ArrayList(), new ArrayList() });
    this.UkK = p.listOf(new HashSet[] { new HashSet(), new HashSet() });
    this.UkL = p.listOf(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c[] { new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYi), new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYj) });
    this.lock = new Object();
    this.mXP = ((kotlin.g.a.r)new b(this));
    this.parent.setVisibility(0);
    this.cqj.setImageDrawable(bb.m(this.context, a.h.icons_filled_caption, -1));
    this.UkF.setImageDrawable(this.context.getResources().getDrawable(a.h.popvideo_post_selected_origin));
    this.cqj.setOnClickListener(new b..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(283248);
  }
  
  private final void a(int paramInt, uq paramuq)
  {
    int k = 0;
    AppMethodBeat.i(283272);
    hTI().UkR = paramInt;
    Object localObject1 = hTI();
    kotlin.g.b.s.u(paramuq, "transResult");
    ((c)localObject1).UkW = 0;
    long l = paramuq.YZX;
    Object localObject2 = ((Iterable)((c)localObject1).UkT.UkY).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        p.kkW();
      }
      if (((uq)localObject3).YZX == l)
      {
        ((c)localObject1).bVs = i;
        i = j;
      }
      else
      {
        i = j;
      }
    }
    i = ((c)localObject1).bVs;
    Log.i("MicroMsg.EditorEditCaptionView", "scrollToTimeMs " + paramuq.YZX + ' ' + ((c)localObject1).bVs);
    paramuq = ((c)localObject1).UkS.getLayoutManager();
    if (paramuq != null)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramuq, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
      paramuq.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramuq, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
    }
    ((c)localObject1).wO(0L);
    hTI().UkT.UkY.clear();
    paramuq = hTI();
    localObject1 = (List)this.UkJ.get(paramInt);
    kotlin.g.b.s.u(localObject1, "items");
    paramuq.UkT.UkY.addAll((Collection)localObject1);
    hTI().UkT.bZE.notifyChanged();
    hTI().lKz.start();
    if (!this.UkD.gBh())
    {
      this.UkD.setCoverByKeyboard(true);
      paramInt = k;
      if (hTI().UkU != null) {
        paramInt = 1;
      }
      if (paramInt == 0)
      {
        hTI().setCancelClickListener((kotlin.g.a.a)new k(this));
        hTI().setSureClickListener((m)new l(this));
      }
      EditorPanelHolder.a(this.UkD, (View)hTI());
      this.UkD.setOnVisibleChangeCallback((kotlin.g.a.b)new m(this));
    }
    this.UkD.setShow(true);
    AppMethodBeat.o(283272);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(283301);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramb, "this$0");
    paramb.UkN += 1;
    if (!paramb.UkM)
    {
      paramb.UkM = true;
      paramb.apJ(0);
      paramb.apG(0);
      paramb.apI(0);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283301);
      return;
    }
    if (!paramb.UkC.gBh()) {
      if (paramb.hTH().ykx == null) {
        break label307;
      }
    }
    label307:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramb.hTH().setVideoPauseListener((kotlin.g.a.a)new e(paramb));
        paramb.hTH().setVideoSeekListener((kotlin.g.a.b)new f(paramb));
        paramb.hTH().setStartTransListener((kotlin.g.a.b)new g(paramb));
        paramb.hTH().setClearTransListener((m)new h(paramb));
        paramb.hTH().setDismissListener((kotlin.g.a.a)new i(paramb));
        paramb.hTH().setItemClickListener((m)new j(paramb));
      }
      EditorPanelHolder.a(paramb.UkC, (View)paramb.hTH());
      paramb.UkC.setOnVisibleChangeCallback((kotlin.g.a.b)new n(paramb));
      paramb.UkC.setShow(true);
      break;
    }
  }
  
  private final void apI(int paramInt)
  {
    AppMethodBeat.i(283289);
    Log.i("MicroMsg.EditorCaptionPlugin", kotlin.g.b.s.X("voiceTranslate type:", Integer.valueOf(paramInt)));
    this.UkF.setVisibility(0);
    Object localObject1 = hTH();
    if (paramInt == 0)
    {
      ((d)localObject1).getLoadingView().setVisibility(0);
      ((d)localObject1).getContentLayout().setVisibility(4);
      ((d)localObject1).getEmptyLayout().setVisibility(4);
      localObject1 = ((Map)this.UkH.get(paramInt)).entrySet().iterator();
    }
    for (;;)
    {
      label87:
      if (!((Iterator)localObject1).hasNext()) {
        break label416;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (a)((Map.Entry)localObject2).getValue();
      kotlin.g.a.r localr = this.mXP;
      kotlin.g.b.s.u(str, "filePath");
      kotlin.g.b.s.u(localr, "callback");
      Log.i("MicroMsg.EditCaptionDataManager", "[" + ((a)localObject2).hashCode() + "]prepare translate file:" + str);
      if ((!((a)localObject2).Ukv) && (kotlin.g.b.s.p(str, ((a)localObject2).filePath)))
      {
        Collection localCollection = (Collection)((a)localObject2).Uks;
        if ((localCollection == null) || (localCollection.isEmpty()))
        {
          i = 1;
          label239:
          if (i == 0) {
            break label304;
          }
        }
        label304:
        for (i = -2;; i = 0)
        {
          localr.a(Integer.valueOf(paramInt), str, Integer.valueOf(i), ((a)localObject2).Uks);
          break label87;
          ((d)localObject1).getRecordLoadingView().setVisibility(0);
          ((d)localObject1).getRecordContentLayout().setVisibility(4);
          ((d)localObject1).getRecordEmptyLayout().setVisibility(4);
          break;
          i = 0;
          break label239;
        }
      }
      ((a)localObject2).Ukv = false;
      ((a)localObject2).Bcz = true;
      ((a)localObject2).mXP = localr;
      ((a)localObject2).filePath = str;
      int i = ((a)localObject2).bfs(str);
      if (i != 0)
      {
        ((a)localObject2).Bcz = false;
        localr.a(Integer.valueOf(paramInt), str, Integer.valueOf(i), null);
      }
      else
      {
        ((a)localObject2).Ukw = i;
        kotlinx.coroutines.j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new a.b((a)localObject2, paramInt, null), 2);
      }
    }
    label416:
    AppMethodBeat.o(283289);
  }
  
  private final d hTH()
  {
    AppMethodBeat.i(283254);
    d locald = (d)this.NTV.getValue();
    AppMethodBeat.o(283254);
    return locald;
  }
  
  private final c hTI()
  {
    AppMethodBeat.i(283259);
    c localc = (c)this.UkG.getValue();
    AppMethodBeat.o(283259);
    return localc;
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(283441);
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    paramRecordConfigProvider = paramRecordConfigProvider.oSS;
    if (paramRecordConfigProvider != null)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.getParcelableArrayList("media_list");
      if (paramRecordConfigProvider != null)
      {
        paramRecordConfigProvider = (Iterable)paramRecordConfigProvider;
        int i = 0;
        paramRecordConfigProvider = paramRecordConfigProvider.iterator();
        while (paramRecordConfigProvider.hasNext())
        {
          Object localObject = paramRecordConfigProvider.next();
          if (i < 0) {
            p.kkW();
          }
          localObject = (GalleryItem.MediaItem)localObject;
          if (((GalleryItem.MediaItem)localObject).getType() == 2)
          {
            localObject = ((GalleryItem.MediaItem)localObject).Gcc;
            kotlin.g.b.s.s(localObject, "item.mOriginalPath");
            bft((String)localObject);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(283441);
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(283497);
    ((ArrayList)this.UkI.get(0)).clear();
    if (paramac != null)
    {
      paramac = paramac.hRb();
      if (paramac != null)
      {
        paramac = ((Iterable)paramac).iterator();
        while (paramac.hasNext())
        {
          Object localObject = (ad)paramac.next();
          localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a(((ad)localObject).path, ((ad)localObject).UaI.TDw, ((ad)localObject).UaI.TDx, ((ad)localObject).UaI.sAn);
          ((ArrayList)this.UkI.get(0)).add(localObject);
          Log.i("MicroMsg.EditorCaptionPlugin", kotlin.g.b.s.X("update script:", localObject));
        }
      }
    }
    if (!this.UkM)
    {
      AppMethodBeat.o(283497);
      return;
    }
    apJ(0);
    apG(0);
    AppMethodBeat.o(283497);
  }
  
  public final void a(d.e parame) {}
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(283465);
    kotlin.g.b.s.u(paramArrayOfByte, "transResult");
    for (;;)
    {
      int k;
      try
      {
        Object localObject1 = (com.tencent.mm.bx.a)new uq();
        try
        {
          ((com.tencent.mm.bx.a)localObject1).parseFrom(paramArrayOfByte);
          paramArrayOfByte = (byte[])localObject1;
        }
        catch (Exception paramArrayOfByte)
        {
          Iterator localIterator;
          com.tencent.mm.plugin.recordvideo.ui.editor.item.c localc;
          Object localObject2;
          Object localObject3;
          Object localObject4;
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          paramArrayOfByte = null;
          continue;
          k = 0;
        }
        localObject1 = (uq)paramArrayOfByte;
        if (localObject1 != null)
        {
          localIterator = ((Iterable)this.UkL).iterator();
          int i = 0;
          if (localIterator.hasNext())
          {
            paramArrayOfByte = localIterator.next();
            int j = i + 1;
            if (i < 0) {
              p.kkW();
            }
            localc = (com.tencent.mm.plugin.recordvideo.ui.editor.item.c)paramArrayOfByte;
            localObject2 = ((Iterable)localc.NYc).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              paramArrayOfByte = ((Iterator)localObject2).next();
              if (((uq)paramArrayOfByte).id == ((uq)localObject1).id)
              {
                k = 1;
                break label454;
                paramArrayOfByte = (uq)paramArrayOfByte;
                if (paramArrayOfByte == null) {
                  continue;
                }
                localObject2 = hTH();
                kotlin.g.b.s.u(localObject1, "transResult");
                localObject3 = (Iterable)((d.c)((d)localObject2).Ulx.get(i)).UkY;
                k = 0;
                localObject3 = ((Iterable)localObject3).iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  localObject4 = ((Iterator)localObject3).next();
                  if (k < 0) {
                    p.kkW();
                  }
                  localObject4 = (uq)localObject4;
                  if (((uq)localObject4).id != ((uq)localObject1).id) {
                    continue;
                  }
                  ((uq)localObject4).YZW = ((uq)localObject1).YZW;
                  ((d.c)((d)localObject2).Ulx.get(i)).fV(k);
                }
                localc.textColor = paramInt1;
                localc.bgColor = paramInt2;
                localc.mAD = paramString;
                paramArrayOfByte.YZW = ((uq)localObject1).YZW;
                paramArrayOfByte = new Bundle();
                paramArrayOfByte.putInt("PARAM_1_INT", i);
                paramArrayOfByte.putByteArray("PARAM_1_BYTEARRAY", localc.gKr().toByteArray());
                this.GrC.a(a.c.NPK, paramArrayOfByte);
                i = j;
                continue;
              }
            }
            paramArrayOfByte = null;
            continue;
            k += 1;
            continue;
            i = j;
            continue;
          }
          AppMethodBeat.o(283465);
        }
      }
      catch (IOException paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.EditorCaptionPlugin", (Throwable)paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(283465);
        return;
      }
      label454:
      if (k == 0) {}
    }
  }
  
  public final void agy(int paramInt)
  {
    AppMethodBeat.i(283595);
    this.cqj.setImageDrawable(bb.m(this.context, a.h.icons_filled_caption, paramInt));
    AppMethodBeat.o(283595);
  }
  
  public final void apG(int paramInt)
  {
    AppMethodBeat.i(283433);
    Object localObject2 = new ArrayList((Collection)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.UkL.get(paramInt)).NYc);
    Object localObject1 = (Iterable)this.UkJ.get(paramInt);
    Object localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    Object localObject4 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      uq localuq = (uq)((Iterator)localObject4).next();
      Iterator localIterator = ((Iterable)localObject2).iterator();
      label108:
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (((uq)localObject1).id == localuq.id)
        {
          i = 1;
          if (i == 0) {
            break label182;
          }
        }
      }
      for (;;)
      {
        label144:
        localObject1 = (uq)localObject1;
        if (localObject1 != null) {
          localuq.YZW = ((uq)localObject1).YZW;
        }
        ((Collection)localObject3).add(localuq);
        break;
        i = 0;
        break label144;
        label182:
        break label108;
        localObject1 = null;
      }
    }
    localObject1 = (List)localObject3;
    localObject2 = ((Iterable)this.UkJ.get(paramInt)).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext()) {
      if (!((uq)((Iterator)localObject2).next()).YZZ)
      {
        localObject3 = hTH();
        kotlin.g.b.s.u(localObject1, "items");
        ((d)localObject3).apK(paramInt);
        localObject4 = new uq();
        ((uq)localObject4).YZX = -2L;
        ((uq)localObject4).YZY = -1L;
        ((d.c)((d)localObject3).Ulx.get(paramInt)).UkY.add(localObject4);
        ((d.c)((d)localObject3).Ulx.get(paramInt)).UkY.add(localObject4);
        ((d.c)((d)localObject3).Ulx.get(paramInt)).UkY.addAll((Collection)localObject1);
        localObject4 = new uq();
        ((uq)localObject4).YZX = 2147483645L;
        ((uq)localObject4).YZY = 2147483646L;
        ((d.c)((d)localObject3).Ulx.get(paramInt)).UkY.add(localObject4);
        ((d.c)((d)localObject3).Ulx.get(paramInt)).UkY.add(localObject4);
        hTH().apL(paramInt);
        i = 1;
      }
    }
    ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.UkL.get(paramInt)).NYc.clear();
    ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.UkL.get(paramInt)).NYc.addAll((Collection)localObject1);
    if (this.UkF.getVisibility() == 0) {
      if (i != 0)
      {
        localObject1 = hTH();
        if (paramInt != 0) {
          break label594;
        }
        ((d)localObject1).getLoadingView().setVisibility(4);
        ((d)localObject1).getEmptyLayout().setVisibility(4);
        ((d)localObject1).getContentLayout().setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("PARAM_1_INT", paramInt);
      ((Bundle)localObject1).putByteArray("PARAM_1_BYTEARRAY", ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.UkL.get(paramInt)).gKr().toByteArray());
      this.GrC.a(a.c.NPK, (Bundle)localObject1);
      AppMethodBeat.o(283433);
      return;
      label594:
      ((d)localObject1).getRecordLoadingView().setVisibility(4);
      ((d)localObject1).getRecordEmptyLayout().setVisibility(4);
      ((d)localObject1).getRecordContentLayout().setVisibility(0);
    }
  }
  
  public final void apH(int paramInt)
  {
    AppMethodBeat.i(283482);
    d.a(hTH(), paramInt);
    this.UkF.setVisibility(4);
    AppMethodBeat.o(283482);
  }
  
  public final ArrayList<uq> apJ(int paramInt)
  {
    AppMethodBeat.i(283530);
    ((ArrayList)this.UkJ.get(paramInt)).clear();
    long l = 0L;
    Object localObject1 = ((Iterable)this.UkI.get(paramInt)).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a locala = (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)((Iterator)localObject1).next();
      Object localObject2 = (a)((HashMap)this.UkH.get(paramInt)).get(locala.path);
      Object localObject3;
      if (localObject2 != null)
      {
        if (((a)localObject2).Uks.size() != 0) {
          break label303;
        }
        if ((((a)localObject2).Ukw == 0) && (((a)localObject2).Bcz))
        {
          Log.i("MicroMsg.EditorCaptionPlugin", kotlin.g.b.s.X("set default caption. path:", locala.path));
          localObject2 = new uq();
          ((uq)localObject2).id = -1L;
          localObject3 = com.tencent.mm.cd.a.bt(this.context, a.i.video_caption_hint);
          kotlin.g.b.s.s(localObject3, "getString(context, R.string.video_caption_hint)");
          localObject3 = ((String)localObject3).getBytes(kotlin.n.d.UTF_8);
          kotlin.g.b.s.s(localObject3, "(this as java.lang.String).getBytes(charset)");
          ((uq)localObject2).YZW = new com.tencent.mm.bx.b((byte[])localObject3);
          ((uq)localObject2).YZX = ((int)((float)locala.startMs / locala.sAn) + l);
          ((uq)localObject2).YZY = ((int)((float)locala.NZH / locala.sAn) + l);
          ((uq)localObject2).YZZ = true;
          ((ArrayList)this.UkJ.get(paramInt)).add(localObject2);
        }
      }
      for (;;)
      {
        l = (int)((float)(locala.NZH - locala.startMs) / locala.sAn) + l;
        break;
        label303:
        Log.i("MicroMsg.EditorCaptionPlugin", kotlin.g.b.s.X("set translate caption. path:", locala.path));
        localObject2 = ((Iterable)((a)localObject2).Uks).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (uq)((Iterator)localObject2).next();
          if ((((uq)localObject3).YZY >= locala.startMs) && (((uq)localObject3).YZX <= locala.NZH))
          {
            uq localuq = new uq();
            localuq.id = ((uq)localObject3).id;
            localuq.YZW = ((uq)localObject3).YZW;
            localuq.YZX = ((int)((float)(((uq)localObject3).YZX - locala.startMs) / locala.sAn) + l);
            localuq.YZY = ((int)((float)(((uq)localObject3).YZY - locala.startMs) / locala.sAn) + l);
            ((ArrayList)this.UkJ.get(paramInt)).add(localuq);
          }
        }
      }
    }
    Log.i("MicroMsg.EditorCaptionPlugin", "type:" + paramInt + ", scriptTransResult size:" + ((ArrayList)this.UkJ.get(paramInt)).size());
    localObject1 = (ArrayList)this.UkJ.get(paramInt);
    AppMethodBeat.o(283530);
    return localObject1;
  }
  
  public final void bft(String paramString)
  {
    AppMethodBeat.i(283450);
    kotlin.g.b.s.u(paramString, "path");
    if (y.ZC(paramString))
    {
      if (((HashMap)this.UkH.get(0)).get(paramString) == null)
      {
        ((Map)this.UkH.get(0)).put(paramString, new a());
        AppMethodBeat.o(283450);
      }
    }
    else {
      Log.e("MicroMsg.EditorCaptionPlugin", kotlin.g.b.s.X("file not exist ", paramString));
    }
    AppMethodBeat.o(283450);
  }
  
  public final void cy(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(283474);
    kotlin.g.b.s.u(paramArrayOfByte, "transResult");
    for (;;)
    {
      int k;
      try
      {
        Object localObject = (com.tencent.mm.bx.a)new uq();
        try
        {
          ((com.tencent.mm.bx.a)localObject).parseFrom(paramArrayOfByte);
          paramArrayOfByte = (byte[])localObject;
        }
        catch (Exception paramArrayOfByte)
        {
          Iterator localIterator1;
          Iterator localIterator2;
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          paramArrayOfByte = null;
          continue;
          k = 0;
        }
        localObject = (uq)paramArrayOfByte;
        if (localObject != null)
        {
          localIterator1 = ((Iterable)this.UkL).iterator();
          int i = 0;
          if (localIterator1.hasNext())
          {
            paramArrayOfByte = localIterator1.next();
            int j = i + 1;
            if (i < 0) {
              p.kkW();
            }
            localIterator2 = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)paramArrayOfByte).NYc).iterator();
            if (localIterator2.hasNext())
            {
              paramArrayOfByte = localIterator2.next();
              if (((uq)paramArrayOfByte).id == ((uq)localObject).id)
              {
                k = 1;
                break label239;
                paramArrayOfByte = (uq)paramArrayOfByte;
                if (paramArrayOfByte == null) {
                  continue;
                }
                a(i, paramArrayOfByte);
                i = j;
                continue;
              }
            }
            paramArrayOfByte = null;
            continue;
            i = j;
            continue;
          }
          AppMethodBeat.o(283474);
        }
      }
      catch (IOException paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.EditorCaptionPlugin", (Throwable)paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(283474);
        return;
      }
      label239:
      if (k == 0) {}
    }
  }
  
  public final void hTJ()
  {
    this.UkO += 1;
  }
  
  public final String hTK()
  {
    AppMethodBeat.i(283587);
    Object localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.UkL.get(0)).mAD;
    Object localObject3;
    Object localObject2;
    long l1;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject3 = (Iterable)this.UkI.get(0);
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      l1 = 0L;
    }
    for (;;)
    {
      label73:
      long l2;
      label175:
      Object localObject7;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject4;
        l2 = (int)((float)(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).NZH - ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).startMs) / ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).sAn) + l1;
        localObject6 = (Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.UkL.get(0)).NYc;
        if ((!(localObject6 instanceof Collection)) || (!((Collection)localObject6).isEmpty()))
        {
          localObject6 = ((Iterable)localObject6).iterator();
          if (((Iterator)localObject6).hasNext())
          {
            localObject7 = (uq)((Iterator)localObject6).next();
            if ((!((uq)localObject7).YZZ) && (((uq)localObject7).YZX >= ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).startMs + l1) && (((uq)localObject7).YZY <= ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).NZH + l1))
            {
              i = 1;
              label241:
              if (i == 0) {
                break label294;
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label1029;
          }
          ((Collection)localObject2).add(localObject4);
          l1 = l2;
          break label73;
          localObject1 = com.tencent.mm.plugin.vlog.model.h.beZ((String)localObject1);
          if (localObject1 == null)
          {
            localObject1 = "";
            break;
          }
          break;
          i = 0;
          break label241;
          label294:
          break label175;
        }
      }
      int k = ((Collection)localObject2).size();
      localObject3 = (Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.UkL.get(0)).NYc;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      label425:
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        localObject5 = (uq)localObject4;
        if ((!((uq)localObject5).YZZ) && (((uq)localObject5).YZW.Op.length > 0)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label425;
          }
          ((Collection)localObject2).add(localObject4);
          break;
        }
      }
      int m = ((Collection)localObject2).size();
      localObject2 = (Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.UkL.get(0)).NYc;
      if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
      {
        localObject2 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (uq)((Iterator)localObject2).next();
          if ((!((uq)localObject3).YZZ) && (((uq)localObject3).YZW.Op.length == 0))
          {
            i = 1;
            label537:
            if (i == 0) {
              break label630;
            }
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        localObject3 = (Map)this.UkH.get(0);
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext()) {
          p.a((Collection)localObject2, (Iterable)((a)((Map.Entry)((Iterator)localObject3).next()).getValue()).Uks);
        }
        i = 0;
        break label537;
        label630:
        break;
      }
      localObject2 = (Iterable)localObject2;
      localObject3 = (Collection)new ArrayList();
      Object localObject4 = ((Iterable)localObject2).iterator();
      label820:
      label828:
      label831:
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = ((Iterator)localObject4).next();
        localObject6 = (uq)localObject5;
        localObject7 = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.UkL.get(0)).NYc).iterator();
        label720:
        if (((Iterator)localObject7).hasNext())
        {
          localObject2 = ((Iterator)localObject7).next();
          if (((uq)localObject2).id == ((uq)localObject6).id)
          {
            j = 1;
            label758:
            if (j == 0) {
              break label820;
            }
            label762:
            localObject2 = (uq)localObject2;
            if ((localObject2 == null) || (((uq)localObject6).YZZ) || (kotlin.g.b.s.p(((uq)localObject6).YZW, ((uq)localObject2).YZW))) {
              break label828;
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label831;
          }
          ((Collection)localObject3).add(localObject5);
          break;
          j = 0;
          break label758;
          break label720;
          localObject2 = null;
          break label762;
        }
      }
      int j = ((Collection)localObject3).size();
      localObject2 = v.Y("useCaptionTrackCount", Integer.valueOf(k));
      localObject3 = v.Y("captionCount", Integer.valueOf(m));
      localObject1 = v.Y("captionFont", localObject1);
      localObject4 = v.Y("captionIconClickCount", Integer.valueOf(this.UkN));
      Object localObject5 = v.Y("captionEditClickCount", Integer.valueOf(this.UkO));
      Object localObject6 = v.Y("captionModifiedCount", Integer.valueOf(j));
      if (i != 0) {}
      for (i = 1;; i = 0)
      {
        localObject1 = new com.tencent.mm.ad.i(ak.e(new kotlin.r[] { localObject2, localObject3, localObject1, localObject4, localObject5, localObject6, v.Y("hasDeleteCaption", Integer.valueOf(i)) })).toString();
        kotlin.g.b.s.s(localObject1, "JSONObject(info).toString()");
        localObject1 = n.bV((String)localObject1, ",", ";");
        AppMethodBeat.o(283587);
        return localObject1;
      }
      label1029:
      l1 = l2;
    }
  }
  
  public final void qU(long paramLong)
  {
    AppMethodBeat.i(283512);
    if (!this.UkM)
    {
      AppMethodBeat.o(283512);
      return;
    }
    hTH().bf(0, paramLong);
    hTH().bf(1, paramLong);
    AppMethodBeat.o(283512);
  }
  
  public final void release()
  {
    AppMethodBeat.i(283550);
    super.release();
    hTI().lKz.afIL = null;
    Iterator localIterator1 = ((Iterable)this.UkH).iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Map)localIterator1.next()).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator2.next()).getValue();
        com.tencent.mm.kernel.h.baD().mCm.b(3835, (com.tencent.mm.am.h)locala);
        try
        {
          locala.nzB = true;
          com.tencent.mm.compatible.i.c localc = locala.nAr;
          if (localc != null) {
            localc.lZm.release();
          }
          locala.nAr = null;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", (Throwable)localException, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(283550);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(283538);
    super.reset();
    this.UkN = 0;
    this.UkO = 0;
    this.UkF.setVisibility(4);
    this.UkM = false;
    Iterator localIterator = ((Iterable)this.UkL).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localIterator.next()).NYc.clear();
    }
    localIterator = ((Iterable)this.UkH).iterator();
    while (localIterator.hasNext()) {
      ((HashMap)localIterator.next()).clear();
    }
    AppMethodBeat.o(283538);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(283558);
    this.UkE.setVisibility(paramInt);
    AppMethodBeat.o(283558);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "type", "", "key", "", "ret", "transition", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.r<Integer, String, Integer, ArrayList<uq>, ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<c>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<d>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<Long, ah>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "type", "", "hasTranslate", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements m<Integer, Boolean, ah>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "type", "", "result", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements m<Integer, uq, ah>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "type", "", "result", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements m<Integer, ArrayList<uq>, ah>
  {
    l(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    m(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    n(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.b
 * JD-Core Version:    0.7.0.1
 */