package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/PolymorphicKind;", "Lkotlinx/serialization/SerialKind;", "()V", "OPEN", "SEALED", "Lkotlinx/serialization/PolymorphicKind$SEALED;", "Lkotlinx/serialization/PolymorphicKind$OPEN;", "kotlinx-serialization-runtime"})
public abstract class j
  extends s
{
  private j()
  {
    super((byte)0);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/PolymorphicKind$OPEN;", "Lkotlinx/serialization/PolymorphicKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class a
    extends j
  {
    public static final a abAD;
    
    static
    {
      AppMethodBeat.i(254942);
      abAD = new a();
      AppMethodBeat.o(254942);
    }
    
    private a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/PolymorphicKind$SEALED;", "Lkotlinx/serialization/PolymorphicKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class b
    extends j
  {
    public static final b abAE;
    
    static
    {
      AppMethodBeat.i(254166);
      abAE = new b();
      AppMethodBeat.o(254166);
    }
    
    private b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.j
 * JD-Core Version:    0.7.0.1
 */