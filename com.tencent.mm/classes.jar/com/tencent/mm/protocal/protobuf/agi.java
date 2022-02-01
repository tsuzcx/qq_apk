package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agi
  extends com.tencent.mm.bx.a
{
  public int Geq;
  public String MD5;
  public int Ret;
  public long xbt;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109447);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      paramVarArgs.aS(2, this.xcL);
      paramVarArgs.aS(3, this.xcK);
      if (this.MD5 != null) {
        paramVarArgs.d(4, this.MD5);
      }
      paramVarArgs.aS(5, this.Geq);
      paramVarArgs.aY(6, this.xbt);
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Ret) + 0 + f.a.a.b.b.a.bz(2, this.xcL) + f.a.a.b.b.a.bz(3, this.xcK);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.MD5);
      }
      i = f.a.a.b.b.a.bz(5, this.Geq);
      int j = f.a.a.b.b.a.p(6, this.xbt);
      AppMethodBeat.o(109447);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      agi localagi = (agi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(109447);
        return -1;
      case 1: 
        localagi.Ret = locala.NPN.zc();
        AppMethodBeat.o(109447);
        return 0;
      case 2: 
        localagi.xcL = locala.NPN.zc();
        AppMethodBeat.o(109447);
        return 0;
      case 3: 
        localagi.xcK = locala.NPN.zc();
        AppMethodBeat.o(109447);
        return 0;
      case 4: 
        localagi.MD5 = locala.NPN.readString();
        AppMethodBeat.o(109447);
        return 0;
      case 5: 
        localagi.Geq = locala.NPN.zc();
        AppMethodBeat.o(109447);
        return 0;
      }
      localagi.xbt = locala.NPN.zd();
      AppMethodBeat.o(109447);
      return 0;
    }
    AppMethodBeat.o(109447);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agi
 * JD-Core Version:    0.7.0.1
 */