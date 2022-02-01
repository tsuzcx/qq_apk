package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class ah
{
  public static ccf DUb;
  
  public static void aHm(String paramString)
  {
    AppMethodBeat.i(117732);
    if (b.Gw((String)g.ajR().ajA().get(274436, null)))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (!x.Ao(paramString))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (DUb == null) {
      ePV();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < DUb.nIE.size())
    {
      localObject2 = (cce)DUb.nIE.get(i);
      long l2 = (l1 - ((cce)localObject2).Hpc) / 86400000L;
      ((cce)localObject2).Hpb *= Math.pow(0.98D, l2);
      ((cce)localObject2).Hpc = (l2 * 86400000L + ((cce)localObject2).Hpc);
      ae.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((cce)localObject2).Hpb), Long.valueOf(((cce)localObject2).Hpc), ((cce)localObject2).Username });
      if (!((cce)localObject2).Username.equals(paramString)) {
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
        localObject1 = new cce();
        ((cce)localObject1).Hpb = 1.0D;
        ((cce)localObject1).Hpc = l1;
        ((cce)localObject1).Username = paramString;
        DUb.nIE.add(localObject1);
        ae.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(DUb.nIE, new Comparator() {});
        i = DUb.nIE.size() - 1;
        while ((i < DUb.nIE.size()) && (DUb.nIE.size() > 8))
        {
          if (((cce)DUb.nIE.get(i)).Hpb < 0.5D) {
            DUb.nIE.remove(i);
          }
          i += 1;
        }
        ((cce)localObject1).Hpb += 1.0D;
        ae.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((cce)localObject1).Hpb) });
      }
      paramString = ak.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = boE();
        localObject2 = Base64.encodeToString(DUb.toByteArray(), 0);
        paramString.edit().putString((String)localObject1, (String)localObject2).commit();
        ae.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", new Object[] { localObject2 });
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
  
  public static String boE()
  {
    AppMethodBeat.i(117731);
    String str = "key_pb_most_search_biz_list" + v.aAC();
    AppMethodBeat.o(117731);
    return str;
  }
  
  public static ccf ePV()
  {
    AppMethodBeat.i(117730);
    Object localObject;
    if (DUb == null)
    {
      localObject = boE();
      DUb = new ccf();
    }
    try
    {
      localObject = ak.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!bu.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        DUb.parseFrom((byte[])localObject);
      }
      label67:
      if (b.Gw((String)g.ajR().ajA().get(274436, null))) {
        DUb.nIE.clear();
      }
      localObject = DUb;
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
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ah
 * JD-Core Version:    0.7.0.1
 */