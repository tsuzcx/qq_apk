package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bml
  extends com.tencent.mm.bv.a
{
  public String nqD;
  public cyu xAN;
  public cyx xAO;
  public cyq xAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63690);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqD == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(63690);
        throw paramVarArgs;
      }
      if (this.nqD != null) {
        paramVarArgs.e(1, this.nqD);
      }
      if (this.xAN != null)
      {
        paramVarArgs.iQ(2, this.xAN.computeSize());
        this.xAN.writeFields(paramVarArgs);
      }
      if (this.xAO != null)
      {
        paramVarArgs.iQ(3, this.xAO.computeSize());
        this.xAO.writeFields(paramVarArgs);
      }
      if (this.xAP != null)
      {
        paramVarArgs.iQ(4, this.xAP.computeSize());
        this.xAP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(63690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqD == null) {
        break label726;
      }
    }
    label726:
    for (int i = e.a.a.b.b.a.f(1, this.nqD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xAN != null) {
        paramInt = i + e.a.a.a.iP(2, this.xAN.computeSize());
      }
      i = paramInt;
      if (this.xAO != null) {
        i = paramInt + e.a.a.a.iP(3, this.xAO.computeSize());
      }
      paramInt = i;
      if (this.xAP != null) {
        paramInt = i + e.a.a.a.iP(4, this.xAP.computeSize());
      }
      AppMethodBeat.o(63690);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nqD == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(63690);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63690);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bml localbml = (bml)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63690);
          return -1;
        case 1: 
          localbml.nqD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(63690);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbml.xAN = ((cyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63690);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbml.xAO = ((cyx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63690);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyq();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cyq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbml.xAP = ((cyq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(63690);
        return 0;
      }
      AppMethodBeat.o(63690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bml
 * JD-Core Version:    0.7.0.1
 */