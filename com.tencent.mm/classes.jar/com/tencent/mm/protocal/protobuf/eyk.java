package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eyk
  extends dyl
{
  public String CRQ;
  public String CRR;
  public int Cqs;
  public String RII;
  public String RJQ;
  public int RUc;
  public String ScV;
  public int ScW;
  public int ScX;
  public int ScY;
  public String ScZ;
  public int SsZ;
  public int Sue;
  public int TCZ;
  public int TDa;
  public eae TDb;
  public int TDc;
  public String Tsc;
  public String Tse;
  public int UhL;
  public int UjJ;
  public int UyB;
  public int UyC;
  public eae UyD;
  public String UyE;
  public int UyF;
  public String UyG;
  public String UyH;
  public int UyI;
  public String UyJ;
  public String UyK;
  public String UyL;
  public String UyM;
  public String UyN;
  public String UyO;
  public String UyP;
  public String UyQ;
  public int Uys;
  public int Uyt;
  public int Uyu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127180);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TDb == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.UyD == null)
      {
        paramVarArgs = new b("Not all required fields were included: VideoData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RJQ != null) {
        paramVarArgs.f(2, this.RJQ);
      }
      if (this.CRR != null) {
        paramVarArgs.f(3, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(4, this.CRQ);
      }
      paramVarArgs.aY(5, this.TCZ);
      paramVarArgs.aY(6, this.TDa);
      if (this.TDb != null)
      {
        paramVarArgs.oE(7, this.TDb.computeSize());
        this.TDb.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.UyB);
      paramVarArgs.aY(9, this.UyC);
      if (this.UyD != null)
      {
        paramVarArgs.oE(10, this.UyD.computeSize());
        this.UyD.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.UjJ);
      paramVarArgs.aY(12, this.SsZ);
      paramVarArgs.aY(13, this.TDc);
      paramVarArgs.aY(14, this.RUc);
      if (this.RII != null) {
        paramVarArgs.f(15, this.RII);
      }
      if (this.UyE != null) {
        paramVarArgs.f(16, this.UyE);
      }
      if (this.ScV != null) {
        paramVarArgs.f(17, this.ScV);
      }
      paramVarArgs.aY(18, this.ScW);
      if (this.Tsc != null) {
        paramVarArgs.f(19, this.Tsc);
      }
      paramVarArgs.aY(20, this.Uys);
      paramVarArgs.aY(21, this.Uyt);
      paramVarArgs.aY(22, this.Uyu);
      if (this.Tse != null) {
        paramVarArgs.f(23, this.Tse);
      }
      paramVarArgs.aY(24, this.UyF);
      paramVarArgs.aY(25, this.Sue);
      if (this.UyG != null) {
        paramVarArgs.f(26, this.UyG);
      }
      if (this.UyH != null) {
        paramVarArgs.f(27, this.UyH);
      }
      paramVarArgs.aY(28, this.UyI);
      if (this.UyJ != null) {
        paramVarArgs.f(29, this.UyJ);
      }
      if (this.UyK != null) {
        paramVarArgs.f(30, this.UyK);
      }
      if (this.UyL != null) {
        paramVarArgs.f(31, this.UyL);
      }
      if (this.UyM != null) {
        paramVarArgs.f(32, this.UyM);
      }
      if (this.UyN != null) {
        paramVarArgs.f(33, this.UyN);
      }
      if (this.UyO != null) {
        paramVarArgs.f(34, this.UyO);
      }
      if (this.UyP != null) {
        paramVarArgs.f(35, this.UyP);
      }
      paramVarArgs.aY(36, this.UhL);
      if (this.UyQ != null) {
        paramVarArgs.f(37, this.UyQ);
      }
      paramVarArgs.aY(38, this.ScX);
      paramVarArgs.aY(39, this.ScY);
      paramVarArgs.aY(40, this.Cqs);
      if (this.ScZ != null) {
        paramVarArgs.f(41, this.ScZ);
      }
      AppMethodBeat.o(127180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2676;
      }
    }
    label2676:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RJQ);
      }
      i = paramInt;
      if (this.CRR != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRR);
      }
      paramInt = i;
      if (this.CRQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CRQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TCZ) + g.a.a.b.b.a.bM(6, this.TDa);
      paramInt = i;
      if (this.TDb != null) {
        paramInt = i + g.a.a.a.oD(7, this.TDb.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.UyB) + g.a.a.b.b.a.bM(9, this.UyC);
      paramInt = i;
      if (this.UyD != null) {
        paramInt = i + g.a.a.a.oD(10, this.UyD.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.UjJ) + g.a.a.b.b.a.bM(12, this.SsZ) + g.a.a.b.b.a.bM(13, this.TDc) + g.a.a.b.b.a.bM(14, this.RUc);
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.RII);
      }
      i = paramInt;
      if (this.UyE != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.UyE);
      }
      paramInt = i;
      if (this.ScV != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.ScV);
      }
      i = paramInt + g.a.a.b.b.a.bM(18, this.ScW);
      paramInt = i;
      if (this.Tsc != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.Tsc);
      }
      i = paramInt + g.a.a.b.b.a.bM(20, this.Uys) + g.a.a.b.b.a.bM(21, this.Uyt) + g.a.a.b.b.a.bM(22, this.Uyu);
      paramInt = i;
      if (this.Tse != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.Tse);
      }
      i = paramInt + g.a.a.b.b.a.bM(24, this.UyF) + g.a.a.b.b.a.bM(25, this.Sue);
      paramInt = i;
      if (this.UyG != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.UyG);
      }
      i = paramInt;
      if (this.UyH != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.UyH);
      }
      i += g.a.a.b.b.a.bM(28, this.UyI);
      paramInt = i;
      if (this.UyJ != null) {
        paramInt = i + g.a.a.b.b.a.g(29, this.UyJ);
      }
      i = paramInt;
      if (this.UyK != null) {
        i = paramInt + g.a.a.b.b.a.g(30, this.UyK);
      }
      paramInt = i;
      if (this.UyL != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.UyL);
      }
      i = paramInt;
      if (this.UyM != null) {
        i = paramInt + g.a.a.b.b.a.g(32, this.UyM);
      }
      paramInt = i;
      if (this.UyN != null) {
        paramInt = i + g.a.a.b.b.a.g(33, this.UyN);
      }
      i = paramInt;
      if (this.UyO != null) {
        i = paramInt + g.a.a.b.b.a.g(34, this.UyO);
      }
      paramInt = i;
      if (this.UyP != null) {
        paramInt = i + g.a.a.b.b.a.g(35, this.UyP);
      }
      i = paramInt + g.a.a.b.b.a.bM(36, this.UhL);
      paramInt = i;
      if (this.UyQ != null) {
        paramInt = i + g.a.a.b.b.a.g(37, this.UyQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(38, this.ScX) + g.a.a.b.b.a.bM(39, this.ScY) + g.a.a.b.b.a.bM(40, this.Cqs);
      paramInt = i;
      if (this.ScZ != null) {
        paramInt = i + g.a.a.b.b.a.g(41, this.ScZ);
      }
      AppMethodBeat.o(127180);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TDb == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        if (this.UyD == null)
        {
          paramVarArgs = new b("Not all required fields were included: VideoData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eyk localeyk = (eyk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127180);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localeyk.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 2: 
          localeyk.RJQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 3: 
          localeyk.CRR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 4: 
          localeyk.CRQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 5: 
          localeyk.TCZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 6: 
          localeyk.TDa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeyk.TDb = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 8: 
          localeyk.UyB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 9: 
          localeyk.UyC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeyk.UyD = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 11: 
          localeyk.UjJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 12: 
          localeyk.SsZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 13: 
          localeyk.TDc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 14: 
          localeyk.RUc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 15: 
          localeyk.RII = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 16: 
          localeyk.UyE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 17: 
          localeyk.ScV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 18: 
          localeyk.ScW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 19: 
          localeyk.Tsc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 20: 
          localeyk.Uys = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 21: 
          localeyk.Uyt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 22: 
          localeyk.Uyu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 23: 
          localeyk.Tse = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 24: 
          localeyk.UyF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 25: 
          localeyk.Sue = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 26: 
          localeyk.UyG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 27: 
          localeyk.UyH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 28: 
          localeyk.UyI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 29: 
          localeyk.UyJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 30: 
          localeyk.UyK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 31: 
          localeyk.UyL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 32: 
          localeyk.UyM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 33: 
          localeyk.UyN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 34: 
          localeyk.UyO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 35: 
          localeyk.UyP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 36: 
          localeyk.UhL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 37: 
          localeyk.UyQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 38: 
          localeyk.ScX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 39: 
          localeyk.ScY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        case 40: 
          localeyk.Cqs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127180);
          return 0;
        }
        localeyk.ScZ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(127180);
        return 0;
      }
      AppMethodBeat.o(127180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyk
 * JD-Core Version:    0.7.0.1
 */