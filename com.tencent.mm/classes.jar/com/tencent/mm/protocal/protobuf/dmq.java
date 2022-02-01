package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmq
  extends com.tencent.mm.bw.a
{
  public long HDI;
  public dml HTQ;
  public LinkedList<String> HTR;
  public aiq HTS;
  public int HTT;
  public csm HTU;
  public String HTV;
  public String dmp;
  public long lastUpdateTime;
  public int pos;
  public int style;
  public int weight;
  
  public dmq()
  {
    AppMethodBeat.i(124563);
    this.HTR = new LinkedList();
    AppMethodBeat.o(124563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HTQ != null)
      {
        paramVarArgs.lJ(1, this.HTQ.computeSize());
        this.HTQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.lastUpdateTime);
      paramVarArgs.aS(3, this.pos);
      paramVarArgs.aS(4, this.weight);
      paramVarArgs.aZ(5, this.HDI);
      paramVarArgs.e(6, 1, this.HTR);
      paramVarArgs.aS(7, this.style);
      if (this.dmp != null) {
        paramVarArgs.d(8, this.dmp);
      }
      if (this.HTS != null)
      {
        paramVarArgs.lJ(9, this.HTS.computeSize());
        this.HTS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.HTT);
      if (this.HTU != null)
      {
        paramVarArgs.lJ(11, this.HTU.computeSize());
        this.HTU.writeFields(paramVarArgs);
      }
      if (this.HTV != null) {
        paramVarArgs.d(12, this.HTV);
      }
      AppMethodBeat.o(124564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HTQ == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.a.lI(1, this.HTQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.lastUpdateTime) + f.a.a.b.b.a.bz(3, this.pos) + f.a.a.b.b.a.bz(4, this.weight) + f.a.a.b.b.a.p(5, this.HDI) + f.a.a.a.c(6, 1, this.HTR) + f.a.a.b.b.a.bz(7, this.style);
      paramInt = i;
      if (this.dmp != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dmp);
      }
      i = paramInt;
      if (this.HTS != null) {
        i = paramInt + f.a.a.a.lI(9, this.HTS.computeSize());
      }
      i += f.a.a.b.b.a.bz(10, this.HTT);
      paramInt = i;
      if (this.HTU != null) {
        paramInt = i + f.a.a.a.lI(11, this.HTU.computeSize());
      }
      i = paramInt;
      if (this.HTV != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HTV);
      }
      AppMethodBeat.o(124564);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HTR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124564);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmq localdmq = (dmq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124564);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dml();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dml)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmq.HTQ = ((dml)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 2: 
          localdmq.lastUpdateTime = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124564);
          return 0;
        case 3: 
          localdmq.pos = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124564);
          return 0;
        case 4: 
          localdmq.weight = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124564);
          return 0;
        case 5: 
          localdmq.HDI = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124564);
          return 0;
        case 6: 
          localdmq.HTR.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(124564);
          return 0;
        case 7: 
          localdmq.style = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124564);
          return 0;
        case 8: 
          localdmq.dmp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124564);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmq.HTS = ((aiq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 10: 
          localdmq.HTT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124564);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmq.HTU = ((csm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        }
        localdmq.HTV = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124564);
        return 0;
      }
      AppMethodBeat.o(124564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmq
 * JD-Core Version:    0.7.0.1
 */