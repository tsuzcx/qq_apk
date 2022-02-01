package com.tencent.mm.vending.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b<T>
{
  private volatile List<T> HPR;
  
  private b(List paramList)
  {
    this.HPR = paramList;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(74867);
    Object localObject = this.HPR.get(paramInt);
    AppMethodBeat.o(74867);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(74866);
    int i = this.HPR.size();
    AppMethodBeat.o(74866);
    return i;
  }
  
  public static final class a<T>
  {
    private ArrayList<T> HPS;
    
    public a()
    {
      AppMethodBeat.i(74868);
      this.HPS = new ArrayList();
      AppMethodBeat.o(74868);
    }
    
    private void acJ()
    {
      AppMethodBeat.i(177475);
      if (this.HPS == null)
      {
        IllegalAccessError localIllegalAccessError = new IllegalAccessError();
        AppMethodBeat.o(177475);
        throw localIllegalAccessError;
      }
      AppMethodBeat.o(177475);
    }
    
    public final a<T> C(T... paramVarArgs)
    {
      AppMethodBeat.i(74870);
      acJ();
      int i = 0;
      while (i <= 0)
      {
        T ? = paramVarArgs[0];
        this.HPS.add(?);
        i += 1;
      }
      AppMethodBeat.o(74870);
      return this;
    }
    
    public final b<T> fhj()
    {
      AppMethodBeat.i(74871);
      acJ();
      Object localObject = this.HPS;
      this.HPS = null;
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