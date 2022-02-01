package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgc
  extends com.tencent.mm.bx.a
{
  public String DfI;
  public String Dqd;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127291);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(2, this.Dqd);
      }
      if (this.DfI != null) {
        paramVarArgs.d(3, this.DfI);
      }
      AppMethodBeat.o(127291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.mAQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dqd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dqd);
      }
      i = paramInt;
      if (this.DfI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DfI);
      }
      AppMethodBeat.o(127291);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(127291);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cgc localcgc = (cgc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127291);
          return -1;
        case 1: 
          localcgc.mAQ = locala.KhF.readString();
          AppMethodBeat.o(127291);
          return 0;
        case 2: 
          localcgc.Dqd = locala.KhF.readString();
          AppMethodBeat.o(127291);
          return 0;
        }
        localcgc.DfI = locala.KhF.readString();
        AppMethodBeat.o(127291);
        return 0;
      }
      AppMethodBeat.o(127291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgc
 * JD-Core Version:    0.7.0.1
 */