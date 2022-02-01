package kotlinx.a;

import d.g.a;
import d.g.b.p;
import d.g.b.z;
import d.l;
import d.l.b;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/SerialKind;", "", "()V", "toString", "", "Lkotlinx/serialization/PrimitiveKind;", "Lkotlinx/serialization/StructureKind;", "Lkotlinx/serialization/UnionKind;", "Lkotlinx/serialization/PolymorphicKind;", "kotlinx-serialization-runtime"})
public abstract class s
{
  public String toString()
  {
    Object localObject = z.bp(getClass());
    p.h(localObject, "$this$simpleName");
    localObject = a.a((b)localObject).getSimpleName();
    if (localObject == null) {
      p.gfZ();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.s
 * JD-Core Version:    0.7.0.1
 */