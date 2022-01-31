package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cbl
  extends bvk
{
  public int Ret;
  public int jJu;
  public String puI;
  public LinkedList<cbj> xMe;
  public int xMf;
  
  public cbl()
  {
    AppMethodBeat.i(28644);
    this.xMe = new LinkedList();
    AppMethodBeat.o(28644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28645);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28645);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jJu);
      paramVarArgs.e(3, 8, this.xMe);
      if (this.puI != null) {
        paramVarArgs.e(4, this.puI);
      }
      paramVarArgs.aO(5, this.xMf);
      paramVarArgs.aO(6, this.Ret);
      AppMethodBeat.o(28645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jJu) + e.a.a.a.c(3, 8, this.xMe);
      paramInt = i;
      if (this.puI != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.puI);
      }
      i = e.a.a.b.b.a.bl(5, this.xMf);
      int j = e.a.a.b.b.a.bl(6, this.Ret);
      AppMethodBeat.o(28645);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xMe.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cbl localcbl = (cbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28645);
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
            localcbl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28645);
          return 0;
        case 2: 
          localcbl.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28645);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbl.xMe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28645);
          return 0;
        case 4: 
          localcbl.puI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28645);
          return 0;
        case 5: 
          localcbl.xMf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28645);
          return 0;
        }
        localcbl.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28645);
        return 0;
      }
      AppMethodBeat.o(28645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbl
 * JD-Core Version:    0.7.0.1
 */