package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dqr
  extends com.tencent.mm.bx.a
{
  public String mAQ;
  public int mBH;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32517);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.mBV == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(32517);
        throw paramVarArgs;
      }
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      paramVarArgs.aR(3, this.mBH);
      AppMethodBeat.o(32517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label427;
      }
    }
    label427:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mBV);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.mBH);
      AppMethodBeat.o(32517);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.mAQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        if (this.mBV == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(32517);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32517);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqr localdqr = (dqr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32517);
          return -1;
        case 1: 
          localdqr.mAQ = locala.KhF.readString();
          AppMethodBeat.o(32517);
          return 0;
        case 2: 
          localdqr.mBV = locala.KhF.readString();
          AppMethodBeat.o(32517);
          return 0;
        }
        localdqr.mBH = locala.KhF.xS();
        AppMethodBeat.o(32517);
        return 0;
      }
      AppMethodBeat.o(32517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqr
 * JD-Core Version:    0.7.0.1
 */