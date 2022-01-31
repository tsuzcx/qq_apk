package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class jj
  extends bvk
{
  public int koj;
  public String kok;
  public bmu wvq;
  public bje wvr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48781);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48781);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      if (this.wvq != null)
      {
        paramVarArgs.iQ(6, this.wvq.computeSize());
        this.wvq.writeFields(paramVarArgs);
      }
      if (this.wvr != null)
      {
        paramVarArgs.iQ(7, this.wvr.computeSize());
        this.wvr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.wvq != null) {
        i = paramInt + e.a.a.a.iP(6, this.wvq.computeSize());
      }
      paramInt = i;
      if (this.wvr != null) {
        paramInt = i + e.a.a.a.iP(7, this.wvr.computeSize());
      }
      AppMethodBeat.o(48781);
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
          AppMethodBeat.o(48781);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48781);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        jj localjj = (jj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(48781);
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
            localjj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48781);
          return 0;
        case 2: 
          localjj.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48781);
          return 0;
        case 3: 
          localjj.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48781);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localjj.wvq = ((bmu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48781);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bje();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bje)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localjj.wvr = ((bje)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48781);
        return 0;
      }
      AppMethodBeat.o(48781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jj
 * JD-Core Version:    0.7.0.1
 */