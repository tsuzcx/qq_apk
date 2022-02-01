package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pe
  extends com.tencent.mm.cd.a
{
  public String CPq;
  public int CreateTime;
  public int RIs;
  public String RTi;
  public int RTj;
  public String RTk;
  public String RTl;
  public String RTm;
  public String RTn;
  public String RTo;
  public String RTp;
  public int RTq;
  public int RTr;
  public String RTv;
  public int RTw;
  public int RTx;
  public int RTy;
  public long RXE;
  public LinkedList<String> RXF;
  public int RXG;
  public String RXH;
  public int RXI;
  public int RXJ;
  public String RXK;
  public String fwr;
  public int lpx;
  public String lpy;
  
  public pe()
  {
    AppMethodBeat.i(207808);
    this.RXF = new LinkedList();
    AppMethodBeat.o(207808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207813);
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
      if (this.lpy != null) {
        paramVarArgs.f(4, this.lpy);
      }
      paramVarArgs.aY(5, this.RTj);
      if (this.RTk != null) {
        paramVarArgs.f(6, this.RTk);
      }
      if (this.RTl != null) {
        paramVarArgs.f(7, this.RTl);
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
      if (this.RTp != null) {
        paramVarArgs.f(12, this.RTp);
      }
      paramVarArgs.aY(13, this.RTq);
      paramVarArgs.aY(14, this.RTr);
      if (this.RTv != null) {
        paramVarArgs.f(15, this.RTv);
      }
      paramVarArgs.aY(16, this.RTw);
      paramVarArgs.aY(17, this.RTx);
      paramVarArgs.aY(18, this.RTy);
      paramVarArgs.aY(19, this.CreateTime);
      paramVarArgs.bm(20, this.RXE);
      paramVarArgs.e(21, 1, this.RXF);
      paramVarArgs.aY(22, this.RXG);
      if (this.CPq != null) {
        paramVarArgs.f(23, this.CPq);
      }
      if (this.RXH != null) {
        paramVarArgs.f(24, this.RXH);
      }
      paramVarArgs.aY(25, this.RXI);
      paramVarArgs.aY(26, this.RXJ);
      if (this.RXK != null) {
        paramVarArgs.f(27, this.RXK);
      }
      AppMethodBeat.o(207813);
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
      if (this.lpy != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lpy);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RTj);
      paramInt = i;
      if (this.RTk != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RTk);
      }
      i = paramInt;
      if (this.RTl != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RTl);
      }
      paramInt = i;
      if (this.RTm != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.RTm);
      }
      i = paramInt;
      if (this.RTn != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RTn);
      }
      paramInt = i;
      if (this.RTo != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RTo);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.lpx);
      paramInt = i;
      if (this.RTp != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.RTp);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.RTq) + g.a.a.b.b.a.bM(14, this.RTr);
      paramInt = i;
      if (this.RTv != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.RTv);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.RTw) + g.a.a.b.b.a.bM(17, this.RTx) + g.a.a.b.b.a.bM(18, this.RTy) + g.a.a.b.b.a.bM(19, this.CreateTime) + g.a.a.b.b.a.p(20, this.RXE) + g.a.a.a.c(21, 1, this.RXF) + g.a.a.b.b.a.bM(22, this.RXG);
      paramInt = i;
      if (this.CPq != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.CPq);
      }
      i = paramInt;
      if (this.RXH != null) {
        i = paramInt + g.a.a.b.b.a.g(24, this.RXH);
      }
      i = i + g.a.a.b.b.a.bM(25, this.RXI) + g.a.a.b.b.a.bM(26, this.RXJ);
      paramInt = i;
      if (this.RXK != null) {
        paramInt = i + g.a.a.b.b.a.g(27, this.RXK);
      }
      AppMethodBeat.o(207813);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RXF.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207813);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      pe localpe = (pe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207813);
        return -1;
      case 1: 
        localpe.RIs = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 2: 
        localpe.fwr = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 3: 
        localpe.RTi = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 4: 
        localpe.lpy = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 5: 
        localpe.RTj = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 6: 
        localpe.RTk = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 7: 
        localpe.RTl = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 8: 
        localpe.RTm = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 9: 
        localpe.RTn = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 10: 
        localpe.RTo = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 11: 
        localpe.lpx = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 12: 
        localpe.RTp = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 13: 
        localpe.RTq = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 14: 
        localpe.RTr = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 15: 
        localpe.RTv = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 16: 
        localpe.RTw = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 17: 
        localpe.RTx = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 18: 
        localpe.RTy = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 19: 
        localpe.CreateTime = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 20: 
        localpe.RXE = locala.abFh.AN();
        AppMethodBeat.o(207813);
        return 0;
      case 21: 
        localpe.RXF.add(locala.abFh.readString());
        AppMethodBeat.o(207813);
        return 0;
      case 22: 
        localpe.RXG = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 23: 
        localpe.CPq = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 24: 
        localpe.RXH = locala.abFh.readString();
        AppMethodBeat.o(207813);
        return 0;
      case 25: 
        localpe.RXI = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      case 26: 
        localpe.RXJ = locala.abFh.AK();
        AppMethodBeat.o(207813);
        return 0;
      }
      localpe.RXK = locala.abFh.readString();
      AppMethodBeat.o(207813);
      return 0;
    }
    AppMethodBeat.o(207813);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pe
 * JD-Core Version:    0.7.0.1
 */