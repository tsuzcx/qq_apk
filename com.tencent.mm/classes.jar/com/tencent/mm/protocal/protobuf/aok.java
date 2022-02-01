package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aok
  extends cwj
{
  public LinkedList<FinderObject> GFP;
  public int continueFlag;
  public int fVS;
  public com.tencent.mm.bw.b lastBuffer;
  
  public aok()
  {
    AppMethodBeat.i(168986);
    this.GFP = new LinkedList();
    AppMethodBeat.o(168986);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168987);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168987);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GFP);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aS(4, this.continueFlag);
      paramVarArgs.aS(5, this.fVS);
      AppMethodBeat.o(168987);
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
      int i = paramInt + f.a.a.a.c(2, 8, this.GFP);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = f.a.a.b.b.a.bz(4, this.continueFlag);
      int j = f.a.a.b.b.a.bz(5, this.fVS);
      AppMethodBeat.o(168987);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GFP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168987);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168987);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aok localaok = (aok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168987);
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
            localaok.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168987);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaok.GFP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168987);
          return 0;
        case 3: 
          localaok.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168987);
          return 0;
        case 4: 
          localaok.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168987);
          return 0;
        }
        localaok.fVS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168987);
        return 0;
      }
      AppMethodBeat.o(168987);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aok
 * JD-Core Version:    0.7.0.1
 */