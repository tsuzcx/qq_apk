package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcr
  extends com.tencent.mm.bw.a
{
  public float AAM;
  public float MHV;
  public float MHW;
  public float MHX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209795);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.AAM);
      paramVarArgs.E(2, this.MHV);
      paramVarArgs.E(3, this.MHW);
      paramVarArgs.E(4, this.MHX);
      AppMethodBeat.o(209795);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(209795);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209795);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dcr localdcr = (dcr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209795);
        return -1;
      case 1: 
        localdcr.AAM = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209795);
        return 0;
      case 2: 
        localdcr.MHV = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209795);
        return 0;
      case 3: 
        localdcr.MHW = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209795);
        return 0;
      }
      localdcr.MHX = Float.intBitsToFloat(locala.UbS.zm());
      AppMethodBeat.o(209795);
      return 0;
    }
    AppMethodBeat.o(209795);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcr
 * JD-Core Version:    0.7.0.1
 */