package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffa
  extends com.tencent.mm.bw.a
{
  public int KSa;
  public int MjZ;
  public int NAo;
  public int NAp;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123712);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MjZ);
      paramVarArgs.aM(2, this.KSa);
      paramVarArgs.aM(3, this.NAo);
      paramVarArgs.aM(4, this.Scene);
      paramVarArgs.aM(10, this.NAp);
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MjZ);
      int i = g.a.a.b.b.a.bu(2, this.KSa);
      int j = g.a.a.b.b.a.bu(3, this.NAo);
      int k = g.a.a.b.b.a.bu(4, this.Scene);
      int m = g.a.a.b.b.a.bu(10, this.NAp);
      AppMethodBeat.o(123712);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123712);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ffa localffa = (ffa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        AppMethodBeat.o(123712);
        return -1;
      case 1: 
        localffa.MjZ = locala.UbS.zi();
        AppMethodBeat.o(123712);
        return 0;
      case 2: 
        localffa.KSa = locala.UbS.zi();
        AppMethodBeat.o(123712);
        return 0;
      case 3: 
        localffa.NAo = locala.UbS.zi();
        AppMethodBeat.o(123712);
        return 0;
      case 4: 
        localffa.Scene = locala.UbS.zi();
        AppMethodBeat.o(123712);
        return 0;
      }
      localffa.NAp = locala.UbS.zi();
      AppMethodBeat.o(123712);
      return 0;
    }
    AppMethodBeat.o(123712);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffa
 * JD-Core Version:    0.7.0.1
 */