package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ayg
  extends com.tencent.mm.bw.a
{
  public float LIt;
  public float LIu;
  public float LIv;
  public float LIw;
  public float LIx;
  public boolean LIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209586);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.LIt);
      paramVarArgs.E(2, this.LIu);
      paramVarArgs.E(3, this.LIv);
      paramVarArgs.E(4, this.LIw);
      paramVarArgs.E(5, this.LIx);
      paramVarArgs.cc(6, this.LIy);
      AppMethodBeat.o(209586);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      int n = g.a.a.b.b.a.fS(6);
      AppMethodBeat.o(209586);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + (m + 4) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209586);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ayg localayg = (ayg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209586);
        return -1;
      case 1: 
        localayg.LIt = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209586);
        return 0;
      case 2: 
        localayg.LIu = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209586);
        return 0;
      case 3: 
        localayg.LIv = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209586);
        return 0;
      case 4: 
        localayg.LIw = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209586);
        return 0;
      case 5: 
        localayg.LIx = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(209586);
        return 0;
      }
      localayg.LIy = locala.UbS.yZ();
      AppMethodBeat.o(209586);
      return 0;
    }
    AppMethodBeat.o(209586);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayg
 * JD-Core Version:    0.7.0.1
 */