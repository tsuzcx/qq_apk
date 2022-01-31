package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class rj
  extends bvk
{
  public String gwS;
  public int wJC;
  public String wJD;
  public String wJE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(135753);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(135753);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.gwS != null) {
        paramVarArgs.e(2, this.gwS);
      }
      paramVarArgs.aO(3, this.wJC);
      if (this.wJD != null) {
        paramVarArgs.e(4, this.wJD);
      }
      if (this.wJE != null) {
        paramVarArgs.e(5, this.wJE);
      }
      AppMethodBeat.o(135753);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gwS != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.gwS);
      }
      i += e.a.a.b.b.a.bl(3, this.wJC);
      paramInt = i;
      if (this.wJD != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wJD);
      }
      i = paramInt;
      if (this.wJE != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wJE);
      }
      AppMethodBeat.o(135753);
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
          AppMethodBeat.o(135753);
          throw paramVarArgs;
        }
        AppMethodBeat.o(135753);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        rj localrj = (rj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(135753);
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
            localrj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(135753);
          return 0;
        case 2: 
          localrj.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135753);
          return 0;
        case 3: 
          localrj.wJC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(135753);
          return 0;
        case 4: 
          localrj.wJD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(135753);
          return 0;
        }
        localrj.wJE = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(135753);
        return 0;
      }
      AppMethodBeat.o(135753);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rj
 * JD-Core Version:    0.7.0.1
 */