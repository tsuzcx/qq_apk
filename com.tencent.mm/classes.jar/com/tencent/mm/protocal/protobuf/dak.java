package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dak
  extends com.tencent.mm.cd.a
{
  public long THD;
  public String THE;
  public long status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205565);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.THD);
      paramVarArgs.bm(2, this.status);
      if (this.THE != null) {
        paramVarArgs.f(3, this.THE);
      }
      AppMethodBeat.o(205565);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.THD) + 0 + g.a.a.b.b.a.p(2, this.status);
      paramInt = i;
      if (this.THE != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.THE);
      }
      AppMethodBeat.o(205565);
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
      AppMethodBeat.o(205565);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dak localdak = (dak)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(205565);
        return -1;
      case 1: 
        localdak.THD = locala.abFh.AN();
        AppMethodBeat.o(205565);
        return 0;
      case 2: 
        localdak.status = locala.abFh.AN();
        AppMethodBeat.o(205565);
        return 0;
      }
      localdak.THE = locala.abFh.readString();
      AppMethodBeat.o(205565);
      return 0;
    }
    AppMethodBeat.o(205565);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dak
 * JD-Core Version:    0.7.0.1
 */