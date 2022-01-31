package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bu
  extends bt
  implements am
{
  private ci a;
  private ak b;
  
  public bu()
  {
    AppMethodBeat.i(147315);
    this.a = new ci("HttpSchedulerClient");
    AppMethodBeat.o(147315);
  }
  
  private static void a(ak paramak, JSONArray paramJSONArray)
  {
    AppMethodBeat.i(147319);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramJSONArray.length())
        {
          localObject = paramJSONArray.getJSONObject(i);
          JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("domains");
          localJSONArray2 = ((JSONObject)localObject).optJSONArray("resultlist");
          String str1 = ((JSONObject)localObject).optString("schedulecode");
          localObject = ((JSONObject)localObject).optString("httpsport");
          if ((localJSONArray1 != null) && (localJSONArray2 != null))
          {
            j = 0;
            if (j < localJSONArray1.length()) {
              localal = new al(localJSONArray1.getString(j), str1);
            }
          }
        }
      }
      catch (Exception paramak)
      {
        Object localObject;
        JSONArray localJSONArray2;
        int j;
        al localal;
        String str2;
        ad localad;
        AppMethodBeat.o(147319);
        return;
      }
      try
      {
        localal.d = Integer.parseInt((String)localObject);
        k = 0;
      }
      catch (Throwable localThrowable)
      {
        continue;
        k += 1;
        continue;
      }
      if (k < localJSONArray2.length())
      {
        str2 = localJSONArray2.getString(k);
        localad = new ad();
        if (!localad.a(str2)) {
          break label201;
        }
        localal.c.add(localad);
        break label201;
      }
      paramak.a(localal);
      j += 1;
      continue;
      i += 1;
    }
    AppMethodBeat.o(147319);
  }
  
  public final List<al> a()
  {
    AppMethodBeat.i(147318);
    if ((this.b != null) && (this.b.a().equals(an.b())))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.b.b().entrySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Map.Entry)localIterator.next()).getValue());
      }
      AppMethodBeat.o(147318);
      return localArrayList;
    }
    ac.j().post(new bv(this));
    AppMethodBeat.o(147318);
    return null;
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    AppMethodBeat.i(147317);
    this.a.a(paramString1, paramArrayOfByte);
    ac.j().post(new bv(this));
    AppMethodBeat.o(147317);
  }
  
  public final String b()
  {
    return "accessscheduler";
  }
  
  public final void c()
  {
    AppMethodBeat.i(147316);
    cw.d().a();
    AppMethodBeat.o(147316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bu
 * JD-Core Version:    0.7.0.1
 */