package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crg
  extends com.tencent.mm.cd.a
{
  public String Izj;
  public String SjI;
  public String SjJ;
  public String Tav;
  public String UserName;
  public int rVU;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155433);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Izj != null) {
        paramVarArgs.f(1, this.Izj);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      paramVarArgs.aY(3, this.rVU);
      if (this.SjI != null) {
        paramVarArgs.f(4, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(5, this.SjJ);
      }
      if (this.rWI != null) {
        paramVarArgs.f(6, this.rWI);
      }
      if (this.Tav != null) {
        paramVarArgs.f(7, this.Tav);
      }
      AppMethodBeat.o(155433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Izj == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.b.b.a.g(1, this.Izj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UserName);
      }
      i += g.a.a.b.b.a.bM(3, this.rVU);
      paramInt = i;
      if (this.SjI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SjI);
      }
      i = paramInt;
      if (this.SjJ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SjJ);
      }
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.rWI);
      }
      i = paramInt;
      if (this.Tav != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Tav);
      }
      AppMethodBeat.o(155433);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155433);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        crg localcrg = (crg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155433);
          return -1;
        case 1: 
          localcrg.Izj = locala.abFh.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 2: 
          localcrg.UserName = locala.abFh.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 3: 
          localcrg.rVU = locala.abFh.AK();
          AppMethodBeat.o(155433);
          return 0;
        case 4: 
          localcrg.SjI = locala.abFh.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 5: 
          localcrg.SjJ = locala.abFh.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 6: 
          localcrg.rWI = locala.abFh.readString();
          AppMethodBeat.o(155433);
          return 0;
        }
        localcrg.Tav = locala.abFh.readString();
        AppMethodBeat.o(155433);
        return 0;
      }
      AppMethodBeat.o(155433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crg
 * JD-Core Version:    0.7.0.1
 */