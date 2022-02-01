package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lq
  extends cvc
{
  public int FAt;
  public String FDJ;
  public String FDK;
  public int FDL;
  public String FDM;
  public int FDN;
  public String FDO;
  public String FDP;
  public SKBuiltinBuffer_t FDQ;
  public int FDR;
  public int FDS;
  public int FDT;
  public String FDU;
  public SKBuiltinBuffer_t FDV;
  public String FDW;
  public dew FDX;
  public ccb FDY;
  public String FzI;
  public SKBuiltinBuffer_t FzL;
  public String Fzf;
  public String nDo;
  public String qei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134243);
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
      if (this.FDJ != null) {
        paramVarArgs.d(3, this.FDJ);
      }
      paramVarArgs.aS(4, this.FAt);
      if (this.FDK != null) {
        paramVarArgs.d(5, this.FDK);
      }
      paramVarArgs.aS(6, this.FDL);
      if (this.FDM != null) {
        paramVarArgs.d(7, this.FDM);
      }
      if (this.Fzf != null) {
        paramVarArgs.d(8, this.Fzf);
      }
      paramVarArgs.aS(9, this.FDN);
      if (this.FDO != null) {
        paramVarArgs.d(10, this.FDO);
      }
      if (this.FDP != null) {
        paramVarArgs.d(11, this.FDP);
      }
      if (this.FDQ != null)
      {
        paramVarArgs.lC(12, this.FDQ.computeSize());
        this.FDQ.writeFields(paramVarArgs);
      }
      if (this.qei != null) {
        paramVarArgs.d(13, this.qei);
      }
      paramVarArgs.aS(14, this.FDR);
      paramVarArgs.aS(15, this.FDS);
      if (this.FzI != null) {
        paramVarArgs.d(16, this.FzI);
      }
      paramVarArgs.aS(17, this.FDT);
      if (this.FDU != null) {
        paramVarArgs.d(18, this.FDU);
      }
      if (this.FDV != null)
      {
        paramVarArgs.lC(19, this.FDV.computeSize());
        this.FDV.writeFields(paramVarArgs);
      }
      if (this.FzL != null)
      {
        paramVarArgs.lC(20, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
      }
      if (this.FDW != null) {
        paramVarArgs.d(21, this.FDW);
      }
      if (this.FDX != null)
      {
        paramVarArgs.lC(22, this.FDX.computeSize());
        this.FDX.writeFields(paramVarArgs);
      }
      if (this.FDY != null)
      {
        paramVarArgs.lC(23, this.FDY.computeSize());
        this.FDY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2038;
      }
    }
    label2038:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDo);
      }
      i = paramInt;
      if (this.FDJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FDJ);
      }
      i += f.a.a.b.b.a.bz(4, this.FAt);
      paramInt = i;
      if (this.FDK != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FDK);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FDL);
      paramInt = i;
      if (this.FDM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FDM);
      }
      i = paramInt;
      if (this.Fzf != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Fzf);
      }
      i += f.a.a.b.b.a.bz(9, this.FDN);
      paramInt = i;
      if (this.FDO != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FDO);
      }
      i = paramInt;
      if (this.FDP != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FDP);
      }
      paramInt = i;
      if (this.FDQ != null) {
        paramInt = i + f.a.a.a.lB(12, this.FDQ.computeSize());
      }
      i = paramInt;
      if (this.qei != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.qei);
      }
      i = i + f.a.a.b.b.a.bz(14, this.FDR) + f.a.a.b.b.a.bz(15, this.FDS);
      paramInt = i;
      if (this.FzI != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FzI);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.FDT);
      paramInt = i;
      if (this.FDU != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FDU);
      }
      i = paramInt;
      if (this.FDV != null) {
        i = paramInt + f.a.a.a.lB(19, this.FDV.computeSize());
      }
      paramInt = i;
      if (this.FzL != null) {
        paramInt = i + f.a.a.a.lB(20, this.FzL.computeSize());
      }
      i = paramInt;
      if (this.FDW != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.FDW);
      }
      paramInt = i;
      if (this.FDX != null) {
        paramInt = i + f.a.a.a.lB(22, this.FDX.computeSize());
      }
      i = paramInt;
      if (this.FDY != null) {
        i = paramInt + f.a.a.a.lB(23, this.FDY.computeSize());
      }
      AppMethodBeat.o(134243);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(134243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lq locallq = (lq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134243);
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
            locallq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 2: 
          locallq.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 3: 
          locallq.FDJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 4: 
          locallq.FAt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 5: 
          locallq.FDK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 6: 
          locallq.FDL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 7: 
          locallq.FDM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 8: 
          locallq.Fzf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 9: 
          locallq.FDN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 10: 
          locallq.FDO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 11: 
          locallq.FDP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallq.FDQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 13: 
          locallq.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 14: 
          locallq.FDR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 15: 
          locallq.FDS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 16: 
          locallq.FzI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 17: 
          locallq.FDT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(134243);
          return 0;
        case 18: 
          locallq.FDU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
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
            locallq.FDV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallq.FzL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 21: 
          locallq.FDW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dew();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallq.FDX = ((dew)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locallq.FDY = ((ccb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134243);
        return 0;
      }
      AppMethodBeat.o(134243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lq
 * JD-Core Version:    0.7.0.1
 */