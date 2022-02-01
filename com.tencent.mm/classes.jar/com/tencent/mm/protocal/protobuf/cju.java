package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cju
  extends cqk
{
  public String AXd;
  public String AYl;
  public int ErG;
  public boolean FdJ;
  public int Foc;
  public cga Foi;
  public String Fwv;
  public String Fwx;
  public String FxA;
  public int FxB;
  public LinkedList<acz> FxC;
  public int FxD;
  public LinkedList<acz> FxE;
  public acz FxF;
  public LinkedList<acz> FxG;
  public acz FxH;
  public bum FxI;
  public String FxJ;
  public int FxK;
  public String FxL;
  public int FxM;
  public boolean FxN;
  public String FxO;
  public String FxP;
  public LinkedList<bxp> FxQ;
  public String FxR;
  public String FxS;
  public String FxT;
  public bxp FxU;
  public bok FxV;
  public bok FxW;
  public String FxX;
  public String FxY;
  public aip FxZ;
  public String Fxs;
  public String Fxy;
  public String Fxz;
  public LinkedList<bxp> Fya;
  public String Fyb;
  public String Fyc;
  public bpi Fyd;
  public int dAL;
  public int nWx;
  public String nWy;
  
  public cju()
  {
    AppMethodBeat.i(91644);
    this.FxC = new LinkedList();
    this.FxE = new LinkedList();
    this.FxG = new LinkedList();
    this.FxQ = new LinkedList();
    this.Fya = new LinkedList();
    AppMethodBeat.o(91644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91645);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91645);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      paramVarArgs.aR(4, this.Foc);
      if (this.Fxy != null) {
        paramVarArgs.d(5, this.Fxy);
      }
      if (this.Fxz != null) {
        paramVarArgs.d(6, this.Fxz);
      }
      if (this.FxA != null) {
        paramVarArgs.d(7, this.FxA);
      }
      paramVarArgs.aR(8, this.FxB);
      paramVarArgs.e(9, 8, this.FxC);
      paramVarArgs.aR(10, this.dAL);
      paramVarArgs.aR(11, this.FxD);
      paramVarArgs.e(12, 8, this.FxE);
      if (this.Fwv != null) {
        paramVarArgs.d(13, this.Fwv);
      }
      if (this.FxF != null)
      {
        paramVarArgs.ln(14, this.FxF.computeSize());
        this.FxF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.FxG);
      if (this.FxH != null)
      {
        paramVarArgs.ln(16, this.FxH.computeSize());
        this.FxH.writeFields(paramVarArgs);
      }
      if (this.FxI != null)
      {
        paramVarArgs.ln(17, this.FxI.computeSize());
        this.FxI.writeFields(paramVarArgs);
      }
      if (this.FxJ != null) {
        paramVarArgs.d(18, this.FxJ);
      }
      paramVarArgs.aR(19, this.FxK);
      if (this.FxL != null) {
        paramVarArgs.d(20, this.FxL);
      }
      if (this.Fxs != null) {
        paramVarArgs.d(21, this.Fxs);
      }
      paramVarArgs.aR(22, this.FxM);
      paramVarArgs.bl(23, this.FxN);
      paramVarArgs.aR(24, this.ErG);
      if (this.Fwx != null) {
        paramVarArgs.d(25, this.Fwx);
      }
      if (this.FxO != null) {
        paramVarArgs.d(26, this.FxO);
      }
      if (this.FxP != null) {
        paramVarArgs.d(27, this.FxP);
      }
      paramVarArgs.e(28, 8, this.FxQ);
      if (this.FxR != null) {
        paramVarArgs.d(29, this.FxR);
      }
      if (this.FxS != null) {
        paramVarArgs.d(30, this.FxS);
      }
      if (this.FxT != null) {
        paramVarArgs.d(31, this.FxT);
      }
      if (this.AXd != null) {
        paramVarArgs.d(32, this.AXd);
      }
      if (this.FxU != null)
      {
        paramVarArgs.ln(33, this.FxU.computeSize());
        this.FxU.writeFields(paramVarArgs);
      }
      if (this.FxV != null)
      {
        paramVarArgs.ln(34, this.FxV.computeSize());
        this.FxV.writeFields(paramVarArgs);
      }
      if (this.FxW != null)
      {
        paramVarArgs.ln(35, this.FxW.computeSize());
        this.FxW.writeFields(paramVarArgs);
      }
      if (this.FxX != null) {
        paramVarArgs.d(36, this.FxX);
      }
      if (this.FxY != null) {
        paramVarArgs.d(37, this.FxY);
      }
      if (this.FxZ != null)
      {
        paramVarArgs.ln(38, this.FxZ.computeSize());
        this.FxZ.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(39, this.FdJ);
      if (this.Foi != null)
      {
        paramVarArgs.ln(40, this.Foi.computeSize());
        this.Foi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(41, 8, this.Fya);
      if (this.Fyb != null) {
        paramVarArgs.d(42, this.Fyb);
      }
      if (this.Fyc != null) {
        paramVarArgs.d(43, this.Fyc);
      }
      if (this.Fyd != null)
      {
        paramVarArgs.ln(45, this.Fyd.computeSize());
        this.Fyd.writeFields(paramVarArgs);
      }
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(91645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label4366;
      }
    }
    label4366:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Foc);
      paramInt = i;
      if (this.Fxy != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fxy);
      }
      i = paramInt;
      if (this.Fxz != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fxz);
      }
      paramInt = i;
      if (this.FxA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FxA);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FxB) + f.a.a.a.c(9, 8, this.FxC) + f.a.a.b.b.a.bx(10, this.dAL) + f.a.a.b.b.a.bx(11, this.FxD) + f.a.a.a.c(12, 8, this.FxE);
      paramInt = i;
      if (this.Fwv != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Fwv);
      }
      i = paramInt;
      if (this.FxF != null) {
        i = paramInt + f.a.a.a.lm(14, this.FxF.computeSize());
      }
      i += f.a.a.a.c(15, 8, this.FxG);
      paramInt = i;
      if (this.FxH != null) {
        paramInt = i + f.a.a.a.lm(16, this.FxH.computeSize());
      }
      i = paramInt;
      if (this.FxI != null) {
        i = paramInt + f.a.a.a.lm(17, this.FxI.computeSize());
      }
      paramInt = i;
      if (this.FxJ != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FxJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(19, this.FxK);
      paramInt = i;
      if (this.FxL != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FxL);
      }
      i = paramInt;
      if (this.Fxs != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.Fxs);
      }
      i = i + f.a.a.b.b.a.bx(22, this.FxM) + (f.a.a.b.b.a.fK(23) + 1) + f.a.a.b.b.a.bx(24, this.ErG);
      paramInt = i;
      if (this.Fwx != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.Fwx);
      }
      i = paramInt;
      if (this.FxO != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.FxO);
      }
      paramInt = i;
      if (this.FxP != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.FxP);
      }
      i = paramInt + f.a.a.a.c(28, 8, this.FxQ);
      paramInt = i;
      if (this.FxR != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.FxR);
      }
      i = paramInt;
      if (this.FxS != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.FxS);
      }
      paramInt = i;
      if (this.FxT != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.FxT);
      }
      i = paramInt;
      if (this.AXd != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.AXd);
      }
      paramInt = i;
      if (this.FxU != null) {
        paramInt = i + f.a.a.a.lm(33, this.FxU.computeSize());
      }
      i = paramInt;
      if (this.FxV != null) {
        i = paramInt + f.a.a.a.lm(34, this.FxV.computeSize());
      }
      paramInt = i;
      if (this.FxW != null) {
        paramInt = i + f.a.a.a.lm(35, this.FxW.computeSize());
      }
      i = paramInt;
      if (this.FxX != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.FxX);
      }
      paramInt = i;
      if (this.FxY != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.FxY);
      }
      i = paramInt;
      if (this.FxZ != null) {
        i = paramInt + f.a.a.a.lm(38, this.FxZ.computeSize());
      }
      i += f.a.a.b.b.a.fK(39) + 1;
      paramInt = i;
      if (this.Foi != null) {
        paramInt = i + f.a.a.a.lm(40, this.Foi.computeSize());
      }
      i = paramInt + f.a.a.a.c(41, 8, this.Fya);
      paramInt = i;
      if (this.Fyb != null) {
        paramInt = i + f.a.a.b.b.a.e(42, this.Fyb);
      }
      i = paramInt;
      if (this.Fyc != null) {
        i = paramInt + f.a.a.b.b.a.e(43, this.Fyc);
      }
      paramInt = i;
      if (this.Fyd != null) {
        paramInt = i + f.a.a.a.lm(45, this.Fyd.computeSize());
      }
      i = paramInt;
      if (this.AYl != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(91645);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FxC.clear();
        this.FxE.clear();
        this.FxG.clear();
        this.FxQ.clear();
        this.Fya.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cju localcju = (cju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 44: 
        case 46: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
        case 58: 
        case 59: 
        case 60: 
        case 61: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 70: 
        case 71: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 80: 
        case 81: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 96: 
        case 97: 
        case 98: 
        case 99: 
        default: 
          AppMethodBeat.o(91645);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 2: 
          localcju.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91645);
          return 0;
        case 3: 
          localcju.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 4: 
          localcju.Foc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91645);
          return 0;
        case 5: 
          localcju.Fxy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 6: 
          localcju.Fxz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 7: 
          localcju.FxA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 8: 
          localcju.FxB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91645);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 10: 
          localcju.dAL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91645);
          return 0;
        case 11: 
          localcju.FxD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91645);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 13: 
          localcju.Fwv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxF = ((acz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxH = ((acz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bum();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bum)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxI = ((bum)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 18: 
          localcju.FxJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 19: 
          localcju.FxK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91645);
          return 0;
        case 20: 
          localcju.FxL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 21: 
          localcju.Fxs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 22: 
          localcju.FxM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91645);
          return 0;
        case 23: 
          localcju.FxN = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91645);
          return 0;
        case 24: 
          localcju.ErG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91645);
          return 0;
        case 25: 
          localcju.Fwx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 26: 
          localcju.FxO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 27: 
          localcju.FxP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 29: 
          localcju.FxR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 30: 
          localcju.FxS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 31: 
          localcju.FxT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 32: 
          localcju.AXd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxU = ((bxp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bok();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxV = ((bok)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 35: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bok();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxW = ((bok)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 36: 
          localcju.FxX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 37: 
          localcju.FxY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 38: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.FxZ = ((aip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 39: 
          localcju.FdJ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91645);
          return 0;
        case 40: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cga();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cga)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.Foi = ((cga)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 41: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.Fya.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 42: 
          localcju.Fyb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 43: 
          localcju.Fyc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 45: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcju.Fyd = ((bpi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        }
        localcju.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91645);
        return 0;
      }
      AppMethodBeat.o(91645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cju
 * JD-Core Version:    0.7.0.1
 */