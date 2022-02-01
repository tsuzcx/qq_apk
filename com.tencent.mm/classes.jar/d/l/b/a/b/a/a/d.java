package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.l.b.a.b.b.t;
import d.l.b.a.b.l.i;
import java.util.List;

public final class d
  extends d.l.b.a.b.j.f.e
{
  public d(i parami, b paramb)
  {
    super(parami, (d.l.b.a.b.b.e)paramb);
    AppMethodBeat.i(56736);
    AppMethodBeat.o(56736);
  }
  
  public final List<t> fQu()
  {
    AppMethodBeat.i(56735);
    Object localObject = this.LGR;
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
      AppMethodBeat.o(56735);
      throw ((Throwable)localObject);
    }
    localObject = ((b)localObject).LbN;
    switch (e.cfA[localObject.ordinal()])
    {
    default: 
      localObject = (List)d.a.v.KTF;
      AppMethodBeat.o(56735);
      return localObject;
    case 1: 
      localObject = f.Lca;
      localObject = j.listOf(f.a.a((b)this.LGR, false));
      AppMethodBeat.o(56735);
      return localObject;
    }
    localObject = f.Lca;
    localObject = j.listOf(f.a.a((b)this.LGR, true));
    AppMethodBeat.o(56735);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */