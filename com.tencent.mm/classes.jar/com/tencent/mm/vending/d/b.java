package com.tencent.mm.vending.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(126073);
    Object localObject = this.a.get(paramInt);
    AppMethodBeat.o(126073);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(126072);
    int i = this.a.size();
    AppMethodBeat.o(126072);
    return i;
  }
  
  public static final class a<T>
  {
    private ArrayList<T> a;
    
    public a()
    {
      AppMethodBeat.i(126074);
      this.a = new ArrayList();
      AppMethodBeat.o(126074);
    }
    
    private void a()
    {
      AppMethodBeat.i(126075);
      if (this.a == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError();
        AppMethodBeat.o(126075);
        throw localIllegalAccessError;
      }
      AppMethodBeat.o(126075);
    }
    
    public final a<T> B(T... paramVarArgs)
    {
      AppMethodBeat.i(126076);
      a();
      int i = 0;
      while (i <= 0)
      {
        T ? = paramVarArgs[0];
        this.a.add(?);
        i += 1;
      }
      AppMethodBeat.o(126076);
      return this;
    }
    
    public final b<T> dQl()
    {
      AppMethodBeat.i(126077);
      a();
      Object localObject = this.a;
      this.a = null;
      localObject = new b((List)localObject, (byte)0);
      AppMethodBeat.o(126077);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.d.b
 * JD-Core Version:    0.7.0.1
 */