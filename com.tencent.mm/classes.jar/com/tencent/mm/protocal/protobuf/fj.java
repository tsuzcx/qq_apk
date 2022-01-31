package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class fj
  extends bvk
{
  public int cnK;
  public String kNv;
  public hi wrx;
  public String wry;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48774);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48774);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      if (this.wrx != null)
      {
        paramVarArgs.iQ(4, this.wrx.computeSize());
        this.wrx.writeFields(paramVarArgs);
      }
      if (this.wry != null) {
        paramVarArgs.e(5, this.wry);
      }
      AppMethodBeat.o(48774);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.wrx != null) {
        i = paramInt + e.a.a.a.iP(4, this.wrx.computeSize());
      }
      paramInt = i;
      if (this.wry != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wry);
      }
      AppMethodBeat.o(48774);
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
          AppMethodBeat.o(48774);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48774);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        fj localfj = (fj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48774);
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
            localfj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48774);
          return 0;
        case 2: 
          localfj.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48774);
          return 0;
        case 3: 
          localfj.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48774);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localfj.wrx = ((hi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48774);
          return 0;
        }
        localfj.wry = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48774);
        return 0;
      }
      AppMethodBeat.o(48774);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fj
 * JD-Core Version:    0.7.0.1
 */