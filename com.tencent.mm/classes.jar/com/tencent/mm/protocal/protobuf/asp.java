package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asp
  extends com.tencent.mm.bx.a
{
  public djj Gex;
  public djq ZCO;
  public FinderFeedReportObject ZCP;
  public bso ZCQ;
  public awf ZCR;
  public djq ZCS;
  public djq ZCT;
  public dje ZCU;
  public int pSb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258588);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.pSb);
      if (this.Gex != null)
      {
        paramVarArgs.qD(2, this.Gex.computeSize());
        this.Gex.writeFields(paramVarArgs);
      }
      if (this.ZCO != null)
      {
        paramVarArgs.qD(3, this.ZCO.computeSize());
        this.ZCO.writeFields(paramVarArgs);
      }
      if (this.ZCP != null)
      {
        paramVarArgs.qD(4, this.ZCP.computeSize());
        this.ZCP.writeFields(paramVarArgs);
      }
      if (this.ZCQ != null)
      {
        paramVarArgs.qD(5, this.ZCQ.computeSize());
        this.ZCQ.writeFields(paramVarArgs);
      }
      if (this.ZCR != null)
      {
        paramVarArgs.qD(6, this.ZCR.computeSize());
        this.ZCR.writeFields(paramVarArgs);
      }
      if (this.ZCS != null)
      {
        paramVarArgs.qD(7, this.ZCS.computeSize());
        this.ZCS.writeFields(paramVarArgs);
      }
      if (this.ZCT != null)
      {
        paramVarArgs.qD(8, this.ZCT.computeSize());
        this.ZCT.writeFields(paramVarArgs);
      }
      if (this.ZCU != null)
      {
        paramVarArgs.qD(9, this.ZCU.computeSize());
        this.ZCU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258588);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.pSb) + 0;
      paramInt = i;
      if (this.Gex != null) {
        paramInt = i + i.a.a.a.qC(2, this.Gex.computeSize());
      }
      i = paramInt;
      if (this.ZCO != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZCO.computeSize());
      }
      paramInt = i;
      if (this.ZCP != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZCP.computeSize());
      }
      i = paramInt;
      if (this.ZCQ != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZCQ.computeSize());
      }
      paramInt = i;
      if (this.ZCR != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZCR.computeSize());
      }
      i = paramInt;
      if (this.ZCS != null) {
        i = paramInt + i.a.a.a.qC(7, this.ZCS.computeSize());
      }
      paramInt = i;
      if (this.ZCT != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZCT.computeSize());
      }
      i = paramInt;
      if (this.ZCU != null) {
        i = paramInt + i.a.a.a.qC(9, this.ZCU.computeSize());
      }
      AppMethodBeat.o(258588);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258588);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      asp localasp = (asp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258588);
        return -1;
      case 1: 
        localasp.pSb = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258588);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new djj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((djj)localObject2).parseFrom((byte[])localObject1);
          }
          localasp.Gex = ((djj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258588);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new djq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((djq)localObject2).parseFrom((byte[])localObject1);
          }
          localasp.ZCO = ((djq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258588);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderFeedReportObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderFeedReportObject)localObject2).parseFrom((byte[])localObject1);
          }
          localasp.ZCP = ((FinderFeedReportObject)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258588);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bso();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bso)localObject2).parseFrom((byte[])localObject1);
          }
          localasp.ZCQ = ((bso)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258588);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new awf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((awf)localObject2).parseFrom((byte[])localObject1);
          }
          localasp.ZCR = ((awf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258588);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new djq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((djq)localObject2).parseFrom((byte[])localObject1);
          }
          localasp.ZCS = ((djq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258588);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new djq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((djq)localObject2).parseFrom((byte[])localObject1);
          }
          localasp.ZCT = ((djq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258588);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dje();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dje)localObject2).parseFrom((byte[])localObject1);
        }
        localasp.ZCU = ((dje)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258588);
      return 0;
    }
    AppMethodBeat.o(258588);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asp
 * JD-Core Version:    0.7.0.1
 */