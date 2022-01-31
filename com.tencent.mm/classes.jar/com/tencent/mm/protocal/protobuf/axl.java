package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class axl
  extends bvk
{
  public LinkedList<cpx> xmK;
  public LinkedList<String> xmL;
  public String xmM;
  public axe xmu;
  
  public axl()
  {
    AppMethodBeat.i(10205);
    this.xmK = new LinkedList();
    this.xmL = new LinkedList();
    AppMethodBeat.o(10205);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10206);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(10206);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xmu != null)
      {
        paramVarArgs.iQ(2, this.xmu.computeSize());
        this.xmu.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.xmK);
      paramVarArgs.e(4, 1, this.xmL);
      if (this.xmM != null) {
        paramVarArgs.e(5, this.xmM);
      }
      AppMethodBeat.o(10206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label781;
      }
    }
    label781:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xmu != null) {
        i = paramInt + e.a.a.a.iP(2, this.xmu.computeSize());
      }
      i = i + e.a.a.a.c(3, 8, this.xmK) + e.a.a.a.c(4, 1, this.xmL);
      paramInt = i;
      if (this.xmM != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xmM);
      }
      AppMethodBeat.o(10206);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xmK.clear();
        this.xmL.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(10206);
          throw paramVarArgs;
        }
        AppMethodBeat.o(10206);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axl localaxl = (axl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10206);
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
            localaxl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10206);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxl.xmu = ((axe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10206);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxl.xmK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10206);
          return 0;
        case 4: 
          localaxl.xmL.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(10206);
          return 0;
        }
        localaxl.xmM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10206);
        return 0;
      }
      AppMethodBeat.o(10206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axl
 * JD-Core Version:    0.7.0.1
 */