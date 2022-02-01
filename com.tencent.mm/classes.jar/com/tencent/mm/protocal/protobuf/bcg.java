package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bcg
  extends com.tencent.mm.cd.a
{
  public String SNI;
  public String SNJ;
  public String SNK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199061);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SNI != null) {
        paramVarArgs.f(1, this.SNI);
      }
      if (this.SNJ != null) {
        paramVarArgs.f(2, this.SNJ);
      }
      if (this.SNK != null) {
        paramVarArgs.f(3, this.SNK);
      }
      AppMethodBeat.o(199061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SNI == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.SNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SNJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SNJ);
      }
      i = paramInt;
      if (this.SNK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SNK);
      }
      AppMethodBeat.o(199061);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199061);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bcg localbcg = (bcg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199061);
          return -1;
        case 1: 
          localbcg.SNI = locala.abFh.readString();
          AppMethodBeat.o(199061);
          return 0;
        case 2: 
          localbcg.SNJ = locala.abFh.readString();
          AppMethodBeat.o(199061);
          return 0;
        }
        localbcg.SNK = locala.abFh.readString();
        AppMethodBeat.o(199061);
        return 0;
      }
      AppMethodBeat.o(199061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcg
 * JD-Core Version:    0.7.0.1
 */