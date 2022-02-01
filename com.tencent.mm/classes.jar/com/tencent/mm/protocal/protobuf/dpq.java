package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpq
  extends com.tencent.mm.bw.a
{
  public dqe KEP;
  public String KNW;
  public ehf Lov;
  public int MSP;
  public int MSQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91674);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MSP);
      paramVarArgs.aM(2, this.MSQ);
      if (this.KEP != null)
      {
        paramVarArgs.ni(3, this.KEP.computeSize());
        this.KEP.writeFields(paramVarArgs);
      }
      if (this.Lov != null)
      {
        paramVarArgs.ni(4, this.Lov.computeSize());
        this.Lov.writeFields(paramVarArgs);
      }
      if (this.KNW != null) {
        paramVarArgs.e(5, this.KNW);
      }
      AppMethodBeat.o(91674);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MSP) + 0 + g.a.a.b.b.a.bu(2, this.MSQ);
      paramInt = i;
      if (this.KEP != null) {
        paramInt = i + g.a.a.a.nh(3, this.KEP.computeSize());
      }
      i = paramInt;
      if (this.Lov != null) {
        i = paramInt + g.a.a.a.nh(4, this.Lov.computeSize());
      }
      paramInt = i;
      if (this.KNW != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KNW);
      }
      AppMethodBeat.o(91674);
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
      AppMethodBeat.o(91674);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dpq localdpq = (dpq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91674);
        return -1;
      case 1: 
        localdpq.MSP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91674);
        return 0;
      case 2: 
        localdpq.MSQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91674);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdpq.KEP = ((dqe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdpq.Lov = ((ehf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      }
      localdpq.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91674);
      return 0;
    }
    AppMethodBeat.o(91674);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpq
 * JD-Core Version:    0.7.0.1
 */