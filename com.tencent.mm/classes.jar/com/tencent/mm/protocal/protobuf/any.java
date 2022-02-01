package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class any
  extends cwj
{
  public long GFK;
  public LinkedList<anb> GFL;
  public LinkedList<FinderContact> GFl;
  public int continueFlag;
  public b skw;
  
  public any()
  {
    AppMethodBeat.i(168977);
    this.GFl = new LinkedList();
    this.GFL = new LinkedList();
    AppMethodBeat.o(168977);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168978);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GFl);
      paramVarArgs.aS(3, this.continueFlag);
      paramVarArgs.aZ(4, this.GFK);
      if (this.skw != null) {
        paramVarArgs.c(5, this.skw);
      }
      paramVarArgs.e(6, 8, this.GFL);
      AppMethodBeat.o(168978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GFl) + f.a.a.b.b.a.bz(3, this.continueFlag) + f.a.a.b.b.a.p(4, this.GFK);
      paramInt = i;
      if (this.skw != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.skw);
      }
      i = f.a.a.a.c(6, 8, this.GFL);
      AppMethodBeat.o(168978);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GFl.clear();
        this.GFL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        any localany = (any)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168978);
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
            localany.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
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
            localany.GFl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
          return 0;
        case 3: 
          localany.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(168978);
          return 0;
        case 4: 
          localany.GFK = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(168978);
          return 0;
        case 5: 
          localany.skw = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168978);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((anb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localany.GFL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168978);
        return 0;
      }
      AppMethodBeat.o(168978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.any
 * JD-Core Version:    0.7.0.1
 */