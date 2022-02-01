package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwo
  extends com.tencent.mm.bx.a
{
  public int HIU;
  public String HIY;
  public int ihf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HIU);
      paramVarArgs.aS(2, this.ihf);
      if (this.HIY != null) {
        paramVarArgs.d(3, this.HIY);
      }
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HIU) + 0 + f.a.a.b.b.a.bz(2, this.ihf);
      paramInt = i;
      if (this.HIY != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HIY);
      }
      AppMethodBeat.o(32501);
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
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwo localdwo = (dwo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32501);
        return -1;
      case 1: 
        localdwo.HIU = locala.NPN.zc();
        AppMethodBeat.o(32501);
        return 0;
      case 2: 
        localdwo.ihf = locala.NPN.zc();
        AppMethodBeat.o(32501);
        return 0;
      }
      localdwo.HIY = locala.NPN.readString();
      AppMethodBeat.o(32501);
      return 0;
    }
    AppMethodBeat.o(32501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwo
 * JD-Core Version:    0.7.0.1
 */