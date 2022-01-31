package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aiw
  extends bvk
{
  public int jJr;
  public String xaB;
  public rc xaC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5586);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5586);
        throw paramVarArgs;
      }
      if (this.xaC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NewChatroomData");
        AppMethodBeat.o(5586);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xaB != null) {
        paramVarArgs.e(2, this.xaB);
      }
      paramVarArgs.aO(3, this.jJr);
      if (this.xaC != null)
      {
        paramVarArgs.iQ(4, this.xaC.computeSize());
        this.xaC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(5586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label680;
      }
    }
    label680:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xaB != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xaB);
      }
      i += e.a.a.b.b.a.bl(3, this.jJr);
      paramInt = i;
      if (this.xaC != null) {
        paramInt = i + e.a.a.a.iP(4, this.xaC.computeSize());
      }
      AppMethodBeat.o(5586);
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
          AppMethodBeat.o(5586);
          throw paramVarArgs;
        }
        if (this.xaC == null)
        {
          paramVarArgs = new b("Not all required fields were included: NewChatroomData");
          AppMethodBeat.o(5586);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aiw localaiw = (aiw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5586);
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
            localaiw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5586);
          return 0;
        case 2: 
          localaiw.xaB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5586);
          return 0;
        case 3: 
          localaiw.jJr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5586);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaiw.xaC = ((rc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5586);
        return 0;
      }
      AppMethodBeat.o(5586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiw
 * JD-Core Version:    0.7.0.1
 */