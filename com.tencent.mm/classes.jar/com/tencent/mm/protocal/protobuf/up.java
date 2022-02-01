package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class up
  extends com.tencent.mm.cd.a
{
  public String Ooe;
  public String Oof;
  public int Paq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113965);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ooe != null) {
        paramVarArgs.f(1, this.Ooe);
      }
      if (this.Oof != null) {
        paramVarArgs.f(2, this.Oof);
      }
      paramVarArgs.aY(3, this.Paq);
      AppMethodBeat.o(113965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ooe == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.Ooe) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Oof != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Oof);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.Paq);
      AppMethodBeat.o(113965);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113965);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        up localup = (up)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113965);
          return -1;
        case 1: 
          localup.Ooe = locala.abFh.readString();
          AppMethodBeat.o(113965);
          return 0;
        case 2: 
          localup.Oof = locala.abFh.readString();
          AppMethodBeat.o(113965);
          return 0;
        }
        localup.Paq = locala.abFh.AK();
        AppMethodBeat.o(113965);
        return 0;
      }
      AppMethodBeat.o(113965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.up
 * JD-Core Version:    0.7.0.1
 */