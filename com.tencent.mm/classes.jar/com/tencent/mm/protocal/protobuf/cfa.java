package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfa
  extends buy
{
  public int OpCode;
  public int Scene;
  public int jJu;
  public LinkedList<bwc> jJv;
  public String ntn;
  public long xPq;
  
  public cfa()
  {
    AppMethodBeat.i(94611);
    this.jJv = new LinkedList();
    AppMethodBeat.o(94611);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94612);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.OpCode);
      paramVarArgs.am(3, this.xPq);
      if (this.ntn != null) {
        paramVarArgs.e(4, this.ntn);
      }
      paramVarArgs.aO(5, this.jJu);
      paramVarArgs.e(6, 8, this.jJv);
      paramVarArgs.aO(7, this.Scene);
      AppMethodBeat.o(94612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.OpCode) + e.a.a.b.b.a.p(3, this.xPq);
      paramInt = i;
      if (this.ntn != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntn);
      }
      i = e.a.a.b.b.a.bl(5, this.jJu);
      int j = e.a.a.a.c(6, 8, this.jJv);
      int k = e.a.a.b.b.a.bl(7, this.Scene);
      AppMethodBeat.o(94612);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.jJv.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfa localcfa = (cfa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94612);
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
            localcfa.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94612);
          return 0;
        case 2: 
          localcfa.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94612);
          return 0;
        case 3: 
          localcfa.xPq = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94612);
          return 0;
        case 4: 
          localcfa.ntn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94612);
          return 0;
        case 5: 
          localcfa.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94612);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfa.jJv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94612);
          return 0;
        }
        localcfa.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94612);
        return 0;
      }
      AppMethodBeat.o(94612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfa
 * JD-Core Version:    0.7.0.1
 */