package com.tencent.mm.vending.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b<T>
{
  private volatile List<T> Jqm;
  
  private b(List paramList)
  {
    this.Jqm = paramList;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(74867);
    Object localObject = this.Jqm.get(paramInt);
    AppMethodBeat.o(74867);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(74866);
    int i = this.Jqm.size();
    AppMethodBeat.o(74866);
    return i;
  }
  
  public static final class a<T>
  {
    private ArrayList<T> Jqn;
    
    public a()
    {
      AppMethodBeat.i(74868);
      this.Jqn = new ArrayList();
      AppMethodBeat.o(74868);
    }
    
    private void adP()
    {
      AppMethodBeat.i(177475);
      if (this.Jqn == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError();
        AppMethodBeat.o(177475);
        throw localIllegalAccessError;
      }
      AppMethodBeat.o(177475);
    }
    
    public final a<T> E(T... paramVarArgs)
    {
      AppMethodBeat.i(74870);
      adP();
      int i = 0;
      while (i <= 0)
      {
        T ? = paramVarArgs[0];
        this.Jqn.add(?);
        i += 1;
      }
      AppMethodBeat.o(74870);
      return this;
    }
    
    public final b<T> fxl()
    {
      AppMethodBeat.i(74871);
      adP();
      Object localObject = this.Jqn;
      this.Jqn = null;
      localObject = new b((List)localObject, (byte)0);
      AppMethodBeat.o(74871);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.d.b
 * JD-Core Version:    0.7.0.1
 */