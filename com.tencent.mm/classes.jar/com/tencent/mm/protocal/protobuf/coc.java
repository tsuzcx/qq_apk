package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class coc
  extends com.tencent.mm.cd.a
{
  public String RUC;
  public String error_msg;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(263691);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ret);
      if (this.error_msg != null) {
        paramVarArgs.f(2, this.error_msg);
      }
      if (this.RUC != null) {
        paramVarArgs.f(3, this.RUC);
      }
      AppMethodBeat.o(263691);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.ret) + 0;
      paramInt = i;
      if (this.error_msg != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.error_msg);
      }
      i = paramInt;
      if (this.RUC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RUC);
      }
      AppMethodBeat.o(263691);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(263691);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      coc localcoc = (coc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(263691);
        return -1;
      case 1: 
        localcoc.ret = locala.abFh.AK();
        AppMethodBeat.o(263691);
        return 0;
      case 2: 
        localcoc.error_msg = locala.abFh.readString();
        AppMethodBeat.o(263691);
        return 0;
      }
      localcoc.RUC = locala.abFh.readString();
      AppMethodBeat.o(263691);
      return 0;
    }
    AppMethodBeat.o(263691);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coc
 * JD-Core Version:    0.7.0.1
 */