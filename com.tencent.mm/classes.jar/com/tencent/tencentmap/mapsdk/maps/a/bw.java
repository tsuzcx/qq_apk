package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bw
  extends bt
  implements cu
{
  private au a;
  private List<Object> b;
  
  public bw()
  {
    AppMethodBeat.i(147322);
    this.a = new au();
    this.b = new ArrayList();
    ac.j().post(new bx(this));
    AppMethodBeat.o(147322);
  }
  
  private void a()
  {
    try
    {
      AppMethodBeat.i(98592);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(98592);
    }
    finally {}
  }
  
  public final String a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(147324);
    paramString1 = this.a.a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(147324);
    return paramString1;
  }
  
  public final void a(String paramString1, String arg2)
  {
    AppMethodBeat.i(147323);
    if ((!TextUtils.isEmpty(???)) && (!cb.a().b().equals(???))) {
      cb.a().a(???, true);
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    synchronized (this.a)
    {
      this.a.b();
      this.a.a(paramString1);
      da.a("settings_in_client", this.a.a(), true);
      a();
      AppMethodBeat.o(147323);
      return;
    }
  }
  
  public final String b()
  {
    return "settings";
  }
  
  public final void c()
  {
    AppMethodBeat.i(98594);
    cw.d().b();
    AppMethodBeat.o(98594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bw
 * JD-Core Version:    0.7.0.1
 */