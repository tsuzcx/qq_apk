package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/UnionKind;", "Lkotlinx/serialization/SerialKind;", "()V", "CONTEXTUAL", "Companion", "ENUM_KIND", "Lkotlinx/serialization/UnionKind$ENUM_KIND;", "Lkotlinx/serialization/UnionKind$CONTEXTUAL;", "kotlinx-serialization-runtime"})
public abstract class x
  extends s
{
  private static final w.d Oja = w.d.OiZ;
  public static final b Ojb = new b((byte)0);
  
  private x()
  {
    super((byte)0);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/UnionKind$CONTEXTUAL;", "Lkotlinx/serialization/UnionKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class a
    extends x
  {
    public static final a Ojc;
    
    static
    {
      AppMethodBeat.i(200082);
      Ojc = new a();
      AppMethodBeat.o(200082);
    }
    
    private a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/UnionKind$Companion;", "", "()V", "OBJECT", "Lkotlinx/serialization/StructureKind$OBJECT;", "OBJECT$annotations", "getOBJECT", "()Lkotlinx/serialization/StructureKind$OBJECT;", "kotlinx-serialization-runtime"})
  public static final class b {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/UnionKind$ENUM_KIND;", "Lkotlinx/serialization/UnionKind;", "()V", "kotlinx-serialization-runtime"})
  public static final class c
    extends x
  {
    public static final c Ojd;
    
    static
    {
      AppMethodBeat.i(199587);
      Ojd = new c();
      AppMethodBeat.o(199587);
    }
    
    private c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.x
 * JD-Core Version:    0.7.0.1
 */