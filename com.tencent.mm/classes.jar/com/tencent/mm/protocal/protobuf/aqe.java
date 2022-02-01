package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqe
  extends com.tencent.mm.bx.a
{
  public int Gok;
  public int Gol;
  public int Gom;
  public int Gon;
  public int Goo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209345);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gok);
      paramVarArgs.aS(2, this.Gol);
      paramVarArgs.aS(3, this.Gom);
      paramVarArgs.aS(4, this.Gon);
      paramVarArgs.aS(5, this.Goo);
      AppMethodBeat.o(209345);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gok);
      int i = f.a.a.b.b.a.bz(2, this.Gol);
      int j = f.a.a.b.b.a.bz(3, this.Gom);
      int k = f.a.a.b.b.a.bz(4, this.Gon);
      int m = f.a.a.b.b.a.bz(5, this.Goo);
      AppMethodBeat.o(209345);
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
      AppMethodBeat.o(209345);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqe localaqe = (aqe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209345);
        return -1;
      case 1: 
        localaqe.Gok = locala.NPN.zc();
        AppMethodBeat.o(209345);
        return 0;
      case 2: 
        localaqe.Gol = locala.NPN.zc();
        AppMethodBeat.o(209345);
        return 0;
      case 3: 
        localaqe.Gom = locala.NPN.zc();
        AppMethodBeat.o(209345);
        return 0;
      case 4: 
        localaqe.Gon = locala.NPN.zc();
        AppMethodBeat.o(209345);
        return 0;
      }
      localaqe.Goo = locala.NPN.zc();
      AppMethodBeat.o(209345);
      return 0;
    }
    AppMethodBeat.o(209345);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqe
 * JD-Core Version:    0.7.0.1
 */