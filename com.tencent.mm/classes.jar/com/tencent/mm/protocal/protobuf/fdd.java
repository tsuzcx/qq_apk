package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdd
  extends com.tencent.mm.bw.a
{
  public double NyO;
  public long NyP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153324);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.NyO);
      paramVarArgs.bb(2, this.NyP);
      AppMethodBeat.o(153324);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.r(2, this.NyP);
      AppMethodBeat.o(153324);
      return paramInt + 8 + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153324);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdd localfdd = (fdd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153324);
        return -1;
      case 1: 
        localfdd.NyO = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(153324);
        return 0;
      }
      localfdd.NyP = locala.UbS.zl();
      AppMethodBeat.o(153324);
      return 0;
    }
    AppMethodBeat.o(153324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdd
 * JD-Core Version:    0.7.0.1
 */