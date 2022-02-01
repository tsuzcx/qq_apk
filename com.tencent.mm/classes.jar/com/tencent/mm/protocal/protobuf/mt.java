package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mt
  extends com.tencent.mm.bw.a
{
  public int FQg;
  public int FYV;
  public int FYW;
  public int FYX;
  public int FYY;
  public int FYZ;
  public int enabled;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103202);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.enabled);
      paramVarArgs.aS(2, this.FYV);
      paramVarArgs.aS(3, this.FYW);
      paramVarArgs.aS(4, this.FYX);
      paramVarArgs.aS(5, this.FYY);
      paramVarArgs.aS(6, this.FYZ);
      paramVarArgs.aS(7, this.FQg);
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.enabled);
      int i = f.a.a.b.b.a.bz(2, this.FYV);
      int j = f.a.a.b.b.a.bz(3, this.FYW);
      int k = f.a.a.b.b.a.bz(4, this.FYX);
      int m = f.a.a.b.b.a.bz(5, this.FYY);
      int n = f.a.a.b.b.a.bz(6, this.FYZ);
      int i1 = f.a.a.b.b.a.bz(7, this.FQg);
      AppMethodBeat.o(103202);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(103202);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mt localmt = (mt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103202);
        return -1;
      case 1: 
        localmt.enabled = locala.OmT.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 2: 
        localmt.FYV = locala.OmT.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 3: 
        localmt.FYW = locala.OmT.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 4: 
        localmt.FYX = locala.OmT.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 5: 
        localmt.FYY = locala.OmT.zc();
        AppMethodBeat.o(103202);
        return 0;
      case 6: 
        localmt.FYZ = locala.OmT.zc();
        AppMethodBeat.o(103202);
        return 0;
      }
      localmt.FQg = locala.OmT.zc();
      AppMethodBeat.o(103202);
      return 0;
    }
    AppMethodBeat.o(103202);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mt
 * JD-Core Version:    0.7.0.1
 */