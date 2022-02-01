package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mc
  extends com.tencent.mm.bw.a
{
  public float FXo;
  public float dBu;
  public float dzE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210677);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.dzE);
      paramVarArgs.y(2, this.dBu);
      paramVarArgs.y(3, this.FXo);
      AppMethodBeat.o(210677);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amE(1);
      int i = f.a.a.b.b.a.amE(2);
      int j = f.a.a.b.b.a.amE(3);
      AppMethodBeat.o(210677);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(210677);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mc localmc = (mc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(210677);
        return -1;
      case 1: 
        localmc.dzE = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(210677);
        return 0;
      case 2: 
        localmc.dBu = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(210677);
        return 0;
      }
      localmc.FXo = Float.intBitsToFloat(locala.OmT.gwb());
      AppMethodBeat.o(210677);
      return 0;
    }
    AppMethodBeat.o(210677);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mc
 * JD-Core Version:    0.7.0.1
 */