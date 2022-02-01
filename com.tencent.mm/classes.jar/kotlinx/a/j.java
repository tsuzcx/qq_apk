package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/PolymorphicKind;", "Lkotlinx/serialization/SerialKind;", "()V", "OPEN", "SEALED", "Lkotlinx/serialization/PolymorphicKind$SEALED;", "Lkotlinx/serialization/PolymorphicKind$OPEN;", "kotlinx-serialization-runtime"})
public abstract class j
  extends s
{
  private j()
  {
    super((byte)0);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/PolymorphicKind$OPEN;", "Lkotlinx/serialization/PolymorphicKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class a
    extends j
  {
    public static final a Oiq;
    
    static
    {
      AppMethodBeat.i(199835);
      Oiq = new a();
      AppMethodBeat.o(199835);
    }
    
    private a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/PolymorphicKind$SEALED;", "Lkotlinx/serialization/PolymorphicKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class b
    extends j
  {
    public static final b Oir;
    
    static
    {
      AppMethodBeat.i(199593);
      Oir = new b();
      AppMethodBeat.o(199593);
    }
    
    private b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.j
 * JD-Core Version:    0.7.0.1
 */