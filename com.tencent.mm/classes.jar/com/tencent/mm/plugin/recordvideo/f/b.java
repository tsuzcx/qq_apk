package com.tencent.mm.plugin.recordvideo.f;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kc;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport;", "", "()V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;)V", "report", "", "reset", "setBeautyConfig", "config", "Lcom/tencent/mm/plugin/xlabeffect/XEffectConfig;", "setEditItemList", "editList", "", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "isAllImage", "", "setVideoLabel", "enable", "labelMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "", "Lkotlin/collections/HashMap;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a NRd;
  public kc NRe;
  
  static
  {
    AppMethodBeat.i(279417);
    NRd = new b.a((byte)0);
    AppMethodBeat.o(279417);
  }
  
  public b()
  {
    AppMethodBeat.i(279412);
    this.NRe = new kc();
    reset();
    AppMethodBeat.o(279412);
  }
  
  public final void A(List<? extends MediaEditReportInfo.EditItem> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(279426);
    s.u(paramList, "editList");
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
    localObject2 = p.a((Iterable)localObject2, (CharSequence)"#", null, null, 0, null, null, 62);
    Object localObject4 = (Iterable)paramList;
    localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
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
    this.NRe.sv((String)localObject1);
    this.NRe.sw((String)localObject2);
    this.NRe.sx((String)localObject3);
    this.NRe.sz((String)localObject4);
    this.NRe.sA((String)localObject5);
    this.NRe.sB((String)localObject6);
    this.NRe.sC((String)localObject7);
    this.NRe.sD((String)localObject8);
    this.NRe.sE((String)localObject9);
    this.NRe.sF(paramList);
    this.NRe.ipV = 101L;
    AppMethodBeat.o(279426);
  }
  
  public final void a(XEffectConfig paramXEffectConfig)
  {
    AppMethodBeat.i(279434);
    kc localkc = this.NRe;
    if (paramXEffectConfig == null) {}
    for (paramXEffectConfig = null;; paramXEffectConfig = paramXEffectConfig.mxQ)
    {
      localkc.sM(paramXEffectConfig);
      AppMethodBeat.o(279434);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, HashMap<String, Pair<Integer, Long>> paramHashMap)
  {
    AppMethodBeat.i(279431);
    s.u(paramHashMap, "labelMap");
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
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((JSONObject)localObject).put("enable", i);
      paramHashMap = this.NRe;
      localObject = ((JSONObject)localObject).toString();
      s.s(localObject, "json.toString()");
      paramHashMap.sL(n.bV((String)localObject, ",", ";"));
      Log.i("MicroMsg.MultiMediaEditReport", s.X("filterInfo:", this.NRe.iVI));
      AppMethodBeat.o(279431);
      return;
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(279436);
    this.NRe.bMH();
    AppMethodBeat.o(279436);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(279440);
    this.NRe = new kc();
    this.NRe.sy("");
    this.NRe.su("");
    AppMethodBeat.o(279440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.f.b
 * JD-Core Version:    0.7.0.1
 */