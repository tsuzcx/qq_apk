package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class gi
  extends gf
  implements hh
{
  private ff a = new ff();
  private List<Object> b = new ArrayList();
  
  public gi()
  {
    em.j().post(new gj(this));
  }
  
  private void a()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    finally {}
  }
  
  public final String a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return this.a.a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final void a(String paramString1, String arg2)
  {
    if ((!TextUtils.isEmpty(???)) && (!gn.a().b().equals(???))) {
      gn.a().a(???, true);
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    synchronized (this.a)
    {
      this.a.b();
      this.a.a(paramString1);
      hn.a("settings_in_client", this.a.a(), true);
      a();
      return;
    }
  }
  
  public final String b()
  {
    return "settings";
  }
  
  public final void c()
  {
    hj.d().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gi
 * JD-Core Version:    0.7.0.1
 */