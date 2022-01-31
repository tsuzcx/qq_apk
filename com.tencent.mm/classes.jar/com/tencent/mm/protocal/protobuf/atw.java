package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atw
  extends buy
{
  public String kMN;
  public String ojA;
  public String opF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56840);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ojA != null) {
        paramVarArgs.e(2, this.ojA);
      }
      if (this.kMN != null) {
        paramVarArgs.e(3, this.kMN);
      }
      if (this.opF != null) {
        paramVarArgs.e(4, this.opF);
      }
      AppMethodBeat.o(56840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ojA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ojA);
      }
      i = paramInt;
      if (this.kMN != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kMN);
      }
      paramInt = i;
      if (this.opF != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.opF);
      }
      AppMethodBeat.o(56840);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56840);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        atw localatw = (atw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56840);
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
            localatw.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56840);
          return 0;
        case 2: 
          localatw.ojA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56840);
          return 0;
        case 3: 
          localatw.kMN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56840);
          return 0;
        }
        localatw.opF = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56840);
        return 0;
      }
      AppMethodBeat.o(56840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atw
 * JD-Core Version:    0.7.0.1
 */