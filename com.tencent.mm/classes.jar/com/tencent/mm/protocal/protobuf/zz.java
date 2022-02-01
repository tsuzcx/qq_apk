package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zz
  extends com.tencent.mm.bx.a
{
  public String Username;
  public int dlq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dlq);
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      AppMethodBeat.o(117859);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.dlq) + 0;
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
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117859);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      zz localzz = (zz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117859);
        return -1;
      case 1: 
        localzz.dlq = locala.NPN.zc();
        AppMethodBeat.o(117859);
        return 0;
      }
      localzz.Username = locala.NPN.readString();
      AppMethodBeat.o(117859);
      return 0;
    }
    AppMethodBeat.o(117859);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zz
 * JD-Core Version:    0.7.0.1
 */