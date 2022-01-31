package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class ai
{
  public static bfi uJI;
  
  public static void agy(String paramString)
  {
    AppMethodBeat.i(124176);
    if (b.tM((String)g.RL().Ru().get(274436, null)))
    {
      AppMethodBeat.o(124176);
      return;
    }
    if (!t.nU(paramString))
    {
      AppMethodBeat.o(124176);
      return;
    }
    if (uJI == null) {
      cZA();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < uJI.jJv.size())
    {
      localObject2 = (bfh)uJI.jJv.get(i);
      long l2 = (l1 - ((bfh)localObject2).xux) / 86400000L;
      ((bfh)localObject2).xuw *= Math.pow(0.98D, l2);
      ((bfh)localObject2).xux = (l2 * 86400000L + ((bfh)localObject2).xux);
      ab.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((bfh)localObject2).xuw), Long.valueOf(((bfh)localObject2).xux), ((bfh)localObject2).Username });
      if (!((bfh)localObject2).Username.equals(paramString)) {
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
        localObject1 = new bfh();
        ((bfh)localObject1).xuw = 1.0D;
        ((bfh)localObject1).xux = l1;
        ((bfh)localObject1).Username = paramString;
        uJI.jJv.add(localObject1);
        ab.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(uJI.jJv, new Comparator() {});
        i = uJI.jJv.size() - 1;
        while ((i < uJI.jJv.size()) && (uJI.jJv.size() > 8))
        {
          if (((bfh)uJI.jJv.get(i)).xuw < 0.5D) {
            uJI.jJv.remove(i);
          }
          i += 1;
        }
        ((bfh)localObject1).xuw += 1.0D;
        ab.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((bfh)localObject1).xuw) });
      }
      paramString = ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = cZx();
        localObject2 = Base64.encodeToString(uJI.toByteArray(), 0);
        paramString.edit().putString((String)localObject1, (String)localObject2).commit();
        ab.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", new Object[] { localObject2 });
        AppMethodBeat.o(124176);
        return;
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(124176);
        return;
      }
    }
  }
  
  public static bfi cZA()
  {
    AppMethodBeat.i(124174);
    Object localObject;
    if (uJI == null)
    {
      localObject = cZx();
      uJI = new bfi();
      localObject = ah.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!bo.isNullOrNil((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      uJI.parseFrom((byte[])localObject);
      label67:
      if (b.tM((String)g.RL().Ru().get(274436, null))) {
        uJI.jJv.clear();
      }
      localObject = uJI;
      AppMethodBeat.o(124174);
      return localObject;
    }
    catch (IOException localIOException)
    {
      break label67;
    }
  }
  
  public static String cZx()
  {
    AppMethodBeat.i(124175);
    String str = "key_pb_most_search_biz_list" + r.Zn();
    AppMethodBeat.o(124175);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ai
 * JD-Core Version:    0.7.0.1
 */