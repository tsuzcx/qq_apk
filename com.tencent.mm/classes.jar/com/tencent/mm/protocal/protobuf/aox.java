package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aox
  extends cwj
{
  public String GEf;
  public int continueFlag;
  public b lastBuffer;
  public LinkedList<FinderObject> object;
  public arc preloadInfo;
  public b rSO;
  
  public aox()
  {
    AppMethodBeat.i(189361);
    this.object = new LinkedList();
    AppMethodBeat.o(189361);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189362);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aS(4, this.continueFlag);
      if (this.rSO != null) {
        paramVarArgs.c(5, this.rSO);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.lJ(6, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.GEf != null) {
        paramVarArgs.d(7, this.GEf);
      }
      AppMethodBeat.o(189362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.continueFlag);
      paramInt = i;
      if (this.rSO != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.rSO);
      }
      i = paramInt;
      if (this.preloadInfo != null) {
        i = paramInt + f.a.a.a.lI(6, this.preloadInfo.computeSize());
      }
      paramInt = i;
      if (this.GEf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GEf);
      }
      AppMethodBeat.o(189362);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aox localaox = (aox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189362);
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
            localaox.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189362);
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
            localaox.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189362);
          return 0;
        case 3: 
          localaox.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(189362);
          return 0;
        case 4: 
          localaox.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189362);
          return 0;
        case 5: 
          localaox.rSO = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(189362);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaox.preloadInfo = ((arc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189362);
          return 0;
        }
        localaox.GEf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189362);
        return 0;
      }
      AppMethodBeat.o(189362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aox
 * JD-Core Version:    0.7.0.1
 */