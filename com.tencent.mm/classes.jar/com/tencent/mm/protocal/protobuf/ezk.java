package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezk
  extends com.tencent.mm.cd.a
{
  public String CNj;
  public String CQz;
  public String RMK;
  public String SpT;
  public String TQB;
  public String TpL;
  public long UzL;
  public String rVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32491);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SpT != null) {
        paramVarArgs.f(1, this.SpT);
      }
      if (this.RMK != null) {
        paramVarArgs.f(2, this.RMK);
      }
      if (this.TQB != null) {
        paramVarArgs.f(3, this.TQB);
      }
      if (this.CQz != null) {
        paramVarArgs.f(4, this.CQz);
      }
      if (this.rVG != null) {
        paramVarArgs.f(5, this.rVG);
      }
      if (this.CNj != null) {
        paramVarArgs.f(6, this.CNj);
      }
      if (this.TpL != null) {
        paramVarArgs.f(7, this.TpL);
      }
      paramVarArgs.bm(8, this.UzL);
      AppMethodBeat.o(32491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SpT == null) {
        break label640;
      }
    }
    label640:
    for (int i = g.a.a.b.b.a.g(1, this.SpT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RMK != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RMK);
      }
      i = paramInt;
      if (this.TQB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TQB);
      }
      paramInt = i;
      if (this.CQz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CQz);
      }
      i = paramInt;
      if (this.rVG != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.rVG);
      }
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CNj);
      }
      i = paramInt;
      if (this.TpL != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TpL);
      }
      paramInt = g.a.a.b.b.a.p(8, this.UzL);
      AppMethodBeat.o(32491);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32491);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezk localezk = (ezk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32491);
          return -1;
        case 1: 
          localezk.SpT = locala.abFh.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 2: 
          localezk.RMK = locala.abFh.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 3: 
          localezk.TQB = locala.abFh.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 4: 
          localezk.CQz = locala.abFh.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 5: 
          localezk.rVG = locala.abFh.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 6: 
          localezk.CNj = locala.abFh.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 7: 
          localezk.TpL = locala.abFh.readString();
          AppMethodBeat.o(32491);
          return 0;
        }
        localezk.UzL = locala.abFh.AN();
        AppMethodBeat.o(32491);
        return 0;
      }
      AppMethodBeat.o(32491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezk
 * JD-Core Version:    0.7.0.1
 */