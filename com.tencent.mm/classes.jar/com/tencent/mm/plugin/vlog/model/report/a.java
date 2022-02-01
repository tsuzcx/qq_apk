package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.model.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/report/MultiMediaIDKeyStat;", "", "()V", "DATA_ID", "", "ERR_ID", "HighFpsLimit", "", "HighResolutionLimit", "TAG", "", "finishMux", "", "path", "cost", "hasOriginSound", "", "hasMusic", "markGetFrameThumbFailed", "markGetFrameThumbNull", "markMuxTrackCount", "count", "videoAndImage", "muxErrCode", "code", "reportMuxResult", "background", "success", "retryCount", "startMux", "pathList", "", "plugin-vlog_release"})
public final class a
{
  public static final a Apq;
  
  static
  {
    AppMethodBeat.i(207647);
    Apq = new a();
    AppMethodBeat.o(207647);
  }
  
  public static void RR(int paramInt)
  {
    AppMethodBeat.i(207643);
    ac.i("MicroMsg.MultiMediaIDKeyStat", "muxErrCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 5L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 6L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 7L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 8L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 9L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 10L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 11L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 12L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 13L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 14L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 15L, 1L);
      AppMethodBeat.o(207643);
      return;
      h.wUl.n(1372L, 16L, 1L);
    }
  }
  
  public static void aF(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(207640);
    ac.i("MicroMsg.MultiMediaIDKeyStat", "markMuxTrackCount, count:" + paramInt + ", videoAndImage:" + paramBoolean);
    if (paramBoolean) {
      h.wUl.n(1371L, 2L, 1L);
    }
    if (paramInt <= 1)
    {
      h.wUl.n(1371L, 3L, 1L);
      AppMethodBeat.o(207640);
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
      h.wUl.n(1371L, 6L, 1L);
      AppMethodBeat.o(207640);
      return;
      if (3 < paramInt) {
        break;
      }
      h.wUl.n(1371L, 4L, 1L);
      AppMethodBeat.o(207640);
      return;
    }
    h.wUl.n(1371L, 5L, 1L);
    AppMethodBeat.o(207640);
  }
  
