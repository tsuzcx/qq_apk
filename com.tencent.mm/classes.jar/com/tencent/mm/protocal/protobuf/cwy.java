package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwy
  extends com.tencent.mm.bx.a
{
  public String GBF;
  public String HfF;
  public String HfG;
  public int nDi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91678);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GBF != null) {
        paramVarArgs.d(1, this.GBF);
      }
      if (this.HfG != null) {
        paramVarArgs.d(2, this.HfG);
      }
      paramVarArgs.aS(3, this.nDi);
      if (this.HfF != null) {
        paramVarArgs.d(4, this.HfF);
      }
      AppMethodBeat.o(91678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GBF == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.GBF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HfG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HfG);
      }
      i += f.a.a.b.b.a.bz(3, this.nDi);
      paramInt = i;
      if (this.HfF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HfF);
      }
      AppMethodBeat.o(91678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91678);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwy localcwy = (cwy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91678);
          return -1;
        case 1: 
          localcwy.GBF = locala.NPN.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 2: 
          localcwy.HfG = locala.NPN.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 3: 
          localcwy.nDi = locala.NPN.zc();
          AppMethodBeat.o(91678);
          return 0;
        }
        localcwy.HfF = locala.NPN.readString();
        AppMethodBeat.o(91678);
        return 0;
      }
      AppMethodBeat.o(91678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwy
 * JD-Core Version:    0.7.0.1
 */