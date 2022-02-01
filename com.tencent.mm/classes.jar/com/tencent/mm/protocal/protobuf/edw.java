package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edw
  extends com.tencent.mm.bw.a
{
  public long Nds;
  public int Nej;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118457);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Nds);
      paramVarArgs.aM(2, this.Nej);
      AppMethodBeat.o(118457);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.Nds);
      int i = g.a.a.b.b.a.bu(2, this.Nej);
      AppMethodBeat.o(118457);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(118457);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      edw localedw = (edw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118457);
        return -1;
      case 1: 
        localedw.Nds = locala.UbS.zl();
        AppMethodBeat.o(118457);
        return 0;
      }
      localedw.Nej = locala.UbS.zi();
      AppMethodBeat.o(118457);
      return 0;
    }
    AppMethodBeat.o(118457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edw
 * JD-Core Version:    0.7.0.1
 */