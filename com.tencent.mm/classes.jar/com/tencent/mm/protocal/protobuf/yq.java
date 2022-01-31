package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class yq
  extends buy
{
  public int jKs;
  public bka wPK;
  public int wPL;
  public int wzS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80048);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wPK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Package");
        AppMethodBeat.o(80048);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wPK != null)
      {
        paramVarArgs.iQ(2, this.wPK.computeSize());
        this.wPK.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wzS);
      paramVarArgs.aO(4, this.wPL);
      paramVarArgs.aO(5, this.jKs);
      AppMethodBeat.o(80048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wPK != null) {
        i = paramInt + e.a.a.a.iP(2, this.wPK.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(3, this.wzS);
      int j = e.a.a.b.b.a.bl(4, this.wPL);
      int k = e.a.a.b.b.a.bl(5, this.jKs);
      AppMethodBeat.o(80048);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wPK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Package");
          AppMethodBeat.o(80048);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        yq localyq = (yq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80048);
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
            localyq.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80048);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bka();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bka)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localyq.wPK = ((bka)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80048);
          return 0;
        case 3: 
          localyq.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80048);
          return 0;
        case 4: 
          localyq.wPL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80048);
          return 0;
        }
        localyq.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80048);
        return 0;
      }
      AppMethodBeat.o(80048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yq
 * JD-Core Version:    0.7.0.1
 */