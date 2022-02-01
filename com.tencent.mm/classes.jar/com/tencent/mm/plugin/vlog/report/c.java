package com.tencent.mm.plugin.vlog.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qn;
import com.tencent.mm.media.f.a;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.report.c.d;
import com.tencent.mm.plugin.vlog.model.report.c.e;
import com.tencent.mm.plugin.vlog.model.report.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/report/VideoCompositionPerformanceReport;", "", "()V", "ReportSceneC2CVideo", "", "ReportSceneCompositionTranscoder", "ReportSceneFinder", "ReportSceneFinderLongVideo", "ReportSceneMvMusic", "TAG", "", "reportMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "Lkotlin/collections/HashMap;", "createMediaItem", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "it", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "doReport", "", "key", "getReportStruct", "initBasicInfo", "struct", "initOutputVideoInfo", "videoPath", "getReportKey", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c UeI;
  private static final HashMap<String, qn> xLE;
  
  static
  {
    AppMethodBeat.i(281326);
    UeI = new c();
    xLE = new HashMap();
    AppMethodBeat.o(281326);
  }
  
  public static c.e a(com.tencent.mm.videocomposition.b paramb)
  {
    AppMethodBeat.i(281307);
    s.u(paramb, "it");
    Object localObject1 = null;
    Object localObject2;
    if (paramb.type == 2)
    {
      localObject2 = (c.e)new c.f();
      ((c.f)localObject2).sAn = paramb.sAn;
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.ObB.cI(paramb.path, true);
      localObject1 = localObject2;
      if (locala != null)
      {
        ((c.f)localObject2).bitrate = locala.bitrate;
        ((c.f)localObject2).eGw = locala.eGw;
        ((c.f)localObject2).audioSampleRate = locala.audioSampleRate;
        ((c.f)localObject2).audioBitrate = locala.audioBitrate;
        ((c.f)localObject2).duration = locala.duration;
        a locala1 = new a(paramb.path);
        c.f localf = (c.f)localObject2;
        String str = locala1.bpp();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        localf.bfj((String)localObject1);
        localf = (c.f)localObject2;
        str = locala1.bpq();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        localf.bfk((String)localObject1);
        ((c.f)localObject2).Uct.add(Integer.valueOf(locala.width));
        ((c.f)localObject2).Uct.add(Integer.valueOf(locala.height));
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
        localObject2 = ((c.e)localObject1).Ucp;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(paramb.startTimeMs));
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).Ucp;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(paramb.endTimeMs));
        }
      }
      AppMethodBeat.o(281307);
      return localObject1;
      if (paramb.type == 1)
      {
        localObject1 = (c.e)new c.d();
        ((c.d)localObject1).Uct.add(Integer.valueOf(paramb.UaC));
        ((c.d)localObject1).Uct.add(Integer.valueOf(paramb.UaD));
      }
    }
  }
  
  public static void a(qn paramqn, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(281320);
    s.u(paramqn, "struct");
    MultiMediaVideoChecker.a locala;
    if ((paramString != null) && (y.ZC(paramString)))
    {
      locala = MultiMediaVideoChecker.ObB.cI(paramString, false);
      if (locala != null)
      {
        paramString = locala.ObD;
        if (paramString != null) {
          break label117;
        }
        paramString = localObject;
      }
    }
    for (;;)
    {
      paramqn.xI(paramString);
      paramqn.jso = (locala.eGw);
      paramqn.jss = locala.duration;
      paramqn.xH(locala.width / 100 + 'x' + locala.height / 100);
      AppMethodBeat.o(281320);
      return;
      label117:
      String str = paramString.toString();
      paramString = localObject;
      if (str != null) {
        paramString = n.m(str, ",", ";", false);
      }
    }
  }
  
  public static void aZm(String paramString)
  {
    AppMethodBeat.i(281323);
    s.u(paramString, "key");
    qn localqn = (qn)xLE.get(paramString);
    if (localqn != null) {
      localqn.bMH();
    }
    xLE.remove(paramString);
    Log.i("MicroMsg.VideoCompositionPerformance", s.X("do report key:", paramString));
    AppMethodBeat.o(281323);
  }
  
  public static c.e b(ad paramad)
  {
    AppMethodBeat.i(281297);
    s.u(paramad, "it");
    Object localObject1 = null;
    Object localObject2;
    if (paramad.type == 2)
    {
      localObject2 = (c.e)new c.f();
      ((c.f)localObject2).sAn = paramad.UaI.sAn;
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.ObB.cI(paramad.path, true);
      localObject1 = localObject2;
      if (locala != null)
      {
        ((c.f)localObject2).bitrate = locala.bitrate;
        ((c.f)localObject2).eGw = locala.eGw;
        ((c.f)localObject2).audioSampleRate = locala.audioSampleRate;
        ((c.f)localObject2).audioBitrate = locala.audioBitrate;
        ((c.f)localObject2).duration = locala.duration;
        a locala1 = new a(paramad.path);
        c.f localf = (c.f)localObject2;
        String str = locala1.bpp();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        localf.bfj((String)localObject1);
        localf = (c.f)localObject2;
        str = locala1.bpq();
        localObject1 = str;
        if (str == null) {
          localObject1 = "";
        }
        localf.bfk((String)localObject1);
        ((c.f)localObject2).Uct.add(Integer.valueOf(locala.width));
        ((c.f)localObject2).Uct.add(Integer.valueOf(locala.height));
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
        localObject2 = ((c.e)localObject1).Ucp;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(paramad.UaI.startTimeMs));
        }
      }
      if (localObject1 != null)
      {
        localObject2 = ((c.e)localObject1).Ucp;
        if (localObject2 != null) {
          ((ArrayList)localObject2).add(Long.valueOf(paramad.UaI.endTimeMs));
        }
      }
      AppMethodBeat.o(281297);
      return localObject1;
      if (paramad.type == 1)
      {
        localObject1 = (c.e)new c.d();
        ((c.d)localObject1).Uct.add(Integer.valueOf(paramad.UaC));
        ((c.d)localObject1).Uct.add(Integer.valueOf(paramad.UaD));
      }
    }
  }
  
  public static qn bfn(String paramString)
  {
    AppMethodBeat.i(281312);
    s.u(paramString, "key");
    if (!xLE.containsKey(paramString))
    {
      ((Map)xLE).put(paramString, new qn());
      Object localObject = xLE.get(paramString);
      s.checkNotNull(localObject);
      ((qn)localObject).xJ(paramString);
      Log.i("MicroMsg.VideoCompositionPerformance", s.X("getReportStruct: create ", paramString));
      localObject = xLE.get(paramString);
      s.checkNotNull(localObject);
      s.s(localObject, "reportMap[key]!!");
      localObject = (qn)localObject;
      List localList = n.a((CharSequence)"2.3-609", new char[] { '-' }, 0, 6);
      Log.i("MicroMsg.VideoCompositionPerformance", "renderlibVersion :2.3-609");
      if (localList.size() == 2)
      {
        long l = (Float.parseFloat((String)localList.get(0)) * 1000000.0F);
        ((qn)localObject).jsi = (Util.safeParseLong((String)localList.get(1)) + l);
      }
    }
    paramString = xLE.get(paramString);
    s.checkNotNull(paramString);
    s.s(paramString, "reportMap[key]!!");
    paramString = (qn)paramString;
    AppMethodBeat.o(281312);
    return paramString;
  }
  
  public static void ns(String paramString1, String paramString2)
  {
    AppMethodBeat.i(281317);
    s.u(paramString1, "key");
    a(bfn(paramString1), paramString2);
    AppMethodBeat.o(281317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.report.c
 * JD-Core Version:    0.7.0.1
 */