package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ai;
import com.tencent.tencentmap.mapsdk.a.ap;
import com.tencent.tencentmap.mapsdk.a.bg;
import com.tencent.tencentmap.mapsdk.a.cf;
import com.tencent.tencentmap.mapsdk.a.m;
import com.tencent.tencentmap.mapsdk.a.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class lh
  implements lj.a
{
  private Context a;
  private bg b;
  private np c;
  private o d;
  private cf e;
  private List<AsyncTask> f;
  private ll g;
  
  public lh(ap paramap)
  {
    AppMethodBeat.i(149149);
    this.a = paramap.l();
    this.c = paramap.k().r();
    this.b = paramap.a();
    this.d = paramap.b();
    this.e = paramap.k().H();
    this.f = new ArrayList();
    String str3 = "";
    String str4 = "";
    String str2 = str4;
    String str1 = str3;
    if (paramap.k() != null)
    {
      str2 = str4;
      str1 = str3;
      if (paramap.k().p() != null)
      {
        str1 = paramap.k().p().h();
        str2 = paramap.k().p().g();
      }
    }
    this.g = new ll(this.a, paramap, str1);
    this.f.add(new li(this.b.a, this, str1, str2));
    this.f.add(new lj(this.a, this));
    AppMethodBeat.o(149149);
  }
  
  public void a()
  {
    AppMethodBeat.i(100384);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext()) {
      ((AsyncTask)localIterator.next()).execute(new Object[0]);
    }
    AppMethodBeat.o(100384);
  }
  
  public void a(a parama, ai paramai)
  {
    AppMethodBeat.i(149150);
    this.b.a(parama, paramai);
    AppMethodBeat.o(149150);
  }
  
  public void a(JSONArray paramJSONArray, m paramm)
  {
    AppMethodBeat.i(149151);
    if (this.d == null)
    {
      AppMethodBeat.o(149151);
      return;
    }
    this.d.a(paramJSONArray);
    this.e.a(paramm);
    this.g.a(this.d.a(), paramm);
    AppMethodBeat.o(149151);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(100390);
    if (this.b == null)
    {
      AppMethodBeat.o(100390);
      return;
    }
    this.b.i(paramBoolean);
    if (paramBoolean) {
      this.c.d();
    }
    this.c.a(true);
    AppMethodBeat.o(100390);
  }
  
  public void b()
  {
    AppMethodBeat.i(100381);
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
    AppMethodBeat.o(100381);
  }
  
  public static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lh
 * JD-Core Version:    0.7.0.1
 */