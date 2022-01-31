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
    this.CMD = 2064;
    this.CME = 3;
    this.CMG = parami;
  }
  
  public final int J(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96437);
    f localf = new f();
    g localg = new g();
    paramInt2 = super.aa(paramArrayOfByte, paramInt1 + 2);
    super.erb();
    int j = paramInt1 + 5;
    switch (paramInt2)
    {
    case 3: 
    case 4: 
    default: 
      I(paramArrayOfByte, j, this.CMs - j - 1);
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      AppMethodBeat.o(96437);
      return paramInt1;
      int i = localf.M(paramArrayOfByte, j, this.CMs - j);
      paramInt1 = i;
      if (i >= 0)
      {
        this.CMG.CML = localf;
        i = localg.M(paramArrayOfByte, j, this.CMs - j);
        paramInt1 = i;
        if (i >= 0)
        {
          this.CMG.CMM = localg;
          paramInt1 = paramInt2;
          continue;
          super.I(paramArrayOfByte, j, this.CMs - j - 1);
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