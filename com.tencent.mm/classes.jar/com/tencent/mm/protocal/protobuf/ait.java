package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ait
  extends cqk
{
  public FinderContact EDv;
  public String EDw;
  public String EDx;
  public cca entranceInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195047);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EDv != null)
      {
        paramVarArgs.ln(2, this.EDv.computeSize());
        this.EDv.writeFields(paramVarArgs);
      }
      if (this.EDw != null) {
        paramVarArgs.d(3, this.EDw);
      }
      if (this.EDx != null) {
        paramVarArgs.d(4, this.EDx);
      }
      if (this.entranceInfo != null)
      {
        paramVarArgs.ln(5, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EDv != null) {
        paramInt = i + f.a.a.a.lm(2, this.EDv.computeSize());
      }
      i = paramInt;
      if (this.EDw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EDw);
      }
      paramInt = i;
      if (this.EDx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EDx);
      }
      i = paramInt;
      if (this.entranceInfo != null) {
        i = paramInt + f.a.a.a.lm(5, this.entranceInfo.computeSize());
      }
      AppMethodBeat.o(195047);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195047);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ait localait = (ait)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195047);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localait.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195047);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localait.EDv = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195047);
          return 0;
        case 3: 
          localait.EDw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195047);
          return 0;
        case 4: 
          localait.EDx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195047);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cca();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localait.entranceInfo = ((cca)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195047);
        return 0;
      }
      AppMethodBeat.o(195047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ait
 * JD-Core Version:    0.7.0.1
 */