package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asu
  extends buy
{
  public double xhM;
  public double xhN;
  public String xhO;
  public boolean xhP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96237);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.f(2, this.xhM);
      paramVarArgs.f(3, this.xhN);
      if (this.xhO != null) {
        paramVarArgs.e(4, this.xhO);
      }
      paramVarArgs.aS(5, this.xhP);
      AppMethodBeat.o(96237);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label504;
      }
    }
    label504:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 8) + (e.a.a.b.b.a.eW(3) + 8);
      paramInt = i;
      if (this.xhO != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xhO);
      }
      i = e.a.a.b.b.a.eW(5);
      AppMethodBeat.o(96237);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96237);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        asu localasu = (asu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96237);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localasu.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96237);
          return 0;
        case 2: 
          localasu.xhM = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(96237);
          return 0;
        case 3: 
          localasu.xhN = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(96237);
          return 0;
        case 4: 
          localasu.xhO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96237);
          return 0;
        }
        localasu.xhP = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(96237);
        return 0;
      }
      AppMethodBeat.o(96237);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asu
 * JD-Core Version:    0.7.0.1
 */