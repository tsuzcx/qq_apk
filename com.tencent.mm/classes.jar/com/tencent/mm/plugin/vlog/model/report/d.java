package com.tencent.mm.plugin.vlog.model.report;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.hz;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/VideoEditResultReport;", "", "()V", "reportJson", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "getReportJson", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "setReportJson", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;)V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;)V", "fillReportMem", "", "report", "setAction", "action", "", "setComposition", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setEditItem", "itemList", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "setSourceType", "source", "setTemplateId", "templateId", "", "setTemplateResourceReady", "ready", "", "Companion", "plugin-vlog_release"})
public final class d
{
  public static final a NoW;
  public hz NoU;
  private c NoV;
  
  static
  {
    AppMethodBeat.i(224428);
    NoW = new a((byte)0);
    AppMethodBeat.o(224428);
  }
  
  public d()
  {
    AppMethodBeat.i(224425);
    this.NoU = new hz();
    this.NoV = new c();
    AppMethodBeat.o(224425);
  }
  
  public final void Sq(long paramLong)
  {
    AppMethodBeat.i(224413);
    this.NoU.si(paramLong);
    AppMethodBeat.o(224413);
  }
  
  public final void Sr(long paramLong)
  {
    AppMethodBeat.i(224415);
    this.NoU.sj(paramLong);
    AppMethodBeat.o(224415);
  }
  
  public final void c(ac paramac)
  {
    long l5 = 0L;
    AppMethodBeat.i(224403);
    p.k(paramac, "composition");
    this.NoV.xoX.clear();
    Object localObject1 = ((Iterable)paramac.MQY).iterator();
    long l1 = 0L;
    long l2 = 0L;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ad)((Iterator)localObject1).next();
      com.tencent.mm.plugin.vlog.report.c localc = com.tencent.mm.plugin.vlog.report.c.NqY;
      localObject2 = com.tencent.mm.plugin.vlog.report.c.b((ad)localObject2);
      long l3 = l1;
      long l4 = l2;
      if (localObject2 != null)
      {
        if (!(localObject2 instanceof c.d)) {
          break label134;
        }
        l1 += 1L;
      }
      for (;;)
      {
        this.NoV.xoX.add(localObject2);
        l4 = l2;
        l3 = l1;
        l1 = l3;
        l2 = l4;
        break;
        label134:
        l2 += 1L;
      }
    }
    this.NoU.ng(1);
    this.NoU.se(l2);
    this.NoU.sf(l1);
    localObject1 = this.NoU;
    l1 = l5;
    if (paramac.NmV) {
      l1 = 1L;
    }
    ((hz)localObject1).sk(l1);
    Log.i("MicroMsg.MultiMediaEditReport", "setComposition, isEnableVideoEnhancement:" + paramac.NmV);
    AppMethodBeat.o(224403);
  }
  
  public final void iG(List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(224411);
    p.k(paramList, "itemList");
    this.NoV.editList.clear();
    Iterator localIterator = ((Iterable)paramList).iterator();
    com.tencent.mm.plugin.recordvideo.ui.editor.item.a locala;
    c.a locala1;
    c.b localb;
    if (localIterator.hasNext())
    {
      locala = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localIterator.next();
      if (locala.Ibt == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbG)
      {
        locala1 = (c.a)new c.b();
        localb = (c.b)locala1;
        if ((locala instanceof r)) {
          break label344;
        }
      }
    }
    label339:
    label344:
    for (Object localObject = null;; localObject = locala)
    {
      localObject = (r)localObject;
      String str;
      if (localObject != null)
      {
        str = ((r)localObject).IbE;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localObject = new q((String)localObject).getName();
      p.j(localObject, "VFSFile((it as? TextItem)?.font ?: \"\").name");
      localb.setFont((String)localObject);
      localObject = locala1;
      ((c.a)localObject).type = locala.Ibt.value;
      ((c.a)localObject).NoN.add(Long.valueOf(locala.Ibr.Ido.getTime()));
      ((c.a)localObject).NoN.add(Long.valueOf(locala.Ibr.Idp.getTime()));
      this.NoV.editList.add(localObject);
      break;
      if (locala.Ibt == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbL)
      {
        locala1 = (c.a)new c.b();
        localb = (c.b)locala1;
        if ((locala instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.c)) {
          break label339;
        }
      }
      for (localObject = null;; localObject = locala)
      {
        localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject;
        if (localObject != null)
        {
          str = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject).IbE;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localObject = new q((String)localObject).getName();
        p.j(localObject, "VFSFile((it as? CaptionItem)?.font ?: \"\").name");
        localb.setFont((String)localObject);
        localObject = locala1;
        break;
        localObject = new c.a();
        break;
        this.NoU.sg(paramList.size());
        AppMethodBeat.o(224411);
        return;
      }
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(224423);
    Object localObject1 = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(224423);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((ActivityManager)localObject1).getProcessMemoryInfo(new int[] { Process.myPid() });
    if (localObject2 != null) {}
    for (int i = localObject2.length;; i = 0)
    {
      if (i > 0)
      {
        localObject1 = this.NoV.NoL;
        localObject2 = localObject2[0];
        p.j(localObject2, "memInfos[0]");
        ((c.c)localObject1).NoO = ((Debug.MemoryInfo)localObject2).getTotalPss();
      }
      localObject1 = com.tencent.mm.videocomposition.a.YHM;
      localObject2 = com.tencent.mm.videocomposition.a.fgL().snapshot();
      this.NoV.NoL.NoP = ((Map)localObject2).size();
      localObject1 = this.NoV.NoL;
      localObject2 = ((Iterable)((Map)localObject2).values()).iterator();
      Bitmap localBitmap;
      for (i = 0; ((Iterator)localObject2).hasNext(); i = localBitmap.getAllocationByteCount() + i)
      {
        localBitmap = (Bitmap)((Iterator)localObject2).next();
        p.j(localBitmap, "it");
      }
    }
    ((c.c)localObject1).NoQ = i;
    localObject1 = this.NoV.toJson().toString();
    p.j(localObject1, "reportJson.toJson().toString()");
    localObject1 = n.l((String)localObject1, ",", ";", false);
    this.NoU.xA((String)localObject1);
    Log.i("MicroMsg.MultiMediaEditReport", "report: " + this.NoU.agI());
    this.NoU.bpa();
    this.NoU = new hz();
    this.NoV = new c();
    AppMethodBeat.o(224423);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/VideoEditResultReport$Companion;", "", "()V", "ACTION_EXIT", "", "ACTION_NEXT", "SOURCE_MUSIC_FOLLOW", "SOURCE_OTHER", "SOURCE_TEMPLATE_FOLLOW", "SOURCE_TEMPLATE_POST", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.d
 * JD-Core Version:    0.7.0.1
 */