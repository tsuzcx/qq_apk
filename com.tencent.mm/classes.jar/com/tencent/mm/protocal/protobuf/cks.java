package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cks
  extends com.tencent.mm.bw.a
{
  public int Lqz;
  public String Mqc;
  public String Mqd;
  public String Mqe;
  public String Mqf;
  public int Mqg;
  public String Mqh;
  public int Mqi;
  public int Mqj;
  public String Mqk;
  public int Mql;
  public int Mqm;
  public String Mqn;
  public int Mqo;
  public int Mqp;
  public String Mqq;
  public String Mqr;
  public String Mqs;
  public String Mqt;
  public String dNI;
  public String qGA;
  public int qGD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152627);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.Mqc != null) {
        paramVarArgs.e(20, this.Mqc);
      }
      if (this.Mqd != null) {
        paramVarArgs.e(21, this.Mqd);
      }
      if (this.Mqe != null) {
        paramVarArgs.e(22, this.Mqe);
      }
      if (this.Mqf != null) {
        paramVarArgs.e(23, this.Mqf);
      }
      if (this.qGA != null) {
        paramVarArgs.e(31, this.qGA);
      }
      paramVarArgs.aM(32, this.qGD);
      paramVarArgs.aM(33, this.Mqg);
      if (this.Mqh != null) {
        paramVarArgs.e(34, this.Mqh);
      }
      paramVarArgs.aM(35, this.Mqi);
      paramVarArgs.aM(36, this.Mqj);
      if (this.Mqk != null) {
        paramVarArgs.e(37, this.Mqk);
      }
      paramVarArgs.aM(38, this.Mql);
      paramVarArgs.aM(39, this.Mqm);
      if (this.Mqn != null) {
        paramVarArgs.e(41, this.Mqn);
      }
      paramVarArgs.aM(200, this.Mqo);
      paramVarArgs.aM(201, this.Mqp);
      paramVarArgs.aM(202, this.Lqz);
      if (this.Mqq != null) {
        paramVarArgs.e(203, this.Mqq);
      }
      if (this.Mqr != null) {
        paramVarArgs.e(204, this.Mqr);
      }
      if (this.Mqs != null) {
        paramVarArgs.e(205, this.Mqs);
      }
      if (this.Mqt != null) {
        paramVarArgs.e(206, this.Mqt);
      }
      AppMethodBeat.o(152627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label1462;
      }
    }
    label1462:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mqc != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.Mqc);
      }
      i = paramInt;
      if (this.Mqd != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.Mqd);
      }
      paramInt = i;
      if (this.Mqe != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.Mqe);
      }
      i = paramInt;
      if (this.Mqf != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.Mqf);
      }
      paramInt = i;
      if (this.qGA != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.qGA);
      }
      i = paramInt + g.a.a.b.b.a.bu(32, this.qGD) + g.a.a.b.b.a.bu(33, this.Mqg);
      paramInt = i;
      if (this.Mqh != null) {
        paramInt = i + g.a.a.b.b.a.f(34, this.Mqh);
      }
      i = paramInt + g.a.a.b.b.a.bu(35, this.Mqi) + g.a.a.b.b.a.bu(36, this.Mqj);
      paramInt = i;
      if (this.Mqk != null) {
        paramInt = i + g.a.a.b.b.a.f(37, this.Mqk);
      }
      i = paramInt + g.a.a.b.b.a.bu(38, this.Mql) + g.a.a.b.b.a.bu(39, this.Mqm);
      paramInt = i;
      if (this.Mqn != null) {
        paramInt = i + g.a.a.b.b.a.f(41, this.Mqn);
      }
      i = paramInt + g.a.a.b.b.a.bu(200, this.Mqo) + g.a.a.b.b.a.bu(201, this.Mqp) + g.a.a.b.b.a.bu(202, this.Lqz);
      paramInt = i;
      if (this.Mqq != null) {
        paramInt = i + g.a.a.b.b.a.f(203, this.Mqq);
      }
      i = paramInt;
      if (this.Mqr != null) {
        i = paramInt + g.a.a.b.b.a.f(204, this.Mqr);
      }
      paramInt = i;
      if (this.Mqs != null) {
        paramInt = i + g.a.a.b.b.a.f(205, this.Mqs);
      }
      i = paramInt;
      if (this.Mqt != null) {
        i = paramInt + g.a.a.b.b.a.f(206, this.Mqt);
      }
      AppMethodBeat.o(152627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152627);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cks localcks = (cks)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152627);
          return -1;
        case 1: 
          localcks.dNI = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 20: 
          localcks.Mqc = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 21: 
          localcks.Mqd = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 22: 
          localcks.Mqe = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 23: 
          localcks.Mqf = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 31: 
          localcks.qGA = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 32: 
          localcks.qGD = locala.UbS.zi();
          AppMethodBeat.o(152627);
          return 0;
        case 33: 
          localcks.Mqg = locala.UbS.zi();
          AppMethodBeat.o(152627);
          return 0;
        case 34: 
          localcks.Mqh = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 35: 
          localcks.Mqi = locala.UbS.zi();
          AppMethodBeat.o(152627);
          return 0;
        case 36: 
          localcks.Mqj = locala.UbS.zi();
          AppMethodBeat.o(152627);
          return 0;
        case 37: 
          localcks.Mqk = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 38: 
          localcks.Mql = locala.UbS.zi();
          AppMethodBeat.o(152627);
          return 0;
        case 39: 
          localcks.Mqm = locala.UbS.zi();
          AppMethodBeat.o(152627);
          return 0;
        case 41: 
          localcks.Mqn = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 200: 
          localcks.Mqo = locala.UbS.zi();
          AppMethodBeat.o(152627);
          return 0;
        case 201: 
          localcks.Mqp = locala.UbS.zi();
          AppMethodBeat.o(152627);
          return 0;
        case 202: 
          localcks.Lqz = locala.UbS.zi();
          AppMethodBeat.o(152627);
          return 0;
        case 203: 
          localcks.Mqq = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 204: 
          localcks.Mqr = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 205: 
          localcks.Mqs = locala.UbS.readString();
          AppMethodBeat.o(152627);
          return 0;
        }
        localcks.Mqt = locala.UbS.readString();
        AppMethodBeat.o(152627);
        return 0;
      }
      AppMethodBeat.o(152627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cks
 * JD-Core Version:    0.7.0.1
 */