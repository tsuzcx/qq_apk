package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.vfs.o;
import com.tencent.mm.videocomposition.b;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/report/MultiMediaIDKeyStat;", "", "()V", "DATA_ID", "", "ERR_ID", "HighFpsLimit", "", "HighResolutionLimit", "MuxStateResumeFromPrevious", "MuxStateStart", "MuxStateUnknown", "TAG", "", "muxReportMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "finishMux", "", "path", "cost", "hasOriginSound", "", "hasMusic", "markGetFrameThumbFailed", "markGetFrameThumbNull", "markMuxTrackCount", "count", "videoAndImage", "muxErrCode", "code", "pathListHashKey", "pathList", "", "report", "key", "reportCompositionInfo", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "reportEditItem", "itemList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "reportMuxResult", "background", "success", "retryCount", "startMux", "outputPath", "plugin-vlog_release"})
public final class a
{
  private static final ay BZj;
  private static final int BZk = 0;
  private static final int BZl = 1;
  private static final int BZm = 2;
  public static final a BZn;
  
  static
  {
    AppMethodBeat.i(191349);
    BZn = new a();
    BZj = ay.aRW("MultiMediaIDKeyStatMuxMark");
    BZl = 1;
    BZm = 2;
    AppMethodBeat.o(191349);
  }
  
