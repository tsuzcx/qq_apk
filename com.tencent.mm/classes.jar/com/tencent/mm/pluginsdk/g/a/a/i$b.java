package com.tencent.mm.pluginsdk.g.a.a;

 enum i$b
{
  final int bcw;
  
  private i$b(int paramInt)
  {
    this.bcw = paramInt;
  }
  
  static boolean DP(int paramInt)
  {
    return paramInt == rWJ.bcw;
  }
  
  static boolean DQ(int paramInt)
  {
    return (rWK.bcw & paramInt) > 0;
  }
  
  static boolean DR(int paramInt)
  {
    return (rWL.bcw & paramInt) > 0;
  }
  
  static boolean DS(int paramInt)
  {
    return (rWM.bcw & paramInt) > 0;
  }
  
  static int Wi(String paramString)
  {
    if ("cache".equals(paramString)) {
      return rWK.bcw;
    }
    if ("delete".equals(paramString)) {
      return rWM.bcw;
    }
    if ("decrypt".equals(paramString)) {
      return rWL.bcw;
    }
    return rWJ.bcw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.i.b
 * JD-Core Version:    0.7.0.1
 */