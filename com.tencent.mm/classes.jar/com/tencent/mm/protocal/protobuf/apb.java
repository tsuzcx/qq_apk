package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apb
  extends com.tencent.mm.bw.a
{
  public int LBb;
  public int LBc;
  public int LBd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209346);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LBb);
      paramVarArgs.aM(2, this.LBc);
      paramVarArgs.aM(3, this.LBd);
      AppMethodBeat.o(209346);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LBb);
      int i = g.a.a.b.b.a.bu(2, this.LBc);
      int j = g.a.a.b.b.a.bu(3, this.LBd);
      AppMethodBeat.o(209346);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209346);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      apb localapb = (apb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209346);
        return -1;
      case 1: 
        localapb.LBb = locala.UbS.zi();
        AppMethodBeat.o(209346);
        return 0;
      case 2: 
        localapb.LBc = locala.UbS.zi();
        AppMethodBeat.o(209346);
        return 0;
      }
      localapb.LBd = locala.UbS.zi();
      AppMethodBeat.o(209346);
      return 0;
    }
    AppMethodBeat.o(209346);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apb
 * JD-Core Version:    0.7.0.1
 */