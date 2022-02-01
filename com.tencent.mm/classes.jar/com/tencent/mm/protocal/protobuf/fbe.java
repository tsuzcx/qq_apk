package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fbe
  extends com.tencent.mm.bw.a
{
  public boolean Nxu;
  public boolean Nxv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110855);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.Nxu);
      paramVarArgs.cc(2, this.Nxv);
      AppMethodBeat.o(110855);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(110855);
      return paramInt + 1 + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110855);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fbe localfbe = (fbe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110855);
        return -1;
      case 1: 
        localfbe.Nxu = locala.UbS.yZ();
        AppMethodBeat.o(110855);
        return 0;
      }
      localfbe.Nxv = locala.UbS.yZ();
      AppMethodBeat.o(110855);
      return 0;
    }
    AppMethodBeat.o(110855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbe
 * JD-Core Version:    0.7.0.1
 */