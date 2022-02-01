package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efm
  extends com.tencent.mm.bx.a
{
  public int HQJ;
  public int HQK;
  public int HQL;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.version);
      paramVarArgs.aS(2, this.HQJ);
      paramVarArgs.aS(3, this.HQK);
      paramVarArgs.aS(4, this.HQL);
      AppMethodBeat.o(219114);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.version);
      int i = f.a.a.b.b.a.bz(2, this.HQJ);
      int j = f.a.a.b.b.a.bz(3, this.HQK);
      int k = f.a.a.b.b.a.bz(4, this.HQL);
      AppMethodBeat.o(219114);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(219114);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      efm localefm = (efm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(219114);
        return -1;
      case 1: 
        localefm.version = locala.NPN.zc();
        AppMethodBeat.o(219114);
        return 0;
      case 2: 
        localefm.HQJ = locala.NPN.zc();
        AppMethodBeat.o(219114);
        return 0;
      case 3: 
        localefm.HQK = locala.NPN.zc();
        AppMethodBeat.o(219114);
        return 0;
      }
      localefm.HQL = locala.NPN.zc();
      AppMethodBeat.o(219114);
      return 0;
    }
    AppMethodBeat.o(219114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efm
 * JD-Core Version:    0.7.0.1
 */