package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdg
  extends com.tencent.mm.bv.a
{
  public int niK;
  public bwc xNI;
  public bwc xNK;
  public int xNL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94557);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xNI != null)
      {
        paramVarArgs.iQ(1, this.xNI.computeSize());
        this.xNI.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.niK);
      if (this.xNK != null)
      {
        paramVarArgs.iQ(3, this.xNK.computeSize());
        this.xNK.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xNL);
      AppMethodBeat.o(94557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNI == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = e.a.a.a.iP(1, this.xNI.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.niK);
      paramInt = i;
      if (this.xNK != null) {
        paramInt = i + e.a.a.a.iP(3, this.xNK.computeSize());
      }
      i = e.a.a.b.b.a.bl(4, this.xNL);
      AppMethodBeat.o(94557);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cdg localcdg = (cdg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94557);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcdg.xNI = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94557);
          return 0;
        case 2: 
          localcdg.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94557);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcdg.xNK = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94557);
          return 0;
        }
        localcdg.xNL = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94557);
        return 0;
      }
      AppMethodBeat.o(94557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdg
 * JD-Core Version:    0.7.0.1
 */