package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cj
  extends ch
{
  private ci a;
  
  public cj()
  {
    AppMethodBeat.i(147347);
    this.a = new ci("HttpSchedulerHandler");
    AppMethodBeat.o(147347);
  }
  
  public final void a()
  {
    AppMethodBeat.i(147348);
    ac.j().post(new ck(this, null, null));
    AppMethodBeat.o(147348);
  }
  
  public final void a(cd paramcd)
  {
    AppMethodBeat.i(147349);
    try
    {
      localJSONObject2 = new JSONObject();
      Object localObject = this.a;
      an.e();
      localObject = ((ci)localObject).a(an.b());
      if (!dd.a((byte[])localObject))
      {
        localObject = new JSONObject(new String((byte[])localObject));
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optJSONObject("resultMap");
          if (localObject != null)
          {
            Iterator localIterator = ((JSONObject)localObject).keys();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray(str);
              if (localJSONArray != null)
              {
                JSONObject localJSONObject3 = new JSONObject();
                int i = 0;
                while (i < localJSONArray.length())
                {
                  JSONObject localJSONObject4 = localJSONArray.getJSONObject(i);
                  localJSONObject3.put(localJSONObject4.optString("unit"), localJSONObject4.optString("schedulecode"));
                  i += 1;
                }
                localJSONObject2.put(str, localJSONObject3);
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          localJSONObject1 = new JSONObject();
          localJSONObject1.put(ac.c(), new JSONObject());
          paramcd.a.put("directScheduleCodes", localJSONObject1);
          AppMethodBeat.o(147349);
          return;
        }
        catch (Exception paramcd)
        {
          JSONObject localJSONObject2;
          AppMethodBeat.o(147349);
          return;
        }
        localJSONObject2.put(ac.c(), new JSONObject());
        paramcd.a.put("directScheduleCodes", localJSONObject2);
        AppMethodBeat.o(147349);
        return;
        localJSONObject2.put(ac.c(), new JSONObject());
        continue;
        JSONObject localJSONObject1 = null;
      }
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(147350);
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("AccessScheduleRsp");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.toString();
        if (!dd.a(paramJSONObject))
        {
          paramJSONObject = paramJSONObject.getBytes();
          if (!dd.a(paramJSONObject))
          {
            String str = an.b();
            this.a.a(str, paramJSONObject);
            ac.j().post(new ck(this, str, paramJSONObject));
          }
        }
      }
      AppMethodBeat.o(147350);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(147350);
    }
  }
  
  public final String c()
  {
    return "accessscheduler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cj
 * JD-Core Version:    0.7.0.1
 */