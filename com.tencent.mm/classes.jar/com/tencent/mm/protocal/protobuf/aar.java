package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aar
  extends com.tencent.mm.bx.a
{
  public int FZJ;
  public int FZK;
  public int FZL;
  public int FZM;
  public int oXm;
  public int oXn;
  public int oXo;
  public int oXp;
  public int oXq;
  public int oXr;
  public int oXs;
  public int oXt;
  public int oXu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.oXm);
      paramVarArgs.aS(2, this.FZJ);
      paramVarArgs.aS(3, this.oXn);
      paramVarArgs.aS(4, this.oXo);
      paramVarArgs.aS(5, this.oXp);
      paramVarArgs.aS(6, this.FZK);
      paramVarArgs.aS(7, this.oXq);
      paramVarArgs.aS(8, this.oXr);
      paramVarArgs.aS(9, this.FZL);
      paramVarArgs.aS(10, this.FZM);
      paramVarArgs.aS(11, this.oXs);
      paramVarArgs.aS(12, this.oXt);
      paramVarArgs.aS(13, this.oXu);
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.oXm);
      int i = f.a.a.b.b.a.bz(2, this.FZJ);
      int j = f.a.a.b.b.a.bz(3, this.oXn);
      int k = f.a.a.b.b.a.bz(4, this.oXo);
      int m = f.a.a.b.b.a.bz(5, this.oXp);
      int n = f.a.a.b.b.a.bz(6, this.FZK);
      int i1 = f.a.a.b.b.a.bz(7, this.oXq);
      int i2 = f.a.a.b.b.a.bz(8, this.oXr);
      int i3 = f.a.a.b.b.a.bz(9, this.FZL);
      int i4 = f.a.a.b.b.a.bz(10, this.FZM);
      int i5 = f.a.a.b.b.a.bz(11, this.oXs);
      int i6 = f.a.a.b.b.a.bz(12, this.oXt);
      int i7 = f.a.a.b.b.a.bz(13, this.oXu);
      AppMethodBeat.o(90959);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(90959);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aar localaar = (aar)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90959);
        return -1;
      case 1: 
        localaar.oXm = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 2: 
        localaar.FZJ = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 3: 
        localaar.oXn = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 4: 
        localaar.oXo = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 5: 
        localaar.oXp = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 6: 
        localaar.FZK = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 7: 
        localaar.oXq = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 8: 
        localaar.oXr = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 9: 
        localaar.FZL = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 10: 
        localaar.FZM = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 11: 
        localaar.oXs = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      case 12: 
        localaar.oXt = locala.NPN.zc();
        AppMethodBeat.o(90959);
        return 0;
      }
      localaar.oXu = locala.NPN.zc();
      AppMethodBeat.o(90959);
      return 0;
    }
    AppMethodBeat.o(90959);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aar
 * JD-Core Version:    0.7.0.1
 */