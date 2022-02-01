package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cai
  extends com.tencent.mm.bw.a
{
  public cxn FNm;
  public cxn HnM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101828);
        throw paramVarArgs;
      }
      if (this.HnM == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomTopic");
        AppMethodBeat.o(101828);
        throw paramVarArgs;
      }
      if (this.FNm != null)
      {
        paramVarArgs.lJ(1, this.FNm.computeSize());
        this.FNm.writeFields(paramVarArgs);
      }
      if (this.HnM != null)
      {
        paramVarArgs.lJ(2, this.HnM.computeSize());
        this.HnM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNm == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lI(1, this.FNm.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HnM != null) {
        i = paramInt + f.a.a.a.lI(2, this.HnM.computeSize());
      }
      AppMethodBeat.o(101828);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FNm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101828);
          throw paramVarArgs;
        }
        if (this.HnM == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomTopic");
          AppMethodBeat.o(101828);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101828);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cai localcai = (cai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101828);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcai.FNm = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101828);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcai.HnM = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101828);
        return 0;
      }
      AppMethodBeat.o(101828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cai
 * JD-Core Version:    0.7.0.1
 */