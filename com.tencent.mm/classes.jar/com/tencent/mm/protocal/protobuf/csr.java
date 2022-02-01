package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csr
  extends cpx
{
  public crm EuE;
  public int FEP;
  public int FuY;
  public int OpCode;
  public SKBuiltinBuffer_t ReqBuf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152682);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuE == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152682);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EuE != null)
      {
        paramVarArgs.ln(2, this.EuE.computeSize());
        this.EuE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.OpCode);
      if (this.ReqBuf != null)
      {
        paramVarArgs.ln(4, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.FuY);
      paramVarArgs.aR(6, this.FEP);
      AppMethodBeat.o(152682);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EuE != null) {
        i = paramInt + f.a.a.a.lm(2, this.EuE.computeSize());
      }
      i += f.a.a.b.b.a.bx(3, this.OpCode);
      paramInt = i;
      if (this.ReqBuf != null) {
        paramInt = i + f.a.a.a.lm(4, this.ReqBuf.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.FuY);
      int j = f.a.a.b.b.a.bx(6, this.FEP);
      AppMethodBeat.o(152682);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EuE == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152682);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152682);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csr localcsr = (csr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152682);
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
            localcsr.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsr.EuE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 3: 
          localcsr.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152682);
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
            localcsr.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 5: 
          localcsr.FuY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152682);
          return 0;
        }
        localcsr.FEP = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152682);
        return 0;
      }
      AppMethodBeat.o(152682);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csr
 * JD-Core Version:    0.7.0.1
 */