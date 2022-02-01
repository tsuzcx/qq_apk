package com.tencent.mm.sdk.platformtools;

import androidx.a.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

class WeChatBrands$PlaceHolderHandler$2
  implements a<List, String>
{
  WeChatBrands$PlaceHolderHandler$2(WeChatBrands.PlaceHolderHandler paramPlaceHolderHandler) {}
  
  public String apply(List paramList)
  {
    AppMethodBeat.i(249411);
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(paramList.next().toString());
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(249411);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands.PlaceHolderHandler.2
 * JD-Core Version:    0.7.0.1
 */