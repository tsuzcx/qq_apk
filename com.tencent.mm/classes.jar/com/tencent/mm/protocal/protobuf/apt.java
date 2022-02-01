package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apt
  extends com.tencent.mm.bw.a
{
  public FinderContact contact;
  public boolean dsB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189376);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.contact != null)
      {
        paramVarArgs.lJ(1, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.dsB);
      AppMethodBeat.o(189376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.contact == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.a.lI(1, this.contact.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amF(2);
      AppMethodBeat.o(189376);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apt localapt = (apt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189376);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localapt.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189376);
          return 0;
        }
        localapt.dsB = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(189376);
        return 0;
      }
      AppMethodBeat.o(189376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apt
 * JD-Core Version:    0.7.0.1
 */