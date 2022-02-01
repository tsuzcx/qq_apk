package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcm
  extends com.tencent.mm.bw.a
{
  public float LbC;
  public float LbD;
  public int LuT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209789);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.LbC);
      paramVarArgs.E(2, this.LbD);
      paramVarArgs.aM(3, this.LuT);
      AppMethodBeat.o(209789);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.bu(3, this.LuT);
      AppMethodBeat.o(209789);
      return paramInt + 4 + 0 + (i + 4) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209789);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dcm localdcm = (dcm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209789);
        return -1;
      case 1: 
        localdcm.LbC = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209789);
        return 0;
      case 2: 
        localdcm.LbD = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209789);
        return 0;
      }
      localdcm.LuT = locala.UbS.zi();
      AppMethodBeat.o(209789);
      return 0;
    }
    AppMethodBeat.o(209789);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcm
 * JD-Core Version:    0.7.0.1
 */