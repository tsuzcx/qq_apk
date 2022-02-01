package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwk
  extends com.tencent.mm.bx.a
{
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      AppMethodBeat.o(125838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.mAQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.mBV);
      }
      AppMethodBeat.o(125838);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cwk localcwk = (cwk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125838);
          return -1;
        case 1: 
          localcwk.mAQ = locala.KhF.readString();
          AppMethodBeat.o(125838);
          return 0;
        }
        localcwk.mBV = locala.KhF.readString();
        AppMethodBeat.o(125838);
        return 0;
      }
      AppMethodBeat.o(125838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwk
 * JD-Core Version:    0.7.0.1
 */