package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a<T>
  implements e
{
  private List<T> hMc;
  
  public a(List<T> paramList)
  {
    this.hMc = paramList;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(200539);
    if ((paramInt >= 0) && (paramInt < this.hMc.size()))
    {
      Object localObject = this.hMc.get(paramInt);
      AppMethodBeat.o(200539);
      return localObject;
    }
    AppMethodBeat.o(200539);
    return "";
  }
  
  public final int getItemsCount()
  {
    AppMethodBeat.i(200541);
    int i = this.hMc.size();
    AppMethodBeat.o(200541);
    return i;
  }
  
  public final String qO(int paramInt)
  {
    AppMethodBeat.i(200540);
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(200540);
      return localObject1;
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = localObject2.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.a
 * JD-Core Version:    0.7.0.1
 */