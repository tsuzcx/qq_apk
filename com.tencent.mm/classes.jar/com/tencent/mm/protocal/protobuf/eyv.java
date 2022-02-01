package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eyv
  extends com.tencent.mm.cd.a
{
  public String JdV;
  public int JdW;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74674);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.f(1, this.scope);
      }
      if (this.JdV != null) {
        paramVarArgs.f(2, this.JdV);
      }
      paramVarArgs.aY(3, this.state);
      paramVarArgs.aY(4, this.JdW);
      AppMethodBeat.o(74674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.JdV != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.JdV);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.state);
      int j = g.a.a.b.b.a.bM(4, this.JdW);
      AppMethodBeat.o(74674);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(74674);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        eyv localeyv = (eyv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(74674);
          return -1;
        case 1: 
          localeyv.scope = locala.abFh.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 2: 
          localeyv.JdV = locala.abFh.readString();
          AppMethodBeat.o(74674);
          return 0;
        case 3: 
          localeyv.state = locala.abFh.AK();
          AppMethodBeat.o(74674);
          return 0;
        }
        localeyv.JdW = locala.abFh.AK();
        AppMethodBeat.o(74674);
        return 0;
      }
      AppMethodBeat.o(74674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyv
 * JD-Core Version:    0.7.0.1
 */