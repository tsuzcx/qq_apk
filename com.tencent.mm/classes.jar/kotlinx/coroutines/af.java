package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a;
import d.d.f.c;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CoroutineName;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Key", "kotlinx-coroutines-core"})
public final class af
  extends a
{
  public static final a LRb;
  final String name;
  
  static
  {
    AppMethodBeat.i(118179);
    LRb = new a((byte)0);
    AppMethodBeat.o(118179);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(118181);
    if (this != paramObject)
    {
      if ((paramObject instanceof af))
      {
        paramObject = (af)paramObject;
        if (!k.g(this.name, paramObject.name)) {}
      }
    }
    else
    {
      AppMethodBeat.o(118181);
      return true;
    }
    AppMethodBeat.o(118181);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(118180);
    String str = this.name;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(118180);
      return i;
    }
    AppMethodBeat.o(118180);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118178);
    String str = "CoroutineName(" + this.name + ')';
    AppMethodBeat.o(118178);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CoroutineName$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineName;", "()V", "kotlinx-coroutines-core"})
  public static final class a
    implements f.c<af>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.af
 * JD-Core Version:    0.7.0.1
 */