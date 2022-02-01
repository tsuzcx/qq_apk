package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxo
  extends com.tencent.mm.bx.a
{
  public String dxD;
  public String kzK;
  public String kzL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72513);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dxD != null) {
        paramVarArgs.d(1, this.dxD);
      }
      if (this.kzK != null) {
        paramVarArgs.d(2, this.kzK);
      }
      if (this.kzL != null) {
        paramVarArgs.d(4, this.kzL);
      }
      AppMethodBeat.o(72513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dxD == null) {
        break label338;
      }
    }
    label338:
    for (int i = f.a.a.b.b.a.e(1, this.dxD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kzK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.kzK);
      }
      i = paramInt;
      if (this.kzL != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.kzL);
      }
      AppMethodBeat.o(72513);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72513);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bxo localbxo = (bxo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          AppMethodBeat.o(72513);
          return -1;
        case 1: 
          localbxo.dxD = locala.NPN.readString();
          AppMethodBeat.o(72513);
          return 0;
        case 2: 
          localbxo.kzK = locala.NPN.readString();
          AppMethodBeat.o(72513);
          return 0;
        }
        localbxo.kzL = locala.NPN.readString();
        AppMethodBeat.o(72513);
        return 0;
      }
      AppMethodBeat.o(72513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxo
 * JD-Core Version:    0.7.0.1
 */