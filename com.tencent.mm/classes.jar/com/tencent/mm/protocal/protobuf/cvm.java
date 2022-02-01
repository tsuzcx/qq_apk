package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvm
  extends com.tencent.mm.bx.a
{
  public int EPM;
  public int HfH;
  public int HnI;
  public int HnK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HfH);
      paramVarArgs.aS(2, this.HnK);
      paramVarArgs.aS(3, this.HnI);
      paramVarArgs.aS(4, this.EPM);
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HfH);
      int i = f.a.a.b.b.a.bz(2, this.HnK);
      int j = f.a.a.b.b.a.bz(3, this.HnI);
      int k = f.a.a.b.b.a.bz(4, this.EPM);
      AppMethodBeat.o(152672);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cvm localcvm = (cvm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152672);
        return -1;
      case 1: 
        localcvm.HfH = locala.NPN.zc();
        AppMethodBeat.o(152672);
        return 0;
      case 2: 
        localcvm.HnK = locala.NPN.zc();
        AppMethodBeat.o(152672);
        return 0;
      case 3: 
        localcvm.HnI = locala.NPN.zc();
        AppMethodBeat.o(152672);
        return 0;
      }
      localcvm.EPM = locala.NPN.zc();
      AppMethodBeat.o(152672);
      return 0;
    }
    AppMethodBeat.o(152672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvm
 * JD-Core Version:    0.7.0.1
 */