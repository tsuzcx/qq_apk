package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.mm.at.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class ai
{
  public static ayl qUx;
  
  public static void Rx(String paramString)
  {
    if (b.mC((String)g.DP().Dz().get(274436, null))) {}
    while (!s.hl(paramString)) {
      return;
    }
    if (qUx == null) {
      bZE();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < qUx.hPT.size())
    {
      localObject2 = (ayk)qUx.hPT.get(i);
      long l2 = (l1 - ((ayk)localObject2).tuv) / 86400000L;
      ((ayk)localObject2).tuu *= Math.pow(0.98D, l2);
      ((ayk)localObject2).tuv = (l2 * 86400000L + ((ayk)localObject2).tuv);
      y.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((ayk)localObject2).tuu), Long.valueOf(((ayk)localObject2).tuv), ((ayk)localObject2).sxM });
      if (!((ayk)localObject2).sxM.equals(paramString)) {
        break label453;
      }
      localObject1 = localObject2;
    }
    label453:
    for (;;)
    {
      i += 1;
      break;
      if (localObject1 == null)
      {
        localObject1 = new ayk();
        ((ayk)localObject1).tuu = 1.0D;
        ((ayk)localObject1).tuv = l1;
        ((ayk)localObject1).sxM = paramString;
        qUx.hPT.add(localObject1);
        y.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(qUx.hPT, new Comparator() {});
        i = qUx.hPT.size() - 1;
        while ((i < qUx.hPT.size()) && (qUx.hPT.size() > 8))
        {
          if (((ayk)qUx.hPT.get(i)).tuu < 0.5D) {
            qUx.hPT.remove(i);
          }
          i += 1;
        }
        ((ayk)localObject1).tuu += 1.0D;
        y.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((ayk)localObject1).tuu) });
      }
      paramString = ae.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = bZB();
        localObject2 = Base64.encodeToString(qUx.toByteArray(), 0);
        paramString.edit().putString((String)localObject1, (String)localObject2).commit();
        y.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "useBiz pbListString %s", new Object[] { localObject2 });
        return;
      }
      catch (IOException paramString)
      {
        return;
      }
    }
  }
  
  public static String bZB()
  {
    return "key_pb_most_search_biz_list" + q.Gj();
  }
  
  public static ayl bZE()
  {
    Object localObject;
    if (qUx == null)
    {
      localObject = bZB();
      qUx = new ayl();
      localObject = ae.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!bk.bl((String)localObject)) {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
      }
    }
    try
    {
      qUx.aH((byte[])localObject);
      label62:
      if (b.mC((String)g.DP().Dz().get(274436, null))) {
        qUx.hPT.clear();
      }
      return qUx;
    }
    catch (IOException localIOException)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ai
 * JD-Core Version:    0.7.0.1
 */