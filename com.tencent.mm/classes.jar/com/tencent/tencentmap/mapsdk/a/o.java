package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class o
{
  public static int a = 1000;
  private volatile List<n> b;
  private q c;
  private int d;
  
  public o(Context paramContext, String paramString)
  {
    AppMethodBeat.i(147046);
    this.d = -1;
    if (paramString == null) {}
    for (this.c = u.a(paramContext);; this.c = s.a(paramContext, paramString))
    {
      b();
      AppMethodBeat.o(147046);
      return;
    }
  }
  
  private List<n> b(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(147049);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(147049);
      return null;
    }
    int j = paramJSONArray.length();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j) {
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        localArrayList.add(new n(localJSONObject.getInt("index"), localJSONObject.getInt("id"), localJSONObject.getInt("order")));
        i += 1;
      }
      catch (Exception paramJSONArray)
      {
        AppMethodBeat.o(147049);
        return null;
      }
    }
    Collections.sort(localArrayList);
    AppMethodBeat.o(147049);
    return localArrayList;
  }
  
  private void b()
  {
    AppMethodBeat.i(147047);
    this.b = new CopyOnWriteArrayList();
    String str = this.c.a("mapStyleList");
    Object localObject = str;
    if (str == null) {
      localObject = "[{\"id\":0,\"index\":0,\"order\":1},{\"id\":-1,\"index\":1,\"order\":-1},{\"id\":-1,\"index\":2,\"order\":-1},{\"id\":-1,\"index\":3,\"order\":-1},{\"id\":-1,\"index\":4,\"order\":-1},{\"id\":-1,\"index\":5,\"order\":-1},{\"id\":-1,\"index\":6,\"order\":-1},{\"id\":-1,\"index\":7,\"order\":-1},{\"id\":-1,\"index\":8,\"order\":-1},{\"id\":9,\"index\":9,\"order\":-1},{\"id\":10,\"index\":10,\"order\":-1},{\"id\":5,\"index\":11,\"order\":-1},{\"id\":4,\"index\":12,\"order\":-1},{\"id\":6,\"index\":13,\"order\":-1},{\"id\":7,\"index\":14,\"order\":-1},{\"id\":8,\"index\":15,\"order\":-1}]";
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      this.b.addAll(b((JSONArray)localObject));
      AppMethodBeat.o(147047);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(147047);
    }
  }
  
  public int a(int paramInt)
  {
    AppMethodBeat.i(147051);
    if ((this.b == null) || (this.b.size() == 0) || (paramInt < 0))
    {
      AppMethodBeat.o(147051);
      return paramInt;
    }
    this.d = paramInt;
    if (paramInt >= a)
    {
      int i = a;
      AppMethodBeat.o(147051);
      return paramInt - i;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.c == paramInt)
      {
        paramInt = localn.a;
        AppMethodBeat.o(147051);
        return paramInt;
      }
    }
    AppMethodBeat.o(147051);
    return paramInt;
  }
  
  public String a()
  {
    AppMethodBeat.i(147050);
    if (this.b == null)
    {
      AppMethodBeat.o(147050);
      return null;
    }
    Object localObject = new StringBuilder(128);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.b != -1)
      {
        if (((StringBuilder)localObject).length() == 0)
        {
          ((StringBuilder)localObject).append(localn.b);
        }
        else
        {
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(localn.b);
        }
      }
      else if (((StringBuilder)localObject).length() == 0) {
        ((StringBuilder)localObject).append(0);
      } else {
        ((StringBuilder)localObject).append(",");
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(147050);
    return localObject;
  }
  
  public void a(f paramf)
  {
    AppMethodBeat.i(147052);
    if (paramf != null) {
      paramf.a(a(this.d));
    }
    AppMethodBeat.o(147052);
  }
  
  public void a(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(147048);
    String str = this.c.a("mapStyleList");
    if (paramJSONArray != null)
    {
      List localList = b(paramJSONArray);
      if (localList != null)
      {
        this.b.clear();
        this.b.addAll(localList);
        if (!paramJSONArray.toString().equals(str))
        {
          this.c.a();
          this.c.a("mapStyleList", paramJSONArray.toString());
        }
      }
    }
    AppMethodBeat.o(147048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.o
 * JD-Core Version:    0.7.0.1
 */