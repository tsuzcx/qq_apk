package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sb
  extends com.tencent.mm.bw.a
{
  public rt KZG;
  public rs KZH;
  public long KZI;
  public rz KZJ;
  public sd KZK;
  public ry KZL;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117850);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oUv);
      if (this.KZG != null)
      {
        paramVarArgs.ni(2, this.KZG.computeSize());
        this.KZG.writeFields(paramVarArgs);
      }
      if (this.KZH != null)
      {
        paramVarArgs.ni(3, this.KZH.computeSize());
        this.KZH.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(4, this.KZI);
      if (this.KZJ != null)
      {
        paramVarArgs.ni(5, this.KZJ.computeSize());
        this.KZJ.writeFields(paramVarArgs);
      }
      if (this.KZK != null)
      {
        paramVarArgs.ni(6, this.KZK.computeSize());
        this.KZK.writeFields(paramVarArgs);
      }
      if (this.KZL != null)
      {
        paramVarArgs.ni(7, this.KZL.computeSize());
        this.KZL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.oUv) + 0;
      paramInt = i;
      if (this.KZG != null) {
        paramInt = i + g.a.a.a.nh(2, this.KZG.computeSize());
      }
      i = paramInt;
      if (this.KZH != null) {
        i = paramInt + g.a.a.a.nh(3, this.KZH.computeSize());
      }
      i += g.a.a.b.b.a.r(4, this.KZI);
      paramInt = i;
      if (this.KZJ != null) {
        paramInt = i + g.a.a.a.nh(5, this.KZJ.computeSize());
      }
      i = paramInt;
      if (this.KZK != null) {
        i = paramInt + g.a.a.a.nh(6, this.KZK.computeSize());
      }
      paramInt = i;
      if (this.KZL != null) {
        paramInt = i + g.a.a.a.nh(7, this.KZL.computeSize());
      }
      AppMethodBeat.o(117850);
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
      AppMethodBeat.o(117850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      sb localsb = (sb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117850);
        return -1;
      case 1: 
        localsb.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117850);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsb.KZG = ((rt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rs();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsb.KZH = ((rs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 4: 
        localsb.KZI = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117850);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsb.KZJ = ((rz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sd();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsb.KZK = ((sd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ry();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ry)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localsb.KZL = ((ry)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    AppMethodBeat.o(117850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sb
 * JD-Core Version:    0.7.0.1
 */