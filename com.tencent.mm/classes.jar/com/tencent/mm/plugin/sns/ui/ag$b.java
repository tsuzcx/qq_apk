package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class ag$b
{
  ArrayList<String> rKh;
  Map<String, Boolean> rKi;
  Map<String, Integer> rKj;
  
  ag$b(ag paramag)
  {
    AppMethodBeat.i(38488);
    this.rKh = new ArrayList();
    this.rKi = new HashMap();
    this.rKj = new HashMap();
    AppMethodBeat.o(38488);
  }
  
  public final void R(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(38490);
    this.rKi.clear();
    if (paramArrayList == null)
    {
      this.rKh = new ArrayList();
      AppMethodBeat.o(38490);
      return;
    }
    this.rKh = paramArrayList;
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      this.rKi.put(str, Boolean.FALSE);
    }
    AppMethodBeat.o(38490);
  }
  
  public final b ace(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(38492);
    try
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split(",");
        this.rKh.add(arrayOfString[0]);
        this.rKj.put(arrayOfString[0], Integer.valueOf(bo.getInt(arrayOfString[1], 0)));
        i += 1;
      }
      return this;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(38492);
    }
  }
  
  public final b q(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38489);
    this.rKh.add(paramString);
    this.rKj.put(paramString, Integer.valueOf(paramInt));
    this.rKi.put(paramString, Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(38489);
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(38491);
    Iterator localIterator = this.rKh.iterator();
    String str2;
    int i;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + "," + i + ";")
    {
      str2 = (String)localIterator.next();
      i = 0;
      if (this.rKj != null) {
        i = ((Integer)this.rKj.get(str2)).intValue();
      }
    }
    AppMethodBeat.o(38491);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.b
 * JD-Core Version:    0.7.0.1
 */