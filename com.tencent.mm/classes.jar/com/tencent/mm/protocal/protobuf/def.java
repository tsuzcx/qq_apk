package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class def
  extends cwj
{
  public int HLD;
  public LinkedList<ded> hFT;
  public int oHV;
  public long seq;
  
  public def()
  {
    AppMethodBeat.i(114076);
    this.hFT = new LinkedList();
    AppMethodBeat.o(114076);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114077);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114077);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.hFT);
      paramVarArgs.aS(3, this.HLD);
      paramVarArgs.aZ(4, this.seq);
      paramVarArgs.aS(5, this.oHV);
      AppMethodBeat.o(114077);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.hFT);
      int j = f.a.a.b.b.a.bz(3, this.HLD);
      int k = f.a.a.b.b.a.p(4, this.seq);
      int m = f.a.a.b.b.a.bz(5, this.oHV);
      AppMethodBeat.o(114077);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hFT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114077);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114077);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        def localdef = (def)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114077);
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
            localdef.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114077);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ded();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ded)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdef.hFT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114077);
          return 0;
        case 3: 
          localdef.HLD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114077);
          return 0;
        case 4: 
          localdef.seq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(114077);
          return 0;
        }
        localdef.oHV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(114077);
        return 0;
      }
      AppMethodBeat.o(114077);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.def
 * JD-Core Version:    0.7.0.1
 */