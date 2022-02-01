package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dr
  extends com.tencent.mm.bx.a
{
  public int FvT;
  public int FvU;
  public int bDT;
  public float bDX;
  public int bHf;
  public int lrc;
  public int lrd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.bHf);
      paramVarArgs.aS(2, this.bDT);
      paramVarArgs.z(3, this.bDX);
      paramVarArgs.aS(4, this.FvT);
      paramVarArgs.aS(5, this.FvU);
      paramVarArgs.aS(6, this.lrc);
      paramVarArgs.aS(7, this.lrd);
      AppMethodBeat.o(103178);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.bHf);
      int i = f.a.a.b.b.a.bz(2, this.bDT);
      int j = f.a.a.b.b.a.alU(3);
      int k = f.a.a.b.b.a.bz(4, this.FvT);
      int m = f.a.a.b.b.a.bz(5, this.FvU);
      int n = f.a.a.b.b.a.bz(6, this.lrc);
      int i1 = f.a.a.b.b.a.bz(7, this.lrd);
      AppMethodBeat.o(103178);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(103178);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dr localdr = (dr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103178);
        return -1;
      case 1: 
        localdr.bHf = locala.NPN.zc();
        AppMethodBeat.o(103178);
        return 0;
      case 2: 
        localdr.bDT = locala.NPN.zc();
        AppMethodBeat.o(103178);
        return 0;
      case 3: 
        localdr.bDX = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(103178);
        return 0;
      case 4: 
        localdr.FvT = locala.NPN.zc();
        AppMethodBeat.o(103178);
        return 0;
      case 5: 
        localdr.FvU = locala.NPN.zc();
        AppMethodBeat.o(103178);
        return 0;
      case 6: 
        localdr.lrc = locala.NPN.zc();
        AppMethodBeat.o(103178);
        return 0;
      }
      localdr.lrd = locala.NPN.zc();
      AppMethodBeat.o(103178);
      return 0;
    }
    AppMethodBeat.o(103178);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dr
 * JD-Core Version:    0.7.0.1
 */