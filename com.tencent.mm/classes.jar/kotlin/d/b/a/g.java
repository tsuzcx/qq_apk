package kotlin.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class g
{
  static final int a(a parama)
  {
    AppMethodBeat.i(129608);
    for (;;)
    {
      try
      {
        Object localObject = parama.getClass().getDeclaredField("label");
        s.s(localObject, "field");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.b.a.g
 * JD-Core Version:    0.7.0.1
 */