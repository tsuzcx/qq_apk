package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aog
  extends cwj
{
  public int GFM;
  public LinkedList<FinderContact> GFl;
  public int continueFlag;
  public b lastBuffer;
  
  public aog()
  {
    AppMethodBeat.i(168980);
    this.GFl = new LinkedList();
    AppMethodBeat.o(168980);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168981);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GFl);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aS(4, this.continueFlag);
      paramVarArgs.aS(5, this.GFM);
      AppMethodBeat.o(168981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GFl);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = f.a.a.b.b.a.bz(4, this.continueFlag);
      int j = f.a.a.b.b.a.bz(5, this.GFM);
      AppMethodBeat.o(168981);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GFl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168981);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aog localaog = (aog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168981);
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
            localaog.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168981);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaog.GFl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168981);
          return 0;
        case 3: 
          localaog.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168981);
          return 0;
        case 4: 
          localaog.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168981);
          return 0;
        }
        localaog.GFM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168981);
        return 0;
      }
      AppMethodBeat.o(168981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aog
 * JD-Core Version:    0.7.0.1
 */