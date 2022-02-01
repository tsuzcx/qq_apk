package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ahm
  extends com.tencent.mm.bw.a
{
  public int Lrk;
  public ahn Lrl;
  public int Lrm;
  public ahn Lrn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43094);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.Lrn == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Lrk);
      if (this.Lrl != null)
      {
        paramVarArgs.ni(2, this.Lrl.computeSize());
        this.Lrl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.Lrm);
      if (this.Lrn != null)
      {
        paramVarArgs.ni(4, this.Lrn.computeSize());
        this.Lrn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Lrk) + 0;
      paramInt = i;
      if (this.Lrl != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lrl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Lrm);
      paramInt = i;
      if (this.Lrn != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lrn.computeSize());
      }
      AppMethodBeat.o(43094);
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
      if (this.Lrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.Lrn == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ahm localahm = (ahm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43094);
        return -1;
      case 1: 
        localahm.Lrk = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43094);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localahm.Lrl = ((ahn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43094);
        return 0;
      case 3: 
        localahm.Lrm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(43094);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ahn();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ahn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localahm.Lrn = ((ahn)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    AppMethodBeat.o(43094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahm
 * JD-Core Version:    0.7.0.1
 */