package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dwz
  extends com.tencent.mm.bw.a
{
  public long Gdw;
  public b ncy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Gdw);
      if (this.ncy != null) {
        paramVarArgs.c(2, this.ncy);
      }
      AppMethodBeat.o(32538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Gdw) + 0;
      paramInt = i;
      if (this.ncy != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.ncy);
      }
      AppMethodBeat.o(32538);
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
      AppMethodBeat.o(32538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwz localdwz = (dwz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32538);
        return -1;
      case 1: 
        localdwz.Gdw = locala.LVo.xG();
        AppMethodBeat.o(32538);
        return 0;
      }
      localdwz.ncy = locala.LVo.gfk();
      AppMethodBeat.o(32538);
      return 0;
    }
    AppMethodBeat.o(32538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwz
 * JD-Core Version:    0.7.0.1
 */