package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cp
  extends com.tencent.mm.bw.a
{
  public int FNu;
  public int FNv;
  public int FNw;
  public int FNx;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127429);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FNu);
      paramVarArgs.aS(2, this.nJA);
      paramVarArgs.aS(3, this.FNv);
      paramVarArgs.aS(4, this.FNw);
      paramVarArgs.aS(5, this.FNx);
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FNu);
      int i = f.a.a.b.b.a.bz(2, this.nJA);
      int j = f.a.a.b.b.a.bz(3, this.FNv);
      int k = f.a.a.b.b.a.bz(4, this.FNw);
      int m = f.a.a.b.b.a.bz(5, this.FNx);
      AppMethodBeat.o(127429);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cp localcp = (cp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127429);
        return -1;
      case 1: 
        localcp.FNu = locala.OmT.zc();
        AppMethodBeat.o(127429);
        return 0;
      case 2: 
        localcp.nJA = locala.OmT.zc();
        AppMethodBeat.o(127429);
        return 0;
      case 3: 
        localcp.FNv = locala.OmT.zc();
        AppMethodBeat.o(127429);
        return 0;
      case 4: 
        localcp.FNw = locala.OmT.zc();
        AppMethodBeat.o(127429);
        return 0;
      }
      localcp.FNx = locala.OmT.zc();
      AppMethodBeat.o(127429);
      return 0;
    }
    AppMethodBeat.o(127429);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cp
 * JD-Core Version:    0.7.0.1
 */