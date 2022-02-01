package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class du
  extends com.tencent.mm.cd.a
{
  public String RJk;
  public String jump_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200461);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJk != null) {
        paramVarArgs.f(1, this.RJk);
      }
      if (this.jump_url != null) {
        paramVarArgs.f(2, this.jump_url);
      }
      AppMethodBeat.o(200461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RJk == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.RJk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jump_url != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.jump_url);
      }
      AppMethodBeat.o(200461);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200461);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        du localdu = (du)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200461);
          return -1;
        case 1: 
          localdu.RJk = locala.abFh.readString();
          AppMethodBeat.o(200461);
          return 0;
        }
        localdu.jump_url = locala.abFh.readString();
        AppMethodBeat.o(200461);
        return 0;
      }
      AppMethodBeat.o(200461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.du
 * JD-Core Version:    0.7.0.1
 */