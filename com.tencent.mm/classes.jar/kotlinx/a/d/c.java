package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.a.f;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"throwSubtypeNotRegistered", "", "subClassName", "", "baseClass", "Lkotlin/reflect/KClass;", "subClass", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class c
{
  static final Void a(String paramString, kotlin.l.c<?> paramc)
  {
    AppMethodBeat.i(188688);
    paramString = (Throwable)new f(paramString + " is not registered for polymorphic serialization in the scope of " + paramc);
    AppMethodBeat.o(188688);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.d.c
 * JD-Core Version:    0.7.0.1
 */