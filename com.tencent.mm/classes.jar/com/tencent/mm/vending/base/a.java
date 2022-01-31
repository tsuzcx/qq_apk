package com.tencent.mm.vending.base;

public abstract class a<_Struct>
  extends Vending<_Struct, Class<?>, Void>
{
  protected abstract _Struct aA(Class<?> paramClass);
  
  protected void destroyAsynchronous() {}
  
  public void notifyVendingDataChange() {}
  
  public void notifyVendingDataChangeSynchronize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.vending.base.a
 * JD-Core Version:    0.7.0.1
 */