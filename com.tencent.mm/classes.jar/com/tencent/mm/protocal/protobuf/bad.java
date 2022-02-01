package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bad
  extends cwj
{
  public LinkedList<pp> FQQ;
  public int FRF;
  public long GNP;
  public int GQl;
  public int GeQ;
  public int GeT;
  
  public bad()
  {
    AppMethodBeat.i(117869);
    this.FQQ = new LinkedList();
    AppMethodBeat.o(117869);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117870);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.FQQ);
      paramVarArgs.aS(3, this.GeQ);
      paramVarArgs.aS(4, this.GQl);
      paramVarArgs.aS(5, this.FRF);
      paramVarArgs.aZ(6, this.GNP);
      paramVarArgs.aS(7, this.GeT);
      AppMethodBeat.o(117870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.FQQ);
      int j = f.a.a.b.b.a.bz(3, this.GeQ);
      int k = f.a.a.b.b.a.bz(4, this.GQl);
      int m = f.a.a.b.b.a.bz(5, this.FRF);
      int n = f.a.a.b.b.a.p(6, this.GNP);
      int i1 = f.a.a.b.b.a.bz(7, this.GeT);
      AppMethodBeat.o(117870);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FQQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117870);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bad localbad = (bad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117870);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbad.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbad.FQQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117870);
          return 0;
        case 3: 
          localbad.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117870);
          return 0;
        case 4: 
          localbad.GQl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117870);
          return 0;
        case 5: 
          localbad.FRF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117870);
          return 0;
        case 6: 
          localbad.GNP = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(117870);
          return 0;
        }
        localbad.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117870);
        return 0;
      }
      AppMethodBeat.o(117870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bad
 * JD-Core Version:    0.7.0.1
 */