package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bnw
  extends cpx
{
  public SKBuiltinBuffer_t DYu;
  public int FdB;
  public SKBuiltinBuffer_t FdC;
  public SKBuiltinBuffer_t FdD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143983);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FdC == null)
      {
        paramVarArgs = new b("Not all required fields were included: KVBuffer");
        AppMethodBeat.o(143983);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FdB);
      if (this.FdC != null)
      {
        paramVarArgs.ln(3, this.FdC.computeSize());
        this.FdC.writeFields(paramVarArgs);
      }
      if (this.DYu != null)
      {
        paramVarArgs.ln(4, this.DYu.computeSize());
        this.DYu.writeFields(paramVarArgs);
      }
      if (this.FdD != null)
      {
        paramVarArgs.ln(5, this.FdD.computeSize());
        this.FdD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143983);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FdB);
      paramInt = i;
      if (this.FdC != null) {
        paramInt = i + f.a.a.a.lm(3, this.FdC.computeSize());
      }
      i = paramInt;
      if (this.DYu != null) {
        i = paramInt + f.a.a.a.lm(4, this.DYu.computeSize());
      }
      paramInt = i;
      if (this.FdD != null) {
        paramInt = i + f.a.a.a.lm(5, this.FdD.computeSize());
      }
      AppMethodBeat.o(143983);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FdC == null)
        {
          paramVarArgs = new b("Not all required fields were included: KVBuffer");
          AppMethodBeat.o(143983);
          throw paramVarArgs;
        }
        AppMethodBeat.o(143983);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnw localbnw = (bnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(143983);
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
            localbnw.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(143983);
          return 0;
        case 2: 
          localbnw.FdB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(143983);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnw.FdC = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(143983);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnw.DYu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(143983);
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
          localbnw.FdD = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143983);
        return 0;
      }
      AppMethodBeat.o(143983);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnw
 * JD-Core Version:    0.7.0.1
 */