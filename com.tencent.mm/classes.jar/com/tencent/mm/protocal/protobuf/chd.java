package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class chd
  extends bvk
{
  public int wBX;
  public int wlc;
  public LinkedList<chs> xRR;
  public long xRS;
  public int xRy;
  
  public chd()
  {
    AppMethodBeat.i(56510);
    this.xRR = new LinkedList();
    AppMethodBeat.o(56510);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56511);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56511);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xRy);
      paramVarArgs.e(3, 8, this.xRR);
      paramVarArgs.am(4, this.xRS);
      paramVarArgs.aO(5, this.wBX);
      paramVarArgs.aO(6, this.wlc);
      AppMethodBeat.o(56511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xRy);
      int j = e.a.a.a.c(3, 8, this.xRR);
      int k = e.a.a.b.b.a.p(4, this.xRS);
      int m = e.a.a.b.b.a.bl(5, this.wBX);
      int n = e.a.a.b.b.a.bl(6, this.wlc);
      AppMethodBeat.o(56511);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xRR.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56511);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        chd localchd = (chd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56511);
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
            localchd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56511);
          return 0;
        case 2: 
          localchd.xRy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56511);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localchd.xRR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56511);
          return 0;
        case 4: 
          localchd.xRS = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56511);
          return 0;
        case 5: 
          localchd.wBX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56511);
          return 0;
        }
        localchd.wlc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56511);
        return 0;
      }
      AppMethodBeat.o(56511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chd
 * JD-Core Version:    0.7.0.1
 */