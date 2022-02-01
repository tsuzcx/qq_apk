package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agx
  extends com.tencent.mm.bx.a
{
  public String FxH;
  public int score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153270);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.score);
      if (this.FxH != null) {
        paramVarArgs.d(2, this.FxH);
      }
      AppMethodBeat.o(153270);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.score) + 0;
      paramInt = i;
      if (this.FxH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FxH);
      }
      AppMethodBeat.o(153270);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(153270);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      agx localagx = (agx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153270);
        return -1;
      case 1: 
        localagx.score = locala.NPN.zc();
        AppMethodBeat.o(153270);
        return 0;
      }
      localagx.FxH = locala.NPN.readString();
      AppMethodBeat.o(153270);
      return 0;
    }
    AppMethodBeat.o(153270);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agx
 * JD-Core Version:    0.7.0.1
 */