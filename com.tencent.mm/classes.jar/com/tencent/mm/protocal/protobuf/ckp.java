package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckp
  extends com.tencent.mm.bx.a
{
  public int CLK;
  public String DyR;
  public int DyU;
  public String dlB;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175247);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.DyR != null) {
        paramVarArgs.d(3, this.DyR);
      }
      paramVarArgs.aR(4, this.DyU);
      paramVarArgs.aR(5, this.CLK);
      AppMethodBeat.o(175247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label426;
      }
    }
    label426:
    for (int i = f.a.a.b.b.a.e(1, this.dlB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.DyR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DyR);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.DyU);
      int j = f.a.a.b.b.a.bA(5, this.CLK);
      AppMethodBeat.o(175247);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(175247);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ckp localckp = (ckp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(175247);
          return -1;
        case 1: 
          localckp.dlB = locala.KhF.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 2: 
          localckp.username = locala.KhF.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 3: 
          localckp.DyR = locala.KhF.readString();
          AppMethodBeat.o(175247);
          return 0;
        case 4: 
          localckp.DyU = locala.KhF.xS();
          AppMethodBeat.o(175247);
          return 0;
        }
        localckp.CLK = locala.KhF.xS();
        AppMethodBeat.o(175247);
        return 0;
      }
      AppMethodBeat.o(175247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckp
 * JD-Core Version:    0.7.0.1
 */