package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhb
  extends buy
{
  public int wMi;
  public int xwg;
  public LinkedList<bhd> xwh;
  public LinkedList<bha> xwi;
  
  public bhb()
  {
    AppMethodBeat.i(14734);
    this.xwh = new LinkedList();
    this.xwi = new LinkedList();
    AppMethodBeat.o(14734);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14735);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xwg);
      paramVarArgs.aO(3, this.wMi);
      paramVarArgs.e(4, 8, this.xwh);
      paramVarArgs.e(5, 8, this.xwi);
      AppMethodBeat.o(14735);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label697;
      }
    }
    label697:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xwg);
      int j = e.a.a.b.b.a.bl(3, this.wMi);
      int k = e.a.a.a.c(4, 8, this.xwh);
      int m = e.a.a.a.c(5, 8, this.xwi);
      AppMethodBeat.o(14735);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xwh.clear();
        this.xwi.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14735);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bhb localbhb = (bhb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(14735);
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
            localbhb.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14735);
          return 0;
        case 2: 
          localbhb.xwg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14735);
          return 0;
        case 3: 
          localbhb.wMi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14735);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhb.xwh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14735);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bha();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bha)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbhb.xwi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(14735);
        return 0;
      }
      AppMethodBeat.o(14735);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhb
 * JD-Core Version:    0.7.0.1
 */