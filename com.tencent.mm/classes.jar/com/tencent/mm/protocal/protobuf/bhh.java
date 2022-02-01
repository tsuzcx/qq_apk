package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhh
  extends dpc
{
  public int KOL;
  public LinkedList<com.tencent.mm.bw.b> LRg;
  public LinkedList<Integer> LRr;
  public LinkedList<bhg> LRs;
  public LinkedList<bhb> LRt;
  
  public bhh()
  {
    AppMethodBeat.i(152550);
    this.LRr = new LinkedList();
    this.LRs = new LinkedList();
    this.LRt = new LinkedList();
    this.LRg = new LinkedList();
    AppMethodBeat.o(152550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152551);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152551);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KOL);
      paramVarArgs.e(3, 2, this.LRr);
      paramVarArgs.e(4, 8, this.LRs);
      paramVarArgs.e(5, 8, this.LRt);
      paramVarArgs.e(7, 6, this.LRg);
      AppMethodBeat.o(152551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label817;
      }
    }
    label817:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.KOL);
      int j = g.a.a.a.c(3, 2, this.LRr);
      int k = g.a.a.a.c(4, 8, this.LRs);
      int m = g.a.a.a.c(5, 8, this.LRt);
      int n = g.a.a.a.c(7, 6, this.LRg);
      AppMethodBeat.o(152551);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LRr.clear();
        this.LRs.clear();
        this.LRt.clear();
        this.LRg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bhh localbhh = (bhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(152551);
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
            localbhh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 2: 
          localbhh.KOL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152551);
          return 0;
        case 3: 
          localbhh.LRr.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(152551);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhh.LRs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhh.LRt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        }
        localbhh.LRg.add(((g.a.a.a.a)localObject1).UbS.hPo());
        AppMethodBeat.o(152551);
        return 0;
      }
      AppMethodBeat.o(152551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhh
 * JD-Core Version:    0.7.0.1
 */