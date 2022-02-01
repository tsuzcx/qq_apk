package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chj
  extends com.tencent.mm.bw.a
{
  public String drt;
  public int dru;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dru);
      if (this.drt != null) {
        paramVarArgs.d(2, this.drt);
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.dru) + 0;
      paramInt = i;
      if (this.drt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.drt);
      }
      AppMethodBeat.o(19408);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      chj localchj = (chj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19408);
        return -1;
      case 1: 
        localchj.dru = locala.LVo.xF();
        AppMethodBeat.o(19408);
        return 0;
      }
      localchj.drt = locala.LVo.readString();
      AppMethodBeat.o(19408);
      return 0;
    }
    AppMethodBeat.o(19408);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chj
 * JD-Core Version:    0.7.0.1
 */