package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import e.a.a.b;
import java.util.LinkedList;

public final class ah
  extends bvk
{
  public String pIF;
  public String pIw;
  public int pIx;
  public int pIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(68074);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(68074);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIy);
      if (this.pIF != null) {
        paramVarArgs.e(3, this.pIF);
      }
      paramVarArgs.aO(4, this.pIx);
      if (this.pIw != null) {
        paramVarArgs.e(5, this.pIw);
      }
      AppMethodBeat.o(68074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIy);
      paramInt = i;
      if (this.pIF != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.pIF);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.pIx);
      paramInt = i;
      if (this.pIw != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.pIw);
      }
      AppMethodBeat.o(68074);
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
          AppMethodBeat.o(68074);
          throw paramVarArgs;
        }
        AppMethodBeat.o(68074);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ah localah = (ah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(68074);
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
            localah.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(68074);
          return 0;
        case 2: 
          localah.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(68074);
          return 0;
        case 3: 
          localah.pIF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(68074);
          return 0;
        case 4: 
          localah.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(68074);
          return 0;
        }
        localah.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(68074);
        return 0;
      }
      AppMethodBeat.o(68074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ah
 * JD-Core Version:    0.7.0.1
 */