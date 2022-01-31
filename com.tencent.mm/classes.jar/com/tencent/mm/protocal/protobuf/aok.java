package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aok
  extends bvk
{
  public bzx xeh;
  public daj xei;
  public dau xej;
  public adj xek;
  public dal xel;
  public dbb xem;
  public dbd xen;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114964);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114964);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xeh != null)
      {
        paramVarArgs.iQ(2, this.xeh.computeSize());
        this.xeh.writeFields(paramVarArgs);
      }
      if (this.xei != null)
      {
        paramVarArgs.iQ(3, this.xei.computeSize());
        this.xei.writeFields(paramVarArgs);
      }
      if (this.xej != null)
      {
        paramVarArgs.iQ(4, this.xej.computeSize());
        this.xej.writeFields(paramVarArgs);
      }
      if (this.xek != null)
      {
        paramVarArgs.iQ(5, this.xek.computeSize());
        this.xek.writeFields(paramVarArgs);
      }
      if (this.xel != null)
      {
        paramVarArgs.iQ(6, this.xel.computeSize());
        this.xel.writeFields(paramVarArgs);
      }
      if (this.xem != null)
      {
        paramVarArgs.iQ(7, this.xem.computeSize());
        this.xem.writeFields(paramVarArgs);
      }
      if (this.xen != null)
      {
        paramVarArgs.iQ(8, this.xen.computeSize());
        this.xen.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1442;
      }
    }
    label1442:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xeh != null) {
        paramInt = i + e.a.a.a.iP(2, this.xeh.computeSize());
      }
      i = paramInt;
      if (this.xei != null) {
        i = paramInt + e.a.a.a.iP(3, this.xei.computeSize());
      }
      paramInt = i;
      if (this.xej != null) {
        paramInt = i + e.a.a.a.iP(4, this.xej.computeSize());
      }
      i = paramInt;
      if (this.xek != null) {
        i = paramInt + e.a.a.a.iP(5, this.xek.computeSize());
      }
      paramInt = i;
      if (this.xel != null) {
        paramInt = i + e.a.a.a.iP(6, this.xel.computeSize());
      }
      i = paramInt;
      if (this.xem != null) {
        i = paramInt + e.a.a.a.iP(7, this.xem.computeSize());
      }
      paramInt = i;
      if (this.xen != null) {
        paramInt = i + e.a.a.a.iP(8, this.xen.computeSize());
      }
      AppMethodBeat.o(114964);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114964);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aok localaok = (aok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114964);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaok.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114964);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaok.xeh = ((bzx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114964);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new daj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((daj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaok.xei = ((daj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114964);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dau();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dau)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaok.xej = ((dau)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114964);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaok.xek = ((adj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114964);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dal();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dal)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaok.xel = ((dal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114964);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaok.xem = ((dbb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114964);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbd();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaok.xen = ((dbd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114964);
        return 0;
      }
      AppMethodBeat.o(114964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aok
 * JD-Core Version:    0.7.0.1
 */