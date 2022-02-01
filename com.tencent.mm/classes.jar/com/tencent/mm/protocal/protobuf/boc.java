package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class boc
  extends com.tencent.mm.bw.a
{
  public cat KOZ;
  public int LWr;
  public int LWs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82410);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KOZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.LWr);
      paramVarArgs.aM(2, this.LWs);
      if (this.KOZ != null)
      {
        paramVarArgs.ni(3, this.KOZ.computeSize());
        this.KOZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LWr) + 0 + g.a.a.b.b.a.bu(2, this.LWs);
      paramInt = i;
      if (this.KOZ != null) {
        paramInt = i + g.a.a.a.nh(3, this.KOZ.computeSize());
      }
      AppMethodBeat.o(82410);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KOZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      boc localboc = (boc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82410);
        return -1;
      case 1: 
        localboc.LWr = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(82410);
        return 0;
      case 2: 
        localboc.LWs = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(82410);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cat();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localboc.KOZ = ((cat)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    AppMethodBeat.o(82410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boc
 * JD-Core Version:    0.7.0.1
 */