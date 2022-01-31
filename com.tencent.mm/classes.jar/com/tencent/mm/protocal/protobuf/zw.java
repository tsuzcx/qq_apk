package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class zw
  extends bvk
{
  public int wQP;
  public long wQQ;
  public int wQR;
  public int wQS;
  public int wQT;
  public LinkedList<cjn> wov;
  public int wta;
  public LinkedList<cjm> wtb;
  
  public zw()
  {
    AppMethodBeat.i(28387);
    this.wov = new LinkedList();
    this.wtb = new LinkedList();
    AppMethodBeat.o(28387);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28388);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28388);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.am(3, this.wQQ);
      paramVarArgs.aO(4, this.wQR);
      paramVarArgs.aO(5, this.wQS);
      paramVarArgs.e(6, 8, this.wov);
      paramVarArgs.aO(7, this.wQT);
      paramVarArgs.aO(8, this.wta);
      paramVarArgs.e(9, 8, this.wtb);
      AppMethodBeat.o(28388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label941;
      }
    }
    label941:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wQP);
      int j = e.a.a.b.b.a.p(3, this.wQQ);
      int k = e.a.a.b.b.a.bl(4, this.wQR);
      int m = e.a.a.b.b.a.bl(5, this.wQS);
      int n = e.a.a.a.c(6, 8, this.wov);
      int i1 = e.a.a.b.b.a.bl(7, this.wQT);
      int i2 = e.a.a.b.b.a.bl(8, this.wta);
      int i3 = e.a.a.a.c(9, 8, this.wtb);
      AppMethodBeat.o(28388);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wov.clear();
        this.wtb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28388);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28388);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        zw localzw = (zw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28388);
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
            localzw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28388);
          return 0;
        case 2: 
          localzw.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28388);
          return 0;
        case 3: 
          localzw.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28388);
          return 0;
        case 4: 
          localzw.wQR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28388);
          return 0;
        case 5: 
          localzw.wQS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28388);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localzw.wov.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28388);
          return 0;
        case 7: 
          localzw.wQT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28388);
          return 0;
        case 8: 
          localzw.wta = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28388);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjm();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localzw.wtb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28388);
        return 0;
      }
      AppMethodBeat.o(28388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zw
 * JD-Core Version:    0.7.0.1
 */