package com.tencent.smtt.sdk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private String a;
  private String b;
  private Integer c;
  private String d;
  private String e;
  private Integer f;
  private Integer g;
  private List<Integer> h;
  
  public String a()
  {
    AppMethodBeat.i(194153);
    Object localObject1 = new JSONObject();
    Object localObject2 = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(this.a)) {
        ((JSONObject)localObject2).put("PP", this.a);
      }
      if (!TextUtils.isEmpty(this.b)) {
        ((JSONObject)localObject2).put("PPVN", this.b);
      }
      if (this.c != null) {
        ((JSONObject)localObject2).put("ADRV", this.c);
      }
      if (!TextUtils.isEmpty(this.d)) {
        ((JSONObject)localObject2).put("MODEL", this.d);
      }
      if (!TextUtils.isEmpty(this.e)) {
        ((JSONObject)localObject2).put("NAME", this.e);
      }
      if (this.f != null) {
        ((JSONObject)localObject2).put("SDKVC", this.f);
      }
      if (this.g != null) {
        ((JSONObject)localObject2).put("COMPVC", this.g);
      }
      ((JSONObject)localObject1).put("terminal_params", localObject2);
      if (this.h != null)
      {
        localObject2 = new JSONArray();
        int i = 0;
        while (i < this.h.size())
        {
          ((JSONArray)localObject2).put(this.h.get(i));
          i += 1;
        }
        ((JSONObject)localObject1).put("ids", localObject2);
      }
    }
    catch (JSONException localJSONException)
    {
      label227:
      break label227;
    }
    localObject1 = ((JSONObject)localObject1).toString();
    AppMethodBeat.o(194153);
    return localObject1;
  }
  
  public void a(Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(List<Integer> paramList)
  {
    this.h = paramList;
  }
  
  public void b(Integer paramInteger)
  {
    this.f = paramInteger;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(Integer paramInteger)
  {
    this.g = paramInteger;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */