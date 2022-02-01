package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ay;

public abstract class t
  implements e
{
  public static final a aaOB = new a((byte)0);
  
  protected abstract h a(i parami);
  
  protected abstract h a(ay paramay, i parami);
  
  public static final class a
  {
    public static h a(e parame, i parami)
    {
      AppMethodBeat.i(57168);
      p.k(parame, "$this$getRefinedUnsubstitutedMemberScopeIfPossible");
      p.k(parami, "kotlinTypeRefiner");
      if (!(parame instanceof t)) {}
      for (Object localObject = null;; localObject = parame)
      {
        localObject = (t)localObject;
        if (localObject != null)
        {
          localObject = ((t)localObject).a(parami);
          parami = (i)localObject;
          if (localObject != null) {}
        }
        else
        {
          parami = parame.iEZ();
          p.j(parami, "this.unsubstitutedMemberScope");
        }
        AppMethodBeat.o(57168);
        return parami;
      }
    }
    
    public static h a(e parame, ay paramay, i parami)
    {
      AppMethodBeat.i(57169);
      p.k(parame, "$this$getRefinedMemberScopeIfPossible");
      p.k(paramay, "typeSubstitution");
      p.k(parami, "kotlinTypeRefiner");
      if (!(parame instanceof t)) {}
      for (Object localObject = null;; localObject = parame)
      {
        localObject = (t)localObject;
        if (localObject != null)
        {
          localObject = ((t)localObject).a(paramay, parami);
          parami = (i)localObject;
          if (localObject != null) {}
        }
        else
        {
          parami = parame.a(paramay);
          p.j(parami, "this.getMemberScope(\n   …ubstitution\n            )");
        }
        AppMethodBeat.o(57169);
        return parami;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.t
 * JD-Core Version:    0.7.0.1
 */