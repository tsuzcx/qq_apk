package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class apc
  extends bvk
{
  public long bqN;
  public int hdi;
  public LinkedList<bso> xff;
  public LinkedList<bsi> xfg;
  public int xfh;
  
  public apc()
  {
    AppMethodBeat.i(134431);
    this.xff = new LinkedList();
    this.xfg = new LinkedList();
    AppMethodBeat.o(134431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134432);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134432);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.hdi);
      paramVarArgs.e(3, 8, this.xff);
      paramVarArgs.am(4, this.bqN);
      paramVarArgs.e(5, 8, this.xfg);
      paramVarArgs.aO(6, this.xfh);
      AppMethodBeat.o(134432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.hdi);
      int j = e.a.a.a.c(3, 8, this.xff);
      int k = e.a.a.b.b.a.p(4, this.bqN);
      int m = e.a.a.a.c(5, 8, this.xfg);
      int n = e.a.a.b.b.a.bl(6, this.xfh);
      AppMethodBeat.o(134432);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xff.clear();
        this.xfg.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(134432);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        apc localapc = (apc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134432);
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
            localapc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134432);
          return 0;
        case 2: 
          localapc.hdi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(134432);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bso();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bso)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localapc.xff.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134432);
          return 0;
        case 4: 
          localapc.bqN = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(134432);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localapc.xfg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134432);
          return 0;
        }
        localapc.xfh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(134432);
        return 0;
      }
      AppMethodBeat.o(134432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apc
 * JD-Core Version:    0.7.0.1
 */