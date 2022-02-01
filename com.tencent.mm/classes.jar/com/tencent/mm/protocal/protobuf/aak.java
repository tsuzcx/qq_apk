package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aak
  extends com.tencent.mm.bw.a
{
  public int FZk;
  public int GrG;
  public int nJb;
  public int urJ;
  public int xri;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xri);
      paramVarArgs.aS(2, this.urJ);
      paramVarArgs.aS(3, this.GrG);
      paramVarArgs.aS(4, this.nJb);
      paramVarArgs.aS(5, this.FZk);
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.xri);
      int i = f.a.a.b.b.a.bz(2, this.urJ);
      int j = f.a.a.b.b.a.bz(3, this.GrG);
      int k = f.a.a.b.b.a.bz(4, this.nJb);
      int m = f.a.a.b.b.a.bz(5, this.FZk);
      AppMethodBeat.o(124478);
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
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aak localaak = (aak)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124478);
        return -1;
      case 1: 
        localaak.xri = locala.OmT.zc();
        AppMethodBeat.o(124478);
        return 0;
      case 2: 
        localaak.urJ = locala.OmT.zc();
        AppMethodBeat.o(124478);
        return 0;
      case 3: 
        localaak.GrG = locala.OmT.zc();
        AppMethodBeat.o(124478);
        return 0;
      case 4: 
        localaak.nJb = locala.OmT.zc();
        AppMethodBeat.o(124478);
        return 0;
      }
      localaak.FZk = locala.OmT.zc();
      AppMethodBeat.o(124478);
      return 0;
    }
    AppMethodBeat.o(124478);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aak
 * JD-Core Version:    0.7.0.1
 */