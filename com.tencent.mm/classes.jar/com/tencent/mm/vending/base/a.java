package com.tencent.mm.vending.base;

public abstract class a<_Struct>
  extends Vending<_Struct, Class<?>, Void>
{
  protected abstract _Struct bl(Class<?> paramClass);
  
  protected void destroyAsynchronous() {}
  
  public void notifyVendingDataChange() {}
  
  public void notifyVendingDataChangeSynchronize() {}
  
  public static abstract interface a
    extends Vending.e
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.a
 * JD-Core Version:    0.7.0.1
 */