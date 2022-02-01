package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzf
  extends com.tencent.mm.bx.a
{
  public String GKe;
  public long HMz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147787);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.HMz);
      if (this.GKe != null) {
        paramVarArgs.d(2, this.GKe);
      }
      AppMethodBeat.o(147787);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.HMz) + 0;
      paramInt = i;
      if (this.GKe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GKe);
      }
      AppMethodBeat.o(147787);
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
      AppMethodBeat.o(147787);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzf localdzf = (dzf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147787);
        return -1;
      case 1: 
        localdzf.HMz = locala.NPN.zd();
        AppMethodBeat.o(147787);
        return 0;
      }
      localdzf.GKe = locala.NPN.readString();
      AppMethodBeat.o(147787);
      return 0;
    }
    AppMethodBeat.o(147787);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzf
 * JD-Core Version:    0.7.0.1
 */