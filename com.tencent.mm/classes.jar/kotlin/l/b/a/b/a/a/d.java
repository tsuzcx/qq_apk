package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;

public final class d
  extends kotlin.l.b.a.b.j.f.e
{
  public d(kotlin.l.b.a.b.l.j paramj, b paramb)
  {
    super(paramj, (kotlin.l.b.a.b.b.e)paramb);
    AppMethodBeat.i(56736);
    AppMethodBeat.o(56736);
  }
  
  public final List<kotlin.l.b.a.b.b.t> hzW()
  {
    AppMethodBeat.i(56735);
    Object localObject = this.TJS;
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
      AppMethodBeat.o(56735);
      throw ((Throwable)localObject);
    }
    localObject = ((b)localObject).Tfv;
    switch (e.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      localObject = (List)v.SXr;
      AppMethodBeat.o(56735);
      return localObject;
    case 1: 
      localObject = f.TfI;
      localObject = kotlin.a.j.listOf(f.a.a((b)this.TJS, false));
      AppMethodBeat.o(56735);
      return localObject;
    }
    localObject = f.TfI;
    localObject = kotlin.a.j.listOf(f.a.a((b)this.TJS, true));
    AppMethodBeat.o(56735);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */