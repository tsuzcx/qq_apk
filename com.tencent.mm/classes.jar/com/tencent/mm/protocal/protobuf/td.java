package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class td
  extends com.tencent.mm.cd.a
{
  public int Sco;
  public int Scp;
  public int Scq;
  public int Scr;
  public int Scs;
  public int Sct;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133161);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Sco);
      paramVarArgs.aY(2, this.Scp);
      paramVarArgs.aY(3, this.Scq);
      paramVarArgs.aY(4, this.Scr);
      paramVarArgs.aY(5, this.Scs);
      paramVarArgs.aY(6, this.Sct);
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.Sco);
      int i = g.a.a.b.b.a.bM(2, this.Scp);
      int j = g.a.a.b.b.a.bM(3, this.Scq);
      int k = g.a.a.b.b.a.bM(4, this.Scr);
      int m = g.a.a.b.b.a.bM(5, this.Scs);
      int n = g.a.a.b.b.a.bM(6, this.Sct);
      AppMethodBeat.o(133161);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      td localtd = (td)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133161);
        return -1;
      case 1: 
        localtd.Sco = locala.abFh.AK();
        AppMethodBeat.o(133161);
        return 0;
      case 2: 
        localtd.Scp = locala.abFh.AK();
        AppMethodBeat.o(133161);
        return 0;
      case 3: 
        localtd.Scq = locala.abFh.AK();
        AppMethodBeat.o(133161);
        return 0;
      case 4: 
        localtd.Scr = locala.abFh.AK();
        AppMethodBeat.o(133161);
        return 0;
      case 5: 
        localtd.Scs = locala.abFh.AK();
        AppMethodBeat.o(133161);
        return 0;
      }
      localtd.Sct = locala.abFh.AK();
      AppMethodBeat.o(133161);
      return 0;
    }
    AppMethodBeat.o(133161);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.td
 * JD-Core Version:    0.7.0.1
 */