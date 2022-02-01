package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ba
  extends com.tencent.mm.cd.a
{
  public String RFI;
  public String RFJ;
  public String RFK;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125688);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG != null) {
        paramVarArgs.f(1, this.lVG);
      }
      if (this.RFI != null) {
        paramVarArgs.f(2, this.RFI);
      }
      if (this.RFJ != null) {
        paramVarArgs.f(3, this.RFJ);
      }
      if (this.RFK != null) {
        paramVarArgs.f(4, this.RFK);
      }
      AppMethodBeat.o(125688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVG == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.lVG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RFI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RFI);
      }
      i = paramInt;
      if (this.RFJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RFJ);
      }
      paramInt = i;
      if (this.RFK != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RFK);
      }
      AppMethodBeat.o(125688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125688);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ba localba = (ba)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125688);
          return -1;
        case 1: 
          localba.lVG = locala.abFh.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 2: 
          localba.RFI = locala.abFh.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 3: 
          localba.RFJ = locala.abFh.readString();
          AppMethodBeat.o(125688);
          return 0;
        }
        localba.RFK = locala.abFh.readString();
        AppMethodBeat.o(125688);
        return 0;
      }
      AppMethodBeat.o(125688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ba
 * JD-Core Version:    0.7.0.1
 */