package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgh
  extends com.tencent.mm.bv.a
{
  public cgi xQY;
  public cgg xQZ;
  public cgf xRa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94631);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xQY != null)
      {
        paramVarArgs.iQ(1, this.xQY.computeSize());
        this.xQY.writeFields(paramVarArgs);
      }
      if (this.xQZ != null)
      {
        paramVarArgs.iQ(2, this.xQZ.computeSize());
        this.xQZ.writeFields(paramVarArgs);
      }
      if (this.xRa != null)
      {
        paramVarArgs.iQ(3, this.xRa.computeSize());
        this.xRa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xQY == null) {
        break label618;
      }
    }
    label618:
    for (int i = e.a.a.a.iP(1, this.xQY.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xQZ != null) {
        paramInt = i + e.a.a.a.iP(2, this.xQZ.computeSize());
      }
      i = paramInt;
      if (this.xRa != null) {
        i = paramInt + e.a.a.a.iP(3, this.xRa.computeSize());
      }
      AppMethodBeat.o(94631);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cgh localcgh = (cgh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94631);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcgh.xQY = ((cgi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94631);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcgh.xQZ = ((cgg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94631);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcgh.xRa = ((cgf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94631);
        return 0;
      }
      AppMethodBeat.o(94631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgh
 * JD-Core Version:    0.7.0.1
 */