package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cat
  extends com.tencent.mm.bw.a
{
  public String Hot;
  public int nJA;
  public String uum;
  public String yxn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uum != null) {
        paramVarArgs.d(1, this.uum);
      }
      if (this.Hot != null) {
        paramVarArgs.d(2, this.Hot);
      }
      if (this.yxn != null) {
        paramVarArgs.d(3, this.yxn);
      }
      paramVarArgs.aS(4, this.nJA);
      AppMethodBeat.o(127501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uum == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.uum) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hot != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hot);
      }
      i = paramInt;
      if (this.yxn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.yxn);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.nJA);
      AppMethodBeat.o(127501);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127501);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cat localcat = (cat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127501);
          return -1;
        case 1: 
          localcat.uum = locala.OmT.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 2: 
          localcat.Hot = locala.OmT.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 3: 
          localcat.yxn = locala.OmT.readString();
          AppMethodBeat.o(127501);
          return 0;
        }
        localcat.nJA = locala.OmT.zc();
        AppMethodBeat.o(127501);
        return 0;
      }
      AppMethodBeat.o(127501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cat
 * JD-Core Version:    0.7.0.1
 */