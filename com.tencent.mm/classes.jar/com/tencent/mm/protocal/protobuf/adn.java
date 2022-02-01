package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class adn
  extends com.tencent.mm.bw.a
{
  public cxn GuK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101806);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuK == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101806);
        throw paramVarArgs;
      }
      if (this.GuK != null)
      {
        paramVarArgs.lJ(1, this.GuK.computeSize());
        this.GuK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuK == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.a.lI(1, this.GuK.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(101806);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuK == null)
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
        adn localadn = (adn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101806);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localadn.GuK = ((cxn)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adn
 * JD-Core Version:    0.7.0.1
 */