package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezr
  extends com.tencent.mm.bw.a
{
  public int KLp;
  public long KMm;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32561);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ret);
      paramVarArgs.aM(2, this.KLp);
      paramVarArgs.bb(3, this.KMm);
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Ret);
      int i = g.a.a.b.b.a.bu(2, this.KLp);
      int j = g.a.a.b.b.a.r(3, this.KMm);
      AppMethodBeat.o(32561);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32561);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ezr localezr = (ezr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32561);
        return -1;
      case 1: 
        localezr.Ret = locala.UbS.zi();
        AppMethodBeat.o(32561);
        return 0;
      case 2: 
        localezr.KLp = locala.UbS.zi();
        AppMethodBeat.o(32561);
        return 0;
      }
      localezr.KMm = locala.UbS.zl();
      AppMethodBeat.o(32561);
      return 0;
    }
    AppMethodBeat.o(32561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezr
 * JD-Core Version:    0.7.0.1
 */