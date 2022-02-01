package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class ak$b
{
  ArrayList<String> xqL;
  Map<String, Boolean> xqM;
  Map<String, Integer> xqN;
  
  ak$b(ak paramak)
  {
    AppMethodBeat.i(98168);
    this.xqL = new ArrayList();
    this.xqM = new HashMap();
    this.xqN = new HashMap();
    AppMethodBeat.o(98168);
  }
  
  public final void ao(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(98170);
    this.xqM.clear();
    if (paramArrayList == null)
    {
      this.xqL = new ArrayList();
      AppMethodBeat.o(98170);
      return;
    }
    this.xqL = paramArrayList;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.xqM.put(str, Boolean.FALSE);
    }
    AppMethodBeat.o(98170);
  }
  
  public final b aqw(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(98172);
    try
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split(",");
        this.xqL.add(arrayOfString[0]);
        this.xqN.put(arrayOfString[0], Integer.valueOf(bt.getInt(arrayOfString[1], 0)));
        i += 1;
      }
      return this;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(98172);
    }
  }
  
  public final b q(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(98169);
    this.xqL.add(paramString);
    this.xqN.put(paramString, Integer.valueOf(paramInt));
    this.xqM.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(98169);
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(98171);
    Iterator localIterator = this.xqL.iterator();
    String str2;
    int i;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + "," + i + ";")
    {
      str2 = (String)localIterator.next();
      i = 0;
      if (this.xqN != null) {
        i = ((Integer)this.xqN.get(str2)).intValue();
      }
    }
    AppMethodBeat.o(98171);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak.b
 * JD-Core Version:    0.7.0.1
 */