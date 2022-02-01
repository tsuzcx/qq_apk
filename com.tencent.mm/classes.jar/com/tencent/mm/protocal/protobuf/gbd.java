package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gbd
  extends com.tencent.mm.bx.a
{
  public int abZs;
  public int abZt;
  public int bej;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115903);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      paramVarArgs.bS(2, this.abZs);
      paramVarArgs.bS(3, this.bej);
      paramVarArgs.bS(4, this.abZt);
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.vhJ);
      int i = i.a.a.b.b.a.cJ(2, this.abZs);
      int j = i.a.a.b.b.a.cJ(3, this.bej);
      int k = i.a.a.b.b.a.cJ(4, this.abZt);
      AppMethodBeat.o(115903);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gbd localgbd = (gbd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115903);
        return -1;
      case 1: 
        localgbd.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(115903);
        return 0;
      case 2: 
        localgbd.abZs = locala.ajGk.aar();
        AppMethodBeat.o(115903);
        return 0;
      case 3: 
        localgbd.bej = locala.ajGk.aar();
        AppMethodBeat.o(115903);
        return 0;
      }
      localgbd.abZt = locala.ajGk.aar();
      AppMethodBeat.o(115903);
      return 0;
    }
    AppMethodBeat.o(115903);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbd
 * JD-Core Version:    0.7.0.1
 */