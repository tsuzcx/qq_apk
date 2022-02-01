package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdn
  extends com.tencent.mm.bx.a
{
  public String CVu;
  public int DZN;
  public int DaA;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.CVu != null) {
        paramVarArgs.d(2, this.CVu);
      }
      paramVarArgs.aR(3, this.DZN);
      paramVarArgs.aR(4, this.DaA);
      AppMethodBeat.o(32393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CVu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.CVu);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.DZN);
      int j = f.a.a.b.b.a.bA(4, this.DaA);
      AppMethodBeat.o(32393);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32393);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cdn localcdn = (cdn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32393);
          return -1;
        case 1: 
          localcdn.mAQ = locala.KhF.readString();
          AppMethodBeat.o(32393);
          return 0;
        case 2: 
          localcdn.CVu = locala.KhF.readString();
          AppMethodBeat.o(32393);
          return 0;
        case 3: 
          localcdn.DZN = locala.KhF.xS();
          AppMethodBeat.o(32393);
          return 0;
        }
        localcdn.DaA = locala.KhF.xS();
        AppMethodBeat.o(32393);
        return 0;
      }
      AppMethodBeat.o(32393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdn
 * JD-Core Version:    0.7.0.1
 */