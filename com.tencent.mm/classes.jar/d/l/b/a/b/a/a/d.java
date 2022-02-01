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
  
  public final List<t> fxQ()
  {
    AppMethodBeat.i(56735);
    Object localObject = this.JTy;
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
      AppMethodBeat.o(56735);
      throw ((Throwable)localObject);
    }
    localObject = ((b)localObject).Jot;
    switch (e.ciE[localObject.ordinal()])
    {
    default: 
      localObject = (List)d.a.v.Jgl;
      AppMethodBeat.o(56735);
      return localObject;
    case 1: 
      localObject = f.JoH;
      localObject = j.listOf(f.a.a((b)this.JTy, false));
      AppMethodBeat.o(56735);
      return localObject;
    }
    localObject = f.JoH;
    localObject = j.listOf(f.a.a((b)this.JTy, true));
    AppMethodBeat.o(56735);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */