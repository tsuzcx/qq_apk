package com.tencent.mm.plugin.vlog.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.nd;
import com.tencent.mm.media.f.a;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.report.c.d;
import com.tencent.mm.plugin.vlog.model.report.c.e;
import com.tencent.mm.plugin.vlog.model.report.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/report/VideoCompositionPerformanceReport;", "", "()V", "ReportSceneC2CVideo", "", "ReportSceneCompositionTranscoder", "ReportSceneFinder", "ReportSceneFinderLongVideo", "ReportSceneMvMusic", "TAG", "", "reportMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "Lkotlin/collections/HashMap;", "createMediaItem", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "it", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "doReport", "", "key", "getReportStruct", "initBasicInfo", "struct", "initOutputVideoInfo", "videoPath", "getReportKey", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "plugin-vlog_release"})
public final class c
{
  public static final c NqY;
  private static final HashMap<String, nd> uDm;
  
  static
  {
    AppMethodBeat.i(243845);
    NqY = new c();
    uDm = new HashMap();
    AppMethodBeat.o(243845);
  }
  
  public static void a(nd paramnd, String paramString)
  {
    AppMethodBeat.i(243843);
    p.k(paramnd, "struct");
    if (u.agG(paramString))
    {
      paramString = f.aYg(paramString);
      if (paramString != null)
      {
        paramnd.DT(paramString.toString());
        paramnd.yY(paramString.frameRate);
        paramnd.zb(paramString.videoDuration);
        paramnd.DS(paramString.width / 100 + 'x' + paramString.height / 100);
        AppMethodBeat.o(243843);
        return;
      }
    }
    AppMethodBeat.o(243843);
  }
  
  public static c.e b(ad paramad)
  {
    AppMethodBeat.i(243833);
    p.k(paramad, "it");
    Object localObject1 = null;
    Object localObject2;
    if (paramad.type == 2)
    {
      localObject2 = (c.e)new c.f();
      ((c.f)localObject2).pvh = paramad.Nng.pvh;
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.NmA.bfs(paramad.path);
      localObject1 = localObject2;
      if (locala != null)
      {
        ((c.f)localObject2).bitrate = locala.bitrate;
        ((c.f)localObject2).cLa = locala.cLa;
        ((c.f)localObject2).audioSampleRate = locala.audioSampleRate;
        ((c.f)localObject2).audioBitrate = locala.audioBitrate;
        ((c.f)localObject2).duration = locala.duration;
        a locala1 = new a(paramad.path);
        c.f localf = (c.f)localObject2;
        String str = locala1.aUI();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        localf.bfC((String)localObject1);
        localf = (c.f)localObject2;
        str = locala1.aUJ();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        localf.bfD((String)localObject1);
        ((c.e)localObject2).NoR.add(Integer.valueOf(locala.width));
        ((c.e)localObject2).NoR.add(Integer.valueOf(locala.height));
        locala1.release();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((c.e)localObject1).type = paramad.type;
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).NoN;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(paramad.Nng.startTimeMs));
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).NoN;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(paramad.Nng.endTimeMs));
        }
      }
      AppMethodBeat.o(243833);
      return localObject1;
      if (paramad.type == 1)
      {
        localObject1 = (c.e)new c.d();
        ((c.e)localObject1).NoR.add(Integer.valueOf(paramad.Nna));
        ((c.e)localObject1).NoR.add(Integer.valueOf(paramad.Nnb));
      }
    }
  }
  
  public static c.e b(com.tencent.mm.videocomposition.b paramb)
  {
    AppMethodBeat.i(243836);
    p.k(paramb, "it");
    Object localObject1 = null;
    Object localObject2;
    if (paramb.type == 2)
    {
      localObject2 = (c.e)new c.f();
      ((c.f)localObject2).pvh = paramb.pvh;
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.NmA.bfs(paramb.path);
      localObject1 = localObject2;
      if (locala != null)
      {
        ((c.f)localObject2).bitrate = locala.bitrate;
        ((c.f)localObject2).cLa = locala.cLa;
        ((c.f)localObject2).audioSampleRate = locala.audioSampleRate;
        ((c.f)localObject2).audioBitrate = locala.audioBitrate;
        ((c.f)localObject2).duration = locala.duration;
        a locala1 = new a(paramb.path);
        c.f localf = (c.f)localObject2;
        String str = locala1.aUI();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        localf.bfC((String)localObject1);
        localf = (c.f)localObject2;
        str = locala1.aUJ();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        localf.bfD((String)localObject1);
        ((c.e)localObject2).NoR.add(Integer.valueOf(locala.width));
        ((c.e)localObject2).NoR.add(Integer.valueOf(locala.height));
        locala1.release();
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((c.e)localObject1).type = paramb.type;
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).NoN;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(paramb.startTimeMs));
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).NoN;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(paramb.endTimeMs));
        }
      }
      AppMethodBeat.o(243836);
      return localObject1;
      if (paramb.type == 1)
      {
        localObject1 = (c.e)new c.d();
        ((c.e)localObject1).NoR.add(Integer.valueOf(paramb.Nna));
        ((c.e)localObject1).NoR.add(Integer.valueOf(paramb.Nnb));
      }
    }
  }
  
  public static nd bfG(String paramString)
  {
    AppMethodBeat.i(243839);
    p.k(paramString, "key");
    if (!uDm.containsKey(paramString))
    {
      ((Map)uDm).put(paramString, new nd());
      Object localObject = uDm.get(paramString);
      if (localObject == null) {
        p.iCn();
      }
      p.j(localObject, "reportMap[key]!!");
      ((nd)localObject).DU(paramString);
      localObject = uDm.get(paramString);
      if (localObject == null) {
        p.iCn();
      }
      p.j(localObject, "reportMap[key]!!");
      localObject = (nd)localObject;
      List localList = n.a((CharSequence)"2.3-398", new char[] { '-' });
      Log.i("MicroMsg.VideoCompositionPerformance", "renderlibVersion :2.3-398");
      if (localList.size() == 2)
      {
        long l = (Float.parseFloat((String)localList.get(0)) * 1000000.0F);
        ((nd)localObject).yT(Util.safeParseLong((String)localList.get(1)) + l);
      }
    }
    paramString = uDm.get(paramString);
    if (paramString == null) {
      p.iCn();
    }
    paramString = (nd)paramString;
    AppMethodBeat.o(243839);
    return paramString;
  }
  
  public static void bfH(String paramString)
  {
    AppMethodBeat.i(243844);
    p.k(paramString, "key");
    nd localnd = (nd)uDm.get(paramString);
    if (localnd != null) {
      localnd.bpa();
    }
    uDm.remove(paramString);
    Log.i("MicroMsg.VideoCompositionPerformance", "do report key:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(243844);
  }
  
  public static void lI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243841);
    p.k(paramString1, "key");
    a(bfG(paramString1), paramString2);
    AppMethodBeat.o(243841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.report.c
 * JD-Core Version:    0.7.0.1
 */