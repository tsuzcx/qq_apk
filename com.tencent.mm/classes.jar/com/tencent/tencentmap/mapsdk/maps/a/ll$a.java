package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.m;
import java.lang.ref.WeakReference;
import java.util.List;

class ll$a
  extends Thread
{
  private final WeakReference<ll> a;
  private final String b;
  private final m c;
  
  public ll$a(ll paramll, String paramString, m paramm)
  {
    AppMethodBeat.i(149171);
    this.a = new WeakReference(paramll);
    this.b = paramString;
    this.c = paramm;
    AppMethodBeat.o(149171);
  }
  
  public void run()
  {
    AppMethodBeat.i(149172);
    if ((this.a != null) && (this.a.get() != null))
    {
      ll localll = (ll)this.a.get();
      List localList = ll.a(localll, this.b, this.c);
      if (localList != null)
      {
        if (localll.a)
        {
          if ((!ll.a(localll, ll.a(localll), ll.b(localll))) || (!ll.a(localll, ll.c(localll), ll.d(localll))))
          {
            localll.a = false;
            ll.a(localll, false);
            AppMethodBeat.o(149172);
            return;
          }
          int i = 0;
          while (i < localList.size())
          {
            ll.a(localll, (jo)localList.get(i));
            i += 1;
          }
        }
        ll.a(localll, true);
        AppMethodBeat.o(149172);
        return;
      }
      localll.a = false;
      ll.a(localll, false);
    }
    AppMethodBeat.o(149172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ll.a
 * JD-Core Version:    0.7.0.1
 */