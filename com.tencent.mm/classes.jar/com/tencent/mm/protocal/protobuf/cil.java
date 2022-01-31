package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cil
  extends bvk
{
  public String wOx;
  public int wsg;
  public fy xLn;
  public gc xSY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96298);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96298);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xLn != null)
      {
        paramVarArgs.iQ(2, this.xLn.computeSize());
        this.xLn.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wsg);
      if (this.xSY != null)
      {
        paramVarArgs.iQ(4, this.xSY.computeSize());
        this.xSY.writeFields(paramVarArgs);
      }
      if (this.wOx != null) {
        paramVarArgs.e(5, this.wOx);
      }
      AppMethodBeat.o(96298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xLn != null) {
        i = paramInt + e.a.a.a.iP(2, this.xLn.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.wsg);
      paramInt = i;
      if (this.xSY != null) {
        paramInt = i + e.a.a.a.iP(4, this.xSY.computeSize());
      }
      i = paramInt;
      if (this.wOx != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wOx);
      }
      AppMethodBeat.o(96298);
      return i;
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
          AppMethodBeat.o(96298);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96298);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cil localcil = (cil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96298);
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
            localcil.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96298);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fy();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcil.xLn = ((fy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96298);
          return 0;
        case 3: 
          localcil.wsg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96298);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcil.xSY = ((gc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96298);
          return 0;
        }
        localcil.wOx = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96298);
        return 0;
      }
      AppMethodBeat.o(96298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cil
 * JD-Core Version:    0.7.0.1
 */