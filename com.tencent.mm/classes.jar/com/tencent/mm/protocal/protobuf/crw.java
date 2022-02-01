package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class crw
  extends com.tencent.mm.cd.a
{
  public String TyF;
  public int Tzj;
  public int Tzk;
  public int Tzl;
  public b Tzm;
  public b Tzn;
  public b Tzo;
  public String Tzp;
  public long Tzq;
  public long Tzr;
  public String Tzs;
  public long klE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(253375);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Tzj);
      if (this.TyF != null) {
        paramVarArgs.f(2, this.TyF);
      }
      paramVarArgs.aY(3, this.Tzk);
      paramVarArgs.aY(4, this.Tzl);
      if (this.Tzm != null) {
        paramVarArgs.c(5, this.Tzm);
      }
      if (this.Tzn != null) {
        paramVarArgs.c(6, this.Tzn);
      }
      if (this.Tzo != null) {
        paramVarArgs.c(7, this.Tzo);
      }
      if (this.Tzp != null) {
        paramVarArgs.f(8, this.Tzp);
      }
      paramVarArgs.bm(9, this.Tzq);
      paramVarArgs.bm(10, this.Tzr);
      paramVarArgs.bm(11, this.klE);
      if (this.Tzs != null) {
        paramVarArgs.f(12, this.Tzs);
      }
      AppMethodBeat.o(253375);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Tzj) + 0;
      paramInt = i;
      if (this.TyF != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TyF);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.Tzk) + g.a.a.b.b.a.bM(4, this.Tzl);
      paramInt = i;
      if (this.Tzm != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.Tzm);
      }
      i = paramInt;
      if (this.Tzn != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.Tzn);
      }
      paramInt = i;
      if (this.Tzo != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.Tzo);
      }
      i = paramInt;
      if (this.Tzp != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Tzp);
      }
      i = i + g.a.a.b.b.a.p(9, this.Tzq) + g.a.a.b.b.a.p(10, this.Tzr) + g.a.a.b.b.a.p(11, this.klE);
      paramInt = i;
      if (this.Tzs != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Tzs);
      }
      AppMethodBeat.o(253375);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(253375);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      crw localcrw = (crw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(253375);
        return -1;
      case 1: 
        localcrw.Tzj = locala.abFh.AK();
        AppMethodBeat.o(253375);
        return 0;
      case 2: 
        localcrw.TyF = locala.abFh.readString();
        AppMethodBeat.o(253375);
        return 0;
      case 3: 
        localcrw.Tzk = locala.abFh.AK();
        AppMethodBeat.o(253375);
        return 0;
      case 4: 
        localcrw.Tzl = locala.abFh.AK();
        AppMethodBeat.o(253375);
        return 0;
      case 5: 
        localcrw.Tzm = locala.abFh.iUw();
        AppMethodBeat.o(253375);
        return 0;
      case 6: 
        localcrw.Tzn = locala.abFh.iUw();
        AppMethodBeat.o(253375);
        return 0;
      case 7: 
        localcrw.Tzo = locala.abFh.iUw();
        AppMethodBeat.o(253375);
        return 0;
      case 8: 
        localcrw.Tzp = locala.abFh.readString();
        AppMethodBeat.o(253375);
        return 0;
      case 9: 
        localcrw.Tzq = locala.abFh.AN();
        AppMethodBeat.o(253375);
        return 0;
      case 10: 
        localcrw.Tzr = locala.abFh.AN();
        AppMethodBeat.o(253375);
        return 0;
      case 11: 
        localcrw.klE = locala.abFh.AN();
        AppMethodBeat.o(253375);
        return 0;
      }
      localcrw.Tzs = locala.abFh.readString();
      AppMethodBeat.o(253375);
      return 0;
    }
    AppMethodBeat.o(253375);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crw
 * JD-Core Version:    0.7.0.1
 */