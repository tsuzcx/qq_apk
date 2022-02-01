package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apn
  extends com.tencent.mm.bw.a
{
  public String LAt;
  public awt LBv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209354);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LAt != null) {
        paramVarArgs.e(1, this.LAt);
      }
      if (this.LBv != null)
      {
        paramVarArgs.ni(2, this.LBv.computeSize());
        this.LBv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209354);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LAt == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.LAt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LBv != null) {
        i = paramInt + g.a.a.a.nh(2, this.LBv.computeSize());
      }
      AppMethodBeat.o(209354);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209354);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        apn localapn = (apn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209354);
          return -1;
        case 1: 
          localapn.LAt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209354);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((awt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localapn.LBv = ((awt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209354);
        return 0;
      }
      AppMethodBeat.o(209354);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apn
 * JD-Core Version:    0.7.0.1
 */