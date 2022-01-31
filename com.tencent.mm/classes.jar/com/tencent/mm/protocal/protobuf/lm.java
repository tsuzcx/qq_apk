package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class lm
  extends buy
{
  public int Scene;
  public int fKi;
  public int wwm;
  public int wzP;
  public SKBuiltinBuffer_t wzQ;
  public int wzR;
  public int wzS;
  public int wzT;
  public int wzU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11723);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wzQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImageBuffer");
        AppMethodBeat.o(11723);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wzP);
      if (this.wzQ != null)
      {
        paramVarArgs.iQ(3, this.wzQ.computeSize());
        this.wzQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wzR);
      paramVarArgs.aO(5, this.wzS);
      paramVarArgs.aO(6, this.fKi);
      paramVarArgs.aO(7, this.wzT);
      paramVarArgs.aO(8, this.wwm);
      paramVarArgs.aO(9, this.wzU);
      paramVarArgs.aO(10, this.Scene);
      AppMethodBeat.o(11723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wzP);
      paramInt = i;
      if (this.wzQ != null) {
        paramInt = i + e.a.a.a.iP(3, this.wzQ.computeSize());
      }
      i = e.a.a.b.b.a.bl(4, this.wzR);
      int j = e.a.a.b.b.a.bl(5, this.wzS);
      int k = e.a.a.b.b.a.bl(6, this.fKi);
      int m = e.a.a.b.b.a.bl(7, this.wzT);
      int n = e.a.a.b.b.a.bl(8, this.wwm);
      int i1 = e.a.a.b.b.a.bl(9, this.wzU);
      int i2 = e.a.a.b.b.a.bl(10, this.Scene);
      AppMethodBeat.o(11723);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wzQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImageBuffer");
          AppMethodBeat.o(11723);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11723);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        lm locallm = (lm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11723);
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
            locallm.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11723);
          return 0;
        case 2: 
          locallm.wzP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11723);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallm.wzQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11723);
          return 0;
        case 4: 
          locallm.wzR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11723);
          return 0;
        case 5: 
          locallm.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11723);
          return 0;
        case 6: 
          locallm.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11723);
          return 0;
        case 7: 
          locallm.wzT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11723);
          return 0;
        case 8: 
          locallm.wwm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11723);
          return 0;
        case 9: 
          locallm.wzU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11723);
          return 0;
        }
        locallm.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(11723);
        return 0;
      }
      AppMethodBeat.o(11723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lm
 * JD-Core Version:    0.7.0.1
 */