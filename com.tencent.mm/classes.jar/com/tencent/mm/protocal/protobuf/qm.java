package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qm
  extends com.tencent.mm.cd.a
{
  public String RYJ;
  public String RYK;
  public String Url;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152989);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RYJ != null) {
        paramVarArgs.f(1, this.RYJ);
      }
      if (this.RYK != null) {
        paramVarArgs.f(2, this.RYK);
      }
      if (this.Url != null) {
        paramVarArgs.f(3, this.Url);
      }
      paramVarArgs.aY(4, this.rWu);
      AppMethodBeat.o(152989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RYJ == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.RYJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RYK != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RYK);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Url);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.rWu);
      AppMethodBeat.o(152989);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152989);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        qm localqm = (qm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152989);
          return -1;
        case 1: 
          localqm.RYJ = locala.abFh.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 2: 
          localqm.RYK = locala.abFh.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 3: 
          localqm.Url = locala.abFh.readString();
          AppMethodBeat.o(152989);
          return 0;
        }
        localqm.rWu = locala.abFh.AK();
        AppMethodBeat.o(152989);
        return 0;
      }
      AppMethodBeat.o(152989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qm
 * JD-Core Version:    0.7.0.1
 */