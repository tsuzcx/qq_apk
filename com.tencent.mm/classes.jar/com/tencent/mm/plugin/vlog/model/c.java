package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/AdaptiveAdjustBitrateHelper;", "", "()V", "TAG", "", "getABAResult", "Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "videoList", "", "Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "targetWidth", "", "targetHeight", "addStickers", "", "scene", "sortVideoBitrate", "", "abaParamList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c TXW;
  
  static
  {
    AppMethodBeat.i(283513);
    TXW = new c();
    TAG = "MicroMsg.AdaptiveAdjustBitrateHelper";
    AppMethodBeat.o(283513);
  }
  
  private static final int a(a parama1, a parama2)
  {
    AppMethodBeat.i(283506);
    if (parama1 == null)
    {
      parama1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ABAResult");
      AppMethodBeat.o(283506);
      throw parama1;
    }
    if (parama2 == null)
    {
      parama1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ABAResult");
      AppMethodBeat.o(283506);
      throw parama1;
    }
    int i = parama1.bitrate;
    int j = parama2.bitrate;
    if (j < i)
    {
      AppMethodBeat.o(283506);
      return -1;
    }
    if (i < j)
    {
      AppMethodBeat.o(283506);
      return 1;
    }
    AppMethodBeat.o(283506);
    return 0;
  }
  
  public static a a(List<b> paramList, VideoTransPara paramVideoTransPara, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    AppMethodBeat.i(283483);
    s.u(paramList, "videoList");
    s.u(paramVideoTransPara, "videoParams");
    ArrayList localArrayList = new ArrayList();
    int k;
    int m;
    for (;;)
    {
      float f;
      try
      {
        if (!((Collection)paramList).isEmpty())
        {
          i = 1;
          if ((i == 0) || (paramVideoTransPara.oCb != 1)) {
            break;
          }
          paramList = ((Iterable)paramList).iterator();
          if (!paramList.hasNext()) {
            break;
          }
          Object localObject = (b)paramList.next();
          f = 1.0F;
          if (paramVideoTransPara.oCh != 1) {
            break label342;
          }
          f = paramVideoTransPara.oCd;
          localObject = AdaptiveAdjustBitrate.a(((b)localObject).path, paramInt2, paramInt1, paramVideoTransPara.fps, paramVideoTransPara.videoBitrate, (float)(((b)localObject).TXV - ((b)localObject).TXU) / 1000.0F, (float)((b)localObject).TXU / 1000.0F, paramInt3, f, paramVideoTransPara.oCf, paramVideoTransPara.oCg, paramVideoTransPara.oCh, paramVideoTransPara.oCi, paramVideoTransPara.oCj, paramBoolean);
          int j = paramVideoTransPara.videoBitrate;
          i = -1;
          if (localObject != null)
          {
            j = ((ABAPrams)localObject).outputKbps * 1000;
            i = 0;
          }
          if ((localObject == null) || (((ABAPrams)localObject).resolutionAdjust <= 0)) {
            break label442;
          }
          k = ((ABAPrams)localObject).outputWidth;
          m = ((ABAPrams)localObject).outputHeight;
          i = 0;
          Log.i(TAG, "ABA:  finder video bitrate:" + j + " width: " + k + " height:" + m);
          if (v.bOi() != null) {
            j.a((ABAPrams)localObject);
          }
          if (i == -1) {
            continue;
          }
          localArrayList.add(new a(i, k, m, j, (ABAPrams)localObject));
          continue;
        }
        int i = 0;
      }
      finally
      {
        paramList = new a(-1, 0, 0, 0, null);
        AppMethodBeat.o(283483);
        return paramList;
      }
      continue;
      label342:
      if (paramVideoTransPara.oCh == 2) {
        f = paramVideoTransPara.oCe;
      }
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) && (paramVideoTransPara.oCb == 1))
      {
        p.a((List)localArrayList, c..ExternalSyntheticLambda0.INSTANCE);
        paramList = localArrayList.get(0);
        s.s(paramList, "abaParamList[0]");
        paramList = (a)paramList;
        AppMethodBeat.o(283483);
        return paramList;
      }
      paramList = new a(-1, 0, 0, 0, null);
      AppMethodBeat.o(283483);
      return paramList;
      label442:
      m = paramInt2;
      k = paramInt1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.c
 * JD-Core Version:    0.7.0.1
 */