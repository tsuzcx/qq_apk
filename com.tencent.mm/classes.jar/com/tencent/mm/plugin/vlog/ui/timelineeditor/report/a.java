package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kc;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.af;
import com.tencent.mm.plugin.vlog.ui.widget.VLogThumbView;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport19904;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;)V", "isVideoEnhancementEnable", "", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "setPluginLayout", "init", "", "intent", "Landroid/content/Intent;", "packageReportData", "prepareBackPress", "reportId", "", "reset", "setBeautyConfig", "config", "Lcom/tencent/mm/plugin/xlabeffect/XEffectConfig;", "setEditId", "editId", "setEditItemList", "editList", "", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "isAllImage", "setPostId", "postId", "setVideoLabel", "enable", "labelMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "", "Lkotlin/collections/HashMap;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e<kc>
{
  public static final a UqO;
  private boolean Ugg;
  private BasePluginLayout UqP;
  
  static
  {
    AppMethodBeat.i(282154);
    UqO = new a((byte)0);
    AppMethodBeat.o(282154);
  }
  
  public a(BasePluginLayout paramBasePluginLayout)
  {
    AppMethodBeat.i(282093);
    this.UqP = paramBasePluginLayout;
    AppMethodBeat.o(282093);
  }
  
  private final void a(boolean paramBoolean, HashMap<String, Pair<Integer, Long>> paramHashMap)
  {
    AppMethodBeat.i(282146);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("count", paramHashMap.size());
    StringBuffer localStringBuffer = new StringBuffer();
    paramHashMap = paramHashMap.values();
    s.s(paramHashMap, "labelMap.values");
    paramHashMap = ((Iterable)paramHashMap).iterator();
    while (paramHashMap.hasNext())
    {
      Pair localPair = (Pair)paramHashMap.next();
      localStringBuffer.append(localPair.first + '#');
    }
    ((JSONObject)localObject).put("labelList", localStringBuffer);
    int i;
    if (paramBoolean)
    {
      i = 1;
      ((JSONObject)localObject).put("enable", i);
      paramHashMap = (kc)this.UqZ;
      if (paramHashMap != null)
      {
        localObject = ((JSONObject)localObject).toString();
        s.s(localObject, "json.toString()");
        paramHashMap.sL(n.bV((String)localObject, ",", ";"));
      }
      localObject = dgV();
      paramHashMap = (kc)this.UqZ;
      if (paramHashMap != null) {
        break label215;
      }
    }
    label215:
    for (paramHashMap = null;; paramHashMap = paramHashMap.iVI)
    {
      Log.i((String)localObject, s.X("filterInfo:", paramHashMap));
      AppMethodBeat.o(282146);
      return;
      i = 0;
      break;
    }
  }
  
  private final void hUC()
  {
    long l = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(282111);
    Object localObject1 = (kc)this.UqZ;
    kc localkc;
    if (localObject1 != null)
    {
      localObject3 = (af)this.UqP.bZ(af.class);
      if (localObject3 == null) {
        ((kc)localObject1).iVz = l;
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)this.UqP.bZ(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (localObject1 == null) {
        break label363;
      }
      localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).Uaw;
      if (localObject1 == null) {
        break label363;
      }
      localObject3 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d((j)localObject1);
      localkc = (kc)this.UqZ;
      if (localkc != null)
      {
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)this.UqP.bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 != null) {
          break label322;
        }
        localObject1 = null;
        label123:
        localkc.sH((String)localObject1);
      }
      localkc = (kc)this.UqZ;
      if (localkc != null)
      {
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)this.UqP.bZ(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 != null) {
          break label338;
        }
      }
    }
    label322:
    label338:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).L(((ac)localObject3).hRb(), false))
    {
      localkc.sI((String)localObject1);
      localObject1 = (kc)this.UqZ;
      if (localObject1 != null) {
        ((kc)localObject1).sJ(((ac)localObject3).hRc());
      }
      localObject1 = (kc)this.UqZ;
      if (localObject1 != null) {
        ((kc)localObject1).sK(((ac)localObject3).hRd());
      }
      localObject3 = (Iterable)((ac)localObject3).TDz;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add(((ad)((Iterator)localObject3).next()).UaH);
      }
      localObject3 = ((af)localObject3).UjU;
      if (localObject3 == null) {
        break;
      }
      l = ((VLogThumbView)localObject3).getScrollCount();
      break;
      localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).K(((ac)localObject3).hRb(), false);
      break label123;
    }
    lT((List)localObject1);
    label363:
    Object localObject3 = (kc)this.UqZ;
    if (localObject3 != null)
    {
      localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)this.UqP.bZ(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
      if (localObject1 != null) {
        break label463;
      }
    }
    label463:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject1).hTK())
    {
      ((kc)localObject3).sG((String)localObject1);
      localObject1 = (kc)this.UqZ;
      if (localObject1 != null) {
        ((kc)localObject1).ipV = 101L;
      }
      boolean bool = this.Ugg;
      localObject1 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
      a(bool, com.tencent.mm.plugin.vlog.model.local.a.hRx());
      hUE();
      reset();
      AppMethodBeat.o(282111);
      return;
    }
  }
  
  private final void lT(List<? extends MediaEditReportInfo.EditItem> paramList)
  {
    AppMethodBeat.i(282135);
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    int i;
    if (((Iterator)localObject2).hasNext())
    {
      if (((MediaEditReportInfo.EditItem)((Iterator)localObject2).next()).isBeauty) {}
      for (i = 1;; i = 0)
      {
        ((Collection)localObject1).add(Integer.valueOf(i));
        break;
      }
    }
    localObject1 = p.a((Iterable)localObject1, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject3 = (Iterable)paramList;
    localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Integer.valueOf(Util.videoMsToSec(((MediaEditReportInfo.EditItem)((Iterator)localObject3).next()).targetDuration)));
    }
    localObject2 = p.a((Iterable)localObject2, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject4 = (Iterable)paramList;
    localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext()) {
      ((Collection)localObject3).add(Integer.valueOf(Util.videoMsToSec(((MediaEditReportInfo.EditItem)((Iterator)localObject4).next()).originDuration)));
    }
    localObject3 = p.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject5 = (Iterable)paramList;
    localObject4 = (Collection)new ArrayList(p.a((Iterable)localObject5, 10));
    localObject5 = ((Iterable)localObject5).iterator();
    while (((Iterator)localObject5).hasNext()) {
      ((Collection)localObject4).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject5).next()).dragCount));
    }
    localObject4 = p.a((Iterable)localObject4, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject6 = (Iterable)paramList;
    localObject5 = (Collection)new ArrayList(p.a((Iterable)localObject6, 10));
    localObject6 = ((Iterable)localObject6).iterator();
    while (((Iterator)localObject6).hasNext()) {
      ((Collection)localObject5).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject6).next()).scaleCount));
    }
    localObject5 = p.a((Iterable)localObject5, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject7 = (Iterable)paramList;
    localObject6 = (Collection)new ArrayList(p.a((Iterable)localObject7, 10));
    localObject7 = ((Iterable)localObject7).iterator();
    while (((Iterator)localObject7).hasNext()) {
      ((Collection)localObject6).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject7).next()).clickEditCount));
    }
    localObject6 = p.a((Iterable)localObject6, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject8 = (Iterable)paramList;
    localObject7 = (Collection)new ArrayList(p.a((Iterable)localObject8, 10));
    localObject8 = ((Iterable)localObject8).iterator();
    while (((Iterator)localObject8).hasNext()) {
      ((Collection)localObject7).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject8).next()).durationCutCount));
    }
    localObject7 = p.a((Iterable)localObject7, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject9 = (Iterable)paramList;
    localObject8 = (Collection)new ArrayList(p.a((Iterable)localObject9, 10));
    localObject9 = ((Iterable)localObject9).iterator();
    while (((Iterator)localObject9).hasNext()) {
      ((Collection)localObject8).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject9).next()).durationScrollCount));
    }
    localObject8 = p.a((Iterable)localObject8, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject10 = (Iterable)paramList;
    localObject9 = (Collection)new ArrayList(p.a((Iterable)localObject10, 10));
    localObject10 = ((Iterable)localObject10).iterator();
    if (((Iterator)localObject10).hasNext())
    {
      MediaEditReportInfo.EditItem localEditItem = (MediaEditReportInfo.EditItem)((Iterator)localObject10).next();
      if (localEditItem.targetDuration < localEditItem.originDuration) {}
      for (i = 1;; i = 0)
      {
        ((Collection)localObject9).add(Integer.valueOf(i));
        break;
      }
    }
    localObject9 = p.a((Iterable)localObject9, (CharSequence)"#", null, null, 0, null, null, 62);
    localObject10 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject10, 10));
    localObject10 = ((Iterable)localObject10).iterator();
    while (((Iterator)localObject10).hasNext()) {
      paramList.add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject10).next()).type));
    }
    paramList = p.a((Iterable)paramList, (CharSequence)"#", null, null, 0, null, null, 62);
    localObject10 = (kc)this.UqZ;
    if (localObject10 != null) {
      ((kc)localObject10).sv((String)localObject1);
    }
    localObject1 = (kc)this.UqZ;
    if (localObject1 != null) {
      ((kc)localObject1).sw((String)localObject2);
    }
    localObject1 = (kc)this.UqZ;
    if (localObject1 != null) {
      ((kc)localObject1).sx((String)localObject3);
    }
    localObject1 = (kc)this.UqZ;
    if (localObject1 != null) {
      ((kc)localObject1).sz((String)localObject4);
    }
    localObject1 = (kc)this.UqZ;
    if (localObject1 != null) {
      ((kc)localObject1).sA((String)localObject5);
    }
    localObject1 = (kc)this.UqZ;
    if (localObject1 != null) {
      ((kc)localObject1).sB((String)localObject6);
    }
    localObject1 = (kc)this.UqZ;
    if (localObject1 != null) {
      ((kc)localObject1).sC((String)localObject7);
    }
    localObject1 = (kc)this.UqZ;
    if (localObject1 != null) {
      ((kc)localObject1).sD((String)localObject8);
    }
    localObject1 = (kc)this.UqZ;
    if (localObject1 != null) {
      ((kc)localObject1).sE((String)localObject9);
    }
    localObject1 = (kc)this.UqZ;
    if (localObject1 != null) {
      ((kc)localObject1).sF(paramList);
    }
    AppMethodBeat.o(282135);
  }
  
  private void reset()
  {
    AppMethodBeat.i(282099);
    this.UqZ = null;
    this.UqZ = ((com.tencent.mm.plugin.report.a)new kc());
    kc localkc = (kc)this.UqZ;
    if (localkc != null) {
      localkc.sy("");
    }
    localkc = (kc)this.UqZ;
    if (localkc != null) {
      localkc.su("");
    }
    AppMethodBeat.o(282099);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(282176);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(282176);
      return;
    case 1: 
      paramc = (kc)this.UqZ;
      if (paramc != null) {
        paramc.iVB = 2L;
      }
      hUC();
      AppMethodBeat.o(282176);
      return;
    }
    if (paramBundle == null) {}
    for (;;)
    {
      this.Ugg = bool;
      break;
      bool = paramBundle.getBoolean("PARAM_1_BOOLEAN", false);
    }
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(282202);
    kc localkc = (kc)this.UqZ;
    if (localkc != null) {
      if (paramXEffectConfig != null) {
        break label37;
      }
    }
    label37:
    for (paramXEffectConfig = null;; paramXEffectConfig = paramXEffectConfig.mxQ)
    {
      localkc.sM(paramXEffectConfig);
      AppMethodBeat.o(282202);
      return;
    }
  }
  
  public final void ak(Intent paramIntent)
  {
    AppMethodBeat.i(282167);
    s.u(paramIntent, "intent");
    this.UqZ = ((com.tencent.mm.plugin.report.a)new kc());
    paramIntent = (kc)this.UqZ;
    if (paramIntent != null) {
      paramIntent.sy("");
    }
    paramIntent = (kc)this.UqZ;
    if (paramIntent != null) {
      paramIntent.su("");
    }
    AppMethodBeat.o(282167);
  }
  
  public final void bfy(String paramString)
  {
    AppMethodBeat.i(282197);
    s.u(paramString, "postId");
    kc localkc = (kc)this.UqZ;
    if (localkc != null) {
      localkc.ss(paramString);
    }
    AppMethodBeat.o(282197);
  }
  
  public final String hUA()
  {
    return "19904";
  }
  
  public final void hUB()
  {
    AppMethodBeat.i(282185);
    super.hUB();
    kc localkc = (kc)this.UqZ;
    if (localkc != null) {
      localkc.iVB = 1L;
    }
    hUC();
    AppMethodBeat.o(282185);
  }
  
  public final void setEditId(String paramString)
  {
    AppMethodBeat.i(282192);
    s.u(paramString, "editId");
    kc localkc = (kc)this.UqZ;
    if (localkc != null) {
      localkc.st(paramString);
    }
    AppMethodBeat.o(282192);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport19904$Companion;", "", "()V", "ExitBack", "", "ExitNextStep", "ReportID", "", "TypeImage", "", "TypeVideo", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a
 * JD-Core Version:    0.7.0.1
 */