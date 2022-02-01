package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bx
  extends com.tencent.mm.cd.a
{
  public String data;
  public int tpK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260612);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.tpK);
      if (this.data != null) {
        paramVarArgs.f(2, this.data);
      }
      AppMethodBeat.o(260612);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.tpK) + 0;
      paramInt = i;
      if (this.data != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.data);
      }
      AppMethodBeat.o(260612);
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
      AppMethodBeat.o(260612);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bx localbx = (bx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260612);
        return -1;
      case 1: 
        localbx.tpK = locala.abFh.AK();
        AppMethodBeat.o(260612);
        return 0;
      }
      localbx.data = locala.abFh.readString();
      AppMethodBeat.o(260612);
      return 0;
    }
    AppMethodBeat.o(260612);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bx
 * JD-Core Version:    0.7.0.1
 */