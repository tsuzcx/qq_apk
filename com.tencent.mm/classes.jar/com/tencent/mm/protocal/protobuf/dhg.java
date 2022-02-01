package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhg
  extends com.tencent.mm.bx.a
{
  public int HvJ;
  public int HvK;
  public int jdn;
  public String jdo;
  public long jdp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43131);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.jdn);
      if (this.jdo != null) {
        paramVarArgs.d(2, this.jdo);
      }
      paramVarArgs.aY(3, this.jdp);
      paramVarArgs.aS(4, this.HvJ);
      paramVarArgs.aS(5, this.HvK);
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.jdn) + 0;
      paramInt = i;
      if (this.jdo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jdo);
      }
      i = f.a.a.b.b.a.p(3, this.jdp);
      int j = f.a.a.b.b.a.bz(4, this.HvJ);
      int k = f.a.a.b.b.a.bz(5, this.HvK);
      AppMethodBeat.o(43131);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhg localdhg = (dhg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43131);
        return -1;
      case 1: 
        localdhg.jdn = locala.NPN.zc();
        AppMethodBeat.o(43131);
        return 0;
      case 2: 
        localdhg.jdo = locala.NPN.readString();
        AppMethodBeat.o(43131);
        return 0;
      case 3: 
        localdhg.jdp = locala.NPN.zd();
        AppMethodBeat.o(43131);
        return 0;
      case 4: 
        localdhg.HvJ = locala.NPN.zc();
        AppMethodBeat.o(43131);
        return 0;
      }
      localdhg.HvK = locala.NPN.zc();
      AppMethodBeat.o(43131);
      return 0;
    }
    AppMethodBeat.o(43131);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhg
 * JD-Core Version:    0.7.0.1
 */