package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class brt
  extends com.tencent.mm.bw.a
{
  public int EuT;
  public String FgL;
  public String FgM;
  public String FgN;
  public String FgO;
  public int FgP;
  public String FgQ;
  public int FgR;
  public int FgS;
  public String FgT;
  public int FgU;
  public int FgV;
  public String FgW;
  public int FgX;
  public int FgY;
  public String FgZ;
  public String Fha;
  public String Fhb;
  public String Fhc;
  public String djj;
  public String oGM;
  public int oGP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152627);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      if (this.FgL != null) {
        paramVarArgs.d(20, this.FgL);
      }
      if (this.FgM != null) {
        paramVarArgs.d(21, this.FgM);
      }
      if (this.FgN != null) {
        paramVarArgs.d(22, this.FgN);
      }
      if (this.FgO != null) {
        paramVarArgs.d(23, this.FgO);
      }
      if (this.oGM != null) {
        paramVarArgs.d(31, this.oGM);
      }
      paramVarArgs.aR(32, this.oGP);
      paramVarArgs.aR(33, this.FgP);
      if (this.FgQ != null) {
        paramVarArgs.d(34, this.FgQ);
      }
      paramVarArgs.aR(35, this.FgR);
      paramVarArgs.aR(36, this.FgS);
      if (this.FgT != null) {
        paramVarArgs.d(37, this.FgT);
      }
      paramVarArgs.aR(38, this.FgU);
      paramVarArgs.aR(39, this.FgV);
      if (this.FgW != null) {
        paramVarArgs.d(41, this.FgW);
      }
      paramVarArgs.aR(200, this.FgX);
      paramVarArgs.aR(201, this.FgY);
      paramVarArgs.aR(202, this.EuT);
      if (this.FgZ != null) {
        paramVarArgs.d(203, this.FgZ);
      }
      if (this.Fha != null) {
        paramVarArgs.d(204, this.Fha);
      }
      if (this.Fhb != null) {
        paramVarArgs.d(205, this.Fhb);
      }
      if (this.Fhc != null) {
        paramVarArgs.d(206, this.Fhc);
      }
      AppMethodBeat.o(152627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label1462;
      }
    }
    label1462:
    for (int i = f.a.a.b.b.a.e(1, this.djj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FgL != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FgL);
      }
      i = paramInt;
      if (this.FgM != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.FgM);
      }
      paramInt = i;
      if (this.FgN != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.FgN);
      }
      i = paramInt;
      if (this.FgO != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.FgO);
      }
      paramInt = i;
      if (this.oGM != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.oGM);
      }
      i = paramInt + f.a.a.b.b.a.bx(32, this.oGP) + f.a.a.b.b.a.bx(33, this.FgP);
      paramInt = i;
      if (this.FgQ != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.FgQ);
      }
      i = paramInt + f.a.a.b.b.a.bx(35, this.FgR) + f.a.a.b.b.a.bx(36, this.FgS);
      paramInt = i;
      if (this.FgT != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.FgT);
      }
      i = paramInt + f.a.a.b.b.a.bx(38, this.FgU) + f.a.a.b.b.a.bx(39, this.FgV);
      paramInt = i;
      if (this.FgW != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.FgW);
      }
      i = paramInt + f.a.a.b.b.a.bx(200, this.FgX) + f.a.a.b.b.a.bx(201, this.FgY) + f.a.a.b.b.a.bx(202, this.EuT);
      paramInt = i;
      if (this.FgZ != null) {
        paramInt = i + f.a.a.b.b.a.e(203, this.FgZ);
      }
      i = paramInt;
      if (this.Fha != null) {
        i = paramInt + f.a.a.b.b.a.e(204, this.Fha);
      }
      paramInt = i;
      if (this.Fhb != null) {
        paramInt = i + f.a.a.b.b.a.e(205, this.Fhb);
      }
      i = paramInt;
      if (this.Fhc != null) {
        i = paramInt + f.a.a.b.b.a.e(206, this.Fhc);
      }
      AppMethodBeat.o(152627);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152627);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        brt localbrt = (brt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152627);
          return -1;
        case 1: 
          localbrt.djj = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 20: 
          localbrt.FgL = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 21: 
          localbrt.FgM = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 22: 
          localbrt.FgN = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 23: 
          localbrt.FgO = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 31: 
          localbrt.oGM = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 32: 
          localbrt.oGP = locala.LVo.xF();
          AppMethodBeat.o(152627);
          return 0;
        case 33: 
          localbrt.FgP = locala.LVo.xF();
          AppMethodBeat.o(152627);
          return 0;
        case 34: 
          localbrt.FgQ = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 35: 
          localbrt.FgR = locala.LVo.xF();
          AppMethodBeat.o(152627);
          return 0;
        case 36: 
          localbrt.FgS = locala.LVo.xF();
          AppMethodBeat.o(152627);
          return 0;
        case 37: 
          localbrt.FgT = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 38: 
          localbrt.FgU = locala.LVo.xF();
          AppMethodBeat.o(152627);
          return 0;
        case 39: 
          localbrt.FgV = locala.LVo.xF();
          AppMethodBeat.o(152627);
          return 0;
        case 41: 
          localbrt.FgW = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 200: 
          localbrt.FgX = locala.LVo.xF();
          AppMethodBeat.o(152627);
          return 0;
        case 201: 
          localbrt.FgY = locala.LVo.xF();
          AppMethodBeat.o(152627);
          return 0;
        case 202: 
          localbrt.EuT = locala.LVo.xF();
          AppMethodBeat.o(152627);
          return 0;
        case 203: 
          localbrt.FgZ = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 204: 
          localbrt.Fha = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        case 205: 
          localbrt.Fhb = locala.LVo.readString();
          AppMethodBeat.o(152627);
          return 0;
        }
        localbrt.Fhc = locala.LVo.readString();
        AppMethodBeat.o(152627);
        return 0;
      }
      AppMethodBeat.o(152627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brt
 * JD-Core Version:    0.7.0.1
 */