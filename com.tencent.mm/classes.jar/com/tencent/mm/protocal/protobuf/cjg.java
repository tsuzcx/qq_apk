package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjg
  extends ckq
{
  public SKBuiltinBuffer_t CBU;
  public com.tencent.mm.bx.b EeA;
  public int dvM;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133192);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EeA == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: clientCheckData");
        AppMethodBeat.o(133192);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EeA != null) {
        paramVarArgs.c(2, this.EeA);
      }
      paramVarArgs.aR(3, this.dvM);
      if (this.CBU != null)
      {
        paramVarArgs.kX(4, this.CBU.computeSize());
        this.CBU.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(5, this.timestamp);
      AppMethodBeat.o(133192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EeA != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.EeA);
      }
      i += f.a.a.b.b.a.bA(3, this.dvM);
      paramInt = i;
      if (this.CBU != null) {
        paramInt = i + f.a.a.a.kW(4, this.CBU.computeSize());
      }
      i = f.a.a.b.b.a.q(5, this.timestamp);
      AppMethodBeat.o(133192);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EeA == null)
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
        cjg localcjg = (cjg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133192);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjg.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        case 2: 
          localcjg.EeA = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(133192);
          return 0;
        case 3: 
          localcjg.dvM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133192);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjg.CBU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        }
        localcjg.timestamp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(133192);
        return 0;
      }
      AppMethodBeat.o(133192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjg
 * JD-Core Version:    0.7.0.1
 */