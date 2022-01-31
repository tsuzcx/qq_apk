package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvm
  extends com.tencent.mm.bv.a
{
  public String ydT;
  public nw ydU;
  public boolean ydV;
  public String ydW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56999);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ydT != null) {
        paramVarArgs.e(1, this.ydT);
      }
      if (this.ydU != null)
      {
        paramVarArgs.iQ(2, this.ydU.computeSize());
        this.ydU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.ydV);
      if (this.ydW != null) {
        paramVarArgs.e(4, this.ydW);
      }
      AppMethodBeat.o(56999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ydT == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = e.a.a.b.b.a.f(1, this.ydT) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ydU != null) {
        i = paramInt + e.a.a.a.iP(2, this.ydU.computeSize());
      }
      i += e.a.a.b.b.a.eW(3) + 1;
      paramInt = i;
      if (this.ydW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ydW);
      }
      AppMethodBeat.o(56999);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56999);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cvm localcvm = (cvm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56999);
          return -1;
        case 1: 
          localcvm.ydT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56999);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((nw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcvm.ydU = ((nw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56999);
          return 0;
        case 3: 
          localcvm.ydV = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56999);
          return 0;
        }
        localcvm.ydW = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56999);
        return 0;
      }
      AppMethodBeat.o(56999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvm
 * JD-Core Version:    0.7.0.1
 */