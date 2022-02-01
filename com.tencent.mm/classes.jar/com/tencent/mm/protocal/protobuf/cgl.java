package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cgl
  extends com.tencent.mm.bx.a
{
  public zv GWT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GWT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(43118);
        throw paramVarArgs;
      }
      if (this.GWT != null)
      {
        paramVarArgs.lC(1, this.GWT.computeSize());
        this.GWT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43118);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GWT == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.a.lB(1, this.GWT.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43118);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GWT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(43118);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43118);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgl localcgl = (cgl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43118);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((zv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgl.GWT = ((zv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43118);
        return 0;
      }
      AppMethodBeat.o(43118);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgl
 * JD-Core Version:    0.7.0.1
 */