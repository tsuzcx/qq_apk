package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjr
  extends com.tencent.mm.bv.a
{
  public String wug;
  public bnq xxZ;
  public LinkedList<ccx> xya;
  
  public bjr()
  {
    AppMethodBeat.i(48913);
    this.xya = new LinkedList();
    AppMethodBeat.o(48913);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48914);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xxZ != null)
      {
        paramVarArgs.iQ(1, this.xxZ.computeSize());
        this.xxZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.xya);
      if (this.wug != null) {
        paramVarArgs.e(3, this.wug);
      }
      AppMethodBeat.o(48914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xxZ == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = e.a.a.a.iP(1, this.xxZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.xya);
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wug);
      }
      AppMethodBeat.o(48914);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xya.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48914);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bjr localbjr = (bjr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48914);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbjr.xxZ = ((bnq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48914);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbjr.xya.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48914);
          return 0;
        }
        localbjr.wug = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48914);
        return 0;
      }
      AppMethodBeat.o(48914);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjr
 * JD-Core Version:    0.7.0.1
 */