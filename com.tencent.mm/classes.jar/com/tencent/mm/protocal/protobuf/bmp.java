package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmp
  extends com.tencent.mm.cd.a
{
  public String SXx;
  public int SvP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155407);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SvP);
      if (this.SXx != null) {
        paramVarArgs.f(2, this.SXx);
      }
      AppMethodBeat.o(155407);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SvP) + 0;
      paramInt = i;
      if (this.SXx != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SXx);
      }
      AppMethodBeat.o(155407);
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
      AppMethodBeat.o(155407);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bmp localbmp = (bmp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155407);
        return -1;
      case 1: 
        localbmp.SvP = locala.abFh.AK();
        AppMethodBeat.o(155407);
        return 0;
      }
      localbmp.SXx = locala.abFh.readString();
      AppMethodBeat.o(155407);
      return 0;
    }
    AppMethodBeat.o(155407);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmp
 * JD-Core Version:    0.7.0.1
 */