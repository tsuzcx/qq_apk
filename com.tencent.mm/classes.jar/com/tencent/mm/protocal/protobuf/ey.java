package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ey
  extends com.tencent.mm.cd.a
{
  public String RJK;
  public String RJL;
  public String RJM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125710);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJK != null) {
        paramVarArgs.f(1, this.RJK);
      }
      if (this.RJL != null) {
        paramVarArgs.f(2, this.RJL);
      }
      if (this.RJM != null) {
        paramVarArgs.f(3, this.RJM);
      }
      AppMethodBeat.o(125710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RJK == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.RJK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RJL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RJL);
      }
      i = paramInt;
      if (this.RJM != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RJM);
      }
      AppMethodBeat.o(125710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125710);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ey localey = (ey)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125710);
          return -1;
        case 1: 
          localey.RJK = locala.abFh.readString();
          AppMethodBeat.o(125710);
          return 0;
        case 2: 
          localey.RJL = locala.abFh.readString();
          AppMethodBeat.o(125710);
          return 0;
        }
        localey.RJM = locala.abFh.readString();
        AppMethodBeat.o(125710);
        return 0;
      }
      AppMethodBeat.o(125710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ey
 * JD-Core Version:    0.7.0.1
 */