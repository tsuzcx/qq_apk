package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class djz
  extends cwj
{
  public int FJk;
  public int GeQ;
  public LinkedList<dkn> HRI;
  public long HRJ;
  public int HRq;
  
  public djz()
  {
    AppMethodBeat.i(118445);
    this.HRI = new LinkedList();
    AppMethodBeat.o(118445);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118446);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HRq);
      paramVarArgs.e(3, 8, this.HRI);
      paramVarArgs.aZ(4, this.HRJ);
      paramVarArgs.aS(5, this.GeQ);
      paramVarArgs.aS(6, this.FJk);
      AppMethodBeat.o(118446);
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
      int i = f.a.a.b.b.a.bz(2, this.HRq);
      int j = f.a.a.a.c(3, 8, this.HRI);
      int k = f.a.a.b.b.a.p(4, this.HRJ);
      int m = f.a.a.b.b.a.bz(5, this.GeQ);
      int n = f.a.a.b.b.a.bz(6, this.FJk);
      AppMethodBeat.o(118446);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HRI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djz localdjz = (djz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118446);
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
            localdjz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 2: 
          localdjz.HRq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118446);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjz.HRI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 4: 
          localdjz.HRJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118446);
          return 0;
        case 5: 
          localdjz.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118446);
          return 0;
        }
        localdjz.FJk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118446);
        return 0;
      }
      AppMethodBeat.o(118446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djz
 * JD-Core Version:    0.7.0.1
 */