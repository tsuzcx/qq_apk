package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzk
  extends cwj
{
  public int Gxq;
  public long Gxr;
  public int Hqo;
  public int HzI;
  public int Iet;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115877);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115877);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.HzI);
      paramVarArgs.aS(5, this.Hqo);
      paramVarArgs.aS(6, this.Iet);
      AppMethodBeat.o(115877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gxq);
      int j = f.a.a.b.b.a.p(3, this.Gxr);
      int k = f.a.a.b.b.a.bz(4, this.HzI);
      int m = f.a.a.b.b.a.bz(5, this.Hqo);
      int n = f.a.a.b.b.a.bz(6, this.Iet);
      AppMethodBeat.o(115877);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115877);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115877);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzk localdzk = (dzk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115877);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115877);
          return 0;
        case 2: 
          localdzk.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115877);
          return 0;
        case 3: 
          localdzk.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115877);
          return 0;
        case 4: 
          localdzk.HzI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115877);
          return 0;
        case 5: 
          localdzk.Hqo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115877);
          return 0;
        }
        localdzk.Iet = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115877);
        return 0;
      }
      AppMethodBeat.o(115877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzk
 * JD-Core Version:    0.7.0.1
 */