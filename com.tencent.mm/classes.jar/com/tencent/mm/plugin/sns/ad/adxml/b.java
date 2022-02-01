package com.tencent.mm.plugin.sns.ad.adxml;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class b
{
  public SparseArray<a> Jyi;
  
  public static b u(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(241220);
    for (;;)
    {
      try
      {
        if (!d.isEmpty(paramMap)) {
          break label197;
        }
        AppMethodBeat.o(241220);
        return null;
      }
      catch (Throwable paramMap)
      {
        Object localObject2;
        Object localObject1;
        Log.e("AdDynamicUpdateInfo", "parse the update info failed!!");
        AppMethodBeat.o(241220);
        return null;
      }
      localObject2 = localSparseArray;
      if (i < 20) {
        if (i == 0)
        {
          localObject2 = a.v(paramMap, paramString + ".action");
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localSparseArray = new SparseArray();
            localObject1 = localObject2;
          }
          localObject2 = localSparseArray;
          if (localObject1 != null)
          {
            localObject2 = localSparseArray;
            if (localSparseArray != null)
            {
              localSparseArray.put(((a)localObject1).type, localObject1);
              i += 1;
            }
          }
        }
        else
        {
          localObject1 = a.v(paramMap, paramString + ".action" + i);
          continue;
        }
      }
      if ((localObject2 != null) && (((SparseArray)localObject2).size() > 0))
      {
        paramMap = new b();
        paramMap.Jyi = ((SparseArray)localObject2);
        AppMethodBeat.o(241220);
        return paramMap;
      }
      paramMap = null;
      continue;
      label197:
      int i = 0;
      SparseArray localSparseArray = null;
    }
  }
  
  public static final class a
  {
    public int expireTime;
    public int type;
    
    static a v(Map<String, String> paramMap, String paramString)
    {
      AppMethodBeat.i(263692);
      if (d.isEmpty(paramMap))
      {
        AppMethodBeat.o(263692);
        return null;
      }
      int i = Util.safeParseInt((String)paramMap.get(paramString + ".type"));
      int j = Util.safeParseInt((String)paramMap.get(paramString + ".expireTime")) * 1000;
      if ((i == 0) || (j == 0))
      {
        AppMethodBeat.o(263692);
        return null;
      }
      paramMap = new a();
      paramMap.type = i;
      paramMap.expireTime = j;
      AppMethodBeat.o(263692);
      return paramMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.b
 * JD-Core Version:    0.7.0.1
 */