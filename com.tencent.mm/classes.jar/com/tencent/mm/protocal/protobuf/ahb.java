package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahb
  extends com.tencent.mm.bw.a
{
  public int LqL;
  public int dYT;
  public int fps;
  public int gGn;
  public int gGo;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90965);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.gGn);
      paramVarArgs.aM(2, this.fps);
      paramVarArgs.aM(3, this.gGo);
      paramVarArgs.aM(4, this.LqL);
      paramVarArgs.aM(5, this.dYT);
      paramVarArgs.aM(6, this.width);
      paramVarArgs.aM(7, this.height);
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.gGn);
      int i = g.a.a.b.b.a.bu(2, this.fps);
      int j = g.a.a.b.b.a.bu(3, this.gGo);
      int k = g.a.a.b.b.a.bu(4, this.LqL);
      int m = g.a.a.b.b.a.bu(5, this.dYT);
      int n = g.a.a.b.b.a.bu(6, this.width);
      int i1 = g.a.a.b.b.a.bu(7, this.height);
      AppMethodBeat.o(90965);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(90965);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ahb localahb = (ahb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90965);
        return -1;
      case 1: 
        localahb.gGn = locala.UbS.zi();
        AppMethodBeat.o(90965);
        return 0;
      case 2: 
        localahb.fps = locala.UbS.zi();
        AppMethodBeat.o(90965);
        return 0;
      case 3: 
        localahb.gGo = locala.UbS.zi();
        AppMethodBeat.o(90965);
        return 0;
      case 4: 
        localahb.LqL = locala.UbS.zi();
        AppMethodBeat.o(90965);
        return 0;
      case 5: 
        localahb.dYT = locala.UbS.zi();
        AppMethodBeat.o(90965);
        return 0;
      case 6: 
        localahb.width = locala.UbS.zi();
        AppMethodBeat.o(90965);
        return 0;
      }
      localahb.height = locala.UbS.zi();
      AppMethodBeat.o(90965);
      return 0;
    }
    AppMethodBeat.o(90965);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahb
 * JD-Core Version:    0.7.0.1
 */