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
    this.Ony = 2064;
    this.Onz = 3;
    this.OnB = parami;
  }
  
  public final int S(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88076);
    f localf = new f();
    g localg = new g();
    paramInt2 = super.ai(paramArrayOfByte, paramInt1 + 2);
    super.gCu();
    int j = paramInt1 + 5;
    switch (paramInt2)
    {
    case 3: 
    case 4: 
    default: 
      R(paramArrayOfByte, j, this.Onn - j - 1);
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      AppMethodBeat.o(88076);
      return paramInt1;
      int i = localf.V(paramArrayOfByte, j, this.Onn - j);
      paramInt1 = i;
      if (i >= 0)
      {
        this.OnB.OnG = localf;
        i = localg.V(paramArrayOfByte, j, this.Onn - j);
        paramInt1 = i;
        if (i >= 0)
        {
          this.OnB.OnH = localg;
          paramInt1 = paramInt2;
          continue;
          super.R(paramArrayOfByte, j, this.Onn - j - 1);
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