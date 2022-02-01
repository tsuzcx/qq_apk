package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bal
  extends com.tencent.mm.bw.a
{
  public float LKc;
  public float LKd;
  public int LKe;
  public float dTj;
  public float latitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169035);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(8, this.dTj);
      paramVarArgs.E(9, this.latitude);
      paramVarArgs.E(10, this.LKc);
      paramVarArgs.E(11, this.LKd);
      paramVarArgs.aM(12, this.LKe);
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(8);
      int i = g.a.a.b.b.a.fS(9);
      int j = g.a.a.b.b.a.fS(10);
      int k = g.a.a.b.b.a.fS(11);
      int m = g.a.a.b.b.a.bu(12, this.LKe);
      AppMethodBeat.o(169035);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bal localbal = (bal)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169035);
        return -1;
      case 8: 
        localbal.dTj = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(169035);
        return 0;
      case 9: 
        localbal.latitude = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(169035);
        return 0;
      case 10: 
        localbal.LKc = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(169035);
        return 0;
      case 11: 
        localbal.LKd = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(169035);
        return 0;
      }
      localbal.LKe = locala.UbS.zi();
      AppMethodBeat.o(169035);
      return 0;
    }
    AppMethodBeat.o(169035);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bal
 * JD-Core Version:    0.7.0.1
 */