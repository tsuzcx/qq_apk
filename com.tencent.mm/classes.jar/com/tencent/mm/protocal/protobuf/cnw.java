package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cnw
  extends bvk
{
  public String pIw;
  public int pIx;
  public int pIy;
  public String xtD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(136947);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(136947);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIy);
      paramVarArgs.aO(3, this.pIx);
      if (this.pIw != null) {
        paramVarArgs.e(4, this.pIw);
      }
      if (this.xtD != null) {
        paramVarArgs.e(5, this.xtD);
      }
      AppMethodBeat.o(136947);
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
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIy) + e.a.a.b.b.a.bl(3, this.pIx);
      paramInt = i;
      if (this.pIw != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.pIw);
      }
      i = paramInt;
      if (this.xtD != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xtD);
      }
      AppMethodBeat.o(136947);
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
          AppMethodBeat.o(136947);
          throw paramVarArgs;
        }
        AppMethodBeat.o(136947);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cnw localcnw = (cnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(136947);
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
            localcnw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(136947);
          return 0;
        case 2: 
          localcnw.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(136947);
          return 0;
        case 3: 
          localcnw.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(136947);
          return 0;
        case 4: 
          localcnw.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(136947);
          return 0;
        }
        localcnw.xtD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(136947);
        return 0;
      }
      AppMethodBeat.o(136947);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnw
 * JD-Core Version:    0.7.0.1
 */