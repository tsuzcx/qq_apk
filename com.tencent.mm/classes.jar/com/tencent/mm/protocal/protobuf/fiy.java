package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fiy
  extends com.tencent.mm.bx.a
{
  public int QCD;
  public long QCF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118460);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.QCF);
      paramVarArgs.bS(2, this.QCD);
      AppMethodBeat.o(118460);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.QCF);
      int i = i.a.a.b.b.a.cJ(2, this.QCD);
      AppMethodBeat.o(118460);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(118460);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fiy localfiy = (fiy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118460);
        return -1;
      case 1: 
        localfiy.QCF = locala.ajGk.aaw();
        AppMethodBeat.o(118460);
        return 0;
      }
      localfiy.QCD = locala.ajGk.aar();
      AppMethodBeat.o(118460);
      return 0;
    }
    AppMethodBeat.o(118460);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fiy
 * JD-Core Version:    0.7.0.1
 */