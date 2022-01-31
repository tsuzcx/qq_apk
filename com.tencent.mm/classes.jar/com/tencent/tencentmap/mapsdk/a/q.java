package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class q
{
  public static int a = 1000;
  private volatile List<p> b;
  private s c;
  private int d = -1;
  
  public q(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    for (this.c = w.a(paramContext);; this.c = u.a(paramContext, paramString))
    {
      b();
      return;
    }
  }
  
  private List<p> b(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    int j = paramJSONArray.length();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    for (;;)
    {
      if (i < j) {}
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        localArrayList.add(new p(localJSONObject.getInt("index"), localJSONObject.getInt("id"), localJSONObject.getInt("order")));
        i += 1;
      }
      catch (Exception paramJSONArray) {}
    }
    Collections.sort(localArrayList);
    return localArrayList;
    return null;
  }
  
  private void b()
  {
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
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a(int paramInt)
  {
    if ((this.b == null) || (this.b.size() == 0) || (paramInt < 0)) {}
    p localp;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return paramInt;
        this.d = paramInt;
        if (paramInt >= a) {
          return paramInt - a;
        }
        localIterator = this.b.iterator();
      }
      localp = (p)localIterator.next();
    } while (localp.c != paramInt);
    return localp.a;
  }
  
  public String a()
  {
    if (this.b == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if (localp.b != -1)
      {
        if (localStringBuilder.length() == 0)
        {
          localStringBuilder.append(localp.b);
        }
        else
        {
          localStringBuilder.append(",");
          localStringBuilder.append(localp.b);
        }
      }
      else if (localStringBuilder.length() == 0) {
        localStringBuilder.append(0);
      } else {
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a(f paramf)
  {
    if (paramf != null) {
      paramf.a(a(this.d));
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.q
 * JD-Core Version:    0.7.0.1
 */