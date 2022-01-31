package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aeo
  extends bvk
{
  public String Title;
  public String niO;
  public LinkedList<String> wXv;
  public LinkedList<String> wXw;
  public LinkedList<String> wXx;
  public LinkedList<aep> wXy;
  
  public aeo()
  {
    AppMethodBeat.i(112423);
    this.wXv = new LinkedList();
    this.wXw = new LinkedList();
    this.wXx = new LinkedList();
    this.wXy = new LinkedList();
    AppMethodBeat.o(112423);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(112424);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(112424);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(112424);
        throw paramVarArgs;
      }
      if (this.niO == null)
      {
        paramVarArgs = new b("Not all required fields were included: JsonData");
        AppMethodBeat.o(112424);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      paramVarArgs.e(3, 1, this.wXv);
      if (this.niO != null) {
        paramVarArgs.e(4, this.niO);
      }
      paramVarArgs.e(5, 1, this.wXw);
      paramVarArgs.e(6, 1, this.wXx);
      paramVarArgs.e(7, 8, this.wXy);
      AppMethodBeat.o(112424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Title);
      }
      i += e.a.a.a.c(3, 1, this.wXv);
      paramInt = i;
      if (this.niO != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.niO);
      }
      i = e.a.a.a.c(5, 1, this.wXw);
      int j = e.a.a.a.c(6, 1, this.wXx);
      int k = e.a.a.a.c(7, 8, this.wXy);
      AppMethodBeat.o(112424);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wXv.clear();
        this.wXw.clear();
        this.wXx.clear();
        this.wXy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(112424);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(112424);
          throw paramVarArgs;
        }
        if (this.niO == null)
        {
          paramVarArgs = new b("Not all required fields were included: JsonData");
          AppMethodBeat.o(112424);
          throw paramVarArgs;
        }
        AppMethodBeat.o(112424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aeo localaeo = (aeo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(112424);
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
            localaeo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(112424);
          return 0;
        case 2: 
          localaeo.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112424);
          return 0;
        case 3: 
          localaeo.wXv.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(112424);
          return 0;
        case 4: 
          localaeo.niO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(112424);
          return 0;
        case 5: 
          localaeo.wXw.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(112424);
          return 0;
        case 6: 
          localaeo.wXx.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(112424);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aep();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aep)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaeo.wXy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(112424);
        return 0;
      }
      AppMethodBeat.o(112424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeo
 * JD-Core Version:    0.7.0.1
 */