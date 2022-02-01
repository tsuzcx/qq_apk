package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsx
  extends com.tencent.mm.bx.a
{
  public int saz;
  public String sdP;
  public String sdQ;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdQ != null) {
        paramVarArgs.d(1, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(2, this.sdP);
      }
      paramVarArgs.aR(3, this.uKX);
      paramVarArgs.aR(4, this.saz);
      paramVarArgs.aG(5, this.uKZ);
      AppMethodBeat.o(43113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdQ == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.sdQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sdP);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.uKX);
      int j = f.a.a.b.b.a.bA(4, this.saz);
      int k = f.a.a.b.b.a.q(5, this.uKZ);
      AppMethodBeat.o(43113);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(43113);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsx localbsx = (bsx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43113);
          return -1;
        case 1: 
          localbsx.sdQ = locala.KhF.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 2: 
          localbsx.sdP = locala.KhF.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 3: 
          localbsx.uKX = locala.KhF.xS();
          AppMethodBeat.o(43113);
          return 0;
        case 4: 
          localbsx.saz = locala.KhF.xS();
          AppMethodBeat.o(43113);
          return 0;
        }
        localbsx.uKZ = locala.KhF.xT();
        AppMethodBeat.o(43113);
        return 0;
      }
      AppMethodBeat.o(43113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsx
 * JD-Core Version:    0.7.0.1
 */