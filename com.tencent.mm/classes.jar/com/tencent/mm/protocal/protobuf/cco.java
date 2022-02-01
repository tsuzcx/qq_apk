package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cco
  extends cvc
{
  public int FDN;
  public SKBuiltinBuffer_t FDQ;
  public int FDT;
  public String FDU;
  public String FEb;
  public int Fsf;
  public String Fsg;
  public String Fsh;
  public int FzH;
  public String FzI;
  public SKBuiltinBuffer_t FzK;
  public SKBuiltinBuffer_t FzL;
  public afp FzR;
  public String GDw;
  public String GDx;
  public int GDy;
  public String GRK;
  public String GWA;
  public int GWB;
  public String GWC;
  public String GWD;
  public int GWs;
  public int GWt;
  public int GWu;
  public String GWv;
  public String GWw;
  public String GWx;
  public String GWy;
  public String GWz;
  public String GdW;
  public String Ggx;
  public String GtW;
  public String jdh;
  public String nDo;
  public String nEt;
  public String qeh;
  public String qei;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133184);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      if (this.FEb != null) {
        paramVarArgs.d(3, this.FEb);
      }
      if (this.nEt != null) {
        paramVarArgs.d(4, this.nEt);
      }
      paramVarArgs.aS(5, this.Fsf);
      if (this.Fsg != null) {
        paramVarArgs.d(6, this.Fsg);
      }
      if (this.Fsh != null) {
        paramVarArgs.d(7, this.Fsh);
      }
      if (this.xbo != null) {
        paramVarArgs.d(8, this.xbo);
      }
      paramVarArgs.aS(12, this.FzH);
      paramVarArgs.aS(13, this.GWs);
      paramVarArgs.aS(14, this.GDy);
      if (this.qeh != null) {
        paramVarArgs.d(15, this.qeh);
      }
      if (this.qei != null) {
        paramVarArgs.d(16, this.qei);
      }
      paramVarArgs.aS(17, this.FDN);
      if (this.GdW != null) {
        paramVarArgs.d(18, this.GdW);
      }
      if (this.FDQ != null)
      {
        paramVarArgs.lC(19, this.FDQ.computeSize());
        this.FDQ.writeFields(paramVarArgs);
      }
      if (this.jdh != null) {
        paramVarArgs.d(20, this.jdh);
      }
      if (this.GDw != null) {
        paramVarArgs.d(21, this.GDw);
      }
      if (this.GDx != null) {
        paramVarArgs.d(22, this.GDx);
      }
      paramVarArgs.aS(23, this.GWt);
      paramVarArgs.aS(24, this.GWu);
      if (this.FzI != null) {
        paramVarArgs.d(31, this.FzI);
      }
      if (this.GRK != null) {
        paramVarArgs.d(32, this.GRK);
      }
      if (this.GWv != null) {
        paramVarArgs.d(33, this.GWv);
      }
      if (this.Ggx != null) {
        paramVarArgs.d(34, this.Ggx);
      }
      if (this.GWw != null) {
        paramVarArgs.d(35, this.GWw);
      }
      if (this.GWx != null) {
        paramVarArgs.d(36, this.GWx);
      }
      if (this.FzR != null)
      {
        paramVarArgs.lC(37, this.FzR.computeSize());
        this.FzR.writeFields(paramVarArgs);
      }
      if (this.GWy != null) {
        paramVarArgs.d(38, this.GWy);
      }
      if (this.GtW != null) {
        paramVarArgs.d(39, this.GtW);
      }
      if (this.GWz != null) {
        paramVarArgs.d(40, this.GWz);
      }
      if (this.GWA != null) {
        paramVarArgs.d(41, this.GWA);
      }
      paramVarArgs.aS(42, this.GWB);
      if (this.FzK != null)
      {
        paramVarArgs.lC(43, this.FzK.computeSize());
        this.FzK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(44, this.FDT);
      if (this.FDU != null) {
        paramVarArgs.d(45, this.FDU);
      }
      if (this.GWC != null) {
        paramVarArgs.d(46, this.GWC);
      }
      if (this.GWD != null) {
        paramVarArgs.d(47, this.GWD);
      }
      if (this.FzL != null)
      {
        paramVarArgs.lC(48, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.FEb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FEb);
      }
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nEt);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Fsf);
      paramInt = i;
      if (this.Fsg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fsg);
      }
      i = paramInt;
      if (this.Fsh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Fsh);
      }
      paramInt = i;
      if (this.xbo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.xbo);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.FzH) + f.a.a.b.b.a.bz(13, this.GWs) + f.a.a.b.b.a.bz(14, this.GDy);
      paramInt = i;
      if (this.qeh != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.qeh);
      }
      i = paramInt;
      if (this.qei != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.qei);
      }
      i += f.a.a.b.b.a.bz(17, this.FDN);
      paramInt = i;
      if (this.GdW != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.GdW);
      }
      i = paramInt;
      if (this.FDQ != null) {
        i = paramInt + f.a.a.a.lB(19, this.FDQ.computeSize());
      }
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.jdh);
      }
      i = paramInt;
      if (this.GDw != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.GDw);
      }
      paramInt = i;
      if (this.GDx != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.GDx);
      }
      i = paramInt + f.a.a.b.b.a.bz(23, this.GWt) + f.a.a.b.b.a.bz(24, this.GWu);
      paramInt = i;
      if (this.FzI != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.FzI);
      }
      i = paramInt;
      if (this.GRK != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.GRK);
      }
      paramInt = i;
      if (this.GWv != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.GWv);
      }
      i = paramInt;
      if (this.Ggx != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.Ggx);
      }
      paramInt = i;
      if (this.GWw != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.GWw);
      }
      i = paramInt;
      if (this.GWx != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.GWx);
      }
      paramInt = i;
      if (this.FzR != null) {
        paramInt = i + f.a.a.a.lB(37, this.FzR.computeSize());
      }
      i = paramInt;
      if (this.GWy != null) {
        i = paramInt + f.a.a.b.b.a.e(38, this.GWy);
      }
      paramInt = i;
      if (this.GtW != null) {
        paramInt = i + f.a.a.b.b.a.e(39, this.GtW);
      }
      i = paramInt;
      if (this.GWz != null) {
        i = paramInt + f.a.a.b.b.a.e(40, this.GWz);
      }
      paramInt = i;
      if (this.GWA != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.GWA);
      }
      i = paramInt + f.a.a.b.b.a.bz(42, this.GWB);
      paramInt = i;
      if (this.FzK != null) {
        paramInt = i + f.a.a.a.lB(43, this.FzK.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(44, this.FDT);
      paramInt = i;
      if (this.FDU != null) {
        paramInt = i + f.a.a.b.b.a.e(45, this.FDU);
      }
      i = paramInt;
      if (this.GWC != null) {
        i = paramInt + f.a.a.b.b.a.e(46, this.GWC);
      }
      paramInt = i;
      if (this.GWD != null) {
        paramInt = i + f.a.a.b.b.a.e(47, this.GWD);
      }
      i = paramInt;
      if (this.FzL != null) {
        i = paramInt + f.a.a.a.lB(48, this.FzL.computeSize());
      }
      AppMethodBeat.o(133184);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cco localcco = (cco)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcco.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 2: 
          localcco.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 3: 
          localcco.FEb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 4: 
          localcco.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 5: 
          localcco.Fsf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 6: 
          localcco.Fsg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 7: 
          localcco.Fsh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 8: 
          localcco.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 12: 
          localcco.FzH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 13: 
          localcco.GWs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 14: 
          localcco.GDy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 15: 
          localcco.qeh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 16: 
          localcco.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 17: 
          localcco.FDN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 18: 
          localcco.GdW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcco.FDQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 20: 
          localcco.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 21: 
          localcco.GDw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 22: 
          localcco.GDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 23: 
          localcco.GWt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 24: 
          localcco.GWu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 31: 
          localcco.FzI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 32: 
          localcco.GRK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 33: 
          localcco.GWv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 34: 
          localcco.Ggx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 35: 
          localcco.GWw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 36: 
          localcco.GWx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 37: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcco.FzR = ((afp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 38: 
          localcco.GWy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 39: 
          localcco.GtW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 40: 
          localcco.GWz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 41: 
          localcco.GWA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 42: 
          localcco.GWB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 43: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcco.FzK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 44: 
          localcco.FDT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133184);
          return 0;
        case 45: 
          localcco.FDU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 46: 
          localcco.GWC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 47: 
          localcco.GWD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133184);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcco.FzL = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cco
 * JD-Core Version:    0.7.0.1
 */