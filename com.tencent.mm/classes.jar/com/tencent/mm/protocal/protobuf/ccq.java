package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccq
  extends com.tencent.mm.bx.a
{
  public int GNa;
  public int GWN;
  public int GWO;
  public int GWP;
  public int GWQ;
  public int GWR;
  public int GWS;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143985);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GNa);
      paramVarArgs.aS(2, this.GWN);
      paramVarArgs.aS(3, this.GWO);
      paramVarArgs.aS(4, this.GWP);
      paramVarArgs.aS(5, this.GWQ);
      paramVarArgs.aS(6, this.GWR);
      paramVarArgs.aS(7, this.GWS);
      paramVarArgs.aS(8, this.nEf);
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GNa);
      int i = f.a.a.b.b.a.bz(2, this.GWN);
      int j = f.a.a.b.b.a.bz(3, this.GWO);
      int k = f.a.a.b.b.a.bz(4, this.GWP);
      int m = f.a.a.b.b.a.bz(5, this.GWQ);
      int n = f.a.a.b.b.a.bz(6, this.GWR);
      int i1 = f.a.a.b.b.a.bz(7, this.GWS);
      int i2 = f.a.a.b.b.a.bz(8, this.nEf);
      AppMethodBeat.o(143985);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ccq localccq = (ccq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143985);
        return -1;
      case 1: 
        localccq.GNa = locala.NPN.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 2: 
        localccq.GWN = locala.NPN.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 3: 
        localccq.GWO = locala.NPN.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 4: 
        localccq.GWP = locala.NPN.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 5: 
        localccq.GWQ = locala.NPN.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 6: 
        localccq.GWR = locala.NPN.zc();
        AppMethodBeat.o(143985);
        return 0;
      case 7: 
        localccq.GWS = locala.NPN.zc();
        AppMethodBeat.o(143985);
        return 0;
      }
      localccq.nEf = locala.NPN.zc();
      AppMethodBeat.o(143985);
      return 0;
    }
    AppMethodBeat.o(143985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccq
 * JD-Core Version:    0.7.0.1
 */