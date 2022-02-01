package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public int KAX;
  public int KAY;
  public int KAZ;
  public int KBa;
  public int KBb;
  public int KBc;
  public int KBd;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143955);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.KAX);
      paramVarArgs.aM(2, this.action);
      paramVarArgs.aM(3, this.KAY);
      paramVarArgs.aM(4, this.KAZ);
      paramVarArgs.aM(5, this.KBa);
      paramVarArgs.aM(6, this.KBb);
      paramVarArgs.aM(7, this.KBc);
      paramVarArgs.aM(8, this.KBd);
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.KAX);
      int i = g.a.a.b.b.a.bu(2, this.action);
      int j = g.a.a.b.b.a.bu(3, this.KAY);
      int k = g.a.a.b.b.a.bu(4, this.KAZ);
      int m = g.a.a.b.b.a.bu(5, this.KBa);
      int n = g.a.a.b.b.a.bu(6, this.KBb);
      int i1 = g.a.a.b.b.a.bu(7, this.KBc);
      int i2 = g.a.a.b.b.a.bu(8, this.KBd);
      AppMethodBeat.o(143955);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143955);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143955);
        return -1;
      case 1: 
        locall.KAX = locala.UbS.zi();
        AppMethodBeat.o(143955);
        return 0;
      case 2: 
        locall.action = locala.UbS.zi();
        AppMethodBeat.o(143955);
        return 0;
      case 3: 
        locall.KAY = locala.UbS.zi();
        AppMethodBeat.o(143955);
        return 0;
      case 4: 
        locall.KAZ = locala.UbS.zi();
        AppMethodBeat.o(143955);
        return 0;
      case 5: 
        locall.KBa = locala.UbS.zi();
        AppMethodBeat.o(143955);
        return 0;
      case 6: 
        locall.KBb = locala.UbS.zi();
        AppMethodBeat.o(143955);
        return 0;
      case 7: 
        locall.KBc = locala.UbS.zi();
        AppMethodBeat.o(143955);
        return 0;
      }
      locall.KBd = locala.UbS.zi();
      AppMethodBeat.o(143955);
      return 0;
    }
    AppMethodBeat.o(143955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.l
 * JD-Core Version:    0.7.0.1
 */