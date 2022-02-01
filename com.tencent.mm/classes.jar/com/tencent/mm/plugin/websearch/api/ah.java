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
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class ah
{
  public static cbl DCe;
  
  public static void aFS(String paramString)
  {
    AppMethodBeat.i(117732);
    if (b.FU((String)g.ajC().ajl().get(274436, null)))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (!w.zE(paramString))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (DCe == null) {
      eMm();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < DCe.nDj.size())
    {
      localObject2 = (cbk)DCe.nDj.get(i);
      long l2 = (l1 - ((cbk)localObject2).GVB) / 86400000L;
      ((cbk)localObject2).GVA *= Math.pow(0.98D, l2);
      ((cbk)localObject2).GVB = (l2 * 86400000L + ((cbk)localObject2).GVB);
      ad.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((cbk)localObject2).GVA), Long.valueOf(((cbk)localObject2).GVB), ((cbk)localObject2).Username });
      if (!((cbk)localObject2).Username.equals(paramString)) {
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
        localObject1 = new cbk();
        ((cbk)localObject1).GVA = 1.0D;
        ((cbk)localObject1).GVB = l1;
        ((cbk)localObject1).Username = paramString;
        DCe.nDj.add(localObject1);
        ad.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(DCe.nDj, new Comparator() {});
        i = DCe.nDj.size() - 1;
        while ((i < DCe.nDj.size()) && (DCe.nDj.size() > 8))
        {
          if (((cbk)DCe.nDj.get(i)).GVA < 0.5D) {
            DCe.nDj.remove(i);
          }
          i += 1;
        }
        ((cbk)localObject1).GVA += 1.0D;
        ad.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((cbk)localObject1).GVA) });
      }
      paramString = aj.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = bnU();
        localObject2 = Base64.encodeToString(DCe.toByteArray(), 0);
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
  
  public static String bnU()
  {
    AppMethodBeat.i(117731);
    String str = "key_pb_most_search_biz_list" + u.aAm();
    AppMethodBeat.o(117731);
    return str;
  }
  
  public static cbl eMm()
  {
    AppMethodBeat.i(117730);
    Object localObject;
    if (DCe == null)
    {
      localObject = bnU();
      DCe = new cbl();
    }
    try
    {
      localObject = aj.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!bt.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        DCe.parseFrom((byte[])localObject);
      }
      label67:
      if (b.FU((String)g.ajC().ajl().get(274436, null))) {
        DCe.nDj.clear();
      }
      localObject = DCe;
      AppMethodBeat.o(117730);
      return localObject;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ah
 * JD-Core Version:    0.7.0.1
 */