package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/AdaptiveAdjustBitrateHelper;", "", "()V", "TAG", "", "getABAResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "videoList", "", "Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "", "targetHeight", "addStickers", "", "sortVideoBitrate", "", "abaParamList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-vlog_release"})
public final class c
{
  public static final c GwZ;
  private static final String TAG = "MicroMsg.AdaptiveAdjustBitrateHelper";
  
  static
  {
    AppMethodBeat.i(190483);
    GwZ = new c();
    TAG = "MicroMsg.AdaptiveAdjustBitrateHelper";
    AppMethodBeat.o(190483);
  }
  
  public static a a(List<b> paramList, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(190482);
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
          break label296;
        }
        i = 1;
        if ((i == 0) || (paramVideoTransPara.iTg != 1)) {
          break;
        }
        paramList = ((Iterable)paramList).iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (b)paramList.next();
        localObject = AdaptiveAdjustBitrate.a(((b)localObject).path, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, (float)(((b)localObject).GwY - ((b)localObject).GwX) / 1000.0F, (float)((b)localObject).GwX / 1000.0F, 4, paramVideoTransPara.iTi, paramVideoTransPara.iTj, paramVideoTransPara.iTk, paramVideoTransPara.iTl, paramVideoTransPara.iTm, paramVideoTransPara.iTn, paramVideoTransPara.iTo, paramBoolean);
        j = paramVideoTransPara.videoBitrate;
        i = -1;
        if (localObject == null) {
          break label400;
        }
        j = localObject[0] * 1000;
        i = 0;
      }
      catch (Throwable paramList)
      {
        int j;
        paramList = new a(-1, 0, 0, 0, null);
        AppMethodBeat.o(190482);
        return paramList;
      }
      Log.i(TAG, "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + m);
      if (o.bhk() != null) {
        e.s((int[])localObject);
      }
      if (i != -1)
      {
        localArrayList.add(new a(i, k, m, j, (int[])localObject));
        continue;
        label296:
        i = 0;
      }
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) && (paramVideoTransPara.iTg == 1))
      {
        j.a((List)localArrayList, (Comparator)a.Gxa);
        paramList = localArrayList.get(0);
        p.g(paramList, "abaParamList[0]");
        paramList = (a)paramList;
        AppMethodBeat.o(190482);
        return paramList;
      }
      paramList = new a(-1, 0, 0, 0, new int[34]);
      AppMethodBeat.o(190482);
      return paramList;
      label400:
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class a<T>
    implements Comparator<a>
  {
    public static final a Gxa;
    
    static
    {
      AppMethodBeat.i(190481);
      Gxa = new a();
      AppMethodBeat.o(190481);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.c
 * JD-Core Version:    0.7.0.1
 */