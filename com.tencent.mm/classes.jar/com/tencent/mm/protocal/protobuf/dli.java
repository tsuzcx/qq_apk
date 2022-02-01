package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dli
  extends com.tencent.mm.bx.a
{
  public int HzQ;
  public String HzR;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153305);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(2, this.nEf);
      paramVarArgs.aS(3, this.HzQ);
      if (this.HzR != null) {
        paramVarArgs.d(4, this.HzR);
      }
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(2, this.nEf) + 0 + f.a.a.b.b.a.bz(3, this.HzQ);
      paramInt = i;
      if (this.HzR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HzR);
      }
      AppMethodBeat.o(153305);
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
      AppMethodBeat.o(153305);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dli localdli = (dli)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153305);
        return -1;
      case 2: 
        localdli.nEf = locala.NPN.zc();
        AppMethodBeat.o(153305);
        return 0;
      case 3: 
        localdli.HzQ = locala.NPN.zc();
        AppMethodBeat.o(153305);
        return 0;
      }
      localdli.HzR = locala.NPN.readString();
      AppMethodBeat.o(153305);
      return 0;
    }
    AppMethodBeat.o(153305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dli
 * JD-Core Version:    0.7.0.1
 */