package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acb
  extends com.tencent.mm.bw.a
{
  public int Brl;
  public int KTf;
  public int LmE;
  public int oTW;
  public int xKb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124478);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Brl);
      paramVarArgs.aM(2, this.xKb);
      paramVarArgs.aM(3, this.LmE);
      paramVarArgs.aM(4, this.oTW);
      paramVarArgs.aM(5, this.KTf);
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Brl);
      int i = g.a.a.b.b.a.bu(2, this.xKb);
      int j = g.a.a.b.b.a.bu(3, this.LmE);
      int k = g.a.a.b.b.a.bu(4, this.oTW);
      int m = g.a.a.b.b.a.bu(5, this.KTf);
      AppMethodBeat.o(124478);
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
      AppMethodBeat.o(124478);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      acb localacb = (acb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124478);
        return -1;
      case 1: 
        localacb.Brl = locala.UbS.zi();
        AppMethodBeat.o(124478);
        return 0;
      case 2: 
        localacb.xKb = locala.UbS.zi();
        AppMethodBeat.o(124478);
        return 0;
      case 3: 
        localacb.LmE = locala.UbS.zi();
        AppMethodBeat.o(124478);
        return 0;
      case 4: 
        localacb.oTW = locala.UbS.zi();
        AppMethodBeat.o(124478);
        return 0;
      }
      localacb.KTf = locala.UbS.zi();
      AppMethodBeat.o(124478);
      return 0;
    }
    AppMethodBeat.o(124478);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acb
 * JD-Core Version:    0.7.0.1
 */