package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a<T>
  implements e
{
  private List<T> iHf;
  
  public a(List<T> paramList)
  {
    this.iHf = paramList;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(198497);
    if ((paramInt >= 0) && (paramInt < this.iHf.size()))
    {
      Object localObject = this.iHf.get(paramInt);
      AppMethodBeat.o(198497);
      return localObject;
    }
    AppMethodBeat.o(198497);
    return "";
  }
  
  public final int getItemsCount()
  {
    AppMethodBeat.i(198499);
    int i = this.iHf.size();
    AppMethodBeat.o(198499);
    return i;
  }
  
  public final String uG(int paramInt)
  {
    AppMethodBeat.i(198498);
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(198498);
      return localObject1;
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = localObject2.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a.a
 * JD-Core Version:    0.7.0.1
 */