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
  
  public final List<t> gmu()
  {
    AppMethodBeat.i(56735);
    Object localObject = this.NUW;
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
      AppMethodBeat.o(56735);
      throw ((Throwable)localObject);
    }
    localObject = ((b)localObject).NpN;
    switch (e.cqt[localObject.ordinal()])
    {
    default: 
      localObject = (List)d.a.v.NhH;
      AppMethodBeat.o(56735);
      return localObject;
    case 1: 
      localObject = f.Nqa;
      localObject = d.a.j.listOf(f.a.a((b)this.NUW, false));
      AppMethodBeat.o(56735);
      return localObject;
    }
    localObject = f.Nqa;
    localObject = d.a.j.listOf(f.a.a((b)this.NUW, true));
    AppMethodBeat.o(56735);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */