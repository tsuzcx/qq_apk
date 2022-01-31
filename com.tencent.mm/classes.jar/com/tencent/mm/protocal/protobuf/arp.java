package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class arp
  extends buy
{
  public bwc wOT;
  public SKBuiltinBuffer_t wvN;
  public bwc xgU;
  public bwc xgV;
  public SKBuiltinBuffer_t xgW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73719);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOT == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(73719);
        throw paramVarArgs;
      }
      if (this.xgU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Pwd");
        AppMethodBeat.o(73719);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wOT != null)
      {
        paramVarArgs.iQ(2, this.wOT.computeSize());
        this.wOT.writeFields(paramVarArgs);
      }
      if (this.xgU != null)
      {
        paramVarArgs.iQ(3, this.xgU.computeSize());
        this.xgU.writeFields(paramVarArgs);
      }
      if (this.xgV != null)
      {
        paramVarArgs.iQ(4, this.xgV.computeSize());
        this.xgV.writeFields(paramVarArgs);
      }
      if (this.wvN != null)
      {
        paramVarArgs.iQ(5, this.wvN.computeSize());
        this.wvN.writeFields(paramVarArgs);
      }
      if (this.xgW != null)
      {
        paramVarArgs.iQ(6, this.xgW.computeSize());
        this.xgW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(73719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1178;
      }
    }
    label1178:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wOT != null) {
        paramInt = i + e.a.a.a.iP(2, this.wOT.computeSize());
      }
      i = paramInt;
      if (this.xgU != null) {
        i = paramInt + e.a.a.a.iP(3, this.xgU.computeSize());
      }
      paramInt = i;
      if (this.xgV != null) {
        paramInt = i + e.a.a.a.iP(4, this.xgV.computeSize());
      }
      i = paramInt;
      if (this.wvN != null) {
        i = paramInt + e.a.a.a.iP(5, this.wvN.computeSize());
      }
      paramInt = i;
      if (this.xgW != null) {
        paramInt = i + e.a.a.a.iP(6, this.xgW.computeSize());
      }
      AppMethodBeat.o(73719);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOT == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(73719);
          throw paramVarArgs;
        }
        if (this.xgU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Pwd");
          AppMethodBeat.o(73719);
          throw paramVarArgs;
        }
        AppMethodBeat.o(73719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        arp localarp = (arp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73719);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localarp.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73719);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localarp.wOT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73719);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localarp.xgU = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73719);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localarp.xgV = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73719);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localarp.wvN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73719);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localarp.xgW = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73719);
        return 0;
      }
      AppMethodBeat.o(73719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arp
 * JD-Core Version:    0.7.0.1
 */