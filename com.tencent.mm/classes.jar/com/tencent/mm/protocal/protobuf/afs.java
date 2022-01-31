package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class afs
  extends bvk
{
  public int cxa;
  public String cxb;
  public awd wYS;
  public awe wYT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48844);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48844);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cxa);
      if (this.cxb != null) {
        paramVarArgs.e(3, this.cxb);
      }
      if (this.wYS != null)
      {
        paramVarArgs.iQ(4, this.wYS.computeSize());
        this.wYS.writeFields(paramVarArgs);
      }
      if (this.wYT != null)
      {
        paramVarArgs.iQ(5, this.wYT.computeSize());
        this.wYT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48844);
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
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cxa);
      paramInt = i;
      if (this.cxb != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.cxb);
      }
      i = paramInt;
      if (this.wYS != null) {
        i = paramInt + e.a.a.a.iP(4, this.wYS.computeSize());
      }
      paramInt = i;
      if (this.wYT != null) {
        paramInt = i + e.a.a.a.iP(5, this.wYT.computeSize());
      }
      AppMethodBeat.o(48844);
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
          AppMethodBeat.o(48844);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48844);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        afs localafs = (afs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48844);
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
            localafs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48844);
          return 0;
        case 2: 
          localafs.cxa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48844);
          return 0;
        case 3: 
          localafs.cxb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48844);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localafs.wYS = ((awd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48844);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awe();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localafs.wYT = ((awe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48844);
        return 0;
      }
      AppMethodBeat.o(48844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afs
 * JD-Core Version:    0.7.0.1
 */