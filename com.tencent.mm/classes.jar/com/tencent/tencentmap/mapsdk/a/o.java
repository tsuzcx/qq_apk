package com.tencent.tencentmap.mapsdk.a;

import android.util.Log;
import com.tencent.map.lib.d;
import org.json.JSONArray;
import org.json.JSONException;

public class o
{
  private int a;
  private int b;
  private JSONArray c;
  private String[] d;
  
  public o(int paramInt1, int paramInt2, JSONArray paramJSONArray)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramJSONArray;
    if (this.c == null)
    {
      this.d = null;
      return;
    }
    paramInt2 = this.c.length();
    this.d = new String[paramInt2];
    paramInt1 = 0;
    while (paramInt1 < paramInt2) {
      try
      {
        this.d[paramInt1] = this.c.getString(paramInt1);
        paramInt1 += 1;
      }
      catch (JSONException paramJSONArray)
      {
        this.d = null;
        d.b(Log.getStackTraceString(paramJSONArray));
      }
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public JSONArray c()
  {
    return this.c;
  }
  
  public String[] d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.o
 * JD-Core Version:    0.7.0.1
 */