  public static void Ui(int paramInt)
  {
    AppMethodBeat.i(191344);
    ae.i("MicroMsg.MultiMediaIDKeyStat", "muxErrCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      g.yxI.n(1372L, 16L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -10: 
      g.yxI.n(1372L, 5L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -11: 
      g.yxI.n(1372L, 6L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -14: 
      g.yxI.n(1372L, 8L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -15: 
      g.yxI.n(1372L, 9L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -101: 
      g.yxI.n(1372L, 30L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -102: 
      g.yxI.n(1372L, 31L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -103: 
      g.yxI.n(1372L, 32L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -104: 
      g.yxI.n(1372L, 33L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -110: 
      g.yxI.n(1372L, 34L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -111: 
      g.yxI.n(1372L, 35L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -112: 
      g.yxI.n(1372L, 36L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -113: 
      g.yxI.n(1372L, 37L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -121: 
      g.yxI.n(1372L, 38L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -122: 
      g.yxI.n(1372L, 39L, 1L);
      AppMethodBeat.o(191344);
      return;
    case -123: 
      g.yxI.n(1372L, 40L, 1L);
      AppMethodBeat.o(191344);
      return;
    }
    g.yxI.n(1372L, 41L, 1L);
    AppMethodBeat.o(191344);
  }
  
  public static void aN(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(191341);
    ae.i("MicroMsg.MultiMediaIDKeyStat", "markMuxTrackCount, count:" + paramInt + ", videoAndImage:" + paramBoolean);
    if (paramBoolean) {
      g.yxI.n(1371L, 2L, 1L);
    }
    if (paramInt <= 1)
    {
      g.yxI.n(1371L, 3L, 1L);
      AppMethodBeat.o(191341);
      return;
    }
    if (2 > paramInt) {
      if (4 <= paramInt) {
        break label129;
      }
    }
    label129:
    while (5 < paramInt)
    {
      g.yxI.n(1371L, 6L, 1L);
      AppMethodBeat.o(191341);
      return;
      if (3 < paramInt) {
        break;
      }
      g.yxI.n(1371L, 4L, 1L);
      AppMethodBeat.o(191341);
      return;
    }
    g.yxI.n(1371L, 5L, 1L);
    AppMethodBeat.o(191341);
  }
  
  public static void b(v paramv)
  {
    int k = 1;
    AppMethodBeat.i(191347);
    p.h(paramv, "composition");
    Object localObject = (Iterable)paramv.BXJ;
    int i;
    boolean bool;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((w)((Iterator)localObject).next()).evS())
        {
          i = 1;
          bool = paramv.BXL;
          paramv = (Iterable)paramv.BXJ;
          if (((paramv instanceof Collection)) && (((Collection)paramv).isEmpty())) {
            break label228;
          }
          paramv = paramv.iterator();
          label126:
          if (!paramv.hasNext()) {
            break label228;
          }
          if (((w)paramv.next()).BXV.lqb == 1.0F) {
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
        g.yxI.A(1371L, 106L);
      }
      if (bool) {
        g.yxI.A(1371L, 107L);
      }
      if (j != 0) {
        g.yxI.A(1371L, 114L);
      }
      AppMethodBeat.o(191347);
      return;
      i = 0;
      break;
      j = 0;
      break label157;
      break label126;
    }
  }
  
  public static void b(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(191343);
    p.h(paramString, "path");
    ae.i("MicroMsg.MultiMediaIDKeyStat", "finishMux:" + paramString + ", cost:" + paramLong + ", hasOriginSound:" + paramBoolean1 + ", hasMusic:" + paramBoolean2);
    int i = 0;
    if (!o.fB(paramString))
    {
      ae.i("MicroMsg.MultiMediaIDKeyStat", "finish mux file not exist path:".concat(String.valueOf(paramString)));
      g.yxI.n(1372L, 18L, 1L);
      i = 1;
    }
    MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.BXt.aED(paramString);
    int j;
    if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.cwp <= 0.0F)) {
      if (locala == null)
      {
        ae.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo path:".concat(String.valueOf(paramString)));
        g.yxI.n(1372L, 19L, 1L);
        j = 0;
        label183:
        if (BZj.getInt(paramString, BZk) == BZm)
        {
          if (j == 0) {
            break label1364;
          }
          ae.i("MicroMsg.MultiMediaIDKeyStat", "finishMux error is resume from previous");
          g.yxI.n(1371L, 101L, 1L);
        }
      }
    }
    for (;;)
    {
      BZj.remove(paramString);
      AppMethodBeat.o(191343);
      return;
      if ((locala.width <= 0) || (locala.height <= 0))
      {
        ae.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo width/height path:".concat(String.valueOf(paramString)));
        g.yxI.n(1372L, 20L, 1L);
        break;
      }
      if (locala.cwp > 0.0F) {
        break;
      }
      ae.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo fps path:".concat(String.valueOf(paramString)));
      g.yxI.n(1372L, 21L, 1L);
      break;
      g.yxI.n(1371L, 1L, 1L);
      g.yxI.n(1371L, 62L, paramLong);
      g.yxI.n(1371L, 63L, 1L);
      g.yxI.n(1371L, 16L, locala.cwp);
      g.yxI.n(1371L, 17L, 1L);
      label418:
      long l;
      if ((paramBoolean1) && (!paramBoolean2))
      {
        g.yxI.n(1371L, 20L, 1L);
        ae.i("MicroMsg.MultiMediaIDKeyStat", "finish mux video duration:" + locala.duration);
        l = locala.duration / 1000L;
        if (0L <= l) {
          break label744;
        }
        label462:
        if (11L <= l) {
          break label858;
        }
        label471:
        if (21L <= l) {
          break label972;
        }
        label480:
        if (31L <= l) {
          break label1086;
        }
        label489:
        if (41L <= l) {
          break label1200;
        }
        label498:
        j = i;
        if (51L > l) {
          break label183;
        }
        j = i;
        if (60L < l) {
          break label183;
        }
        if ((paramBoolean1) || (paramBoolean2)) {
          break label1314;
        }
        g.yxI.n(1371L, 34L, 1L);
      }
      for (;;)
      {
        g.yxI.n(1371L, 86L, paramLong);
        g.yxI.n(1371L, 87L, 1L);
        j = i;
        break;
        if ((!paramBoolean1) && (!paramBoolean2))
        {
          g.yxI.n(1371L, 21L, 1L);
          g.yxI.n(1371L, 36L, locala.duration);
          g.yxI.n(1371L, 37L, 1L);
          break label418;
        }
        if ((paramBoolean1) && (paramBoolean2))
        {
          g.yxI.n(1371L, 22L, 1L);
          g.yxI.n(1371L, 47L, locala.duration);
          g.yxI.n(1371L, 48L, 1L);
          break label418;
        }
        if ((paramBoolean1) || (!paramBoolean2)) {
          break label418;
        }
        g.yxI.n(1371L, 23L, 1L);
        g.yxI.n(1371L, 58L, locala.duration);
        g.yxI.n(1371L, 59L, 1L);
        break label418;
        label744:
        if (10L < l) {
          break label462;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yxI.n(1371L, 29L, 1L);
        }
        for (;;)
        {
          g.yxI.n(1371L, 66L, paramLong);
          g.yxI.n(1371L, 67L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 40L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 51L, 1L);
          }
        }
        label858:
        if (20L < l) {
          break label471;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yxI.n(1371L, 30L, 1L);
        }
        for (;;)
        {
          g.yxI.n(1371L, 70L, paramLong);
          g.yxI.n(1371L, 71L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 41L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 52L, 1L);
          }
        }
        label972:
        if (30L < l) {
          break label480;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yxI.n(1371L, 31L, 1L);
        }
        for (;;)
        {
          g.yxI.n(1371L, 74L, paramLong);
          g.yxI.n(1371L, 75L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 42L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 53L, 1L);
          }
        }
        label1086:
        if (40L < l) {
          break label489;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yxI.n(1371L, 32L, 1L);
        }
        for (;;)
        {
          g.yxI.n(1371L, 78L, paramLong);
          g.yxI.n(1371L, 79L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 43L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 54L, 1L);
          }
        }
        label1200:
        if (50L < l) {
          break label498;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yxI.n(1371L, 33L, 1L);
        }
        for (;;)
        {
          g.yxI.n(1371L, 82L, paramLong);
          g.yxI.n(1371L, 83L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 44L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yxI.n(1371L, 55L, 1L);
          }
        }
        label1314:
        if ((paramBoolean1) && (paramBoolean2)) {
          g.yxI.n(1371L, 45L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          g.yxI.n(1371L, 56L, 1L);
        }
      }
      label1364:
      ae.i("MicroMsg.MultiMediaIDKeyStat", "finishMux success is resume from previous");
      g.yxI.n(1371L, 100L, 1L);
    }
  }
  
  public static void e(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(191345);
    if (!paramBoolean1) {
      if (paramBoolean2) {
        paramInt = 90;
      }
    }
    for (;;)
    {
      g.yxI.n(1371L, paramInt, 1L);
      AppMethodBeat.o(191345);
      return;
      paramInt = 91;
      continue;
      switch (paramInt)
      {
      default: 
        if (paramBoolean2) {
          paramInt = 96;
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
          paramInt = 94;
        }
        else
        {
          paramInt = 95;
          continue;
          paramInt = 97;
        }
        break;
      }
    }
  }
  
  public static void gN(List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    int k = 1;
    AppMethodBeat.i(191346);
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
          if (((CharSequence)((q)localObject).ydG).length() <= 0) {
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
        g.yxI.A(1371L, 104L);
      }
      if (j != 0) {
        g.yxI.A(1371L, 105L);
      }
      AppMethodBeat.o(191346);
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
  
  public static void q(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(191342);
    p.h(paramList, "pathList");
    p.h(paramString, "outputPath");
    ae.i("MicroMsg.MultiMediaIDKeyStat", "startMux, pathList:" + paramList + ", outputPath:" + paramString);
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label603;
      }
      if (BZj.getInt(paramString, BZk) != BZl) {
        break label296;
      }
      ae.i("MicroMsg.MultiMediaIDKeyStat", "check mux may be resume from previous error");
      BZj.putInt(paramString, BZm);
      g.yxI.n(1371L, 99L, 1L);
      label118:
      g.yxI.n(1371L, 0L, 1L);
      g.yxI.n(1371L, 8L, paramList.size());
      g.yxI.n(1371L, 9L, 1L);
      paramList = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label603;
      }
      paramString = (String)paramList.next();
      if (!o.fB(paramString)) {
        g.yxI.n(1372L, 1L, 0L);
      }
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.BXt.aED(paramString);
      ae.i("MicroMsg.MultiMediaIDKeyStat", "startMux, videoInfo:".concat(String.valueOf(locala)));
      if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.cwp <= 0.0F))
      {
        if (locala == null)
        {
          ae.i("MicroMsg.MultiMediaIDKeyStat", "cannot get videoInfo path:".concat(String.valueOf(paramString)));
          g.yxI.n(1372L, 0L, 1L);
          continue;
          i = 0;
          break;
          label296:
          BZj.putInt(paramString, BZl);
          break label118;
        }
        if ((locala.width <= 0) || (locala.height <= 0))
        {
          ae.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video width/height path:".concat(String.valueOf(paramString)));
          g.yxI.n(1372L, 2L, 1L);
          continue;
        }
        if (locala.cwp > 0.0F) {
          continue;
        }
        ae.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video fps path:".concat(String.valueOf(paramString)));
        g.yxI.n(1372L, 3L, 1L);
        continue;
      }
      if (locala.wfj)
      {
        ae.i("MicroMsg.MultiMediaIDKeyStat", "video is h265 path:".concat(String.valueOf(paramString)));
        g.yxI.n(1371L, 25L, 1L);
      }
      if ((locala.width >= 2000) || (locala.height >= 2000))
      {
        ae.i("MicroMsg.MultiMediaIDKeyStat", "video high resolution:[" + locala.width + ", " + locala.height + "], path:" + paramString);
        g.yxI.n(1371L, 26L, 1L);
      }
      if (locala.cwp >= 40.0F)
      {
        ae.i("MicroMsg.MultiMediaIDKeyStat", "video high fps:" + locala.cwp + ", path:" + paramString);
        g.yxI.n(1371L, 27L, 1L);
      }
      g.yxI.n(1371L, 12L, locala.cwp);
      g.yxI.n(1371L, 13L, 1L);
    }
    label603:
    AppMethodBeat.o(191342);
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(191348);
    g.yxI.A(1371L, paramLong);
    AppMethodBeat.o(191348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.a
 * JD-Core Version:    0.7.0.1
 */