package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfp
  extends com.tencent.mm.bv.a
{
  public cjw wmY;
  public bfr xuB;
  public bfq xuC;
  public bfq xuD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48898);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wmY != null)
      {
        paramVarArgs.iQ(1, this.wmY.computeSize());
        this.wmY.writeFields(paramVarArgs);
      }
      if (this.xuB != null)
      {
        paramVarArgs.iQ(2, this.xuB.computeSize());
        this.xuB.writeFields(paramVarArgs);
      }
      if (this.xuC != null)
      {
        paramVarArgs.iQ(3, this.xuC.computeSize());
        this.xuC.writeFields(paramVarArgs);
      }
      if (this.xuD != null)
      {
        paramVarArgs.iQ(4, this.xuD.computeSize());
        this.xuD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48898);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmY == null) {
        break label774;
      }
    }
    label774:
    for (int i = e.a.a.a.iP(1, this.wmY.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xuB != null) {
        paramInt = i + e.a.a.a.iP(2, this.xuB.computeSize());
      }
      i = paramInt;
      if (this.xuC != null) {
        i = paramInt + e.a.a.a.iP(3, this.xuC.computeSize());
      }
      paramInt = i;
      if (this.xuD != null) {
        paramInt = i + e.a.a.a.iP(4, this.xuD.computeSize());
      }
      AppMethodBeat.o(48898);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48898);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bfp localbfp = (bfp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48898);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbfp.wmY = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48898);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbfp.xuB = ((bfr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48898);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbfp.xuC = ((bfq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48898);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfq();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbfp.xuD = ((bfq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48898);
        return 0;
      }
      AppMethodBeat.o(48898);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfp
 * JD-Core Version:    0.7.0.1
 */