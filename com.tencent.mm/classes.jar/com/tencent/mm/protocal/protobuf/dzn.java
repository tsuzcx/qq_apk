package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzn
  extends com.tencent.mm.cd.a
{
  public String CQz;
  public String RGJ;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258879);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG != null) {
        paramVarArgs.f(1, this.lVG);
      }
      if (this.CQz != null) {
        paramVarArgs.f(2, this.CQz);
      }
      if (this.RGJ != null) {
        paramVarArgs.f(3, this.RGJ);
      }
      AppMethodBeat.o(258879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVG == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.lVG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CQz);
      }
      i = paramInt;
      if (this.RGJ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RGJ);
      }
      AppMethodBeat.o(258879);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(258879);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dzn localdzn = (dzn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258879);
          return -1;
        case 1: 
          localdzn.lVG = locala.abFh.readString();
          AppMethodBeat.o(258879);
          return 0;
        case 2: 
          localdzn.CQz = locala.abFh.readString();
          AppMethodBeat.o(258879);
          return 0;
        }
        localdzn.RGJ = locala.abFh.readString();
        AppMethodBeat.o(258879);
        return 0;
      }
      AppMethodBeat.o(258879);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzn
 * JD-Core Version:    0.7.0.1
 */