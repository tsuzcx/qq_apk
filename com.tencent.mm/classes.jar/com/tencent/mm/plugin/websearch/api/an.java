package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dre;
import com.tencent.mm.protocal.protobuf.drf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class an
{
  public static drf Wpx;
  
  public static void biA(String paramString)
  {
    AppMethodBeat.i(117732);
    if (b.OE((String)h.baE().ban().d(274436, null)))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (!ab.IS(paramString))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (Wpx == null) {
      iqf();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < Wpx.vgO.size())
    {
      localObject2 = (dre)Wpx.vgO.get(i);
      long l2 = (l1 - ((dre)localObject2).aaXe) / 86400000L;
      ((dre)localObject2).aaXd *= Math.pow(0.98D, l2);
      ((dre)localObject2).aaXe = (l2 * 86400000L + ((dre)localObject2).aaXe);
      Log.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((dre)localObject2).aaXd), Long.valueOf(((dre)localObject2).aaXe), ((dre)localObject2).Username });
      if (!((dre)localObject2).Username.equals(paramString)) {
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
        localObject1 = new dre();
        ((dre)localObject1).aaXd = 1.0D;
        ((dre)localObject1).aaXe = l1;
        ((dre)localObject1).Username = paramString;
        Wpx.vgO.add(localObject1);
        Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(Wpx.vgO, new Comparator() {});
        i = Wpx.vgO.size() - 1;
        while ((i < Wpx.vgO.size()) && (Wpx.vgO.size() > 8))
        {
          if (((dre)Wpx.vgO.get(i)).aaXd < 0.5D) {
            Wpx.vgO.remove(i);
          }
          i += 1;
        }
        ((dre)localObject1).aaXd += 1.0D;
        Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((dre)localObject1).aaXd) });
      }
      paramString = MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = cwe();
        localObject2 = Base64.encodeToString(Wpx.toByteArray(), 0);
        paramString.edit().putString((String)localObject1, (String)localObject2).commit();
        Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", new Object[] { localObject2 });
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
  
  public static String cwe()
  {
    AppMethodBeat.i(117731);
    String str = "key_pb_most_search_biz_list" + z.bAM();
    AppMethodBeat.o(117731);
    return str;
  }
  
  public static drf iqf()
  {
    AppMethodBeat.i(117730);
    Object localObject;
    if (Wpx == null)
    {
      localObject = cwe();
      Wpx = new drf();
    }
    try
    {
      localObject = MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        Wpx.parseFrom((byte[])localObject);
      }
      label67:
      if (b.OE((String)h.baE().ban().d(274436, null))) {
        Wpx.vgO.clear();
      }
      localObject = Wpx;
      AppMethodBeat.o(117730);
      return localObject;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.an
 * JD-Core Version:    0.7.0.1
 */