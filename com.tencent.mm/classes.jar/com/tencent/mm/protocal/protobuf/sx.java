package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sx
  extends com.tencent.mm.bw.a
{
  public LinkedList<ccu> FPC;
  public int dms;
  
  public sx()
  {
    AppMethodBeat.i(188948);
    this.FPC = new LinkedList();
    AppMethodBeat.o(188948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FPC);
      paramVarArgs.aS(2, this.dms);
      AppMethodBeat.o(188949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.FPC);
      i = f.a.a.b.b.a.bz(2, this.dms);
      AppMethodBeat.o(188949);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FPC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(188949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      sx localsx = (sx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(188949);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ccu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsx.FPC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(188949);
        return 0;
      }
      localsx.dms = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(188949);
      return 0;
    }
    AppMethodBeat.o(188949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sx
 * JD-Core Version:    0.7.0.1
 */