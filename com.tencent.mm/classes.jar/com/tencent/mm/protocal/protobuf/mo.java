package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mo
  extends com.tencent.mm.bw.a
{
  public tc KQK;
  public tc KQL;
  public tc KQM;
  public SKBuiltinBuffer_t KQN;
  public SKBuiltinBuffer_t KQO;
  public tc KQP;
  public int KQQ;
  public tb KQR;
  public tb KQS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104359);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KQK != null)
      {
        paramVarArgs.ni(1, this.KQK.computeSize());
        this.KQK.writeFields(paramVarArgs);
      }
      if (this.KQL != null)
      {
        paramVarArgs.ni(2, this.KQL.computeSize());
        this.KQL.writeFields(paramVarArgs);
      }
      if (this.KQM != null)
      {
        paramVarArgs.ni(4, this.KQM.computeSize());
        this.KQM.writeFields(paramVarArgs);
      }
      if (this.KQN != null)
      {
        paramVarArgs.ni(5, this.KQN.computeSize());
        this.KQN.writeFields(paramVarArgs);
      }
      if (this.KQO != null)
      {
        paramVarArgs.ni(6, this.KQO.computeSize());
        this.KQO.writeFields(paramVarArgs);
      }
      if (this.KQP != null)
      {
        paramVarArgs.ni(7, this.KQP.computeSize());
        this.KQP.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.KQQ);
      if (this.KQR != null)
      {
        paramVarArgs.ni(9, this.KQR.computeSize());
        this.KQR.writeFields(paramVarArgs);
      }
      if (this.KQS != null)
      {
        paramVarArgs.ni(10, this.KQS.computeSize());
        this.KQS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104359);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KQK == null) {
        break label1446;
      }
    }
    label1446:
    for (int i = g.a.a.a.nh(1, this.KQK.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KQL != null) {
        paramInt = i + g.a.a.a.nh(2, this.KQL.computeSize());
      }
      i = paramInt;
      if (this.KQM != null) {
        i = paramInt + g.a.a.a.nh(4, this.KQM.computeSize());
      }
      paramInt = i;
      if (this.KQN != null) {
        paramInt = i + g.a.a.a.nh(5, this.KQN.computeSize());
      }
      i = paramInt;
      if (this.KQO != null) {
        i = paramInt + g.a.a.a.nh(6, this.KQO.computeSize());
      }
      paramInt = i;
      if (this.KQP != null) {
        paramInt = i + g.a.a.a.nh(7, this.KQP.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.KQQ);
      paramInt = i;
      if (this.KQR != null) {
        paramInt = i + g.a.a.a.nh(9, this.KQR.computeSize());
      }
      i = paramInt;
      if (this.KQS != null) {
        i = paramInt + g.a.a.a.nh(10, this.KQS.computeSize());
      }
      AppMethodBeat.o(104359);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mo localmo = (mo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(104359);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmo.KQK = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmo.KQL = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmo.KQM = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmo.KQN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmo.KQO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmo.KQP = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        case 8: 
          localmo.KQQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104359);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localmo.KQR = ((tb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104359);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localmo.KQS = ((tb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104359);
        return 0;
      }
      AppMethodBeat.o(104359);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mo
 * JD-Core Version:    0.7.0.1
 */