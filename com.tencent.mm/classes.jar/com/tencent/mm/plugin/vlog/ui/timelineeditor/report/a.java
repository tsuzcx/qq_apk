package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.hy;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.ag;
import com.tencent.mm.plugin.vlog.ui.widget.VLogThumbView;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport19904;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;)V", "isVideoEnhancementEnable", "", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "setPluginLayout", "init", "", "packageReportData", "prepareBackPress", "reportId", "", "reset", "setBeautyConfig", "config", "Lcom/tencent/mm/plugin/xlabeffect/XEffectConfig;", "setEditId", "editId", "setEditItemList", "editList", "", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "isAllImage", "setPostId", "postId", "setVideoLabel", "enable", "labelMap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "", "", "Lkotlin/collections/HashMap;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public final class a
  extends g<hy>
{
  public static final a NEE;
  private BasePluginLayout NED;
  private boolean Nsu;
  
  static
  {
    AppMethodBeat.i(225546);
    NEE = new a((byte)0);
    AppMethodBeat.o(225546);
  }
  
  public a(BasePluginLayout paramBasePluginLayout)
  {
    AppMethodBeat.i(225543);
    this.NED = paramBasePluginLayout;
    AppMethodBeat.o(225543);
  }
  
  private final void a(boolean paramBoolean, HashMap<String, Pair<Integer, Long>> paramHashMap)
  {
    AppMethodBeat.i(225539);
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("count", paramHashMap.size());
    Object localObject2 = new StringBuffer();
    paramHashMap = paramHashMap.values();
    p.j(paramHashMap, "labelMap.values");
    paramHashMap = ((Iterable)paramHashMap).iterator();
    while (paramHashMap.hasNext())
    {
      Pair localPair = (Pair)paramHashMap.next();
      ((StringBuffer)localObject2).append((Integer)localPair.first + '#');
    }
    ((JSONObject)localObject1).put("labelList", localObject2);
    int i;
    if (paramBoolean)
    {
      i = 1;
      ((JSONObject)localObject1).put("enable", i);
      paramHashMap = (hy)this.NEK;
      if (paramHashMap != null)
      {
        localObject1 = ((JSONObject)localObject1).toString();
        p.j(localObject1, "json.toString()");
        paramHashMap.xx(n.l((String)localObject1, ",", ";", false));
      }
      localObject1 = gwG();
      localObject2 = new StringBuilder("filterInfo:");
      paramHashMap = (hy)this.NEK;
      if (paramHashMap == null) {
        break label236;
      }
    }
    label236:
    for (paramHashMap = paramHashMap.alN();; paramHashMap = null)
    {
      Log.i((String)localObject1, paramHashMap);
      AppMethodBeat.o(225539);
      return;
      i = 0;
      break;
    }
  }
  
  private final void gwE()
  {
    Object localObject2 = null;
    AppMethodBeat.i(225516);
    Object localObject1 = (hy)this.NEK;
    long l;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject3 = (ag)this.NED.bp(ag.class);
      if (localObject3 != null)
      {
        localObject3 = ((ag)localObject3).NwM;
        if (localObject3 != null)
        {
          l = ((VLogThumbView)localObject3).getScrollCount();
          ((hy)localObject1).sa(l);
        }
      }
    }
    else
    {
      localObject1 = (com.tencent.mm.plugin.vlog.ui.timelineeditor.b)this.NED.bp(com.tencent.mm.plugin.vlog.ui.timelineeditor.b.class);
      if (localObject1 == null) {
        break label364;
      }
      localObject1 = ((com.tencent.mm.plugin.vlog.ui.timelineeditor.b)localObject1).NmT;
      if (localObject1 == null) {
        break label364;
      }
      localObject3 = com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a.d((com.tencent.mm.videocomposition.j)localObject1);
      localObject4 = (hy)this.NEK;
      if (localObject4 != null)
      {
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)this.NED.bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 == null) {
          break label343;
        }
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).w(((ac)localObject3).gtA(), false);
        label151:
        ((hy)localObject4).xt((String)localObject1);
      }
      localObject4 = (hy)this.NEK;
      if (localObject4 != null)
      {
        localObject1 = (com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)this.NED.bp(com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a.class);
        if (localObject1 == null) {
          break label349;
        }
      }
    }
    label343:
    label349:
    for (localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.timeedit.a)localObject1).x(((ac)localObject3).gtA(), false);; localObject1 = null)
    {
      ((hy)localObject4).xu((String)localObject1);
      localObject1 = (hy)this.NEK;
      if (localObject1 != null) {
        ((hy)localObject1).xv(((ac)localObject3).gtB());
      }
      localObject1 = (hy)this.NEK;
      if (localObject1 != null) {
        ((hy)localObject1).xw(((ac)localObject3).gtC());
      }
      localObject3 = (Iterable)((ac)localObject3).MQY;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add(((ad)((Iterator)localObject3).next()).Nnf);
      }
      l = 0L;
      break;
      localObject1 = null;
      break label151;
    }
    iL((List)localObject1);
    label364:
    Object localObject3 = (hy)this.NEK;
    if (localObject3 != null)
    {
      localObject4 = (com.tencent.mm.plugin.vlog.ui.plugin.caption.b)this.NED.bp(com.tencent.mm.plugin.vlog.ui.plugin.caption.b.class);
      localObject1 = localObject2;
      if (localObject4 != null) {
        localObject1 = ((com.tencent.mm.plugin.vlog.ui.plugin.caption.b)localObject4).gvV();
      }
      ((hy)localObject3).xs((String)localObject1);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null) {
      ((hy)localObject1).sd(101L);
    }
    boolean bool = this.Nsu;
    localObject1 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    a(bool, com.tencent.mm.plugin.vlog.model.local.a.gtP());
    gwH();
    reset();
    AppMethodBeat.o(225516);
  }
  
  private final void iL(List<? extends MediaEditReportInfo.EditItem> paramList)
  {
    AppMethodBeat.i(225533);
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
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
    localObject1 = kotlin.a.j.a((Iterable)localObject1, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject3 = (Iterable)paramList;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Integer.valueOf(Util.videoMsToSec(((MediaEditReportInfo.EditItem)((Iterator)localObject3).next()).targetDuration)));
    }
    localObject2 = kotlin.a.j.a((Iterable)localObject2, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject4 = (Iterable)paramList;
    localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext()) {
      ((Collection)localObject3).add(Integer.valueOf(Util.videoMsToSec(((MediaEditReportInfo.EditItem)((Iterator)localObject4).next()).originDuration)));
    }
    localObject3 = kotlin.a.j.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject5 = (Iterable)paramList;
    localObject4 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject5, 10));
    localObject5 = ((Iterable)localObject5).iterator();
    while (((Iterator)localObject5).hasNext()) {
      ((Collection)localObject4).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject5).next()).dragCount));
    }
    localObject4 = kotlin.a.j.a((Iterable)localObject4, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject6 = (Iterable)paramList;
    localObject5 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject6, 10));
    localObject6 = ((Iterable)localObject6).iterator();
    while (((Iterator)localObject6).hasNext()) {
      ((Collection)localObject5).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject6).next()).scaleCount));
    }
    localObject5 = kotlin.a.j.a((Iterable)localObject5, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject7 = (Iterable)paramList;
    localObject6 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject7, 10));
    localObject7 = ((Iterable)localObject7).iterator();
    while (((Iterator)localObject7).hasNext()) {
      ((Collection)localObject6).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject7).next()).clickEditCount));
    }
    localObject6 = kotlin.a.j.a((Iterable)localObject6, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject8 = (Iterable)paramList;
    localObject7 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject8, 10));
    localObject8 = ((Iterable)localObject8).iterator();
    while (((Iterator)localObject8).hasNext()) {
      ((Collection)localObject7).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject8).next()).durationCutCount));
    }
    localObject7 = kotlin.a.j.a((Iterable)localObject7, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject9 = (Iterable)paramList;
    localObject8 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject9, 10));
    localObject9 = ((Iterable)localObject9).iterator();
    while (((Iterator)localObject9).hasNext()) {
      ((Collection)localObject8).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject9).next()).durationScrollCount));
    }
    localObject8 = kotlin.a.j.a((Iterable)localObject8, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject10 = (Iterable)paramList;
    localObject9 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject10, 10));
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
    localObject9 = kotlin.a.j.a((Iterable)localObject9, (CharSequence)"#", null, null, 0, null, null, 62);
    localObject10 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject10, 10));
    localObject10 = ((Iterable)localObject10).iterator();
    while (((Iterator)localObject10).hasNext()) {
      paramList.add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject10).next()).type));
    }
    paramList = kotlin.a.j.a((Iterable)paramList, (CharSequence)"#", null, null, 0, null, null, 62);
    localObject10 = (hy)this.NEK;
    if (localObject10 != null) {
      ((hy)localObject10).xh((String)localObject1);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null) {
      ((hy)localObject1).xi((String)localObject2);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null) {
      ((hy)localObject1).xj((String)localObject3);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null) {
      ((hy)localObject1).xl((String)localObject4);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null) {
      ((hy)localObject1).xm((String)localObject5);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null) {
      ((hy)localObject1).xn((String)localObject6);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null) {
      ((hy)localObject1).xo((String)localObject7);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null) {
      ((hy)localObject1).xp((String)localObject8);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null) {
      ((hy)localObject1).xq((String)localObject9);
    }
    localObject1 = (hy)this.NEK;
    if (localObject1 != null)
    {
      ((hy)localObject1).xr(paramList);
      AppMethodBeat.o(225533);
      return;
    }
    AppMethodBeat.o(225533);
  }
  
  private void reset()
  {
    AppMethodBeat.i(225506);
    this.NEK = null;
    init();
    AppMethodBeat.o(225506);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(225508);
    p.k(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(225508);
      return;
      paramc = (hy)this.NEK;
      if (paramc != null) {
        paramc.sc(2L);
      }
      gwE();
      AppMethodBeat.o(225508);
      return;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("PARAM_1_BOOLEAN", false);
      }
      this.Nsu = bool;
    }
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(225541);
    hy localhy = (hy)this.NEK;
    if (localhy != null)
    {
      if (paramXEffectConfig != null) {}
      for (paramXEffectConfig = paramXEffectConfig.jXW;; paramXEffectConfig = null)
      {
        localhy.xy(paramXEffectConfig);
        AppMethodBeat.o(225541);
        return;
      }
    }
    AppMethodBeat.o(225541);
  }
  
  public final void bfS(String paramString)
  {
    AppMethodBeat.i(225521);
    p.k(paramString, "postId");
    hy localhy = (hy)this.NEK;
    if (localhy != null)
    {
      localhy.xe(paramString);
      AppMethodBeat.o(225521);
      return;
    }
    AppMethodBeat.o(225521);
  }
  
  public final String gwC()
  {
    return "19904";
  }
  
  public final void gwD()
  {
    AppMethodBeat.i(225509);
    super.gwD();
    hy localhy = (hy)this.NEK;
    if (localhy != null) {
      localhy.sc(1L);
    }
    gwE();
    AppMethodBeat.o(225509);
  }
  
  public final void init()
  {
    AppMethodBeat.i(225504);
    this.NEK = ((com.tencent.mm.plugin.report.a)new hy());
    hy localhy = (hy)this.NEK;
    if (localhy != null) {
      localhy.xk("");
    }
    localhy = (hy)this.NEK;
    if (localhy != null)
    {
      localhy.xg("");
      AppMethodBeat.o(225504);
      return;
    }
    AppMethodBeat.o(225504);
  }
  
  public final void setEditId(String paramString)
  {
    AppMethodBeat.i(225519);
    p.k(paramString, "editId");
    hy localhy = (hy)this.NEK;
    if (localhy != null)
    {
      localhy.xf(paramString);
      AppMethodBeat.o(225519);
      return;
    }
    AppMethodBeat.o(225519);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport19904$Companion;", "", "()V", "ExitBack", "", "ExitNextStep", "ReportID", "", "TypeImage", "", "TypeVideo", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.a
 * JD-Core Version:    0.7.0.1
 */