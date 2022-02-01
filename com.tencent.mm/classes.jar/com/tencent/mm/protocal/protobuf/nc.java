package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nc
  extends com.tencent.mm.bw.a
{
  public yi EcP;
  public oa EcQ;
  public na EcR;
  public of EcS;
  public od EcT;
  public lz EcU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EcP != null)
      {
        paramVarArgs.ln(1, this.EcP.computeSize());
        this.EcP.writeFields(paramVarArgs);
      }
      if (this.EcQ != null)
      {
        paramVarArgs.ln(2, this.EcQ.computeSize());
        this.EcQ.writeFields(paramVarArgs);
      }
      if (this.EcR != null)
      {
        paramVarArgs.ln(3, this.EcR.computeSize());
        this.EcR.writeFields(paramVarArgs);
      }
      if (this.EcS != null)
      {
        paramVarArgs.ln(4, this.EcS.computeSize());
        this.EcS.writeFields(paramVarArgs);
      }
      if (this.EcT != null)
      {
        paramVarArgs.ln(5, this.EcT.computeSize());
        this.EcT.writeFields(paramVarArgs);
      }
      if (this.EcU != null)
      {
        paramVarArgs.ln(6, this.EcU.computeSize());
        this.EcU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EcP == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = f.a.a.a.lm(1, this.EcP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EcQ != null) {
        paramInt = i + f.a.a.a.lm(2, this.EcQ.computeSize());
      }
      i = paramInt;
      if (this.EcR != null) {
        i = paramInt + f.a.a.a.lm(3, this.EcR.computeSize());
      }
      paramInt = i;
      if (this.EcS != null) {
        paramInt = i + f.a.a.a.lm(4, this.EcS.computeSize());
      }
      i = paramInt;
      if (this.EcT != null) {
        i = paramInt + f.a.a.a.lm(5, this.EcT.computeSize());
      }
      paramInt = i;
      if (this.EcU != null) {
        paramInt = i + f.a.a.a.lm(6, this.EcU.computeSize());
      }
      AppMethodBeat.o(124434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nc localnc = (nc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124434);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnc.EcP = ((yi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnc.EcQ = ((oa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new na();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((na)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnc.EcR = ((na)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new of();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((of)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnc.EcS = ((of)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new od();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((od)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnc.EcT = ((od)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new lz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((lz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnc.EcU = ((lz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      AppMethodBeat.o(124434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nc
 * JD-Core Version:    0.7.0.1
 */