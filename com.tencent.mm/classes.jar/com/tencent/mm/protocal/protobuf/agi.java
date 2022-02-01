package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agi
  extends com.tencent.mm.bx.a
{
  public etg YCV;
  public adv YZb;
  public esi ZpB;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91426);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.ZpB != null)
      {
        paramVarArgs.qD(2, this.ZpB.computeSize());
        this.ZpB.writeFields(paramVarArgs);
      }
      if (this.YCV != null)
      {
        paramVarArgs.qD(3, this.YCV.computeSize());
        this.YCV.writeFields(paramVarArgs);
      }
      if (this.YZb != null)
      {
        paramVarArgs.qD(4, this.YZb.computeSize());
        this.YZb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.ZpB != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZpB.computeSize());
      }
      i = paramInt;
      if (this.YCV != null) {
        i = paramInt + i.a.a.a.qC(3, this.YCV.computeSize());
      }
      paramInt = i;
      if (this.YZb != null) {
        paramInt = i + i.a.a.a.qC(4, this.YZb.computeSize());
      }
      AppMethodBeat.o(91426);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      agi localagi = (agi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91426);
        return -1;
      case 1: 
        localagi.type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91426);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new esi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((esi)localObject2).parseFrom((byte[])localObject1);
          }
          localagi.ZpB = ((esi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etg)localObject2).parseFrom((byte[])localObject1);
          }
          localagi.YCV = ((etg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new adv();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((adv)localObject2).parseFrom((byte[])localObject1);
        }
        localagi.YZb = ((adv)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    AppMethodBeat.o(91426);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agi
 * JD-Core Version:    0.7.0.1
 */