package d.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.lang.reflect.Field;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"})
public final class g
{
  public static final StackTraceElement a(a parama)
  {
    AppMethodBeat.i(199641);
    p.h(parama, "$this$getStackTraceElementImpl");
    f localf = b(parama);
    if (localf == null)
    {
      AppMethodBeat.o(199641);
      return null;
    }
    ajj(localf.gfK());
    int i = c(parama);
    if (i < 0)
    {
      i = -1;
      h localh = h.MLq;
      parama = h.d(parama);
      if (parama != null) {
        break label108;
      }
    }
    label108:
    for (parama = localf.c();; parama = parama + '/' + localf.c())
    {
      parama = new StackTraceElement(parama, localf.m(), localf.f(), i);
      AppMethodBeat.o(199641);
      return parama;
      i = localf.gfL()[i];
      break;
    }
  }
  
  private static final void ajj(int paramInt)
  {
    AppMethodBeat.i(199643);
    if (paramInt > 1)
    {
      Throwable localThrowable = (Throwable)new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + paramInt + ". Please update the Kotlin standard library.").toString());
      AppMethodBeat.o(199643);
      throw localThrowable;
    }
    AppMethodBeat.o(199643);
  }
  
  private static final f b(a parama)
  {
    AppMethodBeat.i(199642);
    parama = (f)parama.getClass().getAnnotation(f.class);
    AppMethodBeat.o(199642);
    return parama;
  }
  
  private static final int c(a parama)
  {
    AppMethodBeat.i(129608);
    for (;;)
    {
      try
      {
        Object localObject = parama.getClass().getDeclaredField("label");
        p.g(localObject, "field");
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(parama);
        parama = (a)localObject;
        if (!(localObject instanceof Integer)) {
          parama = null;
        }
        parama = (Integer)parama;
        if (parama == null) {
          continue;
        }
        i = parama.intValue();
        i -= 1;
      }
      catch (Exception parama)
      {
        int i = -1;
        continue;
      }
      AppMethodBeat.o(129608);
      return i;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.g
 * JD-Core Version:    0.7.0.1
 */