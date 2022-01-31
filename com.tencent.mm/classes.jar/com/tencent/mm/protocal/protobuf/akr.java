package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class akr
  extends bvk
{
  public int OpCode;
  public String xbL;
  public nf xbM;
  public long xbN;
  public cm xbO;
  public int xbP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(59564);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(59564);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.OpCode);
      paramVarArgs.am(3, this.xbN);
      if (this.xbO != null)
      {
        paramVarArgs.iQ(4, this.xbO.computeSize());
        this.xbO.writeFields(paramVarArgs);
      }
      if (this.xbL != null) {
        paramVarArgs.e(5, this.xbL);
      }
      paramVarArgs.aO(6, this.xbP);
      if (this.xbM != null)
      {
        paramVarArgs.iQ(7, this.xbM.computeSize());
        this.xbM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(59564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.OpCode) + e.a.a.b.b.a.p(3, this.xbN);
      paramInt = i;
      if (this.xbO != null) {
        paramInt = i + e.a.a.a.iP(4, this.xbO.computeSize());
      }
      i = paramInt;
      if (this.xbL != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xbL);
      }
      i += e.a.a.b.b.a.bl(6, this.xbP);
      paramInt = i;
      if (this.xbM != null) {
        paramInt = i + e.a.a.a.iP(7, this.xbM.computeSize());
      }
      AppMethodBeat.o(59564);
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
          AppMethodBeat.o(59564);
          throw paramVarArgs;
        }
        AppMethodBeat.o(59564);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        akr localakr = (akr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(59564);
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
            localakr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(59564);
          return 0;
        case 2: 
          localakr.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(59564);
          return 0;
        case 3: 
          localakr.xbN = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(59564);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localakr.xbO = ((cm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(59564);
          return 0;
        case 5: 
          localakr.xbL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(59564);
          return 0;
        case 6: 
          localakr.xbP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(59564);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nf();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localakr.xbM = ((nf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(59564);
        return 0;
      }
      AppMethodBeat.o(59564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akr
 * JD-Core Version:    0.7.0.1
 */