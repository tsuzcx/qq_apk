package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efj
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public String HQE;
  public String HQF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123682);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FFN);
      if (this.HQE != null) {
        paramVarArgs.d(2, this.HQE);
      }
      if (this.HQF != null) {
        paramVarArgs.d(3, this.HQF);
      }
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FFN) + 0;
      paramInt = i;
      if (this.HQE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HQE);
      }
      i = paramInt;
      if (this.HQF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HQF);
      }
      AppMethodBeat.o(123682);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      efj localefj = (efj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123682);
        return -1;
      case 1: 
        localefj.FFN = locala.NPN.zc();
        AppMethodBeat.o(123682);
        return 0;
      case 2: 
        localefj.HQE = locala.NPN.readString();
        AppMethodBeat.o(123682);
        return 0;
      }
      localefj.HQF = locala.NPN.readString();
      AppMethodBeat.o(123682);
      return 0;
    }
    AppMethodBeat.o(123682);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efj
 * JD-Core Version:    0.7.0.1
 */