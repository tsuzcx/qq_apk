package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/MultiMediaIDKeyStat;", "", "()V", "DATA_ID", "", "ERR_ID", "HighFpsLimit", "", "HighResolutionLimit", "MuxStateResumeFromPrevious", "MuxStateStart", "MuxStateUnknown", "TAG", "", "muxReportMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "finishMux", "", "path", "cost", "hasOriginSound", "", "hasMusic", "isHevcHard", "isHevcSoft", "markGetCompositionLabelCost", "markGetCompositionLabelFail", "markGetCompositionLabelSucc", "markGetFrameThumbFailed", "markGetFrameThumbNull", "markMuxTrackCount", "count", "videoAndImage", "markSelectNonYuv420Video", "markStartGetCompositionLabel", "muxErrCode", "code", "pathListHashKey", "pathList", "", "report", "key", "reportCompositionInfo", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "reportEditItem", "itemList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "reportMuxResult", "background", "success", "retryCount", "softEncode", "startMux", "outputPath", "plugin-vlog_release"})
public final class a
{
  private static final MultiProcessMMKV NoF;
  private static final int NoG = 0;
  private static final int NoH = 1;
  private static final int NoI = 2;
  public static final a NoJ;
  
  static
  {
    AppMethodBeat.i(225052);
    NoJ = new a();
    NoF = MultiProcessMMKV.getMMKV("MultiMediaIDKeyStatMuxMark");
    NoH = 1;
    NoI = 2;
    AppMethodBeat.o(225052);
  }
  
  public static void Sp(long paramLong)
  {
    AppMethodBeat.i(225046);
    h.IzE.p(1371L, 121L, paramLong);
    h.IzE.p(1371L, 122L, 1L);
    AppMethodBeat.o(225046);
  }
  
