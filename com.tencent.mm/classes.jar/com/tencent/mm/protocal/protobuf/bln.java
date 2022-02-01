package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bln
  extends dpc
{
  public LinkedList<qq> KKx;
  public int KLm;
  public int KZh;
  public int KZk;
  public long LRV;
  public int LUs;
  
  public bln()
  {
    AppMethodBeat.i(117869);
    this.KKx = new LinkedList();
    AppMethodBeat.o(117869);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117870);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.KKx);
      paramVarArgs.aM(3, this.KZh);
      paramVarArgs.aM(4, this.LUs);
      paramVarArgs.aM(5, this.KLm);
      paramVarArgs.bb(6, this.LRV);
      paramVarArgs.aM(7, this.KZk);
      AppMethodBeat.o(117870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.KKx);
      int j = g.a.a.b.b.a.bu(3, this.KZh);
      int k = g.a.a.b.b.a.bu(4, this.LUs);
      int m = g.a.a.b.b.a.bu(5, this.KLm);
      int n = g.a.a.b.b.a.r(6, this.LRV);
      int i1 = g.a.a.b.b.a.bu(7, this.KZk);
      AppMethodBeat.o(117870);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KKx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117870);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bln localbln = (bln)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117870);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbln.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbln.KKx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 3: 
          localbln.KZh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117870);
          return 0;
        case 4: 
          localbln.LUs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117870);
          return 0;
        case 5: 
          localbln.KLm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117870);
          return 0;
        case 6: 
          localbln.LRV = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(117870);
          return 0;
        }
        localbln.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117870);
        return 0;
      }
      AppMethodBeat.o(117870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bln
 * JD-Core Version:    0.7.0.1
 */