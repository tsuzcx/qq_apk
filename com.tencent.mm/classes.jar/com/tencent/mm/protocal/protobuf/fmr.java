package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmr
  extends com.tencent.mm.cd.a
{
  public String CNM;
  public String Nickname;
  public String ULp;
  public int ULq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124574);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ULp != null) {
        paramVarArgs.f(1, this.ULp);
      }
      if (this.CNM != null) {
        paramVarArgs.f(2, this.CNM);
      }
      if (this.Nickname != null) {
        paramVarArgs.f(3, this.Nickname);
      }
      paramVarArgs.aY(4, this.ULq);
      AppMethodBeat.o(124574);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ULp == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.ULp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNM);
      }
      i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Nickname);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.ULq);
      AppMethodBeat.o(124574);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124574);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fmr localfmr = (fmr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124574);
          return -1;
        case 1: 
          localfmr.ULp = locala.abFh.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 2: 
          localfmr.CNM = locala.abFh.readString();
          AppMethodBeat.o(124574);
          return 0;
        case 3: 
          localfmr.Nickname = locala.abFh.readString();
          AppMethodBeat.o(124574);
          return 0;
        }
        localfmr.ULq = locala.abFh.AK();
        AppMethodBeat.o(124574);
        return 0;
      }
      AppMethodBeat.o(124574);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmr
 * JD-Core Version:    0.7.0.1
 */