package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dij
  extends com.tencent.mm.bx.a
{
  public String DUR;
  public int aaNj;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260181);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.DUR != null) {
        paramVarArgs.g(1, this.DUR);
      }
      paramVarArgs.bS(2, this.height);
      paramVarArgs.bS(3, this.width);
      paramVarArgs.bS(4, this.aaNj);
      AppMethodBeat.o(260181);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUR == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = i.a.a.b.b.a.h(1, this.DUR) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.height);
      int j = i.a.a.b.b.a.cJ(3, this.width);
      int k = i.a.a.b.b.a.cJ(4, this.aaNj);
      AppMethodBeat.o(260181);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260181);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dij localdij = (dij)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260181);
          return -1;
        case 1: 
          localdij.DUR = locala.ajGk.readString();
          AppMethodBeat.o(260181);
          return 0;
        case 2: 
          localdij.height = locala.ajGk.aar();
          AppMethodBeat.o(260181);
          return 0;
        case 3: 
          localdij.width = locala.ajGk.aar();
          AppMethodBeat.o(260181);
          return 0;
        }
        localdij.aaNj = locala.ajGk.aar();
        AppMethodBeat.o(260181);
        return 0;
      }
      AppMethodBeat.o(260181);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dij
 * JD-Core Version:    0.7.0.1
 */