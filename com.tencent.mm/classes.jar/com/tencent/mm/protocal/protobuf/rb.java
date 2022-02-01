package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rb
  extends com.tencent.mm.bw.a
{
  public int KXU;
  public int KXV;
  public int KXW;
  public int cSx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91367);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.cSx);
      paramVarArgs.aM(2, this.KXU);
      paramVarArgs.aM(3, this.KXV);
      paramVarArgs.aM(4, this.KXW);
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.cSx);
      int i = g.a.a.b.b.a.bu(2, this.KXU);
      int j = g.a.a.b.b.a.bu(3, this.KXV);
      int k = g.a.a.b.b.a.bu(4, this.KXW);
      AppMethodBeat.o(91367);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      rb localrb = (rb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91367);
        return -1;
      case 1: 
        localrb.cSx = locala.UbS.zi();
        AppMethodBeat.o(91367);
        return 0;
      case 2: 
        localrb.KXU = locala.UbS.zi();
        AppMethodBeat.o(91367);
        return 0;
      case 3: 
        localrb.KXV = locala.UbS.zi();
        AppMethodBeat.o(91367);
        return 0;
      }
      localrb.KXW = locala.UbS.zi();
      AppMethodBeat.o(91367);
      return 0;
    }
    AppMethodBeat.o(91367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rb
 * JD-Core Version:    0.7.0.1
 */