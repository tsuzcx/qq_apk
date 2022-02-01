package com.tencent.mm.plugin.recordvideo.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.hy;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport;", "", "()V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;)V", "report", "", "reset", "setBeautyConfig", "config", "Lcom/tencent/mm/plugin/xlabeffect/XEffectConfig;", "setEditItemList", "editList", "", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "isAllImage", "", "setVideoLabel", "enable", "labelMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "", "Lkotlin/collections/HashMap;", "Companion", "plugin-recordvideo_release"})
public final class b
{
  public static final a HUm;
  public hy HUl;
  
  static
  {
    AppMethodBeat.i(220969);
    HUm = new a((byte)0);
    AppMethodBeat.o(220969);
  }
  
  public b()
  {
    AppMethodBeat.i(220967);
    this.HUl = new hy();
    reset();
    AppMethodBeat.o(220967);
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(220950);
    hy localhy = this.HUl;
    if (paramXEffectConfig != null) {}
    for (paramXEffectConfig = paramXEffectConfig.jXW;; paramXEffectConfig = null)
    {
      localhy.xy(paramXEffectConfig);
      AppMethodBeat.o(220950);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, HashMap<String, Pair<Integer, Long>> paramHashMap)
  {
    AppMethodBeat.i(220948);
    p.k(paramHashMap, "labelMap");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("count", paramHashMap.size());
    StringBuffer localStringBuffer = new StringBuffer();
    paramHashMap = paramHashMap.values();
    p.j(paramHashMap, "labelMap.values");
    paramHashMap = ((Iterable)paramHashMap).iterator();
    while (paramHashMap.hasNext())
    {
      Pair localPair = (Pair)paramHashMap.next();
      localStringBuffer.append((Integer)localPair.first + '#');
    }
    ((JSONObject)localObject).put("labelList", localStringBuffer);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((JSONObject)localObject).put("enable", i);
      paramHashMap = this.HUl;
      localObject = ((JSONObject)localObject).toString();
      p.j(localObject, "json.toString()");
      paramHashMap.xx(n.l((String)localObject, ",", ";", false));
      Log.i("MicroMsg.MultiMediaEditReport", "filterInfo:" + this.HUl.alN());
      AppMethodBeat.o(220948);
      return;
    }
  }
  
  public final void m(List<? extends MediaEditReportInfo.EditItem> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(220942);
    p.k(paramList, "editList");
    Object localObject2 = (Iterable)paramList;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
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
    localObject1 = j.a((Iterable)localObject1, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject3 = (Iterable)paramList;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (MediaEditReportInfo.EditItem)((Iterator)localObject3).next();
      if (paramBoolean) {}
      for (i = 0;; i = Util.videoMsToSec(((MediaEditReportInfo.EditItem)localObject4).targetDuration))
      {
        ((Collection)localObject2).add(Integer.valueOf(i));
        break;
      }
    }
    localObject2 = j.a((Iterable)localObject2, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject4 = (Iterable)paramList;
    localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      localObject5 = (MediaEditReportInfo.EditItem)((Iterator)localObject4).next();
      if (paramBoolean) {}
      for (i = 0;; i = Util.videoMsToSec(((MediaEditReportInfo.EditItem)localObject5).originDuration))
      {
        ((Collection)localObject3).add(Integer.valueOf(i));
        break;
      }
    }
    localObject3 = j.a((Iterable)localObject3, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject5 = (Iterable)paramList;
    localObject4 = (Collection)new ArrayList(j.a((Iterable)localObject5, 10));
    localObject5 = ((Iterable)localObject5).iterator();
    while (((Iterator)localObject5).hasNext()) {
      ((Collection)localObject4).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject5).next()).dragCount));
    }
    localObject4 = j.a((Iterable)localObject4, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject6 = (Iterable)paramList;
    localObject5 = (Collection)new ArrayList(j.a((Iterable)localObject6, 10));
    localObject6 = ((Iterable)localObject6).iterator();
    while (((Iterator)localObject6).hasNext()) {
      ((Collection)localObject5).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject6).next()).scaleCount));
    }
    localObject5 = j.a((Iterable)localObject5, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject7 = (Iterable)paramList;
    localObject6 = (Collection)new ArrayList(j.a((Iterable)localObject7, 10));
    localObject7 = ((Iterable)localObject7).iterator();
    while (((Iterator)localObject7).hasNext()) {
      ((Collection)localObject6).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject7).next()).clickEditCount));
    }
    localObject6 = j.a((Iterable)localObject6, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject8 = (Iterable)paramList;
    localObject7 = (Collection)new ArrayList(j.a((Iterable)localObject8, 10));
    localObject8 = ((Iterable)localObject8).iterator();
    while (((Iterator)localObject8).hasNext()) {
      ((Collection)localObject7).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject8).next()).durationCutCount));
    }
    localObject7 = j.a((Iterable)localObject7, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject9 = (Iterable)paramList;
    localObject8 = (Collection)new ArrayList(j.a((Iterable)localObject9, 10));
    localObject9 = ((Iterable)localObject9).iterator();
    while (((Iterator)localObject9).hasNext()) {
      ((Collection)localObject8).add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject9).next()).durationScrollCount));
    }
    localObject8 = j.a((Iterable)localObject8, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject10 = (Iterable)paramList;
    localObject9 = (Collection)new ArrayList(j.a((Iterable)localObject10, 10));
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
    localObject9 = j.a((Iterable)localObject9, (CharSequence)"#", null, null, 0, null, null, 62);
    localObject10 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject10, 10));
    localObject10 = ((Iterable)localObject10).iterator();
    while (((Iterator)localObject10).hasNext()) {
      paramList.add(Integer.valueOf(((MediaEditReportInfo.EditItem)((Iterator)localObject10).next()).type));
    }
    paramList = j.a((Iterable)paramList, (CharSequence)"#", null, null, 0, null, null, 62);
    this.HUl.xh((String)localObject1);
    this.HUl.xi((String)localObject2);
    this.HUl.xj((String)localObject3);
    this.HUl.xl((String)localObject4);
    this.HUl.xm((String)localObject5);
    this.HUl.xn((String)localObject6);
    this.HUl.xo((String)localObject7);
    this.HUl.xp((String)localObject8);
    this.HUl.xq((String)localObject9);
    this.HUl.xr(paramList);
    this.HUl.sd(101L);
    AppMethodBeat.o(220942);
  }
  
  public final void report()
  {
    AppMethodBeat.i(220953);
    this.HUl.bpa();
    AppMethodBeat.o(220953);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(220959);
    this.HUl = new hy();
    this.HUl.xk("");
    this.HUl.xg("");
    AppMethodBeat.o(220959);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport$Companion;", "", "()V", "ExitBack", "", "ExitNextStep", "TAG", "", "TypeImage", "", "TypeVideo", "beautyConfigToJson", "config", "Lcom/tencent/mm/plugin/xlabeffect/XEffectConfig;", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.b
 * JD-Core Version:    0.7.0.1
 */