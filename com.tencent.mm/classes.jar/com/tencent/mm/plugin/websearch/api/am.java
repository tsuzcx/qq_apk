package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class am
{
  public static czy Pzo;
  
  public static String bVR()
  {
    AppMethodBeat.i(117731);
    String str = "key_pb_most_search_biz_list" + z.bcZ();
    AppMethodBeat.o(117731);
    return str;
  }
  
  public static void biS(String paramString)
  {
    AppMethodBeat.i(117732);
    if (b.WF((String)h.aHG().aHp().b(274436, null)))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (!ab.Qm(paramString))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (Pzo == null) {
      gQT();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < Pzo.rVy.size())
    {
      localObject2 = (czx)Pzo.rVy.get(i);
      long l2 = (l1 - ((czx)localObject2).THv) / 86400000L;
      ((czx)localObject2).THu *= Math.pow(0.98D, l2);
      ((czx)localObject2).THv = (l2 * 86400000L + ((czx)localObject2).THv);
      Log.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((czx)localObject2).THu), Long.valueOf(((czx)localObject2).THv), ((czx)localObject2).Username });
      if (!((czx)localObject2).Username.equals(paramString)) {
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
        localObject1 = new czx();
        ((czx)localObject1).THu = 1.0D;
        ((czx)localObject1).THv = l1;
        ((czx)localObject1).Username = paramString;
        Pzo.rVy.add(localObject1);
        Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(Pzo.rVy, new Comparator() {});
        i = Pzo.rVy.size() - 1;
        while ((i < Pzo.rVy.size()) && (Pzo.rVy.size() > 8))
        {
          if (((czx)Pzo.rVy.get(i)).THu < 0.5D) {
            Pzo.rVy.remove(i);
          }
          i += 1;
        }
        ((czx)localObject1).THu += 1.0D;
        Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((czx)localObject1).THu) });
      }
      paramString = MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = bVR();
        localObject2 = Base64.encodeToString(Pzo.toByteArray(), 0);
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
  
  public static czy gQT()
  {
    AppMethodBeat.i(117730);
    Object localObject;
    if (Pzo == null)
    {
      localObject = bVR();
      Pzo = new czy();
    }
    try
    {
      localObject = MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        Pzo.parseFrom((byte[])localObject);
      }
      label67:
      if (b.WF((String)h.aHG().aHp().b(274436, null))) {
        Pzo.rVy.clear();
      }
      localObject = Pzo;
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
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.am
 * JD-Core Version:    0.7.0.1
 */