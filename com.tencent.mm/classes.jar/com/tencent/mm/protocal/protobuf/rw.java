package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rw
  extends com.tencent.mm.bx.a
{
  public int FOa;
  public int FOb;
  public int FOc;
  public int FOd;
  public int FOe;
  public int FOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133161);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FOa);
      paramVarArgs.aS(2, this.FOb);
      paramVarArgs.aS(3, this.FOc);
      paramVarArgs.aS(4, this.FOd);
      paramVarArgs.aS(5, this.FOe);
      paramVarArgs.aS(6, this.FOf);
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FOa);
      int i = f.a.a.b.b.a.bz(2, this.FOb);
      int j = f.a.a.b.b.a.bz(3, this.FOc);
      int k = f.a.a.b.b.a.bz(4, this.FOd);
      int m = f.a.a.b.b.a.bz(5, this.FOe);
      int n = f.a.a.b.b.a.bz(6, this.FOf);
      AppMethodBeat.o(133161);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      rw localrw = (rw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133161);
        return -1;
      case 1: 
        localrw.FOa = locala.NPN.zc();
        AppMethodBeat.o(133161);
        return 0;
      case 2: 
        localrw.FOb = locala.NPN.zc();
        AppMethodBeat.o(133161);
        return 0;
      case 3: 
        localrw.FOc = locala.NPN.zc();
        AppMethodBeat.o(133161);
        return 0;
      case 4: 
        localrw.FOd = locala.NPN.zc();
        AppMethodBeat.o(133161);
        return 0;
      case 5: 
        localrw.FOe = locala.NPN.zc();
        AppMethodBeat.o(133161);
        return 0;
      }
      localrw.FOf = locala.NPN.zc();
      AppMethodBeat.o(133161);
      return 0;
    }
    AppMethodBeat.o(133161);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rw
 * JD-Core Version:    0.7.0.1
 */