  public static void b(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(207642);
    k.h(paramString, "path");
    ac.i("MicroMsg.MultiMediaIDKeyStat", "finishMux:" + paramString + ", cost:" + paramLong + ", hasOriginSound:" + paramBoolean1 + ", hasMusic:" + paramBoolean2);
    if (!i.eA(paramString))
    {
      ac.i("MicroMsg.MultiMediaIDKeyStat", "finish mux file not exist path:".concat(String.valueOf(paramString)));
      h.wUl.n(1372L, 18L, 1L);
    }
    Object localObject = com.tencent.mm.plugin.vlog.model.l.AnC;
    localObject = com.tencent.mm.plugin.vlog.model.l.aye(paramString);
    if ((localObject == null) || (((l.a)localObject).width <= 0) || (((l.a)localObject).height <= 0) || (((l.a)localObject).clj <= 0.0F))
    {
      if (localObject == null)
      {
        ac.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo path:".concat(String.valueOf(paramString)));
        h.wUl.n(1372L, 19L, 1L);
        AppMethodBeat.o(207642);
        return;
      }
      if ((((l.a)localObject).width <= 0) || (((l.a)localObject).height <= 0))
      {
        ac.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo width/height path:".concat(String.valueOf(paramString)));
        h.wUl.n(1372L, 20L, 1L);
        AppMethodBeat.o(207642);
        return;
      }
      if (((l.a)localObject).clj <= 0.0F)
      {
        ac.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo fps path:".concat(String.valueOf(paramString)));
        h.wUl.n(1372L, 21L, 1L);
      }
      AppMethodBeat.o(207642);
      return;
    }
    h.wUl.n(1371L, 1L, 1L);
    h.wUl.n(1371L, 62L, paramLong);
    h.wUl.n(1371L, 63L, 1L);
    h.wUl.n(1371L, 16L, ((l.a)localObject).clj);
    h.wUl.n(1371L, 17L, 1L);
    long l;
    if ((paramBoolean1) && (!paramBoolean2))
    {
      h.wUl.n(1371L, 20L, 1L);
      ac.i("MicroMsg.MultiMediaIDKeyStat", "finish mux video duration:" + ((l.a)localObject).duration);
      l = ((l.a)localObject).duration;
      if (0L <= l) {
        break label611;
      }
      label395:
      if (11L <= l) {
        break label724;
      }
      label404:
      if (21L <= l) {
        break label837;
      }
      label413:
      if (31L <= l) {
        break label950;
      }
      label422:
      if (41L <= l) {
        break label1063;
      }
    }
    for (;;)
    {
      if (51L > l)
      {
        AppMethodBeat.o(207642);
        return;
        if ((!paramBoolean1) && (!paramBoolean2))
        {
          h.wUl.n(1371L, 21L, 1L);
          h.wUl.n(1371L, 36L, ((l.a)localObject).duration);
          h.wUl.n(1371L, 37L, 1L);
          break;
        }
        if ((paramBoolean1) && (paramBoolean2))
        {
          h.wUl.n(1371L, 22L, 1L);
          h.wUl.n(1371L, 47L, ((l.a)localObject).duration);
          h.wUl.n(1371L, 48L, 1L);
          break;
        }
        if ((paramBoolean1) || (!paramBoolean2)) {
          break;
        }
        h.wUl.n(1371L, 23L, 1L);
        h.wUl.n(1371L, 58L, ((l.a)localObject).duration);
        h.wUl.n(1371L, 59L, 1L);
        break;
        label611:
        if (10L < l) {
          break label395;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.wUl.n(1371L, 29L, 1L);
        }
        for (;;)
        {
          h.wUl.n(1371L, 66L, paramLong);
          h.wUl.n(1371L, 67L, 1L);
          AppMethodBeat.o(207642);
          return;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.wUl.n(1371L, 40L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.wUl.n(1371L, 51L, 1L);
          }
        }
        label724:
        if (20L < l) {
          break label404;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.wUl.n(1371L, 30L, 1L);
        }
        for (;;)
        {
          h.wUl.n(1371L, 70L, paramLong);
          h.wUl.n(1371L, 71L, 1L);
          AppMethodBeat.o(207642);
          return;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.wUl.n(1371L, 41L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.wUl.n(1371L, 52L, 1L);
          }
        }
        label837:
        if (30L < l) {
          break label413;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.wUl.n(1371L, 31L, 1L);
        }
        for (;;)
        {
          h.wUl.n(1371L, 74L, paramLong);
          h.wUl.n(1371L, 75L, 1L);
          AppMethodBeat.o(207642);
          return;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.wUl.n(1371L, 42L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.wUl.n(1371L, 53L, 1L);
          }
        }
        label950:
        if (40L < l) {
          break label422;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.wUl.n(1371L, 32L, 1L);
        }
        for (;;)
        {
          h.wUl.n(1371L, 78L, paramLong);
          h.wUl.n(1371L, 79L, 1L);
          AppMethodBeat.o(207642);
          return;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.wUl.n(1371L, 43L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.wUl.n(1371L, 54L, 1L);
          }
        }
        label1063:
        if (50L >= l)
        {
          if ((!paramBoolean1) && (!paramBoolean2)) {
            h.wUl.n(1371L, 33L, 1L);
          }
          for (;;)
          {
            h.wUl.n(1371L, 82L, paramLong);
            h.wUl.n(1371L, 83L, 1L);
            AppMethodBeat.o(207642);
            return;
            if ((paramBoolean1) && (paramBoolean2)) {
              h.wUl.n(1371L, 44L, 1L);
            } else if ((!paramBoolean1) && (paramBoolean2)) {
              h.wUl.n(1371L, 55L, 1L);
            }
          }
        }
      }
    }
    if (60L >= l)
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        break label1239;
      }
      h.wUl.n(1371L, 34L, 1L);
    }
    for (;;)
    {
      h.wUl.n(1371L, 86L, paramLong);
      h.wUl.n(1371L, 87L, 1L);
      AppMethodBeat.o(207642);
      return;
      label1239:
      if ((paramBoolean1) && (paramBoolean2)) {
        h.wUl.n(1371L, 45L, 1L);
      } else if ((!paramBoolean1) && (paramBoolean2)) {
        h.wUl.n(1371L, 56L, 1L);
      }
    }
  }
  
  public static void d(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(207644);
    if (!paramBoolean1) {
      if (paramBoolean2) {
        paramInt = 90;
      }
    }
    for (;;)
    {
      h.wUl.n(1371L, paramInt, 1L);
      AppMethodBeat.o(207644);
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
  
  public static void efP()
  {
    AppMethodBeat.i(207645);
    ac.i("MicroMsg.MultiMediaIDKeyStat", "markGetFrameThumbNull");
    h.wUl.n(1372L, 23L, 1L);
    AppMethodBeat.o(207645);
  }
  
  public static void efQ()
  {
    AppMethodBeat.i(207646);
    ac.i("MicroMsg.MultiMediaIDKeyStat", "markGetFrameThumbNull");
    h.wUl.n(1372L, 24L, 1L);
    AppMethodBeat.o(207646);
  }
  
  public static void gt(List<String> paramList)
  {
    AppMethodBeat.i(207641);
    k.h(paramList, "pathList");
    ac.i("MicroMsg.MultiMediaIDKeyStat", "startMux, pathList:".concat(String.valueOf(paramList)));
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        h.wUl.n(1371L, 0L, 1L);
        h.wUl.n(1371L, 8L, paramList.size());
        h.wUl.n(1371L, 9L, 1L);
        paramList = ((Iterable)paramList).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label503;
        }
        String str = (String)paramList.next();
        if (!i.eA(str)) {
          h.wUl.n(1372L, 1L, 0L);
        }
        Object localObject = com.tencent.mm.plugin.vlog.model.l.AnC;
        localObject = com.tencent.mm.plugin.vlog.model.l.aye(str);
        if ((localObject == null) || (((l.a)localObject).width <= 0) || (((l.a)localObject).height <= 0) || (((l.a)localObject).clj <= 0.0F))
        {
          if (localObject == null)
          {
            ac.i("MicroMsg.MultiMediaIDKeyStat", "cannot get videoInfo path:".concat(String.valueOf(str)));
            h.wUl.n(1372L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
          if ((((l.a)localObject).width <= 0) || (((l.a)localObject).height <= 0))
          {
            ac.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video width/height path:".concat(String.valueOf(str)));
            h.wUl.n(1372L, 2L, 1L);
            continue;
          }
          if (((l.a)localObject).clj > 0.0F) {
            continue;
          }
          ac.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video fps path:".concat(String.valueOf(str)));
          h.wUl.n(1372L, 3L, 1L);
          continue;
        }
        if (((l.a)localObject).uPV)
        {
          ac.i("MicroMsg.MultiMediaIDKeyStat", "video is h265 path:".concat(String.valueOf(str)));
          h.wUl.n(1371L, 25L, 1L);
        }
        if ((((l.a)localObject).width >= 2000) || (((l.a)localObject).height >= 2000))
        {
          ac.i("MicroMsg.MultiMediaIDKeyStat", "video high resolution:[" + ((l.a)localObject).width + ", " + ((l.a)localObject).height + "], path:" + str);
          h.wUl.n(1371L, 26L, 1L);
        }
        if (((l.a)localObject).clj >= 40.0F)
        {
          ac.i("MicroMsg.MultiMediaIDKeyStat", "video high fps:" + ((l.a)localObject).clj + ", path:" + str);
          h.wUl.n(1371L, 27L, 1L);
        }
        h.wUl.n(1371L, 12L, ((l.a)localObject).clj);
        h.wUl.n(1371L, 13L, 1L);
      }
    }
    label503:
    AppMethodBeat.o(207641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.a
 * JD-Core Version:    0.7.0.1
 */