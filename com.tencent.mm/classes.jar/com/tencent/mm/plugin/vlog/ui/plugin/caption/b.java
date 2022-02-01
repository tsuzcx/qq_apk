package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.h;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.d.d;
import com.tencent.mm.plugin.vlog.ui.plugin.d.e;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "parent", "Landroid/view/ViewGroup;", "previewHolder", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "editHolder", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "btnRoot", "Landroid/view/View;", "kotlin.jvm.PlatformType", "callback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "type", "", "key", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "captionDatas", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "captionEditClickCount", "captionEditView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "getCaptionEditView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "captionEditView$delegate", "Lkotlin/Lazy;", "captionIconClickCount", "captionView", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "getCaptionView", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "captionView$delegate", "checkIcon", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "dataMangerMaps", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lkotlin/collections/HashMap;", "editRenderScripts", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/EditRenderScript;", "enableCaption", "", "invalidSets", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "lock", "Ljava/lang/Object;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "scriptTransResults", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "view", "addVideoPath", "path", "clearCaption", "getScriptTransResult", "incCaptionEditClickCount", "initCaptionView", "initEditView", "initEditorHolder", "initLogic", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "initPreviewHolder", "kvCaptionInfo", "notifyCaptionViewUpdate", "onApplyRecords", "records", "Lkotlin/Triple;", "", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOriginPosition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "release", "reset", "resetIconColor", "iconColor", "setVisibility", "visibility", "showCaptionEditView", "transResult", "", "showEditorHolder", "result", "updateCaption", "color", "bgColor", "font", "voiceTranslate", "Companion", "plugin-vlog_release"})
public final class b
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements com.tencent.mm.plugin.vlog.ui.plugin.d.c, d.d
{
  public static final a NxN;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  private final f HXk;
  private final View NxA;
  private final ImageView NxB;
  private final f NxC;
  private final List<HashMap<String, a>> NxD;
  public final List<ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a>> NxE;
  private final List<ArrayList<ta>> NxF;
  private final List<HashSet<String>> NxG;
  private final List<com.tencent.mm.plugin.recordvideo.ui.editor.item.c> NxH;
  public boolean NxI;
  private int NxJ;
  private int NxK;
  private final EditorPanelHolder NxL;
  private final EditorPanelHolder NxM;
  private final Context context;
  private final r<Integer, String, Integer, ArrayList<ta>, x> ktT;
  private final Object lock;
  private ViewGroup parent;
  private final ImageView wRg;
  
  static
  {
    AppMethodBeat.i(226483);
    NxN = new a((byte)0);
    AppMethodBeat.o(226483);
  }
  
  public b(ViewGroup paramViewGroup, EditorPanelHolder paramEditorPanelHolder1, EditorPanelHolder paramEditorPanelHolder2, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(226482);
    this.parent = paramViewGroup;
    this.NxL = paramEditorPanelHolder1;
    this.NxM = paramEditorPanelHolder2;
    this.APl = paramd;
    this.context = this.parent.getContext();
    this.NxA = this.parent.findViewById(a.f.editor_add_caption_group);
    this.wRg = ((ImageView)this.parent.findViewById(a.f.editor_add_caption));
    this.NxB = ((ImageView)this.parent.findViewById(a.f.editor_add_caption_status));
    this.HXk = g.ar((kotlin.g.a.a)new d(this));
    this.NxC = g.ar((kotlin.g.a.a)new c(this));
    this.NxD = j.listOf(new HashMap[] { new HashMap(), new HashMap() });
    this.NxE = j.listOf(new ArrayList[] { new ArrayList(), new ArrayList() });
    this.NxF = j.listOf(new ArrayList[] { new ArrayList(), new ArrayList() });
    this.NxG = j.listOf(new HashSet[] { new HashSet(), new HashSet() });
    this.NxH = j.listOf(new com.tencent.mm.plugin.recordvideo.ui.editor.item.c[] { new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbL), new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbM) });
    this.lock = new Object();
    this.ktT = ((r)new b(this));
    this.parent.setVisibility(0);
    this.wRg.setImageDrawable(au.o(this.context, a.h.icons_filled_caption, -1));
    paramViewGroup = this.NxB;
    paramEditorPanelHolder1 = this.context;
    p.j(paramEditorPanelHolder1, "context");
    paramViewGroup.setImageDrawable(paramEditorPanelHolder1.getResources().getDrawable(a.h.popvideo_post_selected_origin));
    this.wRg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235953);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.NxO;
        b.d(paramAnonymousView, b.m(paramAnonymousView) + 1);
        if (!b.e(this.NxO))
        {
          b.a(this.NxO, true);
          b.c(this.NxO, 0);
          b.b(this.NxO, 0);
          b.a(this.NxO, 0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(235953);
          return;
          b.n(this.NxO);
          b.b(this.NxO).setShow(true);
        }
      }
    });
    AppMethodBeat.o(226482);
  }
  
  private final void a(int paramInt, ta paramta)
  {
    int k = 0;
    AppMethodBeat.i(226394);
    gvT().NxP = paramInt;
    Object localObject1 = gvT();
    p.k(paramta, "transResult");
    ((c)localObject1).NxU = 0;
    long l = paramta.Scf;
    Object localObject2 = ((Iterable)((c)localObject1).NxR.NxY).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      if (((ta)localObject3).Scf == l)
      {
        ((c)localObject1).agM = i;
        i = j;
      }
      else
      {
        i = j;
      }
    }
    i = ((c)localObject1).agM;
    Log.i("MicroMsg.EditorEditCaptionView", "scrollToTimeMs " + paramta.Scf + ' ' + ((c)localObject1).agM);
    paramta = ((c)localObject1).NxQ.getLayoutManager();
    if (paramta != null)
    {
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramta, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
      paramta.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramta, "com/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView", "selectCaption", "(Lcom/tencent/mm/protocal/protobuf/CCTransResult;)V", "Undefined", "scrollToPosition", "(I)V");
    }
    ((c)localObject1).SA(0L);
    gvT().NxR.NxY.clear();
    paramta = gvT();
    localObject1 = (List)this.NxF.get(paramInt);
    p.k(localObject1, "items");
    paramta.NxR.NxY.addAll((Collection)localObject1);
    gvT().NxR.notifyDataSetChanged();
    gvT().jij.start();
    if (!this.NxM.fpT())
    {
      this.NxM.setCoverByKeyboard(true);
      paramInt = k;
      if (gvT().NxS != null) {
        paramInt = 1;
      }
      if (paramInt == 0)
      {
        gvT().setCancelClickListener((kotlin.g.a.a)new k(this));
        gvT().setSureClickListener((m)new l(this));
      }
      EditorPanelHolder.a(this.NxM, (View)gvT());
      this.NxM.setOnVisibleChangeCallback((kotlin.g.a.b)new m(this));
    }
    this.NxM.setShow(true);
    AppMethodBeat.o(226394);
  }
  
  private final d gvS()
  {
    AppMethodBeat.i(226370);
    d locald = (d)this.HXk.getValue();
    AppMethodBeat.o(226370);
    return locald;
  }
  
  private final c gvT()
  {
    AppMethodBeat.i(226371);
    c localc = (c)this.NxC.getValue();
    AppMethodBeat.o(226371);
    return localc;
  }
  
  public final void LX(long paramLong)
  {
    AppMethodBeat.i(226422);
    if (!this.NxI)
    {
      AppMethodBeat.o(226422);
      return;
    }
    gvS().aX(0, paramLong);
    gvS().aX(1, paramLong);
    AppMethodBeat.o(226422);
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(226419);
    ((ArrayList)this.NxE.get(0)).clear();
    if (paramac != null)
    {
      paramac = ((Iterable)paramac.gtA()).iterator();
      while (paramac.hasNext())
      {
        Object localObject = (ad)paramac.next();
        localObject = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a(((ad)localObject).path, ((ad)localObject).Nng.MQV, ((ad)localObject).Nng.MQW, ((ad)localObject).Nng.pvh);
        ((ArrayList)this.NxE.get(0)).add(localObject);
        Log.i("MicroMsg.EditorCaptionPlugin", "update script:".concat(String.valueOf(localObject)));
      }
    }
    if (!this.NxI)
    {
      AppMethodBeat.o(226419);
      return;
    }
    akp(0);
    akn(0);
    AppMethodBeat.o(226419);
  }
  
  public final void a(d.e parame) {}
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(226410);
    p.k(paramArrayOfByte, "transResult");
    for (;;)
    {
      int j;
      int k;
      try
      {
        Object localObject1 = (com.tencent.mm.cd.a)new ta();
        try
        {
          ((com.tencent.mm.cd.a)localObject1).parseFrom(paramArrayOfByte);
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
          AppMethodBeat.o(226410);
          return;
        }
        localObject1 = (ta)paramArrayOfByte;
        if (localObject1 != null)
        {
          localIterator = ((Iterable)this.NxH).iterator();
          i = 0;
          if (localIterator.hasNext())
          {
            paramArrayOfByte = localIterator.next();
            j = i + 1;
            if (i < 0) {
              j.iBO();
            }
            localc = (com.tencent.mm.plugin.recordvideo.ui.editor.item.c)paramArrayOfByte;
            localObject2 = ((Iterable)localc.IbD).iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label448;
            }
            paramArrayOfByte = ((Iterator)localObject2).next();
            if (((ta)paramArrayOfByte).id != ((ta)localObject1).id) {
              break label442;
            }
            k = 1;
            break label434;
            paramArrayOfByte = (ta)paramArrayOfByte;
            if (paramArrayOfByte == null) {
              break label462;
            }
            localObject2 = gvS();
            p.k(localObject1, "transResult");
            localObject3 = (Iterable)((d.c)((d)localObject2).Nyw.get(i)).NxY;
            k = 0;
            localObject3 = ((Iterable)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = ((Iterator)localObject3).next();
              if (k < 0) {
                j.iBO();
              }
              localObject4 = (ta)localObject4;
              if (((ta)localObject4).id != ((ta)localObject1).id) {
                break label453;
              }
              ((ta)localObject4).Sce = ((ta)localObject1).Sce;
              ((d.c)((d)localObject2).Nyw.get(i)).cL(k);
            }
            localc.textColor = paramInt1;
            localc.bgColor = paramInt2;
            localc.IbE = paramString;
            paramArrayOfByte.Sce = ((ta)localObject1).Sce;
            paramArrayOfByte = new Bundle();
            paramArrayOfByte.putInt("PARAM_1_INT", i);
            paramArrayOfByte.putByteArray("PARAM_1_BYTEARRAY", localc.fyF().toByteArray());
            this.APl.a(com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTe, paramArrayOfByte);
            i = j;
            continue;
          }
        }
        AppMethodBeat.o(226410);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.EditorCaptionPlugin", (Throwable)paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(226410);
        return;
      }
      for (;;)
      {
        label434:
        if (k == 0) {
          break label446;
        }
        break;
        label442:
        k = 0;
      }
      label446:
      continue;
      label448:
      paramArrayOfByte = null;
      continue;
      label453:
      k += 1;
      continue;
      label462:
      int i = j;
    }
  }
  
  public final void acl(int paramInt)
  {
    AppMethodBeat.i(226471);
    this.wRg.setImageDrawable(au.o(this.context, a.h.icons_filled_caption, paramInt));
    AppMethodBeat.o(226471);
  }
  
  public final void akn(int paramInt)
  {
    AppMethodBeat.i(226376);
    Object localObject2 = new ArrayList((Collection)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.NxH.get(paramInt)).IbD);
    Object localObject1 = (Iterable)this.NxF.get(paramInt);
    Object localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    Object localObject4 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      ta localta = (ta)((Iterator)localObject4).next();
      Iterator localIterator = ((Iterable)localObject2).iterator();
      label108:
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        if (((ta)localObject1).id == localta.id)
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
        localObject1 = (ta)localObject1;
        if (localObject1 != null) {
          localta.Sce = ((ta)localObject1).Sce;
        }
        ((Collection)localObject3).add(localta);
        break;
        i = 0;
        break label144;
        label182:
        break label108;
        localObject1 = null;
      }
    }
    localObject1 = (List)localObject3;
    localObject2 = ((Iterable)this.NxF.get(paramInt)).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext()) {
      if (!((ta)((Iterator)localObject2).next()).Sch)
      {
        localObject3 = gvS();
        p.k(localObject1, "items");
        ((d)localObject3).akq(paramInt);
        localObject4 = new ta();
        ((ta)localObject4).Scf = -2L;
        ((ta)localObject4).Scg = -1L;
        ((d.c)((d)localObject3).Nyw.get(paramInt)).NxY.add(localObject4);
        ((d.c)((d)localObject3).Nyw.get(paramInt)).NxY.add(localObject4);
        ((d.c)((d)localObject3).Nyw.get(paramInt)).NxY.addAll((Collection)localObject1);
        localObject4 = new ta();
        ((ta)localObject4).Scf = 2147483645L;
        ((ta)localObject4).Scg = 2147483646L;
        ((d.c)((d)localObject3).Nyw.get(paramInt)).NxY.add(localObject4);
        ((d.c)((d)localObject3).Nyw.get(paramInt)).NxY.add(localObject4);
        gvS().akr(paramInt);
        i = 1;
      }
    }
    ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.NxH.get(paramInt)).IbD.clear();
    ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.NxH.get(paramInt)).IbD.addAll((Collection)localObject1);
    localObject1 = this.NxB;
    p.j(localObject1, "checkIcon");
    if (((ImageView)localObject1).getVisibility() == 0) {
      if (i != 0)
      {
        localObject1 = gvS();
        if (paramInt != 0) {
          break label636;
        }
        localObject2 = ((d)localObject1).getLoadingView();
        p.j(localObject2, "loadingView");
        ((View)localObject2).setVisibility(4);
        localObject2 = ((d)localObject1).getEmptyLayout();
        p.j(localObject2, "emptyLayout");
        ((LinearLayout)localObject2).setVisibility(4);
        localObject1 = ((d)localObject1).getContentLayout();
        p.j(localObject1, "contentLayout");
        ((LinearLayout)localObject1).setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("PARAM_1_INT", paramInt);
      ((Bundle)localObject1).putByteArray("PARAM_1_BYTEARRAY", ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.NxH.get(paramInt)).fyF().toByteArray());
      this.APl.a(com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTe, (Bundle)localObject1);
      AppMethodBeat.o(226376);
      return;
      label636:
      localObject2 = ((d)localObject1).getRecordLoadingView();
      p.j(localObject2, "recordLoadingView");
      ((View)localObject2).setVisibility(4);
      localObject2 = ((d)localObject1).getRecordEmptyLayout();
      p.j(localObject2, "recordEmptyLayout");
      ((ViewGroup)localObject2).setVisibility(4);
      localObject1 = ((d)localObject1).getRecordContentLayout();
      p.j(localObject1, "recordContentLayout");
      ((ViewGroup)localObject1).setVisibility(0);
    }
  }
  
  public final void ako(int paramInt)
  {
    AppMethodBeat.i(226414);
    d.a(gvS(), paramInt);
    ImageView localImageView = this.NxB;
    p.j(localImageView, "checkIcon");
    localImageView.setVisibility(4);
    AppMethodBeat.o(226414);
  }
  
  public final ArrayList<ta> akp(int paramInt)
  {
    AppMethodBeat.i(226433);
    ((ArrayList)this.NxF.get(paramInt)).clear();
    long l = 0L;
    Object localObject1 = ((Iterable)this.NxE.get(paramInt)).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a locala = (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)((Iterator)localObject1).next();
      Object localObject2 = (a)((HashMap)this.NxD.get(paramInt)).get(locala.path);
      Object localObject3;
      Object localObject4;
      if (localObject2 != null)
      {
        if (((a)localObject2).Nxq.size() != 0) {
          break label343;
        }
        if ((((a)localObject2).Nxu == 0) && (((a)localObject2).xFl))
        {
          Log.i("MicroMsg.EditorCaptionPlugin", "set default caption. path:" + locala.path);
          localObject2 = new ta();
          ((ta)localObject2).id = -1L;
          localObject3 = com.tencent.mm.ci.a.ba(this.context, a.i.video_caption_hint);
          p.j(localObject3, "ResourceHelper.getString…tring.video_caption_hint)");
          localObject4 = kotlin.n.d.UTF_8;
          if (localObject3 == null)
          {
            localObject1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(226433);
            throw ((Throwable)localObject1);
          }
          localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
          p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
          ((ta)localObject2).Sce = new com.tencent.mm.cd.b((byte[])localObject3);
          ((ta)localObject2).Scf = ((int)((float)locala.gcH / locala.pvh) + l);
          ((ta)localObject2).Scg = ((int)((float)locala.Idl / locala.pvh) + l);
          ((ta)localObject2).Sch = true;
          ((ArrayList)this.NxF.get(paramInt)).add(localObject2);
        }
      }
      for (;;)
      {
        l = (int)((float)(locala.Idl - locala.gcH) / locala.pvh) + l;
        break;
        label343:
        Log.i("MicroMsg.EditorCaptionPlugin", "set translate caption. path:" + locala.path);
        localObject2 = ((Iterable)((a)localObject2).Nxq).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ta)((Iterator)localObject2).next();
          if ((((ta)localObject3).Scg >= locala.gcH) && (((ta)localObject3).Scf <= locala.Idl))
          {
            localObject4 = new ta();
            ((ta)localObject4).id = ((ta)localObject3).id;
            ((ta)localObject4).Sce = ((ta)localObject3).Sce;
            ((ta)localObject4).Scf = ((int)((float)(((ta)localObject3).Scf - locala.gcH) / locala.pvh) + l);
            ((ta)localObject4).Scg = ((int)((float)(((ta)localObject3).Scg - locala.gcH) / locala.pvh) + l);
            ((ArrayList)this.NxF.get(paramInt)).add(localObject4);
          }
        }
      }
    }
    Log.i("MicroMsg.EditorCaptionPlugin", "type:" + paramInt + ", scriptTransResult size:" + ((ArrayList)this.NxF.get(paramInt)).size());
    localObject1 = (ArrayList)this.NxF.get(paramInt);
    AppMethodBeat.o(226433);
    return localObject1;
  }
  
  public final void bfN(String paramString)
  {
    AppMethodBeat.i(226400);
    p.k(paramString, "path");
    if (u.agG(paramString))
    {
      if (((HashMap)this.NxD.get(0)).get(paramString) == null)
      {
        ((Map)this.NxD.get(0)).put(paramString, new a());
        AppMethodBeat.o(226400);
      }
    }
    else {
      Log.e("MicroMsg.EditorCaptionPlugin", "file not exist ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(226400);
  }
  
  public final void cu(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(226413);
    p.k(paramArrayOfByte, "transResult");
    for (;;)
    {
      int j;
      int k;
      try
      {
        Object localObject = (com.tencent.mm.cd.a)new ta();
        try
        {
          ((com.tencent.mm.cd.a)localObject).parseFrom(paramArrayOfByte);
          paramArrayOfByte = (byte[])localObject;
        }
        catch (Exception paramArrayOfByte)
        {
          Iterator localIterator1;
          Iterator localIterator2;
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          paramArrayOfByte = null;
          continue;
          AppMethodBeat.o(226413);
          return;
        }
        localObject = (ta)paramArrayOfByte;
        if (localObject != null)
        {
          localIterator1 = ((Iterable)this.NxH).iterator();
          i = 0;
          if (localIterator1.hasNext())
          {
            paramArrayOfByte = localIterator1.next();
            j = i + 1;
            if (i < 0) {
              j.iBO();
            }
            localIterator2 = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)paramArrayOfByte).IbD).iterator();
            if (!localIterator2.hasNext()) {
              break label244;
            }
            paramArrayOfByte = localIterator2.next();
            if (((ta)paramArrayOfByte).id != ((ta)localObject).id) {
              break label238;
            }
            k = 1;
            break label230;
            paramArrayOfByte = (ta)paramArrayOfByte;
            if (paramArrayOfByte == null) {
              break label249;
            }
            a(i, paramArrayOfByte);
            i = j;
            continue;
          }
        }
        AppMethodBeat.o(226413);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.EditorCaptionPlugin", (Throwable)paramArrayOfByte, "", new Object[0]);
        AppMethodBeat.o(226413);
        return;
      }
      for (;;)
      {
        label230:
        if (k == 0) {
          break label242;
        }
        break;
        label238:
        k = 0;
      }
      label242:
      continue;
      label244:
      paramArrayOfByte = null;
      continue;
      label249:
      int i = j;
    }
  }
  
  public final void gvU()
  {
    this.NxK += 1;
  }
  
  public final String gvV()
  {
    AppMethodBeat.i(226470);
    Object localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.NxH.get(0)).IbE;
    if (localObject1 != null)
    {
      localObject1 = com.tencent.mm.plugin.vlog.model.i.bfr((String)localObject1);
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject3 = (Iterable)this.NxE.get(0);
      Object localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      long l1 = 0L;
      for (;;)
      {
        long l2;
        label187:
        Object localObject7;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          localObject5 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject4;
          l2 = (int)((float)(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).Idl - ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).gcH) / ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).pvh) + l1;
          localObject6 = (Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.NxH.get(0)).IbD;
          if ((!(localObject6 instanceof Collection)) || (!((Collection)localObject6).isEmpty()))
          {
            localObject6 = ((Iterable)localObject6).iterator();
            if (((Iterator)localObject6).hasNext())
            {
              localObject7 = (ta)((Iterator)localObject6).next();
              if ((!((ta)localObject7).Sch) && (((ta)localObject7).Scf >= ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).gcH + l1) && (((ta)localObject7).Scg <= ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a)localObject5).Idl + l1))
              {
                i = 1;
                label253:
                if (i == 0) {
                  break label283;
                }
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1021;
            }
            ((Collection)localObject2).add(localObject4);
            l1 = l2;
            break;
            i = 0;
            break label253;
            label283:
            break label187;
          }
        }
        int k = ((Collection)localObject2).size();
        localObject3 = (Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.NxH.get(0)).IbD;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        label414:
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          localObject5 = (ta)localObject4;
          if ((!((ta)localObject5).Sch) && (((ta)localObject5).Sce.UH.length > 0)) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label414;
            }
            ((Collection)localObject2).add(localObject4);
            break;
          }
        }
        int m = ((Collection)localObject2).size();
        localObject2 = (Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.NxH.get(0)).IbD;
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ta)((Iterator)localObject2).next();
            if ((!((ta)localObject3).Sch) && (((ta)localObject3).Sce.UH.length == 0))
            {
              i = 1;
              label526:
              if (i == 0) {
                break label619;
              }
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          localObject3 = (Map)this.NxD.get(0);
          localObject2 = (Collection)new ArrayList();
          localObject3 = ((Map)localObject3).entrySet().iterator();
          while (((Iterator)localObject3).hasNext()) {
            j.a((Collection)localObject2, (Iterable)((a)((Map.Entry)((Iterator)localObject3).next()).getValue()).Nxq);
          }
          i = 0;
          break label526;
          label619:
          break;
        }
        localObject2 = (Iterable)localObject2;
        localObject3 = (Collection)new ArrayList();
        Object localObject4 = ((Iterable)localObject2).iterator();
        label811:
        label819:
        label822:
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          localObject6 = (ta)localObject5;
          localObject7 = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)this.NxH.get(0)).IbD).iterator();
          label709:
          if (((Iterator)localObject7).hasNext())
          {
            localObject2 = ((Iterator)localObject7).next();
            if (((ta)localObject2).id == ((ta)localObject6).id)
            {
              j = 1;
              label747:
              if (j == 0) {
                break label811;
              }
              label751:
              localObject2 = (ta)localObject2;
              if ((localObject2 == null) || (((ta)localObject6).Sch) || (!(p.h(((ta)localObject6).Sce, ((ta)localObject2).Sce) ^ true))) {
                break label819;
              }
            }
          }
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label822;
            }
            ((Collection)localObject3).add(localObject5);
            break;
            j = 0;
            break label747;
            break label709;
            localObject2 = null;
            break label751;
          }
        }
        int j = ((Collection)localObject3).size();
        localObject2 = s.M("useCaptionTrackCount", Integer.valueOf(k));
        localObject3 = s.M("captionCount", Integer.valueOf(m));
        localObject1 = s.M("captionFont", localObject1);
        localObject4 = s.M("captionIconClickCount", Integer.valueOf(this.NxJ));
        Object localObject5 = s.M("captionEditClickCount", Integer.valueOf(this.NxK));
        Object localObject6 = s.M("captionModifiedCount", Integer.valueOf(j));
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          localObject1 = new com.tencent.mm.ad.i(ae.e(new o[] { localObject2, localObject3, localObject1, localObject4, localObject5, localObject6, s.M("hasDeleteCaption", Integer.valueOf(i)) })).toString();
          p.j(localObject1, "JSONObject(info).toString()");
          localObject1 = n.l((String)localObject1, ",", ";", false);
          AppMethodBeat.o(226470);
          return localObject1;
        }
        label1021:
        l1 = l2;
      }
    }
  }
  
  public final void n(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(226399);
    if (paramRecordConfigProvider != null)
    {
      paramRecordConfigProvider = paramRecordConfigProvider.mab;
      if (paramRecordConfigProvider != null)
      {
        paramRecordConfigProvider = paramRecordConfigProvider.getParcelableArrayList("media_list");
        if (paramRecordConfigProvider != null)
        {
          p.j(paramRecordConfigProvider, "list");
          paramRecordConfigProvider = (Iterable)paramRecordConfigProvider;
          int i = 0;
          paramRecordConfigProvider = paramRecordConfigProvider.iterator();
          while (paramRecordConfigProvider.hasNext())
          {
            Object localObject = paramRecordConfigProvider.next();
            if (i < 0) {
              j.iBO();
            }
            localObject = (GalleryItem.MediaItem)localObject;
            p.j(localObject, "item");
            if (((GalleryItem.MediaItem)localObject).getType() == 2)
            {
              localObject = ((GalleryItem.MediaItem)localObject).AAz;
              p.j(localObject, "item.mOriginalPath");
              bfN((String)localObject);
            }
            i += 1;
          }
          AppMethodBeat.o(226399);
          return;
        }
        AppMethodBeat.o(226399);
        return;
      }
    }
    AppMethodBeat.o(226399);
  }
  
  public final void release()
  {
    AppMethodBeat.i(226445);
    super.release();
    gvT().jij.setKeyboardHeightObserver(null);
    Iterator localIterator1 = ((Iterable)this.NxD).iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Map)localIterator1.next()).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        a locala = (a)((Map.Entry)localIterator2.next()).getValue();
        Object localObject = h.aHF();
        p.j(localObject, "MMKernel.network()");
        ((com.tencent.mm.kernel.c)localObject).aGY().b(3835, (com.tencent.mm.an.i)locala);
        try
        {
          locala.kTS = true;
          localObject = locala.kUU;
          if (localObject != null) {
            ((com.tencent.mm.compatible.i.c)localObject).release();
          }
          locala.kUU = null;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.EditCaptionDataManager", (Throwable)localException, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(226445);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(226436);
    super.reset();
    this.NxJ = 0;
    this.NxK = 0;
    Object localObject = this.NxB;
    p.j(localObject, "checkIcon");
    ((ImageView)localObject).setVisibility(4);
    this.NxI = false;
    localObject = ((Iterable)this.NxH).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)((Iterator)localObject).next()).IbD.clear();
    }
    localObject = ((Iterable)this.NxD).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((HashMap)((Iterator)localObject).next()).clear();
    }
    AppMethodBeat.o(226436);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(226447);
    View localView = this.NxA;
    p.j(localView, "btnRoot");
    localView.setVisibility(paramInt);
    AppMethodBeat.o(226447);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "type", "", "key", "", "ret", "transition", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "invoke"})
  static final class b
    extends q
    implements r<Integer, String, Integer, ArrayList<ta>, x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorEditCaptionView;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<c>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorTextCaptionView;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<d>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Long, x>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "type", "", "hasTranslate", "", "invoke"})
  static final class h
    extends q
    implements m<Integer, Boolean, x>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "type", "", "result", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "invoke"})
  static final class j
    extends q
    implements m<Integer, ta, x>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "type", "", "result", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "invoke"})
  static final class l
    extends q
    implements m<Integer, ArrayList<ta>, x>
  {
    l(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    m(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    n(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.b
 * JD-Core Version:    0.7.0.1
 */