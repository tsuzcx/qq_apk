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
    this.NQs = 2064;
    this.NQt = 3;
    this.NQv = parami;
  }
  
  public final int R(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88076);
    f localf = new f();
    g localg = new g();
    paramInt2 = super.ae(paramArrayOfByte, paramInt1 + 2);
    super.gxS();
    int j = paramInt1 + 5;
    switch (paramInt2)
    {
    case 3: 
    case 4: 
    default: 
      Q(paramArrayOfByte, j, this.NQh - j - 1);
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      AppMethodBeat.o(88076);
      return paramInt1;
      int i = localf.U(paramArrayOfByte, j, this.NQh - j);
      paramInt1 = i;
      if (i >= 0)
      {
        this.NQv.NQA = localf;
        i = localg.U(paramArrayOfByte, j, this.NQh - j);
        paramInt1 = i;
        if (i >= 0)
        {
          this.NQv.NQB = localg;
          paramInt1 = paramInt2;
          continue;
          super.Q(paramArrayOfByte, j, this.NQh - j - 1);
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