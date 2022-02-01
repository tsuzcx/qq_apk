package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fek
  extends com.tencent.mm.cd.a
{
  public int UDZ;
  public int UEa;
  public int UEb;
  public int UEc;
  public int UEd;
  public int UEe;
  public int UEf;
  public int UEg;
  public int UEh;
  public int UEi;
  public LinkedList<Integer> UEj;
  public int UEk;
  public LinkedList<Integer> UEl;
  public int UEm;
  public LinkedList<Integer> UEn;
  public String UEo;
  public String UEp;
  
  public fek()
  {
    AppMethodBeat.i(115892);
    this.UEj = new LinkedList();
    this.UEl = new LinkedList();
    this.UEn = new LinkedList();
    AppMethodBeat.o(115892);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115893);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UDZ);
      paramVarArgs.aY(2, this.UEa);
      paramVarArgs.aY(3, this.UEb);
      paramVarArgs.aY(4, this.UEc);
      paramVarArgs.aY(5, this.UEd);
      paramVarArgs.aY(6, this.UEe);
      paramVarArgs.aY(7, this.UEf);
      paramVarArgs.aY(8, this.UEg);
      paramVarArgs.aY(9, this.UEh);
      paramVarArgs.aY(10, this.UEi);
      paramVarArgs.e(11, 2, this.UEj);
      paramVarArgs.aY(12, this.UEk);
      paramVarArgs.e(13, 2, this.UEl);
      paramVarArgs.aY(14, this.UEm);
      paramVarArgs.e(15, 2, this.UEn);
      if (this.UEo != null) {
        paramVarArgs.f(16, this.UEo);
      }
      if (this.UEp != null) {
        paramVarArgs.f(17, this.UEp);
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.UDZ) + 0 + g.a.a.b.b.a.bM(2, this.UEa) + g.a.a.b.b.a.bM(3, this.UEb) + g.a.a.b.b.a.bM(4, this.UEc) + g.a.a.b.b.a.bM(5, this.UEd) + g.a.a.b.b.a.bM(6, this.UEe) + g.a.a.b.b.a.bM(7, this.UEf) + g.a.a.b.b.a.bM(8, this.UEg) + g.a.a.b.b.a.bM(9, this.UEh) + g.a.a.b.b.a.bM(10, this.UEi) + g.a.a.a.c(11, 2, this.UEj) + g.a.a.b.b.a.bM(12, this.UEk) + g.a.a.a.c(13, 2, this.UEl) + g.a.a.b.b.a.bM(14, this.UEm) + g.a.a.a.c(15, 2, this.UEn);
      paramInt = i;
      if (this.UEo != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.UEo);
      }
      i = paramInt;
      if (this.UEp != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.UEp);
      }
      AppMethodBeat.o(115893);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UEj.clear();
      this.UEl.clear();
      this.UEn.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fek localfek = (fek)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115893);
        return -1;
      case 1: 
        localfek.UDZ = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 2: 
        localfek.UEa = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 3: 
        localfek.UEb = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 4: 
        localfek.UEc = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 5: 
        localfek.UEd = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 6: 
        localfek.UEe = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 7: 
        localfek.UEf = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 8: 
        localfek.UEg = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 9: 
        localfek.UEh = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 10: 
        localfek.UEi = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 11: 
        localfek.UEj.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(115893);
        return 0;
      case 12: 
        localfek.UEk = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 13: 
        localfek.UEl.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(115893);
        return 0;
      case 14: 
        localfek.UEm = locala.abFh.AK();
        AppMethodBeat.o(115893);
        return 0;
      case 15: 
        localfek.UEn.add(Integer.valueOf(locala.abFh.AK()));
        AppMethodBeat.o(115893);
        return 0;
      case 16: 
        localfek.UEo = locala.abFh.readString();
        AppMethodBeat.o(115893);
        return 0;
      }
      localfek.UEp = locala.abFh.readString();
      AppMethodBeat.o(115893);
      return 0;
    }
    AppMethodBeat.o(115893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fek
 * JD-Core Version:    0.7.0.1
 */