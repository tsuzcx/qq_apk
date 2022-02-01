package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apc
  extends com.tencent.mm.bx.a
{
  public int GnC;
  public int GnD;
  public String dDf;
  public String slv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184203);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dDf != null) {
        paramVarArgs.d(1, this.dDf);
      }
      paramVarArgs.aS(2, this.GnC);
      paramVarArgs.aS(3, this.GnD);
      if (this.slv != null) {
        paramVarArgs.d(4, this.slv);
      }
      AppMethodBeat.o(184203);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dDf == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.dDf) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GnC) + f.a.a.b.b.a.bz(3, this.GnD);
      paramInt = i;
      if (this.slv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.slv);
      }
      AppMethodBeat.o(184203);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(184203);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        apc localapc = (apc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184203);
          return -1;
        case 1: 
          localapc.dDf = locala.NPN.readString();
          AppMethodBeat.o(184203);
          return 0;
        case 2: 
          localapc.GnC = locala.NPN.zc();
          AppMethodBeat.o(184203);
          return 0;
        case 3: 
          localapc.GnD = locala.NPN.zc();
          AppMethodBeat.o(184203);
          return 0;
        }
        localapc.slv = locala.NPN.readString();
        AppMethodBeat.o(184203);
        return 0;
      }
      AppMethodBeat.o(184203);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apc
 * JD-Core Version:    0.7.0.1
 */