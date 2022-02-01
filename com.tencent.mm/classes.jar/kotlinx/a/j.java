package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/PolymorphicKind;", "Lkotlinx/serialization/SerialKind;", "()V", "OPEN", "SEALED", "Lkotlinx/serialization/PolymorphicKind$SEALED;", "Lkotlinx/serialization/PolymorphicKind$OPEN;", "kotlinx-serialization-runtime"})
public abstract class j
  extends s
{
  private j()
  {
    super((byte)0);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/PolymorphicKind$OPEN;", "Lkotlinx/serialization/PolymorphicKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class a
    extends j
  {
    public static final a NLk;
    
    static
    {
      AppMethodBeat.i(191247);
      NLk = new a();
      AppMethodBeat.o(191247);
    }
    
    private a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/PolymorphicKind$SEALED;", "Lkotlinx/serialization/PolymorphicKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class b
    extends j
  {
    public static final b NLl;
    
    static
    {
      AppMethodBeat.i(191005);
      NLl = new b();
      AppMethodBeat.o(191005);
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