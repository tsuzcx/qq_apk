package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.AsyncTask;
import com.tencent.map.lib.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class mc
  implements me.a
{
  private Context a;
  private oo b;
  private nd c;
  private q d;
  private mb e;
  private List<AsyncTask> f;
  private mg g;
  
  public mc(nv paramnv, ai paramai)
  {
    this.a = paramnv.m();
    this.c = paramnv.l().getWorldMapOverlayManager();
    this.b = paramnv.a();
    this.d = paramnv.b();
    this.e = paramnv.c();
    this.f = new ArrayList();
    String str1 = "";
    String str4 = "";
    String str2 = str1;
    String str3 = str4;
    if (paramai != null)
    {
      if (!StringUtil.isEmpty(paramai.f())) {
        str1 = paramai.f().trim();
      }
      str2 = str1;
      str3 = str4;
      if (!StringUtil.isEmpty(paramai.e()))
      {
        str3 = paramai.e().trim();
        str2 = str1;
      }
    }
    this.g = new mg(this.a, paramnv, str2);
    this.f.add(new md(this.b.a, this, str2, str3).execute(new String[0]));
    this.f.add(new me(this.a, this).execute(new String[0]));
  }
  
  public void a()
  {
    if (this.f != null)
    {
      int i = 0;
      while (i < this.f.size())
      {
        ((AsyncTask)this.f.get(i)).cancel(true);
        i += 1;
      }
      this.f.clear();
    }
    this.f = null;
  }
  
  public void a(JSONArray paramJSONArray, o paramo)
  {
    if (this.d == null) {
      return;
    }
    this.d.a(paramJSONArray);
    this.e.a(paramo);
    int i = mb.c;
    if (paramo != null) {
      i = paramo.b();
    }
    this.g.a(this.d.a(), i);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {}
    do
    {
      return;
      this.b.i(paramBoolean);
    } while (!paramBoolean);
    this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mc
 * JD-Core Version:    0.7.0.1
 */