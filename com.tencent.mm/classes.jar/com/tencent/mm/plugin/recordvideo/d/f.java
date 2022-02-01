package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.im;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport;", "", "()V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditInfoStruct;)V", "report", "", "reset", "setEditItemList", "editList", "", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "isAllImage", "", "Companion", "plugin-recordvideo_release"})
public final class f
{
  public static final a LoP;
  public im LoO;
  
  static
  {
    AppMethodBeat.i(204240);
    LoP = new a((byte)0);
    AppMethodBeat.o(204240);
  }
  
  public f()
  {
    AppMethodBeat.i(204239);
    this.LoO = new im();
    reset();
    AppMethodBeat.o(204239);
  }
  
  public final void r(List<? extends MediaEditReportInfo.EditItem> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(204237);
    k.h(paramList, "editList");
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
      for (i = 0;; i = bt.vN(((MediaEditReportInfo.EditItem)localObject4).targetDuration))
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
      for (i = 0;; i = bt.vN(((MediaEditReportInfo.EditItem)localObject5).originDuration))
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
    this.LoO.aTt((String)localObject1);
    this.LoO.aTu((String)localObject2);
    this.LoO.aTv((String)localObject3);
    this.LoO.aTx((String)localObject4);
    this.LoO.aTy((String)localObject5);
    this.LoO.aTz((String)localObject6);
    this.LoO.aTA((String)localObject7);
    this.LoO.aTB((String)localObject8);
    this.LoO.aTC((String)localObject9);
    this.LoO.aTD(paramList);
    AppMethodBeat.o(204237);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(204238);
    this.LoO = new im();
    this.LoO.aTw("");
    this.LoO.aTs("");
    AppMethodBeat.o(204238);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/report/MultiMediaEditReport$Companion;", "", "()V", "ExitBack", "", "ExitNextStep", "TypeImage", "", "TypeVideo", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.f
 * JD-Core Version:    0.7.0.1
 */