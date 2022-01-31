package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class GetEmotionListRequest
  extends buy
{
  public int Category;
  public SKBuiltinBuffer_t ReqBuf;
  public int ReqType;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62563);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ReqBuf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqBuf");
        AppMethodBeat.o(62563);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ReqBuf != null)
      {
        paramVarArgs.iQ(2, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.ReqType);
      paramVarArgs.aO(4, this.Scene);
      paramVarArgs.aO(5, this.Category);
      AppMethodBeat.o(62563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ReqBuf != null) {
        i = paramInt + e.a.a.a.iP(2, this.ReqBuf.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.ReqType);
      int j = e.a.a.b.b.a.bl(4, this.Scene);
      int k = e.a.a.b.b.a.bl(5, this.Category);
      AppMethodBeat.o(62563);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ReqBuf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqBuf");
          AppMethodBeat.o(62563);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        GetEmotionListRequest localGetEmotionListRequest = (GetEmotionListRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62563);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListRequest.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62563);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localGetEmotionListRequest.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62563);
          return 0;
        case 3: 
          localGetEmotionListRequest.ReqType = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62563);
          return 0;
        case 4: 
          localGetEmotionListRequest.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62563);
          return 0;
        }
        localGetEmotionListRequest.Category = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(62563);
        return 0;
      }
      AppMethodBeat.o(62563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.GetEmotionListRequest
 * JD-Core Version:    0.7.0.1
 */