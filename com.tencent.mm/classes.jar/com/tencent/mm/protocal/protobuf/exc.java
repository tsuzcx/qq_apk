package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class exc
  extends com.tencent.mm.bw.a
{
  public String Name;
  public exg NuA;
  public int Nuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200236);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Nuz);
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.NuA != null)
      {
        paramVarArgs.ni(3, this.NuA.computeSize());
        this.NuA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200236);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Nuz) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.NuA != null) {
        i = paramInt + g.a.a.a.nh(3, this.NuA.computeSize());
      }
      AppMethodBeat.o(200236);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(200236);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      exc localexc = (exc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(200236);
        return -1;
      case 1: 
        localexc.Nuz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(200236);
        return 0;
      case 2: 
        localexc.Name = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(200236);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new exg();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((exg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localexc.NuA = ((exg)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(200236);
      return 0;
    }
    AppMethodBeat.o(200236);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exc
 * JD-Core Version:    0.7.0.1
 */