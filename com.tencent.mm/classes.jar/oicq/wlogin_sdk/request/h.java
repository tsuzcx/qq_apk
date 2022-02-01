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
    this.abFM = 2064;
    this.abFN = 3;
    this.abFP = parami;
  }
  
  public final int ad(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88076);
    f localf = new f();
    g localg = new g();
    paramInt2 = super.al(paramArrayOfByte, paramInt1 + 2);
    super.iUG();
    int j = paramInt1 + 5;
    switch (paramInt2)
    {
    case 3: 
    case 4: 
    default: 
      ac(paramArrayOfByte, j, this.abFB - j - 1);
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      AppMethodBeat.o(88076);
      return paramInt1;
      int i = localf.ag(paramArrayOfByte, j, this.abFB - j);
      paramInt1 = i;
      if (i >= 0)
      {
        this.abFP.abFU = localf;
        i = localg.ag(paramArrayOfByte, j, this.abFB - j);
        paramInt1 = i;
        if (i >= 0)
        {
          this.abFP.abFV = localg;
          paramInt1 = paramInt2;
          continue;
          super.ac(paramArrayOfByte, j, this.abFB - j - 1);
          paramInt1 = paramInt2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.request.h
 * JD-Core Version:    0.7.0.1
 */