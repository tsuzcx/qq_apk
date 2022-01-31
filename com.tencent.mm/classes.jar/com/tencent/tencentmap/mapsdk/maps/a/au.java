package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class au
{
  private JSONObject a;
  
  /* Error */
  public final String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 15
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 23	com/tencent/tencentmap/mapsdk/maps/a/au:a	Lorg/json/JSONObject;
    //   11: ifnonnull +15 -> 26
    //   14: ldc 25
    //   16: astore_1
    //   17: ldc 15
    //   19: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: aload_0
    //   27: getfield 23	com/tencent/tencentmap/mapsdk/maps/a/au:a	Lorg/json/JSONObject;
    //   30: invokevirtual 33	org/json/JSONObject:toString	()Ljava/lang/String;
    //   33: astore_1
    //   34: ldc 15
    //   36: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: goto -17 -> 22
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	au
    //   16	18	1	str	String
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	42	finally
    //   17	22	42	finally
    //   26	39	42	finally
  }
  
  public final String a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    label199:
    boolean bool;
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        AppMethodBeat.i(147252);
        if ((this.a == null) || (TextUtils.isEmpty(paramString1)))
        {
          paramString1 = "";
          AppMethodBeat.o(147252);
          return paramString1;
        }
        localJSONObject = this.a.optJSONObject("data");
        if (localJSONObject == null)
        {
          paramString1 = "";
          AppMethodBeat.o(147252);
          continue;
        }
        localJSONObject = localJSONObject.optJSONObject(paramString1);
      }
      finally {}
      if (localJSONObject == null)
      {
        paramString1 = "";
        AppMethodBeat.o(147252);
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        paramString1 = localJSONObject.keys();
        for (;;)
        {
          if (!paramString1.hasNext()) {
            break label199;
          }
          Object localObject = (String)paramString1.next();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if (((String)localObject).equals("deviceid"))
            {
              paramString1 = localJSONObject.optString("deviceid");
              AppMethodBeat.o(147252);
              break;
            }
            localObject = new au.a(this, (String)localObject, paramInt, paramString2, paramString3, paramString4, paramString5);
            if (((au.a)localObject).b) {
              localArrayList.add(localObject);
            }
          }
        }
        if (localArrayList.size() == 0)
        {
          paramString1 = "";
          AppMethodBeat.o(147252);
        }
        else if (localArrayList.size() == 1)
        {
          paramString1 = localJSONObject.optString(((au.a)localArrayList.get(0)).a);
          AppMethodBeat.o(147252);
        }
        else
        {
          paramString1 = (au.a)localArrayList.get(0);
          paramInt = 1;
          if (paramInt < localArrayList.size())
          {
            paramString2 = (au.a)localArrayList.get(paramInt);
            if (!paramString1.b) {
              break label438;
            }
            if (paramString2.c != paramString1.c)
            {
              bool = paramString2.c;
              break;
            }
            if (paramString2.d != paramString1.d)
            {
              bool = paramString2.d;
              break;
            }
            if (paramString2.e != paramString1.e)
            {
              bool = paramString2.e;
              break;
            }
            if (paramString2.f != paramString1.f)
            {
              bool = paramString2.f;
              break;
            }
            if (paramString2.g == paramString1.g) {
              break label438;
            }
            bool = paramString2.g;
            break;
          }
          paramString1 = localJSONObject.optString(paramString1.a);
          AppMethodBeat.o(147252);
        }
      }
    }
    label438:
    label442:
    for (;;)
    {
      for (;;)
      {
        if (!bool) {
          break label442;
        }
        paramString1 = paramString2;
        paramInt += 1;
        break;
        bool = true;
      }
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      AppMethodBeat.i(147250);
      if (TextUtils.isEmpty(paramString)) {
        AppMethodBeat.o(147250);
      }
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject(paramString);
          if (this.a != null) {
            break;
          }
          this.a = ((JSONObject)localObject);
          AppMethodBeat.o(147250);
        }
        catch (Throwable paramString)
        {
          AppMethodBeat.o(147250);
        }
      }
      paramString = ((JSONObject)localObject).optJSONObject("data");
    }
    finally {}
    Object localObject = ((JSONObject)localObject).optString("version");
    JSONObject localJSONObject1;
    if ((paramString != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localJSONObject1 = this.a.optJSONObject("data");
      if (localJSONObject1 != null) {
        break label134;
      }
      this.a.putOpt("data", paramString);
    }
    for (;;)
    {
      this.a.putOpt("version", localObject);
      AppMethodBeat.o(147250);
      break;
      label134:
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str))
        {
          JSONObject localJSONObject2 = paramString.optJSONObject(str);
          if (localJSONObject2 != null) {
            localJSONObject1.putOpt(str, localJSONObject2);
          }
        }
      }
    }
  }
  
  public final void b()
  {
    try
    {
      this.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final String c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 127
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 23	com/tencent/tencentmap/mapsdk/maps/a/au:a	Lorg/json/JSONObject;
    //   11: ifnull +22 -> 33
    //   14: aload_0
    //   15: getfield 23	com/tencent/tencentmap/mapsdk/maps/a/au:a	Lorg/json/JSONObject;
    //   18: ldc 122
    //   20: invokevirtual 76	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_1
    //   24: ldc 127
    //   26: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: ldc 25
    //   35: astore_1
    //   36: ldc 127
    //   38: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	au
    //   23	13	1	str	String
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   36	41	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.au
 * JD-Core Version:    0.7.0.1
 */