package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdi
  extends buy
{
  public long Id;
  public int Scene;
  public int niK;
  public btk wpo;
  public SKBuiltinBuffer_t xNO;
  public SKBuiltinBuffer_t xNP;
  public int xNQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94559);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.am(2, this.Id);
      paramVarArgs.aO(3, this.Scene);
      if (this.xNO != null)
      {
        paramVarArgs.iQ(4, this.xNO.computeSize());
        this.xNO.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.niK);
      if (this.xNP != null)
      {
        paramVarArgs.iQ(6, this.xNP.computeSize());
        this.xNP.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.xNQ);
      if (this.wpo != null)
      {
        paramVarArgs.iQ(8, this.wpo.computeSize());
        this.wpo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.Id) + e.a.a.b.b.a.bl(3, this.Scene);
      paramInt = i;
      if (this.xNO != null) {
        paramInt = i + e.a.a.a.iP(4, this.xNO.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.niK);
      paramInt = i;
      if (this.xNP != null) {
        paramInt = i + e.a.a.a.iP(6, this.xNP.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.xNQ);
      paramInt = i;
      if (this.wpo != null) {
        paramInt = i + e.a.a.a.iP(8, this.wpo.computeSize());
      }
      AppMethodBeat.o(94559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94559);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cdi localcdi = (cdi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94559);
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
            localcdi.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94559);
          return 0;
        case 2: 
          localcdi.Id = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94559);
          return 0;
        case 3: 
          localcdi.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94559);
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
            localcdi.xNO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94559);
          return 0;
        case 5: 
          localcdi.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94559);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcdi.xNP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94559);
          return 0;
        case 7: 
          localcdi.xNQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94559);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdi.wpo = ((btk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94559);
        return 0;
      }
      AppMethodBeat.o(94559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdi
 * JD-Core Version:    0.7.0.1
 */