package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzo
  extends com.tencent.mm.bx.a
{
  public cwt FuO;
  public cwt GUl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101828);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuO == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101828);
        throw paramVarArgs;
      }
      if (this.GUl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomTopic");
        AppMethodBeat.o(101828);
        throw paramVarArgs;
      }
      if (this.FuO != null)
      {
        paramVarArgs.lC(1, this.FuO.computeSize());
        this.FuO.writeFields(paramVarArgs);
      }
      if (this.GUl != null)
      {
        paramVarArgs.lC(2, this.GUl.computeSize());
        this.GUl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FuO == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lB(1, this.FuO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GUl != null) {
        i = paramInt + f.a.a.a.lB(2, this.GUl.computeSize());
      }
      AppMethodBeat.o(101828);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FuO == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101828);
          throw paramVarArgs;
        }
        if (this.GUl == null)
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
        bzo localbzo = (bzo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101828);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzo.FuO = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101828);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzo.GUl = ((cwt)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzo
 * JD-Core Version:    0.7.0.1
 */