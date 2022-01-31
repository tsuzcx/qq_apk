package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aaw
  extends bvk
{
  public aaz wRp;
  public aat wRq;
  public aau wRr;
  public String wRs;
  public int wRt;
  public int wRu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28398);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28398);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wRp != null)
      {
        paramVarArgs.iQ(2, this.wRp.computeSize());
        this.wRp.writeFields(paramVarArgs);
      }
      if (this.wRq != null)
      {
        paramVarArgs.iQ(3, this.wRq.computeSize());
        this.wRq.writeFields(paramVarArgs);
      }
      if (this.wRr != null)
      {
        paramVarArgs.iQ(4, this.wRr.computeSize());
        this.wRr.writeFields(paramVarArgs);
      }
      if (this.wRs != null) {
        paramVarArgs.e(5, this.wRs);
      }
      paramVarArgs.aO(6, this.wRt);
      paramVarArgs.aO(7, this.wRu);
      AppMethodBeat.o(28398);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label991;
      }
    }
    label991:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wRp != null) {
        paramInt = i + e.a.a.a.iP(2, this.wRp.computeSize());
      }
      i = paramInt;
      if (this.wRq != null) {
        i = paramInt + e.a.a.a.iP(3, this.wRq.computeSize());
      }
      paramInt = i;
      if (this.wRr != null) {
        paramInt = i + e.a.a.a.iP(4, this.wRr.computeSize());
      }
      i = paramInt;
      if (this.wRs != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wRs);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.wRt);
      int j = e.a.a.b.b.a.bl(7, this.wRu);
      AppMethodBeat.o(28398);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28398);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28398);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aaw localaaw = (aaw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28398);
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
            localaaw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28398);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaaw.wRp = ((aaz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28398);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aat();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aat)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaaw.wRq = ((aat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28398);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aau();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aau)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaaw.wRr = ((aau)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28398);
          return 0;
        case 5: 
          localaaw.wRs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28398);
          return 0;
        case 6: 
          localaaw.wRt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28398);
          return 0;
        }
        localaaw.wRu = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28398);
        return 0;
      }
      AppMethodBeat.o(28398);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaw
 * JD-Core Version:    0.7.0.1
 */