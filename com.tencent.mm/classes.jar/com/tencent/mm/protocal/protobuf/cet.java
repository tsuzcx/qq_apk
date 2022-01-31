package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cet
  extends com.tencent.mm.bv.a
{
  public float boo;
  public int rIi;
  public float xPh;
  public float xPi;
  public float xPj;
  public float xPk;
  public int xPl;
  public long xPm;
  public long xPn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94602);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.q(1, this.xPh);
      paramVarArgs.q(2, this.xPi);
      paramVarArgs.q(3, this.xPj);
      paramVarArgs.q(4, this.xPk);
      paramVarArgs.aO(5, this.xPl);
      paramVarArgs.am(6, this.xPm);
      paramVarArgs.am(7, this.xPn);
      paramVarArgs.q(8, this.boo);
      paramVarArgs.aO(9, this.rIi);
      AppMethodBeat.o(94602);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.eW(1);
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.eW(4);
      int m = e.a.a.b.b.a.bl(5, this.xPl);
      int n = e.a.a.b.b.a.p(6, this.xPm);
      int i1 = e.a.a.b.b.a.p(7, this.xPn);
      int i2 = e.a.a.b.b.a.eW(8);
      int i3 = e.a.a.b.b.a.bl(9, this.rIi);
      AppMethodBeat.o(94602);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m + n + i1 + (i2 + 4) + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94602);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cet localcet = (cet)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94602);
        return -1;
      case 1: 
        localcet.xPh = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94602);
        return 0;
      case 2: 
        localcet.xPi = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94602);
        return 0;
      case 3: 
        localcet.xPj = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94602);
        return 0;
      case 4: 
        localcet.xPk = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94602);
        return 0;
      case 5: 
        localcet.xPl = locala.CLY.sl();
        AppMethodBeat.o(94602);
        return 0;
      case 6: 
        localcet.xPm = locala.CLY.sm();
        AppMethodBeat.o(94602);
        return 0;
      case 7: 
        localcet.xPn = locala.CLY.sm();
        AppMethodBeat.o(94602);
        return 0;
      case 8: 
        localcet.boo = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(94602);
        return 0;
      }
      localcet.rIi = locala.CLY.sl();
      AppMethodBeat.o(94602);
      return 0;
    }
    AppMethodBeat.o(94602);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cet
 * JD-Core Version:    0.7.0.1
 */