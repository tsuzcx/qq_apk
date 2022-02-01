package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmd
  extends com.tencent.mm.bx.a
{
  public int HAw;
  public String HAx;
  public int HfV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HAw);
      paramVarArgs.aS(2, this.HfV);
      if (this.HAx != null) {
        paramVarArgs.d(3, this.HAx);
      }
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HAw) + 0 + f.a.a.b.b.a.bz(2, this.HfV);
      paramInt = i;
      if (this.HAx != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HAx);
      }
      AppMethodBeat.o(32466);
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
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmd localdmd = (dmd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32466);
        return -1;
      case 1: 
        localdmd.HAw = locala.NPN.zc();
        AppMethodBeat.o(32466);
        return 0;
      case 2: 
        localdmd.HfV = locala.NPN.zc();
        AppMethodBeat.o(32466);
        return 0;
      }
      localdmd.HAx = locala.NPN.readString();
      AppMethodBeat.o(32466);
      return 0;
    }
    AppMethodBeat.o(32466);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmd
 * JD-Core Version:    0.7.0.1
 */