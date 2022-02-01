package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoo
  extends dpc
{
  public FinderContact LAJ;
  public String LAK;
  public cxs entranceInfo;
  public String nbg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209329);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LAJ != null)
      {
        paramVarArgs.ni(2, this.LAJ.computeSize());
        this.LAJ.writeFields(paramVarArgs);
      }
      if (this.nbg != null) {
        paramVarArgs.e(3, this.nbg);
      }
      if (this.LAK != null) {
        paramVarArgs.e(4, this.LAK);
      }
      if (this.entranceInfo != null)
      {
        paramVarArgs.ni(5, this.entranceInfo.computeSize());
        this.entranceInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209329);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LAJ != null) {
        paramInt = i + g.a.a.a.nh(2, this.LAJ.computeSize());
      }
      i = paramInt;
      if (this.nbg != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.nbg);
      }
      paramInt = i;
      if (this.LAK != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LAK);
      }
      i = paramInt;
      if (this.entranceInfo != null) {
        i = paramInt + g.a.a.a.nh(5, this.entranceInfo.computeSize());
      }
      AppMethodBeat.o(209329);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209329);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aoo localaoo = (aoo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209329);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaoo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209329);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaoo.LAJ = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209329);
          return 0;
        case 3: 
          localaoo.nbg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209329);
          return 0;
        case 4: 
          localaoo.LAK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209329);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxs();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaoo.entranceInfo = ((cxs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209329);
        return 0;
      }
      AppMethodBeat.o(209329);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoo
 * JD-Core Version:    0.7.0.1
 */