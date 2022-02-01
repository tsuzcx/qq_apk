package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class duu
  extends cvp
{
  public cwt FEs;
  public SKBuiltinBuffer_t FEt;
  public SKBuiltinBuffer_t Fvm;
  public SKBuiltinBuffer_t FyW;
  public String Fzb;
  public SKBuiltinBuffer_t Fzc;
  public cwt GEQ;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43134);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.GEQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgSid");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43134);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GEQ != null)
      {
        paramVarArgs.lC(2, this.GEQ.computeSize());
        this.GEQ.writeFields(paramVarArgs);
      }
      if (this.Fvm != null)
      {
        paramVarArgs.lC(3, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      if (this.xbo != null) {
        paramVarArgs.d(4, this.xbo);
      }
      if (this.FEs != null)
      {
        paramVarArgs.lC(5, this.FEs.computeSize());
        this.FEs.writeFields(paramVarArgs);
      }
      if (this.Fzc != null)
      {
        paramVarArgs.lC(6, this.Fzc.computeSize());
        this.Fzc.writeFields(paramVarArgs);
      }
      if (this.FEt != null)
      {
        paramVarArgs.lC(7, this.FEt.computeSize());
        this.FEt.writeFields(paramVarArgs);
      }
      if (this.Fzb != null) {
        paramVarArgs.d(8, this.Fzb);
      }
      if (this.FyW != null)
      {
        paramVarArgs.lC(9, this.FyW.computeSize());
        this.FyW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43134);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1506;
      }
    }
    label1506:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GEQ != null) {
        paramInt = i + f.a.a.a.lB(2, this.GEQ.computeSize());
      }
      i = paramInt;
      if (this.Fvm != null) {
        i = paramInt + f.a.a.a.lB(3, this.Fvm.computeSize());
      }
      paramInt = i;
      if (this.xbo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xbo);
      }
      i = paramInt;
      if (this.FEs != null) {
        i = paramInt + f.a.a.a.lB(5, this.FEs.computeSize());
      }
      paramInt = i;
      if (this.Fzc != null) {
        paramInt = i + f.a.a.a.lB(6, this.Fzc.computeSize());
      }
      i = paramInt;
      if (this.FEt != null) {
        i = paramInt + f.a.a.a.lB(7, this.FEt.computeSize());
      }
      paramInt = i;
      if (this.Fzb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fzb);
      }
      i = paramInt;
      if (this.FyW != null) {
        i = paramInt + f.a.a.a.lB(9, this.FyW.computeSize());
      }
      AppMethodBeat.o(43134);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.GEQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgSid");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        if (this.Fvm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43134);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duu localduu = (duu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43134);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduu.GEQ = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduu.Fvm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 4: 
          localduu.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43134);
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
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduu.FEs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduu.Fzc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localduu.FEt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43134);
          return 0;
        case 8: 
          localduu.Fzb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43134);
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
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localduu.FyW = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43134);
        return 0;
      }
      AppMethodBeat.o(43134);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duu
 * JD-Core Version:    0.7.0.1
 */