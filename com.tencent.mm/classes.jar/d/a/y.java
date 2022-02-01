package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/collections/IndexedValue;", "T", "", "index", "", "value", "(ILjava/lang/Object;)V", "getIndex", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "equals", "", "other", "hashCode", "toString", "", "kotlin-stdlib"})
public final class y<T>
{
  public final int index;
  public final T value;
  
  public y(int paramInt, T paramT)
  {
    this.index = paramInt;
    this.value = paramT;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129129);
    if (this != paramObject)
    {
      if ((paramObject instanceof y))
      {
        paramObject = (y)paramObject;
        if ((this.index != paramObject.index) || (!p.i(this.value, paramObject.value))) {}
      }
    }
    else
    {
      AppMethodBeat.o(129129);
      return true;
    }
    AppMethodBeat.o(129129);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(129128);
    int j = this.index;
    Object localObject = this.value;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      AppMethodBeat.o(129128);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129127);
    String str = "IndexedValue(index=" + this.index + ", value=" + this.value + ")";
    AppMethodBeat.o(129127);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.y
 * JD-Core Version:    0.7.0.1
 */