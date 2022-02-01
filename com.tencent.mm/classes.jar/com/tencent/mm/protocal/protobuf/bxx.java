package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxx
  extends cpx
{
  public int DNa;
  public String DNb;
  public String DNc;
  public int DUn;
  public String DUo;
  public SKBuiltinBuffer_t DUq;
  public SKBuiltinBuffer_t DUr;
  public ado DUx;
  public String DYF;
  public int DYr;
  public SKBuiltinBuffer_t DYu;
  public int DYx;
  public String DYy;
  public String EKT;
  public String ETZ;
  public String EUa;
  public int EUb;
  public String Ews;
  public String Ewu;
  public String EyL;
  public String Fij;
  public int FmJ;
  public int FmK;
  public int FmL;
  public String FmM;
  public String FmN;
  public String FmO;
  public String FmP;
  public String FmQ;
  public String FmR;
  public int FmS;
  public String FmT;
  public String FmU;
  public String iJY;
  public String ncR;
  public String ndW;
  public String pAC;
  public String pAD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133184);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      if (this.DYF != null) {
        paramVarArgs.d(3, this.DYF);
      }
      if (this.ndW != null) {
        paramVarArgs.d(4, this.ndW);
      }
      paramVarArgs.aR(5, this.DNa);
      if (this.DNb != null) {
        paramVarArgs.d(6, this.DNb);
      }
      if (this.DNc != null) {
        paramVarArgs.d(7, this.DNc);
      }
      if (this.Ewu != null) {
        paramVarArgs.d(8, this.Ewu);
      }
      paramVarArgs.aR(12, this.DUn);
      paramVarArgs.aR(13, this.FmJ);
      paramVarArgs.aR(14, this.EUb);
      if (this.pAC != null) {
        paramVarArgs.d(15, this.pAC);
      }
      if (this.pAD != null) {
        paramVarArgs.d(16, this.pAD);
      }
      paramVarArgs.aR(17, this.DYr);
      if (this.Ews != null) {
        paramVarArgs.d(18, this.Ews);
      }
      if (this.DYu != null)
      {
        paramVarArgs.ln(19, this.DYu.computeSize());
        this.DYu.writeFields(paramVarArgs);
      }
      if (this.iJY != null) {
        paramVarArgs.d(20, this.iJY);
      }
      if (this.ETZ != null) {
        paramVarArgs.d(21, this.ETZ);
      }
      if (this.EUa != null) {
        paramVarArgs.d(22, this.EUa);
      }
      paramVarArgs.aR(23, this.FmK);
      paramVarArgs.aR(24, this.FmL);
      if (this.DUo != null) {
        paramVarArgs.d(31, this.DUo);
      }
      if (this.Fij != null) {
        paramVarArgs.d(32, this.Fij);
      }
      if (this.FmM != null) {
        paramVarArgs.d(33, this.FmM);
      }
      if (this.EyL != null) {
        paramVarArgs.d(34, this.EyL);
      }
      if (this.FmN != null) {
        paramVarArgs.d(35, this.FmN);
      }
      if (this.FmO != null) {
        paramVarArgs.d(36, this.FmO);
      }
      if (this.DUx != null)
      {
        paramVarArgs.ln(37, this.DUx.computeSize());
        this.DUx.writeFields(paramVarArgs);
      }
      if (this.FmP != null) {
        paramVarArgs.d(38, this.FmP);
      }
      if (this.EKT != null) {
        paramVarArgs.d(39, this.EKT);
      }
      if (this.FmQ != null) {
        paramVarArgs.d(40, this.FmQ);
      }
      if (this.FmR != null) {
        paramVarArgs.d(41, this.FmR);
      }
      paramVarArgs.aR(42, this.FmS);
      if (this.DUq != null)
      {
        paramVarArgs.ln(43, this.DUq.computeSize());
        this.DUq.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(44, this.DYx);
      if (this.DYy != null) {
        paramVarArgs.d(45, this.DYy);
      }
      if (this.FmT != null) {
        paramVarArgs.d(46, this.FmT);
      }
      if (this.FmU != null) {
        paramVarArgs.d(47, this.FmU);
      }
      if (this.DUr != null)
      {
        paramVarArgs.ln(48, this.DUr.computeSize());
        this.DUr.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ncR);
      }
      i = paramInt;
      if (this.DYF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DYF);
      }
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ndW);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.DNa);
      paramInt = i;
      if (this.DNb != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DNb);
      }
      i = paramInt;
      if (this.DNc != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DNc);
      }
      paramInt = i;
      if (this.Ewu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Ewu);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.DUn) + f.a.a.b.b.a.bx(13, this.FmJ) + f.a.a.b.b.a.bx(14, this.EUb);
      paramInt = i;
      if (this.pAC != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.pAC);
      }
      i = paramInt;
      if (this.pAD != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.pAD);
      }
      i += f.a.a.b.b.a.bx(17, this.DYr);
      paramInt = i;
      if (this.Ews != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Ews);
      }
      i = paramInt;
      if (this.DYu != null) {
        i = paramInt + f.a.a.a.lm(19, this.DYu.computeSize());
      }
      paramInt = i;
      if (this.iJY != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.iJY);
      }
      i = paramInt;
      if (this.ETZ != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.ETZ);
      }
      paramInt = i;
      if (this.EUa != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.EUa);
      }
      i = paramInt + f.a.a.b.b.a.bx(23, this.FmK) + f.a.a.b.b.a.bx(24, this.FmL);
      paramInt = i;
      if (this.DUo != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.DUo);
      }
      i = paramInt;
      if (this.Fij != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.Fij);
      }
      paramInt = i;
      if (this.FmM != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.FmM);
      }
      i = paramInt;
      if (this.EyL != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.EyL);
      }
      paramInt = i;
      if (this.FmN != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.FmN);
      }
      i = paramInt;
      if (this.FmO != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.FmO);
      }
      paramInt = i;
      if (this.DUx != null) {
        paramInt = i + f.a.a.a.lm(37, this.DUx.computeSize());
      }
      i = paramInt;
      if (this.FmP != null) {
        i = paramInt + f.a.a.b.b.a.e(38, this.FmP);
      }
      paramInt = i;
      if (this.EKT != null) {
        paramInt = i + f.a.a.b.b.a.e(39, this.EKT);
      }
      i = paramInt;
      if (this.FmQ != null) {
        i = paramInt + f.a.a.b.b.a.e(40, this.FmQ);
      }
      paramInt = i;
      if (this.FmR != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.FmR);
      }
      i = paramInt + f.a.a.b.b.a.bx(42, this.FmS);
      paramInt = i;
      if (this.DUq != null) {
        paramInt = i + f.a.a.a.lm(43, this.DUq.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(44, this.DYx);
      paramInt = i;
      if (this.DYy != null) {
        paramInt = i + f.a.a.b.b.a.e(45, this.DYy);
      }
      i = paramInt;
      if (this.FmT != null) {
        i = paramInt + f.a.a.b.b.a.e(46, this.FmT);
      }
      paramInt = i;
      if (this.FmU != null) {
        paramInt = i + f.a.a.b.b.a.e(47, this.FmU);
      }
      i = paramInt;
      if (this.DUr != null) {
        i = paramInt + f.a.a.a.lm(48, this.DUr.computeSize());
      }
      AppMethodBeat.o(133184);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxx localbxx = (bxx)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 2: 
          localbxx.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 3: 
          localbxx.DYF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 4: 
          localbxx.ndW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 5: 
          localbxx.DNa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133184);
          return 0;
        case 6: 
          localbxx.DNb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 7: 
          localbxx.DNc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 8: 
          localbxx.Ewu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 12: 
          localbxx.DUn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133184);
          return 0;
        case 13: 
          localbxx.FmJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133184);
          return 0;
        case 14: 
          localbxx.EUb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133184);
          return 0;
        case 15: 
          localbxx.pAC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 16: 
          localbxx.pAD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 17: 
          localbxx.DYr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133184);
          return 0;
        case 18: 
          localbxx.Ews = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxx.DYu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 20: 
          localbxx.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 21: 
          localbxx.ETZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 22: 
          localbxx.EUa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 23: 
          localbxx.FmK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133184);
          return 0;
        case 24: 
          localbxx.FmL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133184);
          return 0;
        case 31: 
          localbxx.DUo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 32: 
          localbxx.Fij = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 33: 
          localbxx.FmM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 34: 
          localbxx.EyL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 35: 
          localbxx.FmN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 36: 
          localbxx.FmO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 37: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ado();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ado)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxx.DUx = ((ado)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 38: 
          localbxx.FmP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 39: 
          localbxx.EKT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 40: 
          localbxx.FmQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 41: 
          localbxx.FmR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 42: 
          localbxx.FmS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133184);
          return 0;
        case 43: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxx.DUq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 44: 
          localbxx.DYx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133184);
          return 0;
        case 45: 
          localbxx.DYy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 46: 
          localbxx.FmT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 47: 
          localbxx.FmU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133184);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxx.DUr = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxx
 * JD-Core Version:    0.7.0.1
 */