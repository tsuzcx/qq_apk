package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcs;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public bcs cIc;
  public int fDT;
  public String rlJ;
  public int rlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(36823);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cIc != null)
      {
        paramVarArgs.iQ(1, this.cIc.computeSize());
        this.cIc.writeFields(paramVarArgs);
      }
      if (this.rlJ != null) {
        paramVarArgs.e(2, this.rlJ);
      }
      paramVarArgs.aO(3, this.fDT);
      paramVarArgs.aO(4, this.rlK);
      AppMethodBeat.o(36823);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cIc == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = e.a.a.a.iP(1, this.cIc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rlJ != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.rlJ);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.fDT);
      int j = e.a.a.b.b.a.bl(4, this.rlK);
      AppMethodBeat.o(36823);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(36823);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(36823);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bcs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localb.cIc = ((bcs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(36823);
          return 0;
        case 2: 
          localb.rlJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(36823);
          return 0;
        case 3: 
          localb.fDT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(36823);
          return 0;
        }
        localb.rlK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(36823);
        return 0;
      }
      AppMethodBeat.o(36823);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.b
 * JD-Core Version:    0.7.0.1
 */