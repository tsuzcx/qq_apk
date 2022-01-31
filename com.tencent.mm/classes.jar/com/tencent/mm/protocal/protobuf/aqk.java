package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aqk
  extends bvk
{
  public LinkedList<bg> ntB;
  public LinkedList<atf> nth;
  public int xfO;
  public LinkedList<brj> xfP;
  public int xfQ;
  public int xfR;
  public int xfS;
  public ate xfT;
  
  public aqk()
  {
    AppMethodBeat.i(80099);
    this.xfP = new LinkedList();
    this.ntB = new LinkedList();
    this.nth = new LinkedList();
    AppMethodBeat.o(80099);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80100);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80100);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xfO);
      paramVarArgs.e(3, 8, this.xfP);
      paramVarArgs.aO(4, this.xfQ);
      paramVarArgs.aO(5, this.xfR);
      paramVarArgs.e(6, 8, this.ntB);
      paramVarArgs.aO(7, this.xfS);
      paramVarArgs.e(8, 8, this.nth);
      if (this.xfT != null)
      {
        paramVarArgs.iQ(9, this.xfT.computeSize());
        this.xfT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(80100);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1102;
      }
    }
    label1102:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xfO) + e.a.a.a.c(3, 8, this.xfP) + e.a.a.b.b.a.bl(4, this.xfQ) + e.a.a.b.b.a.bl(5, this.xfR) + e.a.a.a.c(6, 8, this.ntB) + e.a.a.b.b.a.bl(7, this.xfS) + e.a.a.a.c(8, 8, this.nth);
      paramInt = i;
      if (this.xfT != null) {
        paramInt = i + e.a.a.a.iP(9, this.xfT.computeSize());
      }
      AppMethodBeat.o(80100);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xfP.clear();
        this.ntB.clear();
        this.nth.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(80100);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80100);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aqk localaqk = (aqk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80100);
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
            localaqk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80100);
          return 0;
        case 2: 
          localaqk.xfO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80100);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaqk.xfP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80100);
          return 0;
        case 4: 
          localaqk.xfQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80100);
          return 0;
        case 5: 
          localaqk.xfR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80100);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaqk.ntB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80100);
          return 0;
        case 7: 
          localaqk.xfS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80100);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaqk.nth.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80100);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ate();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ate)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaqk.xfT = ((ate)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80100);
        return 0;
      }
      AppMethodBeat.o(80100);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqk
 * JD-Core Version:    0.7.0.1
 */