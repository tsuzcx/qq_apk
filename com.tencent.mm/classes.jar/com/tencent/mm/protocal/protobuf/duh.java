package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duh
  extends com.tencent.mm.bx.a
{
  public int HHd;
  public long HHe;
  public long HHf;
  public long qXg;
  public int zMn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169092);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HHd);
      paramVarArgs.aS(2, this.zMn);
      paramVarArgs.aY(3, this.qXg);
      paramVarArgs.aY(4, this.HHe);
      paramVarArgs.aY(5, this.HHf);
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HHd);
      int i = f.a.a.b.b.a.bz(2, this.zMn);
      int j = f.a.a.b.b.a.p(3, this.qXg);
      int k = f.a.a.b.b.a.p(4, this.HHe);
      int m = f.a.a.b.b.a.p(5, this.HHf);
      AppMethodBeat.o(169092);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      duh localduh = (duh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169092);
        return -1;
      case 1: 
        localduh.HHd = locala.NPN.zc();
        AppMethodBeat.o(169092);
        return 0;
      case 2: 
        localduh.zMn = locala.NPN.zc();
        AppMethodBeat.o(169092);
        return 0;
      case 3: 
        localduh.qXg = locala.NPN.zd();
        AppMethodBeat.o(169092);
        return 0;
      case 4: 
        localduh.HHe = locala.NPN.zd();
        AppMethodBeat.o(169092);
        return 0;
      }
      localduh.HHf = locala.NPN.zd();
      AppMethodBeat.o(169092);
      return 0;
    }
    AppMethodBeat.o(169092);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duh
 * JD-Core Version:    0.7.0.1
 */