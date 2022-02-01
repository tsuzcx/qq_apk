package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aao
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public int YFt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127453);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YFt);
      paramVarArgs.bS(2, this.Idd);
      AppMethodBeat.o(127453);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YFt);
      int i = i.a.a.b.b.a.cJ(2, this.Idd);
      AppMethodBeat.o(127453);
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
      AppMethodBeat.o(127453);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aao localaao = (aao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127453);
        return -1;
      case 1: 
        localaao.YFt = locala.ajGk.aar();
        AppMethodBeat.o(127453);
        return 0;
      }
      localaao.Idd = locala.ajGk.aar();
      AppMethodBeat.o(127453);
      return 0;
    }
    AppMethodBeat.o(127453);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aao
 * JD-Core Version:    0.7.0.1
 */