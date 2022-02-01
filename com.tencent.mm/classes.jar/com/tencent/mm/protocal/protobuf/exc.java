package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exc
  extends com.tencent.mm.cd.a
{
  public String fAo;
  public String fHp;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181514);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fHp != null) {
        paramVarArgs.f(1, this.fHp);
      }
      if (this.fAo != null) {
        paramVarArgs.f(2, this.fAo);
      }
      paramVarArgs.aY(3, this.scene);
      AppMethodBeat.o(181514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fHp == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.fHp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fAo != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fAo);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.scene);
      AppMethodBeat.o(181514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(181514);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exc localexc = (exc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181514);
          return -1;
        case 1: 
          localexc.fHp = locala.abFh.readString();
          AppMethodBeat.o(181514);
          return 0;
        case 2: 
          localexc.fAo = locala.abFh.readString();
          AppMethodBeat.o(181514);
          return 0;
        }
        localexc.scene = locala.abFh.AK();
        AppMethodBeat.o(181514);
        return 0;
      }
      AppMethodBeat.o(181514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exc
 * JD-Core Version:    0.7.0.1
 */