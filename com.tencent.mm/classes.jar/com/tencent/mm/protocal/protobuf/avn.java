package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avn
  extends com.tencent.mm.bv.a
{
  public int xkS;
  public avq xkT;
  public avp xkU;
  public avo xkV;
  public avm xkW;
  public avr xkX;
  public avs xkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28524);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xkS);
      if (this.xkT != null)
      {
        paramVarArgs.iQ(2, this.xkT.computeSize());
        this.xkT.writeFields(paramVarArgs);
      }
      if (this.xkU != null)
      {
        paramVarArgs.iQ(3, this.xkU.computeSize());
        this.xkU.writeFields(paramVarArgs);
      }
      if (this.xkV != null)
      {
        paramVarArgs.iQ(4, this.xkV.computeSize());
        this.xkV.writeFields(paramVarArgs);
      }
      if (this.xkW != null)
      {
        paramVarArgs.iQ(5, this.xkW.computeSize());
        this.xkW.writeFields(paramVarArgs);
      }
      if (this.xkX != null)
      {
        paramVarArgs.iQ(6, this.xkX.computeSize());
        this.xkX.writeFields(paramVarArgs);
      }
      if (this.xkY != null)
      {
        paramVarArgs.iQ(7, this.xkY.computeSize());
        this.xkY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(28524);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xkS) + 0;
      paramInt = i;
      if (this.xkT != null) {
        paramInt = i + e.a.a.a.iP(2, this.xkT.computeSize());
      }
      i = paramInt;
      if (this.xkU != null) {
        i = paramInt + e.a.a.a.iP(3, this.xkU.computeSize());
      }
      paramInt = i;
      if (this.xkV != null) {
        paramInt = i + e.a.a.a.iP(4, this.xkV.computeSize());
      }
      i = paramInt;
      if (this.xkW != null) {
        i = paramInt + e.a.a.a.iP(5, this.xkW.computeSize());
      }
      paramInt = i;
      if (this.xkX != null) {
        paramInt = i + e.a.a.a.iP(6, this.xkX.computeSize());
      }
      i = paramInt;
      if (this.xkY != null) {
        i = paramInt + e.a.a.a.iP(7, this.xkY.computeSize());
      }
      AppMethodBeat.o(28524);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28524);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      avn localavn = (avn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28524);
        return -1;
      case 1: 
        localavn.xkS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28524);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avq();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localavn.xkT = ((avq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28524);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avp();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localavn.xkU = ((avp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28524);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localavn.xkV = ((avo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28524);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avm();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localavn.xkW = ((avm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28524);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avr();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localavn.xkX = ((avr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28524);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new avs();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((avs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localavn.xkY = ((avs)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(28524);
      return 0;
    }
    AppMethodBeat.o(28524);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avn
 * JD-Core Version:    0.7.0.1
 */