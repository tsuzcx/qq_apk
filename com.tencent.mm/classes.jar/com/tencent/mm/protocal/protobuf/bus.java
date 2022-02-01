package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bus
  extends com.tencent.mm.bw.a
{
  public String MaX;
  public int MaY;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187871);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Scene);
      if (this.MaX != null) {
        paramVarArgs.e(2, this.MaX);
      }
      paramVarArgs.aM(3, this.MaY);
      AppMethodBeat.o(187871);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Scene) + 0;
      paramInt = i;
      if (this.MaX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MaX);
      }
      i = g.a.a.b.b.a.bu(3, this.MaY);
      AppMethodBeat.o(187871);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(187871);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bus localbus = (bus)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(187871);
        return -1;
      case 1: 
        localbus.Scene = locala.UbS.zi();
        AppMethodBeat.o(187871);
        return 0;
      case 2: 
        localbus.MaX = locala.UbS.readString();
        AppMethodBeat.o(187871);
        return 0;
      }
      localbus.MaY = locala.UbS.zi();
      AppMethodBeat.o(187871);
      return 0;
    }
    AppMethodBeat.o(187871);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bus
 * JD-Core Version:    0.7.0.1
 */