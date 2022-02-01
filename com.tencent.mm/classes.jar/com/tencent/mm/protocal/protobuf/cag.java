package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cag
  extends com.tencent.mm.bw.a
{
  public String FNj;
  public int HnL;
  public String nIJ;
  public int yxf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101826);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNj != null) {
        paramVarArgs.d(1, this.FNj);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      paramVarArgs.aS(3, this.HnL);
      paramVarArgs.aS(4, this.yxf);
      AppMethodBeat.o(101826);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNj == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.FNj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nIJ);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HnL);
      int j = f.a.a.b.b.a.bz(4, this.yxf);
      AppMethodBeat.o(101826);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(101826);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cag localcag = (cag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101826);
          return -1;
        case 1: 
          localcag.FNj = locala.OmT.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 2: 
          localcag.nIJ = locala.OmT.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 3: 
          localcag.HnL = locala.OmT.zc();
          AppMethodBeat.o(101826);
          return 0;
        }
        localcag.yxf = locala.OmT.zc();
        AppMethodBeat.o(101826);
        return 0;
      }
      AppMethodBeat.o(101826);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cag
 * JD-Core Version:    0.7.0.1
 */