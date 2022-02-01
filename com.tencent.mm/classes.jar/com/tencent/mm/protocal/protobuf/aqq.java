package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqq
  extends com.tencent.mm.bw.a
{
  public FinderObject LCD;
  public int LCE;
  public azm LCF;
  public ayj LCG;
  public int dataType;
  public long id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168953);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      paramVarArgs.bb(2, this.id);
      if (this.LCD != null)
      {
        paramVarArgs.ni(3, this.LCD.computeSize());
        this.LCD.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.LCE);
      if (this.LCF != null)
      {
        paramVarArgs.ni(5, this.LCF.computeSize());
        this.LCF.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.dataType);
      if (this.LCG != null)
      {
        paramVarArgs.ni(7, this.LCG.computeSize());
        this.LCG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.type) + 0 + g.a.a.b.b.a.r(2, this.id);
      paramInt = i;
      if (this.LCD != null) {
        paramInt = i + g.a.a.a.nh(3, this.LCD.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.LCE);
      paramInt = i;
      if (this.LCF != null) {
        paramInt = i + g.a.a.a.nh(5, this.LCF.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.dataType);
      paramInt = i;
      if (this.LCG != null) {
        paramInt = i + g.a.a.a.nh(7, this.LCG.computeSize());
      }
      AppMethodBeat.o(168953);
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
      AppMethodBeat.o(168953);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aqq localaqq = (aqq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168953);
        return -1;
      case 1: 
        localaqq.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168953);
        return 0;
      case 2: 
        localaqq.id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(168953);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaqq.LCD = ((FinderObject)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 4: 
        localaqq.LCE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168953);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new azm();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((azm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaqq.LCF = ((azm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 6: 
        localaqq.dataType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(168953);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ayj();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ayj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localaqq.LCG = ((ayj)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    AppMethodBeat.o(168953);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqq
 * JD-Core Version:    0.7.0.1
 */