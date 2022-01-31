package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqx
  extends com.tencent.mm.bv.a
{
  public vh xZj;
  public boolean xZk = true;
  public cqt xZl;
  public String xZm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124376);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xZj != null)
      {
        paramVarArgs.iQ(1, this.xZj.computeSize());
        this.xZj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xZk);
      if (this.xZl != null)
      {
        paramVarArgs.iQ(3, this.xZl.computeSize());
        this.xZl.writeFields(paramVarArgs);
      }
      if (this.xZm != null) {
        paramVarArgs.e(4, this.xZm);
      }
      AppMethodBeat.o(124376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xZj == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = e.a.a.a.iP(1, this.xZj.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 1);
      paramInt = i;
      if (this.xZl != null) {
        paramInt = i + e.a.a.a.iP(3, this.xZl.computeSize());
      }
      i = paramInt;
      if (this.xZm != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.xZm);
      }
      AppMethodBeat.o(124376);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cqx localcqx = (cqx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124376);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqx.xZj = ((vh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124376);
          return 0;
        case 2: 
          localcqx.xZk = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(124376);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqx.xZl = ((cqt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124376);
          return 0;
        }
        localcqx.xZm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124376);
        return 0;
      }
      AppMethodBeat.o(124376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqx
 * JD-Core Version:    0.7.0.1
 */