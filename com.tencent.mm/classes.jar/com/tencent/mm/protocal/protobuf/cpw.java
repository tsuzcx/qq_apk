package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cpw
  extends bvk
{
  public bfu wZE;
  public String xGJ;
  public int xGK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(858);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(858);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xGJ != null) {
        paramVarArgs.e(2, this.xGJ);
      }
      if (this.wZE != null)
      {
        paramVarArgs.iQ(3, this.wZE.computeSize());
        this.wZE.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xGK);
      AppMethodBeat.o(858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label628;
      }
    }
    label628:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xGJ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xGJ);
      }
      i = paramInt;
      if (this.wZE != null) {
        i = paramInt + e.a.a.a.iP(3, this.wZE.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(4, this.xGK);
      AppMethodBeat.o(858);
      return i + paramInt;
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
          AppMethodBeat.o(858);
          throw paramVarArgs;
        }
        AppMethodBeat.o(858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cpw localcpw = (cpw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(858);
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
            localcpw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(858);
          return 0;
        case 2: 
          localcpw.xGJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(858);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcpw.wZE = ((bfu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(858);
          return 0;
        }
        localcpw.xGK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(858);
        return 0;
      }
      AppMethodBeat.o(858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpw
 * JD-Core Version:    0.7.0.1
 */