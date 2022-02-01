package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoy
  extends com.tencent.mm.bx.a
{
  public int Cys;
  public int DqH;
  public String hnC;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hnC != null) {
        paramVarArgs.d(1, this.hnC);
      }
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.Cys);
      paramVarArgs.aR(4, this.DqH);
      AppMethodBeat.o(123572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hnC == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.hnC) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.mBH);
      int j = f.a.a.b.b.a.bA(3, this.Cys);
      int k = f.a.a.b.b.a.bA(4, this.DqH);
      AppMethodBeat.o(123572);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123572);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aoy localaoy = (aoy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123572);
          return -1;
        case 1: 
          localaoy.hnC = locala.KhF.readString();
          AppMethodBeat.o(123572);
          return 0;
        case 2: 
          localaoy.mBH = locala.KhF.xS();
          AppMethodBeat.o(123572);
          return 0;
        case 3: 
          localaoy.Cys = locala.KhF.xS();
          AppMethodBeat.o(123572);
          return 0;
        }
        localaoy.DqH = locala.KhF.xS();
        AppMethodBeat.o(123572);
        return 0;
      }
      AppMethodBeat.o(123572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoy
 * JD-Core Version:    0.7.0.1
 */