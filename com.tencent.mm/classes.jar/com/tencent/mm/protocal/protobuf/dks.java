package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dks
  extends cwj
{
  public dkn HRH;
  public int HSt;
  public int HSu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118470);
        throw paramVarArgs;
      }
      if (this.HRH == null)
      {
        paramVarArgs = new b("Not all required fields were included: StoryObject");
        AppMethodBeat.o(118470);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HRH != null)
      {
        paramVarArgs.lJ(2, this.HRH.computeSize());
        this.HRH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HSt);
      paramVarArgs.aS(4, this.HSu);
      AppMethodBeat.o(118470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HRH != null) {
        i = paramInt + f.a.a.a.lI(2, this.HRH.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HSt);
      int j = f.a.a.b.b.a.bz(4, this.HSu);
      AppMethodBeat.o(118470);
      return i + paramInt + j;
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
          AppMethodBeat.o(118470);
          throw paramVarArgs;
        }
        if (this.HRH == null)
        {
          paramVarArgs = new b("Not all required fields were included: StoryObject");
          AppMethodBeat.o(118470);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dks localdks = (dks)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118470);
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
            localdks.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118470);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdks.HRH = ((dkn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118470);
          return 0;
        case 3: 
          localdks.HSt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118470);
          return 0;
        }
        localdks.HSu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118470);
        return 0;
      }
      AppMethodBeat.o(118470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dks
 * JD-Core Version:    0.7.0.1
 */