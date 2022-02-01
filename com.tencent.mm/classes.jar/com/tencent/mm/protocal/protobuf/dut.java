package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dut
  extends cvc
{
  public SKBuiltinBuffer_t FBT;
  public String FEo;
  public cwt FEs;
  public SKBuiltinBuffer_t FEt;
  public cwt GEQ;
  public String HHk;
  public cwt HHl;
  public int HrJ;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43133);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      if (this.HHk != null) {
        paramVarArgs.d(3, this.HHk);
      }
      if (this.FEo != null) {
        paramVarArgs.d(4, this.FEo);
      }
      if (this.GEQ != null)
      {
        paramVarArgs.lC(5, this.GEQ.computeSize());
        this.GEQ.writeFields(paramVarArgs);
      }
      if (this.HHl != null)
      {
        paramVarArgs.lC(6, this.HHl.computeSize());
        this.HHl.writeFields(paramVarArgs);
      }
      if (this.FEs != null)
      {
        paramVarArgs.lC(7, this.FEs.computeSize());
        this.FEs.writeFields(paramVarArgs);
      }
      if (this.FEt != null)
      {
        paramVarArgs.lC(8, this.FEt.computeSize());
        this.FEt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.HrJ);
      if (this.FBT != null)
      {
        paramVarArgs.lC(10, this.FBT.computeSize());
        this.FBT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode);
      paramInt = i;
      if (this.HHk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HHk);
      }
      i = paramInt;
      if (this.FEo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FEo);
      }
      paramInt = i;
      if (this.GEQ != null) {
        paramInt = i + f.a.a.a.lB(5, this.GEQ.computeSize());
      }
      i = paramInt;
      if (this.HHl != null) {
        i = paramInt + f.a.a.a.lB(6, this.HHl.computeSize());
      }
      paramInt = i;
      if (this.FEs != null) {
        paramInt = i + f.a.a.a.lB(7, this.FEs.computeSize());
      }
      i = paramInt;
      if (this.FEt != null) {
        i = paramInt + f.a.a.a.lB(8, this.FEt.computeSize());
      }
      i += f.a.a.b.b.a.bz(9, this.HrJ);
      paramInt = i;
      if (this.FBT != null) {
        paramInt = i + f.a.a.a.lB(10, this.FBT.computeSize());
      }
      AppMethodBeat.o(43133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dut localdut = (dut)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43133);
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
            localdut.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 2: 
          localdut.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43133);
          return 0;
        case 3: 
          localdut.HHk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 4: 
          localdut.FEo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43133);
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
            localdut.GEQ = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
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
            localdut.HHl = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
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
            localdut.FEs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdut.FEt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 9: 
          localdut.HrJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43133);
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
          localdut.FBT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      AppMethodBeat.o(43133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dut
 * JD-Core Version:    0.7.0.1
 */