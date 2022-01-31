package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czw
  extends com.tencent.mm.bv.a
{
  public int cJb;
  public String cJc;
  public String fKw;
  public String iHi;
  public int iHn;
  public int jKs;
  public int lGW;
  public int qsk;
  public int qsl;
  public int uPv;
  public String wqN;
  public String ygA;
  public int ygB;
  public String ygC;
  public String ygx;
  public String ygy;
  public int ygz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96330);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jKs);
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      if (this.ygx != null) {
        paramVarArgs.e(3, this.ygx);
      }
      paramVarArgs.aO(4, this.qsk);
      paramVarArgs.aO(5, this.lGW);
      paramVarArgs.aO(6, this.qsl);
      if (this.ygy != null) {
        paramVarArgs.e(7, this.ygy);
      }
      paramVarArgs.aO(8, this.ygz);
      if (this.wqN != null) {
        paramVarArgs.e(9, this.wqN);
      }
      if (this.ygA != null) {
        paramVarArgs.e(10, this.ygA);
      }
      paramVarArgs.aO(11, this.uPv);
      paramVarArgs.aO(12, this.ygB);
      if (this.ygC != null) {
        paramVarArgs.e(13, this.ygC);
      }
      if (this.iHi != null) {
        paramVarArgs.e(14, this.iHi);
      }
      paramVarArgs.aO(15, this.cJb);
      if (this.cJc != null) {
        paramVarArgs.e(16, this.cJc);
      }
      paramVarArgs.aO(17, this.iHn);
      AppMethodBeat.o(96330);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.jKs) + 0;
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.ygx != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ygx);
      }
      i = i + e.a.a.b.b.a.bl(4, this.qsk) + e.a.a.b.b.a.bl(5, this.lGW) + e.a.a.b.b.a.bl(6, this.qsl);
      paramInt = i;
      if (this.ygy != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.ygy);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.ygz);
      paramInt = i;
      if (this.wqN != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wqN);
      }
      i = paramInt;
      if (this.ygA != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.ygA);
      }
      i = i + e.a.a.b.b.a.bl(11, this.uPv) + e.a.a.b.b.a.bl(12, this.ygB);
      paramInt = i;
      if (this.ygC != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.ygC);
      }
      i = paramInt;
      if (this.iHi != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.iHi);
      }
      i += e.a.a.b.b.a.bl(15, this.cJb);
      paramInt = i;
      if (this.cJc != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.cJc);
      }
      i = e.a.a.b.b.a.bl(17, this.iHn);
      AppMethodBeat.o(96330);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96330);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      czw localczw = (czw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96330);
        return -1;
      case 1: 
        localczw.jKs = locala.CLY.sl();
        AppMethodBeat.o(96330);
        return 0;
      case 2: 
        localczw.fKw = locala.CLY.readString();
        AppMethodBeat.o(96330);
        return 0;
      case 3: 
        localczw.ygx = locala.CLY.readString();
        AppMethodBeat.o(96330);
        return 0;
      case 4: 
        localczw.qsk = locala.CLY.sl();
        AppMethodBeat.o(96330);
        return 0;
      case 5: 
        localczw.lGW = locala.CLY.sl();
        AppMethodBeat.o(96330);
        return 0;
      case 6: 
        localczw.qsl = locala.CLY.sl();
        AppMethodBeat.o(96330);
        return 0;
      case 7: 
        localczw.ygy = locala.CLY.readString();
        AppMethodBeat.o(96330);
        return 0;
      case 8: 
        localczw.ygz = locala.CLY.sl();
        AppMethodBeat.o(96330);
        return 0;
      case 9: 
        localczw.wqN = locala.CLY.readString();
        AppMethodBeat.o(96330);
        return 0;
      case 10: 
        localczw.ygA = locala.CLY.readString();
        AppMethodBeat.o(96330);
        return 0;
      case 11: 
        localczw.uPv = locala.CLY.sl();
        AppMethodBeat.o(96330);
        return 0;
      case 12: 
        localczw.ygB = locala.CLY.sl();
        AppMethodBeat.o(96330);
        return 0;
      case 13: 
        localczw.ygC = locala.CLY.readString();
        AppMethodBeat.o(96330);
        return 0;
      case 14: 
        localczw.iHi = locala.CLY.readString();
        AppMethodBeat.o(96330);
        return 0;
      case 15: 
        localczw.cJb = locala.CLY.sl();
        AppMethodBeat.o(96330);
        return 0;
      case 16: 
        localczw.cJc = locala.CLY.readString();
        AppMethodBeat.o(96330);
        return 0;
      }
      localczw.iHn = locala.CLY.sl();
      AppMethodBeat.o(96330);
      return 0;
    }
    AppMethodBeat.o(96330);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czw
 * JD-Core Version:    0.7.0.1
 */