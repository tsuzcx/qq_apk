package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class gw
  extends gu
{
  private gv a = new gv("HttpSchedulerHandler");
  
  public final void a()
  {
    em.j().post(new gx(this, null, null));
  }
  
  public final void a(gp paramgp)
  {
    try
    {
      localJSONObject2 = new JSONObject();
      Object localObject = this.a;
      ey.e();
      localObject = ((gv)localObject).a(ey.b());
      if (!hq.a((byte[])localObject))
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
          localJSONObject1.put(em.c(), new JSONObject());
          paramgp.a.put("directScheduleCodes", localJSONObject1);
          return;
        }
        catch (Exception paramgp)
        {
          JSONObject localJSONObject2;
          return;
        }
        localJSONObject2.put(em.c(), new JSONObject());
        paramgp.a.put("directScheduleCodes", localJSONObject2);
        return;
        localJSONObject2.put(em.c(), new JSONObject());
        continue;
        JSONObject localJSONObject1 = null;
      }
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optJSONObject("AccessScheduleRsp");
      if (paramJSONObject != null)
      {
        paramJSONObject = paramJSONObject.toString();
        if (!hq.a(paramJSONObject))
        {
          paramJSONObject = paramJSONObject.getBytes();
          if (!hq.a(paramJSONObject))
          {
            String str = ey.b();
            this.a.a(str, paramJSONObject);
            em.j().post(new gx(this, str, paramJSONObject));
          }
        }
      }
      return;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  public final String c()
  {
    return "accessscheduler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gw
 * JD-Core Version:    0.7.0.1
 */