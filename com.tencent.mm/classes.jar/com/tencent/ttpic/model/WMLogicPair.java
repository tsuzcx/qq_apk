package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WMLogicPair
  implements Comparable<WMLogicPair>
{
  public String key;
  public String value;
  
  public WMLogicPair(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public int compareTo(WMLogicPair paramWMLogicPair)
  {
    AppMethodBeat.i(83602);
    if (Integer.parseInt(this.key) > Integer.parseInt(paramWMLogicPair.key))
    {
      AppMethodBeat.o(83602);
      return 1;
    }
    AppMethodBeat.o(83602);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.model.WMLogicPair
 * JD-Core Version:    0.7.0.1
 */