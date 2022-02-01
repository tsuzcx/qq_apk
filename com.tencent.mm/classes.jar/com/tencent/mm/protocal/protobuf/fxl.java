package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fxl
  extends com.tencent.mm.bx.a
{
  public int abVa;
  public String abVb;
  public String abVc;
  public int abVd;
  public String abVe;
  public int abVf;
  public int abVg;
  public String abVh;
  public int abVi;
  public String abVj;
  public int abVk;
  public String abVl;
  public int abVm;
  public String abVn;
  public String abzC;
  public String appid;
  public String extInfo;
  public int interval;
  public String nQG;
  public String title;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176157);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      paramVarArgs.bS(3, this.version);
      if (this.nQG != null) {
        paramVarArgs.g(4, this.nQG);
      }
      paramVarArgs.bS(5, this.abVa);
      if (this.abVb != null) {
        paramVarArgs.g(6, this.abVb);
      }
      if (this.abVc != null) {
        paramVarArgs.g(7, this.abVc);
      }
      paramVarArgs.bS(8, this.abVd);
      if (this.abVe != null) {
        paramVarArgs.g(9, this.abVe);
      }
      paramVarArgs.bS(10, this.interval);
      paramVarArgs.bS(11, this.abVf);
      paramVarArgs.bS(12, this.abVg);
      if (this.abVh != null) {
        paramVarArgs.g(13, this.abVh);
      }
      if (this.abzC != null) {
        paramVarArgs.g(14, this.abzC);
      }
      paramVarArgs.bS(15, this.abVi);
      if (this.abVj != null) {
        paramVarArgs.g(16, this.abVj);
      }
      paramVarArgs.bS(17, this.abVk);
      if (this.abVl != null) {
        paramVarArgs.g(18, this.abVl);
      }
      paramVarArgs.bS(19, this.abVm);
      if (this.extInfo != null) {
        paramVarArgs.g(20, this.extInfo);
      }
      if (this.abVn != null) {
        paramVarArgs.g(21, this.abVn);
      }
      AppMethodBeat.o(176157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1294;
      }
    }
    label1294:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      i += i.a.a.b.b.a.cJ(3, this.version);
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nQG);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abVa);
      paramInt = i;
      if (this.abVb != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abVb);
      }
      i = paramInt;
      if (this.abVc != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abVc);
      }
      i += i.a.a.b.b.a.cJ(8, this.abVd);
      paramInt = i;
      if (this.abVe != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abVe);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.interval) + i.a.a.b.b.a.cJ(11, this.abVf) + i.a.a.b.b.a.cJ(12, this.abVg);
      paramInt = i;
      if (this.abVh != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abVh);
      }
      i = paramInt;
      if (this.abzC != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.abzC);
      }
      i += i.a.a.b.b.a.cJ(15, this.abVi);
      paramInt = i;
      if (this.abVj != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.abVj);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.abVk);
      paramInt = i;
      if (this.abVl != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.abVl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.abVm);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.extInfo);
      }
      i = paramInt;
      if (this.abVn != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.abVn);
      }
      AppMethodBeat.o(176157);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(176157);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fxl localfxl = (fxl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176157);
          return -1;
        case 1: 
          localfxl.title = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 2: 
          localfxl.appid = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 3: 
          localfxl.version = locala.ajGk.aar();
          AppMethodBeat.o(176157);
          return 0;
        case 4: 
          localfxl.nQG = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 5: 
          localfxl.abVa = locala.ajGk.aar();
          AppMethodBeat.o(176157);
          return 0;
        case 6: 
          localfxl.abVb = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 7: 
          localfxl.abVc = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 8: 
          localfxl.abVd = locala.ajGk.aar();
          AppMethodBeat.o(176157);
          return 0;
        case 9: 
          localfxl.abVe = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 10: 
          localfxl.interval = locala.ajGk.aar();
          AppMethodBeat.o(176157);
          return 0;
        case 11: 
          localfxl.abVf = locala.ajGk.aar();
          AppMethodBeat.o(176157);
          return 0;
        case 12: 
          localfxl.abVg = locala.ajGk.aar();
          AppMethodBeat.o(176157);
          return 0;
        case 13: 
          localfxl.abVh = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 14: 
          localfxl.abzC = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 15: 
          localfxl.abVi = locala.ajGk.aar();
          AppMethodBeat.o(176157);
          return 0;
        case 16: 
          localfxl.abVj = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 17: 
          localfxl.abVk = locala.ajGk.aar();
          AppMethodBeat.o(176157);
          return 0;
        case 18: 
          localfxl.abVl = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        case 19: 
          localfxl.abVm = locala.ajGk.aar();
          AppMethodBeat.o(176157);
          return 0;
        case 20: 
          localfxl.extInfo = locala.ajGk.readString();
          AppMethodBeat.o(176157);
          return 0;
        }
        localfxl.abVn = locala.ajGk.readString();
        AppMethodBeat.o(176157);
        return 0;
      }
      AppMethodBeat.o(176157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxl
 * JD-Core Version:    0.7.0.1
 */