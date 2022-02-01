package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/AdaptiveAdjustBitrateHelper;", "", "()V", "TAG", "", "getABAResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "videoList", "", "Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "", "targetHeight", "sortVideoBitrate", "", "abaParamList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-vlog_release"})
public final class c
{
  public static final c BES;
  private static final String TAG = "MicroMsg.AdaptiveAdjustBitrateHelper";
  
  static
  {
    AppMethodBeat.i(195690);
    BES = new c();
    TAG = "MicroMsg.AdaptiveAdjustBitrateHelper";
    AppMethodBeat.o(195690);
  }
  
  public static a a(List<b> paramList, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195689);
    p.h(paramList, "videoList");
    p.h(paramVideoTransPara, "videoParams");
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject;
    int k;
    int m;
    for (;;)
    {
      try
      {
        if (((Collection)paramList).isEmpty()) {
          break label294;
        }
        i = 1;
        if ((i == 0) || (paramVideoTransPara.hVq != 1)) {
          break;
        }
        paramList = ((Iterable)paramList).iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (b)paramList.next();
        localObject = AdaptiveAdjustBitrate.a(((b)localObject).path, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, (float)(((b)localObject).BER - ((b)localObject).BEQ) / 1000.0F, (float)((b)localObject).BEQ / 1000.0F, 4, paramVideoTransPara.hVs, paramVideoTransPara.hVt, paramVideoTransPara.hVu, paramVideoTransPara.hVv, paramVideoTransPara.hVw, paramVideoTransPara.hVx, paramVideoTransPara.hVy);
        j = paramVideoTransPara.videoBitrate;
        i = -1;
        if (localObject == null) {
          break label398;
        }
        j = localObject[0] * 1000;
        i = 0;
      }
      catch (Throwable paramList)
      {
        int j;
        paramList = new a(-1, 0, 0, 0, null);
        AppMethodBeat.o(195689);
        return paramList;
      }
      ad.i(TAG, "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + m);
      if (o.aMK() != null) {
        e.q((int[])localObject);
      }
      if (i != -1)
      {
        localArrayList.add(new a(i, k, m, j, (int[])localObject));
        continue;
        label294:
        i = 0;
      }
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) && (paramVideoTransPara.hVq == 1))
      {
        j.a((List)localArrayList, (Comparator)a.BET);
        paramList = localArrayList.get(0);
        p.g(paramList, "abaParamList[0]");
        paramList = (a)paramList;
        AppMethodBeat.o(195689);
        return paramList;
      }
      paramList = new a(-1, 0, 0, 0, new int[28]);
      AppMethodBeat.o(195689);
      return paramList;
      label398:
      do
      {
        m = paramInt2;
        k = paramInt1;
        break;
      } while ((localObject == null) || (localObject[5] <= 0));
      k = localObject[1];
      m = localObject[2];
      i = 0;
      break;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class a<T>
    implements Comparator<a>
  {
    public static final a BET;
    
    static
    {
      AppMethodBeat.i(195688);
      BET = new a();
      AppMethodBeat.o(195688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.c
 * JD-Core Version:    0.7.0.1
 */