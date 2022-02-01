package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epv
  extends com.tencent.mm.cd.a
{
  public int Usq;
  public String Usr;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153305);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(2, this.rWu);
      paramVarArgs.aY(3, this.Usq);
      if (this.Usr != null) {
        paramVarArgs.f(4, this.Usr);
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(2, this.rWu) + 0 + g.a.a.b.b.a.bM(3, this.Usq);
      paramInt = i;
      if (this.Usr != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Usr);
      }
      AppMethodBeat.o(153305);
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
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      epv localepv = (epv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153305);
        return -1;
      case 2: 
        localepv.rWu = locala.abFh.AK();
        AppMethodBeat.o(153305);
        return 0;
      case 3: 
        localepv.Usq = locala.abFh.AK();
        AppMethodBeat.o(153305);
        return 0;
      }
      localepv.Usr = locala.abFh.readString();
      AppMethodBeat.o(153305);
      return 0;
    }
    AppMethodBeat.o(153305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epv
 * JD-Core Version:    0.7.0.1
 */