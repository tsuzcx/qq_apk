package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bg
  extends com.tencent.mm.bx.a
{
  public int YCr;
  public int YCs;
  public int YCt;
  public int YCu;
  public int YCv;
  public int YCw;
  public int YCx;
  public int YCy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260057);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YCr);
      paramVarArgs.bS(2, this.YCs);
      paramVarArgs.bS(3, this.YCt);
      paramVarArgs.bS(4, this.YCu);
      paramVarArgs.bS(5, this.YCv);
      paramVarArgs.bS(6, this.YCw);
      paramVarArgs.bS(7, this.YCx);
      paramVarArgs.bS(8, this.YCy);
      AppMethodBeat.o(260057);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YCr);
      int i = i.a.a.b.b.a.cJ(2, this.YCs);
      int j = i.a.a.b.b.a.cJ(3, this.YCt);
      int k = i.a.a.b.b.a.cJ(4, this.YCu);
      int m = i.a.a.b.b.a.cJ(5, this.YCv);
      int n = i.a.a.b.b.a.cJ(6, this.YCw);
      int i1 = i.a.a.b.b.a.cJ(7, this.YCx);
      int i2 = i.a.a.b.b.a.cJ(8, this.YCy);
      AppMethodBeat.o(260057);
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
      AppMethodBeat.o(260057);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bg localbg = (bg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260057);
        return -1;
      case 1: 
        localbg.YCr = locala.ajGk.aar();
        AppMethodBeat.o(260057);
        return 0;
      case 2: 
        localbg.YCs = locala.ajGk.aar();
        AppMethodBeat.o(260057);
        return 0;
      case 3: 
        localbg.YCt = locala.ajGk.aar();
        AppMethodBeat.o(260057);
        return 0;
      case 4: 
        localbg.YCu = locala.ajGk.aar();
        AppMethodBeat.o(260057);
        return 0;
      case 5: 
        localbg.YCv = locala.ajGk.aar();
        AppMethodBeat.o(260057);
        return 0;
      case 6: 
        localbg.YCw = locala.ajGk.aar();
        AppMethodBeat.o(260057);
        return 0;
      case 7: 
        localbg.YCx = locala.ajGk.aar();
        AppMethodBeat.o(260057);
        return 0;
      }
      localbg.YCy = locala.ajGk.aar();
      AppMethodBeat.o(260057);
      return 0;
    }
    AppMethodBeat.o(260057);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bg
 * JD-Core Version:    0.7.0.1
 */