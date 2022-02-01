package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ele
  extends com.tencent.mm.bx.a
{
  public etl YFn;
  public etl ZqL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101829);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFn == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101829);
        throw paramVarArgs;
      }
      if (this.ZqL == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101829);
        throw paramVarArgs;
      }
      if (this.YFn != null)
      {
        paramVarArgs.qD(1, this.YFn.computeSize());
        this.YFn.writeFields(paramVarArgs);
      }
      if (this.ZqL != null)
      {
        paramVarArgs.qD(2, this.ZqL.computeSize());
        this.ZqL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YFn == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.YFn.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZqL != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZqL.computeSize());
      }
      AppMethodBeat.o(101829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YFn == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101829);
          throw paramVarArgs;
        }
        if (this.ZqL == null)
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
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ele localele = (ele)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        etl localetl;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101829);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localetl = new etl();
            if ((localObject != null) && (localObject.length > 0)) {
              localetl.dh((byte[])localObject);
            }
            localele.YFn = localetl;
            paramInt += 1;
          }
          AppMethodBeat.o(101829);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localetl = new etl();
          if ((localObject != null) && (localObject.length > 0)) {
            localetl.dh((byte[])localObject);
          }
          localele.ZqL = localetl;
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ele
 * JD-Core Version:    0.7.0.1
 */