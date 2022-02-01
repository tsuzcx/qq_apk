package com.tencent.mm.plugin.websearch.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.crh;
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
  public static crh IEW;
  
  public static void aXh(String paramString)
  {
    AppMethodBeat.i(117732);
    if (b.Pi((String)g.aAh().azQ().get(274436, null)))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (!ab.IT(paramString))
    {
      AppMethodBeat.o(117732);
      return;
    }
    if (IEW == null) {
      fYi();
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    if (i < IEW.oTA.size())
    {
      localObject2 = (crg)IEW.oTA.get(i);
      long l2 = (l1 - ((crg)localObject2).Mwx) / 86400000L;
      ((crg)localObject2).Mww *= Math.pow(0.98D, l2);
      ((crg)localObject2).Mwx = (l2 * 86400000L + ((crg)localObject2).Mwx);
      Log.d("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "after update: %.2f %d %s", new Object[] { Double.valueOf(((crg)localObject2).Mww), Long.valueOf(((crg)localObject2).Mwx), ((crg)localObject2).Username });
      if (!((crg)localObject2).Username.equals(paramString)) {
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
        localObject1 = new crg();
        ((crg)localObject1).Mww = 1.0D;
        ((crg)localObject1).Mwx = l1;
        ((crg)localObject1).Username = paramString;
        IEW.oTA.add(localObject1);
        Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "add new use %s", new Object[] { paramString });
      }
      for (;;)
      {
        Collections.sort(IEW.oTA, new Comparator() {});
        i = IEW.oTA.size() - 1;
        while ((i < IEW.oTA.size()) && (IEW.oTA.size() > 8))
        {
          if (((crg)IEW.oTA.get(i)).Mww < 0.5D) {
            IEW.oTA.remove(i);
          }
          i += 1;
        }
        ((crg)localObject1).Mww += 1.0D;
        Log.i("MicroMsg.WebSearch.WebSearchMostSearchBizLogic", "update use %s %.2f", new Object[] { paramString, Double.valueOf(((crg)localObject1).Mww) });
      }
      paramString = MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
      try
      {
        localObject1 = bKh();
        localObject2 = Base64.encodeToString(IEW.toByteArray(), 0);
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
  
  public static String bKh()
  {
    AppMethodBeat.i(117731);
    String str = "key_pb_most_search_biz_list" + z.aTY();
    AppMethodBeat.o(117731);
    return str;
  }
  
  public static crh fYi()
  {
    AppMethodBeat.i(117730);
    Object localObject;
    if (IEW == null)
    {
      localObject = bKh();
      IEW = new crh();
    }
    try
    {
      localObject = MMApplicationContext.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString((String)localObject, "");
      if (!Util.isNullOrNil((String)localObject))
      {
        localObject = Base64.decode(((String)localObject).getBytes(), 0);
        IEW.parseFrom((byte[])localObject);
      }
      label67:
      if (b.Pi((String)g.aAh().azQ().get(274436, null))) {
        IEW.oTA.clear();
      }
      localObject = IEW;
      AppMethodBeat.o(117730);
      return localObject;
    }
    catch (Exception localException)
    {
      break label67;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.am
 * JD-Core Version:    0.7.0.1
 */