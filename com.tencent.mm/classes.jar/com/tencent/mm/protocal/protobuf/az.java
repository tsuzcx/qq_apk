package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class az
  extends com.tencent.mm.bv.a
{
  public cjw wmY;
  public cjw wmZ;
  public bvz wna;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48769);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wmY != null)
      {
        paramVarArgs.iQ(1, this.wmY.computeSize());
        this.wmY.writeFields(paramVarArgs);
      }
      if (this.wmZ != null)
      {
        paramVarArgs.iQ(2, this.wmZ.computeSize());
        this.wmZ.writeFields(paramVarArgs);
      }
      if (this.wna != null)
      {
        paramVarArgs.iQ(3, this.wna.computeSize());
        this.wna.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmY == null) {
        break label618;
      }
    }
    label618:
    for (int i = e.a.a.a.iP(1, this.wmY.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wmZ != null) {
        paramInt = i + e.a.a.a.iP(2, this.wmZ.computeSize());
      }
      i = paramInt;
      if (this.wna != null) {
        i = paramInt + e.a.a.a.iP(3, this.wna.computeSize());
      }
      AppMethodBeat.o(48769);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48769);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48769);
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
            localaz.wmY = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48769);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaz.wmZ = ((cjw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48769);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaz.wna = ((bvz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48769);
        return 0;
      }
      AppMethodBeat.o(48769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.az
 * JD-Core Version:    0.7.0.1
 */