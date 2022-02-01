package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccc
  extends com.tencent.mm.bx.a
{
  public String GVR;
  public String GVS;
  public int GVT;
  public int GVU;
  public int GVV;
  public int GVW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133179);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GVR != null) {
        paramVarArgs.d(1, this.GVR);
      }
      if (this.GVS != null) {
        paramVarArgs.d(2, this.GVS);
      }
      paramVarArgs.aS(3, this.GVT);
      paramVarArgs.aS(4, this.GVU);
      paramVarArgs.aS(5, this.GVV);
      paramVarArgs.aS(7, this.GVW);
      AppMethodBeat.o(133179);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GVR == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.b.b.a.e(1, this.GVR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GVS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GVS);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GVT);
      int j = f.a.a.b.b.a.bz(4, this.GVU);
      int k = f.a.a.b.b.a.bz(5, this.GVV);
      int m = f.a.a.b.b.a.bz(7, this.GVW);
      AppMethodBeat.o(133179);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(133179);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccc localccc = (ccc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 6: 
        default: 
          AppMethodBeat.o(133179);
          return -1;
        case 1: 
          localccc.GVR = locala.NPN.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 2: 
          localccc.GVS = locala.NPN.readString();
          AppMethodBeat.o(133179);
          return 0;
        case 3: 
          localccc.GVT = locala.NPN.zc();
          AppMethodBeat.o(133179);
          return 0;
        case 4: 
          localccc.GVU = locala.NPN.zc();
          AppMethodBeat.o(133179);
          return 0;
        case 5: 
          localccc.GVV = locala.NPN.zc();
          AppMethodBeat.o(133179);
          return 0;
        }
        localccc.GVW = locala.NPN.zc();
        AppMethodBeat.o(133179);
        return 0;
      }
      AppMethodBeat.o(133179);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccc
 * JD-Core Version:    0.7.0.1
 */