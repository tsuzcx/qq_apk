package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ed
  extends com.tencent.mm.bx.a
{
  public int Cys;
  public String Cyt;
  public String hnC;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hnC != null) {
        paramVarArgs.d(1, this.hnC);
      }
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.Cys);
      if (this.Cyt != null) {
        paramVarArgs.d(4, this.Cyt);
      }
      AppMethodBeat.o(123539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hnC == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.hnC) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH) + f.a.a.b.b.a.bA(3, this.Cys);
      paramInt = i;
      if (this.Cyt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Cyt);
      }
      AppMethodBeat.o(123539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123539);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ed localed = (ed)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123539);
          return -1;
        case 1: 
          localed.hnC = locala.KhF.readString();
          AppMethodBeat.o(123539);
          return 0;
        case 2: 
          localed.mBH = locala.KhF.xS();
          AppMethodBeat.o(123539);
          return 0;
        case 3: 
          localed.Cys = locala.KhF.xS();
          AppMethodBeat.o(123539);
          return 0;
        }
        localed.Cyt = locala.KhF.readString();
        AppMethodBeat.o(123539);
        return 0;
      }
      AppMethodBeat.o(123539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ed
 * JD-Core Version:    0.7.0.1
 */