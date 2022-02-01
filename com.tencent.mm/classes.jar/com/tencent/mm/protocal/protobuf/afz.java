package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afz
  extends com.tencent.mm.bw.a
{
  public String data;
  public String qXW;
  public long qXX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196246);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qXW != null) {
        paramVarArgs.d(1, this.qXW);
      }
      paramVarArgs.aZ(2, this.qXX);
      if (this.data != null) {
        paramVarArgs.d(3, this.data);
      }
      AppMethodBeat.o(196246);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qXW == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.qXW) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.qXX);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.data);
      }
      AppMethodBeat.o(196246);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(196246);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        afz localafz = (afz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196246);
          return -1;
        case 1: 
          localafz.qXW = locala.OmT.readString();
          AppMethodBeat.o(196246);
          return 0;
        case 2: 
          localafz.qXX = locala.OmT.zd();
          AppMethodBeat.o(196246);
          return 0;
        }
        localafz.data = locala.OmT.readString();
        AppMethodBeat.o(196246);
        return 0;
      }
      AppMethodBeat.o(196246);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afz
 * JD-Core Version:    0.7.0.1
 */