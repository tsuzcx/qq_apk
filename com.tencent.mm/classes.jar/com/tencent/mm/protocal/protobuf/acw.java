package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class acw
  extends com.tencent.mm.cd.a
{
  public long SoL;
  public int label;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(255117);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.f(1, this.path);
      }
      paramVarArgs.aY(2, this.label);
      paramVarArgs.bm(3, this.SoL);
      AppMethodBeat.o(255117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = g.a.a.b.b.a.g(1, this.path) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.label);
      int j = g.a.a.b.b.a.p(3, this.SoL);
      AppMethodBeat.o(255117);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(255117);
          throw paramVarArgs;
        }
        AppMethodBeat.o(255117);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        acw localacw = (acw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(255117);
          return -1;
        case 1: 
          localacw.path = locala.abFh.readString();
          AppMethodBeat.o(255117);
          return 0;
        case 2: 
          localacw.label = locala.abFh.AK();
          AppMethodBeat.o(255117);
          return 0;
        }
        localacw.SoL = locala.abFh.AN();
        AppMethodBeat.o(255117);
        return 0;
      }
      AppMethodBeat.o(255117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acw
 * JD-Core Version:    0.7.0.1
 */