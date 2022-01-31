package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class py
  extends bvk
{
  public int cnK;
  public String kNv;
  public int wIn;
  public com.tencent.mm.bv.b wIo;
  public int wIp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56755);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56755);
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
      if (this.wIo != null) {
        paramVarArgs.c(4, this.wIo);
      }
      paramVarArgs.aO(5, this.wIn);
      paramVarArgs.aO(6, this.wIp);
      AppMethodBeat.o(56755);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.wIo != null) {
        i = paramInt + e.a.a.b.b.a.b(4, this.wIo);
      }
      paramInt = e.a.a.b.b.a.bl(5, this.wIn);
      int j = e.a.a.b.b.a.bl(6, this.wIp);
      AppMethodBeat.o(56755);
      return i + paramInt + j;
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
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56755);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56755);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        py localpy = (py)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56755);
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
            localpy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56755);
          return 0;
        case 2: 
          localpy.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56755);
          return 0;
        case 3: 
          localpy.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56755);
          return 0;
        case 4: 
          localpy.wIo = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(56755);
          return 0;
        case 5: 
          localpy.wIn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56755);
          return 0;
        }
        localpy.wIp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56755);
        return 0;
      }
      AppMethodBeat.o(56755);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.py
 * JD-Core Version:    0.7.0.1
 */