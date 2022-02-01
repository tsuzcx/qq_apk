package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzo
  extends com.tencent.mm.bw.a
{
  public int Hnw;
  public int Hnx;
  public int Hny;
  public int wZK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hnw);
      paramVarArgs.aS(2, this.Hnx);
      paramVarArgs.aS(3, this.Hny);
      paramVarArgs.aS(4, this.wZK);
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Hnw);
      int i = f.a.a.b.b.a.bz(2, this.Hnx);
      int j = f.a.a.b.b.a.bz(3, this.Hny);
      int k = f.a.a.b.b.a.bz(4, this.wZK);
      AppMethodBeat.o(116472);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(116472);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bzo localbzo = (bzo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116472);
        return -1;
      case 1: 
        localbzo.Hnw = locala.OmT.zc();
        AppMethodBeat.o(116472);
        return 0;
      case 2: 
        localbzo.Hnx = locala.OmT.zc();
        AppMethodBeat.o(116472);
        return 0;
      case 3: 
        localbzo.Hny = locala.OmT.zc();
        AppMethodBeat.o(116472);
        return 0;
      }
      localbzo.wZK = locala.OmT.zc();
      AppMethodBeat.o(116472);
      return 0;
    }
    AppMethodBeat.o(116472);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzo
 * JD-Core Version:    0.7.0.1
 */