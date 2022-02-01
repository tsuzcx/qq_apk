package d.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.e;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.ay;

public abstract class t
  implements e
{
  public static final a NvZ = new a((byte)0);
  
  protected abstract h a(i parami);
  
  protected abstract h a(ay paramay, i parami);
  
  public static final class a
  {
    public static h a(e parame, i parami)
    {
      AppMethodBeat.i(57168);
      p.h(parame, "$this$getRefinedUnsubstitutedMemberScopeIfPossible");
      p.h(parami, "kotlinTypeRefiner");
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
          parami = parame.gnk();
          p.g(parami, "this.unsubstitutedMemberScope");
        }
        AppMethodBeat.o(57168);
        return parami;
      }
    }
    
    public static h a(e parame, ay paramay, i parami)
    {
      AppMethodBeat.i(57169);
      p.h(parame, "$this$getRefinedMemberScopeIfPossible");
      p.h(paramay, "typeSubstitution");
      p.h(parami, "kotlinTypeRefiner");
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
          p.g(parami, "this.getMemberScope(\n   …ubstitution\n            )");
        }
        AppMethodBeat.o(57169);
        return parami;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.t
 * JD-Core Version:    0.7.0.1
 */