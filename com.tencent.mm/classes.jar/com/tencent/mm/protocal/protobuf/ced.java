package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ced
  extends com.tencent.mm.bx.a
{
  public int FKZ;
  public int FYc;
  public int GYg;
  public String GYh;
  public String GYi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32361);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FKZ);
      if (this.GYi != null) {
        paramVarArgs.d(3, this.GYi);
      }
      paramVarArgs.aS(4, this.GYg);
      paramVarArgs.aS(5, this.FYc);
      if (this.GYh != null) {
        paramVarArgs.d(6, this.GYh);
      }
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FKZ) + 0;
      paramInt = i;
      if (this.GYi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GYi);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GYg) + f.a.a.b.b.a.bz(5, this.FYc);
      paramInt = i;
      if (this.GYh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GYh);
      }
      AppMethodBeat.o(32361);
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
      AppMethodBeat.o(32361);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ced localced = (ced)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(32361);
        return -1;
      case 1: 
        localced.FKZ = locala.NPN.zc();
        AppMethodBeat.o(32361);
        return 0;
      case 3: 
        localced.GYi = locala.NPN.readString();
        AppMethodBeat.o(32361);
        return 0;
      case 4: 
        localced.GYg = locala.NPN.zc();
        AppMethodBeat.o(32361);
        return 0;
      case 5: 
        localced.FYc = locala.NPN.zc();
        AppMethodBeat.o(32361);
        return 0;
      }
      localced.GYh = locala.NPN.readString();
      AppMethodBeat.o(32361);
      return 0;
    }
    AppMethodBeat.o(32361);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ced
 * JD-Core Version:    0.7.0.1
 */