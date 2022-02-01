package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rp
  extends com.tencent.mm.bx.a
{
  public int FNJ;
  public long FNK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194980);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FNJ);
      paramVarArgs.aY(2, this.FNK);
      AppMethodBeat.o(194980);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FNJ);
      int i = f.a.a.b.b.a.p(2, this.FNK);
      AppMethodBeat.o(194980);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(194980);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      rp localrp = (rp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(194980);
        return -1;
      case 1: 
        localrp.FNJ = locala.NPN.zc();
        AppMethodBeat.o(194980);
        return 0;
      }
      localrp.FNK = locala.NPN.zd();
      AppMethodBeat.o(194980);
      return 0;
    }
    AppMethodBeat.o(194980);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rp
 * JD-Core Version:    0.7.0.1
 */