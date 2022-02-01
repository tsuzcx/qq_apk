package com.tencent.mm.plugin.vlog.model.report;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ge;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/VideoEditResultReport;", "", "()V", "reportJson", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "getReportJson", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "setReportJson", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;)V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;)V", "fillReportMem", "", "report", "setAction", "action", "", "setComposition", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setEditItem", "itemList", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "setSourceType", "source", "setTemplateId", "templateId", "", "setTemplateResourceReady", "ready", "", "Companion", "plugin-vlog_release"})
public final class d
{
  public static final a GBk;
  public ge GBi;
  private c GBj;
  
  static
  {
    AppMethodBeat.i(190833);
    GBk = new a((byte)0);
    AppMethodBeat.o(190833);
  }
  
  public d()
  {
    AppMethodBeat.i(190832);
    this.GBi = new ge();
    this.GBj = new c();
    AppMethodBeat.o(190832);
  }
  
  public final void KT(long paramLong)
  {
    AppMethodBeat.i(190829);
    this.GBi.pT(paramLong);
    AppMethodBeat.o(190829);
  }
  
  public final void KU(long paramLong)
  {
    AppMethodBeat.i(190830);
    this.GBi.pU(paramLong);
    AppMethodBeat.o(190830);
  }
  
  public final void b(ac paramac)
  {
    AppMethodBeat.i(190827);
    p.h(paramac, "composition");
    this.GBj.tGk.clear();
    long l2 = 0L;
    Iterator localIterator = ((Iterable)paramac.Gzn).iterator();
    long l1 = 0L;
    ad localad;
    Object localObject1;
    Object localObject2;
    long l3;
    if (localIterator.hasNext())
    {
      localad = (ad)localIterator.next();
      localObject1 = null;
      if (localad.type == 2)
      {
        l2 += 1L;
        localObject2 = (c.e)new c.f();
        ((c.f)localObject2).mwH = localad.GzA.mwH;
        MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.GyY.aTV(localad.path);
        localObject1 = localObject2;
        l3 = l2;
        if (locala == null) {
          break label476;
        }
        ((c.f)localObject2).bitrate = locala.bitrate;
        ((c.f)localObject2).cKu = locala.cKu;
        ((c.f)localObject2).audioSampleRate = locala.audioSampleRate;
        ((c.f)localObject2).audioBitrate = locala.audioBitrate;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((c.e)localObject1).type = localad.type;
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).GBh;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Integer.valueOf(localad.Gzu));
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).GBh;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Integer.valueOf(localad.Gzv));
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).GBd;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(localad.GzA.startTimeMs));
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).GBd;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(localad.GzA.endTimeMs));
        }
      }
      if (localObject1 != null) {
        this.GBj.tGk.add(localObject1);
      }
      break;
      l3 = l2;
      if (localad.type == 1)
      {
        localObject1 = (c.e)new c.d();
        l1 += 1L;
        continue;
        this.GBi.ln(1);
        this.GBi.pP(l2);
        this.GBi.pQ(l1);
        localObject1 = this.GBi;
        if (paramac.Gzp) {}
        for (l1 = 1L;; l1 = 0L)
        {
          ((ge)localObject1).pV(l1);
          Log.i("MicroMsg.MultiMediaEditReport", "setComposition, isEnableVideoEnhancement:" + paramac.Gzp);
          AppMethodBeat.o(190827);
          return;
        }
      }
      else
      {
        label476:
        l2 = l3;
      }
    }
  }
  
  public final void hR(List<? extends a> paramList)
  {
    AppMethodBeat.i(190828);
    p.h(paramList, "itemList");
    this.GBj.editList.clear();
    Iterator localIterator = ((Iterable)paramList).iterator();
    a locala;
    c.a locala1;
    c.b localb;
    if (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if (locala.Cex == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeK)
      {
        locala1 = (c.a)new c.b();
        localb = (c.b)locala1;
        if ((locala instanceof q)) {
          break label350;
        }
      }
    }
    label345:
    label350:
    for (Object localObject = null;; localObject = locala)
    {
      localObject = (q)localObject;
      String str;
      if (localObject != null)
      {
        str = ((q)localObject).CeI;
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      localObject = new o((String)localObject).getName();
      p.g(localObject, "VFSFile((it as? TextItem)?.font ?: \"\").name");
      localb.setFont((String)localObject);
      localObject = locala1;
      ((c.a)localObject).type = locala.Cex.value;
      ((c.a)localObject).GBd.add(Long.valueOf(locala.Cev.Cgx.getTime()));
      ((c.a)localObject).GBd.add(Long.valueOf(locala.Cev.Cgy.getTime()));
      this.GBj.editList.add(localObject);
      break;
      if (locala.Cex == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeP)
      {
        locala1 = (c.a)new c.b();
        localb = (c.b)locala1;
        if ((locala instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.c)) {
          break label345;
        }
      }
      for (localObject = null;; localObject = locala)
      {
        localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject;
        if (localObject != null)
        {
          str = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject).CeI;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localObject = new o((String)localObject).getName();
        p.g(localObject, "VFSFile((it as? CaptionItem)?.font ?: \"\").name");
        localb.setFont((String)localObject);
        localObject = locala1;
        break;
        localObject = new c.a();
        break;
        this.GBi.pR(paramList.size());
        AppMethodBeat.o(190828);
        return;
      }
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(190831);
    Object localObject1 = MMApplicationContext.getContext().getSystemService("activity");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(190831);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = ((ActivityManager)localObject1).getProcessMemoryInfo(new int[] { Process.myPid() });
    if (localObject2 != null) {}
    for (int i = localObject2.length;; i = 0)
    {
      if (i > 0)
      {
        localObject1 = this.GBj.GBc;
        localObject2 = localObject2[0];
        p.g(localObject2, "memInfos[0]");
        ((c.c)localObject1).GBe = ((Debug.MemoryInfo)localObject2).getTotalPss();
      }
      localObject1 = com.tencent.mm.videocomposition.c.RgU;
      localObject2 = com.tencent.mm.videocomposition.c.evK().snapshot();
      this.GBj.GBc.GBf = ((Map)localObject2).size();
      localObject1 = this.GBj.GBc;
      localObject2 = ((Iterable)((Map)localObject2).values()).iterator();
      Bitmap localBitmap;
      for (i = 0; ((Iterator)localObject2).hasNext(); i = localBitmap.getAllocationByteCount() + i)
      {
        localBitmap = (Bitmap)((Iterator)localObject2).next();
        p.g(localBitmap, "it");
      }
    }
    ((c.c)localObject1).GBg = i;
    localObject1 = this.GBj.toJson().toString();
    p.g(localObject1, "reportJson.toJson().toString()");
    localObject1 = n.j((String)localObject1, ",", ";", false);
    this.GBi.tI((String)localObject1);
    Log.i("MicroMsg.MultiMediaEditReport", "report: " + this.GBi.abW());
    this.GBi.bfK();
    this.GBi = new ge();
    this.GBj = new c();
    AppMethodBeat.o(190831);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/VideoEditResultReport$Companion;", "", "()V", "ACTION_EXIT", "", "ACTION_NEXT", "SOURCE_MUSIC_FOLLOW", "SOURCE_OTHER", "SOURCE_TEMPLATE_FOLLOW", "SOURCE_TEMPLATE_POST", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.d
 * JD-Core Version:    0.7.0.1
 */