package com.tencent.mm.ui.widget.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class a<T>
  implements e
{
  private List<T> gQr;
  
  public a(List<T> paramList)
  {
    this.gQr = paramList;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(195349);
    if ((paramInt >= 0) && (paramInt < this.gQr.size()))
    {
      Object localObject = this.gQr.get(paramInt);
      AppMethodBeat.o(195349);
      return localObject;
    }
    AppMethodBeat.o(195349);
    return "";
  }
  
  public final int getItemsCount()
  {
    AppMethodBeat.i(195351);
    int i = this.gQr.size();
    AppMethodBeat.o(195351);
    return i;
  }
  
  public final String pw(int paramInt)
  {
    AppMethodBeat.i(195350);
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(195350);
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