package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xb
  extends com.tencent.mm.bv.a
{
  public int jJu;
  public bwc wOT;
  public LinkedList<Integer> wOZ;
  
  public xb()
  {
    AppMethodBeat.i(60032);
    this.wOZ = new LinkedList();
    AppMethodBeat.o(60032);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60033);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOT == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(60033);
        throw paramVarArgs;
      }
      if (this.wOT != null)
      {
        paramVarArgs.iQ(1, this.wOT.computeSize());
        this.wOT.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jJu);
      paramVarArgs.f(3, 2, this.wOZ);
      AppMethodBeat.o(60033);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOT == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = e.a.a.a.iP(1, this.wOT.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jJu);
      int j = e.a.a.a.d(3, 2, this.wOZ);
      AppMethodBeat.o(60033);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wOZ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOT == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: UserName");
          AppMethodBeat.o(60033);
          throw paramVarArgs;
        }
        AppMethodBeat.o(60033);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        xb localxb = (xb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(60033);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localxb.wOT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60033);
          return 0;
        case 2: 
          localxb.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60033);
          return 0;
        }
        localxb.wOZ = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
        AppMethodBeat.o(60033);
        return 0;
      }
      AppMethodBeat.o(60033);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xb
 * JD-Core Version:    0.7.0.1
 */