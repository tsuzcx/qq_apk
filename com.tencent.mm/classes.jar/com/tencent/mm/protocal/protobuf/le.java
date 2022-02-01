package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class le
  extends com.tencent.mm.bw.a
{
  public String KOS;
  public String KOX;
  public cpl KOY;
  public cat KOZ;
  public int Ret;
  public String oTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82393);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ret);
      if (this.KOX != null) {
        paramVarArgs.e(2, this.KOX);
      }
      if (this.KOY != null)
      {
        paramVarArgs.ni(3, this.KOY.computeSize());
        this.KOY.writeFields(paramVarArgs);
      }
      if (this.KOS != null) {
        paramVarArgs.e(4, this.KOS);
      }
      if (this.oTI != null) {
        paramVarArgs.e(5, this.oTI);
      }
      if (this.KOZ != null)
      {
        paramVarArgs.ni(6, this.KOZ.computeSize());
        this.KOZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0;
      paramInt = i;
      if (this.KOX != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KOX);
      }
      i = paramInt;
      if (this.KOY != null) {
        i = paramInt + g.a.a.a.nh(3, this.KOY.computeSize());
      }
      paramInt = i;
      if (this.KOS != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KOS);
      }
      i = paramInt;
      if (this.oTI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.oTI);
      }
      paramInt = i;
      if (this.KOZ != null) {
        paramInt = i + g.a.a.a.nh(6, this.KOZ.computeSize());
      }
      AppMethodBeat.o(82393);
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
      AppMethodBeat.o(82393);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      le localle = (le)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82393);
        return -1;
      case 1: 
        localle.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(82393);
        return 0;
      case 2: 
        localle.KOX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cpl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cpl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localle.KOY = ((cpl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82393);
        return 0;
      case 4: 
        localle.KOS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82393);
        return 0;
      case 5: 
        localle.oTI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82393);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cat();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localle.KOZ = ((cat)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(82393);
      return 0;
    }
    AppMethodBeat.o(82393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.le
 * JD-Core Version:    0.7.0.1
 */