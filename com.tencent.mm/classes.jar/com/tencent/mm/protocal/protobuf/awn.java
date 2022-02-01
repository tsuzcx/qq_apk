package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awn
  extends com.tencent.mm.bw.a
{
  public String KDS;
  public int LFG;
  public avn LHl;
  public avn LHm;
  public axd LHn;
  public LinkedList<awm> LHo;
  public int status;
  
  public awn()
  {
    AppMethodBeat.i(209537);
    this.LHo = new LinkedList();
    AppMethodBeat.o(209537);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209538);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KDS != null) {
        paramVarArgs.e(1, this.KDS);
      }
      paramVarArgs.aM(2, this.LFG);
      if (this.LHl != null)
      {
        paramVarArgs.ni(3, this.LHl.computeSize());
        this.LHl.writeFields(paramVarArgs);
      }
      if (this.LHm != null)
      {
        paramVarArgs.ni(4, this.LHm.computeSize());
        this.LHm.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.status);
      if (this.LHn != null)
      {
        paramVarArgs.ni(6, this.LHn.computeSize());
        this.LHn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.LHo);
      AppMethodBeat.o(209538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KDS == null) {
        break label910;
      }
    }
    label910:
    for (paramInt = g.a.a.b.b.a.f(1, this.KDS) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LFG);
      paramInt = i;
      if (this.LHl != null) {
        paramInt = i + g.a.a.a.nh(3, this.LHl.computeSize());
      }
      i = paramInt;
      if (this.LHm != null) {
        i = paramInt + g.a.a.a.nh(4, this.LHm.computeSize());
      }
      i += g.a.a.b.b.a.bu(5, this.status);
      paramInt = i;
      if (this.LHn != null) {
        paramInt = i + g.a.a.a.nh(6, this.LHn.computeSize());
      }
      i = g.a.a.a.c(7, 8, this.LHo);
      AppMethodBeat.o(209538);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LHo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awn localawn = (awn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209538);
          return -1;
        case 1: 
          localawn.KDS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209538);
          return 0;
        case 2: 
          localawn.LFG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209538);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localawn.LHl = ((avn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209538);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localawn.LHm = ((avn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209538);
          return 0;
        case 5: 
          localawn.status = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209538);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localawn.LHn = ((axd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209538);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localawn.LHo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209538);
        return 0;
      }
      AppMethodBeat.o(209538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awn
 * JD-Core Version:    0.7.0.1
 */