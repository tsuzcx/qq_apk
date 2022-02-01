package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbn
  extends com.tencent.mm.bx.a
{
  public int FUX;
  public int GBD;
  public String GBE;
  public String yma;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yma != null) {
        paramVarArgs.d(1, this.yma);
      }
      paramVarArgs.aS(2, this.GBD);
      if (this.GBE != null) {
        paramVarArgs.d(3, this.GBE);
      }
      paramVarArgs.aS(4, this.FUX);
      AppMethodBeat.o(116456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yma == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.yma) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GBD);
      paramInt = i;
      if (this.GBE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GBE);
      }
      i = f.a.a.b.b.a.bz(4, this.FUX);
      AppMethodBeat.o(116456);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(116456);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cbn localcbn = (cbn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116456);
          return -1;
        case 1: 
          localcbn.yma = locala.NPN.readString();
          AppMethodBeat.o(116456);
          return 0;
        case 2: 
          localcbn.GBD = locala.NPN.zc();
          AppMethodBeat.o(116456);
          return 0;
        case 3: 
          localcbn.GBE = locala.NPN.readString();
          AppMethodBeat.o(116456);
          return 0;
        }
        localcbn.FUX = locala.NPN.zc();
        AppMethodBeat.o(116456);
        return 0;
      }
      AppMethodBeat.o(116456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbn
 * JD-Core Version:    0.7.0.1
 */