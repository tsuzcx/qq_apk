package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aop
  extends buy
{
  public int fKy;
  public SKBuiltinBuffer_t xet;
  public int xeu;
  public int xev;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(105146);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xet == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(105146);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.fKy);
      if (this.xet != null)
      {
        paramVarArgs.iQ(3, this.xet.computeSize());
        this.xet.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xeu);
      paramVarArgs.aO(5, this.xev);
      AppMethodBeat.o(105146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.fKy);
      paramInt = i;
      if (this.xet != null) {
        paramInt = i + e.a.a.a.iP(3, this.xet.computeSize());
      }
      i = e.a.a.b.b.a.bl(4, this.xeu);
      int j = e.a.a.b.b.a.bl(5, this.xev);
      AppMethodBeat.o(105146);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xet == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(105146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(105146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aop localaop = (aop)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(105146);
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
            localaop.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(105146);
          return 0;
        case 2: 
          localaop.fKy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(105146);
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
            localaop.xet = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(105146);
          return 0;
        case 4: 
          localaop.xeu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(105146);
          return 0;
        }
        localaop.xev = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(105146);
        return 0;
      }
      AppMethodBeat.o(105146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aop
 * JD-Core Version:    0.7.0.1
 */