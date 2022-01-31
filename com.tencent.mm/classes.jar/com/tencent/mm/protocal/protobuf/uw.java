package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class uw
  extends com.tencent.mm.bv.a
{
  public String app_id;
  public String wNe;
  public String wNf;
  public String wNg;
  public int wNh;
  public int wNi;
  public int wNj;
  public int wNk;
  public int wNl;
  public int wNm;
  public int wNn;
  public int wNo;
  public int wNp;
  public int wNq;
  public String wNr;
  public String wNs;
  public String wNt;
  public String wNu;
  public String wNv;
  public b wNw;
  public String wNx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135599);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.e(1, this.app_id);
      }
      if (this.wNe != null) {
        paramVarArgs.e(2, this.wNe);
      }
      if (this.wNf != null) {
        paramVarArgs.e(3, this.wNf);
      }
      if (this.wNg != null) {
        paramVarArgs.e(4, this.wNg);
      }
      paramVarArgs.aO(5, this.wNh);
      paramVarArgs.aO(6, this.wNi);
      paramVarArgs.aO(7, this.wNj);
      paramVarArgs.aO(8, this.wNk);
      paramVarArgs.aO(9, this.wNl);
      paramVarArgs.aO(10, this.wNm);
      paramVarArgs.aO(11, this.wNn);
      paramVarArgs.aO(20, this.wNo);
      paramVarArgs.aO(21, this.wNp);
      paramVarArgs.aO(22, this.wNq);
      if (this.wNr != null) {
        paramVarArgs.e(25, this.wNr);
      }
      if (this.wNs != null) {
        paramVarArgs.e(26, this.wNs);
      }
      if (this.wNt != null) {
        paramVarArgs.e(27, this.wNt);
      }
      if (this.wNu != null) {
        paramVarArgs.e(28, this.wNu);
      }
      if (this.wNv != null) {
        paramVarArgs.e(29, this.wNv);
      }
      if (this.wNw != null) {
        paramVarArgs.c(30, this.wNw);
      }
      if (this.wNx != null) {
        paramVarArgs.e(31, this.wNx);
      }
      AppMethodBeat.o(135599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label1310;
      }
    }
    label1310:
    for (int i = e.a.a.b.b.a.f(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wNe != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wNe);
      }
      i = paramInt;
      if (this.wNf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wNf);
      }
      paramInt = i;
      if (this.wNg != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wNg);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wNh) + e.a.a.b.b.a.bl(6, this.wNi) + e.a.a.b.b.a.bl(7, this.wNj) + e.a.a.b.b.a.bl(8, this.wNk) + e.a.a.b.b.a.bl(9, this.wNl) + e.a.a.b.b.a.bl(10, this.wNm) + e.a.a.b.b.a.bl(11, this.wNn) + e.a.a.b.b.a.bl(20, this.wNo) + e.a.a.b.b.a.bl(21, this.wNp) + e.a.a.b.b.a.bl(22, this.wNq);
      paramInt = i;
      if (this.wNr != null) {
        paramInt = i + e.a.a.b.b.a.f(25, this.wNr);
      }
      i = paramInt;
      if (this.wNs != null) {
        i = paramInt + e.a.a.b.b.a.f(26, this.wNs);
      }
      paramInt = i;
      if (this.wNt != null) {
        paramInt = i + e.a.a.b.b.a.f(27, this.wNt);
      }
      i = paramInt;
      if (this.wNu != null) {
        i = paramInt + e.a.a.b.b.a.f(28, this.wNu);
      }
      paramInt = i;
      if (this.wNv != null) {
        paramInt = i + e.a.a.b.b.a.f(29, this.wNv);
      }
      i = paramInt;
      if (this.wNw != null) {
        i = paramInt + e.a.a.b.b.a.b(30, this.wNw);
      }
      paramInt = i;
      if (this.wNx != null) {
        paramInt = i + e.a.a.b.b.a.f(31, this.wNx);
      }
      AppMethodBeat.o(135599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(135599);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        uw localuw = (uw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 23: 
        case 24: 
        default: 
          AppMethodBeat.o(135599);
          return -1;
        case 1: 
          localuw.app_id = locala.CLY.readString();
          AppMethodBeat.o(135599);
          return 0;
        case 2: 
          localuw.wNe = locala.CLY.readString();
          AppMethodBeat.o(135599);
          return 0;
        case 3: 
          localuw.wNf = locala.CLY.readString();
          AppMethodBeat.o(135599);
          return 0;
        case 4: 
          localuw.wNg = locala.CLY.readString();
          AppMethodBeat.o(135599);
          return 0;
        case 5: 
          localuw.wNh = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 6: 
          localuw.wNi = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 7: 
          localuw.wNj = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 8: 
          localuw.wNk = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 9: 
          localuw.wNl = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 10: 
          localuw.wNm = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 11: 
          localuw.wNn = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 20: 
          localuw.wNo = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 21: 
          localuw.wNp = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 22: 
          localuw.wNq = locala.CLY.sl();
          AppMethodBeat.o(135599);
          return 0;
        case 25: 
          localuw.wNr = locala.CLY.readString();
          AppMethodBeat.o(135599);
          return 0;
        case 26: 
          localuw.wNs = locala.CLY.readString();
          AppMethodBeat.o(135599);
          return 0;
        case 27: 
          localuw.wNt = locala.CLY.readString();
          AppMethodBeat.o(135599);
          return 0;
        case 28: 
          localuw.wNu = locala.CLY.readString();
          AppMethodBeat.o(135599);
          return 0;
        case 29: 
          localuw.wNv = locala.CLY.readString();
          AppMethodBeat.o(135599);
          return 0;
        case 30: 
          localuw.wNw = locala.CLY.eqS();
          AppMethodBeat.o(135599);
          return 0;
        }
        localuw.wNx = locala.CLY.readString();
        AppMethodBeat.o(135599);
        return 0;
      }
      AppMethodBeat.o(135599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uw
 * JD-Core Version:    0.7.0.1
 */