package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctq
  extends cvc
{
  public SKBuiltinBuffer_t FzL;
  public com.tencent.mm.bx.b HlN;
  public int dFA;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133192);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HlN == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: clientCheckData");
        AppMethodBeat.o(133192);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HlN != null) {
        paramVarArgs.c(2, this.HlN);
      }
      paramVarArgs.aS(3, this.dFA);
      if (this.FzL != null)
      {
        paramVarArgs.lC(4, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.timestamp);
      AppMethodBeat.o(133192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HlN != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.HlN);
      }
      i += f.a.a.b.b.a.bz(3, this.dFA);
      paramInt = i;
      if (this.FzL != null) {
        paramInt = i + f.a.a.a.lB(4, this.FzL.computeSize());
      }
      i = f.a.a.b.b.a.p(5, this.timestamp);
      AppMethodBeat.o(133192);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HlN == null)
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
        ctq localctq = (ctq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133192);
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
            localctq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        case 2: 
          localctq.HlN = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(133192);
          return 0;
        case 3: 
          localctq.dFA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133192);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctq.FzL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        }
        localctq.timestamp = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(133192);
        return 0;
      }
      AppMethodBeat.o(133192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctq
 * JD-Core Version:    0.7.0.1
 */