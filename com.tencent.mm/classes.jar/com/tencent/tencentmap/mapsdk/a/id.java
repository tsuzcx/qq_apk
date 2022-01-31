package com.tencent.tencentmap.mapsdk.a;

public class id
  implements Cloneable
{
  private static final if<Integer> d = new hz();
  private static final if<Number> e = new hw();
  int a;
  Class<?> b;
  ib c = null;
  private if f;
  
  private id(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static id a(int paramInt, if<Object> paramif, Object... paramVarArgs)
  {
    id localid = new id(paramInt);
    localid.a(paramVarArgs);
    localid.a(paramif);
    return localid;
  }
  
  public static id a(int paramInt, double... paramVarArgs)
  {
    return new id.a(paramInt, paramVarArgs);
  }
  
  public id a()
  {
    try
    {
      id localid = (id)super.clone();
      localid.a = this.a;
      localid.c = this.c.b();
      localid.f = this.f;
      return localid;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public void a(if paramif)
  {
    this.f = paramif;
    this.c.a(paramif);
  }
  
  public void a(double... paramVarArgs)
  {
    this.b = Double.TYPE;
    this.c = ib.a(paramVarArgs);
  }
  
  public void a(Object... paramVarArgs)
  {
    this.b = paramVarArgs[0].getClass();
    this.c = ib.a(paramVarArgs);
  }
  
  public int b()
  {
    return this.a;
  }
  
  public String toString()
  {
    return this.a + ": " + this.c.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.id
 * JD-Core Version:    0.7.0.1
 */