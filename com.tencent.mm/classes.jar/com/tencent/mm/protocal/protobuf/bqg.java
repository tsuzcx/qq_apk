package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqg
  extends com.tencent.mm.bx.a
{
  public String Cxb;
  public int DOl;
  public String mAQ;
  public int vJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101826);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxb != null) {
        paramVarArgs.d(1, this.Cxb);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      paramVarArgs.aR(3, this.DOl);
      paramVarArgs.aR(4, this.vJA);
      AppMethodBeat.o(101826);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cxb == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.Cxb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mAQ);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DOl);
      int j = f.a.a.b.b.a.bA(4, this.vJA);
      AppMethodBeat.o(101826);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(101826);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bqg localbqg = (bqg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101826);
          return -1;
        case 1: 
          localbqg.Cxb = locala.KhF.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 2: 
          localbqg.mAQ = locala.KhF.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 3: 
          localbqg.DOl = locala.KhF.xS();
          AppMethodBeat.o(101826);
          return 0;
        }
        localbqg.vJA = locala.KhF.xS();
        AppMethodBeat.o(101826);
        return 0;
      }
      AppMethodBeat.o(101826);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqg
 * JD-Core Version:    0.7.0.1
 */