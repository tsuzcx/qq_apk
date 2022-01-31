package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class azn
  extends bvk
{
  public azj xoT;
  public se xoU;
  public czq xoV;
  public bor xoW;
  public ay xoX;
  public bjk xoY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96274);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96274);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xoT != null)
      {
        paramVarArgs.iQ(2, this.xoT.computeSize());
        this.xoT.writeFields(paramVarArgs);
      }
      if (this.xoU != null)
      {
        paramVarArgs.iQ(3, this.xoU.computeSize());
        this.xoU.writeFields(paramVarArgs);
      }
      if (this.xoV != null)
      {
        paramVarArgs.iQ(4, this.xoV.computeSize());
        this.xoV.writeFields(paramVarArgs);
      }
      if (this.xoW != null)
      {
        paramVarArgs.iQ(5, this.xoW.computeSize());
        this.xoW.writeFields(paramVarArgs);
      }
      if (this.xoX != null)
      {
        paramVarArgs.iQ(6, this.xoX.computeSize());
        this.xoX.writeFields(paramVarArgs);
      }
      if (this.xoY != null)
      {
        paramVarArgs.iQ(7, this.xoY.computeSize());
        this.xoY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(96274);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1286;
      }
    }
    label1286:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xoT != null) {
        paramInt = i + e.a.a.a.iP(2, this.xoT.computeSize());
      }
      i = paramInt;
      if (this.xoU != null) {
        i = paramInt + e.a.a.a.iP(3, this.xoU.computeSize());
      }
      paramInt = i;
      if (this.xoV != null) {
        paramInt = i + e.a.a.a.iP(4, this.xoV.computeSize());
      }
      i = paramInt;
      if (this.xoW != null) {
        i = paramInt + e.a.a.a.iP(5, this.xoW.computeSize());
      }
      paramInt = i;
      if (this.xoX != null) {
        paramInt = i + e.a.a.a.iP(6, this.xoX.computeSize());
      }
      i = paramInt;
      if (this.xoY != null) {
        i = paramInt + e.a.a.a.iP(7, this.xoY.computeSize());
      }
      AppMethodBeat.o(96274);
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
          AppMethodBeat.o(96274);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96274);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        azn localazn = (azn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96274);
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
            localazn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96274);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazn.xoT = ((azj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96274);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new se();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((se)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazn.xoU = ((se)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96274);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazn.xoV = ((czq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96274);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bor();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bor)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazn.xoW = ((bor)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96274);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ay();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ay)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazn.xoX = ((ay)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96274);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localazn.xoY = ((bjk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(96274);
        return 0;
      }
      AppMethodBeat.o(96274);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azn
 * JD-Core Version:    0.7.0.1
 */