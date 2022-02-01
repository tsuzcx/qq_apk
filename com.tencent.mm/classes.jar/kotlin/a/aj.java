package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.k.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class aj<T>
  extends c<T>
{
  private final List<T> aaAh;
  
  public aj(List<T> paramList)
  {
    AppMethodBeat.i(129150);
    this.aaAh = paramList;
    AppMethodBeat.o(129150);
  }
  
  public final void add(int paramInt, T paramT)
  {
    AppMethodBeat.i(129149);
    List localList = this.aaAh;
    int i = size();
    if (paramInt < 0) {}
    while (i < paramInt)
    {
      paramT = (Throwable)new IndexOutOfBoundsException("Position index " + paramInt + " must be in range [" + new e(0, size()) + "].");
      AppMethodBeat.o(129149);
      throw paramT;
    }
    localList.add(size() - paramInt, paramT);
    AppMethodBeat.o(129149);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(129146);
    this.aaAh.clear();
    AppMethodBeat.o(129146);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(129145);
    Object localObject = this.aaAh.get(r.L(this, paramInt));
    AppMethodBeat.o(129145);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(129144);
    int i = this.aaAh.size();
    AppMethodBeat.o(129144);
    return i;
  }
  
  public final T removeAt(int paramInt)
  {
    AppMethodBeat.i(129147);
    Object localObject = this.aaAh.remove(r.L(this, paramInt));
    AppMethodBeat.o(129147);
    return localObject;
  }
  
  public final T set(int paramInt, T paramT)
  {
    AppMethodBeat.i(129148);
    paramT = this.aaAh.set(r.L(this, paramInt), paramT);
    AppMethodBeat.o(129148);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.aj
 * JD-Core Version:    0.7.0.1
 */