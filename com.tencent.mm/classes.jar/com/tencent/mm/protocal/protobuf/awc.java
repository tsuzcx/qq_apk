package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awc
  extends com.tencent.mm.bv.a
{
  public int cnE;
  public int xlq;
  public int xlr;
  public int xls;
  public int xlt;
  public int xlu;
  public int xlv;
  public int xlw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72857);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xlq);
      paramVarArgs.aO(2, this.cnE);
      paramVarArgs.aO(3, this.xlr);
      paramVarArgs.aO(4, this.xls);
      paramVarArgs.aO(5, this.xlt);
      paramVarArgs.aO(6, this.xlu);
      paramVarArgs.aO(7, this.xlv);
      paramVarArgs.aO(8, this.xlw);
      AppMethodBeat.o(72857);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xlq);
      int i = e.a.a.b.b.a.bl(2, this.cnE);
      int j = e.a.a.b.b.a.bl(3, this.xlr);
      int k = e.a.a.b.b.a.bl(4, this.xls);
      int m = e.a.a.b.b.a.bl(5, this.xlt);
      int n = e.a.a.b.b.a.bl(6, this.xlu);
      int i1 = e.a.a.b.b.a.bl(7, this.xlv);
      int i2 = e.a.a.b.b.a.bl(8, this.xlw);
      AppMethodBeat.o(72857);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72857);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      awc localawc = (awc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72857);
        return -1;
      case 1: 
        localawc.xlq = locala.CLY.sl();
        AppMethodBeat.o(72857);
        return 0;
      case 2: 
        localawc.cnE = locala.CLY.sl();
        AppMethodBeat.o(72857);
        return 0;
      case 3: 
        localawc.xlr = locala.CLY.sl();
        AppMethodBeat.o(72857);
        return 0;
      case 4: 
        localawc.xls = locala.CLY.sl();
        AppMethodBeat.o(72857);
        return 0;
      case 5: 
        localawc.xlt = locala.CLY.sl();
        AppMethodBeat.o(72857);
        return 0;
      case 6: 
        localawc.xlu = locala.CLY.sl();
        AppMethodBeat.o(72857);
        return 0;
      case 7: 
        localawc.xlv = locala.CLY.sl();
        AppMethodBeat.o(72857);
        return 0;
      }
      localawc.xlw = locala.CLY.sl();
      AppMethodBeat.o(72857);
      return 0;
    }
    AppMethodBeat.o(72857);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awc
 * JD-Core Version:    0.7.0.1
 */