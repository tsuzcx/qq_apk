package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fep
  extends com.tencent.mm.cd.a
{
  public int DQe;
  public fev UCF;
  public fev UCG;
  public int UEB;
  public fdc UEC;
  public fdc UED;
  public int UEE;
  public int UEF;
  public int UEG;
  public int UEH;
  public eae UEI;
  public int UEJ;
  public fdc UEK;
  public int UEL;
  public int UEM;
  public int UEN;
  public int UEO;
  public int UEP;
  public int UEQ;
  public eae UER;
  public eae UES;
  public int UET;
  public eae UEU;
  public int UEV;
  public int UEW;
  public int UEX;
  public cnt UEY;
  public eae UEZ;
  public dwd UEu;
  public ahv UEv;
  public int UFa;
  public String UFb;
  public int UFc;
  public LinkedList<feq> UFd;
  public bys UFe;
  
  public fep()
  {
    AppMethodBeat.i(115899);
    this.UFd = new LinkedList();
    AppMethodBeat.o(115899);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115900);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UCF == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.UCG == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.UCF != null)
      {
        paramVarArgs.oE(1, this.UCF.computeSize());
        this.UCF.writeFields(paramVarArgs);
      }
      if (this.UCG != null)
      {
        paramVarArgs.oE(2, this.UCG.computeSize());
        this.UCG.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.UEB);
      if (this.UEC != null)
      {
        paramVarArgs.oE(4, this.UEC.computeSize());
        this.UEC.writeFields(paramVarArgs);
      }
      if (this.UED != null)
      {
        paramVarArgs.oE(5, this.UED.computeSize());
        this.UED.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.UEE);
      paramVarArgs.aY(7, this.UEF);
      paramVarArgs.aY(8, this.UEG);
      paramVarArgs.aY(9, this.UEH);
      if (this.UEI != null)
      {
        paramVarArgs.oE(10, this.UEI.computeSize());
        this.UEI.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.UEJ);
      if (this.UEK != null)
      {
        paramVarArgs.oE(12, this.UEK.computeSize());
        this.UEK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.UEL);
      paramVarArgs.aY(14, this.UEM);
      paramVarArgs.aY(15, this.UEN);
      paramVarArgs.aY(16, this.UEO);
      paramVarArgs.aY(17, this.UEP);
      paramVarArgs.aY(18, this.DQe);
      paramVarArgs.aY(19, this.UEQ);
      if (this.UER != null)
      {
        paramVarArgs.oE(20, this.UER.computeSize());
        this.UER.writeFields(paramVarArgs);
      }
      if (this.UES != null)
      {
        paramVarArgs.oE(21, this.UES.computeSize());
        this.UES.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(22, this.UET);
      if (this.UEU != null)
      {
        paramVarArgs.oE(23, this.UEU.computeSize());
        this.UEU.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(24, this.UEV);
      paramVarArgs.aY(25, this.UEW);
      paramVarArgs.aY(26, this.UEX);
      if (this.UEY != null)
      {
        paramVarArgs.oE(27, this.UEY.computeSize());
        this.UEY.writeFields(paramVarArgs);
      }
      if (this.UEZ != null)
      {
        paramVarArgs.oE(28, this.UEZ.computeSize());
        this.UEZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(29, this.UFa);
      if (this.UFb != null) {
        paramVarArgs.f(30, this.UFb);
      }
      paramVarArgs.aY(31, this.UFc);
      paramVarArgs.e(32, 8, this.UFd);
      if (this.UEu != null)
      {
        paramVarArgs.oE(33, this.UEu.computeSize());
        this.UEu.writeFields(paramVarArgs);
      }
      if (this.UEv != null)
      {
        paramVarArgs.oE(34, this.UEv.computeSize());
        this.UEv.writeFields(paramVarArgs);
      }
      if (this.UFe != null)
      {
        paramVarArgs.oE(35, this.UFe.computeSize());
        this.UFe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UCF == null) {
        break label3152;
      }
    }
    label3152:
    for (paramInt = g.a.a.a.oD(1, this.UCF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UCG != null) {
        i = paramInt + g.a.a.a.oD(2, this.UCG.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.UEB);
      paramInt = i;
      if (this.UEC != null) {
        paramInt = i + g.a.a.a.oD(4, this.UEC.computeSize());
      }
      i = paramInt;
      if (this.UED != null) {
        i = paramInt + g.a.a.a.oD(5, this.UED.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(6, this.UEE) + g.a.a.b.b.a.bM(7, this.UEF) + g.a.a.b.b.a.bM(8, this.UEG) + g.a.a.b.b.a.bM(9, this.UEH);
      paramInt = i;
      if (this.UEI != null) {
        paramInt = i + g.a.a.a.oD(10, this.UEI.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.UEJ);
      paramInt = i;
      if (this.UEK != null) {
        paramInt = i + g.a.a.a.oD(12, this.UEK.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.UEL) + g.a.a.b.b.a.bM(14, this.UEM) + g.a.a.b.b.a.bM(15, this.UEN) + g.a.a.b.b.a.bM(16, this.UEO) + g.a.a.b.b.a.bM(17, this.UEP) + g.a.a.b.b.a.bM(18, this.DQe) + g.a.a.b.b.a.bM(19, this.UEQ);
      paramInt = i;
      if (this.UER != null) {
        paramInt = i + g.a.a.a.oD(20, this.UER.computeSize());
      }
      i = paramInt;
      if (this.UES != null) {
        i = paramInt + g.a.a.a.oD(21, this.UES.computeSize());
      }
      i += g.a.a.b.b.a.bM(22, this.UET);
      paramInt = i;
      if (this.UEU != null) {
        paramInt = i + g.a.a.a.oD(23, this.UEU.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(24, this.UEV) + g.a.a.b.b.a.bM(25, this.UEW) + g.a.a.b.b.a.bM(26, this.UEX);
      paramInt = i;
      if (this.UEY != null) {
        paramInt = i + g.a.a.a.oD(27, this.UEY.computeSize());
      }
      i = paramInt;
      if (this.UEZ != null) {
        i = paramInt + g.a.a.a.oD(28, this.UEZ.computeSize());
      }
      i += g.a.a.b.b.a.bM(29, this.UFa);
      paramInt = i;
      if (this.UFb != null) {
        paramInt = i + g.a.a.b.b.a.g(30, this.UFb);
      }
      i = paramInt + g.a.a.b.b.a.bM(31, this.UFc) + g.a.a.a.c(32, 8, this.UFd);
      paramInt = i;
      if (this.UEu != null) {
        paramInt = i + g.a.a.a.oD(33, this.UEu.computeSize());
      }
      i = paramInt;
      if (this.UEv != null) {
        i = paramInt + g.a.a.a.oD(34, this.UEv.computeSize());
      }
      paramInt = i;
      if (this.UFe != null) {
        paramInt = i + g.a.a.a.oD(35, this.UFe.computeSize());
      }
      AppMethodBeat.o(115900);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UFd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UCF == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        if (this.UCG == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fep localfep = (fep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115900);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fev();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fev)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.UCF = ((fev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fev();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fev)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.UCG = ((fev)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 3: 
          localfep.UEB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdc)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.UEC = ((fdc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdc)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.UED = ((fdc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 6: 
          localfep.UEE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 7: 
          localfep.UEF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 8: 
          localfep.UEG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 9: 
          localfep.UEH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
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
            localfep.UEI = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 11: 
          localfep.UEJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdc)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.UEK = ((fdc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 13: 
          localfep.UEL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 14: 
          localfep.UEM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 15: 
          localfep.UEN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 16: 
          localfep.UEO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 17: 
          localfep.UEP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 18: 
          localfep.DQe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 19: 
          localfep.UEQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 20: 
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
            localfep.UER = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 21: 
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
            localfep.UES = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 22: 
          localfep.UET = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 23: 
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
            localfep.UEU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 24: 
          localfep.UEV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 25: 
          localfep.UEW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 26: 
          localfep.UEX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 27: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cnt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cnt)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.UEY = ((cnt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 28: 
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
            localfep.UEZ = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 29: 
          localfep.UFa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 30: 
          localfep.UFb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115900);
          return 0;
        case 31: 
          localfep.UFc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115900);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new feq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((feq)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.UFd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dwd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dwd)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.UEu = ((dwd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 34: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahv)localObject2).parseFrom((byte[])localObject1);
            }
            localfep.UEv = ((ahv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bys();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bys)localObject2).parseFrom((byte[])localObject1);
          }
          localfep.UFe = ((bys)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      AppMethodBeat.o(115900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fep
 * JD-Core Version:    0.7.0.1
 */