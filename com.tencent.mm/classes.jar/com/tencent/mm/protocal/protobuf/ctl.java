package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctl
  extends com.tencent.mm.cd.a
{
  public String TBf;
  public String TBg;
  public String TBh;
  public String TBi;
  public int TBj;
  public String TBk;
  public int TBl;
  public int TBm;
  public String TBn;
  public int TBo;
  public int TBp;
  public String TBq;
  public int TBr;
  public int TBs;
  public String TBt;
  public String TBu;
  public String TBv;
  public String TBw;
  public String appid;
  public int group_id;
  public String ufB;
  public int ufE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152627);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.TBf != null) {
        paramVarArgs.f(20, this.TBf);
      }
      if (this.TBg != null) {
        paramVarArgs.f(21, this.TBg);
      }
      if (this.TBh != null) {
        paramVarArgs.f(22, this.TBh);
      }
      if (this.TBi != null) {
        paramVarArgs.f(23, this.TBi);
      }
      if (this.ufB != null) {
        paramVarArgs.f(31, this.ufB);
      }
      paramVarArgs.aY(32, this.ufE);
      paramVarArgs.aY(33, this.TBj);
      if (this.TBk != null) {
        paramVarArgs.f(34, this.TBk);
      }
      paramVarArgs.aY(35, this.TBl);
      paramVarArgs.aY(36, this.TBm);
      if (this.TBn != null) {
        paramVarArgs.f(37, this.TBn);
      }
      paramVarArgs.aY(38, this.TBo);
      paramVarArgs.aY(39, this.TBp);
      if (this.TBq != null) {
        paramVarArgs.f(41, this.TBq);
      }
      paramVarArgs.aY(200, this.TBr);
      paramVarArgs.aY(201, this.TBs);
      paramVarArgs.aY(202, this.group_id);
      if (this.TBt != null) {
        paramVarArgs.f(203, this.TBt);
      }
      if (this.TBu != null) {
        paramVarArgs.f(204, this.TBu);
      }
      if (this.TBv != null) {
        paramVarArgs.f(205, this.TBv);
      }
      if (this.TBw != null) {
        paramVarArgs.f(206, this.TBw);
      }
      AppMethodBeat.o(152627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label1462;
      }
    }
    label1462:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TBf != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.TBf);
      }
      i = paramInt;
      if (this.TBg != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.TBg);
      }
      paramInt = i;
      if (this.TBh != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.TBh);
      }
      i = paramInt;
      if (this.TBi != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.TBi);
      }
      paramInt = i;
      if (this.ufB != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.ufB);
      }
      i = paramInt + g.a.a.b.b.a.bM(32, this.ufE) + g.a.a.b.b.a.bM(33, this.TBj);
      paramInt = i;
      if (this.TBk != null) {
        paramInt = i + g.a.a.b.b.a.g(34, this.TBk);
      }
      i = paramInt + g.a.a.b.b.a.bM(35, this.TBl) + g.a.a.b.b.a.bM(36, this.TBm);
      paramInt = i;
      if (this.TBn != null) {
        paramInt = i + g.a.a.b.b.a.g(37, this.TBn);
      }
      i = paramInt + g.a.a.b.b.a.bM(38, this.TBo) + g.a.a.b.b.a.bM(39, this.TBp);
      paramInt = i;
      if (this.TBq != null) {
        paramInt = i + g.a.a.b.b.a.g(41, this.TBq);
      }
      i = paramInt + g.a.a.b.b.a.bM(200, this.TBr) + g.a.a.b.b.a.bM(201, this.TBs) + g.a.a.b.b.a.bM(202, this.group_id);
      paramInt = i;
      if (this.TBt != null) {
        paramInt = i + g.a.a.b.b.a.g(203, this.TBt);
      }
      i = paramInt;
      if (this.TBu != null) {
        i = paramInt + g.a.a.b.b.a.g(204, this.TBu);
      }
      paramInt = i;
      if (this.TBv != null) {
        paramInt = i + g.a.a.b.b.a.g(205, this.TBv);
      }
      i = paramInt;
      if (this.TBw != null) {
        i = paramInt + g.a.a.b.b.a.g(206, this.TBw);
      }
      AppMethodBeat.o(152627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152627);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ctl localctl = (ctl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152627);
          return -1;
        case 1: 
          localctl.appid = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 20: 
          localctl.TBf = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 21: 
          localctl.TBg = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 22: 
          localctl.TBh = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 23: 
          localctl.TBi = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 31: 
          localctl.ufB = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 32: 
          localctl.ufE = locala.abFh.AK();
          AppMethodBeat.o(152627);
          return 0;
        case 33: 
          localctl.TBj = locala.abFh.AK();
          AppMethodBeat.o(152627);
          return 0;
        case 34: 
          localctl.TBk = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 35: 
          localctl.TBl = locala.abFh.AK();
          AppMethodBeat.o(152627);
          return 0;
        case 36: 
          localctl.TBm = locala.abFh.AK();
          AppMethodBeat.o(152627);
          return 0;
        case 37: 
          localctl.TBn = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 38: 
          localctl.TBo = locala.abFh.AK();
          AppMethodBeat.o(152627);
          return 0;
        case 39: 
          localctl.TBp = locala.abFh.AK();
          AppMethodBeat.o(152627);
          return 0;
        case 41: 
          localctl.TBq = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 200: 
          localctl.TBr = locala.abFh.AK();
          AppMethodBeat.o(152627);
          return 0;
        case 201: 
          localctl.TBs = locala.abFh.AK();
          AppMethodBeat.o(152627);
          return 0;
        case 202: 
          localctl.group_id = locala.abFh.AK();
          AppMethodBeat.o(152627);
          return 0;
        case 203: 
          localctl.TBt = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 204: 
          localctl.TBu = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 205: 
          localctl.TBv = locala.abFh.readString();
          AppMethodBeat.o(152627);
          return 0;
        }
        localctl.TBw = locala.abFh.readString();
        AppMethodBeat.o(152627);
        return 0;
      }
      AppMethodBeat.o(152627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctl
 * JD-Core Version:    0.7.0.1
 */