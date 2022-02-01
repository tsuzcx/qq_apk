package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bsh
  extends com.tencent.mm.bx.a
{
  public int GNa;
  public b GNb;
  public int GNc;
  public int GNd;
  public int Gdc;
  public int nDi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143982);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GNa);
      if (this.GNb != null) {
        paramVarArgs.c(2, this.GNb);
      }
      paramVarArgs.aS(3, this.GNc);
      paramVarArgs.aS(4, this.Gdc);
      paramVarArgs.aS(5, this.nDi);
      paramVarArgs.aS(6, this.GNd);
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GNa) + 0;
      paramInt = i;
      if (this.GNb != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GNb);
      }
      i = f.a.a.b.b.a.bz(3, this.GNc);
      int j = f.a.a.b.b.a.bz(4, this.Gdc);
      int k = f.a.a.b.b.a.bz(5, this.nDi);
      int m = f.a.a.b.b.a.bz(6, this.GNd);
      AppMethodBeat.o(143982);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143982);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsh localbsh = (bsh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143982);
        return -1;
      case 1: 
        localbsh.GNa = locala.NPN.zc();
        AppMethodBeat.o(143982);
        return 0;
      case 2: 
        localbsh.GNb = locala.NPN.gxI();
        AppMethodBeat.o(143982);
        return 0;
      case 3: 
        localbsh.GNc = locala.NPN.zc();
        AppMethodBeat.o(143982);
        return 0;
      case 4: 
        localbsh.Gdc = locala.NPN.zc();
        AppMethodBeat.o(143982);
        return 0;
      case 5: 
        localbsh.nDi = locala.NPN.zc();
        AppMethodBeat.o(143982);
        return 0;
      }
      localbsh.GNd = locala.NPN.zc();
      AppMethodBeat.o(143982);
      return 0;
    }
    AppMethodBeat.o(143982);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsh
 * JD-Core Version:    0.7.0.1
 */