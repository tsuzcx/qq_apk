package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqt
  extends com.tencent.mm.bx.a
{
  public String DOT;
  public int mBH;
  public String scP;
  public String vJI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scP != null) {
        paramVarArgs.d(1, this.scP);
      }
      if (this.DOT != null) {
        paramVarArgs.d(2, this.DOT);
      }
      if (this.vJI != null) {
        paramVarArgs.d(3, this.vJI);
      }
      paramVarArgs.aR(4, this.mBH);
      AppMethodBeat.o(127501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scP == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.scP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DOT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DOT);
      }
      i = paramInt;
      if (this.vJI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.vJI);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.mBH);
      AppMethodBeat.o(127501);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127501);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqt localbqt = (bqt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127501);
          return -1;
        case 1: 
          localbqt.scP = locala.KhF.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 2: 
          localbqt.DOT = locala.KhF.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 3: 
          localbqt.vJI = locala.KhF.readString();
          AppMethodBeat.o(127501);
          return 0;
        }
        localbqt.mBH = locala.KhF.xS();
        AppMethodBeat.o(127501);
        return 0;
      }
      AppMethodBeat.o(127501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqt
 * JD-Core Version:    0.7.0.1
 */