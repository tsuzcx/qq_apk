package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bgb
  extends bvk
{
  public int wBX;
  public int wlx;
  public SKBuiltinBuffer_t xuQ;
  public SKBuiltinBuffer_t xuR;
  public int xuS;
  public int xuT;
  public LinkedList<ud> xuU;
  
  public bgb()
  {
    AppMethodBeat.i(58918);
    this.xuU = new LinkedList();
    AppMethodBeat.o(58918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58919);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(58919);
        throw paramVarArgs;
      }
      if (this.xuQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(58919);
        throw paramVarArgs;
      }
      if (this.xuR == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(58919);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xuQ != null)
      {
        paramVarArgs.iQ(2, this.xuQ.computeSize());
        this.xuQ.writeFields(paramVarArgs);
      }
      if (this.xuR != null)
      {
        paramVarArgs.iQ(3, this.xuR.computeSize());
        this.xuR.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wBX);
      paramVarArgs.aO(5, this.xuS);
      paramVarArgs.aO(6, this.xuT);
      paramVarArgs.e(7, 8, this.xuU);
      paramVarArgs.aO(8, this.wlx);
      AppMethodBeat.o(58919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xuQ != null) {
        paramInt = i + e.a.a.a.iP(2, this.xuQ.computeSize());
      }
      i = paramInt;
      if (this.xuR != null) {
        i = paramInt + e.a.a.a.iP(3, this.xuR.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(4, this.wBX);
      int j = e.a.a.b.b.a.bl(5, this.xuS);
      int k = e.a.a.b.b.a.bl(6, this.xuT);
      int m = e.a.a.a.c(7, 8, this.xuU);
      int n = e.a.a.b.b.a.bl(8, this.wlx);
      AppMethodBeat.o(58919);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xuU.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(58919);
          throw paramVarArgs;
        }
        if (this.xuQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(58919);
          throw paramVarArgs;
        }
        if (this.xuR == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(58919);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bgb localbgb = (bgb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58919);
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
            localbgb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58919);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgb.xuQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58919);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgb.xuR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58919);
          return 0;
        case 4: 
          localbgb.wBX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58919);
          return 0;
        case 5: 
          localbgb.xuS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58919);
          return 0;
        case 6: 
          localbgb.xuT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58919);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ud();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ud)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgb.xuU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58919);
          return 0;
        }
        localbgb.wlx = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58919);
        return 0;
      }
      AppMethodBeat.o(58919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgb
 * JD-Core Version:    0.7.0.1
 */