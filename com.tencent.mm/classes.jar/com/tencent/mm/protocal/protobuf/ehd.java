package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehd
  extends com.tencent.mm.bx.a
{
  public int HRQ;
  public int HRR;
  public int HRS;
  public int HRT;
  public int HRU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50122);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HRQ);
      paramVarArgs.aS(2, this.HRR);
      paramVarArgs.aS(3, this.HRS);
      paramVarArgs.aS(4, this.HRT);
      paramVarArgs.aS(5, this.HRU);
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HRQ);
      int i = f.a.a.b.b.a.bz(2, this.HRR);
      int j = f.a.a.b.b.a.bz(3, this.HRS);
      int k = f.a.a.b.b.a.bz(4, this.HRT);
      int m = f.a.a.b.b.a.bz(5, this.HRU);
      AppMethodBeat.o(50122);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ehd localehd = (ehd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50122);
        return -1;
      case 1: 
        localehd.HRQ = locala.NPN.zc();
        AppMethodBeat.o(50122);
        return 0;
      case 2: 
        localehd.HRR = locala.NPN.zc();
        AppMethodBeat.o(50122);
        return 0;
      case 3: 
        localehd.HRS = locala.NPN.zc();
        AppMethodBeat.o(50122);
        return 0;
      case 4: 
        localehd.HRT = locala.NPN.zc();
        AppMethodBeat.o(50122);
        return 0;
      }
      localehd.HRU = locala.NPN.zc();
      AppMethodBeat.o(50122);
      return 0;
    }
    AppMethodBeat.o(50122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehd
 * JD-Core Version:    0.7.0.1
 */