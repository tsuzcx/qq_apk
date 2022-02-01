package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.l.c;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/descriptors/SerialKind;", "", "()V", "hashCode", "", "toString", "", "CONTEXTUAL", "ENUM", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "Lkotlinx/serialization/descriptors/StructureKind;", "Lkotlinx/serialization/descriptors/PolymorphicKind;", "Lkotlinx/serialization/descriptors/SerialKind$ENUM;", "Lkotlinx/serialization/descriptors/SerialKind$CONTEXTUAL;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class i
{
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    String str = ai.cz(getClass()).klt();
    s.checkNotNull(str);
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/descriptors/SerialKind$CONTEXTUAL;", "Lkotlinx/serialization/descriptors/SerialKind;", "()V", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
  public static final class a
    extends i
  {
    public static final a ajDh;
    
    static
    {
      AppMethodBeat.i(188457);
      ajDh = new a();
      AppMethodBeat.o(188457);
    }
    
    private a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.b.i
 * JD-Core Version:    0.7.0.1
 */