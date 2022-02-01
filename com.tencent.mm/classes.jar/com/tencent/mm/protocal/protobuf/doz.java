package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doz
  extends com.tencent.mm.bw.a
{
  public int JZb;
  public int MJT;
  public int MSs;
  public int MSu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152672);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MJT);
      paramVarArgs.aM(2, this.MSu);
      paramVarArgs.aM(3, this.MSs);
      paramVarArgs.aM(4, this.JZb);
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MJT);
      int i = g.a.a.b.b.a.bu(2, this.MSu);
      int j = g.a.a.b.b.a.bu(3, this.MSs);
      int k = g.a.a.b.b.a.bu(4, this.JZb);
      AppMethodBeat.o(152672);
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
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      doz localdoz = (doz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152672);
        return -1;
      case 1: 
        localdoz.MJT = locala.UbS.zi();
        AppMethodBeat.o(152672);
        return 0;
      case 2: 
        localdoz.MSu = locala.UbS.zi();
        AppMethodBeat.o(152672);
        return 0;
      case 3: 
        localdoz.MSs = locala.UbS.zi();
        AppMethodBeat.o(152672);
        return 0;
      }
      localdoz.JZb = locala.UbS.zi();
      AppMethodBeat.o(152672);
      return 0;
    }
    AppMethodBeat.o(152672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doz
 * JD-Core Version:    0.7.0.1
 */