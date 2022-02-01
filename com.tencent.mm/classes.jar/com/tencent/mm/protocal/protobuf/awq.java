package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awq
  extends com.tencent.mm.bw.a
{
  public String ProductID;
  public SKBuiltinBuffer_t ReqBuf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104796);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104796);
        throw paramVarArgs;
      }
      if (this.ReqBuf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104796);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.d(1, this.ProductID);
      }
      if (this.ReqBuf != null)
      {
        paramVarArgs.ln(2, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ReqBuf != null) {
        i = paramInt + f.a.a.a.lm(2, this.ReqBuf.computeSize());
      }
      AppMethodBeat.o(104796);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104796);
          throw paramVarArgs;
        }
        if (this.ReqBuf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104796);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awq localawq = (awq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104796);
          return -1;
        case 1: 
          localawq.ProductID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104796);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localawq.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104796);
        return 0;
      }
      AppMethodBeat.o(104796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awq
 * JD-Core Version:    0.7.0.1
 */