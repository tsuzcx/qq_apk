package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.k.g;

@Metadata(d1={""}, d2={"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ap<T>
  extends e<T>
{
  private final List<T> aivC;
  
  public ap(List<T> paramList)
  {
    AppMethodBeat.i(129150);
    this.aivC = paramList;
    AppMethodBeat.o(129150);
  }
  
  public final void add(int paramInt, T paramT)
  {
    AppMethodBeat.i(129149);
    List localList = this.aivC;
    int i = size();
    if (paramInt < 0) {}
    while (i < paramInt)
    {
      paramT = (Throwable)new IndexOutOfBoundsException("Position index " + paramInt + " must be in range [" + new g(0, size()) + "].");
      AppMethodBeat.o(129149);
      throw paramT;
    }
    localList.add(size() - paramInt, paramT);
    AppMethodBeat.o(129149);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(129146);
    this.aivC.clear();
    AppMethodBeat.o(129146);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(129145);
    Object localObject = this.aivC.get(x.ad(this, paramInt));
    AppMethodBeat.o(129145);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(129144);
    int i = this.aivC.size();
    AppMethodBeat.o(129144);
    return i;
  }
  
  public final T removeAt(int paramInt)
  {
    AppMethodBeat.i(129147);
    Object localObject = this.aivC.remove(x.ad(this, paramInt));
    AppMethodBeat.o(129147);
    return localObject;
  }
  
  public final T set(int paramInt, T paramT)
  {
    AppMethodBeat.i(129148);
    paramT = this.aivC.set(x.ad(this, paramInt), paramT);
    AppMethodBeat.o(129148);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ap
 * JD-Core Version:    0.7.0.1
 */