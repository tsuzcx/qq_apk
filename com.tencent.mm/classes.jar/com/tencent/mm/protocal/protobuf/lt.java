package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class lt
  extends cvp
{
  public cww FEh;
  public String FEp;
  public cwt FEs;
  public SKBuiltinBuffer_t FEt;
  public int FEv;
  public String FEw;
  public String FEx;
  public int Fsl;
  public int Fso;
  public SKBuiltinBuffer_t Fvm;
  public SKBuiltinBuffer_t FyW;
  public SKBuiltinBuffer_t Fzc;
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155397);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FEp != null) {
        paramVarArgs.d(2, this.FEp);
      }
      if (this.Fvm != null)
      {
        paramVarArgs.lC(3, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Fso);
      paramVarArgs.aS(5, this.FEv);
      if (this.FEw != null) {
        paramVarArgs.d(6, this.FEw);
      }
      paramVarArgs.aS(7, this.nDG);
      if (this.FEx != null) {
        paramVarArgs.d(8, this.FEx);
      }
      if (this.FEs != null)
      {
        paramVarArgs.lC(9, this.FEs.computeSize());
        this.FEs.writeFields(paramVarArgs);
      }
      if (this.Fzc != null)
      {
        paramVarArgs.lC(10, this.Fzc.computeSize());
        this.Fzc.writeFields(paramVarArgs);
      }
      if (this.FEt != null)
      {
        paramVarArgs.lC(11, this.FEt.computeSize());
        this.FEt.writeFields(paramVarArgs);
      }
      if (this.FEh != null)
      {
        paramVarArgs.lC(12, this.FEh.computeSize());
        this.FEh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.Fsl);
      if (this.FyW != null)
      {
        paramVarArgs.lC(14, this.FyW.computeSize());
        this.FyW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1702;
      }
    }
    label1702:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FEp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FEp);
      }
      i = paramInt;
      if (this.Fvm != null) {
        i = paramInt + f.a.a.a.lB(3, this.Fvm.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(4, this.Fso) + f.a.a.b.b.a.bz(5, this.FEv);
      paramInt = i;
      if (this.FEw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FEw);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.nDG);
      paramInt = i;
      if (this.FEx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FEx);
      }
      i = paramInt;
      if (this.FEs != null) {
        i = paramInt + f.a.a.a.lB(9, this.FEs.computeSize());
      }
      paramInt = i;
      if (this.Fzc != null) {
        paramInt = i + f.a.a.a.lB(10, this.Fzc.computeSize());
      }
      i = paramInt;
      if (this.FEt != null) {
        i = paramInt + f.a.a.a.lB(11, this.FEt.computeSize());
      }
      paramInt = i;
      if (this.FEh != null) {
        paramInt = i + f.a.a.a.lB(12, this.FEh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.Fsl);
      paramInt = i;
      if (this.FyW != null) {
        paramInt = i + f.a.a.a.lB(14, this.FyW.computeSize());
      }
      AppMethodBeat.o(155397);
      return paramInt;
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
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        if (this.Fvm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        lt locallt = (lt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155397);
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
            locallt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 2: 
          locallt.FEp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155397);
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
            locallt.Fvm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 4: 
          locallt.Fso = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155397);
          return 0;
        case 5: 
          locallt.FEv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155397);
          return 0;
        case 6: 
          locallt.FEw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 7: 
          locallt.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155397);
          return 0;
        case 8: 
          locallt.FEx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallt.FEs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallt.Fzc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallt.FEt = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cww();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locallt.FEh = ((cww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 13: 
          locallt.Fsl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(155397);
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
          locallt.FyW = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      AppMethodBeat.o(155397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lt
 * JD-Core Version:    0.7.0.1
 */