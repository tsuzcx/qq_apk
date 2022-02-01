package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arp
  extends com.tencent.mm.bw.a
{
  public String GIi;
  public LinkedList<aso> GIl;
  
  public arp()
  {
    AppMethodBeat.i(189399);
    this.GIl = new LinkedList();
    AppMethodBeat.o(189399);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189400);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GIi != null) {
        paramVarArgs.d(1, this.GIi);
      }
      paramVarArgs.e(2, 8, this.GIl);
      AppMethodBeat.o(189400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GIi == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.GIi) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.GIl);
      AppMethodBeat.o(189400);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GIl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arp localarp = (arp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189400);
          return -1;
        case 1: 
          localarp.GIi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189400);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aso();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aso)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarp.GIl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189400);
        return 0;
      }
      AppMethodBeat.o(189400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arp
 * JD-Core Version:    0.7.0.1
 */