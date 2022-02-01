package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class af
{
  public static bse AGQ;
  
  public static void avh(String paramString)
  {
    AppMethodBeat.i(117732);
    if (b.yL((String)g.afB().afk().get(274436, null)))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (!w.sE(paramString))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (AGQ == null) {
      eib();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < AGQ.mAL.size())
    {
      localObject2 = (bsd)AGQ.mAL.get(i);
      long l2 = (l1 - ((bsd)localObject2).DPB) / 86400000L;
      ((bsd)localObject2).DPA *= Math.pow(0.98D, l2);
      ((bsd)localObject2).DPB = (l2 * 86400000L + ((bsd)localObject2).DPB);
      ad.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((bsd)localObject2).DPA), Long.valueOf(((bsd)localObject2).DPB), ((bsd)localObject2).Username });
      if (!((bsd)localObject2).Username.equals(paramString)) {
        break label479;
      }
      localObject1 = localObject2;
    }
    label479:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 == null)
      {
        localObject1 = new bsd();
        ((bsd)localObject1).DPA = 1.0D;
        ((bsd)localObject1).DPB = l1;
        ((bsd)localObject1).Username = paramString;
        AGQ.mAL.add(localObject1);
        ad.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(AGQ.mAL, new Comparator() {});
        i = AGQ.mAL.size() - 1;
        while ((i < AGQ.mAL.size()) && (AGQ.mAL.size() > 8))
        {
          if (((bsd)AGQ.mAL.get(i)).DPA < 0.5D) {
            AGQ.mAL.remove(i);
          }
          i += 1;
        }
        ((bsd)localObject1).DPA += 1.0D;
        ad.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((bsd)localObject1).DPA) });
      }
      paramString = aj.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = bdo();
        localObject2 = Base64.encodeToString(AGQ.toByteArray(), 0);
        paramString.edit().putString((String)localObject1, (String)localObject2).commit();
        ad.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", new Object[] { localObject2 });
        AppMethodBeat.o(117732);
        return;
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(117732);
        return;
      }
    }
  }
  
  public static String bdo()
  {
    AppMethodBeat.i(117731);
    String str = "key_pb_most_search_biz_list" + u.aqG();
    AppMethodBeat.o(117731);
    return str;
  }
  
  public static bse eib()
  {
    AppMethodBeat.i(117730);
    Object localObject;
    if (AGQ == null)
    {
      localObject = bdo();
      AGQ = new bse();
    }
    try
    {
      localObject = aj.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        AGQ.parseFrom((byte[])localObject);
      }
      label67:
      if (b.yL((String)g.afB().afk().get(274436, null))) {
        AGQ.mAL.clear();
      }
      localObject = AGQ;
      AppMethodBeat.o(117730);
      return localObject;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.af
 * JD-Core Version:    0.7.0.1
 */