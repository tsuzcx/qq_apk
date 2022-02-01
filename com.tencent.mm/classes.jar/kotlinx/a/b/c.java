package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.l.b;
import kotlinx.a.t;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"throwSubtypeNotRegistered", "", "subClassName", "", "baseClass", "Lkotlin/reflect/KClass;", "subClass", "kotlinx-serialization-runtime"})
public final class c
{
  static final Void a(String paramString, b<?> paramb)
  {
    AppMethodBeat.i(191031);
    paramString = (Throwable)new t(paramString + " is not registered for polymorphic serialization in the scope of " + paramb, (byte)0);
    AppMethodBeat.o(191031);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.c
 * JD-Core Version:    0.7.0.1
 */