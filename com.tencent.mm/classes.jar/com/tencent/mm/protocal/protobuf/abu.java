package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abu
  extends com.tencent.mm.bw.a
{
  public coq GtN;
  public coq GtO;
  public int GtP;
  public String dyI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197187);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyI != null) {
        paramVarArgs.d(1, this.dyI);
      }
      if (this.GtN != null)
      {
        paramVarArgs.lJ(2, this.GtN.computeSize());
        this.GtN.writeFields(paramVarArgs);
      }
      if (this.GtO != null)
      {
        paramVarArgs.lJ(3, this.GtO.computeSize());
        this.GtO.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GtP);
      AppMethodBeat.o(197187);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyI == null) {
        break label570;
      }
    }
    label570:
    for (int i = f.a.a.b.b.a.e(1, this.dyI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GtN != null) {
        paramInt = i + f.a.a.a.lI(2, this.GtN.computeSize());
      }
      i = paramInt;
      if (this.GtO != null) {
        i = paramInt + f.a.a.a.lI(3, this.GtO.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GtP);
      AppMethodBeat.o(197187);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197187);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abu localabu = (abu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197187);
          return -1;
        case 1: 
          localabu.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197187);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabu.GtN = ((coq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197187);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabu.GtO = ((coq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197187);
          return 0;
        }
        localabu.GtP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(197187);
        return 0;
      }
      AppMethodBeat.o(197187);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abu
 * JD-Core Version:    0.7.0.1
 */