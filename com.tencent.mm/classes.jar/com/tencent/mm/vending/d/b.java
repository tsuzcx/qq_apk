package com.tencent.mm.vending.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b<T>
{
  private volatile List<T> LhR;
  
  private b(List paramList)
  {
    this.LhR = paramList;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(74867);
    Object localObject = this.LhR.get(paramInt);
    AppMethodBeat.o(74867);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(74866);
    int i = this.LhR.size();
    AppMethodBeat.o(74866);
    return i;
  }
  
  public static final class a<T>
  {
    private ArrayList<T> LhS;
    
    public a()
    {
      AppMethodBeat.i(74868);
      this.LhS = new ArrayList();
      AppMethodBeat.o(74868);
    }
    
    private void agv()
    {
      AppMethodBeat.i(177475);
      if (this.LhS == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError();
        AppMethodBeat.o(177475);
        throw localIllegalAccessError;
      }
      AppMethodBeat.o(177475);
    }
    
    public final a<T> F(T... paramVarArgs)
    {
      AppMethodBeat.i(74870);
      agv();
      int i = 0;
      while (i <= 0)
      {
        T ? = paramVarArgs[0];
        this.LhS.add(?);
        i += 1;
      }
      AppMethodBeat.o(74870);
      return this;
    }
    
    public final b<T> fNY()
    {
      AppMethodBeat.i(74871);
      agv();
      Object localObject = this.LhS;
      this.LhS = null;
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