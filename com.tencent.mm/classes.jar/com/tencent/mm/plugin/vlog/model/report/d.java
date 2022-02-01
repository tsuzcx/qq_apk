package com.tencent.mm.plugin.vlog.model.report;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kd;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/VideoEditResultReport;", "", "()V", "reportJson", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "getReportJson", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "setReportJson", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;)V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;)V", "fillReportMem", "", "report", "setAction", "action", "", "setComposition", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setEditItem", "itemList", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "setSourceType", "source", "setTemplateId", "templateId", "", "setTemplateResourceReady", "ready", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a Ucw;
  public kd Ucx;
  private c Ucy;
  
  static
  {
    AppMethodBeat.i(283719);
    Ucw = new d.a((byte)0);
    AppMethodBeat.o(283719);
  }
  
  public d()
  {
    AppMethodBeat.i(283716);
    this.Ucx = new kd();
    this.Ucy = new c();
    AppMethodBeat.o(283716);
  }
  
  public final void c(ac paramac)
  {
    long l5 = 0L;
    AppMethodBeat.i(283727);
    s.u(paramac, "composition");
    this.Ucy.ofu.clear();
    Object localObject1 = ((Iterable)paramac.TDz).iterator();
    long l1 = 0L;
    long l2 = 0L;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ad)((Iterator)localObject1).next();
      com.tencent.mm.plugin.vlog.report.c localc = com.tencent.mm.plugin.vlog.report.c.UeI;
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
        this.Ucy.ofu.add(localObject2);
        l4 = l2;
        l3 = l1;
        l1 = l3;
        l2 = l4;
        break;
        label134:
        l2 += 1L;
      }
    }
    this.Ucx.iVY = 1;
    this.Ucx.iVL = l2;
    this.Ucx.iVM = l1;
    localObject1 = this.Ucx;
    l1 = l5;
    if (paramac.Uay) {
      l1 = 1L;
    }
    ((kd)localObject1).iVT = l1;
    Log.i("MicroMsg.MultiMediaEditReport", s.X("setComposition, isEnableVideoEnhancement:", Boolean.valueOf(paramac.Uay)));
    AppMethodBeat.o(283727);
  }
  
  public final void lM(List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(283736);
    s.u(paramList, "itemList");
    this.Ucy.editList.clear();
    Iterator localIterator = ((Iterable)paramList).iterator();
    if (localIterator.hasNext())
    {
      com.tencent.mm.plugin.recordvideo.ui.editor.item.a locala1 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localIterator.next();
      c.a locala;
      c.b localb;
      Object localObject;
      if (locala1.NXP == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYd)
      {
        locala = (c.a)new c.b();
        localb = (c.b)locala;
        if ((locala1 instanceof r))
        {
          localObject = (r)locala1;
          label96:
          if (localObject != null) {
            break label205;
          }
          localObject = "";
          label103:
          localObject = new u((String)localObject).getName();
          s.s(localObject, "VFSFile((it as? TextItem)?.font ?: \"\").name");
          localb.setFont((String)localObject);
          localObject = locala;
        }
      }
      for (;;)
      {
        ((c.a)localObject).type = locala1.NXP.value;
        ((c.a)localObject).Ucp.add(Long.valueOf(locala1.NXR.NZL.getTime()));
        ((c.a)localObject).Ucp.add(Long.valueOf(locala1.NXR.NZM.getTime()));
        this.Ucy.editList.add(localObject);
        break;
        localObject = null;
        break label96;
        label205:
        String str = ((r)localObject).mAD;
        localObject = str;
        if (str != null) {
          break label103;
        }
        localObject = "";
        break label103;
        if (locala1.NXP == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYi)
        {
          locala = (c.a)new c.b();
          localb = (c.b)locala;
          if ((locala1 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.c))
          {
            localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.c)locala1;
            label267:
            if (localObject != null) {
              break label309;
            }
            localObject = "";
          }
          for (;;)
          {
            localObject = new u((String)localObject).getName();
            s.s(localObject, "VFSFile((it as? CaptionItem)?.font ?: \"\").name");
            localb.setFont((String)localObject);
            localObject = locala;
            break;
            localObject = null;
            break label267;
            label309:
            str = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject).mAD;
            localObject = str;
            if (str == null) {
              localObject = "";
            }
          }
        }
        localObject = new c.a();
      }
    }
    this.Ucx.iVN = paramList.size();
    AppMethodBeat.o(283736);
  }
  
  public final void report()
  {
    int j = 0;
    AppMethodBeat.i(283753);
    Object localObject1 = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(283753);
      throw ((Throwable)localObject1);
    }
    localObject1 = ((ActivityManager)localObject1).getProcessMemoryInfo(new int[] { Process.myPid() });
    if (localObject1 == null) {}
    for (int i = 0;; i = localObject1.length)
    {
      if (i > 0) {
        this.Ucy.Ucn.Ucq = localObject1[0].getTotalPss();
      }
      localObject1 = com.tencent.mm.videocomposition.a.agDr;
      localObject2 = com.tencent.mm.videocomposition.a.fka().snapshot();
      this.Ucy.Ucn.Ucr = ((Map)localObject2).size();
      localObject1 = this.Ucy.Ucn;
      localObject2 = ((Iterable)((Map)localObject2).values()).iterator();
      for (i = j; ((Iterator)localObject2).hasNext(); i = ((Bitmap)((Iterator)localObject2).next()).getAllocationByteCount() + i) {}
    }
    ((c.c)localObject1).Ucs = i;
    localObject1 = this.Ucy.toJson().toString();
    s.s(localObject1, "reportJson.toJson().toString()");
    localObject1 = n.bV((String)localObject1, ",", ";");
    Object localObject2 = this.Ucx;
    ((kd)localObject2).iVK = ((kd)localObject2).F("JsonInfo", (String)localObject1, true);
    Log.i("MicroMsg.MultiMediaEditReport", s.X("report: ", this.Ucx.aIF()));
    this.Ucx.bMH();
    this.Ucx = new kd();
    this.Ucy = new c();
    AppMethodBeat.o(283753);
  }
  
  public final void wE(long paramLong)
  {
    this.Ucx.ikE = paramLong;
  }
  
  public final void wF(long paramLong)
  {
    this.Ucx.iVP = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.d
 * JD-Core Version:    0.7.0.1
 */