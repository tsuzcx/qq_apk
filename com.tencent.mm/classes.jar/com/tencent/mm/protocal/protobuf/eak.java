package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eak
  extends com.tencent.mm.cd.a
{
  public String TVK;
  public String TVL;
  public String TiR;
  public int rVx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91678);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TiR != null) {
        paramVarArgs.f(1, this.TiR);
      }
      if (this.TVL != null) {
        paramVarArgs.f(2, this.TVL);
      }
      paramVarArgs.aY(3, this.rVx);
      if (this.TVK != null) {
        paramVarArgs.f(4, this.TVK);
      }
      AppMethodBeat.o(91678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TiR == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.g(1, this.TiR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TVL != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TVL);
      }
      i += g.a.a.b.b.a.bM(3, this.rVx);
      paramInt = i;
      if (this.TVK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TVK);
      }
      AppMethodBeat.o(91678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91678);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eak localeak = (eak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91678);
          return -1;
        case 1: 
          localeak.TiR = locala.abFh.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 2: 
          localeak.TVL = locala.abFh.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 3: 
          localeak.rVx = locala.abFh.AK();
          AppMethodBeat.o(91678);
          return 0;
        }
        localeak.TVK = locala.abFh.readString();
        AppMethodBeat.o(91678);
        return 0;
      }
      AppMethodBeat.o(91678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eak
 * JD-Core Version:    0.7.0.1
 */