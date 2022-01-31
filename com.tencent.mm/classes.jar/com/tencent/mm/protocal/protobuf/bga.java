package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bga
  extends buy
{
  public String jJA;
  public String lGH;
  public SKBuiltinBuffer_t xuQ;
  public SKBuiltinBuffer_t xuR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58917);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xuQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(58917);
        throw paramVarArgs;
      }
      if (this.xuR == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(58917);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      if (this.xuQ != null)
      {
        paramVarArgs.iQ(3, this.xuQ.computeSize());
        this.xuQ.writeFields(paramVarArgs);
      }
      if (this.xuR != null)
      {
        paramVarArgs.iQ(4, this.xuR.computeSize());
        this.xuR.writeFields(paramVarArgs);
      }
      if (this.lGH != null) {
        paramVarArgs.e(5, this.lGH);
      }
      AppMethodBeat.o(58917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label834;
      }
    }
    label834:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = paramInt;
      if (this.xuQ != null) {
        i = paramInt + e.a.a.a.iP(3, this.xuQ.computeSize());
      }
      paramInt = i;
      if (this.xuR != null) {
        paramInt = i + e.a.a.a.iP(4, this.xuR.computeSize());
      }
      i = paramInt;
      if (this.lGH != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.lGH);
      }
      AppMethodBeat.o(58917);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xuQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(58917);
          throw paramVarArgs;
        }
        if (this.xuR == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(58917);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bga localbga = (bga)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58917);
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
            localbga.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58917);
          return 0;
        case 2: 
          localbga.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58917);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbga.xuQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58917);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbga.xuR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58917);
          return 0;
        }
        localbga.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58917);
        return 0;
      }
      AppMethodBeat.o(58917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bga
 * JD-Core Version:    0.7.0.1
 */