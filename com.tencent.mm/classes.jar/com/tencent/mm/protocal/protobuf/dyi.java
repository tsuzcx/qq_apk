package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyi
  extends com.tencent.mm.bx.a
{
  public int HLE;
  public int HLF;
  public int HLG;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115903);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nEf);
      paramVarArgs.aS(2, this.HLE);
      paramVarArgs.aS(3, this.HLF);
      paramVarArgs.aS(4, this.HLG);
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.nEf);
      int i = f.a.a.b.b.a.bz(2, this.HLE);
      int j = f.a.a.b.b.a.bz(3, this.HLF);
      int k = f.a.a.b.b.a.bz(4, this.HLG);
      AppMethodBeat.o(115903);
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
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dyi localdyi = (dyi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115903);
        return -1;
      case 1: 
        localdyi.nEf = locala.NPN.zc();
        AppMethodBeat.o(115903);
        return 0;
      case 2: 
        localdyi.HLE = locala.NPN.zc();
        AppMethodBeat.o(115903);
        return 0;
      case 3: 
        localdyi.HLF = locala.NPN.zc();
        AppMethodBeat.o(115903);
        return 0;
      }
      localdyi.HLG = locala.NPN.zc();
      AppMethodBeat.o(115903);
      return 0;
    }
    AppMethodBeat.o(115903);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyi
 * JD-Core Version:    0.7.0.1
 */