package com.tencent.mm.vending.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b<T>
{
  private volatile List<T> LEt;
  
  private b(List paramList)
  {
    this.LEt = paramList;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(74867);
    Object localObject = this.LEt.get(paramInt);
    AppMethodBeat.o(74867);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(74866);
    int i = this.LEt.size();
    AppMethodBeat.o(74866);
    return i;
  }
  
  public static final class a<T>
  {
    private ArrayList<T> LEu;
    
    public a()
    {
      AppMethodBeat.i(74868);
      this.LEu = new ArrayList();
      AppMethodBeat.o(74868);
    }
    
    private void agJ()
    {
      AppMethodBeat.i(177475);
      if (this.LEu == null)
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
      agJ();
      int i = 0;
      while (i <= 0)
      {
        T ? = paramVarArgs[0];
        this.LEu.add(?);
        i += 1;
      }
      AppMethodBeat.o(74870);
      return this;
    }
    
    public final b<T> fSt()
    {
      AppMethodBeat.i(74871);
      agJ();
      Object localObject = this.LEu;
      this.LEu = null;
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