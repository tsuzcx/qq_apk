package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cpm
  extends com.tencent.mm.bv.a
{
  public String Username;
  public bmx xYw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113793);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xYw == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(113793);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.xYw != null)
      {
        paramVarArgs.iQ(2, this.xYw.computeSize());
        this.xYw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = e.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xYw != null) {
        i = paramInt + e.a.a.a.iP(2, this.xYw.computeSize());
      }
      AppMethodBeat.o(113793);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xYw == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(113793);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cpm localcpm = (cpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113793);
          return -1;
        case 1: 
          localcpm.Username = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(113793);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmx();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcpm.xYw = ((bmx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113793);
        return 0;
      }
      AppMethodBeat.o(113793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpm
 * JD-Core Version:    0.7.0.1
 */