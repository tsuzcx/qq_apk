package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auk
  extends cqk
{
  public String DMA;
  public String DMB;
  public String DMC;
  public String DMD;
  public String DME;
  public String DMF;
  public boolean DMG = false;
  public int DMH;
  public int DMI;
  public int DMJ;
  public String DMK;
  public String DML;
  public String DMN;
  public String DMO;
  public String DMP;
  public String DMQ;
  public String DMR;
  public String DMS;
  public String DMT;
  public String DMU;
  public String DMu;
  public String DMv;
  public String DMw;
  public String DMx;
  public String DMy;
  public String DMz;
  public int EMP;
  public String content;
  public String hiu;
  public String nUr;
  public int nVm;
  public String nVn;
  public String nVo;
  public String nVp;
  public String nVq;
  public String nVr;
  public String nVs;
  public int nVt;
  public String nVu;
  public String nVv;
  public String nVw;
  public String nVx;
  public String nVy;
  public String nVz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114009);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DMu != null) {
        paramVarArgs.d(2, this.DMu);
      }
      if (this.DMv != null) {
        paramVarArgs.d(3, this.DMv);
      }
      if (this.DMw != null) {
        paramVarArgs.d(4, this.DMw);
      }
      if (this.content != null) {
        paramVarArgs.d(5, this.content);
      }
      if (this.DMx != null) {
        paramVarArgs.d(6, this.DMx);
      }
      if (this.DMy != null) {
        paramVarArgs.d(7, this.DMy);
      }
      if (this.DMz != null) {
        paramVarArgs.d(8, this.DMz);
      }
      if (this.DMA != null) {
        paramVarArgs.d(9, this.DMA);
      }
      if (this.DMB != null) {
        paramVarArgs.d(10, this.DMB);
      }
      if (this.DMC != null) {
        paramVarArgs.d(11, this.DMC);
      }
      if (this.DMD != null) {
        paramVarArgs.d(12, this.DMD);
      }
      if (this.DME != null) {
        paramVarArgs.d(13, this.DME);
      }
      if (this.nVy != null) {
        paramVarArgs.d(14, this.nVy);
      }
      if (this.nVz != null) {
        paramVarArgs.d(15, this.nVz);
      }
      if (this.DMF != null) {
        paramVarArgs.d(16, this.DMF);
      }
      paramVarArgs.bl(17, this.DMG);
      paramVarArgs.aR(18, this.DMH);
      paramVarArgs.aR(19, this.DMI);
      paramVarArgs.aR(20, this.DMJ);
      if (this.hiu != null) {
        paramVarArgs.d(21, this.hiu);
      }
      if (this.DMK != null) {
        paramVarArgs.d(22, this.DMK);
      }
      if (this.DML != null) {
        paramVarArgs.d(23, this.DML);
      }
      paramVarArgs.aR(24, this.EMP);
      if (this.DMN != null) {
        paramVarArgs.d(25, this.DMN);
      }
      if (this.DMO != null) {
        paramVarArgs.d(26, this.DMO);
      }
      if (this.DMP != null) {
        paramVarArgs.d(27, this.DMP);
      }
      if (this.DMQ != null) {
        paramVarArgs.d(28, this.DMQ);
      }
      if (this.DMR != null) {
        paramVarArgs.d(29, this.DMR);
      }
      if (this.DMS != null) {
        paramVarArgs.d(30, this.DMS);
      }
      if (this.DMT != null) {
        paramVarArgs.d(31, this.DMT);
      }
      if (this.nUr != null) {
        paramVarArgs.d(32, this.nUr);
      }
      if (this.DMU != null) {
        paramVarArgs.d(33, this.DMU);
      }
      paramVarArgs.aR(37, this.nVm);
      if (this.nVn != null) {
        paramVarArgs.d(38, this.nVn);
      }
      if (this.nVo != null) {
        paramVarArgs.d(39, this.nVo);
      }
      if (this.nVp != null) {
        paramVarArgs.d(40, this.nVp);
      }
      if (this.nVq != null) {
        paramVarArgs.d(41, this.nVq);
      }
      if (this.nVr != null) {
        paramVarArgs.d(42, this.nVr);
      }
      if (this.nVs != null) {
        paramVarArgs.d(43, this.nVs);
      }
      paramVarArgs.aR(44, this.nVt);
      if (this.nVu != null) {
        paramVarArgs.d(45, this.nVu);
      }
      if (this.nVv != null) {
        paramVarArgs.d(46, this.nVv);
      }
      if (this.nVw != null) {
        paramVarArgs.d(47, this.nVw);
      }
      if (this.nVx != null) {
        paramVarArgs.d(48, this.nVx);
      }
      AppMethodBeat.o(114009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2922;
      }
    }
    label2922:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DMu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DMu);
      }
      i = paramInt;
      if (this.DMv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DMv);
      }
      paramInt = i;
      if (this.DMw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DMw);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.content);
      }
      paramInt = i;
      if (this.DMx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DMx);
      }
      i = paramInt;
      if (this.DMy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DMy);
      }
      paramInt = i;
      if (this.DMz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DMz);
      }
      i = paramInt;
      if (this.DMA != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DMA);
      }
      paramInt = i;
      if (this.DMB != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DMB);
      }
      i = paramInt;
      if (this.DMC != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DMC);
      }
      paramInt = i;
      if (this.DMD != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DMD);
      }
      i = paramInt;
      if (this.DME != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DME);
      }
      paramInt = i;
      if (this.nVy != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.nVy);
      }
      i = paramInt;
      if (this.nVz != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.nVz);
      }
      paramInt = i;
      if (this.DMF != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DMF);
      }
      i = paramInt + (f.a.a.b.b.a.fK(17) + 1) + f.a.a.b.b.a.bx(18, this.DMH) + f.a.a.b.b.a.bx(19, this.DMI) + f.a.a.b.b.a.bx(20, this.DMJ);
      paramInt = i;
      if (this.hiu != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.hiu);
      }
      i = paramInt;
      if (this.DMK != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.DMK);
      }
      paramInt = i;
      if (this.DML != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.DML);
      }
      i = paramInt + f.a.a.b.b.a.bx(24, this.EMP);
      paramInt = i;
      if (this.DMN != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.DMN);
      }
      i = paramInt;
      if (this.DMO != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.DMO);
      }
      paramInt = i;
      if (this.DMP != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.DMP);
      }
      i = paramInt;
      if (this.DMQ != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.DMQ);
      }
      paramInt = i;
      if (this.DMR != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.DMR);
      }
      i = paramInt;
      if (this.DMS != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.DMS);
      }
      paramInt = i;
      if (this.DMT != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.DMT);
      }
      i = paramInt;
      if (this.nUr != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.nUr);
      }
      paramInt = i;
      if (this.DMU != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.DMU);
      }
      i = paramInt + f.a.a.b.b.a.bx(37, this.nVm);
      paramInt = i;
      if (this.nVn != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.nVn);
      }
      i = paramInt;
      if (this.nVo != null) {
        i = paramInt + f.a.a.b.b.a.e(39, this.nVo);
      }
      paramInt = i;
      if (this.nVp != null) {
        paramInt = i + f.a.a.b.b.a.e(40, this.nVp);
      }
      i = paramInt;
      if (this.nVq != null) {
        i = paramInt + f.a.a.b.b.a.e(41, this.nVq);
      }
      paramInt = i;
      if (this.nVr != null) {
        paramInt = i + f.a.a.b.b.a.e(42, this.nVr);
      }
      i = paramInt;
      if (this.nVs != null) {
        i = paramInt + f.a.a.b.b.a.e(43, this.nVs);
      }
      i += f.a.a.b.b.a.bx(44, this.nVt);
      paramInt = i;
      if (this.nVu != null) {
        paramInt = i + f.a.a.b.b.a.e(45, this.nVu);
      }
      i = paramInt;
      if (this.nVv != null) {
        i = paramInt + f.a.a.b.b.a.e(46, this.nVv);
      }
      paramInt = i;
      if (this.nVw != null) {
        paramInt = i + f.a.a.b.b.a.e(47, this.nVw);
      }
      i = paramInt;
      if (this.nVx != null) {
        i = paramInt + f.a.a.b.b.a.e(48, this.nVx);
      }
      AppMethodBeat.o(114009);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        auk localauk = (auk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 34: 
        case 35: 
        case 36: 
        default: 
          AppMethodBeat.o(114009);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114009);
          return 0;
        case 2: 
          localauk.DMu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 3: 
          localauk.DMv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 4: 
          localauk.DMw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 5: 
          localauk.content = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 6: 
          localauk.DMx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 7: 
          localauk.DMy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 8: 
          localauk.DMz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 9: 
          localauk.DMA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 10: 
          localauk.DMB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 11: 
          localauk.DMC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 12: 
          localauk.DMD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 13: 
          localauk.DME = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 14: 
          localauk.nVy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 15: 
          localauk.nVz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 16: 
          localauk.DMF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 17: 
          localauk.DMG = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(114009);
          return 0;
        case 18: 
          localauk.DMH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114009);
          return 0;
        case 19: 
          localauk.DMI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114009);
          return 0;
        case 20: 
          localauk.DMJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114009);
          return 0;
        case 21: 
          localauk.hiu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 22: 
          localauk.DMK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 23: 
          localauk.DML = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 24: 
          localauk.EMP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114009);
          return 0;
        case 25: 
          localauk.DMN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 26: 
          localauk.DMO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 27: 
          localauk.DMP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 28: 
          localauk.DMQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 29: 
          localauk.DMR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 30: 
          localauk.DMS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 31: 
          localauk.DMT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 32: 
          localauk.nUr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 33: 
          localauk.DMU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 37: 
          localauk.nVm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114009);
          return 0;
        case 38: 
          localauk.nVn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 39: 
          localauk.nVo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 40: 
          localauk.nVp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 41: 
          localauk.nVq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 42: 
          localauk.nVr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 43: 
          localauk.nVs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 44: 
          localauk.nVt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114009);
          return 0;
        case 45: 
          localauk.nVu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 46: 
          localauk.nVv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 47: 
          localauk.nVw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114009);
          return 0;
        }
        localauk.nVx = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(114009);
        return 0;
      }
      AppMethodBeat.o(114009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auk
 * JD-Core Version:    0.7.0.1
 */