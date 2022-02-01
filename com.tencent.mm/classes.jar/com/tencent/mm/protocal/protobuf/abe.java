package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abe
  extends com.tencent.mm.bw.a
{
  public crm EuJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101806);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EuJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101806);
        throw paramVarArgs;
      }
      if (this.EuJ != null)
      {
        paramVarArgs.ln(1, this.EuJ.computeSize());
        this.EuJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EuJ == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.a.lm(1, this.EuJ.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(101806);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EuJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101806);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abe localabe = (abe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101806);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabe.EuJ = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101806);
        return 0;
      }
      AppMethodBeat.o(101806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abe
 * JD-Core Version:    0.7.0.1
 */