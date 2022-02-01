package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ls
  extends cvc
{
  public SKBuiltinBuffer_t FBT;
  public String FDO;
  public String FDP;
  public String FEb;
  public int FEn;
  public String FEo;
  public String FEp;
  public String FEq;
  public int FEr;
  public cwt FEs;
  public SKBuiltinBuffer_t FEt;
  public int FEu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155396);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FEn);
      if (this.FEb != null) {
        paramVarArgs.d(3, this.FEb);
      }
      if (this.FEo != null) {
        paramVarArgs.d(4, this.FEo);
      }
      if (this.FEp != null) {
        paramVarArgs.d(5, this.FEp);
      }
      if (this.FEq != null) {
        paramVarArgs.d(6, this.FEq);
      }
      paramVarArgs.aS(7, this.FEr);
      if (this.FEs != null)
      {
        paramVarArgs.lC(8, this.FEs.computeSize());
        this.FEs.writeFields(paramVarArgs);
      }
      if (this.FEt != null)
      {
        paramVarArgs.lC(9, this.FEt.computeSize());
        this.FEt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.FEu);
      if (this.FDO != null) {
        paramVarArgs.d(11, this.FDO);
      }
      if (this.FDP != null) {
        paramVarArgs.d(12, this.FDP);
      }
      if (this.FBT != null)
      {
        paramVarArgs.lC(13, this.FBT.computeSize());
        this.FBT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FEn);
      paramInt = i;
      if (this.FEb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FEb);
      }
      i = paramInt;
      if (this.FEo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FEo);
      }
      paramInt = i;
      if (this.FEp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FEp);
      }
      i = paramInt;
      if (this.FEq != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FEq);
      }
      i += f.a.a.b.b.a.bz(7, this.FEr);
      paramInt = i;
      if (this.FEs != null) {
        paramInt = i + f.a.a.a.lB(8, this.FEs.computeSize());
      }
      i = paramInt;
      if (this.FEt != null) {
        i = paramInt + f.a.a.a.lB(9, this.FEt.computeSize());
      }
      i += f.a.a.b.b.a.bz(10, this.FEu);
      paramInt = i;
      if (this.FDO != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FDO);
      }
      i = paramInt;
      if (this.FDP != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FDP);
      }
      paramInt = i;
      if (this.FBT != null) {
        paramInt = i + f.a.a.a.lB(13, this.FBT.computeSize());
      }
      AppMethodBeat.o(155396);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ls localls = (ls)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155396);
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
            localls.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 2: 
          localls.FEn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155396);
          return 0;
        case 3: 
          localls.FEb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 4: 
          localls.FEo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 5: 
          localls.FEp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 6: 
          localls.FEq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 7: 
          localls.FEr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155396);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localls.FEs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localls.FEt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 10: 
          localls.FEu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155396);
          return 0;
        case 11: 
          localls.FDO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 12: 
          localls.FDP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155396);
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
          localls.FBT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      AppMethodBeat.o(155396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ls
 * JD-Core Version:    0.7.0.1
 */