package com.tencent.mm.sns_compose.c;

import androidx.compose.runtime.c.c;
import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a aczo;
  public static m<h, Integer, ah> agS;
  public static m<h, Integer, ah> alA;
  
  static
  {
    AppMethodBeat.i(235601);
    aczo = new a();
    agS = (m)c.a(-985544133, false, a.aczp);
    alA = (m)c.a(-985549068, false, b.aczq);
    AppMethodBeat.o(235601);
  }
  
  public static m<h, Integer, ah> iVv()
  {
    return agS;
  }
  
  public static m<h, Integer, ah> iVw()
  {
    return alA;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<h, Integer, ah>
  {
    public static final a aczp;
    
    static
    {
      AppMethodBeat.i(235554);
      aczp = new a();
      AppMethodBeat.o(235554);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<h, Integer, ah>
  {
    public static final b aczq;
    
    static
    {
      AppMethodBeat.i(235552);
      aczq = new b();
      AppMethodBeat.o(235552);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sns_compose.c.a
 * JD-Core Version:    0.7.0.1
 */