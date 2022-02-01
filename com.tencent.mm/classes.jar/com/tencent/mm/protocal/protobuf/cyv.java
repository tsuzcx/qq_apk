package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyv
  extends cvw
{
  public cxn GuF;
  public int HIQ;
  public int HyD;
  public int OpCode;
  public SKBuiltinBuffer_t ReqBuf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152682);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152682);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GuF != null)
      {
        paramVarArgs.lJ(2, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.OpCode);
      if (this.ReqBuf != null)
      {
        paramVarArgs.lJ(4, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HyD);
      paramVarArgs.aS(6, this.HIQ);
      AppMethodBeat.o(152682);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GuF != null) {
        i = paramInt + f.a.a.a.lI(2, this.GuF.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.OpCode);
      paramInt = i;
      if (this.ReqBuf != null) {
        paramInt = i + f.a.a.a.lI(4, this.ReqBuf.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.HyD);
      int j = f.a.a.b.b.a.bz(6, this.HIQ);
      AppMethodBeat.o(152682);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuF == null)
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
        cyv localcyv = (cyv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152682);
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
            localcyv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyv.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 3: 
          localcyv.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152682);
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
            localcyv.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152682);
          return 0;
        case 5: 
          localcyv.HyD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152682);
          return 0;
        }
        localcyv.HIQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152682);
        return 0;
      }
      AppMethodBeat.o(152682);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyv
 * JD-Core Version:    0.7.0.1
 */