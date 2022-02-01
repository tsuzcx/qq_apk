package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ail
  extends com.tencent.mm.bx.a
{
  public etl ZqQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101805);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZqQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101805);
        throw paramVarArgs;
      }
      if (this.ZqQ != null)
      {
        paramVarArgs.qD(1, this.ZqQ.computeSize());
        this.ZqQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZqQ == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.a.qC(1, this.ZqQ.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(101805);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZqQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101805);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101805);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ail localail = (ail)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101805);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          etl localetl = new etl();
          if ((localObject != null) && (localObject.length > 0)) {
            localetl.dh((byte[])localObject);
          }
          localail.ZqQ = localetl;
          paramInt += 1;
        }
        AppMethodBeat.o(101805);
        return 0;
      }
      AppMethodBeat.o(101805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ail
 * JD-Core Version:    0.7.0.1
 */