package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dit
  extends com.tencent.mm.bx.a
{
  public int aaNA;
  public int aaNB;
  public int aaNv;
  public int aaNw;
  public int aaNx;
  public int aaNy;
  public int aaNz;
  public int akli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260043);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaNv);
      paramVarArgs.bS(2, this.aaNw);
      paramVarArgs.bS(3, this.aaNx);
      paramVarArgs.bS(4, this.aaNy);
      paramVarArgs.bS(5, this.aaNz);
      paramVarArgs.bS(6, this.aaNA);
      paramVarArgs.bS(7, this.aaNB);
      paramVarArgs.bS(8, this.akli);
      AppMethodBeat.o(260043);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaNv);
      int i = i.a.a.b.b.a.cJ(2, this.aaNw);
      int j = i.a.a.b.b.a.cJ(3, this.aaNx);
      int k = i.a.a.b.b.a.cJ(4, this.aaNy);
      int m = i.a.a.b.b.a.cJ(5, this.aaNz);
      int n = i.a.a.b.b.a.cJ(6, this.aaNA);
      int i1 = i.a.a.b.b.a.cJ(7, this.aaNB);
      int i2 = i.a.a.b.b.a.cJ(8, this.akli);
      AppMethodBeat.o(260043);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260043);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dit localdit = (dit)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260043);
        return -1;
      case 1: 
        localdit.aaNv = locala.ajGk.aar();
        AppMethodBeat.o(260043);
        return 0;
      case 2: 
        localdit.aaNw = locala.ajGk.aar();
        AppMethodBeat.o(260043);
        return 0;
      case 3: 
        localdit.aaNx = locala.ajGk.aar();
        AppMethodBeat.o(260043);
        return 0;
      case 4: 
        localdit.aaNy = locala.ajGk.aar();
        AppMethodBeat.o(260043);
        return 0;
      case 5: 
        localdit.aaNz = locala.ajGk.aar();
        AppMethodBeat.o(260043);
        return 0;
      case 6: 
        localdit.aaNA = locala.ajGk.aar();
        AppMethodBeat.o(260043);
        return 0;
      case 7: 
        localdit.aaNB = locala.ajGk.aar();
        AppMethodBeat.o(260043);
        return 0;
      }
      localdit.akli = locala.ajGk.aar();
      AppMethodBeat.o(260043);
      return 0;
    }
    AppMethodBeat.o(260043);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dit
 * JD-Core Version:    0.7.0.1
 */