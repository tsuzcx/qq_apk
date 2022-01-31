package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bxg
  extends buy
{
  public int OpCode;
  public SKBuiltinBuffer_t ReqBuf;
  public bwc wOT;
  public int xBG;
  public int xKg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80176);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOT == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(80176);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wOT != null)
      {
        paramVarArgs.iQ(2, this.wOT.computeSize());
        this.wOT.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.OpCode);
      if (this.ReqBuf != null)
      {
        paramVarArgs.iQ(4, this.ReqBuf.computeSize());
        this.ReqBuf.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xBG);
      paramVarArgs.aO(6, this.xKg);
      AppMethodBeat.o(80176);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wOT != null) {
        i = paramInt + e.a.a.a.iP(2, this.wOT.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.OpCode);
      paramInt = i;
      if (this.ReqBuf != null) {
        paramInt = i + e.a.a.a.iP(4, this.ReqBuf.computeSize());
      }
      i = e.a.a.b.b.a.bl(5, this.xBG);
      int j = e.a.a.b.b.a.bl(6, this.xKg);
      AppMethodBeat.o(80176);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOT == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(80176);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80176);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bxg localbxg = (bxg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80176);
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
            localbxg.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80176);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxg.wOT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80176);
          return 0;
        case 3: 
          localbxg.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80176);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbxg.ReqBuf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80176);
          return 0;
        case 5: 
          localbxg.xBG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80176);
          return 0;
        }
        localbxg.xKg = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80176);
        return 0;
      }
      AppMethodBeat.o(80176);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxg
 * JD-Core Version:    0.7.0.1
 */