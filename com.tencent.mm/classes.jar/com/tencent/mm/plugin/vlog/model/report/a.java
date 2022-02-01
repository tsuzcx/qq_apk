package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/MultiMediaIDKeyStat;", "", "()V", "DATA_ID", "", "ERR_ID", "HighFpsLimit", "", "HighResolutionLimit", "MuxStateResumeFromPrevious", "MuxStateStart", "MuxStateUnknown", "TAG", "", "muxReportMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "finishMux", "", "path", "cost", "hasOriginSound", "", "hasMusic", "isHevcHard", "isHevcSoft", "markGetCompositionLabelCost", "markGetCompositionLabelFail", "markGetCompositionLabelSucc", "markGetFrameThumbFailed", "markGetFrameThumbNull", "markMuxTrackCount", "count", "videoAndImage", "markSelectNonYuv420Video", "markStartGetCompositionLabel", "muxErrCode", "code", "pathListHashKey", "pathList", "", "report", "key", "reportCompositionInfo", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "reportEditItem", "itemList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "reportMuxResult", "background", "success", "retryCount", "softEncode", "startMux", "outputPath", "plugin-vlog_release"})
public final class a
{
  private static final MultiProcessMMKV GAW;
  private static final int GAX = 0;
  private static final int GAY = 1;
  private static final int GAZ = 2;
  public static final a GBa;
  
  static
  {
    AppMethodBeat.i(190814);
    GBa = new a();
    GAW = MultiProcessMMKV.getMMKV("MultiMediaIDKeyStatMuxMark");
    GAY = 1;
    GAZ = 2;
    AppMethodBeat.o(190814);
  }
  
  public static void KS(long paramLong)
  {
    AppMethodBeat.i(190811);
    h.CyF.n(1371L, 121L, paramLong);
    h.CyF.n(1371L, 122L, 1L);
    AppMethodBeat.o(190811);
  }
  
