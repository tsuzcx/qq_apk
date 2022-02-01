package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eql
  extends com.tencent.mm.bw.a
{
  public boolean NnQ;
  public String NnR;
  public String NnS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209826);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.NnQ);
      if (this.NnR != null) {
        paramVarArgs.e(2, this.NnR);
      }
      if (this.NnS != null) {
        paramVarArgs.e(3, this.NnS);
      }
      AppMethodBeat.o(209826);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.NnR != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.NnR);
      }
      i = paramInt;
      if (this.NnS != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.NnS);
      }
      AppMethodBeat.o(209826);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209826);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eql localeql = (eql)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209826);
        return -1;
      case 1: 
        localeql.NnQ = locala.UbS.yZ();
        AppMethodBeat.o(209826);
        return 0;
      case 2: 
        localeql.NnR = locala.UbS.readString();
        AppMethodBeat.o(209826);
        return 0;
      }
      localeql.NnS = locala.UbS.readString();
      AppMethodBeat.o(209826);
      return 0;
    }
    AppMethodBeat.o(209826);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eql
 * JD-Core Version:    0.7.0.1
 */