package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apf
  extends com.tencent.mm.cd.a
{
  public long Rwe;
  public String SCA;
  public int SCB;
  public String SCC;
  public long SCD;
  public String SCE;
  public String SCF;
  public long SCG;
  public boolean SCl;
  public String SCm;
  public String SCn;
  public long SCo;
  public boolean SCp;
  public String SCq;
  public String SCr;
  public String SCs;
  public int SCt;
  public String SCu;
  public String SCv;
  public String SCw;
  public String SCx;
  public String SCy;
  public int SCz;
  public String appId;
  public String filePath;
  public String jmx;
  public boolean orn;
  public String processName;
  public int scene;
  public int tNG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205490);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.SCl);
      if (this.filePath != null) {
        paramVarArgs.f(2, this.filePath);
      }
      if (this.jmx != null) {
        paramVarArgs.f(3, this.jmx);
      }
      if (this.appId != null) {
        paramVarArgs.f(4, this.appId);
      }
      if (this.processName != null) {
        paramVarArgs.f(5, this.processName);
      }
      paramVarArgs.aY(6, this.tNG);
      paramVarArgs.co(7, this.orn);
      paramVarArgs.bm(8, this.Rwe);
      if (this.SCm != null) {
        paramVarArgs.f(9, this.SCm);
      }
      if (this.SCn != null) {
        paramVarArgs.f(10, this.SCn);
      }
      paramVarArgs.bm(11, this.SCo);
      paramVarArgs.co(12, this.SCp);
      paramVarArgs.aY(13, this.scene);
      if (this.SCq != null) {
        paramVarArgs.f(14, this.SCq);
      }
      if (this.SCr != null) {
        paramVarArgs.f(15, this.SCr);
      }
      if (this.SCs != null) {
        paramVarArgs.f(16, this.SCs);
      }
      paramVarArgs.aY(17, this.SCt);
      if (this.SCu != null) {
        paramVarArgs.f(18, this.SCu);
      }
      if (this.SCv != null) {
        paramVarArgs.f(19, this.SCv);
      }
      if (this.SCw != null) {
        paramVarArgs.f(20, this.SCw);
      }
      if (this.SCx != null) {
        paramVarArgs.f(21, this.SCx);
      }
      if (this.SCy != null) {
        paramVarArgs.f(22, this.SCy);
      }
      paramVarArgs.aY(23, this.SCz);
      if (this.SCA != null) {
        paramVarArgs.f(24, this.SCA);
      }
      paramVarArgs.aY(25, this.SCB);
      if (this.SCC != null) {
        paramVarArgs.f(26, this.SCC);
      }
      paramVarArgs.bm(27, this.SCD);
      if (this.SCE != null) {
        paramVarArgs.f(28, this.SCE);
      }
      if (this.SCF != null) {
        paramVarArgs.f(29, this.SCF);
      }
      paramVarArgs.bm(30, this.SCG);
      AppMethodBeat.o(205490);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0;
      paramInt = i;
      if (this.filePath != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.filePath);
      }
      i = paramInt;
      if (this.jmx != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jmx);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.appId);
      }
      i = paramInt;
      if (this.processName != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.processName);
      }
      i = i + g.a.a.b.b.a.bM(6, this.tNG) + (g.a.a.b.b.a.gL(7) + 1) + g.a.a.b.b.a.p(8, this.Rwe);
      paramInt = i;
      if (this.SCm != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.SCm);
      }
      i = paramInt;
      if (this.SCn != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.SCn);
      }
      i = i + g.a.a.b.b.a.p(11, this.SCo) + (g.a.a.b.b.a.gL(12) + 1) + g.a.a.b.b.a.bM(13, this.scene);
      paramInt = i;
      if (this.SCq != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.SCq);
      }
      i = paramInt;
      if (this.SCr != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.SCr);
      }
      paramInt = i;
      if (this.SCs != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.SCs);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.SCt);
      paramInt = i;
      if (this.SCu != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.SCu);
      }
      i = paramInt;
      if (this.SCv != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.SCv);
      }
      paramInt = i;
      if (this.SCw != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.SCw);
      }
      i = paramInt;
      if (this.SCx != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.SCx);
      }
      paramInt = i;
      if (this.SCy != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.SCy);
      }
      i = paramInt + g.a.a.b.b.a.bM(23, this.SCz);
      paramInt = i;
      if (this.SCA != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.SCA);
      }
      i = paramInt + g.a.a.b.b.a.bM(25, this.SCB);
      paramInt = i;
      if (this.SCC != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.SCC);
      }
      i = paramInt + g.a.a.b.b.a.p(27, this.SCD);
      paramInt = i;
      if (this.SCE != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.SCE);
      }
      i = paramInt;
      if (this.SCF != null) {
        i = paramInt + g.a.a.b.b.a.g(29, this.SCF);
      }
      paramInt = g.a.a.b.b.a.p(30, this.SCG);
      AppMethodBeat.o(205490);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(205490);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      apf localapf = (apf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(205490);
        return -1;
      case 1: 
        localapf.SCl = locala.abFh.AB();
        AppMethodBeat.o(205490);
        return 0;
      case 2: 
        localapf.filePath = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 3: 
        localapf.jmx = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 4: 
        localapf.appId = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 5: 
        localapf.processName = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 6: 
        localapf.tNG = locala.abFh.AK();
        AppMethodBeat.o(205490);
        return 0;
      case 7: 
        localapf.orn = locala.abFh.AB();
        AppMethodBeat.o(205490);
        return 0;
      case 8: 
        localapf.Rwe = locala.abFh.AN();
        AppMethodBeat.o(205490);
        return 0;
      case 9: 
        localapf.SCm = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 10: 
        localapf.SCn = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 11: 
        localapf.SCo = locala.abFh.AN();
        AppMethodBeat.o(205490);
        return 0;
      case 12: 
        localapf.SCp = locala.abFh.AB();
        AppMethodBeat.o(205490);
        return 0;
      case 13: 
        localapf.scene = locala.abFh.AK();
        AppMethodBeat.o(205490);
        return 0;
      case 14: 
        localapf.SCq = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 15: 
        localapf.SCr = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 16: 
        localapf.SCs = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 17: 
        localapf.SCt = locala.abFh.AK();
        AppMethodBeat.o(205490);
        return 0;
      case 18: 
        localapf.SCu = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 19: 
        localapf.SCv = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 20: 
        localapf.SCw = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 21: 
        localapf.SCx = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 22: 
        localapf.SCy = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 23: 
        localapf.SCz = locala.abFh.AK();
        AppMethodBeat.o(205490);
        return 0;
      case 24: 
        localapf.SCA = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 25: 
        localapf.SCB = locala.abFh.AK();
        AppMethodBeat.o(205490);
        return 0;
      case 26: 
        localapf.SCC = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 27: 
        localapf.SCD = locala.abFh.AN();
        AppMethodBeat.o(205490);
        return 0;
      case 28: 
        localapf.SCE = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      case 29: 
        localapf.SCF = locala.abFh.readString();
        AppMethodBeat.o(205490);
        return 0;
      }
      localapf.SCG = locala.abFh.AN();
      AppMethodBeat.o(205490);
      return 0;
    }
    AppMethodBeat.o(205490);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apf
 * JD-Core Version:    0.7.0.1
 */