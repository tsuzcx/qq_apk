package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhl
  extends com.tencent.mm.bw.a
{
  public int LRW;
  public LinkedList<akc> LRX;
  public int LRY;
  public int cSx;
  
  public bhl()
  {
    AppMethodBeat.i(153145);
    this.LRX = new LinkedList();
    AppMethodBeat.o(153145);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153146);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LRW);
      paramVarArgs.e(2, 8, this.LRX);
      paramVarArgs.aM(3, this.LRY);
      paramVarArgs.aM(4, this.cSx);
      AppMethodBeat.o(153146);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.LRW);
      i = g.a.a.a.c(2, 8, this.LRX);
      int j = g.a.a.b.b.a.bu(3, this.LRY);
      int k = g.a.a.b.b.a.bu(4, this.cSx);
      AppMethodBeat.o(153146);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LRX.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153146);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bhl localbhl = (bhl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153146);
        return -1;
      case 1: 
        localbhl.LRW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153146);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((akc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbhl.LRX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153146);
        return 0;
      case 3: 
        localbhl.LRY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153146);
        return 0;
      }
      localbhl.cSx = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(153146);
      return 0;
    }
    AppMethodBeat.o(153146);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhl
 * JD-Core Version:    0.7.0.1
 */