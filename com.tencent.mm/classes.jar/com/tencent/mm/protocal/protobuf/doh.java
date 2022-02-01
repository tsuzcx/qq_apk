package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class doh
  extends com.tencent.mm.bx.a
{
  public b FLP;
  public int FLQ;
  public int HCS;
  public int HCT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(7, this.HCS);
      if (this.FLP != null) {
        paramVarArgs.c(8, this.FLP);
      }
      paramVarArgs.aS(9, this.FLQ);
      paramVarArgs.aS(10, this.HCT);
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(7, this.HCS) + 0;
      paramInt = i;
      if (this.FLP != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.FLP);
      }
      i = f.a.a.b.b.a.bz(9, this.FLQ);
      int j = f.a.a.b.b.a.bz(10, this.HCT);
      AppMethodBeat.o(91718);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      doh localdoh = (doh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91718);
        return -1;
      case 7: 
        localdoh.HCS = locala.NPN.zc();
        AppMethodBeat.o(91718);
        return 0;
      case 8: 
        localdoh.FLP = locala.NPN.gxI();
        AppMethodBeat.o(91718);
        return 0;
      case 9: 
        localdoh.FLQ = locala.NPN.zc();
        AppMethodBeat.o(91718);
        return 0;
      }
      localdoh.HCT = locala.NPN.zc();
      AppMethodBeat.o(91718);
      return 0;
    }
    AppMethodBeat.o(91718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doh
 * JD-Core Version:    0.7.0.1
 */