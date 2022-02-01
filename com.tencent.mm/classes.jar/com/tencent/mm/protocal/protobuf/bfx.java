package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfx
  extends com.tencent.mm.bw.a
{
  public int BsD;
  public int LPB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43096);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LPB);
      paramVarArgs.aM(2, this.BsD);
      AppMethodBeat.o(43096);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LPB);
      int i = g.a.a.b.b.a.bu(2, this.BsD);
      AppMethodBeat.o(43096);
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
      AppMethodBeat.o(43096);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bfx localbfx = (bfx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43096);
        return -1;
      case 1: 
        localbfx.LPB = locala.UbS.zi();
        AppMethodBeat.o(43096);
        return 0;
      }
      localbfx.BsD = locala.UbS.zi();
      AppMethodBeat.o(43096);
      return 0;
    }
    AppMethodBeat.o(43096);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfx
 * JD-Core Version:    0.7.0.1
 */