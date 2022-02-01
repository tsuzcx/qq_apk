package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ara
  extends com.tencent.mm.bw.a
{
  public int GHN;
  public int GHO;
  public int GHP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GHN);
      paramVarArgs.aS(2, this.GHO);
      paramVarArgs.aS(3, this.GHP);
      AppMethodBeat.o(184204);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GHN);
      int i = f.a.a.b.b.a.bz(2, this.GHO);
      int j = f.a.a.b.b.a.bz(3, this.GHP);
      AppMethodBeat.o(184204);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(184204);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ara localara = (ara)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184204);
        return -1;
      case 1: 
        localara.GHN = locala.OmT.zc();
        AppMethodBeat.o(184204);
        return 0;
      case 2: 
        localara.GHO = locala.OmT.zc();
        AppMethodBeat.o(184204);
        return 0;
      }
      localara.GHP = locala.OmT.zc();
      AppMethodBeat.o(184204);
      return 0;
    }
    AppMethodBeat.o(184204);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ara
 * JD-Core Version:    0.7.0.1
 */