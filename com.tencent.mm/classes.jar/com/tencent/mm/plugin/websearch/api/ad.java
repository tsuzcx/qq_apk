package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class ad
{
  public static bwv BZi;
  
  public static void aAy(String paramString)
  {
    AppMethodBeat.i(117732);
    if (b.CQ((String)g.agR().agA().get(274436, null)))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (!w.wH(paramString))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (BZi == null) {
      exv();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < BZi.ncM.size())
    {
      localObject2 = (bwu)BZi.ncM.get(i);
      long l2 = (l1 - ((bwu)localObject2).FlS) / 86400000L;
      ((bwu)localObject2).FlR *= Math.pow(0.98D, l2);
      ((bwu)localObject2).FlS = (l2 * 86400000L + ((bwu)localObject2).FlS);
      ac.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((bwu)localObject2).FlR), Long.valueOf(((bwu)localObject2).FlS), ((bwu)localObject2).Username });
      if (!((bwu)localObject2).Username.equals(paramString)) {
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
        localObject1 = new bwu();
        ((bwu)localObject1).FlR = 1.0D;
        ((bwu)localObject1).FlS = l1;
        ((bwu)localObject1).Username = paramString;
        BZi.ncM.add(localObject1);
        ac.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(BZi.ncM, new Comparator() {});
        i = BZi.ncM.size() - 1;
        while ((i < BZi.ncM.size()) && (BZi.ncM.size() > 8))
        {
          if (((bwu)BZi.ncM.get(i)).FlR < 0.5D) {
            BZi.ncM.remove(i);
          }
          i += 1;
        }
        ((bwu)localObject1).FlR += 1.0D;
        ac.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((bwu)localObject1).FlR) });
      }
      paramString = ai.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = bkj();
        localObject2 = Base64.encodeToString(BZi.toByteArray(), 0);
        paramString.edit().putString((String)localObject1, (String)localObject2).commit();
        ac.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", new Object[] { localObject2 });
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
  
  public static String bkj()
  {
    AppMethodBeat.i(117731);
    String str = "key_pb_most_search_biz_list" + u.axw();
    AppMethodBeat.o(117731);
    return str;
  }
  
  public static bwv exv()
  {
    AppMethodBeat.i(117730);
    Object localObject;
    if (BZi == null)
    {
      localObject = bkj();
      BZi = new bwv();
    }
    try
    {
      localObject = ai.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!bs.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        BZi.parseFrom((byte[])localObject);
      }
      label67:
      if (b.CQ((String)g.agR().agA().get(274436, null))) {
        BZi.ncM.clear();
      }
      localObject = BZi;
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
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ad
 * JD-Core Version:    0.7.0.1
 */