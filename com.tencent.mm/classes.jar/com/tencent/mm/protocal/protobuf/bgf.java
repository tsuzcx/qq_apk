package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bgf
  extends cwj
{
  public int GUM;
  public int GeQ;
  public int nID;
  public LinkedList<chu> nIE;
  public int nJA;
  
  public bgf()
  {
    AppMethodBeat.i(152590);
    this.nIE = new LinkedList();
    AppMethodBeat.o(152590);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152591);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nID);
      paramVarArgs.e(3, 8, this.nIE);
      paramVarArgs.aS(4, this.GeQ);
      paramVarArgs.aS(5, this.GUM);
      paramVarArgs.aS(6, this.nJA);
      AppMethodBeat.o(152591);
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
      int i = f.a.a.b.b.a.bz(2, this.nID);
      int j = f.a.a.a.c(3, 8, this.nIE);
      int k = f.a.a.b.b.a.bz(4, this.GeQ);
      int m = f.a.a.b.b.a.bz(5, this.GUM);
      int n = f.a.a.b.b.a.bz(6, this.nJA);
      AppMethodBeat.o(152591);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nIE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bgf localbgf = (bgf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152591);
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
            localbgf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152591);
          return 0;
        case 2: 
          localbgf.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152591);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbgf.nIE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152591);
          return 0;
        case 4: 
          localbgf.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152591);
          return 0;
        case 5: 
          localbgf.GUM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152591);
          return 0;
        }
        localbgf.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152591);
        return 0;
      }
      AppMethodBeat.o(152591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgf
 * JD-Core Version:    0.7.0.1
 */