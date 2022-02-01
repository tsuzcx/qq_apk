package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddj
  extends com.tencent.mm.bw.a
{
  public double KUt;
  public double KUu;
  public double MIv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56258);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.KUu);
      paramVarArgs.e(2, this.KUt);
      paramVarArgs.e(3, this.MIv);
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(56258);
      return paramInt + 8 + 0 + (i + 8) + (j + 8);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(56258);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ddj localddj = (ddj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56258);
        return -1;
      case 1: 
        localddj.KUu = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(56258);
        return 0;
      case 2: 
        localddj.KUt = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(56258);
        return 0;
      }
      localddj.MIv = Double.longBitsToDouble(locala.UbS.zn());
      AppMethodBeat.o(56258);
      return 0;
    }
    AppMethodBeat.o(56258);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddj
 * JD-Core Version:    0.7.0.1
 */