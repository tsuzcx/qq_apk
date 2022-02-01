package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ya
  extends com.tencent.mm.bw.a
{
  public String Username;
  public int cZY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.cZY);
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      AppMethodBeat.o(117859);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.cZY) + 0;
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Username);
      }
      AppMethodBeat.o(117859);
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
      AppMethodBeat.o(117859);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ya localya = (ya)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117859);
        return -1;
      case 1: 
        localya.cZY = locala.LVo.xF();
        AppMethodBeat.o(117859);
        return 0;
      }
      localya.Username = locala.LVo.readString();
      AppMethodBeat.o(117859);
      return 0;
    }
    AppMethodBeat.o(117859);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ya
 * JD-Core Version:    0.7.0.1
 */