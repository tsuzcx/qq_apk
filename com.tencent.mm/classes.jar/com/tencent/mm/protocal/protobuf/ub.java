package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ub
  extends com.tencent.mm.bw.a
{
  public LinkedList<dul> GkW;
  public b GkX;
  public b GkY;
  
  public ub()
  {
    AppMethodBeat.i(117854);
    this.GkW = new LinkedList();
    AppMethodBeat.o(117854);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GkW);
      if (this.GkX != null) {
        paramVarArgs.c(2, this.GkX);
      }
      if (this.GkY != null) {
        paramVarArgs.c(3, this.GkY);
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.GkW) + 0;
      paramInt = i;
      if (this.GkX != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GkX);
      }
      i = paramInt;
      if (this.GkY != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GkY);
      }
      AppMethodBeat.o(117855);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GkW.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ub localub = (ub)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117855);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dul();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dul)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localub.GkW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117855);
        return 0;
      case 2: 
        localub.GkX = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(117855);
        return 0;
      }
      localub.GkY = ((f.a.a.a.a)localObject1).OmT.gCk();
      AppMethodBeat.o(117855);
      return 0;
    }
    AppMethodBeat.o(117855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ub
 * JD-Core Version:    0.7.0.1
 */