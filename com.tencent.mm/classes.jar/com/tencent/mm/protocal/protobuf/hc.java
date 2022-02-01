package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hc
  extends com.tencent.mm.bw.a
{
  public hb FRT;
  public awn FRU;
  public String FRV;
  public String FRW;
  public String FRX;
  public cyk FRY;
  public hj FRZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123544);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRT != null)
      {
        paramVarArgs.lJ(1, this.FRT.computeSize());
        this.FRT.writeFields(paramVarArgs);
      }
      if (this.FRU != null)
      {
        paramVarArgs.lJ(2, this.FRU.computeSize());
        this.FRU.writeFields(paramVarArgs);
      }
      if (this.FRV != null) {
        paramVarArgs.d(3, this.FRV);
      }
      if (this.FRW != null) {
        paramVarArgs.d(4, this.FRW);
      }
      if (this.FRX != null) {
        paramVarArgs.d(5, this.FRX);
      }
      if (this.FRY != null)
      {
        paramVarArgs.lJ(6, this.FRY.computeSize());
        this.FRY.writeFields(paramVarArgs);
      }
      if (this.FRZ != null)
      {
        paramVarArgs.lJ(7, this.FRZ.computeSize());
        this.FRZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FRT == null) {
        break label958;
      }
    }
    label958:
    for (int i = f.a.a.a.lI(1, this.FRT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FRU != null) {
        paramInt = i + f.a.a.a.lI(2, this.FRU.computeSize());
      }
      i = paramInt;
      if (this.FRV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FRV);
      }
      paramInt = i;
      if (this.FRW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FRW);
      }
      i = paramInt;
      if (this.FRX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FRX);
      }
      paramInt = i;
      if (this.FRY != null) {
        paramInt = i + f.a.a.a.lI(6, this.FRY.computeSize());
      }
      i = paramInt;
      if (this.FRZ != null) {
        i = paramInt + f.a.a.a.lI(7, this.FRZ.computeSize());
      }
      AppMethodBeat.o(123544);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        hc localhc = (hc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123544);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhc.FRT = ((hb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhc.FRU = ((awn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 3: 
          localhc.FRV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 4: 
          localhc.FRW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 5: 
          localhc.FRX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localhc.FRY = ((cyk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhc.FRZ = ((hj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      AppMethodBeat.o(123544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hc
 * JD-Core Version:    0.7.0.1
 */