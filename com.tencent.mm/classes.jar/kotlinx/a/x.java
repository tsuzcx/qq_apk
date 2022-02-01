package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/UnionKind;", "Lkotlinx/serialization/SerialKind;", "()V", "CONTEXTUAL", "Companion", "ENUM_KIND", "Lkotlinx/serialization/UnionKind$ENUM_KIND;", "Lkotlinx/serialization/UnionKind$CONTEXTUAL;", "kotlinx-serialization-runtime"})
public abstract class x
  extends s
{
  private static final w.d abBl = w.d.abBk;
  public static final x.b abBm = new x.b((byte)0);
  
  private x()
  {
    super((byte)0);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/UnionKind$CONTEXTUAL;", "Lkotlinx/serialization/UnionKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class a
    extends x
  {
    public static final a abBn;
    
    static
    {
      AppMethodBeat.i(257134);
      abBn = new a();
      AppMethodBeat.o(257134);
    }
    
    private a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/UnionKind$ENUM_KIND;", "Lkotlinx/serialization/UnionKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class c
    extends x
  {
    public static final c abBo;
    
    static
    {
      AppMethodBeat.i(254148);
      abBo = new c();
      AppMethodBeat.o(254148);
    }
    
    private c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.x
 * JD-Core Version:    0.7.0.1
 */