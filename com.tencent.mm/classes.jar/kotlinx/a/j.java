package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/PolymorphicKind;", "Lkotlinx/serialization/SerialKind;", "()V", "OPEN", "SEALED", "Lkotlinx/serialization/PolymorphicKind$SEALED;", "Lkotlinx/serialization/PolymorphicKind$OPEN;", "kotlinx-serialization-runtime"})
public abstract class j
  extends s
{
  private j()
  {
    super((byte)0);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/PolymorphicKind$OPEN;", "Lkotlinx/serialization/PolymorphicKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class a
    extends j
  {
    public static final a TXm;
    
    static
    {
      AppMethodBeat.i(225607);
      TXm = new a();
      AppMethodBeat.o(225607);
    }
    
    private a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/PolymorphicKind$SEALED;", "Lkotlinx/serialization/PolymorphicKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class b
    extends j
  {
    public static final b TXn;
    
    static
    {
      AppMethodBeat.i(225365);
      TXn = new b();
      AppMethodBeat.o(225365);
    }
    
    private b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.j
 * JD-Core Version:    0.7.0.1
 */