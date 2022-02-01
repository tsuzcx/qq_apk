package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cfv
  extends com.tencent.mm.bx.a
{
  public cmf Cxe;
  public cmf Dby;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101829);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxe == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101829);
        throw paramVarArgs;
      }
      if (this.Dby == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101829);
        throw paramVarArgs;
      }
      if (this.Cxe != null)
      {
        paramVarArgs.kX(1, this.Cxe.computeSize());
        this.Cxe.writeFields(paramVarArgs);
      }
      if (this.Dby != null)
      {
        paramVarArgs.kX(2, this.Dby.computeSize());
        this.Dby.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cxe == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.kW(1, this.Cxe.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dby != null) {
        i = paramInt + f.a.a.a.kW(2, this.Dby.computeSize());
      }
      AppMethodBeat.o(101829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Cxe == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101829);
          throw paramVarArgs;
        }
        if (this.Dby == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(101829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101829);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfv localcfv = (cfv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101829);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfv.Cxe = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101829);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcfv.Dby = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101829);
        return 0;
      }
      AppMethodBeat.o(101829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfv
 * JD-Core Version:    0.7.0.1
 */