package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duo
  extends com.tencent.mm.bx.a
{
  public String GKI;
  public int HHh;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKI != null) {
        paramVarArgs.d(1, this.GKI);
      }
      paramVarArgs.aS(2, this.state);
      paramVarArgs.aS(3, this.HHh);
      AppMethodBeat.o(82486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GKI == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.GKI) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.state);
      int j = f.a.a.b.b.a.bz(3, this.HHh);
      AppMethodBeat.o(82486);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82486);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        duo localduo = (duo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82486);
          return -1;
        case 1: 
          localduo.GKI = locala.NPN.readString();
          AppMethodBeat.o(82486);
          return 0;
        case 2: 
          localduo.state = locala.NPN.zc();
          AppMethodBeat.o(82486);
          return 0;
        }
        localduo.HHh = locala.NPN.zc();
        AppMethodBeat.o(82486);
        return 0;
      }
      AppMethodBeat.o(82486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duo
 * JD-Core Version:    0.7.0.1
 */