package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class ag$b
{
  ArrayList<String> oSo = new ArrayList();
  Map<String, Boolean> oSp = new HashMap();
  Map<String, Integer> oSq = new HashMap();
  
  ag$b(ag paramag) {}
  
  public final void P(ArrayList<String> paramArrayList)
  {
    this.oSp.clear();
    if (paramArrayList == null) {
      this.oSo = new ArrayList();
    }
    for (;;)
    {
      return;
      this.oSo = paramArrayList;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        this.oSp.put(str, Boolean.valueOf(false));
      }
    }
  }
  
  public final b Pk(String paramString)
  {
    int i = 0;
    try
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split(",");
        this.oSo.add(arrayOfString[0]);
        this.oSq.put(arrayOfString[0], Integer.valueOf(bk.getInt(arrayOfString[1], 0)));
        i += 1;
      }
      return this;
    }
    catch (Exception paramString) {}
  }
  
  public final b o(String paramString, int paramInt, boolean paramBoolean)
  {
    this.oSo.add(paramString);
    this.oSq.put(paramString, Integer.valueOf(paramInt));
    this.oSp.put(paramString, Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public final String toString()
  {
    Iterator localIterator = this.oSo.iterator();
    String str2;
    int i;
    for (String str1 = ""; localIterator.hasNext(); str1 = str1 + str2 + "," + i + ";")
    {
      str2 = (String)localIterator.next();
      i = 0;
      if (this.oSq != null) {
        i = ((Integer)this.oSq.get(str2)).intValue();
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.b
 * JD-Core Version:    0.7.0.1
 */