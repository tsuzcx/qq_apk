package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.k.d;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class aj<T>
  extends c<T>
{
  private final List<T> MKJ;
  
  public aj(List<T> paramList)
  {
    AppMethodBeat.i(129150);
    this.MKJ = paramList;
    AppMethodBeat.o(129150);
  }
  
  public final void add(int paramInt, T paramT)
  {
    AppMethodBeat.i(129149);
    List localList = this.MKJ;
    int i = size();
    if (paramInt < 0) {}
    while (i < paramInt)
    {
      paramT = (Throwable)new IndexOutOfBoundsException("Position index " + paramInt + " must be in range [" + new d(0, size()) + "].");
      AppMethodBeat.o(129149);
      throw paramT;
    }
    localList.add(size() - paramInt, paramT);
    AppMethodBeat.o(129149);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(129146);
    this.MKJ.clear();
    AppMethodBeat.o(129146);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(129145);
    Object localObject = this.MKJ.get(r.D(this, paramInt));
    AppMethodBeat.o(129145);
    return localObject;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(129144);
    int i = this.MKJ.size();
    AppMethodBeat.o(129144);
    return i;
  }
  
  public final T removeAt(int paramInt)
  {
    AppMethodBeat.i(129147);
    Object localObject = this.MKJ.remove(r.D(this, paramInt));
    AppMethodBeat.o(129147);
    return localObject;
  }
  
  public final T set(int paramInt, T paramT)
  {
    AppMethodBeat.i(129148);
    paramT = this.MKJ.set(r.D(this, paramInt), paramT);
    AppMethodBeat.o(129148);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.a.aj
 * JD-Core Version:    0.7.0.1
 */