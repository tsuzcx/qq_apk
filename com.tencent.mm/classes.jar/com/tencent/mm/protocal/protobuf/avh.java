package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class avh
  extends buy
{
  public int xkI;
  public int xkJ;
  public SKBuiltinBuffer_t xkK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(70475);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xkK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqText");
        AppMethodBeat.o(70475);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xkI);
      paramVarArgs.aO(3, this.xkJ);
      if (this.xkK != null)
      {
        paramVarArgs.iQ(4, this.xkK.computeSize());
        this.xkK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(70475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xkI) + e.a.a.b.b.a.bl(3, this.xkJ);
      paramInt = i;
      if (this.xkK != null) {
        paramInt = i + e.a.a.a.iP(4, this.xkK.computeSize());
      }
      AppMethodBeat.o(70475);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xkK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqText");
          AppMethodBeat.o(70475);
          throw paramVarArgs;
        }
        AppMethodBeat.o(70475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        avh localavh = (avh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(70475);
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
            localavh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(70475);
          return 0;
        case 2: 
          localavh.xkI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(70475);
          return 0;
        case 3: 
          localavh.xkJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(70475);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localavh.xkK = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(70475);
        return 0;
      }
      AppMethodBeat.o(70475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avh
 * JD-Core Version:    0.7.0.1
 */