package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctq
  extends com.tencent.mm.bw.a
{
  public int MlF;
  public int MyT;
  public int MyU;
  public int MyV;
  public int MyW;
  public int MyX;
  public int MyY;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143985);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MlF);
      paramVarArgs.aM(2, this.MyT);
      paramVarArgs.aM(3, this.MyU);
      paramVarArgs.aM(4, this.MyV);
      paramVarArgs.aM(5, this.MyW);
      paramVarArgs.aM(6, this.MyX);
      paramVarArgs.aM(7, this.MyY);
      paramVarArgs.aM(8, this.oUv);
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MlF);
      int i = g.a.a.b.b.a.bu(2, this.MyT);
      int j = g.a.a.b.b.a.bu(3, this.MyU);
      int k = g.a.a.b.b.a.bu(4, this.MyV);
      int m = g.a.a.b.b.a.bu(5, this.MyW);
      int n = g.a.a.b.b.a.bu(6, this.MyX);
      int i1 = g.a.a.b.b.a.bu(7, this.MyY);
      int i2 = g.a.a.b.b.a.bu(8, this.oUv);
      AppMethodBeat.o(143985);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143985);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ctq localctq = (ctq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143985);
        return -1;
      case 1: 
        localctq.MlF = locala.UbS.zi();
        AppMethodBeat.o(143985);
        return 0;
      case 2: 
        localctq.MyT = locala.UbS.zi();
        AppMethodBeat.o(143985);
        return 0;
      case 3: 
        localctq.MyU = locala.UbS.zi();
        AppMethodBeat.o(143985);
        return 0;
      case 4: 
        localctq.MyV = locala.UbS.zi();
        AppMethodBeat.o(143985);
        return 0;
      case 5: 
        localctq.MyW = locala.UbS.zi();
        AppMethodBeat.o(143985);
        return 0;
      case 6: 
        localctq.MyX = locala.UbS.zi();
        AppMethodBeat.o(143985);
        return 0;
      case 7: 
        localctq.MyY = locala.UbS.zi();
        AppMethodBeat.o(143985);
        return 0;
      }
      localctq.oUv = locala.UbS.zi();
      AppMethodBeat.o(143985);
      return 0;
    }
    AppMethodBeat.o(143985);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctq
 * JD-Core Version:    0.7.0.1
 */