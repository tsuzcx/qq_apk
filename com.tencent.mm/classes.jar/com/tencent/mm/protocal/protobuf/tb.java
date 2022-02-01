package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tb
  extends com.tencent.mm.bw.a
{
  public int Lbc;
  public int Lbd;
  public int Lbe;
  public int Lbf;
  public int Lbg;
  public int Lbh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133161);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lbc);
      paramVarArgs.aM(2, this.Lbd);
      paramVarArgs.aM(3, this.Lbe);
      paramVarArgs.aM(4, this.Lbf);
      paramVarArgs.aM(5, this.Lbg);
      paramVarArgs.aM(6, this.Lbh);
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Lbc);
      int i = g.a.a.b.b.a.bu(2, this.Lbd);
      int j = g.a.a.b.b.a.bu(3, this.Lbe);
      int k = g.a.a.b.b.a.bu(4, this.Lbf);
      int m = g.a.a.b.b.a.bu(5, this.Lbg);
      int n = g.a.a.b.b.a.bu(6, this.Lbh);
      AppMethodBeat.o(133161);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      tb localtb = (tb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133161);
        return -1;
      case 1: 
        localtb.Lbc = locala.UbS.zi();
        AppMethodBeat.o(133161);
        return 0;
      case 2: 
        localtb.Lbd = locala.UbS.zi();
        AppMethodBeat.o(133161);
        return 0;
      case 3: 
        localtb.Lbe = locala.UbS.zi();
        AppMethodBeat.o(133161);
        return 0;
      case 4: 
        localtb.Lbf = locala.UbS.zi();
        AppMethodBeat.o(133161);
        return 0;
      case 5: 
        localtb.Lbg = locala.UbS.zi();
        AppMethodBeat.o(133161);
        return 0;
      }
      localtb.Lbh = locala.UbS.zi();
      AppMethodBeat.o(133161);
      return 0;
    }
    AppMethodBeat.o(133161);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tb
 * JD-Core Version:    0.7.0.1
 */