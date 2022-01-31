package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arc
  extends bvk
{
  public cpg wPc;
  public com.tencent.mm.bv.b xgp;
  public LinkedList<cpe> xgq;
  public int xgr;
  
  public arc()
  {
    AppMethodBeat.i(127725);
    this.xgq = new LinkedList();
    AppMethodBeat.o(127725);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127726);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127726);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wPc != null)
      {
        paramVarArgs.iQ(2, this.wPc.computeSize());
        this.wPc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.xgq);
      if (this.xgp != null) {
        paramVarArgs.c(4, this.xgp);
      }
      paramVarArgs.aO(5, this.xgr);
      AppMethodBeat.o(127726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wPc != null) {
        i = paramInt + e.a.a.a.iP(2, this.wPc.computeSize());
      }
      i += e.a.a.a.c(3, 8, this.xgq);
      paramInt = i;
      if (this.xgp != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.xgp);
      }
      i = e.a.a.b.b.a.bl(5, this.xgr);
      AppMethodBeat.o(127726);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xgq.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(127726);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127726);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        arc localarc = (arc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127726);
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
            localarc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127726);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localarc.wPc = ((cpg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127726);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localarc.xgq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127726);
          return 0;
        case 4: 
          localarc.xgp = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(127726);
          return 0;
        }
        localarc.xgr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(127726);
        return 0;
      }
      AppMethodBeat.o(127726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arc
 * JD-Core Version:    0.7.0.1
 */