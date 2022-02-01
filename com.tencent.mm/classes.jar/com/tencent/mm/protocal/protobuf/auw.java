package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auw
  extends com.tencent.mm.bx.a
{
  public int nEf;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221050);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      if (this.xbo != null) {
        paramVarArgs.d(2, this.xbo);
      }
      AppMethodBeat.o(221050);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nEf) + 0;
      paramInt = i;
      if (this.xbo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xbo);
      }
      AppMethodBeat.o(221050);
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
      AppMethodBeat.o(221050);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      auw localauw = (auw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(221050);
        return -1;
      case 1: 
        localauw.nEf = locala.NPN.zc();
        AppMethodBeat.o(221050);
        return 0;
      }
      localauw.xbo = locala.NPN.readString();
      AppMethodBeat.o(221050);
      return 0;
    }
    AppMethodBeat.o(221050);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auw
 * JD-Core Version:    0.7.0.1
 */