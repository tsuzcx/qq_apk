package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asv
  extends com.tencent.mm.bx.a
{
  public int GqO;
  public int percent;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184213);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      paramVarArgs.aS(2, this.percent);
      paramVarArgs.aS(3, this.GqO);
      AppMethodBeat.o(184213);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.type);
      int i = f.a.a.b.b.a.bz(2, this.percent);
      int j = f.a.a.b.b.a.bz(3, this.GqO);
      AppMethodBeat.o(184213);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184213);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      asv localasv = (asv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184213);
        return -1;
      case 1: 
        localasv.type = locala.NPN.zc();
        AppMethodBeat.o(184213);
        return 0;
      case 2: 
        localasv.percent = locala.NPN.zc();
        AppMethodBeat.o(184213);
        return 0;
      }
      localasv.GqO = locala.NPN.zc();
      AppMethodBeat.o(184213);
      return 0;
    }
    AppMethodBeat.o(184213);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asv
 * JD-Core Version:    0.7.0.1
 */