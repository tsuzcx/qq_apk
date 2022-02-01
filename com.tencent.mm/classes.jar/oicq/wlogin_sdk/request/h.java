package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h
  extends d
{
  public h(i parami)
  {
    this.Ucx = 2064;
    this.Ucy = 3;
    this.UcA = parami;
  }
  
  public final int ac(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88076);
    f localf = new f();
    g localg = new g();
    paramInt2 = super.aj(paramArrayOfByte, paramInt1 + 2);
    super.hPy();
    int j = paramInt1 + 5;
    switch (paramInt2)
    {
    case 3: 
    case 4: 
    default: 
      ab(paramArrayOfByte, j, this.Ucm - j - 1);
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      AppMethodBeat.o(88076);
      return paramInt1;
      int i = localf.af(paramArrayOfByte, j, this.Ucm - j);
      paramInt1 = i;
      if (i >= 0)
      {
        this.UcA.UcF = localf;
        i = localg.af(paramArrayOfByte, j, this.Ucm - j);
        paramInt1 = i;
        if (i >= 0)
        {
          this.UcA.UcG = localg;
          paramInt1 = paramInt2;
          continue;
          super.ab(paramArrayOfByte, j, this.Ucm - j - 1);
          paramInt1 = paramInt2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.h
 * JD-Core Version:    0.7.0.1
 */