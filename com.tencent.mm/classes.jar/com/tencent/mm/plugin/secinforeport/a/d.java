package com.tencent.mm.plugin.secinforeport.a;

public enum d
  implements c
{
  private static c nQs = new d.a((byte)0);
  
  private d() {}
  
  public static void a(c paramc)
  {
    if (paramc != null) {
      nQs = paramc;
    }
  }
  
  public final boolean M(int paramInt, long paramLong)
  {
    return nQs.M(paramInt, paramLong);
  }
  
  public final void dI(int paramInt1, int paramInt2)
  {
    nQs.dI(paramInt1, paramInt2);
  }
  
  public final void o(int paramInt, byte[] paramArrayOfByte)
  {
    nQs.o(paramInt, paramArrayOfByte);
  }
  
  public final void wZ(int paramInt)
  {
    nQs.wZ(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.a.d
 * JD-Core Version:    0.7.0.1
 */