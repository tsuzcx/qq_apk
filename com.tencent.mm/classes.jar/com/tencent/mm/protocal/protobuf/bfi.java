package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfi
  extends com.tencent.mm.cd.a
{
  public int SQa;
  public String mbB;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198564);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      paramVarArgs.aY(2, this.SQa);
      if (this.mbB != null) {
        paramVarArgs.f(3, this.mbB);
      }
      AppMethodBeat.o(198564);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.type) + 0 + g.a.a.b.b.a.bM(2, this.SQa);
      paramInt = i;
      if (this.mbB != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.mbB);
      }
      AppMethodBeat.o(198564);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(198564);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bfi localbfi = (bfi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198564);
        return -1;
      case 1: 
        localbfi.type = locala.abFh.AK();
        AppMethodBeat.o(198564);
        return 0;
      case 2: 
        localbfi.SQa = locala.abFh.AK();
        AppMethodBeat.o(198564);
        return 0;
      }
      localbfi.mbB = locala.abFh.readString();
      AppMethodBeat.o(198564);
      return 0;
    }
    AppMethodBeat.o(198564);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfi
 * JD-Core Version:    0.7.0.1
 */