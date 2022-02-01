package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqm
  extends com.tencent.mm.cd.a
{
  public int UsV;
  public String UsW;
  public String UsX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117933);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UsV);
      if (this.UsW != null) {
        paramVarArgs.f(2, this.UsW);
      }
      if (this.UsX != null) {
        paramVarArgs.f(3, this.UsX);
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.UsV) + 0;
      paramInt = i;
      if (this.UsW != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UsW);
      }
      i = paramInt;
      if (this.UsX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UsX);
      }
      AppMethodBeat.o(117933);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eqm localeqm = (eqm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117933);
        return -1;
      case 1: 
        localeqm.UsV = locala.abFh.AK();
        AppMethodBeat.o(117933);
        return 0;
      case 2: 
        localeqm.UsW = locala.abFh.readString();
        AppMethodBeat.o(117933);
        return 0;
      }
      localeqm.UsX = locala.abFh.readString();
      AppMethodBeat.o(117933);
      return 0;
    }
    AppMethodBeat.o(117933);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqm
 * JD-Core Version:    0.7.0.1
 */