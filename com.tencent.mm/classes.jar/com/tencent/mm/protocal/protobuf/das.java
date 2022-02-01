package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class das
  extends com.tencent.mm.cd.a
{
  public String TIj;
  public String TIk;
  public String TIl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63277);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TIj != null) {
        paramVarArgs.f(1, this.TIj);
      }
      if (this.TIk != null) {
        paramVarArgs.f(2, this.TIk);
      }
      if (this.TIl != null) {
        paramVarArgs.f(3, this.TIl);
      }
      AppMethodBeat.o(63277);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TIj == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.TIj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TIk != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TIk);
      }
      i = paramInt;
      if (this.TIl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TIl);
      }
      AppMethodBeat.o(63277);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(63277);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        das localdas = (das)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(63277);
          return -1;
        case 1: 
          localdas.TIj = locala.abFh.readString();
          AppMethodBeat.o(63277);
          return 0;
        case 2: 
          localdas.TIk = locala.abFh.readString();
          AppMethodBeat.o(63277);
          return 0;
        }
        localdas.TIl = locala.abFh.readString();
        AppMethodBeat.o(63277);
        return 0;
      }
      AppMethodBeat.o(63277);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.das
 * JD-Core Version:    0.7.0.1
 */