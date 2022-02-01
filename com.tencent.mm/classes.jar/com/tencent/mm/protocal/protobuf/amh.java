package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amh
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public int SwJ;
  public long rJY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155404);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.rJY);
      if (this.CMP != null) {
        paramVarArgs.f(2, this.CMP);
      }
      paramVarArgs.aY(3, this.SwJ);
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.rJY) + 0;
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMP);
      }
      i = g.a.a.b.b.a.bM(3, this.SwJ);
      AppMethodBeat.o(155404);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      amh localamh = (amh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155404);
        return -1;
      case 1: 
        localamh.rJY = locala.abFh.AN();
        AppMethodBeat.o(155404);
        return 0;
      case 2: 
        localamh.CMP = locala.abFh.readString();
        AppMethodBeat.o(155404);
        return 0;
      }
      localamh.SwJ = locala.abFh.AK();
      AppMethodBeat.o(155404);
      return 0;
    }
    AppMethodBeat.o(155404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amh
 * JD-Core Version:    0.7.0.1
 */