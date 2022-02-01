package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crq
  extends com.tencent.mm.bx.a
{
  public int HjX;
  public int HjY;
  public String HjZ;
  public String dBS;
  public String dxD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207255);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dBS != null) {
        paramVarArgs.d(1, this.dBS);
      }
      paramVarArgs.aS(2, this.HjX);
      paramVarArgs.aS(3, this.HjY);
      if (this.HjZ != null) {
        paramVarArgs.d(4, this.HjZ);
      }
      if (this.dxD != null) {
        paramVarArgs.d(5, this.dxD);
      }
      AppMethodBeat.o(207255);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dBS == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.dBS) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HjX) + f.a.a.b.b.a.bz(3, this.HjY);
      paramInt = i;
      if (this.HjZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HjZ);
      }
      i = paramInt;
      if (this.dxD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dxD);
      }
      AppMethodBeat.o(207255);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(207255);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        crq localcrq = (crq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207255);
          return -1;
        case 1: 
          localcrq.dBS = locala.NPN.readString();
          AppMethodBeat.o(207255);
          return 0;
        case 2: 
          localcrq.HjX = locala.NPN.zc();
          AppMethodBeat.o(207255);
          return 0;
        case 3: 
          localcrq.HjY = locala.NPN.zc();
          AppMethodBeat.o(207255);
          return 0;
        case 4: 
          localcrq.HjZ = locala.NPN.readString();
          AppMethodBeat.o(207255);
          return 0;
        }
        localcrq.dxD = locala.NPN.readString();
        AppMethodBeat.o(207255);
        return 0;
      }
      AppMethodBeat.o(207255);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crq
 * JD-Core Version:    0.7.0.1
 */