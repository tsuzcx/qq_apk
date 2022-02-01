package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/MultiMediaIDKeyStat;", "", "()V", "DATA_ID", "", "ERR_ID", "HighFpsLimit", "", "HighResolutionLimit", "MuxStateResumeFromPrevious", "MuxStateStart", "MuxStateUnknown", "TAG", "", "muxReportMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "finishMux", "", "path", "cost", "hasOriginSound", "", "hasMusic", "isHevcHard", "isHevcSoft", "markGetCompositionLabelCost", "markGetCompositionLabelFail", "markGetCompositionLabelSucc", "markGetFrameThumbFailed", "markGetFrameThumbNull", "markMuxTrackCount", "count", "videoAndImage", "markSelectNonYuv420Video", "markStartGetCompositionLabel", "muxErrCode", "code", "pathListHashKey", "pathList", "", "report", "key", "reportCompositionInfo", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "reportEditItem", "itemList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "reportMuxResult", "background", "success", "retryCount", "softEncode", "startMux", "outputPath", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Uch;
  private static final MultiProcessMMKV Uci;
  private static final int Ucj = 0;
  private static final int Uck;
  private static final int Ucl;
  
  static
  {
    AppMethodBeat.i(283789);
    Uch = new a();
    Uci = MultiProcessMMKV.getMMKV("MultiMediaIDKeyStatMuxMark");
    Uck = 1;
    Ucl = 2;
    AppMethodBeat.o(283789);
  }
  
  public static void a(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(283752);
    s.u(paramString, "path");
    Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux:" + paramString + ", cost:" + paramLong + ", hasOriginSound:" + paramBoolean1 + ", hasMusic:" + paramBoolean2 + ", isHevcHard:" + paramBoolean3 + ", isHevcSoft:" + paramBoolean4);
    int i = 0;
    if (!y.ZC(paramString))
    {
      Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("finish mux file not exist path:", paramString));
      h.OAn.p(1372L, 18L, 1L);
      i = 1;
    }
    MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.ObB.aTG(paramString);
    int k;
    if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.eGw <= 0.0F)) {
      if (locala == null)
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("finish mux cannot get videoInfo path:", paramString));
        h.OAn.p(1372L, 19L, 1L);
        k = 0;
        label189:
        if (Uci.getInt(paramString, Ucj) == Ucl)
        {
          if (k == 0) {
            break label1556;
          }
          Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux error is resume from previous");
          h.OAn.p(1371L, 101L, 1L);
        }
      }
    }
    for (;;)
    {
      Uci.remove(paramString);
      AppMethodBeat.o(283752);
      return;
      if ((locala.width <= 0) || (locala.height <= 0))
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("finish mux cannot get videoInfo width/height path:", paramString));
        h.OAn.p(1372L, 20L, 1L);
        break;
      }
      if (locala.eGw > 0.0F) {
        break;
      }
      Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("finish mux cannot get videoInfo fps path:", paramString));
      h.OAn.p(1372L, 21L, 1L);
      break;
      h.OAn.p(1371L, 1L, 1L);
      if (paramBoolean4) {
        h.OAn.p(1371L, 129L, 1L);
      }
      if (paramBoolean3) {
        h.OAn.p(1371L, 130L, 1L);
      }
      label407:
      label460:
      long l;
      int j;
      if ((!paramBoolean3) && (!paramBoolean4))
      {
        h.OAn.p(1371L, 62L, paramLong);
        h.OAn.p(1371L, 63L, 1L);
        h.OAn.p(1371L, 16L, locala.eGw);
        h.OAn.p(1371L, 17L, 1L);
        if ((!paramBoolean1) || (paramBoolean2)) {
          break label610;
        }
        h.OAn.p(1371L, 20L, 1L);
        Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("finish mux video duration:", Long.valueOf(locala.duration)));
        l = locala.duration / 1000L;
        if (0L > l) {
          break label781;
        }
        if (l > 10L) {
          break label775;
        }
        j = 1;
        label508:
        if (j == 0) {
          break label837;
        }
        if ((paramBoolean1) || (paramBoolean2)) {
          break label787;
        }
        h.OAn.p(1371L, 29L, 1L);
      }
      for (;;)
      {
        h.OAn.p(1371L, 66L, paramLong);
        h.OAn.p(1371L, 67L, 1L);
        k = i;
        break;
        if (paramBoolean3)
        {
          h.OAn.p(1371L, 132L, paramLong);
          break label407;
        }
        if (!paramBoolean4) {
          break label407;
        }
        h.OAn.p(1371L, 135L, paramLong);
        break label407;
        label610:
        if ((!paramBoolean1) && (!paramBoolean2))
        {
          h.OAn.p(1371L, 21L, 1L);
          h.OAn.p(1371L, 36L, locala.duration);
          h.OAn.p(1371L, 37L, 1L);
          break label460;
        }
        if ((paramBoolean1) && (paramBoolean2))
        {
          h.OAn.p(1371L, 22L, 1L);
          h.OAn.p(1371L, 47L, locala.duration);
          h.OAn.p(1371L, 48L, 1L);
          break label460;
        }
        if ((paramBoolean1) || (!paramBoolean2)) {
          break label460;
        }
        h.OAn.p(1371L, 23L, 1L);
        h.OAn.p(1371L, 58L, locala.duration);
        h.OAn.p(1371L, 59L, 1L);
        break label460;
        label775:
        j = 0;
        break label508;
        label781:
        j = 0;
        break label508;
        label787:
        if ((paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 40L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 51L, 1L);
        }
      }
      label837:
      if (11L <= l) {
        if (l <= 20L)
        {
          j = 1;
          label858:
          if (j == 0) {
            break label980;
          }
          if ((paramBoolean1) || (paramBoolean2)) {
            break label930;
          }
          h.OAn.p(1371L, 30L, 1L);
        }
      }
      for (;;)
      {
        h.OAn.p(1371L, 70L, paramLong);
        h.OAn.p(1371L, 71L, 1L);
        k = i;
        break;
        j = 0;
        break label858;
        j = 0;
        break label858;
        label930:
        if ((paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 41L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 52L, 1L);
        }
      }
      label980:
      if (21L <= l) {
        if (l <= 30L)
        {
          j = 1;
          label1001:
          if (j == 0) {
            break label1123;
          }
          if ((paramBoolean1) || (paramBoolean2)) {
            break label1073;
          }
          h.OAn.p(1371L, 31L, 1L);
        }
      }
      for (;;)
      {
        h.OAn.p(1371L, 74L, paramLong);
        h.OAn.p(1371L, 75L, 1L);
        k = i;
        break;
        j = 0;
        break label1001;
        j = 0;
        break label1001;
        label1073:
        if ((paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 42L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 53L, 1L);
        }
      }
      label1123:
      if (31L <= l) {
        if (l <= 40L)
        {
          j = 1;
          label1144:
          if (j == 0) {
            break label1266;
          }
          if ((paramBoolean1) || (paramBoolean2)) {
            break label1216;
          }
          h.OAn.p(1371L, 32L, 1L);
        }
      }
      for (;;)
      {
        h.OAn.p(1371L, 78L, paramLong);
        h.OAn.p(1371L, 79L, 1L);
        k = i;
        break;
        j = 0;
        break label1144;
        j = 0;
        break label1144;
        label1216:
        if ((paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 43L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 54L, 1L);
        }
      }
      label1266:
      if (41L <= l) {
        if (l <= 50L)
        {
          j = 1;
          if (j == 0) {
            break label1409;
          }
          if ((paramBoolean1) || (paramBoolean2)) {
            break label1359;
          }
          h.OAn.p(1371L, 33L, 1L);
        }
      }
      for (;;)
      {
        label1287:
        h.OAn.p(1371L, 82L, paramLong);
        h.OAn.p(1371L, 83L, 1L);
        k = i;
        break;
        j = 0;
        break label1287;
        j = 0;
        break label1287;
        label1359:
        if ((paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 44L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 55L, 1L);
        }
      }
      label1409:
      if (51L <= l) {
        if (l <= 60L)
        {
          j = 1;
          label1430:
          k = i;
          if (j == 0) {
            break label189;
          }
          if ((paramBoolean1) || (paramBoolean2)) {
            break label1506;
          }
          h.OAn.p(1371L, 34L, 1L);
        }
      }
      for (;;)
      {
        h.OAn.p(1371L, 86L, paramLong);
        h.OAn.p(1371L, 87L, 1L);
        k = i;
        break;
        j = 0;
        break label1430;
        j = 0;
        break label1430;
        label1506:
        if ((paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 45L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          h.OAn.p(1371L, 56L, 1L);
        }
      }
      label1556:
      Log.i("MicroMsg.MultiMediaIDKeyStat", "finishMux success is resume from previous");
      h.OAn.p(1371L, 100L, 1L);
    }
  }
  
  public static void apB(int paramInt)
  {
    AppMethodBeat.i(283761);
    Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("muxErrCode:", Integer.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      h.OAn.p(1372L, 16L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -10: 
      h.OAn.p(1372L, 5L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -11: 
      h.OAn.p(1372L, 6L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -14: 
      h.OAn.p(1372L, 8L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -15: 
      h.OAn.p(1372L, 9L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -101: 
      h.OAn.p(1372L, 30L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -102: 
      h.OAn.p(1372L, 31L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -103: 
      h.OAn.p(1372L, 32L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -104: 
      h.OAn.p(1372L, 33L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -110: 
      h.OAn.p(1372L, 34L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -111: 
      h.OAn.p(1372L, 35L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -112: 
      h.OAn.p(1372L, 36L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -113: 
      h.OAn.p(1372L, 37L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -121: 
      h.OAn.p(1372L, 38L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -122: 
      h.OAn.p(1372L, 39L, 1L);
      AppMethodBeat.o(283761);
      return;
    case -123: 
      h.OAn.p(1372L, 40L, 1L);
      AppMethodBeat.o(283761);
      return;
    }
    h.OAn.p(1372L, 41L, 1L);
    AppMethodBeat.o(283761);
  }
  
  public static void b(ac paramac)
  {
    int k = 0;
    AppMethodBeat.i(283775);
    s.u(paramac, "composition");
    Object localObject = (Iterable)paramac.TDz;
    int i;
    boolean bool;
    int j;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if (((ad)((Iterator)localObject).next()).hRe())
          {
            i = 1;
            bool = paramac.Uay;
            paramac = (Iterable)paramac.TDz;
            if ((paramac instanceof Collection))
            {
              j = k;
              if (((Collection)paramac).isEmpty()) {
                break;
              }
            }
            else
            {
              paramac = paramac.iterator();
            }
          }
        }
      }
    }
    label163:
    label239:
    label244:
    label247:
    for (;;)
    {
      j = k;
      if (paramac.hasNext())
      {
        if (((ad)paramac.next()).UaI.sAn != 1.0F) {
          break label239;
        }
        j = 1;
        if (j != 0) {
          break label244;
        }
      }
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label247;
        }
        j = 1;
        if (i != 0) {
          h.OAn.p(1371L, 106L, 1L);
        }
        if (bool) {
          h.OAn.p(1371L, 107L, 1L);
        }
        if (j != 0) {
          h.OAn.p(1371L, 114L, 1L);
        }
        AppMethodBeat.o(283775);
        return;
        i = 0;
        break;
        j = 0;
        break label163;
      }
    }
  }
  
  public static void bY(int paramInt, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(283725);
    Log.i("MicroMsg.MultiMediaIDKeyStat", "markMuxTrackCount, count:" + paramInt + ", videoAndImage:" + paramBoolean);
    if (paramBoolean) {
      h.OAn.p(1371L, 2L, 1L);
    }
    if (paramInt <= 1)
    {
      h.OAn.p(1371L, 3L, 1L);
      AppMethodBeat.o(283725);
      return;
    }
    int i;
    if (2 <= paramInt) {
      if (paramInt <= 3) {
        i = 1;
      }
    }
    while (i != 0)
    {
      h.OAn.p(1371L, 4L, 1L);
      AppMethodBeat.o(283725);
      return;
      i = 0;
      continue;
      i = 0;
    }
    if (4 <= paramInt) {
      if (paramInt <= 5) {
        paramInt = j;
      }
    }
    while (paramInt != 0)
    {
      h.OAn.p(1371L, 5L, 1L);
      AppMethodBeat.o(283725);
      return;
      paramInt = 0;
      continue;
      paramInt = 0;
    }
    h.OAn.p(1371L, 6L, 1L);
    AppMethodBeat.o(283725);
  }
  
  public static void c(List<String> paramList, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(283738);
    s.u(paramList, "pathList");
    s.u(paramString, "outputPath");
    Log.i("MicroMsg.MultiMediaIDKeyStat", "startMux, pathList:" + paramList + ", outputPath:" + paramString + ", softEncode:" + paramBoolean);
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label633;
      }
      if (Uci.getInt(paramString, Ucj) != Uck) {
        break label324;
      }
      Log.i("MicroMsg.MultiMediaIDKeyStat", "check mux may be resume from previous error");
      Uci.putInt(paramString, Ucl);
      h.OAn.p(1371L, 99L, 1L);
      label128:
      h.OAn.p(1371L, 0L, 1L);
      if (paramBoolean) {
        h.OAn.p(1371L, 139L, 1L);
      }
      h.OAn.p(1371L, 8L, paramList.size());
      h.OAn.p(1371L, 9L, 1L);
      paramList = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label633;
      }
      paramString = (String)paramList.next();
      if (!y.ZC(paramString)) {
        h.OAn.p(1372L, 1L, 0L);
      }
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.ObB.aTG(paramString);
      Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("startMux, videoInfo:", locala));
      if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.eGw <= 0.0F))
      {
        if (locala == null)
        {
          Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("cannot get videoInfo path:", paramString));
          h.OAn.p(1372L, 0L, 1L);
          continue;
          i = 0;
          break;
          label324:
          Uci.putInt(paramString, Uck);
          break label128;
        }
        if ((locala.width <= 0) || (locala.height <= 0))
        {
          Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("cannot get video width/height path:", paramString));
          h.OAn.p(1372L, 2L, 1L);
          continue;
        }
        if (locala.eGw > 0.0F) {
          continue;
        }
        Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("cannot get video fps path:", paramString));
        h.OAn.p(1372L, 3L, 1L);
        continue;
      }
      if (locala.Lam)
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", s.X("video is h265 path:", paramString));
        h.OAn.p(1371L, 25L, 1L);
      }
      if ((locala.width >= 2000) || (locala.height >= 2000))
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "video high resolution:[" + locala.width + ", " + locala.height + "], path:" + paramString);
        h.OAn.p(1371L, 26L, 1L);
      }
      if (locala.eGw >= 40.0F)
      {
        Log.i("MicroMsg.MultiMediaIDKeyStat", "video high fps:" + locala.eGw + ", path:" + paramString);
        h.OAn.p(1371L, 27L, 1L);
      }
      h.OAn.p(1371L, 12L, locala.eGw);
      h.OAn.p(1371L, 13L, 1L);
    }
    label633:
    AppMethodBeat.o(283738);
  }
  
  public static void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(283766);
    if (!paramBoolean1) {
      if (paramBoolean2) {
        paramInt = 90;
      }
    }
    for (;;)
    {
      h.OAn.p(1371L, paramInt, 1L);
      AppMethodBeat.o(283766);
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
  
  public static void hRN()
  {
    AppMethodBeat.i(283778);
    h.OAn.p(1371L, 117L, 1L);
    AppMethodBeat.o(283778);
  }
  
  public static void hRO()
  {
    AppMethodBeat.i(283779);
    h.OAn.p(1371L, 118L, 1L);
    AppMethodBeat.o(283779);
  }
  
  public static void hRP()
  {
    AppMethodBeat.i(283782);
    h.OAn.p(1371L, 119L, 1L);
    AppMethodBeat.o(283782);
  }
  
  public static void hRQ()
  {
    AppMethodBeat.i(283787);
    h.OAn.p(1371L, 127L, 1L);
    AppMethodBeat.o(283787);
  }
  
  public static void lL(List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    AppMethodBeat.i(283771);
    s.u(paramList, "itemList");
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
            break label215;
          }
          paramList = paramList.iterator();
          label101:
          if (!paramList.hasNext()) {
            break label215;
          }
          localObject = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)paramList.next();
          if (!(localObject instanceof r)) {
            break label210;
          }
          if (((CharSequence)((r)localObject).mAD).length() <= 0) {
            break label205;
          }
          j = 1;
          label147:
          if (j == 0) {
            break label210;
          }
          j = 1;
          label153:
          if (j == 0) {
            break label213;
          }
        }
      }
    }
    label205:
    label210:
    label213:
    label215:
    for (int j = 1;; j = 0)
    {
      if (i != 0) {
        h.OAn.p(1371L, 104L, 1L);
      }
      if (j != 0) {
        h.OAn.p(1371L, 105L, 1L);
      }
      AppMethodBeat.o(283771);
      return;
      i = 0;
      break;
      j = 0;
      break label147;
      j = 0;
      break label153;
      break label101;
    }
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(283785);
    h.OAn.p(1371L, paramLong, 1L);
    AppMethodBeat.o(283785);
  }
  
  public static void wD(long paramLong)
  {
    AppMethodBeat.i(283783);
    h.OAn.p(1371L, 121L, paramLong);
    h.OAn.p(1371L, 122L, 1L);
    AppMethodBeat.o(283783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.a
 * JD-Core Version:    0.7.0.1
 */