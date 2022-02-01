package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class he
  extends com.tencent.mm.bw.a
{
  public int dxd;
  public String dxe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dxd);
      if (this.dxe != null) {
        paramVarArgs.d(2, this.dxe);
      }
      AppMethodBeat.o(123546);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.dxd) + 0;
      paramInt = i;
      if (this.dxe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxe);
      }
      AppMethodBeat.o(123546);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123546);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      he localhe = (he)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123546);
        return -1;
      case 1: 
        localhe.dxd = locala.OmT.zc();
        AppMethodBeat.o(123546);
        return 0;
      }
      localhe.dxe = locala.OmT.readString();
      AppMethodBeat.o(123546);
      return 0;
    }
    AppMethodBeat.o(123546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.he
 * JD-Core Version:    0.7.0.1
 */