package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abw
  extends cwj
{
  public String Dhc;
  public LinkedList<ss> GtQ;
  public int GtR;
  public int GtS;
  public int version;
  
  public abw()
  {
    AppMethodBeat.i(32177);
    this.GtQ = new LinkedList();
    AppMethodBeat.o(32177);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32178);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GtQ);
      paramVarArgs.aS(3, this.version);
      paramVarArgs.aS(4, this.GtR);
      paramVarArgs.aS(5, this.GtS);
      if (this.Dhc != null) {
        paramVarArgs.d(6, this.Dhc);
      }
      AppMethodBeat.o(32178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GtQ) + f.a.a.b.b.a.bz(3, this.version) + f.a.a.b.b.a.bz(4, this.GtR) + f.a.a.b.b.a.bz(5, this.GtS);
      paramInt = i;
      if (this.Dhc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dhc);
      }
      AppMethodBeat.o(32178);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GtQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32178);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32178);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abw localabw = (abw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32178);
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
            localabw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabw.GtQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32178);
          return 0;
        case 3: 
          localabw.version = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32178);
          return 0;
        case 4: 
          localabw.GtR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32178);
          return 0;
        case 5: 
          localabw.GtS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32178);
          return 0;
        }
        localabw.Dhc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32178);
        return 0;
      }
      AppMethodBeat.o(32178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abw
 * JD-Core Version:    0.7.0.1
 */