package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bsz
  extends bvk
{
  public int jJu;
  public String wuE;
  public LinkedList<cpm> xGC;
  public clf xGD;
  public int xor;
  
  public bsz()
  {
    AppMethodBeat.i(113790);
    this.xGC = new LinkedList();
    AppMethodBeat.o(113790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113791);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(113791);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jJu);
      paramVarArgs.e(3, 8, this.xGC);
      if (this.wuE != null) {
        paramVarArgs.e(4, this.wuE);
      }
      paramVarArgs.aO(5, this.xor);
      if (this.xGD != null)
      {
        paramVarArgs.iQ(6, this.xGD.computeSize());
        this.xGD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jJu) + e.a.a.a.c(3, 8, this.xGC);
      paramInt = i;
      if (this.wuE != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wuE);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xor);
      paramInt = i;
      if (this.xGD != null) {
        paramInt = i + e.a.a.a.iP(6, this.xGD.computeSize());
      }
      AppMethodBeat.o(113791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xGC.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(113791);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113791);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bsz localbsz = (bsz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113791);
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
            localbsz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113791);
          return 0;
        case 2: 
          localbsz.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113791);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbsz.xGC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113791);
          return 0;
        case 4: 
          localbsz.wuE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(113791);
          return 0;
        case 5: 
          localbsz.xor = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(113791);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbsz.xGD = ((clf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113791);
        return 0;
      }
      AppMethodBeat.o(113791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsz
 * JD-Core Version:    0.7.0.1
 */