package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cce
  extends com.tencent.mm.bw.a
{
  public int Mia;
  public cch Mib;
  public ccg Mic;
  public ccf Mid;
  public ccd Mie;
  public cci Mif;
  public ccj Mig;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32324);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Mia);
      if (this.Mib != null)
      {
        paramVarArgs.ni(2, this.Mib.computeSize());
        this.Mib.writeFields(paramVarArgs);
      }
      if (this.Mic != null)
      {
        paramVarArgs.ni(3, this.Mic.computeSize());
        this.Mic.writeFields(paramVarArgs);
      }
      if (this.Mid != null)
      {
        paramVarArgs.ni(4, this.Mid.computeSize());
        this.Mid.writeFields(paramVarArgs);
      }
      if (this.Mie != null)
      {
        paramVarArgs.ni(5, this.Mie.computeSize());
        this.Mie.writeFields(paramVarArgs);
      }
      if (this.Mif != null)
      {
        paramVarArgs.ni(6, this.Mif.computeSize());
        this.Mif.writeFields(paramVarArgs);
      }
      if (this.Mig != null)
      {
        paramVarArgs.ni(7, this.Mig.computeSize());
        this.Mig.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Mia) + 0;
      paramInt = i;
      if (this.Mib != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mib.computeSize());
      }
      i = paramInt;
      if (this.Mic != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mic.computeSize());
      }
      paramInt = i;
      if (this.Mid != null) {
        paramInt = i + g.a.a.a.nh(4, this.Mid.computeSize());
      }
      i = paramInt;
      if (this.Mie != null) {
        i = paramInt + g.a.a.a.nh(5, this.Mie.computeSize());
      }
      paramInt = i;
      if (this.Mif != null) {
        paramInt = i + g.a.a.a.nh(6, this.Mif.computeSize());
      }
      i = paramInt;
      if (this.Mig != null) {
        i = paramInt + g.a.a.a.nh(7, this.Mig.computeSize());
      }
      AppMethodBeat.o(32324);
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
      AppMethodBeat.o(32324);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cce localcce = (cce)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32324);
        return -1;
      case 1: 
        localcce.Mia = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32324);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cch();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cch)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcce.Mib = ((cch)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcce.Mic = ((ccg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcce.Mid = ((ccf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcce.Mie = ((ccd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cci();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cci)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcce.Mif = ((cci)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ccj();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ccj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localcce.Mig = ((ccj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    AppMethodBeat.o(32324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cce
 * JD-Core Version:    0.7.0.1
 */