package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ard
  extends com.tencent.mm.bw.a
{
  public LinkedList<FinderObject> LCW;
  public int gAZ;
  public int tQR;
  public String username;
  
  public ard()
  {
    AppMethodBeat.i(209389);
    this.LCW = new LinkedList();
    AppMethodBeat.o(209389);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209390);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.tQR);
      paramVarArgs.e(2, 8, this.LCW);
      if (this.username != null) {
        paramVarArgs.e(3, this.username);
      }
      paramVarArgs.aM(4, this.gAZ);
      AppMethodBeat.o(209390);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.tQR) + 0 + g.a.a.a.c(2, 8, this.LCW);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.username);
      }
      i = g.a.a.b.b.a.bu(4, this.gAZ);
      AppMethodBeat.o(209390);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LCW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209390);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ard localard = (ard)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209390);
        return -1;
      case 1: 
        localard.tQR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209390);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localard.LCW.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209390);
        return 0;
      case 3: 
        localard.username = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209390);
        return 0;
      }
      localard.gAZ = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(209390);
      return 0;
    }
    AppMethodBeat.o(209390);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ard
 * JD-Core Version:    0.7.0.1
 */