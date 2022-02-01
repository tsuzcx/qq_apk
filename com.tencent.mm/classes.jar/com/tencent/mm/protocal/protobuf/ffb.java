package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffb
  extends com.tencent.mm.bx.a
{
  public int abEQ;
  public int abER;
  public int akln;
  public int aklo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125813);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abEQ);
      paramVarArgs.bS(2, this.abER);
      paramVarArgs.bS(4, this.akln);
      paramVarArgs.bS(5, this.aklo);
      AppMethodBeat.o(125813);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abEQ);
      int i = i.a.a.b.b.a.cJ(2, this.abER);
      int j = i.a.a.b.b.a.cJ(4, this.akln);
      int k = i.a.a.b.b.a.cJ(5, this.aklo);
      AppMethodBeat.o(125813);
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
      AppMethodBeat.o(125813);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ffb localffb = (ffb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 3: 
      default: 
        AppMethodBeat.o(125813);
        return -1;
      case 1: 
        localffb.abEQ = locala.ajGk.aar();
        AppMethodBeat.o(125813);
        return 0;
      case 2: 
        localffb.abER = locala.ajGk.aar();
        AppMethodBeat.o(125813);
        return 0;
      case 4: 
        localffb.akln = locala.ajGk.aar();
        AppMethodBeat.o(125813);
        return 0;
      }
      localffb.aklo = locala.ajGk.aar();
      AppMethodBeat.o(125813);
      return 0;
    }
    AppMethodBeat.o(125813);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffb
 * JD-Core Version:    0.7.0.1
 */