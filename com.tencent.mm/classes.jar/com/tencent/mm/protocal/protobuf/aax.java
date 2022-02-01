package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aax
  extends com.tencent.mm.cd.a
{
  public String Snk;
  public String wmL;
  public String wmz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197020);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wmL != null) {
        paramVarArgs.f(1, this.wmL);
      }
      if (this.wmz != null) {
        paramVarArgs.f(2, this.wmz);
      }
      if (this.Snk != null) {
        paramVarArgs.f(3, this.Snk);
      }
      AppMethodBeat.o(197020);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmL == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.wmL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wmz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wmz);
      }
      i = paramInt;
      if (this.Snk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Snk);
      }
      AppMethodBeat.o(197020);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(197020);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aax localaax = (aax)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(197020);
          return -1;
        case 1: 
          localaax.wmL = locala.abFh.readString();
          AppMethodBeat.o(197020);
          return 0;
        case 2: 
          localaax.wmz = locala.abFh.readString();
          AppMethodBeat.o(197020);
          return 0;
        }
        localaax.Snk = locala.abFh.readString();
        AppMethodBeat.o(197020);
        return 0;
      }
      AppMethodBeat.o(197020);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aax
 * JD-Core Version:    0.7.0.1
 */