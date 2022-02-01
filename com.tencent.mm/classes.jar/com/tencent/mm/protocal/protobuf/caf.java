package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caf
  extends com.tencent.mm.bw.a
{
  public String FNj;
  public String GnM;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101825);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNj != null) {
        paramVarArgs.d(1, this.FNj);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.GnM != null) {
        paramVarArgs.d(3, this.GnM);
      }
      AppMethodBeat.o(101825);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNj == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.FNj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.GnM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GnM);
      }
      AppMethodBeat.o(101825);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(101825);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        caf localcaf = (caf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101825);
          return -1;
        case 1: 
          localcaf.FNj = locala.OmT.readString();
          AppMethodBeat.o(101825);
          return 0;
        case 2: 
          localcaf.nIJ = locala.OmT.readString();
          AppMethodBeat.o(101825);
          return 0;
        }
        localcaf.GnM = locala.OmT.readString();
        AppMethodBeat.o(101825);
        return 0;
      }
      AppMethodBeat.o(101825);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caf
 * JD-Core Version:    0.7.0.1
 */