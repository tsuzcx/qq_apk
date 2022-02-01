package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxu
  extends com.tencent.mm.bx.a
{
  public long EpQ;
  public int EpR;
  public int EpS;
  public String ThumbUrl;
  public String mAQ;
  public String sbz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      paramVarArgs.aG(2, this.EpQ);
      paramVarArgs.aR(3, this.EpR);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(4, this.ThumbUrl);
      }
      paramVarArgs.aR(5, this.EpS);
      if (this.sbz != null) {
        paramVarArgs.d(6, this.sbz);
      }
      AppMethodBeat.o(118434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.EpQ) + f.a.a.b.b.a.bA(3, this.EpR);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ThumbUrl);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.EpS);
      paramInt = i;
      if (this.sbz != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sbz);
      }
      AppMethodBeat.o(118434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(118434);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cxu localcxu = (cxu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118434);
          return -1;
        case 1: 
          localcxu.mAQ = locala.KhF.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 2: 
          localcxu.EpQ = locala.KhF.xT();
          AppMethodBeat.o(118434);
          return 0;
        case 3: 
          localcxu.EpR = locala.KhF.xS();
          AppMethodBeat.o(118434);
          return 0;
        case 4: 
          localcxu.ThumbUrl = locala.KhF.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 5: 
          localcxu.EpS = locala.KhF.xS();
          AppMethodBeat.o(118434);
          return 0;
        }
        localcxu.sbz = locala.KhF.readString();
        AppMethodBeat.o(118434);
        return 0;
      }
      AppMethodBeat.o(118434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxu
 * JD-Core Version:    0.7.0.1
 */