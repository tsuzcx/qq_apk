package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.l.b;
import kotlinx.a.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"throwSubtypeNotRegistered", "", "subClassName", "", "baseClass", "Lkotlin/reflect/KClass;", "subClass", "kotlinx-serialization-runtime"})
public final class c
{
  static final Void a(String paramString, b<?> paramb)
  {
    AppMethodBeat.i(225391);
    paramString = (Throwable)new t(paramString + " is not registered for polymorphic serialization in the scope of " + paramb, (byte)0);
    AppMethodBeat.o(225391);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.c
 * JD-Core Version:    0.7.0.1
 */