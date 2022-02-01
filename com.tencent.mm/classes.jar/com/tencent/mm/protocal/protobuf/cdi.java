package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdi
  extends cvw
{
  public int FKD;
  public String FKE;
  public String FKF;
  public int FSf;
  public String FSg;
  public SKBuiltinBuffer_t FSi;
  public SKBuiltinBuffer_t FSj;
  public afy FSp;
  public int FWi;
  public SKBuiltinBuffer_t FWl;
  public int FWo;
  public String FWp;
  public String FWw;
  public String GNv;
  public String GWZ;
  public String GXa;
  public int GXb;
  public String GwD;
  public String Gzg;
  public String Hll;
  public int HpS;
  public int HpT;
  public int HpU;
  public String HpV;
  public String HpW;
  public String HpX;
  public String HpY;
  public String HpZ;
  public String Hqa;
  public int Hqb;
  public String Hqc;
  public String Hqd;
  public String jga;
  public String nIJ;
  public String nJO;
  public String qkM;
  public String qkN;
  public String xrf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133184);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.FWw != null) {
        paramVarArgs.d(3, this.FWw);
      }
      if (this.nJO != null) {
        paramVarArgs.d(4, this.nJO);
      }
      paramVarArgs.aS(5, this.FKD);
      if (this.FKE != null) {
        paramVarArgs.d(6, this.FKE);
      }
      if (this.FKF != null) {
        paramVarArgs.d(7, this.FKF);
      }
      if (this.xrf != null) {
        paramVarArgs.d(8, this.xrf);
      }
      paramVarArgs.aS(12, this.FSf);
      paramVarArgs.aS(13, this.HpS);
      paramVarArgs.aS(14, this.GXb);
      if (this.qkM != null) {
        paramVarArgs.d(15, this.qkM);
      }
      if (this.qkN != null) {
        paramVarArgs.d(16, this.qkN);
      }
      paramVarArgs.aS(17, this.FWi);
      if (this.GwD != null) {
        paramVarArgs.d(18, this.GwD);
      }
      if (this.FWl != null)
      {
        paramVarArgs.lJ(19, this.FWl.computeSize());
        this.FWl.writeFields(paramVarArgs);
      }
      if (this.jga != null) {
        paramVarArgs.d(20, this.jga);
      }
      if (this.GWZ != null) {
        paramVarArgs.d(21, this.GWZ);
      }
      if (this.GXa != null) {
        paramVarArgs.d(22, this.GXa);
      }
      paramVarArgs.aS(23, this.HpT);
      paramVarArgs.aS(24, this.HpU);
      if (this.FSg != null) {
        paramVarArgs.d(31, this.FSg);
      }
      if (this.Hll != null) {
        paramVarArgs.d(32, this.Hll);
      }
      if (this.HpV != null) {
        paramVarArgs.d(33, this.HpV);
      }
      if (this.Gzg != null) {
        paramVarArgs.d(34, this.Gzg);
      }
      if (this.HpW != null) {
        paramVarArgs.d(35, this.HpW);
      }
      if (this.HpX != null) {
        paramVarArgs.d(36, this.HpX);
      }
      if (this.FSp != null)
      {
        paramVarArgs.lJ(37, this.FSp.computeSize());
        this.FSp.writeFields(paramVarArgs);
      }
      if (this.HpY != null) {
        paramVarArgs.d(38, this.HpY);
      }
      if (this.GNv != null) {
        paramVarArgs.d(39, this.GNv);
      }
      if (this.HpZ != null) {
        paramVarArgs.d(40, this.HpZ);
      }
      if (this.Hqa != null) {
        paramVarArgs.d(41, this.Hqa);
      }
      paramVarArgs.aS(42, this.Hqb);
      if (this.FSi != null)
      {
        paramVarArgs.lJ(43, this.FSi.computeSize());
        this.FSi.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(44, this.FWo);
      if (this.FWp != null) {
        paramVarArgs.d(45, this.FWp);
      }
      if (this.Hqc != null) {
        paramVarArgs.d(46, this.Hqc);
      }
      if (this.Hqd != null) {
        paramVarArgs.d(47, this.Hqd);
      }
      if (this.FSj != null)
      {
        paramVarArgs.lJ(48, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2922;
      }
    }
    label2922:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.FWw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FWw);
      }
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nJO);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FKD);
      paramInt = i;
      if (this.FKE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FKE);
      }
      i = paramInt;
      if (this.FKF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FKF);
      }
      paramInt = i;
      if (this.xrf != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.xrf);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.FSf) + f.a.a.b.b.a.bz(13, this.HpS) + f.a.a.b.b.a.bz(14, this.GXb);
      paramInt = i;
      if (this.qkM != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.qkM);
      }
      i = paramInt;
      if (this.qkN != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.qkN);
      }
      i += f.a.a.b.b.a.bz(17, this.FWi);
      paramInt = i;
      if (this.GwD != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.GwD);
      }
      i = paramInt;
      if (this.FWl != null) {
        i = paramInt + f.a.a.a.lI(19, this.FWl.computeSize());
      }
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.jga);
      }
      i = paramInt;
      if (this.GWZ != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.GWZ);
      }
      paramInt = i;
      if (this.GXa != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.GXa);
      }
      i = paramInt + f.a.a.b.b.a.bz(23, this.HpT) + f.a.a.b.b.a.bz(24, this.HpU);
      paramInt = i;
      if (this.FSg != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.FSg);
      }
      i = paramInt;
      if (this.Hll != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.Hll);
      }
      paramInt = i;
      if (this.HpV != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.HpV);
      }
      i = paramInt;
      if (this.Gzg != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.Gzg);
      }
      paramInt = i;
      if (this.HpW != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.HpW);
      }
      i = paramInt;
      if (this.HpX != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.HpX);
      }
      paramInt = i;
      if (this.FSp != null) {
        paramInt = i + f.a.a.a.lI(37, this.FSp.computeSize());
      }
      i = paramInt;
      if (this.HpY != null) {
        i = paramInt + f.a.a.b.b.a.e(38, this.HpY);
      }
      paramInt = i;
      if (this.GNv != null) {
        paramInt = i + f.a.a.b.b.a.e(39, this.GNv);
      }
      i = paramInt;
      if (this.HpZ != null) {
        i = paramInt + f.a.a.b.b.a.e(40, this.HpZ);
      }
      paramInt = i;
      if (this.Hqa != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.Hqa);
      }
      i = paramInt + f.a.a.b.b.a.bz(42, this.Hqb);
      paramInt = i;
      if (this.FSi != null) {
        paramInt = i + f.a.a.a.lI(43, this.FSi.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(44, this.FWo);
      paramInt = i;
      if (this.FWp != null) {
        paramInt = i + f.a.a.b.b.a.e(45, this.FWp);
      }
      i = paramInt;
      if (this.Hqc != null) {
        i = paramInt + f.a.a.b.b.a.e(46, this.Hqc);
      }
      paramInt = i;
      if (this.Hqd != null) {
        paramInt = i + f.a.a.b.b.a.e(47, this.Hqd);
      }
      i = paramInt;
      if (this.FSj != null) {
        i = paramInt + f.a.a.a.lI(48, this.FSj.computeSize());
      }
      AppMethodBeat.o(133184);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdi localcdi = (cdi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        case 11: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        default: 
          AppMethodBeat.o(133184);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 2: 
          localcdi.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 3: 
          localcdi.FWw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 4: 
          localcdi.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 5: 
          localcdi.FKD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 6: 
          localcdi.FKE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 7: 
          localcdi.FKF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 8: 
          localcdi.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 12: 
          localcdi.FSf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 13: 
          localcdi.HpS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 14: 
          localcdi.GXb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 15: 
          localcdi.qkM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 16: 
          localcdi.qkN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 17: 
          localcdi.FWi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 18: 
          localcdi.GwD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdi.FWl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 20: 
          localcdi.jga = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 21: 
          localcdi.GWZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 22: 
          localcdi.GXa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 23: 
          localcdi.HpT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 24: 
          localcdi.HpU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 31: 
          localcdi.FSg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 32: 
          localcdi.Hll = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 33: 
          localcdi.HpV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 34: 
          localcdi.Gzg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 35: 
          localcdi.HpW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 36: 
          localcdi.HpX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 37: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdi.FSp = ((afy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 38: 
          localcdi.HpY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 39: 
          localcdi.GNv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 40: 
          localcdi.HpZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 41: 
          localcdi.Hqa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 42: 
          localcdi.Hqb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 43: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdi.FSi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 44: 
          localcdi.FWo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 45: 
          localcdi.FWp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 46: 
          localcdi.Hqc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 47: 
          localcdi.Hqd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(133184);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdi.FSj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      AppMethodBeat.o(133184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdi
 * JD-Core Version:    0.7.0.1
 */