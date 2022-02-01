package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class GetEmotionListRequest
  extends cvw
{
  public int Category;
  public SKBuiltinBuffer_t ReqBuf;
  public int ReqType;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104799);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ReqBuf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(104799);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ReqBuf != null)
      {
        paramVarArgs.lJ(2, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.ReqType);
      paramVarArgs.aS(4, this.Scene);
      paramVarArgs.aS(5, this.Category);
      AppMethodBeat.o(104799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ReqBuf != null) {
        i = paramInt + f.a.a.a.lI(2, this.ReqBuf.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.ReqType);
      int j = f.a.a.b.b.a.bz(4, this.Scene);
      int k = f.a.a.b.b.a.bz(5, this.Category);
      AppMethodBeat.o(104799);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.ReqBuf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(104799);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        GetEmotionListRequest localGetEmotionListRequest = (GetEmotionListRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104799);
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
            localGetEmotionListRequest.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104799);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localGetEmotionListRequest.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104799);
          return 0;
        case 3: 
          localGetEmotionListRequest.ReqType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104799);
          return 0;
        case 4: 
          localGetEmotionListRequest.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104799);
          return 0;
        }
        localGetEmotionListRequest.Category = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(104799);
        return 0;
      }
      AppMethodBeat.o(104799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.GetEmotionListRequest
 * JD-Core Version:    0.7.0.1
 */