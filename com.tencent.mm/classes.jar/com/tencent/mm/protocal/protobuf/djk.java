package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djk
  extends com.tencent.mm.bw.a
{
  public int HRg;
  public int HRh;
  public int HRi;
  public int HRj;
  public int HRk;
  public int HRl;
  public int Timestamp;
  public int nJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32457);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJz);
      paramVarArgs.aS(2, this.Timestamp);
      paramVarArgs.aS(3, this.HRg);
      paramVarArgs.aS(4, this.HRh);
      paramVarArgs.aS(5, this.HRi);
      paramVarArgs.aS(6, this.HRj);
      paramVarArgs.aS(7, this.HRk);
      paramVarArgs.aS(8, this.HRl);
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.nJz);
      int i = f.a.a.b.b.a.bz(2, this.Timestamp);
      int j = f.a.a.b.b.a.bz(3, this.HRg);
      int k = f.a.a.b.b.a.bz(4, this.HRh);
      int m = f.a.a.b.b.a.bz(5, this.HRi);
      int n = f.a.a.b.b.a.bz(6, this.HRj);
      int i1 = f.a.a.b.b.a.bz(7, this.HRk);
      int i2 = f.a.a.b.b.a.bz(8, this.HRl);
      AppMethodBeat.o(32457);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32457);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      djk localdjk = (djk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32457);
        return -1;
      case 1: 
        localdjk.nJz = locala.OmT.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 2: 
        localdjk.Timestamp = locala.OmT.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 3: 
        localdjk.HRg = locala.OmT.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 4: 
        localdjk.HRh = locala.OmT.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 5: 
        localdjk.HRi = locala.OmT.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 6: 
        localdjk.HRj = locala.OmT.zc();
        AppMethodBeat.o(32457);
        return 0;
      case 7: 
        localdjk.HRk = locala.OmT.zc();
        AppMethodBeat.o(32457);
        return 0;
      }
      localdjk.HRl = locala.OmT.zc();
      AppMethodBeat.o(32457);
      return 0;
    }
    AppMethodBeat.o(32457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djk
 * JD-Core Version:    0.7.0.1
 */