package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqz
  extends com.tencent.mm.bw.a
{
  public String GNI;
  public String Gzj;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127291);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.GNI != null) {
        paramVarArgs.d(2, this.GNI);
      }
      if (this.Gzj != null) {
        paramVarArgs.d(3, this.Gzj);
      }
      AppMethodBeat.o(127291);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.nIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GNI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GNI);
      }
      i = paramInt;
      if (this.Gzj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gzj);
      }
      AppMethodBeat.o(127291);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127291);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqz localcqz = (cqz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127291);
          return -1;
        case 1: 
          localcqz.nIJ = locala.OmT.readString();
          AppMethodBeat.o(127291);
          return 0;
        case 2: 
          localcqz.GNI = locala.OmT.readString();
          AppMethodBeat.o(127291);
          return 0;
        }
        localcqz.Gzj = locala.OmT.readString();
        AppMethodBeat.o(127291);
        return 0;
      }
      AppMethodBeat.o(127291);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqz
 * JD-Core Version:    0.7.0.1
 */