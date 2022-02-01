package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axl
  extends com.tencent.mm.cd.a
{
  public String SJO;
  public int SJP;
  public String SKa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230010);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKa != null) {
        paramVarArgs.f(1, this.SKa);
      }
      if (this.SJO != null) {
        paramVarArgs.f(101, this.SJO);
      }
      paramVarArgs.aY(102, this.SJP);
      AppMethodBeat.o(230010);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKa == null) {
        break label330;
      }
    }
    label330:
    for (paramInt = g.a.a.b.b.a.g(1, this.SKa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SJO != null) {
        i = paramInt + g.a.a.b.b.a.g(101, this.SJO);
      }
      paramInt = g.a.a.b.b.a.bM(102, this.SJP);
      AppMethodBeat.o(230010);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230010);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        axl localaxl = (axl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(230010);
          return -1;
        case 1: 
          localaxl.SKa = locala.abFh.readString();
          AppMethodBeat.o(230010);
          return 0;
        case 101: 
          localaxl.SJO = locala.abFh.readString();
          AppMethodBeat.o(230010);
          return 0;
        }
        localaxl.SJP = locala.abFh.AK();
        AppMethodBeat.o(230010);
        return 0;
      }
      AppMethodBeat.o(230010);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axl
 * JD-Core Version:    0.7.0.1
 */