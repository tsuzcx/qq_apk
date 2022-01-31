package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

public class nr
{
  public long a;
  public long b;
  public nr.d c;
  private nr.f d;
  
  public nr()
  {
    AppMethodBeat.i(149553);
    this.a = 0L;
    this.b = 0L;
    this.c = new nr.d();
    AppMethodBeat.o(149553);
  }
  
  protected static nr a(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(149562);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(149562);
      return null;
    }
    nr localnr = new nr();
    localnr.a = paramJSONObject.optLong("create");
    localnr.b = paramJSONObject.optLong("destroy");
    localnr.c = nr.d.a(paramJSONObject.optJSONObject("mapLoad"));
    localnr.d = nr.f.a(paramJSONObject.optJSONObject("oversea"));
    AppMethodBeat.o(149562);
    return localnr;
  }
  
  protected JSONObject a()
  {
    AppMethodBeat.i(149561);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("create", this.a);
      localJSONObject.put("destroy", this.b);
      if (this.c != null) {
        localJSONObject.put("mapLoad", nr.d.d(this.c));
      }
      if (this.d != null) {
        localJSONObject.put("oversea", nr.f.b(this.d));
      }
      AppMethodBeat.o(149561);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(149561);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(149560);
    if (this.d == null) {
      this.d = new nr.f(null);
    }
    nr.f localf = this.d;
    nr.f.a(localf, nr.f.a(localf) + paramInt);
    AppMethodBeat.o(149560);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(149555);
    if (nr.d.a(this.c) > 0L)
    {
      nr.d.a(this.c, paramLong - this.a);
      AppMethodBeat.o(149555);
      return;
    }
    nr.d.b(this.c, paramLong - this.a);
    AppMethodBeat.o(149555);
  }
  
  public void a(long paramLong, String paramString)
  {
    AppMethodBeat.i(149559);
    if (nr.d.c(this.c) == null) {
      nr.d.a(this.c, new nr.a());
    }
    if (nr.a.b(nr.d.c(this.c)) == null) {
      nr.a.b(nr.d.c(this.c), new CopyOnWriteArraySet());
    }
    if (nr.a.b(nr.d.c(this.c)).size() > 9)
    {
      AppMethodBeat.o(149559);
      return;
    }
    nr.e locale = new nr.e();
    nr.e.a(locale, paramLong - this.a);
    nr.e.a(locale, paramString);
    nr.a.b(nr.d.c(this.c)).add(locale);
    AppMethodBeat.o(149559);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(149557);
    if (nr.d.b(this.c) == null) {
      nr.d.a(this.c, new CopyOnWriteArraySet());
    }
    if (nr.d.b(this.c).size() > 9)
    {
      AppMethodBeat.o(149557);
      return;
    }
    nr.g localg = new nr.g(null);
    nr.g.a(localg, paramLong - this.a);
    nr.g.a(localg, paramString);
    nr.g.a(localg, paramInt);
    nr.d.b(this.c).add(localg);
    AppMethodBeat.o(149557);
  }
  
  public void a(nr.c paramc)
  {
    AppMethodBeat.i(149558);
    if (nr.d.c(this.c) == null) {
      nr.d.a(this.c, new nr.a());
    }
    if (nr.a.a(nr.d.c(this.c)) == null) {
      nr.a.a(nr.d.c(this.c), new CopyOnWriteArraySet());
    }
    if (nr.a.a(nr.d.c(this.c)).size() > 9)
    {
      AppMethodBeat.o(149558);
      return;
    }
    nr.a.a(nr.d.c(this.c)).add(paramc);
    AppMethodBeat.o(149558);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(149554);
    nr.d.a(this.c, paramBoolean);
    AppMethodBeat.o(149554);
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(149556);
    nr.b localb = new nr.b(null);
    nr.b.a(localb, paramBoolean);
    if (paramLong - this.a > 0L) {
      nr.b.a(localb, paramLong - this.a);
    }
    nr.d.a(this.c, localb);
    AppMethodBeat.o(149556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nr
 * JD-Core Version:    0.7.0.1
 */