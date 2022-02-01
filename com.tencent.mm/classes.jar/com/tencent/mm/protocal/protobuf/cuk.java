package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuk
  extends cvw
{
  public SKBuiltinBuffer_t FSj;
  public com.tencent.mm.bw.b HFn;
  public int dGF;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133192);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HFn == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: clientCheckData");
        AppMethodBeat.o(133192);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HFn != null) {
        paramVarArgs.c(2, this.HFn);
      }
      paramVarArgs.aS(3, this.dGF);
      if (this.FSj != null)
      {
        paramVarArgs.lJ(4, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(5, this.timestamp);
      AppMethodBeat.o(133192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HFn != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.HFn);
      }
      i += f.a.a.b.b.a.bz(3, this.dGF);
      paramInt = i;
      if (this.FSj != null) {
        paramInt = i + f.a.a.a.lI(4, this.FSj.computeSize());
      }
      i = f.a.a.b.b.a.p(5, this.timestamp);
      AppMethodBeat.o(133192);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HFn == null)
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
        cuk localcuk = (cuk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133192);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        case 2: 
          localcuk.HFn = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(133192);
          return 0;
        case 3: 
          localcuk.dGF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133192);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuk.FSj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133192);
          return 0;
        }
        localcuk.timestamp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(133192);
        return 0;
      }
      AppMethodBeat.o(133192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuk
 * JD-Core Version:    0.7.0.1
 */