package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class buz
  extends com.tencent.mm.bw.a
{
  public crm DPA;
  public crm FkD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPA == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101828);
        throw paramVarArgs;
      }
      if (this.FkD == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomTopic");
        AppMethodBeat.o(101828);
        throw paramVarArgs;
      }
      if (this.DPA != null)
      {
        paramVarArgs.ln(1, this.DPA.computeSize());
        this.DPA.writeFields(paramVarArgs);
      }
      if (this.FkD != null)
      {
        paramVarArgs.ln(2, this.FkD.computeSize());
        this.FkD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPA == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lm(1, this.DPA.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FkD != null) {
        i = paramInt + f.a.a.a.lm(2, this.FkD.computeSize());
      }
      AppMethodBeat.o(101828);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DPA == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101828);
          throw paramVarArgs;
        }
        if (this.FkD == null)
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
        buz localbuz = (buz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101828);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbuz.DPA = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101828);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbuz.FkD = ((crm)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buz
 * JD-Core Version:    0.7.0.1
 */