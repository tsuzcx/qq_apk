package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqe
  extends com.tencent.mm.cd.a
{
  public String RTS;
  public LinkedList<String> RVG;
  public int RVf;
  public long RXN;
  public String SwF;
  public String UsB;
  
  public eqe()
  {
    AppMethodBeat.i(124560);
    this.RVG = new LinkedList();
    AppMethodBeat.o(124560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124561);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RXN);
      if (this.RTS != null) {
        paramVarArgs.f(2, this.RTS);
      }
      paramVarArgs.e(3, 1, this.RVG);
      if (this.SwF != null) {
        paramVarArgs.f(4, this.SwF);
      }
      if (this.UsB != null) {
        paramVarArgs.f(5, this.UsB);
      }
      paramVarArgs.aY(6, this.RVf);
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.RXN) + 0;
      paramInt = i;
      if (this.RTS != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RTS);
      }
      i = paramInt + g.a.a.a.c(3, 1, this.RVG);
      paramInt = i;
      if (this.SwF != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SwF);
      }
      i = paramInt;
      if (this.UsB != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UsB);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.RVf);
      AppMethodBeat.o(124561);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RVG.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124561);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eqe localeqe = (eqe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124561);
        return -1;
      case 1: 
        localeqe.RXN = locala.abFh.AN();
        AppMethodBeat.o(124561);
        return 0;
      case 2: 
        localeqe.RTS = locala.abFh.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 3: 
        localeqe.RVG.add(locala.abFh.readString());
        AppMethodBeat.o(124561);
        return 0;
      case 4: 
        localeqe.SwF = locala.abFh.readString();
        AppMethodBeat.o(124561);
        return 0;
      case 5: 
        localeqe.UsB = locala.abFh.readString();
        AppMethodBeat.o(124561);
        return 0;
      }
      localeqe.RVf = locala.abFh.AK();
      AppMethodBeat.o(124561);
      return 0;
    }
    AppMethodBeat.o(124561);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqe
 * JD-Core Version:    0.7.0.1
 */