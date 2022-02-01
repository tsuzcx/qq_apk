package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class to
  extends com.tencent.mm.bx.a
{
  public int FRm;
  public int FRn;
  public String FRo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FRm);
      paramVarArgs.aS(2, this.FRn);
      if (this.FRo != null) {
        paramVarArgs.d(3, this.FRo);
      }
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FRm) + 0 + f.a.a.b.b.a.bz(2, this.FRn);
      paramInt = i;
      if (this.FRo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FRo);
      }
      AppMethodBeat.o(113972);
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
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      to localto = (to)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113972);
        return -1;
      case 1: 
        localto.FRm = locala.NPN.zc();
        AppMethodBeat.o(113972);
        return 0;
      case 2: 
        localto.FRn = locala.NPN.zc();
        AppMethodBeat.o(113972);
        return 0;
      }
      localto.FRo = locala.NPN.readString();
      AppMethodBeat.o(113972);
      return 0;
    }
    AppMethodBeat.o(113972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.to
 * JD-Core Version:    0.7.0.1
 */