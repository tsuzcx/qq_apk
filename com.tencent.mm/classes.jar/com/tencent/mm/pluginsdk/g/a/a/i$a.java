package com.tencent.mm.pluginsdk.g.a.a;

 enum i$a
{
  final int bcw;
  
  private i$a(int paramInt)
  {
    this.bcw = paramInt;
  }
  
  static boolean DM(int paramInt)
  {
    return (rWG.bcw & paramInt) > 0;
  }
  
  static boolean DN(int paramInt)
  {
    return (rWH.bcw & paramInt) > 0;
  }
  
  static int DO(int paramInt)
  {
    return rWH.bcw | paramInt;
  }
  
  static int cly()
  {
    return rWG.bcw | 0x0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.i.a
 * JD-Core Version:    0.7.0.1
 */