package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doi
  extends com.tencent.mm.bx.a
{
  public LinkedList<doe> EED;
  public String EEl;
  
  public doi()
  {
    AppMethodBeat.i(147803);
    this.EED = new LinkedList();
    AppMethodBeat.o(147803);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EEl != null) {
        paramVarArgs.d(1, this.EEl);
      }
      paramVarArgs.e(2, 8, this.EED);
      AppMethodBeat.o(147804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EEl == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.EEl) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.EED);
      AppMethodBeat.o(147804);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EED.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        doi localdoi = (doi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147804);
          return -1;
        case 1: 
          localdoi.EEl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147804);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((doe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdoi.EED.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(147804);
        return 0;
      }
      AppMethodBeat.o(147804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doi
 * JD-Core Version:    0.7.0.1
 */