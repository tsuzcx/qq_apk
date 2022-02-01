package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class con
  extends cpx
{
  public SKBuiltinBuffer_t DUr;
  public com.tencent.mm.bw.b FBA;
  public int dtz;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133192);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FBA == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: clientCheckData");
        AppMethodBeat.o(133192);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FBA != null) {
        paramVarArgs.c(2, this.FBA);
      }
      paramVarArgs.aR(3, this.dtz);
      if (this.DUr != null)
      {
        paramVarArgs.ln(4, this.DUr.computeSize());
        this.DUr.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.timestamp);
      AppMethodBeat.o(133192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FBA != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FBA);
      }
      i += f.a.a.b.b.a.bx(3, this.dtz);
      paramInt = i;
      if (this.DUr != null) {
        paramInt = i + f.a.a.a.lm(4, this.DUr.computeSize());
      }
      i = f.a.a.b.b.a.p(5, this.timestamp);
      AppMethodBeat.o(133192);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FBA == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: clientCheckData");
          AppMethodBeat.o(133192);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        con localcon = (con)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133192);
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
            localcon.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        case 2: 
          localcon.FBA = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(133192);
          return 0;
        case 3: 
          localcon.dtz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133192);
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
            localcon.DUr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        }
        localcon.timestamp = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(133192);
        return 0;
      }
      AppMethodBeat.o(133192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.con
 * JD-Core Version:    0.7.0.1
 */