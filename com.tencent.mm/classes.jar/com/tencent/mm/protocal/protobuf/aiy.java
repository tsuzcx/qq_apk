package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aiy
  extends cld
{
  public long Dlp;
  public LinkedList<aii> Dlq;
  public int continueFlag;
  public b qHz;
  public LinkedList<FinderContact> qMq;
  
  public aiy()
  {
    AppMethodBeat.i(168977);
    this.qMq = new LinkedList();
    this.Dlq = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.qMq);
      paramVarArgs.aR(3, this.continueFlag);
      paramVarArgs.aG(4, this.Dlp);
      if (this.qHz != null) {
        paramVarArgs.c(5, this.qHz);
      }
      paramVarArgs.e(6, 8, this.Dlq);
      AppMethodBeat.o(168978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.qMq) + f.a.a.b.b.a.bA(3, this.continueFlag) + f.a.a.b.b.a.q(4, this.Dlp);
      paramInt = i;
      if (this.qHz != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.qHz);
      }
      i = f.a.a.a.c(6, 8, this.Dlq);
      AppMethodBeat.o(168978);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qMq.clear();
        this.Dlq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aiy localaiy = (aiy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168978);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaiy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaiy.qMq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
          return 0;
        case 3: 
          localaiy.continueFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168978);
          return 0;
        case 4: 
          localaiy.Dlp = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168978);
          return 0;
        case 5: 
          localaiy.qHz = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(168978);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aii();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaiy.Dlq.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiy
 * JD-Core Version:    0.7.0.1
 */