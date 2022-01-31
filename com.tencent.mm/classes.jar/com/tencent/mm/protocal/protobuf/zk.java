package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class zk
  extends bvk
{
  public boolean wQo;
  public String wQp;
  public String wQq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62526);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(62526);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.wQo);
      if (this.wQp != null) {
        paramVarArgs.e(3, this.wQp);
      }
      if (this.wQq != null) {
        paramVarArgs.e(4, this.wQq);
      }
      AppMethodBeat.o(62526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 1);
      paramInt = i;
      if (this.wQp != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wQp);
      }
      i = paramInt;
      if (this.wQq != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wQq);
      }
      AppMethodBeat.o(62526);
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
          AppMethodBeat.o(62526);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62526);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zk localzk = (zk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62526);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localzk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62526);
          return 0;
        case 2: 
          localzk.wQo = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(62526);
          return 0;
        case 3: 
          localzk.wQp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62526);
          return 0;
        }
        localzk.wQq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(62526);
        return 0;
      }
      AppMethodBeat.o(62526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zk
 * JD-Core Version:    0.7.0.1
 */