  public static void a(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(225017);
    p.k(paramString, "path");
    Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux:" + paramString + ", cost:" + paramLong + ", hasOriginSound:" + paramBoolean1 + ", hasMusic:" + paramBoolean2 + ", isHevcHard:" + paramBoolean3 + ", isHevcSoft:" + paramBoolean4);
    int i = 0;
    if (!u.agG(paramString))
    {
      Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux file not exist path:".concat(String.valueOf(paramString)));
      h.IzE.p(1372L, 18L, 1L);
      i = 1;
    }
    MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.NmA.bfs(paramString);
    int j;
    if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.cLa <= 0.0F)) {
      if (locala == null)
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo path:".concat(String.valueOf(paramString)));
        h.IzE.p(1372L, 19L, 1L);
        j = 0;
        label195:
        if (NoF.getInt(paramString, NoG) == NoI)
        {
          if (j == 0) {
            break label1459;
          }
          Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux error is resume from previous");
          h.IzE.p(1371L, 101L, 1L);
        }
      }
    }
    for (;;)
    {
      NoF.remove(paramString);
      AppMethodBeat.o(225017);
      return;
      if ((locala.width <= 0) || (locala.height <= 0))
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo width/height path:".concat(String.valueOf(paramString)));
        h.IzE.p(1372L, 20L, 1L);
        break;
      }
      if (locala.cLa > 0.0F) {
        break;
      }
      Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo fps path:".concat(String.valueOf(paramString)));
      h.IzE.p(1372L, 21L, 1L);
      break;
      h.IzE.p(1371L, 1L, 1L);
      if (paramBoolean4) {
        h.IzE.p(1371L, 129L, 1L);
      }
      if (paramBoolean3) {
        h.IzE.p(1371L, 130L, 1L);
      }
      label419:
      label472:
      long l;
      if ((!paramBoolean3) && (!paramBoolean4))
      {
        h.IzE.p(1371L, 62L, paramLong);
        h.IzE.p(1371L, 63L, 1L);
        h.IzE.p(1371L, 16L, locala.cLa);
        h.IzE.p(1371L, 17L, 1L);
        if ((!paramBoolean1) || (paramBoolean2)) {
          break label674;
        }
        h.IzE.p(1371L, 20L, 1L);
        Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux video duration:" + locala.duration);
        l = locala.duration / 1000L;
        if (0L <= l) {
          break label839;
        }
        label515:
        if (11L <= l) {
          break label953;
        }
        label524:
        if (21L <= l) {
          break label1067;
        }
        label533:
        if (31L <= l) {
          break label1181;
        }
        label542:
        if (41L <= l) {
          break label1295;
        }
        label551:
        j = i;
        if (51L > l) {
          break label195;
        }
        j = i;
        if (60L < l) {
          break label195;
        }
        if ((paramBoolean1) || (paramBoolean2)) {
          break label1409;
        }
        h.IzE.p(1371L, 34L, 1L);
      }
      for (;;)
      {
        h.IzE.p(1371L, 86L, paramLong);
        h.IzE.p(1371L, 87L, 1L);
        j = i;
        break;
        if (paramBoolean3)
        {
          h.IzE.p(1371L, 132L, paramLong);
          break label419;
        }
        if (!paramBoolean4) {
          break label419;
        }
        h.IzE.p(1371L, 135L, paramLong);
        break label419;
        label674:
        if ((!paramBoolean1) && (!paramBoolean2))
        {
          h.IzE.p(1371L, 21L, 1L);
          h.IzE.p(1371L, 36L, locala.duration);
          h.IzE.p(1371L, 37L, 1L);
          break label472;
        }
        if ((paramBoolean1) && (paramBoolean2))
        {
          h.IzE.p(1371L, 22L, 1L);
          h.IzE.p(1371L, 47L, locala.duration);
          h.IzE.p(1371L, 48L, 1L);
          break label472;
        }
        if ((paramBoolean1) || (!paramBoolean2)) {
          break label472;
        }
        h.IzE.p(1371L, 23L, 1L);
        h.IzE.p(1371L, 58L, locala.duration);
        h.IzE.p(1371L, 59L, 1L);
        break label472;
        label839:
        if (10L < l) {
          break label515;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.IzE.p(1371L, 29L, 1L);
        }
        for (;;)
        {
          h.IzE.p(1371L, 66L, paramLong);
          h.IzE.p(1371L, 67L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 40L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 51L, 1L);
          }
        }
        label953:
        if (20L < l) {
          break label524;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.IzE.p(1371L, 30L, 1L);
        }
        for (;;)
        {
          h.IzE.p(1371L, 70L, paramLong);
          h.IzE.p(1371L, 71L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 41L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 52L, 1L);
          }
        }
        label1067:
        if (30L < l) {
          break label533;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.IzE.p(1371L, 31L, 1L);
        }
        for (;;)
        {
          h.IzE.p(1371L, 74L, paramLong);
          h.IzE.p(1371L, 75L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 42L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 53L, 1L);
          }
        }
        label1181:
        if (40L < l) {
          break label542;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.IzE.p(1371L, 32L, 1L);
        }
        for (;;)
        {
          h.IzE.p(1371L, 78L, paramLong);
          h.IzE.p(1371L, 79L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 43L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 54L, 1L);
          }
        }
        label1295:
        if (50L < l) {
          break label551;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.IzE.p(1371L, 33L, 1L);
        }
        for (;;)
        {
          h.IzE.p(1371L, 82L, paramLong);
          h.IzE.p(1371L, 83L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 44L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.IzE.p(1371L, 55L, 1L);
          }
        }
        label1409:
        if ((paramBoolean1) && (paramBoolean2)) {
          h.IzE.p(1371L, 45L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          h.IzE.p(1371L, 56L, 1L);
        }
      }
      label1459:
      Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux success is resume from previous");
      h.IzE.p(1371L, 100L, 1L);
    }
  }
  
  public static void akh(int paramInt)
  {
    AppMethodBeat.i(225021);
    Log.i("MicroMsg.MultiMediaIDKeyStat", "muxErrCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      h.IzE.p(1372L, 16L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -10: 
      h.IzE.p(1372L, 5L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -11: 
      h.IzE.p(1372L, 6L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -14: 
      h.IzE.p(1372L, 8L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -15: 
      h.IzE.p(1372L, 9L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -101: 
      h.IzE.p(1372L, 30L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -102: 
      h.IzE.p(1372L, 31L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -103: 
      h.IzE.p(1372L, 32L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -104: 
      h.IzE.p(1372L, 33L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -110: 
      h.IzE.p(1372L, 34L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -111: 
      h.IzE.p(1372L, 35L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -112: 
      h.IzE.p(1372L, 36L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -113: 
      h.IzE.p(1372L, 37L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -121: 
      h.IzE.p(1372L, 38L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -122: 
      h.IzE.p(1372L, 39L, 1L);
      AppMethodBeat.o(225021);
      return;
    case -123: 
      h.IzE.p(1372L, 40L, 1L);
      AppMethodBeat.o(225021);
      return;
    }
    h.IzE.p(1372L, 41L, 1L);
    AppMethodBeat.o(225021);
  }
  
  public static void b(ac paramac)
  {
    int k = 1;
    AppMethodBeat.i(225041);
    p.k(paramac, "composition");
    Object localObject = (Iterable)paramac.MQY;
    int i;
    boolean bool;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ad)((Iterator)localObject).next()).gtD())
        {
          i = 1;
          bool = paramac.NmV;
          paramac = (Iterable)paramac.MQY;
          if (((paramac instanceof Collection)) && (((Collection)paramac).isEmpty())) {
            break label231;
          }
          paramac = paramac.iterator();
          label128:
          if (!paramac.hasNext()) {
            break label231;
          }
          if (((ad)paramac.next()).Nng.pvh == 1.0F) {
            break label226;
          }
          j = 1;
          label159:
          if (j == 0) {
            break label229;
          }
        }
      }
    }
    label226:
    label229:
    label231:
    for (int j = k;; j = 0)
    {
      if (i != 0) {
        h.IzE.F(1371L, 106L);
      }
      if (bool) {
        h.IzE.F(1371L, 107L);
      }
      if (j != 0) {
        h.IzE.F(1371L, 114L);
      }
      AppMethodBeat.o(225041);
      return;
      i = 0;
      break;
      j = 0;
      break label159;
      break label128;
    }
  }
  
  public static void bq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(224994);
    Log.i("MicroMsg.MultiMediaIDKeyStat", "markMuxTrackCount, count:" + paramInt + ", videoAndImage:" + paramBoolean);
    if (paramBoolean) {
      h.IzE.p(1371L, 2L, 1L);
    }
    if (paramInt <= 1)
    {
      h.IzE.p(1371L, 3L, 1L);
      AppMethodBeat.o(224994);
      return;
    }
    if (2 > paramInt) {
      if (4 <= paramInt) {
        break label135;
      }
    }
    label135:
    while (5 < paramInt)
    {
      h.IzE.p(1371L, 6L, 1L);
      AppMethodBeat.o(224994);
      return;
      if (3 < paramInt) {
        break;
      }
      h.IzE.p(1371L, 4L, 1L);
      AppMethodBeat.o(224994);
      return;
    }
    h.IzE.p(1371L, 5L, 1L);
    AppMethodBeat.o(224994);
  }
  
  public static void c(List<String> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(224999);
    p.k(paramList, "pathList");
    p.k(paramString, "outputPath");
    Log.i("MicroMsg.MultiMediaIDKeyStat", "startMux, pathList:" + paramList + ", outputPath:" + paramString + ", softEncode:" + paramBoolean);
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label648;
      }
      if (NoF.getInt(paramString, NoG) != NoH) {
        break label330;
      }
      Log.i("MicroMsg.MultiMediaIDKeyStat", "check mux may be resume from previous error");
      NoF.putInt(paramString, NoI);
      h.IzE.p(1371L, 99L, 1L);
      label128:
      h.IzE.p(1371L, 0L, 1L);
      if (paramBoolean) {
        h.IzE.p(1371L, 139L, 1L);
      }
      h.IzE.p(1371L, 8L, paramList.size());
      h.IzE.p(1371L, 9L, 1L);
      paramList = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label648;
      }
      paramString = (String)paramList.next();
      if (!u.agG(paramString)) {
        h.IzE.p(1372L, 1L, 0L);
      }
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.NmA.bfs(paramString);
      Log.i("MicroMsg.MultiMediaIDKeyStat", "startMux, videoInfo:".concat(String.valueOf(locala)));
      if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.cLa <= 0.0F))
      {
        if (locala == null)
        {
          Log.i("MicroMsg.MultiMediaIDKeyStat", "cannot get videoInfo path:".concat(String.valueOf(paramString)));
          h.IzE.p(1372L, 0L, 1L);
          continue;
          i = 0;
          break;
          label330:
          NoF.putInt(paramString, NoH);
          break label128;
        }
        if ((locala.width <= 0) || (locala.height <= 0))
        {
          Log.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video width/height path:".concat(String.valueOf(paramString)));
          h.IzE.p(1372L, 2L, 1L);
          continue;
        }
        if (locala.cLa > 0.0F) {
          continue;
        }
        Log.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video fps path:".concat(String.valueOf(paramString)));
        h.IzE.p(1372L, 3L, 1L);
        continue;
      }
      if (locala.FeD)
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "video is h265 path:".concat(String.valueOf(paramString)));
        h.IzE.p(1371L, 25L, 1L);
      }
      if ((locala.width >= 2000) || (locala.height >= 2000))
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "video high resolution:[" + locala.width + ", " + locala.height + "], path:" + paramString);
        h.IzE.p(1371L, 26L, 1L);
      }
      if (locala.cLa >= 40.0F)
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "video high fps:" + locala.cLa + ", path:" + paramString);
        h.IzE.p(1371L, 27L, 1L);
      }
      h.IzE.p(1371L, 12L, locala.cLa);
      h.IzE.p(1371L, 13L, 1L);
    }
    label648:
    AppMethodBeat.o(224999);
  }
  
  public static void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(225025);
    if (!paramBoolean1) {
      if (paramBoolean2) {
        paramInt = 90;
      }
    }
    for (;;)
    {
      h.IzE.p(1371L, paramInt, 1L);
      AppMethodBeat.o(225025);
      return;
      paramInt = 91;
      continue;
      switch (paramInt)
      {
      default: 
        if (paramBoolean2) {
          if (paramBoolean3) {
            paramInt = 143;
          }
        }
        break;
      case 1: 
        if (paramBoolean2) {
          paramInt = 92;
        } else {
          paramInt = 93;
        }
        break;
      case 2: 
        if (paramBoolean2)
        {
          if (paramBoolean3) {
            paramInt = 141;
          } else {
            paramInt = 94;
          }
        }
        else if (paramBoolean3)
        {
          paramInt = 142;
        }
        else
        {
          paramInt = 95;
          continue;
          paramInt = 96;
          continue;
          if (paramBoolean3) {
            paramInt = 144;
          } else {
            paramInt = 97;
          }
        }
        break;
      }
    }
  }
  
  public static void guf()
  {
    AppMethodBeat.i(225042);
    h.IzE.p(1371L, 117L, 1L);
    AppMethodBeat.o(225042);
  }
  
  public static void gug()
  {
    AppMethodBeat.i(225044);
    h.IzE.p(1371L, 118L, 1L);
    AppMethodBeat.o(225044);
  }
  
  public static void guh()
  {
    AppMethodBeat.i(225045);
    h.IzE.p(1371L, 119L, 1L);
    AppMethodBeat.o(225045);
  }
  
  public static void gui()
  {
    AppMethodBeat.i(225050);
    h.IzE.p(1371L, 127L, 1L);
    AppMethodBeat.o(225050);
  }
  
  public static void iF(List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    int k = 1;
    AppMethodBeat.i(225032);
    p.k(paramList, "itemList");
    Object localObject = (Iterable)paramList;
    int i;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject).next() instanceof c))
        {
          i = 1;
          paramList = (Iterable)paramList;
          if (((paramList instanceof Collection)) && (((Collection)paramList).isEmpty())) {
            break label225;
          }
          paramList = paramList.iterator();
          label110:
          if (!paramList.hasNext()) {
            break label225;
          }
          localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramList.next();
          if (!(localObject instanceof r)) {
            break label220;
          }
          if (((CharSequence)((r)localObject).IbE).length() <= 0) {
            break label215;
          }
          j = 1;
          label159:
          if (j == 0) {
            break label220;
          }
          j = 1;
          label165:
          if (j == 0) {
            break label223;
          }
        }
      }
    }
    label215:
    label220:
    label223:
    label225:
    for (int j = k;; j = 0)
    {
      if (i != 0) {
        h.IzE.F(1371L, 104L);
      }
      if (j != 0) {
        h.IzE.F(1371L, 105L);
      }
      AppMethodBeat.o(225032);
      return;
      i = 0;
      break;
      j = 0;
      break label159;
      j = 0;
      break label165;
      break label110;
    }
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(225047);
    h.IzE.F(1371L, paramLong);
    AppMethodBeat.o(225047);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.a
 * JD-Core Version:    0.7.0.1
 */