  public static void a(ac paramac)
  {
    int k = 1;
    AppMethodBeat.i(190807);
    p.h(paramac, "composition");
    Object localObject = (Iterable)paramac.Gzn;
    int i;
    boolean bool;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ad)((Iterator)localObject).next()).fBG())
        {
          i = 1;
          bool = paramac.Gzp;
          paramac = (Iterable)paramac.Gzn;
          if (((paramac instanceof Collection)) && (((Collection)paramac).isEmpty())) {
            break label228;
          }
          paramac = paramac.iterator();
          label126:
          if (!paramac.hasNext()) {
            break label228;
          }
          if (((ad)paramac.next()).GzA.mwH == 1.0F) {
            break label223;
          }
          j = 1;
          label157:
          if (j == 0) {
            break label226;
          }
        }
      }
    }
    label223:
    label226:
    label228:
    for (int j = k;; j = 0)
    {
      if (i != 0) {
        h.CyF.F(1371L, 106L);
      }
      if (bool) {
        h.CyF.F(1371L, 107L);
      }
      if (j != 0) {
        h.CyF.F(1371L, 114L);
      }
      AppMethodBeat.o(190807);
      return;
      i = 0;
      break;
      j = 0;
      break label157;
      break label126;
    }
  }
  
  public static void a(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(190803);
    p.h(paramString, "path");
    Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux:" + paramString + ", cost:" + paramLong + ", hasOriginSound:" + paramBoolean1 + ", hasMusic:" + paramBoolean2 + ", isHevcHard:" + paramBoolean3 + ", isHevcSoft:" + paramBoolean4);
    int i = 0;
    if (!s.YS(paramString))
    {
      Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux file not exist path:".concat(String.valueOf(paramString)));
      h.CyF.n(1372L, 18L, 1L);
      i = 1;
    }
    MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.GyY.aTV(paramString);
    int j;
    if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.cKu <= 0.0F)) {
      if (locala == null)
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo path:".concat(String.valueOf(paramString)));
        h.CyF.n(1372L, 19L, 1L);
        j = 0;
        label196:
        if (GAW.getInt(paramString, GAX) == GAZ)
        {
          if (j == 0) {
            break label1464;
          }
          Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux error is resume from previous");
          h.CyF.n(1371L, 101L, 1L);
        }
      }
    }
    for (;;)
    {
      GAW.remove(paramString);
      AppMethodBeat.o(190803);
      return;
      if ((locala.width <= 0) || (locala.height <= 0))
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo width/height path:".concat(String.valueOf(paramString)));
        h.CyF.n(1372L, 20L, 1L);
        break;
      }
      if (locala.cKu > 0.0F) {
        break;
      }
      Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo fps path:".concat(String.valueOf(paramString)));
      h.CyF.n(1372L, 21L, 1L);
      break;
      h.CyF.n(1371L, 1L, 1L);
      if (paramBoolean4) {
        h.CyF.n(1371L, 129L, 1L);
      }
      if (paramBoolean3) {
        h.CyF.n(1371L, 130L, 1L);
      }
      label423:
      label476:
      long l;
      if ((!paramBoolean3) && (!paramBoolean4))
      {
        h.CyF.n(1371L, 62L, paramLong);
        h.CyF.n(1371L, 63L, 1L);
        h.CyF.n(1371L, 16L, locala.cKu);
        h.CyF.n(1371L, 17L, 1L);
        if ((!paramBoolean1) || (paramBoolean2)) {
          break label679;
        }
        h.CyF.n(1371L, 20L, 1L);
        Log.i("MicroMsg.MultiMediaIDKeyStat", "finish mux video duration:" + locala.duration);
        l = locala.duration / 1000L;
        if (0L <= l) {
          break label844;
        }
        label520:
        if (11L <= l) {
          break label958;
        }
        label529:
        if (21L <= l) {
          break label1072;
        }
        label538:
        if (31L <= l) {
          break label1186;
        }
        label547:
        if (41L <= l) {
          break label1300;
        }
        label556:
        j = i;
        if (51L > l) {
          break label196;
        }
        j = i;
        if (60L < l) {
          break label196;
        }
        if ((paramBoolean1) || (paramBoolean2)) {
          break label1414;
        }
        h.CyF.n(1371L, 34L, 1L);
      }
      for (;;)
      {
        h.CyF.n(1371L, 86L, paramLong);
        h.CyF.n(1371L, 87L, 1L);
        j = i;
        break;
        if (paramBoolean3)
        {
          h.CyF.n(1371L, 132L, paramLong);
          break label423;
        }
        if (!paramBoolean4) {
          break label423;
        }
        h.CyF.n(1371L, 135L, paramLong);
        break label423;
        label679:
        if ((!paramBoolean1) && (!paramBoolean2))
        {
          h.CyF.n(1371L, 21L, 1L);
          h.CyF.n(1371L, 36L, locala.duration);
          h.CyF.n(1371L, 37L, 1L);
          break label476;
        }
        if ((paramBoolean1) && (paramBoolean2))
        {
          h.CyF.n(1371L, 22L, 1L);
          h.CyF.n(1371L, 47L, locala.duration);
          h.CyF.n(1371L, 48L, 1L);
          break label476;
        }
        if ((paramBoolean1) || (!paramBoolean2)) {
          break label476;
        }
        h.CyF.n(1371L, 23L, 1L);
        h.CyF.n(1371L, 58L, locala.duration);
        h.CyF.n(1371L, 59L, 1L);
        break label476;
        label844:
        if (10L < l) {
          break label520;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.CyF.n(1371L, 29L, 1L);
        }
        for (;;)
        {
          h.CyF.n(1371L, 66L, paramLong);
          h.CyF.n(1371L, 67L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 40L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 51L, 1L);
          }
        }
        label958:
        if (20L < l) {
          break label529;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.CyF.n(1371L, 30L, 1L);
        }
        for (;;)
        {
          h.CyF.n(1371L, 70L, paramLong);
          h.CyF.n(1371L, 71L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 41L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 52L, 1L);
          }
        }
        label1072:
        if (30L < l) {
          break label538;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.CyF.n(1371L, 31L, 1L);
        }
        for (;;)
        {
          h.CyF.n(1371L, 74L, paramLong);
          h.CyF.n(1371L, 75L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 42L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 53L, 1L);
          }
        }
        label1186:
        if (40L < l) {
          break label547;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.CyF.n(1371L, 32L, 1L);
        }
        for (;;)
        {
          h.CyF.n(1371L, 78L, paramLong);
          h.CyF.n(1371L, 79L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 43L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 54L, 1L);
          }
        }
        label1300:
        if (50L < l) {
          break label556;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.CyF.n(1371L, 33L, 1L);
        }
        for (;;)
        {
          h.CyF.n(1371L, 82L, paramLong);
          h.CyF.n(1371L, 83L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 44L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.CyF.n(1371L, 55L, 1L);
          }
        }
        label1414:
        if ((paramBoolean1) && (paramBoolean2)) {
          h.CyF.n(1371L, 45L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          h.CyF.n(1371L, 56L, 1L);
        }
      }
      label1464:
      Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux success is resume from previous");
      h.CyF.n(1371L, 100L, 1L);
    }
  }
  
  public static void acB(int paramInt)
  {
    AppMethodBeat.i(190804);
    Log.i("MicroMsg.MultiMediaIDKeyStat", "muxErrCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      h.CyF.n(1372L, 16L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -10: 
      h.CyF.n(1372L, 5L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -11: 
      h.CyF.n(1372L, 6L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -14: 
      h.CyF.n(1372L, 8L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -15: 
      h.CyF.n(1372L, 9L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -101: 
      h.CyF.n(1372L, 30L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -102: 
      h.CyF.n(1372L, 31L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -103: 
      h.CyF.n(1372L, 32L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -104: 
      h.CyF.n(1372L, 33L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -110: 
      h.CyF.n(1372L, 34L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -111: 
      h.CyF.n(1372L, 35L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -112: 
      h.CyF.n(1372L, 36L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -113: 
      h.CyF.n(1372L, 37L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -121: 
      h.CyF.n(1372L, 38L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -122: 
      h.CyF.n(1372L, 39L, 1L);
      AppMethodBeat.o(190804);
      return;
    case -123: 
      h.CyF.n(1372L, 40L, 1L);
      AppMethodBeat.o(190804);
      return;
    }
    h.CyF.n(1372L, 41L, 1L);
    AppMethodBeat.o(190804);
  }
  
  public static void bd(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(190801);
    Log.i("MicroMsg.MultiMediaIDKeyStat", "markMuxTrackCount, count:" + paramInt + ", videoAndImage:" + paramBoolean);
    if (paramBoolean) {
      h.CyF.n(1371L, 2L, 1L);
    }
    if (paramInt <= 1)
    {
      h.CyF.n(1371L, 3L, 1L);
      AppMethodBeat.o(190801);
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
      h.CyF.n(1371L, 6L, 1L);
      AppMethodBeat.o(190801);
      return;
      if (3 < paramInt) {
        break;
      }
      h.CyF.n(1371L, 4L, 1L);
      AppMethodBeat.o(190801);
      return;
    }
    h.CyF.n(1371L, 5L, 1L);
    AppMethodBeat.o(190801);
  }
  
  public static void c(List<String> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(190802);
    p.h(paramList, "pathList");
    p.h(paramString, "outputPath");
    Log.i("MicroMsg.MultiMediaIDKeyStat", "startMux, pathList:" + paramList + ", outputPath:" + paramString + ", softEncode:" + paramBoolean);
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label648;
      }
      if (GAW.getInt(paramString, GAX) != GAY) {
        break label330;
      }
      Log.i("MicroMsg.MultiMediaIDKeyStat", "check mux may be resume from previous error");
      GAW.putInt(paramString, GAZ);
      h.CyF.n(1371L, 99L, 1L);
      label128:
      h.CyF.n(1371L, 0L, 1L);
      if (paramBoolean) {
        h.CyF.n(1371L, 139L, 1L);
      }
      h.CyF.n(1371L, 8L, paramList.size());
      h.CyF.n(1371L, 9L, 1L);
      paramList = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label648;
      }
      paramString = (String)paramList.next();
      if (!s.YS(paramString)) {
        h.CyF.n(1372L, 1L, 0L);
      }
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.GyY.aTV(paramString);
      Log.i("MicroMsg.MultiMediaIDKeyStat", "startMux, videoInfo:".concat(String.valueOf(locala)));
      if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.cKu <= 0.0F))
      {
        if (locala == null)
        {
          Log.i("MicroMsg.MultiMediaIDKeyStat", "cannot get videoInfo path:".concat(String.valueOf(paramString)));
          h.CyF.n(1372L, 0L, 1L);
          continue;
          i = 0;
          break;
          label330:
          GAW.putInt(paramString, GAY);
          break label128;
        }
        if ((locala.width <= 0) || (locala.height <= 0))
        {
          Log.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video width/height path:".concat(String.valueOf(paramString)));
          h.CyF.n(1372L, 2L, 1L);
          continue;
        }
        if (locala.cKu > 0.0F) {
          continue;
        }
        Log.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video fps path:".concat(String.valueOf(paramString)));
        h.CyF.n(1372L, 3L, 1L);
        continue;
      }
      if (locala.zzJ)
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "video is h265 path:".concat(String.valueOf(paramString)));
        h.CyF.n(1371L, 25L, 1L);
      }
      if ((locala.width >= 2000) || (locala.height >= 2000))
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "video high resolution:[" + locala.width + ", " + locala.height + "], path:" + paramString);
        h.CyF.n(1371L, 26L, 1L);
      }
      if (locala.cKu >= 40.0F)
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "video high fps:" + locala.cKu + ", path:" + paramString);
        h.CyF.n(1371L, 27L, 1L);
      }
      h.CyF.n(1371L, 12L, locala.cKu);
      h.CyF.n(1371L, 13L, 1L);
    }
    label648:
    AppMethodBeat.o(190802);
  }
  
  public static void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(190805);
    if (!paramBoolean1) {
      if (paramBoolean2) {
        paramInt = 90;
      }
    }
    for (;;)
    {
      h.CyF.n(1371L, paramInt, 1L);
      AppMethodBeat.o(190805);
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
  
  public static void fCh()
  {
    AppMethodBeat.i(190808);
    h.CyF.n(1371L, 117L, 1L);
    AppMethodBeat.o(190808);
  }
  
  public static void fCi()
  {
    AppMethodBeat.i(190809);
    h.CyF.n(1371L, 118L, 1L);
    AppMethodBeat.o(190809);
  }
  
  public static void fCj()
  {
    AppMethodBeat.i(190810);
    h.CyF.n(1371L, 119L, 1L);
    AppMethodBeat.o(190810);
  }
  
  public static void fCk()
  {
    AppMethodBeat.i(190813);
    h.CyF.n(1371L, 127L, 1L);
    AppMethodBeat.o(190813);
  }
  
  public static void hQ(List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    int k = 1;
    AppMethodBeat.i(190806);
    p.h(paramList, "itemList");
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
          if (!(localObject instanceof q)) {
            break label220;
          }
          if (((CharSequence)((q)localObject).CeI).length() <= 0) {
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
        h.CyF.F(1371L, 104L);
      }
      if (j != 0) {
        h.CyF.F(1371L, 105L);
      }
      AppMethodBeat.o(190806);
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
    AppMethodBeat.i(190812);
    h.CyF.F(1371L, paramLong);
    AppMethodBeat.o(190812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.a
 * JD-Core Version:    0.7.0.1
 */