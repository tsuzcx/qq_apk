package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class agh
  extends bvk
{
  public gm mNG;
  public int wkZ;
  public int wld;
  public String wle;
  public ccq wlf;
  public int wln;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28416);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28416);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wld);
      paramVarArgs.aO(3, this.wln);
      if (this.wle != null) {
        paramVarArgs.e(4, this.wle);
      }
      if (this.wlf != null)
      {
        paramVarArgs.iQ(5, this.wlf.computeSize());
        this.wlf.writeFields(paramVarArgs);
      }
      if (this.mNG != null)
      {
        paramVarArgs.iQ(6, this.mNG.computeSize());
        this.mNG.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.wkZ);
      AppMethodBeat.o(28416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label875;
      }
    }
    label875:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wld) + e.a.a.b.b.a.bl(3, this.wln);
      paramInt = i;
      if (this.wle != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wle);
      }
      i = paramInt;
      if (this.wlf != null) {
        i = paramInt + e.a.a.a.iP(5, this.wlf.computeSize());
      }
      paramInt = i;
      if (this.mNG != null) {
        paramInt = i + e.a.a.a.iP(6, this.mNG.computeSize());
      }
      i = e.a.a.b.b.a.bl(7, this.wkZ);
      AppMethodBeat.o(28416);
      return paramInt + i;
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
          AppMethodBeat.o(28416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        agh localagh = (agh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28416);
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
            localagh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28416);
          return 0;
        case 2: 
          localagh.wld = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28416);
          return 0;
        case 3: 
          localagh.wln = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28416);
          return 0;
        case 4: 
          localagh.wle = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28416);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagh.wlf = ((ccq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28416);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagh.mNG = ((gm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28416);
          return 0;
        }
        localagh.wkZ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28416);
        return 0;
      }
      AppMethodBeat.o(28416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agh
 * JD-Core Version:    0.7.0.1
 */