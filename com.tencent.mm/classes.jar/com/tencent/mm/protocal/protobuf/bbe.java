package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbe
  extends com.tencent.mm.bv.a
{
  public String cwc;
  public int kWA;
  public String kWx;
  public int wPj;
  public String xqA;
  public String xqB;
  public String xqC;
  public String xqD;
  public String xqm;
  public String xqn;
  public String xqo;
  public String xqp;
  public int xqq;
  public String xqr;
  public int xqs;
  public int xqt;
  public String xqu;
  public int xqv;
  public int xqw;
  public String xqx;
  public int xqy;
  public int xqz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80121);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cwc != null) {
        paramVarArgs.e(1, this.cwc);
      }
      if (this.xqm != null) {
        paramVarArgs.e(20, this.xqm);
      }
      if (this.xqn != null) {
        paramVarArgs.e(21, this.xqn);
      }
      if (this.xqo != null) {
        paramVarArgs.e(22, this.xqo);
      }
      if (this.xqp != null) {
        paramVarArgs.e(23, this.xqp);
      }
      if (this.kWx != null) {
        paramVarArgs.e(31, this.kWx);
      }
      paramVarArgs.aO(32, this.kWA);
      paramVarArgs.aO(33, this.xqq);
      if (this.xqr != null) {
        paramVarArgs.e(34, this.xqr);
      }
      paramVarArgs.aO(35, this.xqs);
      paramVarArgs.aO(36, this.xqt);
      if (this.xqu != null) {
        paramVarArgs.e(37, this.xqu);
      }
      paramVarArgs.aO(38, this.xqv);
      paramVarArgs.aO(39, this.xqw);
      if (this.xqx != null) {
        paramVarArgs.e(41, this.xqx);
      }
      paramVarArgs.aO(200, this.xqy);
      paramVarArgs.aO(201, this.xqz);
      paramVarArgs.aO(202, this.wPj);
      if (this.xqA != null) {
        paramVarArgs.e(203, this.xqA);
      }
      if (this.xqB != null) {
        paramVarArgs.e(204, this.xqB);
      }
      if (this.xqC != null) {
        paramVarArgs.e(205, this.xqC);
      }
      if (this.xqD != null) {
        paramVarArgs.e(206, this.xqD);
      }
      AppMethodBeat.o(80121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cwc == null) {
        break label1462;
      }
    }
    label1462:
    for (int i = e.a.a.b.b.a.f(1, this.cwc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xqm != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.xqm);
      }
      i = paramInt;
      if (this.xqn != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.xqn);
      }
      paramInt = i;
      if (this.xqo != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.xqo);
      }
      i = paramInt;
      if (this.xqp != null) {
        i = paramInt + e.a.a.b.b.a.f(23, this.xqp);
      }
      paramInt = i;
      if (this.kWx != null) {
        paramInt = i + e.a.a.b.b.a.f(31, this.kWx);
      }
      i = paramInt + e.a.a.b.b.a.bl(32, this.kWA) + e.a.a.b.b.a.bl(33, this.xqq);
      paramInt = i;
      if (this.xqr != null) {
        paramInt = i + e.a.a.b.b.a.f(34, this.xqr);
      }
      i = paramInt + e.a.a.b.b.a.bl(35, this.xqs) + e.a.a.b.b.a.bl(36, this.xqt);
      paramInt = i;
      if (this.xqu != null) {
        paramInt = i + e.a.a.b.b.a.f(37, this.xqu);
      }
      i = paramInt + e.a.a.b.b.a.bl(38, this.xqv) + e.a.a.b.b.a.bl(39, this.xqw);
      paramInt = i;
      if (this.xqx != null) {
        paramInt = i + e.a.a.b.b.a.f(41, this.xqx);
      }
      i = paramInt + e.a.a.b.b.a.bl(200, this.xqy) + e.a.a.b.b.a.bl(201, this.xqz) + e.a.a.b.b.a.bl(202, this.wPj);
      paramInt = i;
      if (this.xqA != null) {
        paramInt = i + e.a.a.b.b.a.f(203, this.xqA);
      }
      i = paramInt;
      if (this.xqB != null) {
        i = paramInt + e.a.a.b.b.a.f(204, this.xqB);
      }
      paramInt = i;
      if (this.xqC != null) {
        paramInt = i + e.a.a.b.b.a.f(205, this.xqC);
      }
      i = paramInt;
      if (this.xqD != null) {
        i = paramInt + e.a.a.b.b.a.f(206, this.xqD);
      }
      AppMethodBeat.o(80121);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80121);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bbe localbbe = (bbe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80121);
          return -1;
        case 1: 
          localbbe.cwc = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 20: 
          localbbe.xqm = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 21: 
          localbbe.xqn = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 22: 
          localbbe.xqo = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 23: 
          localbbe.xqp = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 31: 
          localbbe.kWx = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 32: 
          localbbe.kWA = locala.CLY.sl();
          AppMethodBeat.o(80121);
          return 0;
        case 33: 
          localbbe.xqq = locala.CLY.sl();
          AppMethodBeat.o(80121);
          return 0;
        case 34: 
          localbbe.xqr = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 35: 
          localbbe.xqs = locala.CLY.sl();
          AppMethodBeat.o(80121);
          return 0;
        case 36: 
          localbbe.xqt = locala.CLY.sl();
          AppMethodBeat.o(80121);
          return 0;
        case 37: 
          localbbe.xqu = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 38: 
          localbbe.xqv = locala.CLY.sl();
          AppMethodBeat.o(80121);
          return 0;
        case 39: 
          localbbe.xqw = locala.CLY.sl();
          AppMethodBeat.o(80121);
          return 0;
        case 41: 
          localbbe.xqx = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 200: 
          localbbe.xqy = locala.CLY.sl();
          AppMethodBeat.o(80121);
          return 0;
        case 201: 
          localbbe.xqz = locala.CLY.sl();
          AppMethodBeat.o(80121);
          return 0;
        case 202: 
          localbbe.wPj = locala.CLY.sl();
          AppMethodBeat.o(80121);
          return 0;
        case 203: 
          localbbe.xqA = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 204: 
          localbbe.xqB = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        case 205: 
          localbbe.xqC = locala.CLY.readString();
          AppMethodBeat.o(80121);
          return 0;
        }
        localbbe.xqD = locala.CLY.readString();
        AppMethodBeat.o(80121);
        return 0;
      }
      AppMethodBeat.o(80121);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbe
 * JD-Core Version:    0.7.0.1
 */