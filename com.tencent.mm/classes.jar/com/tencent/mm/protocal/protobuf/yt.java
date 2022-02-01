package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class yt
  extends com.tencent.mm.bw.a
{
  public String EsB;
  public String EsC;
  public String EsD;
  public int EsE;
  public int EsF;
  public int EsG;
  public int EsH;
  public int EsI;
  public int EsJ;
  public int EsK;
  public int EsL;
  public int EsM;
  public int EsN;
  public int EsO;
  public int EsP;
  public int EsQ;
  public String EsR;
  public String EsS;
  public String EsT;
  public String EsU;
  public String EsV;
  public b EsW;
  public String EsX;
  public String app_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.d(1, this.app_id);
      }
      if (this.EsB != null) {
        paramVarArgs.d(2, this.EsB);
      }
      if (this.EsC != null) {
        paramVarArgs.d(3, this.EsC);
      }
      if (this.EsD != null) {
        paramVarArgs.d(4, this.EsD);
      }
      paramVarArgs.aR(5, this.EsE);
      paramVarArgs.aR(6, this.EsF);
      paramVarArgs.aR(7, this.EsG);
      paramVarArgs.aR(8, this.EsH);
      paramVarArgs.aR(9, this.EsI);
      paramVarArgs.aR(10, this.EsJ);
      paramVarArgs.aR(11, this.EsK);
      paramVarArgs.aR(12, this.EsL);
      paramVarArgs.aR(13, this.EsM);
      paramVarArgs.aR(14, this.EsN);
      paramVarArgs.aR(20, this.EsO);
      paramVarArgs.aR(21, this.EsP);
      paramVarArgs.aR(22, this.EsQ);
      if (this.EsR != null) {
        paramVarArgs.d(25, this.EsR);
      }
      if (this.EsS != null) {
        paramVarArgs.d(26, this.EsS);
      }
      if (this.EsT != null) {
        paramVarArgs.d(27, this.EsT);
      }
      if (this.EsU != null) {
        paramVarArgs.d(28, this.EsU);
      }
      if (this.EsV != null) {
        paramVarArgs.d(29, this.EsV);
      }
      if (this.EsW != null) {
        paramVarArgs.c(30, this.EsW);
      }
      if (this.EsX != null) {
        paramVarArgs.d(31, this.EsX);
      }
      AppMethodBeat.o(90960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label1430;
      }
    }
    label1430:
    for (int i = f.a.a.b.b.a.e(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EsB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EsB);
      }
      i = paramInt;
      if (this.EsC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EsC);
      }
      paramInt = i;
      if (this.EsD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EsD);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EsE) + f.a.a.b.b.a.bx(6, this.EsF) + f.a.a.b.b.a.bx(7, this.EsG) + f.a.a.b.b.a.bx(8, this.EsH) + f.a.a.b.b.a.bx(9, this.EsI) + f.a.a.b.b.a.bx(10, this.EsJ) + f.a.a.b.b.a.bx(11, this.EsK) + f.a.a.b.b.a.bx(12, this.EsL) + f.a.a.b.b.a.bx(13, this.EsM) + f.a.a.b.b.a.bx(14, this.EsN) + f.a.a.b.b.a.bx(20, this.EsO) + f.a.a.b.b.a.bx(21, this.EsP) + f.a.a.b.b.a.bx(22, this.EsQ);
      paramInt = i;
      if (this.EsR != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.EsR);
      }
      i = paramInt;
      if (this.EsS != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.EsS);
      }
      paramInt = i;
      if (this.EsT != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.EsT);
      }
      i = paramInt;
      if (this.EsU != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.EsU);
      }
      paramInt = i;
      if (this.EsV != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.EsV);
      }
      i = paramInt;
      if (this.EsW != null) {
        i = paramInt + f.a.a.b.b.a.b(30, this.EsW);
      }
      paramInt = i;
      if (this.EsX != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.EsX);
      }
      AppMethodBeat.o(90960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(90960);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        yt localyt = (yt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 23: 
        case 24: 
        default: 
          AppMethodBeat.o(90960);
          return -1;
        case 1: 
          localyt.app_id = locala.LVo.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 2: 
          localyt.EsB = locala.LVo.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 3: 
          localyt.EsC = locala.LVo.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 4: 
          localyt.EsD = locala.LVo.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 5: 
          localyt.EsE = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 6: 
          localyt.EsF = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 7: 
          localyt.EsG = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 8: 
          localyt.EsH = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 9: 
          localyt.EsI = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 10: 
          localyt.EsJ = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 11: 
          localyt.EsK = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 12: 
          localyt.EsL = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 13: 
          localyt.EsM = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 14: 
          localyt.EsN = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 20: 
          localyt.EsO = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 21: 
          localyt.EsP = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 22: 
          localyt.EsQ = locala.LVo.xF();
          AppMethodBeat.o(90960);
          return 0;
        case 25: 
          localyt.EsR = locala.LVo.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 26: 
          localyt.EsS = locala.LVo.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 27: 
          localyt.EsT = locala.LVo.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 28: 
          localyt.EsU = locala.LVo.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 29: 
          localyt.EsV = locala.LVo.readString();
          AppMethodBeat.o(90960);
          return 0;
        case 30: 
          localyt.EsW = locala.LVo.gfk();
          AppMethodBeat.o(90960);
          return 0;
        }
        localyt.EsX = locala.LVo.readString();
        AppMethodBeat.o(90960);
        return 0;
      }
      AppMethodBeat.o(90960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yt
 * JD-Core Version:    0.7.0.1
 */