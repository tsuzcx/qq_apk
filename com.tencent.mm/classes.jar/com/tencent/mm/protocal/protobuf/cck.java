package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cck
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String Tku;
  public int Tkv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212093);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CPw);
      if (this.Tku != null) {
        paramVarArgs.f(2, this.Tku);
      }
      paramVarArgs.aY(3, this.Tkv);
      AppMethodBeat.o(212093);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CPw) + 0;
      paramInt = i;
      if (this.Tku != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tku);
      }
      i = g.a.a.b.b.a.bM(3, this.Tkv);
      AppMethodBeat.o(212093);
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
      AppMethodBeat.o(212093);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cck localcck = (cck)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(212093);
        return -1;
      case 1: 
        localcck.CPw = locala.abFh.AK();
        AppMethodBeat.o(212093);
        return 0;
      case 2: 
        localcck.Tku = locala.abFh.readString();
        AppMethodBeat.o(212093);
        return 0;
      }
      localcck.Tkv = locala.abFh.AK();
      AppMethodBeat.o(212093);
      return 0;
    }
    AppMethodBeat.o(212093);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cck
 * JD-Core Version:    0.7.0.1
 */