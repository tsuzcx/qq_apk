package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ask
  extends com.tencent.mm.bx.a
{
  public int duh;
  public String objectNonceId;
  public long rIZ;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209373);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rIZ);
      if (this.objectNonceId != null) {
        paramVarArgs.d(2, this.objectNonceId);
      }
      paramVarArgs.aS(3, this.duh);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(4, this.sessionBuffer);
      }
      AppMethodBeat.o(209373);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.rIZ) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.objectNonceId);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.duh);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sessionBuffer);
      }
      AppMethodBeat.o(209373);
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
      AppMethodBeat.o(209373);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ask localask = (ask)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209373);
        return -1;
      case 1: 
        localask.rIZ = locala.NPN.zd();
        AppMethodBeat.o(209373);
        return 0;
      case 2: 
        localask.objectNonceId = locala.NPN.readString();
        AppMethodBeat.o(209373);
        return 0;
      case 3: 
        localask.duh = locala.NPN.zc();
        AppMethodBeat.o(209373);
        return 0;
      }
      localask.sessionBuffer = locala.NPN.readString();
      AppMethodBeat.o(209373);
      return 0;
    }
    AppMethodBeat.o(209373);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ask
 * JD-Core Version:    0.7.0.1
 */