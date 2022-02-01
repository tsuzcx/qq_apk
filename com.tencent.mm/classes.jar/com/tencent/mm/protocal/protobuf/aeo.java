package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aeo
  extends com.tencent.mm.bw.a
{
  public cmv LpQ;
  public dlh LpR;
  public dlh LpS;
  public dlh LpT;
  public dlh LpU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201293);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LpQ != null)
      {
        paramVarArgs.ni(1, this.LpQ.computeSize());
        this.LpQ.writeFields(paramVarArgs);
      }
      if (this.LpR != null)
      {
        paramVarArgs.ni(2, this.LpR.computeSize());
        this.LpR.writeFields(paramVarArgs);
      }
      if (this.LpS != null)
      {
        paramVarArgs.ni(3, this.LpS.computeSize());
        this.LpS.writeFields(paramVarArgs);
      }
      if (this.LpT != null)
      {
        paramVarArgs.ni(4, this.LpT.computeSize());
        this.LpT.writeFields(paramVarArgs);
      }
      if (this.LpU != null)
      {
        paramVarArgs.ni(5, this.LpU.computeSize());
        this.LpU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(201293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LpQ == null) {
        break label926;
      }
    }
    label926:
    for (int i = g.a.a.a.nh(1, this.LpQ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LpR != null) {
        paramInt = i + g.a.a.a.nh(2, this.LpR.computeSize());
      }
      i = paramInt;
      if (this.LpS != null) {
        i = paramInt + g.a.a.a.nh(3, this.LpS.computeSize());
      }
      paramInt = i;
      if (this.LpT != null) {
        paramInt = i + g.a.a.a.nh(4, this.LpT.computeSize());
      }
      i = paramInt;
      if (this.LpU != null) {
        i = paramInt + g.a.a.a.nh(5, this.LpU.computeSize());
      }
      AppMethodBeat.o(201293);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(201293);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aeo localaeo = (aeo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201293);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaeo.LpQ = ((cmv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201293);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaeo.LpR = ((dlh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201293);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaeo.LpS = ((dlh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201293);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaeo.LpT = ((dlh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201293);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaeo.LpU = ((dlh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201293);
        return 0;
      }
      AppMethodBeat.o(201293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeo
 * JD-Core Version:    0.7.0.1
 */