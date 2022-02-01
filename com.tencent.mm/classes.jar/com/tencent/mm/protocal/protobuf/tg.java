package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tg
  extends dyl
{
  public int CPw;
  public String CRQ;
  public String CRR;
  public int Cqs;
  public String RFI;
  public String RFJ;
  public String RFK;
  public String RII;
  public String ScK;
  public int ScL;
  public int ScM;
  public eae ScN;
  public float ScO;
  public float ScP;
  public String ScQ;
  public int ScR;
  public int ScS;
  public int ScT;
  public int ScU;
  public String ScV;
  public int ScW;
  public int ScX;
  public int ScY;
  public String ScZ;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152511);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ScK != null) {
        paramVarArgs.f(1, this.ScK);
      }
      if (this.CRR != null) {
        paramVarArgs.f(2, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(3, this.CRQ);
      }
      paramVarArgs.aY(4, this.ScL);
      paramVarArgs.aY(5, this.ScM);
      if (this.RII != null) {
        paramVarArgs.f(6, this.RII);
      }
      if (this.ScN != null)
      {
        paramVarArgs.oE(7, this.ScN.computeSize());
        this.ScN.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.CPw);
      paramVarArgs.i(9, this.ScO);
      paramVarArgs.i(10, this.ScP);
      if (this.ScQ != null) {
        paramVarArgs.f(11, this.ScQ);
      }
      paramVarArgs.aY(12, this.ScR);
      paramVarArgs.aY(13, this.ScS);
      paramVarArgs.aY(14, this.ScT);
      paramVarArgs.aY(15, this.ScU);
      if (this.ScV != null) {
        paramVarArgs.f(16, this.ScV);
      }
      paramVarArgs.aY(17, this.ScW);
      paramVarArgs.aY(18, this.ScX);
      paramVarArgs.aY(19, this.ScY);
      paramVarArgs.aY(20, this.Cqs);
      if (this.lVG != null) {
        paramVarArgs.f(21, this.lVG);
      }
      if (this.RFK != null) {
        paramVarArgs.f(22, this.RFK);
      }
      if (this.RFJ != null) {
        paramVarArgs.f(23, this.RFJ);
      }
      if (this.RFI != null) {
        paramVarArgs.f(24, this.RFI);
      }
      if (this.ScZ != null) {
        paramVarArgs.f(25, this.ScZ);
      }
      AppMethodBeat.o(152511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ScK == null) {
        break label1546;
      }
    }
    label1546:
    for (int i = g.a.a.b.b.a.g(1, this.ScK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CRR);
      }
      i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRQ);
      }
      i = i + g.a.a.b.b.a.bM(4, this.ScL) + g.a.a.b.b.a.bM(5, this.ScM);
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RII);
      }
      i = paramInt;
      if (this.ScN != null) {
        i = paramInt + g.a.a.a.oD(7, this.ScN.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(8, this.CPw) + (g.a.a.b.b.a.gL(9) + 4) + (g.a.a.b.b.a.gL(10) + 4);
      paramInt = i;
      if (this.ScQ != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.ScQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.ScR) + g.a.a.b.b.a.bM(13, this.ScS) + g.a.a.b.b.a.bM(14, this.ScT) + g.a.a.b.b.a.bM(15, this.ScU);
      paramInt = i;
      if (this.ScV != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.ScV);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.ScW) + g.a.a.b.b.a.bM(18, this.ScX) + g.a.a.b.b.a.bM(19, this.ScY) + g.a.a.b.b.a.bM(20, this.Cqs);
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.lVG);
      }
      i = paramInt;
      if (this.RFK != null) {
        i = paramInt + g.a.a.b.b.a.g(22, this.RFK);
      }
      paramInt = i;
      if (this.RFJ != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.RFJ);
      }
      i = paramInt;
      if (this.RFI != null) {
        i = paramInt + g.a.a.b.b.a.g(24, this.RFI);
      }
      paramInt = i;
      if (this.ScZ != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.ScZ);
      }
      AppMethodBeat.o(152511);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        tg localtg = (tg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152511);
          return -1;
        case 1: 
          localtg.ScK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 2: 
          localtg.CRR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 3: 
          localtg.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 4: 
          localtg.ScL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 5: 
          localtg.ScM = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 6: 
          localtg.RII = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eae localeae = new eae();
            if ((localObject != null) && (localObject.length > 0)) {
              localeae.dd((byte[])localObject);
            }
            localtg.ScN = localeae;
            paramInt += 1;
          }
          AppMethodBeat.o(152511);
          return 0;
        case 8: 
          localtg.CPw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 9: 
          localtg.ScO = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(152511);
          return 0;
        case 10: 
          localtg.ScP = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(152511);
          return 0;
        case 11: 
          localtg.ScQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 12: 
          localtg.ScR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 13: 
          localtg.ScS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 14: 
          localtg.ScT = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 15: 
          localtg.ScU = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 16: 
          localtg.ScV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 17: 
          localtg.ScW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 18: 
          localtg.ScX = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 19: 
          localtg.ScY = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 20: 
          localtg.Cqs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(152511);
          return 0;
        case 21: 
          localtg.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 22: 
          localtg.RFK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 23: 
          localtg.RFJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 24: 
          localtg.RFI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152511);
          return 0;
        }
        localtg.ScZ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152511);
        return 0;
      }
      AppMethodBeat.o(152511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tg
 * JD-Core Version:    0.7.0.1
 */