package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dte
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b LrK;
  public int MVl;
  public int MVm;
  public int MVn;
  public int MVo;
  public int MVp;
  public int MVq;
  public int MVr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32425);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LrK == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.MVl);
      paramVarArgs.aM(2, this.MVm);
      paramVarArgs.aM(3, this.MVn);
      paramVarArgs.aM(4, this.MVo);
      paramVarArgs.aM(5, this.MVp);
      paramVarArgs.aM(6, this.MVq);
      paramVarArgs.aM(7, this.MVr);
      if (this.LrK != null) {
        paramVarArgs.c(8, this.LrK);
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MVl) + 0 + g.a.a.b.b.a.bu(2, this.MVm) + g.a.a.b.b.a.bu(3, this.MVn) + g.a.a.b.b.a.bu(4, this.MVo) + g.a.a.b.b.a.bu(5, this.MVp) + g.a.a.b.b.a.bu(6, this.MVq) + g.a.a.b.b.a.bu(7, this.MVr);
      paramInt = i;
      if (this.LrK != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.LrK);
      }
      AppMethodBeat.o(32425);
      return paramInt;
    }
    g.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(locala); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(locala)) {
        if (!super.populateBuilderWithField(locala, this, paramInt)) {
          locala.hPl();
        }
      }
      if (paramVarArgs == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (g.a.a.a.a)paramVarArgs[0];
      dte localdte = (dte)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32425);
        return -1;
      case 1: 
        localdte.MVl = locala.UbS.zi();
        AppMethodBeat.o(32425);
        return 0;
      case 2: 
        localdte.MVm = locala.UbS.zi();
        AppMethodBeat.o(32425);
        return 0;
      case 3: 
        localdte.MVn = locala.UbS.zi();
        AppMethodBeat.o(32425);
        return 0;
      case 4: 
        localdte.MVo = locala.UbS.zi();
        AppMethodBeat.o(32425);
        return 0;
      case 5: 
        localdte.MVp = locala.UbS.zi();
        AppMethodBeat.o(32425);
        return 0;
      case 6: 
        localdte.MVq = locala.UbS.zi();
        AppMethodBeat.o(32425);
        return 0;
      case 7: 
        localdte.MVr = locala.UbS.zi();
        AppMethodBeat.o(32425);
        return 0;
      }
      localdte.LrK = locala.UbS.hPo();
      AppMethodBeat.o(32425);
      return 0;
    }
    AppMethodBeat.o(32425);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dte
 * JD-Core Version:    0.7.0.1
 */