package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.t;
import java.util.List;

public final class d
  extends d.l.b.a.b.j.f.e
{
  public d(d.l.b.a.b.l.j paramj, b paramb)
  {
    super(paramj, (d.l.b.a.b.b.e)paramb);
    AppMethodBeat.i(56736);
    AppMethodBeat.o(56736);
  }
  
  public final List<t> ghS()
  {
    AppMethodBeat.i(56735);
    Object localObject = this.NxP;
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
      AppMethodBeat.o(56735);
      throw ((Throwable)localObject);
    }
    localObject = ((b)localObject).MSI;
    switch (e.cpQ[localObject.ordinal()])
    {
    default: 
      localObject = (List)d.a.v.MKE;
      AppMethodBeat.o(56735);
      return localObject;
    case 1: 
      localObject = f.MSV;
      localObject = d.a.j.listOf(f.a.a((b)this.NxP, false));
      AppMethodBeat.o(56735);
      return localObject;
    }
    localObject = f.MSV;
    localObject = d.a.j.listOf(f.a.a((b)this.NxP, true));
    AppMethodBeat.o(56735);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */