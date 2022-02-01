package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/report/MultiMediaIDKeyStat;", "", "()V", "DATA_ID", "", "ERR_ID", "HighFpsLimit", "", "HighResolutionLimit", "MuxStateResumeFromPrevious", "MuxStateStart", "MuxStateUnknown", "TAG", "", "muxReportMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "finishMux", "", "path", "cost", "hasOriginSound", "", "hasMusic", "markGetFrameThumbFailed", "markGetFrameThumbNull", "markMuxTrackCount", "count", "videoAndImage", "muxErrCode", "code", "pathListHashKey", "pathList", "", "reportCompositionInfo", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "reportEditItem", "itemList", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "reportMuxResult", "background", "success", "retryCount", "startMux", "outputPath", "plugin-vlog_release"})
public final class a
{
  private static final ax BHK;
  private static final int BHL = 0;
  private static final int BHM = 1;
  private static final int BHN = 2;
  public static final a BHO;
  
  static
  {
    AppMethodBeat.i(195889);
    BHO = new a();
    BHK = ax.aQz("MultiMediaIDKeyStatMuxMark");
    BHM = 1;
    BHN = 2;
    AppMethodBeat.o(195889);
  }
  
  public static void TB(int paramInt)
  {
    AppMethodBeat.i(195885);
    ad.i("MicroMsg.MultiMediaIDKeyStat", "muxErrCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      g.yhR.n(1372L, 16L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -10: 
      g.yhR.n(1372L, 5L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -11: 
      g.yhR.n(1372L, 6L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -14: 
      g.yhR.n(1372L, 8L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -15: 
      g.yhR.n(1372L, 9L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -101: 
      g.yhR.n(1372L, 30L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -102: 
      g.yhR.n(1372L, 31L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -103: 
      g.yhR.n(1372L, 32L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -104: 
      g.yhR.n(1372L, 33L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -110: 
      g.yhR.n(1372L, 34L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -111: 
      g.yhR.n(1372L, 35L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -112: 
      g.yhR.n(1372L, 36L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -113: 
      g.yhR.n(1372L, 37L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -121: 
      g.yhR.n(1372L, 38L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -122: 
      g.yhR.n(1372L, 39L, 1L);
      AppMethodBeat.o(195885);
      return;
    case -123: 
      g.yhR.n(1372L, 40L, 1L);
      AppMethodBeat.o(195885);
      return;
    }
    g.yhR.n(1372L, 41L, 1L);
    AppMethodBeat.o(195885);
  }
  
  public static void aK(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(195882);
    ad.i("MicroMsg.MultiMediaIDKeyStat", "markMuxTrackCount, count:" + paramInt + ", videoAndImage:" + paramBoolean);
    if (paramBoolean) {
      g.yhR.n(1371L, 2L, 1L);
    }
    if (paramInt <= 1)
    {
      g.yhR.n(1371L, 3L, 1L);
      AppMethodBeat.o(195882);
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
      g.yhR.n(1371L, 6L, 1L);
      AppMethodBeat.o(195882);
      return;
      if (3 < paramInt) {
        break;
      }
      g.yhR.n(1371L, 4L, 1L);
      AppMethodBeat.o(195882);
      return;
    }
    g.yhR.n(1371L, 5L, 1L);
    AppMethodBeat.o(195882);
  }
  
  public static void b(v paramv)
  {
    AppMethodBeat.i(195888);
    p.h(paramv, "composition");
    Object localObject = (Iterable)paramv.BGl;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((w)((Iterator)localObject).next()).esl());
    }
    for (int i = 1;; i = 0)
    {
      boolean bool = paramv.BGn;
      if (i != 0) {
        g.yhR.A(1371L, 106L);
      }
      if (bool) {
        g.yhR.A(1371L, 107L);
      }
      AppMethodBeat.o(195888);
      return;
    }
  }
  
  public static void b(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195884);
    p.h(paramString, "path");
    ad.i("MicroMsg.MultiMediaIDKeyStat", "finishMux:" + paramString + ", cost:" + paramLong + ", hasOriginSound:" + paramBoolean1 + ", hasMusic:" + paramBoolean2);
    int i = 0;
    if (!i.fv(paramString))
    {
      ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux file not exist path:".concat(String.valueOf(paramString)));
      g.yhR.n(1372L, 18L, 1L);
      i = 1;
    }
    MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.BFV.aDk(paramString);
    int j;
    if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.cvL <= 0.0F)) {
      if (locala == null)
      {
        ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo path:".concat(String.valueOf(paramString)));
        g.yhR.n(1372L, 19L, 1L);
        j = 0;
        label181:
        if (BHK.getInt(paramString, BHL) == BHN)
        {
          if (j == 0) {
            break label1361;
          }
          ad.i("MicroMsg.MultiMediaIDKeyStat", "finishMux error is resume from previous");
          g.yhR.n(1371L, 101L, 1L);
        }
      }
    }
    for (;;)
    {
      BHK.remove(paramString);
      AppMethodBeat.o(195884);
      return;
      if ((locala.width <= 0) || (locala.height <= 0))
      {
        ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo width/height path:".concat(String.valueOf(paramString)));
        g.yhR.n(1372L, 20L, 1L);
        break;
      }
      if (locala.cvL > 0.0F) {
        break;
      }
      ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo fps path:".concat(String.valueOf(paramString)));
      g.yhR.n(1372L, 21L, 1L);
      break;
      g.yhR.n(1371L, 1L, 1L);
      g.yhR.n(1371L, 62L, paramLong);
      g.yhR.n(1371L, 63L, 1L);
      g.yhR.n(1371L, 16L, locala.cvL);
      g.yhR.n(1371L, 17L, 1L);
      label415:
      long l;
      if ((paramBoolean1) && (!paramBoolean2))
      {
        g.yhR.n(1371L, 20L, 1L);
        ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux video duration:" + locala.duration);
        l = locala.duration / 1000L;
        if (0L <= l) {
          break label741;
        }
        label459:
        if (11L <= l) {
          break label855;
        }
        label468:
        if (21L <= l) {
          break label969;
        }
        label477:
        if (31L <= l) {
          break label1083;
        }
        label486:
        if (41L <= l) {
          break label1197;
        }
        label495:
        j = i;
        if (51L > l) {
          break label181;
        }
        j = i;
        if (60L < l) {
          break label181;
        }
        if ((paramBoolean1) || (paramBoolean2)) {
          break label1311;
        }
        g.yhR.n(1371L, 34L, 1L);
      }
      for (;;)
      {
        g.yhR.n(1371L, 86L, paramLong);
        g.yhR.n(1371L, 87L, 1L);
        j = i;
        break;
        if ((!paramBoolean1) && (!paramBoolean2))
        {
          g.yhR.n(1371L, 21L, 1L);
          g.yhR.n(1371L, 36L, locala.duration);
          g.yhR.n(1371L, 37L, 1L);
          break label415;
        }
        if ((paramBoolean1) && (paramBoolean2))
        {
          g.yhR.n(1371L, 22L, 1L);
          g.yhR.n(1371L, 47L, locala.duration);
          g.yhR.n(1371L, 48L, 1L);
          break label415;
        }
        if ((paramBoolean1) || (!paramBoolean2)) {
          break label415;
        }
        g.yhR.n(1371L, 23L, 1L);
        g.yhR.n(1371L, 58L, locala.duration);
        g.yhR.n(1371L, 59L, 1L);
        break label415;
        label741:
        if (10L < l) {
          break label459;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yhR.n(1371L, 29L, 1L);
        }
        for (;;)
        {
          g.yhR.n(1371L, 66L, paramLong);
          g.yhR.n(1371L, 67L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 40L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 51L, 1L);
          }
        }
        label855:
        if (20L < l) {
          break label468;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yhR.n(1371L, 30L, 1L);
        }
        for (;;)
        {
          g.yhR.n(1371L, 70L, paramLong);
          g.yhR.n(1371L, 71L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 41L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 52L, 1L);
          }
        }
        label969:
        if (30L < l) {
          break label477;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yhR.n(1371L, 31L, 1L);
        }
        for (;;)
        {
          g.yhR.n(1371L, 74L, paramLong);
          g.yhR.n(1371L, 75L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 42L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 53L, 1L);
          }
        }
        label1083:
        if (40L < l) {
          break label486;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yhR.n(1371L, 32L, 1L);
        }
        for (;;)
        {
          g.yhR.n(1371L, 78L, paramLong);
          g.yhR.n(1371L, 79L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 43L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 54L, 1L);
          }
        }
        label1197:
        if (50L < l) {
          break label495;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          g.yhR.n(1371L, 33L, 1L);
        }
        for (;;)
        {
          g.yhR.n(1371L, 82L, paramLong);
          g.yhR.n(1371L, 83L, 1L);
          j = i;
          break;
          if ((paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 44L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            g.yhR.n(1371L, 55L, 1L);
          }
        }
        label1311:
        if ((paramBoolean1) && (paramBoolean2)) {
          g.yhR.n(1371L, 45L, 1L);
        } else if ((!paramBoolean1) && (paramBoolean2)) {
          g.yhR.n(1371L, 56L, 1L);
        }
      }
      label1361:
      ad.i("MicroMsg.MultiMediaIDKeyStat", "finishMux success is resume from previous");
      g.yhR.n(1371L, 100L, 1L);
    }
  }
  
  public static void d(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(195886);
    if (!paramBoolean1) {
      if (paramBoolean2) {
        paramInt = 90;
      }
    }
    for (;;)
    {
      g.yhR.n(1371L, paramInt, 1L);
      AppMethodBeat.o(195886);
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
  
  public static void gE(List<? extends com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramList)
  {
    int k = 1;
    AppMethodBeat.i(195887);
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
          if (((CharSequence)((q)localObject).xNN).length() <= 0) {
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
        g.yhR.A(1371L, 104L);
      }
      if (j != 0) {
        g.yhR.A(1371L, 105L);
      }
      AppMethodBeat.o(195887);
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
    AppMethodBeat.i(195883);
    p.h(paramList, "pathList");
    p.h(paramString, "outputPath");
    ad.i("MicroMsg.MultiMediaIDKeyStat", "startMux, pathList:" + paramList + ", outputPath:" + paramString);
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label603;
      }
      if (BHK.getInt(paramString, BHL) != BHM) {
        break label296;
      }
      ad.i("MicroMsg.MultiMediaIDKeyStat", "check mux may be resume from previous error");
      BHK.putInt(paramString, BHN);
      g.yhR.n(1371L, 99L, 1L);
      label118:
      g.yhR.n(1371L, 0L, 1L);
      g.yhR.n(1371L, 8L, paramList.size());
      g.yhR.n(1371L, 9L, 1L);
      paramList = ((Iterable)paramList).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label603;
      }
      paramString = (String)paramList.next();
      if (!i.fv(paramString)) {
        g.yhR.n(1372L, 1L, 0L);
      }
      MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.BFV.aDk(paramString);
      ad.i("MicroMsg.MultiMediaIDKeyStat", "startMux, videoInfo:".concat(String.valueOf(locala)));
      if ((locala == null) || (locala.width <= 0) || (locala.height <= 0) || (locala.cvL <= 0.0F))
      {
        if (locala == null)
        {
          ad.i("MicroMsg.MultiMediaIDKeyStat", "cannot get videoInfo path:".concat(String.valueOf(paramString)));
          g.yhR.n(1372L, 0L, 1L);
          continue;
          i = 0;
          break;
          label296:
          BHK.putInt(paramString, BHM);
          break label118;
        }
        if ((locala.width <= 0) || (locala.height <= 0))
        {
          ad.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video width/height path:".concat(String.valueOf(paramString)));
          g.yhR.n(1372L, 2L, 1L);
          continue;
        }
        if (locala.cvL > 0.0F) {
          continue;
        }
        ad.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video fps path:".concat(String.valueOf(paramString)));
        g.yhR.n(1372L, 3L, 1L);
        continue;
      }
      if (locala.vTf)
      {
        ad.i("MicroMsg.MultiMediaIDKeyStat", "video is h265 path:".concat(String.valueOf(paramString)));
        g.yhR.n(1371L, 25L, 1L);
      }
      if ((locala.width >= 2000) || (locala.height >= 2000))
      {
        ad.i("MicroMsg.MultiMediaIDKeyStat", "video high resolution:[" + locala.width + ", " + locala.height + "], path:" + paramString);
        g.yhR.n(1371L, 26L, 1L);
      }
      if (locala.cvL >= 40.0F)
      {
        ad.i("MicroMsg.MultiMediaIDKeyStat", "video high fps:" + locala.cvL + ", path:" + paramString);
        g.yhR.n(1371L, 27L, 1L);
      }
      g.yhR.n(1371L, 12L, locala.cvL);
      g.yhR.n(1371L, 13L, 1L);
    }
    label603:
    AppMethodBeat.o(195883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.a
 * JD-Core Version:    0.7.0.1
 */