package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class pu
  extends com.tencent.mm.bx.a
{
  public b FKV;
  public b FKW;
  public int port;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133158);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      paramVarArgs.aS(2, this.port);
      if (this.FKV != null) {
        paramVarArgs.c(3, this.FKV);
      }
      if (this.FKW != null) {
        paramVarArgs.c(4, this.FKW);
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0 + f.a.a.b.b.a.bz(2, this.port);
      paramInt = i;
      if (this.FKV != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.FKV);
      }
      i = paramInt;
      if (this.FKW != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.FKW);
      }
      AppMethodBeat.o(133158);
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
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pu localpu = (pu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133158);
        return -1;
      case 1: 
        localpu.type = locala.NPN.zc();
        AppMethodBeat.o(133158);
        return 0;
      case 2: 
        localpu.port = locala.NPN.zc();
        AppMethodBeat.o(133158);
        return 0;
      case 3: 
        localpu.FKV = locala.NPN.gxI();
        AppMethodBeat.o(133158);
        return 0;
      }
      localpu.FKW = locala.NPN.gxI();
      AppMethodBeat.o(133158);
      return 0;
    }
    AppMethodBeat.o(133158);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pu
 * JD-Core Version:    0.7.0.1
 */