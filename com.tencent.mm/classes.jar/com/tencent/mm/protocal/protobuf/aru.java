package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aru
  extends cwj
{
  public int continueFlag;
  public String dyb;
  public int offset;
  public LinkedList<FinderObject> rBY;
  public b skw;
  public LinkedList<ars> vTm;
  
  public aru()
  {
    AppMethodBeat.i(169049);
    this.vTm = new LinkedList();
    this.rBY = new LinkedList();
    AppMethodBeat.o(169049);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169050);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.vTm);
      paramVarArgs.aS(3, this.offset);
      paramVarArgs.aS(4, this.continueFlag);
      paramVarArgs.e(5, 8, this.rBY);
      if (this.skw != null) {
        paramVarArgs.c(6, this.skw);
      }
      if (this.dyb != null) {
        paramVarArgs.d(7, this.dyb);
      }
      AppMethodBeat.o(169050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.vTm) + f.a.a.b.b.a.bz(3, this.offset) + f.a.a.b.b.a.bz(4, this.continueFlag) + f.a.a.a.c(5, 8, this.rBY);
      paramInt = i;
      if (this.skw != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.skw);
      }
      i = paramInt;
      if (this.dyb != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dyb);
      }
      AppMethodBeat.o(169050);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vTm.clear();
        this.rBY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169050);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aru localaru = (aru)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169050);
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
            localaru.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ars();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ars)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaru.vTm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 3: 
          localaru.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169050);
          return 0;
        case 4: 
          localaru.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169050);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaru.rBY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 6: 
          localaru.skw = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(169050);
          return 0;
        }
        localaru.dyb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169050);
        return 0;
      }
      AppMethodBeat.o(169050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aru
 * JD-Core Version:    0.7.0.1
 */