package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class baj
  extends com.tencent.mm.cd.a
{
  public int SMp;
  public String SMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231454);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SMp);
      if (this.SMq != null) {
        paramVarArgs.f(2, this.SMq);
      }
      AppMethodBeat.o(231454);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SMp) + 0;
      paramInt = i;
      if (this.SMq != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SMq);
      }
      AppMethodBeat.o(231454);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(231454);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      baj localbaj = (baj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(231454);
        return -1;
      case 1: 
        localbaj.SMp = locala.abFh.AK();
        AppMethodBeat.o(231454);
        return 0;
      }
      localbaj.SMq = locala.abFh.readString();
      AppMethodBeat.o(231454);
      return 0;
    }
    AppMethodBeat.o(231454);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baj
 * JD-Core Version:    0.7.0.1
 */