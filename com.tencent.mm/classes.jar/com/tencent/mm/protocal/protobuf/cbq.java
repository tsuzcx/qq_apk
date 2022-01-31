package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cbq
  extends buy
{
  public int fKi;
  public SKBuiltinBuffer_t pIA;
  public float wDi;
  public int wLO;
  public int wpR;
  public int xMg;
  public float xMh;
  public float xMi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28650);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(28650);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pIA != null)
      {
        paramVarArgs.iQ(2, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xMg);
      paramVarArgs.aO(4, this.fKi);
      paramVarArgs.q(5, this.xMh);
      paramVarArgs.aO(6, this.wLO);
      paramVarArgs.aO(7, this.wpR);
      paramVarArgs.q(8, this.xMi);
      paramVarArgs.q(9, this.wDi);
      AppMethodBeat.o(28650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pIA != null) {
        i = paramInt + e.a.a.a.iP(2, this.pIA.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xMg);
      int j = e.a.a.b.b.a.bl(4, this.fKi);
      int k = e.a.a.b.b.a.eW(5);
      int m = e.a.a.b.b.a.bl(6, this.wLO);
      int n = e.a.a.b.b.a.bl(7, this.wpR);
      int i1 = e.a.a.b.b.a.eW(8);
      int i2 = e.a.a.b.b.a.eW(9);
      AppMethodBeat.o(28650);
      return i + paramInt + j + (k + 4) + m + n + (i1 + 4) + (i2 + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(28650);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28650);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cbq localcbq = (cbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28650);
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
            localcbq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28650);
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
            localcbq.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28650);
          return 0;
        case 3: 
          localcbq.xMg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28650);
          return 0;
        case 4: 
          localcbq.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28650);
          return 0;
        case 5: 
          localcbq.xMh = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(28650);
          return 0;
        case 6: 
          localcbq.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28650);
          return 0;
        case 7: 
          localcbq.wpR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28650);
          return 0;
        case 8: 
          localcbq.xMi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(28650);
          return 0;
        }
        localcbq.wDi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
        AppMethodBeat.o(28650);
        return 0;
      }
      AppMethodBeat.o(28650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbq
 * JD-Core Version:    0.7.0.1
 */