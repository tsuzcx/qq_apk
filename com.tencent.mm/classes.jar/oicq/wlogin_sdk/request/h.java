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
    this.ajGQ = 2064;
    this.ajGR = 3;
    this.ajGT = parami;
  }
  
  public final int ab(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88076);
    f localf = new f();
    g localg = new g();
    paramInt2 = super.am(paramArrayOfByte, paramInt1 + 2);
    super.kGh();
    int j = paramInt1 + 5;
    switch (paramInt2)
    {
    case 3: 
    case 4: 
    default: 
      aa(paramArrayOfByte, j, this.ajGF - j - 1);
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      AppMethodBeat.o(88076);
      return paramInt1;
      int i = localf.ae(paramArrayOfByte, j, this.ajGF - j);
      paramInt1 = i;
      if (i >= 0)
      {
        this.ajGT.ajGY = localf;
        i = localg.ae(paramArrayOfByte, j, this.ajGF - j);
        paramInt1 = i;
        if (i >= 0)
        {
          this.ajGT.ajGZ = localg;
          paramInt1 = paramInt2;
          continue;
          super.aa(paramArrayOfByte, j, this.ajGF - j - 1);
          paramInt1 = paramInt2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.request.h
 * JD-Core Version:    0.7.0.1
 */