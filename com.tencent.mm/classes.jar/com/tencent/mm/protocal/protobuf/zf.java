package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class zf
  extends bvk
{
  public String wQf;
  public cco wrV;
  public avk wvX;
  public mg wvY;
  public bft wvZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73702);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(73702);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wQf != null) {
        paramVarArgs.e(2, this.wQf);
      }
      if (this.wvY != null)
      {
        paramVarArgs.iQ(3, this.wvY.computeSize());
        this.wvY.writeFields(paramVarArgs);
      }
      if (this.wvX != null)
      {
        paramVarArgs.iQ(4, this.wvX.computeSize());
        this.wvX.writeFields(paramVarArgs);
      }
      if (this.wrV != null)
      {
        paramVarArgs.iQ(5, this.wrV.computeSize());
        this.wrV.writeFields(paramVarArgs);
      }
      if (this.wvZ != null)
      {
        paramVarArgs.iQ(6, this.wvZ.computeSize());
        this.wvZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(73702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1038;
      }
    }
    label1038:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wQf != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wQf);
      }
      i = paramInt;
      if (this.wvY != null) {
        i = paramInt + e.a.a.a.iP(3, this.wvY.computeSize());
      }
      paramInt = i;
      if (this.wvX != null) {
        paramInt = i + e.a.a.a.iP(4, this.wvX.computeSize());
      }
      i = paramInt;
      if (this.wrV != null) {
        i = paramInt + e.a.a.a.iP(5, this.wrV.computeSize());
      }
      paramInt = i;
      if (this.wvZ != null) {
        paramInt = i + e.a.a.a.iP(6, this.wvZ.computeSize());
      }
      AppMethodBeat.o(73702);
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
          AppMethodBeat.o(73702);
          throw paramVarArgs;
        }
        AppMethodBeat.o(73702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zf localzf = (zf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73702);
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
            localzf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73702);
          return 0;
        case 2: 
          localzf.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73702);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localzf.wvY = ((mg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73702);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localzf.wvX = ((avk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73702);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cco();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cco)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localzf.wrV = ((cco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73702);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bft();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bft)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localzf.wvZ = ((bft)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73702);
        return 0;
      }
      AppMethodBeat.o(73702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zf
 * JD-Core Version:    0.7.0.1
 */