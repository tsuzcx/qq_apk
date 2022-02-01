package d.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.lang.reflect.Field;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"})
public final class f
{
  public static final StackTraceElement a(a parama)
  {
    AppMethodBeat.i(186165);
    k.h(parama, "$this$getStackTraceElementImpl");
    e locale = b(parama);
    if (locale == null)
    {
      AppMethodBeat.o(186165);
      return null;
    }
    agI(locale.fOl());
    int i = c(parama);
    if (i < 0)
    {
      i = -1;
      g localg = g.KUr;
      parama = g.d(parama);
      if (parama != null) {
        break label108;
      }
    }
    label108:
    for (parama = locale.c();; parama = parama + '/' + locale.c())
    {
      parama = new StackTraceElement(parama, locale.m(), locale.f(), i);
      AppMethodBeat.o(186165);
      return parama;
      i = locale.l()[i];
      break;
    }
  }
  
  private static final void agI(int paramInt)
  {
    AppMethodBeat.i(186167);
    if (paramInt > 1)
    {
      Throwable localThrowable = (Throwable)new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + paramInt + ". Please update the Kotlin standard library.").toString());
      AppMethodBeat.o(186167);
      throw localThrowable;
    }
    AppMethodBeat.o(186167);
  }
  
  private static final e b(a parama)
  {
    AppMethodBeat.i(186166);
    parama = (e)parama.getClass().getAnnotation(e.class);
    AppMethodBeat.o(186166);
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
        k.g(localObject, "field");
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
 * Qualified Name:     d.d.b.a.f
 * JD-Core Version:    0.7.0.1
 */