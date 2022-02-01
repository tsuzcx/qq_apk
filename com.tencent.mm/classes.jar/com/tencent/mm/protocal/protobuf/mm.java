package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mm
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int FFS;
  public int FFT;
  public int FuY;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124398);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FFS);
      paramVarArgs.aS(2, this.CreateTime);
      paramVarArgs.aS(3, this.FuY);
      paramVarArgs.aS(4, this.nEf);
      paramVarArgs.aS(5, this.FFT);
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FFS);
      int i = f.a.a.b.b.a.bz(2, this.CreateTime);
      int j = f.a.a.b.b.a.bz(3, this.FuY);
      int k = f.a.a.b.b.a.bz(4, this.nEf);
      int m = f.a.a.b.b.a.bz(5, this.FFT);
      AppMethodBeat.o(124398);
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
      AppMethodBeat.o(124398);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mm localmm = (mm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124398);
        return -1;
      case 1: 
        localmm.FFS = locala.NPN.zc();
        AppMethodBeat.o(124398);
        return 0;
      case 2: 
        localmm.CreateTime = locala.NPN.zc();
        AppMethodBeat.o(124398);
        return 0;
      case 3: 
        localmm.FuY = locala.NPN.zc();
        AppMethodBeat.o(124398);
        return 0;
      case 4: 
        localmm.nEf = locala.NPN.zc();
        AppMethodBeat.o(124398);
        return 0;
      }
      localmm.FFT = locala.NPN.zc();
      AppMethodBeat.o(124398);
      return 0;
    }
    AppMethodBeat.o(124398);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mm
 * JD-Core Version:    0.7.0.1
 */