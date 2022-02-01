package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rb
  extends dyy
{
  public int ImF = 0;
  public String ImG;
  public String ImH;
  public String ImI;
  public String ImJ;
  public String InV;
  public String RJf;
  public String RJg;
  public String RZC;
  public eig RZD;
  public String RZE;
  public String RZF;
  public int RZG;
  public int RZH;
  public int RZI;
  public esi RZJ;
  public String RZK;
  public int RZL;
  public int RZM;
  public int RZN;
  public com.tencent.mm.cd.b RZO;
  public int RZP;
  public int RZQ;
  public int RZR;
  public qu RZS;
  public ea RZT;
  public dz RZU;
  public zk RZV;
  public String RZo;
  public String fHb;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91375);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91375);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.fHb != null) {
        paramVarArgs.f(4, this.fHb);
      }
      if (this.RZC != null) {
        paramVarArgs.f(5, this.RZC);
      }
      if (this.RZD != null)
      {
        paramVarArgs.oE(6, this.RZD.computeSize());
        this.RZD.writeFields(paramVarArgs);
      }
      if (this.RJf != null) {
        paramVarArgs.f(7, this.RJf);
      }
      if (this.RJg != null) {
        paramVarArgs.f(8, this.RJg);
      }
      if (this.RZE != null) {
        paramVarArgs.f(9, this.RZE);
      }
      if (this.RZF != null) {
        paramVarArgs.f(10, this.RZF);
      }
      paramVarArgs.aY(11, this.RZG);
      if (this.InV != null) {
        paramVarArgs.f(12, this.InV);
      }
      if (this.RZo != null) {
        paramVarArgs.f(13, this.RZo);
      }
      paramVarArgs.aY(14, this.RZH);
      paramVarArgs.aY(15, this.RZI);
      if (this.RZJ != null)
      {
        paramVarArgs.oE(16, this.RZJ.computeSize());
        this.RZJ.writeFields(paramVarArgs);
      }
      if (this.RZK != null) {
        paramVarArgs.f(17, this.RZK);
      }
      paramVarArgs.aY(18, this.RZL);
      paramVarArgs.aY(19, this.RZM);
      paramVarArgs.aY(20, this.RZN);
      if (this.RZO != null) {
        paramVarArgs.c(21, this.RZO);
      }
      paramVarArgs.aY(22, this.RZP);
      paramVarArgs.aY(23, this.ImF);
      if (this.ImG != null) {
        paramVarArgs.f(24, this.ImG);
      }
      if (this.ImH != null) {
        paramVarArgs.f(25, this.ImH);
      }
      paramVarArgs.aY(26, this.RZQ);
      if (this.ImI != null) {
        paramVarArgs.f(27, this.ImI);
      }
      if (this.ImJ != null) {
        paramVarArgs.f(28, this.ImJ);
      }
      paramVarArgs.aY(29, this.RZR);
      if (this.RZS != null)
      {
        paramVarArgs.oE(30, this.RZS.computeSize());
        this.RZS.writeFields(paramVarArgs);
      }
      if (this.RZT != null)
      {
        paramVarArgs.oE(31, this.RZT.computeSize());
        this.RZT.writeFields(paramVarArgs);
      }
      if (this.RZU != null)
      {
        paramVarArgs.oE(32, this.RZU.computeSize());
        this.RZU.writeFields(paramVarArgs);
      }
      if (this.RZV != null)
      {
        paramVarArgs.oE(33, this.RZV.computeSize());
        this.RZV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2560;
      }
    }
    label2560:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.fHb != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.fHb);
      }
      paramInt = i;
      if (this.RZC != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RZC);
      }
      i = paramInt;
      if (this.RZD != null) {
        i = paramInt + g.a.a.a.oD(6, this.RZD.computeSize());
      }
      paramInt = i;
      if (this.RJf != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RJf);
      }
      i = paramInt;
      if (this.RJg != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RJg);
      }
      paramInt = i;
      if (this.RZE != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RZE);
      }
      i = paramInt;
      if (this.RZF != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.RZF);
      }
      i += g.a.a.b.b.a.bM(11, this.RZG);
      paramInt = i;
      if (this.InV != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.InV);
      }
      i = paramInt;
      if (this.RZo != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.RZo);
      }
      i = i + g.a.a.b.b.a.bM(14, this.RZH) + g.a.a.b.b.a.bM(15, this.RZI);
      paramInt = i;
      if (this.RZJ != null) {
        paramInt = i + g.a.a.a.oD(16, this.RZJ.computeSize());
      }
      i = paramInt;
      if (this.RZK != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.RZK);
      }
      i = i + g.a.a.b.b.a.bM(18, this.RZL) + g.a.a.b.b.a.bM(19, this.RZM) + g.a.a.b.b.a.bM(20, this.RZN);
      paramInt = i;
      if (this.RZO != null) {
        paramInt = i + g.a.a.b.b.a.b(21, this.RZO);
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.RZP) + g.a.a.b.b.a.bM(23, this.ImF);
      paramInt = i;
      if (this.ImG != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.ImG);
      }
      i = paramInt;
      if (this.ImH != null) {
        i = paramInt + g.a.a.b.b.a.g(25, this.ImH);
      }
      i += g.a.a.b.b.a.bM(26, this.RZQ);
      paramInt = i;
      if (this.ImI != null) {
        paramInt = i + g.a.a.b.b.a.g(27, this.ImI);
      }
      i = paramInt;
      if (this.ImJ != null) {
        i = paramInt + g.a.a.b.b.a.g(28, this.ImJ);
      }
      i += g.a.a.b.b.a.bM(29, this.RZR);
      paramInt = i;
      if (this.RZS != null) {
        paramInt = i + g.a.a.a.oD(30, this.RZS.computeSize());
      }
      i = paramInt;
      if (this.RZT != null) {
        i = paramInt + g.a.a.a.oD(31, this.RZT.computeSize());
      }
      paramInt = i;
      if (this.RZU != null) {
        paramInt = i + g.a.a.a.oD(32, this.RZU.computeSize());
      }
      i = paramInt;
      if (this.RZV != null) {
        i = paramInt + g.a.a.a.oD(33, this.RZV.computeSize());
      }
      AppMethodBeat.o(91375);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91375);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rb localrb = (rb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91375);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localrb.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 2: 
          localrb.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 3: 
          localrb.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 4: 
          localrb.fHb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 5: 
          localrb.RZC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eig();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eig)localObject2).parseFrom((byte[])localObject1);
            }
            localrb.RZD = ((eig)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 7: 
          localrb.RJf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 8: 
          localrb.RJg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 9: 
          localrb.RZE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 10: 
          localrb.RZF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 11: 
          localrb.RZG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 12: 
          localrb.InV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 13: 
          localrb.RZo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 14: 
          localrb.RZH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 15: 
          localrb.RZI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esi)localObject2).parseFrom((byte[])localObject1);
            }
            localrb.RZJ = ((esi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 17: 
          localrb.RZK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 18: 
          localrb.RZL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 19: 
          localrb.RZM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 20: 
          localrb.RZN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 21: 
          localrb.RZO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(91375);
          return 0;
        case 22: 
          localrb.RZP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 23: 
          localrb.ImF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 24: 
          localrb.ImG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 25: 
          localrb.ImH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 26: 
          localrb.RZQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 27: 
          localrb.ImI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 28: 
          localrb.ImJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 29: 
          localrb.RZR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91375);
          return 0;
        case 30: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qu)localObject2).parseFrom((byte[])localObject1);
            }
            localrb.RZS = ((qu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ea();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ea)localObject2).parseFrom((byte[])localObject1);
            }
            localrb.RZT = ((ea)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dz)localObject2).parseFrom((byte[])localObject1);
            }
            localrb.RZU = ((dz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new zk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((zk)localObject2).parseFrom((byte[])localObject1);
          }
          localrb.RZV = ((zk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      AppMethodBeat.o(91375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rb
 * JD-Core Version:    0.7.0.1
 */