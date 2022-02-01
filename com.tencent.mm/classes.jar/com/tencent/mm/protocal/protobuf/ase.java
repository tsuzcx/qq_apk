package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ase
  extends com.tencent.mm.bw.a
{
  public long GIB;
  public int GIK;
  public int GIL;
  public String dyI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GIK);
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      paramVarArgs.aS(3, this.GIL);
      paramVarArgs.aZ(4, this.GIB);
      AppMethodBeat.o(189404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GIK) + 0;
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = f.a.a.b.b.a.bz(3, this.GIL);
      int j = f.a.a.b.b.a.p(4, this.GIB);
      AppMethodBeat.o(189404);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189404);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ase localase = (ase)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189404);
        return -1;
      case 1: 
        localase.GIK = locala.OmT.zc();
        AppMethodBeat.o(189404);
        return 0;
      case 2: 
        localase.dyI = locala.OmT.readString();
        AppMethodBeat.o(189404);
        return 0;
      case 3: 
        localase.GIL = locala.OmT.zc();
        AppMethodBeat.o(189404);
        return 0;
      }
      localase.GIB = locala.OmT.zd();
      AppMethodBeat.o(189404);
      return 0;
    }
    AppMethodBeat.o(189404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ase
 * JD-Core Version:    0.7.0.1
 */