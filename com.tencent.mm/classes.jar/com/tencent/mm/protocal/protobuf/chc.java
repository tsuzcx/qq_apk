package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chc
  extends buy
{
  public String jJA;
  public int lGX;
  public long xOl;
  public String xRQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56509);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      paramVarArgs.aO(3, this.lGX);
      if (this.xRQ != null) {
        paramVarArgs.e(4, this.xRQ);
      }
      paramVarArgs.am(5, this.xOl);
      AppMethodBeat.o(56509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jJA);
      }
      i += e.a.a.b.b.a.bl(3, this.lGX);
      paramInt = i;
      if (this.xRQ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xRQ);
      }
      i = e.a.a.b.b.a.p(5, this.xOl);
      AppMethodBeat.o(56509);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        chc localchc = (chc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56509);
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
            localchc.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56509);
          return 0;
        case 2: 
          localchc.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56509);
          return 0;
        case 3: 
          localchc.lGX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56509);
          return 0;
        case 4: 
          localchc.xRQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56509);
          return 0;
        }
        localchc.xOl = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56509);
        return 0;
      }
      AppMethodBeat.o(56509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chc
 * JD-Core Version:    0.7.0.1
 */