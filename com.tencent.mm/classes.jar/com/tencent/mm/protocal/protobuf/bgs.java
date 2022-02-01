package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgs
  extends com.tencent.mm.bx.a
{
  public int DEC;
  public bgv DED;
  public bgu DEE;
  public bgt DEF;
  public bgr DEG;
  public bgw DEH;
  public bgx DEI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32324);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DEC);
      if (this.DED != null)
      {
        paramVarArgs.kX(2, this.DED.computeSize());
        this.DED.writeFields(paramVarArgs);
      }
      if (this.DEE != null)
      {
        paramVarArgs.kX(3, this.DEE.computeSize());
        this.DEE.writeFields(paramVarArgs);
      }
      if (this.DEF != null)
      {
        paramVarArgs.kX(4, this.DEF.computeSize());
        this.DEF.writeFields(paramVarArgs);
      }
      if (this.DEG != null)
      {
        paramVarArgs.kX(5, this.DEG.computeSize());
        this.DEG.writeFields(paramVarArgs);
      }
      if (this.DEH != null)
      {
        paramVarArgs.kX(6, this.DEH.computeSize());
        this.DEH.writeFields(paramVarArgs);
      }
      if (this.DEI != null)
      {
        paramVarArgs.kX(7, this.DEI.computeSize());
        this.DEI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DEC) + 0;
      paramInt = i;
      if (this.DED != null) {
        paramInt = i + f.a.a.a.kW(2, this.DED.computeSize());
      }
      i = paramInt;
      if (this.DEE != null) {
        i = paramInt + f.a.a.a.kW(3, this.DEE.computeSize());
      }
      paramInt = i;
      if (this.DEF != null) {
        paramInt = i + f.a.a.a.kW(4, this.DEF.computeSize());
      }
      i = paramInt;
      if (this.DEG != null) {
        i = paramInt + f.a.a.a.kW(5, this.DEG.computeSize());
      }
      paramInt = i;
      if (this.DEH != null) {
        paramInt = i + f.a.a.a.kW(6, this.DEH.computeSize());
      }
      i = paramInt;
      if (this.DEI != null) {
        i = paramInt + f.a.a.a.kW(7, this.DEI.computeSize());
      }
      AppMethodBeat.o(32324);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bgs localbgs = (bgs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32324);
        return -1;
      case 1: 
        localbgs.DEC = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32324);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgs.DED = ((bgv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgs.DEE = ((bgu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgs.DEF = ((bgt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgs.DEG = ((bgr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbgs.DEH = ((bgw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bgx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bgx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbgs.DEI = ((bgx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    AppMethodBeat.o(32324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgs
 * JD-Core Version:    0.7.0.1
 */