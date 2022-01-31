package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class csp
  extends bvk
{
  public int CreateTime;
  public int eeF;
  public int wQP;
  public long wQQ;
  public int yaX;
  public String ybf;
  public LinkedList<ctl> ybg;
  
  public csp()
  {
    AppMethodBeat.i(5245);
    this.ybg = new LinkedList();
    AppMethodBeat.o(5245);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5246);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5246);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.aO(4, this.CreateTime);
      paramVarArgs.aO(6, this.eeF);
      paramVarArgs.e(7, 8, this.ybg);
      if (this.ybf != null) {
        paramVarArgs.e(8, this.ybf);
      }
      paramVarArgs.aO(9, this.yaX);
      AppMethodBeat.o(5246);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label800;
      }
    }
    label800:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wQP) + e.a.a.b.b.a.p(3, this.wQQ) + e.a.a.b.b.a.bl(4, this.CreateTime) + e.a.a.b.b.a.bl(6, this.eeF) + e.a.a.a.c(7, 8, this.ybg);
      paramInt = i;
      if (this.ybf != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.ybf);
      }
      i = e.a.a.b.b.a.bl(9, this.yaX);
      AppMethodBeat.o(5246);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ybg.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(5246);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5246);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        csp localcsp = (csp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(5246);
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
            localcsp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5246);
          return 0;
        case 2: 
          localcsp.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5246);
          return 0;
        case 3: 
          localcsp.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5246);
          return 0;
        case 4: 
          localcsp.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5246);
          return 0;
        case 6: 
          localcsp.eeF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5246);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcsp.ybg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5246);
          return 0;
        case 8: 
          localcsp.ybf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(5246);
          return 0;
        }
        localcsp.yaX = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5246);
        return 0;
      }
      AppMethodBeat.o(5246);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csp
 * JD-Core Version:    0.7.0.1
 */