package com.tencent.mm.plugin.vlog.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.model.r.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/report/MultiMediaIDKeyStat;", "", "()V", "DATA_ID", "", "ERR_ID", "HighFpsLimit", "", "HighResolutionLimit", "TAG", "", "finishMux", "", "path", "cost", "hasOriginSound", "", "hasMusic", "markGetFrameThumbFailed", "markGetFrameThumbNull", "markMuxTrackCount", "count", "videoAndImage", "muxErrCode", "code", "reportMuxResult", "background", "success", "retryCount", "startMux", "pathList", "", "plugin-vlog_release"})
public final class a
{
  public static final a LrI;
  
  static
  {
    AppMethodBeat.i(200961);
    LrI = new a();
    AppMethodBeat.o(200961);
  }
  
  public static void aih(int paramInt)
  {
    AppMethodBeat.i(200957);
    ad.i("MicroMsg.MultiMediaIDKeyStat", "muxErrCode:".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 5L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 6L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 7L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 8L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 9L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 10L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 11L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 12L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 13L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 14L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 15L, 1L);
      AppMethodBeat.o(200957);
      return;
      h.vKh.m(1372L, 16L, 1L);
    }
  }
  
  public static void b(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(200956);
    k.h(paramString, "path");
    ad.i("MicroMsg.MultiMediaIDKeyStat", "finishMux:" + paramString + ", cost:" + paramLong + ", hasOriginSound:" + paramBoolean1 + ", hasMusic:" + paramBoolean2);
    if (!i.eK(paramString))
    {
      ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux file not exist path:".concat(String.valueOf(paramString)));
      h.vKh.m(1372L, 18L, 1L);
    }
    Object localObject = r.LqC;
    localObject = r.aVP(paramString);
    if ((localObject == null) || (((r.a)localObject).width <= 0) || (((r.a)localObject).height <= 0) || (((r.a)localObject).coh <= 0.0F))
    {
      if (localObject == null)
      {
        ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo path:".concat(String.valueOf(paramString)));
        h.vKh.m(1372L, 19L, 1L);
        AppMethodBeat.o(200956);
        return;
      }
      if ((((r.a)localObject).width <= 0) || (((r.a)localObject).height <= 0))
      {
        ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo width/height path:".concat(String.valueOf(paramString)));
        h.vKh.m(1372L, 20L, 1L);
        AppMethodBeat.o(200956);
        return;
      }
      if (((r.a)localObject).coh <= 0.0F)
      {
        ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux cannot get videoInfo fps path:".concat(String.valueOf(paramString)));
        h.vKh.m(1372L, 21L, 1L);
      }
      AppMethodBeat.o(200956);
      return;
    }
    h.vKh.m(1371L, 1L, 1L);
    h.vKh.m(1371L, 62L, paramLong);
    h.vKh.m(1371L, 63L, 1L);
    h.vKh.m(1371L, 16L, ((r.a)localObject).coh);
    h.vKh.m(1371L, 17L, 1L);
    long l;
    if ((paramBoolean1) && (!paramBoolean2))
    {
      h.vKh.m(1371L, 20L, 1L);
      ad.i("MicroMsg.MultiMediaIDKeyStat", "finish mux video duration:" + ((r.a)localObject).duration);
      l = ((r.a)localObject).duration;
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
        AppMethodBeat.o(200956);
        return;
        if ((!paramBoolean1) && (!paramBoolean2))
        {
          h.vKh.m(1371L, 21L, 1L);
          h.vKh.m(1371L, 36L, ((r.a)localObject).duration);
          h.vKh.m(1371L, 37L, 1L);
          break;
        }
        if ((paramBoolean1) && (paramBoolean2))
        {
          h.vKh.m(1371L, 22L, 1L);
          h.vKh.m(1371L, 47L, ((r.a)localObject).duration);
          h.vKh.m(1371L, 48L, 1L);
          break;
        }
        if ((paramBoolean1) || (!paramBoolean2)) {
          break;
        }
        h.vKh.m(1371L, 23L, 1L);
        h.vKh.m(1371L, 58L, ((r.a)localObject).duration);
        h.vKh.m(1371L, 59L, 1L);
        break;
        label611:
        if (10L < l) {
          break label395;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.vKh.m(1371L, 29L, 1L);
        }
        for (;;)
        {
          h.vKh.m(1371L, 66L, paramLong);
          h.vKh.m(1371L, 67L, 1L);
          AppMethodBeat.o(200956);
          return;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.vKh.m(1371L, 40L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.vKh.m(1371L, 51L, 1L);
          }
        }
        label724:
        if (20L < l) {
          break label404;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.vKh.m(1371L, 30L, 1L);
        }
        for (;;)
        {
          h.vKh.m(1371L, 70L, paramLong);
          h.vKh.m(1371L, 71L, 1L);
          AppMethodBeat.o(200956);
          return;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.vKh.m(1371L, 41L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.vKh.m(1371L, 52L, 1L);
          }
        }
        label837:
        if (30L < l) {
          break label413;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.vKh.m(1371L, 31L, 1L);
        }
        for (;;)
        {
          h.vKh.m(1371L, 74L, paramLong);
          h.vKh.m(1371L, 75L, 1L);
          AppMethodBeat.o(200956);
          return;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.vKh.m(1371L, 42L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.vKh.m(1371L, 53L, 1L);
          }
        }
        label950:
        if (40L < l) {
          break label422;
        }
        if ((!paramBoolean1) && (!paramBoolean2)) {
          h.vKh.m(1371L, 32L, 1L);
        }
        for (;;)
        {
          h.vKh.m(1371L, 78L, paramLong);
          h.vKh.m(1371L, 79L, 1L);
          AppMethodBeat.o(200956);
          return;
          if ((paramBoolean1) && (paramBoolean2)) {
            h.vKh.m(1371L, 43L, 1L);
          } else if ((!paramBoolean1) && (paramBoolean2)) {
            h.vKh.m(1371L, 54L, 1L);
          }
        }
        label1063:
        if (50L >= l)
        {
          if ((!paramBoolean1) && (!paramBoolean2)) {
            h.vKh.m(1371L, 33L, 1L);
          }
          for (;;)
          {
            h.vKh.m(1371L, 82L, paramLong);
            h.vKh.m(1371L, 83L, 1L);
            AppMethodBeat.o(200956);
            return;
            if ((paramBoolean1) && (paramBoolean2)) {
              h.vKh.m(1371L, 44L, 1L);
            } else if ((!paramBoolean1) && (paramBoolean2)) {
              h.vKh.m(1371L, 55L, 1L);
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
      h.vKh.m(1371L, 34L, 1L);
    }
    for (;;)
    {
      h.vKh.m(1371L, 86L, paramLong);
      h.vKh.m(1371L, 87L, 1L);
      AppMethodBeat.o(200956);
      return;
      label1239:
      if ((paramBoolean1) && (paramBoolean2)) {
        h.vKh.m(1371L, 45L, 1L);
      } else if ((!paramBoolean1) && (paramBoolean2)) {
        h.vKh.m(1371L, 56L, 1L);
      }
    }
  }
  
  public static void bh(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(200954);
    ad.i("MicroMsg.MultiMediaIDKeyStat", "markMuxTrackCount, count:" + paramInt + ", videoAndImage:" + paramBoolean);
    if (paramBoolean) {
      h.vKh.m(1371L, 2L, 1L);
    }
    if (paramInt <= 1)
    {
      h.vKh.m(1371L, 3L, 1L);
      AppMethodBeat.o(200954);
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
      h.vKh.m(1371L, 6L, 1L);
      AppMethodBeat.o(200954);
      return;
      if (3 < paramInt) {
        break;
      }
      h.vKh.m(1371L, 4L, 1L);
      AppMethodBeat.o(200954);
      return;
    }
    h.vKh.m(1371L, 5L, 1L);
    AppMethodBeat.o(200954);
  }
  
  public static void e(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(200958);
    if (!paramBoolean1) {
      if (paramBoolean2) {
        paramInt = 90;
      }
    }
    for (;;)
    {
      h.vKh.m(1371L, paramInt, 1L);
      AppMethodBeat.o(200958);
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
  
  public static void fYS()
  {
    AppMethodBeat.i(200959);
    ad.i("MicroMsg.MultiMediaIDKeyStat", "markGetFrameThumbNull");
    h.vKh.m(1372L, 23L, 1L);
    AppMethodBeat.o(200959);
  }
  
  public static void fYT()
  {
    AppMethodBeat.i(200960);
    ad.i("MicroMsg.MultiMediaIDKeyStat", "markGetFrameThumbNull");
    h.vKh.m(1372L, 24L, 1L);
    AppMethodBeat.o(200960);
  }
  
  public static void jc(List<String> paramList)
  {
    AppMethodBeat.i(200955);
    k.h(paramList, "pathList");
    ad.i("MicroMsg.MultiMediaIDKeyStat", "startMux, pathList:".concat(String.valueOf(paramList)));
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if (i != 0)
      {
        h.vKh.m(1371L, 0L, 1L);
        h.vKh.m(1371L, 8L, paramList.size());
        h.vKh.m(1371L, 9L, 1L);
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
        if (!i.eK(str)) {
          h.vKh.m(1372L, 1L, 0L);
        }
        Object localObject = r.LqC;
        localObject = r.aVP(str);
        if ((localObject == null) || (((r.a)localObject).width <= 0) || (((r.a)localObject).height <= 0) || (((r.a)localObject).coh <= 0.0F))
        {
          if (localObject == null)
          {
            ad.i("MicroMsg.MultiMediaIDKeyStat", "cannot get videoInfo path:".concat(String.valueOf(str)));
            h.vKh.m(1372L, 0L, 1L);
            continue;
            i = 0;
            break;
          }
          if ((((r.a)localObject).width <= 0) || (((r.a)localObject).height <= 0))
          {
            ad.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video width/height path:".concat(String.valueOf(str)));
            h.vKh.m(1372L, 2L, 1L);
            continue;
          }
          if (((r.a)localObject).coh > 0.0F) {
            continue;
          }
          ad.i("MicroMsg.MultiMediaIDKeyStat", "cannot get video fps path:".concat(String.valueOf(str)));
          h.vKh.m(1372L, 3L, 1L);
          continue;
        }
        if (((r.a)localObject).tHz)
        {
          ad.i("MicroMsg.MultiMediaIDKeyStat", "video is h265 path:".concat(String.valueOf(str)));
          h.vKh.m(1371L, 25L, 1L);
        }
        if ((((r.a)localObject).width >= 2000) || (((r.a)localObject).height >= 2000))
        {
          ad.i("MicroMsg.MultiMediaIDKeyStat", "video high resolution:[" + ((r.a)localObject).width + ", " + ((r.a)localObject).height + "], path:" + str);
          h.vKh.m(1371L, 26L, 1L);
        }
        if (((r.a)localObject).coh >= 40.0F)
        {
          ad.i("MicroMsg.MultiMediaIDKeyStat", "video high fps:" + ((r.a)localObject).coh + ", path:" + str);
          h.vKh.m(1371L, 27L, 1L);
        }
        h.vKh.m(1371L, 12L, ((r.a)localObject).coh);
        h.vKh.m(1371L, 13L, 1L);
      }
    }
    label503:
    AppMethodBeat.o(200955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.a.a
 * JD-Core Version:    0.7.0.1
 */