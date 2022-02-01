package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eqc
  extends com.tencent.mm.cd.a
{
  public int CreateTime;
  public int RIs;
  public String RTi;
  public String RTk;
  public String RTm;
  public String RTn;
  public String RTo;
  public String RTv;
  public int RTw;
  public int RTx;
  public int RTy;
  public long RXE;
  public String RXH;
  public int RXI;
  public String fwr;
  public int lpx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RIs);
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.RTi != null) {
        paramVarArgs.f(3, this.RTi);
      }
      if (this.RTk != null) {
        paramVarArgs.f(6, this.RTk);
      }
      if (this.RTm != null) {
        paramVarArgs.f(8, this.RTm);
      }
      if (this.RTn != null) {
        paramVarArgs.f(9, this.RTn);
      }
      if (this.RTo != null) {
        paramVarArgs.f(10, this.RTo);
      }
      paramVarArgs.aY(11, this.lpx);
      if (this.RTv != null) {
        paramVarArgs.f(15, this.RTv);
      }
      paramVarArgs.aY(16, this.RTw);
      paramVarArgs.aY(17, this.RTx);
      paramVarArgs.aY(18, this.RTy);
      paramVarArgs.aY(19, this.CreateTime);
      paramVarArgs.bm(20, this.RXE);
      if (this.RXH != null) {
        paramVarArgs.f(21, this.RXH);
      }
      paramVarArgs.aY(22, this.RXI);
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RIs) + 0;
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.RTi != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RTi);
      }
      paramInt = i;
      if (this.RTk != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RTk);
      }
      i = paramInt;
      if (this.RTm != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RTm);
      }
      paramInt = i;
      if (this.RTn != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RTn);
      }
      i = paramInt;
      if (this.RTo != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.RTo);
      }
      i += g.a.a.b.b.a.bM(11, this.lpx);
      paramInt = i;
      if (this.RTv != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.RTv);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.RTw) + g.a.a.b.b.a.bM(17, this.RTx) + g.a.a.b.b.a.bM(18, this.RTy) + g.a.a.b.b.a.bM(19, this.CreateTime) + g.a.a.b.b.a.p(20, this.RXE);
      paramInt = i;
      if (this.RXH != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.RXH);
      }
      i = g.a.a.b.b.a.bM(22, this.RXI);
      AppMethodBeat.o(124558);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(124558);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eqc localeqc = (eqc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 4: 
      case 5: 
      case 7: 
      case 12: 
      case 13: 
      case 14: 
      default: 
        AppMethodBeat.o(124558);
        return -1;
      case 1: 
        localeqc.RIs = locala.abFh.AK();
        AppMethodBeat.o(124558);
        return 0;
      case 2: 
        localeqc.fwr = locala.abFh.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 3: 
        localeqc.RTi = locala.abFh.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 6: 
        localeqc.RTk = locala.abFh.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 8: 
        localeqc.RTm = locala.abFh.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 9: 
        localeqc.RTn = locala.abFh.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 10: 
        localeqc.RTo = locala.abFh.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 11: 
        localeqc.lpx = locala.abFh.AK();
        AppMethodBeat.o(124558);
        return 0;
      case 15: 
        localeqc.RTv = locala.abFh.readString();
        AppMethodBeat.o(124558);
        return 0;
      case 16: 
        localeqc.RTw = locala.abFh.AK();
        AppMethodBeat.o(124558);
        return 0;
      case 17: 
        localeqc.RTx = locala.abFh.AK();
        AppMethodBeat.o(124558);
        return 0;
      case 18: 
        localeqc.RTy = locala.abFh.AK();
        AppMethodBeat.o(124558);
        return 0;
      case 19: 
        localeqc.CreateTime = locala.abFh.AK();
        AppMethodBeat.o(124558);
        return 0;
      case 20: 
        localeqc.RXE = locala.abFh.AN();
        AppMethodBeat.o(124558);
        return 0;
      case 21: 
        localeqc.RXH = locala.abFh.readString();
        AppMethodBeat.o(124558);
        return 0;
      }
      localeqc.RXI = locala.abFh.AK();
      AppMethodBeat.o(124558);
      return 0;
    }
    AppMethodBeat.o(124558);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqc
 * JD-Core Version:    0.7.0.1
 */