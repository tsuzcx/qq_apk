package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eak
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b EaW;
  public LinkedList<eah> EaX;
  public String Fed;
  
  public eak()
  {
    AppMethodBeat.i(123701);
    this.EaX = new LinkedList();
    AppMethodBeat.o(123701);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123702);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fed == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: WxaUserName");
        AppMethodBeat.o(123702);
        throw paramVarArgs;
      }
      if (this.Fed != null) {
        paramVarArgs.d(1, this.Fed);
      }
      if (this.EaW != null) {
        paramVarArgs.c(2, this.EaW);
      }
      paramVarArgs.e(3, 8, this.EaX);
      AppMethodBeat.o(123702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fed == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fed) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EaW != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.EaW);
      }
      paramInt = f.a.a.a.c(3, 8, this.EaX);
      AppMethodBeat.o(123702);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EaX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Fed == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: WxaUserName");
          AppMethodBeat.o(123702);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eak localeak = (eak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123702);
          return -1;
        case 1: 
          localeak.Fed = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123702);
          return 0;
        case 2: 
          localeak.EaW = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(123702);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eah();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eah)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeak.EaX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123702);
        return 0;
      }
      AppMethodBeat.o(123702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eak
 * JD-Core Version:    0.7.0.1
 */