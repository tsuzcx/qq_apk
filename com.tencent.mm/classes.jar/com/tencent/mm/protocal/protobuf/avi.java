package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avi
  extends cvc
{
  public int FVR;
  public int FVS;
  public int FuX;
  public int FxO;
  public int FzW;
  public SKBuiltinBuffer_t Fzc;
  public String GtA;
  public cwt GtQ;
  public cwt GtR;
  public cwt GtS;
  public cwt GtT;
  public String GtU;
  public int GtV;
  public String GtW;
  public SKBuiltinBuffer_t GtX;
  public int GtY;
  public String GtZ;
  public int Gtz;
  public int Gua;
  public SKBuiltinBuffer_t Gub;
  public int OpCode;
  public int Scene;
  public String nDo;
  public String orm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      if (this.Fzc != null)
      {
        paramVarArgs.lC(3, this.Fzc.computeSize());
        this.Fzc.writeFields(paramVarArgs);
      }
      if (this.GtQ != null)
      {
        paramVarArgs.lC(4, this.GtQ.computeSize());
        this.GtQ.writeFields(paramVarArgs);
      }
      if (this.GtR != null)
      {
        paramVarArgs.lC(5, this.GtR.computeSize());
        this.GtR.writeFields(paramVarArgs);
      }
      if (this.GtS != null)
      {
        paramVarArgs.lC(6, this.GtS.computeSize());
        this.GtS.writeFields(paramVarArgs);
      }
      if (this.GtT != null)
      {
        paramVarArgs.lC(7, this.GtT.computeSize());
        this.GtT.writeFields(paramVarArgs);
      }
      if (this.GtU != null) {
        paramVarArgs.d(8, this.GtU);
      }
      paramVarArgs.aS(9, this.GtV);
      paramVarArgs.aS(10, this.Scene);
      if (this.nDo != null) {
        paramVarArgs.d(11, this.nDo);
      }
      if (this.GtW != null) {
        paramVarArgs.d(12, this.GtW);
      }
      if (this.GtX != null)
      {
        paramVarArgs.lC(13, this.GtX.computeSize());
        this.GtX.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.FzW);
      paramVarArgs.aS(15, this.Gtz);
      paramVarArgs.aS(16, this.FuX);
      if (this.orm != null) {
        paramVarArgs.d(17, this.orm);
      }
      paramVarArgs.aS(18, this.FVR);
      paramVarArgs.aS(19, this.FVS);
      paramVarArgs.aS(20, this.GtY);
      if (this.GtZ != null) {
        paramVarArgs.d(21, this.GtZ);
      }
      paramVarArgs.aS(22, this.Gua);
      if (this.Gub != null)
      {
        paramVarArgs.lC(23, this.Gub.computeSize());
        this.Gub.writeFields(paramVarArgs);
      }
      if (this.GtA != null) {
        paramVarArgs.d(24, this.GtA);
      }
      paramVarArgs.aS(25, this.FxO);
      AppMethodBeat.o(152552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2262;
      }
    }
    label2262:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode);
      paramInt = i;
      if (this.Fzc != null) {
        paramInt = i + f.a.a.a.lB(3, this.Fzc.computeSize());
      }
      i = paramInt;
      if (this.GtQ != null) {
        i = paramInt + f.a.a.a.lB(4, this.GtQ.computeSize());
      }
      paramInt = i;
      if (this.GtR != null) {
        paramInt = i + f.a.a.a.lB(5, this.GtR.computeSize());
      }
      i = paramInt;
      if (this.GtS != null) {
        i = paramInt + f.a.a.a.lB(6, this.GtS.computeSize());
      }
      paramInt = i;
      if (this.GtT != null) {
        paramInt = i + f.a.a.a.lB(7, this.GtT.computeSize());
      }
      i = paramInt;
      if (this.GtU != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GtU);
      }
      i = i + f.a.a.b.b.a.bz(9, this.GtV) + f.a.a.b.b.a.bz(10, this.Scene);
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.nDo);
      }
      i = paramInt;
      if (this.GtW != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GtW);
      }
      paramInt = i;
      if (this.GtX != null) {
        paramInt = i + f.a.a.a.lB(13, this.GtX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.FzW) + f.a.a.b.b.a.bz(15, this.Gtz) + f.a.a.b.b.a.bz(16, this.FuX);
      paramInt = i;
      if (this.orm != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.orm);
      }
      i = paramInt + f.a.a.b.b.a.bz(18, this.FVR) + f.a.a.b.b.a.bz(19, this.FVS) + f.a.a.b.b.a.bz(20, this.GtY);
      paramInt = i;
      if (this.GtZ != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.GtZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.Gua);
      paramInt = i;
      if (this.Gub != null) {
        paramInt = i + f.a.a.a.lB(23, this.Gub.computeSize());
      }
      i = paramInt;
      if (this.GtA != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.GtA);
      }
      paramInt = f.a.a.b.b.a.bz(25, this.FxO);
      AppMethodBeat.o(152552);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avi localavi = (avi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152552);
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
            localavi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 2: 
          localavi.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavi.Fzc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavi.GtQ = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavi.GtR = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavi.GtS = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavi.GtT = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 8: 
          localavi.GtU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 9: 
          localavi.GtV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 10: 
          localavi.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 11: 
          localavi.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 12: 
          localavi.GtW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavi.GtX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 14: 
          localavi.FzW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 15: 
          localavi.Gtz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 16: 
          localavi.FuX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 17: 
          localavi.orm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 18: 
          localavi.FVR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 19: 
          localavi.FVS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 20: 
          localavi.GtY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 21: 
          localavi.GtZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 22: 
          localavi.Gua = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152552);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavi.Gub = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 24: 
          localavi.GtA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152552);
          return 0;
        }
        localavi.FxO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152552);
        return 0;
      }
      AppMethodBeat.o(152552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avi
 * JD-Core Version:    0.7.0.1
 */