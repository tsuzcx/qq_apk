package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cee
  extends com.tencent.mm.bx.a
{
  public int FKZ;
  public int FYc;
  public int GYg;
  public String GYh;
  public String GYj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FKZ);
      if (this.GYj != null) {
        paramVarArgs.d(3, this.GYj);
      }
      paramVarArgs.aS(4, this.GYg);
      paramVarArgs.aS(5, this.FYc);
      if (this.GYh != null) {
        paramVarArgs.d(6, this.GYh);
      }
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FKZ) + 0;
      paramInt = i;
      if (this.GYj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GYj);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GYg) + f.a.a.b.b.a.bz(5, this.FYc);
      paramInt = i;
      if (this.GYh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GYh);
      }
      AppMethodBeat.o(43114);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cee localcee = (cee)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(43114);
        return -1;
      case 1: 
        localcee.FKZ = locala.NPN.zc();
        AppMethodBeat.o(43114);
        return 0;
      case 3: 
        localcee.GYj = locala.NPN.readString();
        AppMethodBeat.o(43114);
        return 0;
      case 4: 
        localcee.GYg = locala.NPN.zc();
        AppMethodBeat.o(43114);
        return 0;
      case 5: 
        localcee.FYc = locala.NPN.zc();
        AppMethodBeat.o(43114);
        return 0;
      }
      localcee.GYh = locala.NPN.readString();
      AppMethodBeat.o(43114);
      return 0;
    }
    AppMethodBeat.o(43114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cee
 * JD-Core Version:    0.7.0.1
 */