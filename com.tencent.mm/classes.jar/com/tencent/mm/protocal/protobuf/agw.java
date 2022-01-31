package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agw
  extends buy
{
  public LinkedList<avv> wZt;
  public avx wZv;
  public long wZw;
  
  public agw()
  {
    AppMethodBeat.i(10172);
    this.wZt = new LinkedList();
    AppMethodBeat.o(10172);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10173);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wZt);
      if (this.wZv != null)
      {
        paramVarArgs.iQ(4, this.wZv.computeSize());
        this.wZv.writeFields(paramVarArgs);
      }
      paramVarArgs.am(5, this.wZw);
      AppMethodBeat.o(10173);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label664;
      }
    }
    label664:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wZt);
      paramInt = i;
      if (this.wZv != null) {
        paramInt = i + e.a.a.a.iP(4, this.wZv.computeSize());
      }
      i = e.a.a.b.b.a.p(5, this.wZw);
      AppMethodBeat.o(10173);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wZt.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10173);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        agw localagw = (agw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(10173);
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
            localagw.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10173);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagw.wZt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10173);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagw.wZv = ((avx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10173);
          return 0;
        }
        localagw.wZw = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(10173);
        return 0;
      }
      AppMethodBeat.o(10173);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agw
 * JD-Core Version:    0.7.0.1
 */