package com.tencent.mm.vending.d;

import java.util.ArrayList;
import java.util.List;

public final class b<T>
{
  private volatile List<T> a;
  
  private b(List paramList)
  {
    this.a = paramList;
  }
  
  public final T get(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public final int size()
  {
    return this.a.size();
  }
  
  public static final class a<T>
  {
    private ArrayList<T> a = new ArrayList();
    
    private void a()
    {
      if (this.a == null) {
        throw new IllegalAccessError();
      }
    }
    
    public final b<T> cKV()
    {
      a();
      ArrayList localArrayList = this.a;
      this.a = null;
      return new b(localArrayList, (byte)0);
    }
    
    public final a<T> w(T... paramVarArgs)
    {
      a();
      int i = 0;
      while (i <= 0)
      {
        T ? = paramVarArgs[0];
        this.a.add(?);
        i += 1;
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.d.b
 * JD-Core Version:    0.7.0.1
 */