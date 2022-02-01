package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class etz
  extends com.tencent.mm.bw.a
{
  public int Nrd;
  public int Nre;
  public int Nrf;
  public int Nrg;
  public int Nrh;
  public int Nri;
  public int Nrj;
  public int Nrk;
  public int Nrl;
  public int Nrm;
  public LinkedList<Integer> Nrn;
  public int Nro;
  public LinkedList<Integer> Nrp;
  public int Nrq;
  public LinkedList<Integer> Nrr;
  public String Nrs;
  public String Nrt;
  
  public etz()
  {
    AppMethodBeat.i(115892);
    this.Nrn = new LinkedList();
    this.Nrp = new LinkedList();
    this.Nrr = new LinkedList();
    AppMethodBeat.o(115892);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115893);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Nrd);
      paramVarArgs.aM(2, this.Nre);
      paramVarArgs.aM(3, this.Nrf);
      paramVarArgs.aM(4, this.Nrg);
      paramVarArgs.aM(5, this.Nrh);
      paramVarArgs.aM(6, this.Nri);
      paramVarArgs.aM(7, this.Nrj);
      paramVarArgs.aM(8, this.Nrk);
      paramVarArgs.aM(9, this.Nrl);
      paramVarArgs.aM(10, this.Nrm);
      paramVarArgs.e(11, 2, this.Nrn);
      paramVarArgs.aM(12, this.Nro);
      paramVarArgs.e(13, 2, this.Nrp);
      paramVarArgs.aM(14, this.Nrq);
      paramVarArgs.e(15, 2, this.Nrr);
      if (this.Nrs != null) {
        paramVarArgs.e(16, this.Nrs);
      }
      if (this.Nrt != null) {
        paramVarArgs.e(17, this.Nrt);
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Nrd) + 0 + g.a.a.b.b.a.bu(2, this.Nre) + g.a.a.b.b.a.bu(3, this.Nrf) + g.a.a.b.b.a.bu(4, this.Nrg) + g.a.a.b.b.a.bu(5, this.Nrh) + g.a.a.b.b.a.bu(6, this.Nri) + g.a.a.b.b.a.bu(7, this.Nrj) + g.a.a.b.b.a.bu(8, this.Nrk) + g.a.a.b.b.a.bu(9, this.Nrl) + g.a.a.b.b.a.bu(10, this.Nrm) + g.a.a.a.c(11, 2, this.Nrn) + g.a.a.b.b.a.bu(12, this.Nro) + g.a.a.a.c(13, 2, this.Nrp) + g.a.a.b.b.a.bu(14, this.Nrq) + g.a.a.a.c(15, 2, this.Nrr);
      paramInt = i;
      if (this.Nrs != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.Nrs);
      }
      i = paramInt;
      if (this.Nrt != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.Nrt);
      }
      AppMethodBeat.o(115893);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Nrn.clear();
      this.Nrp.clear();
      this.Nrr.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      etz localetz = (etz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115893);
        return -1;
      case 1: 
        localetz.Nrd = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 2: 
        localetz.Nre = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 3: 
        localetz.Nrf = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 4: 
        localetz.Nrg = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 5: 
        localetz.Nrh = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 6: 
        localetz.Nri = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 7: 
        localetz.Nrj = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 8: 
        localetz.Nrk = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 9: 
        localetz.Nrl = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 10: 
        localetz.Nrm = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 11: 
        localetz.Nrn.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(115893);
        return 0;
      case 12: 
        localetz.Nro = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 13: 
        localetz.Nrp.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(115893);
        return 0;
      case 14: 
        localetz.Nrq = locala.UbS.zi();
        AppMethodBeat.o(115893);
        return 0;
      case 15: 
        localetz.Nrr.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(115893);
        return 0;
      case 16: 
        localetz.Nrs = locala.UbS.readString();
        AppMethodBeat.o(115893);
        return 0;
      }
      localetz.Nrt = locala.UbS.readString();
      AppMethodBeat.o(115893);
      return 0;
    }
    AppMethodBeat.o(115893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etz
 * JD-Core Version:    0.7.0.1
 */