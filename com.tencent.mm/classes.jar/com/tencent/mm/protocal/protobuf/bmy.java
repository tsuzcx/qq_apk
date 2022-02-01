package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmy
  extends com.tencent.mm.cd.a
{
  public int HmX;
  public int SXP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43096);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SXP);
      paramVarArgs.aY(2, this.HmX);
      AppMethodBeat.o(43096);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SXP);
      int i = g.a.a.b.b.a.bM(2, this.HmX);
      AppMethodBeat.o(43096);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(43096);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bmy localbmy = (bmy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43096);
        return -1;
      case 1: 
        localbmy.SXP = locala.abFh.AK();
        AppMethodBeat.o(43096);
        return 0;
      }
      localbmy.HmX = locala.abFh.AK();
      AppMethodBeat.o(43096);
      return 0;
    }
    AppMethodBeat.o(43096);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmy
 * JD-Core Version:    0.7.0.1
 */