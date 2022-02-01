package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a<T>
  implements e
{
  private List<T> hJj;
  
  public a(List<T> paramList)
  {
    this.hJj = paramList;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(192766);
    if ((paramInt >= 0) && (paramInt < this.hJj.size()))
    {
      Object localObject = this.hJj.get(paramInt);
      AppMethodBeat.o(192766);
      return localObject;
    }
    AppMethodBeat.o(192766);
    return "";
  }
  
  public final int getItemsCount()
  {
    AppMethodBeat.i(192768);
    int i = this.hJj.size();
    AppMethodBeat.o(192768);
    return i;
  }
  
  public final String qL(int paramInt)
  {
    AppMethodBeat.i(192767);
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(192767);
      return localObject1;
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = localObject2.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.a
 * JD-Core Version:    0.7.0.1
 */