package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bym
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b wPX;
  public int xKN;
  public int xKO;
  public int xKP;
  public int xKQ;
  public int xKR;
  public int xKS;
  public int xKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28628);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wPX == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(28628);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xKN);
      paramVarArgs.aO(2, this.xKO);
      paramVarArgs.aO(3, this.xKP);
      paramVarArgs.aO(4, this.xKQ);
      paramVarArgs.aO(5, this.xKR);
      paramVarArgs.aO(6, this.xKS);
      paramVarArgs.aO(7, this.xKT);
      if (this.wPX != null) {
        paramVarArgs.c(8, this.wPX);
      }
      AppMethodBeat.o(28628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xKN) + 0 + e.a.a.b.b.a.bl(2, this.xKO) + e.a.a.b.b.a.bl(3, this.xKP) + e.a.a.b.b.a.bl(4, this.xKQ) + e.a.a.b.b.a.bl(5, this.xKR) + e.a.a.b.b.a.bl(6, this.xKS) + e.a.a.b.b.a.bl(7, this.xKT);
      paramInt = i;
      if (this.wPX != null) {
        paramInt = i + e.a.a.b.b.a.b(8, this.wPX);
      }
      AppMethodBeat.o(28628);
      return paramInt;
    }
    e.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(locala); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(locala)) {
        if (!super.populateBuilderWithField(locala, this, paramInt)) {
          locala.eqQ();
        }
      }
      if (paramVarArgs == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(28628);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28628);
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (e.a.a.a.a)paramVarArgs[0];
      bym localbym = (bym)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28628);
        return -1;
      case 1: 
        localbym.xKN = locala.CLY.sl();
        AppMethodBeat.o(28628);
        return 0;
      case 2: 
        localbym.xKO = locala.CLY.sl();
        AppMethodBeat.o(28628);
        return 0;
      case 3: 
        localbym.xKP = locala.CLY.sl();
        AppMethodBeat.o(28628);
        return 0;
      case 4: 
        localbym.xKQ = locala.CLY.sl();
        AppMethodBeat.o(28628);
        return 0;
      case 5: 
        localbym.xKR = locala.CLY.sl();
        AppMethodBeat.o(28628);
        return 0;
      case 6: 
        localbym.xKS = locala.CLY.sl();
        AppMethodBeat.o(28628);
        return 0;
      case 7: 
        localbym.xKT = locala.CLY.sl();
        AppMethodBeat.o(28628);
        return 0;
      }
      localbym.wPX = locala.CLY.eqS();
      AppMethodBeat.o(28628);
      return 0;
    }
    AppMethodBeat.o(28628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bym
 * JD-Core Version:    0.7.0.1
 */